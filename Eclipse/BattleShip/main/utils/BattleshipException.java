package main.utils;

public class BattleshipException extends Exception{
	//Private data members
	private String errorCode;
	private String message;

	//Public Methods
	public BattleshipException()
	{
		super();
	}
	
	public BattleshipException(String message)
	{
		super(message);
		this.message = message;
	}
	
	public BattleshipException(String message, Throwable cause)
	{
		super(message, cause);
		this.message = message;
	}
	
	public BattleshipException(String message, String errorCode, Throwable cause)
	{
		super(message, cause);
		this.errorCode = errorCode;
		this.message = message;
	}
}
