public class AddressPrint
{
        public static void main(String[] args)
        {
	int a = 10;
	int b = 100;
	int array[][] = { { 1, 3, 5 } , { 87, 33, 54 } };
	System.out.println(System.identityHashCode(a));
	System.out.println(System.identityHashCode(b));
	System.out.println(System.identityHashCode(array[0][2]));
	System.out.println(System.identityHashCode(array[0]));
        }
}
