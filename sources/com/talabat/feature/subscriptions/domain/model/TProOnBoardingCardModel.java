package com.talabat.feature.subscriptions.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001BS\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010R\u0014\u0010\u0005\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0014\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\f\u001a\u0004\u0018\u00010\rX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0012R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0012\u0001\u0006\u001e\u001f !\"#¨\u0006$"}, d2 = {"Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardModel;", "", "trackingId", "", "topImage", "cardBackgroundColor", "cardBackgroundImage", "titleSpanning", "", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingTitleSpanningModel;", "haveMore", "", "moreContent", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;", "cardType", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardType;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;ZLcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardType;)V", "getCardBackgroundColor", "()Ljava/lang/String;", "getCardBackgroundImage", "getCardType", "()Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardType;", "getHaveMore", "()Z", "getMoreContent", "()Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;", "getTitleSpanning", "()Ljava/util/List;", "getTopImage", "getTrackingId", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCapsuleCardModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingDefaultCardModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCardLotteModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingTagsCardModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCarouselCardModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingGridCardModel;", "com_talabat_feature_subscriptions_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class TProOnBoardingCardModel {
    @NotNull
    private final String cardBackgroundColor;
    @Nullable
    private final String cardBackgroundImage;
    @NotNull
    private final TProOnBoardingCardType cardType;
    private final boolean haveMore;
    @Nullable
    private final TProOnBoardingMoreContentModel moreContent;
    @NotNull
    private final List<TProOnBoardingTitleSpanningModel> titleSpanning;
    @Nullable
    private final String topImage;
    @NotNull
    private final String trackingId;

    private TProOnBoardingCardModel(String str, String str2, String str3, String str4, List<TProOnBoardingTitleSpanningModel> list, boolean z11, TProOnBoardingMoreContentModel tProOnBoardingMoreContentModel, TProOnBoardingCardType tProOnBoardingCardType) {
        this.trackingId = str;
        this.topImage = str2;
        this.cardBackgroundColor = str3;
        this.cardBackgroundImage = str4;
        this.titleSpanning = list;
        this.haveMore = z11;
        this.moreContent = tProOnBoardingMoreContentModel;
        this.cardType = tProOnBoardingCardType;
    }

    public /* synthetic */ TProOnBoardingCardModel(String str, String str2, String str3, String str4, List list, boolean z11, TProOnBoardingMoreContentModel tProOnBoardingMoreContentModel, TProOnBoardingCardType tProOnBoardingCardType, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, list, z11, tProOnBoardingMoreContentModel, tProOnBoardingCardType);
    }

    @NotNull
    public String getCardBackgroundColor() {
        return this.cardBackgroundColor;
    }

    @Nullable
    public String getCardBackgroundImage() {
        return this.cardBackgroundImage;
    }

    @NotNull
    public TProOnBoardingCardType getCardType() {
        return this.cardType;
    }

    public boolean getHaveMore() {
        return this.haveMore;
    }

    @Nullable
    public TProOnBoardingMoreContentModel getMoreContent() {
        return this.moreContent;
    }

    @NotNull
    public List<TProOnBoardingTitleSpanningModel> getTitleSpanning() {
        return this.titleSpanning;
    }

    @Nullable
    public String getTopImage() {
        return this.topImage;
    }

    @NotNull
    public String getTrackingId() {
        return this.trackingId;
    }
}
