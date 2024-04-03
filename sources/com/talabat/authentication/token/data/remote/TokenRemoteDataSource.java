package com.talabat.authentication.token.data.remote;

import com.talabat.authentication.token.data.model.TokenData;
import io.reactivex.Single;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u000e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H&¨\u0006\u0005"}, d2 = {"Lcom/talabat/authentication/token/data/remote/TokenRemoteDataSource;", "", "fetchClientTokenData", "Lio/reactivex/Single;", "Lcom/talabat/authentication/token/data/model/TokenData;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface TokenRemoteDataSource {
    @NotNull
    Single<TokenData> fetchClientTokenData();
}
