package com.talabat.darkstores.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ$\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/model/ToastModel;", "", "labelResId", "", "leadingIconResId", "(ILjava/lang/Integer;)V", "getLabelResId", "()I", "getLeadingIconResId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "copy", "(ILjava/lang/Integer;)Lcom/talabat/darkstores/model/ToastModel;", "equals", "", "other", "hashCode", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ToastModel {
    private final int labelResId;
    @Nullable
    private final Integer leadingIconResId;

    public ToastModel(int i11, @Nullable Integer num) {
        this.labelResId = i11;
        this.leadingIconResId = num;
    }

    public static /* synthetic */ ToastModel copy$default(ToastModel toastModel, int i11, Integer num, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = toastModel.labelResId;
        }
        if ((i12 & 2) != 0) {
            num = toastModel.leadingIconResId;
        }
        return toastModel.copy(i11, num);
    }

    public final int component1() {
        return this.labelResId;
    }

    @Nullable
    public final Integer component2() {
        return this.leadingIconResId;
    }

    @NotNull
    public final ToastModel copy(int i11, @Nullable Integer num) {
        return new ToastModel(i11, num);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ToastModel)) {
            return false;
        }
        ToastModel toastModel = (ToastModel) obj;
        return this.labelResId == toastModel.labelResId && Intrinsics.areEqual((Object) this.leadingIconResId, (Object) toastModel.leadingIconResId);
    }

    public final int getLabelResId() {
        return this.labelResId;
    }

    @Nullable
    public final Integer getLeadingIconResId() {
        return this.leadingIconResId;
    }

    public int hashCode() {
        int i11 = this.labelResId * 31;
        Integer num = this.leadingIconResId;
        return i11 + (num == null ? 0 : num.hashCode());
    }

    @NotNull
    public String toString() {
        int i11 = this.labelResId;
        Integer num = this.leadingIconResId;
        return "ToastModel(labelResId=" + i11 + ", leadingIconResId=" + num + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ToastModel(int i11, Integer num, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(i11, (i12 & 2) != 0 ? null : num);
    }
}
