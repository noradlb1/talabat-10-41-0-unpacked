package md;

import com.instabug.library.settings.SettingsManager;

public final /* synthetic */ class a implements Runnable {
    public final void run() {
        SettingsManager.getInstance().setLastForegroundTime(System.currentTimeMillis());
    }
}
