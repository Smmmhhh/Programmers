import java.util.Arrays;
import java.util.HashMap;

public class 체육복 {

	public static void main(String[] args) {

		int n = 5;
		int[] lost = { 4,2 };
		int[] reserve = { 3,5 };

		System.out.println(solution(n, lost, reserve));

	}

	public static int solution(int n, int[] lost, int[] reserve) {

		HashMap<Integer, Integer> hm = new HashMap<>();
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		int answer = 0;

		// 전체 인원 넣어주기
		for (int i = 0; i < n; i++) {
			hm.put(i + 1, 1);
		}

		// 체육복 여벌이 있는 인원은 +1
		for (int i = 0; i < reserve.length; i++) {
			if (hm.containsKey(reserve[i])) {
				hm.put(reserve[i], hm.get(reserve[i]) + 1);
			}
		}

		System.out.println("여벌 체육복 인원" + hm);

		// 도둑맞은 체육복 주인 제거
		for (int i = 0; i < lost.length; i++) {
			if (hm.containsKey(lost[i])) {
				hm.put(lost[i], hm.get(lost[i]) - 1);
			}
		}

		System.out.println("도둑 맞은 체육복" + hm);

		// 체육복 빌려주기
		for (int i = 0; i < lost.length; i++) {
			int left = lost[i] - 1;
			int right = lost[i] + 1;

			while ((hm.get(lost[i]) == 0) && (hm.containsKey(left) || hm.containsKey(right))) {
				boolean result = false;
				// 왼쪽 인원 여벌 조사
				if (hm.containsKey(left) && hm.get(left) >= 2) {
					hm.put(left, hm.get(left) - 1); // 여벌이 있는 학생의 수량 -1
					hm.put(lost[i], hm.get(lost[i]) + 1); // 빌린 학생의 수량 +1
					result = true;
					break;
				}
				// 오른쪽 인원 여벌 조사
				if (hm.containsKey(right) && hm.get(right) >= 2) {
					hm.put(right, hm.get(right) - 1); // 여벌이 있는 학생의 수량 -1
					hm.put(lost[i], hm.get(lost[i]) + 1); // 빌린 학생의 수량 +1
					result = true;
					break;
				}
				if(!result) break;
			}
		}

		System.out.println("빌려준 뒤 결과" + hm);

		// 체육복이 있는 인원 출력
		for (int i = 0; i < n; i++) {
			if (hm.get(i + 1) > 0)
				answer++;
		}

		return answer;
	}

}
