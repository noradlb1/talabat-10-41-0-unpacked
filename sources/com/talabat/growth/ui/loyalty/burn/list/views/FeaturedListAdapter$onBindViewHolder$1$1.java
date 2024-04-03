package com.talabat.growth.ui.loyalty.burn.list.views;

import com.talabat.growth.ui.loyalty.burn.list.views.FeaturedListAdapter;
import com.talabat.growth.ui.loyalty.burn.models.BurnItemDisplayModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Lkotlin/Unit;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class FeaturedListAdapter$onBindViewHolder$1$1 extends Lambda implements Function0<Unit> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ FeaturedListAdapter f60645g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f60646h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeaturedListAdapter$onBindViewHolder$1$1(FeaturedListAdapter featuredListAdapter, int i11) {
        super(0);
        this.f60645g = featuredListAdapter;
        this.f60646h = i11;
    }

    @Nullable
    public final Unit invoke() {
        FeaturedListAdapter.FeaturedListItemClickListener access$getItemClickListener$p = this.f60645g.itemClickListener;
        if (access$getItemClickListener$p == null) {
            return null;
        }
        access$getItemClickListener$p.onItemClicked(this.f60646h, (BurnItemDisplayModel) this.f60645g.burnItems.get(this.f60646h));
        return Unit.INSTANCE;
    }
}
