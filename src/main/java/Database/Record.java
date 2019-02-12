package Database;

public class Record implements Comparable<Record>
{
    private int id;
    private String name;
    private Boolean good;
    private Integer length;

    public Record(String name, Boolean good, Integer length) {
        this.name = name;
        this.good = good;
        this.length = length;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGood() {
        return good;
    }

    public void setGood(boolean good) {
        this.good = good;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int compareTo(Record o) {
        return length.compareTo(o.getLength());
    }
}
