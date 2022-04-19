package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;

/**
 * Factory pour materiel
 *
 */
public class MaterielFactory
{
	/** singleton */
	private static MaterielFactory factory = new MaterielFactory();
	/** la map du mat�riel disponible */
	private Map<String, Materiel> materials = new HashMap<String, Materiel>();

	/**
	 * Constructeur
	 */
	private MaterielFactory()
	{
		// rien
	}

	/**
	 * Construit une liste de mat�riel � partir d'une liste de String. La factory
	 * doit poss�der le mat�riel sinon l�ve une exception
	 * 
	 * @param lines de mat�riels
	 * @return liste de mat�riels
	 * @throws BadMaterialException si le mat�riel n'existe pas
	 */
	public List<Materiel> builds(List<String> lines) throws BadMaterialException
	{
		List<Materiel> results = new ArrayList<Materiel>();
		for (String line : lines)
		{
			// Le mat�riel doit exister
			if (materials.containsKey(line))
			{
				results.add(materials.get(line));
			} else
			{
				throw new BadMaterialException();
			}
		}
		return results;
	}

	/**
	 * Permet de construire la liste du mat�riel disponible pour les agents � partir
	 * d'un fichier
	 * 
	 * @param file � utiliser
	 * @throws IOException
	 * @throws BadFileException
	 */
	public void buildsAll(File file) throws IOException, BadFileException
	{
		// On r�cup�re les lignes du fichier
		List<String> lines = FileUtils.readLines((file), "UTF-8");

		// Traitement
		Map<String, Materiel> results = new HashMap<String, Materiel>();
		for (String line : lines)
		{
			// split entre l'id et la description (au premier espace d�tect�)
			String[] tab = line.split("\\s", 2);
			// donn�es valide
			if (tab.length == 2)
			{
				results.put(tab[0], new Materiel(tab[0], tab[1]));
			} else // non valide
			{
				throw new BadFileException();
			}
		}

		// Mise � jour du mat�riel
		materials = results;
	}

	public static MaterielFactory getFactory()
	{
		return factory;
	}

}
