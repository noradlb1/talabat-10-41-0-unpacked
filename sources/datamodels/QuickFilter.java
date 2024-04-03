package datamodels;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.android.parcel.Parcelize;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b&\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\u0010\u0010'\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u001fJ\u0010\u0010(\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010)\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010*\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ\u000b\u0010+\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0013HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00101\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00102\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u000b\u00103\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u00104\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010\u001cJ¶\u0001\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÆ\u0001¢\u0006\u0002\u00106J\t\u00107\u001a\u00020\u0003HÖ\u0001J\u0013\u00108\u001a\u00020\r2\b\u00109\u001a\u0004\u0018\u00010:HÖ\u0003J\t\u0010;\u001a\u00020\u0003HÖ\u0001J\t\u0010<\u001a\u00020\u0005HÖ\u0001J\u0019\u0010=\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0016R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0016R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u001b\u0010\u001cR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\f\u0010\u001cR\u0015\u0010\u0010\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u001d\u001a\u0004\b\u0010\u0010\u001cR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u0016R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0016R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0016¨\u0006B"}, d2 = {"Ldatamodels/QuickFilter;", "Landroid/os/Parcelable;", "id", "", "widgetName", "", "pageName", "description", "slug", "colorCode", "smallIcon", "bigIcon", "isCuisine", "", "hasTermsNCodn", "deepLink", "isSubscribed", "collectionType", "subscription", "Ldatamodels/SubscriptionCollection;", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ldatamodels/SubscriptionCollection;)V", "getBigIcon", "()Ljava/lang/String;", "getCollectionType", "getColorCode", "getDeepLink", "getDescription", "getHasTermsNCodn", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getPageName", "getSlug", "getSmallIcon", "getSubscription", "()Ldatamodels/SubscriptionCollection;", "getWidgetName", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;Ldatamodels/SubscriptionCollection;)Ldatamodels/QuickFilter;", "describeContents", "equals", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Parcelize
public final class QuickFilter implements Parcelable {
    @NotNull
    public static final Parcelable.Creator<QuickFilter> CREATOR = new Creator();
    @Nullable
    private final String bigIcon;
    @Nullable
    private final String collectionType;
    @Nullable
    private final String colorCode;
    @Nullable
    private final String deepLink;
    @Nullable
    private final String description;
    @Nullable
    private final Boolean hasTermsNCodn;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f13868id;
    @Nullable
    private final Boolean isCuisine;
    @Nullable
    private final Boolean isSubscribed;
    @Nullable
    private final String pageName;
    @Nullable
    private final String slug;
    @Nullable
    private final String smallIcon;
    @Nullable
    private final SubscriptionCollection subscription;
    @Nullable
    private final String widgetName;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<QuickFilter> {
        @NotNull
        public final QuickFilter createFromParcel(@NotNull Parcel parcel) {
            Boolean bool;
            Boolean bool2;
            Boolean bool3;
            Parcel parcel2 = parcel;
            Intrinsics.checkNotNullParameter(parcel2, "parcel");
            SubscriptionCollection subscriptionCollection = null;
            Integer valueOf = parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt());
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            String readString6 = parcel.readString();
            String readString7 = parcel.readString();
            boolean z11 = true;
            if (parcel.readInt() == 0) {
                bool = null;
            } else {
                bool = Boolean.valueOf(parcel.readInt() != 0);
            }
            if (parcel.readInt() == 0) {
                bool2 = null;
            } else {
                bool2 = Boolean.valueOf(parcel.readInt() != 0);
            }
            String readString8 = parcel.readString();
            if (parcel.readInt() == 0) {
                bool3 = null;
            } else {
                if (parcel.readInt() == 0) {
                    z11 = false;
                }
                bool3 = Boolean.valueOf(z11);
            }
            String readString9 = parcel.readString();
            if (parcel.readInt() != 0) {
                subscriptionCollection = SubscriptionCollection.CREATOR.createFromParcel(parcel2);
            }
            return new QuickFilter(valueOf, readString, readString2, readString3, readString4, readString5, readString6, readString7, bool, bool2, readString8, bool3, readString9, subscriptionCollection);
        }

        @NotNull
        public final QuickFilter[] newArray(int i11) {
            return new QuickFilter[i11];
        }
    }

    public QuickFilter(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str8, @Nullable Boolean bool3, @Nullable String str9, @Nullable SubscriptionCollection subscriptionCollection) {
        this.f13868id = num;
        this.widgetName = str;
        this.pageName = str2;
        this.description = str3;
        this.slug = str4;
        this.colorCode = str5;
        this.smallIcon = str6;
        this.bigIcon = str7;
        this.isCuisine = bool;
        this.hasTermsNCodn = bool2;
        this.deepLink = str8;
        this.isSubscribed = bool3;
        this.collectionType = str9;
        this.subscription = subscriptionCollection;
    }

    public static /* synthetic */ QuickFilter copy$default(QuickFilter quickFilter, Integer num, String str, String str2, String str3, String str4, String str5, String str6, String str7, Boolean bool, Boolean bool2, String str8, Boolean bool3, String str9, SubscriptionCollection subscriptionCollection, int i11, Object obj) {
        QuickFilter quickFilter2 = quickFilter;
        int i12 = i11;
        return quickFilter.copy((i12 & 1) != 0 ? quickFilter2.f13868id : num, (i12 & 2) != 0 ? quickFilter2.widgetName : str, (i12 & 4) != 0 ? quickFilter2.pageName : str2, (i12 & 8) != 0 ? quickFilter2.description : str3, (i12 & 16) != 0 ? quickFilter2.slug : str4, (i12 & 32) != 0 ? quickFilter2.colorCode : str5, (i12 & 64) != 0 ? quickFilter2.smallIcon : str6, (i12 & 128) != 0 ? quickFilter2.bigIcon : str7, (i12 & 256) != 0 ? quickFilter2.isCuisine : bool, (i12 & 512) != 0 ? quickFilter2.hasTermsNCodn : bool2, (i12 & 1024) != 0 ? quickFilter2.deepLink : str8, (i12 & 2048) != 0 ? quickFilter2.isSubscribed : bool3, (i12 & 4096) != 0 ? quickFilter2.collectionType : str9, (i12 & 8192) != 0 ? quickFilter2.subscription : subscriptionCollection);
    }

    @Nullable
    public final Integer component1() {
        return this.f13868id;
    }

    @Nullable
    public final Boolean component10() {
        return this.hasTermsNCodn;
    }

    @Nullable
    public final String component11() {
        return this.deepLink;
    }

    @Nullable
    public final Boolean component12() {
        return this.isSubscribed;
    }

    @Nullable
    public final String component13() {
        return this.collectionType;
    }

    @Nullable
    public final SubscriptionCollection component14() {
        return this.subscription;
    }

    @Nullable
    public final String component2() {
        return this.widgetName;
    }

    @Nullable
    public final String component3() {
        return this.pageName;
    }

    @Nullable
    public final String component4() {
        return this.description;
    }

    @Nullable
    public final String component5() {
        return this.slug;
    }

    @Nullable
    public final String component6() {
        return this.colorCode;
    }

    @Nullable
    public final String component7() {
        return this.smallIcon;
    }

    @Nullable
    public final String component8() {
        return this.bigIcon;
    }

    @Nullable
    public final Boolean component9() {
        return this.isCuisine;
    }

    @NotNull
    public final QuickFilter copy(@Nullable Integer num, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4, @Nullable String str5, @Nullable String str6, @Nullable String str7, @Nullable Boolean bool, @Nullable Boolean bool2, @Nullable String str8, @Nullable Boolean bool3, @Nullable String str9, @Nullable SubscriptionCollection subscriptionCollection) {
        return new QuickFilter(num, str, str2, str3, str4, str5, str6, str7, bool, bool2, str8, bool3, str9, subscriptionCollection);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickFilter)) {
            return false;
        }
        QuickFilter quickFilter = (QuickFilter) obj;
        return Intrinsics.areEqual((Object) this.f13868id, (Object) quickFilter.f13868id) && Intrinsics.areEqual((Object) this.widgetName, (Object) quickFilter.widgetName) && Intrinsics.areEqual((Object) this.pageName, (Object) quickFilter.pageName) && Intrinsics.areEqual((Object) this.description, (Object) quickFilter.description) && Intrinsics.areEqual((Object) this.slug, (Object) quickFilter.slug) && Intrinsics.areEqual((Object) this.colorCode, (Object) quickFilter.colorCode) && Intrinsics.areEqual((Object) this.smallIcon, (Object) quickFilter.smallIcon) && Intrinsics.areEqual((Object) this.bigIcon, (Object) quickFilter.bigIcon) && Intrinsics.areEqual((Object) this.isCuisine, (Object) quickFilter.isCuisine) && Intrinsics.areEqual((Object) this.hasTermsNCodn, (Object) quickFilter.hasTermsNCodn) && Intrinsics.areEqual((Object) this.deepLink, (Object) quickFilter.deepLink) && Intrinsics.areEqual((Object) this.isSubscribed, (Object) quickFilter.isSubscribed) && Intrinsics.areEqual((Object) this.collectionType, (Object) quickFilter.collectionType) && Intrinsics.areEqual((Object) this.subscription, (Object) quickFilter.subscription);
    }

    @Nullable
    public final String getBigIcon() {
        return this.bigIcon;
    }

    @Nullable
    public final String getCollectionType() {
        return this.collectionType;
    }

    @Nullable
    public final String getColorCode() {
        return this.colorCode;
    }

    @Nullable
    public final String getDeepLink() {
        return this.deepLink;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final Boolean getHasTermsNCodn() {
        return this.hasTermsNCodn;
    }

    @Nullable
    public final Integer getId() {
        return this.f13868id;
    }

    @Nullable
    public final String getPageName() {
        return this.pageName;
    }

    @Nullable
    public final String getSlug() {
        return this.slug;
    }

    @Nullable
    public final String getSmallIcon() {
        return this.smallIcon;
    }

    @Nullable
    public final SubscriptionCollection getSubscription() {
        return this.subscription;
    }

    @Nullable
    public final String getWidgetName() {
        return this.widgetName;
    }

    public int hashCode() {
        Integer num = this.f13868id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.widgetName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.pageName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.description;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.slug;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.colorCode;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.smallIcon;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.bigIcon;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        Boolean bool = this.isCuisine;
        int hashCode9 = (hashCode8 + (bool == null ? 0 : bool.hashCode())) * 31;
        Boolean bool2 = this.hasTermsNCodn;
        int hashCode10 = (hashCode9 + (bool2 == null ? 0 : bool2.hashCode())) * 31;
        String str8 = this.deepLink;
        int hashCode11 = (hashCode10 + (str8 == null ? 0 : str8.hashCode())) * 31;
        Boolean bool3 = this.isSubscribed;
        int hashCode12 = (hashCode11 + (bool3 == null ? 0 : bool3.hashCode())) * 31;
        String str9 = this.collectionType;
        int hashCode13 = (hashCode12 + (str9 == null ? 0 : str9.hashCode())) * 31;
        SubscriptionCollection subscriptionCollection = this.subscription;
        if (subscriptionCollection != null) {
            i11 = subscriptionCollection.hashCode();
        }
        return hashCode13 + i11;
    }

    @Nullable
    public final Boolean isCuisine() {
        return this.isCuisine;
    }

    @Nullable
    public final Boolean isSubscribed() {
        return this.isSubscribed;
    }

    @NotNull
    public String toString() {
        Integer num = this.f13868id;
        String str = this.widgetName;
        String str2 = this.pageName;
        String str3 = this.description;
        String str4 = this.slug;
        String str5 = this.colorCode;
        String str6 = this.smallIcon;
        String str7 = this.bigIcon;
        Boolean bool = this.isCuisine;
        Boolean bool2 = this.hasTermsNCodn;
        String str8 = this.deepLink;
        Boolean bool3 = this.isSubscribed;
        String str9 = this.collectionType;
        SubscriptionCollection subscriptionCollection = this.subscription;
        return "QuickFilter(id=" + num + ", widgetName=" + str + ", pageName=" + str2 + ", description=" + str3 + ", slug=" + str4 + ", colorCode=" + str5 + ", smallIcon=" + str6 + ", bigIcon=" + str7 + ", isCuisine=" + bool + ", hasTermsNCodn=" + bool2 + ", deepLink=" + str8 + ", isSubscribed=" + bool3 + ", collectionType=" + str9 + ", subscription=" + subscriptionCollection + ")";
    }

    public void writeToParcel(@NotNull Parcel parcel, int i11) {
        Intrinsics.checkNotNullParameter(parcel, "out");
        Integer num = this.f13868id;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        parcel.writeString(this.widgetName);
        parcel.writeString(this.pageName);
        parcel.writeString(this.description);
        parcel.writeString(this.slug);
        parcel.writeString(this.colorCode);
        parcel.writeString(this.smallIcon);
        parcel.writeString(this.bigIcon);
        Boolean bool = this.isCuisine;
        if (bool == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool.booleanValue() ? 1 : 0);
        }
        Boolean bool2 = this.hasTermsNCodn;
        if (bool2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool2.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.deepLink);
        Boolean bool3 = this.isSubscribed;
        if (bool3 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(bool3.booleanValue() ? 1 : 0);
        }
        parcel.writeString(this.collectionType);
        SubscriptionCollection subscriptionCollection = this.subscription;
        if (subscriptionCollection == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        subscriptionCollection.writeToParcel(parcel, i11);
    }
}
