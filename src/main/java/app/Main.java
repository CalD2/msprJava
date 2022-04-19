package app;

import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.io.FileUtils;

import freemarker.template.TemplateException;

public class Main
{

	public static void main(String[] args) throws IOException, BadFileException, BadMaterialException, TemplateException
	{
		String directory = "src/main/resources/"; // args[0];
		String directoryIdCards = "src/main/resources/idcards/"; // args[1];
		String directoryStaffs = "src/main/resources/staffs/"; // args[2];

		// Récupération url
		if (args.length != 0)
		{
			directory = args[0];
			directoryIdCards = args[1];
			directoryStaffs = args[2];
		}

		// init du matériel de la factory
		StaffFactory.factory.buildsAll(new File(directory + "liste.txt"));

		// On construit la liste des agents
		List<String> lines = FileUtils.readLines(new File(directory + "staff.txt"), "UTF-8");
		List<Staff> staffs = StaffFactory.builds(lines, directoryStaffs, directoryIdCards);

		// On tri les agents par ordre alphabétique
		staffs.sort(Comparator.comparing(Staff::getId));

		// On génère les pages html
		HtmlFactory.buildIndex(staffs);
		String result = HtmlFactory.build(staffs);
	}

}
