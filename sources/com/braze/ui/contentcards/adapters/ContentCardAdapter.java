package com.braze.ui.contentcards.adapters;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.view.ViewGroup;
import androidx.annotation.VisibleForTesting;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.appboy.models.cards.Card;
import com.braze.support.BrazeLogger;
import com.braze.ui.contentcards.handlers.IContentCardsViewBindingHandler;
import com.braze.ui.contentcards.listeners.IContentCardsActionListener;
import com.braze.ui.contentcards.managers.BrazeContentCardsManager;
import com.braze.ui.contentcards.recycler.ItemTouchHelperAdapter;
import com.braze.ui.contentcards.view.ContentCardViewHolder;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v3.a;
import v3.b;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010#\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00016B+\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0012\u0010\u0019\u001a\u0004\u0018\u00010\n2\u0006\u0010\u001a\u001a\u00020\u001bH\u0007J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bH\u0007J\u000e\u0010$\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001bJ\u0010\u0010%\u001a\u00020\"2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0012\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010\nH\u0007J\u0006\u0010)\u001a\u00020'J\u0018\u0010*\u001a\u00020'2\u0006\u0010+\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0018\u0010,\u001a\u00020\u00022\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001bH\u0016J\u0010\u00100\u001a\u00020'2\u0006\u0010\u001f\u001a\u00020\u001bH\u0016J\u0010\u00101\u001a\u00020'2\u0006\u00102\u001a\u00020\u0002H\u0016J\u0010\u00103\u001a\u00020'2\u0006\u00102\u001a\u00020\u0002H\u0016J\u0014\u00104\u001a\u00020'2\f\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\u0011R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R0\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118F@FX\u000e¢\u0006\f\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0018X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000¨\u00067"}, d2 = {"Lcom/braze/ui/contentcards/adapters/ContentCardAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/braze/ui/contentcards/view/ContentCardViewHolder;", "Lcom/braze/ui/contentcards/recycler/ItemTouchHelperAdapter;", "context", "Landroid/content/Context;", "layoutManager", "Landroidx/recyclerview/widget/LinearLayoutManager;", "cardData", "", "Lcom/appboy/models/cards/Card;", "contentCardsViewBindingHandler", "Lcom/braze/ui/contentcards/handlers/IContentCardsViewBindingHandler;", "(Landroid/content/Context;Landroidx/recyclerview/widget/LinearLayoutManager;Ljava/util/List;Lcom/braze/ui/contentcards/handlers/IContentCardsViewBindingHandler;)V", "handler", "Landroid/os/Handler;", "impressedCardIds", "", "", "getImpressedCardIds", "()Ljava/util/List;", "setImpressedCardIds", "(Ljava/util/List;)V", "impressedCardIdsInternal", "", "getCardAtIndex", "index", "", "getItemCount", "getItemId", "", "position", "getItemViewType", "isAdapterPositionOnScreen", "", "adapterPosition", "isControlCardAtPosition", "isItemDismissable", "logImpression", "", "card", "markOnScreenCardsAsRead", "onBindViewHolder", "viewHolder", "onCreateViewHolder", "viewGroup", "Landroid/view/ViewGroup;", "viewType", "onItemDismiss", "onViewAttachedToWindow", "holder", "onViewDetachedFromWindow", "replaceCards", "newCardData", "CardListDiffCallback", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ContentCardAdapter extends RecyclerView.Adapter<ContentCardViewHolder> implements ItemTouchHelperAdapter {
    /* access modifiers changed from: private */
    @NotNull
    public final List<Card> cardData;
    @NotNull
    private final IContentCardsViewBindingHandler contentCardsViewBindingHandler;
    @NotNull
    private final Context context;
    @NotNull
    private final Handler handler = new Handler(Looper.getMainLooper());
    @NotNull
    private Set<String> impressedCardIdsInternal = new LinkedHashSet();
    @NotNull
    private final LinearLayoutManager layoutManager;

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0002\u0018\u00002\u00020\u0001B!\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\b\u0010\u000e\u001a\u00020\nH\u0016J\b\u0010\u000f\u001a\u00020\nH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/braze/ui/contentcards/adapters/ContentCardAdapter$CardListDiffCallback;", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "oldCards", "", "Lcom/appboy/models/cards/Card;", "newCards", "(Ljava/util/List;Ljava/util/List;)V", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "doItemsShareIds", "getNewListSize", "getOldListSize", "android-sdk-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CardListDiffCallback extends DiffUtil.Callback {
        @NotNull
        private final List<Card> newCards;
        @NotNull
        private final List<Card> oldCards;

        public CardListDiffCallback(@NotNull List<? extends Card> list, @NotNull List<? extends Card> list2) {
            Intrinsics.checkNotNullParameter(list, "oldCards");
            Intrinsics.checkNotNullParameter(list2, "newCards");
            this.oldCards = list;
            this.newCards = list2;
        }

        private final boolean doItemsShareIds(int i11, int i12) {
            return Intrinsics.areEqual((Object) this.oldCards.get(i11).getId(), (Object) this.newCards.get(i12).getId());
        }

        public boolean areContentsTheSame(int i11, int i12) {
            return doItemsShareIds(i11, i12);
        }

        public boolean areItemsTheSame(int i11, int i12) {
            return doItemsShareIds(i11, i12);
        }

        public int getNewListSize() {
            return this.newCards.size();
        }

        public int getOldListSize() {
            return this.oldCards.size();
        }
    }

    public ContentCardAdapter(@NotNull Context context2, @NotNull LinearLayoutManager linearLayoutManager, @NotNull List<Card> list, @NotNull IContentCardsViewBindingHandler iContentCardsViewBindingHandler) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(linearLayoutManager, "layoutManager");
        Intrinsics.checkNotNullParameter(list, "cardData");
        Intrinsics.checkNotNullParameter(iContentCardsViewBindingHandler, "contentCardsViewBindingHandler");
        this.context = context2;
        this.layoutManager = linearLayoutManager;
        this.cardData = list;
        this.contentCardsViewBindingHandler = iContentCardsViewBindingHandler;
        setHasStableIds(true);
    }

    /* access modifiers changed from: private */
    /* renamed from: markOnScreenCardsAsRead$lambda-1  reason: not valid java name */
    public static final void m9202markOnScreenCardsAsRead$lambda1(int i11, int i12, ContentCardAdapter contentCardAdapter) {
        Intrinsics.checkNotNullParameter(contentCardAdapter, "this$0");
        contentCardAdapter.notifyItemRangeChanged(i12, (i11 - i12) + 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: onViewDetachedFromWindow$lambda-0  reason: not valid java name */
    public static final void m9203onViewDetachedFromWindow$lambda0(ContentCardAdapter contentCardAdapter, int i11) {
        Intrinsics.checkNotNullParameter(contentCardAdapter, "this$0");
        contentCardAdapter.notifyItemChanged(i11);
    }

    @VisibleForTesting
    @Nullable
    public final Card getCardAtIndex(int i11) {
        if (i11 >= 0 && i11 < this.cardData.size()) {
            return this.cardData.get(i11);
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new ContentCardAdapter$getCardAtIndex$1(i11, this), 7, (Object) null);
        return null;
    }

    @NotNull
    public final List<String> getImpressedCardIds() {
        return CollectionsKt___CollectionsKt.toList(this.impressedCardIdsInternal);
    }

    public int getItemCount() {
        return this.cardData.size();
    }

    public long getItemId(int i11) {
        String id2;
        Card cardAtIndex = getCardAtIndex(i11);
        if (cardAtIndex == null || (id2 = cardAtIndex.getId()) == null) {
            return 0;
        }
        return (long) id2.hashCode();
    }

    public int getItemViewType(int i11) {
        return this.contentCardsViewBindingHandler.getItemViewType(this.context, this.cardData, i11);
    }

    @VisibleForTesting
    public final boolean isAdapterPositionOnScreen(int i11) {
        int min = Math.min(this.layoutManager.findFirstVisibleItemPosition(), this.layoutManager.findFirstCompletelyVisibleItemPosition());
        int max = Math.max(this.layoutManager.findLastVisibleItemPosition(), this.layoutManager.findLastCompletelyVisibleItemPosition());
        if (min > i11 || i11 > max) {
            return false;
        }
        return true;
    }

    public final boolean isControlCardAtPosition(int i11) {
        Card cardAtIndex = getCardAtIndex(i11);
        if (cardAtIndex == null || !cardAtIndex.isControl()) {
            return false;
        }
        return true;
    }

    public boolean isItemDismissable(int i11) {
        if (this.cardData.isEmpty()) {
            return false;
        }
        return this.cardData.get(i11).isDismissibleByUser();
    }

    @VisibleForTesting
    public final void logImpression(@Nullable Card card) {
        if (card != null) {
            if (!this.impressedCardIdsInternal.contains(card.getId())) {
                card.logImpression();
                this.impressedCardIdsInternal.add(card.getId());
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new ContentCardAdapter$logImpression$1(card), 6, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new ContentCardAdapter$logImpression$2(card), 6, (Object) null);
            }
            if (!card.getViewed()) {
                card.setViewed(true);
            }
        }
    }

    public final void markOnScreenCardsAsRead() {
        if (this.cardData.isEmpty()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) ContentCardAdapter$markOnScreenCardsAsRead$1.INSTANCE, 7, (Object) null);
            return;
        }
        int findFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
        int findLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
        if (findFirstVisibleItemPosition < 0 || findLastVisibleItemPosition < 0) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, false, (Function0) new ContentCardAdapter$markOnScreenCardsAsRead$2(findFirstVisibleItemPosition, findLastVisibleItemPosition), 7, (Object) null);
            return;
        }
        if (findFirstVisibleItemPosition <= findLastVisibleItemPosition) {
            int i11 = findFirstVisibleItemPosition;
            while (true) {
                int i12 = i11 + 1;
                Card cardAtIndex = getCardAtIndex(i11);
                if (cardAtIndex != null) {
                    cardAtIndex.setIndicatorHighlighted(true);
                }
                if (i11 == findLastVisibleItemPosition) {
                    break;
                }
                i11 = i12;
            }
        }
        this.handler.post(new b(findLastVisibleItemPosition, findFirstVisibleItemPosition, this));
    }

    public void onItemDismiss(int i11) {
        Card remove = this.cardData.remove(i11);
        remove.setDismissed(true);
        notifyItemRemoved(i11);
        IContentCardsActionListener contentCardsActionListener = BrazeContentCardsManager.Companion.getInstance().getContentCardsActionListener();
        if (contentCardsActionListener != null) {
            contentCardsActionListener.onContentCardDismissed(this.context, remove);
        }
    }

    public final synchronized void replaceCards(@NotNull List<? extends Card> list) {
        Intrinsics.checkNotNullParameter(list, "newCardData");
        DiffUtil.DiffResult calculateDiff = DiffUtil.calculateDiff(new CardListDiffCallback(this.cardData, list));
        Intrinsics.checkNotNullExpressionValue(calculateDiff, "calculateDiff(diffCallback)");
        this.cardData.clear();
        this.cardData.addAll(list);
        calculateDiff.dispatchUpdatesTo((RecyclerView.Adapter) this);
    }

    public final void setImpressedCardIds(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "impressedCardIds");
        this.impressedCardIdsInternal = CollectionsKt___CollectionsKt.toMutableSet(list);
    }

    public void onBindViewHolder(@NotNull ContentCardViewHolder contentCardViewHolder, int i11) {
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "viewHolder");
        this.contentCardsViewBindingHandler.onBindViewHolder(this.context, this.cardData, contentCardViewHolder, i11);
    }

    @NotNull
    public ContentCardViewHolder onCreateViewHolder(@NotNull ViewGroup viewGroup, int i11) {
        Intrinsics.checkNotNullParameter(viewGroup, "viewGroup");
        return this.contentCardsViewBindingHandler.onCreateViewHolder(this.context, this.cardData, viewGroup, i11);
    }

    public void onViewAttachedToWindow(@NotNull ContentCardViewHolder contentCardViewHolder) {
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "holder");
        super.onViewAttachedToWindow(contentCardViewHolder);
        if (!this.cardData.isEmpty()) {
            int bindingAdapterPosition = contentCardViewHolder.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || !isAdapterPositionOnScreen(bindingAdapterPosition)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new ContentCardAdapter$onViewAttachedToWindow$1(bindingAdapterPosition), 6, (Object) null);
                return;
            }
            logImpression(getCardAtIndex(bindingAdapterPosition));
        }
    }

    public void onViewDetachedFromWindow(@NotNull ContentCardViewHolder contentCardViewHolder) {
        Intrinsics.checkNotNullParameter(contentCardViewHolder, "holder");
        super.onViewDetachedFromWindow(contentCardViewHolder);
        if (!this.cardData.isEmpty()) {
            int bindingAdapterPosition = contentCardViewHolder.getBindingAdapterPosition();
            if (bindingAdapterPosition == -1 || !isAdapterPositionOnScreen(bindingAdapterPosition)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.V, (Throwable) null, false, (Function0) new ContentCardAdapter$onViewDetachedFromWindow$1(bindingAdapterPosition), 6, (Object) null);
                return;
            }
            Card cardAtIndex = getCardAtIndex(bindingAdapterPosition);
            if (cardAtIndex != null && !cardAtIndex.isIndicatorHighlighted()) {
                cardAtIndex.setIndicatorHighlighted(true);
                this.handler.post(new a(this, bindingAdapterPosition));
            }
        }
    }
}
