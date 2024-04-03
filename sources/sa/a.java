package sa;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.tracing.ComponentMonitor;

public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f50775a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f50776b;

    public /* synthetic */ a(String str, Component component) {
        this.f50775a = str;
        this.f50776b = component;
    }

    public final Object create(ComponentContainer componentContainer) {
        return ComponentMonitor.lambda$processRegistrar$0(this.f50775a, this.f50776b, componentContainer);
    }
}
