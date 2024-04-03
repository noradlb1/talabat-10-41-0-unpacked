package androidx.compose.ui.text;

import androidx.compose.ui.text.intl.LocaleList;
import kotlin.Metadata;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "str", "start", "", "end", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class AnnotatedStringKt$toUpperCase$1 extends Lambda implements Function3<String, Integer, Integer, String> {

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ LocaleList f10129g;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AnnotatedStringKt$toUpperCase$1(LocaleList localeList) {
        super(3);
        this.f10129g = localeList;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return invoke((String) obj, ((Number) obj2).intValue(), ((Number) obj3).intValue());
    }

    @NotNull
    public final String invoke(@NotNull String str, int i11, int i12) {
        Intrinsics.checkNotNullParameter(str, "str");
        String substring = str.substring(i11, i12);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return StringKt.toUpperCase(substring, this.f10129g);
    }
}
