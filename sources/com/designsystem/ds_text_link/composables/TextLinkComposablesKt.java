package com.designsystem.ds_text_link.composables;

import androidx.compose.foundation.text.ClickableTextKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import com.designsystem.ds_text_link.Colored;
import com.designsystem.ds_text_link.DSTextLinkText;
import com.designsystem.ds_text_link.Tappable;
import com.designsystem.ds_theme.DSTheme;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u001a#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0001¢\u0006\u0002\u0010\t\u001a$\u0010\n\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00012\u0006\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000fH\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"TextLinkUrlAnnotationTag", "", "BaseParagraphWithTextLinks", "", "modifier", "Landroidx/compose/ui/Modifier;", "texts", "", "Lcom/designsystem/ds_text_link/DSTextLinkText;", "(Landroidx/compose/ui/Modifier;Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "appendStringWithUrlAnnotation", "Landroidx/compose/ui/text/AnnotatedString$Builder;", "text", "annotation", "style", "Landroidx/compose/ui/text/SpanStyle;", "marshmallow_release"}, k = 2, mv = {1, 5, 1}, xi = 48)
public final class TextLinkComposablesKt {
    @NotNull
    private static final String TextLinkUrlAnnotationTag = "TextLinkUrlAnnotationTag";

    /* JADX INFO: finally extract failed */
    @Composable
    public static final void BaseParagraphWithTextLinks(@NotNull Modifier modifier, @NotNull List<? extends DSTextLinkText> list, @Nullable Composer composer, int i11) {
        boolean z11;
        Modifier modifier2 = modifier;
        List<? extends DSTextLinkText> list2 = list;
        int i12 = i11;
        Intrinsics.checkNotNullParameter(modifier2, "modifier");
        Intrinsics.checkNotNullParameter(list2, "texts");
        Composer startRestartGroup = composer.startRestartGroup(1210748272);
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        startRestartGroup.startReplaceableGroup(1210748469);
        AnnotatedString.Builder builder = new AnnotatedString.Builder(0, 1, (DefaultConstructorMarker) null);
        int i13 = 0;
        for (DSTextLinkText dSTextLinkText : list2) {
            if (dSTextLinkText instanceof DSTextLinkText.Normal) {
                startRestartGroup.startReplaceableGroup(-308861308);
                int pushStyle = builder.pushStyle(((DSTextLinkText.Normal) dSTextLinkText).textStyle(startRestartGroup, 0).toSpanStyle());
                try {
                    builder.append(dSTextLinkText.getText());
                    Unit unit = Unit.INSTANCE;
                    builder.pop(pushStyle);
                    startRestartGroup.endReplaceableGroup();
                } catch (Throwable th2) {
                    builder.pop(pushStyle);
                    throw th2;
                }
            } else {
                if (dSTextLinkText instanceof DSTextLinkText.AlternativeLink) {
                    z11 = true;
                } else {
                    z11 = dSTextLinkText instanceof DSTextLinkText.Link;
                }
                if (z11) {
                    startRestartGroup.startReplaceableGroup(-308861069);
                    String valueOf = String.valueOf(i13);
                    appendStringWithUrlAnnotation(builder, dSTextLinkText.getText(), valueOf, SpanStyle.m4994copyIuqyXdg$default(DSTheme.INSTANCE.getTypography(startRestartGroup, 0).getDsLink().toSpanStyle(), ((Colored) dSTextLinkText).m8637colorWaAFU9c(startRestartGroup, 0), 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, 16382, (Object) null));
                    linkedHashMap.put(valueOf, (Tappable) dSTextLinkText);
                    i13++;
                    startRestartGroup.endReplaceableGroup();
                } else {
                    startRestartGroup.startReplaceableGroup(-308860571);
                    startRestartGroup.endReplaceableGroup();
                }
            }
        }
        AnnotatedString annotatedString = builder.toAnnotatedString();
        startRestartGroup.endReplaceableGroup();
        ClickableTextKt.m835ClickableText4YKlhWE(annotatedString, modifier, (TextStyle) null, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, new TextLinkComposablesKt$BaseParagraphWithTextLinks$1(annotatedString, linkedHashMap), startRestartGroup, ((i12 << 3) & 112) | 32768, 124);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new TextLinkComposablesKt$BaseParagraphWithTextLinks$2(modifier2, list2, i12));
        }
    }

    /* JADX INFO: finally extract failed */
    private static final void appendStringWithUrlAnnotation(AnnotatedString.Builder builder, String str, String str2, SpanStyle spanStyle) {
        builder.pushStringAnnotation(TextLinkUrlAnnotationTag, str2);
        int pushStyle = builder.pushStyle(spanStyle);
        try {
            builder.append(str);
            Unit unit = Unit.INSTANCE;
            builder.pop(pushStyle);
            builder.pop();
        } catch (Throwable th2) {
            builder.pop(pushStyle);
            throw th2;
        }
    }
}
