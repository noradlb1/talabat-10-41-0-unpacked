package com.talabat.sdsquad.ui.restaurantssearch.globalsearch;

import android.os.Handler;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.tabs.TabLayout;
import com.talabat.sdsquad.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ku.d;
import ku.e;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/talabat/sdsquad/ui/restaurantssearch/globalsearch/GlobalSearchFragment$mTabSelectedListener$1", "Lcom/google/android/material/tabs/TabLayout$OnTabSelectedListener;", "onTabReselected", "", "tab", "Lcom/google/android/material/tabs/TabLayout$Tab;", "onTabSelected", "onTabUnselected", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlobalSearchFragment$mTabSelectedListener$1 implements TabLayout.OnTabSelectedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ GlobalSearchFragment f61342a;

    public GlobalSearchFragment$mTabSelectedListener$1(GlobalSearchFragment globalSearchFragment) {
        this.f61342a = globalSearchFragment;
    }

    /* access modifiers changed from: private */
    /* renamed from: onTabSelected$lambda-0  reason: not valid java name */
    public static final void m10834onTabSelected$lambda0(GlobalSearchFragment globalSearchFragment) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "this$0");
        RecyclerView recyclerView = (RecyclerView) globalSearchFragment._$_findCachedViewById(R.id.globalSearchRecyclerView);
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(globalSearchFragment.mListScrollListener);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onTabSelected$lambda-1  reason: not valid java name */
    public static final void m10835onTabSelected$lambda1(GlobalSearchFragment globalSearchFragment) {
        Intrinsics.checkNotNullParameter(globalSearchFragment, "this$0");
        RecyclerView recyclerView = (RecyclerView) globalSearchFragment._$_findCachedViewById(R.id.globalSearchRecyclerView);
        if (recyclerView != null) {
            recyclerView.addOnScrollListener(globalSearchFragment.mListScrollListener);
        }
    }

    public void onTabReselected(@NotNull TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
    }

    public void onTabSelected(@NotNull TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        if (tab.getTag() != null) {
            GlobalSearchFragment globalSearchFragment = this.f61342a;
            int i11 = R.id.globalSearchRecyclerView;
            if (((RecyclerView) globalSearchFragment._$_findCachedViewById(i11)) == null) {
                return;
            }
            if (StringsKt__StringsJVMKt.equals((String) tab.getTag(), "restaurant", true)) {
                ((RecyclerView) this.f61342a._$_findCachedViewById(i11)).removeOnScrollListener(this.f61342a.mListScrollListener);
                ((RecyclerView) this.f61342a._$_findCachedViewById(i11)).scrollToPosition(0);
                new Handler().postDelayed(new d(this.f61342a), 100);
            } else if (StringsKt__StringsJVMKt.equals((String) tab.getTag(), "dish", true)) {
                ((RecyclerView) this.f61342a._$_findCachedViewById(i11)).removeOnScrollListener(this.f61342a.mListScrollListener);
                RecyclerView.LayoutManager layoutManager = ((RecyclerView) this.f61342a._$_findCachedViewById(i11)).getLayoutManager();
                if (layoutManager != null) {
                    LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
                    GlobalSearchViewModel access$getViewModel$p = this.f61342a.viewModel;
                    if (access$getViewModel$p == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
                        access$getViewModel$p = null;
                    }
                    linearLayoutManager.scrollToPositionWithOffset(access$getViewModel$p.getDishHeaderPosition(), 0);
                    new Handler().postDelayed(new e(this.f61342a), 100);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
            }
        }
    }

    public void onTabUnselected(@NotNull TabLayout.Tab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
    }
}
