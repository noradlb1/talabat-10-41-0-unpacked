package com.talabat.core.social.login.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00060\u0001j\u0002`\u0002:\u0001\bB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/talabat/core/social/login/domain/SocialLoginException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "type", "Lcom/talabat/core/social/login/domain/SocialLoginException$Type;", "(Lcom/talabat/core/social/login/domain/SocialLoginException$Type;)V", "getType", "()Lcom/talabat/core/social/login/domain/SocialLoginException$Type;", "Type", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SocialLoginException extends Exception {
    @NotNull
    private final Type type;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/core/social/login/domain/SocialLoginException$Type;", "", "(Ljava/lang/String;I)V", "FAILURE_TO_FETCH_EMAIL", "EMPTY_SOCIAL_TOKEN", "com_talabat_core_social-login_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Type {
        FAILURE_TO_FETCH_EMAIL,
        EMPTY_SOCIAL_TOKEN
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SocialLoginException(@NotNull Type type2) {
        super(type2.toString());
        Intrinsics.checkNotNullParameter(type2, "type");
        this.type = type2;
    }

    @NotNull
    public final Type getType() {
        return this.type;
    }
}
