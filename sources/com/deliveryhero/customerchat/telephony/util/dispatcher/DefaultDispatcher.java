package com.deliveryhero.customerchat.telephony.util.dispatcher;

import com.deliveryhero.customerchat.telephony.util.dispatcher.Dispatcher;
import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/deliveryhero/customerchat/telephony/util/dispatcher/DefaultDispatcher;", "Lcom/deliveryhero/customerchat/telephony/util/dispatcher/Dispatcher;", "()V", "telephony_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultDispatcher implements Dispatcher {
    @NotNull
    /* renamed from: default  reason: not valid java name */
    public CoroutineDispatcher m8175default() {
        return Dispatcher.DefaultImpls.m8177default(this);
    }

    @NotNull
    public CoroutineDispatcher io() {
        return Dispatcher.DefaultImpls.io(this);
    }

    @NotNull
    public CoroutineDispatcher main() {
        return Dispatcher.DefaultImpls.main(this);
    }

    @NotNull
    public CoroutineDispatcher unconfined() {
        return Dispatcher.DefaultImpls.unconfined(this);
    }
}
