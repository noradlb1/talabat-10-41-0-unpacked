package com.deliveryhero.contract.model;

import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u001e\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/deliveryhero/contract/model/UserMessage;", "Lcom/deliveryhero/contract/model/BaseMessage;", "message", "", "getMessage", "()Ljava/lang/String;", "sender", "Lcom/deliveryhero/contract/model/User;", "getSender", "()Lcom/deliveryhero/contract/model/User;", "translations", "", "getTranslations", "()Ljava/util/Map;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface UserMessage extends BaseMessage {
    @NotNull
    String getMessage();

    @NotNull
    User getSender();

    @NotNull
    Map<String, String> getTranslations();
}
