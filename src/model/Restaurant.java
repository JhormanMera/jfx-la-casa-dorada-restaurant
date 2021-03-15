package model;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
	
	private static List<Custome> customes;
	public Restaurant() {
		setCustomes(new ArrayList<>());
	}
	public static List<Custome> getCustomes() {
		return customes;
	}
	public static void setCustomes(List<Custome> customes) {
		Restaurant.customes = customes;
	}

}
