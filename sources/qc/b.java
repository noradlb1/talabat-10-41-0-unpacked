package qc;

import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.settings.SettingsManager;

public final /* synthetic */ class b implements ReturnableRunnable {
    public final Object run() {
        return Integer.valueOf(SettingsManager.getInstance().getPrimaryColor());
    }
}
