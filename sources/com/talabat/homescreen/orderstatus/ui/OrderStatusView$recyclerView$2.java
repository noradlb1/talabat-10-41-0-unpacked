package com.talabat.homescreen.orderstatus.ui;

import androidx.recyclerview.widget.RecyclerView;
import com.talabat.homescreen.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/recyclerview/widget/RecyclerView;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class OrderStatusView$recyclerView$2 extends Lambda implements Function0<RecyclerView> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ OrderStatusView f60973g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderStatusView$recyclerView$2(OrderStatusView orderStatusView) {
        super(0);
        this.f60973g = orderStatusView;
    }

    public final RecyclerView invoke() {
        return (RecyclerView) this.f60973g.findViewById(R.id.recyclerView);
    }
}
