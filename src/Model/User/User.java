package Model.User;

public abstract class User {
    private String typeUser;
    private boolean hasAdds;
    private boolean canDownload;

    public User(String typeUser, boolean hasAdds, boolean canDownload) {
        this.typeUser = typeUser;
        this.hasAdds = hasAdds;
        this.canDownload = canDownload;
    }

    public String getTypeUser(){
        return typeUser;

    }
    public void setTypeUser(String typeUser){
        this.typeUser = typeUser;

    }

    public boolean getHasAdds(){
        return hasAdds;

    }
    public void setHasAdds(boolean hasAdds){
        this.hasAdds = hasAdds;

    }
    public boolean getCanDownload(){
        return canDownload;

    }
    public void setCanDownload(boolean canDownload){
        this.canDownload = canDownload;
    }


}

