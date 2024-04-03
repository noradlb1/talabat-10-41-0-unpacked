package androidx.compose.foundation.lazy;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntRange;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J[\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\u00142\u0006\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J;\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u00012\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\t2\u0006\u0010(\u001a\u00020\t2\u0006\u0010)\u001a\u00020\u0014ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b*\u0010+J<\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\t2\u0006\u0010/\u001a\u00020\t2\u0006\u00100\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00052\f\u00101\u001a\b\u0012\u0004\u0012\u00020!022\u0006\u00103\u001a\u000204J\u0006\u00105\u001a\u00020-J\u0018\u00106\u001a\u00020-2\u0006\u00107\u001a\u00020!2\u0006\u00108\u001a\u00020\fH\u0002J\"\u00109\u001a\u00020\t*\b\u0012\u0004\u0012\u00020!0 2\u0006\u0010:\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\tH\u0002J\u001c\u0010;\u001a\u00020\u0014*\u00020\tH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\t*\u00020\u00148BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006>"}, d2 = {"Landroidx/compose/foundation/lazy/LazyListItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/ItemInfo;", "positionedKeys", "", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", "index", "sizeWithSpacings", "averageItemsSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", "fallback", "visibleItems", "", "Landroidx/compose/foundation/lazy/LazyListPositionedItem;", "calculateExpectedOffset-diAxcj4", "(IIIJZIILjava/util/List;)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "itemProvider", "Landroidx/compose/foundation/lazy/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "item", "itemInfo", "getItemSize", "itemIndex", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyListItemPlacementAnimator {
    private final boolean isVertical;
    @NotNull
    private Map<Object, Integer> keyToIndexMap = MapsKt__MapsKt.emptyMap();
    @NotNull
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    @NotNull
    private final Set<Object> positionedKeys = new LinkedHashSet();
    @NotNull
    private final CoroutineScope scope;
    private int viewportEndItemIndex = -1;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex = -1;
    private int viewportStartItemNotVisiblePartSize;

    public LazyListItemPlacementAnimator(@NotNull CoroutineScope coroutineScope, boolean z11) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.scope = coroutineScope;
        this.isVertical = z11;
    }

    /* renamed from: calculateExpectedOffset-diAxcj4  reason: not valid java name */
    private final int m630calculateExpectedOffsetdiAxcj4(int i11, int i12, int i13, long j11, boolean z11, int i14, int i15, List<LazyListPositionedItem> list) {
        boolean z12;
        boolean z13;
        IntRange intRange;
        IntRange intRange2;
        int i16 = 0;
        int i17 = this.viewportEndItemIndex;
        if (z11 ? i17 <= i11 : i17 >= i11) {
            z12 = false;
        } else {
            z12 = true;
        }
        int i18 = this.viewportStartItemIndex;
        if (z11 ? i18 >= i11 : i18 <= i11) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (z12) {
            if (!z11) {
                intRange2 = RangesKt___RangesKt.until(this.viewportEndItemIndex + 1, i11);
            } else {
                intRange2 = RangesKt___RangesKt.until(i11 + 1, this.viewportEndItemIndex);
            }
            int first = intRange2.getFirst();
            int last = intRange2.getLast();
            if (first <= last) {
                while (true) {
                    i16 += getItemSize(list, first, i13);
                    if (first == last) {
                        break;
                    }
                    first++;
                }
            }
            return i14 + this.viewportEndItemNotVisiblePartSize + i16 + m631getMainAxisgyyYBs(j11);
        } else if (!z13) {
            return i15;
        } else {
            if (!z11) {
                intRange = RangesKt___RangesKt.until(i11 + 1, this.viewportStartItemIndex);
            } else {
                intRange = RangesKt___RangesKt.until(this.viewportStartItemIndex + 1, i11);
            }
            int first2 = intRange.getFirst();
            int last2 = intRange.getLast();
            if (first2 <= last2) {
                while (true) {
                    i12 += getItemSize(list, first2, i13);
                    if (first2 == last2) {
                        break;
                    }
                    first2++;
                }
            }
            return (this.viewportStartItemNotVisiblePartSize - i12) + m631getMainAxisgyyYBs(j11);
        }
    }

    private final int getItemSize(List<LazyListPositionedItem> list, int i11, int i12) {
        if (!list.isEmpty() && i11 >= ((LazyListPositionedItem) CollectionsKt___CollectionsKt.first(list)).getIndex() && i11 <= ((LazyListPositionedItem) CollectionsKt___CollectionsKt.last(list)).getIndex()) {
            if (i11 - ((LazyListPositionedItem) CollectionsKt___CollectionsKt.first(list)).getIndex() >= ((LazyListPositionedItem) CollectionsKt___CollectionsKt.last(list)).getIndex() - i11) {
                int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
                while (-1 < lastIndex) {
                    LazyListPositionedItem lazyListPositionedItem = list.get(lastIndex);
                    if (lazyListPositionedItem.getIndex() != i11) {
                        if (lazyListPositionedItem.getIndex() < i11) {
                            break;
                        }
                        lastIndex--;
                    } else {
                        return lazyListPositionedItem.getSizeWithSpacings();
                    }
                }
            } else {
                int size = list.size();
                int i13 = 0;
                while (i13 < size) {
                    LazyListPositionedItem lazyListPositionedItem2 = list.get(i13);
                    if (lazyListPositionedItem2.getIndex() != i11) {
                        if (lazyListPositionedItem2.getIndex() > i11) {
                            break;
                        }
                        i13++;
                    } else {
                        return lazyListPositionedItem2.getSizeWithSpacings();
                    }
                }
            }
        }
        return i12;
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m631getMainAxisgyyYBs(long j11) {
        return this.isVertical ? IntOffset.m5597getYimpl(j11) : IntOffset.m5596getXimpl(j11);
    }

    private final void startAnimationsIfNeeded(LazyListPositionedItem lazyListPositionedItem, ItemInfo itemInfo) {
        LazyListPositionedItem lazyListPositionedItem2 = lazyListPositionedItem;
        while (itemInfo.getPlaceables().size() > lazyListPositionedItem.getPlaceablesCount()) {
            Object unused = CollectionsKt__MutableCollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < lazyListPositionedItem.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long r42 = lazyListPositionedItem2.m641getOffsetBjo55l4(size);
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long r72 = itemInfo.m624getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r42) - IntOffset.m5596getXimpl(r72), IntOffset.m5597getYimpl(r42) - IntOffset.m5597getYimpl(r72)), lazyListPositionedItem2.getMainAxisSize(size), (DefaultConstructorMarker) null));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            PlaceableInfo placeableInfo = placeables2.get(i11);
            long r62 = placeableInfo.m652getTargetOffsetnOccac();
            long r82 = itemInfo.m624getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r62) + IntOffset.m5596getXimpl(r82), IntOffset.m5597getYimpl(r62) + IntOffset.m5597getYimpl(r82));
            long r83 = lazyListPositionedItem2.m641getOffsetBjo55l4(i11);
            placeableInfo.setSize(lazyListPositionedItem2.getMainAxisSize(i11));
            FiniteAnimationSpec<IntOffset> animationSpec = lazyListPositionedItem2.getAnimationSpec(i11);
            if (!IntOffset.m5595equalsimpl0(IntOffset, r83)) {
                long r63 = itemInfo.m624getNotAnimatableDeltanOccac();
                placeableInfo.m653setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r83) - IntOffset.m5596getXimpl(r63), IntOffset.m5597getYimpl(r83) - IntOffset.m5597getYimpl(r63)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, (Continuation<? super LazyListItemPlacementAnimator$startAnimationsIfNeeded$1$1>) null), 3, (Object) null);
                }
            }
        }
    }

    /* renamed from: toOffset-Bjo55l4  reason: not valid java name */
    private final long m632toOffsetBjo55l4(int i11) {
        boolean z11 = this.isVertical;
        int i12 = z11 ? 0 : i11;
        if (!z11) {
            i11 = 0;
        }
        return IntOffsetKt.IntOffset(i12, i11);
    }

    /* renamed from: getAnimatedOffset-YT5a7pE  reason: not valid java name */
    public final long m633getAnimatedOffsetYT5a7pE(@NotNull Object obj, int i11, int i12, int i13, long j11) {
        Intrinsics.checkNotNullParameter(obj, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null) {
            return j11;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i11);
        long r11 = placeableInfo.getAnimatedOffset().getValue().m5605unboximpl();
        long r02 = itemInfo.m624getNotAnimatableDeltanOccac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r11) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(r11) + IntOffset.m5597getYimpl(r02));
        long r03 = placeableInfo.m652getTargetOffsetnOccac();
        long r22 = itemInfo.m624getNotAnimatableDeltanOccac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r03) + IntOffset.m5596getXimpl(r22), IntOffset.m5597getYimpl(r03) + IntOffset.m5597getYimpl(r22));
        if (placeableInfo.getInProgress() && ((m631getMainAxisgyyYBs(IntOffset2) < i12 && m631getMainAxisgyyYBs(IntOffset) < i12) || (m631getMainAxisgyyYBs(IntOffset2) > i13 && m631getMainAxisgyyYBs(IntOffset) > i13))) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyListItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, (Continuation<? super LazyListItemPlacementAnimator$getAnimatedOffset$1>) null), 3, (Object) null);
        }
        return IntOffset;
    }

    public final void onMeasured(int i11, int i12, int i13, boolean z11, @NotNull List<LazyListPositionedItem> list, @NotNull LazyMeasuredItemProvider lazyMeasuredItemProvider) {
        boolean z12;
        int i14;
        boolean z13;
        boolean z14;
        boolean z15;
        int i15;
        int i16;
        ItemInfo itemInfo;
        LazyListPositionedItem lazyListPositionedItem;
        long j11;
        int i17;
        long j12;
        int i18;
        int i19;
        List<LazyListPositionedItem> list2 = list;
        LazyMeasuredItemProvider lazyMeasuredItemProvider2 = lazyMeasuredItemProvider;
        Intrinsics.checkNotNullParameter(list2, "positionedItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider2, "itemProvider");
        int size = list.size();
        int i21 = 0;
        int i22 = 0;
        while (true) {
            if (i22 >= size) {
                z12 = false;
                break;
            } else if (list2.get(i22).getHasAnimations()) {
                z12 = true;
                break;
            } else {
                i22++;
            }
        }
        if (!z12) {
            reset();
            return;
        }
        if (this.isVertical) {
            i14 = i13;
        } else {
            i14 = i12;
        }
        int i23 = i11;
        if (z11) {
            i23 = -i23;
        }
        long r16 = m632toOffsetBjo55l4(i23);
        LazyListPositionedItem lazyListPositionedItem2 = (LazyListPositionedItem) CollectionsKt___CollectionsKt.first(list);
        LazyListPositionedItem lazyListPositionedItem3 = (LazyListPositionedItem) CollectionsKt___CollectionsKt.last(list);
        int size2 = list.size();
        int i24 = 0;
        for (int i25 = 0; i25 < size2; i25++) {
            LazyListPositionedItem lazyListPositionedItem4 = list2.get(i25);
            ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyListPositionedItem4.getKey());
            if (itemInfo2 != null) {
                itemInfo2.setIndex(lazyListPositionedItem4.getIndex());
            }
            i24 += lazyListPositionedItem4.getSizeWithSpacings();
        }
        int size3 = i24 / list.size();
        this.positionedKeys.clear();
        int size4 = list.size();
        int i26 = 0;
        while (i26 < size4) {
            LazyListPositionedItem lazyListPositionedItem5 = list2.get(i26);
            this.positionedKeys.add(lazyListPositionedItem5.getKey());
            ItemInfo itemInfo3 = this.keyToItemInfoMap.get(lazyListPositionedItem5.getKey());
            if (itemInfo3 != null) {
                LazyListPositionedItem lazyListPositionedItem6 = lazyListPositionedItem5;
                i16 = i26;
                i15 = size4;
                if (lazyListPositionedItem6.getHasAnimations()) {
                    long r12 = itemInfo3.m624getNotAnimatableDeltanOccac();
                    itemInfo3.m625setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r12) + IntOffset.m5596getXimpl(r16), IntOffset.m5597getYimpl(r12) + IntOffset.m5597getYimpl(r16)));
                    startAnimationsIfNeeded(lazyListPositionedItem6, itemInfo3);
                } else {
                    this.keyToItemInfoMap.remove(lazyListPositionedItem6.getKey());
                }
            } else if (lazyListPositionedItem5.getHasAnimations()) {
                ItemInfo itemInfo4 = new ItemInfo(lazyListPositionedItem5.getIndex());
                Integer num = this.keyToIndexMap.get(lazyListPositionedItem5.getKey());
                long r42 = lazyListPositionedItem5.m641getOffsetBjo55l4(i21);
                int mainAxisSize = lazyListPositionedItem5.getMainAxisSize(i21);
                if (num == null) {
                    i17 = m631getMainAxisgyyYBs(r42);
                    j11 = r42;
                    itemInfo = itemInfo4;
                    lazyListPositionedItem = lazyListPositionedItem5;
                    i16 = i26;
                    i15 = size4;
                } else {
                    if (!z11) {
                        i18 = m631getMainAxisgyyYBs(r42);
                    } else {
                        i18 = (m631getMainAxisgyyYBs(r42) - lazyListPositionedItem5.getSizeWithSpacings()) + mainAxisSize;
                    }
                    int sizeWithSpacings = lazyListPositionedItem5.getSizeWithSpacings();
                    j11 = r42;
                    itemInfo = itemInfo4;
                    lazyListPositionedItem = lazyListPositionedItem5;
                    i16 = i26;
                    i15 = size4;
                    int r02 = m630calculateExpectedOffsetdiAxcj4(num.intValue(), sizeWithSpacings, size3, r16, z11, i14, i18, list);
                    if (z11) {
                        i19 = lazyListPositionedItem.getSize() - mainAxisSize;
                    } else {
                        i19 = i21;
                    }
                    i17 = r02 + i19;
                }
                if (this.isVertical) {
                    j12 = IntOffset.m5592copyiSbpLlY$default(j11, 0, i17, 1, (Object) null);
                } else {
                    j12 = IntOffset.m5592copyiSbpLlY$default(j11, i17, 0, 2, (Object) null);
                }
                int placeablesCount = lazyListPositionedItem.getPlaceablesCount();
                for (int i27 = i21; i27 < placeablesCount; i27++) {
                    LazyListPositionedItem lazyListPositionedItem7 = lazyListPositionedItem;
                    long r52 = lazyListPositionedItem7.m641getOffsetBjo55l4(i27);
                    long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r52) - IntOffset.m5596getXimpl(j11), IntOffset.m5597getYimpl(r52) - IntOffset.m5597getYimpl(j11));
                    itemInfo.getPlaceables().add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(j12) + IntOffset.m5596getXimpl(IntOffset), IntOffset.m5597getYimpl(j12) + IntOffset.m5597getYimpl(IntOffset)), lazyListPositionedItem7.getMainAxisSize(i27), (DefaultConstructorMarker) null));
                    Unit unit = Unit.INSTANCE;
                }
                LazyListPositionedItem lazyListPositionedItem8 = lazyListPositionedItem;
                ItemInfo itemInfo5 = itemInfo;
                this.keyToItemInfoMap.put(lazyListPositionedItem8.getKey(), itemInfo5);
                startAnimationsIfNeeded(lazyListPositionedItem8, itemInfo5);
            } else {
                i16 = i26;
                i15 = size4;
            }
            i26 = i16 + 1;
            size4 = i15;
            i21 = 0;
        }
        if (!z11) {
            this.viewportStartItemIndex = lazyListPositionedItem2.getIndex();
            this.viewportStartItemNotVisiblePartSize = lazyListPositionedItem2.getOffset();
            this.viewportEndItemIndex = lazyListPositionedItem3.getIndex();
            this.viewportEndItemNotVisiblePartSize = (lazyListPositionedItem3.getOffset() + lazyListPositionedItem3.getSizeWithSpacings()) - i14;
        } else {
            this.viewportStartItemIndex = lazyListPositionedItem3.getIndex();
            this.viewportStartItemNotVisiblePartSize = (i14 - lazyListPositionedItem3.getOffset()) - lazyListPositionedItem3.getSize();
            this.viewportEndItemIndex = lazyListPositionedItem2.getIndex();
            this.viewportEndItemNotVisiblePartSize = (-lazyListPositionedItem2.getOffset()) + (lazyListPositionedItem2.getSizeWithSpacings() - lazyListPositionedItem2.getSize());
        }
        Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!this.positionedKeys.contains(next.getKey())) {
                ItemInfo itemInfo6 = (ItemInfo) next.getValue();
                long r13 = itemInfo6.m624getNotAnimatableDeltanOccac();
                itemInfo6.m625setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r13) + IntOffset.m5596getXimpl(r16), IntOffset.m5597getYimpl(r13) + IntOffset.m5597getYimpl(r16)));
                Integer num2 = lazyMeasuredItemProvider.getKeyToIndexMap().get(next.getKey());
                List<PlaceableInfo> placeables = itemInfo6.getPlaceables();
                int size5 = placeables.size();
                int i28 = 0;
                while (true) {
                    if (i28 >= size5) {
                        z13 = false;
                        break;
                    }
                    PlaceableInfo placeableInfo = placeables.get(i28);
                    long r53 = placeableInfo.m652getTargetOffsetnOccac();
                    long r72 = itemInfo6.m624getNotAnimatableDeltanOccac();
                    long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r53) + IntOffset.m5596getXimpl(r72), IntOffset.m5597getYimpl(r53) + IntOffset.m5597getYimpl(r72));
                    if (m631getMainAxisgyyYBs(IntOffset2) + placeableInfo.getSize() <= 0 || m631getMainAxisgyyYBs(IntOffset2) >= i14) {
                        z15 = false;
                    } else {
                        z15 = true;
                    }
                    if (z15) {
                        z13 = true;
                        break;
                    }
                    i28++;
                }
                List<PlaceableInfo> placeables2 = itemInfo6.getPlaceables();
                int size6 = placeables2.size();
                int i29 = 0;
                while (true) {
                    if (i29 >= size6) {
                        z14 = false;
                        break;
                    } else if (placeables2.get(i29).getInProgress()) {
                        z14 = true;
                        break;
                    } else {
                        i29++;
                    }
                }
                boolean z16 = !z14;
                if ((z13 || !z16) && num2 != null && !itemInfo6.getPlaceables().isEmpty()) {
                    LazyMeasuredItem r82 = lazyMeasuredItemProvider2.m648getAndMeasureZjPyQlc(DataIndex.m612constructorimpl(num2.intValue()));
                    LazyMeasuredItem lazyMeasuredItem = r82;
                    ItemInfo itemInfo7 = itemInfo6;
                    int r03 = m630calculateExpectedOffsetdiAxcj4(num2.intValue(), r82.getSizeWithSpacings(), size3, r16, z11, i14, i14, list);
                    if (z11) {
                        r03 = (i14 - r03) - lazyMeasuredItem.getSize();
                    }
                    LazyListPositionedItem position = lazyMeasuredItem.position(r03, i12, i13);
                    list2.add(position);
                    startAnimationsIfNeeded(position, itemInfo7);
                } else {
                    int i31 = i12;
                    int i32 = i13;
                    it.remove();
                }
            } else {
                int i33 = i12;
                int i34 = i13;
            }
        }
        this.keyToIndexMap = lazyMeasuredItemProvider.getKeyToIndexMap();
    }

    public final void reset() {
        this.keyToItemInfoMap.clear();
        this.keyToIndexMap = MapsKt__MapsKt.emptyMap();
        this.viewportStartItemIndex = -1;
        this.viewportStartItemNotVisiblePartSize = 0;
        this.viewportEndItemIndex = -1;
        this.viewportEndItemNotVisiblePartSize = 0;
    }
}
