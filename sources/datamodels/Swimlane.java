package datamodels;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003JI\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0006HÖ\u0001J\t\u0010%\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0005\u001a\u00020\u00068\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0006@\u0006X\u000e¢\u0006\u0002\n\u0000R \u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0012\"\u0004\b\u001a\u0010\u0014¨\u0006&"}, d2 = {"Ldatamodels/Swimlane;", "", "title", "", "slug", "position", "", "strategy", "Ldatamodels/Strategy;", "restaurants", "Ljava/util/ArrayList;", "Ldatamodels/Restaurant;", "(Ljava/lang/String;Ljava/lang/String;ILdatamodels/Strategy;Ljava/util/ArrayList;)V", "getPosition", "()I", "setPosition", "(I)V", "getSlug", "()Ljava/lang/String;", "setSlug", "(Ljava/lang/String;)V", "getStrategy", "()Ldatamodels/Strategy;", "setStrategy", "(Ldatamodels/Strategy;)V", "getTitle", "setTitle", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "toString", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Swimlane {
    @SerializedName("position")
    private int position;
    @Nullable
    @SerializedName("restaurants")
    @JvmField
    public ArrayList<Restaurant> restaurants;
    @SerializedName("slug")
    @Nullable
    private String slug;
    @SerializedName("strategy")
    @Nullable
    private Strategy strategy;
    @SerializedName("title")
    @Nullable
    private String title;

    public Swimlane() {
        this((String) null, (String) null, 0, (Strategy) null, (ArrayList) null, 31, (DefaultConstructorMarker) null);
    }

    public Swimlane(@Nullable String str, @Nullable String str2, int i11, @Nullable Strategy strategy2, @Nullable ArrayList<Restaurant> arrayList) {
        this.title = str;
        this.slug = str2;
        this.position = i11;
        this.strategy = strategy2;
        this.restaurants = arrayList;
    }

    public static /* synthetic */ Swimlane copy$default(Swimlane swimlane, String str, String str2, int i11, Strategy strategy2, ArrayList<Restaurant> arrayList, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            str = swimlane.title;
        }
        if ((i12 & 2) != 0) {
            str2 = swimlane.slug;
        }
        String str3 = str2;
        if ((i12 & 4) != 0) {
            i11 = swimlane.position;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            strategy2 = swimlane.strategy;
        }
        Strategy strategy3 = strategy2;
        if ((i12 & 16) != 0) {
            arrayList = swimlane.restaurants;
        }
        return swimlane.copy(str, str3, i13, strategy3, arrayList);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.slug;
    }

    public final int component3() {
        return this.position;
    }

    @Nullable
    public final Strategy component4() {
        return this.strategy;
    }

    @Nullable
    public final ArrayList<Restaurant> component5() {
        return this.restaurants;
    }

    @NotNull
    public final Swimlane copy(@Nullable String str, @Nullable String str2, int i11, @Nullable Strategy strategy2, @Nullable ArrayList<Restaurant> arrayList) {
        return new Swimlane(str, str2, i11, strategy2, arrayList);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Swimlane)) {
            return false;
        }
        Swimlane swimlane = (Swimlane) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) swimlane.title) && Intrinsics.areEqual((Object) this.slug, (Object) swimlane.slug) && this.position == swimlane.position && Intrinsics.areEqual((Object) this.strategy, (Object) swimlane.strategy) && Intrinsics.areEqual((Object) this.restaurants, (Object) swimlane.restaurants);
    }

    public final int getPosition() {
        return this.position;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final Strategy getStrategy() {
        return this.strategy;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.slug;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.position) * 31;
        Strategy strategy2 = this.strategy;
        int hashCode3 = (hashCode2 + (strategy2 == null ? 0 : strategy2.hashCode())) * 31;
        ArrayList<Restaurant> arrayList = this.restaurants;
        if (arrayList != null) {
            i11 = arrayList.hashCode();
        }
        return hashCode3 + i11;
    }

    public final void setPosition(int i11) {
        this.position = i11;
    }

    public final void setSlug(@Nullable String str) {
        this.slug = str;
    }

    public final void setStrategy(@Nullable Strategy strategy2) {
        this.strategy = strategy2;
    }

    public final void setTitle(@Nullable String str) {
        this.title = str;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.slug;
        int i11 = this.position;
        Strategy strategy2 = this.strategy;
        ArrayList<Restaurant> arrayList = this.restaurants;
        return "Swimlane(title=" + str + ", slug=" + str2 + ", position=" + i11 + ", strategy=" + strategy2 + ", restaurants=" + arrayList + ")";
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Swimlane(java.lang.String r5, java.lang.String r6, int r7, datamodels.Strategy r8, java.util.ArrayList r9, int r10, kotlin.jvm.internal.DefaultConstructorMarker r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0014
            r7 = 0
        L_0x0014:
            r2 = r7
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001b
            r3 = r0
            goto L_0x001c
        L_0x001b:
            r3 = r8
        L_0x001c:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0022
            r10 = r0
            goto L_0x0023
        L_0x0022:
            r10 = r9
        L_0x0023:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: datamodels.Swimlane.<init>(java.lang.String, java.lang.String, int, datamodels.Strategy, java.util.ArrayList, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
