package com.talabat.feature.tokenization.domain.entity;

import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/tokenization/domain/entity/TokenizedCard;", "", "token", "", "publicKey", "(Ljava/lang/String;Ljava/lang/String;)V", "getPublicKey", "()Ljava/lang/String;", "getToken", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_tokenization_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TokenizedCard {
    @NotNull
    private final String publicKey;
    @NotNull
    private final String token;

    public TokenizedCard(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str2, "publicKey");
        this.token = str;
        this.publicKey = str2;
    }

    public static /* synthetic */ TokenizedCard copy$default(TokenizedCard tokenizedCard, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = tokenizedCard.token;
        }
        if ((i11 & 2) != 0) {
            str2 = tokenizedCard.publicKey;
        }
        return tokenizedCard.copy(str, str2);
    }

    @NotNull
    public final String component1() {
        return this.token;
    }

    @NotNull
    public final String component2() {
        return this.publicKey;
    }

    @NotNull
    public final TokenizedCard copy(@NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(str2, "publicKey");
        return new TokenizedCard(str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TokenizedCard)) {
            return false;
        }
        TokenizedCard tokenizedCard = (TokenizedCard) obj;
        return Intrinsics.areEqual((Object) this.token, (Object) tokenizedCard.token) && Intrinsics.areEqual((Object) this.publicKey, (Object) tokenizedCard.publicKey);
    }

    @NotNull
    public final String getPublicKey() {
        return this.publicKey;
    }

    @NotNull
    public final String getToken() {
        return this.token;
    }

    public int hashCode() {
        return (this.token.hashCode() * 31) + this.publicKey.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.token;
        String str2 = this.publicKey;
        return "TokenizedCard(token=" + str + ", publicKey=" + str2 + ")";
    }
}
