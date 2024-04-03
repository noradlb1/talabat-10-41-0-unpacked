package com.talabat.impressions;

import com.talabat.impressions.ImpressionsItem;
import java.util.ArrayList;
import java.util.HashSet;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B5\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u001c\b\u0002\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\t\u0018\u00010\b¢\u0006\u0002\u0010\nJ\b\u0010\u0015\u001a\u00020\u0016H\u0002J\u001b\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0005¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0002J\b\u0010\u001e\u001a\u00020\u0016H\u0002J.\u0010\u001f\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\t0\fj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\t`\rJ\u001d\u0010 \u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\u001aJ\u0006\u0010!\u001a\u00020\u0016J\u0006\u0010\"\u001a\u00020\u0016J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u0004\u001a\u00020\u0005R9\u0010\u000b\u001a*\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\t0\fj\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\t`\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0006\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00028\u00000\t\u0018\u00010\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u0012X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0013\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0011j\b\u0012\u0004\u0012\u00020\u0005`\u0012X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0011j\b\u0012\u0004\u0012\u00028\u0000`\u0012X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/talabat/impressions/ImpressionRecordable;", "T", "Lcom/talabat/impressions/ImpressionsItem;", "", "scrollingLimit", "", "listTotalSize", "onScrollingSet", "Lcom/talabat/impressions/OnScrollingSet;", "Lkotlin/Pair;", "(IILcom/talabat/impressions/OnScrollingSet;)V", "gaModels", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "getGaModels", "()Ljava/util/ArrayList;", "scrollingSet", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "sessionIdSet", "sessionSet", "addItemsToSessionSet", "", "addScrollSet", "impressionItem", "position", "(Lcom/talabat/impressions/ImpressionsItem;I)V", "allRestaurantsSeen", "", "checkLimitReached", "clearScrollingSet", "getScrollingSetGAModels", "prepareGaModels", "sendRecordedData", "sendRecordedDataAndUpdateSets", "setScrollingLimit", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ImpressionRecordable<T extends ImpressionsItem> {
    @NotNull
    private final ArrayList<Pair<Integer, T>> gaModels;
    private final int listTotalSize;
    @Nullable
    private final OnScrollingSet<Pair<Integer, T>> onScrollingSet;
    private int scrollingLimit;
    @NotNull
    private final HashSet<T> scrollingSet;
    @NotNull
    private final HashSet<Integer> sessionIdSet;
    @NotNull
    private final HashSet<T> sessionSet;

    public ImpressionRecordable(int i11, int i12, @Nullable OnScrollingSet<Pair<Integer, T>> onScrollingSet2) {
        this.scrollingLimit = i11;
        this.listTotalSize = i12;
        this.onScrollingSet = onScrollingSet2;
        this.sessionSet = new HashSet<>();
        this.sessionIdSet = new HashSet<>();
        this.gaModels = new ArrayList<>();
        this.scrollingSet = new HashSet<>();
    }

    private final void addItemsToSessionSet() {
        this.sessionSet.addAll(this.scrollingSet);
    }

    private final boolean allRestaurantsSeen() {
        return this.sessionSet.size() + this.scrollingSet.size() >= this.listTotalSize;
    }

    private final void checkLimitReached() {
        if (this.scrollingSet.size() >= this.scrollingLimit) {
            OnScrollingSet<Pair<Integer, T>> onScrollingSet2 = this.onScrollingSet;
            if (onScrollingSet2 != null) {
                onScrollingSet2.onReachLimit(getScrollingSetGAModels());
            }
            addItemsToSessionSet();
            clearScrollingSet();
        }
    }

    private final void clearScrollingSet() {
        this.scrollingSet.clear();
        this.gaModels.clear();
    }

    private final void prepareGaModels(T t11, int i11) {
        this.gaModels.add(new Pair(Integer.valueOf(i11), t11));
    }

    public final void addScrollSet(@NotNull T t11, int i11) {
        Intrinsics.checkNotNullParameter(t11, "impressionItem");
        if (!CollectionsKt___CollectionsKt.contains(this.sessionIdSet, t11.getId())) {
            Integer id2 = t11.getId();
            if (id2 != null) {
                this.sessionIdSet.add(Integer.valueOf(id2.intValue()));
                this.scrollingSet.add(t11);
                prepareGaModels(t11, i11);
            }
            checkLimitReached();
        }
    }

    @NotNull
    public final ArrayList<Pair<Integer, T>> getGaModels() {
        return this.gaModels;
    }

    @NotNull
    public final ArrayList<Pair<Integer, T>> getScrollingSetGAModels() {
        return this.gaModels;
    }

    public final void sendRecordedData() {
        OnScrollingSet<Pair<Integer, T>> onScrollingSet2;
        ArrayList scrollingSetGAModels = getScrollingSetGAModels();
        if ((!scrollingSetGAModels.isEmpty()) && (onScrollingSet2 = this.onScrollingSet) != null) {
            onScrollingSet2.onReachLimit(scrollingSetGAModels);
        }
    }

    public final void sendRecordedDataAndUpdateSets() {
        ArrayList scrollingSetGAModels = getScrollingSetGAModels();
        if (!scrollingSetGAModels.isEmpty()) {
            OnScrollingSet<Pair<Integer, T>> onScrollingSet2 = this.onScrollingSet;
            if (onScrollingSet2 != null) {
                onScrollingSet2.onReachLimit(scrollingSetGAModels);
            }
            addItemsToSessionSet();
            clearScrollingSet();
        }
    }

    public final void setScrollingLimit(int i11) {
        this.scrollingLimit = i11;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImpressionRecordable(int i11, int i12, OnScrollingSet onScrollingSet2, int i13, DefaultConstructorMarker defaultConstructorMarker) {
        this((i13 & 1) != 0 ? 5 : i11, i12, (i13 & 4) != 0 ? null : onScrollingSet2);
    }
}
