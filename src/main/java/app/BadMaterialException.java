package app;

/**
 * Exception pour un mat�riel invalide
 *
 */
public class BadMaterialException extends Exception
{
	private static final long serialVersionUID = 1L;

	public BadMaterialException()
	{
		new Exception("mat�riel invalide");
	}
}
