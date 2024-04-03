package com.talabat.perseus.config;

import com.newrelic.agent.android.analytics.AnalyticsAttribute;
import com.talabat.core.fwf.data.FunWithFlagsConstants;
import com.talabat.core.tracking.data.constant.ConstantsKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ&\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0003R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/perseus/config/PerseusConfigProvider;", "", "appId", "", "appName", "appVersionName", "baseUrl", "debuggable", "", "entity", "globalEntityId", "uaId", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "create", "Lcom/talabat/perseus/config/PerseusConfig;", "adjustId", "advertisingId", "countryCode", "userId", "perseus_analytics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class PerseusConfigProvider {
    @NotNull
    private final String appId;
    @NotNull
    private final String appName;
    @NotNull
    private final String appVersionName;
    @NotNull
    private final String baseUrl;
    private final boolean debuggable;
    @NotNull
    private final String entity;
    @NotNull
    private final String globalEntityId;
    @NotNull
    private final String uaId;

    public PerseusConfigProvider(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, boolean z11, @NotNull String str5, @NotNull String str6, @NotNull String str7) {
        Intrinsics.checkNotNullParameter(str, "appId");
        Intrinsics.checkNotNullParameter(str2, AnalyticsAttribute.APP_NAME_ATTRIBUTE);
        Intrinsics.checkNotNullParameter(str3, "appVersionName");
        Intrinsics.checkNotNullParameter(str4, "baseUrl");
        Intrinsics.checkNotNullParameter(str5, "entity");
        Intrinsics.checkNotNullParameter(str6, FunWithFlagsConstants.ATTRIBUTE_GLOBAL_ENTITY_ID);
        Intrinsics.checkNotNullParameter(str7, "uaId");
        this.appId = str;
        this.appName = str2;
        this.appVersionName = str3;
        this.baseUrl = str4;
        this.debuggable = z11;
        this.entity = str5;
        this.globalEntityId = str6;
        this.uaId = str7;
    }

    @NotNull
    public final PerseusConfig create(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        String str5 = str;
        Intrinsics.checkNotNullParameter(str5, "adjustId");
        String str6 = str2;
        Intrinsics.checkNotNullParameter(str6, ConstantsKt.GOOGLE_AD_ID);
        String str7 = str3;
        Intrinsics.checkNotNullParameter(str7, "countryCode");
        String str8 = str4;
        Intrinsics.checkNotNullParameter(str8, "userId");
        return new InnerPerseusConfig(str5, str6, this.appId, this.appName, this.appVersionName, this.baseUrl, str7, this.debuggable, this.entity, this.globalEntityId, this.uaId, str8);
    }
}
