package Assignmentt10;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alarm {

    FlatFileStorage ffStorage;
    Notifier notifier;
    int alarmType;

    public Alarm(Notifier n, int alarmType) {
        this.notifier = n;
        this.alarmType = alarmType;
        validateFileExists();
        ffStorage = FlatFileStorage.getInstance("storage.santo");
        init();
    }

    private void init() {
        long[] savedAlarms = ffStorage.getAll();
        int i = 1;
        if (this.alarmType == 0 && savedAlarms[0] > 20) {
            i = 0;
            try {
                this.SetAlarm(savedAlarms[i] + "");
            } catch (ParseException ex) {
                Logger.getLogger(Alarm.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (savedAlarms[1] > 20 && this.alarmType == 3) {
            try {
                this.SetAlarm(savedAlarms[i] + "");
            } catch (ParseException ex) {
                Logger.getLogger(Alarm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void validateFileExists() {
        File localStore = new File("storage.santo");
        try {
            localStore.createNewFile(); // if file already exists will do nothing 
        } catch (IOException ex) {
            Logger.getLogger(Alarm.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String SetAlarm(String alarmTime) throws ParseException {

        long timeTo = stringDateToMillis(alarmTime);
        ffStorage.save(alarmTime, this.alarmType);

        if (timeTo > 0) {//alarm is in the future

            notifyIn(timeTo, 86400 /*24HoursInMillis*/, notifier, alarmType);
            return "Alarm Set";
        }

        return "Alarm Not Set";

    }

    public void notifyIn(long milliSeconds, long duration, Notifier n,
            int alarmType) {

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                n.notify(alarmType);
            }
        }, milliSeconds, milliSeconds + duration);
    }

    public long stringDateToMillis(String alarmTime) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("MMddyyyyHHmm");
        Date d = formatter.parse(alarmTime);
        return d.getTime();
    }
}
