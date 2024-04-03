package androidx.core.content.res;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
final class GradientColorInflaterCompat {
    private static final int TILE_MODE_CLAMP = 0;
    private static final int TILE_MODE_MIRROR = 2;
    private static final int TILE_MODE_REPEAT = 1;

    private GradientColorInflaterCompat() {
    }

    public static Shader a(@NonNull Resources resources, @NonNull XmlPullParser xmlPullParser, @NonNull AttributeSet attributeSet, @Nullable Resources.Theme theme) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name2 = xmlPullParser.getName();
        if (name2.equals(Param.GRADIENT)) {
            Resources.Theme theme2 = theme;
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme2, attributeSet, R.styleable.GradientColor);
            float namedFloat = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser2, "startX", R.styleable.GradientColor_android_startX, 0.0f);
            float namedFloat2 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser2, "startY", R.styleable.GradientColor_android_startY, 0.0f);
            float namedFloat3 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser2, "endX", R.styleable.GradientColor_android_endX, 0.0f);
            float namedFloat4 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser2, "endY", R.styleable.GradientColor_android_endY, 0.0f);
            float namedFloat5 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser2, "centerX", R.styleable.GradientColor_android_centerX, 0.0f);
            float namedFloat6 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser2, "centerY", R.styleable.GradientColor_android_centerY, 0.0f);
            int namedInt = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser2, "type", R.styleable.GradientColor_android_type, 0);
            int namedColor = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser2, "startColor", R.styleable.GradientColor_android_startColor, 0);
            boolean hasAttribute = TypedArrayUtils.hasAttribute(xmlPullParser2, "centerColor");
            int namedColor2 = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser2, "centerColor", R.styleable.GradientColor_android_centerColor, 0);
            int namedColor3 = TypedArrayUtils.getNamedColor(obtainAttributes, xmlPullParser2, "endColor", R.styleable.GradientColor_android_endColor, 0);
            int namedInt2 = TypedArrayUtils.getNamedInt(obtainAttributes, xmlPullParser2, "tileMode", R.styleable.GradientColor_android_tileMode, 0);
            float f11 = namedFloat5;
            float namedFloat7 = TypedArrayUtils.getNamedFloat(obtainAttributes, xmlPullParser2, "gradientRadius", R.styleable.GradientColor_android_gradientRadius, 0.0f);
            obtainAttributes.recycle();
            ColorStops checkColors = checkColors(inflateChildElements(resources, xmlPullParser, attributeSet, theme), namedColor, namedColor3, hasAttribute, namedColor2);
            if (namedInt == 1) {
                float f12 = f11;
                if (namedFloat7 > 0.0f) {
                    int[] iArr = checkColors.f11271a;
                    return new RadialGradient(f12, namedFloat6, namedFloat7, iArr, checkColors.f11272b, parseTileMode(namedInt2));
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            } else if (namedInt != 2) {
                return new LinearGradient(namedFloat, namedFloat2, namedFloat3, namedFloat4, checkColors.f11271a, checkColors.f11272b, parseTileMode(namedInt2));
            } else {
                return new SweepGradient(f11, namedFloat6, checkColors.f11271a, checkColors.f11272b);
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name2);
        }
    }

    private static ColorStops checkColors(@Nullable ColorStops colorStops, @ColorInt int i11, @ColorInt int i12, boolean z11, @ColorInt int i13) {
        if (colorStops != null) {
            return colorStops;
        }
        if (z11) {
            return new ColorStops(i11, i13, i12);
        }
        return new ColorStops(i11, i12);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.res.GradientColorInflaterCompat.ColorStops inflateChildElements(@androidx.annotation.NonNull android.content.res.Resources r9, @androidx.annotation.NonNull org.xmlpull.v1.XmlPullParser r10, @androidx.annotation.NonNull android.util.AttributeSet r11, @androidx.annotation.Nullable android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L_0x0012:
            int r3 = r10.next()
            if (r3 == r1) goto L_0x0081
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L_0x0021
            r6 = 3
            if (r3 == r6) goto L_0x0081
        L_0x0021:
            r6 = 2
            if (r3 == r6) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            if (r5 > r0) goto L_0x0012
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0012
        L_0x0034:
            int[] r3 = androidx.core.R.styleable.GradientColorItem
            android.content.res.TypedArray r3 = androidx.core.content.res.TypedArrayUtils.obtainAttributes(r9, r12, r11, r3)
            int r5 = androidx.core.R.styleable.GradientColorItem_android_color
            boolean r6 = r3.hasValue(r5)
            int r7 = androidx.core.R.styleable.GradientColorItem_android_offset
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L_0x0066
            if (r8 == 0) goto L_0x0066
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L_0x0012
        L_0x0066:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L_0x0081:
            int r9 = r4.size()
            if (r9 <= 0) goto L_0x008d
            androidx.core.content.res.GradientColorInflaterCompat$ColorStops r9 = new androidx.core.content.res.GradientColorInflaterCompat$ColorStops
            r9.<init>((java.util.List<java.lang.Integer>) r4, (java.util.List<java.lang.Float>) r2)
            return r9
        L_0x008d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.res.GradientColorInflaterCompat.inflateChildElements(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):androidx.core.content.res.GradientColorInflaterCompat$ColorStops");
    }

    private static Shader.TileMode parseTileMode(int i11) {
        if (i11 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i11 != 2) {
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.MIRROR;
    }

    public static final class ColorStops {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f11271a;

        /* renamed from: b  reason: collision with root package name */
        public final float[] f11272b;

        public ColorStops(@NonNull List<Integer> list, @NonNull List<Float> list2) {
            int size = list.size();
            this.f11271a = new int[size];
            this.f11272b = new float[size];
            for (int i11 = 0; i11 < size; i11++) {
                this.f11271a[i11] = list.get(i11).intValue();
                this.f11272b[i11] = list2.get(i11).floatValue();
            }
        }

        public ColorStops(@ColorInt int i11, @ColorInt int i12) {
            this.f11271a = new int[]{i11, i12};
            this.f11272b = new float[]{0.0f, 1.0f};
        }

        public ColorStops(@ColorInt int i11, @ColorInt int i12, @ColorInt int i13) {
            this.f11271a = new int[]{i11, i12, i13};
            this.f11272b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
