package com.deliveryhero.chatui.view.chatroom.viewholder;

import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/constraintlayout/widget/ConstraintLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeliveryInfoViewHolder$infosLayout$2 extends Lambda implements Function0<ConstraintLayout> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeliveryInfoViewHolder f29667g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeliveryInfoViewHolder$infosLayout$2(DeliveryInfoViewHolder deliveryInfoViewHolder) {
        super(0);
        this.f29667g = deliveryInfoViewHolder;
    }

    @NotNull
    public final ConstraintLayout invoke() {
        View findViewById = this.f29667g.getView().findViewById(R.id.layout_delivery_infos);
        if (findViewById != null) {
            return (ConstraintLayout) findViewById;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout");
    }
}
