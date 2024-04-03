package com.talabat.itemdetailsbottomsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class ItemDetailsBottomSheet$observatory$2 extends FunctionReferenceImpl implements Function1<Float, Unit> {
    public ItemDetailsBottomSheet$observatory$2(Object obj) {
        super(1, obj, ItemDetailsBottomSheet.class, "setChangedPrices", "setChangedPrices(Ljava/lang/Float;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Float) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Float f11) {
        ((ItemDetailsBottomSheet) this.receiver).setChangedPrices(f11);
    }
}
