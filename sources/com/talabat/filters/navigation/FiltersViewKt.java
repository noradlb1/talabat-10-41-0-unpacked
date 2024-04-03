package com.talabat.filters.navigation;

import com.talabat.talabatcommon.views.StartForResultCallbacks;
import datamodels.filters.Selectables;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\u001aJ\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0014\b\u0002\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00062\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\nH\u0002\u001a,\u0010\u0000\u001a\u00020\u0001*\u00020\u000b2\u001d\u0010\u0007\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\nH\u0002\u001a;\u0010\f\u001a\u0004\u0018\u00010\r*\u00020\u000e2\"\u0010\u000f\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\r\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00010\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00120\u0010H@ø\u0001\u0000¢\u0006\u0002\u0010\u0013\u0002\u0004\n\u0002\b\u0019¨\u0006\u0014"}, d2 = {"invoke", "", "Lcom/talabat/filters/navigation/CollectionsFiltersView;", "selectedCollectionId", "", "saveSelectedCollectionId", "Lkotlin/Function1;", "callbacks", "Lcom/talabat/talabatcommon/views/StartForResultCallbacks;", "Ldatamodels/filters/Selectables;", "Lkotlin/ExtensionFunctionType;", "Lcom/talabat/filters/navigation/RestaurantsFiltersView;", "toActivity", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/content/Context;", "block", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Landroid/content/Context;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "com_talabat_Components_filters_filters"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class FiltersViewKt {
    public static final void invoke(@NotNull RestaurantsFiltersView restaurantsFiltersView, @NotNull Function1<? super StartForResultCallbacks<Selectables>, Unit> function1) {
        Intrinsics.checkNotNullParameter(restaurantsFiltersView, "<this>");
        Intrinsics.checkNotNullParameter(function1, "callbacks");
        StartForResultCallbacks startForResultCallbacks = new StartForResultCallbacks();
        function1.invoke(startForResultCallbacks);
        restaurantsFiltersView.setCallbacks$com_talabat_Components_filters_filters(startForResultCallbacks);
    }

    public static /* synthetic */ void invoke$default(CollectionsFiltersView collectionsFiltersView, int i11, Function1 function1, Function1 function12, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            function1 = FiltersViewKt$invoke$1.INSTANCE;
        }
        invoke(collectionsFiltersView, i11, function1, function12);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object toActivity(android.content.Context r4, kotlin.jvm.functions.Function2<? super androidx.appcompat.app.AppCompatActivity, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r5, kotlin.coroutines.Continuation<? super androidx.appcompat.app.AppCompatActivity> r6) {
        /*
            boolean r0 = r6 instanceof com.talabat.filters.navigation.FiltersViewKt$toActivity$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            com.talabat.filters.navigation.FiltersViewKt$toActivity$1 r0 = (com.talabat.filters.navigation.FiltersViewKt$toActivity$1) r0
            int r1 = r0.f59583j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f59583j = r1
            goto L_0x0018
        L_0x0013:
            com.talabat.filters.navigation.FiltersViewKt$toActivity$1 r0 = new com.talabat.filters.navigation.FiltersViewKt$toActivity$1
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f59582i
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f59583j
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            java.lang.Object r4 = r0.f59581h
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4
            kotlin.ResultKt.throwOnFailure(r6)
            goto L_0x004e
        L_0x002d:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0035:
            kotlin.ResultKt.throwOnFailure(r6)
            boolean r6 = r4 instanceof androidx.appcompat.app.AppCompatActivity
            r2 = 0
            if (r6 == 0) goto L_0x003e
            goto L_0x003f
        L_0x003e:
            r4 = r2
        L_0x003f:
            if (r4 == 0) goto L_0x004f
            androidx.appcompat.app.AppCompatActivity r4 = (androidx.appcompat.app.AppCompatActivity) r4
            r0.f59581h = r4
            r0.f59583j = r3
            java.lang.Object r5 = r5.invoke(r4, r0)
            if (r5 != r1) goto L_0x004e
            return r1
        L_0x004e:
            r2 = r4
        L_0x004f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.filters.navigation.FiltersViewKt.toActivity(android.content.Context, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final void invoke(@NotNull CollectionsFiltersView collectionsFiltersView, int i11, @NotNull Function1<? super Integer, Unit> function1, @NotNull Function1<? super StartForResultCallbacks<Selectables>, Unit> function12) {
        Intrinsics.checkNotNullParameter(collectionsFiltersView, "<this>");
        Intrinsics.checkNotNullParameter(function1, "saveSelectedCollectionId");
        Intrinsics.checkNotNullParameter(function12, "callbacks");
        function1.invoke(Integer.valueOf(i11));
        StartForResultCallbacks startForResultCallbacks = new StartForResultCallbacks();
        function12.invoke(startForResultCallbacks);
        collectionsFiltersView.setCallbacks$com_talabat_Components_filters_filters(startForResultCallbacks);
    }
}
