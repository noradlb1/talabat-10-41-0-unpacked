package com.talabat.talabatlife.data.remote.dto;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0011\u0010\u000b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0003J-\u0010\r\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u001e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u0015"}, d2 = {"Lcom/talabat/talabatlife/data/remote/dto/Result;", "", "offerTypes", "", "Lcom/talabat/talabatlife/data/remote/dto/Filter;", "cuisines", "Lcom/talabat/talabatlife/data/remote/dto/Cuisine;", "(Ljava/util/List;Ljava/util/List;)V", "getCuisines", "()Ljava/util/List;", "getOfferTypes", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Result {
    @SerializedName("cuisines")
    @Nullable
    private final List<Cuisine> cuisines;
    @SerializedName("offerTypes")
    @Nullable
    private final List<Filter> offerTypes;

    public Result(@Nullable List<Filter> list, @Nullable List<Cuisine> list2) {
        this.offerTypes = list;
        this.cuisines = list2;
    }

    public static /* synthetic */ Result copy$default(Result result, List<Filter> list, List<Cuisine> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = result.offerTypes;
        }
        if ((i11 & 2) != 0) {
            list2 = result.cuisines;
        }
        return result.copy(list, list2);
    }

    @Nullable
    public final List<Filter> component1() {
        return this.offerTypes;
    }

    @Nullable
    public final List<Cuisine> component2() {
        return this.cuisines;
    }

    @NotNull
    public final Result copy(@Nullable List<Filter> list, @Nullable List<Cuisine> list2) {
        return new Result(list, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Result)) {
            return false;
        }
        Result result = (Result) obj;
        return Intrinsics.areEqual((Object) this.offerTypes, (Object) result.offerTypes) && Intrinsics.areEqual((Object) this.cuisines, (Object) result.cuisines);
    }

    @Nullable
    public final List<Cuisine> getCuisines() {
        return this.cuisines;
    }

    @Nullable
    public final List<Filter> getOfferTypes() {
        return this.offerTypes;
    }

    public int hashCode() {
        List<Filter> list = this.offerTypes;
        int i11 = 0;
        int hashCode = (list == null ? 0 : list.hashCode()) * 31;
        List<Cuisine> list2 = this.cuisines;
        if (list2 != null) {
            i11 = list2.hashCode();
        }
        return hashCode + i11;
    }

    @NotNull
    public String toString() {
        List<Filter> list = this.offerTypes;
        List<Cuisine> list2 = this.cuisines;
        return "Result(offerTypes=" + list + ", cuisines=" + list2 + ")";
    }
}
