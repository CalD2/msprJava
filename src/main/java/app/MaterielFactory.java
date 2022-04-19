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
	/** la map du matériel disponible */
	private Map<String, Materiel> materials = new HashMap<String, Materiel>();

	/**
	 * Constructeur
	 */
	private MaterielFactory()
	{
		// rien
	}

	/**
	 * Construit une liste de matériel à partir d'une liste de String. La factory
	 * doit posséder le matériel sinon lève une exception
	 * 
	 * @param lines de matériels
	 * @return liste de matériels
	 * @throws BadMaterialException si le matériel n'existe pas
	 */
	public List<Materiel> builds(List<String> lines) throws BadMaterialException
	{
		List<Materiel> results = new ArrayList<Materiel>();
		for (String line : lines)
		{
			// Le matériel doit exister
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
	 * Permet de construire la liste du matériel disponible pour les agents à partir
	 * d'un fichier
	 * 
	 * @param file à utiliser
	 * @throws IOException
	 * @throws BadFileException
	 */
	public void buildsAll(File file) throws IOException, BadFileException
	{
		// On récupère les lignes du fichier
		List<String> lines = FileUtils.readLines((file), "UTF-8");

		// Traitement
		Map<String, Materiel> results = new HashMap<String, Materiel>();
		for (String line : lines)
		{
			// split entre l'id et la description (au premier espace détecté)
			String[] tab = line.split("\\s", 2);
			// données valide
			if (tab.length == 2)
			{
				results.put(tab[0], new Materiel(tab[0], tab[1]));
			} else // non valide
			{
				throw new BadFileException();
			}
		}

		// Mise à jour du matériel
		materials = results;
	}

	public static MaterielFactory getFactory()
	{
		return factory;
	}

}
