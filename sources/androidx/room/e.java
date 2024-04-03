package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class e implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37510a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f37511b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f37512c;

    public /* synthetic */ e(String str, String str2, Object[] objArr) {
        this.f37510a = str;
        this.f37511b = str2;
        this.f37512c = objArr;
    }

    public final Object apply(Object obj) {
        return Integer.valueOf(((SupportSQLiteDatabase) obj).delete(this.f37510a, this.f37511b, this.f37512c));
    }
}
