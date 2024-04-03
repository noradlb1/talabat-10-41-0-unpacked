package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class h implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f37518a;

    public /* synthetic */ h(long j11) {
        this.f37518a = j11;
    }

    public final Object apply(Object obj) {
        return ((SupportSQLiteDatabase) obj).setPageSize(this.f37518a);
    }
}
