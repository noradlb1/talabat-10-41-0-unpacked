package com.talabat.offering.domain.entities;

import com.talabat.mapper.ModelMapping;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B5\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u0014\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0015J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001a\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0004¢\u0006\n\n\u0002\u0010\u000f\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lcom/talabat/offering/domain/entities/CallToAction;", "", "title", "", "type", "", "popupTitle", "popupDescription", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)V", "getPopupDescription", "()Ljava/lang/String;", "getPopupTitle", "getTitle", "getType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;)Lcom/talabat/offering/domain/entities/CallToAction;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_Offering_Offering"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CallToAction {
    @ModelMapping({"popupDescription"})
    @Nullable
    private final String popupDescription;
    @ModelMapping({"popupTitle"})
    @Nullable
    private final String popupTitle;
    @ModelMapping({"title"})
    @Nullable
    private final String title;
    @ModelMapping({"type"})
    @Nullable
    private final Integer type;

    public CallToAction() {
        this((String) null, (Integer) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public CallToAction(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
        this.title = str;
        this.type = num;
        this.popupTitle = str2;
        this.popupDescription = str3;
    }

    public static /* synthetic */ CallToAction copy$default(CallToAction callToAction, String str, Integer num, String str2, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = callToAction.title;
        }
        if ((i11 & 2) != 0) {
            num = callToAction.type;
        }
        if ((i11 & 4) != 0) {
            str2 = callToAction.popupTitle;
        }
        if ((i11 & 8) != 0) {
            str3 = callToAction.popupDescription;
        }
        return callToAction.copy(str, num, str2, str3);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final Integer component2() {
        return this.type;
    }

    @Nullable
    public final String component3() {
        return this.popupTitle;
    }

    @Nullable
    public final String component4() {
        return this.popupDescription;
    }

    @NotNull
    public final CallToAction copy(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3) {
        return new CallToAction(str, num, str2, str3);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CallToAction)) {
            return false;
        }
        CallToAction callToAction = (CallToAction) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) callToAction.title) && Intrinsics.areEqual((Object) this.type, (Object) callToAction.type) && Intrinsics.areEqual((Object) this.popupTitle, (Object) callToAction.popupTitle) && Intrinsics.areEqual((Object) this.popupDescription, (Object) callToAction.popupDescription);
    }

    @Nullable
    public final String getPopupDescription() {
        return this.popupDescription;
    }

    @Nullable
    public final String getPopupTitle() {
        return this.popupTitle;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final Integer getType() {
        return this.type;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.type;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.popupTitle;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.popupDescription;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode3 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        Integer num = this.type;
        String str2 = this.popupTitle;
        String str3 = this.popupDescription;
        return "CallToAction(title=" + str + ", type=" + num + ", popupTitle=" + str2 + ", popupDescription=" + str3 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CallToAction(String str, Integer num, String str2, String str3, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : num, (i11 & 4) != 0 ? "Add Your number" : str2, (i11 & 8) != 0 ? "We’ll send you a code via SMS to confirm your number." : str3);
    }
}
