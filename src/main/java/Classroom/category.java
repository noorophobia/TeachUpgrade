package Classroom;

public class category {
    public String id;
    public String name;
 
    public category(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
 
    public String getId() {
        return id;
    }
 
    public void setId(String id) {
        this.id = id;
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}