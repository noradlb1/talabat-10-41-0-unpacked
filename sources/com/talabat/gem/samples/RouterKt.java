package com.talabat.gem.samples;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0001\u001a%\u0010\u000b\u001a\u00020\f*\u00020\u00042\u0017\u0010\r\u001a\u0013\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\f0\u000e¢\u0006\u0002\b\u0010H\u0001\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"KEY_DATA", "", "navigate", "Landroid/content/Intent;", "Landroidx/appcompat/app/AppCompatActivity;", "screen", "Lkotlin/reflect/KClass;", "restaurantId", "", "subTotal", "", "withNavigationData", "", "block", "Lkotlin/Function1;", "Lcom/talabat/gem/samples/NavigationData;", "Lkotlin/ExtensionFunctionType;", "com_talabat_Components_gem_gem"}, k = 2, mv = {1, 6, 0}, xi = 48)
public final class RouterKt {
    @NotNull
    private static final String KEY_DATA = "KEY_DATA";

    @NavigationDsl
    @NotNull
    public static final Intent navigate(@NotNull AppCompatActivity appCompatActivity, @NotNull KClass<?> kClass, int i11, double d11) {
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "screen");
        Intent putExtra = new Intent(appCompatActivity, JvmClassMappingKt.getJavaClass(kClass)).putExtra(KEY_DATA, new NavigationData(i11, d11));
        appCompatActivity.startActivity(putExtra);
        Intrinsics.checkNotNullExpressionValue(putExtra, "Intent(this, screen.java…lso { startActivity(it) }");
        return putExtra;
    }

    public static /* synthetic */ Intent navigate$default(AppCompatActivity appCompatActivity, KClass kClass, int i11, double d11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            d11 = 0.0d;
        }
        return navigate(appCompatActivity, kClass, i11, d11);
    }

    @NavigationDsl
    public static final void withNavigationData(@NotNull AppCompatActivity appCompatActivity, @NotNull Function1<? super NavigationData, Unit> function1) {
        NavigationData navigationData;
        Intrinsics.checkNotNullParameter(appCompatActivity, "<this>");
        Intrinsics.checkNotNullParameter(function1, "block");
        Serializable serializableExtra = appCompatActivity.getIntent().getSerializableExtra(KEY_DATA);
        if (serializableExtra instanceof NavigationData) {
            navigationData = (NavigationData) serializableExtra;
        } else {
            navigationData = null;
        }
        if (navigationData != null) {
            function1.invoke(navigationData);
        }
    }
}
