package com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote;

import com.talabat.talabatcommon.views.wallet.benefitmanager.data.remote.dto.BenefitBinDetailRemoteDto;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0019\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0006\u0002\u0004\n\u0002\b\u0019¨\u0006\u0007"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/BenefitManagerRemoteDataSource;", "", "getBinDetails", "Lcom/talabat/talabatcommon/views/wallet/benefitmanager/data/remote/dto/BenefitBinDetailRemoteDto;", "bins", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BenefitManagerRemoteDataSource {
    @Nullable
    Object getBinDetails(@NotNull String str, @NotNull Continuation<? super BenefitBinDetailRemoteDto> continuation);
}
