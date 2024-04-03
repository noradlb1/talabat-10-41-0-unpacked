package com.talabat.wallet.features.walletCashBack;

import com.huawei.hms.push.constant.RemoteMessageConst;
import com.talabat.talabatcommon.extentions.SafeLetKt;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u0014\u0012\u0004\u0012\u00020\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0005J\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0007\u001a\u00020\u0002H\u0002¨\u0006\b"}, d2 = {"Lcom/talabat/wallet/features/walletCashBack/GetFormattedWalletTopUpListUseCase;", "Lkotlin/Function1;", "Lcom/talabat/wallet/features/walletCashBack/WalletTopUpListFormatterParam;", "", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "()V", "invoke", "param", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GetFormattedWalletTopUpListUseCase implements Function1<WalletTopUpListFormatterParam, List<? extends WalletCreditCardListDataItemDisplayModel>> {
    @NotNull
    public List<WalletCreditCardListDataItemDisplayModel> invoke(@NotNull WalletTopUpListFormatterParam walletTopUpListFormatterParam) {
        Intrinsics.checkNotNullParameter(walletTopUpListFormatterParam, RemoteMessageConst.MessageBody.PARAM);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = new ArrayList();
        SafeLetKt.safeLet(walletTopUpListFormatterParam.getWalletTransactionListResponse(), walletTopUpListFormatterParam.getWalletCardListDisplayModel(), new GetFormattedWalletTopUpListUseCase$invoke$1(objectRef));
        return (List) objectRef.element;
    }
}
