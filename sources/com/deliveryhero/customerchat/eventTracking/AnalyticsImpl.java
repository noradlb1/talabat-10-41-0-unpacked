package com.deliveryhero.customerchat.eventTracking;

import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.configuration.ChatFeatureCallbacks;
import com.deliveryhero.contract.model.Events;
import com.deliveryhero.customerchat.analytics.repository.AnalyticsRepository;
import com.deliveryhero.customerchat.configuration.ChatConfigProvider;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002J\u0019\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/AnalyticsImpl;", "Lcom/deliveryhero/customerchat/eventTracking/Analytics;", "analyticsRepository", "Lcom/deliveryhero/customerchat/analytics/repository/AnalyticsRepository;", "chatConfigProvider", "Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;", "chatFeatureCallbacks", "Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "(Lcom/deliveryhero/customerchat/analytics/repository/AnalyticsRepository;Lcom/deliveryhero/customerchat/configuration/ChatConfigProvider;Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;)V", "logResponse", "", "eventName", "", "status", "track", "event", "Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;", "(Lcom/deliveryhero/customerchat/analytics/model/EventCreationRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AnalyticsImpl implements Analytics {
    @NotNull
    private final AnalyticsRepository analyticsRepository;
    @NotNull
    private final ChatConfigProvider chatConfigProvider;
    @NotNull
    private final ChatFeatureCallbacks chatFeatureCallbacks;

    public AnalyticsImpl(@NotNull AnalyticsRepository analyticsRepository2, @NotNull ChatConfigProvider chatConfigProvider2, @NotNull ChatFeatureCallbacks chatFeatureCallbacks2) {
        Intrinsics.checkNotNullParameter(analyticsRepository2, "analyticsRepository");
        Intrinsics.checkNotNullParameter(chatConfigProvider2, "chatConfigProvider");
        Intrinsics.checkNotNullParameter(chatFeatureCallbacks2, "chatFeatureCallbacks");
        this.analyticsRepository = analyticsRepository2;
        this.chatConfigProvider = chatConfigProvider2;
        this.chatFeatureCallbacks = chatFeatureCallbacks2;
    }

    private final void logResponse(String str, String str2) {
        Map mapOf = MapsKt__MapsKt.mapOf(TuplesKt.to(Events.GCC_EVENT_TRACKED_EVENT_NAME, str), TuplesKt.to(Events.GCC_EVENT_TRACKED_EVENT_STATUS, str2));
        ChatLogger chatLogger = this.chatFeatureCallbacks.getChatLogger();
        if (chatLogger != null) {
            chatLogger.log(Events.GCC_EVENT_TRACKED, mapOf);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x006d  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x007b  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object track(@org.jetbrains.annotations.NotNull com.deliveryhero.customerchat.analytics.model.EventCreationRequest r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof com.deliveryhero.customerchat.eventTracking.AnalyticsImpl$track$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.deliveryhero.customerchat.eventTracking.AnalyticsImpl$track$1 r0 = (com.deliveryhero.customerchat.eventTracking.AnalyticsImpl$track$1) r0
            int r1 = r0.f29833l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f29833l = r1
            goto L_0x0018
        L_0x0013:
            com.deliveryhero.customerchat.eventTracking.AnalyticsImpl$track$1 r0 = new com.deliveryhero.customerchat.eventTracking.AnalyticsImpl$track$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f29831j
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f29833l
            r3 = 1
            if (r2 == 0) goto L_0x0039
            if (r2 != r3) goto L_0x0031
            java.lang.Object r6 = r0.f29830i
            com.deliveryhero.customerchat.analytics.model.EventCreationRequest r6 = (com.deliveryhero.customerchat.analytics.model.EventCreationRequest) r6
            java.lang.Object r0 = r0.f29829h
            com.deliveryhero.customerchat.eventTracking.AnalyticsImpl r0 = (com.deliveryhero.customerchat.eventTracking.AnalyticsImpl) r0
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0067
        L_0x0031:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0039:
            kotlin.ResultKt.throwOnFailure(r7)
            com.deliveryhero.customerchat.configuration.ChatConfigProvider r7 = r5.chatConfigProvider
            com.deliveryhero.contract.configuration.ChatConfiguration r7 = r7.getChatConfiguration()
            if (r7 != 0) goto L_0x0047
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L_0x0047:
            com.deliveryhero.customerchat.analytics.repository.AnalyticsRepository r2 = r5.analyticsRepository
            com.deliveryhero.contract.model.ClientConfig r4 = r7.getClientConfig()
            java.lang.String r4 = r4.getGlobalEntityID()
            com.deliveryhero.contract.model.UserInfo r7 = r7.getUserInfo()
            java.lang.String r7 = r7.getDhAuthToken()
            r0.f29829h = r5
            r0.f29830i = r6
            r0.f29833l = r3
            java.lang.Object r7 = r2.track(r6, r4, r7, r0)
            if (r7 != r1) goto L_0x0066
            return r1
        L_0x0066:
            r0 = r5
        L_0x0067:
            com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult r7 = (com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult) r7
            boolean r1 = r7 instanceof com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult.Success
            if (r1 == 0) goto L_0x007b
            com.deliveryhero.customerchat.analytics.model.Event r6 = r6.getEvent()
            java.lang.String r6 = r6.getName()
            java.lang.String r7 = "Success"
            r0.logResponse(r6, r7)
            goto L_0x00a7
        L_0x007b:
            boolean r1 = r7 instanceof com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult.Failure
            if (r1 == 0) goto L_0x008d
            com.deliveryhero.customerchat.analytics.model.Event r6 = r6.getEvent()
            java.lang.String r6 = r6.getName()
            java.lang.String r7 = "Failure"
            r0.logResponse(r6, r7)
            goto L_0x00a7
        L_0x008d:
            boolean r1 = r7 instanceof com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult.Exception
            if (r1 == 0) goto L_0x00a7
            com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult$Exception r7 = (com.deliveryhero.customerchat.analytics.service.AnalyticsServiceResult.Exception) r7
            java.lang.Throwable r7 = r7.getE()
            r7.printStackTrace()
            com.deliveryhero.customerchat.analytics.model.Event r6 = r6.getEvent()
            java.lang.String r6 = r6.getName()
            java.lang.String r7 = "Exception"
            r0.logResponse(r6, r7)
        L_0x00a7:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.deliveryhero.customerchat.eventTracking.AnalyticsImpl.track(com.deliveryhero.customerchat.analytics.model.EventCreationRequest, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
