package com.designsystem.ds_tabs_view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\n¢\u0006\u0004\b\u001b\u0010\u001cJ\b\u0010\u0003\u001a\u00020\u0002H\u0002J\b\u0010\u0005\u001a\u00020\u0004H\u0014J\u0016\u0010\t\u001a\u00020\b2\f\u0010\u0007\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006H\u0014J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0014R\u0016\u0010\u000e\u001a\u00020\r8\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0011\u001a\u00020\u00108\u0002@\u0002X.¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0014\u001a\u00020\u00138\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u001e"}, d2 = {"Lcom/designsystem/ds_tabs_view/DSVerticalTabsView;", "Lcom/designsystem/ds_tabs_view/DSTabsView;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "provideScrollListener", "Landroid/view/View;", "b", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "adapter", "", "c", "", "tabIndex", "a", "Landroidx/recyclerview/widget/RecyclerView;", "contentContainer", "Landroidx/recyclerview/widget/RecyclerView;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "", "isScrollingProgrammatically", "Z", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "Companion", "marshmallow_release"}, k = 1, mv = {1, 5, 1})
public final class DSVerticalTabsView extends DSTabsView {
    public static final int $stable = 8;
    private static final int COMPLETELY_VISIBLE_ITEM_NOT_FOUND = -1;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private RecyclerView contentContainer;
    /* access modifiers changed from: private */
    public boolean isScrollingProgrammatically;
    /* access modifiers changed from: private */
    public LinearLayoutManager layoutManager;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/designsystem/ds_tabs_view/DSVerticalTabsView$Companion;", "", "()V", "COMPLETELY_VISIBLE_ITEM_NOT_FOUND", "", "marshmallow_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSVerticalTabsView(@NotNull Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSVerticalTabsView(@NotNull Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DSVerticalTabsView(Context context, AttributeSet attributeSet, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    private final RecyclerView.OnScrollListener provideScrollListener() {
        return new DSVerticalTabsView$provideScrollListener$1(this);
    }

    public void _$_clearFindViewByIdCache() {
    }

    public void a(int i11) {
        RecyclerView recyclerView = this.contentContainer;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            recyclerView = null;
        }
        recyclerView.smoothScrollToPosition(i11);
        this.isScrollingProgrammatically = true;
    }

    @NotNull
    public View b() {
        this.layoutManager = new LinearLayoutManager(getContext());
        RecyclerView recyclerView = new RecyclerView(getContext());
        LinearLayoutManager linearLayoutManager = this.layoutManager;
        if (linearLayoutManager == null) {
            Intrinsics.throwUninitializedPropertyAccessException("layoutManager");
            linearLayoutManager = null;
        }
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(provideScrollListener());
        this.contentContainer = recyclerView;
        return recyclerView;
    }

    public void c(@Nullable RecyclerView.Adapter<?> adapter) {
        RecyclerView recyclerView = this.contentContainer;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("contentContainer");
            recyclerView = null;
        }
        recyclerView.setAdapter(adapter);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public DSVerticalTabsView(@NotNull Context context, @Nullable AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
    }
}
