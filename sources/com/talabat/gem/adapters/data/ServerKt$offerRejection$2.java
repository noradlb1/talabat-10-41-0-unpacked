package com.talabat.gem.adapters.data;

import JsonModels.GemRejectResponse;
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

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u00010\u00020\u00020\u0001*\u00020\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "LJsonModels/GemRejectResponse;", "kotlin.jvm.PlatformType", "Lcom/talabat/gem/adapters/data/GemEndPoints;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ServerKt$offerRejection$2 extends Lambda implements Function1<GemEndPoints, Single<GemRejectResponse>> {
    public static final ServerKt$offerRejection$2 INSTANCE = new ServerKt$offerRejection$2();

    public ServerKt$offerRejection$2() {
        super(1);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final GemRejectResponse m10526invoke$lambda0(GemRejectRawResponse gemRejectRawResponse) {
        Intrinsics.checkNotNullParameter(gemRejectRawResponse, "it");
        return ServerKt.assertNonNullResult(gemRejectRawResponse);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-1  reason: not valid java name */
    public static final void m10527invoke$lambda1(GemRejectResponse gemRejectResponse) {
        AnalyticsPort.DefaultImpls.onGemApiCallResponse$default(IntegrationKt.getAnalytics(), ServerKt.REJECT_GEM_URL, "success", ServerKt.offerId(), (String) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (String) null, 504, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-2  reason: not valid java name */
    public static final void m10528invoke$lambda2(Throwable th2) {
        String str;
        int i11;
        AnalyticsPort analytics = IntegrationKt.getAnalytics();
        String access$offerId = ServerKt.offerId();
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
        AnalyticsPort.DefaultImpls.onGemApiCallResponse$default(analytics, ServerKt.REJECT_GEM_URL, str, access$offerId, (String) null, (Integer) null, (Integer) null, Integer.valueOf(i11), message, (String) null, 312, (Object) null);
        LoggerPort logger = IntegrationKt.getLogger();
        Intrinsics.checkNotNullExpressionValue(th2, "it");
        logger.logError(th2);
    }

    @NotNull
    public final Single<GemRejectResponse> invoke(@NotNull GemEndPoints gemEndPoints) {
        Intrinsics.checkNotNullParameter(gemEndPoints, "$this$server");
        AnalyticsPort.DefaultImpls.onGemApiCallRequest$default(IntegrationKt.getAnalytics(), ServerKt.REJECT_GEM_URL, "loading", ServerKt.offerId(), (String) null, (String) null, 24, (Object) null);
        return GemEndPoints.DefaultImpls.requestReject$default(gemEndPoints, (String) null, 1, (Object) null).map(new s()).doOnSuccess(new t()).doOnError(new u());
    }
}
