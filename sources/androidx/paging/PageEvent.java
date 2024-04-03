package androidx.paging;

import androidx.paging.LoadState;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002:\u0003\u000f\u0010\u0011B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J;\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\"\u0010\u0005\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\tJK\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0000\"\b\b\u0001\u0010\u000b*\u00020\u00022(\u0010\f\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\r0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\tJE\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0000\"\b\b\u0001\u0010\u000b*\u00020\u00022\"\u0010\f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u000b0\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0006H@ø\u0001\u0000¢\u0006\u0002\u0010\t\u0001\u0003\u0012\u0013\u0014\u0002\u0004\n\u0002\b\u0019¨\u0006\u0015"}, d2 = {"Landroidx/paging/PageEvent;", "T", "", "()V", "filter", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flatMap", "R", "transform", "", "map", "Drop", "Insert", "LoadStateUpdate", "Landroidx/paging/PageEvent$Insert;", "Landroidx/paging/PageEvent$Drop;", "Landroidx/paging/PageEvent$LoadStateUpdate;", "paging-common"}, k = 1, mv = {1, 4, 2})
public abstract class PageEvent<T> {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B%\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0007HÆ\u0003J7\u0010\u0017\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u0007HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÖ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\u0010\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000eR\u0011\u0010\t\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000e¨\u0006\u001e"}, d2 = {"Landroidx/paging/PageEvent$Drop;", "T", "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "minPageOffset", "", "maxPageOffset", "placeholdersRemaining", "(Landroidx/paging/LoadType;III)V", "getLoadType", "()Landroidx/paging/LoadType;", "getMaxPageOffset", "()I", "getMinPageOffset", "pageCount", "getPageCount", "getPlaceholdersRemaining", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Drop<T> extends PageEvent<T> {
        @NotNull
        private final LoadType loadType;
        private final int maxPageOffset;
        private final int minPageOffset;
        private final int placeholdersRemaining;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Drop(@NotNull LoadType loadType2, int i11, int i12, int i13) {
            super((DefaultConstructorMarker) null);
            boolean z11;
            boolean z12;
            Intrinsics.checkNotNullParameter(loadType2, "loadType");
            this.loadType = loadType2;
            this.minPageOffset = i11;
            this.maxPageOffset = i12;
            this.placeholdersRemaining = i13;
            boolean z13 = true;
            if (loadType2 != LoadType.REFRESH) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (getPageCount() > 0) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    if (!(i13 < 0 ? false : z13)) {
                        throw new IllegalArgumentException(("Invalid placeholdersRemaining " + i13).toString());
                    }
                    return;
                }
                throw new IllegalArgumentException(("Drop count must be > 0, but was " + getPageCount()).toString());
            }
            throw new IllegalArgumentException("Drop load type must be PREPEND or APPEND".toString());
        }

        public static /* synthetic */ Drop copy$default(Drop drop, LoadType loadType2, int i11, int i12, int i13, int i14, Object obj) {
            if ((i14 & 1) != 0) {
                loadType2 = drop.loadType;
            }
            if ((i14 & 2) != 0) {
                i11 = drop.minPageOffset;
            }
            if ((i14 & 4) != 0) {
                i12 = drop.maxPageOffset;
            }
            if ((i14 & 8) != 0) {
                i13 = drop.placeholdersRemaining;
            }
            return drop.copy(loadType2, i11, i12, i13);
        }

        @NotNull
        public final LoadType component1() {
            return this.loadType;
        }

        public final int component2() {
            return this.minPageOffset;
        }

        public final int component3() {
            return this.maxPageOffset;
        }

        public final int component4() {
            return this.placeholdersRemaining;
        }

        @NotNull
        public final Drop<T> copy(@NotNull LoadType loadType2, int i11, int i12, int i13) {
            Intrinsics.checkNotNullParameter(loadType2, "loadType");
            return new Drop<>(loadType2, i11, i12, i13);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Drop)) {
                return false;
            }
            Drop drop = (Drop) obj;
            return Intrinsics.areEqual((Object) this.loadType, (Object) drop.loadType) && this.minPageOffset == drop.minPageOffset && this.maxPageOffset == drop.maxPageOffset && this.placeholdersRemaining == drop.placeholdersRemaining;
        }

        @NotNull
        public final LoadType getLoadType() {
            return this.loadType;
        }

        public final int getMaxPageOffset() {
            return this.maxPageOffset;
        }

        public final int getMinPageOffset() {
            return this.minPageOffset;
        }

        public final int getPageCount() {
            return (this.maxPageOffset - this.minPageOffset) + 1;
        }

        public final int getPlaceholdersRemaining() {
            return this.placeholdersRemaining;
        }

        public int hashCode() {
            LoadType loadType2 = this.loadType;
            return ((((((loadType2 != null ? loadType2.hashCode() : 0) * 31) + this.minPageOffset) * 31) + this.maxPageOffset) * 31) + this.placeholdersRemaining;
        }

        @NotNull
        public String toString() {
            return "Drop(loadType=" + this.loadType + ", minPageOffset=" + this.minPageOffset + ", maxPageOffset=" + this.maxPageOffset + ", placeholdersRemaining=" + this.placeholdersRemaining + ")";
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001c\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\b\u0018\u0000 2*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u00012B;\b\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0012\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003J\u0015\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007HÆ\u0003J\t\u0010\u001a\u001a\u00020\nHÆ\u0003J\t\u0010\u001b\u001a\u00020\nHÆ\u0003J\t\u0010\u001c\u001a\u00020\rHÆ\u0003JM\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0014\b\u0002\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\f\u001a\u00020\rHÆ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0002HÖ\u0003J;\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00010\u00032\"\u0010\"\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001f0$\u0012\u0006\u0012\u0004\u0018\u00010\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010%JK\u0010&\u001a\b\u0012\u0004\u0012\u0002H'0\u0003\"\b\b\u0002\u0010'*\u00020\u00022(\u0010(\u001a$\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0)0$\u0012\u0006\u0012\u0004\u0018\u00010\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010%J\t\u0010*\u001a\u00020\nHÖ\u0001JE\u0010+\u001a\b\u0012\u0004\u0012\u0002H'0\u0003\"\b\b\u0002\u0010'*\u00020\u00022\"\u0010(\u001a\u001e\b\u0001\u0012\u0004\u0012\u00028\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0$\u0012\u0006\u0012\u0004\u0018\u00010\u00020#H@ø\u0001\u0000¢\u0006\u0002\u0010%J9\u0010,\u001a\b\u0012\u0004\u0012\u0002H'0\u0000\"\b\b\u0002\u0010'*\u00020\u00022\u001e\u0010(\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0\b0-H\bJ\t\u0010.\u001a\u00020/HÖ\u0001JM\u00100\u001a\b\u0012\u0004\u0012\u0002H'0\u0000\"\b\b\u0002\u0010'*\u00020\u00022*\u0010(\u001a&\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H'0\b0\u00070-H\bø\u0001\u0001¢\u0006\u0002\b1R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\b0\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000b\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u00063"}, d2 = {"Landroidx/paging/PageEvent$Insert;", "T", "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersBefore", "", "placeholdersAfter", "combinedLoadStates", "Landroidx/paging/CombinedLoadStates;", "(Landroidx/paging/LoadType;Ljava/util/List;IILandroidx/paging/CombinedLoadStates;)V", "getCombinedLoadStates", "()Landroidx/paging/CombinedLoadStates;", "getLoadType", "()Landroidx/paging/LoadType;", "getPages", "()Ljava/util/List;", "getPlaceholdersAfter", "()I", "getPlaceholdersBefore", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "filter", "predicate", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "flatMap", "R", "transform", "", "hashCode", "map", "mapPages", "Lkotlin/Function1;", "toString", "", "transformPages", "transformPages$paging_common", "Companion", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class Insert<T> extends PageEvent<T> {
        @NotNull
        public static final Companion Companion;
        /* access modifiers changed from: private */
        @NotNull
        public static final Insert<Object> EMPTY_REFRESH_LOCAL;
        @NotNull
        private final CombinedLoadStates combinedLoadStates;
        @NotNull
        private final LoadType loadType;
        @NotNull
        private final List<TransformablePage<T>> pages;
        private final int placeholdersAfter;
        private final int placeholdersBefore;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J:\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ:\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJB\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\b0\u0004\"\b\b\u0002\u0010\b*\u00020\u00012\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\b0\u000b0\n2\u0006\u0010\u0011\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Landroidx/paging/PageEvent$Insert$Companion;", "", "()V", "EMPTY_REFRESH_LOCAL", "Landroidx/paging/PageEvent$Insert;", "getEMPTY_REFRESH_LOCAL", "()Landroidx/paging/PageEvent$Insert;", "Append", "T", "pages", "", "Landroidx/paging/TransformablePage;", "placeholdersAfter", "", "combinedLoadStates", "Landroidx/paging/CombinedLoadStates;", "Prepend", "placeholdersBefore", "Refresh", "paging-common"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            @NotNull
            public final <T> Insert<T> Append(@NotNull List<TransformablePage<T>> list, int i11, @NotNull CombinedLoadStates combinedLoadStates) {
                Intrinsics.checkNotNullParameter(list, "pages");
                Intrinsics.checkNotNullParameter(combinedLoadStates, "combinedLoadStates");
                return new Insert(LoadType.APPEND, list, -1, i11, combinedLoadStates, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final <T> Insert<T> Prepend(@NotNull List<TransformablePage<T>> list, int i11, @NotNull CombinedLoadStates combinedLoadStates) {
                Intrinsics.checkNotNullParameter(list, "pages");
                Intrinsics.checkNotNullParameter(combinedLoadStates, "combinedLoadStates");
                return new Insert(LoadType.PREPEND, list, i11, -1, combinedLoadStates, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final <T> Insert<T> Refresh(@NotNull List<TransformablePage<T>> list, int i11, int i12, @NotNull CombinedLoadStates combinedLoadStates) {
                Intrinsics.checkNotNullParameter(list, "pages");
                Intrinsics.checkNotNullParameter(combinedLoadStates, "combinedLoadStates");
                return new Insert(LoadType.REFRESH, list, i11, i12, combinedLoadStates, (DefaultConstructorMarker) null);
            }

            @NotNull
            public final Insert<Object> getEMPTY_REFRESH_LOCAL() {
                return Insert.EMPTY_REFRESH_LOCAL;
            }
        }

        static {
            Companion companion = new Companion((DefaultConstructorMarker) null);
            Companion = companion;
            List listOf = CollectionsKt__CollectionsJVMKt.listOf(TransformablePage.Companion.getEMPTY_INITIAL_PAGE());
            LoadState.NotLoading.Companion companion2 = LoadState.NotLoading.Companion;
            EMPTY_REFRESH_LOCAL = companion.Refresh(listOf, 0, 0, new CombinedLoadStates(companion2.getIncomplete$paging_common(), companion2.getComplete$paging_common(), companion2.getComplete$paging_common(), new LoadStates(companion2.getIncomplete$paging_common(), companion2.getComplete$paging_common(), companion2.getComplete$paging_common()), (LoadStates) null, 16, (DefaultConstructorMarker) null));
        }

        public /* synthetic */ Insert(LoadType loadType2, List list, int i11, int i12, CombinedLoadStates combinedLoadStates2, DefaultConstructorMarker defaultConstructorMarker) {
            this(loadType2, list, i11, i12, combinedLoadStates2);
        }

        public static /* synthetic */ Insert copy$default(Insert insert, LoadType loadType2, List<TransformablePage<T>> list, int i11, int i12, CombinedLoadStates combinedLoadStates2, int i13, Object obj) {
            if ((i13 & 1) != 0) {
                loadType2 = insert.loadType;
            }
            if ((i13 & 2) != 0) {
                list = insert.pages;
            }
            List<TransformablePage<T>> list2 = list;
            if ((i13 & 4) != 0) {
                i11 = insert.placeholdersBefore;
            }
            int i14 = i11;
            if ((i13 & 8) != 0) {
                i12 = insert.placeholdersAfter;
            }
            int i15 = i12;
            if ((i13 & 16) != 0) {
                combinedLoadStates2 = insert.combinedLoadStates;
            }
            return insert.copy(loadType2, list2, i14, i15, combinedLoadStates2);
        }

        private final <R> Insert<R> mapPages(Function1<? super TransformablePage<T>, TransformablePage<R>> function1) {
            LoadType loadType2 = getLoadType();
            Iterable<Object> pages2 = getPages();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(pages2, 10));
            for (Object invoke : pages2) {
                arrayList.add(function1.invoke(invoke));
            }
            return new Insert(loadType2, arrayList, getPlaceholdersBefore(), getPlaceholdersAfter(), getCombinedLoadStates(), (DefaultConstructorMarker) null);
        }

        @NotNull
        public final LoadType component1() {
            return this.loadType;
        }

        @NotNull
        public final List<TransformablePage<T>> component2() {
            return this.pages;
        }

        public final int component3() {
            return this.placeholdersBefore;
        }

        public final int component4() {
            return this.placeholdersAfter;
        }

        @NotNull
        public final CombinedLoadStates component5() {
            return this.combinedLoadStates;
        }

        @NotNull
        public final Insert<T> copy(@NotNull LoadType loadType2, @NotNull List<TransformablePage<T>> list, int i11, int i12, @NotNull CombinedLoadStates combinedLoadStates2) {
            Intrinsics.checkNotNullParameter(loadType2, "loadType");
            Intrinsics.checkNotNullParameter(list, "pages");
            Intrinsics.checkNotNullParameter(combinedLoadStates2, "combinedLoadStates");
            return new Insert(loadType2, list, i11, i12, combinedLoadStates2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Insert)) {
                return false;
            }
            Insert insert = (Insert) obj;
            return Intrinsics.areEqual((Object) this.loadType, (Object) insert.loadType) && Intrinsics.areEqual((Object) this.pages, (Object) insert.pages) && this.placeholdersBefore == insert.placeholdersBefore && this.placeholdersAfter == insert.placeholdersAfter && Intrinsics.areEqual((Object) this.combinedLoadStates, (Object) insert.combinedLoadStates);
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00cd  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0120  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Object filter(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Boolean>, ? extends java.lang.Object> r20, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<T>> r21) {
            /*
                r19 = this;
                r0 = r21
                boolean r1 = r0 instanceof androidx.paging.PageEvent$Insert$filter$1
                if (r1 == 0) goto L_0x0017
                r1 = r0
                androidx.paging.PageEvent$Insert$filter$1 r1 = (androidx.paging.PageEvent$Insert$filter$1) r1
                int r2 = r1.f36647i
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r2 & r3
                if (r4 == 0) goto L_0x0017
                int r2 = r2 - r3
                r1.f36647i = r2
                r2 = r19
                goto L_0x001e
            L_0x0017:
                androidx.paging.PageEvent$Insert$filter$1 r1 = new androidx.paging.PageEvent$Insert$filter$1
                r2 = r19
                r1.<init>(r2, r0)
            L_0x001e:
                java.lang.Object r0 = r1.f36646h
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r4 = r1.f36647i
                r5 = 1
                if (r4 == 0) goto L_0x0071
                if (r4 != r5) goto L_0x0069
                int r4 = r1.f36661w
                int r6 = r1.f36660v
                java.lang.Object r7 = r1.f36659u
                java.util.Collection r7 = (java.util.Collection) r7
                java.lang.Object r8 = r1.f36658t
                java.lang.Object r9 = r1.f36657s
                java.util.Iterator r9 = (java.util.Iterator) r9
                java.lang.Object r10 = r1.f36656r
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r11 = r1.f36655q
                java.util.List r11 = (java.util.List) r11
                java.lang.Object r12 = r1.f36654p
                androidx.paging.TransformablePage r12 = (androidx.paging.TransformablePage) r12
                java.lang.Object r13 = r1.f36653o
                java.util.Iterator r13 = (java.util.Iterator) r13
                java.lang.Object r14 = r1.f36652n
                java.util.Collection r14 = (java.util.Collection) r14
                java.lang.Object r15 = r1.f36651m
                androidx.paging.LoadType r15 = (androidx.paging.LoadType) r15
                java.lang.Object r5 = r1.f36650l
                androidx.paging.PageEvent$Insert r5 = (androidx.paging.PageEvent.Insert) r5
                java.lang.Object r2 = r1.f36649k
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                kotlin.ResultKt.throwOnFailure(r0)
                r17 = r5
                r5 = r3
                r3 = r13
                r13 = r12
                r12 = r11
                r11 = r10
                r10 = r9
                r9 = r6
                r6 = r17
                goto L_0x0118
            L_0x0069:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0071:
                kotlin.ResultKt.throwOnFailure(r0)
                androidx.paging.LoadType r0 = r19.getLoadType()
                java.util.List r2 = r19.getPages()
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.ArrayList r4 = new java.util.ArrayList
                r5 = 10
                int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r2, r5)
                r4.<init>(r5)
                java.util.Iterator r2 = r2.iterator()
                r6 = r19
                r5 = r4
                r4 = r3
                r3 = r2
                r2 = r0
                r0 = r20
            L_0x0095:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L_0x0159
                java.lang.Object r7 = r3.next()
                androidx.paging.TransformablePage r7 = (androidx.paging.TransformablePage) r7
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                java.util.List r10 = r7.getData()
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                java.util.Iterator r10 = r10.iterator()
                r11 = 0
                r12 = r7
                r7 = r5
                r17 = r10
                r10 = r8
                r8 = r11
                r11 = r9
                r9 = r17
            L_0x00bf:
                boolean r13 = r9.hasNext()
                if (r13 == 0) goto L_0x0147
                java.lang.Object r13 = r9.next()
                int r14 = r8 + 1
                if (r8 >= 0) goto L_0x00d0
                kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
            L_0x00d0:
                java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
                int r8 = r8.intValue()
                r1.f36649k = r0
                r1.f36650l = r6
                r1.f36651m = r2
                r1.f36652n = r5
                r1.f36653o = r3
                r1.f36654p = r12
                r1.f36655q = r11
                r1.f36656r = r10
                r1.f36657s = r9
                r1.f36658t = r13
                r1.f36659u = r7
                r1.f36660v = r14
                r1.f36661w = r8
                r15 = 1
                r1.f36647i = r15
                r16 = 6
                kotlin.jvm.internal.InlineMarker.mark((int) r16)
                java.lang.Object r15 = r0.invoke(r13, r1)
                r16 = 7
                kotlin.jvm.internal.InlineMarker.mark((int) r16)
                if (r15 != r4) goto L_0x0106
                return r4
            L_0x0106:
                r17 = r2
                r2 = r0
                r0 = r15
                r15 = r17
                r18 = r5
                r5 = r4
                r4 = r8
                r8 = r13
                r13 = r12
                r12 = r11
                r11 = r10
                r10 = r9
                r9 = r14
                r14 = r18
            L_0x0118:
                java.lang.Boolean r0 = (java.lang.Boolean) r0
                boolean r0 = r0.booleanValue()
                if (r0 == 0) goto L_0x013c
                r11.add(r8)
                java.util.List r0 = r13.getHintOriginalIndices()
                if (r0 == 0) goto L_0x0135
                java.lang.Object r0 = r0.get(r4)
                java.lang.Integer r0 = (java.lang.Integer) r0
                if (r0 == 0) goto L_0x0135
                int r4 = r0.intValue()
            L_0x0135:
                java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
                r12.add(r0)
            L_0x013c:
                r0 = r2
                r4 = r5
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r12
                r12 = r13
                r5 = r14
                r2 = r15
                goto L_0x00bf
            L_0x0147:
                androidx.paging.TransformablePage r8 = new androidx.paging.TransformablePage
                int[] r9 = r12.getOriginalPageOffsets()
                int r12 = r12.getHintOriginalPageOffset()
                r8.<init>(r9, r10, r12, r11)
                r7.add(r8)
                goto L_0x0095
            L_0x0159:
                r3 = r5
                java.util.List r3 = (java.util.List) r3
                int r4 = r6.getPlaceholdersBefore()
                int r5 = r6.getPlaceholdersAfter()
                androidx.paging.CombinedLoadStates r6 = r6.getCombinedLoadStates()
                r7 = 0
                androidx.paging.PageEvent$Insert r0 = new androidx.paging.PageEvent$Insert
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.filter(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x0071  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x009b  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00c5  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00cd  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x010b  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x013b A[LOOP:0: B:30:0x0131->B:32:0x013b, LOOP_END] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0029  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <R> java.lang.Object flatMap(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super java.lang.Iterable<? extends R>>, ? extends java.lang.Object> r19, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r20) {
            /*
                r18 = this;
                r0 = r20
                boolean r1 = r0 instanceof androidx.paging.PageEvent$Insert$flatMap$1
                if (r1 == 0) goto L_0x0017
                r1 = r0
                androidx.paging.PageEvent$Insert$flatMap$1 r1 = (androidx.paging.PageEvent$Insert$flatMap$1) r1
                int r2 = r1.f36663i
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r2 & r3
                if (r4 == 0) goto L_0x0017
                int r2 = r2 - r3
                r1.f36663i = r2
                r2 = r18
                goto L_0x001e
            L_0x0017:
                androidx.paging.PageEvent$Insert$flatMap$1 r1 = new androidx.paging.PageEvent$Insert$flatMap$1
                r2 = r18
                r1.<init>(r2, r0)
            L_0x001e:
                java.lang.Object r0 = r1.f36662h
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r4 = r1.f36663i
                r5 = 1
                if (r4 == 0) goto L_0x0071
                if (r4 != r5) goto L_0x0069
                int r4 = r1.f36677w
                int r6 = r1.f36676v
                java.lang.Object r7 = r1.f36675u
                java.util.Collection r7 = (java.util.Collection) r7
                java.lang.Object r8 = r1.f36674t
                java.util.Collection r8 = (java.util.Collection) r8
                java.lang.Object r9 = r1.f36673s
                java.util.Iterator r9 = (java.util.Iterator) r9
                java.lang.Object r10 = r1.f36672r
                java.util.List r10 = (java.util.List) r10
                java.lang.Object r11 = r1.f36671q
                java.util.List r11 = (java.util.List) r11
                java.lang.Object r12 = r1.f36670p
                androidx.paging.TransformablePage r12 = (androidx.paging.TransformablePage) r12
                java.lang.Object r13 = r1.f36669o
                java.util.Iterator r13 = (java.util.Iterator) r13
                java.lang.Object r14 = r1.f36668n
                java.util.Collection r14 = (java.util.Collection) r14
                java.lang.Object r15 = r1.f36667m
                androidx.paging.LoadType r15 = (androidx.paging.LoadType) r15
                java.lang.Object r5 = r1.f36666l
                androidx.paging.PageEvent$Insert r5 = (androidx.paging.PageEvent.Insert) r5
                java.lang.Object r2 = r1.f36665k
                kotlin.jvm.functions.Function2 r2 = (kotlin.jvm.functions.Function2) r2
                kotlin.ResultKt.throwOnFailure(r0)
                r16 = r12
                r12 = r11
                r11 = r10
                r10 = r9
                r9 = r6
                r6 = r5
                r5 = r3
                r3 = 1
                goto L_0x011a
            L_0x0069:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x0071:
                kotlin.ResultKt.throwOnFailure(r0)
                androidx.paging.LoadType r0 = r18.getLoadType()
                java.util.List r2 = r18.getPages()
                java.lang.Iterable r2 = (java.lang.Iterable) r2
                java.util.ArrayList r4 = new java.util.ArrayList
                r5 = 10
                int r5 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r2, r5)
                r4.<init>(r5)
                java.util.Iterator r2 = r2.iterator()
                r6 = r18
                r5 = r4
                r4 = r3
                r3 = r2
                r2 = r0
                r0 = r19
            L_0x0095:
                boolean r7 = r3.hasNext()
                if (r7 == 0) goto L_0x0167
                java.lang.Object r7 = r3.next()
                androidx.paging.TransformablePage r7 = (androidx.paging.TransformablePage) r7
                java.util.ArrayList r8 = new java.util.ArrayList
                r8.<init>()
                java.util.ArrayList r9 = new java.util.ArrayList
                r9.<init>()
                java.util.List r10 = r7.getData()
                java.lang.Iterable r10 = (java.lang.Iterable) r10
                java.util.Iterator r10 = r10.iterator()
                r11 = 0
                r12 = r7
                r7 = r5
                r17 = r10
                r10 = r8
                r8 = r11
                r11 = r9
                r9 = r17
            L_0x00bf:
                boolean r13 = r9.hasNext()
                if (r13 == 0) goto L_0x0150
                java.lang.Object r13 = r9.next()
                int r14 = r8 + 1
                if (r8 >= 0) goto L_0x00d0
                kotlin.collections.CollectionsKt__CollectionsKt.throwIndexOverflow()
            L_0x00d0:
                java.lang.Integer r8 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r8)
                int r8 = r8.intValue()
                r15 = r10
                java.util.Collection r15 = (java.util.Collection) r15
                r1.f36665k = r0
                r1.f36666l = r6
                r1.f36667m = r2
                r1.f36668n = r5
                r1.f36669o = r3
                r1.f36670p = r12
                r1.f36671q = r11
                r1.f36672r = r10
                r1.f36673s = r9
                r1.f36674t = r15
                r1.f36675u = r7
                r1.f36676v = r14
                r1.f36677w = r8
                r19 = r3
                r3 = 1
                r1.f36663i = r3
                r16 = 6
                kotlin.jvm.internal.InlineMarker.mark((int) r16)
                java.lang.Object r13 = r0.invoke(r13, r1)
                r16 = 7
                kotlin.jvm.internal.InlineMarker.mark((int) r16)
                if (r13 != r4) goto L_0x010b
                return r4
            L_0x010b:
                r16 = r12
                r12 = r11
                r11 = r10
                r10 = r9
                r9 = r14
                r14 = r5
                r5 = r4
                r4 = r8
                r8 = r15
                r15 = r2
                r2 = r0
                r0 = r13
                r13 = r19
            L_0x011a:
                java.lang.Iterable r0 = (java.lang.Iterable) r0
                boolean unused = kotlin.collections.CollectionsKt__MutableCollectionsKt.addAll(r8, r0)
                java.util.List r0 = r16.getHintOriginalIndices()
                if (r0 == 0) goto L_0x0131
                java.lang.Object r0 = r0.get(r4)
                java.lang.Integer r0 = (java.lang.Integer) r0
                if (r0 == 0) goto L_0x0131
                int r4 = r0.intValue()
            L_0x0131:
                int r0 = r12.size()
                int r8 = r11.size()
                if (r0 >= r8) goto L_0x0143
                java.lang.Integer r0 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r4)
                r12.add(r0)
                goto L_0x0131
            L_0x0143:
                r0 = r2
                r4 = r5
                r8 = r9
                r9 = r10
                r10 = r11
                r11 = r12
                r3 = r13
                r5 = r14
                r2 = r15
                r12 = r16
                goto L_0x00bf
            L_0x0150:
                r19 = r3
                r3 = 1
                androidx.paging.TransformablePage r8 = new androidx.paging.TransformablePage
                int[] r9 = r12.getOriginalPageOffsets()
                int r12 = r12.getHintOriginalPageOffset()
                r8.<init>(r9, r10, r12, r11)
                r7.add(r8)
                r3 = r19
                goto L_0x0095
            L_0x0167:
                r3 = r5
                java.util.List r3 = (java.util.List) r3
                int r4 = r6.getPlaceholdersBefore()
                int r5 = r6.getPlaceholdersAfter()
                androidx.paging.CombinedLoadStates r6 = r6.getCombinedLoadStates()
                r7 = 0
                androidx.paging.PageEvent$Insert r0 = new androidx.paging.PageEvent$Insert
                r1 = r0
                r1.<init>(r2, r3, r4, r5, r6, r7)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.flatMap(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @NotNull
        public final CombinedLoadStates getCombinedLoadStates() {
            return this.combinedLoadStates;
        }

        @NotNull
        public final LoadType getLoadType() {
            return this.loadType;
        }

        @NotNull
        public final List<TransformablePage<T>> getPages() {
            return this.pages;
        }

        public final int getPlaceholdersAfter() {
            return this.placeholdersAfter;
        }

        public final int getPlaceholdersBefore() {
            return this.placeholdersBefore;
        }

        public int hashCode() {
            LoadType loadType2 = this.loadType;
            int i11 = 0;
            int hashCode = (loadType2 != null ? loadType2.hashCode() : 0) * 31;
            List<TransformablePage<T>> list = this.pages;
            int hashCode2 = (((((hashCode + (list != null ? list.hashCode() : 0)) * 31) + this.placeholdersBefore) * 31) + this.placeholdersAfter) * 31;
            CombinedLoadStates combinedLoadStates2 = this.combinedLoadStates;
            if (combinedLoadStates2 != null) {
                i11 = combinedLoadStates2.hashCode();
            }
            return hashCode2 + i11;
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x006d  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0091  */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00ba  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00e8  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x002b  */
        @org.jetbrains.annotations.Nullable
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public <R> java.lang.Object map(@org.jetbrains.annotations.NotNull kotlin.jvm.functions.Function2<? super T, ? super kotlin.coroutines.Continuation<? super R>, ? extends java.lang.Object> r18, @org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super androidx.paging.PageEvent<R>> r19) {
            /*
                r17 = this;
                r0 = r19
                boolean r1 = r0 instanceof androidx.paging.PageEvent$Insert$map$1
                if (r1 == 0) goto L_0x0017
                r1 = r0
                androidx.paging.PageEvent$Insert$map$1 r1 = (androidx.paging.PageEvent$Insert$map$1) r1
                int r2 = r1.f36679i
                r3 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r2 & r3
                if (r4 == 0) goto L_0x0017
                int r2 = r2 - r3
                r1.f36679i = r2
                r2 = r17
                goto L_0x001e
            L_0x0017:
                androidx.paging.PageEvent$Insert$map$1 r1 = new androidx.paging.PageEvent$Insert$map$1
                r2 = r17
                r1.<init>(r2, r0)
            L_0x001e:
                java.lang.Object r0 = r1.f36678h
                java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r4 = r1.f36679i
                r5 = 10
                r6 = 1
                if (r4 == 0) goto L_0x006d
                if (r4 != r6) goto L_0x0065
                java.lang.Object r4 = r1.f36691u
                java.util.Collection r4 = (java.util.Collection) r4
                java.lang.Object r7 = r1.f36690t
                java.util.Collection r7 = (java.util.Collection) r7
                java.lang.Object r8 = r1.f36689s
                java.util.Iterator r8 = (java.util.Iterator) r8
                java.lang.Object r9 = r1.f36688r
                java.util.Collection r9 = (java.util.Collection) r9
                java.lang.Object r10 = r1.f36687q
                int[] r10 = (int[]) r10
                java.lang.Object r11 = r1.f36686p
                androidx.paging.TransformablePage r11 = (androidx.paging.TransformablePage) r11
                java.lang.Object r12 = r1.f36685o
                java.util.Iterator r12 = (java.util.Iterator) r12
                java.lang.Object r13 = r1.f36684n
                java.util.Collection r13 = (java.util.Collection) r13
                java.lang.Object r14 = r1.f36683m
                androidx.paging.LoadType r14 = (androidx.paging.LoadType) r14
                java.lang.Object r15 = r1.f36682l
                androidx.paging.PageEvent$Insert r15 = (androidx.paging.PageEvent.Insert) r15
                java.lang.Object r6 = r1.f36681k
                kotlin.jvm.functions.Function2 r6 = (kotlin.jvm.functions.Function2) r6
                kotlin.ResultKt.throwOnFailure(r0)
                r16 = r11
                r11 = r8
                r8 = r14
                r14 = r9
                r9 = r15
                r15 = 1
                goto L_0x00f0
            L_0x0065:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x006d:
                kotlin.ResultKt.throwOnFailure(r0)
                androidx.paging.LoadType r0 = r17.getLoadType()
                java.util.List r4 = r17.getPages()
                java.lang.Iterable r4 = (java.lang.Iterable) r4
                java.util.ArrayList r6 = new java.util.ArrayList
                int r7 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r4, r5)
                r6.<init>(r7)
                java.util.Iterator r4 = r4.iterator()
                r7 = r0
                r8 = r2
                r0 = r18
            L_0x008b:
                boolean r9 = r4.hasNext()
                if (r9 == 0) goto L_0x0113
                java.lang.Object r9 = r4.next()
                androidx.paging.TransformablePage r9 = (androidx.paging.TransformablePage) r9
                int[] r10 = r9.getOriginalPageOffsets()
                java.util.List r11 = r9.getData()
                java.lang.Iterable r11 = (java.lang.Iterable) r11
                java.util.ArrayList r12 = new java.util.ArrayList
                int r13 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r11, r5)
                r12.<init>(r13)
                java.util.Iterator r11 = r11.iterator()
                r13 = r9
                r9 = r8
                r8 = r7
                r7 = r6
                r6 = r4
                r4 = r7
            L_0x00b4:
                boolean r14 = r11.hasNext()
                if (r14 == 0) goto L_0x00fa
                java.lang.Object r14 = r11.next()
                r1.f36681k = r0
                r1.f36682l = r9
                r1.f36683m = r8
                r1.f36684n = r7
                r1.f36685o = r6
                r1.f36686p = r13
                r1.f36687q = r10
                r1.f36688r = r12
                r1.f36689s = r11
                r1.f36690t = r12
                r1.f36691u = r4
                r15 = 1
                r1.f36679i = r15
                r16 = 6
                kotlin.jvm.internal.InlineMarker.mark((int) r16)
                java.lang.Object r14 = r0.invoke(r14, r1)
                r16 = 7
                kotlin.jvm.internal.InlineMarker.mark((int) r16)
                if (r14 != r3) goto L_0x00e8
                return r3
            L_0x00e8:
                r16 = r13
                r13 = r7
                r7 = r12
                r12 = r6
                r6 = r0
                r0 = r14
                r14 = r7
            L_0x00f0:
                r7.add(r0)
                r0 = r6
                r6 = r12
                r7 = r13
                r12 = r14
                r13 = r16
                goto L_0x00b4
            L_0x00fa:
                r15 = 1
                java.util.List r12 = (java.util.List) r12
                int r11 = r13.getHintOriginalPageOffset()
                java.util.List r13 = r13.getHintOriginalIndices()
                androidx.paging.TransformablePage r14 = new androidx.paging.TransformablePage
                r14.<init>(r10, r12, r11, r13)
                r4.add(r14)
                r4 = r6
                r6 = r7
                r7 = r8
                r8 = r9
                goto L_0x008b
            L_0x0113:
                r0 = r6
                java.util.List r0 = (java.util.List) r0
                int r9 = r8.getPlaceholdersBefore()
                int r10 = r8.getPlaceholdersAfter()
                androidx.paging.CombinedLoadStates r11 = r8.getCombinedLoadStates()
                r12 = 0
                androidx.paging.PageEvent$Insert r1 = new androidx.paging.PageEvent$Insert
                r6 = r1
                r8 = r0
                r6.<init>(r7, r8, r9, r10, r11, r12)
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.paging.PageEvent.Insert.map(kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
        }

        @NotNull
        public String toString() {
            return "Insert(loadType=" + this.loadType + ", pages=" + this.pages + ", placeholdersBefore=" + this.placeholdersBefore + ", placeholdersAfter=" + this.placeholdersAfter + ", combinedLoadStates=" + this.combinedLoadStates + ")";
        }

        @NotNull
        public final <R> Insert<R> transformPages$paging_common(@NotNull Function1<? super List<TransformablePage<T>>, ? extends List<TransformablePage<R>>> function1) {
            Intrinsics.checkNotNullParameter(function1, "transform");
            return new Insert(getLoadType(), (List) function1.invoke(getPages()), getPlaceholdersBefore(), getPlaceholdersAfter(), getCombinedLoadStates(), (DefaultConstructorMarker) null);
        }

        private Insert(LoadType loadType2, List<TransformablePage<T>> list, int i11, int i12, CombinedLoadStates combinedLoadStates2) {
            super((DefaultConstructorMarker) null);
            this.loadType = loadType2;
            this.pages = list;
            this.placeholdersBefore = i11;
            this.placeholdersAfter = i12;
            this.combinedLoadStates = combinedLoadStates2;
            boolean z11 = false;
            if (loadType2 == LoadType.APPEND || i11 >= 0) {
                if (loadType2 == LoadType.PREPEND || i12 >= 0) {
                    if (!((loadType2 != LoadType.REFRESH || (list.isEmpty() ^ true)) ? true : z11)) {
                        throw new IllegalArgumentException("Cannot create a REFRESH Insert event with no TransformablePages as this could permanently stall pagination. Note that this check does not prevent empty LoadResults and is instead usually an indication of an internal error in Paging itself.".toString());
                    }
                    return;
                }
                throw new IllegalArgumentException(("Append insert defining placeholdersAfter must be > 0, but was" + ' ' + i12).toString());
            }
            throw new IllegalArgumentException(("Prepend insert defining placeholdersBefore must be > 0, but was" + ' ' + i11).toString());
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\b\u0018\u0000 \u001b*\b\b\u0001\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u001bB\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0013\u001a\u00020\tHÆ\u0003J-\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001J\u0013\u0010\u0015\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001c"}, d2 = {"Landroidx/paging/PageEvent$LoadStateUpdate;", "T", "", "Landroidx/paging/PageEvent;", "loadType", "Landroidx/paging/LoadType;", "fromMediator", "", "loadState", "Landroidx/paging/LoadState;", "(Landroidx/paging/LoadType;ZLandroidx/paging/LoadState;)V", "getFromMediator", "()Z", "getLoadState", "()Landroidx/paging/LoadState;", "getLoadType", "()Landroidx/paging/LoadType;", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "", "Companion", "paging-common"}, k = 1, mv = {1, 4, 2})
    public static final class LoadStateUpdate<T> extends PageEvent<T> {
        @NotNull
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private final boolean fromMediator;
        @NotNull
        private final LoadState loadState;
        @NotNull
        private final LoadType loadType;

        @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001d\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\b¨\u0006\t"}, d2 = {"Landroidx/paging/PageEvent$LoadStateUpdate$Companion;", "", "()V", "canDispatchWithoutInsert", "", "loadState", "Landroidx/paging/LoadState;", "fromMediator", "canDispatchWithoutInsert$paging_common", "paging-common"}, k = 1, mv = {1, 4, 2})
        public static final class Companion {
            private Companion() {
            }

            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            public final boolean canDispatchWithoutInsert$paging_common(@NotNull LoadState loadState, boolean z11) {
                Intrinsics.checkNotNullParameter(loadState, "loadState");
                if ((loadState instanceof LoadState.Loading) || (loadState instanceof LoadState.Error) || z11) {
                    return true;
                }
                return false;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public LoadStateUpdate(@NotNull LoadType loadType2, boolean z11, @NotNull LoadState loadState2) {
            super((DefaultConstructorMarker) null);
            boolean z12;
            Intrinsics.checkNotNullParameter(loadType2, "loadType");
            Intrinsics.checkNotNullParameter(loadState2, "loadState");
            this.loadType = loadType2;
            this.fromMediator = z11;
            this.loadState = loadState2;
            if (loadType2 != LoadType.REFRESH || z11 || !(loadState2 instanceof LoadState.NotLoading) || !loadState2.getEndOfPaginationReached()) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                throw new IllegalArgumentException("LoadStateUpdate for local REFRESH may not set endOfPaginationReached = true".toString());
            } else if (!Companion.canDispatchWithoutInsert$paging_common(loadState2, z11)) {
                throw new IllegalArgumentException("LoadStateUpdates cannot be used to dispatch NotLoading unless it is from remote mediator and remote mediator reached end of pagination.".toString());
            }
        }

        public static /* synthetic */ LoadStateUpdate copy$default(LoadStateUpdate loadStateUpdate, LoadType loadType2, boolean z11, LoadState loadState2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                loadType2 = loadStateUpdate.loadType;
            }
            if ((i11 & 2) != 0) {
                z11 = loadStateUpdate.fromMediator;
            }
            if ((i11 & 4) != 0) {
                loadState2 = loadStateUpdate.loadState;
            }
            return loadStateUpdate.copy(loadType2, z11, loadState2);
        }

        @NotNull
        public final LoadType component1() {
            return this.loadType;
        }

        public final boolean component2() {
            return this.fromMediator;
        }

        @NotNull
        public final LoadState component3() {
            return this.loadState;
        }

        @NotNull
        public final LoadStateUpdate<T> copy(@NotNull LoadType loadType2, boolean z11, @NotNull LoadState loadState2) {
            Intrinsics.checkNotNullParameter(loadType2, "loadType");
            Intrinsics.checkNotNullParameter(loadState2, "loadState");
            return new LoadStateUpdate<>(loadType2, z11, loadState2);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof LoadStateUpdate)) {
                return false;
            }
            LoadStateUpdate loadStateUpdate = (LoadStateUpdate) obj;
            return Intrinsics.areEqual((Object) this.loadType, (Object) loadStateUpdate.loadType) && this.fromMediator == loadStateUpdate.fromMediator && Intrinsics.areEqual((Object) this.loadState, (Object) loadStateUpdate.loadState);
        }

        public final boolean getFromMediator() {
            return this.fromMediator;
        }

        @NotNull
        public final LoadState getLoadState() {
            return this.loadState;
        }

        @NotNull
        public final LoadType getLoadType() {
            return this.loadType;
        }

        public int hashCode() {
            LoadType loadType2 = this.loadType;
            int i11 = 0;
            int hashCode = (loadType2 != null ? loadType2.hashCode() : 0) * 31;
            boolean z11 = this.fromMediator;
            if (z11) {
                z11 = true;
            }
            int i12 = (hashCode + (z11 ? 1 : 0)) * 31;
            LoadState loadState2 = this.loadState;
            if (loadState2 != null) {
                i11 = loadState2.hashCode();
            }
            return i12 + i11;
        }

        @NotNull
        public String toString() {
            return "LoadStateUpdate(loadType=" + this.loadType + ", fromMediator=" + this.fromMediator + ", loadState=" + this.loadState + ")";
        }
    }

    private PageEvent() {
    }

    public /* synthetic */ PageEvent(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public static /* synthetic */ Object a(PageEvent pageEvent, Function2 function2, Continuation continuation) {
        return pageEvent;
    }

    public static /* synthetic */ Object b(PageEvent pageEvent, Function2 function2, Continuation continuation) {
        if (pageEvent != null) {
            return pageEvent;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.paging.PageEvent<R>");
    }

    public static /* synthetic */ Object c(PageEvent pageEvent, Function2 function2, Continuation continuation) {
        if (pageEvent != null) {
            return pageEvent;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.paging.PageEvent<R>");
    }

    @Nullable
    public Object filter(@NotNull Function2<? super T, ? super Continuation<? super Boolean>, ? extends Object> function2, @NotNull Continuation<? super PageEvent<T>> continuation) {
        return a(this, function2, continuation);
    }

    @Nullable
    public <R> Object flatMap(@NotNull Function2<? super T, ? super Continuation<? super Iterable<? extends R>>, ? extends Object> function2, @NotNull Continuation<? super PageEvent<R>> continuation) {
        return b(this, function2, continuation);
    }

    @Nullable
    public <R> Object map(@NotNull Function2<? super T, ? super Continuation<? super R>, ? extends Object> function2, @NotNull Continuation<? super PageEvent<R>> continuation) {
        return c(this, function2, continuation);
    }
}
