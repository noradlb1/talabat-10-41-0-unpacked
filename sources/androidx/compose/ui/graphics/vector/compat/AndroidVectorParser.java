package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.StyleableRes;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\t\u0010\u000e\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u001e\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0014J\u001e\u0010\u0019\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0014J\u001e\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J(\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0011J0\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\"\u001a\b\u0018\u00010#R\u00020$2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u0005J8\u0010%\u001a\u00020&2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\"\u001a\b\u0018\u00010#R\u00020$2\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u00052\b\b\u0001\u0010\u001a\u001a\u00020\u0005J(\u0010'\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0014J(\u0010(\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0001\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J\u0018\u0010)\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005J\t\u0010*\u001a\u00020\u0005HÖ\u0001J,\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020$2\f\u0010\"\u001a\b\u0018\u00010#R\u00020$2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u000200J\t\u00101\u001a\u00020\u001eHÖ\u0001J\u0010\u00102\u001a\u0002032\u0006\u00104\u001a\u00020\u0005H\u0002R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u00065"}, d2 = {"Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "", "xmlParser", "Lorg/xmlpull/v1/XmlPullParser;", "config", "", "(Lorg/xmlpull/v1/XmlPullParser;I)V", "getConfig", "()I", "setConfig", "(I)V", "getXmlParser", "()Lorg/xmlpull/v1/XmlPullParser;", "component1", "component2", "copy", "equals", "", "other", "getDimension", "", "typedArray", "Landroid/content/res/TypedArray;", "index", "defValue", "getFloat", "defaultValue", "getInt", "getNamedBoolean", "attrName", "", "resId", "getNamedColorStateList", "Landroid/content/res/ColorStateList;", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "getNamedComplexColor", "Landroidx/core/content/res/ComplexColorCompat;", "getNamedFloat", "getNamedInt", "getString", "hashCode", "obtainAttributes", "res", "set", "Landroid/util/AttributeSet;", "attrs", "", "toString", "updateConfig", "", "resConfig", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidVectorParser {
    private int config;
    @NotNull
    private final XmlPullParser xmlParser;

    public AndroidVectorParser(@NotNull XmlPullParser xmlPullParser, int i11) {
        Intrinsics.checkNotNullParameter(xmlPullParser, "xmlParser");
        this.xmlParser = xmlPullParser;
        this.config = i11;
    }

    public static /* synthetic */ AndroidVectorParser copy$default(AndroidVectorParser androidVectorParser, XmlPullParser xmlPullParser, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            xmlPullParser = androidVectorParser.xmlParser;
        }
        if ((i12 & 2) != 0) {
            i11 = androidVectorParser.config;
        }
        return androidVectorParser.copy(xmlPullParser, i11);
    }

    private final void updateConfig(int i11) {
        this.config = i11 | this.config;
    }

    @NotNull
    public final XmlPullParser component1() {
        return this.xmlParser;
    }

    public final int component2() {
        return this.config;
    }

    @NotNull
    public final AndroidVectorParser copy(@NotNull XmlPullParser xmlPullParser, int i11) {
        Intrinsics.checkNotNullParameter(xmlPullParser, "xmlParser");
        return new AndroidVectorParser(xmlPullParser, i11);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AndroidVectorParser)) {
            return false;
        }
        AndroidVectorParser androidVectorParser = (AndroidVectorParser) obj;
        return Intrinsics.areEqual((Object) this.xmlParser, (Object) androidVectorParser.xmlParser) && this.config == androidVectorParser.config;
    }

    public final int getConfig() {
        return this.config;
    }

    public final float getDimension(@NotNull TypedArray typedArray, int i11, float f11) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        float dimension = typedArray.getDimension(i11, f11);
        updateConfig(typedArray.getChangingConfigurations());
        return dimension;
    }

    public final float getFloat(@NotNull TypedArray typedArray, int i11, float f11) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        float f12 = typedArray.getFloat(i11, f11);
        updateConfig(typedArray.getChangingConfigurations());
        return f12;
    }

    public final int getInt(@NotNull TypedArray typedArray, int i11, int i12) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        int i13 = typedArray.getInt(i11, i12);
        updateConfig(typedArray.getChangingConfigurations());
        return i13;
    }

    public final boolean getNamedBoolean(@NotNull TypedArray typedArray, @NotNull String str, @StyleableRes int i11, boolean z11) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(str, "attrName");
        boolean namedBoolean = TypedArrayUtils.getNamedBoolean(typedArray, this.xmlParser, str, i11, z11);
        updateConfig(typedArray.getChangingConfigurations());
        return namedBoolean;
    }

    @Nullable
    public final ColorStateList getNamedColorStateList(@NotNull TypedArray typedArray, @Nullable Resources.Theme theme, @NotNull String str, @StyleableRes int i11) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(str, "attrName");
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, this.xmlParser, theme, str, i11);
        updateConfig(typedArray.getChangingConfigurations());
        return namedColorStateList;
    }

    @NotNull
    public final ComplexColorCompat getNamedComplexColor(@NotNull TypedArray typedArray, @Nullable Resources.Theme theme, @NotNull String str, @StyleableRes int i11, @ColorInt int i12) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(str, "attrName");
        ComplexColorCompat namedComplexColor = TypedArrayUtils.getNamedComplexColor(typedArray, this.xmlParser, theme, str, i11, i12);
        updateConfig(typedArray.getChangingConfigurations());
        Intrinsics.checkNotNullExpressionValue(namedComplexColor, "result");
        return namedComplexColor;
    }

    public final float getNamedFloat(@NotNull TypedArray typedArray, @NotNull String str, @StyleableRes int i11, float f11) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(str, "attrName");
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, this.xmlParser, str, i11, f11);
        updateConfig(typedArray.getChangingConfigurations());
        return namedFloat;
    }

    public final int getNamedInt(@NotNull TypedArray typedArray, @NotNull String str, @StyleableRes int i11, int i12) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        Intrinsics.checkNotNullParameter(str, "attrName");
        int namedInt = TypedArrayUtils.getNamedInt(typedArray, this.xmlParser, str, i11, i12);
        updateConfig(typedArray.getChangingConfigurations());
        return namedInt;
    }

    @Nullable
    public final String getString(@NotNull TypedArray typedArray, int i11) {
        Intrinsics.checkNotNullParameter(typedArray, "typedArray");
        String string = typedArray.getString(i11);
        updateConfig(typedArray.getChangingConfigurations());
        return string;
    }

    @NotNull
    public final XmlPullParser getXmlParser() {
        return this.xmlParser;
    }

    public int hashCode() {
        return (this.xmlParser.hashCode() * 31) + this.config;
    }

    @NotNull
    public final TypedArray obtainAttributes(@NotNull Resources resources, @Nullable Resources.Theme theme, @NotNull AttributeSet attributeSet, @NotNull int[] iArr) {
        Intrinsics.checkNotNullParameter(resources, "res");
        Intrinsics.checkNotNullParameter(attributeSet, "set");
        Intrinsics.checkNotNullParameter(iArr, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, iArr);
        Intrinsics.checkNotNullExpressionValue(obtainAttributes, "obtainAttributes(\n      …          attrs\n        )");
        updateConfig(obtainAttributes.getChangingConfigurations());
        return obtainAttributes;
    }

    public final void setConfig(int i11) {
        this.config = i11;
    }

    @NotNull
    public String toString() {
        return "AndroidVectorParser(xmlParser=" + this.xmlParser + ", config=" + this.config + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AndroidVectorParser(XmlPullParser xmlPullParser, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this(xmlPullParser, (i12 & 2) != 0 ? 0 : i11);
    }
}
