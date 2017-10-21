
package se_01;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ProjectTester {
	Project simple_example, simple_cycle, complex_cycle, complex_graph;

	@Before
	public void setUp() {
		simple_example = new Project(new String[][] { { "A", "C" }, { "C", "D" }, { "B", "C" } });
		simple_cycle = new Project(new String[][] { { "A", "A" } });
		complex_cycle = new Project(new String[][] { { "A", "B" }, { "B", "A" } });
		complex_graph = new Project(new String[][] { { "A", "C" }, { "C", "D" }, { "B", "C" }, { "A", "E" },
				{ "B", "F" }, { "E", "G" }, { "D", "G" }, { "F", "G" }, { "C", "E" }, { "C", "F" } });
	}

	@Test
	public void test_simple_example_1() {
		assertTrue(simple_example.isWellSorted(new String[] { "A", "B", "C", "D" }));
	}

	@Test
	public void test_simple_example_2() {
		assertTrue(simple_example.isWellSorted(new String[] { "B", "A", "C", "D" }));
	}

	@Test
	public void test_simple_example_3() {
		assertFalse(simple_example.isWellSorted(new String[] { "D", "C", "B", "A" }));
	}

	@Test
	public void test_simple_example_4() {
		assertFalse(simple_example.isWellSorted(new String[] { "C", "D", "B", "A" }));
	}

	@Test
	public void test_simple_example_5() {
		assertFalse(simple_example.isWellSorted(new String[] { "C", "D", "A", "B" }));
	}

	@Test
	public void test_simple_example_6() {
		assertFalse(simple_example.isWellSorted(new String[] { "A", "A", "A", "A" }));
	}

	@Test
	public void test_simple_example_7() {
		assertFalse(simple_example.isWellSorted(new String[] { "A", "A" }));
	}

	@Test
	public void test_simple_example_8() {
		assertFalse(simple_example.isWellSorted(new String[] { "A" }));
	}

	@Test
	public void test_simple_example_9() {
		assertFalse(simple_example.isWellSorted(new String[] {}));
	}

	@Test
	public void test_cycle_1() {
		assertFalse(simple_cycle.isWellSorted(new String[] {}));
	}

	@Test
	public void test_cycle_2() {
		assertFalse(simple_cycle.isWellSorted(new String[] { "A" }));
	}

	@Test
	public void test_cycle_3() {
		assertFalse(simple_cycle.isWellSorted(new String[] { "A", "A" }));
	}

	@Test
	public void test_cycle_4() {
		assertFalse(simple_cycle.isWellSorted(new String[] { "A", "A", "A" }));
	}

	@Test
	public void test_complex_cycle_1() {
		assertFalse(complex_cycle.isWellSorted(new String[] { "A", "B" }));
	}

	@Test
	public void test_complex_cycle_2() {
		assertFalse(complex_cycle.isWellSorted(new String[] { "A", "A" }));
	}

	@Test
	public void test_complex_cycle_3() {
		assertFalse(complex_cycle.isWellSorted(new String[] { "A" }));
	}

	@Test
	public void test_complex_graph_1() {
		assertTrue(complex_graph.isWellSorted(new String[] { "A", "B", "C", "D", "E", "F", "G" }));
	}

	@Test
	public void test_complex_graph_2() {
		assertFalse(complex_graph.isWellSorted(new String[] { "A", "B", "F", "D", "E", "C", "G" }));
	}

	// selbst hinzugefügt

	@Test
	public void test_simple_example_10() {
		assertFalse(simple_example.isWellSorted(new String[] { "A", "C", "A" }));
	}

	@Test
	public void test_complex_cycle_4() {
		assertFalse(complex_cycle.isWellSorted(new String[] { "B", "A" }));
	}

	@Test
	public void test_complex_graph_3() {
		assertFalse(complex_graph.isWellSorted(new String[] { "A", "C", "D", "G", "E", "F", "B" }));
	}
}
