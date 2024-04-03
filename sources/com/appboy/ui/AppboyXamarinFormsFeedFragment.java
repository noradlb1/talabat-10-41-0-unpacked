package com.appboy.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.ListFragment;
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
import androidx.core.view.GestureDetectorCompat;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appboy.enums.CardCategory;
import com.appboy.events.FeedUpdatedEvent;
import com.appboy.ui.adapters.AppboyListAdapter;
import com.braze.Braze;
import com.braze.IBraze;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import j3.g;
import j3.h;
import j3.i;
import j3.j;
import j3.k;
import java.util.ArrayList;
import java.util.EnumSet;

@Instrumented
public class AppboyXamarinFormsFeedFragment extends ListFragment implements SwipeRefreshLayout.OnRefreshListener, TraceFieldInterface {
    private static final long AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS = 2500;
    private static final int MAX_FEED_TTL_SECONDS = 60;
    private static final int NETWORK_PROBLEM_WARNING_MS = 5000;
    private static final String TAG = BrazeLogger.getBrazeLogTag((Class<?>) AppboyXamarinFormsFeedFragment.class);
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public int currentCardIndexAtBottomOfScreen;
    /* access modifiers changed from: private */
    public AppboyListAdapter mAdapter;
    private IBraze mBraze;
    private EnumSet<CardCategory> mCategories;
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
    private final Runnable mShowNetworkError = new Runnable() {
        public void run() {
            if (AppboyXamarinFormsFeedFragment.this.mLoadingSpinner != null) {
                AppboyXamarinFormsFeedFragment.this.mLoadingSpinner.setVisibility(8);
            }
            if (AppboyXamarinFormsFeedFragment.this.mNetworkErrorLayout != null) {
                AppboyXamarinFormsFeedFragment.this.mNetworkErrorLayout.setVisibility(0);
            }
        }
    };
    private boolean mSkipCardImpressionsReset;
    private View mTransparentFullBoundsContainerView;
    /* access modifiers changed from: private */
    public int previousVisibleHeadCardIndex;

    public class FeedGestureListener extends GestureDetector.SimpleOnGestureListener {
        public FeedGestureListener() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            long eventTime = (motionEvent2.getEventTime() - motionEvent.getEventTime()) * 2;
            AppboyXamarinFormsFeedFragment.this.getListView().smoothScrollBy(-((int) ((f12 * ((float) eventTime)) / 1000.0f)), (int) (eventTime * 2));
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            AppboyXamarinFormsFeedFragment.this.getListView().smoothScrollBy((int) f12, 0);
            return true;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean lambda$onActivityCreated$0(View view, MotionEvent motionEvent) {
        return this.mGestureDetector.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$onActivityCreated$1(View view, MotionEvent motionEvent) {
        return view.getVisibility() == 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityCreated$2(FeedUpdatedEvent feedUpdatedEvent, ListView listView) {
        String str = TAG;
        BrazeLogger.d(str, "Updating feed views in response to FeedUpdatedEvent: " + feedUpdatedEvent);
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
            this.mBraze.requestFeedRefresh();
            if (feedUpdatedEvent.getCardCount(this.mCategories) == 0) {
                BrazeLogger.d(str, "Old feed was empty, putting up a network spinner and registering the network error message on a delay of 5000ms.");
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
            this.mAdapter.replaceFeed(feedUpdatedEvent.getFeedCards(this.mCategories));
            listView.setVisibility(0);
        }
        this.mFeedSwipeLayout.setRefreshing(false);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onActivityCreated$3(ListView listView, FeedUpdatedEvent feedUpdatedEvent) {
        Activity activity = getActivity();
        if (activity != null) {
            activity.runOnUiThread(new k(this, feedUpdatedEvent, listView));
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$onRefresh$4() {
        this.mFeedSwipeLayout.setRefreshing(false);
    }

    private void setOnScreenCardsToRead() {
        this.mAdapter.batchSetCardsToRead(this.previousVisibleHeadCardIndex, this.currentCardIndexAtBottomOfScreen);
    }

    public EnumSet<CardCategory> getCategories() {
        return this.mCategories;
    }

    @SuppressLint({"InflateParams"})
    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
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
        this.mFeedRootLayout.setOnTouchListener(new h(this));
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
                boolean z11;
                SwipeRefreshLayout access$200 = AppboyXamarinFormsFeedFragment.this.mFeedSwipeLayout;
                if (i11 == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                access$200.setEnabled(z11);
                if (i12 != 0) {
                    int i14 = i11 - 1;
                    if (i14 > AppboyXamarinFormsFeedFragment.this.previousVisibleHeadCardIndex) {
                        AppboyXamarinFormsFeedFragment.this.mAdapter.batchSetCardsToRead(AppboyXamarinFormsFeedFragment.this.previousVisibleHeadCardIndex, i14);
                    }
                    int unused = AppboyXamarinFormsFeedFragment.this.previousVisibleHeadCardIndex = i14;
                    int unused2 = AppboyXamarinFormsFeedFragment.this.currentCardIndexAtBottomOfScreen = i11 + i12;
                }
            }

            public void onScrollStateChanged(AbsListView absListView, int i11) {
            }
        });
        this.mTransparentFullBoundsContainerView.setOnTouchListener(new i());
        this.mBraze.removeSingleSubscription(this.mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
        j jVar = new j(this, listView);
        this.mFeedUpdatedSubscriber = jVar;
        this.mBraze.subscribeToFeedUpdates(jVar);
        listView.setAdapter(this.mAdapter);
        this.mBraze.requestFeedRefreshFromCache();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.mBraze = Braze.getInstance(context);
        if (this.mAdapter == null) {
            this.mAdapter = new AppboyListAdapter(context, R.id.tag, new ArrayList());
            this.mCategories = CardCategory.getAllCategories();
        }
        setRetainInstance(true);
        this.mGestureDetector = new GestureDetectorCompat(context, new FeedGestureListener());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "AppboyXamarinFormsFeedFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "AppboyXamarinFormsFeedFragment#onCreateView", (ArrayList<String>) null);
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
        this.mBraze.removeSingleSubscription(this.mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
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
        this.mBraze.requestFeedRefresh();
        this.mMainThreadLooper.postDelayed(new g(this), AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS);
    }

    public void onResume() {
        super.onResume();
        Braze.getInstance(getActivity()).logFeedDisplayed();
    }

    public void onSaveInstanceState(Bundle bundle) {
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
        IBraze iBraze = this.mBraze;
        if (iBraze != null) {
            iBraze.requestFeedRefreshFromCache();
        }
    }

    public void setCategory(CardCategory cardCategory) {
        setCategories(EnumSet.of(cardCategory));
    }
}
