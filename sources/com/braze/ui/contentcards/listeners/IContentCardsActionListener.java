package com.braze.ui.contentcards.listeners;

import android.content.Context;
import com.appboy.models.cards.Card;
import com.braze.ui.actions.IAction;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\fÀ\u0006\u0001"}, d2 = {"Lcom/braze/ui/contentcards/listeners/IContentCardsActionListener;", "", "onContentCardClicked", "", "context", "Landroid/content/Context;", "card", "Lcom/appboy/models/cards/Card;", "cardAction", "Lcom/braze/ui/actions/IAction;", "onContentCardDismissed", "", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public interface IContentCardsActionListener {
    boolean onContentCardClicked(@NotNull Context context, @NotNull Card card, @Nullable IAction iAction);

    void onContentCardDismissed(@NotNull Context context, @NotNull Card card);
}
