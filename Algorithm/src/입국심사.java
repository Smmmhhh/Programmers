import java.util.Arrays;

public class 입국심사 {
	public static void main(String[] args) {
		int n = 6;
		int[] times = { 7, 10 };
		System.out.println(solution(n, times));

	}

	public static long solution(int n, int[] times) {
		Arrays.sort(times); // 배열을 오름차순으로 정렬
		long answer = 0;
		long min = 0; // 최소시간
		long max = times[times.length - 1] * (long)n; // 최대시간(가장 오래걸리는 입국시간 * 인원 수)
		long mid = 0, sum = 0;

		while (min <= max) {
			mid = (min + max) / 2;
			sum = 0;

			// 입국대마다 mid 시간만큼 걸리는 시간
			for (int i = 0; i < times.length; i++)
				sum = sum + (mid / times[i]);

			if (sum < n)	// 심사한 사람이 적을 경우
				min = mid + 1; 
			else { 	// 심사한 사람이 많거나 같을 경우
				max = mid - 1;
				answer = mid;
			}

		}

		return answer;
	}
}
