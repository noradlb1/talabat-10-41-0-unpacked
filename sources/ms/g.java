package ms;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.BehaviorSubject;

public final /* synthetic */ class g implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BehaviorSubject f62339b;

    public /* synthetic */ g(BehaviorSubject behaviorSubject) {
        this.f62339b = behaviorSubject;
    }

    public final void accept(Object obj) {
        this.f62339b.onNext((Boolean) obj);
    }
}
