package o9;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.concurrent.ExecutorsRegistrar;

public final /* synthetic */ class c implements ComponentFactory {
    public final Object create(ComponentContainer componentContainer) {
        return ExecutorsRegistrar.BLOCKING_EXECUTOR.get();
    }
}
