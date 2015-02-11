package com.example.data;

import java.util.Date;
import java.util.List;
import java.util.ArrayList;

/**
 * Created by eekhout.l on 05-02-2015.
 * class MaxSpeedData
 */

public class GlobalAppData {
	public static String latitude = "----";
	public static String longitude = "----";
	public static String speed = "----";
    public static float maxSpeed = 0.0f;
    public static Date maxSpeedDate = null;
    public static String maxSpeedCoord = "----";
    public static List<ListCoords> listCoordsList = new ArrayList<ListCoords>();
}
