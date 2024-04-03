package androidx.room;

public final /* synthetic */ class a0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f37501b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37502c;

    public /* synthetic */ a0(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f37501b = queryInterceptorDatabase;
        this.f37502c = str;
    }

    public final void run() {
        this.f37501b.lambda$query$6(this.f37502c);
    }
}
