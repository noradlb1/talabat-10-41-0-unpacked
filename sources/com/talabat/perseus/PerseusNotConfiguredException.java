package com.talabat.perseus;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u0016\u0010\u0004\u001a\u0004\u0018\u00010\u00058VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/perseus/PerseusNotConfiguredException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "()V", "message", "", "getMessage", "()Ljava/lang/String;", "com_talabat_ThirdPartyLibs_Perseus_Perseus"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PerseusNotConfiguredException extends Exception {
    @Nullable
    public String getMessage() {
        return "Perseus SDK is not initialized";
    }
}
