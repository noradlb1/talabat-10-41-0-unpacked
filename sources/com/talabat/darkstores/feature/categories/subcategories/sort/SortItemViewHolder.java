package com.talabat.darkstores.feature.categories.subcategories.sort;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import bj.a;
import com.talabat.darkstores.R;
import com.talabat.darkstores.data.discovery.model.SortOption;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u001e\u0010\u000b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\u0006R\u001d\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0010"}, d2 = {"Lcom/talabat/darkstores/feature/categories/subcategories/sort/SortItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "onRadioButtonClicked", "Lkotlin/Function1;", "", "", "(Landroid/view/View;Lkotlin/jvm/functions/Function1;)V", "getOnRadioButtonClicked", "()Lkotlin/jvm/functions/Function1;", "bind", "sortOption", "Lcom/talabat/darkstores/data/discovery/model/SortOption;", "position", "selectedIndex", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SortItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final Function1<Integer, Unit> onRadioButtonClicked;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SortItemViewHolder(@NotNull View view, @NotNull Function1<? super Integer, Unit> function1) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(function1, "onRadioButtonClicked");
        this.onRadioButtonClicked = function1;
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m9931bind$lambda0(SortItemViewHolder sortItemViewHolder, int i11, View view) {
        Intrinsics.checkNotNullParameter(sortItemViewHolder, "this$0");
        sortItemViewHolder.onRadioButtonClicked.invoke(Integer.valueOf(i11));
    }

    public final void bind(@NotNull SortOption sortOption, int i11, int i12) {
        boolean z11;
        Intrinsics.checkNotNullParameter(sortOption, "sortOption");
        this.itemView.setOnClickListener(new a(this, i11));
        ((AppCompatTextView) this.itemView.findViewById(R.id.sort_item_text)).setText(sortOption.getDisplayName());
        if (i11 == i12) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            ((RadioButton) this.itemView.findViewById(R.id.sort_radio_button)).setChecked(true);
            ((FrameLayout) this.itemView.findViewById(R.id.selected_radio_indicator)).setVisibility(0);
            return;
        }
        ((FrameLayout) this.itemView.findViewById(R.id.selected_radio_indicator)).setVisibility(8);
        ((RadioButton) this.itemView.findViewById(R.id.sort_radio_button)).setChecked(false);
    }

    @NotNull
    public final Function1<Integer, Unit> getOnRadioButtonClicked() {
        return this.onRadioButtonClicked;
    }
}
