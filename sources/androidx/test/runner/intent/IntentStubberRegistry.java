package androidx.test.runner.intent;

import android.os.Looper;
import androidx.test.internal.util.Checks;
import java.util.concurrent.atomic.AtomicBoolean;

public final class IntentStubberRegistry {
    private static IntentStubber instance;
    private static AtomicBoolean isLoaded = new AtomicBoolean();

    private IntentStubberRegistry() {
    }

    private static void checkMain() {
        Checks.checkState(Looper.myLooper() == Looper.getMainLooper(), "Must be called on main thread.");
    }

    public static IntentStubber getInstance() {
        boolean z11;
        checkMain();
        if (instance != null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Checks.checkState(z11, "No intent monitor registered! Are you running under an Instrumentation which registers intent monitors?");
        return instance;
    }

    public static boolean isLoaded() {
        return isLoaded.get();
    }

    public static void load(IntentStubber intentStubber) {
        Checks.checkNotNull(intentStubber, "IntentStubber cannot be null!");
        Checks.checkState(!isLoaded.getAndSet(true), "Intent stubber already registered! Multiple stubbers are notallowedAre you running under an ");
        instance = intentStubber;
    }

    public static synchronized void reset() {
        synchronized (IntentStubberRegistry.class) {
            instance = null;
            isLoaded.set(false);
        }
    }
}
