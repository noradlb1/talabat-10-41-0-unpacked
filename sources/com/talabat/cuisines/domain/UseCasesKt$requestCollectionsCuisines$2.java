package com.talabat.cuisines.domain;

import datamodels.Cuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "Ldatamodels/Cuisine;", "Lcom/talabat/cuisines/domain/CuisinesRepository;", "Lcom/talabat/cuisines/domain/Repository;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UseCasesKt$requestCollectionsCuisines$2 extends Lambda implements Function1<CuisinesRepository, Cuisine> {
    public static final UseCasesKt$requestCollectionsCuisines$2 INSTANCE = new UseCasesKt$requestCollectionsCuisines$2();

    public UseCasesKt$requestCollectionsCuisines$2() {
        super(1);
    }

    @Nullable
    public final Cuisine invoke(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "$this$requestAnyCuisines");
        List<Cuisine> loadSelectedCollectionCuisines = cuisinesRepository.loadSelectedCollectionCuisines();
        if (loadSelectedCollectionCuisines != null) {
            return (Cuisine) CollectionsKt___CollectionsKt.firstOrNull(loadSelectedCollectionCuisines);
        }
        return null;
    }
}
