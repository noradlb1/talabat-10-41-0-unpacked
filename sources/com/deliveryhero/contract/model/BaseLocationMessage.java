package com.deliveryhero.contract.model;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0012\u0010\b\u001a\u00020\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/deliveryhero/contract/model/BaseLocationMessage;", "Lcom/deliveryhero/contract/model/BaseMessage;", "latitude", "", "getLatitude", "()D", "longitude", "getLongitude", "sender", "Lcom/deliveryhero/contract/model/User;", "getSender", "()Lcom/deliveryhero/contract/model/User;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface BaseLocationMessage extends BaseMessage {
    double getLatitude();

    double getLongitude();

    @NotNull
    User getSender();
}
