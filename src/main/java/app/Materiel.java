package app;

/**
 * Repr�sentation d'un mat�riel
 *
 */
public class Materiel
{
	/** identifiant du mat�riel */
	private String id;
	/** description */
	private String description;

	/**
	 * Constructeur
	 * 
	 * @param id   du mat�riel
	 * @param desc du mat�riel
	 */
	public Materiel(String id, String desc)
	{
		this.id = id;
		this.description = desc;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

}
