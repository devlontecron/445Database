import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.sql.Date;

/**
 * A class that consists of the database operations to insert and update the Movie information.
 * @author mmuppa &durham
 *
 */

public class SpaceDB {
	private static String userName = "d1durham"; //Change to yours
	private static String password = "VudPyirf";
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
	 * Returns a list of movie objects from the database.
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<Lot> getLots() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select LotName, Location, Capacity, Floors "
				+ "from d1durham.Lots ";

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
	 * Adds a new movie to the table.
	 * @param movie 
	 * @param movie
	 */
	public void addLot(Lot lot) {
		String sql = "insert into d1durham.Movies values " + "(?, ?, ?, ?, null); ";

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
	 * Modifies the movie information corresponding to the index in the list.
	 * @param row index of the element in the list
	 * @param columnName attribute to modify
	 * @param data value to supply
	 */
	public void updateStaff(int row, String columnName, Object data) {
		
		Staff staff = staffList.get(row);
		int id = staff.getStaffNo();
		String sql = "update d1durham.Lot set " + columnName + " = ?  StaffNo = ?";
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
	 * Returns a list of movie objects from the database.
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<Staff> getStaff() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select StaffNo, PhoneExt, LicPlateNo "
				+ "from d1durham.Lots ";

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
	 * Adds a new movie to the table.
	 * @param movie 
	 */
	public void addStaff(Staff staff) {
		String sql = "insert into d1durham.Movies values " + "(?, ?, ?, null); ";

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
	 * Returns a list of movie objects from the database.
	 * @return list of movies
	 * @throws SQLException
	 */
	public List<Covered> getCovered() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select SpaceNo, MonthlyRate "
				+ "from d1durham.Lots ";

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
	 * Adds a new movie to the table.
	 * @param movie 
	 */
	public void addCovered(Covered covered) {
		String sql = "insert into d1durham.Movies values " + "(?, ?, null); ";

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
	
	public List<Uncovered> getUncovered() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select SpaceNo "
				+ "from d1durham.Lots ";

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
	 * Adds a new movie to the table.
	 * @param movie 
	 */
	public void addUncovered(Uncovered uncovered) {
		String sql = "insert into d1durham.Movies values " + "(?, null); ";

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
	
	public List<SpaceBooking> getBookings() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select BookingId, SpaceNo, StaffNo, VisitorLic, DateOfVisit "
				+ "from d1durham.Lots ";

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
	 * Adds a new movie to the table.
	 * @param movie 
	 */
	public void addBooking(SpaceBooking booking) {
		String sql = "insert into d1durham.Movies values " + "(?, ?, ?, ?, ?, null); ";
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
	
	public List<StaffSpace> getStaffSpaces() throws SQLException {
		if (conn == null) {
			createConnection();
		}
		Statement stmt = null;
		String query = "select StaffNo, SpaceNo "
				+ "from d1durham.Lots ";

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
	 * Adds a new movie to the table.
	 * @param movie 
	 */
	public void addStaffSpace(SpaceBooking booking) {
		String sql = "insert into d1durham.Movies values " + "(?, ?, null); ";
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
	
	
	/*
	 * Below go the utility things
	 */
	
	public Set<Integer> getUnavailable() throws SQLException{
		
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
	 * Adds a new movie to the table.
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
}