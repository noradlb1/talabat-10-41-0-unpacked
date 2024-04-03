package androidx.room;

public final /* synthetic */ class x implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f37556b;

    public /* synthetic */ x(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f37556b = queryInterceptorDatabase;
    }

    public final void run() {
        this.f37556b.lambda$beginTransactionWithListenerNonExclusive$3();
    }
}
