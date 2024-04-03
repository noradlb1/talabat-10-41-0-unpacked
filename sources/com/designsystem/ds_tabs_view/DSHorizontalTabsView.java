package com.designsystem.ds_tabs_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u000e\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0010\u0012\b\b\u0002\u0010\u0012\u001a\u00020\b¢\u0006\u0004\b\u0013\u0010\u0014J\b\u0010\u0003\u001a\u00020\u0002H\u0014J\u0016\u0010\u0007\u001a\u00020\u00062\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0014R\u0016\u0010\f\u001a\u00020\u000b8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\f\u0010\r¨\u0006\u0015"}, d2 = {"Lcom/designsystem/ds_tabs_view/DSHorizontalTabsView;", "Lcom/designsystem/ds_tabs_view/DSTabsView;", "Landroid/view/View;", "b", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "c", "", "tabIndex", "a", "Landroidx/viewpager2/widget/ViewPager2;", "contentContainer", "Landroidx/viewpager2/widget/ViewPager2;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "marshmallow_release"}, k = 1, mv = {1, 5, 1})
public final class DSHorizontalTabsView extends DSTabsView {
    public static final int $stable = 8;
    private ViewPager2 contentContainer;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSHorizontalTabsView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSHorizontalTabsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSHorizontalTabsView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void a(int i11) {
        ViewPager2 viewPager2 = this.contentContainer;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            viewPager2 = null;
        }
        viewPager2.setCurrentItem(i11, true);
    }

    @NotNull
    public View b() {
        ViewPager2 viewPager2 = new ViewPager2(getContext());
        viewPager2.setUserInputEnabled(false);
        this.contentContainer = viewPager2;
        return viewPager2;
    }

    public void c(@Nullable RecyclerView.Adapter<?> adapter) {
        ViewPager2 viewPager2 = this.contentContainer;
        if (viewPager2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            viewPager2 = null;
        }
        viewPager2.setAdapter(adapter);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSHorizontalTabsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
