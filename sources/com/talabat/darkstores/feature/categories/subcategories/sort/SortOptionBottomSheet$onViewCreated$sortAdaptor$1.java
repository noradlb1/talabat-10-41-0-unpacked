package com.talabat.darkstores.feature.categories.subcategories.sort;

import com.talabat.darkstores.data.discovery.model.SortOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SortOptionBottomSheet$onViewCreated$sortAdaptor$1 extends FunctionReferenceImpl implements Function2<SortOption, Integer, Unit> {
    public SortOptionBottomSheet$onViewCreated$sortAdaptor$1(Object obj) {
        super(2, obj, SortOptionBottomSheet.class, "onRadioButtonClicked", "onRadioButtonClicked(Lcom/talabat/darkstores/data/discovery/model/SortOption;I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke((SortOption) obj, ((Number) obj2).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull SortOption sortOption, int i11) {
        Intrinsics.checkNotNullParameter(sortOption, "p0");
        ((SortOptionBottomSheet) this.receiver).onRadioButtonClicked(sortOption, i11);
    }
}
