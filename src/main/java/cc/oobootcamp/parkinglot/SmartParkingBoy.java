package cc.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SmartParkingBoy {
	private Map<Ticket,ParkingLot> parkedCars = new HashMap<Ticket, ParkingLot>();
	private List<ParkingLot> parkingLots;
	
	public SmartParkingBoy(List<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}
	
	public Ticket parking(Car car) {
		if (parkingLots != null && !parkingLots.isEmpty()) {
			return parkingCarInMostSpace(parkingLots, car);
		} else {
			throw new ParkingFailedException();
		}
	}
	
	private Ticket parkingCarInMostSpace(List<ParkingLot> parkingLots, Car car) {
		Ticket ticket = new Ticket();
		ParkingLot parkingLot = new ParkingLot();
		int mostSpace = parkingLots.get(0).getRestSpace();;
		for (int i = 1; i < parkingLots.size(); i++) {
			if(mostSpace < parkingLots.get(i).getRestSpace()) {
				mostSpace = parkingLots.get(i).getRestSpace();
				parkingLot = parkingLots.get(i);
			} else {
				continue;
			}
		}
		ticket = parkingLot.parking(car);
		parkedCars.put(ticket, parkingLot);
		return ticket;
	}
	
	public Car takeCar(Ticket ticket) {
		Car car = new Car();
		car = null;
		if(parkedCars.containsKey(ticket)) {
			return parkedCars.get(ticket).extractCar(ticket);
		}else {
			return car;
		}
	}
}
