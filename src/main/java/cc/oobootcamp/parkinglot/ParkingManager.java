package cc.oobootcamp.parkinglot;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingManager extends GraduateParkingBoy{

	private List<ParkingBoy> parkingBoys;
	private List<ParkingLot> pakingLots;
	private Map<Ticket,ParkingBoy> parkedCars = new HashMap<Ticket, ParkingBoy>();
	private List<ParkingLot> parkingLots;

	public ParkingManager(List<ParkingLot> parkingLots, List<ParkingBoy> parkingBoys) {
		super(parkingLots);
		this.parkingBoys = parkingBoys;
	}

	public Ticket parkingBoyPark(Car car) {
		Ticket ticket = new Ticket();
		if(parkingBoys !=null && !parkingBoys.isEmpty()) {
			ticket = parkingBoys.get(0).parking(car);
			parkedCars.put(ticket, parkingBoys.get(0));
		} else {
			ticket = null;
		}
		return ticket;
	}
	
	public Car parkingBoyTakeCar(Ticket ticket) {
		return takeCar(ticket);
	}
	
	public Car takeCar(Ticket ticket) {
		Car car = new Car();
		car = null;
		if(parkedCars.containsKey(ticket)) {
			return parkedCars.get(ticket).takeCar(ticket);
		}else {
			return car;
		}
	}

}
