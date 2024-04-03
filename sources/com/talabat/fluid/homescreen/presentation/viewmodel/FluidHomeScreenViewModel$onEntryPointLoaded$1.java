package com.talabat.fluid.homescreen.presentation.viewmodel;

import com.deliveryhero.fluid.widgets.collections.Cell;
import com.talabat.fluid.homescreen.presentation.mapper.VerticalItemViewEntityMapperKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/deliveryhero/fluid/widgets/collections/Cell;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FluidHomeScreenViewModel$onEntryPointLoaded$1 extends Lambda implements Function1<Cell, String> {
    public static final FluidHomeScreenViewModel$onEntryPointLoaded$1 INSTANCE = new FluidHomeScreenViewModel$onEntryPointLoaded$1();

    public FluidHomeScreenViewModel$onEntryPointLoaded$1() {
        super(1);
    }

    @Nullable
    public final String invoke(@NotNull Cell cell) {
        Intrinsics.checkNotNullParameter(cell, "it");
        Object obj = cell.getData().getMetadata().get(VerticalItemViewEntityMapperKt.VERTICAL_ITEM_KEY);
        if (obj != null) {
            return obj.toString();
        }
        return null;
    }
}
