package com.talabat.appboy;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import androidx.core.view.GestureDetectorCompat;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.ListFragment;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appboy.enums.CardCategory;
import com.appboy.events.FeedUpdatedEvent;
import com.braze.Braze;
import com.braze.events.IEventSubscriber;
import com.braze.support.BrazeLogger;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import com.talabat.R;
import com.talabat.helpers.GlobalDataModel;
import java.util.ArrayList;
import java.util.EnumSet;

@Instrumented
public class NotificationFragment extends ListFragment implements SwipeRefreshLayout.OnRefreshListener, TraceFieldInterface {
    private static final long AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS = 2500;
    private static final int MAX_FEED_TTL_SECONDS = 60;
    private static final int NETWORK_PROBLEM_WARNING_MS = 5000;
    private static final String TAG = "NotificationFragment";
    public Trace _nr_trace;
    /* access modifiers changed from: private */
    public int currentCardIndexAtBottomOfScreen;
    /* access modifiers changed from: private */
    public BrazeListAdapter mAdapter;
    /* access modifiers changed from: private */
    public Braze mBraze;
    /* access modifiers changed from: private */
    public EnumSet<CardCategory> mCategories;
    /* access modifiers changed from: private */
    public LinearLayout mEmptyFeedLayout;
    private RelativeLayout mFeedRootLayout;
    /* access modifiers changed from: private */
    public SwipeRefreshLayout mFeedSwipeLayout;
    private IEventSubscriber<FeedUpdatedEvent> mFeedUpdatedSubscriber;
    /* access modifiers changed from: private */
    public GestureDetectorCompat mGestureDetector;
    /* access modifiers changed from: private */
    public ProgressBar mLoadingSpinner;
    /* access modifiers changed from: private */
    public final Handler mMainThreadLooper = new Handler(Looper.getMainLooper());
    /* access modifiers changed from: private */
    public LinearLayout mNetworkErrorLayout;
    /* access modifiers changed from: private */
    public final Runnable mShowNetworkError = new Runnable() {
        public void run() {
            if (NotificationFragment.this.mLoadingSpinner != null) {
                NotificationFragment.this.mLoadingSpinner.setVisibility(8);
            }
            if (NotificationFragment.this.mNetworkErrorLayout != null) {
                NotificationFragment.this.mNetworkErrorLayout.setVisibility(0);
            }
        }
    };
    private boolean mSkipCardImpressionsReset;
    /* access modifiers changed from: private */
    public View mTransparentFullBoundsContainerView;
    private NewsFeedClickListener newsFeedClickListener;
    /* access modifiers changed from: private */
    public int previousVisibleHeadCardIndex;
    /* access modifiers changed from: private */
    public int unReadNotificationCount;

    public class FeedGestureListener extends GestureDetector.SimpleOnGestureListener {
        public FeedGestureListener() {
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            long eventTime = (motionEvent2.getEventTime() - motionEvent.getEventTime()) * 2;
            NotificationFragment.this.getListView().smoothScrollBy(-((int) ((f12 * ((float) eventTime)) / 1000.0f)), (int) (eventTime * 2));
            return true;
        }

        public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
            NotificationFragment.this.getListView().smoothScrollBy((int) f12, 0);
            return true;
        }
    }

    private void setOnScreenCardsToRead() {
        this.mAdapter.batchSetCardsToRead(this.previousVisibleHeadCardIndex, this.currentCardIndexAtBottomOfScreen);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (this.mSkipCardImpressionsReset) {
            this.mSkipCardImpressionsReset = false;
        } else {
            this.mAdapter.resetCardImpressionTracker();
            BrazeLogger.d(TAG, "Resetting card impressions.");
        }
        LayoutInflater from = LayoutInflater.from(getActivity());
        final ListView listView = getListView();
        listView.setLayoutDirection(0);
        listView.addHeaderView(from.inflate(R.layout.com_appboy_feed_header, (ViewGroup) null));
        listView.addFooterView(from.inflate(R.layout.com_appboy_feed_footer, (ViewGroup) null));
        this.mFeedRootLayout.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return NotificationFragment.this.mGestureDetector.onTouchEvent(motionEvent);
            }
        });
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i11, int i12, int i13) {
                boolean z11;
                SwipeRefreshLayout e11 = NotificationFragment.this.mFeedSwipeLayout;
                if (i11 == 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                e11.setEnabled(z11);
                if (i12 != 0) {
                    int i14 = i11 - 1;
                    if (i14 > NotificationFragment.this.previousVisibleHeadCardIndex) {
                        NotificationFragment.this.mAdapter.batchSetCardsToRead(NotificationFragment.this.previousVisibleHeadCardIndex, i14);
                    }
                    NotificationFragment.this.previousVisibleHeadCardIndex = i14;
                    NotificationFragment.this.currentCardIndexAtBottomOfScreen = i11 + i12;
                }
            }

            public void onScrollStateChanged(AbsListView absListView, int i11) {
            }
        });
        this.mTransparentFullBoundsContainerView.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return view.getVisibility() == 0;
            }
        });
        this.mBraze.removeSingleSubscription(this.mFeedUpdatedSubscriber, FeedUpdatedEvent.class);
        AnonymousClass5 r42 = new IEventSubscriber<FeedUpdatedEvent>() {
            public void trigger(final FeedUpdatedEvent feedUpdatedEvent) {
                FragmentActivity activity = NotificationFragment.this.getActivity();
                if (activity != null) {
                    activity.runOnUiThread(new Runnable() {
                        public void run() {
                            BrazeLogger.d(NotificationFragment.TAG, "Updating feed views in listResponse to FeedUpdatedEvent: " + feedUpdatedEvent);
                            NotificationFragment.this.mMainThreadLooper.removeCallbacks(NotificationFragment.this.mShowNetworkError);
                            NotificationFragment.this.mNetworkErrorLayout.setVisibility(8);
                            if (feedUpdatedEvent.getCardCount((EnumSet<CardCategory>) NotificationFragment.this.mCategories) == 0) {
                                listView.setVisibility(8);
                                NotificationFragment.this.mAdapter.clear();
                            } else {
                                NotificationFragment.this.unReadNotificationCount = feedUpdatedEvent.getUnreadCardCount();
                                GlobalDataModel.APPBOYNOTIFICATION.notificationCount = 0;
                                NotificationFragment.this.mEmptyFeedLayout.setVisibility(8);
                                NotificationFragment.this.mLoadingSpinner.setVisibility(8);
                                NotificationFragment.this.mTransparentFullBoundsContainerView.setVisibility(8);
                            }
                            if (feedUpdatedEvent.isFromOfflineStorage() && (feedUpdatedEvent.lastUpdatedInSecondsFromEpoch() + 60) * 1000 < System.currentTimeMillis()) {
                                BrazeLogger.i(NotificationFragment.TAG, String.format("Feed received was older than the max time to live of %d seconds, displaying it for now, but requesting an updated view from the server.", new Object[]{60}));
                                NotificationFragment.this.mBraze.requestFeedRefresh();
                                if (feedUpdatedEvent.getCardCount((EnumSet<CardCategory>) NotificationFragment.this.mCategories) == 0) {
                                    BrazeLogger.d(NotificationFragment.TAG, String.format("Old feed was empty, putting up a network spinner and registering the network error message on a delay of %dms.", new Object[]{5000}));
                                    NotificationFragment.this.mEmptyFeedLayout.setVisibility(8);
                                    NotificationFragment.this.mLoadingSpinner.setVisibility(0);
                                    NotificationFragment.this.mTransparentFullBoundsContainerView.setVisibility(0);
                                    NotificationFragment.this.mMainThreadLooper.postDelayed(NotificationFragment.this.mShowNetworkError, 5000);
                                    return;
                                }
                            }
                            if (feedUpdatedEvent.getCardCount((EnumSet<CardCategory>) NotificationFragment.this.mCategories) == 0) {
                                NotificationFragment.this.mLoadingSpinner.setVisibility(8);
                                NotificationFragment.this.mEmptyFeedLayout.setVisibility(0);
                                NotificationFragment.this.mTransparentFullBoundsContainerView.setVisibility(0);
                            } else {
                                NotificationFragment.this.mAdapter.replaceFeed(feedUpdatedEvent.getFeedCards((EnumSet<CardCategory>) NotificationFragment.this.mCategories));
                                listView.setVisibility(0);
                            }
                            NotificationFragment.this.mFeedSwipeLayout.setRefreshing(false);
                        }
                    });
                }
            }
        };
        this.mFeedUpdatedSubscriber = r42;
        this.mBraze.subscribeToFeedUpdates(r42);
        listView.setAdapter(this.mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i11, long j11) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("onItemSelected: ");
                sb2.append(i11);
            }
        });
        this.mBraze.requestFeedRefreshFromCache();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.mBraze = Braze.getInstance(activity);
        if (this.mAdapter == null) {
            this.mAdapter = new BrazeListAdapter(activity, R.id.tag, new ArrayList());
            this.mCategories = CardCategory.getAllCategories();
            this.mAdapter.setNewsFeedClickListener(this.newsFeedClickListener);
        }
        setRetainInstance(true);
        this.mGestureDetector = new GestureDetectorCompat(activity, new FeedGestureListener());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "NotificationFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "NotificationFragment#onCreateView", (ArrayList<String>) null);
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
        IEventSubscriber<FeedUpdatedEvent> iEventSubscriber;
        super.onDestroyView();
        Braze braze = this.mBraze;
        if (!(braze == null || (iEventSubscriber = this.mFeedUpdatedSubscriber) == null)) {
            braze.removeSingleSubscription(iEventSubscriber, FeedUpdatedEvent.class);
        }
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
        this.mMainThreadLooper.postDelayed(new Runnable() {
            public void run() {
                NotificationFragment.this.mFeedSwipeLayout.setRefreshing(false);
            }
        }, AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS);
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
        Braze braze = this.mBraze;
        if (braze != null) {
            braze.requestFeedRefreshFromCache();
        }
    }

    public void setNewsFeedClickListener(NewsFeedClickListener newsFeedClickListener2) {
        this.newsFeedClickListener = newsFeedClickListener2;
    }
}
