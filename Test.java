package arraydemo2;
/**
 * 0-99这100个数字,放在数组中
 * 用其中一个数字替换另一个(随机)
 * 找出这个重复的数字
 * */
import java.util.Random;

public class Test {
	public static void main(String[] args) {
		//定义一个数组
		int[] arr = new int[100];
		//0-99这100个数字,放在数组中
		for(int i=0; i<arr.length; i++) {
			arr[i]=i;
		}

		randomArr(arr);
		showArr(arr);
		System.out.println("---------------------------------");
		//替换
		Random r = new Random();
		int i = r.nextInt(100);
		int j = r.nextInt(100);
		while(i==j) {
			//当两个数的索引一样时,再次随机产生索引,直到索引不一样为止
			 i = r.nextInt(100);
			j = r.nextInt(100);
		}
		arr[i]=arr[j];
		System.out.println("重复的元素是:"+arr[i]);
		//打印数组看一下效果
		showArr(arr);
		System.out.println("---------------------------------");

		//测一下算法执行时间
		long startTime = System.nanoTime();

		fun1(arr);
		System.out.println("---------------------------------");
		fun2(arr);

		long endTime = System.nanoTime();
		System.out.println("运行时间是:"+(endTime-startTime)+"纳秒");
	}

	//方法二,定义一个新数组,以空间换时间
	//把原数组的值作为新数组的索引,将新数组中该索引位置的元素加一,
	//找到数组元素为2的索引值,在旧数组此索引处就是重复的元素
	private static void fun2(int[] arr) {
		int[] newArr = new int[100];
		for(int x=0; x<arr.length; x++) {
			newArr[arr[x]]++;
			if(newArr[arr[x]]==2) {
				System.out.println("重复的元素是:"+arr[x]);
				break;
			}
		}
	}

	//方式一:初学者的想法(效率低)
	//每一个元素和它后面的所有元素作比较
	private static void fun1(int[] arr) {
		flag:for(int i=0; i<arr.length; i++) {
			for(int j=i+1;j<arr.length; j++) {
				if(arr[i]==arr[j]) {
					System.out.println("重复的元素是:"+arr[i]);
					break flag;
				}
			}
		}
	}

	//查看数组
	private static void showArr(int[] arr) {
		int count = 0;
		for(int j=0; j<arr.length; j++){
			System.out.print(arr[j]+"\t");
			if(++count%10==0) {
				System.out.println();
			}
		}
		System.out.println();
	}

	//将数组打乱顺序
	private static void randomArr(int[] arr) {
		for(int k=0;k<1000;k++){
			Random r = new Random();
			int i = r.nextInt(100);
			int j = r.nextInt(100);
			int temp =arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
	}

}
