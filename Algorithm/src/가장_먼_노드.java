import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 가장_먼_노드 {
	
	static ArrayList<Integer>[] graph;
	static int[] arr;
	static boolean[] visit;
	
	public static void main(String[] args) {
		
		int n = 6;
		int[][] edge = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
		System.out.println(solution(n, edge));
	}
	
    public static int solution(int n, int[][] edge) {
        int answer = 0;
        
        graph = new ArrayList[n+1];
        arr = new int[n+1];
        visit = new boolean[n+1];
        
        // ArrayList 초기화
        for(int i = 1; i <= n; i++) {
        	graph[i] = new ArrayList<>();
        }
        // 인접 리스트 연결
        for(int i = 0; i < edge.length; i++) {
        	int a = edge[i][0];
        	int b = edge[i][1];
        	graph[a].add(edge[i][1]);
        	graph[b].add(edge[i][0]);
        }
        
        bfs(1);	// 1번 노드부터 검사 시작
        
        // bfs 수행 이후 arr배열에 가장 큰 노드를 기준으로 같은 값 추출
        Arrays.sort(arr);
        
        int max = arr[n];
        
        for(int i = 1; i <= n; i++) {
        	if(max == arr[i]) answer++;
        }
        
        return answer;
    }
    
    private static void bfs(int start) {
    	
    	Queue<Integer> qu = new LinkedList<>();
    	visit[start] = true;	
    	qu.add(start);
    	
    	while(!qu.isEmpty()) {
    		int temp = qu.poll();
//    		System.out.println(temp + " ");
    		for(int e : graph[temp]) {
    			if(!visit[e]) {
    				visit[e] = true;
    				qu.add(e);
    				arr[e] = arr[temp] + 1;		
    			}
    		}

    	}	
    }

}
