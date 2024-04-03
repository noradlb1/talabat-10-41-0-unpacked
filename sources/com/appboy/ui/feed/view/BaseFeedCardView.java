package com.appboy.ui.feed.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageView;
import com.appboy.models.cards.Card;
import com.appboy.ui.R;
import com.appboy.ui.feed.AppboyFeedManager;
import com.appboy.ui.feed.AppboyImageSwitcher;
import com.appboy.ui.widget.BaseCardView;
import com.braze.support.BrazeLogger;
import com.braze.ui.actions.IAction;
import k3.a;
import k3.b;

public abstract class BaseFeedCardView<T extends Card> extends BaseCardView<T> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) BaseCardView.class);

    public BaseFeedCardView(Context context) {
        super(context);
        AppboyImageSwitcher appboyImageSwitcher;
        ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(getLayoutResource(), this);
        AppboyImageSwitcher appboyImageSwitcher2 = (AppboyImageSwitcher) findViewById(R.id.com_appboy_newsfeed_item_read_indicator_image_switcher);
        this.imageSwitcher = appboyImageSwitcher2;
        if (appboyImageSwitcher2 != null) {
            appboyImageSwitcher2.setFactory(new b(this));
        }
        if (!isUnreadIndicatorEnabled() && (appboyImageSwitcher = this.imageSwitcher) != null) {
            appboyImageSwitcher.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ View lambda$new$0() {
        return new ImageView(this.applicationContext);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$setCard$1() {
        setCardViewedIndicator(this.imageSwitcher, getCard());
    }

    public Card getCard() {
        return this.card;
    }

    public abstract int getLayoutResource();

    public View getProperViewFromInflatedStub(int i11) {
        ((ViewStub) findViewById(i11)).inflate();
        return findViewById(R.id.com_appboy_stubbed_feed_image_view);
    }

    public boolean isClickHandled(Context context, Card card, IAction iAction) {
        return AppboyFeedManager.getInstance().getFeedCardClickActionListener().onFeedCardClicked(context, card, iAction);
    }

    public abstract void onSetCard(T t11);

    public void setCard(T t11) {
        this.card = t11;
        onSetCard(t11);
        this.card.setListener(new a(this));
        setCardViewedIndicator(this.imageSwitcher, getCard());
    }
}
