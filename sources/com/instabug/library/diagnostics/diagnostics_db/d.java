package com.instabug.library.diagnostics.diagnostics_db;

import android.database.sqlite.SQLiteDatabase;
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
final class d extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f34244g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String f34245h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ List f34246i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(String str, String str2, List list) {
        super(1);
        this.f34244g = str;
        this.f34245h = str2;
        this.f34246i = list;
    }

    @Nullable
    /* renamed from: a */
    public final Integer invoke(@NotNull SQLiteDatabase sQLiteDatabase) {
        int i11;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$makeReturnableDBOperation");
        String str = this.f34244g;
        String str2 = this.f34245h;
        String[] argsListToStringArray = IBGWhereArg.argsListToStringArray(this.f34246i);
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            i11 = sQLiteDatabase.delete(str, str2, argsListToStringArray);
        } else {
            i11 = SQLiteInstrumentation.delete(sQLiteDatabase, str, str2, argsListToStringArray);
        }
        return Integer.valueOf(i11);
    }
}
