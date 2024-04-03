package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingGridCardResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingGridContentResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingMoreContentResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingTitleSpanningResponseModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingGridCardModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingGridContentModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingMoreContentModel;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0002H\u0016R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingGridCardMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingGridCardResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingGridCardModel;", "tProOnBoardingCardSpanningTitleMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;", "tProOnBoardingCardMoreContentMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;)V", "getTProOnBoardingCardMoreContentMapper", "()Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;", "setTProOnBoardingCardMoreContentMapper", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;)V", "getTProOnBoardingCardSpanningTitleMapper", "()Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;", "setTProOnBoardingCardSpanningTitleMapper", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardSpanningTitleMapper;)V", "apply", "source", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingGridCardMapper implements ModelMapper<TProOnBoardingGridCardResponseModel, TProOnBoardingGridCardModel> {
    @NotNull
    private TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper;
    @NotNull
    private TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper;

    @Inject
    public TProOnBoardingGridCardMapper(@NotNull TProOnBoardingCardSpanningTitleMapper tProOnBoardingCardSpanningTitleMapper2, @NotNull TProOnBoardingCardMoreContentMapper tProOnBoardingCardMoreContentMapper2) {
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
    public TProOnBoardingGridCardModel apply(@NotNull TProOnBoardingGridCardResponseModel tProOnBoardingGridCardResponseModel) {
        String str;
        Intrinsics.checkNotNullParameter(tProOnBoardingGridCardResponseModel, "source");
        List<TProOnBoardingGridContentResponseModel> content = tProOnBoardingGridCardResponseModel.getContent();
        if (content == null) {
            content = CollectionsKt__CollectionsKt.emptyList();
        }
        List<TProOnBoardingTitleSpanningResponseModel> titleSpanning = tProOnBoardingGridCardResponseModel.getTitleSpanning();
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
            String url = ((TProOnBoardingGridContentResponseModel) it.next()).getUrl();
            if (url != null) {
                str = url;
            }
            arrayList.add(new TProOnBoardingGridContentModel(str));
        }
        String topImage = tProOnBoardingGridCardResponseModel.getTopImage();
        String str2 = topImage == null ? str : topImage;
        String cardBackgroundColor = tProOnBoardingGridCardResponseModel.getCardBackgroundColor();
        if (cardBackgroundColor == null) {
            cardBackgroundColor = str;
        }
        String cardBackgroundImage = tProOnBoardingGridCardResponseModel.getCardBackgroundImage();
        if (cardBackgroundImage == null) {
            cardBackgroundImage = str;
        }
        Iterable<TProOnBoardingTitleSpanningResponseModel> iterable2 = titleSpanning;
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable2, 10));
        for (TProOnBoardingTitleSpanningResponseModel apply : iterable2) {
            arrayList2.add(this.tProOnBoardingCardSpanningTitleMapper.apply(apply));
        }
        Boolean haveMore = tProOnBoardingGridCardResponseModel.getHaveMore();
        boolean booleanValue = haveMore != null ? haveMore.booleanValue() : false;
        TProOnBoardingMoreContentResponseModel moreContent = tProOnBoardingGridCardResponseModel.getMoreContent();
        TProOnBoardingMoreContentModel apply2 = moreContent != null ? this.tProOnBoardingCardMoreContentMapper.apply(moreContent) : null;
        String trackingId = tProOnBoardingGridCardResponseModel.getTrackingId();
        return new TProOnBoardingGridCardModel(arrayList, str2, cardBackgroundColor, cardBackgroundImage, arrayList2, booleanValue, apply2, trackingId == null ? str : trackingId);
    }
}
