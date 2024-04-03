package com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.impl;

import com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.BenefitManagerRemoteDataSource;
import com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.api.BenefitManagerApi;
import com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.dto.BenefitBinDetailRemoteDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH@ø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/impl/BenefitManagerRemoteDataSourceImpl;", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/BenefitManagerRemoteDataSource;", "benefitManagerApi", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/api/BenefitManagerApi;", "(Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/api/BenefitManagerApi;)V", "getBinDetails", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinDetailRemoteDto;", "bins", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitManagerRemoteDataSourceImpl implements BenefitManagerRemoteDataSource {
    @NotNull
    private final BenefitManagerApi benefitManagerApi;

    public BenefitManagerRemoteDataSourceImpl(@NotNull BenefitManagerApi benefitManagerApi2) {
        Intrinsics.checkNotNullParameter(benefitManagerApi2, "benefitManagerApi");
        this.benefitManagerApi = benefitManagerApi2;
    }

    @Nullable
    public Object getBinDetails(@NotNull String str, @NotNull Continuation<? super BenefitBinDetailRemoteDto> continuation) {
        return this.benefitManagerApi.getBinDetails(str, continuation);
    }
}
