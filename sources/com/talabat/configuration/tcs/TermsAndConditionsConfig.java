package com.talabat.configuration.tcs;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\b\b\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\u0003J\u0006\u0010\b\u001a\u00020\u0003J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\n\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u0010\u000e\u001a\u00020\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0003J\u0006\u0010\u0012\u001a\u00020\u0003J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0015"}, d2 = {"Lcom/talabat/configuration/tcs/TermsAndConditionsConfig;", "", "termsAndConditionsUrl", "", "(Ljava/lang/String;)V", "getTermsAndConditionsUrl", "()Ljava/lang/String;", "aboutUrl", "checkoutPaymentTermsUrl", "component1", "copy", "equals", "", "other", "faqUrl", "hashCode", "", "privacyPolicyUrl", "termsOfUseUrl", "toString", "Companion", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TermsAndConditionsConfig {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final TermsAndConditionsConfig DEFAULT = new TermsAndConditionsConfig("https://talabat.com/uae");
    @NotNull
    private final String termsAndConditionsUrl;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/talabat/configuration/tcs/TermsAndConditionsConfig$Companion;", "", "()V", "DEFAULT", "Lcom/talabat/configuration/tcs/TermsAndConditionsConfig;", "getDEFAULT", "()Lcom/talabat/configuration/tcs/TermsAndConditionsConfig;", "com_talabat_core_configuration_remote_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TermsAndConditionsConfig getDEFAULT() {
            return TermsAndConditionsConfig.DEFAULT;
        }
    }

    public TermsAndConditionsConfig(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "termsAndConditionsUrl");
        this.termsAndConditionsUrl = str;
    }

    public static /* synthetic */ TermsAndConditionsConfig copy$default(TermsAndConditionsConfig termsAndConditionsConfig, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = termsAndConditionsConfig.termsAndConditionsUrl;
        }
        return termsAndConditionsConfig.copy(str);
    }

    @NotNull
    public final String aboutUrl() {
        String str = this.termsAndConditionsUrl;
        return str + "/about-us?src=app";
    }

    @NotNull
    public final String checkoutPaymentTermsUrl() {
        String str = this.termsAndConditionsUrl;
        return str + "/termsandconditions?t={type}&pm={pm}";
    }

    @NotNull
    public final String component1() {
        return this.termsAndConditionsUrl;
    }

    @NotNull
    public final TermsAndConditionsConfig copy(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "termsAndConditionsUrl");
        return new TermsAndConditionsConfig(str);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof TermsAndConditionsConfig) && Intrinsics.areEqual((Object) this.termsAndConditionsUrl, (Object) ((TermsAndConditionsConfig) obj).termsAndConditionsUrl);
    }

    @NotNull
    public final String faqUrl() {
        String str = this.termsAndConditionsUrl;
        return str + "/faq?src=app";
    }

    @NotNull
    public final String getTermsAndConditionsUrl() {
        return this.termsAndConditionsUrl;
    }

    public int hashCode() {
        return this.termsAndConditionsUrl.hashCode();
    }

    @NotNull
    public final String privacyPolicyUrl() {
        String str = this.termsAndConditionsUrl;
        return str + "/privacy?src=app";
    }

    @NotNull
    public final String termsOfUseUrl() {
        String str = this.termsAndConditionsUrl;
        return str + "/terms?src=app";
    }

    @NotNull
    public String toString() {
        String str = this.termsAndConditionsUrl;
        return "TermsAndConditionsConfig(termsAndConditionsUrl=" + str + ")";
    }
}
