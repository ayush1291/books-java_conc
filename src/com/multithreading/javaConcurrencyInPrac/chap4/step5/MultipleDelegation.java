package com.multithreading.javaConcurrencyInPrac.chap4.step5;

import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class MultipleDelegation {
	private final List<KeyListener> keyListeners = new CopyOnWriteArrayList<>();
	private final List<MouseListener> mouseListeners = new CopyOnWriteArrayList<>();
	
	//any operations on these...add / remove etc are independent of each other
	//so usage of CopyOnWriteArrayList is justified
}
