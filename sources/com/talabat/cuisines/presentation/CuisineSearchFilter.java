package com.talabat.cuisines.presentation;

import android.widget.Filter;
import com.talabat.cuisines.domain.SelectableCuisine;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\b \u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lcom/talabat/cuisines/presentation/CuisineSearchFilter;", "Landroid/widget/Filter;", "cuisines", "", "Lcom/talabat/cuisines/domain/SelectableCuisine;", "(Ljava/util/List;)V", "getCuisines", "()Ljava/util/List;", "performFiltering", "Landroid/widget/Filter$FilterResults;", "charSequence", "", "com_talabat_Components_cuisines_cuisines"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class CuisineSearchFilter extends Filter {
    @NotNull
    private final List<SelectableCuisine> cuisines;

    public CuisineSearchFilter(@NotNull List<SelectableCuisine> list) {
        Intrinsics.checkNotNullParameter(list, "cuisines");
        this.cuisines = list;
    }

    @NotNull
    public final List<SelectableCuisine> getCuisines() {
        return this.cuisines;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x001f A[SYNTHETIC] */
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.widget.Filter.FilterResults performFiltering(@org.jetbrains.annotations.Nullable java.lang.CharSequence r10) {
        /*
            r9 = this;
            java.lang.String r10 = java.lang.String.valueOf(r10)
            int r0 = r10.length()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x000e
            r0 = r1
            goto L_0x000f
        L_0x000e:
            r0 = r2
        L_0x000f:
            if (r0 == 0) goto L_0x0014
            java.util.List<com.talabat.cuisines.domain.SelectableCuisine> r10 = r9.cuisines
            goto L_0x0058
        L_0x0014:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<com.talabat.cuisines.domain.SelectableCuisine> r3 = r9.cuisines
            java.util.Iterator r3 = r3.iterator()
        L_0x001f:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0057
            java.lang.Object r4 = r3.next()
            com.talabat.cuisines.domain.SelectableCuisine r4 = (com.talabat.cuisines.domain.SelectableCuisine) r4
            datamodels.Cuisine r5 = r4.getCuisine()
            java.lang.String r5 = r5.f13849name
            if (r5 == 0) goto L_0x0050
            java.lang.String r5 = r5.toLowerCase()
            java.lang.String r6 = "this as java.lang.String).toLowerCase()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            if (r5 == 0) goto L_0x0050
            java.lang.String r7 = r10.toLowerCase()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r6)
            r6 = 2
            r8 = 0
            boolean r5 = kotlin.text.StringsKt__StringsKt.contains$default((java.lang.CharSequence) r5, (java.lang.CharSequence) r7, (boolean) r2, (int) r6, (java.lang.Object) r8)
            if (r5 != r1) goto L_0x0050
            r5 = r1
            goto L_0x0051
        L_0x0050:
            r5 = r2
        L_0x0051:
            if (r5 == 0) goto L_0x001f
            r0.add(r4)
            goto L_0x001f
        L_0x0057:
            r10 = r0
        L_0x0058:
            android.widget.Filter$FilterResults r0 = new android.widget.Filter$FilterResults
            r0.<init>()
            r0.values = r10
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.cuisines.presentation.CuisineSearchFilter.performFiltering(java.lang.CharSequence):android.widget.Filter$FilterResults");
    }
}
