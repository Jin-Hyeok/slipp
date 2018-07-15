package net.slipp.di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// SpringJUnit4ClassRunner가 di.xml을 읽어들인 다음에 MessageRenderer에 해당하는 인스턴스가 있으면 그 인스턴스를 messageRenderer 변수에다가 주입함  
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/di.xml")
public class MessageRenderTest {
	@Autowired
	private MessageRenderer messageRenderer;
	
	@Test
	public void renderer() {
		messageRenderer.render();
	}

}
