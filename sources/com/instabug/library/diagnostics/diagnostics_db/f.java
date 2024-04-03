package com.instabug.library.diagnostics.diagnostics_db;

import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Instrumented
final class f extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f34249g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(String str) {
        super(1);
        this.f34249g = str;
    }

    public final void a(@NotNull SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$makeNonReturnableDBOperation");
        String str = this.f34249g;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(str);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, str);
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((SQLiteDatabase) obj);
        return Unit.INSTANCE;
    }
}
