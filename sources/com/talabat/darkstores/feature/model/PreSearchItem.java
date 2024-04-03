package com.talabat.darkstores.feature.model;

import com.talabat.feature.darkstorescart.data.model.Product;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l.a;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lcom/talabat/darkstores/feature/model/PreSearchItem;", "", "()V", "RecentSearch", "RecentSearchesHeader", "Swimlane", "Lcom/talabat/darkstores/feature/model/PreSearchItem$RecentSearchesHeader;", "Lcom/talabat/darkstores/feature/model/PreSearchItem$RecentSearch;", "Lcom/talabat/darkstores/feature/model/PreSearchItem$Swimlane;", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PreSearchItem {

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/talabat/darkstores/feature/model/PreSearchItem$RecentSearch;", "Lcom/talabat/darkstores/feature/model/PreSearchItem;", "id", "", "query", "", "(JLjava/lang/String;)V", "getId", "()J", "getQuery", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RecentSearch extends PreSearchItem {

        /* renamed from: id  reason: collision with root package name */
        private final long f56471id;
        @NotNull
        private final String query;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public RecentSearch(long j11, @NotNull String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "query");
            this.f56471id = j11;
            this.query = str;
        }

        public static /* synthetic */ RecentSearch copy$default(RecentSearch recentSearch, long j11, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                j11 = recentSearch.f56471id;
            }
            if ((i11 & 2) != 0) {
                str = recentSearch.query;
            }
            return recentSearch.copy(j11, str);
        }

        public final long component1() {
            return this.f56471id;
        }

        @NotNull
        public final String component2() {
            return this.query;
        }

        @NotNull
        public final RecentSearch copy(long j11, @NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "query");
            return new RecentSearch(j11, str);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RecentSearch)) {
                return false;
            }
            RecentSearch recentSearch = (RecentSearch) obj;
            return this.f56471id == recentSearch.f56471id && Intrinsics.areEqual((Object) this.query, (Object) recentSearch.query);
        }

        public final long getId() {
            return this.f56471id;
        }

        @NotNull
        public final String getQuery() {
            return this.query;
        }

        public int hashCode() {
            return (a.a(this.f56471id) * 31) + this.query.hashCode();
        }

        @NotNull
        public String toString() {
            long j11 = this.f56471id;
            String str = this.query;
            return "RecentSearch(id=" + j11 + ", query=" + str + ")";
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/talabat/darkstores/feature/model/PreSearchItem$RecentSearchesHeader;", "Lcom/talabat/darkstores/feature/model/PreSearchItem;", "()V", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class RecentSearchesHeader extends PreSearchItem {
        @NotNull
        public static final RecentSearchesHeader INSTANCE = new RecentSearchesHeader();

        private RecentSearchesHeader() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/talabat/darkstores/feature/model/PreSearchItem$Swimlane;", "Lcom/talabat/darkstores/feature/model/PreSearchItem;", "products", "", "Lcom/talabat/feature/darkstorescart/data/model/Product;", "(Ljava/util/List;)V", "getProducts", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "com_talabat_NewArchi_darkstores_darkstores"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Swimlane extends PreSearchItem {
        @NotNull
        private final List<Product> products;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Swimlane(@NotNull List<Product> list) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(list, "products");
            this.products = list;
        }

        public static /* synthetic */ Swimlane copy$default(Swimlane swimlane, List<Product> list, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                list = swimlane.products;
            }
            return swimlane.copy(list);
        }

        @NotNull
        public final List<Product> component1() {
            return this.products;
        }

        @NotNull
        public final Swimlane copy(@NotNull List<Product> list) {
            Intrinsics.checkNotNullParameter(list, "products");
            return new Swimlane(list);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Swimlane) && Intrinsics.areEqual((Object) this.products, (Object) ((Swimlane) obj).products);
        }

        @NotNull
        public final List<Product> getProducts() {
            return this.products;
        }

        public int hashCode() {
            return this.products.hashCode();
        }

        @NotNull
        public String toString() {
            List<Product> list = this.products;
            return "Swimlane(products=" + list + ")";
        }
    }

    private PreSearchItem() {
    }

    public /* synthetic */ PreSearchItem(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }
}
