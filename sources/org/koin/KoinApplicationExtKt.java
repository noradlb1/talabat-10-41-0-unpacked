package org.koin;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.koin.core.KoinApplication;
import org.koin.core.registry.PropertyRegistryExtKt;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001\u001a\u0014\u0010\u0002\u001a\u00020\u0001*\u00020\u00012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"environmentProperties", "Lorg/koin/core/KoinApplication;", "fileProperties", "fileName", "", "koin-core"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class KoinApplicationExtKt {
    @NotNull
    public static final KoinApplication environmentProperties(@NotNull KoinApplication koinApplication) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        PropertyRegistryExtKt.loadEnvironmentProperties(koinApplication.getKoin().getPropertyRegistry());
        return koinApplication;
    }

    @NotNull
    public static final KoinApplication fileProperties(@NotNull KoinApplication koinApplication, @NotNull String str) {
        Intrinsics.checkNotNullParameter(koinApplication, "<this>");
        Intrinsics.checkNotNullParameter(str, "fileName");
        PropertyRegistryExtKt.loadPropertiesFromFile(koinApplication.getKoin().getPropertyRegistry(), str);
        return koinApplication;
    }

    public static /* synthetic */ KoinApplication fileProperties$default(KoinApplication koinApplication, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = "/koin.properties";
        }
        return fileProperties(koinApplication, str);
    }
}
