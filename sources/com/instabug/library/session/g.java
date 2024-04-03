package com.instabug.library.session;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

@Instrumented
class g implements CompletableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f51748a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f51749b;

    public g(h hVar, String str, String str2) {
        this.f51748a = str;
        this.f51749b = str2;
    }

    /* JADX INFO: finally extract failed */
    public void subscribe(@NonNull CompletableEmitter completableEmitter) {
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("uuid", this.f51748a);
        String[] strArr = {this.f51749b};
        try {
            openDatabase.beginTransaction();
            if (!(openDatabase instanceof SQLiteDatabase)) {
                openDatabase.update(InstabugDbContract.SessionEntry.TABLE_NAME, contentValues, "uuid = ? ", strArr);
            } else {
                SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.SessionEntry.TABLE_NAME, contentValues, "uuid = ? ", strArr);
            }
            openDatabase.setTransactionSuccessful();
            openDatabase.endTransaction();
            openDatabase.close();
            completableEmitter.onComplete();
        } catch (Throwable th2) {
            openDatabase.endTransaction();
            openDatabase.close();
            throw th2;
        }
    }
}
