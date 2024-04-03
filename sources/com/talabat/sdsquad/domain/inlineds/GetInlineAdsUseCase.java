package com.talabat.sdsquad.domain.inlineds;

import bu.a;
import com.talabat.sdsquad.core.UseCase;
import com.talabat.sdsquad.data.inlineads.InLineAdsRepository;
import com.talabat.searchdiscovery.features.vendorslist.models.responses.Ad;
import com.talabat.searchdiscovery.features.vendorslist.models.responses.InlineAdsResponse;
import io.reactivex.Flowable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u001a\u0012\u0004\u0012\u00020\u0002\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00030\u0001:\u0001\rB\u000f\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\u000b\u0010\fJ\u001e\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u0002H\u0014R\u0014\u0010\t\u001a\u00020\b8\u0002X\u0004¢\u0006\u0006\n\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/talabat/sdsquad/domain/inlineds/GetInlineAdsUseCase;", "Lcom/talabat/sdsquad/core/UseCase;", "Lcom/talabat/sdsquad/domain/inlineds/GetInlineAdsUseCase$RequestValues;", "Lio/reactivex/Flowable;", "", "Lcom/talabat/searchdiscovery/features/vendorslist/models/responses/Ad;", "requestValues", "b", "Lcom/talabat/sdsquad/data/inlineads/InLineAdsRepository;", "mInLineAdsRepository", "Lcom/talabat/sdsquad/data/inlineads/InLineAdsRepository;", "<init>", "(Lcom/talabat/sdsquad/data/inlineads/InLineAdsRepository;)V", "RequestValues", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0})
public final class GetInlineAdsUseCase extends UseCase<RequestValues, Flowable<List<? extends Ad>>> {
    @NotNull
    private final InLineAdsRepository mInLineAdsRepository;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/sdsquad/domain/inlineds/GetInlineAdsUseCase$RequestValues;", "Lcom/talabat/sdsquad/core/UseCase$RequestValues;", "forceUpdate", "", "countryId", "", "(ZLjava/lang/String;)V", "getCountryId", "()Ljava/lang/String;", "getForceUpdate", "()Z", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RequestValues implements UseCase.RequestValues {
        @NotNull
        private final String countryId;
        private final boolean forceUpdate;

        public RequestValues(boolean z11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "countryId");
            this.forceUpdate = z11;
            this.countryId = str;
        }

        @NotNull
        public final String getCountryId() {
            return this.countryId;
        }

        public final boolean getForceUpdate() {
            return this.forceUpdate;
        }
    }

    public GetInlineAdsUseCase(@NotNull InLineAdsRepository inLineAdsRepository) {
        Intrinsics.checkNotNullParameter(inLineAdsRepository, "mInLineAdsRepository");
        this.mInLineAdsRepository = inLineAdsRepository;
    }

    /* access modifiers changed from: private */
    /* renamed from: executeUseCase$lambda-1$lambda-0  reason: not valid java name */
    public static final List m10787executeUseCase$lambda1$lambda0(InlineAdsResponse inlineAdsResponse) {
        Intrinsics.checkNotNullParameter(inlineAdsResponse, "it");
        List<Ad> ads = inlineAdsResponse.getAds();
        if (ads == null) {
            return CollectionsKt__CollectionsKt.emptyList();
        }
        return ads;
    }

    @NotNull
    /* renamed from: b */
    public Flowable<List<Ad>> executeUseCase(@Nullable RequestValues requestValues) {
        if (requestValues != null) {
            Flowable<R> map = this.mInLineAdsRepository.getInlineAds(requestValues.getForceUpdate(), requestValues.getCountryId()).map(new a());
            Intrinsics.checkNotNullExpressionValue(map, "mInLineAdsRepository.get…{ it.ads ?: emptyList() }");
            return map;
        }
        throw new Exception("request values can not be null");
    }
}
