package com.talabat.gem.adapters.presentation;

import io.reactivex.subjects.ReplaySubject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001c\u0010\u0000\u001a\u0010\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0000¨\u0006\u0004"}, d2 = {"Configurations", "Lio/reactivex/subjects/ReplaySubject;", "T", "kotlin.jvm.PlatformType", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ConfigurationsKt {
    @NotNull
    public static final <T> ReplaySubject<T> Configurations() {
        ReplaySubject<T> create = ReplaySubject.create();
        Intrinsics.checkNotNullExpressionValue(create, "create<T>()");
        return create;
    }
}
