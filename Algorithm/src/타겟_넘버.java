
public class 타겟_넘버 {
	public static int count = 0;

	public static void main(String[] args) {
		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		
		System.out.println(solution(numbers, target));
	
	}
	
    public static int solution(int[] numbers, int target) {
        int answer = 0;
        int result = 0;
        int depth = 0;

        dfs(numbers, depth, result, target);
        answer = count;
        
        return answer;
    }
    
    public static void dfs(int[] numbers, int target, int depth, int result) {
    	if(depth == numbers.length) {	//마지막 노드까지 진행했을 때
    		if(target == result) count++; 	// 타겟값과 결과값이 같다면
    		return;
    	}
    	
    	int plus = result + numbers[depth];		//양수를 더한 값
    	int minus = result - numbers[depth];	//음수를 더한 값
    	
    	dfs(numbers, target, depth + 1, plus);	
    	dfs(numbers, target, depth + 1, minus);	
    }
    
}
