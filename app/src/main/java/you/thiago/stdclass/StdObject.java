package you.thiago.stdclass;

import android.os.Parcel;
import android.os.Parcelable;

@SuppressWarnings({"unused", "WeakerAccess"})
public class StdObject implements Parcelable, IStdObject {

    private int id;
    private String name;
    private String extra;
    private boolean defaultValue;

    public StdObject(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public StdObject(Integer id, String name, boolean defaultValue) {
        this.id = id;
        this.name = name;
        this.defaultValue = defaultValue;
    }

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean isDefaultValue() {
        return defaultValue;
    }

    @Override
    public void setDefaultValue(boolean defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String getExtra() {
        return extra;
    }

    public StdObject setExtra(String extra) {
        this.extra = extra;
        return this;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(name);
        dest.writeString(extra);
        dest.writeByte((byte) (defaultValue ? 1 : 0));
    }

    private StdObject(Parcel in) {
        id = in.readInt();
        name = in.readString();
        extra = in.readString();
        defaultValue = in.readByte() != 0;
    }

    public static final Creator<StdObject> CREATOR = new Creator<StdObject>() {
        @Override
        public StdObject createFromParcel(Parcel in) {
            return new StdObject(in);
        }

        @Override
        public StdObject[] newArray(int size) {
            return new StdObject[size];
        }
    };
}
