/*
LS class which was created in order to enter a single load shedding string and store the values of value(stage, day and time) and the area
Initializes all getter and setter commands as well as a toString command
 */
public class LS implements Comparable<LS> {

    private String value, area;

    public LS(String value, String area){
        this.value = value;
        this.area = area;
    }

    public LS() {
    }

    public String getValue() {
        return value;
    }

    public String getArea() {
        return area;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String toString(){
        return "Stage,Day,Time: "+value+"\nArea: "+area+"\n";
    }
    public int compareTo(LS key){
        return value.compareTo(key.value);
    }

}
