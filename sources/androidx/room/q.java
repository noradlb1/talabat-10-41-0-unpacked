package androidx.room;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f37536b;

    public /* synthetic */ q(QueryInterceptorDatabase queryInterceptorDatabase) {
        this.f37536b = queryInterceptorDatabase;
    }

    public final void run() {
        this.f37536b.lambda$beginTransactionNonExclusive$1();
    }
}
