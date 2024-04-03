package com.talabat.helpcenter.presentation.webInterface;

import android.webkit.JavascriptInterface;
import com.talabat.helpcenter.presentation.mapper.GlobalHelpCenterMapper;
import com.talabat.helpcenter.presentation.model.GlobalHelpCenterMessageModel;
import com.talabat.helpcenter.presentation.webview.GlobalHelpCenterCallbacks;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/helpcenter/presentation/webInterface/GlobalHelpCenterWebAppInterface;", "", "callback", "Lcom/talabat/helpcenter/presentation/webview/GlobalHelpCenterCallbacks;", "(Lcom/talabat/helpcenter/presentation/webview/GlobalHelpCenterCallbacks;)V", "postMessage", "", "serializedMessage", "", "Companion", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalHelpCenterWebAppInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String HELP_CENTER_ASKS_FOR_SHUTDOWN_MESSAGE = "HELPCENTER_ASKS_FOR_SHUTDOWN";
    @NotNull
    private static final String HELP_CENTER_CHAT_ENDED = "HELPCENTER_CHAT_ENDED";
    @NotNull
    private static final String HELP_CENTER_CHAT_STARTED = "HELPCENTER_CHAT_STARTED";
    @NotNull
    private static final String HELP_CENTER_INIT_STARTED_MESSAGE = "HELPCENTER_INIT_STARTED";
    @NotNull
    private static final String HELP_CENTER_WILL_NOT_HANDLE_BACK_NAVIGATION_MESSAGE = "HELPCENTER_WILL_NOT_HANDLE_BACK_NAVIGATION";
    @NotNull
    private static final String HELP_CENTER_WONT_HANDLE_BACK_NAVIGATION_MESSAGE = "HELPCENTER_WONT_HANDLE_BACK_NAVIGATION";
    @NotNull
    private final GlobalHelpCenterCallbacks callback;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/talabat/helpcenter/presentation/webInterface/GlobalHelpCenterWebAppInterface$Companion;", "", "()V", "HELP_CENTER_ASKS_FOR_SHUTDOWN_MESSAGE", "", "HELP_CENTER_CHAT_ENDED", "HELP_CENTER_CHAT_STARTED", "HELP_CENTER_INIT_STARTED_MESSAGE", "HELP_CENTER_WILL_NOT_HANDLE_BACK_NAVIGATION_MESSAGE", "HELP_CENTER_WONT_HANDLE_BACK_NAVIGATION_MESSAGE", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    public GlobalHelpCenterWebAppInterface(@NotNull GlobalHelpCenterCallbacks globalHelpCenterCallbacks) {
        Intrinsics.checkNotNullParameter(globalHelpCenterCallbacks, "callback");
        this.callback = globalHelpCenterCallbacks;
    }

    @JavascriptInterface
    public final void postMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "serializedMessage");
        GlobalHelpCenterMessageModel convertMessageToGlobalHelpCenterObject = GlobalHelpCenterMapper.INSTANCE.convertMessageToGlobalHelpCenterObject(str);
        if (convertMessageToGlobalHelpCenterObject != null) {
            String type = convertMessageToGlobalHelpCenterObject.getType();
            switch (type.hashCode()) {
                case -2111344888:
                    if (type.equals(HELP_CENTER_ASKS_FOR_SHUTDOWN_MESSAGE)) {
                        this.callback.onCloseButtonTapped();
                        return;
                    }
                    return;
                case -1853814461:
                    if (type.equals(HELP_CENTER_CHAT_STARTED)) {
                        this.callback.onChatStarted(convertMessageToGlobalHelpCenterObject.getPayload().getChatId());
                        return;
                    }
                    return;
                case -618417531:
                    if (type.equals(HELP_CENTER_WILL_NOT_HANDLE_BACK_NAVIGATION_MESSAGE)) {
                        this.callback.onCloseButtonTapped();
                        return;
                    }
                    return;
                case -548232453:
                    if (type.equals(HELP_CENTER_INIT_STARTED_MESSAGE)) {
                        this.callback.onGlobalHelpCenterStarted();
                        return;
                    }
                    return;
                case -511123460:
                    if (type.equals(HELP_CENTER_CHAT_ENDED)) {
                        this.callback.onChatEnded(convertMessageToGlobalHelpCenterObject.getPayload().getChatId());
                        return;
                    }
                    return;
                case -189132499:
                    if (type.equals(HELP_CENTER_WONT_HANDLE_BACK_NAVIGATION_MESSAGE)) {
                        this.callback.onCloseButtonTapped();
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }
}
