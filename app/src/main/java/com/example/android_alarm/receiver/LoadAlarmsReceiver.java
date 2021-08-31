package com.example.android_alarm.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.android_alarm.data.model.Alarm;
import com.example.android_alarm.service.LoadAlarmsService;

import java.util.ArrayList;

public final class LoadAlarmsReceiver extends BroadcastReceiver {

    private OnAlarmsLoadedListener mListener;

    @SuppressWarnings("unused")
    public LoadAlarmsReceiver(){}

    public LoadAlarmsReceiver(OnAlarmsLoadedListener listener){
        mListener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        final ArrayList<Alarm> alarms =
                intent.getParcelableArrayListExtra(LoadAlarmsService.ALARMS_EXTRA);
        mListener.onAlarmsLoaded(alarms);
    }

    public void setOnAlarmsLoadedListener(OnAlarmsLoadedListener listener) {
        mListener = listener;
    }

    public interface OnAlarmsLoadedListener {
        void onAlarmsLoaded(ArrayList<Alarm> alarms);
    }

}
