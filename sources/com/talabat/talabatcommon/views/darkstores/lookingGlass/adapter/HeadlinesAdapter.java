package com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter;

import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.chip.Chip;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GHeadline;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import mv.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001+B\u0017\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u000e\u0010\u001d\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\rJ\b\u0010\u001e\u001a\u00020\u0019H\u0016J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0018\u0010!\u001a\u00020\u00132\u0006\u0010\"\u001a\u00020\u00022\u0006\u0010 \u001a\u00020\u0019H\u0016J\u0018\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0019H\u0016J\u000e\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020\rJ\u000e\u0010'\u001a\u00020\u00132\u0006\u0010)\u001a\u00020\u0019J\u0014\u0010*\u001a\u00020\u00132\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fR\u001a\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0007\"\u0004\b\n\u0010\tR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u000e¢\u0006\u0002\n\u0000R7\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0013\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001e\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0018\u001a\u00020\u0019@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u0006,"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/HeadlinesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/HeadlinesAdapter$ViewHolder;", "isNewDesign", "", "isGrayBg", "(ZZ)V", "()Z", "setGrayBg", "(Z)V", "setNewDesign", "items", "", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GHeadline;", "onItemSelectedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "headline", "", "getOnItemSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "", "selectedPos", "getSelectedPos", "()I", "getHeadlinePosition", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectedItem", "item", "itemPosition", "submitList", "ViewHolder", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeadlinesAdapter extends RecyclerView.Adapter<ViewHolder> {
    private boolean isGrayBg;
    private boolean isNewDesign;
    @NotNull
    private List<GHeadline> items;
    @Nullable
    private Function1<? super GHeadline, Unit> onItemSelectedListener;
    private int selectedPos;

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0015\n\u0002\b\u0011\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u001d\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0016\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0006J\b\u0010-\u001a\u00020)H\u0002R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u000b\"\u0004\b\u000e\u0010\rR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014R\u001a\u0010\u0018\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014R\u001a\u0010\u001b\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0012\"\u0004\b\u001d\u0010\u0014R\u001a\u0010\u001e\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0012\"\u0004\b \u0010\u0014R\"\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00100\"X\u000e¢\u0006\u0010\n\u0002\u0010'\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&¨\u0006."}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/HeadlinesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "containerView", "Landroid/view/View;", "isNewDesign", "", "isGrayBg", "(Landroid/view/View;ZZ)V", "getContainerView", "()Landroid/view/View;", "()Z", "setGrayBg", "(Z)V", "setNewDesign", "newDesignBg", "", "getNewDesignBg", "()[I", "setNewDesignBg", "([I)V", "newDesignText", "getNewDesignText", "setNewDesignText", "oldDesignBg", "getOldDesignBg", "setOldDesignBg", "oldDesignStroke", "getOldDesignStroke", "setOldDesignStroke", "oldDesignText", "getOldDesignText", "setOldDesignText", "states", "", "getStates", "()[[I", "setStates", "([[I)V", "[[I", "bind", "", "item", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GHeadline;", "isSelected", "setChipColor", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;
        private boolean isGrayBg;
        private boolean isNewDesign;
        @NotNull
        private int[] newDesignBg;
        @NotNull
        private int[] newDesignText;
        @NotNull
        private int[] oldDesignBg;
        @NotNull
        private int[] oldDesignStroke;
        @NotNull
        private int[] oldDesignText;
        @NotNull
        private int[][] states = {new int[]{-16842912}, new int[]{16842912}};

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view, boolean z11, boolean z12) {
            super(view);
            int i11;
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.containerView = view;
            this.isNewDesign = z11;
            this.isGrayBg = z12;
            int[] iArr = new int[2];
            if (z12) {
                i11 = R.color.white;
            } else {
                i11 = com.designsystem.marshmallow.R.color.ds_neutral_4;
            }
            iArr[0] = HeadlinesAdapterKt.getColor(i11);
            int i12 = com.designsystem.marshmallow.R.color.ds_primary_100;
            iArr[1] = HeadlinesAdapterKt.getColor(i12);
            this.newDesignBg = iArr;
            int i13 = R.color.black;
            int i14 = R.color.white;
            this.newDesignText = new int[]{HeadlinesAdapterKt.getColor(i13), HeadlinesAdapterKt.getColor(i14)};
            this.oldDesignText = new int[]{HeadlinesAdapterKt.getColor(i13), HeadlinesAdapterKt.getColor(i12)};
            this.oldDesignBg = new int[]{HeadlinesAdapterKt.getColor(i14), HeadlinesAdapterKt.getColor(com.designsystem.marshmallow.R.color.ds_primary_4)};
            this.oldDesignStroke = new int[]{HeadlinesAdapterKt.getColor(com.designsystem.marshmallow.R.color.ds_neutral_4), HeadlinesAdapterKt.getColor(i12)};
        }

        private final void setChipColor() {
            if (this.isNewDesign) {
                View view = this.itemView;
                int i11 = R.id.glass_headline;
                ((Chip) view.findViewById(i11)).setChipBackgroundColor(new ColorStateList(this.states, this.newDesignBg));
                ((Chip) this.itemView.findViewById(i11)).setChipStrokeColor(new ColorStateList(this.states, this.newDesignBg));
                ((Chip) this.itemView.findViewById(i11)).setTextColor(new ColorStateList(this.states, this.newDesignText));
                return;
            }
            View view2 = this.itemView;
            int i12 = R.id.glass_headline;
            ((Chip) view2.findViewById(i12)).setChipBackgroundColor(new ColorStateList(this.states, this.oldDesignBg));
            ((Chip) this.itemView.findViewById(i12)).setChipStrokeColor(new ColorStateList(this.states, this.oldDesignStroke));
            ((Chip) this.itemView.findViewById(i12)).setTextColor(new ColorStateList(this.states, this.oldDesignText));
        }

        public final void bind(@NotNull GHeadline gHeadline, boolean z11) {
            Intrinsics.checkNotNullParameter(gHeadline, "item");
            View view = this.itemView;
            int i11 = R.id.glass_headline;
            ((Chip) view.findViewById(i11)).setChecked(z11);
            ((Chip) this.itemView.findViewById(i11)).setText(gHeadline.getHeadline());
            setChipColor();
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }

        @NotNull
        public final int[] getNewDesignBg() {
            return this.newDesignBg;
        }

        @NotNull
        public final int[] getNewDesignText() {
            return this.newDesignText;
        }

        @NotNull
        public final int[] getOldDesignBg() {
            return this.oldDesignBg;
        }

        @NotNull
        public final int[] getOldDesignStroke() {
            return this.oldDesignStroke;
        }

        @NotNull
        public final int[] getOldDesignText() {
            return this.oldDesignText;
        }

        @NotNull
        public final int[][] getStates() {
            return this.states;
        }

        public final boolean isGrayBg() {
            return this.isGrayBg;
        }

        public final boolean isNewDesign() {
            return this.isNewDesign;
        }

        public final void setGrayBg(boolean z11) {
            this.isGrayBg = z11;
        }

        public final void setNewDesign(boolean z11) {
            this.isNewDesign = z11;
        }

        public final void setNewDesignBg(@NotNull int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.newDesignBg = iArr;
        }

        public final void setNewDesignText(@NotNull int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.newDesignText = iArr;
        }

        public final void setOldDesignBg(@NotNull int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.oldDesignBg = iArr;
        }

        public final void setOldDesignStroke(@NotNull int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.oldDesignStroke = iArr;
        }

        public final void setOldDesignText(@NotNull int[] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.oldDesignText = iArr;
        }

        public final void setStates(@NotNull int[][] iArr) {
            Intrinsics.checkNotNullParameter(iArr, "<set-?>");
            this.states = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeadlinesAdapter(boolean z11, boolean z12, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11, z12);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m5766onBindViewHolder$lambda0(HeadlinesAdapter headlinesAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(headlinesAdapter, "this$0");
        headlinesAdapter.setSelectedItem(i11);
        Function1<? super GHeadline, Unit> function1 = headlinesAdapter.onItemSelectedListener;
        if (function1 != null) {
            function1.invoke(headlinesAdapter.items.get(i11));
        }
    }

    public final int getHeadlinePosition(@NotNull GHeadline gHeadline) {
        Intrinsics.checkNotNullParameter(gHeadline, "headline");
        return this.items.indexOf(gHeadline);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int i11) {
        return R.layout.item_looking_glass_headline;
    }

    @Nullable
    public final Function1<GHeadline, Unit> getOnItemSelectedListener() {
        return this.onItemSelectedListener;
    }

    public final int getSelectedPos() {
        return this.selectedPos;
    }

    public final boolean isGrayBg() {
        return this.isGrayBg;
    }

    public final boolean isNewDesign() {
        return this.isNewDesign;
    }

    public final void setGrayBg(boolean z11) {
        this.isGrayBg = z11;
    }

    public final void setNewDesign(boolean z11) {
        this.isNewDesign = z11;
    }

    public final void setOnItemSelectedListener(@Nullable Function1<? super GHeadline, Unit> function1) {
        this.onItemSelectedListener = function1;
    }

    public final void setSelectedItem(int i11) {
        int i12 = this.selectedPos;
        Unit unit = Unit.INSTANCE;
        notifyItemChanged(i12, unit);
        this.selectedPos = i11;
        notifyItemChanged(i11, unit);
    }

    public final void submitList(@NotNull List<GHeadline> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.items = list;
        notifyDataSetChanged();
    }

    public HeadlinesAdapter(boolean z11, boolean z12) {
        this.isNewDesign = z11;
        this.isGrayBg = z12;
        this.selectedPos = -1;
        this.items = CollectionsKt__CollectionsKt.emptyList();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        viewHolder.bind(this.items.get(i11), this.selectedPos == i11);
        viewHolder.itemView.setOnClickListener(new b(this, i11));
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…(viewType, parent, false)");
        return new ViewHolder(inflate, this.isNewDesign, this.isGrayBg);
    }

    public final void setSelectedItem(@NotNull GHeadline gHeadline) {
        Intrinsics.checkNotNullParameter(gHeadline, "item");
        setSelectedItem(this.items.indexOf(gHeadline));
    }
}
