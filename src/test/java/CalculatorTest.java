import org.junit.Assert;
import org.junit.Test;

public class CalculatorTest {
	@Test
	public void testProcess() throws Exception {
		Assert.assertEquals(Calculator.process("13/20*9/12"),"13/20*9/12 = 39/80"); //stringToProcess + " = " + res.toString();
		Assert.assertEquals(Calculator.process("qwert"),"qwert < Выраение содержит недопустимые символы");
		Assert.assertEquals(Calculator.process("1/0+3/2"),"1/0+3/2 < Знаменатель не должен быть равен 0");
		Assert.assertEquals(Calculator.process("1+4"),"1+4 < Некорретный ввод дроби");
		Assert.assertEquals(Calculator.process("1/2+4/4+5/6"),"1/2+4/4+5/6 < Выражение содержит более одного операнда");
	}
}
