package androidx.room;

import java.util.List;

public final /* synthetic */ class c0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f37505b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37506c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f37507d;

    public /* synthetic */ c0(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        this.f37505b = queryInterceptorDatabase;
        this.f37506c = str;
        this.f37507d = list;
    }

    public final void run() {
        this.f37505b.lambda$execSQL$11(this.f37506c, this.f37507d);
    }
}
