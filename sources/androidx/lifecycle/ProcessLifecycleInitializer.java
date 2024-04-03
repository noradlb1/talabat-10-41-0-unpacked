package androidx.lifecycle;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.startup.AppInitializer;
import androidx.startup.Initializer;
import java.util.Collections;
import java.util.List;

public final class ProcessLifecycleInitializer implements Initializer<LifecycleOwner> {
    @NonNull
    public List<Class<? extends Initializer<?>>> dependencies() {
        return Collections.emptyList();
    }

    @NonNull
    public LifecycleOwner create(@NonNull Context context) {
        if (AppInitializer.getInstance(context).isEagerlyInitialized(ProcessLifecycleInitializer.class)) {
            LifecycleDispatcher.a(context);
            ProcessLifecycleOwner.h(context);
            return ProcessLifecycleOwner.get();
        }
        throw new IllegalStateException("ProcessLifecycleInitializer cannot be initialized lazily. \nPlease ensure that you have: \n<meta-data\n    android:name='androidx.lifecycle.ProcessLifecycleInitializer' \n    android:value='androidx.startup' /> \nunder InitializationProvider in your AndroidManifest.xml");
    }
}
