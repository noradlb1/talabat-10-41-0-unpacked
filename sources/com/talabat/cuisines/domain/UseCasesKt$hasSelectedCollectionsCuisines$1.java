package com.talabat.cuisines.domain;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00060\u0002j\u0002`\u0003H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"<anonymous>", "", "Lcom/talabat/cuisines/domain/CuisinesRepository;", "Lcom/talabat/cuisines/domain/Repository;", "invoke", "(Lcom/talabat/cuisines/domain/CuisinesRepository;)Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class UseCasesKt$hasSelectedCollectionsCuisines$1 extends Lambda implements Function1<CuisinesRepository, Integer> {
    public static final UseCasesKt$hasSelectedCollectionsCuisines$1 INSTANCE = new UseCasesKt$hasSelectedCollectionsCuisines$1();

    public UseCasesKt$hasSelectedCollectionsCuisines$1() {
        super(1);
    }

    @Nullable
    public final Integer invoke(@NotNull CuisinesRepository cuisinesRepository) {
        Intrinsics.checkNotNullParameter(cuisinesRepository, "$this$hasSelection");
        return cuisinesRepository.loadSelectedCollectionsCuisineId();
    }
}
