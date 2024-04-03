package com.talabat.feature.pickup.presentation.adapters;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.ColorRes;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.talabat.feature.pickup.presentation.R;
import com.talabat.feature.pickup.presentation.entity.SwimlaneView;
import com.talabat.talabatcommon.extension.ViewKt;
import com.talabat.talabatcommon.utils.ImageViewExtensionsKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import sn.a;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001b2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u001b\u001cB'\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u001a\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\n\u001a\u00020\u000bH\u0002J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000bH\u0002J\b\u0010\u0013\u001a\u00020\u000bH\u0016J\u0018\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000bH\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/SwimlanesAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/talabat/feature/pickup/presentation/adapters/SwimlanesAdapter$ViewHolder;", "items", "", "Lcom/talabat/feature/pickup/presentation/entity/SwimlaneView;", "onVendorClick", "Lkotlin/Function1;", "", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;)V", "color", "", "context", "Landroid/content/Context;", "distance", "", "pickupDistanceKm", "formatRatingCount", "count", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "ViewHolder", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlanesAdapter extends RecyclerView.Adapter<ViewHolder> {
    private static final int COUNT_LIMIT = 100;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int METERS_IN_KM = 1000;
    @NotNull
    private static final String MORE_THAN_HUNDRED = "(100+)";
    @NotNull
    private final List<SwimlaneView> items;
    @NotNull
    private final Function1<SwimlaneView, Unit> onVendorClick;

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/SwimlanesAdapter$Companion;", "", "()V", "COUNT_LIMIT", "", "METERS_IN_KM", "MORE_THAN_HUNDRED", "", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\bR\u0011\u0010\u000f\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\fR\u0011\u0010\u0011\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\bR\u0011\u0010\u0013\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/pickup/presentation/adapters/SwimlanesAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Landroid/view/View;)V", "distanceTv", "Landroid/widget/TextView;", "getDistanceTv", "()Landroid/widget/TextView;", "hintIv", "Landroid/widget/ImageView;", "getHintIv", "()Landroid/widget/ImageView;", "hintTv", "getHintTv", "logoIv", "getLogoIv", "ratingCountTv", "getRatingCountTv", "restaurantNameTv", "getRestaurantNameTv", "com_talabat_feature_pickup_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        @NotNull
        private final TextView distanceTv;
        @NotNull
        private final ImageView hintIv;
        @NotNull
        private final TextView hintTv;
        @NotNull
        private final ImageView logoIv;
        @NotNull
        private final TextView ratingCountTv;
        @NotNull
        private final TextView restaurantNameTv;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "view");
            View findViewById = view.findViewById(R.id.restaurantNameTv);
            Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.restaurantNameTv)");
            this.restaurantNameTv = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.distanceTv);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.distanceTv)");
            this.distanceTv = (TextView) findViewById2;
            View findViewById3 = view.findViewById(R.id.hintTv);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.hintTv)");
            this.hintTv = (TextView) findViewById3;
            View findViewById4 = view.findViewById(R.id.ratingCountTv);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.ratingCountTv)");
            this.ratingCountTv = (TextView) findViewById4;
            View findViewById5 = view.findViewById(R.id.hintIv);
            Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.hintIv)");
            this.hintIv = (ImageView) findViewById5;
            View findViewById6 = view.findViewById(R.id.logoIv);
            Intrinsics.checkNotNullExpressionValue(findViewById6, "view.findViewById(R.id.logoIv)");
            this.logoIv = (ImageView) findViewById6;
        }

        @NotNull
        public final TextView getDistanceTv() {
            return this.distanceTv;
        }

        @NotNull
        public final ImageView getHintIv() {
            return this.hintIv;
        }

        @NotNull
        public final TextView getHintTv() {
            return this.hintTv;
        }

        @NotNull
        public final ImageView getLogoIv() {
            return this.logoIv;
        }

        @NotNull
        public final TextView getRatingCountTv() {
            return this.ratingCountTv;
        }

        @NotNull
        public final TextView getRestaurantNameTv() {
            return this.restaurantNameTv;
        }
    }

    public SwimlanesAdapter(@NotNull List<SwimlaneView> list, @NotNull Function1<? super SwimlaneView, Unit> function1) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        Intrinsics.checkNotNullParameter(function1, "onVendorClick");
        this.items = list;
        this.onVendorClick = function1;
    }

    private final int color(Context context, @ColorRes int i11) {
        return ContextCompat.getColor(context, i11);
    }

    private final String distance(Context context, String str) {
        double d11;
        boolean z11;
        Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(str);
        if (doubleOrNull != null) {
            d11 = doubleOrNull.doubleValue();
        } else {
            d11 = 0.0d;
        }
        if (d11 < 1.0d) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            String string = context.getString(com.talabat.localization.R.string.pickup_distance_m, new Object[]{String.valueOf((int) (d11 * ((double) 1000)))});
            Intrinsics.checkNotNullExpressionValue(string, "{\n            val meters…ers.toString())\n        }");
            return string;
        }
        String string2 = context.getString(com.talabat.localization.R.string.pickup_distance_km, new Object[]{String.valueOf(d11)});
        Intrinsics.checkNotNullExpressionValue(string2, "{\n            context.ge…ers.toString())\n        }");
        return string2;
    }

    private final String formatRatingCount(int i11) {
        if (i11 > 100) {
            return "(100+)";
        }
        return "(" + i11 + ")";
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m10257onBindViewHolder$lambda0(SwimlanesAdapter swimlanesAdapter, SwimlaneView swimlaneView, View view) {
        Intrinsics.checkNotNullParameter(swimlanesAdapter, "this$0");
        Intrinsics.checkNotNullParameter(swimlaneView, "$item");
        swimlanesAdapter.onVendorClick.invoke(swimlaneView);
    }

    public int getItemCount() {
        return this.items.size();
    }

    public void onBindViewHolder(@NotNull ViewHolder viewHolder, int i11) {
        Intrinsics.checkNotNullParameter(viewHolder, "holder");
        SwimlaneView swimlaneView = this.items.get(i11);
        Context context = viewHolder.itemView.getContext();
        viewHolder.getRestaurantNameTv().setText(swimlaneView.getRestaurantName());
        TextView distanceTv = viewHolder.getDistanceTv();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        distanceTv.setText(distance(context, swimlaneView.getDistance()));
        TextView ratingCountTv = viewHolder.getRatingCountTv();
        Integer intOrNull = StringsKt__StringNumberConversionsKt.toIntOrNull(swimlaneView.getRatingCount());
        ratingCountTv.setText(formatRatingCount(intOrNull != null ? intOrNull.intValue() : 0));
        ImageViewExtensionsKt.loadImageUrl$default(viewHolder.getLogoIv(), swimlaneView.getImageUrl(), (Function0) null, 2, (Object) null);
        viewHolder.itemView.setOnClickListener(new a(this, swimlaneView));
        Double doubleOrNull = StringsKt__StringNumberConversionsJVMKt.toDoubleOrNull(swimlaneView.getHint());
        if (doubleOrNull == null || Intrinsics.areEqual(doubleOrNull, 0.0d)) {
            viewHolder.getHintTv().setText(com.talabat.localization.R.string.not_rated);
            TextView hintTv = viewHolder.getHintTv();
            int i12 = com.designsystem.marshmallow.R.color.ds_neutral_35;
            hintTv.setTextColor(color(context, i12));
            viewHolder.getHintIv().setImageTintList(ColorStateList.valueOf(color(context, i12)));
            viewHolder.getRatingCountTv().setVisibility(8);
            return;
        }
        viewHolder.getHintTv().setText(swimlaneView.getHint());
        viewHolder.getHintTv().setTextColor(color(context, com.designsystem.marshmallow.R.color.ds_neutral_100));
        viewHolder.getHintIv().setImageTintList(ColorStateList.valueOf(color(context, com.designsystem.marshmallow.R.color.ds_alert_100)));
        viewHolder.getRatingCountTv().setVisibility(0);
    }

    @NotNull
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "parent");
        return new ViewHolder(ViewKt.inflate(viewGroup, R.layout.single_swimlane_view));
    }
}
