package pa;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.remoteconfig.RemoteConfigRegistrar;

public final /* synthetic */ class n implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qualified f50709a;

    public /* synthetic */ n(Qualified qualified) {
        this.f50709a = qualified;
    }

    public final Object create(ComponentContainer componentContainer) {
        return RemoteConfigRegistrar.lambda$getComponents$0(this.f50709a, componentContainer);
    }
}
