package com.braze.ui.contentcards.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.appboy.models.cards.Card;
import com.appboy.ui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0016\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0002H\u0016J\u0010\u0010\u000b\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\rH\u0016¨\u0006\u000e"}, d2 = {"Lcom/braze/ui/contentcards/view/DefaultContentCardView;", "Lcom/braze/ui/contentcards/view/BaseContentCardView;", "Lcom/appboy/models/cards/Card;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindViewHolder", "", "viewHolder", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "card", "createViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class DefaultContentCardView extends BaseContentCardView<Card> {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DefaultContentCardView(@NotNull Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void bindViewHolder(@NotNull ContentCardViewHolder contentCardViewHolder, @NotNull Card card) {
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "viewHolder");
        Intrinsics.checkNotNullParameter(card, "card");
    }

    @NotNull
    public ContentCardViewHolder createViewHolder(@NotNull ViewGroup viewGroup) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.com_braze_default_content_card, viewGroup, false);
        Intrinsics.checkNotNullExpressionValue(inflate, "view");
        return new ContentCardViewHolder(inflate, false);
    }
}
