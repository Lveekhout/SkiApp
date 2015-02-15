package nl.lveekhout.data;

import java.util.Date;

public class ListCoords {

	public double latitude;
	public double longitude;
	public Date date;

	public ListCoords(double d, double e, Date date) {
		this.latitude = d;
		this.longitude = e;
		this.date = date;
	}

}
