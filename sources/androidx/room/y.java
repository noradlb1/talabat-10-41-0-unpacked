package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

public final /* synthetic */ class y implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f37557b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f37558c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorProgram f37559d;

    public /* synthetic */ y(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f37557b = queryInterceptorDatabase;
        this.f37558c = supportSQLiteQuery;
        this.f37559d = queryInterceptorProgram;
    }

    public final void run() {
        this.f37557b.lambda$query$8(this.f37558c, this.f37559d);
    }
}
