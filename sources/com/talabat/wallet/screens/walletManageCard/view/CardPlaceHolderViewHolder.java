package com.talabat.wallet.screens.walletManageCard.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.talabat.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00052\u00020\u0001:\u0001\u0005B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/CardPlaceHolderViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "Companion", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CardPlaceHolderViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/wallet/screens/walletManageCard/view/CardPlaceHolderViewHolder$Companion;", "", "()V", "from", "Lcom/talabat/wallet/screens/walletManageCard/view/CardPlaceHolderViewHolder;", "parent", "Landroid/view/ViewGroup;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final CardPlaceHolderViewHolder from(@NotNull ViewGroup viewGroup) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.wallet_card_view_place_holder, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new CardPlaceHolderViewHolder(inflate);
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CardPlaceHolderViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
