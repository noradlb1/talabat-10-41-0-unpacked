package androidx.room;

import android.content.ContentValues;
import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class k implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f37523a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f37524b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContentValues f37525c;

    public /* synthetic */ k(String str, int i11, ContentValues contentValues) {
        this.f37523a = str;
        this.f37524b = i11;
        this.f37525c = contentValues;
    }

    public final Object apply(Object obj) {
        return Long.valueOf(((SupportSQLiteDatabase) obj).insert(this.f37523a, this.f37524b, this.f37525c));
    }
}
