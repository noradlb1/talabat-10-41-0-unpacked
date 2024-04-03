package com.deliveryhero.contract.model;

import java.util.List;
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
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.PluginExceptionsKt;
import kotlinx.serialization.internal.SerializationConstructorMarker;
import kotlinx.serialization.internal.StringSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000 \u001a2\u00020\u0001:\u0003\u001a\u001b\u001cB1\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bB\u001d\b\u0004\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\fJ\u0006\u0010\u0011\u001a\u00020\bJ\b\u0010\u0012\u001a\u0004\u0018\u00010\u0006J!\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019HÇ\u0001R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010\u0001\u0002\u001d\u001e¨\u0006\u001f"}, d2 = {"Lcom/deliveryhero/contract/model/Translations;", "", "seen1", "", "supportedTranslationsList", "", "", "shouldShowOriginalWithTranslated", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Z)V", "getShouldShowOriginalWithTranslated", "()Z", "getSupportedTranslationsList", "()Ljava/util/List;", "isEnabled", "preferredLanguage", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "Companion", "DISABLED", "ENABLED", "Lcom/deliveryhero/contract/model/Translations$ENABLED;", "Lcom/deliveryhero/contract/model/Translations$DISABLED;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Serializable
public abstract class Translations {
    /* access modifiers changed from: private */
    @NotNull
    public static final Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, Translations$Companion$$cachedSerializer$delegate$1.INSTANCE);
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final boolean shouldShowOriginalWithTranslated;
    @NotNull
    private final List<String> supportedTranslationsList;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/contract/model/Translations$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/contract/model/Translations;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return Translations.$cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer<Translations> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00000\u0004HÆ\u0001¨\u0006\u0005"}, d2 = {"Lcom/deliveryhero/contract/model/Translations$DISABLED;", "Lcom/deliveryhero/contract/model/Translations;", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    public static final class DISABLED extends Translations {
        private static final /* synthetic */ Lazy<KSerializer<Object>> $cachedSerializer$delegate = LazyKt__LazyJVMKt.lazy(LazyThreadSafetyMode.PUBLICATION, Translations$DISABLED$$cachedSerializer$delegate$1.INSTANCE);
        @NotNull
        public static final DISABLED INSTANCE = new DISABLED();

        private DISABLED() {
            super(CollectionsKt__CollectionsKt.emptyList(), false, (DefaultConstructorMarker) null);
        }

        private final /* synthetic */ Lazy get$cachedSerializer$delegate() {
            return $cachedSerializer$delegate;
        }

        @NotNull
        public final KSerializer<DISABLED> serializer() {
            return (KSerializer) get$cachedSerializer$delegate().getValue();
        }
    }

    @Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 '2\u00020\u0001:\u0002&'BS\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\u000b\u001a\u00020\b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eB%\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\b¢\u0006\u0002\u0010\u000fJ\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0006HÆ\u0003J\t\u0010\u0018\u001a\u00020\bHÆ\u0003J-\u0010\u0019\u001a\u00020\u00002\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0006HÖ\u0001J!\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%HÇ\u0001R\u0011\u0010\n\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006("}, d2 = {"Lcom/deliveryhero/contract/model/Translations$ENABLED;", "Lcom/deliveryhero/contract/model/Translations;", "seen1", "", "supportedTranslationsList", "", "", "shouldShowOriginalWithTranslated", "", "supportedTranslations", "preferredLanguage", "showOriginalWithTranslated", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/util/List;ZLjava/util/List;Ljava/lang/String;ZLkotlinx/serialization/internal/SerializationConstructorMarker;)V", "(Ljava/util/List;Ljava/lang/String;Z)V", "getPreferredLanguage", "()Ljava/lang/String;", "getShowOriginalWithTranslated", "()Z", "getSupportedTranslations", "()Ljava/util/List;", "component1", "component2", "component3", "copy", "equals", "other", "", "hashCode", "toString", "write$Self", "", "self", "output", "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "$serializer", "Companion", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
    @Serializable
    public static final class ENABLED extends Translations {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        @NotNull
        private final String preferredLanguage;
        private final boolean showOriginalWithTranslated;
        @NotNull
        private final List<String> supportedTranslations;

        @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004HÆ\u0001¨\u0006\u0006"}, d2 = {"Lcom/deliveryhero/contract/model/Translations$ENABLED$Companion;", "", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/deliveryhero/contract/model/Translations$ENABLED;", "customerchat_basicRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final KSerializer<ENABLED> serializer() {
                return Translations$ENABLED$$serializer.INSTANCE;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
        public /* synthetic */ ENABLED(int i11, List list, boolean z11, List list2, String str, boolean z12, SerializationConstructorMarker serializationConstructorMarker) {
            super(i11, list, z11, serializationConstructorMarker);
            if (15 != (i11 & 15)) {
                PluginExceptionsKt.throwMissingFieldException(i11, 15, Translations$ENABLED$$serializer.INSTANCE.getDescriptor());
            }
            this.supportedTranslations = list2;
            this.preferredLanguage = str;
            if ((i11 & 16) == 0) {
                this.showOriginalWithTranslated = false;
            } else {
                this.showOriginalWithTranslated = z12;
            }
        }

        public static /* synthetic */ ENABLED copy$default(ENABLED enabled, List<String> list, String str, boolean z11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = enabled.supportedTranslations;
            }
            if ((i11 & 2) != 0) {
                str = enabled.preferredLanguage;
            }
            if ((i11 & 4) != 0) {
                z11 = enabled.showOriginalWithTranslated;
            }
            return enabled.copy(list, str, z11);
        }

        @JvmStatic
        public static final void write$Self(@NotNull ENABLED enabled, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
            Intrinsics.checkNotNullParameter(enabled, "self");
            Intrinsics.checkNotNullParameter(compositeEncoder, "output");
            Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
            Translations.write$Self(enabled, compositeEncoder, serialDescriptor);
            compositeEncoder.encodeSerializableElement(serialDescriptor, 2, new ArrayListSerializer(StringSerializer.INSTANCE), enabled.supportedTranslations);
            compositeEncoder.encodeStringElement(serialDescriptor, 3, enabled.preferredLanguage);
            boolean z11 = true;
            if (!compositeEncoder.shouldEncodeElementDefault(serialDescriptor, 4) && !enabled.showOriginalWithTranslated) {
                z11 = false;
            }
            if (z11) {
                compositeEncoder.encodeBooleanElement(serialDescriptor, 4, enabled.showOriginalWithTranslated);
            }
        }

        @NotNull
        public final List<String> component1() {
            return this.supportedTranslations;
        }

        @NotNull
        public final String component2() {
            return this.preferredLanguage;
        }

        public final boolean component3() {
            return this.showOriginalWithTranslated;
        }

        @NotNull
        public final ENABLED copy(@NotNull List<String> list, @NotNull String str, boolean z11) {
            Intrinsics.checkNotNullParameter(list, "supportedTranslations");
            Intrinsics.checkNotNullParameter(str, "preferredLanguage");
            return new ENABLED(list, str, z11);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ENABLED)) {
                return false;
            }
            ENABLED enabled = (ENABLED) obj;
            return Intrinsics.areEqual((Object) this.supportedTranslations, (Object) enabled.supportedTranslations) && Intrinsics.areEqual((Object) this.preferredLanguage, (Object) enabled.preferredLanguage) && this.showOriginalWithTranslated == enabled.showOriginalWithTranslated;
        }

        @NotNull
        public final String getPreferredLanguage() {
            return this.preferredLanguage;
        }

        public final boolean getShowOriginalWithTranslated() {
            return this.showOriginalWithTranslated;
        }

        @NotNull
        public final List<String> getSupportedTranslations() {
            return this.supportedTranslations;
        }

        public int hashCode() {
            int hashCode = ((this.supportedTranslations.hashCode() * 31) + this.preferredLanguage.hashCode()) * 31;
            boolean z11 = this.showOriginalWithTranslated;
            if (z11) {
                z11 = true;
            }
            return hashCode + (z11 ? 1 : 0);
        }

        @NotNull
        public String toString() {
            return "ENABLED(supportedTranslations=" + this.supportedTranslations + ", preferredLanguage=" + this.preferredLanguage + ", showOriginalWithTranslated=" + this.showOriginalWithTranslated + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ ENABLED(List list, String str, boolean z11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this(list, str, (i11 & 4) != 0 ? false : z11);
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ENABLED(@NotNull List<String> list, @NotNull String str, boolean z11) {
            super(list, z11, (DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "supportedTranslations");
            Intrinsics.checkNotNullParameter(str, "preferredLanguage");
            this.supportedTranslations = list;
            this.preferredLanguage = str;
            this.showOriginalWithTranslated = z11;
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "This synthesized declaration should not be used directly", replaceWith = @ReplaceWith(expression = "", imports = {}))
    public /* synthetic */ Translations(int i11, List list, boolean z11, SerializationConstructorMarker serializationConstructorMarker) {
        this.supportedTranslationsList = list;
        this.shouldShowOriginalWithTranslated = z11;
    }

    public /* synthetic */ Translations(List list, boolean z11, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, z11);
    }

    @JvmStatic
    public static final void write$Self(@NotNull Translations translations, @NotNull CompositeEncoder compositeEncoder, @NotNull SerialDescriptor serialDescriptor) {
        Intrinsics.checkNotNullParameter(translations, "self");
        Intrinsics.checkNotNullParameter(compositeEncoder, "output");
        Intrinsics.checkNotNullParameter(serialDescriptor, "serialDesc");
        compositeEncoder.encodeSerializableElement(serialDescriptor, 0, new ArrayListSerializer(StringSerializer.INSTANCE), translations.supportedTranslationsList);
        compositeEncoder.encodeBooleanElement(serialDescriptor, 1, translations.shouldShowOriginalWithTranslated);
    }

    public final boolean getShouldShowOriginalWithTranslated() {
        return this.shouldShowOriginalWithTranslated;
    }

    @NotNull
    public final List<String> getSupportedTranslationsList() {
        return this.supportedTranslationsList;
    }

    public final boolean isEnabled() {
        return this instanceof ENABLED;
    }

    @Nullable
    public final String preferredLanguage() {
        if (this instanceof ENABLED) {
            ENABLED enabled = (ENABLED) this;
            if (!StringsKt__StringsJVMKt.isBlank(enabled.getPreferredLanguage())) {
                return enabled.getPreferredLanguage();
            }
        }
        return null;
    }

    private Translations(List<String> list, boolean z11) {
        this.supportedTranslationsList = list;
        this.shouldShowOriginalWithTranslated = z11;
    }
}
