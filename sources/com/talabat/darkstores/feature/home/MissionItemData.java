package com.talabat.darkstores.feature.home;

import com.talabat.observabilityNew.squads.nfv.ObservableAttributesNames;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B]\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012>\u0010\u0007\u001a:\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003JA\u0010\u0018\u001a:\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rHÆ\u0003Ji\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062@\b\u0002\u0010\u0007\u001a:\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u00062\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000fRI\u0010\u0007\u001a:\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\f\u0018\u00010\bj\u0004\u0018\u0001`\r¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0013¨\u0006\u001f"}, d2 = {"Lcom/talabat/darkstores/feature/home/MissionItemData;", "", "vendorId", "", "vendorCode", "isDarkstores", "", "lifeStyleMissionClickListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "code", "", "Lcom/talabat/feature/mission/control/presentation/listener/LifeStyleMissionClickListener;", "(Ljava/lang/String;Ljava/lang/String;ZLkotlin/jvm/functions/Function2;)V", "()Z", "getLifeStyleMissionClickListener", "()Lkotlin/jvm/functions/Function2;", "getVendorCode", "()Ljava/lang/String;", "getVendorId", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class MissionItemData {
    private final boolean isDarkstores;
    @Nullable
    private final Function2<String, String, Unit> lifeStyleMissionClickListener;
    @NotNull
    private final String vendorCode;
    @NotNull
    private final String vendorId;

    public MissionItemData(@NotNull String str, @NotNull String str2, boolean z11, @Nullable Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        this.vendorId = str;
        this.vendorCode = str2;
        this.isDarkstores = z11;
        this.lifeStyleMissionClickListener = function2;
    }

    public static /* synthetic */ MissionItemData copy$default(MissionItemData missionItemData, String str, String str2, boolean z11, Function2<String, String, Unit> function2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = missionItemData.vendorId;
        }
        if ((i11 & 2) != 0) {
            str2 = missionItemData.vendorCode;
        }
        if ((i11 & 4) != 0) {
            z11 = missionItemData.isDarkstores;
        }
        if ((i11 & 8) != 0) {
            function2 = missionItemData.lifeStyleMissionClickListener;
        }
        return missionItemData.copy(str, str2, z11, function2);
    }

    @NotNull
    public final String component1() {
        return this.vendorId;
    }

    @NotNull
    public final String component2() {
        return this.vendorCode;
    }

    public final boolean component3() {
        return this.isDarkstores;
    }

    @Nullable
    public final Function2<String, String, Unit> component4() {
        return this.lifeStyleMissionClickListener;
    }

    @NotNull
    public final MissionItemData copy(@NotNull String str, @NotNull String str2, boolean z11, @Nullable Function2<? super String, ? super String, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "vendorId");
        Intrinsics.checkNotNullParameter(str2, ObservableAttributesNames.VENDOR_CODE);
        return new MissionItemData(str, str2, z11, function2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MissionItemData)) {
            return false;
        }
        MissionItemData missionItemData = (MissionItemData) obj;
        return Intrinsics.areEqual((Object) this.vendorId, (Object) missionItemData.vendorId) && Intrinsics.areEqual((Object) this.vendorCode, (Object) missionItemData.vendorCode) && this.isDarkstores == missionItemData.isDarkstores && Intrinsics.areEqual((Object) this.lifeStyleMissionClickListener, (Object) missionItemData.lifeStyleMissionClickListener);
    }

    @Nullable
    public final Function2<String, String, Unit> getLifeStyleMissionClickListener() {
        return this.lifeStyleMissionClickListener;
    }

    @NotNull
    public final String getVendorCode() {
        return this.vendorCode;
    }

    @NotNull
    public final String getVendorId() {
        return this.vendorId;
    }

    public int hashCode() {
        int hashCode = ((this.vendorId.hashCode() * 31) + this.vendorCode.hashCode()) * 31;
        boolean z11 = this.isDarkstores;
        if (z11) {
            z11 = true;
        }
        int i11 = (hashCode + (z11 ? 1 : 0)) * 31;
        Function2<String, String, Unit> function2 = this.lifeStyleMissionClickListener;
        return i11 + (function2 == null ? 0 : function2.hashCode());
    }

    public final boolean isDarkstores() {
        return this.isDarkstores;
    }

    @NotNull
    public String toString() {
        String str = this.vendorId;
        String str2 = this.vendorCode;
        boolean z11 = this.isDarkstores;
        Function2<String, String, Unit> function2 = this.lifeStyleMissionClickListener;
        return "MissionItemData(vendorId=" + str + ", vendorCode=" + str2 + ", isDarkstores=" + z11 + ", lifeStyleMissionClickListener=" + function2 + ")";
    }
}
