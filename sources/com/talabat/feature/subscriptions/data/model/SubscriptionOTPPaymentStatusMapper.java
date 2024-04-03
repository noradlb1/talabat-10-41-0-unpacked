package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.SubscriptionPaymentOTPPointResponseModel;
import com.talabat.feature.subscriptions.domain.model.SubscriptionOTPPaymentStatus;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/SubscriptionOTPPaymentStatusMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionPaymentOTPPointResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/SubscriptionOTPPaymentStatus;", "()V", "apply", "source", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionOTPPaymentStatusMapper implements ModelMapper<SubscriptionPaymentOTPPointResponseModel, SubscriptionOTPPaymentStatus> {
    @NotNull
    public SubscriptionOTPPaymentStatus apply(@NotNull SubscriptionPaymentOTPPointResponseModel subscriptionPaymentOTPPointResponseModel) {
        String str;
        String str2;
        Intrinsics.checkNotNullParameter(subscriptionPaymentOTPPointResponseModel, "source");
        Boolean isSuccessful = subscriptionPaymentOTPPointResponseModel.isSuccessful();
        boolean booleanValue = isSuccessful != null ? isSuccessful.booleanValue() : false;
        String imageUrl = subscriptionPaymentOTPPointResponseModel.getImageUrl();
        String str3 = imageUrl == null ? "" : imageUrl;
        String title = subscriptionPaymentOTPPointResponseModel.getTitle();
        if (title == null) {
            str = "";
        } else {
            str = title;
        }
        String description = subscriptionPaymentOTPPointResponseModel.getDescription();
        if (description == null) {
            str2 = "";
        } else {
            str2 = description;
        }
        String buttonTitle = subscriptionPaymentOTPPointResponseModel.getButtonTitle();
        if (buttonTitle == null) {
            buttonTitle = "";
        }
        return new SubscriptionOTPPaymentStatus(booleanValue, str3, str, str2, buttonTitle);
    }
}
