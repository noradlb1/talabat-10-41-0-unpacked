package com.deliveryhero.chatui.domain;

import com.deliveryhero.contract.ChatPushNotificationParser;
import com.deliveryhero.contract.model.ChatPushData;
import com.deliveryhero.repository.gccchat.GccChatNotificationParser;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\bH\u0016J\u001c\u0010\n\u001a\u00020\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/deliveryhero/chatui/domain/PushNotificationParser;", "Lcom/deliveryhero/contract/ChatPushNotificationParser;", "gccChatNotificationParser", "Lcom/deliveryhero/repository/gccchat/GccChatNotificationParser;", "(Lcom/deliveryhero/repository/gccchat/GccChatNotificationParser;)V", "canParse", "", "data", "", "", "parse", "Lcom/deliveryhero/contract/model/ChatPushData;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PushNotificationParser implements ChatPushNotificationParser {
    @NotNull
    private final GccChatNotificationParser gccChatNotificationParser;

    public PushNotificationParser(@NotNull GccChatNotificationParser gccChatNotificationParser2) {
        Intrinsics.checkNotNullParameter(gccChatNotificationParser2, "gccChatNotificationParser");
        this.gccChatNotificationParser = gccChatNotificationParser2;
    }

    public boolean canParse(@Nullable Map<String, String> map) {
        return this.gccChatNotificationParser.canParse(map);
    }

    @NotNull
    public ChatPushData parse(@NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "data");
        if (canParse(map)) {
            return this.gccChatNotificationParser.parse(map);
        }
        throw new IllegalArgumentException("notification data is in invalid format");
    }
}
