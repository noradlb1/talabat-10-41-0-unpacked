package com.talabat.wallet.features.walletTransactionList;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListDisplayModel;
import com.talabat.wallet.ui.walletDashboard.model.WalletTransactionListMapper;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0002H\u0002¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/features/walletTransactionList/GetFormattedWalletTransactionListUseCase;", "Lkotlin/Function1;", "Lcom/talabat/wallet/features/walletTransactionList/WalletTransactionListFormatterParam;", "Lcom/talabat/wallet/ui/walletDashboard/model/WalletTransactionListDisplayModel;", "()V", "invoke", "param", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetFormattedWalletTransactionListUseCase implements Function1<WalletTransactionListFormatterParam, WalletTransactionListDisplayModel> {
    @NotNull
    public WalletTransactionListDisplayModel invoke(@NotNull WalletTransactionListFormatterParam walletTransactionListFormatterParam) {
        Intrinsics.checkNotNullParameter(walletTransactionListFormatterParam, RemoteMessageConst.MessageBody.PARAM);
        return WalletTransactionListMapper.Companion.mapWalletTransactionListToDisplayModel(walletTransactionListFormatterParam.getWalletTransactionListResponse(), walletTransactionListFormatterParam.isFirstResponse(), walletTransactionListFormatterParam.getLastDisplayModel());
    }
}
