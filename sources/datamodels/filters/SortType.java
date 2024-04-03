package datamodels.filters;

import buisnessmodels.FilterEngine;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000b\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000f¨\u0006\u0010"}, d2 = {"Ldatamodels/filters/SortType;", "", "value", "", "slug", "", "(Ljava/lang/String;IILjava/lang/String;)V", "getSlug", "()Ljava/lang/String;", "getValue", "()I", "RECOMMENDATION", "RATING", "ALPHABETIC", "MIN_ORDER", "FASTEST_DELIVERY", "com_talabat_talabatlib_talabatlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public enum SortType {
    RECOMMENDATION(-100, "recommended"),
    RATING(1, FilterEngine.DEEPLINKSORT.RATING),
    ALPHABETIC(0, "a_z"),
    MIN_ORDER(3, "min_order"),
    FASTEST_DELIVERY(5, "fastest_delivery");
    
    @NotNull
    private final String slug;
    private final int value;

    private SortType(int i11, String str) {
        this.value = i11;
        this.slug = str;
    }

    @NotNull
    public final String getSlug() {
        return this.slug;
    }

    public final int getValue() {
        return this.value;
    }
}
