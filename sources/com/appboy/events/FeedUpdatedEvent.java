package com.appboy.events;

import com.appboy.enums.CardCategory;
import com.appboy.models.cards.Card;
import com.braze.support.BrazeLogger;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class FeedUpdatedEvent {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) FeedUpdatedEvent.class);
    private final List<Card> mFeedCards;
    private final boolean mFromOfflineStorage;
    private final long mTimestamp;
    private final String mUserId;

    public FeedUpdatedEvent(List<Card> list, String str, boolean z11, long j11) {
        this.mUserId = str;
        this.mFromOfflineStorage = z11;
        list.getClass();
        this.mFeedCards = list;
        this.mTimestamp = j11;
    }

    public int getCardCount() {
        return getCardCount(CardCategory.getAllCategories());
    }

    public List<Card> getFeedCards() {
        return getFeedCards(CardCategory.getAllCategories());
    }

    public int getUnreadCardCount() {
        return getUnreadCardCount(CardCategory.getAllCategories());
    }

    public String getUserId() {
        return this.mUserId;
    }

    public boolean isFromOfflineStorage() {
        return this.mFromOfflineStorage;
    }

    public long lastUpdatedInSecondsFromEpoch() {
        return this.mTimestamp;
    }

    public String toString() {
        return "FeedUpdatedEvent{" + "mFeedCards=" + this.mFeedCards + ", mUserId='" + this.mUserId + '\'' + ", mFromOfflineStorage=" + this.mFromOfflineStorage + ", mTimestamp=" + this.mTimestamp + AbstractJsonLexerKt.END_OBJ;
    }

    public int getCardCount(CardCategory cardCategory) {
        return getCardCount((EnumSet<CardCategory>) EnumSet.of(cardCategory));
    }

    public List<Card> getFeedCards(CardCategory cardCategory) {
        return getFeedCards((EnumSet<CardCategory>) EnumSet.of(cardCategory));
    }

    public int getUnreadCardCount(CardCategory cardCategory) {
        return getUnreadCardCount((EnumSet<CardCategory>) EnumSet.of(cardCategory));
    }

    public int getCardCount(EnumSet<CardCategory> enumSet) {
        if (enumSet == null) {
            BrazeLogger.i(TAG, "The categories passed into getCardCount are null, FeedUpdatedEvent is going to return the count of all the cards in cache.");
            return this.mFeedCards.size();
        } else if (!enumSet.isEmpty()) {
            return getFeedCards(enumSet).size();
        } else {
            BrazeLogger.w(TAG, "The parameters passed into categories are not valid, Braze is returning 0 in getCardCount().Please pass in a non-empty EnumSet of CardCategory.");
            return 0;
        }
    }

    public List<Card> getFeedCards(EnumSet<CardCategory> enumSet) {
        if (enumSet == null) {
            try {
                BrazeLogger.i(TAG, "The categories passed to getFeedCards are null, FeedUpdatedEvent is going to return all the cards in cache.");
                enumSet = CardCategory.getAllCategories();
            } catch (Exception e11) {
                String str = TAG;
                BrazeLogger.w(str, "Unable to get cards with categories[" + enumSet + "]. Ignoring.", e11);
                return null;
            }
        }
        if (enumSet.isEmpty()) {
            BrazeLogger.w(TAG, "The parameter passed into categories is not valid, Braze is returning an empty card list.Please pass in a non-empty EnumSet of CardCategory for getFeedCards().");
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        for (Card next : this.mFeedCards) {
            if (next.isInCategorySet(enumSet) && !next.isExpired()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    public int getUnreadCardCount(EnumSet<CardCategory> enumSet) {
        if (enumSet == null) {
            BrazeLogger.w(TAG, "The categories passed to getUnreadCardCount are null, FeedUpdatedEvent is going to return the count of all the unread cards in cache.");
            return getUnreadCardCount(CardCategory.getAllCategories());
        }
        int i11 = 0;
        if (enumSet.isEmpty()) {
            BrazeLogger.w(TAG, "The parameters passed into categories are Empty, Braze is returning 0 in getUnreadCardCount().Please pass in a non-empty EnumSet of CardCategory.");
            return 0;
        }
        for (Card next : this.mFeedCards) {
            if (next.isInCategorySet(enumSet) && !next.getViewed() && !next.isExpired()) {
                i11++;
            }
        }
        return i11;
    }
}
