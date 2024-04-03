package com.talabat.gem.adapters.data;

import JsonModels.GemAcceptResponse;
import JsonModels.GemRejectResponse;
import com.talabat.gem.IntegrationKt;
import com.talabat.gem.domain.entities.GemOfferAcceptance;
import com.talabat.gem.ports.data.GemAcceptanceDataSourcesPort;
import com.talabat.talabatcommon.extentions.KotlinResultKt;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import oq.a;
import oq.b;
import oq.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\n\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0016J7\u0010\u0005\u001a&\b\u0001\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\fJ7\u0010\r\u001a&\b\u0001\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\u000e0\u000e0\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u0006H\u0016ø\u0001\u0000ø\u0001\u0000¢\u0006\u0002\u0010\fJ\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0004H\u0016\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lcom/talabat/gem/adapters/data/GemAcceptanceDataSources;", "Lcom/talabat/gem/ports/data/GemAcceptanceDataSourcesPort;", "()V", "loadGemOfferAcceptance", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance;", "requestGemOfferAcceptance", "Lkotlin/Function1;", "Lkotlin/coroutines/Continuation;", "Lkotlin/Result;", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Accepted;", "kotlin.jvm.PlatformType", "", "()Lkotlin/jvm/functions/Function1;", "requestGemOfferRejection", "Lcom/talabat/gem/domain/entities/GemOfferAcceptance$Rejected;", "updateGemOfferAcceptance", "", "acceptance", "com_talabat_Components_gem_gem"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemAcceptanceDataSources implements GemAcceptanceDataSourcesPort {
    /* access modifiers changed from: private */
    /* renamed from: requestGemOfferAcceptance$lambda-0  reason: not valid java name */
    public static final GemOfferAcceptance.Accepted m10501requestGemOfferAcceptance$lambda0(GemAcceptResponse gemAcceptResponse) {
        Intrinsics.checkNotNullParameter(gemAcceptResponse, "it");
        return GemOfferAcceptance.Accepted.INSTANCE;
    }

    /* access modifiers changed from: private */
    /* renamed from: requestGemOfferRejection$lambda-1  reason: not valid java name */
    public static final void m10502requestGemOfferRejection$lambda1(GemRejectResponse gemRejectResponse) {
        if (gemRejectResponse.isGemRejected) {
            IntegrationKt.getAnalytics().onGemOfferRejected();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: requestGemOfferRejection$lambda-2  reason: not valid java name */
    public static final GemOfferAcceptance.Rejected m10503requestGemOfferRejection$lambda2(GemRejectResponse gemRejectResponse) {
        Intrinsics.checkNotNullParameter(gemRejectResponse, "it");
        return GemOfferAcceptance.Rejected.INSTANCE;
    }

    @Nullable
    public GemOfferAcceptance loadGemOfferAcceptance() {
        return CacheKt.getGemOfferAcceptance();
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOfferAcceptance.Accepted>>, Object> requestGemOfferAcceptance() {
        Single<R> map = ServerKt.getOfferAcceptance().map(new c());
        Intrinsics.checkNotNullExpressionValue(map, "offerAcceptance\n        …fferAcceptance.Accepted }");
        return KotlinResultKt.toEither(map);
    }

    @NotNull
    public Function1<Continuation<? super Result<GemOfferAcceptance.Rejected>>, Object> requestGemOfferRejection() {
        Single<R> map = ServerKt.getOfferRejection().doOnSuccess(new a()).map(new b());
        Intrinsics.checkNotNullExpressionValue(map, "offerRejection\n        .…fferAcceptance.Rejected }");
        return KotlinResultKt.toEither(map);
    }

    public void updateGemOfferAcceptance(@Nullable GemOfferAcceptance gemOfferAcceptance) {
        CacheKt.setGemOfferAcceptance(gemOfferAcceptance);
    }
}
