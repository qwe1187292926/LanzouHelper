package entity;

/**
 * 通用实体对象
 * dlLink
 * @author Hoyoung
 */
public class CommonEntity {
    public CommonEntity() {
    }

    public CommonEntity(String dlLink) {
        this.dlLink = dlLink;
    }

    private String dlLink;

    public String getDlLink() {
        return dlLink;
    }

    public void setDlLink(String dlLink) {
        this.dlLink = dlLink;
    }

    @Override
    public String toString() {
        return ", {" +
                "dlLink='" + dlLink + '\'' +
                '}';
    }
}
