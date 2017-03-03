/**
 * A class that represents a space booking
 * @author Josiah Hopkins, Devin Durham
 */

import java.sql.Date;

public class SpaceBooking {
	private String VisitorLic;
	private int BookingId;
	private int SpaceNo;
	private int StaffNo;
	private Date DateOfVisit;
	
	
	/**
	 * Initialize the space booking parameters.
	 * @param VisitorLic
	 * @param BookingId
	 * @param SpaceNo
	 * @param StaffNo
	 * @param DateofVisit
	 * @throws IllegalArgumentException if VisitorLic or DateOfVisi are null or empty,
	 * SpaceNo, staffNo, bookingId < 1.
	 */
	public SpaceBooking(String VisitorLic, int BookingId, int SpaceNo, int StaffNo,
			Date DateOfVisit) {
		setVisitorLic(VisitorLic);
		setBookingId(BookingId);
		setSpaceNo(SpaceNo);
		setStaffNo(StaffNo);
		setDateOfVisit(DateOfVisit);
	}

	/**
	 * Returns the VisitorLic.
	 * @return movie VisitorLic
	 */
	public String getVisitorLic()
	{
		return VisitorLic;
	}
	
	/**
	 * Modifies the VisitorLic.
	 * @param VisitorLic
	 * @throws IllegalArgumentException if VisitorLic is null or empty.
	 */
	private void setVisitorLic(String VisitorLic)
	{
		if (VisitorLic == null || VisitorLic.length() == 0 )
			throw new IllegalArgumentException("Please supply a valid VisitorLic.");
		this.VisitorLic = VisitorLic;
	}
	
	/**
	 * Returns the BookingId.
	 * @return BookingId
	 */
	public int getBookingId()
	{
		return BookingId;
	}
	
	/**
	 * Sets the movie BookingId.
	 * @param BookingId
	 * @throws IllegalArgumentException if BookingId < 1. 
	 */
	private void setBookingId(int BookingId)
	{
		if (BookingId < 1)
			throw new IllegalArgumentException("Booking id cannot be less than 1");
		this.BookingId = BookingId;
	}
	
	/**
	 * Returns the SpaceNo of the movie.
	 * @return SpaceNo
	 */
	public int getSpaceNo()
	{
		return SpaceNo;
	}
	
	/**
	 * Modifies the SpaceNo
	 * @param SpaceNo
	 * @throws IllegalArgumentException if SpaceNo is negative or 0.
	 */
	private void setSpaceNo(int SpaceNo)
	{
		if (SpaceNo <= 0){
			throw new IllegalArgumentException("SpaceNo cannot be negative or 0.");
		}
		this.SpaceNo = SpaceNo;
	}
	
	/**
	 * Returns the staff number.
	 * @return staff number
	 */
	public int getStaffNo()
	{
		return StaffNo;
	}
	
	/**
	 * Sets the genre of the movie.
	 * @param staffNo
	 * @throws IllegalArgumentException if StaffNo < 1.
	 */
	private void setStaffNo(int StaffNo)
	{
		if (StaffNo < 1){
			throw new IllegalArgumentException("StaffNo cannot be negative or 0.");
		}
		this.StaffNo = StaffNo;
	}
	
	/**
	 * Returns the name of the studio.
	 * @return studioName
	 */
	public Date getDateOfVisit()
	{
		return DateOfVisit;
	}
	
	/**
	 * Sets the name of the studio. 
	 * @param DateOfVisit
	 * @throws IllegalArgumentException if date of visit is null.
	 */
	private void setDateOfVisit(Date DateOfVisit)
	{
		if (DateOfVisit == null){
			throw new IllegalArgumentException("Please supply a valid date.");
		}
		this.DateOfVisit = DateOfVisit;
	}
}
