package com.deliveryhero.customerchat.analytics.repository;

import com.deliveryhero.contract.model.DhEnvironment;
import com.deliveryhero.customerchat.analytics.model.EventCreationRequest;
import com.deliveryhero.customerchat.analytics.service.AnalyticsService;
import com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult;
import com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResultKt;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0010H\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002J/\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bXD¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u001a"}, d2 = {"Lcom/deliveryhero/customerchat/analytics/repository/AnalyticsRepositoryImpl;", "Lcom/deliveryhero/customerchat/analytics/repository/AnalyticsRepository;", "analyticsService", "Lcom/deliveryhero/customerchat/analytics/service/AnalyticsService;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "(Lcom/deliveryhero/customerchat/analytics/service/AnalyticsService;Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;)V", "baseURL", "", "getBaseURL", "()Ljava/lang/String;", "baseURL$delegate", "Lkotlin/Lazy;", "sendEventURL", "buildUrl", "environment", "Lcom/deliveryhero/contract/model/DhEnvironment;", "getSendEventsUrl", "track", "Lcom/deliveryhero/customerchat/analytics/service/AnalyticsServiceResult;", "", "event", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "globalEntityID", "authToken", "(Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsRepositoryImpl implements AnalyticsRepository {
    /* access modifiers changed from: private */
    @NotNull
    public final AnalyticsService analyticsService;
    @NotNull
    private final Lazy baseURL$delegate = LazyKt__LazyJVMKt.lazy(new AnalyticsRepositoryImpl$baseURL$2(this));
    /* access modifiers changed from: private */
    @NotNull
    public final ChatConfigProvider chatConfigProvider;
    @NotNull
    private final String sendEventURL = "events/v2/events";

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DhEnvironment.values().length];
            iArr[DhEnvironment.PRODUCTION.ordinal()] = 1;
            iArr[DhEnvironment.TESTING.ordinal()] = 2;
            iArr[DhEnvironment.STAGING.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AnalyticsRepositoryImpl(@NotNull AnalyticsService analyticsService2, @NotNull ChatConfigProvider chatConfigProvider2) {
        Intrinsics.checkNotNullParameter(analyticsService2, "analyticsService");
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        this.analyticsService = analyticsService2;
        this.chatConfigProvider = chatConfigProvider2;
    }

    /* access modifiers changed from: private */
    public final String buildUrl(DhEnvironment dhEnvironment) {
        int i11 = WhenMappings.$EnumSwitchMapping$0[dhEnvironment.ordinal()];
        if (i11 == 1) {
            return "https://helpcenter-ap.usehurrier.com/";
        }
        if (i11 == 2 || i11 == 3) {
            return "https://helpcenter-stg.usehurrier.com/";
        }
        throw new NoWhenBranchMatchedException();
    }

    private final String getBaseURL() {
        return (String) this.baseURL$delegate.getValue();
    }

    /* access modifiers changed from: private */
    public final String getSendEventsUrl() {
        return getBaseURL() + this.sendEventURL;
    }

    @Nullable
    public Object track(@NotNull EventCreationRequest eventCreationRequest, @NotNull String str, @NotNull String str2, @NotNull Continuation<? super AnalyticsServiceResult<? extends Object>> continuation) {
        return AnalyticsServiceResultKt.handleApi(new AnalyticsRepositoryImpl$track$2(this, eventCreationRequest, str2, str, (Continuation<? super AnalyticsRepositoryImpl$track$2>) null), continuation);
    }
}
