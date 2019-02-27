package cc.oobootcamp.parkinglot;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertSame;

import java.util.ArrayList;
import java.util.List;

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
	
	@Test(expected = ParkingFailedException.class)
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
	
	@Test(expected = TakeCarFailedException.class)
	public void should_return_extract_car_failed_exception_when_extract_car_given_not_parked_car_ticket() {
		int restspaceNum = 1;
		ParkingLot parkinglot = new ParkingLot(restspaceNum);
		Car extractcar = parkinglot.extractCar(new Ticket());
	}
	
	@Test(expected = TakeCarFailedException.class)
	public void should_return_extract_car_failed_exception_when_extract_car_given_used_ticket() {
		int restspaceNum = 1;
		ParkingLot parkinglot = new ParkingLot(restspaceNum);
		Car car = new Car();
		Ticket ticket = parkinglot.parking(car);
		Car firstExtractcar = parkinglot.extractCar(ticket);
		Car secondExtractcar = parkinglot.extractCar(ticket);
	}
	
	@Test
	public void graduate_parkingboy_should_park_the_car_in_sequence_of_parkinglot_and_can_take_the_parked_car() {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		int restSpaceOfParkingLotA = 2;
		int restSpaceOfParkingLotB = 5;
		int restSpaceOfParkingLotC = 8;
		ParkingLot parkingLotA = new ParkingLot(restSpaceOfParkingLotA);
		ParkingLot parkingLotB = new ParkingLot(restSpaceOfParkingLotB);
		ParkingLot parkingLotC = new ParkingLot(restSpaceOfParkingLotC);
		parkingLots.add(parkingLotA);
		parkingLots.add(parkingLotB);
		parkingLots.add(parkingLotC);
		Car car = new Car();
		GraduateParkingBoy graduateParkingBoy = new GraduateParkingBoy(parkingLots);
		
		Ticket ticket = graduateParkingBoy.parking(car);
		Car extractcar = graduateParkingBoy.takeCar(ticket);
		assertEquals(car, extractcar);
		assertSame(car, extractcar);
	}
	
	@Test
	public void smart_parkingboy_should_park_the_car_in_sequence_of_parkinglot_and_can_take_the_parked_car() {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		int restSpaceOfParkingLotA = 2;
		int restSpaceOfParkingLotB = 5;
		int restSpaceOfParkingLotC = 8;
		ParkingLot parkingLotA = new ParkingLot(restSpaceOfParkingLotA);
		ParkingLot parkingLotB = new ParkingLot(restSpaceOfParkingLotB);
		ParkingLot parkingLotC = new ParkingLot(restSpaceOfParkingLotC);
		parkingLots.add(parkingLotA);
		parkingLots.add(parkingLotB);
		parkingLots.add(parkingLotC);
		Car car = new Car();
		SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLots);
		
		Ticket ticket = smartParkingBoy.parking(car);
		Car extractcar = smartParkingBoy.takeCar(ticket);
		assertEquals(car, extractcar);
		assertSame(car, extractcar);
	}
	
	
	/*@Test
	public void super_parkingboy_should_park_the_car_in_sequence_of_parkinglot_and_can_take_the_parked_car() {
		List<ParkingLot> parkingLots = new ArrayList<ParkingLot>();
		int restSpaceOfParkingLotA = 2;
		int restSpaceOfParkingLotB = 5;
		int restSpaceOfParkingLotC = 8;
		int allSpace = 10;
		ParkingLot parkingLotA = new ParkingLot(allSpace, restSpaceOfParkingLotA);
		ParkingLot parkingLotB = new ParkingLot(allSpace, restSpaceOfParkingLotB);
		ParkingLot parkingLotC = new ParkingLot(allSpace, restSpaceOfParkingLotC);
		parkingLots.add(parkingLotA);
		parkingLots.add(parkingLotB);
		parkingLots.add(parkingLotC);
		Car car = new Car();
		SuperParkingBoy superParkingBoy = new SuperParkingBoy();
		
		Ticket ticket = smartParkingBoy.parking(car);
		Car extractcar = smartParkingBoy.takeCar(ticket);
		assertEquals(car, extractcar);
		assertSame(car, extractcar);
	}*/
}
