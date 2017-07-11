package hr.fer.zemris.test.hw01;

import static org.junit.Assert.*;

import org.junit.Test;

import static hr.fer.zemris.java.hw01.UniqueNumbers.*;
import hr.fer.zemris.java.hw01.UniqueNumbers.TreeNode;

public class UniqueNumbersTest {

	@Test
	public void dodajUStabloNovaVrijednost() {
		TreeNode glava = null;
		glava = addNode(glava, 42);
		assertEquals(42, glava.value);
	}

	@Test
	public void dodajUStabloVrijednostPostoji() {
		/*
		 * provjera je li glava ostala ista vrijednost u memoriji ,odnosno da se
		 * nije promijenila referenca
		 */

		TreeNode glava = null;
		glava = addNode(glava, 42);

		TreeNode pom = glava;
		glava = addNode(glava, 42);
		assertEquals(pom, glava);
	}

	@Test
	public void veličinuPraznogStabla() {
		assertEquals(0, treeSize(null));
	}

	@Test
	public void veličinaPunogStabla() {
		TreeNode glava = null;
		glava = addNode(glava, 42);
		glava = addNode(glava, 21);
		glava = addNode(glava, 76);
		glava = addNode(glava, 35);
		assertEquals(4, treeSize(glava));
	}

	@Test
	public void veličinaPunogStablaUzVišestrukoDodavanje() {
		TreeNode glava = null;
		glava = addNode(glava, 42);
		glava = addNode(glava, 21);
		glava = addNode(glava, 76);
		glava = addNode(glava, 35);
		glava = addNode(glava, 42);
		glava = addNode(glava, 21);
		assertEquals(4, treeSize(glava));
	}

	@Test
	public void sadrziElementaElementNePostoji() {
		TreeNode glava = null;
		glava = addNode(glava, 42);
		glava = addNode(glava, 21);
		glava = addNode(glava, 76);
		glava = addNode(glava, 35);
		assertEquals(false, containsValue(glava, 0));
	}

	@Test
	public void sadrziElementaElementPostoji() {
		TreeNode glava = null;
		glava = addNode(glava, 42);
		glava = addNode(glava, 21);
		glava = addNode(glava, 76);
		glava = addNode(glava, 35);
		assertEquals(true, containsValue(glava, 76));
	}

	@Test
	public void provjeriPostojanjeGlavaNull() {
		TreeNode glava = null;
		glava = addNode(glava, 42);
		glava = addNode(glava, 21);
		glava = addNode(glava, 76);
		glava = addNode(glava, 35);
		assertEquals(false, containsValue(null, 0));
	}

}
