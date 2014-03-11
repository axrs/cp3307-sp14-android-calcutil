package utilities;

public class StringUtility {
	
	private StringUtility(){
		
	}
	
	public static String fmt(double d)
	{
	    if(d == (int) d)
	        return String.format("%d",(int)d);
	    else
	        return String.format("%s",d);
	}

}
