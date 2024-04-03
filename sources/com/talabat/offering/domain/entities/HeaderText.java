package com.talabat.offering.domain.entities;

import com.talabat.mapper.ModelMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/talabat/offering/domain/entities/HeaderText;", "", "color", "", "main", "secondary", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getColor", "()Ljava/lang/String;", "getMain", "getSecondary", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HeaderText {
    @ModelMapping({"color"})
    @Nullable
    private final String color;
    @ModelMapping({"main"})
    @Nullable
    private final String main;
    @ModelMapping({"secondary"})
    @Nullable
    private final String secondary;

    public HeaderText() {
        this((String) null, (String) null, (String) null, 7, (DefaultConstructorMarker) null);
    }

    public HeaderText(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        this.color = str;
        this.main = str2;
        this.secondary = str3;
    }

    public static /* synthetic */ HeaderText copy$default(HeaderText headerText, String str, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = headerText.color;
        }
        if ((i11 & 2) != 0) {
            str2 = headerText.main;
        }
        if ((i11 & 4) != 0) {
            str3 = headerText.secondary;
        }
        return headerText.copy(str, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.color;
    }

    @Nullable
    public final String component2() {
        return this.main;
    }

    @Nullable
    public final String component3() {
        return this.secondary;
    }

    @NotNull
    public final HeaderText copy(@Nullable String str, @Nullable String str2, @Nullable String str3) {
        return new HeaderText(str, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HeaderText)) {
            return false;
        }
        HeaderText headerText = (HeaderText) obj;
        return Intrinsics.areEqual((Object) this.color, (Object) headerText.color) && Intrinsics.areEqual((Object) this.main, (Object) headerText.main) && Intrinsics.areEqual((Object) this.secondary, (Object) headerText.secondary);
    }

    @Nullable
    public final String getColor() {
        return this.color;
    }

    @Nullable
    public final String getMain() {
        return this.main;
    }

    @Nullable
    public final String getSecondary() {
        return this.secondary;
    }

    public int hashCode() {
        String str = this.color;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.main;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.secondary;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.color;
        String str2 = this.main;
        String str3 = this.secondary;
        return "HeaderText(color=" + str + ", main=" + str2 + ", secondary=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HeaderText(String str, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3);
    }
}
