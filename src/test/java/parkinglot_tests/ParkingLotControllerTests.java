package parkinglot_tests;

import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mockito;

import com.fdm.parkinglot.InvalidCommandException;
import com.fdm.parkinglot.ParkingLot;
import com.fdm.parkinglot.ParkingLotDirector;
import com.fdm.parkinglot.iParkingLot;
import com.fdm.parkinglot.iValidator;
import com.fdm.parkinglot.iView;

import org.junit.Before;

public class ParkingLotControllerTests {
	
	
	
	iView mockiView = mock(iView.class);
	iValidator mockiValidator = mock(iValidator.class);
	iParkingLot mockiParkingLot = mock(iParkingLot.class);
	ParkingLotDirector parkingLotDirector = new ParkingLotDirector(mockiView,mockiValidator,mockiParkingLot);
	
	
	
	@Test
	public void on_call_handle_verify_attempt_to_getExpression() {
		when(mockiView.getExpression()).thenReturn("ENTER CAR");
		parkingLotDirector.handle();
		verify(mockiView).getExpression();
	}
	
	@Test
	public void on_call_handle_verify_attempt_to_getExpression_then_call_validate_method() throws InvalidCommandException {
		when(mockiView.getExpression()).thenReturn("ENTER CAR");
		when(mockiValidator.validate(anyString())).thenReturn("ENTER CAR");
		parkingLotDirector.handle();
		verify(mockiValidator).validate("ENTER CAR");
	}
	
	@Test
	public void on_call_handle_on_valid_expression_call_decideMethod() throws InvalidCommandException {
		when(mockiView.getExpression()).thenReturn("ENTER CAR");
		parkingLotDirector.handle();
		
		InOrder inOrder = Mockito.inOrder(mockiValidator,mockiParkingLot);
		inOrder.verify(mockiValidator).validate(anyString());
		inOrder.verify(mockiParkingLot).decideMethod(anyString());
		
	}
	
	
	@Test
	public void if_exception_occurs_then_display_error_and_never_call_decideMethod() throws InvalidCommandException {
		when(mockiView.getExpression()).thenReturn("$ENTER CAR!");
		when(mockiValidator.validate("$ENTER CAR!")).thenReturn(null);
		doThrow(new InvalidCommandException("Error: unsupported character in expression")).when(mockiValidator).validate("$ENTER CAR!");
		InOrder inOrder = inOrder(mockiValidator, mockiParkingLot);
		parkingLotDirector.handle();
		
		inOrder.verify(mockiValidator).validate("$ENTER CAR!");
		inOrder.verify(mockiParkingLot,never()).decideMethod(null);	

		
	}
	
	
	
	
	
	
}
