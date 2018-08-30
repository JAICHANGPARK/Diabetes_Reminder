package com.dreamwalker.provierchecker;

import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class HomeActivity extends AppCompatActivity {

    private static final String TAG = "HomeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Log.e(TAG, "onCreate: " + " Hello ");

        Uri uri = Uri.parse("com.dreamwalker.diabetesreminder");
        String[] projection = {
                AlarmReminderContract.AlarmReminderEntry._ID,
                AlarmReminderContract.AlarmReminderEntry.KEY_TITLE,
                AlarmReminderContract.AlarmReminderEntry.KEY_DATE,
                AlarmReminderContract.AlarmReminderEntry.KEY_TIME,
                AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT,
                AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_NO,
                AlarmReminderContract.AlarmReminderEntry.KEY_REPEAT_TYPE,
                AlarmReminderContract.AlarmReminderEntry.KEY_ACTIVE

        };

        Cursor cursor = getContentResolver().query(AlarmReminderContract.AlarmReminderEntry.CONTENT_URI, projection, null,null,null);

        if (cursor != null){
            while (cursor.moveToNext()){
                Log.e(TAG, "onCreate: " + cursor.getString(1));
            }
            cursor.close();
        }

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
