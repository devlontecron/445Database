import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.sql.Date;

/**
 * A class that consists of the database operations to insert and update the Space information.
 * @author mmuppa
 *
 */

public class SpaceDB {
	private static String userName = "mmuppa"; //Change to yours
	private static String password = "mysqlpassword";
	private static String serverName = "cssgate.insttech.washington.edu";
	private static Connection conn;
	private List<Lot> list;
	private List<Staff> staffList;
	private List<Space> spaceList;
	private List<Covered> coveredList;
	private List<Uncovered> uncoveredList;
	private List<SpaceBooking> bookingList;
	private List<StaffSpace> staffSpaceList;

	/**
	 * Creates a sql connection to MySQL using the properties for
	 * userid, password and server information.
	 * @throws SQLException
	 */
	public static void createConnection() throws SQLException {
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("password", password);

		conn = DriverManager.getConnection("jdbc:" + "mysql" + "://"
				+ serverName + "/", connectionProps);

		System.out.println("Connected to database");
	}

	/**
	 * Returns a list of lot objects from the database.
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<Lot> getLots() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select LotName, Location, Capacity, Floors "
				+ "from youruwnetid.Lots ";

		list = new ArrayList<Lot>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				String LotName = rs.getString("LotName");
				String Location = rs.getString("Location");
				int length = rs.getInt("Capacity");
				int genre = rs.getInt("Floors");;
				Lot lot = new Lot(LotName, Location, length, genre);
				list.add(lot);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return list;
	}

	/**
	 * Adds a new lot to the table.
	 * @param lot 
	 */
	public void addLot(Lot lot) {
		String sql = "insert into youruwnetid.Movies values " + "(?, ?, ?, ?, null); ";

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, lot.getLotName());
			preparedStatement.setString(2, lot.getLocation());
			preparedStatement.setInt(3, lot.getCapacity());
			preparedStatement.setInt(4, lot.getFloors());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
	}

	/**
	 * Modifies the staff information corresponding to the index in the list.
	 * @param row index of the element in the list
	 * @param columnName attribute to modify
	 * @param data value to supply
	 */
	public void updateStaff(int row, String columnName, Object data) {
		
		Staff staff = staffList.get(row);
		int id = staff.getStaffNo();
		String sql = "update youruwnetid.Lot set " + columnName + " = ?  StaffNo = ?";
		System.out.println(sql);
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			if (data instanceof String)
				preparedStatement.setString(1, (String) data);
			else if (data instanceof Integer)
				preparedStatement.setInt(1, (Integer) data);
			preparedStatement.setInt(2, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
		
	}

	/**
	 * Returns a list of staff objects from the database.
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<Staff> getStaff() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select StaffNo, PhoneExt, LicPlateNo "
				+ "from youruwnetid.Lots ";

		staffList = new ArrayList<Staff>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int staffNo = rs.getInt("StaffNo");
				int phone = rs.getInt("PhoneExt");
				String licPlateNo = rs.getString("LicPlateNo");
				Staff staff = new Staff(licPlateNo, phone, staffNo);
				staffList.add(staff);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return staffList;
	}

	/**
	 * Adds a new staff to the table.
	 * @param staff 
	 */
	public void addStaff(Staff staff) {
		String sql = "insert into youruwnetid.Movies values " + "(?, ?, ?, null); ";

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(1, staff.getLicPlateNo());
			preparedStatement.setInt(2, staff.getPhoneExt());
			preparedStatement.setInt(3, staff.getStaffNo());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
	}

	/**
	 * Returns a list of covered objects from the database.
	 * @return list of covered
	 * @throws SQLException
	 */
	public List<Covered> getCovered() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select SpaceNo, MonthlyRate "
				+ "from youruwnetid.Lots ";

		coveredList = new ArrayList<Covered>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int number = rs.getInt("SpaceNo");
				double monthlyRate = rs.getDouble("MonthlyRate");
				Covered covered = new Covered(number, monthlyRate);
				coveredList.add(covered);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return coveredList;
	}

	/**
	 * Adds a new covered to the table.
	 * @param covered 
	 */
	public void addCovered(Covered covered) {
		String sql = "insert into youruwnetid.Movies values " + "(?, ?, null); ";

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, covered.getSpaceNo());
			preparedStatement.setDouble(2, covered.getMonthlyRate());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
	}

	/**
	 * Returns a list of uncovered objects from the database.
	 * @return list of uncovered
	 * @throws SQLException
	 */
	public List<Uncovered> getUncovered() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select SpaceNo "
				+ "from youruwnetid.Lots ";

		uncoveredList = new ArrayList<Uncovered>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int number = rs.getInt("SpaceNo");
				Uncovered uncovered = new Uncovered(number);
				uncoveredList.add(uncovered);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return uncoveredList;
	}

	/**
	 * Adds a new uncovered to the table.
	 * @param uncovered 
	 */
	public void addUncovered(Uncovered uncovered) {
		String sql = "insert into youruwnetid.Movies values " + "(?, null); ";

		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, uncovered.getSpaceNo());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
	}

	/**
	 * Returns a list of spacebooking objects from the database.
	 * @return list of SpaceBookings
	 * @throws SQLException
	 */
	public List<SpaceBooking> getBookings() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select BookingId, SpaceNo, StaffNo, VisitorLic, DateOfVisit "
				+ "from youruwnetid.Lots ";

		bookingList = new ArrayList<SpaceBooking>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int number = rs.getInt("SpaceNo");
				int staffNo = rs.getInt("StaffNo");
				int id = rs.getInt("BookingId");
				String visLic = rs.getString("VisistorLic");
				Date date = rs.getDate("DateOfVisit");
				SpaceBooking booking = new SpaceBooking(visLic, id, number, staffNo, date);
				bookingList.add(booking);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return bookingList;
	}

	/**
	 * Adds a new spacebooking to the table.
	 * @param booking 
	 */
	public void addBooking(SpaceBooking booking) {
		String sql = "insert into youruwnetid.Movies values " + "(?, ?, ?, ?, ?, null); ";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setString(4, booking.getVisitorLic());
			preparedStatement.setInt(1, booking.getBookingId());
			preparedStatement.setInt(2, booking.getSpaceNo());
			preparedStatement.setInt(3, booking.getStaffNo());
			preparedStatement.setDate(5, booking.getDateOfVisit());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
	}

	/**
	 * Returns a list of staffSpace objects from the database.
	 * @return list of staffSpace
	 * @throws SQLException
	 */
	public List<StaffSpace> getStaffSpaces() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select StaffNo, SpaceNo "
				+ "from youruwnetid.Lots ";

		staffSpaceList = new ArrayList<StaffSpace>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int number = rs.getInt("SpaceNo");
				int staffNo = rs.getInt("StaffNo");
				StaffSpace staffSpace = new StaffSpace(staffNo, number);
				staffSpaceList.add(staffSpace);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return staffSpaceList;
	}

	/**
	 * Adds a new booking to the table.
	 * @param booking 
	 */
	public void addStaffSpace(StaffSpace booking) {
		String sql = "insert into youruwnetid.Movies values " + "(?, ?, null); ";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, booking.getStaffNo());
			preparedStatement.setInt(2, booking.getSpaceNo());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
	}

	/**
	 * Returns a list of Id's of objects which are already booked from the database.
	 * @return list of Integers
	 * @throws SQLException
	 */
	public Set<Integer> getUnavailable(){
		
		Set<Integer> toReturn = new HashSet<Integer>();
		for(Space s: this.getBookings()){
			toReturn.add(s.getSpaceNo());
		}
		for(Space s: this.getStaffSpaces()){
			toReturn.add(s.getSpaceNo());
		}
		return toReturn;
	}
	
	/**
	 * Adds a new space to the table.
	 * @param movie 
	 */
	public void addSpace(Space space) {
		String sql = "insert into youruwnetid.Movies values " + "(?, ?, null); ";
		PreparedStatement preparedStatement = null;
		try {
			preparedStatement = conn.prepareStatement(sql);
			preparedStatement.setInt(1, space.getSpaceNo());
			preparedStatement.setInt(2, space.getSpaceType());
			
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			e.printStackTrace();
		} 
	}

	/**
	 * Returns a list of space objects from the database.
	 * @return list of spaces
	 * @throws SQLException
	 */
	public List<Space> getSpaces() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select SpaceNo, SpaceType "
				+ "from youruwnetid.Lots ";

		staffSpaceList = new ArrayList<StaffSpace>();
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				int number = rs.getInt("SpaceNo");
				String type = rs.getString("SpaceType");
				Space spacepace = new Space(type, number);
				spaceList.add(space);
			}
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			if (stmt != null) {
				stmt.close();
			}
		}
		return spaceList;
	}
	
	/**
	 * Returns a list of available space objects from the database.
	 * @return list of spaces
	 * @throws SQLException
	 */
	public List<Spaces> getAvailable(){
		List<Spaces> toReturn = this.getSpaces();
		List<Spaces> temp = toReturn.copy();
		Set<Integer> noWant = this.getUnavailable();
		for(Space s: temp){
			if(noWant.contains(s.getSpaceNo())){
				toReturn.remove(s);
			}
		}
		return toReturn;
	}
}