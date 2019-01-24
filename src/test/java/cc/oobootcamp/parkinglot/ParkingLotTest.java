package cc.oobootcamp.parkinglot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import org.junit.Test;

public class ParkingLotTest {
	@Test
	public void should_return_ticket_when_one_car_park_given_parkinglot_have_restspace() {
		int spaceNum = 1;
		ParkingLot parkinglot = new ParkingLot(spaceNum);
		Car car = new Car();
		Ticket ticket = parkinglot.parking(car);
		assertNotNull(ticket);
		
	}
	
	@Test(expected = ParkingLotFullException.class)
	public void should_return_park_null_when_one_car_park_given_parkinglot_full() {
		int restspaceNum = 0;
		ParkingLot parkinglot = new ParkingLot(restspaceNum);
		Car car = new Car();
		
		Ticket ticket = parkinglot.parking(car);
		
	}
	
	@Test
	public void should_return_car_when_extract_one_car_given_one_parked_car_ticket() {
		int restspaceNum = 1;
		ParkingLot parkinglot = new ParkingLot(restspaceNum);
		Car car = new Car();
		Ticket ticket = parkinglot.parking(car);
		Car extractcar = parkinglot.extractCar(ticket);
		assertEquals(car, extractcar);
		assertSame(car, extractcar);
	}
	
	@Test(expected = ExtractCarFailedException.class)
	public void should_return_extract_car_failed_exception_when_extract_car_given_not_parked_car_ticket() {
		int restspaceNum = 1;
		ParkingLot parkinglot = new ParkingLot(restspaceNum);
		Car extractcar = parkinglot.extractCar(new Ticket());
 		
	}
	
	@Test(expected = ExtractCarFailedException.class)
	public void should_return_extract_car_failed_exception_when_extract_car_given_used_ticket() {
		int restspaceNum = 1;
		ParkingLot parkinglot = new ParkingLot(restspaceNum);
		Car car = new Car();
		Ticket ticket = parkinglot.parking(car);
		Car firstExtractcar = parkinglot.extractCar(ticket);
		Car secondExtractcar = parkinglot.extractCar(ticket);
	}
}
