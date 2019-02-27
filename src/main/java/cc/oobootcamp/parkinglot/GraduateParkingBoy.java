package cc.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraduateParkingBoy {
	List<ParkingLot> parkingLots;
	private Map<Ticket,ParkingLot> parkedCars = new HashMap<Ticket, ParkingLot>();
	
	public GraduateParkingBoy(List<ParkingLot> parkingLots) {
		this.parkingLots = parkingLots;
	}

	public Ticket parking(Car car) {
		if (parkingLots != null && !parkingLots.isEmpty()) {
			return parkingCarInSequence(parkingLots, car);
		}
		else {
			throw new ParkingFailedException();
		}
	}
	
	private Ticket parkingCarInSequence(List<ParkingLot> parkingLots, Car car) {
		Ticket ticket = new Ticket();
		for(int i = 0; i< parkingLots.size(); i++) {
			ticket = null;
			if(parkingLots.get(i).hasSpace()) {
				ticket = parkingLots.get(i).parking(car);
				parkedCars.put(ticket, parkingLots.get(i));
				return ticket;
			} else {
				continue;
			}
		}
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
