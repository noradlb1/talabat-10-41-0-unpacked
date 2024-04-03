package ah;

import io.reactivex.CompletableEmitter;
import io.reactivex.functions.Consumer;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CompletableEmitter f50827b;

    public /* synthetic */ h(CompletableEmitter completableEmitter) {
        this.f50827b = completableEmitter;
    }

    public final void accept(Object obj) {
        this.f50827b.onError((Throwable) obj);
    }
}
