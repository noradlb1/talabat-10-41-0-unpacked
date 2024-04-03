package androidx.paging;

import androidx.paging.LoadState;
import androidx.paging.PageEvent;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u0002H\u00012\u00020\u0002B^\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012L\u0010\u0006\u001aH\b\u0001\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007ø\u0001\u0000¢\u0006\u0002\u0010\rJ\u001a\u00104\u001a\b\u0012\u0004\u0012\u00028\u0000052\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000105J%\u00107\u001a\b\u0012\u0004\u0012\u00028\u0000082\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u000108H@ø\u0001\u0000¢\u0006\u0002\u00109J%\u0010:\u001a\b\u0012\u0004\u0012\u00028\u00000;2\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010;H@ø\u0001\u0000¢\u0006\u0002\u0010<J%\u0010=\u001a\b\u0012\u0004\u0012\u00028\u0000082\f\u00106\u001a\b\u0012\u0004\u0012\u00028\u00010>H@ø\u0001\u0000¢\u0006\u0002\u0010?J&\u0010@\u001a\b\u0012\u0004\u0012\u0002H\u00030#\"\b\b\u0002\u0010\u0003*\u00020\u00022\f\u0010A\u001a\b\u0012\u0004\u0012\u0002H\u00030#H\u0002J\u0016\u0010B\u001a\b\u0012\u0004\u0012\u00028\u00000;*\b\u0012\u0004\u0012\u00028\u00010;J\"\u0010C\u001a\u00020\u000f\"\b\b\u0002\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00030;2\u0006\u0010\u0004\u001a\u00020\u0005J\"\u0010D\u001a\u00020\u000f\"\b\b\u0002\u0010\u0003*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00030;2\u0006\u0010\u0004\u001a\u00020\u0005R\u001a\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\\\u0010\u0006\u001aH\b\u0001\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0015\u0012\u0013\u0018\u00018\u0001¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\f\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0007ø\u0001\u0000¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u001a\u0010\u001a\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u0011\u0010\u001d\u001a\u00020\u001e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001d\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010#0\"¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u001a\u0010&\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020'X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b2\u00103\u0002\u0004\n\u0002\b\u0019¨\u0006E"}, d2 = {"Landroidx/paging/SeparatorState;", "R", "", "T", "terminalSeparatorType", "Landroidx/paging/TerminalSeparatorType;", "generator", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "before", "after", "Lkotlin/coroutines/Continuation;", "(Landroidx/paging/TerminalSeparatorType;Lkotlin/jvm/functions/Function3;)V", "endTerminalSeparatorDeferred", "", "getEndTerminalSeparatorDeferred", "()Z", "setEndTerminalSeparatorDeferred", "(Z)V", "footerAdded", "getFooterAdded", "setFooterAdded", "getGenerator", "()Lkotlin/jvm/functions/Function3;", "Lkotlin/jvm/functions/Function3;", "headerAdded", "getHeaderAdded", "setHeaderAdded", "loadStates", "Landroidx/paging/MutableLoadStateCollection;", "getLoadStates", "()Landroidx/paging/MutableLoadStateCollection;", "pageStash", "", "Landroidx/paging/TransformablePage;", "getPageStash", "()Ljava/util/List;", "placeholdersAfter", "", "getPlaceholdersAfter", "()I", "setPlaceholdersAfter", "(I)V", "placeholdersBefore", "getPlaceholdersBefore", "setPlaceholdersBefore", "startTerminalSeparatorDeferred", "getStartTerminalSeparatorDeferred", "setStartTerminalSeparatorDeferred", "getTerminalSeparatorType", "()Landroidx/paging/TerminalSeparatorType;", "onDrop", "Landroidx/paging/PageEvent$Drop;", "event", "onEvent", "Landroidx/paging/PageEvent;", "(Landroidx/paging/PageEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onInsert", "Landroidx/paging/PageEvent$Insert;", "(Landroidx/paging/PageEvent$Insert;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLoadStateUpdate", "Landroidx/paging/PageEvent$LoadStateUpdate;", "(Landroidx/paging/PageEvent$LoadStateUpdate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "transformablePageToStash", "originalPage", "asRType", "terminatesEnd", "terminatesStart", "paging-common"}, k = 1, mv = {1, 4, 2})
final class SeparatorState<R, T extends R> {
    private boolean endTerminalSeparatorDeferred;
    private boolean footerAdded;
    @NotNull
    private final Function3<T, T, Continuation<? super R>, Object> generator;
    private boolean headerAdded;
    @NotNull
    private final MutableLoadStateCollection loadStates = new MutableLoadStateCollection();
    @NotNull
    private final List<TransformablePage<T>> pageStash = new ArrayList();
    private int placeholdersAfter;
    private int placeholdersBefore;
    private boolean startTerminalSeparatorDeferred;
    @NotNull
    private final TerminalSeparatorType terminalSeparatorType;

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 2})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TerminalSeparatorType.values().length];
            $EnumSwitchMapping$0 = iArr;
            TerminalSeparatorType terminalSeparatorType = TerminalSeparatorType.FULLY_COMPLETE;
            iArr[terminalSeparatorType.ordinal()] = 1;
            TerminalSeparatorType terminalSeparatorType2 = TerminalSeparatorType.SOURCE_COMPLETE;
            iArr[terminalSeparatorType2.ordinal()] = 2;
            int[] iArr2 = new int[TerminalSeparatorType.values().length];
            $EnumSwitchMapping$1 = iArr2;
            iArr2[terminalSeparatorType.ordinal()] = 1;
            iArr2[terminalSeparatorType2.ordinal()] = 2;
        }
    }

    public SeparatorState(@NotNull TerminalSeparatorType terminalSeparatorType2, @NotNull Function3<? super T, ? super T, ? super Continuation<? super R>, ? extends Object> function3) {
        Intrinsics.checkNotNullParameter(terminalSeparatorType2, "terminalSeparatorType");
        Intrinsics.checkNotNullParameter(function3, "generator");
        this.terminalSeparatorType = terminalSeparatorType2;
        this.generator = function3;
    }

    private final <T> TransformablePage<T> transformablePageToStash(TransformablePage<T> transformablePage) {
        int i11;
        int i12;
        Integer num;
        Integer num2;
        int[] originalPageOffsets = transformablePage.getOriginalPageOffsets();
        List listOf = CollectionsKt__CollectionsKt.listOf(CollectionsKt___CollectionsKt.first(transformablePage.getData()), CollectionsKt___CollectionsKt.last(transformablePage.getData()));
        int hintOriginalPageOffset = transformablePage.getHintOriginalPageOffset();
        Integer[] numArr = new Integer[2];
        List<Integer> hintOriginalIndices = transformablePage.getHintOriginalIndices();
        if (hintOriginalIndices == null || (num2 = (Integer) CollectionsKt___CollectionsKt.first(hintOriginalIndices)) == null) {
            i11 = 0;
        } else {
            i11 = num2.intValue();
        }
        numArr[0] = Integer.valueOf(i11);
        List<Integer> hintOriginalIndices2 = transformablePage.getHintOriginalIndices();
        if (hintOriginalIndices2 == null || (num = (Integer) CollectionsKt___CollectionsKt.last(hintOriginalIndices2)) == null) {
            i12 = CollectionsKt__CollectionsKt.getLastIndex(transformablePage.getData());
        } else {
            i12 = num.intValue();
        }
        numArr[1] = Integer.valueOf(i12);
        return new TransformablePage<>(originalPageOffsets, listOf, hintOriginalPageOffset, CollectionsKt__CollectionsKt.listOf(numArr));
    }

    @NotNull
    public final PageEvent.Insert<R> asRType(@NotNull PageEvent.Insert<T> insert) {
        Intrinsics.checkNotNullParameter(insert, "$this$asRType");
        return insert;
    }

    public final boolean getEndTerminalSeparatorDeferred() {
        return this.endTerminalSeparatorDeferred;
    }

    public final boolean getFooterAdded() {
        return this.footerAdded;
    }

    @NotNull
    public final Function3<T, T, Continuation<? super R>, Object> getGenerator() {
        return this.generator;
    }

    public final boolean getHeaderAdded() {
        return this.headerAdded;
    }

    @NotNull
    public final MutableLoadStateCollection getLoadStates() {
        return this.loadStates;
    }

    @NotNull
    public final List<TransformablePage<T>> getPageStash() {
        return this.pageStash;
    }

    public final int getPlaceholdersAfter() {
        return this.placeholdersAfter;
    }

    public final int getPlaceholdersBefore() {
        return this.placeholdersBefore;
    }

    public final boolean getStartTerminalSeparatorDeferred() {
        return this.startTerminalSeparatorDeferred;
    }

    @NotNull
    public final TerminalSeparatorType getTerminalSeparatorType() {
        return this.terminalSeparatorType;
    }

    @NotNull
    public final PageEvent.Drop<R> onDrop(@NotNull PageEvent.Drop<T> drop) {
        Intrinsics.checkNotNullParameter(drop, "event");
        this.loadStates.set(drop.getLoadType(), false, LoadState.NotLoading.Companion.getIncomplete$paging_common());
        LoadType loadType = drop.getLoadType();
        LoadType loadType2 = LoadType.PREPEND;
        if (loadType == loadType2) {
            this.placeholdersBefore = drop.getPlaceholdersRemaining();
            this.headerAdded = false;
        } else if (drop.getLoadType() == LoadType.APPEND) {
            this.placeholdersAfter = drop.getPlaceholdersRemaining();
            this.footerAdded = false;
        }
        if (this.pageStash.isEmpty()) {
            if (drop.getLoadType() == loadType2) {
                this.startTerminalSeparatorDeferred = false;
            } else {
                this.endTerminalSeparatorDeferred = false;
            }
        }
        boolean unused = CollectionsKt__MutableCollectionsKt.removeAll(this.pageStash, new SeparatorState$onDrop$1(new IntRange(drop.getMinPageOffset(), drop.getMaxPageOffset())));
        return drop;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onEvent(@org.jetbrains.annotations.NotNull androidx.paging.PageEvent<T> r6, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.paging.SeparatorState$onEvent$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.paging.SeparatorState$onEvent$1 r0 = (androidx.paging.SeparatorState$onEvent$1) r0
            int r1 = r0.f37091i
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f37091i = r1
            goto L_0x0018
        L_0x0013:
            androidx.paging.SeparatorState$onEvent$1 r0 = new androidx.paging.SeparatorState$onEvent$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f37090h
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f37091i
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r6 = r0.f37093k
            androidx.paging.SeparatorState r6 = (androidx.paging.SeparatorState) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0076
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            java.lang.Object r6 = r0.f37093k
            androidx.paging.SeparatorState r6 = (androidx.paging.SeparatorState) r6
            kotlin.ResultKt.throwOnFailure(r7)
            goto L_0x0055
        L_0x0040:
            kotlin.ResultKt.throwOnFailure(r7)
            boolean r7 = r6 instanceof androidx.paging.PageEvent.Insert
            if (r7 == 0) goto L_0x0058
            androidx.paging.PageEvent$Insert r6 = (androidx.paging.PageEvent.Insert) r6
            r0.f37093k = r5
            r0.f37091i = r4
            java.lang.Object r7 = r5.onInsert(r6, r0)
            if (r7 != r1) goto L_0x0054
            return r1
        L_0x0054:
            r6 = r5
        L_0x0055:
            androidx.paging.PageEvent r7 = (androidx.paging.PageEvent) r7
            goto L_0x0078
        L_0x0058:
            boolean r7 = r6 instanceof androidx.paging.PageEvent.Drop
            if (r7 == 0) goto L_0x0064
            androidx.paging.PageEvent$Drop r6 = (androidx.paging.PageEvent.Drop) r6
            androidx.paging.PageEvent$Drop r7 = r5.onDrop(r6)
            r6 = r5
            goto L_0x0078
        L_0x0064:
            boolean r7 = r6 instanceof androidx.paging.PageEvent.LoadStateUpdate
            if (r7 == 0) goto L_0x00ab
            androidx.paging.PageEvent$LoadStateUpdate r6 = (androidx.paging.PageEvent.LoadStateUpdate) r6
            r0.f37093k = r5
            r0.f37091i = r3
            java.lang.Object r7 = r5.onLoadStateUpdate(r6, r0)
            if (r7 != r1) goto L_0x0075
            return r1
        L_0x0075:
            r6 = r5
        L_0x0076:
            androidx.paging.PageEvent r7 = (androidx.paging.PageEvent) r7
        L_0x0078:
            boolean r0 = r6.endTerminalSeparatorDeferred
            if (r0 == 0) goto L_0x0091
            java.util.List<androidx.paging.TransformablePage<T>> r0 = r6.pageStash
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0085
            goto L_0x0091
        L_0x0085:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "deferred endTerm, page stash should be empty"
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x0091:
            boolean r0 = r6.startTerminalSeparatorDeferred
            if (r0 == 0) goto L_0x00aa
            java.util.List<androidx.paging.TransformablePage<T>> r6 = r6.pageStash
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x009e
            goto L_0x00aa
        L_0x009e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "deferred startTerm, page stash should be empty"
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x00aa:
            return r7
        L_0x00ab:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.onEvent(androidx.paging.PageEvent, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v1, resolved type: java.util.ArrayList} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v36, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v12, resolved type: androidx.paging.TransformablePage} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: int[]} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v34, resolved type: java.util.ArrayList} */
    /* JADX WARNING: type inference failed for: r4v19, types: [int, boolean] */
    /* JADX WARNING: type inference failed for: r5v35 */
    /* JADX WARNING: type inference failed for: r4v21 */
    /* JADX WARNING: type inference failed for: r4v22 */
    /* JADX WARNING: type inference failed for: r5v36 */
    /* JADX WARNING: Code restructure failed: missing block: B:119:0x0400, code lost:
        r9 = r8.getHintOriginalPageOffset();
        r10 = r8.getHintOriginalIndices();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0409, code lost:
        if (r10 == null) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x040b, code lost:
        r10 = (java.lang.Integer) kotlin.collections.CollectionsKt___CollectionsKt.first(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0411, code lost:
        if (r10 == null) goto L_0x0418;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:123:0x0413, code lost:
        r10 = r10.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0418, code lost:
        r10 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:125:0x0419, code lost:
        androidx.paging.SeparatorsKt.addSeparatorPage(r5, r6, (androidx.paging.TransformablePage) null, r8, r9, r10);
        r6 = r1;
        r5 = r2;
        r10 = r12;
        r9 = r13;
        r8 = r15;
        r12 = r18;
        r7 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0429, code lost:
        if (r6 != 0) goto L_0x07ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x042b, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r9);
        r1 = r9.intValue();
        r2 = r5;
        r13 = r14;
        r14 = r20;
        r5 = 0;
        r27 = r12;
        r12 = r7;
        r7 = r11;
        r11 = r27;
        r28 = r10;
        r10 = r8;
        r8 = r28;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0442, code lost:
        if (r5 >= r1) goto L_0x048f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0444, code lost:
        r0 = r14.generator;
        r3.f37097k = r14;
        r3.f37098l = r13;
        r3.f37099m = r12;
        r3.f37100n = r11;
        r3.f37101o = r10;
        r3.f37102p = r9;
        r3.f37103q = r8;
        r3.f37104r = r7;
        r3.f37105s = r12;
        r18 = r7;
        r3.f37106t = null;
        r3.f37107u = r2;
        r3.f37108v = r6;
        r3.f37109w = r5;
        r3.f37110x = r1;
        r3.f37095i = 3;
        r0 = androidx.paging.SeparatorsKt.insertInternalSeparators(r13.getPages().get(r5), r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0476, code lost:
        if (r0 != r4) goto L_0x0479;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0478, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:133:0x0479, code lost:
        r7 = r2;
        r2 = r0;
        r0 = r14;
        r14 = r12;
        r12 = r10;
        r10 = r8;
        r8 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x0480, code lost:
        r8.add(r2);
        r5 = r5 + 1;
        r2 = r7;
        r8 = r10;
        r10 = r12;
        r12 = r14;
        r7 = r18;
        r14 = r0;
        r0 = r29;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x048f, code lost:
        r18 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:136:0x0498, code lost:
        if (r13.getLoadType() != androidx.paging.LoadType.APPEND) goto L_0x0527;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:138:0x04a3, code lost:
        if ((!r14.pageStash.isEmpty()) == false) goto L_0x0527;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x04a5, code lost:
        r0 = (androidx.paging.TransformablePage) kotlin.collections.CollectionsKt___CollectionsKt.last(r14.pageStash);
        r1 = r14.generator;
        r5 = kotlin.collections.CollectionsKt___CollectionsKt.last(r0.getData());
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r7 = kotlin.collections.CollectionsKt___CollectionsKt.first(r10.getData());
        r3.f37097k = r14;
        r3.f37098l = r13;
        r3.f37099m = r12;
        r3.f37100n = r11;
        r3.f37101o = r10;
        r3.f37102p = r9;
        r3.f37103q = r8;
        r15 = r18;
        r3.f37104r = r15;
        r3.f37105s = r0;
        r30 = r0;
        r3.f37106t = null;
        r3.f37107u = r2;
        r3.f37108v = r6;
        r3.f37095i = 4;
        r0 = r1.invoke(r5, r7, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x009a, code lost:
        r0 = r3;
        r8 = r4;
        r15 = r14;
        r3 = r2;
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r10;
        r10 = r9;
        r9 = r5;
        r5 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:140:0x04e6, code lost:
        if (r0 != r4) goto L_0x04e9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:141:0x04e8, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:142:0x04e9, code lost:
        r1 = r6;
        r18 = r13;
        r19 = r14;
        r13 = r11;
        r14 = r12;
        r11 = r9;
        r12 = r10;
        r9 = r2;
        r10 = r8;
        r8 = r4;
        r4 = r30;
        r27 = r3;
        r3 = r0;
        r0 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:143:0x04fc, code lost:
        r6 = r12.getHintOriginalPageOffset();
        r2 = r12.getHintOriginalIndices();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:144:0x0504, code lost:
        if (r2 == null) goto L_0x0514;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:145:0x0506, code lost:
        r2 = (java.lang.Integer) kotlin.collections.CollectionsKt___CollectionsKt.first(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:146:0x050c, code lost:
        if (r2 == null) goto L_0x0514;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:147:0x050e, code lost:
        r7 = r2.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:148:0x0514, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:149:0x0515, code lost:
        androidx.paging.SeparatorsKt.addSeparatorPage(r14, r3, r4, r12, r6, r7);
        r3 = r0;
        r4 = r8;
        r5 = r9;
        r8 = r10;
        r9 = r11;
        r10 = r13;
        r6 = r14;
        r7 = r15;
        r13 = r18;
        r14 = r19;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0527, code lost:
        r5 = r2;
        r1 = r6;
        r6 = r12;
        r7 = r18;
        r12 = r10;
        r10 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x052f, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r12);
        r10.add(r14.transformablePageToStash(r12));
        r0 = r14.generator;
        r3.f37097k = r14;
        r3.f37098l = r13;
        r3.f37099m = r6;
        r3.f37100n = r10;
        r3.f37101o = r9;
        r3.f37102p = r8;
        r3.f37103q = r7;
        r3.f37104r = r6;
        r3.f37105s = null;
        r3.f37106t = null;
        r3.f37107u = r5;
        r3.f37108v = r1;
        r3.f37095i = 5;
        r2 = androidx.paging.SeparatorsKt.insertInternalSeparators(r12, r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:152:0x055b, code lost:
        if (r2 != r4) goto L_0x055e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:153:0x055d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:154:0x055e, code lost:
        r11 = r6;
        r12 = r13;
        r13 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:155:0x0561, code lost:
        r6.add(r2);
        r0 = r12.getPages();
        r2 = r9.intValue();
        kotlin.jvm.internal.Intrinsics.checkNotNull(r7);
        r0 = r0.subList(r2, r7.intValue() + 1).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:156:0x0583, code lost:
        if (r0.hasNext() == false) goto L_0x07a6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:157:0x0585, code lost:
        r2 = r0.next();
        r9 = r7;
        r14 = r13;
        r13 = r12;
        r12 = r11;
        r11 = r10;
        r10 = r8;
        r8 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:159:0x0594, code lost:
        if (r8.hasNext() == false) goto L_0x06bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x00d6, code lost:
        r0 = r8;
        r8 = r11;
        r11 = r14;
        r14 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:160:0x0596, code lost:
        r7 = r8.next();
        r6 = (androidx.paging.TransformablePage) r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:161:0x05ac, code lost:
        if ((!r7.getData().isEmpty()) == false) goto L_0x0656;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:162:0x05ae, code lost:
        r0 = r14.generator;
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.last(r6.getData());
        r15 = kotlin.collections.CollectionsKt___CollectionsKt.first(r7.getData());
        r3.f37097k = r14;
        r3.f37098l = r13;
        r3.f37099m = r12;
        r3.f37100n = r11;
        r3.f37101o = r10;
        r3.f37102p = r9;
        r3.f37103q = r8;
        r3.f37104r = r7;
        r3.f37105s = r6;
        r30 = r6;
        r3.f37106t = null;
        r3.f37107u = r5;
        r3.f37108v = r1;
        r3.f37095i = 6;
        r2 = r0.invoke(r2, r15, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:163:0x05e2, code lost:
        if (r2 != r4) goto L_0x05e5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:164:0x05e4, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x05e5, code lost:
        r0 = r3;
        r15 = r11;
        r18 = r12;
        r19 = r13;
        r20 = r14;
        r3 = r2;
        r11 = r7;
        r12 = r8;
        r13 = r9;
        r14 = r10;
        r10 = r30;
        r8 = r4;
        r9 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:166:0x05f6, code lost:
        r2 = r19.getLoadType();
        r4 = androidx.paging.LoadType.PREPEND;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:167:0x05fc, code lost:
        if (r2 != r4) goto L_0x0603;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:168:0x05fe, code lost:
        r2 = r10.getHintOriginalPageOffset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:169:0x0603, code lost:
        r2 = r11.getHintOriginalPageOffset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:170:0x0607, code lost:
        r6 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x060c, code lost:
        if (r19.getLoadType() != r4) goto L_0x062b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:172:0x060e, code lost:
        r2 = r10.getHintOriginalIndices();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:173:0x0612, code lost:
        if (r2 == null) goto L_0x0621;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:174:0x0614, code lost:
        r2 = (java.lang.Integer) kotlin.collections.CollectionsKt___CollectionsKt.last(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x061a, code lost:
        if (r2 == null) goto L_0x0621;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x061c, code lost:
        r4 = r2.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x0621, code lost:
        r4 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r10.getData());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:178:0x0629, code lost:
        r7 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x062b, code lost:
        r2 = r11.getHintOriginalIndices();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x062f, code lost:
        if (r2 == null) goto L_0x063e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x0631, code lost:
        r2 = (java.lang.Integer) kotlin.collections.CollectionsKt___CollectionsKt.first(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0637, code lost:
        if (r2 == null) goto L_0x063e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0639, code lost:
        r4 = r2.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:184:0x063e, code lost:
        r7 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x063f, code lost:
        androidx.paging.SeparatorsKt.addSeparatorPage(r18, r3, r10, r11, r6, r7);
        r3 = r0;
        r4 = r8;
        r5 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
        r6 = r18;
        r8 = r19;
        r7 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:186:0x0656, code lost:
        r30 = r6;
        r6 = r12;
        r12 = r9;
        r9 = r30;
        r27 = r10;
        r10 = r7;
        r7 = r14;
        r14 = r11;
        r11 = r8;
        r8 = r13;
        r13 = r27;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:188:0x0671, code lost:
        if ((!r10.getData().isEmpty()) == false) goto L_0x067a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x0673, code lost:
        r14.add(r7.transformablePageToStash(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:190:0x067a, code lost:
        r0 = r7.generator;
        r3.f37097k = r7;
        r3.f37098l = r8;
        r3.f37099m = r6;
        r3.f37100n = r14;
        r3.f37101o = r13;
        r3.f37102p = r12;
        r3.f37103q = r11;
        r3.f37104r = r10;
        r3.f37105s = r9;
        r3.f37106t = r6;
        r3.f37107u = r5;
        r3.f37108v = r1;
        r3.f37095i = 7;
        r2 = androidx.paging.SeparatorsKt.insertInternalSeparators(r10, r0, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:0x069b, code lost:
        if (r2 != r4) goto L_0x069e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:192:0x069d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:0x069e, code lost:
        r15 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x06a1, code lost:
        r6.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x06b0, code lost:
        if ((!r10.getData().isEmpty()) == false) goto L_0x06b4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x06b2, code lost:
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x06b4, code lost:
        r2 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x06b5, code lost:
        r9 = r12;
        r10 = r13;
        r12 = r15;
        r13 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x06c1, code lost:
        if (r13.getLoadType() != androidx.paging.LoadType.PREPEND) goto L_0x0741;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x06cd, code lost:
        if ((!r14.pageStash.isEmpty()) == false) goto L_0x0741;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x06cf, code lost:
        r6 = (androidx.paging.TransformablePage) kotlin.collections.CollectionsKt___CollectionsKt.first(r14.pageStash);
        r0 = r14.generator;
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r2 = kotlin.collections.CollectionsKt___CollectionsKt.last(r10.getData());
        r7 = kotlin.collections.CollectionsKt___CollectionsKt.first(r6.getData());
        r3.f37097k = r14;
        r3.f37098l = r13;
        r3.f37099m = r12;
        r3.f37100n = r11;
        r3.f37101o = r10;
        r3.f37102p = r9;
        r3.f37103q = r6;
        r3.f37104r = null;
        r3.f37105s = null;
        r3.f37106t = null;
        r3.f37107u = r5;
        r3.f37108v = r1;
        r3.f37095i = 8;
        r2 = r0.invoke(r2, r7, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x070e, code lost:
        if (r2 != r4) goto L_0x009a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x0710, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x0711, code lost:
        r6 = r11.getHintOriginalPageOffset();
        r2 = r11.getHintOriginalIndices();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x0719, code lost:
        if (r2 == null) goto L_0x0728;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x071b, code lost:
        r2 = (java.lang.Integer) kotlin.collections.CollectionsKt___CollectionsKt.last(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:209:0x0721, code lost:
        if (r2 == null) goto L_0x0728;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:210:0x0723, code lost:
        r2 = r2.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:211:0x0728, code lost:
        r2 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r11.getData());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:212:0x0730, code lost:
        androidx.paging.SeparatorsKt.addSeparatorPage(r13, r3, r11, r5, r6, r2);
        r3 = r0;
        r6 = r1;
        r4 = r8;
        r5 = r9;
        r9 = r10;
        r10 = r11;
        r11 = r12;
        r12 = r13;
        r13 = r14;
        r14 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:213:0x0741, code lost:
        r6 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x0742, code lost:
        r0 = r9.intValue() + 1;
        r1 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r13.getPages());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x0750, code lost:
        if (r0 > r1) goto L_0x07a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:216:0x0752, code lost:
        r9 = r6;
        r15 = r13;
        r6 = r14;
        r13 = r11;
        r11 = r12;
        r12 = r10;
        r10 = r5;
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:217:0x075a, code lost:
        r2 = r6.generator;
        r3.f37097k = r6;
        r3.f37098l = r15;
        r3.f37099m = r11;
        r3.f37100n = r13;
        r3.f37101o = r12;
        r3.f37102p = r11;
        r3.f37103q = null;
        r3.f37104r = null;
        r3.f37105s = null;
        r3.f37106t = null;
        r3.f37107u = r10;
        r3.f37108v = r9;
        r3.f37109w = r5;
        r3.f37110x = r1;
        r3.f37095i = 9;
        r2 = androidx.paging.SeparatorsKt.insertInternalSeparators(r15.getPages().get(r5), r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:218:0x078b, code lost:
        if (r2 != r4) goto L_0x078e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:219:0x078d, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x078e, code lost:
        r14 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x078f, code lost:
        r11.add(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:222:0x0792, code lost:
        if (r5 == r1) goto L_0x0798;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:223:0x0794, code lost:
        r5 = r5 + 1;
        r11 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:224:0x0798, code lost:
        r0 = r3;
        r3 = r6;
        r6 = r9;
        r5 = r10;
        r10 = r12;
        r1 = r14;
        r8 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:225:0x07a0, code lost:
        r0 = r3;
        r1 = r12;
        r8 = r13;
        r3 = r14;
        r13 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:227:0x07ad, code lost:
        throw new java.lang.UnsupportedOperationException("Empty collection can't be reduced.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:228:0x07ae, code lost:
        r0 = r3;
        r1 = r7;
        r13 = r12;
        r8 = r14;
        r3 = r20;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:0x07b4, code lost:
        if (r5 == false) goto L_0x0826;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:231:0x07b8, code lost:
        if (r3.footerAdded != false) goto L_0x0826;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x07ba, code lost:
        r3.footerAdded = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:233:0x07bd, code lost:
        if (r6 == 0) goto L_0x07c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:234:0x07bf, code lost:
        r2 = (androidx.paging.TransformablePage) kotlin.collections.CollectionsKt___CollectionsKt.last(r3.pageStash);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:235:0x07c8, code lost:
        kotlin.jvm.internal.Intrinsics.checkNotNull(r10);
        r2 = r10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:236:0x07cc, code lost:
        r5 = r3.generator;
        r6 = kotlin.collections.CollectionsKt___CollectionsKt.last(r2.getData());
        r0.f37097k = r3;
        r0.f37098l = r8;
        r0.f37099m = r1;
        r0.f37100n = r13;
        r0.f37101o = r2;
        r0.f37102p = r1;
        r0.f37103q = null;
        r0.f37104r = null;
        r0.f37105s = null;
        r0.f37106t = null;
        r0.f37095i = 10;
        r0 = r5.invoke(r6, null, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x07f3, code lost:
        if (r0 != r4) goto L_0x07f6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x07f5, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x07f6, code lost:
        r15 = r0;
        r7 = r1;
        r14 = r7;
        r16 = r2;
        r5 = r13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x07fc, code lost:
        r18 = r16.getHintOriginalPageOffset();
        r0 = r16.getHintOriginalIndices();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0806, code lost:
        if (r0 == null) goto L_0x0815;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:242:0x0808, code lost:
        r0 = (java.lang.Integer) kotlin.collections.CollectionsKt___CollectionsKt.last(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:243:0x080e, code lost:
        if (r0 == null) goto L_0x0815;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:0x0810, code lost:
        r0 = r0.intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:245:0x0815, code lost:
        r0 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r16.getData());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:246:0x081d, code lost:
        androidx.paging.SeparatorsKt.addSeparatorPage(r14, r15, r16, (androidx.paging.TransformablePage) null, r18, r0);
        r13 = r5;
        r22 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:247:0x0826, code lost:
        r22 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:248:0x0828, code lost:
        r3.endTerminalSeparatorDeferred = false;
        r3.startTerminalSeparatorDeferred = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:249:0x0833, code lost:
        if (r8.getLoadType() != androidx.paging.LoadType.APPEND) goto L_0x083b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:250:0x0835, code lost:
        r3.pageStash.addAll(r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x083b, code lost:
        r3.pageStash.addAll(0, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:252:0x0840, code lost:
        r21 = r8.getLoadType();
        r8.getPages();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:253:0x085c, code lost:
        return new androidx.paging.PageEvent.Insert(r21, r22, r8.getPlaceholdersBefore(), r8.getPlaceholdersAfter(), r8.getCombinedLoadStates(), (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:264:?, code lost:
        return new androidx.paging.PageEvent.Insert(r3, kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(androidx.paging.SeparatorsKt.separatorPage(r2, r5, r4, r4)), r1.getPlaceholdersBefore(), r1.getPlaceholdersAfter(), r1.getCombinedLoadStates(), (kotlin.jvm.internal.DefaultConstructorMarker) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:265:?, code lost:
        return r3.asRType(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x02dd, code lost:
        r3.endTerminalSeparatorDeferred = r4;
        r3.startTerminalSeparatorDeferred = r4;
        r3.headerAdded = r5;
        r3.footerAdded = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x02e5, code lost:
        if (r2 != null) goto L_0x02ec;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x02ec, code lost:
        r3 = r1.getLoadType();
        r1.getPages();
        r5 = new int[r5];
        r5[r4] = r4;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r5v29, types: [int, boolean] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0077  */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0142  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x017e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x01b9  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x01fb  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x020a  */
    /* JADX WARNING: Removed duplicated region for block: B:256:0x0869  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0265  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object onInsert(@org.jetbrains.annotations.NotNull androidx.paging.PageEvent.Insert<T> r30, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.paging.PageEvent.Insert<R>> r31) {
        /*
            r29 = this;
            r0 = r29
            r1 = r30
            r2 = r31
            boolean r3 = r2 instanceof androidx.paging.SeparatorState$onInsert$1
            if (r3 == 0) goto L_0x0019
            r3 = r2
            androidx.paging.SeparatorState$onInsert$1 r3 = (androidx.paging.SeparatorState$onInsert$1) r3
            int r4 = r3.f37095i
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            r6 = r4 & r5
            if (r6 == 0) goto L_0x0019
            int r4 = r4 - r5
            r3.f37095i = r4
            goto L_0x001e
        L_0x0019:
            androidx.paging.SeparatorState$onInsert$1 r3 = new androidx.paging.SeparatorState$onInsert$1
            r3.<init>(r0, r2)
        L_0x001e:
            java.lang.Object r2 = r3.f37094h
            java.lang.Object r4 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r5 = r3.f37095i
            switch(r5) {
                case 0: goto L_0x020a;
                case 1: goto L_0x01fb;
                case 2: goto L_0x01b9;
                case 3: goto L_0x017e;
                case 4: goto L_0x0142;
                case 5: goto L_0x0119;
                case 6: goto L_0x00dc;
                case 7: goto L_0x00a7;
                case 8: goto L_0x0077;
                case 9: goto L_0x0052;
                case 10: goto L_0x0031;
                default: goto L_0x0029;
            }
        L_0x0029:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L_0x0031:
            java.lang.Object r1 = r3.f37102p
            java.util.List r1 = (java.util.List) r1
            java.lang.Object r4 = r3.f37101o
            androidx.paging.TransformablePage r4 = (androidx.paging.TransformablePage) r4
            java.lang.Object r5 = r3.f37100n
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            java.lang.Object r7 = r3.f37099m
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            java.lang.Object r8 = r3.f37098l
            androidx.paging.PageEvent$Insert r8 = (androidx.paging.PageEvent.Insert) r8
            java.lang.Object r3 = r3.f37097k
            androidx.paging.SeparatorState r3 = (androidx.paging.SeparatorState) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r14 = r1
            r15 = r2
            r16 = r4
            goto L_0x07fc
        L_0x0052:
            int r1 = r3.f37110x
            int r5 = r3.f37109w
            int r9 = r3.f37108v
            boolean r10 = r3.f37107u
            java.lang.Object r11 = r3.f37102p
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            java.lang.Object r12 = r3.f37101o
            androidx.paging.TransformablePage r12 = (androidx.paging.TransformablePage) r12
            java.lang.Object r13 = r3.f37100n
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Object r14 = r3.f37099m
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            java.lang.Object r15 = r3.f37098l
            androidx.paging.PageEvent$Insert r15 = (androidx.paging.PageEvent.Insert) r15
            java.lang.Object r6 = r3.f37097k
            androidx.paging.SeparatorState r6 = (androidx.paging.SeparatorState) r6
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x078f
        L_0x0077:
            int r1 = r3.f37108v
            boolean r5 = r3.f37107u
            java.lang.Object r6 = r3.f37103q
            androidx.paging.TransformablePage r6 = (androidx.paging.TransformablePage) r6
            java.lang.Object r9 = r3.f37102p
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.f37101o
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.f37100n
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            java.lang.Object r12 = r3.f37099m
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r3.f37098l
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            java.lang.Object r14 = r3.f37097k
            androidx.paging.SeparatorState r14 = (androidx.paging.SeparatorState) r14
            kotlin.ResultKt.throwOnFailure(r2)
        L_0x009a:
            r0 = r3
            r8 = r4
            r15 = r14
            r3 = r2
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r9
            r9 = r5
            r5 = r6
            goto L_0x0711
        L_0x00a7:
            int r1 = r3.f37108v
            boolean r5 = r3.f37107u
            java.lang.Object r6 = r3.f37106t
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.lang.Object r9 = r3.f37105s
            androidx.paging.TransformablePage r9 = (androidx.paging.TransformablePage) r9
            java.lang.Object r10 = r3.f37104r
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.f37103q
            java.util.Iterator r11 = (java.util.Iterator) r11
            java.lang.Object r12 = r3.f37102p
            java.lang.Integer r12 = (java.lang.Integer) r12
            java.lang.Object r13 = r3.f37101o
            androidx.paging.TransformablePage r13 = (androidx.paging.TransformablePage) r13
            java.lang.Object r14 = r3.f37100n
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            java.lang.Object r15 = r3.f37099m
            java.util.ArrayList r15 = (java.util.ArrayList) r15
            java.lang.Object r8 = r3.f37098l
            androidx.paging.PageEvent$Insert r8 = (androidx.paging.PageEvent.Insert) r8
            java.lang.Object r7 = r3.f37097k
            androidx.paging.SeparatorState r7 = (androidx.paging.SeparatorState) r7
            kotlin.ResultKt.throwOnFailure(r2)
        L_0x00d6:
            r0 = r8
            r8 = r11
            r11 = r14
            r14 = r7
            goto L_0x06a1
        L_0x00dc:
            int r1 = r3.f37108v
            boolean r5 = r3.f37107u
            java.lang.Object r6 = r3.f37105s
            androidx.paging.TransformablePage r6 = (androidx.paging.TransformablePage) r6
            java.lang.Object r7 = r3.f37104r
            androidx.paging.TransformablePage r7 = (androidx.paging.TransformablePage) r7
            java.lang.Object r8 = r3.f37103q
            java.util.Iterator r8 = (java.util.Iterator) r8
            java.lang.Object r9 = r3.f37102p
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.f37101o
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.f37100n
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            java.lang.Object r12 = r3.f37099m
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r3.f37098l
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            java.lang.Object r14 = r3.f37097k
            androidx.paging.SeparatorState r14 = (androidx.paging.SeparatorState) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r0 = r3
            r15 = r11
            r18 = r12
            r19 = r13
            r20 = r14
            r3 = r2
            r11 = r7
            r12 = r8
            r13 = r9
            r14 = r10
            r8 = r4
            r9 = r5
            r10 = r6
            goto L_0x05f6
        L_0x0119:
            int r1 = r3.f37108v
            boolean r5 = r3.f37107u
            java.lang.Object r6 = r3.f37104r
            java.util.ArrayList r6 = (java.util.ArrayList) r6
            java.lang.Object r7 = r3.f37103q
            java.lang.Integer r7 = (java.lang.Integer) r7
            java.lang.Object r8 = r3.f37102p
            androidx.paging.TransformablePage r8 = (androidx.paging.TransformablePage) r8
            java.lang.Object r9 = r3.f37101o
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.f37100n
            java.util.ArrayList r10 = (java.util.ArrayList) r10
            java.lang.Object r11 = r3.f37099m
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            java.lang.Object r12 = r3.f37098l
            androidx.paging.PageEvent$Insert r12 = (androidx.paging.PageEvent.Insert) r12
            java.lang.Object r13 = r3.f37097k
            androidx.paging.SeparatorState r13 = (androidx.paging.SeparatorState) r13
            kotlin.ResultKt.throwOnFailure(r2)
            goto L_0x0561
        L_0x0142:
            int r1 = r3.f37108v
            boolean r5 = r3.f37107u
            java.lang.Object r6 = r3.f37105s
            androidx.paging.TransformablePage r6 = (androidx.paging.TransformablePage) r6
            java.lang.Object r7 = r3.f37104r
            java.lang.Integer r7 = (java.lang.Integer) r7
            java.lang.Object r8 = r3.f37103q
            androidx.paging.TransformablePage r8 = (androidx.paging.TransformablePage) r8
            java.lang.Object r9 = r3.f37102p
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.f37101o
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.f37100n
            java.util.ArrayList r11 = (java.util.ArrayList) r11
            java.lang.Object r12 = r3.f37099m
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r3.f37098l
            androidx.paging.PageEvent$Insert r13 = (androidx.paging.PageEvent.Insert) r13
            java.lang.Object r14 = r3.f37097k
            androidx.paging.SeparatorState r14 = (androidx.paging.SeparatorState) r14
            kotlin.ResultKt.throwOnFailure(r2)
            r0 = r3
            r15 = r7
            r18 = r13
            r19 = r14
            r3 = r2
            r13 = r11
            r14 = r12
            r11 = r9
            r12 = r10
            r9 = r5
            r10 = r8
            r8 = r4
            r4 = r6
            goto L_0x04fc
        L_0x017e:
            int r1 = r3.f37110x
            int r5 = r3.f37109w
            int r6 = r3.f37108v
            boolean r7 = r3.f37107u
            java.lang.Object r8 = r3.f37105s
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            java.lang.Object r9 = r3.f37104r
            java.lang.Integer r9 = (java.lang.Integer) r9
            java.lang.Object r10 = r3.f37103q
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            java.lang.Object r11 = r3.f37102p
            java.lang.Integer r11 = (java.lang.Integer) r11
            java.lang.Object r12 = r3.f37101o
            androidx.paging.TransformablePage r12 = (androidx.paging.TransformablePage) r12
            java.lang.Object r13 = r3.f37100n
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Object r14 = r3.f37099m
            java.util.ArrayList r14 = (java.util.ArrayList) r14
            java.lang.Object r15 = r3.f37098l
            androidx.paging.PageEvent$Insert r15 = (androidx.paging.PageEvent.Insert) r15
            r30 = r1
            java.lang.Object r1 = r3.f37097k
            androidx.paging.SeparatorState r1 = (androidx.paging.SeparatorState) r1
            kotlin.ResultKt.throwOnFailure(r2)
            r0 = r1
            r18 = r9
            r9 = r11
            r11 = r13
            r13 = r15
            r1 = r30
            goto L_0x0480
        L_0x01b9:
            int r1 = r3.f37108v
            boolean r5 = r3.f37107u
            java.lang.Object r6 = r3.f37106t
            java.util.List r6 = (java.util.List) r6
            java.lang.Object r7 = r3.f37105s
            androidx.paging.TransformablePage r7 = (androidx.paging.TransformablePage) r7
            java.lang.Object r8 = r3.f37104r
            java.lang.Integer r8 = (java.lang.Integer) r8
            java.lang.Object r9 = r3.f37103q
            androidx.paging.TransformablePage r9 = (androidx.paging.TransformablePage) r9
            java.lang.Object r10 = r3.f37102p
            java.lang.Integer r10 = (java.lang.Integer) r10
            java.lang.Object r11 = r3.f37101o
            androidx.paging.TransformablePage r11 = (androidx.paging.TransformablePage) r11
            java.lang.Object r12 = r3.f37100n
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            java.lang.Object r13 = r3.f37099m
            java.util.ArrayList r13 = (java.util.ArrayList) r13
            java.lang.Object r14 = r3.f37098l
            androidx.paging.PageEvent$Insert r14 = (androidx.paging.PageEvent.Insert) r14
            java.lang.Object r15 = r3.f37097k
            androidx.paging.SeparatorState r15 = (androidx.paging.SeparatorState) r15
            kotlin.ResultKt.throwOnFailure(r2)
            r18 = r12
            r19 = r13
            r20 = r15
            r12 = r9
            r13 = r10
            r15 = r11
            r11 = r8
            r8 = r7
            r27 = r6
            r6 = r2
            r2 = r5
            r5 = r27
            goto L_0x0400
        L_0x01fb:
            java.lang.Object r1 = r3.f37098l
            androidx.paging.PageEvent$Insert r1 = (androidx.paging.PageEvent.Insert) r1
            java.lang.Object r3 = r3.f37097k
            androidx.paging.SeparatorState r3 = (androidx.paging.SeparatorState) r3
            kotlin.ResultKt.throwOnFailure(r2)
            r4 = 0
            r5 = 1
            goto L_0x02dd
        L_0x020a:
            kotlin.ResultKt.throwOnFailure(r2)
            androidx.paging.TerminalSeparatorType r2 = r0.terminalSeparatorType
            boolean r2 = r0.terminatesStart(r1, r2)
            androidx.paging.TerminalSeparatorType r5 = r0.terminalSeparatorType
            boolean r5 = r0.terminatesEnd(r1, r5)
            java.util.List r6 = r30.getPages()
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            boolean r7 = r6 instanceof java.util.Collection
            if (r7 == 0) goto L_0x022e
            r7 = r6
            java.util.Collection r7 = (java.util.Collection) r7
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x022e
        L_0x022c:
            r6 = 1
            goto L_0x0251
        L_0x022e:
            java.util.Iterator r6 = r6.iterator()
        L_0x0232:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x022c
            java.lang.Object r7 = r6.next()
            androidx.paging.TransformablePage r7 = (androidx.paging.TransformablePage) r7
            java.util.List r7 = r7.getData()
            boolean r7 = r7.isEmpty()
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
            boolean r7 = r7.booleanValue()
            if (r7 != 0) goto L_0x0232
            r6 = 0
        L_0x0251:
            boolean r7 = r0.headerAdded
            if (r7 == 0) goto L_0x0262
            androidx.paging.LoadType r7 = r30.getLoadType()
            androidx.paging.LoadType r8 = androidx.paging.LoadType.PREPEND
            if (r7 != r8) goto L_0x0262
            if (r6 == 0) goto L_0x0260
            goto L_0x0262
        L_0x0260:
            r7 = 0
            goto L_0x0263
        L_0x0262:
            r7 = 1
        L_0x0263:
            if (r7 == 0) goto L_0x0869
            boolean r7 = r0.footerAdded
            if (r7 == 0) goto L_0x0276
            androidx.paging.LoadType r7 = r30.getLoadType()
            androidx.paging.LoadType r8 = androidx.paging.LoadType.APPEND
            if (r7 != r8) goto L_0x0276
            if (r6 == 0) goto L_0x0274
            goto L_0x0276
        L_0x0274:
            r7 = 0
            goto L_0x0277
        L_0x0276:
            r7 = 1
        L_0x0277:
            if (r7 == 0) goto L_0x085d
            androidx.paging.MutableLoadStateCollection r7 = r0.loadStates
            androidx.paging.CombinedLoadStates r8 = r30.getCombinedLoadStates()
            r7.set(r8)
            androidx.paging.LoadType r7 = r30.getLoadType()
            androidx.paging.LoadType r8 = androidx.paging.LoadType.APPEND
            if (r7 == r8) goto L_0x0290
            int r7 = r30.getPlaceholdersBefore()
            r0.placeholdersBefore = r7
        L_0x0290:
            androidx.paging.LoadType r7 = r30.getLoadType()
            androidx.paging.LoadType r8 = androidx.paging.LoadType.PREPEND
            if (r7 == r8) goto L_0x029e
            int r7 = r30.getPlaceholdersAfter()
            r0.placeholdersAfter = r7
        L_0x029e:
            if (r6 == 0) goto L_0x032b
            if (r2 != 0) goto L_0x02a9
            if (r5 != 0) goto L_0x02a9
            androidx.paging.PageEvent$Insert r1 = r29.asRType(r30)
            return r1
        L_0x02a9:
            boolean r7 = r0.headerAdded
            if (r7 == 0) goto L_0x02b6
            boolean r7 = r0.footerAdded
            if (r7 == 0) goto L_0x02b6
            androidx.paging.PageEvent$Insert r1 = r29.asRType(r30)
            return r1
        L_0x02b6:
            java.util.List<androidx.paging.TransformablePage<T>> r7 = r0.pageStash
            boolean r7 = r7.isEmpty()
            if (r7 == 0) goto L_0x032b
            if (r2 == 0) goto L_0x0313
            if (r5 == 0) goto L_0x0313
            boolean r6 = r0.headerAdded
            if (r6 != 0) goto L_0x0313
            boolean r6 = r0.footerAdded
            if (r6 != 0) goto L_0x0313
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r2 = r0.generator
            r3.f37097k = r0
            r3.f37098l = r1
            r5 = 1
            r3.f37095i = r5
            r6 = 0
            java.lang.Object r2 = r2.invoke(r6, r6, r3)
            if (r2 != r4) goto L_0x02db
            return r4
        L_0x02db:
            r3 = r0
            r4 = 0
        L_0x02dd:
            r3.endTerminalSeparatorDeferred = r4
            r3.startTerminalSeparatorDeferred = r4
            r3.headerAdded = r5
            r3.footerAdded = r5
            if (r2 != 0) goto L_0x02ec
            androidx.paging.PageEvent$Insert r1 = r3.asRType(r1)
            goto L_0x0312
        L_0x02ec:
            androidx.paging.LoadType r3 = r1.getLoadType()
            r1.getPages()
            int[] r5 = new int[r5]
            r5[r4] = r4
            androidx.paging.TransformablePage r2 = androidx.paging.SeparatorsKt.separatorPage(r2, r5, r4, r4)
            java.util.List r4 = kotlin.collections.CollectionsKt__CollectionsJVMKt.listOf(r2)
            int r5 = r1.getPlaceholdersBefore()
            int r6 = r1.getPlaceholdersAfter()
            androidx.paging.CombinedLoadStates r7 = r1.getCombinedLoadStates()
            r8 = 0
            androidx.paging.PageEvent$Insert r1 = new androidx.paging.PageEvent$Insert
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
        L_0x0312:
            return r1
        L_0x0313:
            if (r5 == 0) goto L_0x031d
            boolean r3 = r0.footerAdded
            if (r3 != 0) goto L_0x031d
            r3 = 1
            r0.endTerminalSeparatorDeferred = r3
            goto L_0x031e
        L_0x031d:
            r3 = 1
        L_0x031e:
            if (r2 == 0) goto L_0x0326
            boolean r2 = r0.headerAdded
            if (r2 != 0) goto L_0x0326
            r0.startTerminalSeparatorDeferred = r3
        L_0x0326:
            androidx.paging.PageEvent$Insert r1 = r29.asRType(r30)
            return r1
        L_0x032b:
            java.util.ArrayList r7 = new java.util.ArrayList
            java.util.List r8 = r30.getPages()
            int r8 = r8.size()
            r7.<init>(r8)
            java.util.ArrayList r12 = new java.util.ArrayList
            java.util.List r8 = r30.getPages()
            int r8 = r8.size()
            r12.<init>(r8)
            if (r6 != 0) goto L_0x03a7
            r8 = 0
        L_0x0348:
            java.util.List r9 = r30.getPages()
            int r9 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r9)
            if (r8 >= r9) goto L_0x0369
            java.util.List r9 = r30.getPages()
            java.lang.Object r9 = r9.get(r8)
            androidx.paging.TransformablePage r9 = (androidx.paging.TransformablePage) r9
            java.util.List r9 = r9.getData()
            boolean r9 = r9.isEmpty()
            if (r9 == 0) goto L_0x0369
            int r8 = r8 + 1
            goto L_0x0348
        L_0x0369:
            java.lang.Integer r9 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
            java.util.List r10 = r30.getPages()
            java.lang.Object r8 = r10.get(r8)
            androidx.paging.TransformablePage r8 = (androidx.paging.TransformablePage) r8
            java.util.List r10 = r30.getPages()
            int r10 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r10)
        L_0x037f:
            if (r10 <= 0) goto L_0x0398
            java.util.List r11 = r30.getPages()
            java.lang.Object r11 = r11.get(r10)
            androidx.paging.TransformablePage r11 = (androidx.paging.TransformablePage) r11
            java.util.List r11 = r11.getData()
            boolean r11 = r11.isEmpty()
            if (r11 == 0) goto L_0x0398
            int r10 = r10 + -1
            goto L_0x037f
        L_0x0398:
            java.lang.Integer r11 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r10)
            java.util.List r13 = r30.getPages()
            java.lang.Object r10 = r13.get(r10)
            androidx.paging.TransformablePage r10 = (androidx.paging.TransformablePage) r10
            goto L_0x03ab
        L_0x03a7:
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x03ab:
            if (r2 == 0) goto L_0x0426
            boolean r2 = r0.headerAdded
            if (r2 != 0) goto L_0x0426
            r2 = 1
            r0.headerAdded = r2
            if (r6 == 0) goto L_0x03bf
            java.util.List<androidx.paging.TransformablePage<T>> r2 = r0.pageStash
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.first(r2)
            androidx.paging.TransformablePage r2 = (androidx.paging.TransformablePage) r2
            goto L_0x03c3
        L_0x03bf:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)
            r2 = r8
        L_0x03c3:
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r13 = r0.generator
            java.util.List r14 = r2.getData()
            java.lang.Object r14 = kotlin.collections.CollectionsKt___CollectionsKt.first(r14)
            r3.f37097k = r0
            r3.f37098l = r1
            r3.f37099m = r7
            r3.f37100n = r12
            r3.f37101o = r8
            r3.f37102p = r9
            r3.f37103q = r10
            r3.f37104r = r11
            r3.f37105s = r2
            r3.f37106t = r7
            r3.f37107u = r5
            r3.f37108v = r6
            r15 = 2
            r3.f37095i = r15
            r15 = 0
            java.lang.Object r13 = r13.invoke(r15, r14, r3)
            if (r13 != r4) goto L_0x03f0
            return r4
        L_0x03f0:
            r20 = r0
            r14 = r1
            r1 = r6
            r19 = r7
            r15 = r8
            r18 = r12
            r6 = r13
            r8 = r2
            r2 = r5
            r5 = r19
            r13 = r9
            r12 = r10
        L_0x0400:
            r7 = 0
            int r9 = r8.getHintOriginalPageOffset()
            java.util.List r10 = r8.getHintOriginalIndices()
            if (r10 == 0) goto L_0x0418
            java.lang.Object r10 = kotlin.collections.CollectionsKt___CollectionsKt.first(r10)
            java.lang.Integer r10 = (java.lang.Integer) r10
            if (r10 == 0) goto L_0x0418
            int r10 = r10.intValue()
            goto L_0x0419
        L_0x0418:
            r10 = 0
        L_0x0419:
            androidx.paging.SeparatorsKt.addSeparatorPage(r5, r6, r7, r8, r9, r10)
            r6 = r1
            r5 = r2
            r10 = r12
            r9 = r13
            r8 = r15
            r12 = r18
            r7 = r19
            goto L_0x0429
        L_0x0426:
            r20 = r0
            r14 = r1
        L_0x0429:
            if (r6 != 0) goto L_0x07ae
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            int r1 = r9.intValue()
            r2 = r5
            r13 = r14
            r14 = r20
            r5 = 0
            r27 = r12
            r12 = r7
            r7 = r11
            r11 = r27
            r28 = r10
            r10 = r8
            r8 = r28
        L_0x0442:
            if (r5 >= r1) goto L_0x048f
            java.util.List r15 = r13.getPages()
            java.lang.Object r15 = r15.get(r5)
            androidx.paging.TransformablePage r15 = (androidx.paging.TransformablePage) r15
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r0 = r14.generator
            r3.f37097k = r14
            r3.f37098l = r13
            r3.f37099m = r12
            r3.f37100n = r11
            r3.f37101o = r10
            r3.f37102p = r9
            r3.f37103q = r8
            r3.f37104r = r7
            r3.f37105s = r12
            r18 = r7
            r7 = 0
            r3.f37106t = r7
            r3.f37107u = r2
            r3.f37108v = r6
            r3.f37109w = r5
            r3.f37110x = r1
            r7 = 3
            r3.f37095i = r7
            java.lang.Object r0 = androidx.paging.SeparatorsKt.insertInternalSeparators(r15, r0, r3)
            if (r0 != r4) goto L_0x0479
            return r4
        L_0x0479:
            r7 = r2
            r2 = r0
            r0 = r14
            r14 = r12
            r12 = r10
            r10 = r8
            r8 = r14
        L_0x0480:
            r8.add(r2)
            r15 = 1
            int r5 = r5 + r15
            r2 = r7
            r8 = r10
            r10 = r12
            r12 = r14
            r7 = r18
            r14 = r0
            r0 = r29
            goto L_0x0442
        L_0x048f:
            r18 = r7
            r15 = 1
            androidx.paging.LoadType r0 = r13.getLoadType()
            androidx.paging.LoadType r1 = androidx.paging.LoadType.APPEND
            if (r0 != r1) goto L_0x0527
            java.util.List<androidx.paging.TransformablePage<T>> r0 = r14.pageStash
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r15
            if (r0 == 0) goto L_0x0527
            java.util.List<androidx.paging.TransformablePage<T>> r0 = r14.pageStash
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.last(r0)
            androidx.paging.TransformablePage r0 = (androidx.paging.TransformablePage) r0
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r1 = r14.generator
            java.util.List r5 = r0.getData()
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.last(r5)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.util.List r7 = r10.getData()
            java.lang.Object r7 = kotlin.collections.CollectionsKt___CollectionsKt.first(r7)
            r3.f37097k = r14
            r3.f37098l = r13
            r3.f37099m = r12
            r3.f37100n = r11
            r3.f37101o = r10
            r3.f37102p = r9
            r3.f37103q = r8
            r15 = r18
            r3.f37104r = r15
            r3.f37105s = r0
            r30 = r0
            r0 = 0
            r3.f37106t = r0
            r3.f37107u = r2
            r3.f37108v = r6
            r0 = 4
            r3.f37095i = r0
            java.lang.Object r0 = r1.invoke(r5, r7, r3)
            if (r0 != r4) goto L_0x04e9
            return r4
        L_0x04e9:
            r1 = r6
            r18 = r13
            r19 = r14
            r13 = r11
            r14 = r12
            r11 = r9
            r12 = r10
            r9 = r2
            r10 = r8
            r8 = r4
            r4 = r30
            r27 = r3
            r3 = r0
            r0 = r27
        L_0x04fc:
            int r6 = r12.getHintOriginalPageOffset()
            java.util.List r2 = r12.getHintOriginalIndices()
            if (r2 == 0) goto L_0x0514
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.first(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x0514
            int r2 = r2.intValue()
            r7 = r2
            goto L_0x0515
        L_0x0514:
            r7 = 0
        L_0x0515:
            r2 = r14
            r5 = r12
            androidx.paging.SeparatorsKt.addSeparatorPage(r2, r3, r4, r5, r6, r7)
            r3 = r0
            r4 = r8
            r5 = r9
            r8 = r10
            r9 = r11
            r10 = r13
            r6 = r14
            r7 = r15
            r13 = r18
            r14 = r19
            goto L_0x052f
        L_0x0527:
            r15 = r18
            r5 = r2
            r1 = r6
            r6 = r12
            r7 = r15
            r12 = r10
            r10 = r11
        L_0x052f:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r12)
            androidx.paging.TransformablePage r0 = r14.transformablePageToStash(r12)
            r10.add(r0)
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r0 = r14.generator
            r3.f37097k = r14
            r3.f37098l = r13
            r3.f37099m = r6
            r3.f37100n = r10
            r3.f37101o = r9
            r3.f37102p = r8
            r3.f37103q = r7
            r3.f37104r = r6
            r2 = 0
            r3.f37105s = r2
            r3.f37106t = r2
            r3.f37107u = r5
            r3.f37108v = r1
            r2 = 5
            r3.f37095i = r2
            java.lang.Object r2 = androidx.paging.SeparatorsKt.insertInternalSeparators(r12, r0, r3)
            if (r2 != r4) goto L_0x055e
            return r4
        L_0x055e:
            r11 = r6
            r12 = r13
            r13 = r14
        L_0x0561:
            r6.add(r2)
            java.util.List r0 = r12.getPages()
            int r2 = r9.intValue()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            int r6 = r7.intValue()
            r9 = 1
            int r6 = r6 + r9
            java.util.List r0 = r0.subList(r2, r6)
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x07a6
            java.lang.Object r2 = r0.next()
            r9 = r7
            r14 = r13
            r13 = r12
            r12 = r11
            r11 = r10
            r10 = r8
            r8 = r0
        L_0x0590:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x06bb
            java.lang.Object r0 = r8.next()
            r7 = r0
            androidx.paging.TransformablePage r7 = (androidx.paging.TransformablePage) r7
            r6 = r2
            androidx.paging.TransformablePage r6 = (androidx.paging.TransformablePage) r6
            java.util.List r0 = r7.getData()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0656
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r0 = r14.generator
            java.util.List r2 = r6.getData()
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.last(r2)
            java.util.List r15 = r7.getData()
            java.lang.Object r15 = kotlin.collections.CollectionsKt___CollectionsKt.first(r15)
            r3.f37097k = r14
            r3.f37098l = r13
            r3.f37099m = r12
            r3.f37100n = r11
            r3.f37101o = r10
            r3.f37102p = r9
            r3.f37103q = r8
            r3.f37104r = r7
            r3.f37105s = r6
            r30 = r6
            r6 = 0
            r3.f37106t = r6
            r3.f37107u = r5
            r3.f37108v = r1
            r6 = 6
            r3.f37095i = r6
            java.lang.Object r2 = r0.invoke(r2, r15, r3)
            if (r2 != r4) goto L_0x05e5
            return r4
        L_0x05e5:
            r0 = r3
            r15 = r11
            r18 = r12
            r19 = r13
            r20 = r14
            r3 = r2
            r11 = r7
            r12 = r8
            r13 = r9
            r14 = r10
            r10 = r30
            r8 = r4
            r9 = r5
        L_0x05f6:
            androidx.paging.LoadType r2 = r19.getLoadType()
            androidx.paging.LoadType r4 = androidx.paging.LoadType.PREPEND
            if (r2 != r4) goto L_0x0603
            int r2 = r10.getHintOriginalPageOffset()
            goto L_0x0607
        L_0x0603:
            int r2 = r11.getHintOriginalPageOffset()
        L_0x0607:
            r6 = r2
            androidx.paging.LoadType r2 = r19.getLoadType()
            if (r2 != r4) goto L_0x062b
            java.util.List r2 = r10.getHintOriginalIndices()
            if (r2 == 0) goto L_0x0621
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.last(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x0621
            int r4 = r2.intValue()
            goto L_0x0629
        L_0x0621:
            java.util.List r2 = r10.getData()
            int r4 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r2)
        L_0x0629:
            r7 = r4
            goto L_0x063f
        L_0x062b:
            java.util.List r2 = r11.getHintOriginalIndices()
            if (r2 == 0) goto L_0x063e
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.first(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x063e
            int r4 = r2.intValue()
            goto L_0x0629
        L_0x063e:
            r7 = 0
        L_0x063f:
            r2 = r18
            r4 = r10
            r5 = r11
            androidx.paging.SeparatorsKt.addSeparatorPage(r2, r3, r4, r5, r6, r7)
            r3 = r0
            r4 = r8
            r5 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            r6 = r18
            r8 = r19
            r7 = r20
            goto L_0x0665
        L_0x0656:
            r30 = r6
            r6 = r12
            r12 = r9
            r9 = r30
            r27 = r10
            r10 = r7
            r7 = r14
            r14 = r11
            r11 = r8
            r8 = r13
            r13 = r27
        L_0x0665:
            java.util.List r0 = r10.getData()
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x067a
            androidx.paging.TransformablePage r0 = r7.transformablePageToStash(r10)
            r14.add(r0)
        L_0x067a:
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r0 = r7.generator
            r3.f37097k = r7
            r3.f37098l = r8
            r3.f37099m = r6
            r3.f37100n = r14
            r3.f37101o = r13
            r3.f37102p = r12
            r3.f37103q = r11
            r3.f37104r = r10
            r3.f37105s = r9
            r3.f37106t = r6
            r3.f37107u = r5
            r3.f37108v = r1
            r2 = 7
            r3.f37095i = r2
            java.lang.Object r2 = androidx.paging.SeparatorsKt.insertInternalSeparators(r10, r0, r3)
            if (r2 != r4) goto L_0x069e
            return r4
        L_0x069e:
            r15 = r6
            goto L_0x00d6
        L_0x06a1:
            r6.add(r2)
            java.util.List r2 = r10.getData()
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            r6 = 1
            r2 = r2 ^ r6
            if (r2 == 0) goto L_0x06b4
            r2 = r10
            goto L_0x06b5
        L_0x06b4:
            r2 = r9
        L_0x06b5:
            r9 = r12
            r10 = r13
            r12 = r15
            r13 = r0
            goto L_0x0590
        L_0x06bb:
            androidx.paging.LoadType r0 = r13.getLoadType()
            androidx.paging.LoadType r2 = androidx.paging.LoadType.PREPEND
            if (r0 != r2) goto L_0x0741
            java.util.List<androidx.paging.TransformablePage<T>> r0 = r14.pageStash
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r2 = 1
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0741
            java.util.List<androidx.paging.TransformablePage<T>> r0 = r14.pageStash
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.first(r0)
            r6 = r0
            androidx.paging.TransformablePage r6 = (androidx.paging.TransformablePage) r6
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r0 = r14.generator
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            java.util.List r2 = r10.getData()
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.last(r2)
            java.util.List r7 = r6.getData()
            java.lang.Object r7 = kotlin.collections.CollectionsKt___CollectionsKt.first(r7)
            r3.f37097k = r14
            r3.f37098l = r13
            r3.f37099m = r12
            r3.f37100n = r11
            r3.f37101o = r10
            r3.f37102p = r9
            r3.f37103q = r6
            r8 = 0
            r3.f37104r = r8
            r3.f37105s = r8
            r3.f37106t = r8
            r3.f37107u = r5
            r3.f37108v = r1
            r8 = 8
            r3.f37095i = r8
            java.lang.Object r2 = r0.invoke(r2, r7, r3)
            if (r2 != r4) goto L_0x009a
            return r4
        L_0x0711:
            int r6 = r11.getHintOriginalPageOffset()
            java.util.List r2 = r11.getHintOriginalIndices()
            if (r2 == 0) goto L_0x0728
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.last(r2)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x0728
            int r2 = r2.intValue()
            goto L_0x0730
        L_0x0728:
            java.util.List r2 = r11.getData()
            int r2 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r2)
        L_0x0730:
            r7 = r2
            r2 = r13
            r4 = r11
            androidx.paging.SeparatorsKt.addSeparatorPage(r2, r3, r4, r5, r6, r7)
            r3 = r0
            r6 = r1
            r4 = r8
            r5 = r9
            r9 = r10
            r10 = r11
            r11 = r12
            r12 = r13
            r13 = r14
            r14 = r15
            goto L_0x0742
        L_0x0741:
            r6 = r1
        L_0x0742:
            int r0 = r9.intValue()
            r1 = 1
            int r0 = r0 + r1
            java.util.List r1 = r13.getPages()
            int r1 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r1)
            if (r0 > r1) goto L_0x07a0
            r9 = r6
            r15 = r13
            r6 = r14
            r13 = r11
            r11 = r12
            r12 = r10
            r10 = r5
            r5 = r0
        L_0x075a:
            java.util.List r0 = r15.getPages()
            java.lang.Object r0 = r0.get(r5)
            androidx.paging.TransformablePage r0 = (androidx.paging.TransformablePage) r0
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r2 = r6.generator
            r3.f37097k = r6
            r3.f37098l = r15
            r3.f37099m = r11
            r3.f37100n = r13
            r3.f37101o = r12
            r3.f37102p = r11
            r7 = 0
            r3.f37103q = r7
            r3.f37104r = r7
            r3.f37105s = r7
            r3.f37106t = r7
            r3.f37107u = r10
            r3.f37108v = r9
            r3.f37109w = r5
            r3.f37110x = r1
            r7 = 9
            r3.f37095i = r7
            java.lang.Object r2 = androidx.paging.SeparatorsKt.insertInternalSeparators(r0, r2, r3)
            if (r2 != r4) goto L_0x078e
            return r4
        L_0x078e:
            r14 = r11
        L_0x078f:
            r11.add(r2)
            if (r5 == r1) goto L_0x0798
            int r5 = r5 + 1
            r11 = r14
            goto L_0x075a
        L_0x0798:
            r0 = r3
            r3 = r6
            r6 = r9
            r5 = r10
            r10 = r12
            r1 = r14
            r8 = r15
            goto L_0x07b4
        L_0x07a0:
            r0 = r3
            r1 = r12
            r8 = r13
            r3 = r14
            r13 = r11
            goto L_0x07b4
        L_0x07a6:
            java.lang.UnsupportedOperationException r0 = new java.lang.UnsupportedOperationException
            java.lang.String r1 = "Empty collection can't be reduced."
            r0.<init>(r1)
            throw r0
        L_0x07ae:
            r0 = r3
            r1 = r7
            r13 = r12
            r8 = r14
            r3 = r20
        L_0x07b4:
            if (r5 == 0) goto L_0x0826
            boolean r2 = r3.footerAdded
            if (r2 != 0) goto L_0x0826
            r2 = 1
            r3.footerAdded = r2
            if (r6 == 0) goto L_0x07c8
            java.util.List<androidx.paging.TransformablePage<T>> r2 = r3.pageStash
            java.lang.Object r2 = kotlin.collections.CollectionsKt___CollectionsKt.last(r2)
            androidx.paging.TransformablePage r2 = (androidx.paging.TransformablePage) r2
            goto L_0x07cc
        L_0x07c8:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r10)
            r2 = r10
        L_0x07cc:
            kotlin.jvm.functions.Function3<T, T, kotlin.coroutines.Continuation<? super R>, java.lang.Object> r5 = r3.generator
            java.util.List r6 = r2.getData()
            java.lang.Object r6 = kotlin.collections.CollectionsKt___CollectionsKt.last(r6)
            r0.f37097k = r3
            r0.f37098l = r8
            r0.f37099m = r1
            r0.f37100n = r13
            r0.f37101o = r2
            r0.f37102p = r1
            r7 = 0
            r0.f37103q = r7
            r0.f37104r = r7
            r0.f37105s = r7
            r0.f37106t = r7
            r9 = 10
            r0.f37095i = r9
            java.lang.Object r0 = r5.invoke(r6, r7, r0)
            if (r0 != r4) goto L_0x07f6
            return r4
        L_0x07f6:
            r15 = r0
            r7 = r1
            r14 = r7
            r16 = r2
            r5 = r13
        L_0x07fc:
            r17 = 0
            int r18 = r16.getHintOriginalPageOffset()
            java.util.List r0 = r16.getHintOriginalIndices()
            if (r0 == 0) goto L_0x0815
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.last(r0)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L_0x0815
            int r0 = r0.intValue()
            goto L_0x081d
        L_0x0815:
            java.util.List r0 = r16.getData()
            int r0 = kotlin.collections.CollectionsKt__CollectionsKt.getLastIndex(r0)
        L_0x081d:
            r19 = r0
            androidx.paging.SeparatorsKt.addSeparatorPage(r14, r15, r16, r17, r18, r19)
            r13 = r5
            r22 = r7
            goto L_0x0828
        L_0x0826:
            r22 = r1
        L_0x0828:
            r0 = 0
            r3.endTerminalSeparatorDeferred = r0
            r3.startTerminalSeparatorDeferred = r0
            androidx.paging.LoadType r1 = r8.getLoadType()
            androidx.paging.LoadType r2 = androidx.paging.LoadType.APPEND
            if (r1 != r2) goto L_0x083b
            java.util.List<androidx.paging.TransformablePage<T>> r0 = r3.pageStash
            r0.addAll(r13)
            goto L_0x0840
        L_0x083b:
            java.util.List<androidx.paging.TransformablePage<T>> r1 = r3.pageStash
            r1.addAll(r0, r13)
        L_0x0840:
            androidx.paging.LoadType r21 = r8.getLoadType()
            r8.getPages()
            int r23 = r8.getPlaceholdersBefore()
            int r24 = r8.getPlaceholdersAfter()
            androidx.paging.CombinedLoadStates r25 = r8.getCombinedLoadStates()
            r26 = 0
            androidx.paging.PageEvent$Insert r0 = new androidx.paging.PageEvent$Insert
            r20 = r0
            r20.<init>(r21, r22, r23, r24, r25, r26)
            return r0
        L_0x085d:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Additional append event after append state is done"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        L_0x0869:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Additional prepend event after prepend state is done"
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.paging.SeparatorState.onInsert(androidx.paging.PageEvent$Insert, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Nullable
    public final Object onLoadStateUpdate(@NotNull PageEvent.LoadStateUpdate<T> loadStateUpdate, @NotNull Continuation<? super PageEvent<R>> continuation) {
        PageEvent.Insert insert;
        if (Intrinsics.areEqual((Object) this.loadStates.get(loadStateUpdate.getLoadType(), loadStateUpdate.getFromMediator()), (Object) loadStateUpdate.getLoadState())) {
            return loadStateUpdate;
        }
        this.loadStates.set(loadStateUpdate.getLoadType(), loadStateUpdate.getFromMediator(), loadStateUpdate.getLoadState());
        if (loadStateUpdate.getLoadType() == LoadType.REFRESH || !loadStateUpdate.getFromMediator() || !loadStateUpdate.getLoadState().getEndOfPaginationReached()) {
            return loadStateUpdate;
        }
        if (loadStateUpdate.getLoadType() == LoadType.PREPEND) {
            insert = PageEvent.Insert.Companion.Prepend(CollectionsKt__CollectionsKt.emptyList(), this.placeholdersBefore, this.loadStates.snapshot());
        } else {
            insert = PageEvent.Insert.Companion.Append(CollectionsKt__CollectionsKt.emptyList(), this.placeholdersAfter, this.loadStates.snapshot());
        }
        return onInsert(insert, continuation);
    }

    public final void setEndTerminalSeparatorDeferred(boolean z11) {
        this.endTerminalSeparatorDeferred = z11;
    }

    public final void setFooterAdded(boolean z11) {
        this.footerAdded = z11;
    }

    public final void setHeaderAdded(boolean z11) {
        this.headerAdded = z11;
    }

    public final void setPlaceholdersAfter(int i11) {
        this.placeholdersAfter = i11;
    }

    public final void setPlaceholdersBefore(int i11) {
        this.placeholdersBefore = i11;
    }

    public final void setStartTerminalSeparatorDeferred(boolean z11) {
        this.startTerminalSeparatorDeferred = z11;
    }

    public final <T> boolean terminatesEnd(@NotNull PageEvent.Insert<T> insert, @NotNull TerminalSeparatorType terminalSeparatorType2) {
        LoadStates mediator;
        LoadState append;
        Intrinsics.checkNotNullParameter(insert, "$this$terminatesEnd");
        Intrinsics.checkNotNullParameter(terminalSeparatorType2, "terminalSeparatorType");
        if (insert.getLoadType() == LoadType.PREPEND) {
            return this.endTerminalSeparatorDeferred;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$1[terminalSeparatorType2.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                return insert.getCombinedLoadStates().getSource().getAppend().getEndOfPaginationReached();
            }
            throw new NoWhenBranchMatchedException();
        } else if (!insert.getCombinedLoadStates().getSource().getAppend().getEndOfPaginationReached() || ((mediator = insert.getCombinedLoadStates().getMediator()) != null && (append = mediator.getAppend()) != null && !append.getEndOfPaginationReached())) {
            return false;
        } else {
            return true;
        }
    }

    public final <T> boolean terminatesStart(@NotNull PageEvent.Insert<T> insert, @NotNull TerminalSeparatorType terminalSeparatorType2) {
        LoadStates mediator;
        LoadState prepend;
        Intrinsics.checkNotNullParameter(insert, "$this$terminatesStart");
        Intrinsics.checkNotNullParameter(terminalSeparatorType2, "terminalSeparatorType");
        if (insert.getLoadType() == LoadType.APPEND) {
            return this.startTerminalSeparatorDeferred;
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[terminalSeparatorType2.ordinal()];
        if (i11 != 1) {
            if (i11 == 2) {
                return insert.getCombinedLoadStates().getSource().getPrepend().getEndOfPaginationReached();
            }
            throw new NoWhenBranchMatchedException();
        } else if (!insert.getCombinedLoadStates().getSource().getPrepend().getEndOfPaginationReached() || ((mediator = insert.getCombinedLoadStates().getMediator()) != null && (prepend = mediator.getPrepend()) != null && !prepend.getEndOfPaginationReached())) {
            return false;
        } else {
            return true;
        }
    }
}
