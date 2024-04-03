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
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/migration/AddContextualInformationColumnsMigration;", "Landroidx/room/migration/Migration;", "()V", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddContextualInformationColumnsMigration extends Migration {
    public AddContextualInformationColumnsMigration() {
        super(2, 3);
    }

    public void migrate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN payloadTimeStamp TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN payloadTimeStamp TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN country TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN country TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN advertisingId TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN advertisingId TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN appId TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN appId TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN appName TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN appName TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN appVersionCode TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN appVersionCode TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN adjustId TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN adjustId TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN userId TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN userId TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN uaId TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN uaId TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN clientId TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN clientId TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN sessionId TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN sessionId TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN sdkVersionName TEXT NOT NULL DEFAULT \"\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN sdkVersionName TEXT NOT NULL DEFAULT \"\"");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN globalEntityId TEXT");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN globalEntityId TEXT");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN consent TEXT");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN consent TEXT");
        }
    }
}
