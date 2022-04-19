package app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

/**
 * Staff factory
 *
 */
public class StaffFactory
{
	/** la factory du matériel */
	public static MaterielFactory factory = MaterielFactory.getFactory();

	/**
	 * Construit un membre du staff à partir de son fichier et de sa carte
	 * d'identité. Les éléments manquant sont remplacés par des éléments par défaut.
	 * 
	 * @param file   de l'agent à utiliser
	 * @param fileID carte d'identité de l'agent
	 * @return l'agent construit
	 * @throws BadFileException
	 */
	public static Staff build(File file, File fileID) throws BadMaterialException
	{
		Staff result = new Staff(FilenameUtils.getBaseName(file.getName()));

		// Lecture du fichier
		try
		{
			List<String> staffArgs = FileUtils.readLines(file, "UTF-8");

			// Information de base du staff
			result.setFirstName(staffArgs.get(0));
			result.setName(staffArgs.get(1));
			result.setMission(staffArgs.get(2));
			result.setMdp(staffArgs.get(3));

			// Matériel
			// Le staff possède du matériel et si oui, la 4ème ligne est bien vide
			if (staffArgs.size() > 4 && staffArgs.get(4).isBlank())
			{
				List<String> staffMateriels = staffArgs.subList(5, staffArgs.size());

				result.setMateriels(factory.builds(staffMateriels));
			}
		} catch (IOException e) // Le fichier n'existe pas, on crée un schéma par défaut
		{
			result.setFirstName("inconnu");
			result.setName("inconnu");
			result.setMission("inconnu");
			result.setMdp("inconnu");
			result.setMateriels(new ArrayList<Materiel>());
		}

		// carte ID
		if (fileID.exists() && fileID.isFile())
		{
			result.setCarte(fileID);
		} else // la carte n'existe pas, on en met une par défaut
		{
			result.setCarte(new File("src/main/resources/default.png"));
		}

		return result;
	}

	/**
	 * Construit une liste de membre du Staff
	 * 
	 * @param lines          constituant un membre du staff
	 * @param staffDirectory url pour les fiches des membres du staff
	 * @param cardDirectory  url des cartes d'identité
	 * @return liste des membres du staff
	 * @throws IOException
	 * @throws BadMaterialException
	 */
	public static List<Staff> builds(List<String> lines, String staffDirectory, String cardDirectory)
			throws IOException, BadMaterialException
	{
		List<Staff> results = new ArrayList<Staff>();

		for (String line : lines)
		{
			// Récupération des fichiers permettant de construire le membre du staff
			File file = new File(staffDirectory + line + ".txt");
			File fileID = new File(cardDirectory + line + ".png");

			results.add(build(file, fileID));
		}

		return results;
	}
}
