package com.instabug.library.diagnostics.diagnostics_db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.dbv2.IBGContentValues;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
final class h extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f34253g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f34254h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ IBGContentValues f34255i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public h(String str, String str2, IBGContentValues iBGContentValues) {
        super(1);
        this.f34253g = str;
        this.f34254h = str2;
        this.f34255i = iBGContentValues;
    }

    @Nullable
    /* renamed from: a */
    public final Long invoke(@NotNull SQLiteDatabase sQLiteDatabase) {
        long j11;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$makeReturnableDBOperation");
        String str = this.f34253g;
        String str2 = this.f34254h;
        ContentValues contentValues = this.f34255i.toContentValues();
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            j11 = sQLiteDatabase.insertWithOnConflict(str, str2, contentValues, 4);
        } else {
            j11 = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabase, str, str2, contentValues, 4);
        }
        return Long.valueOf(j11);
    }
}
