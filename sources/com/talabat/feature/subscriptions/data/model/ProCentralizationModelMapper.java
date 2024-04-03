package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.ProCentralizationResponseResult;
import com.talabat.feature.subscriptions.data.remote.model.SubscriptionResponseModel;
import com.talabat.feature.subscriptions.domain.model.ProCentralization;
import com.talabat.feature.subscriptions.domain.model.Subscription;
import com.talabat.mapper.ModelMapper;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001b\b\u0007\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001¢\u0006\u0002\u0010\u0007J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0002H\u0016R\u001a\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/ProCentralizationModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/ProCentralizationResponseResult;", "Lcom/talabat/feature/subscriptions/domain/model/ProCentralization;", "subscriptionModelMapper", "Lcom/talabat/feature/subscriptions/data/remote/model/SubscriptionResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/Subscription;", "(Lcom/talabat/mapper/ModelMapper;)V", "apply", "source", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProCentralizationModelMapper implements ModelMapper<ProCentralizationResponseResult, ProCentralization> {
    @NotNull
    private final ModelMapper<SubscriptionResponseModel, Subscription> subscriptionModelMapper;

    @Inject
    public ProCentralizationModelMapper(@NotNull ModelMapper<SubscriptionResponseModel, Subscription> modelMapper) {
        Intrinsics.checkNotNullParameter(modelMapper, "subscriptionModelMapper");
        this.subscriptionModelMapper = modelMapper;
    }

    @NotNull
    public ProCentralization apply(@NotNull ProCentralizationResponseResult proCentralizationResponseResult) {
        List list;
        Intrinsics.checkNotNullParameter(proCentralizationResponseResult, "source");
        List<SubscriptionResponseModel> subscriptionsList = proCentralizationResponseResult.getSubscriptionsList();
        if (subscriptionsList != null) {
            Iterable<SubscriptionResponseModel> iterable = subscriptionsList;
            list = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (SubscriptionResponseModel apply : iterable) {
                list.add(this.subscriptionModelMapper.apply(apply));
            }
        } else {
            list = CollectionsKt__CollectionsKt.emptyList();
        }
        Boolean isPro = proCentralizationResponseResult.isPro();
        boolean z11 = false;
        boolean booleanValue = isPro != null ? isPro.booleanValue() : false;
        Boolean showPro = proCentralizationResponseResult.getShowPro();
        if (showPro != null) {
            z11 = showPro.booleanValue();
        }
        return new ProCentralization(list, booleanValue, z11);
    }
}
