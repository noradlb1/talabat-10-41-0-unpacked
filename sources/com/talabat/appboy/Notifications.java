package com.talabat.appboy;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.appboy.enums.CardCategory;
import com.appboy.models.cards.BannerImageCard;
import com.appboy.models.cards.CaptionedImageCard;
import com.appboy.models.cards.Card;
import com.appboy.models.cards.ShortNewsCard;
import com.appboy.models.cards.TextAnnouncementCard;
import com.talabat.R;
import com.talabat.appboy.FeedCategoriesFragment;
import com.talabat.helpers.GlobalConstants;
import com.talabat.helpers.GlobalDataModel;
import com.talabat.helpers.TalabatBase;
import com.talabat.helpers.TalabatUtils;
import com.talabat.home.HomeScreenActivity;
import java.util.EnumSet;
import library.talabat.mvp.IGlobalPresenter;
import tracking.ScreenNames;

public class Notifications extends TalabatBase implements FeedCategoriesFragment.NoticeDialogListener {
    public static final String SOURCE_KEY = "source";
    private boolean isFromDeeplink = false;
    private EnumSet<CardCategory> mAppboyFeedCategories;
    private NotificationFragment mAppboyFeedFragment;
    private Toolbar mToolbar;
    private boolean shouldDisableSideMenu = false;

    public static String convertBundleToAppboyLogString(Bundle bundle) {
        if (bundle == null) {
            return "Received intent with null extras Bundle from Appboy.";
        }
        String str = "Received intent with extras Bundle of size " + bundle.size() + " from Appboy containing [";
        for (String next : bundle.keySet()) {
            str = str + " '" + next + "':'" + bundle.get(next) + "'";
        }
        return str + " ].";
    }

    /* access modifiers changed from: private */
    public String createQueryString(String str) {
        try {
            String[] split = str.split("\\?");
            if (split.length > 0) {
                return split[1];
            }
        } catch (Exception unused) {
        }
        return null;
    }

    private void processIntent() {
        Bundle extras = getIntent().getExtras();
        if (extras != null && "Appboy".equals(extras.getString("source"))) {
            Toast.makeText(this, convertBundleToAppboyLogString(extras), 1).show();
        }
        setIntent(new Intent());
    }

    public void destroyPresenter() {
    }

    public IGlobalPresenter getPresenter() {
        return null;
    }

    public String getScreenName() {
        return ScreenNames.NOTIFICATIONS;
    }

    public void onAuthError() {
    }

    public void onBackPressed() {
        super.onBackPressed();
        if (!this.shouldDisableSideMenu) {
            effectiveNavigation();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.notifications);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.mToolbar = toolbar;
        setSupportActionBar(toolbar);
        setToolbarPadding(this.mToolbar);
        setTitle("DroidBoy");
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        NotificationFragment notificationFragment = new NotificationFragment();
        this.mAppboyFeedFragment = notificationFragment;
        notificationFragment.setCategories(CardCategory.getAllCategories());
        this.isFromDeeplink = getIntent().getBooleanExtra(GlobalConstants.ExtraNames.ISFROMDEEPLINK, false);
        this.shouldDisableSideMenu = shouldDisableSideMenu();
        GlobalDataModel.APPBOYNOTIFICATION.isNotificationAvail = true;
        this.mAppboyFeedFragment.setNewsFeedClickListener(new NewsFeedClickListener() {
            public void onNewsFeedClick(Card card, int i11) {
                if (card != null) {
                    card.logClick();
                }
                Notifications.this.disableBrandMenu(true);
                if (card instanceof ShortNewsCard) {
                    String url = ((ShortNewsCard) card).getUrl();
                    if (!TalabatUtils.isNullOrEmpty(url)) {
                        Notifications.this.getDeepLinkPresenter().deepLinkRecived(Notifications.this.createQueryString(url));
                        Notifications.this.startLodingPopup();
                        Notifications.this.getDeepLinkPresenter().redirectToDeepLink();
                    }
                } else if (card instanceof BannerImageCard) {
                    String url2 = ((BannerImageCard) card).getUrl();
                    if (!TalabatUtils.isNullOrEmpty(url2)) {
                        Notifications.this.getDeepLinkPresenter().deepLinkRecived(Notifications.this.createQueryString(url2));
                        Notifications.this.startLodingPopup();
                        Notifications.this.getDeepLinkPresenter().redirectToDeepLink();
                    }
                } else if (card instanceof CaptionedImageCard) {
                    String url3 = ((CaptionedImageCard) card).getUrl();
                    if (!TalabatUtils.isNullOrEmpty(url3)) {
                        Notifications.this.getDeepLinkPresenter().deepLinkRecived(Notifications.this.createQueryString(url3));
                        Notifications.this.startLodingPopup();
                        Notifications.this.getDeepLinkPresenter().redirectToDeepLink();
                    }
                } else if (card instanceof TextAnnouncementCard) {
                    String url4 = ((TextAnnouncementCard) card).getUrl();
                    if (!TalabatUtils.isNullOrEmpty(url4)) {
                        Notifications.this.getDeepLinkPresenter().deepLinkRecived(Notifications.this.createQueryString(url4));
                        Notifications.this.startLodingPopup();
                        Notifications.this.getDeepLinkPresenter().redirectToDeepLink();
                    }
                }
            }
        });
        GlobalConstants.isSideMenuInitialSelection = false;
        FragmentTransaction beginTransaction = supportFragmentManager.beginTransaction();
        beginTransaction.add((int) R.id.root, (Fragment) this.mAppboyFeedFragment);
        beginTransaction.commit();
        handleToolBarButton();
    }

    public void onDialogPositiveClick(FeedCategoriesFragment feedCategoriesFragment) {
        if (this.mAppboyFeedFragment == null) {
            this.mAppboyFeedFragment = new NotificationFragment();
        }
        EnumSet<CardCategory> copyOf = EnumSet.copyOf(feedCategoriesFragment.selectedCategories);
        this.mAppboyFeedCategories = copyOf;
        this.mAppboyFeedFragment.setCategories(copyOf);
    }

    public void onError() {
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (this.isFromDeeplink) {
            startActivity(new Intent(this, HomeScreenActivity.class));
            finish();
        }
        return super.onKeyDown(i11, keyEvent);
    }

    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    public void onResume() {
        super.onResume();
        processIntent();
    }
}
