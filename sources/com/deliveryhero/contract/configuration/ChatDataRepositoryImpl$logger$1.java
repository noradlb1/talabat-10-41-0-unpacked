package com.deliveryhero.contract.configuration;

import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.customerchat.telephony.util.logging.TelephonyLogger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000#\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0003\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0007H\u0016J,\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u00072\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\n"}, d2 = {"com/deliveryhero/contract/configuration/ChatDataRepositoryImpl$logger$1", "Lcom/deliveryhero/customerchat/telephony/util/logging/TelephonyLogger;", "log", "", "event", "", "parameters", "", "exception", "", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatDataRepositoryImpl$logger$1 implements TelephonyLogger {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ChatDataRepositoryImpl f29709a;

    public ChatDataRepositoryImpl$logger$1(ChatDataRepositoryImpl chatDataRepositoryImpl) {
        this.f29709a = chatDataRepositoryImpl;
    }

    public void log(@NotNull String str, @NotNull Map<String, String> map) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(map, "parameters");
        ChatLogger chatLogger = this.f29709a.chatFeatureCallbacks.getChatLogger();
        if (chatLogger != null) {
            chatLogger.log(str, map);
        }
    }

    public void log(@NotNull String str, @NotNull Map<String, String> map, @NotNull Throwable th2) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(map, "parameters");
        Intrinsics.checkNotNullParameter(th2, "exception");
        ChatLogger chatLogger = this.f29709a.chatFeatureCallbacks.getChatLogger();
        if (chatLogger != null) {
            chatLogger.log(str, map, th2);
        }
    }
}
