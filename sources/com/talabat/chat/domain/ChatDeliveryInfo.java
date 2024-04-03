package com.talabat.chat.domain;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BY\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003Jb\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006%"}, d2 = {"Lcom/talabat/chat/domain/ChatDeliveryInfo;", "", "id", "", "code", "", "amount", "address", "comments", "customer", "phoneNumber", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getAmount", "getCode", "getComments", "getCustomer", "getId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getPhoneNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "(Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/chat/domain/ChatDeliveryInfo;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_chat_chat"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ChatDeliveryInfo {
    @Nullable
    private final String address;
    @Nullable
    private final String amount;
    @Nullable
    private final String code;
    @Nullable
    private final String comments;
    @Nullable
    private final String customer;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Long f55539id;
    @Nullable
    private final String phoneNumber;

    public ChatDeliveryInfo() {
        this((Long) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 127, (DefaultConstructorMarker) null);
    }

    public ChatDeliveryInfo(@Nullable Long l11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.f55539id = l11;
        this.code = str;
        this.amount = str2;
        this.address = str3;
        this.comments = str4;
        this.customer = str5;
        this.phoneNumber = str6;
    }

    public static /* synthetic */ ChatDeliveryInfo copy$default(ChatDeliveryInfo chatDeliveryInfo, Long l11, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            l11 = chatDeliveryInfo.f55539id;
        }
        if ((i11 & 2) != 0) {
            str = chatDeliveryInfo.code;
        }
        String str7 = str;
        if ((i11 & 4) != 0) {
            str2 = chatDeliveryInfo.amount;
        }
        String str8 = str2;
        if ((i11 & 8) != 0) {
            str3 = chatDeliveryInfo.address;
        }
        String str9 = str3;
        if ((i11 & 16) != 0) {
            str4 = chatDeliveryInfo.comments;
        }
        String str10 = str4;
        if ((i11 & 32) != 0) {
            str5 = chatDeliveryInfo.customer;
        }
        String str11 = str5;
        if ((i11 & 64) != 0) {
            str6 = chatDeliveryInfo.phoneNumber;
        }
        return chatDeliveryInfo.copy(l11, str7, str8, str9, str10, str11, str6);
    }

    @Nullable
    public final Long component1() {
        return this.f55539id;
    }

    @Nullable
    public final String component2() {
        return this.code;
    }

    @Nullable
    public final String component3() {
        return this.amount;
    }

    @Nullable
    public final String component4() {
        return this.address;
    }

    @Nullable
    public final String component5() {
        return this.comments;
    }

    @Nullable
    public final String component6() {
        return this.customer;
    }

    @Nullable
    public final String component7() {
        return this.phoneNumber;
    }

    @NotNull
    public final ChatDeliveryInfo copy(@Nullable Long l11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return new ChatDeliveryInfo(l11, str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ChatDeliveryInfo)) {
            return false;
        }
        ChatDeliveryInfo chatDeliveryInfo = (ChatDeliveryInfo) obj;
        return Intrinsics.areEqual((Object) this.f55539id, (Object) chatDeliveryInfo.f55539id) && Intrinsics.areEqual((Object) this.code, (Object) chatDeliveryInfo.code) && Intrinsics.areEqual((Object) this.amount, (Object) chatDeliveryInfo.amount) && Intrinsics.areEqual((Object) this.address, (Object) chatDeliveryInfo.address) && Intrinsics.areEqual((Object) this.comments, (Object) chatDeliveryInfo.comments) && Intrinsics.areEqual((Object) this.customer, (Object) chatDeliveryInfo.customer) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) chatDeliveryInfo.phoneNumber);
    }

    @Nullable
    public final String getAddress() {
        return this.address;
    }

    @Nullable
    public final String getAmount() {
        return this.amount;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getComments() {
        return this.comments;
    }

    @Nullable
    public final String getCustomer() {
        return this.customer;
    }

    @Nullable
    public final Long getId() {
        return this.f55539id;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int hashCode() {
        Long l11 = this.f55539id;
        int i11 = 0;
        int hashCode = (l11 == null ? 0 : l11.hashCode()) * 31;
        String str = this.code;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.amount;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.address;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.comments;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.customer;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.phoneNumber;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode6 + i11;
    }

    @NotNull
    public String toString() {
        Long l11 = this.f55539id;
        String str = this.code;
        String str2 = this.amount;
        String str3 = this.address;
        String str4 = this.comments;
        String str5 = this.customer;
        String str6 = this.phoneNumber;
        return "ChatDeliveryInfo(id=" + l11 + ", code=" + str + ", amount=" + str2 + ", address=" + str3 + ", comments=" + str4 + ", customer=" + str5 + ", phoneNumber=" + str6 + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ChatDeliveryInfo(java.lang.Long r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, int r14, kotlin.jvm.internal.DefaultConstructorMarker r15) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.chat.domain.ChatDeliveryInfo.<init>(java.lang.Long, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
