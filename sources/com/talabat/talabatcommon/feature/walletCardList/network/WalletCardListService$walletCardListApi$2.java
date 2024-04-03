package com.talabat.talabatcommon.feature.walletCardList.network;

import com.talabat.core.network.endpoint.MonolithEndPointProvider;
import com.talabat.core.network.network.TalabatAPIBuilder;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/talabat/talabatcommon/feature/walletCardList/network/WalletCardListApi;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class WalletCardListService$walletCardListApi$2 extends Lambda implements Function0<WalletCardListApi> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ TalabatAPIBuilder f61706g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public WalletCardListService$walletCardListApi$2(TalabatAPIBuilder talabatAPIBuilder) {
        super(0);
        this.f61706g = talabatAPIBuilder;
    }

    @NotNull
    public final WalletCardListApi invoke() {
        return (WalletCardListApi) this.f61706g.createApi(MonolithEndPointProvider.INSTANCE.getBaseUrl(), WalletCardListApi.class);
    }
}
