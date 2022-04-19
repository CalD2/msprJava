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
	 * test de générer du matérial avec une liste str vide. On ne doit pas avoir de
	 * matériel généré
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
	 * test de générer du matérial avec une liste str contenant un matériel inconnu.
	 * On lève une exception
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
	 * On importe du matériel depuis un fichier qui ne respecte pas le format
	 * demander. On lève une exception
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
	 * On importe du matériel depuis un fichier puis on en fait une liste d'objet.
	 * 
	 * @throws BadFileException
	 * @throws IOException
	 * @throws BadMaterialException
	 */
	@Test
	public void t004_MaterialsGenerate() throws BadFileException, IOException, BadMaterialException
	{
		File file = new File("src/test/resources/listeOk.txt");

		// Import du matériel
		MaterielFactory.getFactory().buildsAll(file);

		// Liste valide de matériel à générer
		List<String> materialsStr = new ArrayList<String>();
		materialsStr.add("mousqueton");
		materialsStr.add("lampe");
		materialsStr.add("taser");

		List<Materiel> materials = MaterielFactory.getFactory().builds(materialsStr);

		assertEquals(3, materials.size());

	}
}
