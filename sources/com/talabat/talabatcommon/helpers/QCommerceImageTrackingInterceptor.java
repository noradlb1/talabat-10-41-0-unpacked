package com.talabat.talabatcommon.helpers;

import com.integration.nfv.observability.NfvObservabilityHandler;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.instrumentation.okhttp3.OkHttp3Instrumentation;
import com.talabat.core.featureflag.domain.ITalabatFeatureFlag;
import com.talabat.core.fwfprojectskeys.domain.projects.qcommerce.QCommerceFeatureFlagsKeys;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.Util;
import org.jetbrains.annotations.NotNull;

@Instrumented
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bH\u0002R\u0014\u0010\u0007\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/talabat/talabatcommon/helpers/QCommerceImageTrackingInterceptor;", "Lokhttp3/Interceptor;", "talabatFeatureFlag", "Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;", "nfvObservabilityHandler", "Lcom/integration/nfv/observability/NfvObservabilityHandler;", "(Lcom/talabat/core/featureflag/domain/ITalabatFeatureFlag;Lcom/integration/nfv/observability/NfvObservabilityHandler;)V", "isQCommerceImageObservabilityEnabled", "", "()Z", "intercept", "Lokhttp3/Response;", "chain", "Lokhttp3/Interceptor$Chain;", "trackImagePerformance", "", "request", "Lokhttp3/Request;", "response", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class QCommerceImageTrackingInterceptor implements Interceptor {
    @NotNull
    private final NfvObservabilityHandler nfvObservabilityHandler;
    @NotNull
    private final ITalabatFeatureFlag talabatFeatureFlag;

    public QCommerceImageTrackingInterceptor(@NotNull ITalabatFeatureFlag iTalabatFeatureFlag, @NotNull NfvObservabilityHandler nfvObservabilityHandler2) {
        Intrinsics.checkNotNullParameter(iTalabatFeatureFlag, "talabatFeatureFlag");
        Intrinsics.checkNotNullParameter(nfvObservabilityHandler2, "nfvObservabilityHandler");
        this.talabatFeatureFlag = iTalabatFeatureFlag;
        this.nfvObservabilityHandler = nfvObservabilityHandler2;
    }

    private final boolean isQCommerceImageObservabilityEnabled() {
        return this.talabatFeatureFlag.getFeatureFlag(QCommerceFeatureFlagsKeys.QCOMMERCE_IMAGE_OPTIMIZATION, false);
    }

    private final void trackImagePerformance(Request request, Response response) {
        if (!isQCommerceImageObservabilityEnabled()) {
            return;
        }
        if (response.isSuccessful()) {
            this.nfvObservabilityHandler.onQCommerceImageResponseReceived(request.url().toString(), response.receivedResponseAtMillis() - response.sentRequestAtMillis(), Util.headersContentLength(response), Response.header$default(response, "Content-Type", (String) null, 2, (Object) null), Response.header$default(response, "CF-Cache-Status", (String) null, 2, (Object) null));
            return;
        }
        this.nfvObservabilityHandler.onDarkstoresImageLoadError(request.url().toString(), response.message(), Integer.valueOf(response.code()));
    }

    @NotNull
    public Response intercept(@NotNull Interceptor.Chain chain) {
        Request request;
        Intrinsics.checkNotNullParameter(chain, "chain");
        Request request2 = chain.request();
        if (!request2.url().queryParameterNames().contains("qcommerce")) {
            return chain.proceed(request2);
        }
        Request.Builder url = request2.newBuilder().url(request2.url().newBuilder().removeAllQueryParameters("qcommerce").build());
        if (!(url instanceof Request.Builder)) {
            request = url.build();
        } else {
            request = OkHttp3Instrumentation.build(url);
        }
        Response proceed = chain.proceed(request);
        trackImagePerformance(request, proceed);
        return proceed;
    }
}
