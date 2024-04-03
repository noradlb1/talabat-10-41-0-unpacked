package com.deliveryhero.contract.configuration;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/deliveryhero/contract/configuration/ChatConfigDeprecationMessages;", "", "()V", "TO_BE_REMOVED_6_2_0", "", "TO_BE_REMOVED_6_4_0", "TO_BE_REMOVED_6_6_0", "TO_BE_REMOVED_6_6_0_DEFAULT_TRUE", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatConfigDeprecationMessages {
    @NotNull
    public static final ChatConfigDeprecationMessages INSTANCE = new ChatConfigDeprecationMessages();
    @NotNull
    public static final String TO_BE_REMOVED_6_2_0 = "Deprecated since 6.2.0. It will be removed in future releases.";
    @NotNull
    public static final String TO_BE_REMOVED_6_4_0 = "Deprecated since 6.4.0. It will be removed in future releases in lieu of remote feature flags.";
    @NotNull
    public static final String TO_BE_REMOVED_6_6_0 = "Deprecated since 6.6.0. It will be removed in future releases in lieu of remote feature flags.";
    @NotNull
    public static final String TO_BE_REMOVED_6_6_0_DEFAULT_TRUE = "Deprecated since 6.6.0. It will be removed in future releases and by default will be set to true.";

    private ChatConfigDeprecationMessages() {
    }
}
