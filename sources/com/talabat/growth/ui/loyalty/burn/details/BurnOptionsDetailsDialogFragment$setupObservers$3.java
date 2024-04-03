package com.talabat.growth.ui.loyalty.burn.details;

import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Lcom/talabat/growth/ui/loyalty/burn/models/BurnItemDisplayModel;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsDialogFragment$setupObservers$3 extends Lambda implements Function1<BurnItemDisplayModel, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BurnOptionsDetailsDialogFragment f60629g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BurnOptionsDetailsDialogFragment$setupObservers$3(BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment) {
        super(1);
        this.f60629g = burnOptionsDetailsDialogFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((BurnItemDisplayModel) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable BurnItemDisplayModel burnItemDisplayModel) {
        if (burnItemDisplayModel != null) {
            BurnOptionsDetailsDialogFragment burnOptionsDetailsDialogFragment = this.f60629g;
            burnOptionsDetailsDialogFragment.updateUi(burnItemDisplayModel, burnOptionsDetailsDialogFragment.getViewModel().getTotalPoints());
        }
    }
}
