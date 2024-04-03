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
final class i extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f34256g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f34257h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ IBGContentValues f34258i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(String str, String str2, IBGContentValues iBGContentValues) {
        super(1);
        this.f34256g = str;
        this.f34257h = str2;
        this.f34258i = iBGContentValues;
    }

    @Nullable
    /* renamed from: a */
    public final Long invoke(@NotNull SQLiteDatabase sQLiteDatabase) {
        long j11;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$makeReturnableDBOperation");
        String str = this.f34256g;
        String str2 = this.f34257h;
        ContentValues contentValues = this.f34258i.toContentValues();
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            j11 = sQLiteDatabase.insertWithOnConflict(str, str2, contentValues, 5);
        } else {
            j11 = SQLiteInstrumentation.insertWithOnConflict(sQLiteDatabase, str, str2, contentValues, 5);
        }
        return Long.valueOf(j11);
    }
}
