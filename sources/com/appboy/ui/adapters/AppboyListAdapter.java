package com.appboy.ui.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import androidx.annotation.NonNull;
import com.appboy.models.cards.BannerImageCard;
import com.appboy.models.cards.CaptionedImageCard;
import com.appboy.models.cards.Card;
import com.appboy.models.cards.ShortNewsCard;
import com.appboy.models.cards.TextAnnouncementCard;
import com.appboy.ui.feed.view.BaseFeedCardView;
import com.appboy.ui.widget.BannerImageCardView;
import com.appboy.ui.widget.CaptionedImageCardView;
import com.appboy.ui.widget.DefaultCardView;
import com.appboy.ui.widget.ShortNewsCardView;
import com.appboy.ui.widget.TextAnnouncementCardView;
import com.braze.support.BrazeLogger;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AppboyListAdapter extends ArrayAdapter<Card> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) AppboyListAdapter.class);
    private final Set<String> mCardIdImpressions = new HashSet();
    private final Context mContext;

    public AppboyListAdapter(Context context, int i11, List<Card> list) {
        super(context, i11, list);
        this.mContext = context;
    }

    private void logCardImpression(Card card) {
        String id2 = card.getId();
        if (!this.mCardIdImpressions.contains(id2)) {
            this.mCardIdImpressions.add(id2);
            card.logImpression();
            String str = TAG;
            BrazeLogger.v(str, "Logged impression for card " + id2);
        } else {
            String str2 = TAG;
            BrazeLogger.v(str2, "Already counted impression for card " + id2);
        }
        if (!card.getViewed()) {
            card.setViewed(true);
        }
    }

    public void batchSetCardsToRead(int i11, int i12) {
        if (getCount() == 0) {
            BrazeLogger.d(TAG, "mAdapter is empty in setting some cards to viewed.");
            return;
        }
        int min = Math.min(getCount(), i12);
        for (int max = Math.max(0, i11); max < min; max++) {
            Card card = (Card) getItem(max);
            if (card == null) {
                BrazeLogger.d(TAG, "Card was null in setting some cards to viewed.");
                return;
            }
            if (!card.isIndicatorHighlighted()) {
                card.setIndicatorHighlighted(true);
            }
        }
    }

    public int getItemViewType(int i11) {
        Card card = (Card) getItem(i11);
        if (card instanceof BannerImageCard) {
            return 1;
        }
        if (card instanceof CaptionedImageCard) {
            return 2;
        }
        if (card instanceof ShortNewsCard) {
            return 3;
        }
        if (card instanceof TextAnnouncementCard) {
            return 4;
        }
        return 0;
    }

    @NonNull
    public View getView(int i11, View view, @NonNull ViewGroup viewGroup) {
        BaseFeedCardView baseFeedCardView;
        Card card = (Card) getItem(i11);
        if (view != null) {
            String str = TAG;
            BrazeLogger.v(str, "Reusing convertView for rendering of item " + i11);
            baseFeedCardView = (BaseFeedCardView) view;
        } else if (card instanceof BannerImageCard) {
            baseFeedCardView = new BannerImageCardView(this.mContext);
        } else if (card instanceof CaptionedImageCard) {
            baseFeedCardView = new CaptionedImageCardView(this.mContext);
        } else if (card instanceof ShortNewsCard) {
            baseFeedCardView = new ShortNewsCardView(this.mContext);
        } else if (card instanceof TextAnnouncementCard) {
            baseFeedCardView = new TextAnnouncementCardView(this.mContext);
        } else {
            baseFeedCardView = new DefaultCardView(this.mContext);
        }
        String str2 = TAG;
        BrazeLogger.v(str2, "Using view of type: " + baseFeedCardView.getClass().getName() + " for card at position " + i11 + ": " + card.toString());
        baseFeedCardView.setCard(card);
        logCardImpression(card);
        return baseFeedCardView;
    }

    public int getViewTypeCount() {
        return 5;
    }

    public synchronized void replaceFeed(List<Card> list) {
        Card card;
        int i11 = 0;
        setNotifyOnChange(false);
        if (list == null) {
            clear();
            notifyDataSetChanged();
            return;
        }
        String str = TAG;
        BrazeLogger.d(str, "Replacing existing feed of " + getCount() + " cards with new feed containing " + list.size() + " cards.");
        int size = list.size();
        int i12 = 0;
        while (i11 < getCount()) {
            Card card2 = (Card) getItem(i11);
            if (i12 < size) {
                card = list.get(i12);
            } else {
                card = null;
            }
            if (card == null || !card.equals(card2)) {
                remove(card2);
            } else {
                i11++;
                i12++;
            }
        }
        super.addAll(list.subList(i12, size));
        notifyDataSetChanged();
    }

    public void resetCardImpressionTracker() {
        this.mCardIdImpressions.clear();
    }

    public synchronized void add(Card card) {
        super.add(card);
    }
}
