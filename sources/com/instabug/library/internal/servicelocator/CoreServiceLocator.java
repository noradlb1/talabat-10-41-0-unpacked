package com.instabug.library.internal.servicelocator;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import bd.a;
import com.google.android.exoplayer2.util.MimeTypes;
import com.instabug.library.diagnostics.IBGDiagnostics;
import com.instabug.library.internal.sharedpreferences.c;
import com.instabug.library.internal.storage.cache.db.DatabaseManager;
import com.instabug.library.internal.storage.cache.db.SQLiteDatabaseWrapper;
import com.instabug.library.settings.f;
import com.instabug.library.tracking.i;
import com.instabug.library.tracking.u;
import com.instabug.library.util.InstabugSDKLogger;
import com.instabug.library.util.threading.PoolProvider;
import com.instabug.library.util.threading.ReturnableSingleThreadExecutor;
import com.instabug.library.util.threading.e;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CoreServiceLocator {
    @NotNull
    public static final CoreServiceLocator INSTANCE = new CoreServiceLocator();
    @Nullable
    private static u screenOffHandler;

    private CoreServiceLocator() {
    }

    @JvmStatic
    @Nullable
    public static final synchronized DatabaseManager getDatabaseManager() {
        DatabaseManager databaseManager;
        DatabaseManager databaseManager2;
        synchronized (CoreServiceLocator.class) {
            try {
                Result.Companion companion = Result.Companion;
                databaseManager = Result.m6329constructorimpl(DatabaseManager.getInstance());
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                databaseManager = Result.m6329constructorimpl(ResultKt.createFailure(th2));
            }
            Throwable r22 = Result.m6332exceptionOrNullimpl(databaseManager);
            if (r22 != null) {
                InstabugSDKLogger.e("IBG-Core", "Couldn't open database.");
                IBGDiagnostics.reportNonFatal(r22, "Couldn't open database.");
                databaseManager = null;
            }
            databaseManager2 = databaseManager;
        }
        return databaseManager2;
    }

    @JvmStatic
    @Nullable
    public static final synchronized SQLiteDatabaseWrapper getDatabaseWrapper() {
        SQLiteDatabaseWrapper sQLiteDatabaseWrapper;
        synchronized (CoreServiceLocator.class) {
            DatabaseManager databaseManager = getDatabaseManager();
            if (databaseManager == null) {
                sQLiteDatabaseWrapper = null;
            } else {
                sQLiteDatabaseWrapper = databaseManager.openDatabase();
            }
        }
        return sQLiteDatabaseWrapper;
    }

    @JvmStatic
    @Nullable
    public static final SharedPreferences getInstabugSharedPreferences(@NotNull Context context, @NotNull String str) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "name");
        c cVar = (c) getSharedPreferencesExecutor().executeAndGet(new a(context, str));
        if (cVar == null) {
            IBGDiagnostics.reportNonFatal(new b(), "Trying to access sharedPref while being NULL");
        }
        return cVar;
    }

    /* access modifiers changed from: private */
    /* renamed from: getInstabugSharedPreferences$lambda-0  reason: not valid java name */
    public static final c m9384getInstabugSharedPreferences$lambda0(Context context, String str) {
        Intrinsics.checkNotNullParameter(context, "$context");
        Intrinsics.checkNotNullParameter(str, "$name");
        return c.f51012b.a(context, str);
    }

    @JvmStatic
    @NotNull
    public static final i getScreenOffEventMonitor(@NotNull Application application) {
        Intrinsics.checkNotNullParameter(application, MimeTypes.BASE_TYPE_APPLICATION);
        return new i(application);
    }

    @JvmStatic
    @NotNull
    public static final synchronized u getScreenOffHandler() {
        u uVar;
        synchronized (CoreServiceLocator.class) {
            if (screenOffHandler == null) {
                screenOffHandler = new u();
            }
            uVar = screenOffHandler;
            Intrinsics.checkNotNull(uVar);
        }
        return uVar;
    }

    @JvmStatic
    @NotNull
    public static final ReturnableSingleThreadExecutor getSharedPreferencesExecutor() {
        ReturnableSingleThreadExecutor returnableSingleThreadExecutor = PoolProvider.getReturnableSingleThreadExecutor("SharedPrefs");
        Intrinsics.checkNotNullExpressionValue(returnableSingleThreadExecutor, "getReturnableSingleThreadExecutor(\"SharedPrefs\")");
        return returnableSingleThreadExecutor;
    }

    @NotNull
    public final e getQueueMonitoringHelper() {
        long j11;
        f s11 = f.s();
        long j12 = 0;
        if (s11 == null) {
            j11 = 0;
        } else {
            j11 = s11.d();
        }
        f s12 = f.s();
        if (s12 != null) {
            j12 = s12.b();
        }
        return new e(j11, j12);
    }
}
