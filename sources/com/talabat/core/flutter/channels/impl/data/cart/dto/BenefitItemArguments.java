package com.talabat.core.flutter.channels.impl.data.cart.dto;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001B-\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\bHÆ\u0003¢\u0006\u0002\u0010\rJ>\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001b\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0007\u0010\rR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006\u001c"}, d2 = {"Lcom/talabat/core/flutter/channels/impl/data/cart/dto/BenefitItemArguments;", "", "id", "", "label", "", "menuItemId", "isSelected", "", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getLabel", "()Ljava/lang/String;", "getMenuItemId", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)Lcom/talabat/core/flutter/channels/impl/data/cart/dto/BenefitItemArguments;", "equals", "other", "hashCode", "toString", "com_talabat_core_flutter-channels-impl_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class BenefitItemArguments {
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f55912id;
    @Nullable
    private final Boolean isSelected;
    @Nullable
    private final String label;
    @Nullable
    private final String menuItemId;

    public BenefitItemArguments(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
        this.f55912id = num;
        this.label = str;
        this.menuItemId = str2;
        this.isSelected = bool;
    }

    public static /* synthetic */ BenefitItemArguments copy$default(BenefitItemArguments benefitItemArguments, Integer num, String str, String str2, Boolean bool, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = benefitItemArguments.f55912id;
        }
        if ((i11 & 2) != 0) {
            str = benefitItemArguments.label;
        }
        if ((i11 & 4) != 0) {
            str2 = benefitItemArguments.menuItemId;
        }
        if ((i11 & 8) != 0) {
            bool = benefitItemArguments.isSelected;
        }
        return benefitItemArguments.copy(num, str, str2, bool);
    }

    @Nullable
    public final Integer component1() {
        return this.f55912id;
    }

    @Nullable
    public final String component2() {
        return this.label;
    }

    @Nullable
    public final String component3() {
        return this.menuItemId;
    }

    @Nullable
    public final Boolean component4() {
        return this.isSelected;
    }

    @NotNull
    public final BenefitItemArguments copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable Boolean bool) {
        return new BenefitItemArguments(num, str, str2, bool);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BenefitItemArguments)) {
            return false;
        }
        BenefitItemArguments benefitItemArguments = (BenefitItemArguments) obj;
        return Intrinsics.areEqual((Object) this.f55912id, (Object) benefitItemArguments.f55912id) && Intrinsics.areEqual((Object) this.label, (Object) benefitItemArguments.label) && Intrinsics.areEqual((Object) this.menuItemId, (Object) benefitItemArguments.menuItemId) && Intrinsics.areEqual((Object) this.isSelected, (Object) benefitItemArguments.isSelected);
    }

    @Nullable
    public final Integer getId() {
        return this.f55912id;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getMenuItemId() {
        return this.menuItemId;
    }

    public int hashCode() {
        Integer num = this.f55912id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.label;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.menuItemId;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.isSelected;
        if (bool != null) {
            i11 = bool.hashCode();
        }
        return hashCode3 + i11;
    }

    @Nullable
    public final Boolean isSelected() {
        return this.isSelected;
    }

    @NotNull
    public String toString() {
        Integer num = this.f55912id;
        String str = this.label;
        String str2 = this.menuItemId;
        Boolean bool = this.isSelected;
        return "BenefitItemArguments(id=" + num + ", label=" + str + ", menuItemId=" + str2 + ", isSelected=" + bool + ")";
    }
}
