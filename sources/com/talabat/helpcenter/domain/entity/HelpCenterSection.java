package com.talabat.helpcenter.domain.entity;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\tJ2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0005HÖ\u0001R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0018"}, d2 = {"Lcom/talabat/helpcenter/domain/entity/HelpCenterSection;", "", "id", "", "sectionName", "", "deepLinkId", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)V", "getDeepLinkId", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getId", "getSectionName", "()Ljava/lang/String;", "component1", "component2", "component3", "copy", "(Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/Integer;)Lcom/talabat/helpcenter/domain/entity/HelpCenterSection;", "equals", "", "other", "hashCode", "toString", "com_talabat_NewArchi_TalabatHelpCenter_TalabatHelpCenter"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class HelpCenterSection {
    @Nullable
    private final Integer deepLinkId;
    @Nullable

    /* renamed from: id  reason: collision with root package name */
    private final Integer f60749id;
    @Nullable
    private final String sectionName;

    public HelpCenterSection() {
        this((Integer) null, (String) null, (Integer) null, 7, (DefaultConstructorMarker) null);
    }

    public HelpCenterSection(@Nullable Integer num, @Nullable String str, @Nullable Integer num2) {
        this.f60749id = num;
        this.sectionName = str;
        this.deepLinkId = num2;
    }

    public static /* synthetic */ HelpCenterSection copy$default(HelpCenterSection helpCenterSection, Integer num, String str, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            num = helpCenterSection.f60749id;
        }
        if ((i11 & 2) != 0) {
            str = helpCenterSection.sectionName;
        }
        if ((i11 & 4) != 0) {
            num2 = helpCenterSection.deepLinkId;
        }
        return helpCenterSection.copy(num, str, num2);
    }

    @Nullable
    public final Integer component1() {
        return this.f60749id;
    }

    @Nullable
    public final String component2() {
        return this.sectionName;
    }

    @Nullable
    public final Integer component3() {
        return this.deepLinkId;
    }

    @NotNull
    public final HelpCenterSection copy(@Nullable Integer num, @Nullable String str, @Nullable Integer num2) {
        return new HelpCenterSection(num, str, num2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HelpCenterSection)) {
            return false;
        }
        HelpCenterSection helpCenterSection = (HelpCenterSection) obj;
        return Intrinsics.areEqual((Object) this.f60749id, (Object) helpCenterSection.f60749id) && Intrinsics.areEqual((Object) this.sectionName, (Object) helpCenterSection.sectionName) && Intrinsics.areEqual((Object) this.deepLinkId, (Object) helpCenterSection.deepLinkId);
    }

    @Nullable
    public final Integer getDeepLinkId() {
        return this.deepLinkId;
    }

    @Nullable
    public final Integer getId() {
        return this.f60749id;
    }

    @Nullable
    public final String getSectionName() {
        return this.sectionName;
    }

    public int hashCode() {
        Integer num = this.f60749id;
        int i11 = 0;
        int hashCode = (num == null ? 0 : num.hashCode()) * 31;
        String str = this.sectionName;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Integer num2 = this.deepLinkId;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        Integer num = this.f60749id;
        String str = this.sectionName;
        Integer num2 = this.deepLinkId;
        return "HelpCenterSection(id=" + num + ", sectionName=" + str + ", deepLinkId=" + num2 + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HelpCenterSection(Integer num, String str, Integer num2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? null : num, (i11 & 2) != 0 ? null : str, (i11 & 4) != 0 ? null : num2);
    }
}
