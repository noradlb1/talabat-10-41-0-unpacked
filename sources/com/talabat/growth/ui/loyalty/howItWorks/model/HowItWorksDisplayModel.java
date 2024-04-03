package com.talabat.growth.ui.loyalty.howItWorks.model;

import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\n\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R \u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0005¨\u0006\u0012"}, d2 = {"Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksDisplayModel;", "", "instructions", "", "Lcom/talabat/growth/ui/loyalty/howItWorks/model/HowItWorksItemDisplayModel;", "(Ljava/util/List;)V", "getInstructions", "()Ljava/util/List;", "setInstructions", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "com_talabat_NewArchi_GrowthSquad_GrowthSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HowItWorksDisplayModel {
    @NotNull
    private List<HowItWorksItemDisplayModel> instructions;

    public HowItWorksDisplayModel() {
        this((List) null, 1, (DefaultConstructorMarker) null);
    }

    public HowItWorksDisplayModel(@NotNull List<HowItWorksItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "instructions");
        this.instructions = list;
    }

    public static /* synthetic */ HowItWorksDisplayModel copy$default(HowItWorksDisplayModel howItWorksDisplayModel, List<HowItWorksItemDisplayModel> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            list = howItWorksDisplayModel.instructions;
        }
        return howItWorksDisplayModel.copy(list);
    }

    @NotNull
    public final List<HowItWorksItemDisplayModel> component1() {
        return this.instructions;
    }

    @NotNull
    public final HowItWorksDisplayModel copy(@NotNull List<HowItWorksItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "instructions");
        return new HowItWorksDisplayModel(list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof HowItWorksDisplayModel) && Intrinsics.areEqual((Object) this.instructions, (Object) ((HowItWorksDisplayModel) obj).instructions);
    }

    @NotNull
    public final List<HowItWorksItemDisplayModel> getInstructions() {
        return this.instructions;
    }

    public int hashCode() {
        return this.instructions.hashCode();
    }

    public final void setInstructions(@NotNull List<HowItWorksItemDisplayModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.instructions = list;
    }

    @NotNull
    public String toString() {
        List<HowItWorksItemDisplayModel> list = this.instructions;
        return "HowItWorksDisplayModel(instructions=" + list + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HowItWorksDisplayModel(List list, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new ArrayList() : list);
    }
}
