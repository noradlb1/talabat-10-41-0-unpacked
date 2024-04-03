package io.flutter.plugins.webviewflutter;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import e00.w2;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.WeakHashMap;

public class InstanceManager {
    private static final long CLEAR_FINALIZED_WEAK_REFERENCES_INTERVAL = 3000;
    private static final long MIN_HOST_CREATED_IDENTIFIER = 65536;
    private static final String TAG = "InstanceManager";
    private final FinalizationListener finalizationListener;
    private final Handler handler;
    private boolean hasFinalizationListenerStopped;
    private final WeakHashMap<Object, Long> identifiers = new WeakHashMap<>();
    private long nextIdentifier;
    private final ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
    private final HashMap<Long, Object> strongInstances = new HashMap<>();
    private final HashMap<Long, WeakReference<Object>> weakInstances = new HashMap<>();
    private final HashMap<WeakReference<Object>, Long> weakReferencesToIdentifiers = new HashMap<>();

    public interface FinalizationListener {
        void onFinalize(long j11);
    }

    private InstanceManager(FinalizationListener finalizationListener2) {
        Handler handler2 = new Handler(Looper.getMainLooper());
        this.handler = handler2;
        this.nextIdentifier = 65536;
        this.hasFinalizationListenerStopped = false;
        this.finalizationListener = finalizationListener2;
        handler2.postDelayed(new w2(this), 3000);
    }

    private void addInstance(Object obj, long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException(String.format("Identifier must be >= 0: %d", new Object[]{Long.valueOf(j11)}));
        } else if (!this.weakInstances.containsKey(Long.valueOf(j11))) {
            WeakReference weakReference = new WeakReference(obj, this.referenceQueue);
            this.identifiers.put(obj, Long.valueOf(j11));
            this.weakInstances.put(Long.valueOf(j11), weakReference);
            this.weakReferencesToIdentifiers.put(weakReference, Long.valueOf(j11));
            this.strongInstances.put(Long.valueOf(j11), obj);
        } else {
            throw new IllegalArgumentException(String.format("Identifier has already been added: %d", new Object[]{Long.valueOf(j11)}));
        }
    }

    @NonNull
    public static InstanceManager create(@NonNull FinalizationListener finalizationListener2) {
        return new InstanceManager(finalizationListener2);
    }

    private void logWarningIfFinalizationListenerHasStopped() {
        if (hasFinalizationListenerStopped()) {
            Log.w(TAG, "The manager was used after calls to the FinalizationListener have been stopped.");
        }
    }

    /* access modifiers changed from: private */
    public void releaseAllFinalizedInstances() {
        if (!hasFinalizationListenerStopped()) {
            while (true) {
                WeakReference weakReference = (WeakReference) this.referenceQueue.poll();
                if (weakReference != null) {
                    Long remove = this.weakReferencesToIdentifiers.remove(weakReference);
                    if (remove != null) {
                        this.weakInstances.remove(remove);
                        this.strongInstances.remove(remove);
                        this.finalizationListener.onFinalize(remove.longValue());
                    }
                } else {
                    this.handler.postDelayed(new w2(this), 3000);
                    return;
                }
            }
        }
    }

    public void addDartCreatedInstance(@NonNull Object obj, long j11) {
        logWarningIfFinalizationListenerHasStopped();
        addInstance(obj, j11);
    }

    public long addHostCreatedInstance(@NonNull Object obj) {
        logWarningIfFinalizationListenerHasStopped();
        if (!containsInstance(obj)) {
            long j11 = this.nextIdentifier;
            this.nextIdentifier = 1 + j11;
            addInstance(obj, j11);
            return j11;
        }
        throw new IllegalArgumentException("Instance of " + obj.getClass() + " has already been added.");
    }

    public void clear() {
        this.identifiers.clear();
        this.weakInstances.clear();
        this.strongInstances.clear();
        this.weakReferencesToIdentifiers.clear();
    }

    public boolean containsInstance(@Nullable Object obj) {
        logWarningIfFinalizationListenerHasStopped();
        return this.identifiers.containsKey(obj);
    }

    @Nullable
    public Long getIdentifierForStrongReference(@Nullable Object obj) {
        logWarningIfFinalizationListenerHasStopped();
        Long l11 = this.identifiers.get(obj);
        if (l11 != null) {
            this.strongInstances.put(l11, obj);
        }
        return l11;
    }

    @Nullable
    public <T> T getInstance(long j11) {
        logWarningIfFinalizationListenerHasStopped();
        WeakReference weakReference = this.weakInstances.get(Long.valueOf(j11));
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }

    public boolean hasFinalizationListenerStopped() {
        return this.hasFinalizationListenerStopped;
    }

    @Nullable
    public <T> T remove(long j11) {
        logWarningIfFinalizationListenerHasStopped();
        return this.strongInstances.remove(Long.valueOf(j11));
    }

    public void stopFinalizationListener() {
        this.handler.removeCallbacks(new w2(this));
        this.hasFinalizationListenerStopped = true;
    }
}
