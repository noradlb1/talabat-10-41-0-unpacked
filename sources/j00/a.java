package j00;

import io.reactivex.rxjava3.disposables.Disposable;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Disposable f23707b;

    public /* synthetic */ a(Disposable disposable) {
        this.f23707b = disposable;
    }

    public final void run() {
        this.f23707b.dispose();
    }
}
