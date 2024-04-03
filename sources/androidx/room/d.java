package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class d implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f37508a;

    public /* synthetic */ d(int i11) {
        this.f37508a = i11;
    }

    public final Object apply(Object obj) {
        return ((SupportSQLiteDatabase) obj).setVersion(this.f37508a);
    }
}
