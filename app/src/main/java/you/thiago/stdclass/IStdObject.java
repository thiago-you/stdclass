package you.thiago.stdclass;

public interface IStdObject {
    int getId();
    String getName();
    String getExtra();
    void setDefaultValue(boolean isDefaultValue);
    boolean isDefaultValue();
}
