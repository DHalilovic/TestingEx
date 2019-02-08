public class Record
{
    private int id;
    private String name;
    private boolean good;
    private int length;

    public Record() {

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
}
