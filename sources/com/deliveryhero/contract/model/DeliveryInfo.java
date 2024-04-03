package com.deliveryhero.contract.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 /2\u00020\u0001:\u0002./B]\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e¢\u0006\u0002\u0010\u000fBI\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u0010J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\u0007HÆ\u0003J[\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\u0003HÖ\u0001J\t\u0010&\u001a\u00020\u0007HÖ\u0001J!\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-HÇ\u0001R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0012¨\u00060"}, d2 = {"Lcom/deliveryhero/contract/model/DeliveryInfo;", "", "seen1", "", "id", "", "code", "", "amount", "address", "comments", "customer", "phoneNumber", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(IJLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(JLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getAmount", "getCode", "getComments", "getCustomer", "getId", "()J", "getPhoneNumber", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
public final class DeliveryInfo {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
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

    /* renamed from: id  reason: collision with root package name */
    private final long f29720id;
    @Nullable
    private final String phoneNumber;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/contract/model/DeliveryInfo$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/contract/model/DeliveryInfo;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final KSerializer<DeliveryInfo> serializer() {
            return DeliveryInfo$$serializer.INSTANCE;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ DeliveryInfo(int i11, long j11, String str, String str2, String str3, String str4, String str5, String str6, SerializationConstructorMarker serializationConstructorMarker) {
        if (127 != (i11 & 127)) {
            PluginExceptionsKt.throwMissingFieldException(i11, 127, DeliveryInfo$$serializer.INSTANCE.getDescriptor());
        }
        this.f29720id = j11;
        this.code = str;
        this.amount = str2;
        this.address = str3;
        this.comments = str4;
        this.customer = str5;
        this.phoneNumber = str6;
    }

    public static /* synthetic */ DeliveryInfo copy$default(DeliveryInfo deliveryInfo, long j11, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        DeliveryInfo deliveryInfo2 = deliveryInfo;
        return deliveryInfo.copy((i11 & 1) != 0 ? deliveryInfo2.f29720id : j11, (i11 & 2) != 0 ? deliveryInfo2.code : str, (i11 & 4) != 0 ? deliveryInfo2.amount : str2, (i11 & 8) != 0 ? deliveryInfo2.address : str3, (i11 & 16) != 0 ? deliveryInfo2.comments : str4, (i11 & 32) != 0 ? deliveryInfo2.customer : str5, (i11 & 64) != 0 ? deliveryInfo2.phoneNumber : str6);
    }

    @JvmStatic
    public static final void write$Self(@NotNull DeliveryInfo deliveryInfo, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(deliveryInfo, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeLongElement(serialDescriptor, 0, deliveryInfo.f29720id);
        StringSerializer stringSerializer = StringSerializer.INSTANCE;
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 1, stringSerializer, deliveryInfo.code);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 2, stringSerializer, deliveryInfo.amount);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 3, stringSerializer, deliveryInfo.address);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 4, stringSerializer, deliveryInfo.comments);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 5, stringSerializer, deliveryInfo.customer);
        compositeEncoder.encodeNullableSerializableElement(serialDescriptor, 6, stringSerializer, deliveryInfo.phoneNumber);
    }

    public final long component1() {
        return this.f29720id;
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
    public final DeliveryInfo copy(long j11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        return new DeliveryInfo(j11, str, str2, str3, str4, str5, str6);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DeliveryInfo)) {
            return false;
        }
        DeliveryInfo deliveryInfo = (DeliveryInfo) obj;
        return this.f29720id == deliveryInfo.f29720id && Intrinsics.areEqual((Object) this.code, (Object) deliveryInfo.code) && Intrinsics.areEqual((Object) this.amount, (Object) deliveryInfo.amount) && Intrinsics.areEqual((Object) this.address, (Object) deliveryInfo.address) && Intrinsics.areEqual((Object) this.comments, (Object) deliveryInfo.comments) && Intrinsics.areEqual((Object) this.customer, (Object) deliveryInfo.customer) && Intrinsics.areEqual((Object) this.phoneNumber, (Object) deliveryInfo.phoneNumber);
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

    public final long getId() {
        return this.f29720id;
    }

    @Nullable
    public final String getPhoneNumber() {
        return this.phoneNumber;
    }

    public int hashCode() {
        int a11 = a.a(this.f29720id) * 31;
        String str = this.code;
        int i11 = 0;
        int hashCode = (a11 + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.amount;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.address;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.comments;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.customer;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.phoneNumber;
        if (str6 != null) {
            i11 = str6.hashCode();
        }
        return hashCode5 + i11;
    }

    @NotNull
    public String toString() {
        return "DeliveryInfo(id=" + this.f29720id + ", code=" + this.code + ", amount=" + this.amount + ", address=" + this.address + ", comments=" + this.comments + ", customer=" + this.customer + ", phoneNumber=" + this.phoneNumber + ')';
    }

    public DeliveryInfo(long j11, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6) {
        this.f29720id = j11;
        this.code = str;
        this.amount = str2;
        this.address = str3;
        this.comments = str4;
        this.customer = str5;
        this.phoneNumber = str6;
    }
}
