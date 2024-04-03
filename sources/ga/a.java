package ga;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.perf.FirebasePerfRegistrar;

public final /* synthetic */ class a implements ComponentFactory {
    public final Object create(ComponentContainer componentContainer) {
        return FirebasePerfRegistrar.providesFirebasePerformance(componentContainer);
    }
}
