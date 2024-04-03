package com.talabat.feature.subscriptions.data.model;

import com.talabat.feature.subscriptions.data.remote.model.ProVendorMovResponseModel;
import com.talabat.feature.subscriptions.domain.model.ProVendorMov;
import com.talabat.mapper.ModelMapper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, d2 = {"Lcom/talabat/feature/subscriptions/data/model/ProVendorMovModelMapper;", "Lcom/talabat/mapper/ModelMapper;", "Lcom/talabat/feature/subscriptions/data/remote/model/ProVendorMovResponseModel;", "Lcom/talabat/feature/subscriptions/domain/model/ProVendorMov;", "()V", "apply", "source", "com_talabat_feature_subscriptions_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ProVendorMovModelMapper implements ModelMapper<ProVendorMovResponseModel, ProVendorMov> {
    @NotNull
    public ProVendorMov apply(@NotNull ProVendorMovResponseModel proVendorMovResponseModel) {
        Intrinsics.checkNotNullParameter(proVendorMovResponseModel, "source");
        Float mov = proVendorMovResponseModel.getMov();
        Integer branchId = proVendorMovResponseModel.getBranchId();
        boolean z11 = false;
        int intValue = branchId != null ? branchId.intValue() : 0;
        Boolean isTalabatPro = proVendorMovResponseModel.isTalabatPro();
        if (isTalabatPro != null) {
            z11 = isTalabatPro.booleanValue();
        }
        return new ProVendorMov(mov, intValue, z11);
    }
}
