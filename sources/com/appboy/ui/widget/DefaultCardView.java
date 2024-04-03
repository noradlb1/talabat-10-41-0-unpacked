package com.appboy.ui.widget;

import android.content.Context;
import com.appboy.models.cards.Card;
import com.appboy.ui.R;
import com.appboy.ui.feed.view.BaseFeedCardView;
import com.braze.support.BrazeLogger;

public class DefaultCardView extends BaseFeedCardView<Card> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) DefaultCardView.class);

    public DefaultCardView(Context context) {
        this(context, (Card) null);
    }

    public int getLayoutResource() {
        return R.layout.com_appboy_default_card;
    }

    public void onSetCard(Card card) {
        String str = TAG;
        BrazeLogger.w(str, "onSetCard called for blank view with: " + card.toString());
    }

    public DefaultCardView(Context context, Card card) {
        super(context);
        if (card != null) {
            setCard(card);
        }
    }
}
