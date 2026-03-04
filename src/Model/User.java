package Model;

public abstract class User {
    private String typeUser;
    private boolean harReklamer;
    private boolean kanDownloade;

    public User(String typeUser, boolean harReklamer, boolean kanDownloade) {
        this.typeUser = typeUser;
        this.harReklamer = harReklamer;
        this.kanDownloade = kanDownloade;
    }

    public String gettypeUser(){
        return typeUser;

    }
    public void settypeUser(String typeUser){
        this.typeUser = typeUser;

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

