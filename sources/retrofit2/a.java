package retrofit2;

import retrofit2.DefaultCallAdapterFactory;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 f63499b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Callback f63500c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Response f63501d;

    public /* synthetic */ a(DefaultCallAdapterFactory.ExecutorCallbackCall.AnonymousClass1 r12, Callback callback, Response response) {
        this.f63499b = r12;
        this.f63500c = callback;
        this.f63501d = response;
    }

    public final void run() {
        this.f63499b.lambda$onResponse$0(this.f63500c, this.f63501d);
    }
}
