package com.javaex.ex01;

public class ThreadApp {

	public static void main(String[] args)throws Exception {
		
		 Thread thread=new DigitThread();//섞어쓰기
		 //DigitThread가 메모리에 올라오면서 자신의 부모도 불러온다.
		 //스레드 실햄--.(비유)출장
		 //thread.run() start가 아닌  run을 사용을 했다면 스헤드를 일시키는건 못했음 
		 thread.start();
		//start라는 메소 드 안에 스레드를 보내고 일을 시키고 마무리 하는 코드가 있다.
        //스레드 끝
		 for (char ch = 'A'; ch <= 'Z'; ch++) {
	            System.out.print(ch);
	            Thread.sleep(1000);//스래드의 작업속도를 조절하는 메소드.
	        }


	}

}
