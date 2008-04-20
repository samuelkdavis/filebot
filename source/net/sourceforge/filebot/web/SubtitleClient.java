
package net.sourceforge.filebot.web;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.ImageIcon;


public abstract class SubtitleClient {
	
	private static final List<SubtitleClient> registry = new ArrayList<SubtitleClient>();
	
	static {
		registry.add(new OpenSubtitlesSubtitleClient());
		registry.add(new SubsceneSubtitleClient());
	}
	
	
	public static List<SubtitleClient> getAvailableSubtitleClients() {
		return Collections.unmodifiableList(registry);
	}
	
	private String name;
	private ImageIcon icon;
	
	
	public SubtitleClient(String name, ImageIcon icon) {
		this.name = name;
		this.icon = icon;
	}
	

	public String getName() {
		return name;
	}
	

	public ImageIcon getIcon() {
		return icon;
	}
	

	public abstract List<MovieDescriptor> search(String query) throws Exception;
	

	public abstract List<? extends SubtitleDescriptor> getSubtitleList(MovieDescriptor descriptor) throws Exception;
	

	@Override
	public String toString() {
		return name;
	}
}
