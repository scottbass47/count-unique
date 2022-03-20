import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class CountUnique {
	
	private char[] alphabet;
	private char start;
	private char terminal;
	private int maxLen;
	
	public CountUnique(char[] alphabet, int terminalIdx, int maxLen) {
		this.alphabet = alphabet;
		this.start = alphabet[0];
		this.terminal = alphabet[terminalIdx];
		this.maxLen = maxLen;
	}
	
	public int count() {
		if (maxLen < 2) return 0;
		
		int count = 0;
		Memo memo = new Memo();
		for (int i = 1; i < maxLen; i++) {
			count += countInternal(memo, start, i);
		}
		
		return count;
	}
	
	public int countInternal(Memo memo, char from, int length) {
		Optional<Integer> lookup = memo.get(from, length);
		
		if (lookup.isPresent()) return lookup.get();
		
		int count = 0;
		if (length == 0) {
			count = from == terminal ? 1 : 0;
		} else {
			for (char letter : alphabet) {
				if (letter == from) continue;
				count += countInternal(memo, letter, length - 1);
			}
		}
		
		return memo.storeAndGet(from, length, count);
	}
	
	private static class Memo {
		
		private Map<Character, Map<Integer, Integer>> m = new HashMap<>();
		
		private Optional<Integer> get(char letter, int length) {
			Map<Integer, Integer> counts = m.get(letter);
			if (counts == null) return Optional.empty();
			
			return Optional.ofNullable(counts.get(length));
		}

		private int storeAndGet(char letter, int length, int count) {
			if (!m.containsKey(letter)) {
				m.put(letter, new HashMap<>());
			}
			
			Map<Integer, Integer> counts = m.get(letter);
			counts.put(length, count);
			return count;
		}
	}

}
