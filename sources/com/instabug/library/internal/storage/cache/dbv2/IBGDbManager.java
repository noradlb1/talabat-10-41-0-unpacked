package com.instabug.library.internal.storage.cache.dbv2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.instabug.library.Instabug;
import com.instabug.library.apichecker.ReturnableRunnable;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.SQLiteInstrumentation;
import java.util.Arrays;
import java.util.List;

public class IBGDbManager {
    private static SQLiteOpenHelper dbHelper;
    @Nullable
    private static IBGDbManager instance;
    /* access modifiers changed from: private */
    @Nullable
    public SQLiteDatabase database;
    @Nullable
    private Boolean databaseTransactionsEnabled;

    public class a implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51035a;

        public a(String str) {
            this.f51035a = str;
        }

        @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE", "ERADICATE_PARAMETER_NOT_NULLABLE"})
        /* renamed from: a */
        public Long run() {
            IBGDbManager.this.openDatabase();
            try {
                if (IBGDbManager.this.databaseInitializedAndOpen()) {
                    return Long.valueOf(DatabaseUtils.queryNumEntries(IBGDbManager.this.database, this.f51035a));
                }
                IBGDbManager.this.logOperationFailedWarning("DB query num entries failed");
                return -1L;
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatalAndLog(e11, "DB query num entries failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()), "IBG-Core");
                IBGDbManager iBGDbManager = IBGDbManager.this;
                iBGDbManager.logOperationFailedWarning("DB query num entries failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                return -1L;
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "DB query num entries failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                IBGDbManager iBGDbManager2 = IBGDbManager.this;
                iBGDbManager2.logOperationFailedWarning("DB query num entries failed due to: " + e12.getMessage());
                return -1L;
            }
        }
    }

    @Instrumented
    public class b implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51037a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51038b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IBGContentValues f51039c;

        public b(String str, String str2, IBGContentValues iBGContentValues) {
            this.f51037a = str;
            this.f51038b = str2;
            this.f51039c = iBGContentValues;
        }

        @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE", "ERADICATE_NULLABLE_DEREFERENCE"})
        /* renamed from: a */
        public Long run() {
            long j11;
            IBGDbManager.this.openDatabase();
            try {
                if (IBGDbManager.this.databaseInitializedAndOpen()) {
                    SQLiteDatabase c11 = IBGDbManager.this.database;
                    String str = this.f51037a;
                    String str2 = this.f51038b;
                    ContentValues contentValues = this.f51039c.toContentValues();
                    if (!(c11 instanceof SQLiteDatabase)) {
                        j11 = c11.insertOrThrow(str, str2, contentValues);
                    } else {
                        j11 = SQLiteInstrumentation.insertOrThrow(c11, str, str2, contentValues);
                    }
                    return Long.valueOf(j11);
                }
                IBGDbManager.this.logOperationFailedWarning("DB insertion failed, database not initialized");
                return -1L;
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "DB insertion failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                IBGDbManager iBGDbManager = IBGDbManager.this;
                iBGDbManager.logOperationFailedWarning("DB insertion failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                return -1L;
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "DB insertion failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                IBGDbManager iBGDbManager2 = IBGDbManager.this;
                iBGDbManager2.logOperationFailedWarning("DB insertion failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                return -1L;
            }
        }
    }

    @Instrumented
    public class c implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51041a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51042b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IBGContentValues f51043c;

        public c(String str, String str2, IBGContentValues iBGContentValues) {
            this.f51041a = str;
            this.f51042b = str2;
            this.f51043c = iBGContentValues;
        }

        @SuppressLint({"ERADICATE_PARAMETER_NOT_NULLABLE", "ERADICATE_NULLABLE_DEREFERENCE"})
        /* renamed from: a */
        public Long run() {
            long j11;
            IBGDbManager.this.openDatabase();
            try {
                if (IBGDbManager.this.databaseInitializedAndOpen()) {
                    SQLiteDatabase c11 = IBGDbManager.this.database;
                    String str = this.f51041a;
                    String str2 = this.f51042b;
                    ContentValues contentValues = this.f51043c.toContentValues();
                    if (!(c11 instanceof SQLiteDatabase)) {
                        j11 = c11.insertWithOnConflict(str, str2, contentValues, 4);
                    } else {
                        j11 = SQLiteInstrumentation.insertWithOnConflict(c11, str, str2, contentValues, 4);
                    }
                    return Long.valueOf(j11);
                }
                IBGDbManager.this.logOperationFailedWarning("DB insertion with on conflict failed database is not initialized");
                return -1L;
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "DB insertion with on conflict failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                IBGDbManager iBGDbManager = IBGDbManager.this;
                iBGDbManager.logOperationFailedWarning("DB insertion with on conflict failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                return -1L;
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "DB insertion with on conflict failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                IBGDbManager iBGDbManager2 = IBGDbManager.this;
                iBGDbManager2.logOperationFailedWarning("DB insertion with on conflict failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                return -1L;
            }
        }
    }

    @Instrumented
    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51045b;

        public d(String str) {
            this.f51045b = str;
        }

        @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
        public void run() {
            IBGDbManager.this.openDatabase();
            try {
                if (IBGDbManager.this.databaseInitializedAndOpen()) {
                    SQLiteDatabase c11 = IBGDbManager.this.database;
                    String str = this.f51045b;
                    if (!(c11 instanceof SQLiteDatabase)) {
                        c11.execSQL(str);
                    } else {
                        SQLiteInstrumentation.execSQL(c11, str);
                    }
                } else {
                    IBGDbManager.this.logOperationFailedWarning("DB execution a sql failed");
                }
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "DB execution a sql failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                IBGDbManager iBGDbManager = IBGDbManager.this;
                iBGDbManager.logOperationFailedWarning("DB execution a sql failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "DB execution a sql failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                IBGDbManager iBGDbManager2 = IBGDbManager.this;
                iBGDbManager2.logOperationFailedWarning("DB execution a sql failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            }
        }
    }

    @Instrumented
    public class e implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51047a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51048b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IBGContentValues f51049c;

        public e(String str, String str2, IBGContentValues iBGContentValues) {
            this.f51047a = str;
            this.f51048b = str2;
            this.f51049c = iBGContentValues;
        }

        @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
        /* renamed from: a */
        public Long run() {
            long j11;
            IBGDbManager.this.openDatabase();
            try {
                if (IBGDbManager.this.databaseInitializedAndOpen()) {
                    SQLiteDatabase c11 = IBGDbManager.this.database;
                    String str = this.f51047a;
                    String str2 = this.f51048b;
                    ContentValues contentValues = this.f51049c.toContentValues();
                    if (!(c11 instanceof SQLiteDatabase)) {
                        j11 = c11.insertWithOnConflict(str, str2, contentValues, 5);
                    } else {
                        j11 = SQLiteInstrumentation.insertWithOnConflict(c11, str, str2, contentValues, 5);
                    }
                    return Long.valueOf(j11);
                }
                IBGDbManager.this.logOperationFailedWarning("DB insertion with on conflict replace failed");
                return -1L;
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "DB insertion with on conflict replace failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                IBGDbManager iBGDbManager = IBGDbManager.this;
                iBGDbManager.logOperationFailedWarning("DB insertion with on conflict replace failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                return -1L;
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "DB insertion with on conflict replace failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                IBGDbManager iBGDbManager2 = IBGDbManager.this;
                iBGDbManager2.logOperationFailedWarning("DB insertion with on conflict replace failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                return -1L;
            }
        }
    }

    @Instrumented
    public class f implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51051a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f51052b;

        public f(String str, List list) {
            this.f51051a = str;
            this.f51052b = list;
        }

        @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
        @Nullable
        /* renamed from: a */
        public IBGCursor run() {
            Cursor cursor;
            IBGDbManager.this.openDatabase();
            try {
                if (IBGDbManager.this.databaseInitializedAndOpen()) {
                    SQLiteDatabase c11 = IBGDbManager.this.database;
                    String str = this.f51051a;
                    String[] argsListToStringArray = IBGWhereArg.argsListToStringArray(this.f51052b);
                    if (!(c11 instanceof SQLiteDatabase)) {
                        cursor = c11.rawQuery(str, argsListToStringArray);
                    } else {
                        cursor = SQLiteInstrumentation.rawQuery(c11, str, argsListToStringArray);
                    }
                    return new IBGCursor(cursor);
                }
                IBGDbManager.this.logOperationFailedWarning("DB raw query faile");
                return null;
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "DB raw query failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                IBGDbManager iBGDbManager = IBGDbManager.this;
                iBGDbManager.logOperationFailedWarning("DB raw query faile due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                return null;
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "DB raw query failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                IBGDbManager iBGDbManager2 = IBGDbManager.this;
                iBGDbManager2.logOperationFailedWarning("DB raw query faile due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                return null;
            }
        }
    }

    @Instrumented
    public class g implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51054a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f51055b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f51056c;

        public g(String str, String str2, List list) {
            this.f51054a = str;
            this.f51055b = str2;
            this.f51056c = list;
        }

        @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
        /* renamed from: a */
        public Integer run() {
            int i11;
            IBGDbManager.this.openDatabase();
            try {
                if (IBGDbManager.this.databaseInitializedAndOpen()) {
                    SQLiteDatabase c11 = IBGDbManager.this.database;
                    String str = this.f51054a;
                    String str2 = this.f51055b;
                    String[] argsListToStringArray = IBGWhereArg.argsListToStringArray(this.f51056c);
                    if (!(c11 instanceof SQLiteDatabase)) {
                        i11 = c11.delete(str, str2, argsListToStringArray);
                    } else {
                        i11 = SQLiteInstrumentation.delete(c11, str, str2, argsListToStringArray);
                    }
                    return Integer.valueOf(i11);
                }
                IBGDbManager.this.logOperationFailedWarning("DB deletion failed");
                return 0;
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "DB deletion failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                IBGDbManager iBGDbManager = IBGDbManager.this;
                iBGDbManager.logOperationFailedWarning("DB deletion failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "DB deletion failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                IBGDbManager iBGDbManager2 = IBGDbManager.this;
                iBGDbManager2.logOperationFailedWarning("DB deletion failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            }
        }
    }

    @Instrumented
    public class h implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51058a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f51059b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f51060c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f51061d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51062e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f51063f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f51064g;

        public h(String str, String[] strArr, String str2, List list, String str3, String str4, String str5) {
            this.f51058a = str;
            this.f51059b = strArr;
            this.f51060c = str2;
            this.f51061d = list;
            this.f51062e = str3;
            this.f51063f = str4;
            this.f51064g = str5;
        }

        @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
        @Nullable
        /* renamed from: a */
        public IBGCursor run() {
            Cursor cursor;
            IBGDbManager.this.openDatabase();
            try {
                if (IBGDbManager.this.databaseInitializedAndOpen()) {
                    SQLiteDatabase c11 = IBGDbManager.this.database;
                    String str = this.f51058a;
                    String[] strArr = this.f51059b;
                    String str2 = this.f51060c;
                    String[] argsListToStringArray = IBGWhereArg.argsListToStringArray(this.f51061d);
                    String str3 = this.f51062e;
                    String str4 = this.f51063f;
                    String str5 = this.f51064g;
                    if (!(c11 instanceof SQLiteDatabase)) {
                        cursor = c11.query(str, strArr, str2, argsListToStringArray, str3, str4, str5);
                    } else {
                        cursor = SQLiteInstrumentation.query(c11, str, strArr, str2, argsListToStringArray, str3, str4, str5);
                    }
                    return new IBGCursor(cursor);
                }
                IBGDbManager.this.logOperationFailedWarning("DB query faile");
                return null;
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "DB query failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                IBGDbManager iBGDbManager = IBGDbManager.this;
                iBGDbManager.logOperationFailedWarning("DB query faile due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                return null;
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "DB query failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                IBGDbManager iBGDbManager2 = IBGDbManager.this;
                iBGDbManager2.logOperationFailedWarning("DB query faile due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                return null;
            }
        }
    }

    @Instrumented
    public class i implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51066a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ IBGContentValues f51067b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f51068c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f51069d;

        public i(String str, IBGContentValues iBGContentValues, String str2, List list) {
            this.f51066a = str;
            this.f51067b = iBGContentValues;
            this.f51068c = str2;
            this.f51069d = list;
        }

        @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
        @Nullable
        /* renamed from: a */
        public Integer run() {
            int i11;
            IBGDbManager.this.openDatabase();
            try {
                if (IBGDbManager.this.databaseInitializedAndOpen()) {
                    SQLiteDatabase c11 = IBGDbManager.this.database;
                    String str = this.f51066a;
                    ContentValues contentValues = this.f51067b.toContentValues();
                    String str2 = this.f51068c;
                    String[] argsListToStringArray = IBGWhereArg.argsListToStringArray(this.f51069d);
                    if (!(c11 instanceof SQLiteDatabase)) {
                        i11 = c11.update(str, contentValues, str2, argsListToStringArray);
                    } else {
                        i11 = SQLiteInstrumentation.update(c11, str, contentValues, str2, argsListToStringArray);
                    }
                    return Integer.valueOf(i11);
                }
                IBGDbManager.this.logOperationFailedWarning("DB update failed");
                return -1;
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "DB update failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                IBGDbManager iBGDbManager = IBGDbManager.this;
                iBGDbManager.logOperationFailedWarning("DB update failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                return -1;
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "DB update failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                IBGDbManager iBGDbManager2 = IBGDbManager.this;
                iBGDbManager2.logOperationFailedWarning("DB update failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                return -1;
            }
        }
    }

    @Instrumented
    public class j implements ReturnableRunnable {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f51071a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f51072b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f51073c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f51074d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51075e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f51076f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f51077g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f51078h;

        public j(String str, String[] strArr, String str2, List list, String str3, String str4, String str5, String str6) {
            this.f51071a = str;
            this.f51072b = strArr;
            this.f51073c = str2;
            this.f51074d = list;
            this.f51075e = str3;
            this.f51076f = str4;
            this.f51077g = str5;
            this.f51078h = str6;
        }

        @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
        @Nullable
        /* renamed from: a */
        public IBGCursor run() {
            Cursor cursor;
            IBGDbManager.this.openDatabase();
            try {
                if (IBGDbManager.this.databaseInitializedAndOpen()) {
                    SQLiteDatabase c11 = IBGDbManager.this.database;
                    String str = this.f51071a;
                    String[] strArr = this.f51072b;
                    String str2 = this.f51073c;
                    String[] argsListToStringArray = IBGWhereArg.argsListToStringArray(this.f51074d);
                    String str3 = this.f51075e;
                    String str4 = this.f51076f;
                    String str5 = this.f51077g;
                    String str6 = this.f51078h;
                    if (!(c11 instanceof SQLiteDatabase)) {
                        cursor = c11.query(str, strArr, str2, argsListToStringArray, str3, str4, str5, str6);
                    } else {
                        cursor = SQLiteInstrumentation.query(c11, str, strArr, str2, argsListToStringArray, str3, str4, str5, str6);
                    }
                    return new IBGCursor(cursor);
                }
                IBGDbManager.this.logOperationFailedWarning("DB query failed");
                return null;
            } catch (Exception e11) {
                IBGDiagnostics.reportNonFatal(e11, "DB query failed: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                IBGDbManager iBGDbManager = IBGDbManager.this;
                iBGDbManager.logOperationFailedWarning("DB query failed due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
                return null;
            } catch (OutOfMemoryError e12) {
                IBGDiagnostics.reportNonFatal(e12, "DB query failed: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                IBGDbManager iBGDbManager2 = IBGDbManager.this;
                iBGDbManager2.logOperationFailedWarning("DB query failed due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
                return null;
            }
        }
    }

    private IBGDbManager() {
    }

    /* access modifiers changed from: private */
    public synchronized boolean databaseInitializedAndOpen() {
        boolean z11;
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            z11 = false;
        } else {
            z11 = true;
        }
        return z11;
    }

    @SuppressLint({"RESOURCE_LEAK"})
    public static synchronized IBGDbManager getInstance() throws IllegalStateException {
        IBGDbManager iBGDbManager;
        synchronized (IBGDbManager.class) {
            if (instance == null) {
                if (Instabug.getApplicationContext() != null) {
                    init(new a(Instabug.getApplicationContext()));
                } else {
                    throw new IllegalStateException("IBG-Core is not initialized, call init(..) method first.");
                }
            }
            iBGDbManager = instance;
        }
        return iBGDbManager;
    }

    public static synchronized void init(a aVar) {
        synchronized (IBGDbManager.class) {
            if (instance == null) {
                instance = new IBGDbManager();
                dbHelper = aVar;
            }
        }
    }

    private synchronized boolean isDatabaseTransactionsEnabled() {
        boolean z11;
        if (this.databaseTransactionsEnabled == null && Instabug.getApplicationContext() != null) {
            this.databaseTransactionsEnabled = Boolean.valueOf(!InstabugCore.isDatabaseTransactionDisabled(Instabug.getApplicationContext()));
        }
        Boolean bool = this.databaseTransactionsEnabled;
        if (bool != null) {
            z11 = bool.booleanValue();
        } else {
            z11 = false;
        }
        return z11;
    }

    /* access modifiers changed from: private */
    public synchronized void logOperationFailedWarning(String str) {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase == null) {
            InstabugSDKLogger.e("IBG-Core", "Attempted to do operation on an uninitialized database. Falling back silently");
        } else if (!sQLiteDatabase.isOpen()) {
            InstabugSDKLogger.e("IBG-Core", "Attempted to do operation on a closed database. Falling back silently");
        } else {
            InstabugSDKLogger.w("IBG-Core", str);
        }
    }

    /* access modifiers changed from: private */
    public synchronized void openDatabase() {
        SQLiteDatabase sQLiteDatabase = this.database;
        if (sQLiteDatabase == null || !sQLiteDatabase.isOpen()) {
            this.database = dbHelper.getWritableDatabase();
        }
    }

    @VisibleForTesting
    @SuppressLint({"ERADICATE_FIELD_NOT_NULLABLE"})
    public static synchronized void tearDown() {
        SQLiteDatabase sQLiteDatabase;
        synchronized (IBGDbManager.class) {
            SQLiteOpenHelper sQLiteOpenHelper = dbHelper;
            if (sQLiteOpenHelper != null) {
                sQLiteOpenHelper.close();
                dbHelper = null;
            }
            IBGDbManager iBGDbManager = instance;
            if (!(iBGDbManager == null || (sQLiteDatabase = iBGDbManager.database) == null)) {
                sQLiteDatabase.close();
                instance.database = null;
                instance = null;
            }
        }
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public synchronized void beginTransaction() {
        openDatabase();
        try {
            if (!databaseInitializedAndOpen()) {
                logOperationFailedWarning("DB transaction failed");
            } else if (isDatabaseTransactionsEnabled()) {
                this.database.beginTransaction();
            }
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB transaction failed: " + e11.getMessage());
            logOperationFailedWarning("DB transaction failed due to:" + e11.getMessage());
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB transaction failed: " + e12.getMessage());
            logOperationFailedWarning("DB transaction failed due to: " + e12.getMessage());
        }
    }

    public int delete(@NonNull String str, @Nullable String str2, @Nullable List<IBGWhereArg> list) {
        Integer num = (Integer) PoolProvider.getDatabaseExecutor().executeAndGet(new g(str, str2, list));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public synchronized void endTransaction() {
        try {
            if (!databaseInitializedAndOpen()) {
                logOperationFailedWarning("DB end transaction not successful");
            } else if (isDatabaseTransactionsEnabled()) {
                this.database.endTransaction();
            }
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB end transaction not successful due to: " + e11.getMessage());
            logOperationFailedWarning("DB end transaction not successful due to: " + e11.getMessage());
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB end transaction not successful due to: " + e12.getMessage());
            logOperationFailedWarning("DB end transaction not successful due to: " + e12.getMessage());
        }
    }

    public void execSQL(@NonNull String str) {
        PoolProvider.getDatabaseExecutor().execute(new d(str));
    }

    public long insert(@NonNull String str, @Nullable String str2, @NonNull IBGContentValues iBGContentValues) {
        Long l11 = (Long) PoolProvider.getDatabaseExecutor().executeAndGet(new b(str, str2, iBGContentValues));
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    public long insertWithOnConflict(@NonNull String str, @Nullable String str2, @NonNull IBGContentValues iBGContentValues) {
        Long l11 = (Long) PoolProvider.getDatabaseExecutor().executeAndGet(new c(str, str2, iBGContentValues));
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    public long insertWithOnConflictReplace(@NonNull String str, @Nullable String str2, @NonNull IBGContentValues iBGContentValues) {
        Long l11 = (Long) PoolProvider.getDatabaseExecutor().executeAndGet(new e(str, str2, iBGContentValues));
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    @Nullable
    public IBGCursor query(String str, @Nullable String[] strArr, @Nullable String str2, @Nullable List<IBGWhereArg> list, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        return (IBGCursor) PoolProvider.getDatabaseExecutor().executeAndGet(new h(str, strArr, str2, list, str3, str4, str5));
    }

    public long queryNumEntries(@NonNull String str) {
        Long l11 = (Long) PoolProvider.getDatabaseExecutor().executeAndGet(new a(str));
        if (l11 == null) {
            return -1;
        }
        return l11.longValue();
    }

    @Nullable
    public IBGCursor rawQuery(@NonNull String str, @Nullable List<IBGWhereArg> list) {
        return (IBGCursor) PoolProvider.getDatabaseExecutor().executeAndGet(new f(str, list));
    }

    @SuppressLint({"ERADICATE_NULLABLE_DEREFERENCE"})
    public synchronized void setTransactionSuccessful() {
        try {
            if (!databaseInitializedAndOpen()) {
                logOperationFailedWarning("DB transaction not successful");
            } else if (isDatabaseTransactionsEnabled()) {
                this.database.setTransactionSuccessful();
            }
        } catch (Exception e11) {
            IBGDiagnostics.reportNonFatal(e11, "DB transaction not successful due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
            logOperationFailedWarning("DB transaction not successful due to: " + e11.getMessage() + Arrays.toString(e11.getStackTrace()));
        } catch (OutOfMemoryError e12) {
            IBGDiagnostics.reportNonFatal(e12, "DB transaction not successful due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
            logOperationFailedWarning("DB transaction not successful due to: " + e12.getMessage() + Arrays.toString(e12.getStackTrace()));
        }
    }

    public int update(@NonNull String str, @NonNull IBGContentValues iBGContentValues, @Nullable String str2, @Nullable List<IBGWhereArg> list) {
        Integer num = (Integer) PoolProvider.getDatabaseExecutor().executeAndGet(new i(str, iBGContentValues, str2, list));
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    @Nullable
    public IBGCursor query(String str, @Nullable String[] strArr, @Nullable String str2, @Nullable List<IBGWhereArg> list, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return (IBGCursor) PoolProvider.getDatabaseExecutor().executeAndGet(new j(str, strArr, str2, list, str3, str4, str5, str6));
    }
}
