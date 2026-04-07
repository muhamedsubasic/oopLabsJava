package InheritanceLibrary;

public class LibraryItem {
    private String id;
    private String title;
    private int year;

    public LibraryItem(String id, String title, int year){
        this.id = id;
        this.title = title;
        this.year = year;
    }

    public String getId(){ return this.id; }
    public void setId(String id){ this.id = id; }
    public String getTitle(){ return this.title; }
    public void setTitle(String title){ this.title = title; }
    public int getYear(){ return this.year; }
    public void setYear(int year){ this.year = year; }

    public String getSummary(){
        return "[" + this.id + "] " + this.title + " (" + this.year + ")";
    }
}
