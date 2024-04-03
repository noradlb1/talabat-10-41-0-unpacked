package com.talabat.darkstores.feature.categories.subcategories;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.talabat.darkstores.R;
import com.talabat.talabatcommon.extension.ViewKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import yi.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u0002\u0012\b\u0012\u00060\u0003R\u00020\u00000\u0001:\u0002 !B\u000f\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u0017\u001a\u00020\r2\n\u0010\u0018\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u0016\u001a\u00020\tH\u0016J\u001c\u0010\u0019\u001a\u00060\u0003R\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\tH\u0016J-\u0010\u001d\u001a\u00020\r2%\u0010\u000f\u001a!\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\bj\u0002`\u000eJ\u000e\u0010\u001e\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\tRd\u0010\u000f\u001a%\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000e2)\u0010\u0007\u001a%\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r\u0018\u00010\bj\u0004\u0018\u0001`\u000e@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\t@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\""}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/HeadlinesChipsListAdapter;", "Landroidx/recyclerview/widget/ListAdapter;", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryHeadline;", "Lcom/talabat/darkstores/feature/categories/subcategories/HeadlinesChipsListAdapter$ViewHolder;", "newDesign", "", "(Z)V", "<set-?>", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "headlineIndex", "", "Lcom/talabat/darkstores/feature/categories/subcategories/HeadlineClickListener;", "clickListener", "getClickListener", "()Lkotlin/jvm/functions/Function1;", "currentSelectedPosition", "getCurrentSelectedPosition", "()I", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "setCurrentSelection", "newPosition", "DiffCallback", "ViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeadlinesChipsListAdapter extends ListAdapter<SubcategoryHeadline, ViewHolder> {
    @Nullable
    private Function1<? super Integer, Unit> clickListener;
    private int currentSelectedPosition;
    private final boolean newDesign;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\bÀ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016J\u0018\u0010\b\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0007\u001a\u00020\u0002H\u0016¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/HeadlinesChipsListAdapter$DiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/talabat/darkstores/feature/categories/subcategories/SubcategoryHeadline;", "()V", "areContentsTheSame", "", "oldItem", "newItem", "areItemsTheSame", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class DiffCallback extends DiffUtil.ItemCallback<SubcategoryHeadline> {
        @NotNull
        public static final DiffCallback INSTANCE = new DiffCallback();

        private DiffCallback() {
        }

        public boolean areContentsTheSame(@NotNull SubcategoryHeadline subcategoryHeadline, @NotNull SubcategoryHeadline subcategoryHeadline2) {
            Intrinsics.checkNotNullParameter(subcategoryHeadline, "oldItem");
            Intrinsics.checkNotNullParameter(subcategoryHeadline2, "newItem");
            return Intrinsics.areEqual((Object) subcategoryHeadline, (Object) subcategoryHeadline2);
        }

        public boolean areItemsTheSame(@NotNull SubcategoryHeadline subcategoryHeadline, @NotNull SubcategoryHeadline subcategoryHeadline2) {
            Intrinsics.checkNotNullParameter(subcategoryHeadline, "oldItem");
            Intrinsics.checkNotNullParameter(subcategoryHeadline2, "newItem");
            return Intrinsics.areEqual((Object) subcategoryHeadline.getHeadline(), (Object) subcategoryHeadline2.getHeadline());
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/HeadlinesChipsListAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Lcom/talabat/darkstores/feature/categories/subcategories/HeadlinesChipsListAdapter;Landroid/view/View;)V", "chip", "Lcom/google/android/material/chip/Chip;", "getContainerView", "()Landroid/view/View;", "bind", "", "headline", "", "isChecked", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final Chip chip;
        @NotNull
        private final View containerView;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ HeadlinesChipsListAdapter f56311h;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull HeadlinesChipsListAdapter headlinesChipsListAdapter, View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.f56311h = headlinesChipsListAdapter;
            this.containerView = view;
            View findViewById = getContainerView().findViewById(R.id.chip);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.chip)");
            this.chip = (Chip) findViewById;
        }

        public final void bind(@NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "headline");
            this.chip.setText(str);
            this.chip.setChecked(z11);
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    public HeadlinesChipsListAdapter() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeadlinesChipsListAdapter(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? true : z11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9863onBindViewHolder$lambda0(HeadlinesChipsListAdapter headlinesChipsListAdapter, SubcategoryHeadline subcategoryHeadline, View view) {
        Intrinsics.checkNotNullParameter(headlinesChipsListAdapter, "this$0");
        Function1<? super Integer, Unit> function1 = headlinesChipsListAdapter.clickListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(subcategoryHeadline.getPositionOnList()));
        }
    }

    @Nullable
    public final Function1<Integer, Unit> getClickListener() {
        return this.clickListener;
    }

    public final int getCurrentSelectedPosition() {
        return this.currentSelectedPosition;
    }

    public int getItemViewType(int i11) {
        if (this.newDesign) {
            return R.layout.darkstores_item_subcategory_chip_new;
        }
        return R.layout.darkstores_item_subcategory_chip;
    }

    public final void setClickListener(@NotNull Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "clickListener");
        this.clickListener = function1;
    }

    public final void setCurrentSelection(int i11) {
        int i12 = this.currentSelectedPosition;
        this.currentSelectedPosition = i11;
        notifyItemChanged(i12);
        notifyItemChanged(i11);
    }

    public HeadlinesChipsListAdapter(boolean z11) {
        super(DiffCallback.INSTANCE);
        this.newDesign = z11;
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        SubcategoryHeadline subcategoryHeadline = (SubcategoryHeadline) getItem(i11);
        viewHolder.bind(subcategoryHeadline.getHeadline(), i11 == this.currentSelectedPosition);
        viewHolder.itemView.setOnClickListener(new a(this, subcategoryHeadline));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new ViewHolder(this, ViewKt.inflate(viewGroup, i11));
    }
}
