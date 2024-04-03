package com.talabat.wallet.bnplmanager.domain.entity;

import com.talabat.mapper.ModelMapping;
import com.visa.checkout.Profile;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BK\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\b\u0012\b\b\u0002\u0010\n\u001a\u00020\b¢\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\bHÆ\u0003J\t\u0010\u001a\u001a\u00020\bHÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003JO\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\b2\b\b\u0002\u0010\n\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0016\u0010\t\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\n\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012¨\u0006\""}, d2 = {"Lcom/talabat/wallet/bnplmanager/domain/entity/BNPLPlan;", "", "id", "", "name", "description", "displayName", "paymentOffsetInDays", "", "paymentCycleInDays", "paymentCycles", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;III)V", "getDescription", "()Ljava/lang/String;", "getDisplayName", "getId", "getName", "getPaymentCycleInDays", "()I", "getPaymentCycles", "getPaymentOffsetInDays", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLPlan {
    @NotNull
    @ModelMapping({"description"})
    private final String description;
    @NotNull
    @ModelMapping({"displayName"})
    private final String displayName;
    @NotNull
    @ModelMapping({"id"})

    /* renamed from: id  reason: collision with root package name */
    private final String f12492id;
    @NotNull
    @ModelMapping({"name"})

    /* renamed from: name  reason: collision with root package name */
    private final String f12493name;
    @ModelMapping({"paymentCycleInDays"})
    private final int paymentCycleInDays;
    @ModelMapping({"paymentCycles"})
    private final int paymentCycles;
    @ModelMapping({"paymentOffsetInDays"})
    private final int paymentOffsetInDays;

    public BNPLPlan() {
        this((String) null, (String) null, (String) null, (String) null, 0, 0, 0, 127, (DefaultConstructorMarker) null);
    }

    public BNPLPlan(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, Profile.DISPLAY_NAME);
        this.f12492id = str;
        this.f12493name = str2;
        this.description = str3;
        this.displayName = str4;
        this.paymentOffsetInDays = i11;
        this.paymentCycleInDays = i12;
        this.paymentCycles = i13;
    }

    public static /* synthetic */ BNPLPlan copy$default(BNPLPlan bNPLPlan, String str, String str2, String str3, String str4, int i11, int i12, int i13, int i14, Object obj) {
        if ((i14 & 1) != 0) {
            str = bNPLPlan.f12492id;
        }
        if ((i14 & 2) != 0) {
            str2 = bNPLPlan.f12493name;
        }
        String str5 = str2;
        if ((i14 & 4) != 0) {
            str3 = bNPLPlan.description;
        }
        String str6 = str3;
        if ((i14 & 8) != 0) {
            str4 = bNPLPlan.displayName;
        }
        String str7 = str4;
        if ((i14 & 16) != 0) {
            i11 = bNPLPlan.paymentOffsetInDays;
        }
        int i15 = i11;
        if ((i14 & 32) != 0) {
            i12 = bNPLPlan.paymentCycleInDays;
        }
        int i16 = i12;
        if ((i14 & 64) != 0) {
            i13 = bNPLPlan.paymentCycles;
        }
        return bNPLPlan.copy(str, str5, str6, str7, i15, i16, i13);
    }

    @NotNull
    public final String component1() {
        return this.f12492id;
    }

    @NotNull
    public final String component2() {
        return this.f12493name;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final String component4() {
        return this.displayName;
    }

    public final int component5() {
        return this.paymentOffsetInDays;
    }

    public final int component6() {
        return this.paymentCycleInDays;
    }

    public final int component7() {
        return this.paymentCycles;
    }

    @NotNull
    public final BNPLPlan copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        Intrinsics.checkNotNullParameter(str4, Profile.DISPLAY_NAME);
        return new BNPLPlan(str, str2, str3, str4, i11, i12, i13);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLPlan)) {
            return false;
        }
        BNPLPlan bNPLPlan = (BNPLPlan) obj;
        return Intrinsics.areEqual((Object) this.f12492id, (Object) bNPLPlan.f12492id) && Intrinsics.areEqual((Object) this.f12493name, (Object) bNPLPlan.f12493name) && Intrinsics.areEqual((Object) this.description, (Object) bNPLPlan.description) && Intrinsics.areEqual((Object) this.displayName, (Object) bNPLPlan.displayName) && this.paymentOffsetInDays == bNPLPlan.paymentOffsetInDays && this.paymentCycleInDays == bNPLPlan.paymentCycleInDays && this.paymentCycles == bNPLPlan.paymentCycles;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    @NotNull
    public final String getId() {
        return this.f12492id;
    }

    @NotNull
    public final String getName() {
        return this.f12493name;
    }

    public final int getPaymentCycleInDays() {
        return this.paymentCycleInDays;
    }

    public final int getPaymentCycles() {
        return this.paymentCycles;
    }

    public final int getPaymentOffsetInDays() {
        return this.paymentOffsetInDays;
    }

    public int hashCode() {
        return (((((((((((this.f12492id.hashCode() * 31) + this.f12493name.hashCode()) * 31) + this.description.hashCode()) * 31) + this.displayName.hashCode()) * 31) + this.paymentOffsetInDays) * 31) + this.paymentCycleInDays) * 31) + this.paymentCycles;
    }

    @NotNull
    public String toString() {
        String str = this.f12492id;
        String str2 = this.f12493name;
        String str3 = this.description;
        String str4 = this.displayName;
        int i11 = this.paymentOffsetInDays;
        int i12 = this.paymentCycleInDays;
        int i13 = this.paymentCycles;
        return "BNPLPlan(id=" + str + ", name=" + str2 + ", description=" + str3 + ", displayName=" + str4 + ", paymentOffsetInDays=" + i11 + ", paymentCycleInDays=" + i12 + ", paymentCycles=" + i13 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BNPLPlan(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, int r10, int r11, int r12, int r13, kotlin.jvm.internal.DefaultConstructorMarker r14) {
        /*
            r5 = this;
            r14 = r13 & 1
            if (r14 == 0) goto L_0x000a
            kotlin.jvm.internal.StringCompanionObject r6 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r6 = com.talabat.talabatcommon.extentions.StringUtils.empty(r6)
        L_0x000a:
            r14 = r13 & 2
            if (r14 == 0) goto L_0x0014
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r7 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x0014:
            r14 = r7
            r7 = r13 & 4
            if (r7 == 0) goto L_0x001f
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r8 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x001f:
            r0 = r8
            r7 = r13 & 8
            if (r7 == 0) goto L_0x002a
            kotlin.jvm.internal.StringCompanionObject r7 = kotlin.jvm.internal.StringCompanionObject.INSTANCE
            java.lang.String r9 = com.talabat.talabatcommon.extentions.StringUtils.empty(r7)
        L_0x002a:
            r1 = r9
            r7 = r13 & 16
            r8 = 0
            if (r7 == 0) goto L_0x0032
            r2 = r8
            goto L_0x0033
        L_0x0032:
            r2 = r10
        L_0x0033:
            r7 = r13 & 32
            if (r7 == 0) goto L_0x0039
            r3 = r8
            goto L_0x003a
        L_0x0039:
            r3 = r11
        L_0x003a:
            r7 = r13 & 64
            if (r7 == 0) goto L_0x0040
            r4 = r8
            goto L_0x0041
        L_0x0040:
            r4 = r12
        L_0x0041:
            r7 = r5
            r8 = r6
            r9 = r14
            r10 = r0
            r11 = r1
            r12 = r2
            r13 = r3
            r14 = r4
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.bnplmanager.domain.entity.BNPLPlan.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, int, int, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
