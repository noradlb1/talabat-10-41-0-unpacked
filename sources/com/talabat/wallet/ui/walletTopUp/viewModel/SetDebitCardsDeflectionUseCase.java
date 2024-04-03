package com.talabat.wallet.ui.walletTopUp.viewModel;

import com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase;
import com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J$\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0002J\u001f\u0010\r\u001a\u00020\u000e2\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u000f0\bHBø\u0001\u0000¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0011"}, d2 = {"Lcom/talabat/wallet/ui/walletTopUp/viewModel/SetDebitCardsDeflectionUseCase;", "", "debitCardDeflectionUseCase", "Lcom/talabat/talabatcommon/feature/walletCardList/DebitCardDeflectionUseCase;", "(Lcom/talabat/talabatcommon/feature/walletCardList/DebitCardDeflectionUseCase;)V", "disableDeflectionCards", "", "cards", "", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel$WalletCardAdapterDisplayModel;", "numbers", "", "", "invoke", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemWithTypeDisplayModel;", "Lcom/talabat/wallet/ui/walletTopUp/model/WalletCreditCardListDataItemDisplayModel;", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SetDebitCardsDeflectionUseCase {
    @NotNull
    private final DebitCardDeflectionUseCase debitCardDeflectionUseCase;

    public SetDebitCardsDeflectionUseCase(@NotNull DebitCardDeflectionUseCase debitCardDeflectionUseCase2) {
        Intrinsics.checkNotNullParameter(debitCardDeflectionUseCase2, "debitCardDeflectionUseCase");
        this.debitCardDeflectionUseCase = debitCardDeflectionUseCase2;
    }

    private final void disableDeflectionCards(List<WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel> list, Set<String> set) {
        for (WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel walletCardAdapterDisplayModel : list) {
            walletCardAdapterDisplayModel.setEnabled(!set.contains(walletCardAdapterDisplayModel.getBinNumber()));
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(@org.jetbrains.annotations.NotNull java.util.List<? extends com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel> r14, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel> r15) {
        /*
            r13 = this;
            boolean r0 = r15 instanceof com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase$invoke$1
            if (r0 == 0) goto L_0x0013
            r0 = r15
            com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase$invoke$1 r0 = (com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase$invoke$1) r0
            int r1 = r0.f12816n
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f12816n = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase$invoke$1 r0 = new com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase$invoke$1
            r0.<init>(r13, r15)
        L_0x0018:
            java.lang.Object r15 = r0.f12814l
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f12816n
            r3 = 1
            if (r2 == 0) goto L_0x0043
            if (r2 != r3) goto L_0x003b
            java.lang.Object r14 = r0.f12813k
            com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel$DeflectionType r14 = (com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel.DeflectionType) r14
            java.lang.Object r1 = r0.f12812j
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r2 = r0.f12811i
            java.util.List r2 = (java.util.List) r2
            java.lang.Object r0 = r0.f12810h
            com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase r0 = (com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase) r0
            kotlin.ResultKt.throwOnFailure(r15)
            r4 = r14
            r14 = r2
            goto L_0x008b
        L_0x003b:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x0043:
            kotlin.ResultKt.throwOnFailure(r15)
            r15 = r14
            java.lang.Iterable r15 = (java.lang.Iterable) r15
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r15 = r15.iterator()
        L_0x0052:
            boolean r4 = r15.hasNext()
            if (r4 == 0) goto L_0x0064
            java.lang.Object r4 = r15.next()
            boolean r5 = r4 instanceof com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemDisplayModel.WalletCardAdapterDisplayModel
            if (r5 == 0) goto L_0x0052
            r2.add(r4)
            goto L_0x0052
        L_0x0064:
            java.lang.String r5 = ","
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase$invoke$bins$1 r10 = com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase$invoke$bins$1.INSTANCE
            r11 = 30
            r12 = 0
            r4 = r2
            java.lang.String r15 = kotlin.collections.CollectionsKt___CollectionsKt.joinToString$default(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel$DeflectionType r4 = com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel.DeflectionType.NONE
            com.talabat.talabatcommon.feature.walletCardList.DebitCardDeflectionUseCase r5 = r13.debitCardDeflectionUseCase
            r0.f12810h = r13
            r0.f12811i = r14
            r0.f12812j = r2
            r0.f12813k = r4
            r0.f12816n = r3
            java.lang.Object r15 = r5.invoke(r15, r0)
            if (r15 != r1) goto L_0x0089
            return r1
        L_0x0089:
            r0 = r13
            r1 = r2
        L_0x008b:
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel r15 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel) r15
            boolean r2 = r15 instanceof com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel.ShowBahrainBenefit
            if (r2 == 0) goto L_0x00ac
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel$ShowBahrainBenefit r15 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel.ShowBahrainBenefit) r15
            java.util.Set r2 = r15.getNumbers()
            r0.disableDeflectionCards(r1, r2)
            java.util.Set r15 = r15.getNumbers()
            boolean r15 = r15.isEmpty()
            r15 = r15 ^ r3
            if (r15 == 0) goto L_0x00a8
            com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel$DeflectionType r15 = com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel.DeflectionType.BENEFITS
            goto L_0x00aa
        L_0x00a8:
            com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel$DeflectionType r15 = com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel.DeflectionType.NONE
        L_0x00aa:
            r4 = r15
            goto L_0x00ca
        L_0x00ac:
            boolean r2 = r15 instanceof com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel.ShowQPay
            if (r2 == 0) goto L_0x00ca
            com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel$ShowQPay r15 = (com.talabat.talabatcommon.views.wallet.cardViewWidgets.viewModel.DeflectionInfoDisplayModel.ShowQPay) r15
            java.util.Set r2 = r15.getNumbers()
            r0.disableDeflectionCards(r1, r2)
            java.util.Set r15 = r15.getNumbers()
            boolean r15 = r15.isEmpty()
            r15 = r15 ^ r3
            if (r15 == 0) goto L_0x00c7
            com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel$DeflectionType r15 = com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel.DeflectionType.QPAY
            goto L_0x00aa
        L_0x00c7:
            com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel$DeflectionType r15 = com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel.DeflectionType.NONE
            goto L_0x00aa
        L_0x00ca:
            com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel r15 = new com.talabat.wallet.ui.walletTopUp.model.WalletCreditCardListDataItemWithTypeDisplayModel
            r15.<init>(r14, r4)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.ui.walletTopUp.viewModel.SetDebitCardsDeflectionUseCase.invoke(java.util.List, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
