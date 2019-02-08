public class Record
{
    private int id;
    private String name;
    private boolean infected;
    private int beepisLength;

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

    public boolean isInfected() {
        return infected;
    }

    public void setInfected(boolean infected) {
        this.infected = infected;
    }

    public int getBeepisLength() {
        return beepisLength;
    }

    public void setBeepisLength(int beepisLength) {
        this.beepisLength = beepisLength;
    }
}
