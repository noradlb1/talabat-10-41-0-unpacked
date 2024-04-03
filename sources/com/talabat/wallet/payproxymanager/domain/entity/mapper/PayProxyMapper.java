package com.talabat.wallet.payproxymanager.domain.entity.mapper;

import com.talabat.talabatcommon.extentions.BooleanKt;
import com.talabat.wallet.payproxymanager.data.remote.dto.response.PayProxyCVVRemoteDto;
import com.talabat.wallet.payproxymanager.domain.entity.PayProxyCVVResult;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/payproxymanager/domain/entity/mapper/PayProxyMapper;", "", "()V", "mapToPayProxyCVV", "Lcom/talabat/wallet/payproxymanager/domain/entity/PayProxyCVVResult;", "payProxyCVVRemoteDto", "Lcom/talabat/wallet/payproxymanager/data/remote/dto/response/PayProxyCVVRemoteDto;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PayProxyMapper {
    @NotNull
    public static final PayProxyMapper INSTANCE = new PayProxyMapper();

    private PayProxyMapper() {
    }

    @NotNull
    public final PayProxyCVVResult mapToPayProxyCVV(@Nullable PayProxyCVVRemoteDto payProxyCVVRemoteDto) {
        Boolean bool;
        if (payProxyCVVRemoteDto != null) {
            bool = payProxyCVVRemoteDto.getHasErrors();
        } else {
            bool = null;
        }
        if (BooleanKt.orTrue(bool)) {
            return PayProxyCVVResult.CVVServerError.INSTANCE;
        }
        return PayProxyCVVResult.CVVSuccessful.INSTANCE;
    }
}
