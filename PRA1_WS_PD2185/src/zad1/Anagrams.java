/**
 *
 *  @author Wijas Sebastian PD2185
 *
 */

package zad1;

import java.io.*;
import java.util.*;

public class Anagrams {

	private Set<List<String>> set = new TreeSet<>(this::toCompare);

	public Anagrams(String path) throws FileNotFoundException {
		List<String> list = getListFromFile(path);
		fillSet(list);

	}

	private int toCompare(List<String> l1, List<String> l2) {
		if (l1.size() < l2.size())
			return 1;
		if (l1.size() > l2.size())
			return -1;
		return 0;
	}

	private List<String> getListFromFile(String path) throws FileNotFoundException {
		List<String> list = new LinkedList<>();
		try (Scanner sc = new Scanner(new FileInputStream(path))) {

			while (sc.hasNext())
				list.add(sc.next());
		}
		return list;

	}

	private void fillSet(List<String> list) {
		while (!list.isEmpty()) {
			Iterator<String> it = list.iterator();
			List<String> l = new LinkedList<>();
			l.add(it.next());
			it.remove();
			while (it.hasNext()) {
				String el = it.next();
				if (isAnagram(el, l.get(0))) {
					l.add(el);
					it.remove();
				}
			}
			set.add(l);

		}
	}

	private boolean isAnagram(String w1, String w2) {
		return getSortListCharacter(w1.toCharArray()).equals(getSortListCharacter(w2.toCharArray()));
	}

	private List<Character> getSortListCharacter(char[] chs) {
		Arrays.sort(chs);
		List<Character> list = new ArrayList<>();
		for (char ch : chs)
			list.add(ch);
		return list;

	}

	public Set<List<String>> getSortedByAnQty() {
		return set;
	}
	//System.out.println(set.toString());
	public String getAnagramsFor(String word) {
		for (List<String> l : set) {

			if (l.contains(word)) {
				System.out.print(word + ": ");
				return l.toString();

			}
		}
		return "";
	}

}