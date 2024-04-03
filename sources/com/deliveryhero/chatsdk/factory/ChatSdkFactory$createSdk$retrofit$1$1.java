package com.deliveryhero.chatsdk.factory;

import com.deliveryhero.chatsdk.provider.ProviderKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import okhttp3.OkHttpClient;
import org.jetbrains.annotations.NotNull;
import org.koin.core.Koin;
import org.koin.core.parameter.ParametersHolder;
import org.koin.core.parameter.ParametersHolderKt;
import org.koin.core.qualifier.StringQualifier;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lorg/koin/core/parameter/ParametersHolder;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ChatSdkFactory$createSdk$retrofit$1$1 extends Lambda implements Function0<ParametersHolder> {
    final /* synthetic */ Koin $this_with;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatSdkFactory$createSdk$retrofit$1$1(Koin koin) {
        super(0);
        this.$this_with = koin;
    }

    @NotNull
    public final ParametersHolder invoke() {
        Koin koin = this.$this_with;
        return ParametersHolderKt.parametersOf(koin.getScopeRegistry().getRootScope().get(Reflection.getOrCreateKotlinClass(OkHttpClient.class), new StringQualifier(ProviderKt.AUTHENTICATED), (Function0<? extends ParametersHolder>) null));
    }
}
