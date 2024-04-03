package com.braze.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.appboy.models.cards.Card;
import com.appboy.models.cards.TextAnnouncementCard;
import com.appboy.ui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u000fB\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u0010"}, d2 = {"Lcom/braze/ui/contentcards/view/TextAnnouncementContentCardView;", "Lcom/braze/ui/contentcards/view/BaseContentCardView;", "Lcom/appboy/models/cards/TextAnnouncementCard;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindViewHolder", "", "viewHolder", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "card", "Lcom/appboy/models/cards/Card;", "createViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "ViewHolder", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class TextAnnouncementContentCardView extends BaseContentCardView<TextAnnouncementCard> {

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u000b"}, d2 = {"Lcom/braze/ui/contentcards/view/TextAnnouncementContentCardView$ViewHolder;", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "view", "Landroid/view/View;", "(Lcom/braze/ui/contentcards/view/TextAnnouncementContentCardView;Landroid/view/View;)V", "description", "Landroid/widget/TextView;", "getDescription", "()Landroid/widget/TextView;", "title", "getTitle", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class ViewHolder extends ContentCardViewHolder {
        @Nullable
        private final TextView description;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ TextAnnouncementContentCardView f44075h;
        @Nullable
        private final TextView title;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(@NotNull TextAnnouncementContentCardView textAnnouncementContentCardView, View view) {
            super(view, textAnnouncementContentCardView.isUnreadIndicatorEnabled());
            Intrinsics.checkNotNullParameter(textAnnouncementContentCardView, "this$0");
            Intrinsics.checkNotNullParameter(view, "view");
            this.f44075h = textAnnouncementContentCardView;
            this.title = (TextView) view.findViewById(R.id.com_braze_content_cards_text_announcement_card_title);
            this.description = (TextView) view.findViewById(R.id.com_braze_content_cards_text_announcement_card_description);
        }

        @Nullable
        public final TextView getDescription() {
            return this.description;
        }

        @Nullable
        public final TextView getTitle() {
            return this.title;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TextAnnouncementContentCardView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void bindViewHolder(@NotNull ContentCardViewHolder contentCardViewHolder, @NotNull Card card) {
        boolean z11;
        String str;
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(card, "card");
        if (card instanceof TextAnnouncementCard) {
            super.bindViewHolder(contentCardViewHolder, card);
            ViewHolder viewHolder = (ViewHolder) contentCardViewHolder;
            TextView title = viewHolder.getTitle();
            if (title != null) {
                setOptionalTextView(title, ((TextAnnouncementCard) card).getTitle());
            }
            TextView description = viewHolder.getDescription();
            if (description != null) {
                setOptionalTextView(description, ((TextAnnouncementCard) card).getDescription());
            }
            TextAnnouncementCard textAnnouncementCard = (TextAnnouncementCard) card;
            String domain = textAnnouncementCard.getDomain();
            if (domain == null || StringsKt__StringsJVMKt.isBlank(domain)) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                str = card.getUrl();
            } else {
                str = textAnnouncementCard.getDomain();
            }
            if (str != null) {
                viewHolder.setActionHintText(str);
            }
            View view = contentCardViewHolder.itemView;
            view.setContentDescription(textAnnouncementCard.getTitle() + " . " + textAnnouncementCard.getDescription());
        }
    }

    @NotNull
    public ContentCardViewHolder createViewHolder(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.com_braze_text_announcement_content_card, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        setViewBackground(inflate);
        return new ViewHolder(this, inflate);
    }
}
