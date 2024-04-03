package com.deliveryhero.contract.model;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Lazy;
import kotlin.LazyThreadSafetyMode;
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
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u000f2\u00020\u0001:\u0005\u000f\u0010\u0011\u0012\u0013B\u0019\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0007J!\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eHÇ\u0001\u0001\u0004\u0014\u0015\u0016\u0017¨\u0006\u0018"}, d2 = {"Lcom/deliveryhero/contract/model/PhoneCallType;", "", "seen1", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILkotlinx/serialization/internal/SerializationConstructorMarker;)V", "()V", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "Masked", "None", "Normal", "Toku", "Lcom/deliveryhero/contract/model/PhoneCallType$Normal;", "Lcom/deliveryhero/contract/model/PhoneCallType$Masked;", "Lcom/deliveryhero/contract/model/PhoneCallType$Toku;", "Lcom/deliveryhero/contract/model/PhoneCallType$None;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
public abstract class PhoneCallType {
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, PhoneCallType$Companion$$cachedSerializer$delegate$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/contract/model/PhoneCallType$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/contract/model/PhoneCallType;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return PhoneCallType.$cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer<PhoneCallType> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/contract/model/PhoneCallType$Masked;", "Lcom/deliveryhero/contract/model/PhoneCallType;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    public static final class Masked extends PhoneCallType {
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, PhoneCallType$Masked$$cachedSerializer$delegate$1.INSTANCE);
        @NotNull
        public static final Masked INSTANCE = new Masked();

        private Masked() {
            super((DefaultConstructorMarker) null);
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return $cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer<Masked> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/contract/model/PhoneCallType$None;", "Lcom/deliveryhero/contract/model/PhoneCallType;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    public static final class None extends PhoneCallType {
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, PhoneCallType$None$$cachedSerializer$delegate$1.INSTANCE);
        @NotNull
        public static final None INSTANCE = new None();

        private None() {
            super((DefaultConstructorMarker) null);
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return $cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer<None> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/contract/model/PhoneCallType$Normal;", "Lcom/deliveryhero/contract/model/PhoneCallType;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    public static final class Normal extends PhoneCallType {
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, PhoneCallType$Normal$$cachedSerializer$delegate$1.INSTANCE);
        @NotNull
        public static final Normal INSTANCE = new Normal();

        private Normal() {
            super((DefaultConstructorMarker) null);
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return $cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer<Normal> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u001c2\u00020\u0001:\u0002\u001b\u001cB#\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\tJ\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u0013\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0005HÖ\u0001J!\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aHÇ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u001d"}, d2 = {"Lcom/deliveryhero/contract/model/PhoneCallType$Toku;", "Lcom/deliveryhero/contract/model/PhoneCallType;", "seen1", "", "licenseKey", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/lang/String;)V", "getLicenseKey", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    public static final class Toku extends PhoneCallType {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        private final String licenseKey;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/contract/model/PhoneCallType$Toku$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/contract/model/PhoneCallType$Toku;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final KSerializer<Toku> serializer() {
                return PhoneCallType$Toku$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ Toku(int i11, String str, SerializationConstructorMarker serializationConstructorMarker) {
            super(i11, serializationConstructorMarker);
            if (1 != (i11 & 1)) {
                PluginExceptionsKt.throwMissingFieldException(i11, 1, PhoneCallType$Toku$$serializer.INSTANCE.getDescriptor());
            }
            this.licenseKey = str;
        }

        public static /* synthetic */ Toku copy$default(Toku toku, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = toku.licenseKey;
            }
            return toku.copy(str);
        }

        @JvmStatic
        public static final void write$Self(@NotNull Toku toku, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(toku, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            PhoneCallType.write$Self(toku, compositeEncoder, serialDescriptor);
            compositeEncoder.encodeStringElement(serialDescriptor, 0, toku.licenseKey);
        }

        @NotNull
        public final String component1() {
            return this.licenseKey;
        }

        @NotNull
        public final Toku copy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "licenseKey");
            return new Toku(str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Toku) && Intrinsics.areEqual((Object) this.licenseKey, (Object) ((Toku) obj).licenseKey);
        }

        @NotNull
        public final String getLicenseKey() {
            return this.licenseKey;
        }

        public int hashCode() {
            return this.licenseKey.hashCode();
        }

        @NotNull
        public String toString() {
            return "Toku(licenseKey=" + this.licenseKey + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Toku(@NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "licenseKey");
            this.licenseKey = str;
        }
    }

    private PhoneCallType() {
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ PhoneCallType(int i11, SerializationConstructorMarker serializationConstructorMarker) {
    }

    public /* synthetic */ PhoneCallType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static final void write$Self(@NotNull PhoneCallType phoneCallType, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(phoneCallType, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
    }
}
