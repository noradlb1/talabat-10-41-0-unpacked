package com.google.android.material.tabs;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import java.lang.ref.WeakReference;

public final class TabLayoutMediator {
    @Nullable
    private RecyclerView.Adapter<?> adapter;
    private boolean attached;
    private final boolean autoRefresh;
    @Nullable
    private TabLayoutOnPageChangeCallback onPageChangeCallback;
    @Nullable
    private TabLayout.OnTabSelectedListener onTabSelectedListener;
    @Nullable
    private RecyclerView.AdapterDataObserver pagerAdapterObserver;
    private final boolean smoothScroll;
    private final TabConfigurationStrategy tabConfigurationStrategy;
    @NonNull
    private final TabLayout tabLayout;
    @NonNull
    private final ViewPager2 viewPager;

    public class PagerAdapterObserver extends RecyclerView.AdapterDataObserver {
        public PagerAdapterObserver() {
        }

        public void onChanged() {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeChanged(int i11, int i12) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeInserted(int i11, int i12) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeMoved(int i11, int i12, int i13) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeRemoved(int i11, int i12) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }

        public void onItemRangeChanged(int i11, int i12, @Nullable Object obj) {
            TabLayoutMediator.this.populateTabsFromPagerAdapter();
        }
    }

    public interface TabConfigurationStrategy {
        void onConfigureTab(@NonNull TabLayout.Tab tab, int i11);
    }

    public static class TabLayoutOnPageChangeCallback extends ViewPager2.OnPageChangeCallback {
        private int previousScrollState;
        private int scrollState;
        @NonNull
        private final WeakReference<TabLayout> tabLayoutRef;

        public TabLayoutOnPageChangeCallback(TabLayout tabLayout) {
            this.tabLayoutRef = new WeakReference<>(tabLayout);
            reset();
        }

        public void onPageScrollStateChanged(int i11) {
            this.previousScrollState = this.scrollState;
            this.scrollState = i11;
        }

        public void onPageScrolled(int i11, float f11, int i12) {
            boolean z11;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null) {
                int i13 = this.scrollState;
                boolean z12 = false;
                if (i13 != 2 || this.previousScrollState == 1) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (!(i13 == 2 && this.previousScrollState == 0)) {
                    z12 = true;
                }
                tabLayout.setScrollPosition(i11, f11, z11, z12);
            }
        }

        public void onPageSelected(int i11) {
            boolean z11;
            TabLayout tabLayout = this.tabLayoutRef.get();
            if (tabLayout != null && tabLayout.getSelectedTabPosition() != i11 && i11 < tabLayout.getTabCount()) {
                int i12 = this.scrollState;
                if (i12 == 0 || (i12 == 2 && this.previousScrollState == 0)) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                tabLayout.selectTab(tabLayout.getTabAt(i11), z11);
            }
        }

        public void reset() {
            this.scrollState = 0;
            this.previousScrollState = 0;
        }
    }

    public static class ViewPagerOnTabSelectedListener implements TabLayout.OnTabSelectedListener {
        private final boolean smoothScroll;
        private final ViewPager2 viewPager;

        public ViewPagerOnTabSelectedListener(ViewPager2 viewPager2, boolean z11) {
            this.viewPager = viewPager2;
            this.smoothScroll = z11;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        public void onTabSelected(@NonNull TabLayout.Tab tab) {
            this.viewPager.setCurrentItem(tab.getPosition(), this.smoothScroll);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout2, @NonNull ViewPager2 viewPager2, @NonNull TabConfigurationStrategy tabConfigurationStrategy2) {
        this(tabLayout2, viewPager2, true, tabConfigurationStrategy2);
    }

    public void attach() {
        if (!this.attached) {
            RecyclerView.Adapter<?> adapter2 = this.viewPager.getAdapter();
            this.adapter = adapter2;
            if (adapter2 != null) {
                this.attached = true;
                TabLayoutOnPageChangeCallback tabLayoutOnPageChangeCallback = new TabLayoutOnPageChangeCallback(this.tabLayout);
                this.onPageChangeCallback = tabLayoutOnPageChangeCallback;
                this.viewPager.registerOnPageChangeCallback(tabLayoutOnPageChangeCallback);
                ViewPagerOnTabSelectedListener viewPagerOnTabSelectedListener = new ViewPagerOnTabSelectedListener(this.viewPager, this.smoothScroll);
                this.onTabSelectedListener = viewPagerOnTabSelectedListener;
                this.tabLayout.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) viewPagerOnTabSelectedListener);
                if (this.autoRefresh) {
                    PagerAdapterObserver pagerAdapterObserver2 = new PagerAdapterObserver();
                    this.pagerAdapterObserver = pagerAdapterObserver2;
                    this.adapter.registerAdapterDataObserver(pagerAdapterObserver2);
                }
                populateTabsFromPagerAdapter();
                this.tabLayout.setScrollPosition(this.viewPager.getCurrentItem(), 0.0f, true);
                return;
            }
            throw new IllegalStateException("TabLayoutMediator attached before ViewPager2 has an adapter");
        }
        throw new IllegalStateException("TabLayoutMediator is already attached");
    }

    public void detach() {
        RecyclerView.Adapter<?> adapter2;
        if (this.autoRefresh && (adapter2 = this.adapter) != null) {
            adapter2.unregisterAdapterDataObserver(this.pagerAdapterObserver);
            this.pagerAdapterObserver = null;
        }
        this.tabLayout.removeOnTabSelectedListener(this.onTabSelectedListener);
        this.viewPager.unregisterOnPageChangeCallback(this.onPageChangeCallback);
        this.onTabSelectedListener = null;
        this.onPageChangeCallback = null;
        this.adapter = null;
        this.attached = false;
    }

    public boolean isAttached() {
        return this.attached;
    }

    public void populateTabsFromPagerAdapter() {
        int min;
        this.tabLayout.removeAllTabs();
        RecyclerView.Adapter<?> adapter2 = this.adapter;
        if (adapter2 != null) {
            int itemCount = adapter2.getItemCount();
            for (int i11 = 0; i11 < itemCount; i11++) {
                TabLayout.Tab newTab = this.tabLayout.newTab();
                this.tabConfigurationStrategy.onConfigureTab(newTab, i11);
                this.tabLayout.addTab(newTab, false);
            }
            if (itemCount > 0 && (min = Math.min(this.viewPager.getCurrentItem(), this.tabLayout.getTabCount() - 1)) != this.tabLayout.getSelectedTabPosition()) {
                TabLayout tabLayout2 = this.tabLayout;
                tabLayout2.selectTab(tabLayout2.getTabAt(min));
            }
        }
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout2, @NonNull ViewPager2 viewPager2, boolean z11, @NonNull TabConfigurationStrategy tabConfigurationStrategy2) {
        this(tabLayout2, viewPager2, z11, true, tabConfigurationStrategy2);
    }

    public TabLayoutMediator(@NonNull TabLayout tabLayout2, @NonNull ViewPager2 viewPager2, boolean z11, boolean z12, @NonNull TabConfigurationStrategy tabConfigurationStrategy2) {
        this.tabLayout = tabLayout2;
        this.viewPager = viewPager2;
        this.autoRefresh = z11;
        this.smoothScroll = z12;
        this.tabConfigurationStrategy = tabConfigurationStrategy2;
    }
}
