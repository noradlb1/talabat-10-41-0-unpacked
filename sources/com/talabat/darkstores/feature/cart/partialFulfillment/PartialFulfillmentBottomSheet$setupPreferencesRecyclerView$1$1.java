package com.talabat.darkstores.feature.cart.partialFulfillment;

import com.talabat.darkstores.data.partialFulfillment.model.Control;
import com.tekartik.sqflite.Constant;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "code", "Lcom/talabat/darkstores/data/partialFulfillment/model/Control;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PartialFulfillmentBottomSheet$setupPreferencesRecyclerView$1$1 extends Lambda implements Function1<Control, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ PartialFulfillmentBottomSheet f56288g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PartialFulfillmentBottomSheet$setupPreferencesRecyclerView$1$1(PartialFulfillmentBottomSheet partialFulfillmentBottomSheet) {
        super(1);
        this.f56288g = partialFulfillmentBottomSheet;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Control) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull Control control) {
        Intrinsics.checkNotNullParameter(control, Constant.PARAM_ERROR_CODE);
        this.f56288g.onPreferenceClicked();
    }
}
