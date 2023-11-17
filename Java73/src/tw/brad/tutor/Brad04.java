package tw.brad.tutor;

public class Brad04 {

	public static void main(String[] args) {
		double temp = Math.random();
		//System.out.println(temp);
		
		String grade = "";
		boolean isPass = false;
		int score = (int)(temp * 101) ;
		if (score >= 90) {
			grade = "A"; isPass = true;
		}else if (score >= 80) {
			grade = "B"; isPass = true;
		}else if (score >= 70) {
			grade = "C"; isPass = true;
		}else if (score >= 60) {
			grade = "D"; isPass = true;
		}else {
			grade = "E"; isPass = false;
		}
		System.out.printf("%d : %s : %s", score, grade, isPass?"Pass":"Down");	
		
		
		
	}

}
