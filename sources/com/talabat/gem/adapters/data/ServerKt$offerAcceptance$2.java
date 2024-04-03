package com.talabat.gem.adapters.data;

import JsonModels.GemAcceptResponse;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.adapters.data.GemEndPoints;
import com.talabat.gem.ports.analytics.AnalyticsPort;
import com.talabat.gem.ports.logging.LoggerPort;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import retrofit2.HttpException;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "LJsonModels/GemAcceptResponse;", "kotlin.jvm.PlatformType", "Lcom/talabat/gem/adapters/data/GemEndPoints;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ServerKt$offerAcceptance$2 extends Lambda implements Function1<GemEndPoints, Single<GemAcceptResponse>> {
    public static final ServerKt$offerAcceptance$2 INSTANCE = new ServerKt$offerAcceptance$2();

    public ServerKt$offerAcceptance$2() {
        super(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final GemAcceptResponse m10522invoke$lambda0(GemAcceptRawResponse gemAcceptRawResponse) {
        Intrinsics.checkNotNullParameter(gemAcceptRawResponse, "it");
        return ServerKt.assertNonNullResult(gemAcceptRawResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final GemAcceptResponse m10523invoke$lambda1(GemAcceptResponse gemAcceptResponse) {
        Intrinsics.checkNotNullParameter(gemAcceptResponse, "it");
        return ServerKt.assertGemIsAccepted(gemAcceptResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m10524invoke$lambda2(GemAcceptResponse gemAcceptResponse) {
        AnalyticsPort.DefaultImpls.onGemApiCallResponse$default(IntegrationKt.getAnalytics(), ServerKt.ACCEPT_GEM_URL, "success", ServerKt.offerId(), ServerKt.reservationCode(), (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, 496, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-3  reason: not valid java name */
    public static final void m10525invoke$lambda3(Throwable th2) {
        String str;
        int i11;
        AnalyticsPort analytics = IntegrationKt.getAnalytics();
        String access$offerId = ServerKt.offerId();
        String access$reservationCode = ServerKt.reservationCode();
        boolean z11 = th2 instanceof HttpException;
        if (z11) {
            str = "error";
        } else {
            str = "success";
        }
        if (z11) {
            i11 = ((HttpException) th2).code();
        } else {
            i11 = 0;
        }
        String message = th2.getMessage();
        AnalyticsPort.DefaultImpls.onGemApiCallResponse$default(analytics, ServerKt.ACCEPT_GEM_URL, str, access$offerId, access$reservationCode, (Integer) null, (Integer) null, Integer.valueOf(i11), message, (String) null, 304, (Object) null);
        LoggerPort logger = IntegrationKt.getLogger();
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        logger.logError(th2);
    }

    @NotNull
    public final Single<GemAcceptResponse> invoke(@NotNull GemEndPoints gemEndPoints) {
        Intrinsics.checkNotNullParameter(gemEndPoints, "$this$server");
        AnalyticsPort.DefaultImpls.onGemApiCallRequest$default(IntegrationKt.getAnalytics(), ServerKt.ACCEPT_GEM_URL, "loading", ServerKt.offerId(), ServerKt.reservationCode(), (String) null, 16, (Object) null);
        return GemEndPoints.DefaultImpls.requestAccept$default(gemEndPoints, (String) null, 1, (Object) null).map(new o()).map(new p()).doOnSuccess(new q()).doOnError(new r());
    }
}
