package com.talabat.verticals.ui.customViewLCAware.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.talabat.core.network.imageDownloader.ImageDownloadHelper;
import com.talabat.core.network.imageDownloader.TransformType;
import com.talabat.verticals.R;
import com.talabat.verticals.ui.customViewLCAware.model.Vertical;
import com.talabat.wallet.bnplmanager.domain.tracking.event.BnplFakeTestSubmissionEventKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ox.a;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0010B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0006R\u001a\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u0011"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsItemSmallViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "mListener", "Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsItemSmallViewHolder$ItemCLickListener;", "getMListener", "()Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsItemSmallViewHolder$ItemCLickListener;", "setMListener", "(Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsItemSmallViewHolder$ItemCLickListener;)V", "bindItem", "", "vertical", "Lcom/talabat/verticals/ui/customViewLCAware/model/Vertical;", "listener", "ItemCLickListener", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsItemSmallViewHolder extends RecyclerView.ViewHolder {
    public ItemCLickListener mListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/adapter/VerticalsItemSmallViewHolder$ItemCLickListener;", "", "onItemCLicked", "", "deepLink", "", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface ItemCLickListener {
        void onItemCLicked(@Nullable String str);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VerticalsItemSmallViewHolder(@NotNull View view) {
        super(view);
        Intrinsics.checkNotNullParameter(view, "itemView");
    }

    /* access modifiers changed from: private */
    /* renamed from: bindItem$lambda-3  reason: not valid java name */
    public static final void m5940bindItem$lambda3(VerticalsItemSmallViewHolder verticalsItemSmallViewHolder, Vertical vertical, View view) {
        Intrinsics.checkNotNullParameter(verticalsItemSmallViewHolder, "this$0");
        Intrinsics.checkNotNullParameter(vertical, "$vertical");
        verticalsItemSmallViewHolder.getMListener().onItemCLicked(vertical.getDeeplink());
    }

    public final void bindItem(@NotNull Vertical vertical, @NotNull ItemCLickListener itemCLickListener) {
        Intrinsics.checkNotNullParameter(vertical, BnplFakeTestSubmissionEventKt.ATTRIBUTE_KEY_VERTICAL);
        Intrinsics.checkNotNullParameter(itemCLickListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        setMListener(itemCLickListener);
        String name2 = vertical.getName();
        if (name2 != null) {
            ((AppCompatTextView) this.itemView.findViewById(R.id.f12448name)).setText(name2);
        }
        String imageUrl = vertical.getImageUrl();
        if (imageUrl != null) {
            ImageDownloadHelper.Companion companion = ImageDownloadHelper.Companion;
            Context context = this.itemView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "itemView.context");
            ImageView imageView = (ImageView) this.itemView.findViewById(R.id.vertical_image);
            Intrinsics.checkNotNullExpressionValue(imageView, "itemView.vertical_image");
            companion.downloadImageSpecificTransform(context, imageUrl, imageView, 200, 200, TransformType.FIT_CENTER);
        }
        if (vertical.getColorCode() != null) {
            try {
                ((ImageView) this.itemView.findViewById(R.id.vertical_image)).setBackgroundColor(Color.parseColor(vertical.getColorCode()));
            } catch (Exception | IllegalArgumentException unused) {
            }
        }
        this.itemView.setOnClickListener(new a(this, vertical));
    }

    @NotNull
    public final ItemCLickListener getMListener() {
        ItemCLickListener itemCLickListener = this.mListener;
        if (itemCLickListener != null) {
            return itemCLickListener;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mListener");
        return null;
    }

    public final void setMListener(@NotNull ItemCLickListener itemCLickListener) {
        Intrinsics.checkNotNullParameter(itemCLickListener, "<set-?>");
        this.mListener = itemCLickListener;
    }
}
