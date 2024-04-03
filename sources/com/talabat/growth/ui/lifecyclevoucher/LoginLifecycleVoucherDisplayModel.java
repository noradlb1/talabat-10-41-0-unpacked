package com.talabat.growth.ui.lifecyclevoucher;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J1\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0018"}, d2 = {"Lcom/talabat/growth/ui/lifecyclevoucher/LoginLifecycleVoucherDisplayModel;", "", "title", "", "tag", "termsAndConditions", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "getTag", "getTermsAndConditions", "getTitle", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LoginLifecycleVoucherDisplayModel {
    @NotNull
    private final String description;
    @NotNull
    private final String tag;
    @NotNull
    private final String termsAndConditions;
    @NotNull
    private final String title;

    public LoginLifecycleVoucherDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Intrinsics.checkNotNullParameter(str3, "termsAndConditions");
        Intrinsics.checkNotNullParameter(str4, "description");
        this.title = str;
        this.tag = str2;
        this.termsAndConditions = str3;
        this.description = str4;
    }

    public static /* synthetic */ LoginLifecycleVoucherDisplayModel copy$default(LoginLifecycleVoucherDisplayModel loginLifecycleVoucherDisplayModel, String str, String str2, String str3, String str4, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = loginLifecycleVoucherDisplayModel.title;
        }
        if ((i11 & 2) != 0) {
            str2 = loginLifecycleVoucherDisplayModel.tag;
        }
        if ((i11 & 4) != 0) {
            str3 = loginLifecycleVoucherDisplayModel.termsAndConditions;
        }
        if ((i11 & 8) != 0) {
            str4 = loginLifecycleVoucherDisplayModel.description;
        }
        return loginLifecycleVoucherDisplayModel.copy(str, str2, str3, str4);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final String component2() {
        return this.tag;
    }

    @NotNull
    public final String component3() {
        return this.termsAndConditions;
    }

    @NotNull
    public final String component4() {
        return this.description;
    }

    @NotNull
    public final LoginLifecycleVoucherDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3, @NotNull String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "tag");
        Intrinsics.checkNotNullParameter(str3, "termsAndConditions");
        Intrinsics.checkNotNullParameter(str4, "description");
        return new LoginLifecycleVoucherDisplayModel(str, str2, str3, str4);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LoginLifecycleVoucherDisplayModel)) {
            return false;
        }
        LoginLifecycleVoucherDisplayModel loginLifecycleVoucherDisplayModel = (LoginLifecycleVoucherDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) loginLifecycleVoucherDisplayModel.title) && Intrinsics.areEqual((Object) this.tag, (Object) loginLifecycleVoucherDisplayModel.tag) && Intrinsics.areEqual((Object) this.termsAndConditions, (Object) loginLifecycleVoucherDisplayModel.termsAndConditions) && Intrinsics.areEqual((Object) this.description, (Object) loginLifecycleVoucherDisplayModel.description);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getTag() {
        return this.tag;
    }

    @NotNull
    public final String getTermsAndConditions() {
        return this.termsAndConditions;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((((this.title.hashCode() * 31) + this.tag.hashCode()) * 31) + this.termsAndConditions.hashCode()) * 31) + this.description.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.tag;
        String str3 = this.termsAndConditions;
        String str4 = this.description;
        return "LoginLifecycleVoucherDisplayModel(title=" + str + ", tag=" + str2 + ", termsAndConditions=" + str3 + ", description=" + str4 + ")";
    }
}
