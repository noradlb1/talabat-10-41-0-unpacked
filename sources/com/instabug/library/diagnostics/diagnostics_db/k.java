package com.instabug.library.diagnostics.diagnostics_db;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.instabug.library.internal.storage.cache.dbv2.IBGCursor;
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
final class k extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f34267g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ List f34268h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public k(String str, List list) {
        super(1);
        this.f34267g = str;
        this.f34268h = list;
    }

    @Nullable
    /* renamed from: a */
    public final IBGCursor invoke(@NotNull SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$makeReturnableDBOperation");
        String str = this.f34267g;
        String[] argsListToStringArray = IBGWhereArg.argsListToStringArray(this.f34268h);
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.rawQuery(str, argsListToStringArray);
        } else {
            cursor = SQLiteInstrumentation.rawQuery(sQLiteDatabase, str, argsListToStringArray);
        }
        return new IBGCursor(cursor);
    }
}
