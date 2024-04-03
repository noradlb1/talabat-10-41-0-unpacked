package com.braze.ui.contentcards.listeners;

import android.content.Context;
import com.appboy.models.cards.Card;
import com.braze.ui.actions.IAction;
import kotlin.Metadata;
import x3.a;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/braze/ui/contentcards/listeners/DefaultContentCardsActionListener;", "Lcom/braze/ui/contentcards/listeners/IContentCardsActionListener;", "()V", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DefaultContentCardsActionListener implements IContentCardsActionListener {
    public /* synthetic */ boolean onContentCardClicked(Context context, Card card, IAction iAction) {
        return a.a(this, context, card, iAction);
    }

    public /* synthetic */ void onContentCardDismissed(Context context, Card card) {
        a.b(this, context, card);
    }
}
