package org.greenrobot.greendao;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import org.greenrobot.greendao.database.Database;

@Instrumented
public class DbUtils {
    public static int copyAllBytes(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[4096];
        int i11 = 0;
        while (true) {
            int read = inputStream.read(bArr);
            if (read == -1) {
                return i11;
            }
            outputStream.write(bArr, 0, read);
            i11 += read;
        }
    }

    public static int executeSqlScript(Context context, Database database, String str) throws IOException {
        return executeSqlScript(context, database, str, true);
    }

    public static int executeSqlStatements(Database database, String[] strArr) {
        int i11 = 0;
        for (String trim : strArr) {
            String trim2 = trim.trim();
            if (trim2.length() > 0) {
                if (!(database instanceof SQLiteDatabase)) {
                    database.execSQL(trim2);
                } else {
                    SQLiteInstrumentation.execSQL((SQLiteDatabase) database, trim2);
                }
                i11++;
            }
        }
        return i11;
    }

    public static int executeSqlStatementsInTx(Database database, String[] strArr) {
        database.beginTransaction();
        try {
            int executeSqlStatements = executeSqlStatements(database, strArr);
            database.setTransactionSuccessful();
            return executeSqlStatements;
        } finally {
            database.endTransaction();
        }
    }

    public static void logTableDump(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursor;
        if (!(sQLiteDatabase instanceof SQLiteDatabase)) {
            cursor = sQLiteDatabase.query(str, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        } else {
            cursor = SQLiteInstrumentation.query(sQLiteDatabase, str, (String[]) null, (String) null, (String[]) null, (String) null, (String) null, (String) null);
        }
        try {
            DaoLog.d(DatabaseUtils.dumpCursorToString(cursor));
        } finally {
            cursor.close();
        }
    }

    public static byte[] readAllBytes(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        copyAllBytes(inputStream, byteArrayOutputStream);
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] readAsset(Context context, String str) throws IOException {
        InputStream open = context.getResources().getAssets().open(str);
        try {
            return readAllBytes(open);
        } finally {
            open.close();
        }
    }

    public static void vacuum(Database database) {
        if (!(database instanceof SQLiteDatabase)) {
            database.execSQL("VACUUM");
        } else {
            SQLiteInstrumentation.execSQL((SQLiteDatabase) database, "VACUUM");
        }
    }

    public static int executeSqlScript(Context context, Database database, String str, boolean z11) throws IOException {
        int i11;
        String[] split = new String(readAsset(context, str), "UTF-8").split(";(\\s)*[\n\r]");
        if (z11) {
            i11 = executeSqlStatementsInTx(database, split);
        } else {
            i11 = executeSqlStatements(database, split);
        }
        DaoLog.i("Executed " + i11 + " statements from SQL script '" + str + "'");
        return i11;
    }
}
