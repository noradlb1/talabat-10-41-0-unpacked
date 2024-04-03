package com.deliveryhero.customerchat.di;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.koin.core.Koin;
import org.koin.core.component.KoinComponent;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"Lcom/deliveryhero/customerchat/di/MyKoinComponent;", "Lorg/koin/core/component/KoinComponent;", "getKoin", "Lorg/koin/core/Koin;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface MyKoinComponent extends KoinComponent {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class DefaultImpls {
        @NotNull
        public static Koin getKoin(@NotNull MyKoinComponent myKoinComponent) {
            return MyKoinContext.INSTANCE.getKoin();
        }
    }

    @NotNull
    Koin getKoin();
}
