package n9;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class l implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f50688a;

    public /* synthetic */ l(ComponentRegistrar componentRegistrar) {
        this.f50688a = componentRegistrar;
    }

    public final Object get() {
        return ComponentRuntime.Builder.lambda$addComponentRegistrar$0(this.f50688a);
    }
}
