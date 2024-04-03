package com.talabat.feature.tpro.presentation.benefits.adapter.onboarding;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.RequestListener;
import com.talabat.feature.tpro.presentation.R;
import com.talabat.feature.tpro.presentation.databinding.ItemContentHeaderBinding;
import com.talabat.feature.tpro.presentation.util.TproImageResources;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import qo.a;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u001e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/talabat/feature/tpro/presentation/benefits/adapter/onboarding/HeaderItemViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "binding", "Lcom/talabat/feature/tpro/presentation/databinding/ItemContentHeaderBinding;", "preloaderCallback", "Lcom/bumptech/glide/request/RequestListener;", "Landroid/graphics/drawable/Drawable;", "onBackClick", "Lkotlin/Function1;", "Landroid/view/View;", "", "(Lcom/talabat/feature/tpro/presentation/databinding/ItemContentHeaderBinding;Lcom/bumptech/glide/request/RequestListener;Lkotlin/jvm/functions/Function1;)V", "applyBrandUpdates", "imageName", "", "bind", "header", "description", "com_talabat_feature_tpro_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeaderItemViewHolder extends RecyclerView.ViewHolder {
    @NotNull
    private final ItemContentHeaderBinding binding;
    @NotNull
    private final Function1<View, Unit> onBackClick;
    @NotNull
    private final RequestListener<Drawable> preloaderCallback;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderItemViewHolder(@NotNull ItemContentHeaderBinding itemContentHeaderBinding, @NotNull RequestListener<Drawable> requestListener, @NotNull Function1<? super View, Unit> function1) {
        super(itemContentHeaderBinding.getRoot());
        Intrinsics.checkNotNullParameter(itemContentHeaderBinding, "binding");
        Intrinsics.checkNotNullParameter(requestListener, "preloaderCallback");
        Intrinsics.checkNotNullParameter(function1, "onBackClick");
        this.binding = itemContentHeaderBinding;
        this.preloaderCallback = requestListener;
        this.onBackClick = function1;
    }

    private final void applyBrandUpdates(String str) {
        ItemContentHeaderBinding itemContentHeaderBinding = this.binding;
        TproImageResources tproImageResources = new TproImageResources(false, (String) null, false, 7, (DefaultConstructorMarker) null);
        Resources resources = itemContentHeaderBinding.getRoot().getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "root.resources");
        ((RequestBuilder) Glide.with((View) itemContentHeaderBinding.ivPoster).load(Uri.parse(tproImageResources.getBenefitsHeaderImage(resources, str))).listener(this.preloaderCallback).fitCenter()).into(itemContentHeaderBinding.ivPoster);
        ConstraintLayout.LayoutParams layoutParams = new ConstraintLayout.LayoutParams((int) this.itemView.getResources().getDimension(R.dimen.tpro_header_width), -2);
        layoutParams.setMargins(0, 0, 0, 0);
        layoutParams.bottomToBottom = 0;
        layoutParams.endToEnd = 0;
        itemContentHeaderBinding.ivPoster.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: bind$lambda-0  reason: not valid java name */
    public static final void m10361bind$lambda0(Function1 function1, View view) {
        Intrinsics.checkNotNullParameter(function1, "$tmp0");
        function1.invoke(view);
    }

    public final void bind(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "header");
        Intrinsics.checkNotNullParameter(str2, "description");
        Intrinsics.checkNotNullParameter(str3, "imageName");
        this.binding.tvOnBoardingSubheader.setText(str2);
        this.binding.tvOnBoardingHeader.setText(str);
        this.binding.ivClose.setOnClickListener(new a(this.onBackClick));
        applyBrandUpdates(str3);
    }
}
