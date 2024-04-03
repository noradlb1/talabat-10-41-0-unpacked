package com.talabat.authentication.authenticate.domain.repository;

import com.talabat.authentication.authenticate.domain.model.PasswordAuthentication;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ)\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0005H¦@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0002\u0004\n\u0002\b\u0019¨\u0006\u000b"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository;", "", "authenticateWithSocialLogin", "Lcom/talabat/authentication/authenticate/domain/model/PasswordAuthentication;", "email", "", "platform", "Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository$Platform;", "socialToken", "(Ljava/lang/String;Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository$Platform;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Platform", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface SocialAuthenticationRepository {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/authentication/authenticate/domain/repository/SocialAuthenticationRepository$Platform;", "", "(Ljava/lang/String;I)V", "FACEBOOK", "GOOGLE", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Platform {
        FACEBOOK,
        GOOGLE
    }

    @Nullable
    Object authenticateWithSocialLogin(@NotNull String str, @NotNull Platform platform, @NotNull String str2, @NotNull Continuation<? super PasswordAuthentication> continuation) throws PasswordAuthenticationException;
}
