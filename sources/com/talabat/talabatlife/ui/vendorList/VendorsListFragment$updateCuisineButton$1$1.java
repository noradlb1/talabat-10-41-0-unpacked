package com.talabat.talabatlife.ui.vendorList;

import com.talabat.talabatlife.domain.entity.Cuisine;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "cuisine", "Lcom/talabat/talabatlife/domain/entity/Cuisine;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$updateCuisineButton$1$1 extends Lambda implements Function1<Cuisine, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f12092g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorsListFragment$updateCuisineButton$1$1(VendorsListFragment vendorsListFragment) {
        super(1);
        this.f12092g = vendorsListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Cuisine) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable Cuisine cuisine) {
        if (cuisine != null) {
            VendorsListFragment vendorsListFragment = this.f12092g;
            vendorsListFragment.selectedCuisineId = cuisine.getId();
            VendorsListFragment.k(vendorsListFragment, 0, 0, (String) null, (String) null, (String) null, (String) null, 0, 0, 255, (Object) null);
        }
    }
}
