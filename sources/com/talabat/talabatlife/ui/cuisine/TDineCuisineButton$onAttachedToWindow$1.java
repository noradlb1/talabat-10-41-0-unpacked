package com.talabat.talabatlife.ui.cuisine;

import android.content.BroadcastReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"com/talabat/talabatlife/ui/cuisine/TDineCuisineButton$onAttachedToWindow$1", "Landroid/content/BroadcastReceiver;", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "com_talabat_NewArchi_TalabatLife_TalabatLife"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TDineCuisineButton$onAttachedToWindow$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TDineCuisineButton f12063a;

    public TDineCuisineButton$onAttachedToWindow$1(TDineCuisineButton tDineCuisineButton) {
        this.f12063a = tDineCuisineButton;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v2, resolved type: com.talabat.talabatlife.domain.entity.Cuisine} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.talabat.talabatlife.domain.entity.Cuisine} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v6, resolved type: com.talabat.talabatlife.domain.entity.Cuisine} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v0, resolved type: com.talabat.talabatlife.domain.entity.Cuisine} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v8, resolved type: com.talabat.talabatlife.domain.entity.Cuisine} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReceive(@org.jetbrains.annotations.NotNull android.content.Context r8, @org.jetbrains.annotations.NotNull android.content.Intent r9) {
        /*
            r7 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.lang.String r8 = "intent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r9, r8)
            com.talabat.talabatlife.ui.cuisine.TDineCuisineButton r8 = r7.f12063a
            java.lang.String r0 = "selectedCuisine"
            android.os.Parcelable r9 = r9.getParcelableExtra(r0)
            com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel r9 = (com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel) r9
            r8.setSelectedCuisine(r9)
            com.talabat.talabatlife.ui.cuisine.TDineCuisineButton r8 = r7.f12063a
            int r9 = com.talabat.talabatlife.R.id.selectedCuisineName
            android.view.View r8 = r8._$_findCachedViewById(r9)
            android.widget.TextView r8 = (android.widget.TextView) r8
            com.talabat.talabatlife.ui.cuisine.TDineCuisineButton r9 = r7.f12063a
            com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel r9 = r9.getSelectedCuisine()
            r0 = 0
            if (r9 == 0) goto L_0x002f
            java.lang.String r9 = r9.getName()
            goto L_0x0030
        L_0x002f:
            r9 = r0
        L_0x0030:
            r8.setText(r9)
            com.talabat.talabatlife.ui.cuisine.TDineCuisineButton r8 = r7.f12063a
            kotlin.jvm.functions.Function1 r8 = r8.getCuisineSelected()
            r9 = 1
            r1 = 0
            if (r8 == 0) goto L_0x0075
            com.talabat.talabatlife.ui.cuisine.TDineCuisineButton r2 = r7.f12063a
            java.util.List r2 = r2.getCuisineList()
            if (r2 == 0) goto L_0x0072
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            com.talabat.talabatlife.ui.cuisine.TDineCuisineButton r3 = r7.f12063a
            java.util.Iterator r2 = r2.iterator()
        L_0x004d:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0070
            java.lang.Object r4 = r2.next()
            r5 = r4
            com.talabat.talabatlife.domain.entity.Cuisine r5 = (com.talabat.talabatlife.domain.entity.Cuisine) r5
            com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel r6 = r3.getSelectedCuisine()
            if (r6 == 0) goto L_0x006c
            int r5 = r5.getId()
            int r6 = r6.getId()
            if (r5 != r6) goto L_0x006c
            r5 = r9
            goto L_0x006d
        L_0x006c:
            r5 = r1
        L_0x006d:
            if (r5 == 0) goto L_0x004d
            r0 = r4
        L_0x0070:
            com.talabat.talabatlife.domain.entity.Cuisine r0 = (com.talabat.talabatlife.domain.entity.Cuisine) r0
        L_0x0072:
            r8.invoke(r0)
        L_0x0075:
            com.talabat.talabatlife.ui.cuisine.TDineCuisineButton r8 = r7.f12063a
            com.talabat.talabatlife.ui.cuisine.CuisineDisplayModel r0 = r8.getSelectedCuisine()
            if (r0 == 0) goto L_0x0084
            int r0 = r0.getId()
            if (r0 != 0) goto L_0x0084
            r1 = r9
        L_0x0084:
            r9 = r9 ^ r1
            r8.setSelected(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.talabat.talabatlife.ui.cuisine.TDineCuisineButton$onAttachedToWindow$1.onReceive(android.content.Context, android.content.Intent):void");
    }
}
