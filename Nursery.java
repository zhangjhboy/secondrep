public class Nursery
{
        public static void main(String[] args)
	{
	        int num = 99;
	        int i;
	        for (i = 0 ; i < num; i++)
	        {
		if (i < num - 1)
		{
		        System.out.println( (num - i) + " bottles of beer on the wall," + (num - i) + " bottles of beer.");
		        System.out.println("Take one down.");
		        System.out.println("Pass it around.");
		        System.out.println( (num - i - 1) + " bottles of beer on the wall.\n");
		}
		else
		{
		        System.out.println( (num - i) + " bottle of beer on the wall," + (num - i) + " bottle of beer.");
		        System.out.println("Take one down.");
		        System.out.println("Pass it around.");
		        System.out.println("No more bottles of beer.");
		}
	        }
	}
}