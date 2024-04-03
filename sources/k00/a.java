package k00;

import io.reactivex.rxjava3.disposables.Disposable;

public final /* synthetic */ class a implements AutoCloseable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Disposable f23743b;

    public /* synthetic */ a(Disposable disposable) {
        this.f23743b = disposable;
    }

    public final void close() {
        this.f23743b.dispose();
    }
}
