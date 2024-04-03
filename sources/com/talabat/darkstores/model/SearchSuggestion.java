package com.talabat.darkstores.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u000eB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\f\u001a\u00020\rH\u0016R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u0001\u0002\u000f\u0010¨\u0006\u0011"}, d2 = {"Lcom/talabat/darkstores/model/SearchSuggestion;", "", "()V", "originalSearchQuery", "", "getOriginalSearchQuery", "()Ljava/lang/String;", "setOriginalSearchQuery", "(Ljava/lang/String;)V", "equals", "", "other", "hashCode", "", "Type", "Lcom/talabat/darkstores/model/ProductSuggestion;", "Lcom/talabat/darkstores/model/CategorySuggestion;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class SearchSuggestion {
    @Nullable
    private String originalSearchQuery;

    @JsonClass(generateAdapter = false)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004¨\u0006\u0005"}, d2 = {"Lcom/talabat/darkstores/model/SearchSuggestion$Type;", "", "(Ljava/lang/String;I)V", "product", "category", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public enum Type {
        product,
        category
    }

    private SearchSuggestion() {
    }

    public /* synthetic */ SearchSuggestion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public boolean equals(@Nullable Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<?> cls2 = getClass();
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!Intrinsics.areEqual((Object) cls2, (Object) cls)) {
            return false;
        }
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type com.talabat.darkstores.model.SearchSuggestion");
        } else if (!Intrinsics.areEqual((Object) this.originalSearchQuery, (Object) ((SearchSuggestion) obj).originalSearchQuery)) {
            return false;
        } else {
            return true;
        }
    }

    @Nullable
    public final String getOriginalSearchQuery() {
        return this.originalSearchQuery;
    }

    public int hashCode() {
        String str = this.originalSearchQuery;
        if (str != null) {
            return str.hashCode();
        }
        return 0;
    }

    public final void setOriginalSearchQuery(@Nullable String str) {
        this.originalSearchQuery = str;
    }
}
