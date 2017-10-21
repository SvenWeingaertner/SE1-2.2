package se_01;

public class Project {
	String[][] rules;

	public Project(String[][] rules) {
		this.rules = rules;
	}

	public boolean isDisjoint(String[] sequence) {
		for (int i = 0; i < sequence.length; i++) {
			for (int j = i + 1; j < sequence.length; j++) {
				if (sequence[i] == sequence[j]) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean foundCycle() {
		for (int i = 0; i < rules.length; i++) {
			// Erkennt Schleifen
			if (rules[i][0] == rules[i][1]) {
				return true;
			}
			for (int j = i + 1; j < rules.length; j++) {
				// Erkennt Zykel
				if ((rules[i][0] == rules[j][1] && rules[i][1] == rules[j][0])) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean minSequenceLength(String[] sequence) {
		return sequence.length * (sequence.length - 1) >= 2 * rules.length;
	}

	public boolean isWellSorted(String[] sequence) {
		if (foundCycle() || !isDisjoint(sequence) || !minSequenceLength(sequence)) {
			return false;
		}

		for (int i = 0; i < rules.length; i++) {
			boolean isVorFound = false;
			boolean isNachFound = false;
			for (int j = 0; j < sequence.length; j++) {
				System.out.println(sequence[j]);
				if (!isVorFound && sequence[j] == rules[i][0]) {
					isVorFound = true;
				}
				if (isVorFound && sequence[j] == rules[i][1]) {
					isNachFound = true;
				}
			}
			if (isVorFound != isNachFound) {
				return false;
			}
		}
		return true;
	}
}