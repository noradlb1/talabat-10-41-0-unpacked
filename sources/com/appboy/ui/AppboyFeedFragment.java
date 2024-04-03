package com.appboy.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.annotation.VisibleForTesting;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appboy.enums.CardCategory;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.models.cards.Card;
import com.appboy.ui.adapters.AppboyListAdapter;
import com.braze.Braze;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import j3.a;
import j3.b;
import j3.c;
import j3.d;
import j3.e;
import j3.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

@Instrumented
public class AppboyFeedFragment extends ListFragment implements SwipeRefreshLayout.OnRefreshListener, TraceFieldInterface {
    private static final long AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS = 2500;
    private static final int MAX_FEED_TTL_SECONDS = 60;
    private static final int NETWORK_PROBLEM_WARNING_MS = 5000;
    @VisibleForTesting
    static final String SAVED_INSTANCE_STATE_KEY_CARD_CATEGORY = "CARD_CATEGORY";
    @VisibleForTesting
    static final String SAVED_INSTANCE_STATE_KEY_CURRENT_CARD_INDEX_AT_BOTTOM_OF_SCREEN = "CURRENT_CARD_INDEX_AT_BOTTOM_OF_SCREEN";
    @VisibleForTesting
    static final String SAVED_INSTANCE_STATE_KEY_PREVIOUS_VISIBLE_HEAD_CARD_INDEX = "PREVIOUS_VISIBLE_HEAD_CARD_INDEX";
    @VisibleForTesting
    static final String SAVED_INSTANCE_STATE_KEY_SKIP_CARD_IMPRESSIONS_RESET = "SKIP_CARD_IMPRESSIONS_RESET";
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) AppboyFeedFragment.class);
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public AppboyListAdapter mAdapter;
    private EnumSet<CardCategory> mCategories;
    @VisibleForTesting
    int mCurrentCardIndexAtBottomOfScreen = 0;
    private LinearLayout mEmptyFeedLayout;
    private RelativeLayout mFeedRootLayout;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout mFeedSwipeLayout;
    private IEventSubscriber<FeedUpdatedEvent> mFeedUpdatedSubscriber;
    private GestureDetectorCompat mGestureDetector;
    /* access modifiers changed from: private */
    public ProgressBar mLoadingSpinner;
    private final Handler mMainThreadLooper = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public LinearLayout mNetworkErrorLayout;
    @VisibleForTesting
    int mPreviousVisibleHeadCardIndex = 0;
    private final Runnable mShowNetworkError = new Runnable() {
        public void run() {
            if (AppboyFeedFragment.this.mLoadingSpinner != null) {
                AppboyFeedFragment.this.mLoadingSpinner.setVisibility(8);
            }
            if (AppboyFeedFragment.this.mNetworkErrorLayout != null) {
                AppboyFeedFragment.this.mNetworkErrorLayout.setVisibility(0);
            }
        }
    };
    @VisibleForTesting
    boolean mSkipCardImpressionsReset = false;
    private boolean mSortEnabled = false;
    private View mTransparentFullBoundsContainerView;

    public class FeedGestureListener extends GestureDetector.SimpleOnGestureListener {
        public FeedGestureListener() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            long eventTime = (motionEvent2.getEventTime() - motionEvent.getEventTime()) * 2;
            AppboyFeedFragment.this.getListView().smoothScrollBy(-((int) ((f12 * ((float) eventTime)) / 1000.0f)), (int) (eventTime * 2));
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            AppboyFeedFragment.this.getListView().smoothScrollBy((int) f12, 0);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onRefresh$5() {
        this.mFeedSwipeLayout.setRefreshing(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onViewCreated$0(View view, MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$onViewCreated$1(View view, MotionEvent motionEvent) {
        return view.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$2(FeedUpdatedEvent feedUpdatedEvent, ListView listView) {
        String str = TAG;
        BrazeLogger.v(str, "Updating feed views in response to FeedUpdatedEvent: " + feedUpdatedEvent);
        this.mMainThreadLooper.removeCallbacks(this.mShowNetworkError);
        this.mNetworkErrorLayout.setVisibility(8);
        if (feedUpdatedEvent.getCardCount(this.mCategories) == 0) {
            listView.setVisibility(8);
            this.mAdapter.clear();
        } else {
            this.mEmptyFeedLayout.setVisibility(8);
            this.mLoadingSpinner.setVisibility(8);
            this.mTransparentFullBoundsContainerView.setVisibility(8);
        }
        if (feedUpdatedEvent.isFromOfflineStorage() && (feedUpdatedEvent.lastUpdatedInSecondsFromEpoch() + 60) * 1000 < System.currentTimeMillis()) {
            BrazeLogger.i(str, "Feed received was older than the max time to live of 60 seconds, displaying it for now, but requesting an updated view from the server.");
            Braze.getInstance(getContext()).requestFeedRefresh();
            if (feedUpdatedEvent.getCardCount(this.mCategories) == 0) {
                BrazeLogger.d(str, "Old feed was empty, putting up a network spinner and registering the network error message with a delay of 5000ms.");
                this.mEmptyFeedLayout.setVisibility(8);
                this.mLoadingSpinner.setVisibility(0);
                this.mTransparentFullBoundsContainerView.setVisibility(0);
                this.mMainThreadLooper.postDelayed(this.mShowNetworkError, 5000);
                return;
            }
        }
        if (feedUpdatedEvent.getCardCount(this.mCategories) == 0) {
            this.mLoadingSpinner.setVisibility(8);
            this.mEmptyFeedLayout.setVisibility(0);
            this.mTransparentFullBoundsContainerView.setVisibility(0);
        } else {
            if (!this.mSortEnabled || feedUpdatedEvent.getCardCount(this.mCategories) == feedUpdatedEvent.getUnreadCardCount(this.mCategories)) {
                this.mAdapter.replaceFeed(feedUpdatedEvent.getFeedCards(this.mCategories));
            } else {
                this.mAdapter.replaceFeed(sortFeedCards(feedUpdatedEvent.getFeedCards(this.mCategories)));
            }
            listView.setVisibility(0);
        }
        this.mFeedSwipeLayout.setRefreshing(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onViewCreated$3(ListView listView, FeedUpdatedEvent feedUpdatedEvent) {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new a(this, feedUpdatedEvent, listView));
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$sortFeedCards$4(Card card, Card card2) {
        if (card.isIndicatorHighlighted() == card2.isIndicatorHighlighted()) {
            return 0;
        }
        return card.isIndicatorHighlighted() ? 1 : -1;
    }

    private void setOnScreenCardsToRead() {
        this.mAdapter.batchSetCardsToRead(this.mPreviousVisibleHeadCardIndex, this.mCurrentCardIndexAtBottomOfScreen);
    }

    public EnumSet<CardCategory> getCategories() {
        return this.mCategories;
    }

    public boolean getSortEnabled() {
        return this.mSortEnabled;
    }

    @VisibleForTesting
    public void loadFragmentStateFromSavedInstanceState(Bundle bundle) {
        if (bundle != null) {
            if (this.mCategories == null) {
                this.mCategories = CardCategory.getAllCategories();
            }
            this.mPreviousVisibleHeadCardIndex = bundle.getInt(SAVED_INSTANCE_STATE_KEY_PREVIOUS_VISIBLE_HEAD_CARD_INDEX, 0);
            this.mCurrentCardIndexAtBottomOfScreen = bundle.getInt(SAVED_INSTANCE_STATE_KEY_CURRENT_CARD_INDEX_AT_BOTTOM_OF_SCREEN, 0);
            this.mSkipCardImpressionsReset = bundle.getBoolean(SAVED_INSTANCE_STATE_KEY_SKIP_CARD_IMPRESSIONS_RESET, false);
            ArrayList<String> stringArrayList = bundle.getStringArrayList(SAVED_INSTANCE_STATE_KEY_CARD_CATEGORY);
            if (stringArrayList != null) {
                this.mCategories.clear();
                Iterator<String> it = stringArrayList.iterator();
                while (it.hasNext()) {
                    this.mCategories.add(CardCategory.valueOf(it.next()));
                }
            }
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.mAdapter == null) {
            this.mAdapter = new AppboyListAdapter(context, R.id.tag, new ArrayList());
            this.mCategories = CardCategory.getAllCategories();
        }
        this.mGestureDetector = new GestureDetectorCompat(context, new FeedGestureListener());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "AppboyFeedFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "AppboyFeedFragment#onCreateView", (ArrayList<String>) null);
        }
        View inflate = layoutInflater.inflate(R.layout.com_appboy_feed, viewGroup, false);
        this.mNetworkErrorLayout = (LinearLayout) inflate.findViewById(R.id.com_appboy_feed_network_error);
        this.mLoadingSpinner = (ProgressBar) inflate.findViewById(R.id.com_appboy_feed_loading_spinner);
        this.mEmptyFeedLayout = (LinearLayout) inflate.findViewById(R.id.com_appboy_feed_empty_feed);
        this.mFeedRootLayout = (RelativeLayout) inflate.findViewById(R.id.com_appboy_feed_root);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.appboy_feed_swipe_container);
        this.mFeedSwipeLayout = swipeRefreshLayout;
        swipeRefreshLayout.setOnRefreshListener(this);
        this.mFeedSwipeLayout.setEnabled(false);
        this.mFeedSwipeLayout.setColorSchemeResources(R.color.com_appboy_newsfeed_swipe_refresh_color_1, R.color.com_appboy_newsfeed_swipe_refresh_color_2, R.color.com_appboy_newsfeed_swipe_refresh_color_3, R.color.com_appboy_newsfeed_swipe_refresh_color_4);
        this.mTransparentFullBoundsContainerView = inflate.findViewById(R.id.com_appboy_feed_transparent_full_bounds_container_view);
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onDestroyView() {
        super.onDestroyView();
        Braze.getInstance(getContext()).removeSingleSubscription(this.mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
        setOnScreenCardsToRead();
    }

    public void onDetach() {
        super.onDetach();
        setListAdapter((ListAdapter) null);
    }

    public void onPause() {
        super.onPause();
        setOnScreenCardsToRead();
    }

    public void onRefresh() {
        Braze.getInstance(getContext()).requestFeedRefresh();
        this.mMainThreadLooper.postDelayed(new f(this), AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS);
    }

    public void onResume() {
        super.onResume();
        Braze.getInstance(getContext()).logFeedDisplayed();
    }

    public void onSaveInstanceState(Bundle bundle) {
        bundle.putInt(SAVED_INSTANCE_STATE_KEY_PREVIOUS_VISIBLE_HEAD_CARD_INDEX, this.mPreviousVisibleHeadCardIndex);
        bundle.putInt(SAVED_INSTANCE_STATE_KEY_CURRENT_CARD_INDEX_AT_BOTTOM_OF_SCREEN, this.mCurrentCardIndexAtBottomOfScreen);
        bundle.putBoolean(SAVED_INSTANCE_STATE_KEY_SKIP_CARD_IMPRESSIONS_RESET, this.mSkipCardImpressionsReset);
        if (this.mCategories == null) {
            this.mCategories = CardCategory.getAllCategories();
        }
        ArrayList arrayList = new ArrayList(this.mCategories.size());
        Iterator<CardCategory> it = this.mCategories.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().name());
        }
        bundle.putStringArrayList(SAVED_INSTANCE_STATE_KEY_CARD_CATEGORY, arrayList);
        super.onSaveInstanceState(bundle);
        if (isVisible()) {
            this.mSkipCardImpressionsReset = true;
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    @SuppressLint({"InflateParams"})
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        loadFragmentStateFromSavedInstanceState(bundle);
        if (this.mSkipCardImpressionsReset) {
            this.mSkipCardImpressionsReset = false;
        } else {
            this.mAdapter.resetCardImpressionTracker();
            BrazeLogger.d(TAG, "Resetting card impressions.");
        }
        LayoutInflater from = LayoutInflater.from(getActivity());
        ListView listView = getListView();
        listView.addHeaderView(from.inflate(R.layout.com_appboy_feed_header, (ViewGroup) null));
        listView.addFooterView(from.inflate(R.layout.com_appboy_feed_footer, (ViewGroup) null));
        this.mFeedRootLayout.setOnTouchListener(new b(this));
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
                boolean z11;
                SwipeRefreshLayout access$200 = AppboyFeedFragment.this.mFeedSwipeLayout;
                if (i11 == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                access$200.setEnabled(z11);
                if (i12 != 0) {
                    int i14 = i11 - 1;
                    AppboyFeedFragment appboyFeedFragment = AppboyFeedFragment.this;
                    if (i14 > appboyFeedFragment.mPreviousVisibleHeadCardIndex) {
                        appboyFeedFragment.mAdapter.batchSetCardsToRead(AppboyFeedFragment.this.mPreviousVisibleHeadCardIndex, i14);
                    }
                    AppboyFeedFragment appboyFeedFragment2 = AppboyFeedFragment.this;
                    appboyFeedFragment2.mPreviousVisibleHeadCardIndex = i14;
                    appboyFeedFragment2.mCurrentCardIndexAtBottomOfScreen = i11 + i12;
                }
            }

            public void onScrollStateChanged(AbsListView absListView, int i11) {
            }
        });
        this.mTransparentFullBoundsContainerView.setOnTouchListener(new c());
        Braze.getInstance(getContext()).removeSingleSubscription(this.mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
        this.mFeedUpdatedSubscriber = new d(this, listView);
        Braze.getInstance(getContext()).subscribeToFeedUpdates(this.mFeedUpdatedSubscriber);
        listView.setAdapter(this.mAdapter);
        Braze.getInstance(getContext()).requestFeedRefreshFromCache();
    }

    public void setCategories(EnumSet<CardCategory> enumSet) {
        if (enumSet == null) {
            BrazeLogger.i(TAG, "The categories passed into setCategories are null, AppboyFeedFragment is going to display all the cards in cache.");
            this.mCategories = CardCategory.getAllCategories();
        } else if (enumSet.isEmpty()) {
            BrazeLogger.w(TAG, "The categories set had no elements and have been ignored. Please pass a valid EnumSet of CardCategory.");
            return;
        } else if (!enumSet.equals(this.mCategories)) {
            this.mCategories = enumSet;
        } else {
            return;
        }
        if (Braze.getInstance(getContext()) != null) {
            Braze.getInstance(getContext()).requestFeedRefreshFromCache();
        }
    }

    public void setCategory(CardCategory cardCategory) {
        setCategories(EnumSet.of(cardCategory));
    }

    public void setSortEnabled(boolean z11) {
        this.mSortEnabled = z11;
    }

    public List<Card> sortFeedCards(List<Card> list) {
        Collections.sort(list, new e());
        return list;
    }
}
