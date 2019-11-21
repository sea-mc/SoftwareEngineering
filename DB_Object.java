import java.sql.Connection;
import java.util.UUID;

abstract class DB_Object {
    UUID UID;
    static Connection conn;

    public DB_Object(){
        this(UUID.fromString(""));
    }
    public DB_Object(UUID UID){
        this.UID = UID;
    }

    public void setUID(UUID UID) {
        this.UID = UID;
    }

    public UUID getUID() {
        return UID;
    }

    public void ensureUID(){

    }

    public String toString(){
        return "UID: " + UID.toString() + "\n";
    }

}
