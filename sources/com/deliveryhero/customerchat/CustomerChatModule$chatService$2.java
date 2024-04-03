package com.deliveryhero.customerchat;

import com.deliveryhero.customerchat.di.MyKoinContext;
import com.deliveryhero.customerchat.service.ChatService;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import org.jetbrains.annotations.NotNull;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.qualifier.Qualifier;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/deliveryhero/customerchat/service/ChatService;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CustomerChatModule$chatService$2 extends Lambda implements Function0<ChatService> {
    public static final CustomerChatModule$chatService$2 INSTANCE = new CustomerChatModule$chatService$2();

    public CustomerChatModule$chatService$2() {
        super(0);
    }

    @NotNull
    public final ChatService invoke() {
        return (ChatService) MyKoinContext.INSTANCE.getKoin().getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(ChatService.class), (Qualifier) null, (Function0<? extends ParametersHolder>) null);
    }
}
