package TechnicalTrain;
import java.util.*;
public class Exp_8 {
	private static Scanner sc;
	public static void main(String[] args) {
		sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			HashSet<Integer> map = new HashSet<Integer>();
			for (int j = 0; j < n; j++) {
				map.add(sc.nextInt());
			}
			System.out.println(getMultSum(map, k));
		}
	}

	private static int getMultSum(HashSet<Integer> map, int k) {
		Iterator<Integer> it = map.iterator();
		boolean[] sum = new boolean[k + 1];
		Arrays.fill(sum, false);
		sum[0] = true;
		int a = 0;
		for (int i = 0; i <= k; i++) {

			if (sum[i] == true) {
				it = map.iterator();
				while (it.hasNext()) {
					a = it.next();
					if ((i + a) <= k)
						sum[i + a] = true;
				}
			}
		}
		for(int i=k;i>=0;i--){
			if(sum[i] == true){
				return i;
			}
		}
		return 0;
	}
}
