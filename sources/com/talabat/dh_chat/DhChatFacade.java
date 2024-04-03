package com.talabat.dh_chat;

import android.app.Application;
import com.deliveryhero.contract.configuration.CustomerChatConfigurationBuilder;
import com.deliveryhero.contract.model.ClientConfig;
import com.deliveryhero.customerchat.CustomerChatModule;
import com.talabat.authentication.token.data.local.impl.LegacyTokenLocalDataSourceImpl;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JB\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00040\u000eH\u0007¨\u0006\u0010"}, d2 = {"Lcom/talabat/dh_chat/DhChatFacade;", "", "()V", "registerToken", "", "app", "Landroid/app/Application;", "token", "", "cc", "Lcom/deliveryhero/contract/model/ClientConfig;", "onSuccess", "Lkotlin/Function0;", "onError", "Lkotlin/Function1;", "", "dh_chat_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class DhChatFacade {
    @NotNull
    public static final DhChatFacade INSTANCE = new DhChatFacade();

    private DhChatFacade() {
    }

    @JvmStatic
    public static final void registerToken(@NotNull Application application, @NotNull String str, @NotNull ClientConfig clientConfig, @NotNull Function0<Unit> function0, @NotNull Function1<? super Throwable, Unit> function1) {
        Intrinsics.checkNotNullParameter(application, "app");
        Intrinsics.checkNotNullParameter(str, LegacyTokenLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(clientConfig, "cc");
        Intrinsics.checkNotNullParameter(function0, "onSuccess");
        Intrinsics.checkNotNullParameter(function1, "onError");
        CustomerChatModule instance = CustomerChatModule.Companion.getInstance(application);
        instance.setConfiguration(new CustomerChatConfigurationBuilder().clientConfig(clientConfig));
        instance.registerToken(str, function0, function1);
    }
}
