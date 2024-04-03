package com.talabat.wallet.helpers;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\t"}, d2 = {"Lcom/talabat/wallet/helpers/ResponseStatus;", "", "status", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getStatus", "()Ljava/lang/String;", "SUCCESS", "ERROR", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum ResponseStatus {
    SUCCESS("success"),
    ERROR("error");
    
    @Nullable
    private final String status;

    private ResponseStatus(String str) {
        this.status = str;
    }

    @Nullable
    public final String getStatus() {
        return this.status;
    }
}
