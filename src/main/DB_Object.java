package main;

abstract class DB_Object {
    public int UID;

    public DB_Object(){
        this(-1);
    }

    public DB_Object(int UID){
        this.UID = UID;
    }

    public String toString(){
        return "UID: " + UID + "\n";
    }
}
