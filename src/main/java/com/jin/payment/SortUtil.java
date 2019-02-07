package com.jin.payment;

import java.util.Arrays;
import java.util.List;

public class SortUtil {
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

    public static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
	
	public static boolean isSorted(Comparable[] a) {
		return isSorted(a, 0, a.length - 1);
	}

	public static boolean isSorted(Comparable[] a, int lo, int hi) {
		for (int i = lo + 1; i <= hi; i++)
			if (less(a[i], a[i - 1]))
				return false;
		return true;
	}
	
	public static Comparable[] toArray(List<? extends Comparable> list) {
		return  list.toArray(new Comparable[list.size()]);
	}

	public static List<Comparable> toList(Comparable[] a) {
		return Arrays.asList(a);
	}

}
