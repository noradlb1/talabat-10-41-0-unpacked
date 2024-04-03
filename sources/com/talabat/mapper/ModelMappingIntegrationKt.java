package com.talabat.mapper;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\f\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u0002H\u0002H\u0007¢\u0006\u0002\u0010\u0005\u001a/\u0010\u0006\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u0003*\u0002H\u00012\b\u0010\u0004\u001a\u0004\u0018\u0001H\u0002H\u0007¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0007\u001a\u0002H\u0002\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\b\b\u0001\u0010\u0001*\u00020\u0003*\u0002H\u00022\u0006\u0010\b\u001a\u0002H\u0001H\u0007¢\u0006\u0002\u0010\u0005¨\u0006\t"}, d2 = {"parseFrom", "D", "S", "", "source", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "parseFromNullable", "parseTo", "destination", "com_talabat_core_model-mapper_model-mapper"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class ModelMappingIntegrationKt {
    @NotNull
    @ModelMappingIntegration
    public static final <S, D> D parseFrom(@NotNull D d11, @NotNull S s11) {
        Intrinsics.checkNotNullParameter(d11, "<this>");
        Intrinsics.checkNotNullParameter(s11, "source");
        new ModelMappingScanner().accept((Object) d11, new ModelMappingNameScanner().apply((Object) s11));
        Unit unit = Unit.INSTANCE;
        return d11;
    }

    @NotNull
    @ModelMappingIntegration
    public static final <S, D> D parseFromNullable(@NotNull D d11, @Nullable S s11) {
        Intrinsics.checkNotNullParameter(d11, "<this>");
        if (s11 == null) {
            return d11;
        }
        return parseFrom(d11, s11);
    }

    @NotNull
    @ModelMappingIntegration
    public static final <S, D> S parseTo(@NotNull S s11, @NotNull D d11) {
        Intrinsics.checkNotNullParameter(s11, "<this>");
        Intrinsics.checkNotNullParameter(d11, "destination");
        parseFrom(d11, s11);
        return s11;
    }
}
