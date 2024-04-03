package com.talabat.wallet.knetStatusManager.domain.repository;

import com.talabat.wallet.knetStatusManager.domain.entity.KNetStatus;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0011\u0010\u0002\u001a\u00020\u0003H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0004\u0002\u0004\n\u0002\b\u0019¨\u0006\u0005"}, d2 = {"Lcom/talabat/wallet/knetStatusManager/domain/repository/KNetStatusManagerRepository;", "", "getKNetStatus", "Lcom/talabat/wallet/knetStatusManager/domain/entity/KNetStatus;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface KNetStatusManagerRepository {
    @Nullable
    Object getKNetStatus(@NotNull Continuation<? super KNetStatus> continuation);
}
