package fr.carbonchat.software.interfaces.main.profile;

import fr.carbonchat.jfxswinger.utils.Interface;

public class MyProfileInterface extends Interface {

	public static final MyProfileInterface INTERFACE = new MyProfileInterface();

	public MyProfileInterface() {
		reloadAll();
	}
	
	public void reloadAll() {
	}

	@Override
	public void enter() {
		reloadAll();
	}

	@Override
	public void leave() {
	}
}
