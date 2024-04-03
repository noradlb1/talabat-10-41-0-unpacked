package com.talabat.core.fwf.data.sdkwrapper;

import android.content.Context;
import fwfd.com.fwfsdk.manager.callback.FWFFeaturesCallback;
import fwfd.com.fwfsdk.model.api.FWFSubscribeResult;
import fwfd.com.fwfsdk.model.db.FWFFallback;
import fwfd.com.fwfsdk.model.db.FWFResult;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH&J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\f\u001a\u00020\u0007H&J<\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\n2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00030\u0014H&J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0007H&J\u0012\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u001a\u001a\u00020\u00032\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007H&J+\u0010\u001c\u001a\u00020\u00032\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00070\u001e2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020 H&¢\u0006\u0002\u0010!J$\u0010\"\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00072\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00030\u0014H&¨\u0006$"}, d2 = {"Lcom/talabat/core/fwf/data/sdkwrapper/FunWithFlagsSdkWrapper;", "", "configureWith", "", "context", "Landroid/content/Context;", "fwfRegion", "", "accessToken", "isDebug", "", "getUserAttribute", "attribute", "getVariation", "token", "flagName", "fwfFallback", "Lfwfd/com/fwfsdk/model/db/FWFFallback;", "forceRequest", "callback", "Lkotlin/Function1;", "Lfwfd/com/fwfsdk/model/db/FWFResult;", "setAttribute", "value", "setGoogleClientId", "googleClientId", "setUserId", "userId", "subscribeFeatures", "keys", "", "fwfCallback", "Lfwfd/com/fwfsdk/manager/callback/FWFFeaturesCallback;", "([Ljava/lang/String;Ljava/lang/String;Lfwfd/com/fwfsdk/manager/callback/FWFFeaturesCallback;)V", "subscribeObserver", "Lfwfd/com/fwfsdk/model/api/FWFSubscribeResult;", "com_talabat_core_fwf_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface FunWithFlagsSdkWrapper {
    void configureWith(@Nullable Context context, @NotNull String str, @NotNull String str2, boolean z11);

    @Nullable
    String getUserAttribute(@NotNull String str);

    void getVariation(@NotNull String str, @NotNull String str2, @NotNull FWFFallback fWFFallback, boolean z11, @NotNull Function1<? super FWFResult, Unit> function1);

    void setAttribute(@NotNull String str, @NotNull String str2);

    void setGoogleClientId(@Nullable String str);

    void setUserId(@Nullable String str);

    void subscribeFeatures(@NotNull String[] strArr, @NotNull String str, @NotNull FWFFeaturesCallback fWFFeaturesCallback);

    void subscribeObserver(@NotNull String str, @NotNull Function1<? super FWFSubscribeResult, Unit> function1);
}
