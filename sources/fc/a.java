package fc;

import com.instabug.crash.CrashPlugin;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CrashPlugin f47088b;

    public /* synthetic */ a(CrashPlugin crashPlugin) {
        this.f47088b = crashPlugin;
    }

    public final void accept(Object obj) {
        CrashPlugin.m9344getSDKEventSubscriber$lambda0(this.f47088b, (SDKCoreEvent) obj);
    }
}
