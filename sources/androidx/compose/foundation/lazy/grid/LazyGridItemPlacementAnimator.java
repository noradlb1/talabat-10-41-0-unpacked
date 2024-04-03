package androidx.compose.foundation.lazy.grid;

import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
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
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.Job;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\b\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010#\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006JM\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\t2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010!J;\u0010\"\u001a\u00020\u00152\u0006\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\t2\u0006\u0010%\u001a\u00020\t2\u0006\u0010&\u001a\u00020\t2\u0006\u0010'\u001a\u00020\u0015ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b(\u0010)JD\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\t2\u0006\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u00052\f\u0010/\u001a\b\u0012\u0004\u0012\u000201002\u0006\u00102\u001a\u000203J\u0006\u00104\u001a\u00020+J\u0018\u00105\u001a\u00020+2\u0006\u00106\u001a\u0002012\u0006\u00107\u001a\u00020\fH\u0002J\u001c\u00108\u001a\u00020\u0015*\u00020\tH\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b9\u0010:R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0014\u001a\u00020\t*\u00020\u00158BX\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006;"}, d2 = {"Landroidx/compose/foundation/lazy/grid/LazyGridItemPlacementAnimator;", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "isVertical", "", "(Lkotlinx/coroutines/CoroutineScope;Z)V", "keyToIndexMap", "", "", "keyToItemInfoMap", "", "Landroidx/compose/foundation/lazy/grid/ItemInfo;", "positionedKeys", "", "slotsPerLine", "viewportEndItemIndex", "viewportEndItemNotVisiblePartSize", "viewportStartItemIndex", "viewportStartItemNotVisiblePartSize", "mainAxis", "Landroidx/compose/ui/unit/IntOffset;", "getMainAxis--gyyYBs", "(J)I", "calculateExpectedOffset", "index", "mainAxisSizeWithSpacings", "averageLineMainAxisSize", "scrolledBy", "reverseLayout", "mainAxisLayoutSize", "fallback", "calculateExpectedOffset-tGxSNXI", "(IIIJZII)I", "getAnimatedOffset", "key", "placeableIndex", "minOffset", "maxOffset", "rawOffset", "getAnimatedOffset-YT5a7pE", "(Ljava/lang/Object;IIIJ)J", "onMeasured", "", "consumedScroll", "layoutWidth", "layoutHeight", "positionedItems", "", "Landroidx/compose/foundation/lazy/grid/LazyGridPositionedItem;", "measuredItemProvider", "Landroidx/compose/foundation/lazy/grid/LazyMeasuredItemProvider;", "reset", "startAnimationsIfNeeded", "item", "itemInfo", "toOffset", "toOffset-Bjo55l4", "(I)J", "foundation_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LazyGridItemPlacementAnimator {
    /* access modifiers changed from: private */
    public final boolean isVertical;
    @NotNull
    private Map<Object, Integer> keyToIndexMap = MapsKt__MapsKt.emptyMap();
    @NotNull
    private final Map<Object, ItemInfo> keyToItemInfoMap = new LinkedHashMap();
    @NotNull
    private final Set<Object> positionedKeys = new LinkedHashSet();
    @NotNull
    private final CoroutineScope scope;
    private int slotsPerLine;
    private int viewportEndItemIndex = -1;
    private int viewportEndItemNotVisiblePartSize;
    private int viewportStartItemIndex = -1;
    private int viewportStartItemNotVisiblePartSize;

    public LazyGridItemPlacementAnimator(@NotNull CoroutineScope coroutineScope, boolean z11) {
        Intrinsics.checkNotNullParameter(coroutineScope, "scope");
        this.scope = coroutineScope;
        this.isVertical = z11;
    }

    /* renamed from: calculateExpectedOffset-tGxSNXI  reason: not valid java name */
    private final int m687calculateExpectedOffsettGxSNXI(int i11, int i12, int i13, long j11, boolean z11, int i14, int i15) {
        boolean z12;
        boolean z13;
        boolean z14 = false;
        if (this.slotsPerLine != 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            int i16 = this.viewportEndItemIndex;
            if (z11 ? i16 <= i11 : i16 >= i11) {
                z13 = false;
            } else {
                z13 = true;
            }
            if (z11 ? this.viewportStartItemIndex < i11 : this.viewportStartItemIndex > i11) {
                z14 = true;
            }
            if (z13) {
                int abs = Math.abs(i11 - this.viewportEndItemIndex);
                int i17 = this.slotsPerLine;
                return i14 + this.viewportEndItemNotVisiblePartSize + (i13 * ((((abs + i17) - 1) / i17) - 1)) + m688getMainAxisgyyYBs(j11);
            } else if (!z14) {
                return i15;
            } else {
                int abs2 = Math.abs(this.viewportStartItemIndex - i11);
                int i18 = this.slotsPerLine;
                return ((this.viewportStartItemNotVisiblePartSize - i12) - (i13 * ((((abs2 + i18) - 1) / i18) - 1))) + m688getMainAxisgyyYBs(j11);
            }
        } else {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    /* renamed from: getMainAxis--gyyYBs  reason: not valid java name */
    private final int m688getMainAxisgyyYBs(long j11) {
        return this.isVertical ? IntOffset.m5597getYimpl(j11) : IntOffset.m5596getXimpl(j11);
    }

    private final void startAnimationsIfNeeded(LazyGridPositionedItem lazyGridPositionedItem, ItemInfo itemInfo) {
        LazyGridPositionedItem lazyGridPositionedItem2 = lazyGridPositionedItem;
        while (itemInfo.getPlaceables().size() > lazyGridPositionedItem.getPlaceablesCount()) {
            Object unused = CollectionsKt__MutableCollectionsKt.removeLast(itemInfo.getPlaceables());
        }
        while (itemInfo.getPlaceables().size() < lazyGridPositionedItem.getPlaceablesCount()) {
            int size = itemInfo.getPlaceables().size();
            long r42 = lazyGridPositionedItem.m703getOffsetnOccac();
            List<PlaceableInfo> placeables = itemInfo.getPlaceables();
            long r72 = itemInfo.m677getNotAnimatableDeltanOccac();
            placeables.add(new PlaceableInfo(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r42) - IntOffset.m5596getXimpl(r72), IntOffset.m5597getYimpl(r42) - IntOffset.m5597getYimpl(r72)), lazyGridPositionedItem2.getMainAxisSize(size), (DefaultConstructorMarker) null));
        }
        List<PlaceableInfo> placeables2 = itemInfo.getPlaceables();
        int size2 = placeables2.size();
        for (int i11 = 0; i11 < size2; i11++) {
            PlaceableInfo placeableInfo = placeables2.get(i11);
            long r62 = placeableInfo.m735getTargetOffsetnOccac();
            long r82 = itemInfo.m677getNotAnimatableDeltanOccac();
            long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r62) + IntOffset.m5596getXimpl(r82), IntOffset.m5597getYimpl(r62) + IntOffset.m5597getYimpl(r82));
            long r83 = lazyGridPositionedItem.m704getPlaceableOffsetnOccac();
            placeableInfo.setMainAxisSize(lazyGridPositionedItem2.getMainAxisSize(i11));
            FiniteAnimationSpec<IntOffset> animationSpec = lazyGridPositionedItem2.getAnimationSpec(i11);
            if (!IntOffset.m5595equalsimpl0(IntOffset, r83)) {
                long r63 = itemInfo.m677getNotAnimatableDeltanOccac();
                placeableInfo.m736setTargetOffsetgyyYBs(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r83) - IntOffset.m5596getXimpl(r63), IntOffset.m5597getYimpl(r83) - IntOffset.m5597getYimpl(r63)));
                if (animationSpec != null) {
                    placeableInfo.setInProgress(true);
                    Job unused2 = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1(placeableInfo, animationSpec, (Continuation<? super LazyGridItemPlacementAnimator$startAnimationsIfNeeded$1$1>) null), 3, (Object) null);
                }
            }
        }
    }

    /* renamed from: toOffset-Bjo55l4  reason: not valid java name */
    private final long m689toOffsetBjo55l4(int i11) {
        boolean z11 = this.isVertical;
        int i12 = z11 ? 0 : i11;
        if (!z11) {
            i11 = 0;
        }
        return IntOffsetKt.IntOffset(i12, i11);
    }

    /* renamed from: getAnimatedOffset-YT5a7pE  reason: not valid java name */
    public final long m690getAnimatedOffsetYT5a7pE(@NotNull Object obj, int i11, int i12, int i13, long j11) {
        Intrinsics.checkNotNullParameter(obj, "key");
        ItemInfo itemInfo = this.keyToItemInfoMap.get(obj);
        if (itemInfo == null) {
            return j11;
        }
        PlaceableInfo placeableInfo = itemInfo.getPlaceables().get(i11);
        long r11 = placeableInfo.getAnimatedOffset().getValue().m5605unboximpl();
        long r02 = itemInfo.m677getNotAnimatableDeltanOccac();
        long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r11) + IntOffset.m5596getXimpl(r02), IntOffset.m5597getYimpl(r11) + IntOffset.m5597getYimpl(r02));
        long r03 = placeableInfo.m735getTargetOffsetnOccac();
        long r22 = itemInfo.m677getNotAnimatableDeltanOccac();
        long IntOffset2 = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r03) + IntOffset.m5596getXimpl(r22), IntOffset.m5597getYimpl(r03) + IntOffset.m5597getYimpl(r22));
        if (placeableInfo.getInProgress() && ((m688getMainAxisgyyYBs(IntOffset2) < i12 && m688getMainAxisgyyYBs(IntOffset) < i12) || (m688getMainAxisgyyYBs(IntOffset2) > i13 && m688getMainAxisgyyYBs(IntOffset) > i13))) {
            Job unused = BuildersKt__Builders_commonKt.launch$default(this.scope, (CoroutineContext) null, (CoroutineStart) null, new LazyGridItemPlacementAnimator$getAnimatedOffset$1(placeableInfo, (Continuation<? super LazyGridItemPlacementAnimator$getAnimatedOffset$1>) null), 3, (Object) null);
        }
        return IntOffset;
    }

    public final void onMeasured(int i11, int i12, int i13, int i14, boolean z11, @NotNull List<LazyGridPositionedItem> list, @NotNull LazyMeasuredItemProvider lazyMeasuredItemProvider) {
        boolean z12;
        boolean z13;
        boolean z14;
        long j11;
        int i15;
        int i16;
        LazyGridPositionedItem lazyGridPositionedItem;
        ItemInfo itemInfo;
        long j12;
        int i17;
        long j13;
        int i18;
        List<LazyGridPositionedItem> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "positionedItems");
        Intrinsics.checkNotNullParameter(lazyMeasuredItemProvider, "measuredItemProvider");
        int size = list.size();
        int i19 = 0;
        while (true) {
            if (i19 >= size) {
                z12 = false;
                break;
            } else if (list2.get(i19).getHasAnimations()) {
                z12 = true;
                break;
            } else {
                i19++;
            }
        }
        if (!z12) {
            reset();
            return;
        }
        this.slotsPerLine = i14;
        int i21 = this.isVertical ? i13 : i12;
        int i22 = i11;
        if (z11) {
            i22 = -i22;
        }
        long r15 = m689toOffsetBjo55l4(i22);
        LazyGridPositionedItem lazyGridPositionedItem2 = (LazyGridPositionedItem) CollectionsKt___CollectionsKt.first(list);
        LazyGridPositionedItem lazyGridPositionedItem3 = (LazyGridPositionedItem) CollectionsKt___CollectionsKt.last(list);
        int size2 = list.size();
        for (int i23 = 0; i23 < size2; i23++) {
            LazyGridPositionedItem lazyGridPositionedItem4 = list2.get(i23);
            ItemInfo itemInfo2 = this.keyToItemInfoMap.get(lazyGridPositionedItem4.getKey());
            if (itemInfo2 != null) {
                itemInfo2.setIndex(lazyGridPositionedItem4.getIndex());
                itemInfo2.setCrossAxisSize(lazyGridPositionedItem4.getCrossAxisSize());
                itemInfo2.setCrossAxisOffset(lazyGridPositionedItem4.getCrossAxisOffset());
            }
        }
        LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1 lazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1 = new LazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1(this, list2);
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        while (i24 < list.size()) {
            int intValue = ((Number) lazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1.invoke(Integer.valueOf(i24))).intValue();
            if (intValue == -1) {
                i24++;
            } else {
                int i27 = 0;
                while (i24 < list.size() && ((Number) lazyGridItemPlacementAnimator$onMeasured$averageLineMainAxisSize$1$lineOf$1.invoke(Integer.valueOf(i24))).intValue() == intValue) {
                    i27 = Math.max(i27, list2.get(i24).getMainAxisSizeWithSpacings());
                    i24++;
                }
                i25 += i27;
                i26++;
            }
        }
        int i28 = i25 / i26;
        this.positionedKeys.clear();
        int i29 = 0;
        for (int size3 = list.size(); i29 < size3; size3 = i15) {
            LazyGridPositionedItem lazyGridPositionedItem5 = list2.get(i29);
            this.positionedKeys.add(lazyGridPositionedItem5.getKey());
            ItemInfo itemInfo3 = this.keyToItemInfoMap.get(lazyGridPositionedItem5.getKey());
            if (itemInfo3 != null) {
                i16 = i29;
                i15 = size3;
                if (lazyGridPositionedItem5.getHasAnimations()) {
                    long r12 = itemInfo3.m677getNotAnimatableDeltanOccac();
                    itemInfo3.m678setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r12) + IntOffset.m5596getXimpl(r15), IntOffset.m5597getYimpl(r12) + IntOffset.m5597getYimpl(r15)));
                    startAnimationsIfNeeded(lazyGridPositionedItem5, itemInfo3);
                } else {
                    this.keyToItemInfoMap.remove(lazyGridPositionedItem5.getKey());
                }
            } else if (lazyGridPositionedItem5.getHasAnimations()) {
                ItemInfo itemInfo4 = new ItemInfo(lazyGridPositionedItem5.getIndex(), lazyGridPositionedItem5.getCrossAxisSize(), lazyGridPositionedItem5.getCrossAxisOffset());
                Integer num = this.keyToIndexMap.get(lazyGridPositionedItem5.getKey());
                long r22 = lazyGridPositionedItem5.m704getPlaceableOffsetnOccac();
                if (num == null) {
                    i17 = m688getMainAxisgyyYBs(r22);
                    j12 = r22;
                    itemInfo = itemInfo4;
                    lazyGridPositionedItem = lazyGridPositionedItem5;
                    i16 = i29;
                    i15 = size3;
                } else {
                    if (!z11) {
                        i18 = m688getMainAxisgyyYBs(r22);
                    } else {
                        i18 = m688getMainAxisgyyYBs(r22) - lazyGridPositionedItem5.getMainAxisSizeWithSpacings();
                    }
                    j12 = r22;
                    itemInfo = itemInfo4;
                    lazyGridPositionedItem = lazyGridPositionedItem5;
                    i16 = i29;
                    i15 = size3;
                    i17 = m687calculateExpectedOffsettGxSNXI(num.intValue(), lazyGridPositionedItem5.getMainAxisSizeWithSpacings(), i28, r15, z11, i21, i18);
                }
                if (this.isVertical) {
                    j13 = IntOffset.m5592copyiSbpLlY$default(j12, 0, i17, 1, (Object) null);
                } else {
                    j13 = IntOffset.m5592copyiSbpLlY$default(j12, i17, 0, 2, (Object) null);
                }
                int placeablesCount = lazyGridPositionedItem.getPlaceablesCount();
                for (int i31 = 0; i31 < placeablesCount; i31++) {
                    itemInfo.getPlaceables().add(new PlaceableInfo(j13, lazyGridPositionedItem.getMainAxisSize(i31), (DefaultConstructorMarker) null));
                    Unit unit = Unit.INSTANCE;
                }
                LazyGridPositionedItem lazyGridPositionedItem6 = lazyGridPositionedItem;
                ItemInfo itemInfo5 = itemInfo;
                this.keyToItemInfoMap.put(lazyGridPositionedItem6.getKey(), itemInfo5);
                startAnimationsIfNeeded(lazyGridPositionedItem6, itemInfo5);
            } else {
                i16 = i29;
                i15 = size3;
            }
            i29 = i16 + 1;
        }
        if (!z11) {
            this.viewportStartItemIndex = lazyGridPositionedItem2.getIndex();
            this.viewportStartItemNotVisiblePartSize = m688getMainAxisgyyYBs(lazyGridPositionedItem2.m703getOffsetnOccac());
            this.viewportEndItemIndex = lazyGridPositionedItem3.getIndex();
            this.viewportEndItemNotVisiblePartSize = (m688getMainAxisgyyYBs(lazyGridPositionedItem3.m703getOffsetnOccac()) + lazyGridPositionedItem3.getLineMainAxisSizeWithSpacings()) - i21;
        } else {
            this.viewportStartItemIndex = lazyGridPositionedItem3.getIndex();
            this.viewportStartItemNotVisiblePartSize = (i21 - m688getMainAxisgyyYBs(lazyGridPositionedItem3.m703getOffsetnOccac())) - lazyGridPositionedItem3.getLineMainAxisSize();
            this.viewportEndItemIndex = lazyGridPositionedItem2.getIndex();
            this.viewportEndItemNotVisiblePartSize = (-m688getMainAxisgyyYBs(lazyGridPositionedItem2.m703getOffsetnOccac())) + (lazyGridPositionedItem2.getLineMainAxisSizeWithSpacings() - (this.isVertical ? IntSize.m5637getHeightimpl(lazyGridPositionedItem2.m705getSizeYbymL2g()) : IntSize.m5638getWidthimpl(lazyGridPositionedItem2.m705getSizeYbymL2g())));
        }
        Iterator<Map.Entry<Object, ItemInfo>> it = this.keyToItemInfoMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry next = it.next();
            if (!this.positionedKeys.contains(next.getKey())) {
                ItemInfo itemInfo6 = (ItemInfo) next.getValue();
                long r13 = itemInfo6.m677getNotAnimatableDeltanOccac();
                itemInfo6.m678setNotAnimatableDeltagyyYBs(IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r13) + IntOffset.m5596getXimpl(r15), IntOffset.m5597getYimpl(r13) + IntOffset.m5597getYimpl(r15)));
                Integer num2 = lazyMeasuredItemProvider.getKeyToIndexMap().get(next.getKey());
                List<PlaceableInfo> placeables = itemInfo6.getPlaceables();
                int size4 = placeables.size();
                int i32 = 0;
                while (true) {
                    if (i32 >= size4) {
                        z13 = false;
                        break;
                    }
                    PlaceableInfo placeableInfo = placeables.get(i32);
                    long r52 = placeableInfo.m735getTargetOffsetnOccac();
                    long r202 = itemInfo6.m677getNotAnimatableDeltanOccac();
                    long IntOffset = IntOffsetKt.IntOffset(IntOffset.m5596getXimpl(r52) + IntOffset.m5596getXimpl(r202), IntOffset.m5597getYimpl(r52) + IntOffset.m5597getYimpl(r202));
                    if (m688getMainAxisgyyYBs(IntOffset) + placeableInfo.getMainAxisSize() > 0 && m688getMainAxisgyyYBs(IntOffset) < i21) {
                        z13 = true;
                        break;
                    }
                    i32++;
                }
                List<PlaceableInfo> placeables2 = itemInfo6.getPlaceables();
                int size5 = placeables2.size();
                int i33 = 0;
                while (true) {
                    if (i33 >= size5) {
                        z14 = false;
                        break;
                    } else if (placeables2.get(i33).getInProgress()) {
                        z14 = true;
                        break;
                    } else {
                        i33++;
                    }
                }
                boolean z15 = !z14;
                if ((z13 || !z15) && num2 != null && !itemInfo6.getPlaceables().isEmpty()) {
                    int r23 = ItemIndex.m666constructorimpl(num2.intValue());
                    if (this.isVertical) {
                        j11 = Constraints.Companion.m5432fixedWidthOenEA2s(itemInfo6.getCrossAxisSize());
                    } else {
                        j11 = Constraints.Companion.m5431fixedHeightOenEA2s(itemInfo6.getCrossAxisSize());
                    }
                    LazyMeasuredItem r203 = LazyMeasuredItemProvider.m715getAndMeasureednRnyU$default(lazyMeasuredItemProvider, r23, 0, j11, 2, (Object) null);
                    ItemInfo itemInfo7 = itemInfo6;
                    int r02 = m687calculateExpectedOffsettGxSNXI(num2.intValue(), r203.getMainAxisSizeWithSpacings(), i28, r15, z11, i21, i21);
                    if (z11) {
                        r02 = (i21 - r02) - r203.getMainAxisSize();
                    }
                    LazyGridPositionedItem position = r203.position(r02, itemInfo7.getCrossAxisOffset(), i12, i13, -1, -1, r203.getMainAxisSize());
                    list2.add(position);
                    startAnimationsIfNeeded(position, itemInfo7);
                } else {
                    it.remove();
                }
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
