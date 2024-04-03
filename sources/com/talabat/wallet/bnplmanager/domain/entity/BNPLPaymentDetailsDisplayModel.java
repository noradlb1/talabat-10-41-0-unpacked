package com.talabat.wallet.bnplmanager.domain.entity;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001a\u0010\f\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR \u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0006\"\u0004\b\u0018\u0010\b¨\u0006\u0019"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPaymentDetailsDisplayModel;", "", "()V", "dueDate", "", "getDueDate", "()Ljava/lang/String;", "setDueDate", "(Ljava/lang/String;)V", "dueToday", "getDueToday", "setDueToday", "installmentAmount", "getInstallmentAmount", "setInstallmentAmount", "installmentDetailList", "", "Lcom/talabat/wallet/bnplmanager/domain/entity/InstallmentDetail;", "getInstallmentDetailList", "()Ljava/util/List;", "setInstallmentDetailList", "(Ljava/util/List;)V", "orderAmount", "getOrderAmount", "setOrderAmount", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLPaymentDetailsDisplayModel {
    @NotNull
    private String dueDate = "";
    @NotNull
    private String dueToday = "";
    @NotNull
    private String installmentAmount = "";
    @NotNull
    private List<InstallmentDetail> installmentDetailList = CollectionsKt__CollectionsKt.emptyList();
    @NotNull
    private String orderAmount = "";

    @NotNull
    public final String getDueDate() {
        return this.dueDate;
    }

    @NotNull
    public final String getDueToday() {
        return this.dueToday;
    }

    @NotNull
    public final String getInstallmentAmount() {
        return this.installmentAmount;
    }

    @NotNull
    public final List<InstallmentDetail> getInstallmentDetailList() {
        return this.installmentDetailList;
    }

    @NotNull
    public final String getOrderAmount() {
        return this.orderAmount;
    }

    public final void setDueDate(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dueDate = str;
    }

    public final void setDueToday(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.dueToday = str;
    }

    public final void setInstallmentAmount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.installmentAmount = str;
    }

    public final void setInstallmentDetailList(@NotNull List<InstallmentDetail> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.installmentDetailList = list;
    }

    public final void setOrderAmount(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.orderAmount = str;
    }
}
