package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingCardTagsContentResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingMoreContentResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingTagsCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingTitleSpanningResponseModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingCardTagsModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingMoreContentModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingTagsCardModel;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingTagsCardMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingTagsCardResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingTagsCardModel;", "tProOnBoardingCardSpanningTitleMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;", "tProOnBoardingCardMoreContentMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;)V", "getTProOnBoardingCardMoreContentMapper", "()Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;", "setTProOnBoardingCardMoreContentMapper", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;)V", "getTProOnBoardingCardSpanningTitleMapper", "()Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;", "setTProOnBoardingCardSpanningTitleMapper", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;)V", "apply", "source", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingTagsCardMapper implements ModelMapper<TProOnBoardingTagsCardResponseModel, TProOnBoardingTagsCardModel> {
    @NotNull
    private TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper;
    @NotNull
    private TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper;

    @Inject
    public TProOnBoardingTagsCardMapper(@NotNull TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper2, @NotNull TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper2) {
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
    public TProOnBoardingTagsCardModel apply(@NotNull TProOnBoardingTagsCardResponseModel tProOnBoardingTagsCardResponseModel) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        Intrinsics.checkNotNullParameter(tProOnBoardingTagsCardResponseModel, "source");
        List<TProOnBoardingCardTagsContentResponseModel> content = tProOnBoardingTagsCardResponseModel.getContent();
        if (content == null) {
            content = CollectionsKt__CollectionsKt.emptyList();
        }
        List<TProOnBoardingTitleSpanningResponseModel> titleSpanning = tProOnBoardingTagsCardResponseModel.getTitleSpanning();
        if (titleSpanning == null) {
            titleSpanning = CollectionsKt__CollectionsKt.emptyList();
        }
        Iterable<TProOnBoardingCardTagsContentResponseModel> iterable = content;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TProOnBoardingCardTagsContentResponseModel tProOnBoardingCardTagsContentResponseModel : iterable) {
            String title = tProOnBoardingCardTagsContentResponseModel.getTitle();
            if (title == null) {
                str3 = "";
            } else {
                str3 = title;
            }
            String titleColor = tProOnBoardingCardTagsContentResponseModel.getTitleColor();
            if (titleColor == null) {
                str4 = "";
            } else {
                str4 = titleColor;
            }
            String background = tProOnBoardingCardTagsContentResponseModel.getBackground();
            if (background == null) {
                str5 = "";
            } else {
                str5 = background;
            }
            String image = tProOnBoardingCardTagsContentResponseModel.getImage();
            if (image == null) {
                str6 = "";
            } else {
                str6 = image;
            }
            String imageBackgroundColor = tProOnBoardingCardTagsContentResponseModel.getImageBackgroundColor();
            if (imageBackgroundColor == null) {
                str7 = "";
            } else {
                str7 = imageBackgroundColor;
            }
            String toolTipImage = tProOnBoardingCardTagsContentResponseModel.getToolTipImage();
            if (toolTipImage == null) {
                str8 = "";
            } else {
                str8 = toolTipImage;
            }
            arrayList.add(new TProOnBoardingCardTagsModel(str3, str4, str5, str6, str7, str8));
        }
        String topImage = tProOnBoardingTagsCardResponseModel.getTopImage();
        if (topImage == null) {
            str = "";
        } else {
            str = topImage;
        }
        String cardBackgroundColor = tProOnBoardingTagsCardResponseModel.getCardBackgroundColor();
        if (cardBackgroundColor == null) {
            cardBackgroundColor = "";
        }
        String cardBackgroundImage = tProOnBoardingTagsCardResponseModel.getCardBackgroundImage();
        if (cardBackgroundImage == null) {
            cardBackgroundImage = "";
        }
        Iterable<TProOnBoardingTitleSpanningResponseModel> iterable2 = titleSpanning;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (TProOnBoardingTitleSpanningResponseModel apply : iterable2) {
            arrayList2.add(this.tProOnBoardingCardSpanningTitleMapper.apply(apply));
        }
        Boolean haveMore = tProOnBoardingTagsCardResponseModel.getHaveMore();
        boolean booleanValue = haveMore != null ? haveMore.booleanValue() : false;
        TProOnBoardingMoreContentResponseModel moreContent = tProOnBoardingTagsCardResponseModel.getMoreContent();
        TProOnBoardingMoreContentModel apply2 = moreContent != null ? this.tProOnBoardingCardMoreContentMapper.apply(moreContent) : null;
        String trackingId = tProOnBoardingTagsCardResponseModel.getTrackingId();
        if (trackingId == null) {
            str2 = "";
        } else {
            str2 = trackingId;
        }
        return new TProOnBoardingTagsCardModel(arrayList, str, cardBackgroundColor, cardBackgroundImage, arrayList2, booleanValue, apply2, str2);
    }
}
