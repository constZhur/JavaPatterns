package practice6.abctactFactory;

import practice6.abctactFactory.banking.BankingTeamFactory;
import practice6.abctactFactory.mobileProject.MobileTeamFactory;
import practice6.abctactFactory.website.WebsiteTeamFactory;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int choice;
        ProjectTeamFactory projectTeamFactory;
        Scanner scanner = new Scanner(System.in);
        System.out.print("Выберите какой проект вы хотите создать:\n1 - банковское приложение\n" +
                "2 - вэбсайт\n3 - мобильное приложение\n> ");
        choice = scanner.nextByte();
        if (choice == 1) {
            projectTeamFactory = new BankingTeamFactory();
        } else if (choice == 2){
            projectTeamFactory = new WebsiteTeamFactory();
        } else if (choice == 3){
            projectTeamFactory = new MobileTeamFactory();
        } else throw new IllegalArgumentException("Некорректный ввод. Попробуйте еще раз!");
        Developer developer = projectTeamFactory.getDeveloper();
        Tester tester = projectTeamFactory.getTester();
        ProjectManager projectManager = projectTeamFactory.getProjectManager();
        if (choice == 1) {
            System.out.println("Создание банковского приложения...");
        } else if (choice == 2){
            System.out.println("Создание вэбсайта...");
        } else {
            System.out.println("Создание мобильного приложения...");
        }
        developer.writeCode();
        tester.testCode();
        projectManager.manageProject();
        System.out.println("Проект готов!");


    }
}
