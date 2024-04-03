package com.talabat.feature.ridertips.domain.model;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001R\u0019\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/talabat/feature/ridertips/domain/model/Terms;", "", "title", "", "description", "contents", "", "Lcom/talabat/feature/ridertips/domain/model/Term;", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V", "getContents", "()Ljava/util/List;", "getDescription", "()Ljava/lang/String;", "getTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "com_talabat_feature_ridertips_domain_domain"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Terms {
    @Nullable
    private final List<Term> contents;
    @Nullable
    private final String description;
    @Nullable
    private final String title;

    public Terms(@Nullable String str, @Nullable String str2, @Nullable List<Term> list) {
        this.title = str;
        this.description = str2;
        this.contents = list;
    }

    public static /* synthetic */ Terms copy$default(Terms terms, String str, String str2, List<Term> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = terms.title;
        }
        if ((i11 & 2) != 0) {
            str2 = terms.description;
        }
        if ((i11 & 4) != 0) {
            list = terms.contents;
        }
        return terms.copy(str, str2, list);
    }

    @Nullable
    public final String component1() {
        return this.title;
    }

    @Nullable
    public final String component2() {
        return this.description;
    }

    @Nullable
    public final List<Term> component3() {
        return this.contents;
    }

    @NotNull
    public final Terms copy(@Nullable String str, @Nullable String str2, @Nullable List<Term> list) {
        return new Terms(str, str2, list);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Terms)) {
            return false;
        }
        Terms terms = (Terms) obj;
        return Intrinsics.areEqual((Object) this.title, (Object) terms.title) && Intrinsics.areEqual((Object) this.description, (Object) terms.description) && Intrinsics.areEqual((Object) this.contents, (Object) terms.contents);
    }

    @Nullable
    public final List<Term> getContents() {
        return this.contents;
    }

    @Nullable
    public final String getDescription() {
        return this.description;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        List<Term> list = this.contents;
        if (list != null) {
            i11 = list.hashCode();
        }
        return hashCode2 + i11;
    }

    @NotNull
    public String toString() {
        String str = this.title;
        String str2 = this.description;
        List<Term> list = this.contents;
        return "Terms(title=" + str + ", description=" + str2 + ", contents=" + list + ")";
    }
}
