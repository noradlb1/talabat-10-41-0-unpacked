package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCapsuleCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardCapsulesResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingMoreContentResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingTitleSpanningResponseModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCapsuleCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardCapsulesContentModel;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCapsuleCardMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingCapsuleCardResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingCapsuleCardModel;", "tProOnBoardingCardSpanningTitleMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;", "tProOnBoardingCardMoreContentMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;)V", "getTProOnBoardingCardMoreContentMapper", "()Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;", "setTProOnBoardingCardMoreContentMapper", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;)V", "getTProOnBoardingCardSpanningTitleMapper", "()Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;", "setTProOnBoardingCardSpanningTitleMapper", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;)V", "apply", "source", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingCapsuleCardMapper implements ModelMapper<TProOnBoardingCapsuleCardResponseModel, TProOnBoardingCapsuleCardModel> {
    @NotNull
    private TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper;
    @NotNull
    private TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper;

    @Inject
    public TProOnBoardingCapsuleCardMapper(@NotNull TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper2, @NotNull TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper2) {
        Intrinsics.checkNotNullParameter(tProOnBoardingCardSpanningTitleMapper2, "tProOnBoardingCardSpanningTitleMapper");
        Intrinsics.checkNotNullParameter(tProOnBoardingCardMoreContentMapper2, "tProOnBoardingCardMoreContentMapper");
        this.tProOnBoardingCardSpanningTitleMapper = tProOnBoardingCardSpanningTitleMapper2;
        this.tProOnBoardingCardMoreContentMapper = tProOnBoardingCardMoreContentMapper2;
    }

    @NotNull
    public final TProOnBoardingCardMoreContentMapper getTProOnBoardingCardMoreContentMapper() {
        return this.tProOnBoardingCardMoreContentMapper;
    }

    @NotNull
    public final TProOnBoardingCardSpanningTitleMapper getTProOnBoardingCardSpanningTitleMapper() {
        return this.tProOnBoardingCardSpanningTitleMapper;
    }

    public final void setTProOnBoardingCardMoreContentMapper(@NotNull TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper2) {
        Intrinsics.checkNotNullParameter(tProOnBoardingCardMoreContentMapper2, "<set-?>");
        this.tProOnBoardingCardMoreContentMapper = tProOnBoardingCardMoreContentMapper2;
    }

    public final void setTProOnBoardingCardSpanningTitleMapper(@NotNull TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper2) {
        Intrinsics.checkNotNullParameter(tProOnBoardingCardSpanningTitleMapper2, "<set-?>");
        this.tProOnBoardingCardSpanningTitleMapper = tProOnBoardingCardSpanningTitleMapper2;
    }

    @NotNull
    public TProOnBoardingCapsuleCardModel apply(@NotNull TProOnBoardingCapsuleCardResponseModel tProOnBoardingCapsuleCardResponseModel) {
        String str;
        Intrinsics.checkNotNullParameter(tProOnBoardingCapsuleCardResponseModel, "source");
        List<TProOnBoardingCardCapsulesResponseModel> content = tProOnBoardingCapsuleCardResponseModel.getContent();
        if (content == null) {
            content = CollectionsKt__CollectionsKt.emptyList();
        }
        List<TProOnBoardingTitleSpanningResponseModel> titleSpanning = tProOnBoardingCapsuleCardResponseModel.getTitleSpanning();
        if (titleSpanning == null) {
            titleSpanning = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable iterable = content;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        Iterator it = iterable.iterator();
        while (true) {
            str = "";
            if (!it.hasNext()) {
                break;
            }
            TProOnBoardingCardCapsulesResponseModel tProOnBoardingCardCapsulesResponseModel = (TProOnBoardingCardCapsulesResponseModel) it.next();
            String title = tProOnBoardingCardCapsulesResponseModel.getTitle();
            if (title == null) {
                title = str;
            }
            String titleColor = tProOnBoardingCardCapsulesResponseModel.getTitleColor();
            if (titleColor == null) {
                titleColor = str;
            }
            String backgroundColor = tProOnBoardingCardCapsulesResponseModel.getBackgroundColor();
            if (backgroundColor == null) {
                backgroundColor = str;
            }
            String image = tProOnBoardingCardCapsulesResponseModel.getImage();
            if (image != null) {
                str = image;
            }
            arrayList.add(new TProOnBoardingCardCapsulesContentModel(title, titleColor, backgroundColor, str));
        }
        String trackingId = tProOnBoardingCapsuleCardResponseModel.getTrackingId();
        String str2 = trackingId == null ? str : trackingId;
        String topImage = tProOnBoardingCapsuleCardResponseModel.getTopImage();
        String str3 = topImage == null ? str : topImage;
        String cardBackgroundColor = tProOnBoardingCapsuleCardResponseModel.getCardBackgroundColor();
        if (cardBackgroundColor == null) {
            cardBackgroundColor = str;
        }
        String cardBackgroundImage = tProOnBoardingCapsuleCardResponseModel.getCardBackgroundImage();
        if (cardBackgroundImage == null) {
            cardBackgroundImage = str;
        }
        Iterable<TProOnBoardingTitleSpanningResponseModel> iterable2 = titleSpanning;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (TProOnBoardingTitleSpanningResponseModel apply : iterable2) {
            arrayList2.add(this.tProOnBoardingCardSpanningTitleMapper.apply(apply));
        }
        Boolean haveMore = tProOnBoardingCapsuleCardResponseModel.getHaveMore();
        boolean booleanValue = haveMore != null ? haveMore.booleanValue() : false;
        TProOnBoardingMoreContentResponseModel moreContent = tProOnBoardingCapsuleCardResponseModel.getMoreContent();
        return new TProOnBoardingCapsuleCardModel(arrayList, str3, cardBackgroundColor, cardBackgroundImage, arrayList2, booleanValue, moreContent != null ? this.tProOnBoardingCardMoreContentMapper.apply(moreContent) : null, str2);
    }
}
