package nl.lveekhout.data;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by eekhout.l on 05-02-2015.
 * class MaxSpeedData
 */

public class GlobalAppData {
	public static String latitude;
	public static String longitude;
	public static String altitude;
	public static Float bearing;
	public static String speed;
    public static float maxSpeed;
    public static Date maxSpeedDate;
    public static String maxSpeedCoord;
    public static List<ListCoords> listCoordsList = new ArrayList<ListCoords>();
    
    static {
    	reset();
    }

    public static void reset() {
    	latitude = "----";
    	longitude = "----";
    	altitude = "----";
    	bearing = null;
    	speed = "----";
        maxSpeed = 0.0f;
        maxSpeedDate = null;
    	maxSpeedCoord = "----";
    	listCoordsList.clear();
    }
}
