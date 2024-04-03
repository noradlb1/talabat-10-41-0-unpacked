package com.talabat.wallet.bnplmanager.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\u0012Jb\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020\bHÖ\u0001J\t\u0010#\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u001a\u0010\t\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0004¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012¨\u0006$"}, d2 = {"Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPlanRemoteDto;", "", "id", "", "name", "description", "displayName", "paymentOffsetInDays", "", "paymentCycleInDays", "paymentCycles", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDescription", "()Ljava/lang/String;", "getDisplayName", "getId", "getName", "getPaymentCycleInDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPaymentCycles", "getPaymentOffsetInDays", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/talabat/wallet/bnplmanager/data/remote/dto/BNPLPlanRemoteDto;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_WalletSquad_WalletSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BNPLPlanRemoteDto {
    @SerializedName("description")
    @Nullable
    private final String description;
    @SerializedName("displayName")
    @Nullable
    private final String displayName;
    @SerializedName("id")
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f12461id;
    @SerializedName("name")
    @Nullable

    /* renamed from: name  reason: collision with root package name */
    private final String f12462name;
    @SerializedName("paymentCycleInDays")
    @Nullable
    private final Integer paymentCycleInDays;
    @SerializedName("paymentCycles")
    @Nullable
    private final Integer paymentCycles;
    @SerializedName("paymentOffsetInDays")
    @Nullable
    private final Integer paymentOffsetInDays;

    public BNPLPlanRemoteDto() {
        this((String) null, (String) null, (String) null, (String) null, (Integer) null, (Integer) null, (Integer) null, 127, (DefaultConstructorMarker) null);
    }

    public BNPLPlanRemoteDto(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        this.f12461id = str;
        this.f12462name = str2;
        this.description = str3;
        this.displayName = str4;
        this.paymentOffsetInDays = num;
        this.paymentCycleInDays = num2;
        this.paymentCycles = num3;
    }

    public static /* synthetic */ BNPLPlanRemoteDto copy$default(BNPLPlanRemoteDto bNPLPlanRemoteDto, String str, String str2, String str3, String str4, Integer num, Integer num2, Integer num3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = bNPLPlanRemoteDto.f12461id;
        }
        if ((i11 & 2) != 0) {
            str2 = bNPLPlanRemoteDto.f12462name;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            str3 = bNPLPlanRemoteDto.description;
        }
        String str6 = str3;
        if ((i11 & 8) != 0) {
            str4 = bNPLPlanRemoteDto.displayName;
        }
        String str7 = str4;
        if ((i11 & 16) != 0) {
            num = bNPLPlanRemoteDto.paymentOffsetInDays;
        }
        Integer num4 = num;
        if ((i11 & 32) != 0) {
            num2 = bNPLPlanRemoteDto.paymentCycleInDays;
        }
        Integer num5 = num2;
        if ((i11 & 64) != 0) {
            num3 = bNPLPlanRemoteDto.paymentCycles;
        }
        return bNPLPlanRemoteDto.copy(str, str5, str6, str7, num4, num5, num3);
    }

    @Nullable
    public final String component1() {
        return this.f12461id;
    }

    @Nullable
    public final String component2() {
        return this.f12462name;
    }

    @Nullable
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final String component4() {
        return this.displayName;
    }

    @Nullable
    public final Integer component5() {
        return this.paymentOffsetInDays;
    }

    @Nullable
    public final Integer component6() {
        return this.paymentCycleInDays;
    }

    @Nullable
    public final Integer component7() {
        return this.paymentCycles;
    }

    @NotNull
    public final BNPLPlanRemoteDto copy(@Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable Integer num, @Nullable Integer num2, @Nullable Integer num3) {
        return new BNPLPlanRemoteDto(str, str2, str3, str4, num, num2, num3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BNPLPlanRemoteDto)) {
            return false;
        }
        BNPLPlanRemoteDto bNPLPlanRemoteDto = (BNPLPlanRemoteDto) obj;
        return Intrinsics.areEqual((Object) this.f12461id, (Object) bNPLPlanRemoteDto.f12461id) && Intrinsics.areEqual((Object) this.f12462name, (Object) bNPLPlanRemoteDto.f12462name) && Intrinsics.areEqual((Object) this.description, (Object) bNPLPlanRemoteDto.description) && Intrinsics.areEqual((Object) this.displayName, (Object) bNPLPlanRemoteDto.displayName) && Intrinsics.areEqual((Object) this.paymentOffsetInDays, (Object) bNPLPlanRemoteDto.paymentOffsetInDays) && Intrinsics.areEqual((Object) this.paymentCycleInDays, (Object) bNPLPlanRemoteDto.paymentCycleInDays) && Intrinsics.areEqual((Object) this.paymentCycles, (Object) bNPLPlanRemoteDto.paymentCycles);
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getDisplayName() {
        return this.displayName;
    }

    @Nullable
    public final String getId() {
        return this.f12461id;
    }

    @Nullable
    public final String getName() {
        return this.f12462name;
    }

    @Nullable
    public final Integer getPaymentCycleInDays() {
        return this.paymentCycleInDays;
    }

    @Nullable
    public final Integer getPaymentCycles() {
        return this.paymentCycles;
    }

    @Nullable
    public final Integer getPaymentOffsetInDays() {
        return this.paymentOffsetInDays;
    }

    public int hashCode() {
        String str = this.f12461id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.f12462name;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.displayName;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        Integer num = this.paymentOffsetInDays;
        int hashCode5 = (hashCode4 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.paymentCycleInDays;
        int hashCode6 = (hashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.paymentCycles;
        if (num3 != null) {
            i11 = num3.hashCode();
        }
        return hashCode6 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f12461id;
        String str2 = this.f12462name;
        String str3 = this.description;
        String str4 = this.displayName;
        Integer num = this.paymentOffsetInDays;
        Integer num2 = this.paymentCycleInDays;
        Integer num3 = this.paymentCycles;
        return "BNPLPlanRemoteDto(id=" + str + ", name=" + str2 + ", description=" + str3 + ", displayName=" + str4 + ", paymentOffsetInDays=" + num + ", paymentCycleInDays=" + num2 + ", paymentCycles=" + num3 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ BNPLPlanRemoteDto(java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.Integer r11, java.lang.Integer r12, java.lang.Integer r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
        /*
            r6 = this;
            r15 = r14 & 1
            r0 = 0
            if (r15 == 0) goto L_0x0007
            r15 = r0
            goto L_0x0008
        L_0x0007:
            r15 = r7
        L_0x0008:
            r7 = r14 & 2
            if (r7 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r8
        L_0x000f:
            r7 = r14 & 4
            if (r7 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r9
        L_0x0016:
            r7 = r14 & 8
            if (r7 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r10
        L_0x001d:
            r7 = r14 & 16
            if (r7 == 0) goto L_0x0023
            r4 = r0
            goto L_0x0024
        L_0x0023:
            r4 = r11
        L_0x0024:
            r7 = r14 & 32
            if (r7 == 0) goto L_0x002a
            r5 = r0
            goto L_0x002b
        L_0x002a:
            r5 = r12
        L_0x002b:
            r7 = r14 & 64
            if (r7 == 0) goto L_0x0031
            r14 = r0
            goto L_0x0032
        L_0x0031:
            r14 = r13
        L_0x0032:
            r7 = r6
            r8 = r15
            r9 = r1
            r10 = r2
            r11 = r3
            r12 = r4
            r13 = r5
            r7.<init>(r8, r9, r10, r11, r12, r13, r14)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.wallet.bnplmanager.data.remote.dto.BNPLPlanRemoteDto.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.Integer, java.lang.Integer, java.lang.Integer, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
