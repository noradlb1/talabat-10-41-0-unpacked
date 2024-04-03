package com.talabat.authentication.token.data.local.impl;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.newrelic.agent.android.instrumentation.GsonInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.talabat.authentication.token.data.local.LegacyTokenLocalDataSource;
import com.talabat.authentication.token.data.model.SwapTokenData;
import com.talabat.core.context.domain.ApplicationContext;
import javax.inject.Inject;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR(\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\u0010\u000f\u001a\u0004\u0018\u00010\b8V@VX\u000e¢\u0006\f\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u0016"}, d2 = {"Lcom/talabat/authentication/token/data/local/impl/LegacyTokenLocalDataSourceImpl;", "Lcom/talabat/authentication/token/data/local/LegacyTokenLocalDataSource;", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "_tokenData", "Lcom/talabat/authentication/token/data/model/SwapTokenData;", "sharedPreferences", "Landroid/content/SharedPreferences;", "getSharedPreferences", "()Landroid/content/SharedPreferences;", "sharedPreferences$delegate", "Lkotlin/Lazy;", "value", "swapTokenData", "getSwapTokenData", "()Lcom/talabat/authentication/token/data/model/SwapTokenData;", "setSwapTokenData", "(Lcom/talabat/authentication/token/data/model/SwapTokenData;)V", "Companion", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LegacyTokenLocalDataSourceImpl implements LegacyTokenLocalDataSource {
    @NotNull
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    @Deprecated
    public static final String KEY = "token";
    @NotNull
    @Deprecated
    public static final String PREFERENCE = "talabat";
    @Nullable
    private SwapTokenData _tokenData;
    /* access modifiers changed from: private */
    @NotNull
    public final Context context;
    @NotNull
    private final Gson gson;
    @NotNull
    private final Lazy sharedPreferences$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, new LegacyTokenLocalDataSourceImpl$sharedPreferences$2(this));

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/talabat/authentication/token/data/local/impl/LegacyTokenLocalDataSourceImpl$Companion;", "", "()V", "KEY", "", "PREFERENCE", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Inject
    public LegacyTokenLocalDataSourceImpl(@NotNull @ApplicationContext Context context2, @NotNull Gson gson2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.context = context2;
        this.gson = gson2;
    }

    private final SharedPreferences getSharedPreferences() {
        Object value = this.sharedPreferences$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-sharedPreferences>(...)");
        return (SharedPreferences) value;
    }

    @Nullable
    public SwapTokenData getSwapTokenData() {
        Object obj;
        SwapTokenData swapTokenData = this._tokenData;
        if (swapTokenData != null) {
            return swapTokenData;
        }
        Gson gson2 = this.gson;
        String string = getSharedPreferences().getString(KEY, (String) null);
        Class cls = SwapTokenData.class;
        if (!(gson2 instanceof Gson)) {
            obj = gson2.fromJson(string, cls);
        } else {
            obj = GsonInstrumentation.fromJson(gson2, string, cls);
        }
        SwapTokenData swapTokenData2 = (SwapTokenData) obj;
        this._tokenData = swapTokenData2;
        return swapTokenData2;
    }

    public void setSwapTokenData(@Nullable SwapTokenData swapTokenData) {
        String str;
        SharedPreferences.Editor edit = getSharedPreferences().edit();
        if (swapTokenData == null) {
            edit.clear().commit();
        } else {
            Gson gson2 = this.gson;
            if (!(gson2 instanceof Gson)) {
                str = gson2.toJson((Object) swapTokenData);
            } else {
                str = GsonInstrumentation.toJson(gson2, (Object) swapTokenData);
            }
            edit.putString(KEY, str).commit();
        }
        this._tokenData = swapTokenData;
    }
}
