import java.util.ArrayList;
import java.util.HashSet;

public class N으로_표현 {

	public static void main(String[] args) {
		
		int N = 5;
		int number = 12;
		System.out.println(solution(N, number));

	}
	
    public static int solution(int N, int number) {
        if (N == number) return 1;
           
    	ArrayList<HashSet<Integer>> dp = new ArrayList<>();
    	
    	// Hashset 초기화
    	for(int i = 0; i <= 8; i++) 
    		dp.add(new HashSet<>());
    	
    	// 숫자 N을 0번 index에 초기화
    	dp.get(1).add(N);
    	
    	for(int i = 2; i <= 8; i++) {
            // N을 i번 사용하여 숫자를 만듭니다.
            // StringBuilder를 사용하여 N을 i번 반복하여 숫자를 생성합니다.
            StringBuilder sb = new StringBuilder().append(N);
            for(int j = 1; j < i; j++) sb.append(N);
            	
            dp.get(i).add(Integer.parseInt(sb.toString()));
            //System.out.println(dp.get(i));
            
         // 숫자를 더하거나 빼는 연산을 적용하여 가능한 숫자들을 생성합니다.
            // dp 리스트를 이용하여 가능한 숫자들을 구합니다.
            // dp[j]와 dp[i-j]에 저장된 숫자들을 이용하여 i에 해당하는 숫자를 만듭니다.
            // 연산 결과를 dp[i]에 추가합니다.
            for (int j = 1; j < i; j++) {
                int k = i - j;
                for (int num1 : dp.get(j)) {
                    for (int num2 : dp.get(k)) {
                        dp.get(i).add(num1 + num2);
                        dp.get(i).add(num1 - num2);
                        dp.get(i).add(num1 * num2);
                        if (num2 != 0) {
                            dp.get(i).add(num1 / num2);
                        }
//                        System.out.println("dp " + i + "번째 index : " + dp.get(i));
                    }
                }
            }
            
            // number가 가능한 숫자들 중에 포함되는지 확인합니다.
            // 만약 number가 포함되어 있다면 i를 반환합니다.
            if (dp.get(i).contains(number)) {
                return i;
            }
    	}
    	
        // number를 표현할 수 없는 경우
        return -1;
    }
}
