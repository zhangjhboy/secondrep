import java.util.Scanner;
public class Audi
{
        public static void main(String[] args)
        {
                int i = 0;
	int num = 10;//��������
	Scanner input = new Scanner(System.in);
	Audi[] array = new Audi[num];
	//���복����Ϣ
	for (i = 0; i < num; i++)
	{
	        array[i] = new Audi();
                        System.out.println("�������" + (i + 1) + "����������Ϣ��");
	        System.out.println("�����ͺţ�");
	        array[i].model = input.next();
	        System.out.println("��ǰ������");
	        array[i].tank = input.nextDouble();
	        System.out.println("�ͺģ�");
	        array[i].oilConsumption= input.nextDouble();
	}
	//���������Ϣ
	for (i = 0; i < num; i++)
                {
	        System.out.println("��" + (i + 1) + "��������Ϣ");
	        System.out.println("�����ͺţ�" + array[i].model + "  " + "��ǰ������" + array[i].tank + "  " + "�ͺģ�" + array[i].oilConsumption);
                }
        }
        public String model;//�����ͺ�
        public double tank;//��ǰ������L��
        public double oilConsumption;//ÿ100km�ĺ��ͣ�L��
        public Audi()
        {
                model = "�µ�A3";
                tank = 25.0;
                oilConsumption = 5.70;
        }
        //����
        public void gas(double t)//������t
        {
                tank = tank + t;
        }
        // ����
        public void run(double distance)//��ʻ����distance
        {
                tank = tank - (oilConsumption * distance);
        }
}