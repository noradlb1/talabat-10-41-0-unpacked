package com.talabat.verticals.ui.customViewLCAware.model;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R*\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/verticals/ui/customViewLCAware/model/VerticalsDisplayModel;", "", "()V", "verticals", "Ljava/util/ArrayList;", "Lcom/talabat/verticals/ui/customViewLCAware/model/Vertical;", "Lkotlin/collections/ArrayList;", "getVerticals", "()Ljava/util/ArrayList;", "setVerticals", "(Ljava/util/ArrayList;)V", "com_talabat_NewArchi_VerticalsSquad_VerticalsSquad"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class VerticalsDisplayModel {
    @NotNull
    private ArrayList<Vertical> verticals = new ArrayList<>();

    @NotNull
    public final ArrayList<Vertical> getVerticals() {
        return this.verticals;
    }

    public final void setVerticals(@NotNull ArrayList<Vertical> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.verticals = arrayList;
    }
}
