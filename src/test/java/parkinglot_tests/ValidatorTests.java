package parkinglot_tests;


import org.junit.Before;
import org.junit.Test;
import com.fdm.parkinglot.InvalidCommandException;
import com.fdm.parkinglot.Validator;

public class ValidatorTests {

	private Validator validator;
	@Before
	public void setup() {
		validator = new Validator();
	}
	
	
	
	@Test (expected = NullPointerException.class)
	public void throws_NullPointerException_when_string_empty() throws NullPointerException, InvalidCommandException{
		validator.validate(null);
	}
	
	
	@Test 
	public void no_exception_if_valid_string() throws InvalidCommandException {
		validator.validate("EXIT CAR 2");
	}
	
	
	@Test (expected = InvalidCommandException.class)
	public void will_throw_invalid_command_exception_when_unorthodox_symbols_in_expression() throws InvalidCommandException {
		validator.validate("$EXIT CAR 2!");
	}
	
	@Test (expected = InvalidCommandException.class)
	public void will_throw_invalid_command_exception_when_multiple_numbers_in_input() throws InvalidCommandException {
		validator.validate("EXIT CAR 2 2");
	}
	
	
	
}
