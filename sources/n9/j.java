package n9;

import com.google.firebase.components.ComponentRegistrar;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class j implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRegistrar f50687a;

    public /* synthetic */ j(ComponentRegistrar componentRegistrar) {
        this.f50687a = componentRegistrar;
    }

    public final Object get() {
        return ComponentRuntime.lambda$toProviders$1(this.f50687a);
    }
}
