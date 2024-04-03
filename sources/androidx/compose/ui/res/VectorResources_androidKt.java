package androidx.compose.ui.res;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.util.Xml;
import androidx.annotation.DrawableRes;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.compat.AndroidVectorParser;
import androidx.compose.ui.graphics.vector.compat.XmlVectorParser_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.ImageVectorCache;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\u0000\u001a\u00020\u00012\u000e\b\u0002\u0010\u0002\u001a\b\u0018\u00010\u0003R\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0000\u001a*\u0010\n\u001a\u00020\u000b*\u00020\f2\u000e\b\u0002\u0010\u0002\u001a\b\u0018\u00010\u0003R\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\t\u001a\u001b\u0010\n\u001a\u00020\u000b*\u00020\f2\b\b\u0001\u0010\u000e\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010"}, d2 = {"loadVectorResourceInner", "Landroidx/compose/ui/res/ImageVectorCache$ImageVectorEntry;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "res", "parser", "Landroid/content/res/XmlResourceParser;", "changingConfigurations", "", "vectorResource", "Landroidx/compose/ui/graphics/vector/ImageVector;", "Landroidx/compose/ui/graphics/vector/ImageVector$Companion;", "resId", "id", "(Landroidx/compose/ui/graphics/vector/ImageVector$Companion;ILandroidx/compose/runtime/Composer;I)Landroidx/compose/ui/graphics/vector/ImageVector;", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class VectorResources_androidKt {
    @NotNull
    public static final ImageVectorCache.ImageVectorEntry loadVectorResourceInner(@Nullable Resources.Theme theme, @NotNull Resources resources, @NotNull XmlResourceParser xmlResourceParser, int i11) throws XmlPullParserException {
        Intrinsics.checkNotNullParameter(resources, "res");
        Intrinsics.checkNotNullParameter(xmlResourceParser, "parser");
        AttributeSet asAttributeSet = Xml.asAttributeSet(xmlResourceParser);
        AndroidVectorParser androidVectorParser = new AndroidVectorParser(xmlResourceParser, 0, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullExpressionValue(asAttributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        ImageVector.Builder createVectorImageBuilder = XmlVectorParser_androidKt.createVectorImageBuilder(androidVectorParser, resources, theme, asAttributeSet);
        int i12 = 0;
        while (!XmlVectorParser_androidKt.isAtEnd(xmlResourceParser)) {
            i12 = XmlVectorParser_androidKt.parseCurrentVectorNode(androidVectorParser, resources, asAttributeSet, theme, createVectorImageBuilder, i12);
            xmlResourceParser.next();
        }
        return new ImageVectorCache.ImageVectorEntry(createVectorImageBuilder.build(), i11);
    }

    public static /* synthetic */ ImageVectorCache.ImageVectorEntry loadVectorResourceInner$default(Resources.Theme theme, Resources resources, XmlResourceParser xmlResourceParser, int i11, int i12, Object obj) throws XmlPullParserException {
        if ((i12 & 1) != 0) {
            theme = null;
        }
        return loadVectorResourceInner(theme, resources, xmlResourceParser, i11);
    }

    @NotNull
    @Composable
    public static final ImageVector vectorResource(@NotNull ImageVector.Companion companion, @DrawableRes int i11, @Nullable Composer composer, int i12) {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        composer.startReplaceableGroup(44534090);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(44534090, i12, -1, "androidx.compose.ui.res.vectorResource (VectorResources.android.kt:47)");
        }
        Resources resources = Resources_androidKt.resources(composer, 0);
        Resources.Theme theme = ((Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext())).getTheme();
        Object[] objArr = {Integer.valueOf(i11), resources, theme, resources.getConfiguration()};
        composer.startReplaceableGroup(-568225417);
        boolean z11 = false;
        for (int i13 = 0; i13 < 4; i13++) {
            z11 |= composer.changed(objArr[i13]);
        }
        Object rememberedValue = composer.rememberedValue();
        if (z11 || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = vectorResource(companion, theme, resources, i11);
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        ImageVector imageVector = (ImageVector) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return imageVector;
    }

    public static /* synthetic */ ImageVector vectorResource$default(ImageVector.Companion companion, Resources.Theme theme, Resources resources, int i11, int i12, Object obj) throws XmlPullParserException {
        if ((i12 & 1) != 0) {
            theme = null;
        }
        return vectorResource(companion, theme, resources, i11);
    }

    @NotNull
    public static final ImageVector vectorResource(@NotNull ImageVector.Companion companion, @Nullable Resources.Theme theme, @NotNull Resources resources, int i11) throws XmlPullParserException {
        Intrinsics.checkNotNullParameter(companion, "<this>");
        Intrinsics.checkNotNullParameter(resources, "res");
        TypedValue typedValue = new TypedValue();
        resources.getValue(i11, typedValue, true);
        XmlResourceParser xml = resources.getXml(i11);
        Intrinsics.checkNotNullExpressionValue(xml, "");
        XmlVectorParser_androidKt.seekToStartTag(xml);
        Unit unit = Unit.INSTANCE;
        Intrinsics.checkNotNullExpressionValue(xml, "res.getXml(resId).apply { seekToStartTag() }");
        return loadVectorResourceInner(theme, resources, xml, typedValue.changingConfigurations).getImageVector();
    }
}
