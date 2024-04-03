package androidx.core.provider;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;

class CalleeHandler {
    private CalleeHandler() {
    }

    @NonNull
    public static Handler a() {
        if (Looper.myLooper() == null) {
            return new Handler(Looper.getMainLooper());
        }
        return new Handler();
    }
}
