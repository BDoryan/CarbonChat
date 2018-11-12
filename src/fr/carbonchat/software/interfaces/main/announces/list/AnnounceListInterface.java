package fr.carbonchat.software.interfaces.main.announces.list;

import fr.carbonchat.jfxswinger.utils.Interface;
import fr.carbonchat.software.core.swinger.Announces;

public class AnnounceListInterface extends Interface {

	protected final int MAX_ANNOUNCES_PER_PAGE = 20;
	
	public Announces[] announces = new Announces[MAX_ANNOUNCES_PER_PAGE];
	
	public AnnounceListInterface(int page) {
		reloadAll();
		}
		
	public void reloadAll() {
		reloadAnnounces();
	}
	
	public void reloadAnnounces() {
		
	}
	
	@Override
	public void enter() {
		reloadAll();
	}

	@Override
	public void leave() {
	}
}
