package parkinglot_tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import com.fdm.parkinglot.ParkingLot;
import com.fdm.parkinglot.*;

public class ParkingLotTests {

	@Test
	public void when_call_enter_vehicles_car_truck_truck_reduce_space_by_5_expect_5_spaces_to_remain() {
		ParkingLot parkingLot = new ParkingLot(10);
		parkingLot.vehicleIn("car");
		parkingLot.vehicleIn("truck");
		parkingLot.vehicleIn("truck");
		assertEquals(5, parkingLot.currentSpace());

	}

	@Test
	public void when_initialising_a_parked_car_expect_variable_parked_cars_to_be_equal_to_1() {
		ParkingLot parkingLot = new ParkingLot(10);
		parkingLot.vehicleIn("car");
		assertEquals(1, parkingLot.enteredCars);

	}

	@Test
	public void when_initialising_a_parked_truck_expect_variable_parkedTrucks_to_be_equal_to_1() {
		ParkingLot parkingLot = new ParkingLot(10);
		parkingLot.vehicleIn("truck");
		assertEquals(1, parkingLot.enteredTrucks);

	}

	@Test
	public void when_initialising_two_trucks_and_cars_expect_variables_parkedTrucks_and_parkedCars_to_be_equal_to_2() {
		ParkingLot parkingLot = new ParkingLot(10);
		parkingLot.vehicleIn("car");
		parkingLot.vehicleIn("car");
		parkingLot.vehicleIn("truck");
		parkingLot.vehicleIn("truck");
		assertEquals(2, parkingLot.enteredCars);
		assertEquals(2, parkingLot.enteredTrucks);

	}
	
	
	@Test
	public void when_calling_vehicleOut_on_car_and_truck_ensure_storage_variables_return_correct_values_expect_2_car_and_2_trucks() {
		ParkingLot parkingLot = new ParkingLot(10);
		parkingLot.vehicleIn("car");
		parkingLot.vehicleIn("car");
		parkingLot.vehicleIn("truck");
		parkingLot.vehicleIn("truck");
		parkingLot.vehicleIn("truck");
		parkingLot.vehicleOut("car", 1);
		parkingLot.vehicleOut("truck", 1);
		assertEquals(2,parkingLot.enteredCars);
		assertEquals(3,parkingLot.enteredTrucks);
	}
	
	@Test
	public void when_calling_vehicle_out_calculate_and_add_to_accumulated_fare_expected_car_1hr_parking_to_accumulate_$2_in_fare() {
		ParkingLot parkingLot = new ParkingLot(10);
		parkingLot.vehicleIn("car");
		parkingLot.vehicleOut("car", 1);
		assertEquals(2,parkingLot.cumulativeFares,0);
	}
	@Test
	public void when_calling_vehicle_out_on_car3_truck7_truck1_expect_30_in_cumulative_fares() {
		ParkingLot parkingLot = new ParkingLot(10);
		parkingLot.vehicleIn("car");
		parkingLot.vehicleIn("car");
		parkingLot.vehicleIn("truck");
		parkingLot.vehicleIn("truck");
		parkingLot.vehicleOut("car", 3);
		parkingLot.vehicleOut("truck", 7);
		parkingLot.vehicleOut("truck", 1);
		assertEquals(30,parkingLot.cumulativeFares,0);
	}
	
	
	

}
