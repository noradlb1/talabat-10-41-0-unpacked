package androidx.compose.ui.text.platform.extensions;

import android.text.style.LocaleSpan;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.AndroidTextPaint;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(24)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0007J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/text/platform/extensions/LocaleListHelperMethods;", "", "()V", "localeSpan", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setTextLocales", "", "textPaint", "Landroidx/compose/ui/text/platform/AndroidTextPaint;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LocaleListHelperMethods {
    @NotNull
    public static final LocaleListHelperMethods INSTANCE = new LocaleListHelperMethods();

    private LocaleListHelperMethods() {
    }

    @RequiresApi(24)
    @NotNull
    @DoNotInline
    public final Object localeSpan(@NotNull LocaleList localeList) {
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList, 10));
        Iterator it = localeList.iterator();
        while (it.hasNext()) {
            arrayList.add(LocaleExtensions_androidKt.toJavaLocale((Locale) it.next()));
        }
        Object[] array = arrayList.toArray(new java.util.Locale[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        java.util.Locale[] localeArr = (java.util.Locale[]) array;
        return new LocaleSpan(new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }

    @RequiresApi(24)
    @DoNotInline
    public final void setTextLocales(@NotNull AndroidTextPaint androidTextPaint, @NotNull LocaleList localeList) {
        Intrinsics.checkNotNullParameter(androidTextPaint, "textPaint");
        Intrinsics.checkNotNullParameter(localeList, "localeList");
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(localeList, 10));
        Iterator it = localeList.iterator();
        while (it.hasNext()) {
            arrayList.add(LocaleExtensions_androidKt.toJavaLocale((Locale) it.next()));
        }
        Object[] array = arrayList.toArray(new java.util.Locale[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        java.util.Locale[] localeArr = (java.util.Locale[]) array;
        androidTextPaint.setTextLocales(new android.os.LocaleList((java.util.Locale[]) Arrays.copyOf(localeArr, localeArr.length)));
    }
}
