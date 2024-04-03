package androidx.navigation.fragment;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.annotation.CallSuper;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.R;
import androidx.navigation.fragment.NavHostFragment;
import androidx.slidingpanelayout.widget.SlidingPaneLayout;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u00002\u00020\u0001:\u0001&B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0010\u001a\u00020\u0004H\u0016J$\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&J$\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\"\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017J\u001a\u0010 \u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u0010\u0010\"\u001a\u00020\u001b2\u0006\u0010#\u001a\u00020\u0018H\u0017J\u001a\u0010$\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0007J\u0012\u0010%\u001a\u00020\u001b2\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0017R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006'"}, d2 = {"Landroidx/navigation/fragment/AbstractListDetailFragment;", "Landroidx/fragment/app/Fragment;", "()V", "_detailPaneNavHostFragment", "Landroidx/navigation/fragment/NavHostFragment;", "detailPaneNavHostFragment", "getDetailPaneNavHostFragment", "()Landroidx/navigation/fragment/NavHostFragment;", "graphId", "", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "slidingPaneLayout", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "getSlidingPaneLayout", "()Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "onCreateDetailPaneNavHostFragment", "onCreateListPaneView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "onInflate", "", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "onListPaneViewCreated", "view", "onSaveInstanceState", "outState", "onViewCreated", "onViewStateRestored", "InnerOnBackPressedCallback", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class AbstractListDetailFragment extends Fragment {
    @Nullable
    private NavHostFragment _detailPaneNavHostFragment;
    private int graphId;
    /* access modifiers changed from: private */
    @Nullable
    public OnBackPressedCallback onBackPressedCallback;

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0000\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Landroidx/navigation/fragment/AbstractListDetailFragment$InnerOnBackPressedCallback;", "Landroidx/activity/OnBackPressedCallback;", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout$PanelSlideListener;", "slidingPaneLayout", "Landroidx/slidingpanelayout/widget/SlidingPaneLayout;", "(Landroidx/slidingpanelayout/widget/SlidingPaneLayout;)V", "handleOnBackPressed", "", "onPanelClosed", "panel", "Landroid/view/View;", "onPanelOpened", "onPanelSlide", "slideOffset", "", "navigation-fragment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class InnerOnBackPressedCallback extends OnBackPressedCallback implements SlidingPaneLayout.PanelSlideListener {
        @NotNull
        private final SlidingPaneLayout slidingPaneLayout;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public InnerOnBackPressedCallback(@NotNull SlidingPaneLayout slidingPaneLayout2) {
            super(true);
            Intrinsics.checkNotNullParameter(slidingPaneLayout2, "slidingPaneLayout");
            this.slidingPaneLayout = slidingPaneLayout2;
            slidingPaneLayout2.addPanelSlideListener(this);
        }

        public void handleOnBackPressed() {
            this.slidingPaneLayout.closePane();
        }

        public void onPanelClosed(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "panel");
            setEnabled(false);
        }

        public void onPanelOpened(@NotNull View view) {
            Intrinsics.checkNotNullParameter(view, "panel");
            setEnabled(true);
        }

        public void onPanelSlide(@NotNull View view, float f11) {
            Intrinsics.checkNotNullParameter(view, "panel");
        }
    }

    @NotNull
    public final NavHostFragment getDetailPaneNavHostFragment() {
        NavHostFragment navHostFragment = this._detailPaneNavHostFragment;
        if (navHostFragment == null) {
            throw new IllegalStateException(("Fragment " + this + " was called before onCreateView().").toString());
        } else if (navHostFragment != null) {
            return navHostFragment;
        } else {
            throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        }
    }

    @NotNull
    public final SlidingPaneLayout getSlidingPaneLayout() {
        return (SlidingPaneLayout) requireView();
    }

    @NotNull
    public NavHostFragment onCreateDetailPaneNavHostFragment() {
        int i11 = this.graphId;
        if (i11 != 0) {
            return NavHostFragment.Companion.create$default(NavHostFragment.Companion, i11, (Bundle) null, 2, (Object) null);
        }
        return new NavHostFragment();
    }

    @NotNull
    public abstract View onCreateListPaneView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle);

    @NotNull
    @CallSuper
    public final View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        NavHostFragment navHostFragment;
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        if (bundle != null) {
            this.graphId = bundle.getInt(NavHostFragment.KEY_GRAPH_ID);
        }
        SlidingPaneLayout slidingPaneLayout = new SlidingPaneLayout(layoutInflater.getContext());
        slidingPaneLayout.setId(R.id.sliding_pane_layout);
        View onCreateListPaneView = onCreateListPaneView(layoutInflater, slidingPaneLayout, bundle);
        if (!Intrinsics.areEqual((Object) onCreateListPaneView, (Object) slidingPaneLayout) && !Intrinsics.areEqual((Object) onCreateListPaneView.getParent(), (Object) slidingPaneLayout)) {
            slidingPaneLayout.addView(onCreateListPaneView);
        }
        Context context = layoutInflater.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "inflater.context");
        FragmentContainerView fragmentContainerView = new FragmentContainerView(context);
        int i11 = R.id.sliding_pane_detail_container;
        fragmentContainerView.setId(i11);
        SlidingPaneLayout.LayoutParams layoutParams = new SlidingPaneLayout.LayoutParams(layoutInflater.getContext().getResources().getDimensionPixelSize(R.dimen.sliding_pane_detail_pane_width), -1);
        layoutParams.weight = 1.0f;
        slidingPaneLayout.addView(fragmentContainerView, layoutParams);
        Fragment findFragmentById = getChildFragmentManager().findFragmentById(i11);
        boolean z11 = true;
        if (findFragmentById != null) {
            navHostFragment = (NavHostFragment) findFragmentById;
        } else {
            navHostFragment = onCreateDetailPaneNavHostFragment();
            FragmentManager childFragmentManager = getChildFragmentManager();
            Intrinsics.checkNotNullExpressionValue(childFragmentManager, "childFragmentManager");
            FragmentTransaction beginTransaction = childFragmentManager.beginTransaction();
            Intrinsics.checkNotNullExpressionValue(beginTransaction, "beginTransaction()");
            beginTransaction.setReorderingAllowed(true);
            beginTransaction.add(i11, (Fragment) navHostFragment);
            beginTransaction.commit();
        }
        this._detailPaneNavHostFragment = navHostFragment;
        this.onBackPressedCallback = new InnerOnBackPressedCallback(slidingPaneLayout);
        if (!ViewCompat.isLaidOut(slidingPaneLayout) || slidingPaneLayout.isLayoutRequested()) {
            slidingPaneLayout.addOnLayoutChangeListener(new AbstractListDetailFragment$onCreateView$$inlined$doOnLayout$1(this, slidingPaneLayout));
        } else {
            OnBackPressedCallback access$getOnBackPressedCallback$p = this.onBackPressedCallback;
            Intrinsics.checkNotNull(access$getOnBackPressedCallback$p);
            if (!slidingPaneLayout.isSlideable() || !slidingPaneLayout.isOpen()) {
                z11 = false;
            }
            access$getOnBackPressedCallback$p.setEnabled(z11);
        }
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        OnBackPressedCallback onBackPressedCallback2 = this.onBackPressedCallback;
        Intrinsics.checkNotNull(onBackPressedCallback2);
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, onBackPressedCallback2);
        return slidingPaneLayout;
    }

    @CallSuper
    public void onInflate(@NotNull Context context, @NotNull AttributeSet attributeSet, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        super.onInflate(context, attributeSet, bundle);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.NavHost);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…yleable.NavHost\n        )");
        int resourceId = obtainStyledAttributes.getResourceId(R.styleable.NavHost_navGraph, 0);
        if (resourceId != 0) {
            this.graphId = resourceId;
        }
        Unit unit = Unit.INSTANCE;
        obtainStyledAttributes.recycle();
    }

    public void onListPaneViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
    }

    @CallSuper
    public void onSaveInstanceState(@NotNull Bundle bundle) {
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        int i11 = this.graphId;
        if (i11 != 0) {
            bundle.putInt(NavHostFragment.KEY_GRAPH_ID, i11);
        }
    }

    @CallSuper
    public final void onViewCreated(@NotNull View view, @Nullable Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        View childAt = getSlidingPaneLayout().getChildAt(0);
        Intrinsics.checkNotNullExpressionValue(childAt, "listPaneView");
        onListPaneViewCreated(childAt, bundle);
    }

    @CallSuper
    public void onViewStateRestored(@Nullable Bundle bundle) {
        boolean z11;
        super.onViewStateRestored(bundle);
        OnBackPressedCallback onBackPressedCallback2 = this.onBackPressedCallback;
        Intrinsics.checkNotNull(onBackPressedCallback2);
        if (!getSlidingPaneLayout().isSlideable() || !getSlidingPaneLayout().isOpen()) {
            z11 = false;
        } else {
            z11 = true;
        }
        onBackPressedCallback2.setEnabled(z11);
    }
}
