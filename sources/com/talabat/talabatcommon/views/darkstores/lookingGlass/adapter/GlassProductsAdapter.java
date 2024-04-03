package com.talabat.talabatcommon.views.darkstores.lookingGlass.adapter;

import android.app.Application;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.core.network.imageDownloader.TransformType;
import com.talabat.lib.Integration;
import com.talabat.talabatcommon.R;
import com.talabat.talabatcommon.extentions.ImageViewForTalabatKt;
import com.talabat.talabatcommon.extentions.IntKt;
import com.talabat.talabatcommon.views.darkstores.lookingGlass.model.GDisplayItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.extensions.LayoutContainer;
import mv.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003&'(B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u0016H\u0016J\u0010\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0018\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u0016H\u0016J\u0018\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0016H\u0016J\u000e\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u0016J\u0014\u0010%\u001a\u00020\u00102\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tR\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u0010\u0006\"\u0004\b\u0007\u0010\u0005R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u000e¢\u0006\u0002\n\u0000R7\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u00110\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001e\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u0016@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/GlassProductsAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "isNewDesign", "", "(Z)V", "()Z", "setNewDesign", "items", "", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "onItemSelectedListener", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "item", "", "getOnItemSelectedListener", "()Lkotlin/jvm/functions/Function1;", "setOnItemSelectedListener", "(Lkotlin/jvm/functions/Function1;)V", "<set-?>", "", "selectedPos", "getSelectedPos", "()I", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "setSelectedItem", "itemPosition", "submitList", "LookingGlassBaseViewHolder", "NewDesignViewHolderLookingGlass", "ViewHolderLookingGlass", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GlassProductsAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private boolean isNewDesign;
    @NotNull
    private List<GDisplayItem> items;
    @Nullable
    private Function1<? super GDisplayItem, Unit> onItemSelectedListener;
    private int selectedPos;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0004R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/GlassProductsAdapter$LookingGlassBaseViewHolder;", "Lkotlinx/android/extensions/LayoutContainer;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "containerView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "item", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "view", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static class LookingGlassBaseViewHolder extends RecyclerView.ViewHolder implements LayoutContainer {
        @NotNull
        private final View containerView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LookingGlassBaseViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.containerView = view;
        }

        public final void bind(@NotNull GDisplayItem gDisplayItem, @NotNull View view) {
            Intrinsics.checkNotNullParameter(gDisplayItem, "item");
            Intrinsics.checkNotNullParameter(view, "view");
            ((AppCompatTextView) view.findViewById(R.id.tvTitle)).setText(gDisplayItem.getName());
            Double price = gDisplayItem.getPrice();
            if (price != null) {
                price.doubleValue();
                ((TextView) view.findViewById(R.id.tvPrice)).setText(gDisplayItem.getPriceDisplayText());
            }
            String imageUrl = gDisplayItem.getImageUrl();
            if (imageUrl != null) {
                ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
                Application appContext = Integration.getAppContext();
                ImageView imageView = (ImageView) view.findViewById(R.id.image);
                Intrinsics.checkNotNullExpressionValue(imageView, "view.image");
                ImageDownloadHelper.Companion.downloadImageSpecificTransform$default(companion, appContext, imageUrl, imageView, 0, 0, TransformType.CENTER_INSIDE, 24, (Object) null);
            }
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/GlassProductsAdapter$NewDesignViewHolderLookingGlass;", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/GlassProductsAdapter$LookingGlassBaseViewHolder;", "containerView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "item", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class NewDesignViewHolderLookingGlass extends LookingGlassBaseViewHolder {
        @NotNull
        private final View containerView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public NewDesignViewHolderLookingGlass(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.containerView = view;
        }

        public final void bind(@NotNull GDisplayItem gDisplayItem) {
            boolean z11;
            Intrinsics.checkNotNullParameter(gDisplayItem, "item");
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            bind(gDisplayItem, view);
            String discountText = gDisplayItem.getDiscountText();
            if (discountText == null || discountText.length() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 || IntKt.isZero(gDisplayItem.getDiscount())) {
                ((LinearLayout) this.itemView.findViewById(R.id.layout_discount)).setVisibility(4);
                ((TextView) this.itemView.findViewById(R.id.textview_original_price)).setVisibility(8);
                return;
            }
            ((LinearLayout) this.itemView.findViewById(R.id.layout_discount)).setVisibility(0);
            View view2 = this.itemView;
            int i11 = R.id.textview_original_price;
            ((TextView) view2.findViewById(i11)).setVisibility(0);
            ((TextView) this.itemView.findViewById(R.id.textview_discount_percentage)).setText(gDisplayItem.getDiscountText());
            ((TextView) this.itemView.findViewById(i11)).setText(gDisplayItem.getOriginalPriceDisplayText());
            ((TextView) this.itemView.findViewById(i11)).setPaintFlags(16);
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000b"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/GlassProductsAdapter$ViewHolderLookingGlass;", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/adapter/GlassProductsAdapter$LookingGlassBaseViewHolder;", "containerView", "Landroid/view/View;", "(Landroid/view/View;)V", "getContainerView", "()Landroid/view/View;", "bind", "", "item", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolderLookingGlass extends LookingGlassBaseViewHolder {
        @NotNull
        private final View containerView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolderLookingGlass(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "containerView");
            this.containerView = view;
        }

        public final void bind(@NotNull GDisplayItem gDisplayItem) {
            Intrinsics.checkNotNullParameter(gDisplayItem, "item");
            View view = this.itemView;
            Intrinsics.checkNotNullExpressionValue(view, "itemView");
            bind(gDisplayItem, view);
            String imageUrl = gDisplayItem.getImageUrl();
            if (imageUrl != null) {
                ImageView imageView = (ImageView) this.itemView.findViewById(R.id.image);
                Intrinsics.checkNotNullExpressionValue(imageView, "itemView.image");
                ImageViewForTalabatKt.setImageResizeUrl$default(imageView, imageUrl, 0, 0, false, 14, (Object) null);
            }
        }

        @NotNull
        public View getContainerView() {
            return this.containerView;
        }
    }

    public GlassProductsAdapter() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GlassProductsAdapter(boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? false : z11);
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m5765onBindViewHolder$lambda0(GlassProductsAdapter glassProductsAdapter, int i11, View view) {
        Intrinsics.checkNotNullParameter(glassProductsAdapter, "this$0");
        glassProductsAdapter.setSelectedItem(i11);
        Function1<? super GDisplayItem, Unit> function1 = glassProductsAdapter.onItemSelectedListener;
        if (function1 != null) {
            function1.invoke(glassProductsAdapter.items.get(i11));
        }
    }

    public int getItemCount() {
        return this.items.size();
    }

    public int getItemViewType(int i11) {
        return this.isNewDesign ? R.layout.item_looking_glass_product_new_design : R.layout.item_looking_glass_product;
    }

    @Nullable
    public final Function1<GDisplayItem, Unit> getOnItemSelectedListener() {
        return this.onItemSelectedListener;
    }

    public final int getSelectedPos() {
        return this.selectedPos;
    }

    public final boolean isNewDesign() {
        return this.isNewDesign;
    }

    public void onBindViewHolder(@NotNull RecyclerView.ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        if (viewHolder instanceof NewDesignViewHolderLookingGlass) {
            ((NewDesignViewHolderLookingGlass) viewHolder).bind(this.items.get(i11));
        } else if (viewHolder instanceof ViewHolderLookingGlass) {
            ((ViewHolderLookingGlass) viewHolder).bind(this.items.get(i11));
        }
        viewHolder.itemView.setOnClickListener(new a(this, i11));
    }

    @NotNull
    public RecyclerView.ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        if (this.isNewDesign) {
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(parent.context).inf…(viewType, parent, false)");
            return new NewDesignViewHolderLookingGlass(inflate);
        }
        View inflate2 = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate2, "from(parent.context).inf…(viewType, parent, false)");
        return new ViewHolderLookingGlass(inflate2);
    }

    public final void setNewDesign(boolean z11) {
        this.isNewDesign = z11;
    }

    public final void setOnItemSelectedListener(@Nullable Function1<? super GDisplayItem, Unit> function1) {
        this.onItemSelectedListener = function1;
    }

    public final void setSelectedItem(int i11) {
        int i12 = this.selectedPos;
        Unit unit = Unit.INSTANCE;
        notifyItemChanged(i12, unit);
        this.selectedPos = i11;
        notifyItemChanged(i11, unit);
    }

    public final void submitList(@NotNull List<GDisplayItem> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        this.items = list;
        notifyDataSetChanged();
    }

    public GlassProductsAdapter(boolean z11) {
        this.isNewDesign = z11;
        this.selectedPos = -1;
        this.items = CollectionsKt__CollectionsKt.emptyList();
    }
}
