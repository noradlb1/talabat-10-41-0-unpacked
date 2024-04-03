package com.designsystem.ds_tabs_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import com.designsystem.ds_tabs.DSTabBar;
import com.designsystem.ds_tabs.DSTabBarCallbacks;
import com.designsystem.marshmallow.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u0000 C2\u00020\u0001:\u0001CB'\b\u0007\u0012\u0006\u0010=\u001a\u00020<\u0012\n\b\u0002\u0010?\u001a\u0004\u0018\u00010>\u0012\b\b\u0002\u0010@\u001a\u00020\u0010¢\u0006\u0004\bA\u0010BJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0004\u001a\u00020\u0002H\u0002J\u001a\u0010\u0007\u001a\u00020\u00022\u0010\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0005H\u0002J\u001e\u0010\u000b\u001a\u00020\u00022\u0014\u0010\n\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\t\u0018\u00010\bH\u0002J\b\u0010\r\u001a\u00020\fH\u0002J\b\u0010\u000f\u001a\u00020\u000eH$J\u0010\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0010H$J\u0016\u0010\u0014\u001a\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013H$J\b\u0010\u0015\u001a\u00020\u0010H\u0004R>\u0010\u0006\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00052\u0010\u0010\u0016\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u00058\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u0006\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR*\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u0016\u001a\u00020\u001c8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R.\u0010$\u001a\u0004\u0018\u00010#2\b\u0010\u0016\u001a\u0004\u0018\u00010#8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R.\u0010+\u001a\u0004\u0018\u00010*2\b\u0010\u0016\u001a\u0004\u0018\u00010*8\u0006@FX\u000e¢\u0006\u0012\n\u0004\b+\u0010,\u001a\u0004\b-\u0010.\"\u0004\b/\u00100R.\u00102\u001a\u0004\u0018\u0001012\b\u0010\u0016\u001a\u0004\u0018\u0001018\u0006@FX\u000e¢\u0006\u0012\n\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u0014\u0010;\u001a\u0002088DX\u0004¢\u0006\u0006\u001a\u0004\b9\u0010:¨\u0006D"}, d2 = {"Lcom/designsystem/ds_tabs_view/DSTabsView;", "Landroid/widget/LinearLayout;", "", "setupTabSelectionListener", "addContainerView", "Lcom/designsystem/ds_tabs_view/DSTabsViewContentAdapter;", "adapter", "setupAdapter", "", "Lcom/designsystem/ds_tabs_view/DSTabsViewItemModel;", "tabViewModels", "updateTabs", "Landroid/widget/LinearLayout$LayoutParams;", "provideContentContainerLayoutParams", "Landroid/view/View;", "b", "", "tabIndex", "a", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "c", "getSelectedTabIndex", "value", "Lcom/designsystem/ds_tabs_view/DSTabsViewContentAdapter;", "getAdapter", "()Lcom/designsystem/ds_tabs_view/DSTabsViewContentAdapter;", "setAdapter", "(Lcom/designsystem/ds_tabs_view/DSTabsViewContentAdapter;)V", "Lcom/designsystem/ds_tabs/DSTabBar$DSTabBarType;", "tabBarType", "Lcom/designsystem/ds_tabs/DSTabBar$DSTabBarType;", "getTabBarType", "()Lcom/designsystem/ds_tabs/DSTabBar$DSTabBarType;", "setTabBarType", "(Lcom/designsystem/ds_tabs/DSTabBar$DSTabBarType;)V", "", "menuTitle", "Ljava/lang/String;", "getMenuTitle", "()Ljava/lang/String;", "setMenuTitle", "(Ljava/lang/String;)V", "Lcom/designsystem/ds_tabs/DSTabBarCallbacks;", "callbacks", "Lcom/designsystem/ds_tabs/DSTabBarCallbacks;", "getCallbacks", "()Lcom/designsystem/ds_tabs/DSTabBarCallbacks;", "setCallbacks", "(Lcom/designsystem/ds_tabs/DSTabBarCallbacks;)V", "Landroidx/fragment/app/FragmentManager;", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "getFragmentManager", "()Landroidx/fragment/app/FragmentManager;", "setFragmentManager", "(Landroidx/fragment/app/FragmentManager;)V", "Lcom/designsystem/ds_tabs/DSTabBar;", "getTabBar", "()Lcom/designsystem/ds_tabs/DSTabBar;", "tabBar", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1})
public abstract class DSTabsView extends LinearLayout {
    public static final int $stable = 8;
    @NotNull
    public static final String CONTAINER_VIEW_TAG = "ContentContainerViewTag";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Nullable
    private DSTabsViewContentAdapter<?, ?> adapter;
    @Nullable
    private DSTabBarCallbacks callbacks;
    @Nullable
    private FragmentManager fragmentManager;
    @Nullable
    private String menuTitle;
    @NotNull
    private DSTabBar.DSTabBarType tabBarType;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/designsystem/ds_tabs_view/DSTabsView$Companion;", "", "()V", "CONTAINER_VIEW_TAG", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTabsView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTabsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSTabsView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final void addContainerView() {
        View b11 = b();
        b11.setTag(CONTAINER_VIEW_TAG);
        Unit unit = Unit.INSTANCE;
        ((LinearLayout) findViewById(R.id.container)).addView(b11, provideContentContainerLayoutParams());
    }

    private final LinearLayout.LayoutParams provideContentContainerLayoutParams() {
        return new LinearLayout.LayoutParams(-1, -1);
    }

    private final void setupAdapter(DSTabsViewContentAdapter<?, ?> dSTabsViewContentAdapter) {
        List<?> list;
        if (dSTabsViewContentAdapter != null) {
            dSTabsViewContentAdapter.registerAdapterDataObserver(new DSTabsView$setupAdapter$1(this, dSTabsViewContentAdapter));
        }
        if (dSTabsViewContentAdapter == null) {
            list = null;
        } else {
            list = dSTabsViewContentAdapter.getCurrentList();
        }
        updateTabs(list);
        c(dSTabsViewContentAdapter);
    }

    private final void setupTabSelectionListener() {
        ((DSTabBar) findViewById(R.id.tabBarMenu)).setOnTabSelected(new DSTabsView$setupTabSelectionListener$1(this));
    }

    /* access modifiers changed from: private */
    public final void updateTabs(List<? extends DSTabsViewItemModel<?>> list) {
        List list2;
        DSTabBar tabBar = getTabBar();
        if (list == null) {
            list2 = null;
        } else {
            Iterable<DSTabsViewItemModel> iterable = list;
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(iterable, 10));
            for (DSTabsViewItemModel tabModel : iterable) {
                arrayList.add(tabModel.getTabModel());
            }
            list2 = arrayList;
        }
        if (list2 == null) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        }
        tabBar.setTabs(list2);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public abstract void a(int i11);

    @NotNull
    public abstract View b();

    public abstract void c(@Nullable RecyclerView.Adapter<?> adapter2);

    @Nullable
    public final DSTabsViewContentAdapter<?, ?> getAdapter() {
        return this.adapter;
    }

    @Nullable
    public final DSTabBarCallbacks getCallbacks() {
        return this.callbacks;
    }

    @Nullable
    public final FragmentManager getFragmentManager() {
        return this.fragmentManager;
    }

    @Nullable
    public final String getMenuTitle() {
        return this.menuTitle;
    }

    public final int getSelectedTabIndex() {
        return ((DSTabBar) findViewById(R.id.tabBarMenu)).getSelectedTabIndex();
    }

    @NotNull
    public final DSTabBar getTabBar() {
        DSTabBar dSTabBar = (DSTabBar) findViewById(R.id.tabBarMenu);
        Intrinsics.checkNotNullExpressionValue(dSTabBar, "tabBarMenu");
        return dSTabBar;
    }

    @NotNull
    public final DSTabBar.DSTabBarType getTabBarType() {
        return this.tabBarType;
    }

    public final void setAdapter(@Nullable DSTabsViewContentAdapter<?, ?> dSTabsViewContentAdapter) {
        this.adapter = dSTabsViewContentAdapter;
        setupAdapter(dSTabsViewContentAdapter);
    }

    public final void setCallbacks(@Nullable DSTabBarCallbacks dSTabBarCallbacks) {
        getTabBar().setCallbacks(dSTabBarCallbacks);
        this.callbacks = dSTabBarCallbacks;
    }

    public final void setFragmentManager(@Nullable FragmentManager fragmentManager2) {
        getTabBar().setFragmentManager(fragmentManager2);
        this.fragmentManager = fragmentManager2;
    }

    public final void setMenuTitle(@Nullable String str) {
        getTabBar().setMenuTitle(str);
        this.menuTitle = str;
    }

    public final void setTabBarType(@NotNull DSTabBar.DSTabBarType dSTabBarType) {
        Intrinsics.checkNotNullParameter(dSTabBarType, "value");
        getTabBar().setType(dSTabBarType);
        this.tabBarType = dSTabBarType;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSTabsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        DSTabBar.DSTabBarType dSTabBarType = DSTabBar.DSTabBarType.MENU;
        this.tabBarType = dSTabBarType;
        LayoutInflater.from(context).inflate(R.layout.ds_tab_view, this, true);
        int[] iArr = R.styleable.DSTabView;
        Intrinsics.checkNotNullExpressionValue(iArr, "DSTabView");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i11, 0);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes)");
        int i12 = obtainStyledAttributes.getInt(R.styleable.DSTabView_tv_tap_bar_type, -1);
        setTabBarType(i12 >= 0 ? DSTabBar.DSTabBarType.values()[i12] : dSTabBarType);
        setMenuTitle(obtainStyledAttributes.getString(R.styleable.DSTabView_tv_menu_title));
        obtainStyledAttributes.recycle();
        setupTabSelectionListener();
        addContainerView();
    }
}
