package com.instabug.library.internal.storage.cache.dbv2.migration;

import android.database.sqlite.SQLiteDatabase;
import com.facebook.appevents.UserDataStore;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Arrays;
import kotlin.Lazy;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
public final class w extends a {
    @NotNull

    /* renamed from: a  reason: collision with root package name */
    private final SQLiteDatabase f51106a;
    @NotNull

    /* renamed from: b  reason: collision with root package name */
    private final Lazy f51107b = LazyKt__LazyJVMKt.lazy(new v(this));

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(@NotNull SQLiteDatabase sQLiteDatabase) {
        super(sQLiteDatabase);
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        this.f51106a = sQLiteDatabase;
    }

    @NotNull
    public b c() {
        return (b) this.f51107b.getValue();
    }

    @NotNull
    public SQLiteDatabase d() {
        return this.f51106a;
    }

    public int e() {
        return 8;
    }

    /* access modifiers changed from: private */
    public final void b(SQLiteDatabase sQLiteDatabase) {
        String format = String.format("ALTER TABLE %s ADD COLUMN %s%s DEFAULT NULL", Arrays.copyOf(new Object[]{"terminations_table", "uuid", " TEXT"}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(format);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, format);
        }
    }

    public void a() {
        b((Function0) new u(this));
    }

    /* access modifiers changed from: private */
    public final void a(SQLiteDatabase sQLiteDatabase) {
        String format = String.format("ALTER TABLE %s ADD COLUMN %s%s DEFAULT NULL", Arrays.copyOf(new Object[]{"fatal_hangs_table", "uuid", " TEXT"}, 3));
        Intrinsics.checkNotNullExpressionValue(format, "format(this, *args)");
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            sQLiteDatabase.execSQL(format);
        } else {
            SQLiteInstrumentation.execSQL(sQLiteDatabase, format);
        }
    }
}
