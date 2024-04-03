package com.talabat.talabatcommon.views.wallet.subscription.model;

import com.talabat.mapper.ModelMapping;
import com.talabat.talabatcommon.extentions.StringUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001e\u0010\u0004\u001a\u00020\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\b\"\u0004\b\u000e\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/talabat/talabatcommon/views/wallet/subscription/model/SubscriptionProductDisplayModel;", "", "id", "", "title", "description", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDescription", "()Ljava/lang/String;", "setDescription", "(Ljava/lang/String;)V", "getId", "setId", "getTitle", "setTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SubscriptionProductDisplayModel {
    @NotNull
    @ModelMapping({"description"})
    private String description;
    @NotNull
    @ModelMapping({"id"})

    /* renamed from: id  reason: collision with root package name */
    private String f11931id;
    @NotNull
    @ModelMapping({"title"})
    private String title;

    public SubscriptionProductDisplayModel() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public SubscriptionProductDisplayModel(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        this.f11931id = str;
        this.title = str2;
        this.description = str3;
    }

    public static /* synthetic */ SubscriptionProductDisplayModel copy$default(SubscriptionProductDisplayModel subscriptionProductDisplayModel, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = subscriptionProductDisplayModel.f11931id;
        }
        if ((i11 & 2) != 0) {
            str2 = subscriptionProductDisplayModel.title;
        }
        if ((i11 & 4) != 0) {
            str3 = subscriptionProductDisplayModel.description;
        }
        return subscriptionProductDisplayModel.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.f11931id;
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
    public final SubscriptionProductDisplayModel copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "title");
        Intrinsics.checkNotNullParameter(str3, "description");
        return new SubscriptionProductDisplayModel(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SubscriptionProductDisplayModel)) {
            return false;
        }
        SubscriptionProductDisplayModel subscriptionProductDisplayModel = (SubscriptionProductDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.f11931id, (Object) subscriptionProductDisplayModel.f11931id) && Intrinsics.areEqual((Object) this.title, (Object) subscriptionProductDisplayModel.title) && Intrinsics.areEqual((Object) this.description, (Object) subscriptionProductDisplayModel.description);
    }

    @NotNull
    public final String getDescription() {
        return this.description;
    }

    @NotNull
    public final String getId() {
        return this.f11931id;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (((this.f11931id.hashCode() * 31) + this.title.hashCode()) * 31) + this.description.hashCode();
    }

    public final void setDescription(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.description = str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f11931id = str;
    }

    public final void setTitle(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.f11931id;
        String str2 = this.title;
        String str3 = this.description;
        return "SubscriptionProductDisplayModel(id=" + str + ", title=" + str2 + ", description=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SubscriptionProductDisplayModel(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str, (i11 & 2) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str2, (i11 & 4) != 0 ? StringUtils.empty(StringCompanionObject.INSTANCE) : str3);
    }
}
