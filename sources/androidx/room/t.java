package androidx.room;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f37539b;

    public /* synthetic */ t(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f37539b = queryInterceptorDatabase;
    }

    public final void run() {
        this.f37539b.lambda$beginTransactionWithListener$2();
    }
}
