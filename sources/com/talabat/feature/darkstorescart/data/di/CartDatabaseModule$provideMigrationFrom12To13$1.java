package com.talabat.feature.darkstorescart.data.di;

import android.database.sqlite.SQLiteDatabase;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/talabat/feature/darkstorescart/data/di/CartDatabaseModule$provideMigrationFrom12To13$1", "Landroidx/room/migration/Migration;", "migrate", "", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "com_talabat_feature_darkstores-cart_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CartDatabaseModule$provideMigrationFrom12To13$1 extends Migration {
    public CartDatabaseModule$provideMigrationFrom12To13$1() {
        super(12, 13);
    }

    public void migrate(@NotNull SupportSQLiteDatabase supportSQLiteDatabase) {
        Intrinsics.checkNotNullParameter(supportSQLiteDatabase, "database");
        if (!(supportSQLiteDatabase instanceof SQLiteDatabase)) {
            supportSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS CartInfo (\ncartId TEXT NOT NULL, \nrestaurantJson TEXT NOT NULL, \nPRIMARY KEY(cartId)\n)");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) supportSQLiteDatabase, "CREATE TABLE IF NOT EXISTS CartInfo (\ncartId TEXT NOT NULL, \nrestaurantJson TEXT NOT NULL, \nPRIMARY KEY(cartId)\n)");
        }
    }
}
