package pl.akdg.carrental.services;

import java.util.List;

import pl.akdg.carrental.dto.MyRentals;

public interface MyRentalServices {
	String getMyRentals();
	List<MyRentals> listRentals();
}
