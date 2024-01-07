import java.util.PriorityQueue;

public class 더_맵게 {

	public static void main(String[] args) {
		int[] scoville = { 2, 1, 3, 100, 5, 4 };
		int k = 100;

		System.out.println(solution(scoville, k));

	}

	public static int solution(int[] scoville, int K) {
		// 우선순위 큐 선언
		// 작은수를 찾아야하기 때문에 기본형으로 객체를 생성한다.
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		int answer = 0;
		int temp = 0;
		
		// pq에 배열의 원소 삽입
		for (int i = 0; i < scoville.length; i++) {
			pq.add(scoville[i]);
		}
		
		System.out.println(pq);

		// 스코빌 지수 계산
		while (true) {
			if(pq.size() > 1 && pq.peek() < K) {
				temp = pq.poll() + (pq.poll() * 2); // 스코빌 지수 계산
				pq.add(temp);
				answer++;
			}

			// pq가 비었는데 k보다 스코프가 작을경우 0 리턴
			if ((pq.size() == 1 && pq.peek() < K)) {
				answer = -1;
				break;
			}
			// 스코프가 k이상이 되었을 때
			if (pq.peek() >= K) {
				break;
			}
		}
		return answer;
	}
}
