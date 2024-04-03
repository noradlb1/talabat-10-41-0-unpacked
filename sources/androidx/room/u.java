package androidx.room;

import androidx.sqlite.db.SupportSQLiteQuery;

public final /* synthetic */ class u implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorDatabase f37540b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SupportSQLiteQuery f37541c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ QueryInterceptorProgram f37542d;

    public /* synthetic */ u(QueryInterceptorDatabase queryInterceptorDatabase, SupportSQLiteQuery supportSQLiteQuery, QueryInterceptorProgram queryInterceptorProgram) {
        this.f37540b = queryInterceptorDatabase;
        this.f37541c = supportSQLiteQuery;
        this.f37542d = queryInterceptorProgram;
    }

    public final void run() {
        this.f37540b.lambda$query$9(this.f37541c, this.f37542d);
    }
}
