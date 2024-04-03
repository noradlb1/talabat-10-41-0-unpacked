package com.talabat.fluttercore.channels.dto;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/talabat/fluttercore/channels/dto/EventChannels;", "", "()V", "DARKSTORES_CART_UPDATES_CHANNEL", "", "com_talabat_NewArchi_TalabatFlutterCore_TalabatFlutterCore"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class EventChannels {
    @NotNull
    public static final String DARKSTORES_CART_UPDATES_CHANNEL = "com.talabat.flutter/groceries-cart-updates";
    @NotNull
    public static final EventChannels INSTANCE = new EventChannels();

    private EventChannels() {
    }
}
