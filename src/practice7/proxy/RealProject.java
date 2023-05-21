package practice7.proxy;

public class RealProject implements IProject {
    private String url;

    public RealProject(String url){
        this.url = url;
        load();
    }

    private void load(){
        System.out.println("Был скачен проект по следующей ссылке: " + url);
    }

    @Override
    public void run() {
        System.out.println("Проект " + url + " был запущен!");
    }
}
