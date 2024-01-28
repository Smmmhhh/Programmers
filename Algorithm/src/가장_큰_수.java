import java.util.Arrays;
import java.util.Comparator;

public class 가장_큰_수 {

	public static void main(String[] args) {

		int[] numbers = { 3, 30, 34, 5, 9 };
		System.out.println(solution(numbers));

	}

	public static String solution(int[] numbers) {
		String answer = "";
		String[] arr = new String[numbers.length];

		// int배열 -> String 배열
		for (int i = 0; i < numbers.length; i++) {
			arr[i] = String.valueOf(numbers[i]);
		}

		// 내림차순 정렬
		Arrays.sort(arr, new Comparator<String>() {
			@Override
			// compare 메서드는 두 문자열 a와 b를 비교하여 정렬 순서를 결정
			public int compare(String a, String b) {
				// 먼저, b + a와 a + b라는 두 개의 문자열을 생성 후 compareTo 메소드를 이용해서 비교 
				// ex) a = 1, b = 20 => 120, 201을 비교 후 첫번째 문자열이 두번째 문자열보다 비교 후 
				// 크면 양수, 작으면 음수, 같으면 0을 return
				return (b + a).compareTo(a + b);
			}
		});

		// 0값이 중복일 경우
		if (arr[0].equals("0"))
			return "0";
		
		// 문자열 더해주기
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < arr.length; i++)
			sb.append(arr[i]);
		
		answer = sb.toString();

		return answer;
	}

}
