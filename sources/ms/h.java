package ms;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

public final /* synthetic */ class h implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BehaviorSubject f62340b;

    public /* synthetic */ h(BehaviorSubject behaviorSubject) {
        this.f62340b = behaviorSubject;
    }

    public final void accept(Object obj) {
        this.f62340b.onError((Throwable) obj);
    }
}
