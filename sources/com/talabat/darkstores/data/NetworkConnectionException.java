package com.talabat.darkstores.data;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/talabat/darkstores/data/NetworkConnectionException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "message", "", "(Ljava/lang/String;)V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class NetworkConnectionException extends Exception {
    public NetworkConnectionException() {
        this((String) null, 1, (DefaultConstructorMarker) null);
    }

    public NetworkConnectionException(@Nullable String str) {
        super(str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NetworkConnectionException(String str, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str);
    }
}
