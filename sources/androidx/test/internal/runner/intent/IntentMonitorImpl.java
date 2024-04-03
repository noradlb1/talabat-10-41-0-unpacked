package androidx.test.internal.runner.intent;

import android.content.Intent;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.test.runner.intent.IntentCallback;
import androidx.test.runner.intent.IntentMonitor;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class IntentMonitorImpl implements IntentMonitor {
    private static final String TAG = "IntentMonitorImpl";

    /* renamed from: a  reason: collision with root package name */
    public List<WeakReference<IntentCallback>> f37704a = Collections.synchronizedList(new ArrayList());

    public void addIntentCallback(@NonNull IntentCallback intentCallback) {
        if (intentCallback != null) {
            Iterator<WeakReference<IntentCallback>> it = this.f37704a.iterator();
            boolean z11 = true;
            while (it.hasNext()) {
                IntentCallback intentCallback2 = (IntentCallback) it.next().get();
                if (intentCallback2 == null) {
                    it.remove();
                } else if (intentCallback2 == intentCallback) {
                    z11 = false;
                }
            }
            if (z11) {
                this.f37704a.add(new WeakReference(intentCallback));
                return;
            }
            return;
        }
        throw new NullPointerException("callback cannot be null!");
    }

    public void removeIntentCallback(@NonNull IntentCallback intentCallback) {
        if (intentCallback != null) {
            Iterator<WeakReference<IntentCallback>> it = this.f37704a.iterator();
            while (it.hasNext()) {
                IntentCallback intentCallback2 = (IntentCallback) it.next().get();
                if (intentCallback2 == null) {
                    it.remove();
                } else if (intentCallback2 == intentCallback) {
                    it.remove();
                }
            }
            return;
        }
        throw new NullPointerException("callback cannot be null!");
    }

    public void signalIntent(Intent intent) {
        Iterator<WeakReference<IntentCallback>> it = this.f37704a.iterator();
        while (it.hasNext()) {
            IntentCallback intentCallback = (IntentCallback) it.next().get();
            if (intentCallback == null) {
                it.remove();
            } else {
                try {
                    intentCallback.onIntentSent(new Intent(intent));
                } catch (RuntimeException e11) {
                    Log.e(TAG, String.format("Callback threw exception! (callback: %s intent: %s)", new Object[]{intentCallback, intent}), e11);
                }
            }
        }
    }
}
