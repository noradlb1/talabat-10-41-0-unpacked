package androidx.compose.ui.res;

import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0002\u001a1\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\u000bR\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\r\u001a\u0017\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\u0010\u0010\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"errorMessage", "", "loadImageBitmapResource", "Landroidx/compose/ui/graphics/ImageBitmap;", "res", "Landroid/content/res/Resources;", "id", "", "loadVectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "theme", "Landroid/content/res/Resources$Theme;", "changingConfigurations", "(Landroid/content/res/Resources$Theme;Landroid/content/res/Resources;IILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "painterResource", "Landroidx/compose/ui/graphics/painter/Painter;", "(ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/painter/Painter;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class PainterResources_androidKt {
    @NotNull
    private static final String errorMessage = "Only VectorDrawables and rasterized asset types are supported ex. PNG, JPG";

    /* access modifiers changed from: private */
    public static final ImageBitmap loadImageBitmapResource(Resources resources, int i11) {
        try {
            return ImageResources_androidKt.imageResource(ImageBitmap.Companion, resources, i11);
        } catch (Throwable unused) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

    @Composable
    private static final ImageVector loadVectorResource(Resources.Theme theme, Resources resources, int i11, int i12, Composer composer, int i13) {
        composer.startReplaceableGroup(21855625);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(21855625, i13, -1, "androidx.compose.ui.res.loadVectorResource (PainterResources.android.kt:81)");
        }
        ImageVectorCache imageVectorCache = (ImageVectorCache) composer.consume(AndroidCompositionLocals_androidKt.getLocalImageVectorCache());
        ImageVectorCache.Key key = new ImageVectorCache.Key(theme, i11);
        ImageVectorCache.ImageVectorEntry imageVectorEntry = imageVectorCache.get(key);
        if (imageVectorEntry == null) {
            XmlResourceParser xml = resources.getXml(i11);
            Intrinsics.checkNotNullExpressionValue(xml, "res.getXml(id)");
            if (Intrinsics.areEqual((Object) XmlVectorParser_androidKt.seekToStartTag(xml).getName(), (Object) "vector")) {
                imageVectorEntry = VectorResources_androidKt.loadVectorResourceInner(theme, resources, xml, i12);
                imageVectorCache.set(key, imageVectorEntry);
            } else {
                throw new IllegalArgumentException(errorMessage);
            }
        }
        ImageVector imageVector = imageVectorEntry.getImageVector();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imageVector;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: androidx.compose.ui.graphics.ImageBitmap} */
    /* JADX WARNING: type inference failed for: r10v4, types: [androidx.compose.ui.graphics.vector.VectorPainter] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @org.jetbrains.annotations.NotNull
    @androidx.compose.runtime.Composable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final androidx.compose.ui.graphics.painter.Painter painterResource(@androidx.annotation.DrawableRes int r10, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r11, int r12) {
        /*
            r0 = 473971343(0x1c403a8f, float:6.3603156E-22)
            r11.startReplaceableGroup(r0)
            boolean r1 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r1 == 0) goto L_0x0012
            r1 = -1
            java.lang.String r2 = "androidx.compose.ui.res.painterResource (PainterResources.android.kt:56)"
            androidx.compose.runtime.ComposerKt.traceEventStart(r0, r12, r1, r2)
        L_0x0012:
            androidx.compose.runtime.ProvidableCompositionLocal r0 = androidx.compose.ui.platform.AndroidCompositionLocals_androidKt.getLocalContext()
            java.lang.Object r0 = r11.consume(r0)
            android.content.Context r0 = (android.content.Context) r0
            r1 = 0
            android.content.res.Resources r3 = androidx.compose.ui.res.Resources_androidKt.resources(r11, r1)
            r2 = -492369756(0xffffffffe2a708a4, float:-1.5406144E21)
            r11.startReplaceableGroup(r2)
            java.lang.Object r2 = r11.rememberedValue()
            androidx.compose.runtime.Composer$Companion r4 = androidx.compose.runtime.Composer.Companion
            java.lang.Object r5 = r4.getEmpty()
            if (r2 != r5) goto L_0x003b
            android.util.TypedValue r2 = new android.util.TypedValue
            r2.<init>()
            r11.updateRememberedValue(r2)
        L_0x003b:
            r11.endReplaceableGroup()
            android.util.TypedValue r2 = (android.util.TypedValue) r2
            r5 = 1
            r3.getValue(r10, r2, r5)
            java.lang.CharSequence r6 = r2.string
            if (r6 == 0) goto L_0x0053
            r7 = 2
            r8 = 0
            java.lang.String r9 = ".xml"
            boolean r7 = kotlin.text.StringsKt__StringsKt.endsWith$default((java.lang.CharSequence) r6, (java.lang.CharSequence) r9, (boolean) r1, (int) r7, (java.lang.Object) r8)
            if (r7 != r5) goto L_0x0053
            goto L_0x0054
        L_0x0053:
            r5 = r1
        L_0x0054:
            if (r5 == 0) goto L_0x007c
            r4 = -738265327(0xffffffffd3fef711, float:-2.19013356E12)
            r11.startReplaceableGroup(r4)
            android.content.res.Resources$Theme r0 = r0.getTheme()
            java.lang.String r4 = "context.theme"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r4)
            int r5 = r2.changingConfigurations
            int r12 = r12 << 6
            r12 = r12 & 896(0x380, float:1.256E-42)
            r7 = r12 | 72
            r2 = r0
            r4 = r10
            r6 = r11
            androidx.compose.ui.graphics.vector.ImageVector r10 = loadVectorResource(r2, r3, r4, r5, r6, r7)
            androidx.compose.ui.graphics.vector.VectorPainter r10 = androidx.compose.ui.graphics.vector.VectorPainterKt.rememberVectorPainter(r10, r11, r1)
            r11.endReplaceableGroup()
            goto L_0x00c6
        L_0x007c:
            r12 = -738265172(0xffffffffd3fef7ac, float:-2.19015388E12)
            r11.startReplaceableGroup(r12)
            java.lang.Integer r12 = java.lang.Integer.valueOf(r10)
            android.content.res.Resources$Theme r0 = r0.getTheme()
            r1 = 1618982084(0x607fb4c4, float:7.370227E19)
            r11.startReplaceableGroup(r1)
            boolean r1 = r11.changed((java.lang.Object) r6)
            boolean r12 = r11.changed((java.lang.Object) r12)
            r12 = r12 | r1
            boolean r0 = r11.changed((java.lang.Object) r0)
            r12 = r12 | r0
            java.lang.Object r0 = r11.rememberedValue()
            if (r12 != 0) goto L_0x00aa
            java.lang.Object r12 = r4.getEmpty()
            if (r0 != r12) goto L_0x00b1
        L_0x00aa:
            androidx.compose.ui.graphics.ImageBitmap r0 = loadImageBitmapResource(r3, r10)
            r11.updateRememberedValue(r0)
        L_0x00b1:
            r11.endReplaceableGroup()
            r2 = r0
            androidx.compose.ui.graphics.ImageBitmap r2 = (androidx.compose.ui.graphics.ImageBitmap) r2
            androidx.compose.ui.graphics.painter.BitmapPainter r10 = new androidx.compose.ui.graphics.painter.BitmapPainter
            r3 = 0
            r5 = 0
            r7 = 6
            r8 = 0
            r1 = r10
            r1.<init>(r2, r3, r5, r7, r8)
            r11.endReplaceableGroup()
        L_0x00c6:
            boolean r12 = androidx.compose.runtime.ComposerKt.isTraceInProgress()
            if (r12 == 0) goto L_0x00cf
            androidx.compose.runtime.ComposerKt.traceEventEnd()
        L_0x00cf:
            r11.endReplaceableGroup()
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.res.PainterResources_androidKt.painterResource(int, androidx.compose.runtime.Composer, int):androidx.compose.ui.graphics.painter.Painter");
    }
}
