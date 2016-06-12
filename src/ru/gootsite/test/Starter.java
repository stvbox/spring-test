package ru.gootsite.test;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

public class Starter {
	static ApplicationContext ctx;
	
	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("beans.xml");
		Beeper beeper = ctx.getBean("БИПЕР", Beeper.class);
		Крякер крякер = ctx.getBean("КРЯКЕР", Крякер.class);
		
		ProxyFactory pf = new ProxyFactory();
		pf.addAdvice(new BeepDecprator());
		pf.setTarget(beeper);
		pf.setTarget(крякер);
		Beeper beeperProxy = (Beeper) pf.getProxy();
		Крякер крякерПрокси = (Крякер) pf.getProxy();

		beeperProxy.sayBeep();
		крякерПрокси.sayBeep();
		
		System.out.println("");
		beeper.sayBeep();
		крякер.sayBeep();
		
		/*Beeper tmpBeep = beeper.beeper;
		for(int i = 0 ; i < 1000 ; i++) {
			tmpBeep.sayBeep();
			System.out.println(i);
			tmpBeep = tmpBeep.beeper;
		}*/
		//System.out.println("Конэдз");
	}

}

@Component("БИПЕР")
class Beeper {
	//@Autowired
	//Beeper beeper;
	
	public void sayBeep() {
		System.out.println("BEEP!!!");
	}
}

@Component("КРЯКЕР")
class Крякер extends Beeper {
	//@Autowired
	//Крякер крякер;
	
	public void скажиКряк() {
		System.out.println("Кряк!!!");
	}

	public void sayBeep() {
		скажиКряк();
	}
}

class BeepDecprator implements MethodInterceptor {
	@Override
	public Object invoke(MethodInvocation invocation) throws Throwable {
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		System.out.print("++ ");
		Object result = invocation.proceed(); 
		System.out.println("++++++++++++++++++++++++++++++++++++++");
		return result;
	}
}






