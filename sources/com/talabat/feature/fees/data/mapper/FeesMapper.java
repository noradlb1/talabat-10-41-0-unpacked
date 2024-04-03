package com.talabat.feature.fees.data.mapper;

import com.talabat.feature.fees.data.remote.dto.Fee;
import com.talabat.feature.fees.data.remote.dto.FeeDescription;
import com.talabat.feature.fees.data.remote.dto.FeeDescriptionDetails;
import com.talabat.feature.fees.data.remote.dto.FeesResponse;
import com.talabat.feature.fees.domain.model.FeeDescriptionType;
import com.talabat.feature.fees.domain.model.Fees;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/fees/data/mapper/FeesMapper;", "", "()V", "map", "Lcom/talabat/feature/fees/domain/model/Fees;", "feesResponse", "Lcom/talabat/feature/fees/data/remote/dto/FeesResponse;", "com_talabat_feature_pricing_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeesMapper {
    @NotNull
    public final Fees map(@NotNull FeesResponse feesResponse) {
        String str;
        Intrinsics.checkNotNullParameter(feesResponse, "feesResponse");
        Iterable<Fee> fees = feesResponse.getFees();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(fees, 10));
        for (Fee fee : fees) {
            arrayList.add(new com.talabat.feature.fees.domain.model.Fee(fee.getFeeType(), fee.getName(), fee.getSetupValue(), fee.getValueType(), fee.getTotal(), fee.getTags()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (FeeDescription feeDescription : feesResponse.getFeesDescriptions()) {
            com.talabat.feature.fees.domain.model.FeeDescription feeDescription2 = null;
            try {
                FeeDescriptionType valueOf = FeeDescriptionType.valueOf(feeDescription.getFeeType());
                String name2 = feeDescription.getName();
                String description = feeDescription.getDescription();
                String url = feeDescription.getUrl();
                String urlText = feeDescription.getUrlText();
                FeeDescriptionDetails details = feeDescription.getDetails();
                if (details != null) {
                    str = details.getExplanation();
                } else {
                    str = null;
                }
                feeDescription2 = new com.talabat.feature.fees.domain.model.FeeDescription(valueOf, name2, description, str, url, urlText);
            } catch (IllegalArgumentException unused) {
            }
            if (feeDescription2 != null) {
                arrayList2.add(feeDescription2);
            }
        }
        return new Fees(arrayList, arrayList2);
    }
}
