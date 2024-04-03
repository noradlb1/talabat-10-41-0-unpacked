package com.instabug.library.diagnostics.diagnostics_db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.instabug.library.internal.storage.cache.dbv2.IBGWhereArg;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
final class l extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f34269g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ IBGContentValues f34270h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f34271i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List f34272j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public l(String str, IBGContentValues iBGContentValues, String str2, List list) {
        super(1);
        this.f34269g = str;
        this.f34270h = iBGContentValues;
        this.f34271i = str2;
        this.f34272j = list;
    }

    @Nullable
    /* renamed from: a */
    public final Integer invoke(@NotNull SQLiteDatabase sQLiteDatabase) {
        int i11;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$makeReturnableDBOperation");
        String str = this.f34269g;
        ContentValues contentValues = this.f34270h.toContentValues();
        String str2 = this.f34271i;
        String[] argsListToStringArray = IBGWhereArg.argsListToStringArray(this.f34272j);
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            i11 = sQLiteDatabase.update(str, contentValues, str2, argsListToStringArray);
        } else {
            i11 = SQLiteInstrumentation.update(sQLiteDatabase, str, contentValues, str2, argsListToStringArray);
        }
        return Integer.valueOf(i11);
    }
}
