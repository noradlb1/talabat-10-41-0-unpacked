package com.talabat.growth.ui.loyalty.burn.burnOptionsDetails;

import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class BurnOptionsDetailsFragment$setupUI$3 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ BurnOptionsDetailsFragment f60607g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ BurnItemDisplayModel f60608h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BurnOptionsDetailsFragment$setupUI$3(BurnOptionsDetailsFragment burnOptionsDetailsFragment, BurnItemDisplayModel burnItemDisplayModel) {
        super(0);
        this.f60607g = burnOptionsDetailsFragment;
        this.f60608h = burnItemDisplayModel;
    }

    public final void invoke() {
        this.f60607g.showAreYouSureDialog(this.f60608h);
    }
}
