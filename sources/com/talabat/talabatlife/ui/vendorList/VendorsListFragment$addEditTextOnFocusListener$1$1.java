package com.talabat.talabatlife.ui.vendorList;

import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import com.talabat.talabatlife.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class VendorsListFragment$addEditTextOnFocusListener$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ VendorsListFragment f12086g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VendorsListFragment$addEditTextOnFocusListener$1$1(VendorsListFragment vendorsListFragment) {
        super(0);
        this.f12086g = vendorsListFragment;
    }

    public final void invoke() {
        ((Toolbar) this.f12086g._$_findCachedViewById(R.id.anim_toolbar)).setVisibility(8);
        ((TextView) this.f12086g._$_findCachedViewById(R.id.cancelBtn)).setVisibility(0);
        ((LinearLayout) this.f12086g._$_findCachedViewById(R.id.vendorsListSearchLinearLayout)).setSelected(true);
    }
}
