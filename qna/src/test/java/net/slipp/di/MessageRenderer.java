package net.slipp.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MessageRenderer {
//	public void render() {
//		MessageProvider mp = new HelloWorldMessageProvider();
//		System.out.println(mp.getMessage());
//	}
	
	// MessageRenderer가 의존관계에 있는 클래스는 MessageRenderer를 사용하고 있는 클라이언트에서 결
	private MessageProvider messageProvider;
	
	public void setMessageProvider(MessageProvider messageProvider) {
		this.messageProvider = messageProvider;
	}
	
	public void render() {
		System.out.println(messageProvider.getMessage());
	}
	
	public static void main(String[] args) {
//		MessageRenderer renderer = new MessageRenderer();
//		renderer.setMessageProvider(new HelloWorldMessageProvider());
//		renderer.render();
//		
//		renderer.setMessageProvider(new HiWorldMessageProvider());
//		renderer.render();
		
		// di.xml을 읽어서 관리하는 Object class를 ApplicationContext 
		// ApplicationContext는 Interface인데 설정파일을 읽는 구현체가 여러개 인데,
		// 그 중 하나인 classpath에 설정되어있는 xml 해당파일을 읽어서 애플리케이션으로 만들수 있다 
		
		// ClassPathXmlApplicationContex 클래스에 di.xml을 읽은 다음에 설정에 따라서 각 클래스들간의 의존관계를 해
		ApplicationContext ac = new ClassPathXmlApplicationContext("di.xml");
		MessageRenderer renderer = (MessageRenderer)ac.getBean("messageRenderer");
		renderer.render();
	}
}
