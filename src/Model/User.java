package Model;

public abstract class User {
    private String title;
    private Genrer genrer;
    private boolean harReklamer;
    private boolean kanDownloade;

    public User(String title, Genrer genrer, boolean harReklamer, boolean kanDownloade) {
        this.title = title;
        this.genrer = genrer;
        this.harReklamer = harReklamer;
        this.kanDownloade = kanDownloade;
    }

    public String getTitle(){
        return title;

    }
    public void setTitle(String title){
        this.title = title;

    }

    public boolean getHarReklamer(){
        return harReklamer;

    }
    public void setHarReklamer(boolean harReklamer){
        this.harReklamer = harReklamer;

    }
    public boolean getKanDownloade(){
        return kanDownloade;

    }
    public void setKanDownloade(boolean kanDownloade){
        this.kanDownloade = kanDownloade;
    }


    
}
