package com.deliveryhero.chatsdk.network.websocket.model;

import com.deliveryhero.chatsdk.domain.model.Location;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000¨\u0006\u0003"}, d2 = {"toLocation", "Lcom/deliveryhero/chatsdk/domain/model/Location;", "Lcom/deliveryhero/chatsdk/network/websocket/model/LocationContent;", "customerchat_basicRelease"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class LocationContentKt {
    @NotNull
    public static final Location toLocation(@NotNull LocationContent locationContent) {
        Intrinsics.checkNotNullParameter(locationContent, "<this>");
        return new Location(locationContent.getLatitude(), locationContent.getLongitude(), locationContent.getAccuracy(), locationContent.getSource());
    }
}
