package com.deliveryhero.customerchat.telephony.util.dispatcher;

import kotlin.Metadata;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0003H\u0016J\b\u0010\u0006\u001a\u00020\u0003H\u0016¨\u0006\u0007"}, d2 = {"Lcom/deliveryhero/customerchat/telephony/util/dispatcher/Dispatcher;", "", "default", "Lkotlinx/coroutines/CoroutineDispatcher;", "io", "main", "unconfined", "telephony_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface Dispatcher {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        /* renamed from: default  reason: not valid java name */
        public static CoroutineDispatcher m8177default(@NotNull Dispatcher dispatcher) {
            return Dispatchers.getDefault();
        }

        @NotNull
        public static CoroutineDispatcher io(@NotNull Dispatcher dispatcher) {
            return Dispatchers.getIO();
        }

        @NotNull
        public static CoroutineDispatcher main(@NotNull Dispatcher dispatcher) {
            return Dispatchers.getMain();
        }

        @NotNull
        public static CoroutineDispatcher unconfined(@NotNull Dispatcher dispatcher) {
            return Dispatchers.getUnconfined();
        }
    }

    @NotNull
    /* renamed from: default  reason: not valid java name */
    CoroutineDispatcher m8176default();

    @NotNull
    CoroutineDispatcher io();

    @NotNull
    CoroutineDispatcher main();

    @NotNull
    CoroutineDispatcher unconfined();
}
