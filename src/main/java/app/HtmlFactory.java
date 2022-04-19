package app;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * Permet de construire du code html
 *
 */
public class HtmlFactory
{
	/**
	 * Constructeur
	 */
	private HtmlFactory()
	{
		// rien
	}

	public static String buildIndex(List<Staff> staffs) throws TemplateException, IOException
	{
		// R�cup�ration du template
		Template template = ViewTemplate.getTemplate().getIndexTemplate();

		// R�cup�ration des identifiants des agents
		List<String> results = new ArrayList<String>();
		for (Staff staff : staffs)
		{
			results.add(staff.getId());
		}
		// Traitement template
		Map<String, Object> input = new HashMap<String, Object>();
		input.put("staffs", results);

		// �criture
		String fileName = "index.html";
		write(template, input, fileName);

		return null;
	}

	/**
	 * Construit une page html pour un membre du staff donn�e
	 * 
	 * @param staff le membre � utiliser pour cr�er la page html
	 * @return
	 * @throws IOException
	 * @throws TemplateException
	 */
	public static String build(List<Staff> staffs) throws IOException, TemplateException
	{
		// R�cup�ration du template
		Template template = ViewTemplate.getTemplate().getPageTemplate();

		// On cr�e une page pour chaque agent
		for (Staff staff : staffs)
		{
			Map<String, Object> input = new HashMap<String, Object>();
			input.put("staff", staff);

			// �criture
			String fileName = "staffs/" + staff.getId() + ".html";
			write(template, input, fileName);
		}

		return null;
	}

	/**
	 * Ecrit en console et dans un fichier de l'html � partir d'un template
	 * 
	 * @param template utilis�
	 * @param input    utilis�
	 * @param fileName nom du fichier
	 * @throws TemplateException
	 * @throws IOException
	 */
	private static void write(Template template, Map<String, Object> input, String fileName)
			throws TemplateException, IOException
	{
		// Write output to the console
		Writer consoleWriter = new OutputStreamWriter(System.out);
		template.process(input, consoleWriter);

		// For the sake of example, also write output into a file:
		try (Writer fileWriter = new FileWriter(new File(fileName), Charset.forName("UTF-8")))
		{
			template.process(input, fileWriter);

		}
	}

}
