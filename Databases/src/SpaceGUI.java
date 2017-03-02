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
	private JPanel pnlButtons, pnlLots;
	private SpaceDB db;
<<<<<<< HEAD
	private List<Lot> list;
	private String[] columnNames = {"Lot Name",
            "Location",
            "Floors",
            "Capacity"};

=======
	private List<Movie> list;
	private String[] columnNames = {"Title",
            "Year",
            "Length",
            "Genre",
            "StudioName"};
	private String
>>>>>>> origin/master
	private Object[][] data;
	private JTable table;
	private JScrollPane scrollPane;
	private JPanel pnlSpace;
	//private JLabel lblTitle;;



	private JPanel pnlStaff;
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
		setSize(500, 500);
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

		btnStaffSpace = new JButton("Staff Space");
		btnStaffSpace.addActionListener(this);
		
		btnSpace = new JButton("Space");
		btnSpace.addActionListener(this);
		
		btnSpaceBooking = new JButton("Space Booking");
		btnSpaceBooking.addActionListener(this);
		
		btnCovered = new JButton("Covered");
		btnCovered.addActionListener(this);
		
		btnUncovered = new JButton("Uncovered");
		btnUncovered.addActionListener(this);

		
		pnlButtons.add(btnLots);
		pnlButtons.add(btnSpace);
		pnlButtons.add(btnStaffSpace);
		pnlButtons.add(btnSpaceBooking);
		pnlButtons.add(btnCovered);
		pnlButtons.add(btnUncovered);
		
		add(pnlButtons, BorderLayout.NORTH);

		//Lots Panel
		pnlLots = new JPanel();
		table = new JTable(data, columnNames);
		scrollPane = new JScrollPane(table);
		pnlLots.add(scrollPane);
		table.getModel().addTableModelListener(this);

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
		if (e.getSource() == btnLots) {
			try {
				list = db.getLots();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			data = new Object[list.size()][columnNames.length];
			for (int i=0; i<list.size(); i++) {
				data[i][0] = list.get(i).getLotName();
				data[i][1] = list.get(i).getLocation();
				data[i][2] = list.get(i).getFloors();
				data[i][3] = list.get(i).getCapacity();
			}
			
			pnlLots.removeAll();
			table = new JTable(data, columnNames);
			table.getModel().addTableModelListener(this);
			scrollPane = new JScrollPane(table);
			pnlLots.add(scrollPane);
			pnlLots.revalidate();
			this.repaint();

		} else if (e.getSource() == btnSpace) {
			pnlLots.removeAll();
			pnlLots.add(pnlSpace);
			pnlLots.revalidate();
			this.repaint();
		} else if (e.getSource() == btnStaff) {
			pnlLots.removeAll();
			pnlLots.add(pnlStaff);
			pnlLots.revalidate();
			this.repaint();
			
			
		} /*else if (e.getSource() == btnTitleSearch) {
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
