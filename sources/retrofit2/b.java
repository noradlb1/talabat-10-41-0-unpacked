package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f63502b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callback f63503c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Throwable f63504d;

    public /* synthetic */ b(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r12, Callback callback, Throwable th2) {
        this.f63502b = r12;
        this.f63503c = callback;
        this.f63504d = th2;
    }

    public final void run() {
        this.f63502b.lambda$onFailure$1(this.f63503c, this.f63504d);
    }
}
