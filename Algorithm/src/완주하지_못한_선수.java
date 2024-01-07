import java.util.*;

public class 완주하지_못한_선수 {
	public static void main(String[] args) {
		String[] participant = {"mislav", "stanko", "mislav", "ana"};
		String[] completion = {"stanko", "ana", "mislav"};
			
		System.out.println(solution(participant, completion)); 
	}
	
    public static String solution(String[] participant, String[] completion) {
    	
    	HashMap<String, Integer> hm = new HashMap<>(); 
    	
    	String answer = "";
    	
    	// 참가자 HashMap에 넣어주기
    	for(int i = 0; i < participant.length; i++) {
    		// 동명이인 찾아주기
    		if(!hm.containsKey(participant[i])) hm.put(participant[i], 1);
    		else {
    			int count = hm.get(participant[i]);
    			hm.put(participant[i], ++count);
    		}
    		
    	}
    	
//    	System.out.println(hm);
    	
    	// 완주자 값 변경
    	for(int i = 0; i < completion.length; i++) {
    		if(hm.containsKey(completion[i])) {
    			// 완주 했을 때 값을 -1 차감
    			int count = hm.get(completion[i]);
    			hm.put(completion[i], --count);
    		} 
    	}
//    	System.out.println(hm);
    	
    	// 값이 1이상인 인원 찾아주기
    	for(int i = 0; i < participant.length; i++) {
    		if(hm.get(participant[i]) > 0) {
    			answer = participant[i];
    		}
    	}

        return answer;
    }
}
