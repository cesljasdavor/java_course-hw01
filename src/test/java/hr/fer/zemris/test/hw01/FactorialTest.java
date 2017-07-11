package hr.fer.zemris.test.hw01;

import static org.junit.Assert.*;

import org.junit.Test;

import hr.fer.zemris.java.hw01.Factorial;

public class FactorialTest {

	@Test
	public void predanNegativanBroj() {
		long result = Factorial.computeFactorail(-200);
		assertEquals(-1L, result);
	}

	@Test
	public void predanaNula() {
		long result = Factorial.computeFactorail(0);
		assertEquals(-1L, result);
	}

	@Test
	public void predanPrirodanBroj() {
		long result = Factorial.computeFactorail(20);
		assertEquals(2432902008176640000L, result);
	}

	@Test
	public void predanBrojZaKojiNemozemoIzracunatiFaktorijele() {
		long result = Factorial.computeFactorail(100000000);
		assertEquals(0L, result);
	}

}
