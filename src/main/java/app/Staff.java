package app;

import java.io.File;
import java.util.List;

/**
 * Représente un membre du staff
 *
 */
public class Staff
{
	/** identifiant du staff */
	private String id;
	/** le nom */
	private String firstName;
	/** prénom */
	private String name;
	/** mission */
	private String mission;
	/** mdp */
	private String mdp;
	/** Le matériel */
	private List<Materiel> materiels;
	/** carte ID */
	private File carte;

	public Staff(String id)
	{
		this.id = id;
	}

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getMission()
	{
		return mission;
	}

	public void setMission(String mission)
	{
		this.mission = mission;
	}

	public String getMdp()
	{
		return mdp;
	}

	public void setMdp(String mdp)
	{
		this.mdp = mdp;
	}

	public List<Materiel> getMateriels()
	{
		return materiels;
	}

	public void setMateriels(List<Materiel> materiels)
	{
		this.materiels = materiels;
	}

	public File getCarte()
	{
		return carte;
	}

	public void setCarte(File carte)
	{
		this.carte = carte;
	}

}
