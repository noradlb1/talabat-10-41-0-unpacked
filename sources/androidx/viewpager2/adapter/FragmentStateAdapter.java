package androidx.viewpager2.adapter;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArraySet;
import androidx.collection.LongSparseArray;
import androidx.core.util.Preconditions;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

public abstract class FragmentStateAdapter extends RecyclerView.Adapter<FragmentViewHolder> implements StatefulAdapter {
    private static final long GRACE_WINDOW_TIME_MS = 10000;
    private static final String KEY_PREFIX_FRAGMENT = "f#";
    private static final String KEY_PREFIX_STATE = "s#";

    /* renamed from: i  reason: collision with root package name */
    public final Lifecycle f37906i;

    /* renamed from: j  reason: collision with root package name */
    public final FragmentManager f37907j;

    /* renamed from: k  reason: collision with root package name */
    public final LongSparseArray<Fragment> f37908k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f37909l;
    private FragmentMaxLifecycleEnforcer mFragmentMaxLifecycleEnforcer;
    private boolean mHasStaleFragments;
    private final LongSparseArray<Integer> mItemIdToViewHolder;
    private final LongSparseArray<Fragment.SavedState> mSavedStates;

    public static abstract class DataSetChangeObserver extends RecyclerView.AdapterDataObserver {
        private DataSetChangeObserver() {
        }

        public abstract void onChanged();

        public final void onItemRangeChanged(int i11, int i12) {
            onChanged();
        }

        public final void onItemRangeInserted(int i11, int i12) {
            onChanged();
        }

        public final void onItemRangeMoved(int i11, int i12, int i13) {
            onChanged();
        }

        public final void onItemRangeRemoved(int i11, int i12) {
            onChanged();
        }

        public final void onItemRangeChanged(int i11, int i12, @Nullable Object obj) {
            onChanged();
        }
    }

    public class FragmentMaxLifecycleEnforcer {
        private RecyclerView.AdapterDataObserver mDataObserver;
        private LifecycleEventObserver mLifecycleObserver;
        private ViewPager2.OnPageChangeCallback mPageChangeCallback;
        private long mPrimaryItemId = -1;
        private ViewPager2 mViewPager;

        public FragmentMaxLifecycleEnforcer() {
        }

        @NonNull
        private ViewPager2 inferViewPager(@NonNull RecyclerView recyclerView) {
            ViewParent parent = recyclerView.getParent();
            if (parent instanceof ViewPager2) {
                return (ViewPager2) parent;
            }
            throw new IllegalStateException("Expected ViewPager2 instance. Got: " + parent);
        }

        public void a(@NonNull RecyclerView recyclerView) {
            this.mViewPager = inferViewPager(recyclerView);
            AnonymousClass1 r22 = new ViewPager2.OnPageChangeCallback() {
                public void onPageScrollStateChanged(int i11) {
                    FragmentMaxLifecycleEnforcer.this.c(false);
                }

                public void onPageSelected(int i11) {
                    FragmentMaxLifecycleEnforcer.this.c(false);
                }
            };
            this.mPageChangeCallback = r22;
            this.mViewPager.registerOnPageChangeCallback(r22);
            AnonymousClass2 r23 = new DataSetChangeObserver() {
                public void onChanged() {
                    FragmentMaxLifecycleEnforcer.this.c(true);
                }
            };
            this.mDataObserver = r23;
            FragmentStateAdapter.this.registerAdapterDataObserver(r23);
            AnonymousClass3 r24 = new LifecycleEventObserver() {
                public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                    FragmentMaxLifecycleEnforcer.this.c(false);
                }
            };
            this.mLifecycleObserver = r24;
            FragmentStateAdapter.this.f37906i.addObserver(r24);
        }

        public void b(@NonNull RecyclerView recyclerView) {
            inferViewPager(recyclerView).unregisterOnPageChangeCallback(this.mPageChangeCallback);
            FragmentStateAdapter.this.unregisterAdapterDataObserver(this.mDataObserver);
            FragmentStateAdapter.this.f37906i.removeObserver(this.mLifecycleObserver);
            this.mViewPager = null;
        }

        public void c(boolean z11) {
            int currentItem;
            Fragment fragment;
            boolean z12;
            if (!FragmentStateAdapter.this.g() && this.mViewPager.getScrollState() == 0 && !FragmentStateAdapter.this.f37908k.isEmpty() && FragmentStateAdapter.this.getItemCount() != 0 && (currentItem = this.mViewPager.getCurrentItem()) < FragmentStateAdapter.this.getItemCount()) {
                long itemId = FragmentStateAdapter.this.getItemId(currentItem);
                if ((itemId != this.mPrimaryItemId || z11) && (fragment = FragmentStateAdapter.this.f37908k.get(itemId)) != null && fragment.isAdded()) {
                    this.mPrimaryItemId = itemId;
                    FragmentTransaction beginTransaction = FragmentStateAdapter.this.f37907j.beginTransaction();
                    Fragment fragment2 = null;
                    for (int i11 = 0; i11 < FragmentStateAdapter.this.f37908k.size(); i11++) {
                        long keyAt = FragmentStateAdapter.this.f37908k.keyAt(i11);
                        Fragment valueAt = FragmentStateAdapter.this.f37908k.valueAt(i11);
                        if (valueAt.isAdded()) {
                            if (keyAt != this.mPrimaryItemId) {
                                beginTransaction.setMaxLifecycle(valueAt, Lifecycle.State.STARTED);
                            } else {
                                fragment2 = valueAt;
                            }
                            if (keyAt == this.mPrimaryItemId) {
                                z12 = true;
                            } else {
                                z12 = false;
                            }
                            valueAt.setMenuVisibility(z12);
                        }
                    }
                    if (fragment2 != null) {
                        beginTransaction.setMaxLifecycle(fragment2, Lifecycle.State.RESUMED);
                    }
                    if (!beginTransaction.isEmpty()) {
                        beginTransaction.commitNow();
                    }
                }
            }
        }
    }

    public FragmentStateAdapter(@NonNull FragmentActivity fragmentActivity) {
        this(fragmentActivity.getSupportFragmentManager(), fragmentActivity.getLifecycle());
    }

    @NonNull
    private static String createKey(@NonNull String str, long j11) {
        return str + j11;
    }

    private void ensureFragment(int i11) {
        long itemId = getItemId(i11);
        if (!this.f37908k.containsKey(itemId)) {
            Fragment createFragment = createFragment(i11);
            createFragment.setInitialSavedState(this.mSavedStates.get(itemId));
            this.f37908k.put(itemId, createFragment);
        }
    }

    private boolean isFragmentViewBound(long j11) {
        View view;
        if (this.mItemIdToViewHolder.containsKey(j11)) {
            return true;
        }
        Fragment fragment = this.f37908k.get(j11);
        if (fragment == null || (view = fragment.getView()) == null) {
            return false;
        }
        if (view.getParent() != null) {
            return true;
        }
        return false;
    }

    private static boolean isValidKey(@NonNull String str, @NonNull String str2) {
        return str.startsWith(str2) && str.length() > str2.length();
    }

    private Long itemForViewHolder(int i11) {
        Long l11 = null;
        for (int i12 = 0; i12 < this.mItemIdToViewHolder.size(); i12++) {
            if (this.mItemIdToViewHolder.valueAt(i12).intValue() == i11) {
                if (l11 == null) {
                    l11 = Long.valueOf(this.mItemIdToViewHolder.keyAt(i12));
                } else {
                    throw new IllegalStateException("Design assumption violated: a ViewHolder can only be bound to one item at a time.");
                }
            }
        }
        return l11;
    }

    private static long parseIdFromKey(@NonNull String str, @NonNull String str2) {
        return Long.parseLong(str.substring(str2.length()));
    }

    private void removeFragment(long j11) {
        ViewParent parent;
        Fragment fragment = this.f37908k.get(j11);
        if (fragment != null) {
            if (!(fragment.getView() == null || (parent = fragment.getView().getParent()) == null)) {
                ((FrameLayout) parent).removeAllViews();
            }
            if (!containsItem(j11)) {
                this.mSavedStates.remove(j11);
            }
            if (!fragment.isAdded()) {
                this.f37908k.remove(j11);
            } else if (g()) {
                this.mHasStaleFragments = true;
            } else {
                if (fragment.isAdded() && containsItem(j11)) {
                    this.mSavedStates.put(j11, this.f37907j.saveFragmentInstanceState(fragment));
                }
                this.f37907j.beginTransaction().remove(fragment).commitNow();
                this.f37908k.remove(j11);
            }
        }
    }

    private void scheduleGracePeriodEnd() {
        final Handler handler = new Handler(Looper.getMainLooper());
        final AnonymousClass4 r12 = new Runnable() {
            public void run() {
                FragmentStateAdapter fragmentStateAdapter = FragmentStateAdapter.this;
                fragmentStateAdapter.f37909l = false;
                fragmentStateAdapter.e();
            }
        };
        this.f37906i.addObserver(new LifecycleEventObserver() {
            public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                if (event == Lifecycle.Event.ON_DESTROY) {
                    handler.removeCallbacks(r12);
                    lifecycleOwner.getLifecycle().removeObserver(this);
                }
            }
        });
        handler.postDelayed(r12, 10000);
    }

    private void scheduleViewAttach(final Fragment fragment, @NonNull final FrameLayout frameLayout) {
        this.f37907j.registerFragmentLifecycleCallbacks(new FragmentManager.FragmentLifecycleCallbacks() {
            public void onFragmentViewCreated(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, @NonNull View view, @Nullable Bundle bundle) {
                if (fragment == fragment) {
                    fragmentManager.unregisterFragmentLifecycleCallbacks(this);
                    FragmentStateAdapter.this.a(view, frameLayout);
                }
            }
        }, false);
    }

    public void a(@NonNull View view, @NonNull FrameLayout frameLayout) {
        if (frameLayout.getChildCount() > 1) {
            throw new IllegalStateException("Design assumption violated.");
        } else if (view.getParent() != frameLayout) {
            if (frameLayout.getChildCount() > 0) {
                frameLayout.removeAllViews();
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            frameLayout.addView(view);
        }
    }

    public boolean containsItem(long j11) {
        return j11 >= 0 && j11 < ((long) getItemCount());
    }

    @NonNull
    public abstract Fragment createFragment(int i11);

    public void e() {
        if (this.mHasStaleFragments && !g()) {
            ArraySet<Long> arraySet = new ArraySet<>();
            for (int i11 = 0; i11 < this.f37908k.size(); i11++) {
                long keyAt = this.f37908k.keyAt(i11);
                if (!containsItem(keyAt)) {
                    arraySet.add(Long.valueOf(keyAt));
                    this.mItemIdToViewHolder.remove(keyAt);
                }
            }
            if (!this.f37909l) {
                this.mHasStaleFragments = false;
                for (int i12 = 0; i12 < this.f37908k.size(); i12++) {
                    long keyAt2 = this.f37908k.keyAt(i12);
                    if (!isFragmentViewBound(keyAt2)) {
                        arraySet.add(Long.valueOf(keyAt2));
                    }
                }
            }
            for (Long longValue : arraySet) {
                removeFragment(longValue.longValue());
            }
        }
    }

    public void f(@NonNull final FragmentViewHolder fragmentViewHolder) {
        Fragment fragment = this.f37908k.get(fragmentViewHolder.getItemId());
        if (fragment != null) {
            FrameLayout c11 = fragmentViewHolder.c();
            View view = fragment.getView();
            if (!fragment.isAdded() && view != null) {
                throw new IllegalStateException("Design assumption violated.");
            } else if (fragment.isAdded() && view == null) {
                scheduleViewAttach(fragment, c11);
            } else if (!fragment.isAdded() || view.getParent() == null) {
                if (fragment.isAdded()) {
                    a(view, c11);
                } else if (!g()) {
                    scheduleViewAttach(fragment, c11);
                    FragmentTransaction beginTransaction = this.f37907j.beginTransaction();
                    beginTransaction.add(fragment, "f" + fragmentViewHolder.getItemId()).setMaxLifecycle(fragment, Lifecycle.State.STARTED).commitNow();
                    this.mFragmentMaxLifecycleEnforcer.c(false);
                } else if (!this.f37907j.isDestroyed()) {
                    this.f37906i.addObserver(new LifecycleEventObserver() {
                        public void onStateChanged(@NonNull LifecycleOwner lifecycleOwner, @NonNull Lifecycle.Event event) {
                            if (!FragmentStateAdapter.this.g()) {
                                lifecycleOwner.getLifecycle().removeObserver(this);
                                if (ViewCompat.isAttachedToWindow(fragmentViewHolder.c())) {
                                    FragmentStateAdapter.this.f(fragmentViewHolder);
                                }
                            }
                        }
                    });
                }
            } else if (view.getParent() != c11) {
                a(view, c11);
            }
        } else {
            throw new IllegalStateException("Design assumption violated.");
        }
    }

    public boolean g() {
        return this.f37907j.isStateSaved();
    }

    public long getItemId(int i11) {
        return (long) i11;
    }

    @CallSuper
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        boolean z11;
        if (this.mFragmentMaxLifecycleEnforcer == null) {
            z11 = true;
        } else {
            z11 = false;
        }
        Preconditions.checkArgument(z11);
        FragmentMaxLifecycleEnforcer fragmentMaxLifecycleEnforcer = new FragmentMaxLifecycleEnforcer();
        this.mFragmentMaxLifecycleEnforcer = fragmentMaxLifecycleEnforcer;
        fragmentMaxLifecycleEnforcer.a(recyclerView);
    }

    @CallSuper
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        this.mFragmentMaxLifecycleEnforcer.b(recyclerView);
        this.mFragmentMaxLifecycleEnforcer = null;
    }

    public final boolean onFailedToRecycleView(@NonNull FragmentViewHolder fragmentViewHolder) {
        return true;
    }

    public final void restoreState(@NonNull Parcelable parcelable) {
        if (!this.mSavedStates.isEmpty() || !this.f37908k.isEmpty()) {
            throw new IllegalStateException("Expected the adapter to be 'fresh' while restoring state.");
        }
        Bundle bundle = (Bundle) parcelable;
        if (bundle.getClassLoader() == null) {
            bundle.setClassLoader(getClass().getClassLoader());
        }
        for (String next : bundle.keySet()) {
            if (isValidKey(next, KEY_PREFIX_FRAGMENT)) {
                this.f37908k.put(parseIdFromKey(next, KEY_PREFIX_FRAGMENT), this.f37907j.getFragment(bundle, next));
            } else if (isValidKey(next, KEY_PREFIX_STATE)) {
                long parseIdFromKey = parseIdFromKey(next, KEY_PREFIX_STATE);
                Fragment.SavedState savedState = (Fragment.SavedState) bundle.getParcelable(next);
                if (containsItem(parseIdFromKey)) {
                    this.mSavedStates.put(parseIdFromKey, savedState);
                }
            } else {
                throw new IllegalArgumentException("Unexpected key in savedState: " + next);
            }
        }
        if (!this.f37908k.isEmpty()) {
            this.mHasStaleFragments = true;
            this.f37909l = true;
            e();
            scheduleGracePeriodEnd();
        }
    }

    @NonNull
    public final Parcelable saveState() {
        Bundle bundle = new Bundle(this.f37908k.size() + this.mSavedStates.size());
        for (int i11 = 0; i11 < this.f37908k.size(); i11++) {
            long keyAt = this.f37908k.keyAt(i11);
            Fragment fragment = this.f37908k.get(keyAt);
            if (fragment != null && fragment.isAdded()) {
                this.f37907j.putFragment(bundle, createKey(KEY_PREFIX_FRAGMENT, keyAt), fragment);
            }
        }
        for (int i12 = 0; i12 < this.mSavedStates.size(); i12++) {
            long keyAt2 = this.mSavedStates.keyAt(i12);
            if (containsItem(keyAt2)) {
                bundle.putParcelable(createKey(KEY_PREFIX_STATE, keyAt2), this.mSavedStates.get(keyAt2));
            }
        }
        return bundle;
    }

    public final void setHasStableIds(boolean z11) {
        throw new UnsupportedOperationException("Stable Ids are required for the adapter to function properly, and the adapter takes care of setting the flag.");
    }

    public FragmentStateAdapter(@NonNull Fragment fragment) {
        this(fragment.getChildFragmentManager(), fragment.getLifecycle());
    }

    public final void onBindViewHolder(@NonNull final FragmentViewHolder fragmentViewHolder, int i11) {
        long itemId = fragmentViewHolder.getItemId();
        int id2 = fragmentViewHolder.c().getId();
        Long itemForViewHolder = itemForViewHolder(id2);
        if (!(itemForViewHolder == null || itemForViewHolder.longValue() == itemId)) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
        this.mItemIdToViewHolder.put(itemId, Integer.valueOf(id2));
        ensureFragment(i11);
        final FrameLayout c11 = fragmentViewHolder.c();
        if (ViewCompat.isAttachedToWindow(c11)) {
            if (c11.getParent() == null) {
                c11.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
                    public void onLayoutChange(View view, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18) {
                        if (c11.getParent() != null) {
                            c11.removeOnLayoutChangeListener(this);
                            FragmentStateAdapter.this.f(fragmentViewHolder);
                        }
                    }
                });
            } else {
                throw new IllegalStateException("Design assumption violated.");
            }
        }
        e();
    }

    @NonNull
    public final FragmentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i11) {
        return FragmentViewHolder.a(viewGroup);
    }

    public final void onViewAttachedToWindow(@NonNull FragmentViewHolder fragmentViewHolder) {
        f(fragmentViewHolder);
        e();
    }

    public final void onViewRecycled(@NonNull FragmentViewHolder fragmentViewHolder) {
        Long itemForViewHolder = itemForViewHolder(fragmentViewHolder.c().getId());
        if (itemForViewHolder != null) {
            removeFragment(itemForViewHolder.longValue());
            this.mItemIdToViewHolder.remove(itemForViewHolder.longValue());
        }
    }

    public FragmentStateAdapter(@NonNull FragmentManager fragmentManager, @NonNull Lifecycle lifecycle) {
        this.f37908k = new LongSparseArray<>();
        this.mSavedStates = new LongSparseArray<>();
        this.mItemIdToViewHolder = new LongSparseArray<>();
        this.f37909l = false;
        this.mHasStaleFragments = false;
        this.f37907j = fragmentManager;
        this.f37906i = lifecycle;
        super.setHasStableIds(true);
    }
}
