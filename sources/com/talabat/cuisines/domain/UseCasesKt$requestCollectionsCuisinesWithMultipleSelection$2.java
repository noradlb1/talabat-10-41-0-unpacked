package com.talabat.cuisines.domain;

import datamodels.Cuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0001*\u00060\u0003j\u0002`\u0004H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "Ldatamodels/Cuisine;", "Lcom/talabat/cuisines/domain/CuisinesRepository;", "Lcom/talabat/cuisines/domain/Repository;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UseCasesKt$requestCollectionsCuisinesWithMultipleSelection$2 extends Lambda implements Function1<CuisinesRepository, List<? extends Cuisine>> {
    public static final UseCasesKt$requestCollectionsCuisinesWithMultipleSelection$2 INSTANCE = new UseCasesKt$requestCollectionsCuisinesWithMultipleSelection$2();

    public UseCasesKt$requestCollectionsCuisinesWithMultipleSelection$2() {
        super(1);
    }

    @Nullable
    public final List<Cuisine> invoke(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "$this$requestAnyCuisinesWithMultipleSelection");
        return cuisinesRepository.loadSelectedCollectionCuisines();
    }
}
