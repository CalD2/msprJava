package app;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MaterialFactoryTest
{
	/**
	 * test de g�n�rer du mat�rial avec une liste str vide. On ne doit pas avoir de
	 * mat�riel g�n�r�
	 * 
	 * @throws BadFileException
	 */
	@Test
	public void t001_noMaterial() throws BadMaterialException
	{
		List<String> materialsStr = new ArrayList<String>();
		List<Materiel> materials = MaterielFactory.getFactory().builds(materialsStr);

		assertEquals(true, materials.isEmpty());
	}

	/**
	 * test de g�n�rer du mat�rial avec une liste str contenant un mat�riel inconnu.
	 * On l�ve une exception
	 * 
	 * @throws BadMaterialException
	 */
	@Test
	public void t002_MaterialNoExist() throws BadMaterialException
	{
		List<String> materialsStr = new ArrayList<String>();
		materialsStr.add("test");

		assertThrows(BadMaterialException.class, () -> MaterielFactory.getFactory().builds(materialsStr));

	}

	/**
	 * On importe du mat�riel depuis un fichier qui ne respecte pas le format
	 * demander. On l�ve une exception
	 * 
	 * @throws BadFileException
	 */
	@Test
	public void t003_MaterialImportBadFile() throws BadFileException
	{
		File file = new File("src/test/resources/listeBad.txt");

		assertThrows(BadFileException.class, () -> MaterielFactory.getFactory().buildsAll(file));

	}

	/**
	 * On importe du mat�riel depuis un fichier puis on en fait une liste d'objet.
	 * 
	 * @throws BadFileException
	 * @throws IOException
	 * @throws BadMaterialException
	 */
	@Test
	public void t004_MaterialsGenerate() throws BadFileException, IOException, BadMaterialException
	{
		File file = new File("src/test/resources/listeOk.txt");

		// Import du mat�riel
		MaterielFactory.getFactory().buildsAll(file);

		// Liste valide de mat�riel � g�n�rer
		List<String> materialsStr = new ArrayList<String>();
		materialsStr.add("mousqueton");
		materialsStr.add("lampe");
		materialsStr.add("taser");

		List<Materiel> materials = MaterielFactory.getFactory().builds(materialsStr);

		assertEquals(3, materials.size());

	}
}
