package com.deliveryhero.customerchat.eventTracking.constants;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/deliveryhero/customerchat/eventTracking/constants/ContactDetailsKeys;", "", "()V", "SENT_FROM", "", "SENT_FROM_VALUE", "USER_TYPES", "USER_TYPES_VALUE", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ContactDetailsKeys {
    @NotNull
    public static final ContactDetailsKeys INSTANCE = new ContactDetailsKeys();
    @NotNull
    public static final String SENT_FROM = "sent_from";
    @NotNull
    public static final String SENT_FROM_VALUE = "client";
    @NotNull
    public static final String USER_TYPES = "user_types";
    @NotNull
    public static final String USER_TYPES_VALUE = "['rider','customer']";

    private ContactDetailsKeys() {
    }
}
