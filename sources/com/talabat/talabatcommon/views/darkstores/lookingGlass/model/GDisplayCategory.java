package com.talabat.talabatcommon.views.darkstores.lookingGlass.model;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\t\u001a\u00020\u00048\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR.\u0010\f\u001a\u0012\u0012\u0004\u0012\u00020\u000e0\rj\b\u0012\u0004\u0012\u00020\u000e`\u000f8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayCategory;", "", "()V", "headline", "", "getHeadline", "()Ljava/lang/String;", "setHeadline", "(Ljava/lang/String;)V", "id", "getId", "setId", "items", "Ljava/util/ArrayList;", "Lcom/talabat/talabatcommon/views/darkstores/lookingGlass/model/GDisplayItem;", "Lkotlin/collections/ArrayList;", "getItems", "()Ljava/util/ArrayList;", "setItems", "(Ljava/util/ArrayList;)V", "com_talabat_NewArchi_TalabatCommon_TalabatCommon"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class GDisplayCategory {
    @SerializedName("headline")
    @NotNull
    private String headline = "";
    @SerializedName("id")
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private String f11724id = "";
    @SerializedName("items")
    @NotNull
    private ArrayList<GDisplayItem> items = new ArrayList<>();

    @NotNull
    public final String getHeadline() {
        return this.headline;
    }

    @NotNull
    public final String getId() {
        return this.f11724id;
    }

    @NotNull
    public final ArrayList<GDisplayItem> getItems() {
        return this.items;
    }

    public final void setHeadline(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.headline = str;
    }

    public final void setId(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.f11724id = str;
    }

    public final void setItems(@NotNull ArrayList<GDisplayItem> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<set-?>");
        this.items = arrayList;
    }
}
