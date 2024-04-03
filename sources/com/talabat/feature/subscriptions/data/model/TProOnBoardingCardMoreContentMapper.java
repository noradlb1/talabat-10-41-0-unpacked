package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingMoreContentItemResponseModel;
import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingMoreContentResponseModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingMoreContentModel;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\u0002H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingMoreContentResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentModel;", "tProOnBoardingCardMoreContentItemMapper", "Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentItemMapper;", "(Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentItemMapper;)V", "apply", "source", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingCardMoreContentMapper implements ModelMapper<TProOnBoardingMoreContentResponseModel, TProOnBoardingMoreContentModel> {
    @NotNull
    private final TProOnBoardingCardMoreContentItemMapper tProOnBoardingCardMoreContentItemMapper;

    @Inject
    public TProOnBoardingCardMoreContentMapper(@NotNull TProOnBoardingCardMoreContentItemMapper tProOnBoardingCardMoreContentItemMapper2) {
        Intrinsics.checkNotNullParameter(tProOnBoardingCardMoreContentItemMapper2, "tProOnBoardingCardMoreContentItemMapper");
        this.tProOnBoardingCardMoreContentItemMapper = tProOnBoardingCardMoreContentItemMapper2;
    }

    @NotNull
    public TProOnBoardingMoreContentModel apply(@NotNull TProOnBoardingMoreContentResponseModel tProOnBoardingMoreContentResponseModel) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(tProOnBoardingMoreContentResponseModel, "source");
        List<TProOnBoardingMoreContentItemResponseModel> items = tProOnBoardingMoreContentResponseModel.getItems();
        if (items == null) {
            items = CollectionsKt__CollectionsKt.emptyList();
        }
        String ctaTitle = tProOnBoardingMoreContentResponseModel.getCtaTitle();
        String str6 = ctaTitle == null ? "" : ctaTitle;
        String ctaTitleColor = tProOnBoardingMoreContentResponseModel.getCtaTitleColor();
        if (ctaTitleColor == null) {
            str = "";
        } else {
            str = ctaTitleColor;
        }
        String titleColor = tProOnBoardingMoreContentResponseModel.getTitleColor();
        if (titleColor == null) {
            str2 = "";
        } else {
            str2 = titleColor;
        }
        String ctaBackgroundColor = tProOnBoardingMoreContentResponseModel.getCtaBackgroundColor();
        if (ctaBackgroundColor == null) {
            str3 = "";
        } else {
            str3 = ctaBackgroundColor;
        }
        String contentBackgroundColor = tProOnBoardingMoreContentResponseModel.getContentBackgroundColor();
        if (contentBackgroundColor == null) {
            str4 = "";
        } else {
            str4 = contentBackgroundColor;
        }
        Iterable<TProOnBoardingMoreContentItemResponseModel> iterable = items;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
        for (TProOnBoardingMoreContentItemResponseModel apply : iterable) {
            arrayList.add(this.tProOnBoardingCardMoreContentItemMapper.apply(apply));
        }
        String title = tProOnBoardingMoreContentResponseModel.getTitle();
        if (title == null) {
            str5 = "";
        } else {
            str5 = title;
        }
        return new TProOnBoardingMoreContentModel(str6, str, str3, str5, str2, str4, arrayList);
    }
}
