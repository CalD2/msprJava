package app;

/**
 * Représentation d'un matériel
 *
 */
public class Materiel
{
	/** identifiant du matériel */
	private String id;
	/** description */
	private String description;

	/**
	 * Constructeur
	 * 
	 * @param id   du matériel
	 * @param desc du matériel
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
