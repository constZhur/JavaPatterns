package project;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.interfaces.Politician;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Введите какого политика вы хотите позвать на международный форум: ");
		String name = scanner.nextLine();
		ClassPathXmlApplicationContext context =
				new ClassPathXmlApplicationContext("applicationContext.xml");
		Politician politician = context.getBean(name.toLowerCase(), Politician.class);
		System.out.print("Отлично! ");
		politician.doPolitic();
		System.out.println(", будет присутствовать на форуме!");
		context.close();
	}
}
