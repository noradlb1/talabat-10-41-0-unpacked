package com.talabat.growth.features.vouchers.domain;

import com.talabat.talabatcommon.feature.vouchers.loyalty.mapper.VoucherDetailDomainModel;
import com.talabat.talabatcommon.feature.vouchers.loyalty.repository.VoucherRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/growth/features/vouchers/domain/GetVoucherDetailsUseCase;", "", "voucherRepository", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;", "(Lcom/talabat/talabatcommon/feature/vouchers/loyalty/repository/VoucherRepository;)V", "invoke", "Lcom/talabat/talabatcommon/feature/vouchers/loyalty/mapper/VoucherDetailDomainModel;", "voucherID", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetVoucherDetailsUseCase {
    @NotNull
    private final VoucherRepository voucherRepository;

    public GetVoucherDetailsUseCase(@NotNull VoucherRepository voucherRepository2) {
        Intrinsics.checkNotNullParameter(voucherRepository2, "voucherRepository");
        this.voucherRepository = voucherRepository2;
    }

    @Nullable
    public final Object invoke(@NotNull String str, @NotNull Continuation<? super VoucherDetailDomainModel> continuation) {
        return this.voucherRepository.getVoucherDetails(str, continuation);
    }
}
