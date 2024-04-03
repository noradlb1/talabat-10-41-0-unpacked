package com.talabat.vendormenu.presentation.flutter.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÂ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JP\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/talabat/vendormenu/presentation/flutter/dto/UpdatedSelectedMenuDiscountCallArguments;", "", "id", "", "label", "discount", "", "passedTypeValue", "Lcom/talabat/vendormenu/presentation/flutter/dto/MenuDiscountTypeArgument;", "benefitItems", "", "Lcom/talabat/vendormenu/presentation/flutter/dto/BenefitItemArguments;", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lcom/talabat/vendormenu/presentation/flutter/dto/MenuDiscountTypeArgument;Ljava/util/List;)V", "getBenefitItems", "()Ljava/util/List;", "getDiscount", "()Ljava/lang/Float;", "Ljava/lang/Float;", "discountType", "getDiscountType", "()Lcom/talabat/vendormenu/presentation/flutter/dto/MenuDiscountTypeArgument;", "getId", "()Ljava/lang/String;", "getLabel", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Float;Lcom/talabat/vendormenu/presentation/flutter/dto/MenuDiscountTypeArgument;Ljava/util/List;)Lcom/talabat/vendormenu/presentation/flutter/dto/UpdatedSelectedMenuDiscountCallArguments;", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_TalabatVendorMenu_TalabatVendorMenu"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class UpdatedSelectedMenuDiscountCallArguments {
    @Nullable
    private final List<BenefitItemArguments> benefitItems;
    @Nullable
    private final Float discount;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final String f12447id;
    @Nullable
    private final String label;
    @SerializedName("type")
    @Nullable
    private final MenuDiscountTypeArgument passedTypeValue;

    public UpdatedSelectedMenuDiscountCallArguments(@Nullable String str, @Nullable String str2, @Nullable Float f11, @Nullable MenuDiscountTypeArgument menuDiscountTypeArgument, @Nullable List<BenefitItemArguments> list) {
        this.f12447id = str;
        this.label = str2;
        this.discount = f11;
        this.passedTypeValue = menuDiscountTypeArgument;
        this.benefitItems = list;
    }

    private final MenuDiscountTypeArgument component4() {
        return this.passedTypeValue;
    }

    public static /* synthetic */ UpdatedSelectedMenuDiscountCallArguments copy$default(UpdatedSelectedMenuDiscountCallArguments updatedSelectedMenuDiscountCallArguments, String str, String str2, Float f11, MenuDiscountTypeArgument menuDiscountTypeArgument, List<BenefitItemArguments> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = updatedSelectedMenuDiscountCallArguments.f12447id;
        }
        if ((i11 & 2) != 0) {
            str2 = updatedSelectedMenuDiscountCallArguments.label;
        }
        String str3 = str2;
        if ((i11 & 4) != 0) {
            f11 = updatedSelectedMenuDiscountCallArguments.discount;
        }
        Float f12 = f11;
        if ((i11 & 8) != 0) {
            menuDiscountTypeArgument = updatedSelectedMenuDiscountCallArguments.passedTypeValue;
        }
        MenuDiscountTypeArgument menuDiscountTypeArgument2 = menuDiscountTypeArgument;
        if ((i11 & 16) != 0) {
            list = updatedSelectedMenuDiscountCallArguments.benefitItems;
        }
        return updatedSelectedMenuDiscountCallArguments.copy(str, str3, f12, menuDiscountTypeArgument2, list);
    }

    @Nullable
    public final String component1() {
        return this.f12447id;
    }

    @Nullable
    public final String component2() {
        return this.label;
    }

    @Nullable
    public final Float component3() {
        return this.discount;
    }

    @Nullable
    public final List<BenefitItemArguments> component5() {
        return this.benefitItems;
    }

    @NotNull
    public final UpdatedSelectedMenuDiscountCallArguments copy(@Nullable String str, @Nullable String str2, @Nullable Float f11, @Nullable MenuDiscountTypeArgument menuDiscountTypeArgument, @Nullable List<BenefitItemArguments> list) {
        return new UpdatedSelectedMenuDiscountCallArguments(str, str2, f11, menuDiscountTypeArgument, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UpdatedSelectedMenuDiscountCallArguments)) {
            return false;
        }
        UpdatedSelectedMenuDiscountCallArguments updatedSelectedMenuDiscountCallArguments = (UpdatedSelectedMenuDiscountCallArguments) obj;
        return Intrinsics.areEqual((Object) this.f12447id, (Object) updatedSelectedMenuDiscountCallArguments.f12447id) && Intrinsics.areEqual((Object) this.label, (Object) updatedSelectedMenuDiscountCallArguments.label) && Intrinsics.areEqual((Object) this.discount, (Object) updatedSelectedMenuDiscountCallArguments.discount) && this.passedTypeValue == updatedSelectedMenuDiscountCallArguments.passedTypeValue && Intrinsics.areEqual((Object) this.benefitItems, (Object) updatedSelectedMenuDiscountCallArguments.benefitItems);
    }

    @Nullable
    public final List<BenefitItemArguments> getBenefitItems() {
        return this.benefitItems;
    }

    @Nullable
    public final Float getDiscount() {
        return this.discount;
    }

    @NotNull
    public final MenuDiscountTypeArgument getDiscountType() {
        MenuDiscountTypeArgument menuDiscountTypeArgument = this.passedTypeValue;
        return menuDiscountTypeArgument == null ? MenuDiscountTypeArgument.COUPON : menuDiscountTypeArgument;
    }

    @Nullable
    public final String getId() {
        return this.f12447id;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    public int hashCode() {
        String str = this.f12447id;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.label;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        Float f11 = this.discount;
        int hashCode3 = (hashCode2 + (f11 == null ? 0 : f11.hashCode())) * 31;
        MenuDiscountTypeArgument menuDiscountTypeArgument = this.passedTypeValue;
        int hashCode4 = (hashCode3 + (menuDiscountTypeArgument == null ? 0 : menuDiscountTypeArgument.hashCode())) * 31;
        List<BenefitItemArguments> list = this.benefitItems;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.f12447id;
        String str2 = this.label;
        Float f11 = this.discount;
        MenuDiscountTypeArgument menuDiscountTypeArgument = this.passedTypeValue;
        List<BenefitItemArguments> list = this.benefitItems;
        return "UpdatedSelectedMenuDiscountCallArguments(id=" + str + ", label=" + str2 + ", discount=" + f11 + ", passedTypeValue=" + menuDiscountTypeArgument + ", benefitItems=" + list + ")";
    }
}
