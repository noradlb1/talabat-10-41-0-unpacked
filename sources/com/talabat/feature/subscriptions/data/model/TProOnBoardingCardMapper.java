package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCapsuleCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardLotteResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardTypeResponse;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCarouselCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingGridCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingTagsCardResponseModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingDefaultCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingMoreContentModel;
import com.talabat.mapper.ModelMapper;
import java.util.Locale;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCardResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardModel;", "tProOnBoardingCapsuleCardMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCapsuleCardMapper;", "tProOnBoardingTagsCardMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingTagsCardMapper;", "tProOnBoardingGridCardMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingGridCardMapper;", "tProOnBoardingLottieCardMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingLottieCardMapper;", "tProOnBoardingCarouselCardMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCarouselCardMapper;", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCapsuleCardMapper;Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingTagsCardMapper;Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingGridCardMapper;Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingLottieCardMapper;Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCarouselCardMapper;)V", "apply", "source", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingCardMapper implements ModelMapper<TProOnBoardingCardResponseModel, TProOnBoardingCardModel> {
    @NotNull
    private TProOnBoardingCapsuleCardMapper tProOnBoardingCapsuleCardMapper;
    @NotNull
    private TProOnBoardingCarouselCardMapper tProOnBoardingCarouselCardMapper;
    @NotNull
    private TProOnBoardingGridCardMapper tProOnBoardingGridCardMapper;
    @NotNull
    private TProOnBoardingLottieCardMapper tProOnBoardingLottieCardMapper;
    @NotNull
    private TProOnBoardingTagsCardMapper tProOnBoardingTagsCardMapper;

    @Inject
    public TProOnBoardingCardMapper(@NotNull TProOnBoardingCapsuleCardMapper tProOnBoardingCapsuleCardMapper2, @NotNull TProOnBoardingTagsCardMapper tProOnBoardingTagsCardMapper2, @NotNull TProOnBoardingGridCardMapper tProOnBoardingGridCardMapper2, @NotNull TProOnBoardingLottieCardMapper tProOnBoardingLottieCardMapper2, @NotNull TProOnBoardingCarouselCardMapper tProOnBoardingCarouselCardMapper2) {
        Intrinsics.checkNotNullParameter(tProOnBoardingCapsuleCardMapper2, "tProOnBoardingCapsuleCardMapper");
        Intrinsics.checkNotNullParameter(tProOnBoardingTagsCardMapper2, "tProOnBoardingTagsCardMapper");
        Intrinsics.checkNotNullParameter(tProOnBoardingGridCardMapper2, "tProOnBoardingGridCardMapper");
        Intrinsics.checkNotNullParameter(tProOnBoardingLottieCardMapper2, "tProOnBoardingLottieCardMapper");
        Intrinsics.checkNotNullParameter(tProOnBoardingCarouselCardMapper2, "tProOnBoardingCarouselCardMapper");
        this.tProOnBoardingCapsuleCardMapper = tProOnBoardingCapsuleCardMapper2;
        this.tProOnBoardingTagsCardMapper = tProOnBoardingTagsCardMapper2;
        this.tProOnBoardingGridCardMapper = tProOnBoardingGridCardMapper2;
        this.tProOnBoardingLottieCardMapper = tProOnBoardingLottieCardMapper2;
        this.tProOnBoardingCarouselCardMapper = tProOnBoardingCarouselCardMapper2;
    }

    @NotNull
    public TProOnBoardingCardModel apply(@NotNull TProOnBoardingCardResponseModel tProOnBoardingCardResponseModel) {
        TProOnBoardingCardResponseModel tProOnBoardingCardResponseModel2 = tProOnBoardingCardResponseModel;
        Intrinsics.checkNotNullParameter(tProOnBoardingCardResponseModel2, "source");
        String cardType = tProOnBoardingCardResponseModel.getCardType();
        String name2 = TProOnBoardingCardTypeResponse.CAPSULES.name();
        Locale locale = Locale.ROOT;
        String lowerCase = name2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual((Object) cardType, (Object) lowerCase)) {
            return this.tProOnBoardingCapsuleCardMapper.apply((TProOnBoardingCapsuleCardResponseModel) tProOnBoardingCardResponseModel2);
        }
        String lowerCase2 = TProOnBoardingCardTypeResponse.CAROUSEL.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual((Object) cardType, (Object) lowerCase2)) {
            return this.tProOnBoardingCarouselCardMapper.apply((TProOnBoardingCarouselCardResponseModel) tProOnBoardingCardResponseModel2);
        }
        String lowerCase3 = TProOnBoardingCardTypeResponse.TAGS.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual((Object) cardType, (Object) lowerCase3)) {
            return this.tProOnBoardingTagsCardMapper.apply((TProOnBoardingTagsCardResponseModel) tProOnBoardingCardResponseModel2);
        }
        String lowerCase4 = TProOnBoardingCardTypeResponse.GRID.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase4, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual((Object) cardType, (Object) lowerCase4)) {
            return this.tProOnBoardingGridCardMapper.apply((TProOnBoardingGridCardResponseModel) tProOnBoardingCardResponseModel2);
        }
        String lowerCase5 = TProOnBoardingCardTypeResponse.LOTTIE.name().toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase5, "this as java.lang.String).toLowerCase(Locale.ROOT)");
        if (Intrinsics.areEqual((Object) cardType, (Object) lowerCase5)) {
            return this.tProOnBoardingLottieCardMapper.apply((TProOnBoardingCardLotteResponseModel) tProOnBoardingCardResponseModel2);
        }
        return new TProOnBoardingDefaultCardModel(CollectionsKt__CollectionsKt.emptyList(), "", "", "", CollectionsKt__CollectionsKt.emptyList(), false, new TProOnBoardingMoreContentModel("", "", "", "", "", "", CollectionsKt__CollectionsKt.emptyList()), "tracking");
    }
}
