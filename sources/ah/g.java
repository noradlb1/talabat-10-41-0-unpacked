package ah;

import io.reactivex.CompletableEmitter;
import io.reactivex.functions.Action;

public final /* synthetic */ class g implements Action {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CompletableEmitter f50826b;

    public /* synthetic */ g(CompletableEmitter completableEmitter) {
        this.f50826b = completableEmitter;
    }

    public final void run() {
        this.f50826b.onComplete();
    }
}
