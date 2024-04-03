package com.deliveryhero.repository.gccchat;

import com.deliveryhero.chatsdk.domain.model.PushNotificationData;
import com.deliveryhero.chatsdk.util.PushNotificationParser;
import com.deliveryhero.contract.ChatPushNotificationParser;
import com.deliveryhero.contract.model.ChatPushData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0016J\u001c\u0010\b\u001a\u00020\t2\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006H\u0016¨\u0006\n"}, d2 = {"Lcom/deliveryhero/repository/gccchat/GccChatNotificationParser;", "Lcom/deliveryhero/contract/ChatPushNotificationParser;", "()V", "canParse", "", "data", "", "", "parse", "Lcom/deliveryhero/contract/model/ChatPushData;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GccChatNotificationParser implements ChatPushNotificationParser {
    public boolean canParse(@Nullable Map<String, String> map) {
        if (map == null) {
            return false;
        }
        return PushNotificationParser.INSTANCE.canParse(map);
    }

    @NotNull
    public ChatPushData parse(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        PushNotificationData parse = PushNotificationParser.INSTANCE.parse(map);
        return new ChatPushData(parse.getChannelID(), parse.getSenderName(), parse.getOrderID(), parse.getCountry(), parse.getMessage(), parse.getPushID(), parse.getPushAlert(), parse.getChannelType());
    }
}
