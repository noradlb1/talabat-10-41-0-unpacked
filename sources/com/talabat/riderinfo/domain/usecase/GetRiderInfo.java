package com.talabat.riderinfo.domain.usecase;

import com.talabat.riderinfo.domain.entity.RiderInfo;
import com.talabat.riderinfo.domain.repository.RiderInfoRepository;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0019\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bHBø\u0001\u0000¢\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\n"}, d2 = {"Lcom/talabat/riderinfo/domain/usecase/GetRiderInfo;", "", "riderInfoRepository", "Lcom/talabat/riderinfo/domain/repository/RiderInfoRepository;", "(Lcom/talabat/riderinfo/domain/repository/RiderInfoRepository;)V", "invoke", "Lcom/talabat/riderinfo/domain/entity/RiderInfo;", "orderId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_RiderInfo_RiderInfo"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetRiderInfo {
    @NotNull
    private final RiderInfoRepository riderInfoRepository;

    public GetRiderInfo(@NotNull RiderInfoRepository riderInfoRepository2) {
        Intrinsics.checkNotNullParameter(riderInfoRepository2, "riderInfoRepository");
        this.riderInfoRepository = riderInfoRepository2;
    }

    @Nullable
    public final Object invoke(@NotNull String str, @NotNull Continuation<? super RiderInfo> continuation) {
        return this.riderInfoRepository.getRiderInfo(str, continuation);
    }
}
