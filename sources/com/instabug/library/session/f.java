package com.instabug.library.session;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import androidx.annotation.NonNull;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.InstabugDbContract;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.model.session.SessionLocalEntity;
import com.instabug.library.model.session.SessionMapper;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import io.reactivex.CompletableEmitter;
import io.reactivex.CompletableOnSubscribe;

@Instrumented
class f implements CompletableOnSubscribe {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SessionLocalEntity f51747a;

    public f(h hVar, SessionLocalEntity sessionLocalEntity) {
        this.f51747a = sessionLocalEntity;
    }

    /* JADX INFO: finally extract failed */
    public void subscribe(@NonNull CompletableEmitter completableEmitter) {
        ContentValues contentValues = SessionMapper.toContentValues(this.f51747a);
        SQLiteDatabaseWrapper openDatabase = DatabaseManager.getInstance().openDatabase();
        try {
            openDatabase.beginTransaction();
            if (openDatabase.insertWithOnConflict(InstabugDbContract.SessionEntry.TABLE_NAME, (String) null, contentValues) == -1) {
                String[] strArr = {String.valueOf(this.f51747a.getId())};
                if (!(openDatabase instanceof SQLiteDatabase)) {
                    openDatabase.update(InstabugDbContract.SessionEntry.TABLE_NAME, contentValues, "session_id = ? ", strArr);
                } else {
                    SQLiteInstrumentation.update((SQLiteDatabase) openDatabase, InstabugDbContract.SessionEntry.TABLE_NAME, contentValues, "session_id = ? ", strArr);
                }
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
