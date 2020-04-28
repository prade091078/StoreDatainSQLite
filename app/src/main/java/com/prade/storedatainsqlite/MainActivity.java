package com.prade.storedatainsqlite;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    try
    {
        SQLiteDatabase myDB = this.openOrCreateDatabase("MyTestDB", MODE_PRIVATE, null);
        myDB.execSQL("CREATE TABLE IF NOT EXISTS FestivalNames (name VARCHAR,month INT(2))");
        myDB.execSQL("INSERT INTO FestivalNames VALUES ('PONGAL',01) ");
        myDB.execSQL("INSERT INTO FestivalNames VALUES ('NEW YEAR',01) ");
        myDB.execSQL("INSERT INTO FestivalNames VALUES ('DIWALI',10) ");
        myDB.execSQL("INSERT INTO FestivalNames VALUES ('RAMZAN',06) ");
        myDB.execSQL("INSERT INTO FestivalNames VALUES ('CHRISTMAS',12) ");

        Cursor c = myDB.rawQuery("SELECT * FROM FestivalNames",null );

        int name = c.getColumnIndex("name");
        int age = c.getColumnIndex("month");

        c.moveToFirst();

        while (c != null) {
            Log.i("FESTIVALName - Month", c.getString(name) + "-"+Integer.toString(c.getInt(age)));
            c.moveToNext();
        }

        c.close();
    }
    catch(Exception e)
    {
        e.printStackTrace();
    }

    }
}
