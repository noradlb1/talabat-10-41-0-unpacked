package o9;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.concurrent.ExecutorsRegistrar;

public final /* synthetic */ class b implements ComponentFactory {
    public final Object create(ComponentContainer componentContainer) {
        return ExecutorsRegistrar.BG_EXECUTOR.get();
    }
}
