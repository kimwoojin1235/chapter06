package com.javaex.ex02;

public class UpperThread extends Thread{

	@Override
	public void run() {
		for (char ch = 'A'; ch <= 'Z'; ch++) {
	        System.out.print(ch);
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}//스래드의 작업속도를 조절하는 메소드.
	    }
	}
	
	
}
