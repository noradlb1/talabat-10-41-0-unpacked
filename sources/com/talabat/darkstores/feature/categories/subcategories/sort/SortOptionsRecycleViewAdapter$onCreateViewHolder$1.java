package com.talabat.darkstores.feature.categories.subcategories.sort;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class SortOptionsRecycleViewAdapter$onCreateViewHolder$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public SortOptionsRecycleViewAdapter$onCreateViewHolder$1(Object obj) {
        super(1, obj, SortOptionsRecycleViewAdapter.class, "onRadioButtonClicked", "onRadioButtonClicked(I)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.INSTANCE;
    }

    public final void invoke(int i11) {
        ((SortOptionsRecycleViewAdapter) this.receiver).onRadioButtonClicked(i11);
    }
}
