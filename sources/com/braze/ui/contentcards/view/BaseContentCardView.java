package com.braze.ui.contentcards.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.appboy.models.cards.Card;
import com.appboy.ui.R;
import com.appboy.ui.widget.BaseCardView;
import com.braze.ui.actions.IAction;
import com.braze.ui.actions.UriAction;
import com.braze.ui.contentcards.listeners.IContentCardsActionListener;
import com.braze.ui.contentcards.managers.BrazeContentCardsManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import y3.a;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\b\u0012\u0004\u0012\u00028\u00000\u0003B\u000f\u0012\u0006\u0010\u0014\u001a\u00020\u0013¢\u0006\u0004\b\u001d\u0010\u001eJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H&J\u0018\u0010\u000b\u001a\u00020\n2\u0006\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0001H\u0016J*\u0010\u0012\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\f2\u0006\u0010\u000f\u001a\u00020\u000e2\b\u0010\u0011\u001a\u0004\u0018\u00010\u00102\u0006\u0010\t\u001a\u00020\u0001J\"\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\t\u001a\u00020\u00012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\u0012\u0010\u0019\u001a\u00020\n2\b\u0010\r\u001a\u0004\u0018\u00010\fH\u0005J\u0010\u0010\u001c\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001aH\u0004¨\u0006\u001f"}, d2 = {"Lcom/braze/ui/contentcards/view/BaseContentCardView;", "Lcom/appboy/models/cards/Card;", "T", "Lcom/appboy/ui/widget/BaseCardView;", "Landroid/view/ViewGroup;", "viewGroup", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "createViewHolder", "viewHolder", "card", "", "bindViewHolder", "Landroid/widget/ImageView;", "imageView", "", "cardAspectRatio", "", "cardImageUrl", "setOptionalCardImage", "Landroid/content/Context;", "context", "Lcom/braze/ui/actions/IAction;", "cardAction", "", "isClickHandled", "b", "Landroid/view/View;", "view", "setViewBackground", "<init>", "(Landroid/content/Context;)V", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0})
public abstract class BaseContentCardView<T extends Card> extends BaseCardView<T> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseContentCardView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* access modifiers changed from: private */
    /* renamed from: bindViewHolder$lambda-0  reason: not valid java name */
    public static final void m9205bindViewHolder$lambda0(BaseContentCardView baseContentCardView, Card card, UriAction uriAction, View view) {
        Intrinsics.checkNotNullParameter(baseContentCardView, "this$0");
        Intrinsics.checkNotNullParameter(card, "$card");
        baseContentCardView.handleCardClick(baseContentCardView.applicationContext, card, uriAction);
    }

    @TargetApi(21)
    public final void b(@Nullable ImageView imageView) {
        if (imageView != null) {
            imageView.setClipToOutline(true);
        }
    }

    public void bindViewHolder(@NotNull ContentCardViewHolder contentCardViewHolder, @NotNull Card card) {
        boolean z11;
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(card, "card");
        contentCardViewHolder.setPinnedIconVisible(card.isPinned());
        boolean z12 = true;
        if (!this.configurationProvider.isContentCardsUnreadVisualIndicatorEnabled() || card.isIndicatorHighlighted()) {
            z11 = false;
        } else {
            z11 = true;
        }
        contentCardViewHolder.setUnreadBarVisible(z11);
        UriAction uriActionForCard = BaseCardView.getUriActionForCard(card);
        contentCardViewHolder.itemView.setOnClickListener(new a(this, card, uriActionForCard));
        if (uriActionForCard == null) {
            z12 = false;
        }
        contentCardViewHolder.setActionHintVisible(z12);
    }

    @NotNull
    public abstract ContentCardViewHolder createViewHolder(@NotNull ViewGroup viewGroup);

    public boolean isClickHandled(@NotNull Context context, @NotNull Card card, @Nullable IAction iAction) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(card, "card");
        IContentCardsActionListener contentCardsActionListener = BrazeContentCardsManager.Companion.getInstance().getContentCardsActionListener();
        if (contentCardsActionListener != null && contentCardsActionListener.onContentCardClicked(context, card, iAction)) {
            return true;
        }
        return false;
    }

    public final void setOptionalCardImage(@Nullable ImageView imageView, float f11, @Nullable String str, @NotNull Card card) {
        Intrinsics.checkNotNullParameter(card, "card");
        if (imageView != null && str != null) {
            setImageViewToUrl(imageView, str, f11, card);
        }
    }

    public final void setViewBackground(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        view.setBackground(getResources().getDrawable(R.drawable.com_braze_content_card_background));
        view.setForeground(getResources().getDrawable(R.drawable.com_braze_content_card_scrim));
    }
}
