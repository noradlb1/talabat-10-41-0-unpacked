package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class f implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f37514a;

    public /* synthetic */ f(long j11) {
        this.f37514a = j11;
    }

    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).setMaximumSize(this.f37514a));
    }
}
