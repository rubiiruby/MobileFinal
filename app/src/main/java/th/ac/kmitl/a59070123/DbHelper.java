package th.ac.kmitl.a59070123;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;


public class DbHelper extends SQLiteOpenHelper {

    private final String TAG = getClass().getSimpleName();
    private SQLiteDatabase sqLiteDatabase;

    public DbHelper(Context context) {
        super(context, "sleep.db", null, 1);

    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_REGIS_TABLE = "CREATE TABLE regis ( id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "user TEXT, name TEXT, age INTEGER, pass TEXT)";
        db.execSQL(CREATE_REGIS_TABLE);

        }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        onCreate(db);
    }

    public ArrayList<Register> getRegisList() {
        ArrayList<Register> sleeps = new ArrayList<>();
        sqLiteDatabase = this.getWritableDatabase();

        Cursor cursor = sqLiteDatabase.query
                ("sleep", null, null, null, null, null, "date desc");

        if (cursor != null) {
            cursor.moveToFirst();
        }

        while(!cursor.isAfterLast()) {
            Register sleep = new Register(String.valueOf(cursor.getString(0)),cursor.getString(1), cursor.getInt(2), cursor.getString(3));
            sleeps.add(sleep);
            cursor.moveToNext();
        }
        sqLiteDatabase.close();
        return sleeps;
    }

    public void addRegis(Register register){
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put("user", register.getUser());
        values.put("fname", register.getFname());
        values.put("age", register.getAge());
        values.put("pass", register.getPass());
        sqLiteDatabase.insert("sleep", null, values);
        sqLiteDatabase.close();
    }

    public void updateRegis(Register register, String ID) {
        sqLiteDatabase = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("user", register.getUser());
        values.put("fname", register.getFname());
        values.put("age", register.getAge());
        values.put("pass", register.getPass());
        sqLiteDatabase.update("sleep", values, "id="+ID, null );
        sqLiteDatabase.close();
    }


}



