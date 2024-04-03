package com.talabat.authentication.authenticate.domain.repository;

import com.talabat.authentication.authenticate.data.remote.model.LogoutResponse;
import com.talabat.authentication.authenticate.domain.model.MigrationExchangeTokenAuthentication;
import com.talabat.authentication.authenticate.domain.model.PasswordAuthentication;
import io.reactivex.Single;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J!\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH&J\u000e\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH&J\u0011\u0010\r\u001a\u00020\u000eH¦@ø\u0001\u0000¢\u0006\u0002\u0010\u000f\u0002\u0004\n\u0002\b\u0019¨\u0006\u0010"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/repository/AuthenticationRepository;", "", "authenticateWithPassword", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication;", "email", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isUserLoggedIn", "", "logout", "Lio/reactivex/Single;", "Lcom/talabat/authentication/authenticate/data/remote/model/LogoutResponse;", "migrationExchangeToken", "Lcom/talabat/authentication/authenticate/domain/model/MigrationExchangeTokenAuthentication;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface AuthenticationRepository {
    @Nullable
    Object authenticateWithPassword(@NotNull String str, @NotNull String str2, @NotNull Continuation<? super PasswordAuthentication> continuation) throws PasswordAuthenticationException;

    boolean isUserLoggedIn();

    @NotNull
    Single<LogoutResponse> logout();

    @Nullable
    Object migrationExchangeToken(@NotNull Continuation<? super MigrationExchangeTokenAuthentication> continuation) throws MigrationExchangeTokenAuthenticationException;
}
