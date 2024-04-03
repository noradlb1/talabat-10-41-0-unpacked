package com.talabat.darkstores.feature.product.views;

import android.widget.ImageView;
import com.talabat.darkstores.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class CartIndicator$image$2 extends Lambda implements Function0<ImageView> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ CartIndicator f56567g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CartIndicator$image$2(CartIndicator cartIndicator) {
        super(0);
        this.f56567g = cartIndicator;
    }

    public final ImageView invoke() {
        return (ImageView) this.f56567g._$_findCachedViewById(R.id.cart_indicator_image);
    }
}
