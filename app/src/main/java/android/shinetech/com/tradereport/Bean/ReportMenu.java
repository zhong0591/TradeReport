package android.shinetech.com.tradereport.Bean;

public class ReportMenu {
    public String getName() {
        return name;
    }


    public String getId() {
        return id;
    }

    public int getImage() {
        return image;
    }
    public  String name;
    public  String id;
    public  int image;

    public ReportMenu( String id, String name,int image) {
        this.name = name;
        this.id = id;
        this.image = image;
    }

}
