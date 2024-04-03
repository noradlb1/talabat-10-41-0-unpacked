package com.talabat.itemdetailsbottomsheet;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import org.jetbrains.annotations.Nullable;

@Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
public /* synthetic */ class ItemDetailsBottomSheet$observatory$1 extends FunctionReferenceImpl implements Function1<Integer, Unit> {
    public ItemDetailsBottomSheet$observatory$1(Object obj) {
        super(1, obj, ItemDetailsBottomSheet.class, "setQuantity", "setQuantity(Ljava/lang/Integer;)V", 0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Integer) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Integer num) {
        ((ItemDetailsBottomSheet) this.receiver).setQuantity(num);
    }
}
