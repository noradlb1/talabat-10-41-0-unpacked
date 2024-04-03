package com.talabat.gem.adapters.presentation.collections;

import com.talabat.gem.domain.entities.GemRestaurant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/gem/domain/entities/GemRestaurant;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class GemCollectionViewHolder$onSelectedAction$1 extends Lambda implements Function1<GemRestaurant, Unit> {
    public static final GemCollectionViewHolder$onSelectedAction$1 INSTANCE = new GemCollectionViewHolder$onSelectedAction$1();

    public GemCollectionViewHolder$onSelectedAction$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((GemRestaurant) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull GemRestaurant gemRestaurant) {
        Intrinsics.checkNotNullParameter(gemRestaurant, "it");
    }
}
