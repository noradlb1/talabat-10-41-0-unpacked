package com.appboy.ui.widget;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.appboy.models.cards.ShortNewsCard;
import com.appboy.ui.R;
import com.appboy.ui.feed.view.BaseFeedCardView;
import com.braze.support.BrazeLogger;
import com.braze.ui.actions.IAction;
import l3.c;

public class ShortNewsCardView extends BaseFeedCardView<ShortNewsCard> {
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) ShortNewsCardView.class);
    private final float mAspectRatio;
    private IAction mCardAction;
    private final TextView mDescription;
    private final TextView mDomain;
    private final ImageView mImage;
    private final TextView mTitle;

    public ShortNewsCardView(Context context) {
        this(context, (ShortNewsCard) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onSetCard$0(ShortNewsCard shortNewsCard, View view) {
        handleCardClick(this.applicationContext, shortNewsCard, this.mCardAction);
    }

    public int getLayoutResource() {
        return R.layout.com_appboy_short_news_card;
    }

    public ShortNewsCardView(Context context, ShortNewsCard shortNewsCard) {
        super(context);
        this.mAspectRatio = 1.0f;
        this.mDescription = (TextView) findViewById(R.id.com_appboy_short_news_card_description);
        this.mTitle = (TextView) findViewById(R.id.com_appboy_short_news_card_title);
        this.mDomain = (TextView) findViewById(R.id.com_appboy_short_news_card_domain);
        ImageView imageView = (ImageView) getProperViewFromInflatedStub(R.id.com_appboy_short_news_card_imageview_stub);
        this.mImage = imageView;
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setAdjustViewBounds(true);
        if (shortNewsCard != null) {
            setCard(shortNewsCard);
        }
        setBackground(getResources().getDrawable(R.drawable.com_appboy_card_background));
    }

    public void onSetCard(ShortNewsCard shortNewsCard) {
        this.mDescription.setText(shortNewsCard.getDescription());
        setOptionalTextView(this.mTitle, shortNewsCard.getTitle());
        setOptionalTextView(this.mDomain, shortNewsCard.getDomain());
        this.mCardAction = BaseCardView.getUriActionForCard(shortNewsCard);
        setOnClickListener(new c(this, shortNewsCard));
        setImageViewToUrl(this.mImage, shortNewsCard.getImageUrl(), 1.0f, shortNewsCard);
    }
}
