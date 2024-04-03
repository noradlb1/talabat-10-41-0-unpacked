package com.deliveryhero.chatsdk.util;

import com.deliveryhero.chatsdk.domain.model.TokenType;
import com.deliveryhero.contract.model.DhEnvironment;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import net.bytebuddy.jar.asm.signature.SignatureVisitor;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007J.\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004¨\u0006\r"}, d2 = {"Lcom/deliveryhero/chatsdk/util/UrlBuilder;", "", "()V", "buildHttpUrl", "", "country", "environment", "Lcom/deliveryhero/contract/model/DhEnvironment;", "buildSocketUrl", "pushTokenType", "Lcom/deliveryhero/chatsdk/domain/model/TokenType;", "versionName", "deviceUUID", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UrlBuilder {
    @NotNull
    public static final UrlBuilder INSTANCE = new UrlBuilder();

    private UrlBuilder() {
    }

    @NotNull
    public final String buildHttpUrl(@NotNull String str, @NotNull DhEnvironment dhEnvironment) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(dhEnvironment, Profile.ENVIRONMENT);
        return "https://chat-" + dhEnvironment.getBackendName$customerchat_basicRelease() + SignatureVisitor.SUPER + str + ".deliveryhero.io/" + str + '/';
    }

    @NotNull
    public final String buildSocketUrl(@NotNull String str, @NotNull DhEnvironment dhEnvironment, @NotNull TokenType tokenType, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "country");
        Intrinsics.checkNotNullParameter(dhEnvironment, Profile.ENVIRONMENT);
        Intrinsics.checkNotNullParameter(tokenType, "pushTokenType");
        Intrinsics.checkNotNullParameter(str2, "versionName");
        Intrinsics.checkNotNullParameter(str3, "deviceUUID");
        return ("wss://chat-" + dhEnvironment.getBackendName$customerchat_basicRelease() + "-ws-" + str + ".deliveryhero.io/" + str) + "?version=" + tokenType.getBackendName$customerchat_basicRelease() + SignatureVisitor.SUPER + str2 + "&device_uuid=" + str3;
    }
}
