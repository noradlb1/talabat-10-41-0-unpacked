package ue;

import android.os.SystemClock;
import javax.inject.Provider;

public final /* synthetic */ class rc implements Provider {
    public final Object get() {
        return Long.valueOf(SystemClock.elapsedRealtime());
    }
}
