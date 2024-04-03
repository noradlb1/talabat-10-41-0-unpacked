package androidx.room;

import java.util.List;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f37552b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f37553c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f37554d;

    public /* synthetic */ v(QueryInterceptorDatabase queryInterceptorDatabase, String str, List list) {
        this.f37552b = queryInterceptorDatabase;
        this.f37553c = str;
        this.f37554d = list;
    }

    public final void run() {
        this.f37552b.lambda$query$7(this.f37553c, this.f37554d);
    }
}
