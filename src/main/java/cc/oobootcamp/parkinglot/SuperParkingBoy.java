package cc.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SuperParkingBoy {

	private List<ParkingLot> parkingLots;
	private Map<Ticket, ParkingLot> boyParkedCars = new HashMap<Ticket, ParkingLot>();

	public SuperParkingBoy(List<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

	public Ticket parking(Car car) {
		if (parkingLots != null && !parkingLots.isEmpty()) {
			return parkingCarInV(parkingLots, car);
		} else {
			throw new ParkingFailedException();
		}
	}

	private Ticket parkingCarInV(List<ParkingLot> parkingLots, Car car) {
		Ticket ticket = new Ticket();
		ParkingLot parkingLot = new ParkingLot();
		double highVacancy = parkingLots.get(0).getVacancy();
		parkingLot = parkingLots.get(0);
		for (int i = 1; i < parkingLots.size(); i++) {
			if(highVacancy < parkingLots.get(i).getVacancy()) {
				highVacancy = parkingLots.get(i).getVacancy();
				parkingLot = parkingLots.get(i);
			} else {
				continue;
			}
		}
		ticket = parkingLot.parking(car);
		boyParkedCars.put(ticket, parkingLot);
		return ticket;
	}

	public Car takeCar(Ticket ticket) {
		Car car = new Car();
		car = null;
		if(boyParkedCars.containsKey(ticket)) {
			return boyParkedCars.get(ticket).extractCar(ticket);
		}else {
			return car;
		}
	}
	
	
}
