package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class l implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37526a;

    public /* synthetic */ l(int i11) {
        this.f37526a = i11;
    }

    public final Object apply(Object obj) {
        return ((SupportSQLiteDatabase) obj).setMaxSqlCacheSize(this.f37526a);
    }
}
