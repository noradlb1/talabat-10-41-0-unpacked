package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.TProOnBoardingMoreContentItemResponseModel;
import com.talabat.feature.subscriptions.domain.model.TProOnBoardingMoreContentItemModel;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/TProOnBoardingCardMoreContentItemMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/TProOnBoardingMoreContentItemResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/TProOnBoardingMoreContentItemModel;", "()V", "apply", "source", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TProOnBoardingCardMoreContentItemMapper implements ModelMapper<TProOnBoardingMoreContentItemResponseModel, TProOnBoardingMoreContentItemModel> {
    @NotNull
    public TProOnBoardingMoreContentItemModel apply(@NotNull TProOnBoardingMoreContentItemResponseModel tProOnBoardingMoreContentItemResponseModel) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        Intrinsics.checkNotNullParameter(tProOnBoardingMoreContentItemResponseModel, "source");
        String backgroundColor = tProOnBoardingMoreContentItemResponseModel.getBackgroundColor();
        String str6 = backgroundColor == null ? "" : backgroundColor;
        String leadingImage = tProOnBoardingMoreContentItemResponseModel.getLeadingImage();
        if (leadingImage == null) {
            str = "";
        } else {
            str = leadingImage;
        }
        String leadingText = tProOnBoardingMoreContentItemResponseModel.getLeadingText();
        if (leadingText == null) {
            str2 = "";
        } else {
            str2 = leadingText;
        }
        String leadingTextColor = tProOnBoardingMoreContentItemResponseModel.getLeadingTextColor();
        if (leadingTextColor == null) {
            str3 = "";
        } else {
            str3 = leadingTextColor;
        }
        String trailingText = tProOnBoardingMoreContentItemResponseModel.getTrailingText();
        if (trailingText == null) {
            str4 = "";
        } else {
            str4 = trailingText;
        }
        String trailingTextColor = tProOnBoardingMoreContentItemResponseModel.getTrailingTextColor();
        if (trailingTextColor == null) {
            str5 = "";
        } else {
            str5 = trailingTextColor;
        }
        String type = tProOnBoardingMoreContentItemResponseModel.getType();
        if (type == null) {
            type = "";
        }
        return new TProOnBoardingMoreContentItemModel(str6, str, str2, str3, str4, str5, type);
    }
}
