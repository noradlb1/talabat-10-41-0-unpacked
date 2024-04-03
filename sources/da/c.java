package da;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.components.Qualified;
import com.google.firebase.heartbeatinfo.DefaultHeartBeatController;

public final /* synthetic */ class c implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Qualified f50605a;

    public /* synthetic */ c(Qualified qualified) {
        this.f50605a = qualified;
    }

    public final Object create(ComponentContainer componentContainer) {
        return DefaultHeartBeatController.lambda$component$3(this.f50605a, componentContainer);
    }
}
