package com.var.perceptive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    ListView eventListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        ArrayList<events> eventsArrayList = new ArrayList<>();
        eventsArrayList.add(new events("ACCIDENT", R.drawable.accident));
        eventsArrayList.add(new events("EARTHQUAKE", R.drawable.earthquake));
        eventsArrayList.add(new events("EVACUATION OR LOCKDOWN", R.drawable.evacuation));
        eventsArrayList.add(new events("FIRE", R.drawable.fire));
        eventsArrayList.add(new events("FLOODING", R.drawable.flooding));
        eventsArrayList.add(new events("HELICOPTER CIRCLING", R.drawable.helicopter_circling));
        eventsArrayList.add(new events("SIRENS", R.drawable.sirens));
        eventsArrayList.add(new events("EXPLOSION", R.drawable.explosion));
        eventsArrayList.add(new events("GUNFIRE", R.drawable.gun));
        eventsArrayList.add(new events("MAJOR DELAY", R.drawable.major_delay));
        eventsArrayList.add(new events("POLICE ACTIVITY", R.drawable.police_activity));
        eventsArrayList.add(new events("POWER OUTAGE", R.drawable.power_outage));
        eventsArrayList.add(new events("PROTEST", R.drawable.protest));
        eventsArrayList.add(new events("SEVERE WEATHER", R.drawable.severe_weather));
        eventsArrayList.add(new events("STORM", R.drawable.storm));
        eventsArrayList.add(new events("UNKNOWN", R.drawable.unknown));
        eventListView = findViewById(R.id.event_list_view);
        EventsAdapter eventsAdapter = new EventsAdapter(this, eventsArrayList);
        eventListView.setAdapter(eventsAdapter);

        eventListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                events clickedEvent = (events) eventListView.getItemAtPosition(i);
                Intent reportIntent = new Intent(EventActivity.this, ReportMapActivity.class);
                reportIntent.putExtra("eventDesc", clickedEvent.eventDesc);
                EventActivity.this.startActivity(reportIntent);
            }
        });

    }
}
