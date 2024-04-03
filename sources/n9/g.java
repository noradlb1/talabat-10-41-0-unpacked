package n9;

import com.google.firebase.components.ComponentDiscovery;
import com.google.firebase.inject.Provider;

public final /* synthetic */ class g implements Provider {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f50684a;

    public /* synthetic */ g(String str) {
        this.f50684a = str;
    }

    public final Object get() {
        return ComponentDiscovery.instantiate(this.f50684a);
    }
}
