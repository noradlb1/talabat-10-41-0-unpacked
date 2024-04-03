package com.deliveryhero.perseus.data.local.db.migration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.deliveryhero.perseus.utils.EventVariablesJsonSerializer;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/perseus/data/local/db/migration/AddHitsInOneTable;", "Landroidx/room/migration/Migration;", "()V", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "perseus_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AddHitsInOneTable extends Migration {
    public AddHitsInOneTable() {
        super(4, 5);
    }

    public void migrate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        if (!(supportSQLiteDatabase instanceof SQLiteDatabase)) {
            supportSQLiteDatabase.execSQL("ALTER TABLE tracking_perseus_events ADD COLUMN eventVariables TEXT NOT NULL DEFAULT \"{}\"");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "ALTER TABLE tracking_perseus_events ADD COLUMN eventVariables TEXT NOT NULL DEFAULT \"{}\"");
        }
        Cursor query = supportSQLiteDatabase.query("SELECT * FROM tracking_perseus_events");
        int columnIndex = query.getColumnIndex("id");
        while (query.moveToNext()) {
            long j11 = query.getLong(columnIndex);
            Cursor query2 = supportSQLiteDatabase.query("SELECT * FROM HitEventValues WHERE timestampId=" + j11 + " order by id");
            int columnIndex2 = query2.getColumnIndex("key");
            int columnIndex3 = query2.getColumnIndex("value");
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            while (query2.moveToNext()) {
                String string = query2.getString(columnIndex2);
                String string2 = query2.getString(columnIndex3);
                Intrinsics.checkNotNullExpressionValue(string, "key");
                Intrinsics.checkNotNullExpressionValue(string2, "value");
                linkedHashMap.put(string, string2);
            }
            String str = "UPDATE tracking_perseus_events SET eventVariables = '" + EventVariablesJsonSerializer.INSTANCE.toJson(linkedHashMap) + "' WHERE id = " + j11;
            if (!(supportSQLiteDatabase instanceof SQLiteDatabase)) {
                supportSQLiteDatabase.execSQL(str);
            } else {
                SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, str);
            }
        }
    }
}
