
public class 최소직사각형 {

	public static void main(String[] args) {
			
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		System.out.println(solution(sizes));
		
	}

	public static int solution(int[][] sizes) {
		int answer = 0;
		int maxRow = 0;
		int maxCol = 0;
		
		for(int i = 0; i < sizes.length; i++) {
			
			int row = sizes[i][0];		// 명함의 가로
			int column = sizes[i][1];	// 명함의 세로
			
			if(column > row) {			// 명함의 가로를 긴부분으로 셋팅
				int temp = column;
				column = row;
				row = temp;
			}
			if(maxRow < row) maxRow = row;	// 명함의 가장 긴 가로 값 구함
			if(maxCol < column) maxCol = column;	// 명함의 가장 긴 세로 값 구함
		}
//		System.out.println("maxRow : " + maxRow + ", maxCol : " + maxCol);
		answer = maxRow * maxCol;
		
		return answer;
	}

}
