package th.ac.kmitl.a59070123;

import android.os.Parcel;
import android.os.Parcelable;

public class Register implements Parcelable {
    String user;
    String fname;
    Integer age;
    String pass;

    public Register() {
    }

    public Register(String user, String fname, Integer age, String pass) {
        this.user = user;
        this.fname = fname;
        this.age = age;
        this.pass = pass;
    }

    protected Register(Parcel in){
        user = in.readString();
        fname = in.readString();
        age = in.readInt();
        pass = in.readString();
    }

    public static final Creator<Register> CREATOR = new Creator<Register>() {

        @Override
        public Register createFromParcel(Parcel in) {
            return new Register(in);
        }

        @Override
        public Register[] newArray(int size) {
            return new Register[size];
        }
    };

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(user);
        parcel.writeString(fname);
        parcel.writeInt(age);
        parcel.writeString(pass);

    }
}

