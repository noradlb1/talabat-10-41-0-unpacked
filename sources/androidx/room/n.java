package androidx.room;

import androidx.arch.core.util.Function;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.Locale;

public final /* synthetic */ class n implements Function {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Locale f37532a;

    public /* synthetic */ n(Locale locale) {
        this.f37532a = locale;
    }

    public final Object apply(Object obj) {
        return ((SupportSQLiteDatabase) obj).setLocale(this.f37532a);
    }
}
