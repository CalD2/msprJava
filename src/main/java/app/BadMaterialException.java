package app;

/**
 * Exception pour un matériel invalide
 *
 */
public class BadMaterialException extends Exception
{
	private static final long serialVersionUID = 1L;

	public BadMaterialException()
	{
		new Exception("matériel invalide");
	}
}
