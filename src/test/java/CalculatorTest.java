import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testProcess() throws Exception {
		Assert.assertEquals(Calculator.process("13/20*9/12"),"13/20*9/12 = 39/80");
		Assert.assertEquals(Calculator.process("qwert"),"qwert < The expression contains invalid characters");
		Assert.assertEquals(Calculator.process("1/0+3/2"),"1/0+3/2 < Denominator should not be equal to 0");
		Assert.assertEquals(Calculator.process("1+4"),"1+4 < Invalid input fractions");
		Assert.assertEquals(Calculator.process("1/2+4/4+5/6"),"1/2+4/4+5/6 < The expression contains more than one operand");
	}
}
