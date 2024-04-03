package com.talabat.darkstores.feature.tracking.data;

import com.talabat.core.tracking.domain.PlatformName;
import com.talabat.core.tracking.domain.TalabatEvent;
import com.talabat.flutter.VendorListSearchFlutterActivity;
import com.talabat.talabatnavigation.opSquad.OPNavigatorActions;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0002\u0010\nJ\u001e\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0006\u0012\u0004\u0018\u00010\r0\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0010\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÂ\u0003J\t\u0010\u0012\u001a\u00020\u0006HÂ\u0003J\t\u0010\u0013\u001a\u00020\bHÂ\u0003J\t\u0010\u0014\u001a\u00020\bHÂ\u0003J;\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00062\b\u0010\u0017\u001a\u0004\u0018\u00010\rHÖ\u0003J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u000e\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000f0\u001cH\u0016J\t\u0010\u001d\u001a\u00020\bHÖ\u0001R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/talabat/darkstores/feature/tracking/data/CollectionClickedEvent;", "Lcom/talabat/core/tracking/domain/TalabatEvent;", "chainId", "", "branchId", "isDarkstore", "", "collectionId", "", "collectionName", "(IIZLjava/lang/String;Ljava/lang/String;)V", "attributes", "", "", "platform", "Lcom/talabat/core/tracking/domain/PlatformName;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "featureName", "hashCode", "name", "platforms", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CollectionClickedEvent extends TalabatEvent {
    private final int branchId;
    private final int chainId;
    @NotNull
    private final String collectionId;
    @NotNull
    private final String collectionName;
    private final boolean isDarkstore;

    public CollectionClickedEvent(int i11, int i12, boolean z11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, VendorListSearchFlutterActivity.COLLECTION_ID_KEY);
        Intrinsics.checkNotNullParameter(str2, "collectionName");
        this.chainId = i11;
        this.branchId = i12;
        this.isDarkstore = z11;
        this.collectionId = str;
        this.collectionName = str2;
    }

    private final int component1() {
        return this.chainId;
    }

    private final int component2() {
        return this.branchId;
    }

    private final boolean component3() {
        return this.isDarkstore;
    }

    private final String component4() {
        return this.collectionId;
    }

    private final String component5() {
        return this.collectionName;
    }

    public static /* synthetic */ CollectionClickedEvent copy$default(CollectionClickedEvent collectionClickedEvent, int i11, int i12, boolean z11, String str, String str2, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = collectionClickedEvent.chainId;
        }
        if ((i13 & 2) != 0) {
            i12 = collectionClickedEvent.branchId;
        }
        int i14 = i12;
        if ((i13 & 4) != 0) {
            z11 = collectionClickedEvent.isDarkstore;
        }
        boolean z12 = z11;
        if ((i13 & 8) != 0) {
            str = collectionClickedEvent.collectionId;
        }
        String str3 = str;
        if ((i13 & 16) != 0) {
            str2 = collectionClickedEvent.collectionName;
        }
        return collectionClickedEvent.copy(i11, i14, z12, str3, str2);
    }

    @NotNull
    public Map<String, Object> attributes(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return MapsKt__MapsKt.mapOf(TuplesKt.to("chain_id", String.valueOf(this.chainId)), TuplesKt.to(OPNavigatorActions.ARG_BRANCH_ID, String.valueOf(this.branchId)), TuplesKt.to("is_darkstore", String.valueOf(this.isDarkstore)), TuplesKt.to("collection_id", this.collectionId), TuplesKt.to("collection_name", this.collectionName));
    }

    @NotNull
    public final CollectionClickedEvent copy(int i11, int i12, boolean z11, @NotNull String str, @NotNull String str2) {
        Intrinsics.checkNotNullParameter(str, VendorListSearchFlutterActivity.COLLECTION_ID_KEY);
        Intrinsics.checkNotNullParameter(str2, "collectionName");
        return new CollectionClickedEvent(i11, i12, z11, str, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectionClickedEvent)) {
            return false;
        }
        CollectionClickedEvent collectionClickedEvent = (CollectionClickedEvent) obj;
        return this.chainId == collectionClickedEvent.chainId && this.branchId == collectionClickedEvent.branchId && this.isDarkstore == collectionClickedEvent.isDarkstore && Intrinsics.areEqual((Object) this.collectionId, (Object) collectionClickedEvent.collectionId) && Intrinsics.areEqual((Object) this.collectionName, (Object) collectionClickedEvent.collectionName);
    }

    @NotNull
    public String featureName(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "darkstores";
    }

    public int hashCode() {
        int i11 = ((this.chainId * 31) + this.branchId) * 31;
        boolean z11 = this.isDarkstore;
        if (z11) {
            z11 = true;
        }
        return ((((i11 + (z11 ? 1 : 0)) * 31) + this.collectionId.hashCode()) * 31) + this.collectionName.hashCode();
    }

    @NotNull
    public String name(@NotNull PlatformName platformName) {
        Intrinsics.checkNotNullParameter(platformName, "platform");
        return "vendor_collection_clicked";
    }

    @NotNull
    public List<PlatformName> platforms() {
        return CollectionsKt__CollectionsJVMKt.listOf(PlatformName.BRAZE);
    }

    @NotNull
    public String toString() {
        int i11 = this.chainId;
        int i12 = this.branchId;
        boolean z11 = this.isDarkstore;
        String str = this.collectionId;
        String str2 = this.collectionName;
        return "CollectionClickedEvent(chainId=" + i11 + ", branchId=" + i12 + ", isDarkstore=" + z11 + ", collectionId=" + str + ", collectionName=" + str2 + ")";
    }
}
