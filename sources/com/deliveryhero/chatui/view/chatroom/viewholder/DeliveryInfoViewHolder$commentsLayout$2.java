package com.deliveryhero.chatui.view.chatroom.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import com.deliveryhero.customerchat.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/widget/LinearLayout;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class DeliveryInfoViewHolder$commentsLayout$2 extends Lambda implements Function0<LinearLayout> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ DeliveryInfoViewHolder f29663g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DeliveryInfoViewHolder$commentsLayout$2(DeliveryInfoViewHolder deliveryInfoViewHolder) {
        super(0);
        this.f29663g = deliveryInfoViewHolder;
    }

    @NotNull
    public final LinearLayout invoke() {
        View findViewById = this.f29663g.getView().findViewById(R.id.layout_delivery_comments);
        if (findViewById != null) {
            return (LinearLayout) findViewById;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout");
    }
}
