package com.talabat.flutter.channels;

import com.talabat.search.domain.callback.SearchMethodHandlerCallback;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00062\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/talabat/flutter/channels/VendorListSearchMethodChannel;", "Lcom/talabat/flutter/channels/SearchMethodChannel;", "isExistingPickupCustomer", "", "(Z)V", "getChannelArguments", "", "", "", "searchCallBack", "Lcom/talabat/search/domain/callback/SearchMethodHandlerCallback;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VendorListSearchMethodChannel extends SearchMethodChannel {
    private final boolean isExistingPickupCustomer;

    public VendorListSearchMethodChannel() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ VendorListSearchMethodChannel(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11);
    }

    @NotNull
    public Map<String, Object> getChannelArguments(@NotNull SearchMethodHandlerCallback searchMethodHandlerCallback) {
        Intrinsics.checkNotNullParameter(searchMethodHandlerCallback, "searchCallBack");
        Map<String, Object> channelArguments = super.getChannelArguments(searchMethodHandlerCallback);
        channelArguments.put("oldPickupCustomer", Boolean.valueOf(this.isExistingPickupCustomer));
        return channelArguments;
    }

    public VendorListSearchMethodChannel(boolean z11) {
        this.isExistingPickupCustomer = z11;
    }
}
