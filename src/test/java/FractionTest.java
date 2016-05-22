import org.junit.Assert;
import org.junit.Test;

public class FractionTest {

	@Test
	public void testReduction() throws Exception {
		Fraction f1 = new Fraction(14, 14);
		Assert.assertEquals(f1.getNumerator(), 1);
		Assert.assertEquals(f1.getDenominator(), 1);
	}

	@Test
	public void testDivBy0() {
		try {
			new Fraction(14, 0);
			Assert.assertTrue(false);
		} catch (Exception e) {
		}

	}

	@Test
	public void testOperations() throws Exception {
		Fraction f1 = new Fraction(7, 8);
		Fraction f2 = new Fraction(1, 2);

		Fraction res1 = null;
		res1 = f1.add(f2);
		Assert.assertEquals(res1.getNumerator(), 11);
		Assert.assertEquals(res1.getDenominator(), 8);

		Fraction res2 = f1.sub(f2);
		Assert.assertEquals(res2.getNumerator(), 3);
		Assert.assertEquals(res2.getDenominator(), 8);

		Fraction res3 = f1.mul(f2);
		Assert.assertEquals(res3.getNumerator(), 7); // 14
		Assert.assertEquals(res3.getDenominator(), 16); // 32

		Fraction res4 = f1.div(f2);
		Assert.assertEquals(res4.getNumerator(), 7); // 28
		Assert.assertEquals(res4.getDenominator(), 4); // 16

	}

	@Test
	public void testToString() throws Exception {
		Fraction f1 = new Fraction(1, 2);
		Assert.assertEquals(f1.toString(), "1/2");
	}

}
