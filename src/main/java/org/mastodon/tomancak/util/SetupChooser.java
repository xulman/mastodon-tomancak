package org.mastodon.tomancak.util;

import org.mastodon.revised.model.mamut.Model;
import org.scijava.command.Command;
import org.scijava.command.DynamicCommand;
import org.scijava.plugin.Plugin;
import org.scijava.plugin.Parameter;
import java.util.Arrays;

@Plugin( type = Command.class, name = "Choose from available setups" )
public class SetupChooser
extends DynamicCommand
{
	@Parameter(required = false, persist = false)
	private String[] setupViews = null;
	//
	@Parameter(label = "Which one: ",
	           initializer = "mySetChoices", choices = {} )
	public String setupView = "";

	void mySetChoices()
	{
		if (setupViews == null)
			throw new IllegalArgumentException("Provide an initial String[] of 'setupViews' to run this plugin.");

		getInfo().getMutableInput("setupView", String.class).setChoices(Arrays.asList(setupViews));
		this.unresolveInput("a");
	}

	@Parameter(label = "Which number: ", persist = false)
	public int a = 0;

	@Parameter
	Model model;

	@Override
	public void run()
	{
		System.out.println("chose: "+setupView);
		System.out.println("chose a="+a);
		for (String s : setupViews)
			System.out.println(s);
		System.out.println("model: "+model.getSpatioTemporalIndex().getSpatialIndex(0).size());
		System.out.println("model: "+model.getSpatioTemporalIndex().getSpatialIndex(1).size());
	}
}
