package com.talabat.feature.helpcenter.presentation;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0003J-\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyDisplayModel;", "", "isEnabled", "", "title", "", "cancellationPolicyList", "", "Lcom/talabat/feature/helpcenter/presentation/CancellationPolicyItemDisplayModel;", "(ZLjava/lang/String;Ljava/util/List;)V", "getCancellationPolicyList", "()Ljava/util/List;", "()Z", "getTitle", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "com_talabat_feature_helpcenter_presentation_presentation"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CancellationPolicyDisplayModel {
    @NotNull
    private final List<CancellationPolicyItemDisplayModel> cancellationPolicyList;
    private final boolean isEnabled;
    @NotNull
    private final String title;

    public CancellationPolicyDisplayModel(boolean z11, @NotNull String str, @NotNull List<CancellationPolicyItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "cancellationPolicyList");
        this.isEnabled = z11;
        this.title = str;
        this.cancellationPolicyList = list;
    }

    public static /* synthetic */ CancellationPolicyDisplayModel copy$default(CancellationPolicyDisplayModel cancellationPolicyDisplayModel, boolean z11, String str, List<CancellationPolicyItemDisplayModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = cancellationPolicyDisplayModel.isEnabled;
        }
        if ((i11 & 2) != 0) {
            str = cancellationPolicyDisplayModel.title;
        }
        if ((i11 & 4) != 0) {
            list = cancellationPolicyDisplayModel.cancellationPolicyList;
        }
        return cancellationPolicyDisplayModel.copy(z11, str, list);
    }

    public final boolean component1() {
        return this.isEnabled;
    }

    @NotNull
    public final String component2() {
        return this.title;
    }

    @NotNull
    public final List<CancellationPolicyItemDisplayModel> component3() {
        return this.cancellationPolicyList;
    }

    @NotNull
    public final CancellationPolicyDisplayModel copy(boolean z11, @NotNull String str, @NotNull List<CancellationPolicyItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list, "cancellationPolicyList");
        return new CancellationPolicyDisplayModel(z11, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CancellationPolicyDisplayModel)) {
            return false;
        }
        CancellationPolicyDisplayModel cancellationPolicyDisplayModel = (CancellationPolicyDisplayModel) obj;
        return this.isEnabled == cancellationPolicyDisplayModel.isEnabled && Intrinsics.areEqual((Object) this.title, (Object) cancellationPolicyDisplayModel.title) && Intrinsics.areEqual((Object) this.cancellationPolicyList, (Object) cancellationPolicyDisplayModel.cancellationPolicyList);
    }

    @NotNull
    public final List<CancellationPolicyItemDisplayModel> getCancellationPolicyList() {
        return this.cancellationPolicyList;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        boolean z11 = this.isEnabled;
        if (z11) {
            z11 = true;
        }
        return ((((z11 ? 1 : 0) * true) + this.title.hashCode()) * 31) + this.cancellationPolicyList.hashCode();
    }

    public final boolean isEnabled() {
        return this.isEnabled;
    }

    @NotNull
    public String toString() {
        boolean z11 = this.isEnabled;
        String str = this.title;
        List<CancellationPolicyItemDisplayModel> list = this.cancellationPolicyList;
        return "CancellationPolicyDisplayModel(isEnabled=" + z11 + ", title=" + str + ", cancellationPolicyList=" + list + ")";
    }
}
