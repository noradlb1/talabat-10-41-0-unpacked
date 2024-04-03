package com.talabat.feature.fees.presentation.displaymodel;

import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@StabilityInferred(parameters = 0)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J5\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/fees/presentation/displaymodel/DisclaimerBannerDisplayModel;", "", "title", "", "description", "action", "actionUrl", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAction", "()Ljava/lang/String;", "getActionUrl", "getDescription", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_pricing_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DisclaimerBannerDisplayModel {
    public static final int $stable = 0;
    @Nullable
    private final String action;
    @Nullable
    private final String actionUrl;
    @NotNull
    private final String description;
    @NotNull
    private final String title;

    public DisclaimerBannerDisplayModel(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        this.title = str;
        this.description = str2;
        this.action = str3;
        this.actionUrl = str4;
    }

    public static /* synthetic */ DisclaimerBannerDisplayModel copy$default(DisclaimerBannerDisplayModel disclaimerBannerDisplayModel, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = disclaimerBannerDisplayModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = disclaimerBannerDisplayModel.description;
        }
        if ((i11 & 4) != 0) {
            str3 = disclaimerBannerDisplayModel.action;
        }
        if ((i11 & 8) != 0) {
            str4 = disclaimerBannerDisplayModel.actionUrl;
        }
        return disclaimerBannerDisplayModel.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final String component3() {
        return this.action;
    }

    @Nullable
    public final String component4() {
        return this.actionUrl;
    }

    @NotNull
    public final DisclaimerBannerDisplayModel copy(@NotNull String str, @NotNull String str2, @Nullable String str3, @Nullable String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "description");
        return new DisclaimerBannerDisplayModel(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DisclaimerBannerDisplayModel)) {
            return false;
        }
        DisclaimerBannerDisplayModel disclaimerBannerDisplayModel = (DisclaimerBannerDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) disclaimerBannerDisplayModel.title) && Intrinsics.areEqual((Object) this.description, (Object) disclaimerBannerDisplayModel.description) && Intrinsics.areEqual((Object) this.action, (Object) disclaimerBannerDisplayModel.action) && Intrinsics.areEqual((Object) this.actionUrl, (Object) disclaimerBannerDisplayModel.actionUrl);
    }

    @Nullable
    public final String getAction() {
        return this.action;
    }

    @Nullable
    public final String getActionUrl() {
        return this.actionUrl;
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        int hashCode = ((this.title.hashCode() * 31) + this.description.hashCode()) * 31;
        String str = this.action;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.actionUrl;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.description;
        String str3 = this.action;
        String str4 = this.actionUrl;
        return "DisclaimerBannerDisplayModel(title=" + str + ", description=" + str2 + ", action=" + str3 + ", actionUrl=" + str4 + ")";
    }
}
