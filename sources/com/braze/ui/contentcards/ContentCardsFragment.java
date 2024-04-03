package com.braze.ui.contentcards;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SimpleItemAnimator;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.appboy.models.cards.Card;
import com.appboy.ui.R;
import com.braze.Braze;
import com.braze.coroutine.BrazeCoroutineScope;
import com.braze.events.ContentCardsUpdatedEvent;
import com.braze.events.IEventSubscriber;
import com.braze.events.SdkDataWipeEvent;
import com.braze.support.BrazeLogger;
import com.braze.ui.contentcards.adapters.ContentCardAdapter;
import com.braze.ui.contentcards.adapters.EmptyContentCardsAdapter;
import com.braze.ui.contentcards.handlers.DefaultContentCardsUpdateHandler;
import com.braze.ui.contentcards.handlers.DefaultContentCardsViewBindingHandler;
import com.braze.ui.contentcards.handlers.IContentCardsUpdateHandler;
import com.braze.ui.contentcards.handlers.IContentCardsViewBindingHandler;
import com.braze.ui.contentcards.recycler.ContentCardsDividerItemDecoration;
import com.braze.ui.contentcards.recycler.SimpleItemTouchHelperCallback;
import com.newrelic.agent.android.api.v2.TraceFieldInterface;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.newrelic.agent.android.tracing.Trace;
import com.newrelic.agent.android.tracing.TraceMachine;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u3.a;
import u3.b;

@Instrumented
@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b\u0016\u0018\u0000 \\2\u00020\u00012\u00020\u0002:\u0001\\B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010>\u001a\u00020?H\u0004J\u0019\u0010@\u001a\u00020?2\u0006\u0010A\u001a\u00020\u0015H@ø\u0001\u0000¢\u0006\u0002\u0010BJ\u0006\u0010C\u001a\u00020\u001bJ\u0006\u0010D\u001a\u00020!J\u0010\u0010E\u001a\u00020?2\u0006\u0010A\u001a\u00020\u0015H\u0004J\b\u0010F\u001a\u00020?H\u0004J\u0011\u0010G\u001a\u00020?H@ø\u0001\u0000¢\u0006\u0002\u0010HJ&\u0010I\u001a\u0004\u0018\u00010J2\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010N2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010Q\u001a\u00020?H\u0016J\b\u0010R\u001a\u00020?H\u0016J\b\u0010S\u001a\u00020?H\u0016J\u0010\u0010T\u001a\u00020?2\u0006\u0010U\u001a\u00020PH\u0016J\u0012\u0010V\u001a\u00020?2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\u0010\u0010W\u001a\u00020?2\b\u0010X\u001a\u0004\u0018\u00010\u001bJ\u0010\u0010Y\u001a\u00020?2\b\u0010X\u001a\u0004\u0018\u00010!J\u0014\u0010Z\u001a\u00020?2\n\u0010[\u001a\u0006\u0012\u0002\b\u000301H\u0004R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u0004\u0018\u00010\u00072\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007@DX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\"\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001c\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010\u001dR\u0014\u0010(\u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b)\u0010#R\u001a\u0010*\u001a\u00020+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u0018\u00100\u001a\u0006\u0012\u0002\b\u0003018DX\u0004¢\u0006\u0006\u001a\u0004\b2\u00103R\u001c\u00104\u001a\u0004\u0018\u000105X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\"\u0010:\u001a\n\u0012\u0004\u0012\u00020;\u0018\u00010\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\u0017\"\u0004\b=\u0010\u0019\u0002\u0004\n\u0002\b\u0019¨\u0006]"}, d2 = {"Lcom/braze/ui/contentcards/ContentCardsFragment;", "Landroidx/fragment/app/Fragment;", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout$OnRefreshListener;", "()V", "cardAdapter", "Lcom/braze/ui/contentcards/adapters/ContentCardAdapter;", "<set-?>", "Landroidx/recyclerview/widget/RecyclerView;", "contentCardsRecyclerView", "getContentCardsRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setContentCardsRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "contentCardsSwipeLayout", "Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "getContentCardsSwipeLayout", "()Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;", "setContentCardsSwipeLayout", "(Landroidx/swiperefreshlayout/widget/SwipeRefreshLayout;)V", "contentCardsUpdatedSubscriber", "Lcom/braze/events/IEventSubscriber;", "Lcom/braze/events/ContentCardsUpdatedEvent;", "getContentCardsUpdatedSubscriber", "()Lcom/braze/events/IEventSubscriber;", "setContentCardsUpdatedSubscriber", "(Lcom/braze/events/IEventSubscriber;)V", "customContentCardUpdateHandler", "Lcom/braze/ui/contentcards/handlers/IContentCardsUpdateHandler;", "getCustomContentCardUpdateHandler", "()Lcom/braze/ui/contentcards/handlers/IContentCardsUpdateHandler;", "setCustomContentCardUpdateHandler", "(Lcom/braze/ui/contentcards/handlers/IContentCardsUpdateHandler;)V", "customContentCardsViewBindingHandler", "Lcom/braze/ui/contentcards/handlers/IContentCardsViewBindingHandler;", "getCustomContentCardsViewBindingHandler", "()Lcom/braze/ui/contentcards/handlers/IContentCardsViewBindingHandler;", "setCustomContentCardsViewBindingHandler", "(Lcom/braze/ui/contentcards/handlers/IContentCardsViewBindingHandler;)V", "defaultContentCardUpdateHandler", "getDefaultContentCardUpdateHandler", "defaultContentCardsViewBindingHandler", "getDefaultContentCardsViewBindingHandler", "defaultEmptyContentCardsAdapter", "Lcom/braze/ui/contentcards/adapters/EmptyContentCardsAdapter;", "getDefaultEmptyContentCardsAdapter", "()Lcom/braze/ui/contentcards/adapters/EmptyContentCardsAdapter;", "setDefaultEmptyContentCardsAdapter", "(Lcom/braze/ui/contentcards/adapters/EmptyContentCardsAdapter;)V", "emptyCardsAdapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "getEmptyCardsAdapter", "()Landroidx/recyclerview/widget/RecyclerView$Adapter;", "networkUnavailableJob", "Lkotlinx/coroutines/Job;", "getNetworkUnavailableJob", "()Lkotlinx/coroutines/Job;", "setNetworkUnavailableJob", "(Lkotlinx/coroutines/Job;)V", "sdkDataWipeEventSubscriber", "Lcom/braze/events/SdkDataWipeEvent;", "getSdkDataWipeEventSubscriber", "setSdkDataWipeEventSubscriber", "attachSwipeHelperCallback", "", "contentCardsUpdate", "event", "(Lcom/braze/events/ContentCardsUpdatedEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getContentCardUpdateHandler", "getContentCardsViewBindingHandler", "handleContentCardsUpdatedEvent", "initializeRecyclerView", "networkUnavailable", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onRefresh", "onResume", "onSaveInstanceState", "outState", "onViewStateRestored", "setContentCardUpdateHandler", "value", "setContentCardsViewBindingHandler", "swapRecyclerViewAdapter", "newAdapter", "Companion", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public class ContentCardsFragment extends Fragment implements SwipeRefreshLayout.OnRefreshListener, TraceFieldInterface {
    private static final long AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS = 2500;
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String KNOWN_CARD_IMPRESSIONS_SAVED_INSTANCE_STATE_KEY = "KNOWN_CARD_IMPRESSIONS_SAVED_INSTANCE_STATE_KEY";
    @NotNull
    private static final String LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY = "LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY";
    private static final int MAX_CONTENT_CARDS_TTL_SECONDS = 60;
    private static final long NETWORK_PROBLEM_WARNING_MS = 5000;
    @NotNull
    private static final String UPDATE_HANDLER_SAVED_INSTANCE_STATE_KEY = "UPDATE_HANDLER_SAVED_INSTANCE_STATE_KEY";
    @NotNull
    private static final String VIEW_BINDING_HANDLER_SAVED_INSTANCE_STATE_KEY = "VIEW_BINDING_HANDLER_SAVED_INSTANCE_STATE_KEY";
    public Trace _nr_trace;
    @Nullable
    @JvmField
    public ContentCardAdapter cardAdapter;
    @Nullable
    private RecyclerView contentCardsRecyclerView;
    @Nullable
    private SwipeRefreshLayout contentCardsSwipeLayout;
    @Nullable
    private IEventSubscriber<ContentCardsUpdatedEvent> contentCardsUpdatedSubscriber;
    @Nullable
    private IContentCardsUpdateHandler customContentCardUpdateHandler;
    @Nullable
    private IContentCardsViewBindingHandler customContentCardsViewBindingHandler;
    @NotNull
    private final IContentCardsUpdateHandler defaultContentCardUpdateHandler = new DefaultContentCardsUpdateHandler();
    @NotNull
    private final IContentCardsViewBindingHandler defaultContentCardsViewBindingHandler = new DefaultContentCardsViewBindingHandler();
    @NotNull
    private EmptyContentCardsAdapter defaultEmptyContentCardsAdapter = new EmptyContentCardsAdapter();
    @Nullable
    private Job networkUnavailableJob;
    @Nullable
    private IEventSubscriber<SdkDataWipeEvent> sdkDataWipeEventSubscriber;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/braze/ui/contentcards/ContentCardsFragment$Companion;", "", "()V", "AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS", "", "KNOWN_CARD_IMPRESSIONS_SAVED_INSTANCE_STATE_KEY", "", "LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY", "MAX_CONTENT_CARDS_TTL_SECONDS", "", "NETWORK_PROBLEM_WARNING_MS", "UPDATE_HANDLER_SAVED_INSTANCE_STATE_KEY", "VIEW_BINDING_HANDLER_SAVED_INSTANCE_STATE_KEY", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-0  reason: not valid java name */
    public static final void m9200onResume$lambda0(ContentCardsFragment contentCardsFragment, ContentCardsUpdatedEvent contentCardsUpdatedEvent) {
        Intrinsics.checkNotNullParameter(contentCardsFragment, "this$0");
        Intrinsics.checkNotNullParameter(contentCardsUpdatedEvent, "event");
        contentCardsFragment.handleContentCardsUpdatedEvent(contentCardsUpdatedEvent);
    }

    /* access modifiers changed from: private */
    /* renamed from: onResume$lambda-2  reason: not valid java name */
    public static final void m9201onResume$lambda2(ContentCardsFragment contentCardsFragment, SdkDataWipeEvent sdkDataWipeEvent) {
        Intrinsics.checkNotNullParameter(contentCardsFragment, "this$0");
        Intrinsics.checkNotNullParameter(sdkDataWipeEvent, "it");
        contentCardsFragment.handleContentCardsUpdatedEvent(ContentCardsUpdatedEvent.Companion.getEmptyUpdate());
    }

    public final void attachSwipeHelperCallback() {
        ContentCardAdapter contentCardAdapter = this.cardAdapter;
        if (contentCardAdapter != null) {
            new ItemTouchHelper(new SimpleItemTouchHelperCallback(contentCardAdapter)).attachToRecyclerView(getContentCardsRecyclerView());
        }
    }

    @Nullable
    public final Object contentCardsUpdate(@NotNull ContentCardsUpdatedEvent contentCardsUpdatedEvent, @NotNull Continuation<? super Unit> continuation) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new ContentCardsFragment$contentCardsUpdate$2(contentCardsUpdatedEvent), 6, (Object) null);
        List<Card> handleCardUpdate = getContentCardUpdateHandler().handleCardUpdate(contentCardsUpdatedEvent);
        ContentCardAdapter contentCardAdapter = this.cardAdapter;
        if (contentCardAdapter != null) {
            contentCardAdapter.replaceCards(handleCardUpdate);
        }
        Job networkUnavailableJob2 = getNetworkUnavailableJob();
        if (networkUnavailableJob2 != null) {
            Job.DefaultImpls.cancel$default(networkUnavailableJob2, (CancellationException) null, 1, (Object) null);
        }
        setNetworkUnavailableJob((Job) null);
        if (contentCardsUpdatedEvent.isFromOfflineStorage() && contentCardsUpdatedEvent.isTimestampOlderThan(60)) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, BrazeLogger.Priority.I, (Throwable) null, false, (Function0) ContentCardsFragment$contentCardsUpdate$3.INSTANCE, 6, (Object) null);
            Braze.Companion companion = Braze.Companion;
            Context requireContext = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
            companion.getInstance(requireContext).requestContentCardsRefresh(false);
            if (handleCardUpdate.isEmpty()) {
                SwipeRefreshLayout contentCardsSwipeLayout2 = getContentCardsSwipeLayout();
                if (contentCardsSwipeLayout2 != null) {
                    contentCardsSwipeLayout2.setRefreshing(true);
                }
                BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) ContentCardsFragment$contentCardsUpdate$4.INSTANCE, 7, (Object) null);
                Job networkUnavailableJob3 = getNetworkUnavailableJob();
                if (networkUnavailableJob3 != null) {
                    Job.DefaultImpls.cancel$default(networkUnavailableJob3, (CancellationException) null, 1, (Object) null);
                }
                setNetworkUnavailableJob(BrazeCoroutineScope.INSTANCE.launchDelayed(Boxing.boxLong(5000), Dispatchers.getMain(), new ContentCardsFragment$contentCardsUpdate$5(this, (Continuation<? super ContentCardsFragment$contentCardsUpdate$5>) null)));
                return Unit.INSTANCE;
            }
        }
        if (!handleCardUpdate.isEmpty()) {
            ContentCardAdapter contentCardAdapter2 = this.cardAdapter;
            if (contentCardAdapter2 != null) {
                swapRecyclerViewAdapter(contentCardAdapter2);
            }
        } else {
            swapRecyclerViewAdapter(getEmptyCardsAdapter());
        }
        SwipeRefreshLayout contentCardsSwipeLayout3 = getContentCardsSwipeLayout();
        if (contentCardsSwipeLayout3 != null) {
            contentCardsSwipeLayout3.setRefreshing(false);
        }
        return Unit.INSTANCE;
    }

    @NotNull
    public final IContentCardsUpdateHandler getContentCardUpdateHandler() {
        IContentCardsUpdateHandler iContentCardsUpdateHandler = this.customContentCardUpdateHandler;
        return iContentCardsUpdateHandler == null ? this.defaultContentCardUpdateHandler : iContentCardsUpdateHandler;
    }

    @Nullable
    public final RecyclerView getContentCardsRecyclerView() {
        return this.contentCardsRecyclerView;
    }

    @Nullable
    public final SwipeRefreshLayout getContentCardsSwipeLayout() {
        return this.contentCardsSwipeLayout;
    }

    @Nullable
    public final IEventSubscriber<ContentCardsUpdatedEvent> getContentCardsUpdatedSubscriber() {
        return this.contentCardsUpdatedSubscriber;
    }

    @NotNull
    public final IContentCardsViewBindingHandler getContentCardsViewBindingHandler() {
        IContentCardsViewBindingHandler iContentCardsViewBindingHandler = this.customContentCardsViewBindingHandler;
        return iContentCardsViewBindingHandler == null ? this.defaultContentCardsViewBindingHandler : iContentCardsViewBindingHandler;
    }

    @Nullable
    public final IContentCardsUpdateHandler getCustomContentCardUpdateHandler() {
        return this.customContentCardUpdateHandler;
    }

    @Nullable
    public final IContentCardsViewBindingHandler getCustomContentCardsViewBindingHandler() {
        return this.customContentCardsViewBindingHandler;
    }

    @NotNull
    public final IContentCardsUpdateHandler getDefaultContentCardUpdateHandler() {
        return this.defaultContentCardUpdateHandler;
    }

    @NotNull
    public final IContentCardsViewBindingHandler getDefaultContentCardsViewBindingHandler() {
        return this.defaultContentCardsViewBindingHandler;
    }

    @NotNull
    public final EmptyContentCardsAdapter getDefaultEmptyContentCardsAdapter() {
        return this.defaultEmptyContentCardsAdapter;
    }

    @NotNull
    public final RecyclerView.Adapter<?> getEmptyCardsAdapter() {
        return this.defaultEmptyContentCardsAdapter;
    }

    @Nullable
    public final Job getNetworkUnavailableJob() {
        return this.networkUnavailableJob;
    }

    @Nullable
    public final IEventSubscriber<SdkDataWipeEvent> getSdkDataWipeEventSubscriber() {
        return this.sdkDataWipeEventSubscriber;
    }

    public final void handleContentCardsUpdatedEvent(@NotNull ContentCardsUpdatedEvent contentCardsUpdatedEvent) {
        Intrinsics.checkNotNullParameter(contentCardsUpdatedEvent, "event");
        Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new ContentCardsFragment$handleContentCardsUpdatedEvent$1(this, contentCardsUpdatedEvent, (Continuation<? super ContentCardsFragment$handleContentCardsUpdatedEvent$1>) null), 2, (Object) null);
    }

    public final void initializeRecyclerView() {
        RecyclerView.ItemAnimator itemAnimator;
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        ContentCardAdapter contentCardAdapter = new ContentCardAdapter(requireContext, linearLayoutManager, new ArrayList(), getContentCardsViewBindingHandler());
        this.cardAdapter = contentCardAdapter;
        RecyclerView recyclerView = this.contentCardsRecyclerView;
        if (recyclerView != null) {
            recyclerView.setAdapter(contentCardAdapter);
        }
        RecyclerView recyclerView2 = this.contentCardsRecyclerView;
        if (recyclerView2 != null) {
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        attachSwipeHelperCallback();
        RecyclerView recyclerView3 = this.contentCardsRecyclerView;
        if (recyclerView3 == null) {
            itemAnimator = null;
        } else {
            itemAnimator = recyclerView3.getItemAnimator();
        }
        if (itemAnimator instanceof SimpleItemAnimator) {
            ((SimpleItemAnimator) itemAnimator).setSupportsChangeAnimations(false);
        }
        RecyclerView recyclerView4 = this.contentCardsRecyclerView;
        if (recyclerView4 != null) {
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            recyclerView4.addItemDecoration(new ContentCardsDividerItemDecoration(requireContext2));
        }
    }

    @Nullable
    public final Object networkUnavailable(@NotNull Continuation<? super Unit> continuation) {
        Context applicationContext;
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) ContentCardsFragment$networkUnavailable$2.INSTANCE, 6, (Object) null);
        Context context = getContext();
        if (!(context == null || (applicationContext = context.getApplicationContext()) == null)) {
            Toast.makeText(applicationContext, applicationContext.getString(R.string.com_appboy_feed_connection_error_title), 1).show();
        }
        swapRecyclerViewAdapter(getEmptyCardsAdapter());
        SwipeRefreshLayout contentCardsSwipeLayout2 = getContentCardsSwipeLayout();
        if (contentCardsSwipeLayout2 != null) {
            contentCardsSwipeLayout2.setRefreshing(false);
        }
        return Unit.INSTANCE;
    }

    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater, @Nullable ViewGroup viewGroup, @Nullable Bundle bundle) {
        try {
            TraceMachine.enterMethod(this._nr_trace, "ContentCardsFragment#onCreateView", (ArrayList<String>) null);
        } catch (NoSuchFieldError unused) {
            TraceMachine.enterMethod((Trace) null, "ContentCardsFragment#onCreateView", (ArrayList<String>) null);
        }
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.com_braze_content_cards, viewGroup, false);
        this.contentCardsRecyclerView = (RecyclerView) inflate.findViewById(R.id.com_braze_content_cards_recycler);
        SwipeRefreshLayout swipeRefreshLayout = (SwipeRefreshLayout) inflate.findViewById(R.id.appboy_content_cards_swipe_container);
        this.contentCardsSwipeLayout = swipeRefreshLayout;
        if (swipeRefreshLayout != null) {
            swipeRefreshLayout.setOnRefreshListener(this);
        }
        SwipeRefreshLayout swipeRefreshLayout2 = this.contentCardsSwipeLayout;
        if (swipeRefreshLayout2 != null) {
            swipeRefreshLayout2.setColorSchemeResources(R.color.com_braze_content_cards_swipe_refresh_color_1, R.color.com_braze_content_cards_swipe_refresh_color_2, R.color.com_braze_content_cards_swipe_refresh_color_3, R.color.com_braze_content_cards_swipe_refresh_color_4);
        }
        TraceMachine.exitMethod();
        return inflate;
    }

    public void onPause() {
        super.onPause();
        Braze.Companion companion = Braze.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.getInstance(requireContext).removeSingleSubscription(this.contentCardsUpdatedSubscriber, ContentCardsUpdatedEvent.class);
        Context requireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
        companion.getInstance(requireContext2).removeSingleSubscription(this.sdkDataWipeEventSubscriber, SdkDataWipeEvent.class);
        Job job = this.networkUnavailableJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.networkUnavailableJob = null;
        ContentCardAdapter contentCardAdapter = this.cardAdapter;
        if (contentCardAdapter != null) {
            contentCardAdapter.markOnScreenCardsAsRead();
        }
    }

    public void onRefresh() {
        Braze.Companion companion = Braze.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.getInstance(requireContext).requestContentCardsRefresh(false);
        BrazeCoroutineScope.launchDelayed$default(BrazeCoroutineScope.INSTANCE, Long.valueOf(AUTO_HIDE_REFRESH_INDICATOR_DELAY_MS), (CoroutineContext) null, new ContentCardsFragment$onRefresh$1(this, (Continuation<? super ContentCardsFragment$onRefresh$1>) null), 2, (Object) null);
    }

    public void onResume() {
        super.onResume();
        Braze.Companion companion = Braze.Companion;
        Context requireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext, "requireContext()");
        companion.getInstance(requireContext).removeSingleSubscription(this.contentCardsUpdatedSubscriber, ContentCardsUpdatedEvent.class);
        if (this.contentCardsUpdatedSubscriber == null) {
            this.contentCardsUpdatedSubscriber = new a(this);
        }
        IEventSubscriber<ContentCardsUpdatedEvent> iEventSubscriber = this.contentCardsUpdatedSubscriber;
        if (iEventSubscriber != null) {
            Context requireContext2 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext2, "requireContext()");
            companion.getInstance(requireContext2).subscribeToContentCardsUpdates(iEventSubscriber);
        }
        Context requireContext3 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext3, "requireContext()");
        companion.getInstance(requireContext3).requestContentCardsRefresh(true);
        Context requireContext4 = requireContext();
        Intrinsics.checkNotNullExpressionValue(requireContext4, "requireContext()");
        Class<SdkDataWipeEvent> cls = SdkDataWipeEvent.class;
        companion.getInstance(requireContext4).removeSingleSubscription(this.sdkDataWipeEventSubscriber, cls);
        if (this.sdkDataWipeEventSubscriber == null) {
            this.sdkDataWipeEventSubscriber = new b(this);
        }
        IEventSubscriber<SdkDataWipeEvent> iEventSubscriber2 = this.sdkDataWipeEventSubscriber;
        if (iEventSubscriber2 != null) {
            Context requireContext5 = requireContext();
            Intrinsics.checkNotNullExpressionValue(requireContext5, "requireContext()");
            companion.getInstance(requireContext5).addSingleSynchronousSubscription(iEventSubscriber2, cls);
        }
    }

    public void onSaveInstanceState(@NotNull Bundle bundle) {
        RecyclerView.LayoutManager layoutManager;
        Intrinsics.checkNotNullParameter(bundle, "outState");
        super.onSaveInstanceState(bundle);
        RecyclerView recyclerView = this.contentCardsRecyclerView;
        if (!(recyclerView == null || (layoutManager = recyclerView.getLayoutManager()) == null)) {
            bundle.putParcelable(LAYOUT_MANAGER_SAVED_INSTANCE_STATE_KEY, layoutManager.onSaveInstanceState());
        }
        ContentCardAdapter contentCardAdapter = this.cardAdapter;
        if (contentCardAdapter != null) {
            bundle.putStringArrayList(KNOWN_CARD_IMPRESSIONS_SAVED_INSTANCE_STATE_KEY, new ArrayList(contentCardAdapter.getImpressedCardIds()));
        }
        IContentCardsViewBindingHandler iContentCardsViewBindingHandler = this.customContentCardsViewBindingHandler;
        if (iContentCardsViewBindingHandler != null) {
            bundle.putParcelable(VIEW_BINDING_HANDLER_SAVED_INSTANCE_STATE_KEY, iContentCardsViewBindingHandler);
        }
        IContentCardsUpdateHandler iContentCardsUpdateHandler = this.customContentCardUpdateHandler;
        if (iContentCardsUpdateHandler != null) {
            bundle.putParcelable(UPDATE_HANDLER_SAVED_INSTANCE_STATE_KEY, iContentCardsUpdateHandler);
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }

    public void onViewStateRestored(@Nullable Bundle bundle) {
        IContentCardsUpdateHandler iContentCardsUpdateHandler;
        IContentCardsViewBindingHandler iContentCardsViewBindingHandler;
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 33) {
                iContentCardsUpdateHandler = (IContentCardsUpdateHandler) bundle.getParcelable(UPDATE_HANDLER_SAVED_INSTANCE_STATE_KEY, IContentCardsUpdateHandler.class);
            } else {
                iContentCardsUpdateHandler = (IContentCardsUpdateHandler) bundle.getParcelable(UPDATE_HANDLER_SAVED_INSTANCE_STATE_KEY);
            }
            if (iContentCardsUpdateHandler != null) {
                setContentCardUpdateHandler(iContentCardsUpdateHandler);
            }
            if (i11 >= 33) {
                iContentCardsViewBindingHandler = (IContentCardsViewBindingHandler) bundle.getParcelable(VIEW_BINDING_HANDLER_SAVED_INSTANCE_STATE_KEY, IContentCardsViewBindingHandler.class);
            } else {
                iContentCardsViewBindingHandler = (IContentCardsViewBindingHandler) bundle.getParcelable(VIEW_BINDING_HANDLER_SAVED_INSTANCE_STATE_KEY);
            }
            if (iContentCardsViewBindingHandler != null) {
                setContentCardsViewBindingHandler(iContentCardsViewBindingHandler);
            }
            Job unused = BuildersKt__Builders_commonKt.launch$default(BrazeCoroutineScope.INSTANCE, Dispatchers.getMain(), (CoroutineStart) null, new ContentCardsFragment$onViewStateRestored$1(bundle, this, (Continuation<? super ContentCardsFragment$onViewStateRestored$1>) null), 2, (Object) null);
        }
        initializeRecyclerView();
    }

    public final void setContentCardUpdateHandler(@Nullable IContentCardsUpdateHandler iContentCardsUpdateHandler) {
        this.customContentCardUpdateHandler = iContentCardsUpdateHandler;
    }

    public final void setContentCardsRecyclerView(@Nullable RecyclerView recyclerView) {
        this.contentCardsRecyclerView = recyclerView;
    }

    public final void setContentCardsSwipeLayout(@Nullable SwipeRefreshLayout swipeRefreshLayout) {
        this.contentCardsSwipeLayout = swipeRefreshLayout;
    }

    public final void setContentCardsUpdatedSubscriber(@Nullable IEventSubscriber<ContentCardsUpdatedEvent> iEventSubscriber) {
        this.contentCardsUpdatedSubscriber = iEventSubscriber;
    }

    public final void setContentCardsViewBindingHandler(@Nullable IContentCardsViewBindingHandler iContentCardsViewBindingHandler) {
        this.customContentCardsViewBindingHandler = iContentCardsViewBindingHandler;
    }

    public final void setCustomContentCardUpdateHandler(@Nullable IContentCardsUpdateHandler iContentCardsUpdateHandler) {
        this.customContentCardUpdateHandler = iContentCardsUpdateHandler;
    }

    public final void setCustomContentCardsViewBindingHandler(@Nullable IContentCardsViewBindingHandler iContentCardsViewBindingHandler) {
        this.customContentCardsViewBindingHandler = iContentCardsViewBindingHandler;
    }

    public final void setDefaultEmptyContentCardsAdapter(@NotNull EmptyContentCardsAdapter emptyContentCardsAdapter) {
        Intrinsics.checkNotNullParameter(emptyContentCardsAdapter, "<set-?>");
        this.defaultEmptyContentCardsAdapter = emptyContentCardsAdapter;
    }

    public final void setNetworkUnavailableJob(@Nullable Job job) {
        this.networkUnavailableJob = job;
    }

    public final void setSdkDataWipeEventSubscriber(@Nullable IEventSubscriber<SdkDataWipeEvent> iEventSubscriber) {
        this.sdkDataWipeEventSubscriber = iEventSubscriber;
    }

    public final void swapRecyclerViewAdapter(@NotNull RecyclerView.Adapter<?> adapter) {
        Intrinsics.checkNotNullParameter(adapter, "newAdapter");
        RecyclerView recyclerView = this.contentCardsRecyclerView;
        if (recyclerView != null && recyclerView.getAdapter() != adapter) {
            recyclerView.setAdapter(adapter);
        }
    }
}
