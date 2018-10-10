package android.shinetech.com.tradereport.Bean;

public class Report {
    public int id ;
    public  int categoryId;
    public  String categoryName;
    public  String description;
    public  String reportName;




    public  Report( int id, int categoryId, String categoryName, String reportName , String description){

        this.id = id;
        this.categoryId = categoryId;
        this.categoryName = categoryName;
        this.reportName = reportName;
        this.description = description;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getReportName() {
        return reportName;
    }

    public void setReportName(String reportName) {
        this.reportName = reportName;
    }


    public String getDescripation() {
        return description;
    }

    public void setDescripation(String descripation) {
        this.description = descripation;
    }


}
