package com.talabat.feature.tmart.growth.domain.dto;

import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\b@\u0018\u00002\u00020\u0001B\u0012\u0012\u0006\u0010\u0002\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u0010\u0010\r\u001a\u00020\u000eHÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0011\u001a\u00020\u0003HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0001\u0002ø\u0001\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Lcom/talabat/feature/tmart/growth/domain/dto/TMartGrowthFilePath;", "", "path", "", "constructor-impl", "(Ljava/lang/String;)Ljava/lang/String;", "getPath", "()Ljava/lang/String;", "equals", "", "other", "equals-impl", "(Ljava/lang/String;Ljava/lang/Object;)Z", "hashCode", "", "hashCode-impl", "(Ljava/lang/String;)I", "toString", "toString-impl", "com_talabat_feature_tmartGrowth_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
@JvmInline
public final class TMartGrowthFilePath {
    @NotNull
    private final String path;

    private /* synthetic */ TMartGrowthFilePath(String str) {
        this.path = str;
    }

    /* renamed from: box-impl  reason: not valid java name */
    public static final /* synthetic */ TMartGrowthFilePath m10323boximpl(String str) {
        return new TMartGrowthFilePath(str);
    }

    @NotNull
    /* renamed from: constructor-impl  reason: not valid java name */
    public static String m10324constructorimpl(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "path");
        return str;
    }

    /* renamed from: equals-impl  reason: not valid java name */
    public static boolean m10325equalsimpl(String str, Object obj) {
        return (obj instanceof TMartGrowthFilePath) && Intrinsics.areEqual((Object) str, (Object) ((TMartGrowthFilePath) obj).m10329unboximpl());
    }

    /* renamed from: equals-impl0  reason: not valid java name */
    public static final boolean m10326equalsimpl0(String str, String str2) {
        return Intrinsics.areEqual((Object) str, (Object) str2);
    }

    /* renamed from: hashCode-impl  reason: not valid java name */
    public static int m10327hashCodeimpl(String str) {
        return str.hashCode();
    }

    /* renamed from: toString-impl  reason: not valid java name */
    public static String m10328toStringimpl(String str) {
        return "TMartGrowthFilePath(path=" + str + ")";
    }

    public boolean equals(Object obj) {
        return m10325equalsimpl(this.path, obj);
    }

    @NotNull
    public final String getPath() {
        return this.path;
    }

    public int hashCode() {
        return m10327hashCodeimpl(this.path);
    }

    public String toString() {
        return m10328toStringimpl(this.path);
    }

    /* renamed from: unbox-impl  reason: not valid java name */
    public final /* synthetic */ String m10329unboximpl() {
        return this.path;
    }
}
