package com.talabat.authentication.authenticate.data.remote;

import com.talabat.authentication.authenticate.data.remote.model.LogoutResponse;
import com.talabat.authentication.token.data.model.TokenData;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J)\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000bJ\u000e\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u0003H&J\u0011\u0010\u000e\u001a\u00020\u0004H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/authentication/authenticate/data/remote/AuthenticationRemoteDataSource;", "", "authenticateWithPassword", "Lio/reactivex/Single;", "Lcom/talabat/authentication/token/data/model/TokenData;", "email", "", "password", "authenticateWithSocialLogin", "platform", "socialToken", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "Lcom/talabat/authentication/authenticate/data/remote/model/LogoutResponse;", "migrationExchangeToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AuthenticationRemoteDataSource {
    @NotNull
    Single<TokenData> authenticateWithPassword(@NotNull String str, @NotNull String str2);

    @Nullable
    Object authenticateWithSocialLogin(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull Continuation<? super TokenData> continuation);

    @NotNull
    Single<LogoutResponse> logout();

    @Nullable
    Object migrationExchangeToken(@NotNull Continuation<? super TokenData> continuation);
}
