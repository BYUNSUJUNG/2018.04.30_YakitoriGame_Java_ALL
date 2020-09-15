package Yakitori;

import java.util.Scanner;

public class Yakitori implements Root {	


	   static Scanner scan = new Scanner(System.in);

	   int yakitoriSelect=0;
	   
	   int  firstNum;
	   int  secondNum; 
	   int thirdNum;	
	   
	   // 손님
	   public void customer() {
		   // 랜덤으로 출력되는 야끼토리 = 손님이 원하는 야끼토리
		   // 랜덤으로 출력되는 야끼토리의 구성대로 야끼토리를 만들어내면 점수가 올라간다.
		   YakitoriScore.score+=1;
	   }
	   
	   //요리행동
	   public void cooking() {
		   // 랜덤으로 출력되는 야끼토리 재료 구성과 같이 야끼토리의 재료를 선택한다
		   
		   // vegetableNum = 1
		   // chickenNum = 0
		   
		   if(yakitoriSelect==0) {
				if(firstNum==1&&secondNum==1&&thirdNum==1) customer();
				System.out.println(YakitoriScore.score);
			} else if (yakitoriSelect==1) {
				if(firstNum==1&&secondNum==1&&thirdNum==0) customer();
				System.out.println(YakitoriScore.score);
			} else if (yakitoriSelect==2) {
				if(firstNum==1&&secondNum==0&&thirdNum==1) customer();
				System.out.println(YakitoriScore.score);
			} else if (yakitoriSelect==3) {
				if(firstNum==0&&secondNum==1&&thirdNum==1) customer();
				System.out.println(YakitoriScore.score);
			} else if (yakitoriSelect==4) {
				if(firstNum==1&&secondNum==0&&thirdNum==0) customer();
				System.out.println(YakitoriScore.score);
			} else if (yakitoriSelect==5) {
				if(firstNum==0&&secondNum==1&&thirdNum==0) customer();
				System.out.println(YakitoriScore.score);
			} else if (yakitoriSelect==6) {
				if(firstNum==0&&secondNum==0&&thirdNum==1) customer();
				System.out.println(YakitoriScore.score);
			} else if (yakitoriSelect==7) {
				if(firstNum==0&&secondNum==0&&thirdNum==0) customer();
				System.out.println(YakitoriScore.score);
			}
	   }
	   
	   // 야끼토리 재료 구성을 랜덤으로 출력한다
	   // 손님이 원하는 야끼토리 구성
	   public void ingredient() {
		   yakitoriSelect=(int)(Math.random()*8)+1;
	   }

	   
	   // 데이터베이스에 저장에 점수를 저장할 아이디 입력
	   public static void idInput() {
			System.out.print("아이디 입력: ");
			YakitoriScore.id = scan.nextLine();
	   }


	   
}

