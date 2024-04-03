package androidx.room;

import android.content.ContentValues;
import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class m implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37527a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f37528b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContentValues f37529c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f37530d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object[] f37531e;

    public /* synthetic */ m(String str, int i11, ContentValues contentValues, String str2, Object[] objArr) {
        this.f37527a = str;
        this.f37528b = i11;
        this.f37529c = contentValues;
        this.f37530d = str2;
        this.f37531e = objArr;
    }

    public final Object apply(Object obj) {
        return Integer.valueOf(((SupportSQLiteDatabase) obj).update(this.f37527a, this.f37528b, this.f37529c, this.f37530d, this.f37531e));
    }
}
