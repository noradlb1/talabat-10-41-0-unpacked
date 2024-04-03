package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class j implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37521a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object[] f37522b;

    public /* synthetic */ j(String str, Object[] objArr) {
        this.f37521a = str;
        this.f37522b = objArr;
    }

    public final Object apply(Object obj) {
        return ((SupportSQLiteDatabase) obj).execSQL(this.f37521a, this.f37522b);
    }
}
