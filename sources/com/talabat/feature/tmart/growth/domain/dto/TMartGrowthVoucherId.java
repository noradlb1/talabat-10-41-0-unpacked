package com.talabat.feature.tmart.growth.domain.dto;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthVoucherId;", "", "id", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getId", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
public final class TMartGrowthVoucherId {
    @NotNull

    /* renamed from: id  reason: collision with root package name */
    private final String f59137id;

    private /* synthetic */ TMartGrowthVoucherId(String str) {
        this.f59137id = str;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TMartGrowthVoucherId m10330boximpl(String str) {
        return new TMartGrowthVoucherId(str);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static String m10331constructorimpl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "id");
        return str;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m10332equalsimpl(String str, Object obj) {
        return (obj instanceof TMartGrowthVoucherId) && Intrinsics.areEqual((Object) str, (Object) ((TMartGrowthVoucherId) obj).m10336unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m10333equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m10334hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m10335toStringimpl(String str) {
        return "TMartGrowthVoucherId(id=" + str + ")";
    }

    public boolean equals(Object obj) {
        return m10332equalsimpl(this.f59137id, obj);
    }

    @NotNull
    public final String getId() {
        return this.f59137id;
    }

    public int hashCode() {
        return m10334hashCodeimpl(this.f59137id);
    }

    public String toString() {
        return m10335toStringimpl(this.f59137id);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m10336unboximpl() {
        return this.f59137id;
    }
}
