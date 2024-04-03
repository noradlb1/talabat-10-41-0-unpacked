package androidx.test.core.app;

import android.app.Activity;
import java.util.Set;

final /* synthetic */ class InstrumentationActivityInvoker$$Lambda$3 implements Runnable {
    private final Activity arg$1;
    private final Set arg$2;

    public InstrumentationActivityInvoker$$Lambda$3(Activity activity, Set set) {
        this.arg$1 = activity;
        this.arg$2 = set;
    }

    public void run() {
        InstrumentationActivityInvoker.a(this.arg$1, this.arg$2);
    }
}
