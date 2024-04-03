package com.talabat.gem.samples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0007*\u00020\bH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"RANDOM_NUMBER_LIMIT", "", "Collections", "", "", "count", "horizontalLayout", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/appcompat/app/AppCompatActivity;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class SampleGemRestaurantsActivityKt {
    private static final int RANDOM_NUMBER_LIMIT = 10;

    @NotNull
    public static final List<String> Collections(int i11) {
        IntRange intRange = new IntRange(1, i11);
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            int nextInt = ((IntIterator) it).nextInt();
            arrayList.add("Special Offer " + nextInt);
        }
        return CollectionsKt___CollectionsKt.toList(arrayList);
    }

    public static /* synthetic */ List Collections$default(int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = (int) (Math.random() * ((double) 10));
        }
        return Collections(i11);
    }

    /* access modifiers changed from: private */
    public static final LinearLayoutManager horizontalLayout(AppCompatActivity appCompatActivity) {
        return new LinearLayoutManager(appCompatActivity, 0, false);
    }
}
