package com.appboy.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.TextView;
import com.appboy.models.cards.TextAnnouncementCard;
import com.appboy.ui.R;
import com.appboy.ui.feed.view.BaseFeedCardView;
import com.braze.support.BrazeLogger;
import com.braze.ui.actions.IAction;
import l3.d;

public class TextAnnouncementCardView extends BaseFeedCardView<TextAnnouncementCard> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) TextAnnouncementCardView.class);
    private IAction mCardAction;
    private final TextView mDescription;
    private final TextView mDomain;
    private final TextView mTitle;

    public TextAnnouncementCardView(Context context) {
        this(context, (TextAnnouncementCard) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onSetCard$0(TextAnnouncementCard textAnnouncementCard, View view) {
        handleCardClick(this.applicationContext, textAnnouncementCard, this.mCardAction);
    }

    public int getLayoutResource() {
        return R.layout.com_appboy_text_announcement_card;
    }

    public TextAnnouncementCardView(Context context, TextAnnouncementCard textAnnouncementCard) {
        super(context);
        this.mTitle = (TextView) findViewById(R.id.com_appboy_text_announcement_card_title);
        this.mDescription = (TextView) findViewById(R.id.com_appboy_text_announcement_card_description);
        this.mDomain = (TextView) findViewById(R.id.com_appboy_text_announcement_card_domain);
        if (textAnnouncementCard != null) {
            setCard(textAnnouncementCard);
        }
        setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
    }

    public void onSetCard(TextAnnouncementCard textAnnouncementCard) {
        this.mTitle.setText(textAnnouncementCard.getTitle());
        this.mDescription.setText(textAnnouncementCard.getDescription());
        setOptionalTextView(this.mDomain, textAnnouncementCard.getDomain());
        this.mCardAction = BaseCardView.getUriActionForCard(textAnnouncementCard);
        setOnClickListener(new d(this, textAnnouncementCard));
    }
}
