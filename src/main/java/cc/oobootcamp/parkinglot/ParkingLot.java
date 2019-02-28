package cc.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
	private int restSpace;
	private Map<Ticket,Car> parkedCars = new HashMap();
	private int allSpace;
	
	public ParkingLot() {
		
	}
	
	public ParkingLot(int restSpace) {
		this.restSpace = restSpace; 
	}
	
	public int getRestSpace() {
		return restSpace;
	}
	
	public ParkingLot(int allSpace,int restSpace) {
		this.restSpace = restSpace;
		this.allSpace = allSpace;
	}

	public Ticket parking(Car car) {
		if (this.restSpace < 1) {
			throw new ParkingFailedException();
		}
		Ticket ticket = new Ticket();
		restSpace = restSpace - 1;
		parkedCars.put(ticket, car);
		return ticket;
	}

	public Car extractCar(Ticket ticket) {
		if(!parkedCars.containsKey(ticket)) {
			throw new TakeCarFailedException();
		}
		restSpace = restSpace + 1;
		return parkedCars.remove(ticket);
	}
	
	public boolean hasSpace() {
		if (this.restSpace < 1) {
			return false;
		}else {
			return true;
		}
	}
}
