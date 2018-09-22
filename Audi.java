import java.util.Scanner;
public class Audi
{
        public static void main(String[] args)
        {
                int i = 0;
	int num = 10;//车辆数量
	Scanner input = new Scanner(System.in);
	Audi[] array = new Audi[num];
	//输入车辆信息
	for (i = 0; i < num; i++)
	{
	        array[i] = new Audi();
                        System.out.println("请输入第" + (i + 1) + "辆汽车的信息：");
	        System.out.println("汽车型号：");
	        array[i].model = input.next();
	        System.out.println("当前油量：");
	        array[i].tank = input.nextDouble();
	        System.out.println("油耗：");
	        array[i].oilConsumption= input.nextDouble();
	}
	//输出车辆信息
	for (i = 0; i < num; i++)
                {
	        System.out.println("第" + (i + 1) + "辆车的信息");
	        System.out.println("汽车型号：" + array[i].model + "  " + "当前油量：" + array[i].tank + "  " + "油耗：" + array[i].oilConsumption);
                }
        }
        public String model;//汽车型号
        public double tank;//当前油量（L）
        public double oilConsumption;//每100km的耗油（L）
        public Audi()
        {
                model = "奥迪A3";
                tank = 25.0;
                oilConsumption = 5.70;
        }
        //加油
        public void gas(double t)//加油量t
        {
                tank = tank + t;
        }
        // 开车
        public void run(double distance)//行驶距离distance
        {
                tank = tank - (oilConsumption * distance);
        }
}