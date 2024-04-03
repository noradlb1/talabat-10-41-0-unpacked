package com.talabat.core.navigation.domain.screen.checkout;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J?\u0010\u0014\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/talabat/core/navigation/domain/screen/checkout/ExitPointFeeDescription;", "", "type", "", "name", "description", "url", "urlText", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getName", "getType", "getUrl", "getUrlText", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_core_navigation_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ExitPointFeeDescription {
    @NotNull
    private final String description;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f55952name;
    @NotNull
    private final String type;
    @Nullable
    private final String url;
    @Nullable
    private final String urlText;

    public ExitPointFeeDescription(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        this.type = str;
        this.f55952name = str2;
        this.description = str3;
        this.url = str4;
        this.urlText = str5;
    }

    public static /* synthetic */ ExitPointFeeDescription copy$default(ExitPointFeeDescription exitPointFeeDescription, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = exitPointFeeDescription.type;
        }
        if ((i11 & 2) != 0) {
            str2 = exitPointFeeDescription.f55952name;
        }
        String str6 = str2;
        if ((i11 & 4) != 0) {
            str3 = exitPointFeeDescription.description;
        }
        String str7 = str3;
        if ((i11 & 8) != 0) {
            str4 = exitPointFeeDescription.url;
        }
        String str8 = str4;
        if ((i11 & 16) != 0) {
            str5 = exitPointFeeDescription.urlText;
        }
        return exitPointFeeDescription.copy(str, str6, str7, str8, str5);
    }

    @NotNull
    public final String component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.f55952name;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final String component4() {
        return this.url;
    }

    @Nullable
    public final String component5() {
        return this.urlText;
    }

    @NotNull
    public final ExitPointFeeDescription copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(str, "type");
        Intrinsics.checkNotNullParameter(str2, "name");
        Intrinsics.checkNotNullParameter(str3, "description");
        return new ExitPointFeeDescription(str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ExitPointFeeDescription)) {
            return false;
        }
        ExitPointFeeDescription exitPointFeeDescription = (ExitPointFeeDescription) obj;
        return Intrinsics.areEqual((Object) this.type, (Object) exitPointFeeDescription.type) && Intrinsics.areEqual((Object) this.f55952name, (Object) exitPointFeeDescription.f55952name) && Intrinsics.areEqual((Object) this.description, (Object) exitPointFeeDescription.description) && Intrinsics.areEqual((Object) this.url, (Object) exitPointFeeDescription.url) && Intrinsics.areEqual((Object) this.urlText, (Object) exitPointFeeDescription.urlText);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getName() {
        return this.f55952name;
    }

    @NotNull
    public final String getType() {
        return this.type;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getUrlText() {
        return this.urlText;
    }

    public int hashCode() {
        int hashCode = ((((this.type.hashCode() * 31) + this.f55952name.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str = this.url;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.urlText;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.type;
        String str2 = this.f55952name;
        String str3 = this.description;
        String str4 = this.url;
        String str5 = this.urlText;
        return "ExitPointFeeDescription(type=" + str + ", name=" + str2 + ", description=" + str3 + ", url=" + str4 + ", urlText=" + str5 + ")";
    }
}
