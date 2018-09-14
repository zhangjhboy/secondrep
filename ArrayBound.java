public class ArrayBound
{
        public static void main(String[] args)
        {
	int array[][] = { { 1, 2, 3 }, { 1, 5 } };
	System.out.println( array[1][2] );
        }
}
/*½á¹û£º
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 2
        at ArrayBound.main(ArrayBound.java:6)*/