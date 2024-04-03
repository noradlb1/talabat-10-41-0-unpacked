package p9;

import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.crashlytics.CrashlyticsRegistrar;

public final /* synthetic */ class d implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ CrashlyticsRegistrar f50696a;

    public /* synthetic */ d(CrashlyticsRegistrar crashlyticsRegistrar) {
        this.f50696a = crashlyticsRegistrar;
    }

    public final Object create(ComponentContainer componentContainer) {
        return this.f50696a.buildCrashlytics(componentContainer);
    }
}
