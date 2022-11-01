package Deserialization;

//import java.util.List;

public class PojoClass {
    private DataPojo data;
    private SupportClass support;

    public DataPojo getData() {
        return data;
    }

    public void setData(DataPojo data) {
        this.data = data;
    }

    public SupportClass getSupport() {
        return support;
    }

    public void setSupport(SupportClass support) {
        this.support = support;
    }

    @Override
    public String toString() {
        return "PojoClass{" +
                ", data=" + data +
                ", support='" + support + '\'' +
                '}';
    }
}
