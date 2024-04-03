package com.talabat.core.fwf.data.sdkwrapper;

import android.content.Context;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import fwfd.com.fwfsdk.FunWithFlags;
import fwfd.com.fwfsdk.constant.FWFConstants;
import fwfd.com.fwfsdk.manager.callback.FWFFeaturesCallback;
import fwfd.com.fwfsdk.model.api.FWFSubscribeResult;
import fwfd.com.fwfsdk.model.db.FWFConfig;
import fwfd.com.fwfsdk.model.db.FWFFallback;
import fwfd.com.fwfsdk.model.db.FWFResult;
import fwfd.com.fwfsdk.model.db.FWFUser;
import fwfd.com.fwfsdk.model.db.FWFUserAttributes;
import fwfd.com.fwfsdk.util.FWFLogger;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ug.a;
import ug.b;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J*\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0015\u001a\u00020\u0003H\u0016J<\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u00132\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\r0\u001dH\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u0003H\u0016J\u0012\u0010!\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0003H\u0016J\u0012\u0010#\u001a\u00020\r2\b\u0010$\u001a\u0004\u0018\u00010\u0003H\u0016J+\u0010%\u001a\u00020\r2\f\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00030'2\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010(\u001a\u00020)H\u0016¢\u0006\u0002\u0010*J$\u0010+\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u00032\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\r0\u001dH\u0016R#\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u00068BX\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006-"}, d2 = {"Lcom/talabat/core/fwf/data/sdkwrapper/FunWithFlagsSdkWrapperImpl;", "Lcom/talabat/core/fwf/data/sdkwrapper/FunWithFlagsSdkWrapper;", "localUrl", "", "(Ljava/lang/String;)V", "fwf", "Lfwfd/com/fwfsdk/FunWithFlags;", "kotlin.jvm.PlatformType", "getFwf", "()Lfwfd/com/fwfsdk/FunWithFlags;", "fwf$delegate", "Lkotlin/Lazy;", "configureWith", "", "context", "Landroid/content/Context;", "fwfRegion", "accessToken", "isDebug", "", "getUserAttribute", "attribute", "getVariation", "token", "flagName", "fwfFallback", "Lfwfd/com/fwfsdk/model/db/FWFFallback;", "forceRequest", "callback", "Lkotlin/Function1;", "Lfwfd/com/fwfsdk/model/db/FWFResult;", "setAttribute", "value", "setGoogleClientId", "googleClientId", "setUserId", "userId", "subscribeFeatures", "keys", "", "fwfCallback", "Lfwfd/com/fwfsdk/manager/callback/FWFFeaturesCallback;", "([Ljava/lang/String;Ljava/lang/String;Lfwfd/com/fwfsdk/manager/callback/FWFFeaturesCallback;)V", "subscribeObserver", "Lfwfd/com/fwfsdk/model/api/FWFSubscribeResult;", "com_talabat_core_fwf_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FunWithFlagsSdkWrapperImpl implements FunWithFlagsSdkWrapper {
    @NotNull
    private final Lazy fwf$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.NONE, FunWithFlagsSdkWrapperImpl$fwf$2.INSTANCE);
    @Nullable
    private final String localUrl;

    public FunWithFlagsSdkWrapperImpl(@Nullable String str) {
        this.localUrl = str;
    }

    private final FunWithFlags getFwf() {
        return (FunWithFlags) this.fwf$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: getVariation$lambda-1  reason: not valid java name */
    public static final void m9591getVariation$lambda1(Function1 function1, FWFResult fWFResult) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(fWFResult);
    }

    /* access modifiers changed from: private */
    /* renamed from: subscribeObserver$lambda-0  reason: not valid java name */
    public static final void m9592subscribeObserver$lambda0(Function1 function1, FWFSubscribeResult fWFSubscribeResult) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(fWFSubscribeResult);
    }

    public void configureWith(@Nullable Context context, @NotNull String str, @NotNull String str2, boolean z11) {
        FWFLogger.FWFLogLevel fWFLogLevel;
        Intrinsics.checkNotNullParameter(str, "fwfRegion");
        Intrinsics.checkNotNullParameter(str2, "accessToken");
        FunWithFlags fwf = getFwf();
        if (fwf != null) {
            fwf.setContext(context);
        }
        FunWithFlags fwf2 = getFwf();
        if (fwf2 != null) {
            FWFConfig.Builder localUrl2 = new FWFConfig.Builder(str2).localUrl(this.localUrl);
            String upperCase = str.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            FWFConfig.Builder cleanDBOnVersionUpdate = localUrl2.region(FWFConstants.Region.valueOf(upperCase)).apiVersion(FWFConstants.API.API_VERSION_V2).featureExpirationTime(86400.0f).cleanDBOnVersionUpdate(Boolean.TRUE);
            if (z11) {
                fWFLogLevel = FWFLogger.FWFLogLevel.debug;
            } else {
                fWFLogLevel = FWFLogger.FWFLogLevel.none;
            }
            fwf2.configureWith(cleanDBOnVersionUpdate.logLevel(fWFLogLevel).debugMode(z11).build());
        }
    }

    @Nullable
    public String getUserAttribute(@NotNull String str) {
        FWFUser user;
        FWFUserAttributes attributes;
        JsonObject custom;
        JsonElement jsonElement;
        Intrinsics.checkNotNullParameter(str, "attribute");
        FunWithFlags fwf = getFwf();
        if (fwf == null || (user = fwf.getUser()) == null || (attributes = user.getAttributes()) == null || (custom = attributes.getCustom()) == null || (jsonElement = custom.get(str)) == null) {
            return null;
        }
        return jsonElement.getAsString();
    }

    public void getVariation(@NotNull String str, @NotNull String str2, @NotNull FWFFallback fWFFallback, boolean z11, @NotNull Function1<? super FWFResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str2, "flagName");
        Intrinsics.checkNotNullParameter(fWFFallback, "fwfFallback");
        Intrinsics.checkNotNullParameter(function1, "callback");
        FunWithFlags fwf = getFwf();
        if (fwf != null) {
            fwf.getVariation(str2, str, fWFFallback, z11, new b(function1));
        }
    }

    public void setAttribute(@NotNull String str, @NotNull String str2) {
        FunWithFlags fwf;
        FWFUser user;
        Intrinsics.checkNotNullParameter(str, "attribute");
        Intrinsics.checkNotNullParameter(str2, "value");
        if (!Intrinsics.areEqual((Object) getUserAttribute(str), (Object) str2) && (fwf = getFwf()) != null && (user = fwf.getUser()) != null) {
            user.setAttribute(str, str2);
        }
    }

    public void setGoogleClientId(@Nullable String str) {
        FWFUser fWFUser;
        FunWithFlags fwf = getFwf();
        if (fwf != null) {
            fWFUser = fwf.getUser();
        } else {
            fWFUser = null;
        }
        if (fWFUser != null && !Intrinsics.areEqual((Object) fWFUser.getGoogleClientId(), (Object) str)) {
            fWFUser.setGoogleClientId(str);
        }
    }

    public void setUserId(@Nullable String str) {
        FWFUser fWFUser;
        FunWithFlags fwf = getFwf();
        FWFUser fWFUser2 = null;
        if (fwf != null) {
            fWFUser = fwf.getUser();
        } else {
            fWFUser = null;
        }
        if (fWFUser != null && !Intrinsics.areEqual((Object) fWFUser.getUserId(), (Object) str)) {
            FunWithFlags fwf2 = getFwf();
            if (fwf2 != null) {
                fWFUser2 = fwf2.getUser();
            }
            if (fWFUser2 != null) {
                fWFUser2.setUserId(str);
            }
        }
    }

    public void subscribeFeatures(@NotNull String[] strArr, @NotNull String str, @NotNull FWFFeaturesCallback fWFFeaturesCallback) {
        Intrinsics.checkNotNullParameter(strArr, UserMetadata.KEYDATA_FILENAME);
        Intrinsics.checkNotNullParameter(str, "accessToken");
        Intrinsics.checkNotNullParameter(fWFFeaturesCallback, "fwfCallback");
        FunWithFlags fwf = getFwf();
        if (fwf != null) {
            fwf.subscribeFeatures(strArr, str, fWFFeaturesCallback);
        }
    }

    public void subscribeObserver(@NotNull String str, @NotNull Function1<? super FWFSubscribeResult, Unit> function1) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(function1, "callback");
        FunWithFlags fwf = getFwf();
        if (fwf != null) {
            fwf.subscribeObserver(str, new a(function1));
        }
    }
}
