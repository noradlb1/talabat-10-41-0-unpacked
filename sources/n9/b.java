package n9;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class b implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f50680a;

    public /* synthetic */ b(Object obj) {
        this.f50680a = obj;
    }

    public final Object create(ComponentContainer componentContainer) {
        return Component.lambda$intoSet$3(this.f50680a, componentContainer);
    }
}
