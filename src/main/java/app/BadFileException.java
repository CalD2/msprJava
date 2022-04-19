package app;

/**
 * Fichier invalide
 *
 */
public class BadFileException extends Exception
{
	private static final long serialVersionUID = 1L;

	public BadFileException()
	{
		new Exception("fichier invalide");
	}
}
