package com.talabat.authentication.token.data.remote;

import com.talabat.authentication.token.data.model.SwapTokenData;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\b"}, d2 = {"Lcom/talabat/authentication/token/data/remote/LegacyTokenRemoteDataSource;", "", "swapToLegacyToken", "Lio/reactivex/Single;", "Lcom/talabat/authentication/token/data/model/SwapTokenData;", "tokenType", "", "accessToken", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface LegacyTokenRemoteDataSource {
    @NotNull
    Single<SwapTokenData> swapToLegacyToken(@NotNull String str, @NotNull String str2);
}
