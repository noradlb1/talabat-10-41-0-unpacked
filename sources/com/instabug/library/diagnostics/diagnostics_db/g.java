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
final class g extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f34250g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f34251h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ IBGContentValues f34252i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(String str, String str2, IBGContentValues iBGContentValues) {
        super(1);
        this.f34250g = str;
        this.f34251h = str2;
        this.f34252i = iBGContentValues;
    }

    @Nullable
    /* renamed from: a */
    public final Long invoke(@NotNull SQLiteDatabase sQLiteDatabase) {
        long j11;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$makeReturnableDBOperation");
        String str = this.f34250g;
        String str2 = this.f34251h;
        ContentValues contentValues = this.f34252i.toContentValues();
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            j11 = sQLiteDatabase.insert(str, str2, contentValues);
        } else {
            j11 = SQLiteInstrumentation.insert(sQLiteDatabase, str, str2, contentValues);
        }
        return Long.valueOf(j11);
    }
}
