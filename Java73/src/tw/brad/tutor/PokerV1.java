package tw.brad.tutor;

public class PokerV1 {

	public static void main(String[] args) {
		int[] poker = new int[10];
		for (int i=0; i<poker.length; i++) {
			int temp = (int)(Math.random()*10);
			
			// 檢查機制
			boolean isRepeat = false;
			for (int j = 0; j < i; j++) {
				if (temp == poker[j]) {
					isRepeat = true;
					break;
				}
			}
			
			if (!isRepeat) {
				poker[i] = temp;
				System.out.println(poker[i]);
			}else {
				i--;
			}
		}
	}

}
