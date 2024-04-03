package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class g implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37516a;

    public /* synthetic */ g(int i11) {
        this.f37516a = i11;
    }

    public final Object apply(Object obj) {
        return Boolean.valueOf(((SupportSQLiteDatabase) obj).needUpgrade(this.f37516a));
    }
}
