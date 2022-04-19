package app;

import java.io.IOException;
import java.util.Locale;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.Version;

/**
 * Template des vues html
 *
 */
public class ViewTemplate
{
	/** singleton */
	private static ViewTemplate template = new ViewTemplate();

	/** config de Freemarker */
	private Configuration config;

	/**
	 * Constructeur. Initialize les informations de base, la config
	 */
	private ViewTemplate()
	{
		config = new Configuration(new Version("2.3.31"));
		// Where do we load the templates from:
		config.setClassForTemplateLoading(ViewTemplate.class, "/templates/");
		// Some other recommended settings:
		config.setIncompatibleImprovements(new Version(2, 3, 31));
		config.setLocale(Locale.FRANCE);
		config.setDefaultEncoding("UTF-8");
		config.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
	}

	public static ViewTemplate getTemplate()
	{
		return template;
	}

	/**
	 * Permet de récupérer le template de l'index
	 * 
	 * @return template de l'index
	 * @throws TemplateException
	 * @throws IOException
	 */
	public Template getIndexTemplate() throws TemplateException, IOException
	{
		return config.getTemplate("index.ftl");
	}

	/**
	 * Permet de récupérer le template d'une page d'agent
	 * 
	 * @return template d'une page d'agent
	 * @throws TemplateException
	 * @throws IOException
	 */
	public Template getPageTemplate() throws TemplateException, IOException
	{
		return config.getTemplate("staffModelHtml.ftl");
	}

}
