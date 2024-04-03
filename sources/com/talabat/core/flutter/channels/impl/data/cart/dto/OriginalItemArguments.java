package com.talabat.core.flutter.channels.impl.data.cart.dto;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u000e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0003J/\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0019\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0018"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/cart/dto/OriginalItemArguments;", "", "menuItemId", "", "specialRequest", "", "choices", "", "(ILjava/lang/String;Ljava/util/List;)V", "getChoices", "()Ljava/util/List;", "getMenuItemId", "()I", "getSpecialRequest", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class OriginalItemArguments {
    @Nullable
    private final List<Integer> choices;
    private final int menuItemId;
    @NotNull
    private final String specialRequest;

    public OriginalItemArguments(int i11, @NotNull String str, @Nullable List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "specialRequest");
        this.menuItemId = i11;
        this.specialRequest = str;
        this.choices = list;
    }

    public static /* synthetic */ OriginalItemArguments copy$default(OriginalItemArguments originalItemArguments, int i11, String str, List<Integer> list, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = originalItemArguments.menuItemId;
        }
        if ((i12 & 2) != 0) {
            str = originalItemArguments.specialRequest;
        }
        if ((i12 & 4) != 0) {
            list = originalItemArguments.choices;
        }
        return originalItemArguments.copy(i11, str, list);
    }

    public final int component1() {
        return this.menuItemId;
    }

    @NotNull
    public final String component2() {
        return this.specialRequest;
    }

    @Nullable
    public final List<Integer> component3() {
        return this.choices;
    }

    @NotNull
    public final OriginalItemArguments copy(int i11, @NotNull String str, @Nullable List<Integer> list) {
        Intrinsics.checkNotNullParameter(str, "specialRequest");
        return new OriginalItemArguments(i11, str, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof OriginalItemArguments)) {
            return false;
        }
        OriginalItemArguments originalItemArguments = (OriginalItemArguments) obj;
        return this.menuItemId == originalItemArguments.menuItemId && Intrinsics.areEqual((Object) this.specialRequest, (Object) originalItemArguments.specialRequest) && Intrinsics.areEqual((Object) this.choices, (Object) originalItemArguments.choices);
    }

    @Nullable
    public final List<Integer> getChoices() {
        return this.choices;
    }

    public final int getMenuItemId() {
        return this.menuItemId;
    }

    @NotNull
    public final String getSpecialRequest() {
        return this.specialRequest;
    }

    public int hashCode() {
        int hashCode = ((this.menuItemId * 31) + this.specialRequest.hashCode()) * 31;
        List<Integer> list = this.choices;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    @NotNull
    public String toString() {
        int i11 = this.menuItemId;
        String str = this.specialRequest;
        List<Integer> list = this.choices;
        return "OriginalItemArguments(menuItemId=" + i11 + ", specialRequest=" + str + ", choices=" + list + ")";
    }
}
