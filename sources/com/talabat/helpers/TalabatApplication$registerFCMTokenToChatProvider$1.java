package com.talabat.helpers;

import com.talabat.chat.api.ChatApi;
import com.talabat.chat.di.ChatFactory;
import com.talabat.talabatcore.logger.LogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "fcmToken", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class TalabatApplication$registerFCMTokenToChatProvider$1 extends Lambda implements Function1<String, Unit> {
    public static final TalabatApplication$registerFCMTokenToChatProvider$1 INSTANCE = new TalabatApplication$registerFCMTokenToChatProvider$1();

    public TalabatApplication$registerFCMTokenToChatProvider$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "fcmToken");
        ChatApi initializeChatProvider = ChatFactory.Companion.getInstance$default(ChatFactory.Companion, (ChatApi) null, 1, (Object) null).initializeChatProvider();
        LogManager.debug("Registering fcm token to the chat provider.");
        ChatApi.DefaultImpls.registerToken$default(initializeChatProvider, str, (Function0) null, (Function1) null, 6, (Object) null);
    }
}
