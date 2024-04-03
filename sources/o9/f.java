package o9;

import com.google.firebase.concurrent.ExecutorsRegistrar;
import com.google.firebase.inject.Provider;
import java.util.concurrent.Executors;

public final /* synthetic */ class f implements Provider {
    public final Object get() {
        return ExecutorsRegistrar.scheduled(Executors.newFixedThreadPool(4, ExecutorsRegistrar.factory("Firebase Background", 10, ExecutorsRegistrar.bgPolicy())));
    }
}
