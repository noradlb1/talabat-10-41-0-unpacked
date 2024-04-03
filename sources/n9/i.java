package n9;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentRuntime;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class i implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ComponentRuntime f50685a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f50686b;

    public /* synthetic */ i(ComponentRuntime componentRuntime, Component component) {
        this.f50685a = componentRuntime;
        this.f50686b = component;
    }

    public final Object get() {
        return this.f50685a.lambda$discoverComponents$0(this.f50686b);
    }
}
