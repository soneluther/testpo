package domain;

public class GuessGameLogic {
	private Integer theNumber;	//自動產生的數字
	private Integer guessCountdown=6;	//可猜的次數
	private String hint;
	
	public Integer getTheNumber() {
		return theNumber;
	}
	public void setTheNumber(Integer theNumber) {
		this.theNumber = theNumber;
	}
	
	public Integer getGuessCountdown() {
		return guessCountdown;
	}
	public void setGuessCountdown(Integer guessCountdown) {
		this.guessCountdown = guessCountdown;
	}
	
	public String getHint() {
		return hint;
	}
	public void setHint(String hint) {
		this.hint = hint;
	}
	
	
	public GuessGameLogic(Integer startNum, Integer endNum) {
		super();
		this.theNumber = getRandomNumber(startNum, endNum);		
	}
	
	public GuessGameLogic(Integer startNum, Integer endNum, Integer guessCountdown) {
		super();
		this.theNumber = getRandomNumber(startNum, endNum);
		this.guessCountdown=guessCountdown;
	}
	
	//亂數產生數字
	private Integer getRandomNumber(Integer startNum, Integer endNum) {
		double range=endNum-startNum+1;
		
		return startNum+(int)(Math.random()*range);
	}
	
	public void init(Integer startNum, Integer endNum) {
		this.theNumber=getRandomNumber(startNum, endNum);
	}
	
	//判斷數字是否相符
	public Boolean isCorrectNum(Integer guessNum) {
		if(guessNum==theNumber) {
			return true;
		}else {
			if(guessNum>theNumber) {
				hint="所猜的數字太大 !";
			}else {
				hint="所猜的數字太小";
			}
			
			guessCountdown--;
			return false;
		}		
	}
}
