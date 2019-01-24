package cc.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
	private int restSpace;
	private Map<Ticket,Car> parkedCars = new HashMap();
	public ParkingLot(int restSpace) {
		this.restSpace = restSpace; 
	}

	public Ticket parking(Car car) {
		if (this.restSpace < 1) {
			throw new ParkingLotFullException();
		}
		Ticket ticket = new Ticket();
		parkedCars.put(ticket, car);
		return ticket;
	}

	public Car extractCar(Ticket ticket) {
		if(!parkedCars.containsKey(ticket)) {
			throw new ExtractCarFailedException();
		}
		return parkedCars.remove(ticket);
	}
}
