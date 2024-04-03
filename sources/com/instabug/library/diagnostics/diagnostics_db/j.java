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
final class j extends Lambda implements Function1 {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ String f34259g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ String[] f34260h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ String f34261i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ List f34262j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f34263k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f34264l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ String f34265m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ String f34266n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(String str, String[] strArr, String str2, List list, String str3, String str4, String str5, String str6) {
        super(1);
        this.f34259g = str;
        this.f34260h = strArr;
        this.f34261i = str2;
        this.f34262j = list;
        this.f34263k = str3;
        this.f34264l = str4;
        this.f34265m = str5;
        this.f34266n = str6;
    }

    @Nullable
    /* renamed from: a */
    public final IBGCursor invoke(@NotNull SQLiteDatabase sQLiteDatabase) {
        Cursor cursor;
        Intrinsics.checkNotNullParameter(sQLiteDatabase, "$this$makeReturnableDBOperation");
        String str = this.f34259g;
        String[] strArr = this.f34260h;
        String str2 = this.f34261i;
        String[] argsListToStringArray = IBGWhereArg.argsListToStringArray(this.f34262j);
        String str3 = this.f34263k;
        String str4 = this.f34264l;
        String str5 = this.f34265m;
        String str6 = this.f34266n;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.query(str, strArr, str2, argsListToStringArray, str3, str4, str5, str6);
        } else {
            cursor = SQLiteInstrumentation.query(sQLiteDatabase, str, strArr, str2, argsListToStringArray, str3, str4, str5, str6);
        }
        return new IBGCursor(cursor);
    }
}
