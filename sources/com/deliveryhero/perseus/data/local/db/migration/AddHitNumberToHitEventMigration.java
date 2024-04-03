package com.deliveryhero.perseus.data.local.db.migration;

import android.database.sqlite.SQLiteDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/migration/AddHitNumberToHitEventMigration;", "Landroidx/room/migration/Migration;", "()V", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddHitNumberToHitEventMigration extends Migration {
    public AddHitNumberToHitEventMigration() {
        super(1, 2);
    }

    public void migrate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        if (!(supportSQLiteDatabase instanceof SQLiteDatabase)) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN sessionOffset INTEGER NOT NULL DEFAULT 0");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN sessionOffset INTEGER NOT NULL DEFAULT 0");
        }
    }
}
