package com.talabat.feature.cancellationpolicy.remote;

import com.google.gson.annotations.SerializedName;
import com.squareup.moshi.Json;
import com.talabat.talabatcommon.views.wallet.cardViewWidgets.view.DefaultCardView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0001\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u000e\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u000e\b\u0003\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/talabat/feature/cancellationpolicy/remote/Content;", "", "title", "", "list", "", "Lcom/talabat/feature/cancellationpolicy/remote/CancellationPolicyItem;", "(Ljava/lang/String;Ljava/util/List;)V", "getList", "()Ljava/util/List;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_helpcenter_data_data"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Content {
    @SerializedName("list")
    @NotNull
    private final List<CancellationPolicyItem> list;
    @SerializedName("title")
    @NotNull
    private final String title;

    public Content(@NotNull @Json(name = "title") String str, @NotNull @Json(name = "list") List<CancellationPolicyItem> list2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list2, DefaultCardView.CARD_LIST);
        this.title = str;
        this.list = list2;
    }

    public static /* synthetic */ Content copy$default(Content content, String str, List<CancellationPolicyItem> list2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = content.title;
        }
        if ((i11 & 2) != 0) {
            list2 = content.list;
        }
        return content.copy(str, list2);
    }

    @NotNull
    public final String component1() {
        return this.title;
    }

    @NotNull
    public final List<CancellationPolicyItem> component2() {
        return this.list;
    }

    @NotNull
    public final Content copy(@NotNull @Json(name = "title") String str, @NotNull @Json(name = "list") List<CancellationPolicyItem> list2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(list2, DefaultCardView.CARD_LIST);
        return new Content(str, list2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Content)) {
            return false;
        }
        Content content = (Content) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) content.title) && Intrinsics.areEqual((Object) this.list, (Object) content.list);
    }

    @NotNull
    public final List<CancellationPolicyItem> getList() {
        return this.list;
    }

    @NotNull
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.list.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.title;
        List<CancellationPolicyItem> list2 = this.list;
        return "Content(title=" + str + ", list=" + list2 + ")";
    }
}
