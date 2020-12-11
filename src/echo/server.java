package echo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
	public static void main(String[] args)throws IOException {
		//1번서버소켓을 만들어서 메모리에 올림
		ServerSocket serverSocket=new ServerSocket();
		//2번(bin)ip         포트번호 설정
		//  192.168.219.160  10001
		serverSocket.bind(new InetSocketAddress("192.168.219.160",10001));
		//InetSocketAddress통해서 바인드 즉 세팅을 해라 누군가 들어오면 반응함
		//아이피 주소랑 포트번호 를 알려줌
		
		System.out.println("<서버시작>");
		System.out.println("===============================");
		System.out.println("[연결을 기다리고 있습니다.]");
		
		//5번accept
		Socket socket = serverSocket.accept();
		System.out.println("[클라이언트가 연결 되었습니다.]");
		//socket<-->socket연결 클라이언트의 소캣과 서버의 소켓이 연결이됨
		//메시지 받기용 스트림
		InputStream is = socket.getInputStream();
		//문자열을 받는 통로
		InputStreamReader isr=new InputStreamReader(is, "UTF-8");
		//받은 문자열을 번역
		BufferedReader br=new BufferedReader(isr);
		//받은 문자열을 모아서 출력
		//메세지 보내기용 스트림
		OutputStream os=socket.getOutputStream();
		OutputStreamWriter osw=new OutputStreamWriter(os, "UTF-8");
		BufferedWriter bw=new BufferedWriter(osw);
		
		//반복구간
		while (true) {
			
			//메세지 받기
			String msg= br.readLine();
			//메세지를 받는 곳이 반복이 되어야 한다.
			if(msg==null) {//들어오는 것이 아무것도 없다면
				break;
			}
			System.out.println("받은 메시지:"+msg);
			//메세지를 출력하는 구간도 반복이 되어야 한다.
			//메세지 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
		}
		//자원종료 자원을 종료하기 때문에 반복문 안에 못들어감
		bw.close();
		br.close();
		//서버는 현재 입력받은 값을 출력만 한다 그래서 업데이트 필요 ㄴㄴ
		System.out.println("===========================");
		System.out.println("<서버종료>");
		serverSocket.close();
	}
}
