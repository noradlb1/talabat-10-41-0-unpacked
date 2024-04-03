package qc;

import com.instabug.library.apichecker.VoidRunnable;
import com.instabug.library.settings.SettingsManager;

public final /* synthetic */ class g implements VoidRunnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f50753a;

    public /* synthetic */ g(int i11) {
        this.f50753a = i11;
    }

    public final void run() {
        SettingsManager.getInstance().setLogLevel(this.f50753a);
    }
}
