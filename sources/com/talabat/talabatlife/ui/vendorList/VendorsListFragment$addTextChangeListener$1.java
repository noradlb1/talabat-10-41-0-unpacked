package com.talabat.talabatlife.ui.vendorList;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "newText", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$addTextChangeListener$1 extends Lambda implements Function1<String, Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f12087g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorsListFragment$addTextChangeListener$1(VendorsListFragment vendorsListFragment) {
        super(1);
        this.f12087g = vendorsListFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@Nullable String str) {
        if (str != null) {
            VendorsListFragment vendorsListFragment = this.f12087g;
            if (str.length() == 0) {
                vendorsListFragment.removeClearButton();
            } else {
                vendorsListFragment.showClearButton();
            }
        }
    }
}
