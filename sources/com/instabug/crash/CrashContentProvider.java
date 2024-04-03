package com.instabug.crash;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.net.Uri;
import com.instabug.crash.di.d;
import com.instabug.library.core.InstabugCore;
import com.instabug.library.diagnostics.customtraces.IBGPendingTraceHandler;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class CrashContentProvider extends ContentProvider {
    private final void init(Context context) {
        if (d.f46399a.a(context).c() && InstabugCore.isLastSDKStateEnabled(context)) {
            Thread.setDefaultUncaughtExceptionHandler(new d(context));
        }
    }

    public void attachInfo(@Nullable Context context, @Nullable ProviderInfo providerInfo) {
        super.attachInfo(context, providerInfo);
        try {
            IBGPendingTraceHandler.setCrashCPStartTime(System.currentTimeMillis());
            if (context != null) {
                init(context);
            }
            IBGPendingTraceHandler.setCrashCPEndTime(System.currentTimeMillis());
        } catch (Exception e11) {
            e11.printStackTrace();
        } catch (OutOfMemoryError e12) {
            e12.printStackTrace();
        }
    }

    public int delete(@NotNull Uri uri, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return -1;
    }

    @Nullable
    public String getType(@NotNull Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    @Nullable
    public Uri insert(@NotNull Uri uri, @Nullable ContentValues contentValues) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    public boolean onCreate() {
        return true;
    }

    @Nullable
    public Cursor query(@NotNull Uri uri, @Nullable String[] strArr, @Nullable String str, @Nullable String[] strArr2, @Nullable String str2) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return null;
    }

    public int update(@NotNull Uri uri, @Nullable ContentValues contentValues, @Nullable String str, @Nullable String[] strArr) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return -1;
    }
}
