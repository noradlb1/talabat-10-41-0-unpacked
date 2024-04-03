package com.talabat.darkstores.feature.product.views;

import android.view.View;
import com.talabat.darkstores.feature.product.views.CartButtonEvent;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n \u0004*\u0004\u0018\u00010\u00030\u0003H\n¢\u0006\u0002\b\u0005"}, d2 = {"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class AddToCartButton$1$3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AddToCartButton f56529b;

    public AddToCartButton$1$3(AddToCartButton addToCartButton) {
        this.f56529b = addToCartButton;
    }

    public final void onClick(View view) {
        this.f56529b.configurationSubject.onNext(CartButtonEvent.Add.INSTANCE);
    }
}
