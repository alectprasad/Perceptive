package com.var.perceptive;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alectprasad on 22/01/18.
 */

public class EventsAdapter extends ArrayAdapter<events> {
    public EventsAdapter(@NonNull Context context, ArrayList<events> eventsArray) {
        super(context, 0, eventsArray);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, @NonNull ViewGroup parent) {
        events currentEvent = getItem(position);
        View eventsListItemView = convertView;
        if(eventsListItemView == null) {
            eventsListItemView = LayoutInflater.from(getContext()).inflate(R.layout.event_list_item, parent, false);
        }
        TextView eventDesc = eventsListItemView.findViewById(R.id.event_desc);
        ImageView eventImage = eventsListItemView.findViewById(R.id.event_image);
        if(currentEvent != null){
            eventDesc.setText(currentEvent.eventDesc);
            eventImage.setImageResource(currentEvent.eventImageID);
        }
        return eventsListItemView;
    }
}
