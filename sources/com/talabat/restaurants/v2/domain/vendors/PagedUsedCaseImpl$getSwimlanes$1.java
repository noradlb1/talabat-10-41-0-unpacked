package com.talabat.restaurants.v2.domain.vendors;

import datamodels.Swimlane;
import io.reactivex.Single;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import library.talabat.com.talabatlib.RestaurantListResponsePaginated;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0010\u0000\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\n¢\u0006\u0002\b\r"}, d2 = {"<anonymous>", "Lio/reactivex/Single;", "", "Ldatamodels/Swimlane;", "<anonymous parameter 0>", "", "<anonymous parameter 1>", "", "<anonymous parameter 2>", "<anonymous parameter 3>", "", "<anonymous parameter 4>", "<anonymous parameter 5>", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class PagedUsedCaseImpl$getSwimlanes$1 extends Lambda implements Function6<Boolean, String, String, Integer, Integer, Integer, Single<List<? extends Swimlane>>> {
    public static final PagedUsedCaseImpl$getSwimlanes$1 INSTANCE = new PagedUsedCaseImpl$getSwimlanes$1();

    public PagedUsedCaseImpl$getSwimlanes$1() {
        super(6);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6) {
        return invoke(((Boolean) obj).booleanValue(), (String) obj2, (String) obj3, ((Number) obj4).intValue(), ((Number) obj5).intValue(), ((Number) obj6).intValue());
    }

    @NotNull
    public final Single<List<Swimlane>> invoke(boolean z11, @NotNull String str, @NotNull String str2, int i11, int i12, int i13) {
        Intrinsics.checkNotNullParameter(str, "<anonymous parameter 1>");
        Intrinsics.checkNotNullParameter(str2, "<anonymous parameter 2>");
        RestaurantListResponsePaginated access$getFirstPageResponseNoFiltrationCache$cp = PagedUsedCaseImpl.firstPageResponseNoFiltrationCache;
        List<Swimlane> swimlanes = access$getFirstPageResponseNoFiltrationCache$cp != null ? access$getFirstPageResponseNoFiltrationCache$cp.getSwimlanes() : null;
        if (swimlanes != null) {
            Single<T> just = Single.just(swimlanes);
            Intrinsics.checkNotNullExpressionValue(just, "{\n                Single…(swimlanes)\n            }");
            return just;
        }
        Single<List<Swimlane>> just2 = Single.just(CollectionsKt__CollectionsKt.emptyList());
        Intrinsics.checkNotNullExpressionValue(just2, "{\n                Single…t(listOf())\n            }");
        return just2;
    }
}
