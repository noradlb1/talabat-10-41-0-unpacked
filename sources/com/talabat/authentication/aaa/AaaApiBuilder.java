package com.talabat.authentication.aaa;

import com.talabat.core.buildconfig.TalabatEnvironment;
import com.talabat.core.network.network.NetworkBuilder;
import com.talabat.core.network.network.OKHttpBuilder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001f\u0010\u0003\u001a\u0002H\u0004\"\u0004\b\u0000\u0010\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/talabat/authentication/aaa/AaaApiBuilder;", "", "()V", "createApi", "T", "clazz", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "com_talabat_Authentication_Authentication"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AaaApiBuilder {
    @NotNull
    public static final AaaApiBuilder INSTANCE = new AaaApiBuilder();

    private AaaApiBuilder() {
    }

    public final <T> T createApi(@NotNull Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "clazz");
        return NetworkBuilder.Companion.getService(new EndpointProvider(TalabatEnvironment.INSTANCE.getEnvironment(), "release").getBaseUrl(), cls, OKHttpBuilder.getBaseHttpClient$default(OKHttpBuilder.INSTANCE, CollectionsKt__CollectionsJVMKt.listOf(new AuthenticationHeaderInterceptor()), 0, 2, (Object) null));
    }
}
