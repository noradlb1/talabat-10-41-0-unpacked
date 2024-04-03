package com.designsystem.ds_tabs;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.gestures.FlingBehavior;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.ViewCompositionStrategy;
import androidx.core.os.BundleKt;
import androidx.fragment.app.Fragment;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Instrumented
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0005¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0014\u001a\u00020\u0006H\u0001¢\u0006\u0004\b\u0015\u0010\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016R'\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00048@X\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\u000b\u001a\u0004\u0018\u00010\u00058@X\u0002¢\u0006\f\n\u0004\b\u000e\u0010\n\u001a\u0004\b\f\u0010\rR!\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00050\u00108@X\u0002¢\u0006\f\n\u0004\b\u0013\u0010\n\u001a\u0004\b\u0011\u0010\u0012¨\u0006 "}, d2 = {"Lcom/designsystem/ds_tabs/TabBarMenuFragment;", "Landroidx/fragment/app/Fragment;", "()V", "onMenuItemTap", "Lkotlin/Function1;", "Lcom/designsystem/ds_tabs/DSTabItemModel;", "", "getOnMenuItemTap$marshmallow_release", "()Lkotlin/jvm/functions/Function1;", "onMenuItemTap$delegate", "Lkotlin/Lazy;", "selectedTab", "getSelectedTab$marshmallow_release", "()Lcom/designsystem/ds_tabs/DSTabItemModel;", "selectedTab$delegate", "tabs", "", "getTabs$marshmallow_release", "()Ljava/util/List;", "tabs$delegate", "Menu", "Menu$marshmallow_release", "(Landroidx/compose/runtime/Composer;I)V", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class TabBarMenuFragment extends Fragment implements TraceFieldInterface {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String TAB_BAR_ON_MENU_ITEM_TAP = "TAB_BAR_ON_MENU_ITEM_TAP";
    @NotNull
    private static final String TAB_BAR_SELECTED_TAB = "TAB_BAR_SELECTED_TAB";
    @NotNull
    private static final String TAB_BAR_TABS = "TAB_BAR_TABS";
    public Trace _nr_trace;
    @NotNull
    private final Lazy onMenuItemTap$delegate = LazyKt__LazyJVMKt.lazy(new TabBarMenuFragment$onMenuItemTap$2(this));
    @NotNull
    private final Lazy selectedTab$delegate = LazyKt__LazyJVMKt.lazy(new TabBarMenuFragment$selectedTab$2(this));
    @NotNull
    private final Lazy tabs$delegate = LazyKt__LazyJVMKt.lazy(new TabBarMenuFragment$tabs$2(this));

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u000bR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/designsystem/ds_tabs/TabBarMenuFragment$Companion;", "", "()V", "TAB_BAR_ON_MENU_ITEM_TAP", "", "TAB_BAR_SELECTED_TAB", "TAB_BAR_TABS", "newInstance", "Lcom/designsystem/ds_tabs/TabBarMenuFragment;", "tabs", "", "Lcom/designsystem/ds_tabs/DSTabItemModel;", "onMenuItemTap", "Lkotlin/Function1;", "", "selectedTab", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TabBarMenuFragment newInstance(@NotNull List<DSTabItemModel> list, @NotNull Function1<? super DSTabItemModel, Unit> function1, @Nullable DSTabItemModel dSTabItemModel) {
            Intrinsics.checkNotNullParameter(list, "tabs");
            Intrinsics.checkNotNullParameter(function1, "onMenuItemTap");
            TabBarMenuFragment tabBarMenuFragment = new TabBarMenuFragment();
            tabBarMenuFragment.setArguments(BundleKt.bundleOf(TuplesKt.to(TabBarMenuFragment.TAB_BAR_TABS, list), TuplesKt.to(TabBarMenuFragment.TAB_BAR_ON_MENU_ITEM_TAP, function1), TuplesKt.to(TabBarMenuFragment.TAB_BAR_SELECTED_TAB, dSTabItemModel)));
            return tabBarMenuFragment;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: Menu$lambda-2  reason: not valid java name */
    public static final DSTabItemModel m8626Menu$lambda2(MutableState<DSTabItemModel> mutableState) {
        return mutableState.getValue();
    }

    /* access modifiers changed from: private */
    /* renamed from: Menu$lambda-3  reason: not valid java name */
    public static final void m8627Menu$lambda3(MutableState<DSTabItemModel> mutableState, DSTabItemModel dSTabItemModel) {
        mutableState.setValue(dSTabItemModel);
    }

    @Composable
    public final void Menu$marshmallow_release(@Nullable Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-84363457);
        startRestartGroup.startReplaceableGroup(-3687241);
        Object rememberedValue = startRestartGroup.rememberedValue();
        if (rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getSelectedTab$marshmallow_release(), (SnapshotMutationPolicy) null, 2, (Object) null);
            startRestartGroup.updateRememberedValue(rememberedValue);
        }
        startRestartGroup.endReplaceableGroup();
        LazyDslKt.LazyColumn((Modifier) null, (LazyListState) null, (PaddingValues) null, false, (Arrangement.Vertical) null, (Alignment.Horizontal) null, (FlingBehavior) null, new TabBarMenuFragment$Menu$1(this, (MutableState) rememberedValue), startRestartGroup, 0, 127);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TabBarMenuFragment$Menu$2(this, i11));
        }
    }

    public void _$_clearFindViewByIdCache() {
    }

    @NotNull
    public final Function1<DSTabItemModel, Unit> getOnMenuItemTap$marshmallow_release() {
        return (Function1) this.onMenuItemTap$delegate.getValue();
    }

    @Nullable
    public final DSTabItemModel getSelectedTab$marshmallow_release() {
        return (DSTabItemModel) this.selectedTab$delegate.getValue();
    }

    @NotNull
    public final List<DSTabItemModel> getTabs$marshmallow_release() {
        Object value = this.tabs$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-tabs>(...)");
        return (List) value;
    }

    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "TabBarMenuFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "TabBarMenuFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ComposeView composeView = new ComposeView(requireContext, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        composeView.setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed.INSTANCE);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-985532591, true, new TabBarMenuFragment$onCreateView$1$1(this)));
        TraceMachine.exitMethod();
        return composeView;
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
