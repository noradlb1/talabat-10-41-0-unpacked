package androidx.paging;

import androidx.annotation.CheckResult;
import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import androidx.paging.PagingSource;
import androidx.paging.ViewportHint;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.talabat.darkstores.feature.main.DarkstoresMainActivity;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u00022\u00020\u0002:\u0001JB\u000f\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000b0/J\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u000b0/J#\u00101\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001022\b\u00103\u001a\u0004\u0018\u000104H\u0000¢\u0006\u0002\b5J\u0014\u00106\u001a\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u00028\u000109J\u001e\u0010:\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u0001092\u0006\u0010;\u001a\u00020\u00122\u0006\u0010<\u001a\u00020\u0013J\u0015\u0010=\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u0012H\u0000¢\u0006\u0002\b>J,\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u000b2\u0006\u0010;\u001a\u00020\u00122\u0012\u0010B\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0007J\u0016\u0010C\u001a\u00020@2\u0006\u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020FJ+\u0010G\u001a\b\u0012\u0004\u0012\u00028\u00010H*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t2\u0006\u0010;\u001a\u00020\u0012H\u0000¢\u0006\u0002\bIR \u0010\u0007\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u001e\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R&\u0010\u001a\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\t0\u001bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR$\u0010\u001f\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b8@@@X\u000e¢\u0006\f\u001a\u0004\b \u0010\u0019\"\u0004\b!\u0010\"R$\u0010#\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u000b8@@@X\u000e¢\u0006\f\u001a\u0004\b$\u0010\u0019\"\u0004\b%\u0010\"R\u000e\u0010&\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010'\u001a\b\u0012\u0004\u0012\u00020\u000b0\u000fX\u0004¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020(2\u0006\u0010\u0016\u001a\u00020(@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u0014\u0010,\u001a\u00020\u000b8@X\u0004¢\u0006\u0006\u001a\u0004\b-\u0010\u0019¨\u0006K"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "(Landroidx/paging/PagingConfig;)V", "_pages", "", "Landroidx/paging/PagingSource$LoadResult$Page;", "_placeholdersAfter", "", "_placeholdersBefore", "appendGenerationId", "appendGenerationIdCh", "Lkotlinx/coroutines/channels/Channel;", "failedHintsByLoadType", "", "Landroidx/paging/LoadType;", "Landroidx/paging/ViewportHint;", "getFailedHintsByLoadType$paging_common", "()Ljava/util/Map;", "<set-?>", "initialPageIndex", "getInitialPageIndex$paging_common", "()I", "pages", "", "getPages$paging_common", "()Ljava/util/List;", "value", "placeholdersAfter", "getPlaceholdersAfter$paging_common", "setPlaceholdersAfter$paging_common", "(I)V", "placeholdersBefore", "getPlaceholdersBefore$paging_common", "setPlaceholdersBefore$paging_common", "prependGenerationId", "prependGenerationIdCh", "Landroidx/paging/LoadStates;", "sourceLoadStates", "getSourceLoadStates$paging_common", "()Landroidx/paging/LoadStates;", "storageCount", "getStorageCount$paging_common", "consumeAppendGenerationIdAsFlow", "Lkotlinx/coroutines/flow/Flow;", "consumePrependGenerationIdAsFlow", "currentPagingState", "Landroidx/paging/PagingState;", "viewportHint", "Landroidx/paging/ViewportHint$Access;", "currentPagingState$paging_common", "drop", "", "event", "Landroidx/paging/PageEvent$Drop;", "dropEventOrNull", "loadType", "hint", "generationId", "generationId$paging_common", "insert", "", "loadId", "page", "setSourceLoadState", "type", "newState", "Landroidx/paging/LoadState;", "toPageEvent", "Landroidx/paging/PageEvent;", "toPageEvent$paging_common", "Holder", "paging-common"}, k = 1, mv = {1, 4, 2})
public final class PageFetcherSnapshotState<Key, Value> {
    private final List<PagingSource.LoadResult.Page<Key, Value>> _pages;
    private int _placeholdersAfter;
    private int _placeholdersBefore;
    /* access modifiers changed from: private */
    public int appendGenerationId;
    /* access modifiers changed from: private */
    public final Channel<Integer> appendGenerationIdCh;
    private final PagingConfig config;
    @NotNull
    private final Map<LoadType, ViewportHint> failedHintsByLoadType;
    private int initialPageIndex;
    @NotNull
    private final List<PagingSource.LoadResult.Page<Key, Value>> pages;
    /* access modifiers changed from: private */
    public int prependGenerationId;
    /* access modifiers changed from: private */
    public final Channel<Integer> prependGenerationIdCh;
    @NotNull
    private LoadStates sourceLoadStates;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000*\b\b\u0002\u0010\u0001*\u00020\u0002*\b\b\u0003\u0010\u0003*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JF\u0010\u000b\u001a\u0002H\f\"\u0004\b\u0004\u0010\f2-\u0010\r\u001a)\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\n¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\t\u0012\u0004\u0012\u0002H\f0\u000eHHø\u0001\u0000¢\u0006\u0002\u0010\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\nX\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Landroidx/paging/PageFetcherSnapshotState$Holder;", "Key", "", "Value", "config", "Landroidx/paging/PagingConfig;", "(Landroidx/paging/PagingConfig;)V", "lock", "Lkotlinx/coroutines/sync/Mutex;", "state", "Landroidx/paging/PageFetcherSnapshotState;", "withLock", "T", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Holder<Key, Value> {
        private final PagingConfig config;
        /* access modifiers changed from: private */
        public final Mutex lock = MutexKt.Mutex$default(false, 1, (Object) null);
        /* access modifiers changed from: private */
        public final PageFetcherSnapshotState<Key, Value> state;

        public Holder(@NotNull PagingConfig pagingConfig) {
            Intrinsics.checkNotNullParameter(pagingConfig, DarkstoresMainActivity.CONFIG_EXTRA_KEY);
            this.config = pagingConfig;
            this.state = new PageFetcherSnapshotState<>(pagingConfig, (DefaultConstructorMarker) null);
        }

        @Nullable
        private final Object withLock$$forInline(@NotNull Function1 function1, @NotNull Continuation continuation) {
            Mutex access$getLock$p = this.lock;
            InlineMarker.mark(0);
            access$getLock$p.lock((Object) null, continuation);
            InlineMarker.mark(2);
            InlineMarker.mark(1);
            try {
                return function1.invoke(this.state);
            } finally {
                InlineMarker.finallyStart(1);
                access$getLock$p.unlock((Object) null);
                InlineMarker.finallyEnd(1);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0040  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <T> java.lang.Object withLock(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function1<? super androidx.paging.PageFetcherSnapshotState<Key, Value>, ? extends T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super T> r7) {
            /*
                r5 = this;
                boolean r0 = r7 instanceof androidx.paging.PageFetcherSnapshotState$Holder$withLock$1
                if (r0 == 0) goto L_0x0013
                r0 = r7
                androidx.paging.PageFetcherSnapshotState$Holder$withLock$1 r0 = (androidx.paging.PageFetcherSnapshotState$Holder$withLock$1) r0
                int r1 = r0.f36835i
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.f36835i = r1
                goto L_0x0018
            L_0x0013:
                androidx.paging.PageFetcherSnapshotState$Holder$withLock$1 r0 = new androidx.paging.PageFetcherSnapshotState$Holder$withLock$1
                r0.<init>(r5, r7)
            L_0x0018:
                java.lang.Object r7 = r0.f36834h
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.f36835i
                r3 = 0
                r4 = 1
                if (r2 == 0) goto L_0x0040
                if (r2 != r4) goto L_0x0038
                java.lang.Object r6 = r0.f36839m
                kotlinx.coroutines.sync.Mutex r6 = (kotlinx.coroutines.sync.Mutex) r6
                java.lang.Object r1 = r0.f36838l
                kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
                java.lang.Object r0 = r0.f36837k
                androidx.paging.PageFetcherSnapshotState$Holder r0 = (androidx.paging.PageFetcherSnapshotState.Holder) r0
                kotlin.ResultKt.throwOnFailure(r7)
                r7 = r6
                r6 = r1
                goto L_0x0057
            L_0x0038:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0040:
                kotlin.ResultKt.throwOnFailure(r7)
                kotlinx.coroutines.sync.Mutex r7 = r5.lock
                r0.f36837k = r5
                r0.f36838l = r6
                r0.f36839m = r7
                r0.f36835i = r4
                java.lang.Object r0 = r7.lock(r3, r0)
                if (r0 != r1) goto L_0x0056
                return r1
            L_0x0056:
                r0 = r5
            L_0x0057:
                androidx.paging.PageFetcherSnapshotState r0 = r0.state     // Catch:{ all -> 0x0069 }
                java.lang.Object r6 = r6.invoke(r0)     // Catch:{ all -> 0x0069 }
                kotlin.jvm.internal.InlineMarker.finallyStart(r4)
                r7.unlock(r3)
                kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
                return r6
            L_0x0069:
                r6 = move-exception
                kotlin.jvm.internal.InlineMarker.finallyStart(r4)
                r7.unlock(r3)
                kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageFetcherSnapshotState.Holder.withLock(kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;
        public static final /* synthetic */ int[] $EnumSwitchMapping$3;
        public static final /* synthetic */ int[] $EnumSwitchMapping$4;
        public static final /* synthetic */ int[] $EnumSwitchMapping$5;
        public static final /* synthetic */ int[] $EnumSwitchMapping$6;
        public static final /* synthetic */ int[] $EnumSwitchMapping$7;
        public static final /* synthetic */ int[] $EnumSwitchMapping$8;

        static {
            int[] iArr = new int[LoadType.values().length];
            $EnumSwitchMapping$0 = iArr;
            LoadType loadType = LoadType.REFRESH;
            iArr[loadType.ordinal()] = 1;
            LoadType loadType2 = LoadType.PREPEND;
            iArr[loadType2.ordinal()] = 2;
            LoadType loadType3 = LoadType.APPEND;
            iArr[loadType3.ordinal()] = 3;
            int[] iArr2 = new int[LoadType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[loadType.ordinal()] = 1;
            iArr2[loadType2.ordinal()] = 2;
            iArr2[loadType3.ordinal()] = 3;
            int[] iArr3 = new int[LoadType.values().length];
            $EnumSwitchMapping$2 = iArr3;
            iArr3[loadType.ordinal()] = 1;
            iArr3[loadType2.ordinal()] = 2;
            iArr3[loadType3.ordinal()] = 3;
            int[] iArr4 = new int[LoadType.values().length];
            $EnumSwitchMapping$3 = iArr4;
            iArr4[loadType.ordinal()] = 1;
            iArr4[loadType2.ordinal()] = 2;
            iArr4[loadType3.ordinal()] = 3;
            int[] iArr5 = new int[LoadType.values().length];
            $EnumSwitchMapping$4 = iArr5;
            iArr5[loadType2.ordinal()] = 1;
            iArr5[loadType3.ordinal()] = 2;
            int[] iArr6 = new int[LoadType.values().length];
            $EnumSwitchMapping$5 = iArr6;
            iArr6[loadType2.ordinal()] = 1;
            int[] iArr7 = new int[LoadType.values().length];
            $EnumSwitchMapping$6 = iArr7;
            iArr7[loadType2.ordinal()] = 1;
            int[] iArr8 = new int[LoadType.values().length];
            $EnumSwitchMapping$7 = iArr8;
            iArr8[loadType2.ordinal()] = 1;
            int[] iArr9 = new int[LoadType.values().length];
            $EnumSwitchMapping$8 = iArr9;
            iArr9[loadType2.ordinal()] = 1;
        }
    }

    private PageFetcherSnapshotState(PagingConfig pagingConfig) {
        this.config = pagingConfig;
        ArrayList arrayList = new ArrayList();
        this._pages = arrayList;
        this.pages = arrayList;
        this.prependGenerationIdCh = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.appendGenerationIdCh = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.failedHintsByLoadType = new LinkedHashMap();
        this.sourceLoadStates = LoadStates.Companion.getIDLE();
    }

    @NotNull
    public final Flow<Integer> consumeAppendGenerationIdAsFlow() {
        return FlowKt.onStart(FlowKt.consumeAsFlow(this.appendGenerationIdCh), new PageFetcherSnapshotState$consumeAppendGenerationIdAsFlow$1(this, (Continuation) null));
    }

    @NotNull
    public final Flow<Integer> consumePrependGenerationIdAsFlow() {
        return FlowKt.onStart(FlowKt.consumeAsFlow(this.prependGenerationIdCh), new PageFetcherSnapshotState$consumePrependGenerationIdAsFlow$1(this, (Continuation) null));
    }

    @NotNull
    public final PagingState<Key, Value> currentPagingState$paging_common(@Nullable ViewportHint.Access access) {
        Integer num;
        int i11;
        List list = CollectionsKt___CollectionsKt.toList(this.pages);
        if (access != null) {
            int placeholdersBefore$paging_common = getPlaceholdersBefore$paging_common();
            int i12 = -this.initialPageIndex;
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(this.pages) - this.initialPageIndex;
            int pageOffset = access.getPageOffset();
            for (int i13 = i12; i13 < pageOffset; i13++) {
                if (i13 > lastIndex) {
                    i11 = this.config.pageSize;
                } else {
                    i11 = this.pages.get(this.initialPageIndex + i13).getData().size();
                }
                placeholdersBefore$paging_common += i11;
            }
            int indexInPage = placeholdersBefore$paging_common + access.getIndexInPage();
            if (access.getPageOffset() < i12) {
                indexInPage -= this.config.pageSize;
            }
            num = Integer.valueOf(indexInPage);
        } else {
            num = null;
        }
        return new PagingState<>(list, num, this.config, getPlaceholdersBefore$paging_common());
    }

    public final void drop(@NotNull PageEvent.Drop<Value> drop) {
        boolean z11;
        Intrinsics.checkNotNullParameter(drop, "event");
        if (drop.getPageCount() <= this.pages.size()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            this.failedHintsByLoadType.remove(drop.getLoadType());
            this.sourceLoadStates = this.sourceLoadStates.modifyState$paging_common(drop.getLoadType(), LoadState.NotLoading.Companion.getIncomplete$paging_common());
            int i11 = WhenMappings.$EnumSwitchMapping$4[drop.getLoadType().ordinal()];
            if (i11 == 1) {
                int pageCount = drop.getPageCount();
                for (int i12 = 0; i12 < pageCount; i12++) {
                    this._pages.remove(0);
                }
                this.initialPageIndex -= drop.getPageCount();
                setPlaceholdersBefore$paging_common(drop.getPlaceholdersRemaining());
                int i13 = this.prependGenerationId + 1;
                this.prependGenerationId = i13;
                this.prependGenerationIdCh.offer(Integer.valueOf(i13));
            } else if (i11 == 2) {
                int pageCount2 = drop.getPageCount();
                for (int i14 = 0; i14 < pageCount2; i14++) {
                    this._pages.remove(this.pages.size() - 1);
                }
                setPlaceholdersAfter$paging_common(drop.getPlaceholdersRemaining());
                int i15 = this.appendGenerationId + 1;
                this.appendGenerationId = i15;
                this.appendGenerationIdCh.offer(Integer.valueOf(i15));
            } else {
                throw new IllegalArgumentException("cannot drop " + drop.getLoadType());
            }
        } else {
            throw new IllegalStateException(("invalid drop count. have " + this.pages.size() + " but wanted to drop " + drop.getPageCount()).toString());
        }
    }

    @Nullable
    public final PageEvent.Drop<Value> dropEventOrNull(@NotNull LoadType loadType, @NotNull ViewportHint viewportHint) {
        boolean z11;
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(viewportHint, ViewHierarchyConstants.HINT_KEY);
        PageEvent.Drop<Value> drop = null;
        if (this.config.maxSize == Integer.MAX_VALUE || this.pages.size() <= 2 || getStorageCount$paging_common() <= this.config.maxSize) {
            return null;
        }
        int i17 = 0;
        if (loadType != LoadType.REFRESH) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int i18 = 0;
            int i19 = 0;
            while (i18 < this.pages.size() && getStorageCount$paging_common() - i19 > this.config.maxSize) {
                if (WhenMappings.$EnumSwitchMapping$5[loadType.ordinal()] != 1) {
                    List<PagingSource.LoadResult.Page<Key, Value>> list = this.pages;
                    i15 = list.get(CollectionsKt__CollectionsKt.getLastIndex(list) - i18).getData().size();
                } else {
                    i15 = this.pages.get(i18).getData().size();
                }
                if (WhenMappings.$EnumSwitchMapping$6[loadType.ordinal()] != 1) {
                    i16 = viewportHint.getPresentedItemsAfter();
                } else {
                    i16 = viewportHint.getPresentedItemsBefore();
                }
                if ((i16 - i19) - i15 < this.config.prefetchDistance) {
                    break;
                }
                i19 += i15;
                i18++;
            }
            if (i18 != 0) {
                if (WhenMappings.$EnumSwitchMapping$7[loadType.ordinal()] != 1) {
                    i11 = (CollectionsKt__CollectionsKt.getLastIndex(this.pages) - this.initialPageIndex) - (i18 - 1);
                } else {
                    i11 = -this.initialPageIndex;
                }
                if (WhenMappings.$EnumSwitchMapping$8[loadType.ordinal()] != 1) {
                    i13 = CollectionsKt__CollectionsKt.getLastIndex(this.pages);
                    i12 = this.initialPageIndex;
                } else {
                    i13 = i18 - 1;
                    i12 = this.initialPageIndex;
                }
                int i21 = i13 - i12;
                if (this.config.enablePlaceholders) {
                    if (loadType == LoadType.PREPEND) {
                        i14 = getPlaceholdersBefore$paging_common();
                    } else {
                        i14 = getPlaceholdersAfter$paging_common();
                    }
                    i17 = i14 + i19;
                }
                drop = new PageEvent.Drop<>(loadType, i11, i21, i17);
            }
            return drop;
        }
        throw new IllegalArgumentException(("Drop LoadType must be PREPEND or APPEND, but got " + loadType).toString());
    }

    public final int generationId$paging_common(@NotNull LoadType loadType) {
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i11 = WhenMappings.$EnumSwitchMapping$0[loadType.ordinal()];
        if (i11 == 1) {
            throw new IllegalArgumentException("Cannot get loadId for loadType: REFRESH");
        } else if (i11 == 2) {
            return this.prependGenerationId;
        } else {
            if (i11 == 3) {
                return this.appendGenerationId;
            }
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public final Map<LoadType, ViewportHint> getFailedHintsByLoadType$paging_common() {
        return this.failedHintsByLoadType;
    }

    public final int getInitialPageIndex$paging_common() {
        return this.initialPageIndex;
    }

    @NotNull
    public final List<PagingSource.LoadResult.Page<Key, Value>> getPages$paging_common() {
        return this.pages;
    }

    public final int getPlaceholdersAfter$paging_common() {
        if (this.config.enablePlaceholders) {
            return this._placeholdersAfter;
        }
        return 0;
    }

    public final int getPlaceholdersBefore$paging_common() {
        if (this.config.enablePlaceholders) {
            return this._placeholdersBefore;
        }
        return 0;
    }

    @NotNull
    public final LoadStates getSourceLoadStates$paging_common() {
        return this.sourceLoadStates;
    }

    public final int getStorageCount$paging_common() {
        int i11 = 0;
        for (PagingSource.LoadResult.Page data : this.pages) {
            i11 += data.getData().size();
        }
        return i11;
    }

    @CheckResult
    public final boolean insert(int i11, @NotNull LoadType loadType, @NotNull PagingSource.LoadResult.Page<Key, Value> page) {
        boolean z11;
        int i12;
        int i13;
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        Intrinsics.checkNotNullParameter(page, "page");
        int i14 = WhenMappings.$EnumSwitchMapping$3[loadType.ordinal()];
        if (i14 != 1) {
            if (i14 != 2) {
                if (i14 == 3) {
                    if (!(!this.pages.isEmpty())) {
                        throw new IllegalStateException("should've received an init before append".toString());
                    } else if (i11 != this.appendGenerationId) {
                        return false;
                    } else {
                        this._pages.add(page);
                        if (page.getItemsAfter() == Integer.MIN_VALUE) {
                            i13 = RangesKt___RangesKt.coerceAtLeast(getPlaceholdersAfter$paging_common() - page.getData().size(), 0);
                        } else {
                            i13 = page.getItemsAfter();
                        }
                        setPlaceholdersAfter$paging_common(i13);
                        this.failedHintsByLoadType.remove(LoadType.APPEND);
                    }
                }
            } else if (!(!this.pages.isEmpty())) {
                throw new IllegalStateException("should've received an init before prepend".toString());
            } else if (i11 != this.prependGenerationId) {
                return false;
            } else {
                this._pages.add(0, page);
                this.initialPageIndex++;
                if (page.getItemsBefore() == Integer.MIN_VALUE) {
                    i12 = RangesKt___RangesKt.coerceAtLeast(getPlaceholdersBefore$paging_common() - page.getData().size(), 0);
                } else {
                    i12 = page.getItemsBefore();
                }
                setPlaceholdersBefore$paging_common(i12);
                this.failedHintsByLoadType.remove(LoadType.PREPEND);
            }
        } else if (this.pages.isEmpty()) {
            if (i11 == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this._pages.add(page);
                this.initialPageIndex = 0;
                setPlaceholdersAfter$paging_common(page.getItemsAfter());
                setPlaceholdersBefore$paging_common(page.getItemsBefore());
            } else {
                throw new IllegalStateException("init loadId must be the initial value, 0".toString());
            }
        } else {
            throw new IllegalStateException("cannot receive multiple init calls".toString());
        }
        return true;
    }

    public final void setPlaceholdersAfter$paging_common(int i11) {
        if (i11 == Integer.MIN_VALUE) {
            i11 = 0;
        }
        this._placeholdersAfter = i11;
    }

    public final void setPlaceholdersBefore$paging_common(int i11) {
        if (i11 == Integer.MIN_VALUE) {
            i11 = 0;
        }
        this._placeholdersBefore = i11;
    }

    public final boolean setSourceLoadState(@NotNull LoadType loadType, @NotNull LoadState loadState) {
        Intrinsics.checkNotNullParameter(loadType, "type");
        Intrinsics.checkNotNullParameter(loadState, "newState");
        if (Intrinsics.areEqual((Object) this.sourceLoadStates.get$paging_common(loadType), (Object) loadState)) {
            return false;
        }
        this.sourceLoadStates = this.sourceLoadStates.modifyState$paging_common(loadType, loadState);
        return true;
    }

    @NotNull
    public final PageEvent<Value> toPageEvent$paging_common(@NotNull PagingSource.LoadResult.Page<Key, Value> page, @NotNull LoadType loadType) {
        Intrinsics.checkNotNullParameter(page, "$this$toPageEvent");
        Intrinsics.checkNotNullParameter(loadType, "loadType");
        int i11 = WhenMappings.$EnumSwitchMapping$1[loadType.ordinal()];
        int i12 = 0;
        if (i11 != 1) {
            if (i11 == 2) {
                i12 = 0 - this.initialPageIndex;
            } else if (i11 == 3) {
                i12 = (this.pages.size() - this.initialPageIndex) - 1;
            } else {
                throw new NoWhenBranchMatchedException();
            }
        }
        List listOf = CollectionsKt__CollectionsJVMKt.listOf(new TransformablePage(i12, page.getData()));
        int i13 = WhenMappings.$EnumSwitchMapping$2[loadType.ordinal()];
        if (i13 == 1) {
            return PageEvent.Insert.Companion.Refresh(listOf, getPlaceholdersBefore$paging_common(), getPlaceholdersAfter$paging_common(), new CombinedLoadStates(this.sourceLoadStates.getRefresh(), this.sourceLoadStates.getPrepend(), this.sourceLoadStates.getAppend(), this.sourceLoadStates, (LoadStates) null));
        }
        if (i13 == 2) {
            return PageEvent.Insert.Companion.Prepend(listOf, getPlaceholdersBefore$paging_common(), new CombinedLoadStates(this.sourceLoadStates.getRefresh(), this.sourceLoadStates.getPrepend(), this.sourceLoadStates.getAppend(), this.sourceLoadStates, (LoadStates) null));
        }
        if (i13 == 3) {
            return PageEvent.Insert.Companion.Append(listOf, getPlaceholdersAfter$paging_common(), new CombinedLoadStates(this.sourceLoadStates.getRefresh(), this.sourceLoadStates.getPrepend(), this.sourceLoadStates.getAppend(), this.sourceLoadStates, (LoadStates) null));
        }
        throw new NoWhenBranchMatchedException();
    }

    public /* synthetic */ PageFetcherSnapshotState(PagingConfig pagingConfig, DefaultConstructorMarker defaultConstructorMarker) {
        this(pagingConfig);
    }
}
