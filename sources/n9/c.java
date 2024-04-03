package n9;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;

public final /* synthetic */ class c implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Object f50681a;

    public /* synthetic */ c(Object obj) {
        this.f50681a = obj;
    }

    public final Object create(ComponentContainer componentContainer) {
        return Component.lambda$intoSet$4(this.f50681a, componentContainer);
    }
}
