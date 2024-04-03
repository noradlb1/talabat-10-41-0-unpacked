package com.talabat.darkstores.feature.categories.subcategories.experiment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.google.android.material.chip.Chip;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.darkstores.R;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import zi.a;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\t\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001!B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u0006J\b\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0018\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\fH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\fH\u0016J\u001e\u0010\u001b\u001a\u00020\t2\u0016\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u0002`\nJ\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\u0006J\u0014\u0010 \u001a\u00020\t2\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t0\bj\u0002`\nX.¢\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\""}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/HeadlinesChipsListAdapterNew;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/darkstores/feature/categories/subcategories/experiment/HeadlinesChipsListAdapterNew$ViewHolder;", "()V", "items", "", "", "onItemSelectedListener", "Lkotlin/Function1;", "", "Lcom/talabat/darkstores/feature/categories/subcategories/experiment/HeadlineClickListener;", "<set-?>", "", "selectedPos", "getSelectedPos", "()I", "getHeadlinePosition", "headline", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setClickListener", "listener", "setSelectedItem", "itemPosition", "selectedHeadline", "submitList", "ViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeadlinesChipsListAdapterNew extends RecyclerView.Adapter<ViewHolder> {
    @NotNull
    private List<String> items = CollectionsKt__CollectionsKt.emptyList();
    private Function1<? super String, Unit> onItemSelectedListener;
    private int selectedPos = -1;

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/experiment/HeadlinesChipsListAdapterNew$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Landroid/view/View;)V", "chip", "Lcom/google/android/material/chip/Chip;", "getContainerView", "()Landroid/view/View;", "bind", "", "headline", "", "isSelected", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final Chip chip;
        @NotNull
        private final View containerView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.containerView = view;
            View findViewById = getContainerView().findViewById(R.id.chip);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.chip)");
            this.chip = (Chip) findViewById;
        }

        public final void bind(@NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(str, "headline");
            this.chip.setChecked(z11);
            this.chip.setText(str);
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9883onBindViewHolder$lambda0(HeadlinesChipsListAdapterNew headlinesChipsListAdapterNew, int i11, View view) {
        Intrinsics.checkNotNullParameter(headlinesChipsListAdapterNew, "this$0");
        headlinesChipsListAdapterNew.setSelectedItem(i11);
        Function1<? super String, Unit> function1 = headlinesChipsListAdapterNew.onItemSelectedListener;
        if (function1 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("onItemSelectedListener");
            function1 = null;
        }
        function1.invoke(headlinesChipsListAdapterNew.items.get(i11));
    }

    public final int getHeadlinePosition(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "headline");
        return this.items.indexOf(str);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int i11) {
        return R.layout.darkstores_item_subcategory_chip_new;
    }

    public final int getSelectedPos() {
        return this.selectedPos;
    }

    public final void setClickListener(@NotNull Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.onItemSelectedListener = function1;
    }

    public final void setSelectedItem(int i11) {
        int i12 = this.selectedPos;
        Unit unit = Unit.INSTANCE;
        notifyItemChanged(i12, unit);
        notifyItemChanged(i11, unit);
        this.selectedPos = i11;
    }

    public final void submitList(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.items = list;
        notifyDataSetChanged();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.bind(this.items.get(i11), this.selectedPos == i11);
        viewHolder.itemView.setOnClickListener(new a(this, i11));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…(viewType, parent, false)");
        return new ViewHolder(inflate);
    }

    public final void setSelectedItem(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "selectedHeadline");
        Iterator<String> it = this.items.iterator();
        int i11 = 0;
        while (true) {
            if (!it.hasNext()) {
                i11 = -1;
                break;
            } else if (Intrinsics.areEqual((Object) it.next(), (Object) str)) {
                break;
            } else {
                i11++;
            }
        }
        setSelectedItem(i11);
    }
}
