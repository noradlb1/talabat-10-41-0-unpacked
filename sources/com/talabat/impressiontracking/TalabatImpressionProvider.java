package com.talabat.impressiontracking;

import com.deliveryhero.impression.Impression;
import com.deliveryhero.impression.ImpressionItemType;
import com.deliveryhero.impression.ImpressionProvider;
import com.deliveryhero.impression.ImpressionValidationRule;
import com.talabat.impressiontracking.items.NonTrackableImpressionItem;
import com.talabat.impressiontracking.items.TrackableImpressionItem;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J!\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u000fJ!\u0010\u0010\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002¢\u0006\u0002\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u0014J!\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0002\u0010\u0017R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/impressiontracking/TalabatImpressionProvider;", "Lcom/deliveryhero/impression/ImpressionProvider;", "()V", "impressionItems", "", "", "getImpressionItems", "()Ljava/util/List;", "setImpressionItems", "(Ljava/util/List;)V", "getImpression", "Lcom/deliveryhero/impression/Impression;", "position", "", "parentPosition", "(ILjava/lang/Integer;)Lcom/deliveryhero/impression/Impression;", "getImpressionItem", "(ILjava/lang/Integer;)Ljava/lang/Object;", "getImpressionValidationRule", "Lcom/deliveryhero/impression/ImpressionValidationRule;", "(ILjava/lang/Integer;)Lcom/deliveryhero/impression/ImpressionValidationRule;", "getItemType", "Lcom/deliveryhero/impression/ImpressionItemType;", "(ILjava/lang/Integer;)Lcom/deliveryhero/impression/ImpressionItemType;", "com_talabat_ThirdPartyLibs_ImpressionTracking_ImpressionTracking"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TalabatImpressionProvider implements ImpressionProvider {
    @NotNull
    private List<? extends Object> impressionItems = CollectionsKt__CollectionsKt.emptyList();

    private final Object getImpressionItem(int i11, Integer num) {
        List list;
        if (num != null) {
            num.intValue();
            Object orNull = CollectionsKt___CollectionsKt.getOrNull(this.impressionItems, num.intValue());
            Object obj = null;
            if (orNull instanceof List) {
                list = (List) orNull;
            } else {
                list = null;
            }
            if (list != null) {
                obj = CollectionsKt___CollectionsKt.getOrNull(list, i11);
            }
            if (obj != null) {
                return obj;
            }
        }
        return CollectionsKt___CollectionsKt.getOrNull(this.impressionItems, i11);
    }

    @Nullable
    public Impression getImpression(int i11, @Nullable Integer num) {
        TrackableImpressionItem trackableImpressionItem;
        Object impressionItem = getImpressionItem(i11, num);
        if (impressionItem instanceof TrackableImpressionItem) {
            trackableImpressionItem = (TrackableImpressionItem) impressionItem;
        } else {
            trackableImpressionItem = null;
        }
        if (trackableImpressionItem != null) {
            return new TalabatImpressionProvider$getImpression$1(trackableImpressionItem);
        }
        return null;
    }

    @NotNull
    public final List<Object> getImpressionItems() {
        return this.impressionItems;
    }

    @NotNull
    public ImpressionValidationRule getImpressionValidationRule(int i11, @Nullable Integer num) {
        return new ImpressionValidationRule(0, 0, 3, (DefaultConstructorMarker) null);
    }

    @Nullable
    public ImpressionItemType getItemType(int i11, @Nullable Integer num) {
        ImpressionItemType impressionItemType;
        Object impressionItem = getImpressionItem(i11, num);
        if (impressionItem == null) {
            return null;
        }
        if (impressionItem instanceof TrackableImpressionItem) {
            impressionItemType = ImpressionItemType.IMPRESSION_CANDIDATE;
        } else if (impressionItem instanceof NonTrackableImpressionItem) {
            return null;
        } else {
            impressionItemType = ImpressionItemType.NESTED_LIST;
        }
        return impressionItemType;
    }

    public final void setImpressionItems(@NotNull List<? extends Object> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.impressionItems = list;
    }
}
