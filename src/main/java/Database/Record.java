package Database;

public class Record implements Comparable<Record>
{
    private int id;
    private String name;
    private boolean good;
    private int length;

    public Record(int id, String name, boolean good, int length) {
        this.id = id;
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
        return name.compareTo(o.getName());
    }
}
