package androidx.compose.ui.text.intl;

import android.os.LocaleList;
import androidx.annotation.RequiresApi;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@RequiresApi(api = 24)
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH\u0016R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/text/intl/AndroidLocaleDelegateAPI24;", "Landroidx/compose/ui/text/intl/PlatformLocaleDelegate;", "()V", "current", "", "Landroidx/compose/ui/text/intl/PlatformLocale;", "getCurrent", "()Ljava/util/List;", "parseLanguageTag", "languageTag", "", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidLocaleDelegateAPI24 implements PlatformLocaleDelegate {
    @NotNull
    public List<PlatformLocale> getCurrent() {
        LocaleList a11 = LocaleList.getDefault();
        Intrinsics.checkNotNullExpressionValue(a11, "getDefault()");
        ArrayList arrayList = new ArrayList();
        int a12 = a11.size();
        for (int i11 = 0; i11 < a12; i11++) {
            Locale a13 = a11.get(i11);
            Intrinsics.checkNotNullExpressionValue(a13, "localeList[i]");
            arrayList.add(new AndroidLocale(a13));
        }
        return arrayList;
    }

    @NotNull
    public PlatformLocale parseLanguageTag(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "languageTag");
        Locale forLanguageTag = Locale.forLanguageTag(str);
        Intrinsics.checkNotNullExpressionValue(forLanguageTag, "forLanguageTag(languageTag)");
        return new AndroidLocale(forLanguageTag);
    }
}
