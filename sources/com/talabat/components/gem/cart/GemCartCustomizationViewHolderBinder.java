package com.talabat.components.gem.cart;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.CartScreen;
import com.talabat.gem.integration.Gem;
import io.reactivex.functions.BiConsumer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\u0003H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/components/gem/cart/GemCartCustomizationViewHolderBinder;", "Lio/reactivex/functions/BiConsumer;", "Lcom/talabat/CartScreen;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "accept", "", "activity", "viewHolder", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GemCartCustomizationViewHolderBinder implements BiConsumer<CartScreen, RecyclerView.ViewHolder> {
    public void accept(@NotNull CartScreen cartScreen, @NotNull RecyclerView.ViewHolder viewHolder) {
        Intrinsics.checkNotNullParameter(cartScreen, "activity");
        Intrinsics.checkNotNullParameter(viewHolder, "viewHolder");
        Gem.withGemComponent(new GemCartCustomizationViewHolderBinder$accept$1(viewHolder, cartScreen));
    }
}
