package com.deliveryhero.perseus.data.local.db.migration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/migration/AddIdToHitEventTimestampMigration;", "Landroidx/room/migration/Migration;", "()V", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddIdToHitEventTimestampMigration extends Migration {
    public AddIdToHitEventTimestampMigration() {
        super(3, 4);
    }

    public void migrate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        boolean z11 = supportSQLiteDatabase instanceof SQLiteDatabase;
        if (!z11) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS `temp_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `payloadTimeStamp` TEXT NOT NULL, `country` TEXT NOT NULL, `advertisingId` TEXT NOT NULL, `appId` TEXT NOT NULL, `appName` TEXT NOT NULL, `appVersionCode` TEXT NOT NULL, `adjustId` TEXT NOT NULL, `userId` TEXT NOT NULL, `uaId` TEXT NOT NULL, `clientId` TEXT NOT NULL, `sessionId` TEXT NOT NULL, `sdkVersionName` TEXT NOT NULL, `globalEntityId` TEXT, `consent` TEXT, `sessionOffset` INTEGER NOT NULL)");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS `temp_table` (`id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, `timestamp` INTEGER NOT NULL, `payloadTimeStamp` TEXT NOT NULL, `country` TEXT NOT NULL, `advertisingId` TEXT NOT NULL, `appId` TEXT NOT NULL, `appName` TEXT NOT NULL, `appVersionCode` TEXT NOT NULL, `adjustId` TEXT NOT NULL, `userId` TEXT NOT NULL, `uaId` TEXT NOT NULL, `clientId` TEXT NOT NULL, `sessionId` TEXT NOT NULL, `sdkVersionName` TEXT NOT NULL, `globalEntityId` TEXT, `consent` TEXT, `sessionOffset` INTEGER NOT NULL)");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("\n            INSERT INTO temp_table (timestamp, payloadTimeStamp, country, advertisingId, appId, appName, appVersionCode, adjustId, userId, uaId, clientId, sessionId, sdkVersionName, globalEntityId, consent, sessionOffset)\n            SELECT timestamp, payloadTimeStamp, country, advertisingId, appId, appName, appVersionCode, adjustId, userId, uaId, clientId, sessionId, sdkVersionName, globalEntityId, consent, sessionOffset FROM tracking_perseus_events\n            ");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "\n            INSERT INTO temp_table (timestamp, payloadTimeStamp, country, advertisingId, appId, appName, appVersionCode, adjustId, userId, uaId, clientId, sessionId, sdkVersionName, globalEntityId, consent, sessionOffset)\n            SELECT timestamp, payloadTimeStamp, country, advertisingId, appId, appName, appVersionCode, adjustId, userId, uaId, clientId, sessionId, sdkVersionName, globalEntityId, consent, sessionOffset FROM tracking_perseus_events\n            ");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("DROP TABLE tracking_perseus_events");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "DROP TABLE tracking_perseus_events");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE `temp_table` RENAME TO tracking_perseus_events");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE `temp_table` RENAME TO tracking_perseus_events");
        }
        if (!z11) {
            supportSQLiteDatabase.execSQL("ALTER TABLE HitEventValues ADD COLUMN `timestampId` INTEGER NOT NULL DEFAULT 0");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE HitEventValues ADD COLUMN `timestampId` INTEGER NOT NULL DEFAULT 0");
        }
        Cursor query = supportSQLiteDatabase.query("SELECT timestamp, id FROM tracking_perseus_events");
        int columnIndex = query.getColumnIndex("timestamp");
        int columnIndex2 = query.getColumnIndex("id");
        while (query.moveToNext()) {
            long j11 = query.getLong(columnIndex);
            String str = "UPDATE HitEventValues SET timestampId = " + query.getLong(columnIndex2) + " WHERE timestamp = " + j11;
            if (!(supportSQLiteDatabase instanceof SQLiteDatabase)) {
                supportSQLiteDatabase.execSQL(str);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, str);
            }
        }
    }
}
