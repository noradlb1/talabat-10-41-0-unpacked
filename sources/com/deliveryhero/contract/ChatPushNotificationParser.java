package com.deliveryhero.contract;

import com.deliveryhero.contract.model.ChatPushData;
import java.util.Map;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u00032\u0014\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005H&J\u001c\u0010\u0007\u001a\u00020\b2\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005H&¨\u0006\t"}, d2 = {"Lcom/deliveryhero/contract/ChatPushNotificationParser;", "", "canParse", "", "data", "", "", "parse", "Lcom/deliveryhero/contract/model/ChatPushData;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface ChatPushNotificationParser {
    boolean canParse(@Nullable Map<String, String> map);

    @NotNull
    ChatPushData parse(@NotNull Map<String, String> map);
}
