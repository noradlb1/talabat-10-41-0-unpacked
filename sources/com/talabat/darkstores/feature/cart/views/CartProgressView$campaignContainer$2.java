package com.talabat.darkstores.feature.cart.views;

import android.widget.LinearLayout;
import com.talabat.darkstores.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartProgressView$campaignContainer$2 extends Lambda implements Function0<LinearLayout> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartProgressView f56293g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartProgressView$campaignContainer$2(CartProgressView cartProgressView) {
        super(0);
        this.f56293g = cartProgressView;
    }

    public final LinearLayout invoke() {
        return (LinearLayout) this.f56293g._$_findCachedViewById(R.id.cart_label_container);
    }
}
