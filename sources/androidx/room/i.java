package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class i implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f37520a;

    public /* synthetic */ i(boolean z11) {
        this.f37520a = z11;
    }

    public final Object apply(Object obj) {
        return ((SupportSQLiteDatabase) obj).setForeignKeyConstraintsEnabled(this.f37520a);
    }
}
