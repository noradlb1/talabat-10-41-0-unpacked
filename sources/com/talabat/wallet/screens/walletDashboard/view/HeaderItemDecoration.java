package com.talabat.wallet.screens.walletDashboard.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.apptimize.c;
import com.talabat.R;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001BB\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0007\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u0018\u0010\u001a\u001a\u00020\u00152\u0006\u0010\u0002\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u0019H\u0002J\u001a\u0010\u001d\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\bH\u0002J\u0010\u0010\u001f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\bH\u0002J\u001a\u0010 \u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002J \u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0011\u001a\u00020\u00192\u0006\u0010\"\u001a\u00020\u0019H\u0002J \u0010#\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010$\u001a\u00020%H\u0016R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R)\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\u00050\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/talabat/wallet/screens/walletDashboard/view/HeaderItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "shouldFadeOutHeader", "", "isHeader", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "itemPosition", "context", "Landroid/content/Context;", "(Landroidx/recyclerview/widget/RecyclerView;ZLkotlin/jvm/functions/Function1;Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "currentHeader", "Lkotlin/Pair;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "drawHeader", "", "c", "Landroid/graphics/Canvas;", "header", "Landroid/view/View;", "fixLayoutSize", "Landroid/view/ViewGroup;", "view", "getChildInContact", "contactPoint", "getHeaderPositionForItem", "getHeaderViewForItem", "moveHeader", "nextHeader", "onDrawOver", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "com_talabat_talabat_talabat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeaderItemDecoration extends RecyclerView.ItemDecoration {
    @NotNull
    private final Context context;
    /* access modifiers changed from: private */
    @Nullable
    public Pair<Integer, ? extends RecyclerView.ViewHolder> currentHeader;
    @NotNull
    private final Function1<Integer, Boolean> isHeader;
    private final boolean shouldFadeOutHeader;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderItemDecoration(RecyclerView recyclerView, boolean z11, Function1 function1, Context context2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(recyclerView, (i11 & 2) != 0 ? false : z11, function1, context2);
    }

    private final void drawHeader(Canvas canvas, View view) {
        canvas.save();
        canvas.translate(0.0f, 0.0f);
        view.draw(canvas);
        canvas.restore();
    }

    private final void fixLayoutSize(ViewGroup viewGroup, View view) {
        view.measure(ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824), viewGroup.getPaddingLeft() + viewGroup.getPaddingRight(), view.getLayoutParams().width), ViewGroup.getChildMeasureSpec(View.MeasureSpec.makeMeasureSpec(viewGroup.getHeight(), 0), viewGroup.getPaddingTop() + viewGroup.getPaddingBottom(), view.getLayoutParams().height));
        view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    private final View getChildInContact(RecyclerView recyclerView, int i11) {
        int childCount = recyclerView.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = recyclerView.getChildAt(i12);
            Rect rect = new Rect();
            recyclerView.getDecoratedBoundsWithMargins(childAt, rect);
            if (rect.bottom > i11 && rect.top <= i11) {
                return childAt;
            }
        }
        return null;
    }

    private final int getHeaderPositionForItem(int i11) {
        while (!this.isHeader.invoke(Integer.valueOf(i11)).booleanValue()) {
            i11--;
            if (i11 < 0) {
                return -1;
            }
        }
        return i11;
    }

    private final View getHeaderViewForItem(int i11, RecyclerView recyclerView) {
        int headerPositionForItem;
        RecyclerView.Adapter adapter;
        boolean z11;
        RecyclerView.ViewHolder viewHolder;
        RecyclerView.ViewHolder viewHolder2;
        RecyclerView.ViewHolder viewHolder3;
        View view;
        RecyclerView.ViewHolder viewHolder4;
        if (recyclerView.getAdapter() == null || (headerPositionForItem = getHeaderPositionForItem(i11)) == -1 || (adapter = recyclerView.getAdapter()) == null) {
            return null;
        }
        int itemViewType = adapter.getItemViewType(headerPositionForItem);
        Pair<Integer, ? extends RecyclerView.ViewHolder> pair = this.currentHeader;
        boolean z12 = true;
        if (pair == null || pair.getFirst().intValue() != headerPositionForItem) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            Pair<Integer, ? extends RecyclerView.ViewHolder> pair2 = this.currentHeader;
            if (pair2 == null || (viewHolder4 = (RecyclerView.ViewHolder) pair2.getSecond()) == null || viewHolder4.getItemViewType() != itemViewType) {
                z12 = false;
            }
            if (z12) {
                Pair<Integer, ? extends RecyclerView.ViewHolder> pair3 = this.currentHeader;
                if (!(pair3 == null || (viewHolder3 = (RecyclerView.ViewHolder) pair3.getSecond()) == null || (view = viewHolder3.itemView) == null)) {
                    view.setBackgroundColor(ContextCompat.getColor(this.context, R.color.white));
                }
                Pair<Integer, ? extends RecyclerView.ViewHolder> pair4 = this.currentHeader;
                if (pair4 == null || (viewHolder2 = (RecyclerView.ViewHolder) pair4.getSecond()) == null) {
                    return null;
                }
                return viewHolder2.itemView;
            }
        }
        RecyclerView.Adapter adapter2 = recyclerView.getAdapter();
        if (adapter2 != null) {
            viewHolder = adapter2.createViewHolder(recyclerView, itemViewType);
        } else {
            viewHolder = null;
        }
        if (viewHolder != null) {
            RecyclerView.Adapter adapter3 = recyclerView.getAdapter();
            if (adapter3 != null) {
                adapter3.onBindViewHolder(viewHolder, headerPositionForItem);
            }
            View view2 = viewHolder.itemView;
            Intrinsics.checkNotNullExpressionValue(view2, "headerHolder.itemView");
            fixLayoutSize(recyclerView, view2);
            this.currentHeader = TuplesKt.to(Integer.valueOf(headerPositionForItem), viewHolder);
        }
        if (viewHolder != null) {
            return viewHolder.itemView;
        }
        return null;
    }

    private final void moveHeader(Canvas canvas, View view, View view2) {
        canvas.save();
        canvas.translate(0.0f, (float) (view2.getTop() - view.getHeight()));
        view.setBackgroundColor(this.context.getResources().getColor(R.color.white));
        view.draw(canvas);
        canvas.restore();
    }

    @NotNull
    public final Context getContext() {
        return this.context;
    }

    public void onDrawOver(@NotNull Canvas canvas, @NotNull RecyclerView recyclerView, @NotNull RecyclerView.State state) {
        int childAdapterPosition;
        View headerViewForItem;
        View childInContact;
        Intrinsics.checkNotNullParameter(canvas, c.f41585a);
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(state, "state");
        super.onDrawOver(canvas, recyclerView, state);
        View childAt = recyclerView.getChildAt(0);
        if (childAt != null && (childAdapterPosition = recyclerView.getChildAdapterPosition(childAt)) != -1 && (headerViewForItem = getHeaderViewForItem(childAdapterPosition, recyclerView)) != null && (childInContact = getChildInContact(recyclerView, headerViewForItem.getBottom())) != null) {
            if (this.isHeader.invoke(Integer.valueOf(recyclerView.getChildAdapterPosition(childInContact))).booleanValue()) {
                moveHeader(canvas, headerViewForItem, childInContact);
            } else {
                drawHeader(canvas, headerViewForItem);
            }
        }
    }

    public HeaderItemDecoration(@NotNull RecyclerView recyclerView, boolean z11, @NotNull Function1<? super Integer, Boolean> function1, @NotNull Context context2) {
        Intrinsics.checkNotNullParameter(recyclerView, "parent");
        Intrinsics.checkNotNullParameter(function1, "isHeader");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.shouldFadeOutHeader = z11;
        this.isHeader = function1;
        this.context = context2;
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter != null) {
            adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver(this) {

                /* renamed from: a  reason: collision with root package name */
                public final /* synthetic */ HeaderItemDecoration f12682a;

                {
                    this.f12682a = r1;
                }

                public void onChanged() {
                    this.f12682a.currentHeader = null;
                }
            });
        }
        recyclerView.addOnLayoutChangeListener(new HeaderItemDecoration$special$$inlined$doOnEachNextLayout$1(this));
    }
}
