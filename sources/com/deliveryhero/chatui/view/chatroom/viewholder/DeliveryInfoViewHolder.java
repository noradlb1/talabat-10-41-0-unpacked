package com.deliveryhero.chatui.view.chatroom.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.chatui.view.chatroom.DeliveryViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001b\u0010\u0010\u001a\u00020\u00068BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\n\u001a\u0004\b\u0011\u0010\bR\u001b\u0010\u0013\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\n\u001a\u0004\b\u0014\u0010\u000eR\u001b\u0010\u0016\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u0018\u0010\n\u001a\u0004\b\u0017\u0010\u000eR\u001b\u0010\u0019\u001a\u00020\f8BX\u0002¢\u0006\f\n\u0004\b\u001b\u0010\n\u001a\u0004\b\u001a\u0010\u000eR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0002¢\u0006\f\n\u0004\b \u0010\n\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/viewholder/DeliveryInfoViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "addressLayout", "Landroid/widget/LinearLayout;", "getAddressLayout", "()Landroid/widget/LinearLayout;", "addressLayout$delegate", "Lkotlin/Lazy;", "addressTextView", "Landroid/widget/TextView;", "getAddressTextView", "()Landroid/widget/TextView;", "addressTextView$delegate", "commentsLayout", "getCommentsLayout", "commentsLayout$delegate", "commentsTextView", "getCommentsTextView", "commentsTextView$delegate", "deliveryAmountTextView", "getDeliveryAmountTextView", "deliveryAmountTextView$delegate", "deliveryTextView", "getDeliveryTextView", "deliveryTextView$delegate", "infosLayout", "Landroidx/constraintlayout/widget/ConstraintLayout;", "getInfosLayout", "()Landroidx/constraintlayout/widget/ConstraintLayout;", "infosLayout$delegate", "getView", "()Landroid/view/View;", "bind", "", "viewModel", "Lcom/deliveryhero/chatui/view/chatroom/DeliveryViewModel;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryInfoViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final Lazy addressLayout$delegate = LazyKt__LazyJVMKt.lazy(new DeliveryInfoViewHolder$addressLayout$2(this));
    @NotNull
    private final Lazy addressTextView$delegate = LazyKt__LazyJVMKt.lazy(new DeliveryInfoViewHolder$addressTextView$2(this));
    @NotNull
    private final Lazy commentsLayout$delegate = LazyKt__LazyJVMKt.lazy(new DeliveryInfoViewHolder$commentsLayout$2(this));
    @NotNull
    private final Lazy commentsTextView$delegate = LazyKt__LazyJVMKt.lazy(new DeliveryInfoViewHolder$commentsTextView$2(this));
    @NotNull
    private final Lazy deliveryAmountTextView$delegate = LazyKt__LazyJVMKt.lazy(new DeliveryInfoViewHolder$deliveryAmountTextView$2(this));
    @NotNull
    private final Lazy deliveryTextView$delegate = LazyKt__LazyJVMKt.lazy(new DeliveryInfoViewHolder$deliveryTextView$2(this));
    @NotNull
    private final Lazy infosLayout$delegate = LazyKt__LazyJVMKt.lazy(new DeliveryInfoViewHolder$infosLayout$2(this));
    @NotNull
    private final View view;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeliveryInfoViewHolder(@NotNull View view2) {
        super(view2);
        Intrinsics.checkNotNullParameter(view2, "view");
        this.view = view2;
    }

    private final LinearLayout getAddressLayout() {
        return (LinearLayout) this.addressLayout$delegate.getValue();
    }

    private final TextView getAddressTextView() {
        return (TextView) this.addressTextView$delegate.getValue();
    }

    private final LinearLayout getCommentsLayout() {
        return (LinearLayout) this.commentsLayout$delegate.getValue();
    }

    private final TextView getCommentsTextView() {
        return (TextView) this.commentsTextView$delegate.getValue();
    }

    private final TextView getDeliveryAmountTextView() {
        return (TextView) this.deliveryAmountTextView$delegate.getValue();
    }

    private final TextView getDeliveryTextView() {
        return (TextView) this.deliveryTextView$delegate.getValue();
    }

    private final ConstraintLayout getInfosLayout() {
        return (ConstraintLayout) this.infosLayout$delegate.getValue();
    }

    public final void bind(@NotNull DeliveryViewModel deliveryViewModel) {
        boolean z11;
        int i11;
        boolean z12;
        int i12;
        boolean z13;
        int i13;
        boolean z14;
        int i14;
        boolean z15;
        Intrinsics.checkNotNullParameter(deliveryViewModel, "viewModel");
        String code = deliveryViewModel.getCode();
        String amount = deliveryViewModel.getAmount();
        String address = deliveryViewModel.getAddress();
        String comments = deliveryViewModel.getComments();
        getAddressTextView().setText(address);
        LinearLayout addressLayout = getAddressLayout();
        boolean z16 = true;
        int i15 = 0;
        if (address == null || address.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            i11 = 8;
        } else {
            i11 = 0;
        }
        addressLayout.setVisibility(i11);
        getDeliveryTextView().setText(code);
        TextView deliveryTextView = getDeliveryTextView();
        if (code == null || code.length() == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            i12 = 8;
        } else {
            i12 = 0;
        }
        deliveryTextView.setVisibility(i12);
        getDeliveryAmountTextView().setText(amount);
        TextView deliveryAmountTextView = getDeliveryAmountTextView();
        if (amount == null || amount.length() == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13) {
            i13 = 8;
        } else {
            i13 = 0;
        }
        deliveryAmountTextView.setVisibility(i13);
        getCommentsTextView().setText(comments);
        LinearLayout commentsLayout = getCommentsLayout();
        if (comments == null || comments.length() == 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        if (z14) {
            i14 = 8;
        } else {
            i14 = 0;
        }
        commentsLayout.setVisibility(i14);
        ConstraintLayout infosLayout = getInfosLayout();
        if (amount == null || amount.length() == 0) {
            z15 = true;
        } else {
            z15 = false;
        }
        if (z15) {
            if (!(code == null || code.length() == 0)) {
                z16 = false;
            }
            if (z16) {
                i15 = 8;
            }
        }
        infosLayout.setVisibility(i15);
    }

    @NotNull
    public final View getView() {
        return this.view;
    }
}
