package ac;

import com.instabug.chat.notification.s;
import com.instabug.library.core.eventbus.coreeventbus.SDKCoreEvent;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class a implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ s f44467b;

    public /* synthetic */ a(s sVar) {
        this.f44467b = sVar;
    }

    public final void accept(Object obj) {
        this.f44467b.a((SDKCoreEvent) obj);
    }
}
