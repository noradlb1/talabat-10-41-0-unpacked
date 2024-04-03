package androidx.core.text;

import android.text.Html;
import android.text.Spanned;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\bH\b\u001a\u0017\u0010\t\u001a\u00020\u0002*\u00020\u00012\b\b\u0002\u0010\n\u001a\u00020\u0004H\b¨\u0006\u000b"}, d2 = {"parseAsHtml", "Landroid/text/Spanned;", "", "flags", "", "imageGetter", "Landroid/text/Html$ImageGetter;", "tagHandler", "Landroid/text/Html$TagHandler;", "toHtml", "option", "core-ktx_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class HtmlKt {
    @NotNull
    public static final Spanned parseAsHtml(@NotNull String str, int i11, @Nullable Html.ImageGetter imageGetter, @Nullable Html.TagHandler tagHandler) {
        Intrinsics.checkNotNullParameter(str, "<this>");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i11, imageGetter, tagHandler);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return fromHtml;
    }

    public static /* synthetic */ Spanned parseAsHtml$default(String str, int i11, Html.ImageGetter imageGetter, Html.TagHandler tagHandler, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        if ((i12 & 2) != 0) {
            imageGetter = null;
        }
        if ((i12 & 4) != 0) {
            tagHandler = null;
        }
        Intrinsics.checkNotNullParameter(str, "<this>");
        Spanned fromHtml = HtmlCompat.fromHtml(str, i11, imageGetter, tagHandler);
        Intrinsics.checkNotNullExpressionValue(fromHtml, "fromHtml(this, flags, imageGetter, tagHandler)");
        return fromHtml;
    }

    @NotNull
    public static final String toHtml(@NotNull Spanned spanned, int i11) {
        Intrinsics.checkNotNullParameter(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i11);
        Intrinsics.checkNotNullExpressionValue(html, "toHtml(this, option)");
        return html;
    }

    public static /* synthetic */ String toHtml$default(Spanned spanned, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        Intrinsics.checkNotNullParameter(spanned, "<this>");
        String html = HtmlCompat.toHtml(spanned, i11);
        Intrinsics.checkNotNullExpressionValue(html, "toHtml(this, option)");
        return html;
    }
}
