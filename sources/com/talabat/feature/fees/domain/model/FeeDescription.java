package com.talabat.feature.fees.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0005HÆ\u0003JK\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006 "}, d2 = {"Lcom/talabat/feature/fees/domain/model/FeeDescription;", "", "type", "Lcom/talabat/feature/fees/domain/model/FeeDescriptionType;", "name", "", "description", "localDescription", "url", "urlText", "(Lcom/talabat/feature/fees/domain/model/FeeDescriptionType;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getLocalDescription", "getName", "getType", "()Lcom/talabat/feature/fees/domain/model/FeeDescriptionType;", "getUrl", "getUrlText", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_pricing_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeeDescription {
    @NotNull
    private final String description;
    @Nullable
    private final String localDescription;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f58531name;
    @NotNull
    private final FeeDescriptionType type;
    @Nullable
    private final String url;
    @Nullable
    private final String urlText;

    public FeeDescription(@NotNull FeeDescriptionType feeDescriptionType, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(feeDescriptionType, "type");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "description");
        this.type = feeDescriptionType;
        this.f58531name = str;
        this.description = str2;
        this.localDescription = str3;
        this.url = str4;
        this.urlText = str5;
    }

    public static /* synthetic */ FeeDescription copy$default(FeeDescription feeDescription, FeeDescriptionType feeDescriptionType, String str, String str2, String str3, String str4, String str5, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            feeDescriptionType = feeDescription.type;
        }
        if ((i11 & 2) != 0) {
            str = feeDescription.f58531name;
        }
        String str6 = str;
        if ((i11 & 4) != 0) {
            str2 = feeDescription.description;
        }
        String str7 = str2;
        if ((i11 & 8) != 0) {
            str3 = feeDescription.localDescription;
        }
        String str8 = str3;
        if ((i11 & 16) != 0) {
            str4 = feeDescription.url;
        }
        String str9 = str4;
        if ((i11 & 32) != 0) {
            str5 = feeDescription.urlText;
        }
        return feeDescription.copy(feeDescriptionType, str6, str7, str8, str9, str5);
    }

    @NotNull
    public final FeeDescriptionType component1() {
        return this.type;
    }

    @NotNull
    public final String component2() {
        return this.f58531name;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @Nullable
    public final String component4() {
        return this.localDescription;
    }

    @Nullable
    public final String component5() {
        return this.url;
    }

    @Nullable
    public final String component6() {
        return this.urlText;
    }

    @NotNull
    public final FeeDescription copy(@NotNull FeeDescriptionType feeDescriptionType, @NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5) {
        Intrinsics.checkNotNullParameter(feeDescriptionType, "type");
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "description");
        return new FeeDescription(feeDescriptionType, str, str2, str3, str4, str5);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeeDescription)) {
            return false;
        }
        FeeDescription feeDescription = (FeeDescription) obj;
        return this.type == feeDescription.type && Intrinsics.areEqual((Object) this.f58531name, (Object) feeDescription.f58531name) && Intrinsics.areEqual((Object) this.description, (Object) feeDescription.description) && Intrinsics.areEqual((Object) this.localDescription, (Object) feeDescription.localDescription) && Intrinsics.areEqual((Object) this.url, (Object) feeDescription.url) && Intrinsics.areEqual((Object) this.urlText, (Object) feeDescription.urlText);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getLocalDescription() {
        return this.localDescription;
    }

    @NotNull
    public final String getName() {
        return this.f58531name;
    }

    @NotNull
    public final FeeDescriptionType getType() {
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
        int hashCode = ((((this.type.hashCode() * 31) + this.f58531name.hashCode()) * 31) + this.description.hashCode()) * 31;
        String str = this.localDescription;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.url;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.urlText;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        FeeDescriptionType feeDescriptionType = this.type;
        String str = this.f58531name;
        String str2 = this.description;
        String str3 = this.localDescription;
        String str4 = this.url;
        String str5 = this.urlText;
        return "FeeDescription(type=" + feeDescriptionType + ", name=" + str + ", description=" + str2 + ", localDescription=" + str3 + ", url=" + str4 + ", urlText=" + str5 + ")";
    }
}
