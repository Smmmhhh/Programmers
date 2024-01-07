import java.util.Arrays;

public class K번째수 {
	public static void main(String[] args) {
		
		int[] array= {1, 5, 2, 6, 3, 7, 4};
		int[][] commands= {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
		
		 int[] answer = solution(array, commands);
		 
		 // answer 출력
		 for(int e : answer) {
			 if(answer.length != e)
				 System.out.print(e + ",");
			 else
				 System.out.print(e);
		 }

	}
	
    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];
      
        // commands 배열 만큼 케이스 반복
        for(int i = 0; i < commands.length; i++) {
        	int[] temp = new int[commands[i][1] - commands[i][0] + 1];	// temp 배열 초기화
        	int count = 0;
        	// commands의 첫번째 요소부터 두번째 요소까지 반복
        	for(int j = commands[i][0] - 1; j <= commands[i][1] - 1 ; j++) {
        		temp[count++] = array[j];
        	}
        	Arrays.sort(temp);	// temp 배열 정렬 
    		answer[i] = temp[commands[i][2]-1];	// temp배열의 결과값을 answer배열에 추가
        }
        return answer;
    }
}
