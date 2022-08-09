package entity;

/**
 * 蓝奏云实体对象
 * @author Hoyoung
 */
public class LanzouEntity extends CommonEntity {
    public LanzouEntity() {
    }

    public LanzouEntity(String name, String size, String dl) {
        this.name = name;
        this.size = size;
        this.setDlLink(dl);
    }

    private String name;
    private String size;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "LanzouEntity{" +
                "name='" + name + '\'' +
                ", size='" + size + '\'' +
                "} " + super.toString();
    }
}
