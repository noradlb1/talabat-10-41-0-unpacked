package com.talabat.core.tracking.data.events;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.helpcenter.presentation.webview.GlobalHelpCenterWebViewActivity;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u00062\u0006\u0010\b\u001a\u00020\tH\u0016J\t\u0010\n\u001a\u00020\u0003HÂ\u0003J\u0013\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÖ\u0003J\u0010\u0010\u000f\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\u0010\u0010\u0012\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH\u0016J\u000e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014H\u0016J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/talabat/core/tracking/data/events/ComplicatedExampleEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "orderId", "", "(Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "copy", "equals", "", "other", "featureName", "hashCode", "", "name", "platforms", "", "toString", "com_talabat_core_tracking_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ComplicatedExampleEvent extends TalabatEvent {
    @NotNull
    private final String orderId;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PlatformName.values().length];
            iArr[PlatformName.GOOGLE_ANALYTICS.ordinal()] = 1;
            iArr[PlatformName.NEW_RELIC.ordinal()] = 2;
            iArr[PlatformName.BRAZE.ordinal()] = 3;
            iArr[PlatformName.ADJUST.ordinal()] = 4;
            iArr[PlatformName.PERSEUS.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public ComplicatedExampleEvent(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        this.orderId = str;
    }

    private final String component1() {
        return this.orderId;
    }

    public static /* synthetic */ ComplicatedExampleEvent copy$default(ComplicatedExampleEvent complicatedExampleEvent, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = complicatedExampleEvent.orderId;
        }
        return complicatedExampleEvent.copy(str);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        LinkedHashMap linkedHashMap;
        Intrinsics.checkNotNullParameter(platformName, "platform");
        Map mapOf = MapsKt__MapsJVMKt.mapOf(TuplesKt.to("orderId", this.orderId));
        int i11 = WhenMappings.$EnumSwitchMapping$0[platformName.ordinal()];
        if (i11 == 1) {
            linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(mapOf.size()));
            for (Map.Entry entry : mapOf.entrySet()) {
                Object key = entry.getKey();
                String lowerCase = String.valueOf(entry.getValue()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                linkedHashMap.put(key, lowerCase);
            }
        } else if (i11 == 2) {
            linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(mapOf.size()));
            for (Map.Entry entry2 : mapOf.entrySet()) {
                Object key2 = entry2.getKey();
                String upperCase = String.valueOf(entry2.getValue()).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                linkedHashMap.put(key2, upperCase);
            }
        } else if (i11 == 3) {
            linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(mapOf.size()));
            for (Map.Entry entry3 : mapOf.entrySet()) {
                Object key3 = entry3.getKey();
                String upperCase2 = String.valueOf(entry3.getValue()).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                linkedHashMap.put(key3, upperCase2);
            }
        } else if (i11 == 4) {
            linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(mapOf.size()));
            for (Map.Entry entry4 : mapOf.entrySet()) {
                Object key4 = entry4.getKey();
                String upperCase3 = String.valueOf(entry4.getValue()).toUpperCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(upperCase3, "this as java.lang.String).toUpperCase(Locale.ROOT)");
                linkedHashMap.put(key4, upperCase3);
            }
        } else if (i11 == 5) {
            linkedHashMap = new LinkedHashMap(MapsKt__MapsJVMKt.mapCapacity(mapOf.size()));
            for (Map.Entry entry5 : mapOf.entrySet()) {
                Object key5 = entry5.getKey();
                String lowerCase2 = String.valueOf(entry5.getValue()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                linkedHashMap.put(key5, lowerCase2);
            }
        } else {
            throw new NoWhenBranchMatchedException();
        }
        return linkedHashMap;
    }

    @NotNull
    public final ComplicatedExampleEvent copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "orderId");
        return new ComplicatedExampleEvent(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ComplicatedExampleEvent) && Intrinsics.areEqual((Object) this.orderId, (Object) ((ComplicatedExampleEvent) obj).orderId);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return GlobalHelpCenterWebViewActivity.ORDER_TRACKING;
    }

    public int hashCode() {
        return this.orderId.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        int i11 = WhenMappings.$EnumSwitchMapping$0[platformName.ordinal()];
        if (i11 == 1) {
            String lowerCase = "ComplicatedExampleEvent".toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
            return lowerCase;
        } else if (i11 == 2) {
            String upperCase = "ComplicatedExampleEvent".toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return upperCase;
        } else if (i11 == 3) {
            String upperCase2 = "ComplicatedExampleEvent".toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase2, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return upperCase2;
        } else if (i11 == 4) {
            String upperCase3 = "ComplicatedExampleEvent".toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase3, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return upperCase3;
        } else if (i11 == 5) {
            String upperCase4 = "ComplicatedExampleEvent".toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase4, "this as java.lang.String).toUpperCase(Locale.ROOT)");
            return upperCase4;
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsKt.listOf(PlatformName.GOOGLE_ANALYTICS, PlatformName.NEW_RELIC, PlatformName.BRAZE, PlatformName.ADJUST);
    }

    @NotNull
    public String toString() {
        String str = this.orderId;
        return "ComplicatedExampleEvent(orderId=" + str + ")";
    }
}
