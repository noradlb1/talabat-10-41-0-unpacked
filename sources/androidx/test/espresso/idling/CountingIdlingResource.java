package androidx.test.espresso.idling;

import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import androidx.test.espresso.IdlingResource;
import java.util.concurrent.atomic.AtomicInteger;

public final class CountingIdlingResource implements IdlingResource {
    private static final String TAG = "CountingIdlingResource";
    private volatile long becameBusyAt;
    private volatile long becameIdleAt;
    private final AtomicInteger counter;
    private final boolean debugCounting;
    private volatile IdlingResource.ResourceCallback resourceCallback;
    private final String resourceName;

    public CountingIdlingResource(String str) {
        this(str, false);
    }

    public void decrement() {
        int decrementAndGet = this.counter.decrementAndGet();
        if (decrementAndGet == 0) {
            if (this.resourceCallback != null) {
                this.resourceCallback.onTransitionToIdle();
            }
            this.becameIdleAt = SystemClock.uptimeMillis();
        }
        if (this.debugCounting) {
            if (decrementAndGet == 0) {
                String str = this.resourceName;
                long j11 = this.becameIdleAt - this.becameBusyAt;
                StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 65);
                sb2.append("Resource: ");
                sb2.append(str);
                sb2.append(" went idle! (Time spent not idle: ");
                sb2.append(j11);
                sb2.append(")");
                Log.i(TAG, sb2.toString());
            } else {
                String str2 = this.resourceName;
                StringBuilder sb3 = new StringBuilder(String.valueOf(str2).length() + 51);
                sb3.append("Resource: ");
                sb3.append(str2);
                sb3.append(" in-use-count decremented to: ");
                sb3.append(decrementAndGet);
                Log.i(TAG, sb3.toString());
            }
        }
        if (decrementAndGet <= -1) {
            StringBuilder sb4 = new StringBuilder(50);
            sb4.append("Counter has been corrupted! counterVal=");
            sb4.append(decrementAndGet);
            throw new IllegalStateException(sb4.toString());
        }
    }

    public void dumpStateToLogs() {
        StringBuilder sb2 = new StringBuilder("Resource: ");
        sb2.append(this.resourceName);
        sb2.append(" inflight transaction count: ");
        sb2.append(this.counter.get());
        if (0 == this.becameBusyAt) {
            sb2.append(" and has never been busy!");
            Log.i(TAG, sb2.toString());
            return;
        }
        sb2.append(" and was last busy at: ");
        sb2.append(this.becameBusyAt);
        if (0 == this.becameIdleAt) {
            sb2.append(" AND NEVER WENT IDLE!");
            Log.w(TAG, sb2.toString());
            return;
        }
        sb2.append(" and last went idle at: ");
        sb2.append(this.becameIdleAt);
        Log.i(TAG, sb2.toString());
    }

    public String getName() {
        return this.resourceName;
    }

    public void increment() {
        int andIncrement = this.counter.getAndIncrement();
        if (andIncrement == 0) {
            this.becameBusyAt = SystemClock.uptimeMillis();
        }
        if (this.debugCounting) {
            String str = this.resourceName;
            StringBuilder sb2 = new StringBuilder(String.valueOf(str).length() + 51);
            sb2.append("Resource: ");
            sb2.append(str);
            sb2.append(" in-use-count incremented to: ");
            sb2.append(andIncrement + 1);
            Log.i(TAG, sb2.toString());
        }
    }

    public boolean isIdleNow() {
        return this.counter.get() == 0;
    }

    public void registerIdleTransitionCallback(IdlingResource.ResourceCallback resourceCallback2) {
        this.resourceCallback = resourceCallback2;
    }

    public CountingIdlingResource(String str, boolean z11) {
        this.counter = new AtomicInteger(0);
        this.becameBusyAt = 0;
        this.becameIdleAt = 0;
        if (!TextUtils.isEmpty(str)) {
            this.resourceName = str;
            this.debugCounting = z11;
            return;
        }
        throw new IllegalArgumentException("resourceName cannot be empty or null!");
    }
}
