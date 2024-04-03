package com.talabat.authentication.token.data.local;

import com.talabat.authentication.token.data.model.SwapTokenData;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/authentication/token/data/local/LegacyTokenLocalDataSource;", "", "swapTokenData", "Lcom/talabat/authentication/token/data/model/SwapTokenData;", "getSwapTokenData", "()Lcom/talabat/authentication/token/data/model/SwapTokenData;", "setSwapTokenData", "(Lcom/talabat/authentication/token/data/model/SwapTokenData;)V", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LegacyTokenLocalDataSource {
    @Nullable
    SwapTokenData getSwapTokenData();

    void setSwapTokenData(@Nullable SwapTokenData swapTokenData);
}
