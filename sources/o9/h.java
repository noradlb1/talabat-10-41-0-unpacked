package o9;

import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

public final /* synthetic */ class h implements Provider {
    public final Object get() {
        return ExecutorsRegistrar.scheduled(Executors.newCachedThreadPool(ExecutorsRegistrar.factory("Firebase Blocking", 11)));
    }
}
