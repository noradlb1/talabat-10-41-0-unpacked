package com.talabat.sdsquad.ui.vendorslist.displaymodels;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B=\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\u0002\u0010\fJ\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u0011\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\nHÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\bHÆ\u0003JP\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\bHÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0003HÖ\u0001J\t\u0010\"\u001a\u00020\bHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0013\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0013¨\u0006#"}, d2 = {"Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/SwimlaneDisplayModel;", "", "position", "", "restaurants", "", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/VendorDisplayModel;", "slug", "", "strategy", "Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/StrategyDisplayModel;", "title", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/StrategyDisplayModel;Ljava/lang/String;)V", "getPosition", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getRestaurants", "()Ljava/util/List;", "getSlug", "()Ljava/lang/String;", "getStrategy", "()Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/StrategyDisplayModel;", "getTitle", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/Integer;Ljava/util/List;Ljava/lang/String;Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/StrategyDisplayModel;Ljava/lang/String;)Lcom/talabat/sdsquad/ui/vendorslist/displaymodels/SwimlaneDisplayModel;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_sdsquad_sdsquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class SwimlaneDisplayModel {
    @Nullable
    private final Integer position;
    @Nullable
    private final List<VendorDisplayModel> restaurants;
    @Nullable
    private final String slug;
    @Nullable
    private final StrategyDisplayModel strategy;
    @Nullable
    private final String title;

    public SwimlaneDisplayModel(@Nullable Integer num, @Nullable List<VendorDisplayModel> list, @Nullable String str, @Nullable StrategyDisplayModel strategyDisplayModel, @Nullable String str2) {
        this.position = num;
        this.restaurants = list;
        this.slug = str;
        this.strategy = strategyDisplayModel;
        this.title = str2;
    }

    public static /* synthetic */ SwimlaneDisplayModel copy$default(SwimlaneDisplayModel swimlaneDisplayModel, Integer num, List<VendorDisplayModel> list, String str, StrategyDisplayModel strategyDisplayModel, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = swimlaneDisplayModel.position;
        }
        if ((i11 & 2) != 0) {
            list = swimlaneDisplayModel.restaurants;
        }
        List<VendorDisplayModel> list2 = list;
        if ((i11 & 4) != 0) {
            str = swimlaneDisplayModel.slug;
        }
        String str3 = str;
        if ((i11 & 8) != 0) {
            strategyDisplayModel = swimlaneDisplayModel.strategy;
        }
        StrategyDisplayModel strategyDisplayModel2 = strategyDisplayModel;
        if ((i11 & 16) != 0) {
            str2 = swimlaneDisplayModel.title;
        }
        return swimlaneDisplayModel.copy(num, list2, str3, strategyDisplayModel2, str2);
    }

    @Nullable
    public final Integer component1() {
        return this.position;
    }

    @Nullable
    public final List<VendorDisplayModel> component2() {
        return this.restaurants;
    }

    @Nullable
    public final String component3() {
        return this.slug;
    }

    @Nullable
    public final StrategyDisplayModel component4() {
        return this.strategy;
    }

    @Nullable
    public final String component5() {
        return this.title;
    }

    @NotNull
    public final SwimlaneDisplayModel copy(@Nullable Integer num, @Nullable List<VendorDisplayModel> list, @Nullable String str, @Nullable StrategyDisplayModel strategyDisplayModel, @Nullable String str2) {
        return new SwimlaneDisplayModel(num, list, str, strategyDisplayModel, str2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SwimlaneDisplayModel)) {
            return false;
        }
        SwimlaneDisplayModel swimlaneDisplayModel = (SwimlaneDisplayModel) obj;
        return Intrinsics.areEqual((Object) this.position, (Object) swimlaneDisplayModel.position) && Intrinsics.areEqual((Object) this.restaurants, (Object) swimlaneDisplayModel.restaurants) && Intrinsics.areEqual((Object) this.slug, (Object) swimlaneDisplayModel.slug) && Intrinsics.areEqual((Object) this.strategy, (Object) swimlaneDisplayModel.strategy) && Intrinsics.areEqual((Object) this.title, (Object) swimlaneDisplayModel.title);
    }

    @Nullable
    public final Integer getPosition() {
        return this.position;
    }

    @Nullable
    public final List<VendorDisplayModel> getRestaurants() {
        return this.restaurants;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final StrategyDisplayModel getStrategy() {
        return this.strategy;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        Integer num = this.position;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        List<VendorDisplayModel> list = this.restaurants;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.slug;
        int hashCode3 = (hashCode2 + (str == null ? 0 : str.hashCode())) * 31;
        StrategyDisplayModel strategyDisplayModel = this.strategy;
        int hashCode4 = (hashCode3 + (strategyDisplayModel == null ? 0 : strategyDisplayModel.hashCode())) * 31;
        String str2 = this.title;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode4 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.position;
        List<VendorDisplayModel> list = this.restaurants;
        String str = this.slug;
        StrategyDisplayModel strategyDisplayModel = this.strategy;
        String str2 = this.title;
        return "SwimlaneDisplayModel(position=" + num + ", restaurants=" + list + ", slug=" + str + ", strategy=" + strategyDisplayModel + ", title=" + str2 + ")";
    }
}
