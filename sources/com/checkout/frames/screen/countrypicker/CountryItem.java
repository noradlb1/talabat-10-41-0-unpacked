package com.checkout.frames.screen.countrypicker;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J'\u0010\u000e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/checkout/frames/screen/countrypicker/CountryItem;", "", "name", "", "emojiFlag", "iso2", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getEmojiFlag", "()Ljava/lang/String;", "getIso2", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "frames_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CountryItem {
    @NotNull
    private final String emojiFlag;
    @NotNull
    private final String iso2;
    @NotNull

    /* renamed from: name  reason: collision with root package name */
    private final String f44268name;

    public CountryItem(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "emojiFlag");
        Intrinsics.checkNotNullParameter(str3, "iso2");
        this.f44268name = str;
        this.emojiFlag = str2;
        this.iso2 = str3;
    }

    public static /* synthetic */ CountryItem copy$default(CountryItem countryItem, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = countryItem.f44268name;
        }
        if ((i11 & 2) != 0) {
            str2 = countryItem.emojiFlag;
        }
        if ((i11 & 4) != 0) {
            str3 = countryItem.iso2;
        }
        return countryItem.copy(str, str2, str3);
    }

    @NotNull
    public final String component1() {
        return this.f44268name;
    }

    @NotNull
    public final String component2() {
        return this.emojiFlag;
    }

    @NotNull
    public final String component3() {
        return this.iso2;
    }

    @NotNull
    public final CountryItem copy(@NotNull String str, @NotNull String str2, @NotNull String str3) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "emojiFlag");
        Intrinsics.checkNotNullParameter(str3, "iso2");
        return new CountryItem(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CountryItem)) {
            return false;
        }
        CountryItem countryItem = (CountryItem) obj;
        return Intrinsics.areEqual((Object) this.f44268name, (Object) countryItem.f44268name) && Intrinsics.areEqual((Object) this.emojiFlag, (Object) countryItem.emojiFlag) && Intrinsics.areEqual((Object) this.iso2, (Object) countryItem.iso2);
    }

    @NotNull
    public final String getEmojiFlag() {
        return this.emojiFlag;
    }

    @NotNull
    public final String getIso2() {
        return this.iso2;
    }

    @NotNull
    public final String getName() {
        return this.f44268name;
    }

    public int hashCode() {
        return (((this.f44268name.hashCode() * 31) + this.emojiFlag.hashCode()) * 31) + this.iso2.hashCode();
    }

    @NotNull
    public String toString() {
        String str = this.f44268name;
        String str2 = this.emojiFlag;
        String str3 = this.iso2;
        return "CountryItem(name=" + str + ", emojiFlag=" + str2 + ", iso2=" + str3 + ")";
    }
}
