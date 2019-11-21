abstract class DB_Object {
    int UID;

    public DB_Object(){
        this(-1);
    }
    public DB_Object(int UID){
        this.UID = UID;
    }

    public void setUID(int UID) {
        this.UID = UID;
    }

    public int getUID() {
        return UID;
    }

    public abstract void ensureUID();

}
