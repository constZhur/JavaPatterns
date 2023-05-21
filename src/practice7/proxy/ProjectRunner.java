package practice7.proxy;

public class ProjectRunner {
    public static void main(String[] args) {
        String url = "https://github.com/constZhur/myProject";

        System.out.println("Работа с проектом напрямую до его запуска: ");
        RealProject realProject = new RealProject(url);
        System.out.println("Запуск проекта напрямую: ");
        realProject.run();

        System.out.println("\n\n");

        System.out.println("Работа с проектом через заместитель до его запуска: ");
        ProxyProject proxyProject = new ProxyProject(url);
        System.out.println("Запуск проекта через заместитель: ");
        proxyProject.run();

    }
}
