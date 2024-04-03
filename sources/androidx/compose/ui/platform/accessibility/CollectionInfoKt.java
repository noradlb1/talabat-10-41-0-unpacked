package androidx.compose.ui.platform.accessibility;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.semantics.CollectionInfo;
import androidx.compose.ui.semantics.CollectionItemInfo;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0016\u0010\u0004\u001a\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H\u0002\u001a\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\u0018\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\fH\u0000\u001a\f\u0010\u000e\u001a\u00020\u0001*\u00020\u0007H\u0000\u001a\u0014\u0010\u000f\u001a\n \u0011*\u0004\u0018\u00010\u00100\u0010*\u00020\u0002H\u0002\u001a\u001c\u0010\u0012\u001a\n \u0011*\u0004\u0018\u00010\u00130\u0013*\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H\u0002\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\u0000\u0010\u0003¨\u0006\u0016"}, d2 = {"isLazyCollection", "", "Landroidx/compose/ui/semantics/CollectionInfo;", "(Landroidx/compose/ui/semantics/CollectionInfo;)Z", "calculateIfHorizontallyStacked", "items", "", "Landroidx/compose/ui/semantics/SemanticsNode;", "setCollectionInfo", "", "node", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "setCollectionItemInfo", "hasCollectionInfo", "toAccessibilityCollectionInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionInfoCompat;", "kotlin.jvm.PlatformType", "toAccessibilityCollectionItemInfo", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat$CollectionItemInfoCompat;", "Landroidx/compose/ui/semantics/CollectionItemInfo;", "itemNode", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class CollectionInfoKt {
    private static final boolean calculateIfHorizontallyStacked(List<SemanticsNode> list) {
        List list2;
        long j11;
        if (list.size() < 2) {
            return true;
        }
        if (list.size() == 0 || list.size() == 1) {
            list2 = CollectionsKt__CollectionsKt.emptyList();
        } else {
            list2 = new ArrayList();
            SemanticsNode semanticsNode = list.get(0);
            int lastIndex = CollectionsKt__CollectionsKt.getLastIndex(list);
            int i11 = 0;
            while (i11 < lastIndex) {
                i11++;
                SemanticsNode semanticsNode2 = list.get(i11);
                SemanticsNode semanticsNode3 = semanticsNode2;
                SemanticsNode semanticsNode4 = semanticsNode;
                list2.add(Offset.m2665boximpl(OffsetKt.Offset(Math.abs(Offset.m2676getXimpl(semanticsNode4.getBoundsInRoot().m2706getCenterF1C5BW0()) - Offset.m2676getXimpl(semanticsNode3.getBoundsInRoot().m2706getCenterF1C5BW0())), Math.abs(Offset.m2677getYimpl(semanticsNode4.getBoundsInRoot().m2706getCenterF1C5BW0()) - Offset.m2677getYimpl(semanticsNode3.getBoundsInRoot().m2706getCenterF1C5BW0())))));
                semanticsNode = semanticsNode2;
            }
        }
        if (list2.size() == 1) {
            j11 = ((Offset) CollectionsKt___CollectionsKt.first(list2)).m2686unboximpl();
        } else if (!list2.isEmpty()) {
            Object first = CollectionsKt___CollectionsKt.first(list2);
            int lastIndex2 = CollectionsKt__CollectionsKt.getLastIndex(list2);
            if (1 <= lastIndex2) {
                int i12 = 1;
                while (true) {
                    first = Offset.m2665boximpl(Offset.m2681plusMKHz9U(((Offset) first).m2686unboximpl(), ((Offset) list2.get(i12)).m2686unboximpl()));
                    if (i12 == lastIndex2) {
                        break;
                    }
                    i12++;
                }
            }
            j11 = ((Offset) first).m2686unboximpl();
        } else {
            throw new UnsupportedOperationException("Empty collection can't be reduced.");
        }
        if (Offset.m2667component2impl(j11) < Offset.m2666component1impl(j11)) {
            return true;
        }
        return false;
    }

    public static final boolean hasCollectionInfo(@NotNull SemanticsNode semanticsNode) {
        Intrinsics.checkNotNullParameter(semanticsNode, "<this>");
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionInfo()) == null && SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), semanticsProperties.getSelectableGroup()) == null) {
            return false;
        }
        return true;
    }

    private static final boolean isLazyCollection(CollectionInfo collectionInfo) {
        return collectionInfo.getRowCount() < 0 || collectionInfo.getColumnCount() < 0;
    }

    public static final void setCollectionInfo(@NotNull SemanticsNode semanticsNode, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i11;
        Intrinsics.checkNotNullParameter(semanticsNode, "node");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, CustomerInfoLocalDataSourceImpl.KEY);
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionInfo());
        if (collectionInfo != null) {
            accessibilityNodeInfoCompat.setCollectionInfo(toAccessibilityCollectionInfo(collectionInfo));
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (SemanticsConfigurationKt.getOrNull(semanticsNode.getConfig(), semanticsProperties.getSelectableGroup()) != null) {
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i12 = 0; i12 < size; i12++) {
                SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i12);
                if (semanticsNode2.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                    arrayList.add(semanticsNode2);
                }
            }
        }
        int i13 = 1;
        if (!arrayList.isEmpty()) {
            boolean calculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
            if (calculateIfHorizontallyStacked) {
                i11 = 1;
            } else {
                i11 = arrayList.size();
            }
            if (calculateIfHorizontallyStacked) {
                i13 = arrayList.size();
            }
            accessibilityNodeInfoCompat.setCollectionInfo(AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(i11, i13, false, 0));
        }
    }

    public static final void setCollectionItemInfo(@NotNull SemanticsNode semanticsNode, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        int i11;
        int i12;
        Intrinsics.checkNotNullParameter(semanticsNode, "node");
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, CustomerInfoLocalDataSourceImpl.KEY);
        SemanticsConfiguration config = semanticsNode.getConfig();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        CollectionItemInfo collectionItemInfo = (CollectionItemInfo) SemanticsConfigurationKt.getOrNull(config, semanticsProperties.getCollectionItemInfo());
        if (collectionItemInfo != null) {
            accessibilityNodeInfoCompat.setCollectionItemInfo(toAccessibilityCollectionItemInfo(collectionItemInfo, semanticsNode));
        }
        SemanticsNode parent = semanticsNode.getParent();
        if (parent != null && SemanticsConfigurationKt.getOrNull(parent.getConfig(), semanticsProperties.getSelectableGroup()) != null) {
            CollectionInfo collectionInfo = (CollectionInfo) SemanticsConfigurationKt.getOrNull(parent.getConfig(), semanticsProperties.getCollectionInfo());
            if ((collectionInfo == null || !isLazyCollection(collectionInfo)) && semanticsNode.getConfig().contains(semanticsProperties.getSelected())) {
                ArrayList arrayList = new ArrayList();
                List<SemanticsNode> replacedChildren$ui_release = parent.getReplacedChildren$ui_release();
                int size = replacedChildren$ui_release.size();
                int i13 = 0;
                for (int i14 = 0; i14 < size; i14++) {
                    SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i14);
                    if (semanticsNode2.getConfig().contains(SemanticsProperties.INSTANCE.getSelected())) {
                        arrayList.add(semanticsNode2);
                        if (semanticsNode2.getLayoutNode$ui_release().getPlaceOrder$ui_release() < semanticsNode.getLayoutNode$ui_release().getPlaceOrder$ui_release()) {
                            i13++;
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    boolean calculateIfHorizontallyStacked = calculateIfHorizontallyStacked(arrayList);
                    if (calculateIfHorizontallyStacked) {
                        i11 = 0;
                    } else {
                        i11 = i13;
                    }
                    if (calculateIfHorizontallyStacked) {
                        i12 = i13;
                    } else {
                        i12 = 0;
                    }
                    AccessibilityNodeInfoCompat.CollectionItemInfoCompat obtain = AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(i11, 1, i12, 1, false, ((Boolean) semanticsNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), CollectionInfoKt$setCollectionItemInfo$itemInfo$1.INSTANCE)).booleanValue());
                    if (obtain != null) {
                        accessibilityNodeInfoCompat.setCollectionItemInfo(obtain);
                    }
                }
            }
        }
    }

    private static final AccessibilityNodeInfoCompat.CollectionInfoCompat toAccessibilityCollectionInfo(CollectionInfo collectionInfo) {
        return AccessibilityNodeInfoCompat.CollectionInfoCompat.obtain(collectionInfo.getRowCount(), collectionInfo.getColumnCount(), false, 0);
    }

    private static final AccessibilityNodeInfoCompat.CollectionItemInfoCompat toAccessibilityCollectionItemInfo(CollectionItemInfo collectionItemInfo, SemanticsNode semanticsNode) {
        return AccessibilityNodeInfoCompat.CollectionItemInfoCompat.obtain(collectionItemInfo.getRowIndex(), collectionItemInfo.getRowSpan(), collectionItemInfo.getColumnIndex(), collectionItemInfo.getColumnSpan(), false, ((Boolean) semanticsNode.getConfig().getOrElse(SemanticsProperties.INSTANCE.getSelected(), CollectionInfoKt$toAccessibilityCollectionItemInfo$1.INSTANCE)).booleanValue());
    }
}
