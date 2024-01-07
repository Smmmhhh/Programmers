import java.util.Stack;

public class 같은_숫자는_싫어 {

	public static void main(String[] args) {

		int[] arr = { 1, 1, 3, 3, 0, 1, 1 };

		arr = solution(arr);

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

	}

	public static int[] solution(int[] arr) {
		int[] answer = {};
		
		// 스택 선언
		Stack<Integer> st = new Stack<>();

		// 가장 초기에 스택에 첫번째 원소를 넣어줌
		st.add(arr[0]);

		for (int i = 0; i < arr.length; i++) {
			// 스택의 가장 상단 값과 배열 값을 비교 후 같지 않을 때만 스택에 저장
			if (!st.isEmpty() && (st.peek() != arr[i])) {
				st.add(arr[i]);
			}
		}
		// answer 배열을 스택 사이즈로 초기화
		answer = new int[st.size()];
		
		// 배열의 역순부터 스택의 첫번째 요소를 저장
		for(int i = st.size()-1; i >= 0; i--) {
			answer[i] = st.pop();
		}

		return answer;
	}

}
