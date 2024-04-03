package com.talabat.userandlocation.customerinfo.data.local.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.talabatcore.logger.LogManager;
import com.talabat.userandlocation.customerinfo.data.local.CustomerInfoLocalDataSource;
import datamodels.CustomerInfo;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u001b\b\u0007\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0010\u001a\u0004\u0018\u00010\bH\u0002J\u0012\u0010\u0011\u001a\u00020\u00122\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0002R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/data/local/impl/CustomerInfoLocalDataSourceImpl;", "Lcom/talabat/userandlocation/customerinfo/data/local/CustomerInfoLocalDataSource;", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "value", "Ldatamodels/CustomerInfo;", "customerInfo", "getCustomerInfo", "()Ldatamodels/CustomerInfo;", "setCustomerInfo", "(Ldatamodels/CustomerInfo;)V", "sharedPreferences", "Landroid/content/SharedPreferences;", "getFromDisk", "writeToDisk", "", "Companion", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CustomerInfoLocalDataSourceImpl implements CustomerInfoLocalDataSource {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String KEY = "info";
    @NotNull
    @Deprecated
    public static final String PREF_NAME = "local_customer_info";
    @NotNull
    private final Gson gson;
    @NotNull
    private final SharedPreferences sharedPreferences;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/userandlocation/customerinfo/data/local/impl/CustomerInfoLocalDataSourceImpl$Companion;", "", "()V", "KEY", "", "PREF_NAME", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmOverloads
    public CustomerInfoLocalDataSourceImpl() {
        this((Context) null, (Gson) null, 3, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public CustomerInfoLocalDataSourceImpl(@NotNull Context context) {
        this(context, (Gson) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    @JvmOverloads
    public CustomerInfoLocalDataSourceImpl(@NotNull Context context, @NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
        SharedPreferences sharedPreferences2 = context.getSharedPreferences(PREF_NAME, 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences2, "context.getSharedPrefere…ME, Context.MODE_PRIVATE)");
        this.sharedPreferences = sharedPreferences2;
    }

    private final CustomerInfo getFromDisk() {
        Object obj;
        Object obj2;
        CustomerInfo customerInfo = null;
        try {
            Result.Companion companion = Result.Companion;
            Gson gson2 = this.gson;
            String string = this.sharedPreferences.getString(KEY, (String) null);
            Class cls = CustomerInfo.class;
            if (!(gson2 instanceof Gson)) {
                obj2 = gson2.fromJson(string, cls);
            } else {
                obj2 = GsonInstrumentation.fromJson(gson2, string, cls);
            }
            obj = Result.m6329constructorimpl((CustomerInfo) obj2);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r22 = Result.m6332exceptionOrNullimpl(obj);
        if (r22 == null) {
            customerInfo = obj;
        } else {
            LogManager.error(r22, "Couldn't read CustomerInfo from local disk");
        }
        return customerInfo;
    }

    private final void writeToDisk(CustomerInfo customerInfo) {
        Object obj;
        String str;
        try {
            Result.Companion companion = Result.Companion;
            SharedPreferences.Editor edit = this.sharedPreferences.edit();
            Gson gson2 = this.gson;
            if (!(gson2 instanceof Gson)) {
                str = gson2.toJson((Object) customerInfo);
            } else {
                str = GsonInstrumentation.toJson(gson2, (Object) customerInfo);
            }
            edit.putString(KEY, str).apply();
            obj = Result.m6329constructorimpl(Unit.INSTANCE);
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable r52 = Result.m6332exceptionOrNullimpl(obj);
        if (r52 != null) {
            LogManager.error(r52, "Couldn't save CustomerInfo to local disk");
        }
    }

    @Nullable
    public CustomerInfo getCustomerInfo() {
        return getFromDisk();
    }

    public void setCustomerInfo(@Nullable CustomerInfo customerInfo) {
        writeToDisk(customerInfo);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ CustomerInfoLocalDataSourceImpl(android.content.Context r1, com.google.gson.Gson r2, int r3, kotlin.jvm.internal.DefaultConstructorMarker r4) {
        /*
            r0 = this;
            r4 = r3 & 1
            if (r4 == 0) goto L_0x0013
            com.talabat.talabatcore.application.BaseApplication$Companion r1 = com.talabat.talabatcore.application.BaseApplication.Companion
            com.talabat.talabatcore.application.BaseApplication r1 = r1.getInstance()
            android.content.Context r1 = r1.getApplicationContext()
            java.lang.String r4 = "BaseApplication.instance.applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r4)
        L_0x0013:
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0020
            JsonModels.parser.UniversalGson r2 = JsonModels.parser.UniversalGson.INSTANCE
            com.google.gson.Gson r2 = r2.gson
            java.lang.String r3 = "INSTANCE.gson"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
        L_0x0020:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl.<init>(android.content.Context, com.google.gson.Gson, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
