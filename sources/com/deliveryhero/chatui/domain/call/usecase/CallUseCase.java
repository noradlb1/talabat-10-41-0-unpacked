package com.deliveryhero.chatui.domain.call.usecase;

import com.deliveryhero.chatui.data.event.Event;
import com.deliveryhero.chatui.data.event.EventHandler;
import com.deliveryhero.chatui.domain.call.CallStatus;
import com.deliveryhero.contract.ChatLogger;
import com.deliveryhero.contract.configuration.ChatFeatureCallbacks;
import com.deliveryhero.customerchat.telephony.domain.TokuService;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/deliveryhero/chatui/domain/call/usecase/CallUseCase;", "", "eventHandler", "Lcom/deliveryhero/chatui/data/event/EventHandler;", "tokuService", "Lcom/deliveryhero/customerchat/telephony/domain/TokuService;", "chatFeatureCallbacks", "Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;", "(Lcom/deliveryhero/chatui/data/event/EventHandler;Lcom/deliveryhero/customerchat/telephony/domain/TokuService;Lcom/deliveryhero/contract/configuration/ChatFeatureCallbacks;)V", "execute", "", "callStatus", "Lcom/deliveryhero/chatui/domain/call/CallStatus;", "pstnCall", "number", "", "voipCall", "Lcom/deliveryhero/chatui/domain/call/CallStatus$VoipActive;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallUseCase {
    @NotNull
    private final ChatFeatureCallbacks chatFeatureCallbacks;
    @NotNull
    private final EventHandler eventHandler;
    @NotNull
    private final TokuService tokuService;

    public CallUseCase(@NotNull EventHandler eventHandler2, @NotNull TokuService tokuService2, @NotNull ChatFeatureCallbacks chatFeatureCallbacks2) {
        Intrinsics.checkNotNullParameter(eventHandler2, "eventHandler");
        Intrinsics.checkNotNullParameter(tokuService2, "tokuService");
        Intrinsics.checkNotNullParameter(chatFeatureCallbacks2, "chatFeatureCallbacks");
        this.eventHandler = eventHandler2;
        this.tokuService = tokuService2;
        this.chatFeatureCallbacks = chatFeatureCallbacks2;
    }

    private final void pstnCall(String str) {
        this.eventHandler.onEvent(new Event.Call(str));
    }

    private final void voipCall(CallStatus.VoipActive voipActive) {
        if (Intrinsics.areEqual((Object) voipActive.getProvider(), (Object) CallStatus.VoipActive.TOKU_PROVIDER)) {
            this.tokuService.call(voipActive.getUsername());
            return;
        }
        String str = "Unknown VoIP Provider - " + voipActive.getProvider();
        this.eventHandler.onEvent(new Event.VoipCallFailed(voipActive.getUsername(), voipActive.getProvider(), str));
        ChatLogger chatLogger = this.chatFeatureCallbacks.getChatLogger();
        if (chatLogger != null) {
            chatLogger.log(CallUseCaseKt.VOIP_CALL_FAILED_ERROR_TAG, MapsKt__MapsJVMKt.mapOf(TuplesKt.to("message", str)));
        }
    }

    public final void execute(@NotNull CallStatus callStatus) {
        Intrinsics.checkNotNullParameter(callStatus, "callStatus");
        if (callStatus instanceof CallStatus.Active) {
            pstnCall(((CallStatus.Active) callStatus).getPhoneNumber());
        } else if (callStatus instanceof CallStatus.VoipActive) {
            voipCall((CallStatus.VoipActive) callStatus);
        }
    }
}
