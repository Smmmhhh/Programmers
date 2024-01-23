
public class 기능개발 {

	public static void main(String[] args) {

		int[] progresses = { 93, 30, 55 };
		int[] speeds = { 1, 30, 5 };

		int[] solution = solution(progresses, speeds);

		for (int i = 0; i < solution.length; i++)
			System.out.print(solution[i] + " ");

	}

	public static int[] solution(int[] progresses, int[] speeds) {
		int[] sol = new int[progresses.length];
		int[] arr = new int[progresses.length];

		// arr배열에 작업기간 구하기
		for (int i = 0; i < progresses.length; i++) {
			int temp = progresses[i];
			int speed = speeds[i];
			int count = 0;

			while (temp < 100) {
				temp += speed;
				count++;
			}
			arr[i] = count;
		}

		// Two Pointer
		int start = 0;
		int end = 1;
		int idx = 0;

		while (start < arr.length) {

			if (end < arr.length && arr[start] >= arr[end]) // end index range setting
				end++;
			else {
				sol[idx++] = end - start;
				start = end;
				end = start + 1;
			}
		}

		// answer 초기화 및 요소 추가
		int[] answer = new int[idx];
		
		for (int i = 0; i < answer.length; i++)
			answer[i] = sol[i];

		return answer;
	}

}
