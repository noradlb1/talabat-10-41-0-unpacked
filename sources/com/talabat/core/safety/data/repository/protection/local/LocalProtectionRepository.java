package com.talabat.core.safety.data.repository.protection.local;

import android.util.Base64;
import com.talabat.core.safety.data.repository.protection.ProtectionRepository;
import java.security.SecureRandom;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0000\u0018\u00002\u00020\u0001B\u0007\b\u0007¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\f\u0010\u0007\u001a\u00020\u0006*\u00020\bH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/talabat/core/safety/data/repository/protection/local/LocalProtectionRepository;", "Lcom/talabat/core/safety/data/repository/protection/ProtectionRepository;", "()V", "secureRandom", "Ljava/security/SecureRandom;", "generateNonce", "", "toBase64UrlSafe", "", "com_talabat_core_safety_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocalProtectionRepository implements ProtectionRepository {
    @NotNull
    private final SecureRandom secureRandom;

    @Inject
    public LocalProtectionRepository() {
        SecureRandom secureRandom2 = new SecureRandom();
        this.secureRandom = secureRandom2;
        secureRandom2.setSeed(System.currentTimeMillis());
    }

    private final String toBase64UrlSafe(byte[] bArr) {
        String encodeToString = Base64.encodeToString(bArr, 11);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "encodeToString(\n        …se64.NO_PADDING\n        )");
        return encodeToString;
    }

    @NotNull
    public String generateNonce() {
        byte[] bArr = new byte[32];
        this.secureRandom.nextBytes(bArr);
        return toBase64UrlSafe(bArr);
    }
}
