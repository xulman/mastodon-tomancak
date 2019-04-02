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
	String[] setupViews = {"hi","ewq"};
	//
	@Parameter(label = "Which one: ", initializer = "mySetChoices",
	           choices = {} )
	public String setupView = "";

	void mySetChoices()
	{
		System.out.println("mySetChoices is called...");

		/*
		final MutableModuleItem<String> i = getInfo().getMutableInput("setupView", String.class);
		i.setChoices(Arrays.asList(setupViews));
		*/

		getInfo().getMutableInput("setupView", String.class).setChoices(Arrays.asList(setupViews));
	}

	@Parameter(label = "Which number: ")
	public int a=10;

	public SetupChooser()
	{
		//empty for now...
		System.out.println("SetupChoose c'tor()");
	}

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
