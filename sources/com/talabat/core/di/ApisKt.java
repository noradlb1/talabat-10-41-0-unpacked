package com.talabat.core.di;

import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0001\u0018\u0001*\u00020\u0002*\u0017\u0012\r\u0012\u000b\u0012\u0002\b\u00030\u0004¢\u0006\u0002\b\u0005\u0012\u0004\u0012\u00020\u00020\u0003H\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"get", "T", "Lcom/talabat/core/di/Api;", "", "Ljava/lang/Class;", "Lkotlin/jvm/JvmSuppressWildcards;", "(Ljava/util/Map;)Lcom/talabat/core/di/Api;", "com_talabat_core_di_di"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ApisKt {
    public static final /* synthetic */ <T extends Api> T get(Map<Class<?>, ? extends Api> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        T t11 = map.get(Api.class);
        Intrinsics.reifiedOperationMarker(1, "T");
        return (Api) t11;
    }
}
