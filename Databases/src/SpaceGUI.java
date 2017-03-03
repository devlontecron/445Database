import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;
import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 * @author mmuppa & Devin Durham
 *
 */
public class SpaceGUI extends JFrame implements ActionListener, TableModelListener
{

	private static final long serialVersionUID = 1779520078061383929L;
	private JButton btnSpace, btnStaff, btnStaffSpace, btnSpaceBooking, btnCovered, btnUncovered, btnLots;
	private JPanel pnlButtons, pnlLots, pnlSpace, pnlCovered, pnlUncovered, pnlStaff, pnlStaffSpace, pnlSpaceBooking;
	private SpaceDB db;
	private List<Lot> list;
	private String[] columnNames = {"Lot Name","Location", "Floors","Capacity"};

	private Object[][] data;
	private JTable table;
	private JScrollPane scrollPane;

	private JLabel[] txfLabel = new JLabel[5];
	private JTextField[] txfField = new JTextField[5];
	private JButton btnAddMovie;


	/**
	 * Creates the frame and components and launches the GUI.
	 */
	public SpaceGUI() {
		super("Parking Lots");

		db = new SpaceDB();
		try
		{
			list = db.getLots();

			data = new Object[list.size()][columnNames.length];
			for (int i=0; i<list.size(); i++) {
				data[i][0] = list.get(i).getLotName();
				data[i][1] = list.get(i).getLocation();
				data[i][2] = list.get(i).getFloors();
				data[i][3] = list.get(i).getCapacity();

			}

		} catch (SQLException e)
		{
			e.printStackTrace();
		}
		createComponents();
		setVisible(true);
		setSize(700, 500);
	}

	/**
	 * Creates panels for list, search, add and adds the corresponding
	 * components to each panel.
	 */
	private void createComponents()
	{
pnlButtons = new JPanel();
		
		btnLots = new JButton("Lots");
		btnLots.addActionListener(this);

		btnSpace = new JButton("Space");
		btnSpace.addActionListener(this);
		
		btnCovered = new JButton("Covered");
		btnCovered.addActionListener(this);
		
		btnUncovered = new JButton("Uncovered");
		btnUncovered.addActionListener(this);

		btnStaff = new JButton("Staff");
		btnStaff.addActionListener(this);
		
		btnStaffSpace = new JButton("Staff Space");
		btnStaffSpace.addActionListener(this);
		
		btnSpaceBooking = new JButton("Space Booking");
		btnSpaceBooking.addActionListener(this);
		
		pnlButtons.add(btnLots);
		pnlButtons.add(btnSpace);
		pnlButtons.add(btnCovered);
		pnlButtons.add(btnUncovered);
		pnlButtons.add(btnStaff);
		pnlButtons.add(btnStaffSpace);
		pnlButtons.add(btnSpaceBooking);

		add(pnlButtons, BorderLayout.NORTH);


		//Lots Panel
		pnlLots = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlLots.add(scrollPane);
		table.getModel().addTableModelListener(this);
		
		//Space Panel
		pnlSpace = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlSpace.add(scrollPane);
		table.getModel().addTableModelListener(this);

		//Covered Panel
		pnlCovered = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlCovered.add(scrollPane);
		table.getModel().addTableModelListener(this);
		
		//Uncovered Panel
		pnlUncovered = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlUncovered.add(scrollPane);
		table.getModel().addTableModelListener(this);

		//Staff Panel
		pnlStaff = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlStaff.add(scrollPane);
		table.getModel().addTableModelListener(this);
		
		//StaffSpace Panel
		pnlStaffSpace = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlStaffSpace.add(scrollPane);
		table.getModel().addTableModelListener(this);

		//SpaceBooking Panel
		pnlSpaceBooking = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlSpaceBooking.add(scrollPane);
		table.getModel().addTableModelListener(this);
		
		
		
		
		
		
		/*


		//Space Panel
		pnlLots = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlLots.add(scrollPane);
		table.getModel().addTableModelListener(this);
		
		pnlSpace = new JPanel();


		//Stafff Panel
		pnlStaff = new JPanel();
		pnlStaff.setLayout(new GridLayout(6, 0));
		String labelNames[] = {"Enter Title: ", "Enter Year: ", "Enter Length: ", "Enter Genre: ", "Enter Studio Name: "};
		for (int i=0; i<labelNames.length; i++) {
			JPanel panel = new JPanel();
			txfLabel[i] = new JLabel(labelNames[i]);
			txfField[i] = new JTextField(25);
			panel.add(txfLabel[i]);
			panel.add(txfField[i]);
			pnlStaff.add(panel);
		}
		JPanel panel = new JPanel();
		btnAddMovie = new JButton("Add");
		btnAddMovie.addActionListener(this);
		panel.add(btnAddMovie);
		pnlStaff.add(panel);
*/
		add(pnlLots, BorderLayout.CENTER);


	}

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		SpaceGUI SpaceGUI = new SpaceGUI();
		SpaceGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	
	
	/**
	 * Event handling to change the panels when different tabs are clicked,
	 * add and search buttons are clicked on the corresponding add and search panels.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		List <Lot> listLots = null;
		String[] columnsLots = {"name","location", "floors","Capa"};
		if (e.getSource() == btnLots) {
			try {
				listLots = db.getLots();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			data = new Object[listLots.size()][columnsLots.length];
			for (int i=0; i<listLots.size(); i++) {
				data[i][0] = listLots.get(i).getLotName();
				data[i][1] = listLots.get(i).getLocation();
				data[i][2] = listLots.get(i).getFloors();
				data[i][3] = listLots.get(i).getCapacity();
			}
			
			pnlLots.removeAll();
			table = new JTable(data, columnsLots);
			table.getModel().addTableModelListener(this);
			scrollPane = new JScrollPane(table);
			pnlLots.add(scrollPane);
			pnlLots.revalidate();
			this.repaint();

		} else if (e.getSource() == btnSpace) {
			List <Space> listSpace = null;
			String[] columnsSpace = {"Space #", "Space Type"};
			try {
				listSpace = db.getSpaces();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			data = new Object[listSpace.size()][columnsSpace.length];
			for (int i=0; i<listSpace.size(); i++) {
				data[i][0] = listSpace.get(i).getSpaceNo();
				data[i][1] = listSpace.get(i).getSpaceType();
			}
			
			pnlLots.removeAll();
			table = new JTable(data, columnsSpace);
			table.getModel().addTableModelListener(this);
			scrollPane = new JScrollPane(table);
			pnlLots.add(scrollPane);
			pnlLots.revalidate();
			this.repaint();
			
		
		} else if (e.getSource() == btnCovered) {
			List <Covered> listCovered = null;
			String[] columnsCovered = {"Space #","Monthly Rate"};
			try {
				listCovered = db.getCovered();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			data = new Object[listCovered.size()][columnsCovered.length];
			for (int i=0; i<listCovered.size(); i++) {
				data[i][0] = listCovered.get(i).getSpaceNo();
				data[i][1] = listCovered.get(i).getMonthlyRate();
			}
			
			pnlLots.removeAll();
			table = new JTable(data, columnsCovered);
			table.getModel().addTableModelListener(this);
			scrollPane = new JScrollPane(table);
			pnlLots.add(scrollPane);
			pnlLots.revalidate();
			this.repaint();
			
			
		} else if (e.getSource() == btnStaff) {
			List <Staff> listStaff = null;
			String[] columnsStaff = {"Staff #","Phone Ext.", "License Plate"};
			try {
				listStaff = db.getStaff();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			data = new Object[listStaff.size()][columnsStaff.length];
			for (int i=0; i<listStaff.size(); i++) {
				data[i][0] = listStaff.get(i).getStaffNo();
				data[i][1] = listStaff.get(i).getPhoneExt();
				data[i][2] = listStaff.get(i).getLicPlateNo();
			}
			
			pnlLots.removeAll();
			table = new JTable(data, columnsStaff);
			table.getModel().addTableModelListener(this);
			scrollPane = new JScrollPane(table);
			pnlLots.add(scrollPane);
			pnlLots.revalidate();
			this.repaint();
			
		} else if (e.getSource() == btnUncovered) {
			List <Uncovered> listUncovered = null;
			String[] columnsUncovered = {"Space #"};
			try {
				listUncovered = db.getUncovered();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			data = new Object[listUncovered.size()][columnsUncovered.length];
			for (int i=0; i<listUncovered.size(); i++) {
				data[i][0] = listUncovered.get(i).getSpaceNo();
			}
			
			pnlLots.removeAll();
			table = new JTable(data, columnsUncovered);
			table.getModel().addTableModelListener(this);
			scrollPane = new JScrollPane(table);
			pnlLots.add(scrollPane);
			pnlLots.revalidate();
			this.repaint();
			
		} else if (e.getSource() == btnStaffSpace) {
			List <StaffSpace> listSS = null;
			String[] columnsSS = {"Staff #","Space #",};
			try {
				listSS = db.getStaffSpaces();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			data = new Object[listSS.size()][columnsSS.length];
			for (int i=0; i<listSS.size(); i++) {
				data[i][0] = listSS.get(i).getStaffNo();
				data[i][1] = listSS.get(i).getSpaceNo();
			}
			
			pnlLots.removeAll();
			table = new JTable(data, columnsSS);
			table.getModel().addTableModelListener(this);
			scrollPane = new JScrollPane(table);
			pnlLots.add(scrollPane);
			pnlLots.revalidate();
			this.repaint();
			
		} else if (e.getSource() == btnSpaceBooking) {
			List <SpaceBooking> listBooking = null;
			String[] columnsBooking = {"Booking ID","Space #","Staff #","Visitors Lic", "Date Visiting"};
			try {
				listBooking = db.getBookings();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			data = new Object[listBooking.size()][columnsBooking.length];
			for (int i=0; i<listBooking.size(); i++) {
				data[i][0] = listBooking.get(i).getBookingId();
				data[i][1] = listBooking.get(i).getSpaceNo();
				data[i][2] = listBooking.get(i).getStaffNo();
				data[i][3] = listBooking.get(i).getVisitorLic();
				data[i][4] = listBooking.get(i).getDateOfVisit();
			}
			
			pnlLots.removeAll();
			table = new JTable(data, columnsBooking);
			table.getModel().addTableModelListener(this);
			scrollPane = new JScrollPane(table);
			pnlLots.add(scrollPane);
			pnlLots.revalidate();
			this.repaint();
			
		} 
		 
		 
		
		
		
		
		/*else if (e.getSource() == btnTitleSearch) {
			String title = txfTitle.getText();
			if (title.length() > 0) {
				list = db.
						getMovies(title);
				data = new Object[list.size()][columnNames.length];
				for (int i=0; i<list.size(); i++) {
					data[i][0] = list.get(i).getTitle();
					data[i][1] = list.get(i).getYear();
					data[i][2] = list.get(i).getLength();
					data[i][3] = list.get(i).getGenre();
					data[i][4] = list.get(i).getStudioName();
				}
				pnlLots.removeAll();
				table = new JTable(data, columnNames);
				table.getModel().addTableModelListener(this);
				scrollPane = new JScrollPane(table);
				pnlLots.add(scrollPane);
				pnlLots.revalidate();
				this.repaint();
			}
		} else if (e.getSource() == btnAddMovie) {
			Movie movie = new Movie(txfField[0].getText(), Integer.parseInt(txfField[1].getText())
					,Integer.parseInt(txfField[2].getText()), txfField[3].getText(), txfField[4].getText() );
			db.addMovie(movie);
			JOptionPane.showMessageDialog(null, "Added Successfully!");
			for (int i=0; i<txfField.length; i++) {
				txfField[i].setText("");
			}
		}
*/
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}

	/**
	 * Event handling for any cell being changed in the table.
	 	@Override
	public void tableChanged(TableModelEvent e) {
		int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel)e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
        db.updateMovie(row, columnName, data);
	}
*/
}