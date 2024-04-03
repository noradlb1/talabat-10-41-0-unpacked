package com.braze.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.appboy.models.cards.BannerImageCard;
import com.appboy.models.cards.Card;
import com.appboy.ui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/braze/ui/contentcards/view/BannerImageContentCardView;", "Lcom/braze/ui/contentcards/view/BaseContentCardView;", "Lcom/appboy/models/cards/BannerImageCard;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindViewHolder", "", "viewHolder", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "card", "Lcom/appboy/models/cards/Card;", "createViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "ViewHolder", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class BannerImageContentCardView extends BaseContentCardView<BannerImageCard> {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/braze/ui/contentcards/view/BannerImageContentCardView$ViewHolder;", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "view", "Landroid/view/View;", "(Lcom/braze/ui/contentcards/view/BannerImageContentCardView;Landroid/view/View;)V", "imageView", "Landroid/widget/ImageView;", "getImageView", "()Landroid/widget/ImageView;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends ContentCardViewHolder {

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ BannerImageContentCardView f44072h;
        @Nullable
        private final ImageView imageView;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull BannerImageContentCardView bannerImageContentCardView, View view) {
            super(view, bannerImageContentCardView.isUnreadIndicatorEnabled());
            Intrinsics.checkNotNullParameter(bannerImageContentCardView, "this$0");
            Intrinsics.checkNotNullParameter(view, "view");
            this.f44072h = bannerImageContentCardView;
            this.imageView = (ImageView) view.findViewById(R.id.com_braze_content_cards_banner_image_card_image);
        }

        @Nullable
        public final ImageView getImageView() {
            return this.imageView;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BannerImageContentCardView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void bindViewHolder(@NotNull ContentCardViewHolder contentCardViewHolder, @NotNull Card card) {
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(card, "card");
        if (card instanceof BannerImageCard) {
            super.bindViewHolder(contentCardViewHolder, card);
            BannerImageCard bannerImageCard = (BannerImageCard) card;
            setOptionalCardImage(((ViewHolder) contentCardViewHolder).getImageView(), bannerImageCard.getAspectRatio(), bannerImageCard.getImageUrl(), card);
        }
    }

    @NotNull
    public ContentCardViewHolder createViewHolder(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.com_braze_banner_image_content_card, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        setViewBackground(inflate);
        return new ViewHolder(this, inflate);
    }
}
