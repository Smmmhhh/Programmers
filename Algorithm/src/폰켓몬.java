import java.util.HashSet;
import java.util.Set;

public class 폰켓몬 {

	public static void main(String[] args) {
		
		int[] nums = {3,1,2,3};
		System.out.println(solution(nums));

	}
	
    public static int solution(int[] nums) {
        int answer = 0;
        int count = 0;
        Set<Integer> hs = new HashSet<>();
        
        // HashSet 자료구조에 nums 배열의 값 add
        for(int i = 0; i < nums.length; i++) {
        	hs.add(nums[i]);
        }
        
        // N / 2 만큼 폰켓몬을 선택
        count = nums.length / 2;
        
        // 포켓몬 종류보다 더 많이 선택 할 수 있다면 포켓몬 종류를 출력
//        if(count >= hs.size()) answer = hs.size();
//        else answer = count;	// 아니라면 선택할 수 있는 수 출력
        		
        // 폰켓몬 수 구하기
        for(int i = 1; i <= count; i++) {
        	if(i <= hs.size()) answer++;
        }
       
        return answer;
    }

}
