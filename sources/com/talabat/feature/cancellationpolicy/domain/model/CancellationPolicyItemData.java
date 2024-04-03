package com.talabat.feature.cancellationpolicy.domain.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/domain/model/CancellationPolicyItemData;", "", "icon", "", "title", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getIcon", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_helpcenter_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyItemData {
    @NotNull
    private final String description;
    @NotNull
    private final String icon;
    @NotNull
    private final String title;

    public CancellationPolicyItemData(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "icon");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        this.icon = str;
        this.title = str2;
        this.description = str3;
    }

    public static /* synthetic */ CancellationPolicyItemData copy$default(CancellationPolicyItemData cancellationPolicyItemData, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = cancellationPolicyItemData.icon;
        }
        if ((i11 & 2) != 0) {
            str2 = cancellationPolicyItemData.title;
        }
        if ((i11 & 4) != 0) {
            str3 = cancellationPolicyItemData.description;
        }
        return cancellationPolicyItemData.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.icon;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final String component3() {
        return this.description;
    }

    @NotNull
    public final CancellationPolicyItemData copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "icon");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        return new CancellationPolicyItemData(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CancellationPolicyItemData)) {
            return false;
        }
        CancellationPolicyItemData cancellationPolicyItemData = (CancellationPolicyItemData) obj;
        return Intrinsics.areEqual((Object) this.icon, (Object) cancellationPolicyItemData.icon) && Intrinsics.areEqual((Object) this.title, (Object) cancellationPolicyItemData.title) && Intrinsics.areEqual((Object) this.description, (Object) cancellationPolicyItemData.description);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getIcon() {
        return this.icon;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.icon.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.icon;
        String str2 = this.title;
        String str3 = this.description;
        return "CancellationPolicyItemData(icon=" + str + ", title=" + str2 + ", description=" + str3 + ")";
    }
}
