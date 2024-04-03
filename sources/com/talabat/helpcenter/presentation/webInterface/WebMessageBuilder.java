package com.talabat.helpcenter.presentation.webInterface;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0007"}, d2 = {"Lcom/talabat/helpcenter/presentation/webInterface/WebMessageBuilder;", "", "()V", "buildBridgeMessageForBackButton", "", "id", "buildInitialBridgeMessage", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class WebMessageBuilder {
    @NotNull
    public final String buildBridgeMessageForBackButton(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return "\n            {\n                \"type\": \"HOST_ASKS_FOR_BACK_NAVIGATION\",\n                \"id\": \"" + str + "\",\n                \"payload\": {}\n            }\n            ";
    }

    @NotNull
    public final String buildInitialBridgeMessage(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return "\n            {\n                \"type\": \"HOST_IS_READY\",\n                \"id\": \"" + str + "\",\n                \"payload\": {\n                    \"supportedMessageTypes\": [\n                        \"HELPCENTER_ASKS_FOR_SHUTDOWN\", \n                        \"HELPCENTER_WILL_HANDLE_BACK_NAVIGATION\", \n                        \"HELPCENTER_BACKWARD_NAVIGATION\", \n                        \"HELPCENTER_WILL_HANDLE_BACK_NAVIGATION\", \n                        \"HELPCENTER_WILL_NOT_HANDLE_BACK_NAVIGATION\", \n                        \"HELPCENTER_WONT_HANDLE_BACK_NAVIGATION\",\n                        \"HELPCENTER_CHAT_STARTED\",\n                        \"HELPCENTER_CHAT_ENDED\"\n                    ],\n                \"isHelpcenterFullScreen\": true\n                }\n            }\n            ";
    }
}
