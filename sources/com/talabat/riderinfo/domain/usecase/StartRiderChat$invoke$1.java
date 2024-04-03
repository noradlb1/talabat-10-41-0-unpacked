package com.talabat.riderinfo.domain.usecase;

import com.talabat.chat.domain.ChatDeliveryInfo;
import com.talabat.chat.domain.ChatUser;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "customerId", "", "sessionToken", "chatChannel", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class StartRiderChat$invoke$1 extends Lambda implements Function3<String, String, String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ StartRiderChat f61291g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public StartRiderChat$invoke$1(StartRiderChat startRiderChat) {
        super(3);
        this.f61291g = startRiderChat;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        invoke((String) obj, (String) obj2, (String) obj3);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        String str4 = str;
        String str5 = str2;
        String str6 = str3;
        Intrinsics.checkNotNullParameter(str4, "customerId");
        Intrinsics.checkNotNullParameter(str5, "sessionToken");
        Intrinsics.checkNotNullParameter(str6, "chatChannel");
        ChatUser chatUser = new ChatUser(str4, str5);
        this.f61291g.chatApi.configureChat(chatUser, new ChatDeliveryInfo((Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null), str3, this.f61291g.configurationLocalRepository.selectedLanguage().getLanguageCode(), new ArrayList(), false);
        this.f61291g.chatApi.startChat(new ChatDeliveryInfo((Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null), str6);
    }
}
