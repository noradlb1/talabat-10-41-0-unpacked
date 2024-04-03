package com.talabat.darkstores.feature.cart.partialFulfillment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.load.Transformation;
import com.talabat.darkstores.R;
import com.talabat.darkstores.common.bindingAdapters.BindingAdaptersKt;
import com.talabat.darkstores.common.bindingAdapters.ResizeStrategy;
import com.talabat.darkstores.data.partialFulfillment.model.Control;
import com.tekartik.sqflite.Constant;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import vi.a;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001$B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0018\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u000fH\u0016J\u0018\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u000fH\u0016J\u000e\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\u001fJ\u0010\u0010 \u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002J\u001c\u0010!\u001a\u00020\t2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010#\u001a\u00020\u001fR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "()V", "items", "", "Lcom/talabat/darkstores/data/partialFulfillment/model/Control;", "onItemClickListener", "Lkotlin/Function1;", "", "getOnItemClickListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemClickListener", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "", "selectedPos", "getSelectedPos", "()I", "getItemCount", "getItemViewType", "position", "getSelectedControl", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setInitialSelectedPosition", "code", "", "setSelectedItem", "submitList", "controls", "preselected", "PreferenceViewHolder", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class PartialFulfillmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    @NotNull
    private List<Control> items = CollectionsKt__CollectionsKt.emptyList();
    @Nullable
    private Function1<? super Control, Unit> onItemClickListener;
    private int selectedPos = -1;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/feature/cart/partialFulfillment/PartialFulfillmentAdapter$PreferenceViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "option_icon", "Landroid/widget/ImageView;", "radioButton_choice", "Landroid/widget/RadioButton;", "selection_control_body", "Landroid/widget/TextView;", "selection_control_title", "bind", "", "control", "Lcom/talabat/darkstores/data/partialFulfillment/model/Control;", "isSelected", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class PreferenceViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;
        @NotNull
        private final ImageView option_icon;
        @NotNull
        private final RadioButton radioButton_choice;
        @NotNull
        private final TextView selection_control_body;
        @NotNull
        private final TextView selection_control_title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public PreferenceViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.containerView = view;
            View findViewById = getContainerView().findViewById(R.id.option_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById, "containerView.findViewById(R.id.option_icon)");
            this.option_icon = (ImageView) findViewById;
            View findViewById2 = getContainerView().findViewById(R.id.radioButton_choice);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "containerView.findViewBy…(R.id.radioButton_choice)");
            this.radioButton_choice = (RadioButton) findViewById2;
            View findViewById3 = getContainerView().findViewById(R.id.selection_control_title);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "containerView.findViewBy….selection_control_title)");
            this.selection_control_title = (TextView) findViewById3;
            View findViewById4 = getContainerView().findViewById(R.id.selection_control_body);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "containerView.findViewBy…d.selection_control_body)");
            this.selection_control_body = (TextView) findViewById4;
        }

        public final void bind(@NotNull Control control, boolean z11) {
            Intrinsics.checkNotNullParameter(control, "control");
            this.selection_control_title.setText(control.getName());
            this.selection_control_body.setText(control.getDescription());
            BindingAdaptersKt.loadImageWithGlide$default(this.option_icon, control.getImageUrl(), Integer.valueOf(com.designsystem.marshmallow.R.drawable.ds_close), (ResizeStrategy) null, (Transformation) null, (Integer) null, 28, (Object) null);
            this.radioButton_choice.setChecked(z11);
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9846onBindViewHolder$lambda0(PartialFulfillmentAdapter partialFulfillmentAdapter, Control control, int i11, View view) {
        Intrinsics.checkNotNullParameter(partialFulfillmentAdapter, "this$0");
        Intrinsics.checkNotNullParameter(control, "$control");
        Function1<? super Control, Unit> function1 = partialFulfillmentAdapter.onItemClickListener;
        if (function1 != null) {
            function1.invoke(control);
        }
        partialFulfillmentAdapter.setSelectedItem(i11);
    }

    private final void setSelectedItem(int i11) {
        this.selectedPos = i11;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int i11) {
        if (i11 == 0) {
            return R.layout.darkstores_partial_fulfillment_option_top;
        }
        return R.layout.darkstores_partial_fulfillment_option;
    }

    @Nullable
    public final Function1<Control, Unit> getOnItemClickListener() {
        return this.onItemClickListener;
    }

    @Nullable
    public final Control getSelectedControl() {
        int i11 = this.selectedPos;
        if (i11 > -1) {
            return this.items.get(i11);
        }
        return null;
    }

    public final int getSelectedPos() {
        return this.selectedPos;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        boolean z11;
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        Control control = this.items.get(i11);
        PreferenceViewHolder preferenceViewHolder = (PreferenceViewHolder) viewHolder;
        if (i11 == this.selectedPos) {
            z11 = true;
        } else {
            z11 = false;
        }
        preferenceViewHolder.bind(control, z11);
        viewHolder.itemView.setOnClickListener(new a(this, control, i11));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "binding");
        return new PreferenceViewHolder(inflate);
    }

    public final void setInitialSelectedPosition(@NotNull String str) {
        boolean z11;
        Control control;
        Intrinsics.checkNotNullParameter(str, Constant.PARAM_ERROR_CODE);
        if (str.length() > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        Control control2 = null;
        if (z11) {
            Iterator it = this.items.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual((Object) ((Control) next).getCode(), (Object) str)) {
                    control2 = next;
                    break;
                }
            }
            control = control2;
        } else {
            Iterator it2 = this.items.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                if (((Control) next2).getValue()) {
                    control2 = next2;
                    break;
                }
            }
            control = control2;
        }
        if (control != null) {
            this.selectedPos = this.items.indexOf(control);
        }
    }

    public final void setOnItemClickListener(@Nullable Function1<? super Control, Unit> function1) {
        this.onItemClickListener = function1;
    }

    public final void submitList(@NotNull List<Control> list, @NotNull String str) {
        Intrinsics.checkNotNullParameter(list, "controls");
        Intrinsics.checkNotNullParameter(str, "preselected");
        this.items = list;
        setInitialSelectedPosition(str);
        notifyDataSetChanged();
    }
}
