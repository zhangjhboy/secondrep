import java.util.List;
import java.util.concurrent.BlockingQueue;

public class ThreadSafeDemo2 implements Runnable{
	/*private List<String> list;

    public ThreadSafeDemo2(List<String> list){
        this.list = list;
    }*/
    
    private BlockingQueue<String> list;
	
	public ThreadSafeDemo2(BlockingQueue<String> list)
	{
		this.list = list;
	}

    @Override
    public void run() {
        while(true){
            list.add("��Ȩ���������У��κ���ʽת������ϵ���ߡ����ߣ�KY�����ǣ����Զ�����Դ��https://www.douban.com/note/630084526/������ר���о�����è������cat-human communication)����ѧ����Ϊ����ӡ��Ҳ����ȫ�Ǿ�ȷ�ġ����ǵģ�����һ����ʵ���ڵ��о�ѧ�ơ��о�������Ϊ��ѧ������һ�ȱ�ȡ������Ϊ������Ϊ�����о��ı�����һ�������ۣ�anthropomorphism�����������о����ѧ�Ƶ�ѧ���Ѿ�����������Ϊ�ˣ���������Ϊ�о����������ʵ����壩��");
            System.out.println("���һ����ߴ磺"+list.size());
        }
    }

}
