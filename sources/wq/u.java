package wq;

import io.reactivex.functions.Consumer;
import io.reactivex.subjects.Subject;

public final /* synthetic */ class u implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Subject f63010b;

    public /* synthetic */ u(Subject subject) {
        this.f63010b = subject;
    }

    public final void accept(Object obj) {
        this.f63010b.onNext((Throwable) obj);
    }
}
