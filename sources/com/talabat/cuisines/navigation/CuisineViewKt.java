package com.talabat.cuisines.navigation;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\u001a\"\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0012\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00050\u0004H\u0002¨\u0006\u0006"}, d2 = {"toActivity", "Landroidx/appcompat/app/AppCompatActivity;", "Landroid/content/Context;", "block", "Lkotlin/Function1;", "", "com_talabat_Components_cuisines_cuisines"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class CuisineViewKt {
    /* access modifiers changed from: private */
    public static final AppCompatActivity toActivity(Context context, Function1<? super AppCompatActivity, Unit> function1) {
        if (!(context instanceof AppCompatActivity)) {
            context = null;
        }
        if (context == null) {
            return null;
        }
        AppCompatActivity appCompatActivity = (AppCompatActivity) context;
        function1.invoke(appCompatActivity);
        return appCompatActivity;
    }
}
