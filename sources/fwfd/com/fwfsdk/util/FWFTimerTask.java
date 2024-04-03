package fwfd.com.fwfsdk.util;

import android.os.SystemClock;
import fwfd.com.fwfsdk.FunWithFlags;
import fwfd.com.fwfsdk.manager.FWFDataManager;
import java.util.Timer;
import java.util.TimerTask;

public class FWFTimerTask {
    private static FWFTimerTask _instance;
    /* access modifiers changed from: private */
    public boolean isActive = true;
    /* access modifiers changed from: private */
    public long startTime = 0;
    private Timer timer = new Timer();

    private int getElapsedTime() {
        return Math.round((float) (SystemClock.elapsedRealtime() - this.startTime));
    }

    public static synchronized FWFTimerTask getInstance() {
        FWFTimerTask fWFTimerTask;
        synchronized (FWFTimerTask.class) {
            if (_instance == null) {
                _instance = new FWFTimerTask();
            }
            fWFTimerTask = _instance;
        }
        return fWFTimerTask;
    }

    /* access modifiers changed from: private */
    public void updateFeatures() {
        FWFDataManager.getInstance().updateSubscribedFeatures();
    }

    public long getStartTime() {
        return this.startTime;
    }

    public Timer getTimer() {
        return this.timer;
    }

    public void restartTimer() {
        if (((long) getElapsedTime()) >= FunWithFlags.getInstance().getFeatureExpirationTime().longValue() * 1000) {
            this.timer.cancel();
            this.timer = new Timer();
            startTimer();
        }
    }

    public void restartTimerOnFeatureExpirationTimeChanged() {
        this.timer.cancel();
        this.timer = new Timer();
        startTimer();
    }

    public void setActive(boolean z11) {
        this.isActive = z11;
    }

    public void startTimer() {
        this.timer.cancel();
        Timer timer2 = new Timer();
        this.timer = timer2;
        timer2.scheduleAtFixedRate(new TimerTask() {
            public void run() {
                if (FWFTimerTask.this.isActive) {
                    long unused = FWFTimerTask.this.startTime = SystemClock.elapsedRealtime();
                    FWFTimerTask.this.updateFeatures();
                }
            }
        }, 0, FunWithFlags.getInstance().getFeatureExpirationTime().longValue() * 1000);
    }

    public void stopTimer() {
        this.timer.cancel();
    }
}
