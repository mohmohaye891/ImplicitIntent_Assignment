package com.myapplication.implicitintent_assignment;

import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.CalendarContract;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TimerActivity extends AppCompatActivity {

    Button btnSetTimer, btnAddCalendar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        btnSetTimer = findViewById(R.id.btn_set_timer);
        btnSetTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AlarmClock.ACTION_SET_TIMER)
                        .putExtra(AlarmClock.EXTRA_MESSAGE, "My Timer")
                        .putExtra(AlarmClock.EXTRA_LENGTH, 18)
                        .putExtra(AlarmClock.EXTRA_SKIP_UI, false);
                startActivity(intent);
            }
        });

        btnAddCalendar = findViewById(R.id.btn_add_calendar);

        btnAddCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*Calendar cal = new GregorianCalendar();
                cal.setTime(new Date());
                cal.add(Calendar.MONTH, 2);
                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setData(CalendarContract.Events.CONTENT_URI);
                intent.putExtra(CalendarContract.Events.TITLE, "Some Test Event");

              //  intent.putExtra(CalendarContract.Events.ALL_DAY, true);

                intent.putExtra(
                        CalendarContract.EXTRA_EVENT_BEGIN_TIME,
                        cal.getTime().getTime());
                intent.putExtra(
                        CalendarContract.EXTRA_EVENT_END_TIME,
                        cal.getTime().getTime() + 600000);
                intent.putExtra(
                        Intent.EXTRA_EMAIL,
                        "attendee1@yourtest.com, attendee2@yourtest.com");
                startActivity(intent);*/

                Intent intent = new Intent(Intent.ACTION_INSERT);
                intent.setType("vnd.android.cursor.item/event");

                Calendar cal = Calendar.getInstance();
                long startTime = cal.getTimeInMillis();
                long endTime = cal.getTimeInMillis()  + 60 * 60 * 1000;

                intent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, startTime);
                intent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME,endTime);
                intent.putExtra(CalendarContract.EXTRA_EVENT_ALL_DAY, true);

                intent.putExtra(CalendarContract.Events.TITLE, "Neel Birthday");
                intent.putExtra(CalendarContract.Events.DESCRIPTION,  "This is a sample description");
                intent.putExtra(CalendarContract.Events.EVENT_LOCATION, "My Guest House");
                intent.putExtra(CalendarContract.Events.RRULE, "FREQ=YEARLY");

                startActivity(intent);
            }
        });
    }

    public void addEvent(String title, String location, long begin, long end) {
        Intent intent = new Intent(Intent.ACTION_INSERT)
                .setData(CalendarContract.Events.CONTENT_URI)
                .putExtra(CalendarContract.Events.TITLE, title)
                .putExtra(CalendarContract.Events.EVENT_LOCATION, location)
                .putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, begin)
                .putExtra(CalendarContract.EXTRA_EVENT_END_TIME, end);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
