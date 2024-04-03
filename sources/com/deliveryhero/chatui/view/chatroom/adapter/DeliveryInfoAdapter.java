package com.deliveryhero.chatui.view.chatroom.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.deliveryhero.chatui.view.chatroom.DeliveryViewModel;
import com.deliveryhero.chatui.view.chatroom.viewholder.DeliveryInfoViewHolder;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00022\u0006\u0010\u000b\u001a\u00020\u0007H\u0016J\u0018\u0010\f\u001a\u00020\u00022\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0007H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/deliveryhero/chatui/view/chatroom/adapter/DeliveryInfoAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/deliveryhero/chatui/view/chatroom/viewholder/DeliveryInfoViewHolder;", "deliveryViewModel", "Lcom/deliveryhero/chatui/view/chatroom/DeliveryViewModel;", "(Lcom/deliveryhero/chatui/view/chatroom/DeliveryViewModel;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DeliveryInfoAdapter extends RecyclerView.Adapter<DeliveryInfoViewHolder> {
    @NotNull
    private final DeliveryViewModel deliveryViewModel;

    public DeliveryInfoAdapter(@NotNull DeliveryViewModel deliveryViewModel2) {
        Intrinsics.checkNotNullParameter(deliveryViewModel2, "deliveryViewModel");
        this.deliveryViewModel = deliveryViewModel2;
    }

    public int getItemCount() {
        return 1;
    }

    public void onBindViewHolder(@NotNull DeliveryInfoViewHolder deliveryInfoViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(deliveryInfoViewHolder, "holder");
        deliveryInfoViewHolder.bind(this.deliveryViewModel);
    }

    @NotNull
    public DeliveryInfoViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.customer_chat_viewholder_delivery, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…      false\n            )");
        return new DeliveryInfoViewHolder(inflate);
    }
}
