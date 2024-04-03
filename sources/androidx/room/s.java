package androidx.room;

public final /* synthetic */ class s implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f37537b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37538c;

    public /* synthetic */ s(QueryInterceptorDatabase queryInterceptorDatabase, String str) {
        this.f37537b = queryInterceptorDatabase;
        this.f37538c = str;
    }

    public final void run() {
        this.f37537b.lambda$execSQL$10(this.f37538c);
    }
}
