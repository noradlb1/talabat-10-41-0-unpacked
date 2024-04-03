package com.talabat.growth.ui.loyalty.history;

import androidx.recyclerview.widget.LinearLayoutManager;
import com.talabat.talabatcommon.listeners.PaginationScrollListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\b\u0010\u0004\u001a\u00020\u0003H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"com/talabat/growth/ui/loyalty/history/LoyaltyHistoryFragment$getPaginationListener$1", "Lcom/talabat/talabatcommon/listeners/PaginationScrollListener;", "isLastPage", "", "isLoading", "loadMoreItems", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoyaltyHistoryFragment$getPaginationListener$1 extends PaginationScrollListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoyaltyHistoryFragment f60690a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LoyaltyHistoryFragment$getPaginationListener$1(LinearLayoutManager linearLayoutManager, LoyaltyHistoryFragment loyaltyHistoryFragment) {
        super(linearLayoutManager);
        this.f60690a = loyaltyHistoryFragment;
    }

    public boolean isLastPage() {
        return this.f60690a.isLastPage;
    }

    public boolean isLoading() {
        return this.f60690a.isLoading;
    }

    public void loadMoreItems() {
        this.f60690a.isLoading = true;
        this.f60690a.getMoreItems();
    }
}
