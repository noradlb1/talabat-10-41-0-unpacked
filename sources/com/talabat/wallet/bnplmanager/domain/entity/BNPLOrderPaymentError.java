package com.talabat.wallet.bnplmanager.domain.entity;

import com.talabat.mapper.ModelMapping;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLOrderPaymentError;", "", "title", "", "description", "code", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getDescription", "getTitle", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLOrderPaymentError {
    @NotNull
    @ModelMapping({"code"})
    private final String code;
    @NotNull
    @ModelMapping({"description"})
    private final String description;
    @NotNull
    @ModelMapping({"title"})
    private final String title;

    public BNPLOrderPaymentError() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public BNPLOrderPaymentError(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, Constant.PARAM_ERROR_CODE);
        this.title = str;
        this.description = str2;
        this.code = str3;
    }

    @NotNull
    public final String getCode() {
        return this.code;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ BNPLOrderPaymentError(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? "" : str2, (i11 & 4) != 0 ? "" : str3);
    }
}
