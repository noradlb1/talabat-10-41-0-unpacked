package androidx.compose.ui.graphics.vector.compat;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.BrushKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.graphics.vector.PathNode;
import androidx.compose.ui.graphics.vector.VectorKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\u001a'\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\rH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011\u001a'\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u000f\u001a\u00020\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0011\u001a\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002\u001a*\u0010\u0019\u001a\u00020\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!H\u0000\u001a\f\u0010\"\u001a\u00020#*\u00020$H\u0000\u001a2\u0010%\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a<\u0010(\u001a\u00020\u0001*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u000e\b\u0002\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010'\u001a\u00020\u001a2\u0006\u0010)\u001a\u00020\u0001H\u0000\u001a2\u0010*\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a2\u0010+\u001a\u00020&*\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0018\u00010\u001fR\u00020\u001d2\u0006\u0010 \u001a\u00020!2\u0006\u0010'\u001a\u00020\u001aH\u0000\u001a\f\u0010,\u001a\u00020$*\u00020$H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XD¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000\"\u000e\u0010\u000b\u001a\u00020\tXT¢\u0006\u0002\n\u0000\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006-"}, d2 = {"FILL_TYPE_WINDING", "", "LINECAP_BUTT", "LINECAP_ROUND", "LINECAP_SQUARE", "LINEJOIN_BEVEL", "LINEJOIN_MITER", "LINEJOIN_ROUND", "SHAPE_CLIP_PATH", "", "SHAPE_GROUP", "SHAPE_PATH", "getStrokeLineCap", "Landroidx/compose/ui/graphics/StrokeCap;", "id", "defValue", "getStrokeLineCap-CSYIeUk", "(II)I", "getStrokeLineJoin", "Landroidx/compose/ui/graphics/StrokeJoin;", "getStrokeLineJoin-kLtJ_vA", "obtainBrushFromComplexColor", "Landroidx/compose/ui/graphics/Brush;", "complexColor", "Landroidx/core/content/res/ComplexColorCompat;", "createVectorImageBuilder", "Landroidx/compose/ui/graphics/vector/ImageVector$Builder;", "Landroidx/compose/ui/graphics/vector/compat/AndroidVectorParser;", "res", "Landroid/content/res/Resources;", "theme", "Landroid/content/res/Resources$Theme;", "attrs", "Landroid/util/AttributeSet;", "isAtEnd", "", "Lorg/xmlpull/v1/XmlPullParser;", "parseClipPath", "", "builder", "parseCurrentVectorNode", "nestedGroups", "parseGroup", "parsePath", "seekToStartTag", "ui_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class XmlVectorParser_androidKt {
    private static final int FILL_TYPE_WINDING = 0;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    @NotNull
    private static final String SHAPE_CLIP_PATH = "clip-path";
    @NotNull
    private static final String SHAPE_GROUP = "group";
    @NotNull
    private static final String SHAPE_PATH = "path";

    @NotNull
    public static final ImageVector.Builder createVectorImageBuilder(@NotNull AndroidVectorParser androidVectorParser, @NotNull Resources resources, @Nullable Resources.Theme theme, @NotNull AttributeSet attributeSet) {
        long j11;
        int i11;
        AndroidVectorParser androidVectorParser2 = androidVectorParser;
        Resources resources2 = resources;
        Resources.Theme theme2 = theme;
        AttributeSet attributeSet2 = attributeSet;
        Intrinsics.checkNotNullParameter(androidVectorParser2, "<this>");
        Intrinsics.checkNotNullParameter(resources2, "res");
        Intrinsics.checkNotNullParameter(attributeSet2, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray obtainAttributes = androidVectorParser2.obtainAttributes(resources2, theme2, attributeSet2, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TYPE_ARRAY());
        boolean namedBoolean = androidVectorParser2.getNamedBoolean(obtainAttributes, "autoMirrored", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_AUTO_MIRRORED(), false);
        float namedFloat = androidVectorParser2.getNamedFloat(obtainAttributes, "viewportWidth", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_WIDTH(), 0.0f);
        float namedFloat2 = androidVectorParser2.getNamedFloat(obtainAttributes, "viewportHeight", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_VIEWPORT_HEIGHT(), 0.0f);
        if (namedFloat <= 0.0f) {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportWidth > 0");
        } else if (namedFloat2 > 0.0f) {
            float dimension = androidVectorParser2.getDimension(obtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_WIDTH(), 0.0f);
            float dimension2 = androidVectorParser2.getDimension(obtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_HEIGHT(), 0.0f);
            if (obtainAttributes.hasValue(androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT())) {
                TypedValue typedValue = new TypedValue();
                obtainAttributes.getValue(androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT(), typedValue);
                if (typedValue.type == 2) {
                    j11 = Color.Companion.m2955getUnspecified0d7_KjU();
                } else {
                    ColorStateList namedColorStateList = androidVectorParser2.getNamedColorStateList(obtainAttributes, theme2, "tint", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT());
                    if (namedColorStateList != null) {
                        j11 = ColorKt.Color(namedColorStateList.getDefaultColor());
                    } else {
                        j11 = Color.Companion.m2955getUnspecified0d7_KjU();
                    }
                }
            } else {
                j11 = Color.Companion.m2955getUnspecified0d7_KjU();
            }
            long j12 = j11;
            int i12 = androidVectorParser2.getInt(obtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_TINT_MODE(), -1);
            if (i12 == -1) {
                i11 = BlendMode.Companion.m2855getSrcIn0nO6VwU();
            } else if (i12 == 3) {
                i11 = BlendMode.Companion.m2857getSrcOver0nO6VwU();
            } else if (i12 == 5) {
                i11 = BlendMode.Companion.m2855getSrcIn0nO6VwU();
            } else if (i12 != 9) {
                switch (i12) {
                    case 14:
                        i11 = BlendMode.Companion.m2846getModulate0nO6VwU();
                        break;
                    case 15:
                        i11 = BlendMode.Companion.m2851getScreen0nO6VwU();
                        break;
                    case 16:
                        i11 = BlendMode.Companion.m2849getPlus0nO6VwU();
                        break;
                    default:
                        i11 = BlendMode.Companion.m2855getSrcIn0nO6VwU();
                        break;
                }
            } else {
                i11 = BlendMode.Companion.m2854getSrcAtop0nO6VwU();
            }
            int i13 = i11;
            float r102 = Dp.m5478constructorimpl(dimension / resources.getDisplayMetrics().density);
            float r11 = Dp.m5478constructorimpl(dimension2 / resources.getDisplayMetrics().density);
            obtainAttributes.recycle();
            return new ImageVector.Builder((String) null, r102, r11, namedFloat, namedFloat2, j12, i13, namedBoolean, 1, (DefaultConstructorMarker) null);
        } else {
            throw new XmlPullParserException(obtainAttributes.getPositionDescription() + "<VectorGraphic> tag requires viewportHeight > 0");
        }
    }

    /* renamed from: getStrokeLineCap-CSYIeUk  reason: not valid java name */
    private static final int m3556getStrokeLineCapCSYIeUk(int i11, int i12) {
        if (i11 == 0) {
            return StrokeCap.Companion.m3253getButtKaPHkGw();
        }
        if (i11 == 1) {
            return StrokeCap.Companion.m3254getRoundKaPHkGw();
        }
        if (i11 != 2) {
            return i12;
        }
        return StrokeCap.Companion.m3255getSquareKaPHkGw();
    }

    /* renamed from: getStrokeLineJoin-kLtJ_vA  reason: not valid java name */
    private static final int m3557getStrokeLineJoinkLtJ_vA(int i11, int i12) {
        if (i11 == 0) {
            return StrokeJoin.Companion.m3264getMiterLxFBmk8();
        }
        if (i11 == 1) {
            return StrokeJoin.Companion.m3265getRoundLxFBmk8();
        }
        if (i11 != 2) {
            return i12;
        }
        return StrokeJoin.Companion.m3263getBevelLxFBmk8();
    }

    public static final boolean isAtEnd(@NotNull XmlPullParser xmlPullParser) {
        Intrinsics.checkNotNullParameter(xmlPullParser, "<this>");
        if (xmlPullParser.getEventType() == 1) {
            return true;
        }
        if (xmlPullParser.getDepth() >= 1 || xmlPullParser.getEventType() != 3) {
            return false;
        }
        return true;
    }

    private static final Brush obtainBrushFromComplexColor(ComplexColorCompat complexColorCompat) {
        if (!complexColorCompat.willDraw()) {
            return null;
        }
        Shader shader = complexColorCompat.getShader();
        if (shader != null) {
            return BrushKt.ShaderBrush(shader);
        }
        return new SolidColor(ColorKt.Color(complexColorCompat.getColor()), (DefaultConstructorMarker) null);
    }

    public static final void parseClipPath(@NotNull AndroidVectorParser androidVectorParser, @NotNull Resources resources, @Nullable Resources.Theme theme, @NotNull AttributeSet attributeSet, @NotNull ImageVector.Builder builder) {
        AndroidVectorParser androidVectorParser2 = androidVectorParser;
        Resources resources2 = resources;
        AttributeSet attributeSet2 = attributeSet;
        Intrinsics.checkNotNullParameter(androidVectorParser2, "<this>");
        Intrinsics.checkNotNullParameter(resources2, "res");
        Intrinsics.checkNotNullParameter(attributeSet2, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        Intrinsics.checkNotNullParameter(builder, "builder");
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray obtainAttributes = androidVectorParser2.obtainAttributes(resources2, theme, attributeSet2, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH());
        String string = androidVectorParser2.getString(obtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_NAME());
        if (string == null) {
            string = "";
        }
        List<PathNode> addPathNodes = VectorKt.addPathNodes(androidVectorParser2.getString(obtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_CLIP_PATH_PATH_DATA()));
        obtainAttributes.recycle();
        ImageVector.Builder.addGroup$default(builder, string, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, addPathNodes, 254, (Object) null);
    }

    public static final int parseCurrentVectorNode(@NotNull AndroidVectorParser androidVectorParser, @NotNull Resources resources, @NotNull AttributeSet attributeSet, @Nullable Resources.Theme theme, @NotNull ImageVector.Builder builder, int i11) {
        Intrinsics.checkNotNullParameter(androidVectorParser, "<this>");
        Intrinsics.checkNotNullParameter(resources, "res");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        Intrinsics.checkNotNullParameter(builder, "builder");
        int eventType = androidVectorParser.getXmlParser().getEventType();
        if (eventType == 2) {
            String name2 = androidVectorParser.getXmlParser().getName();
            if (name2 == null) {
                return i11;
            }
            int hashCode = name2.hashCode();
            if (hashCode != -1649314686) {
                if (hashCode != 3433509) {
                    if (hashCode != 98629247 || !name2.equals("group")) {
                        return i11;
                    }
                    parseGroup(androidVectorParser, resources, theme, attributeSet, builder);
                    return i11;
                } else if (!name2.equals(SHAPE_PATH)) {
                    return i11;
                } else {
                    parsePath(androidVectorParser, resources, theme, attributeSet, builder);
                    return i11;
                }
            } else if (!name2.equals(SHAPE_CLIP_PATH)) {
                return i11;
            } else {
                parseClipPath(androidVectorParser, resources, theme, attributeSet, builder);
                return i11 + 1;
            }
        } else if (eventType != 3 || !Intrinsics.areEqual((Object) "group", (Object) androidVectorParser.getXmlParser().getName())) {
            return i11;
        } else {
            int i12 = i11 + 1;
            for (int i13 = 0; i13 < i12; i13++) {
                builder.clearGroup();
            }
            return 0;
        }
    }

    public static /* synthetic */ int parseCurrentVectorNode$default(AndroidVectorParser androidVectorParser, Resources resources, AttributeSet attributeSet, Resources.Theme theme, ImageVector.Builder builder, int i11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            theme = null;
        }
        return parseCurrentVectorNode(androidVectorParser, resources, attributeSet, theme, builder, i11);
    }

    public static final void parseGroup(@NotNull AndroidVectorParser androidVectorParser, @NotNull Resources resources, @Nullable Resources.Theme theme, @NotNull AttributeSet attributeSet, @NotNull ImageVector.Builder builder) {
        AndroidVectorParser androidVectorParser2 = androidVectorParser;
        Resources resources2 = resources;
        AttributeSet attributeSet2 = attributeSet;
        Intrinsics.checkNotNullParameter(androidVectorParser, "<this>");
        Intrinsics.checkNotNullParameter(resources, "res");
        Intrinsics.checkNotNullParameter(attributeSet2, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        Intrinsics.checkNotNullParameter(builder, "builder");
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray obtainAttributes = androidVectorParser.obtainAttributes(resources, theme, attributeSet2, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP());
        float namedFloat = androidVectorParser.getNamedFloat(obtainAttributes, "rotation", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_ROTATION(), 0.0f);
        float f11 = androidVectorParser.getFloat(obtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_X(), 0.0f);
        float f12 = androidVectorParser.getFloat(obtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_PIVOT_Y(), 0.0f);
        float namedFloat2 = androidVectorParser.getNamedFloat(obtainAttributes, "scaleX", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_X(), 1.0f);
        float namedFloat3 = androidVectorParser.getNamedFloat(obtainAttributes, "scaleY", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_SCALE_Y(), 1.0f);
        float namedFloat4 = androidVectorParser.getNamedFloat(obtainAttributes, "translateX", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_X(), 0.0f);
        float namedFloat5 = androidVectorParser.getNamedFloat(obtainAttributes, "translateY", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_TRANSLATE_Y(), 0.0f);
        String string = androidVectorParser.getString(obtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_GROUP_NAME());
        if (string == null) {
            string = "";
        }
        obtainAttributes.recycle();
        builder.addGroup(string, namedFloat, f11, f12, namedFloat2, namedFloat3, namedFloat4, namedFloat5, VectorKt.getEmptyPath());
    }

    public static final void parsePath(@NotNull AndroidVectorParser androidVectorParser, @NotNull Resources resources, @Nullable Resources.Theme theme, @NotNull AttributeSet attributeSet, @NotNull ImageVector.Builder builder) throws IllegalArgumentException {
        int i11;
        AndroidVectorParser androidVectorParser2 = androidVectorParser;
        Resources resources2 = resources;
        AttributeSet attributeSet2 = attributeSet;
        Intrinsics.checkNotNullParameter(androidVectorParser2, "<this>");
        Intrinsics.checkNotNullParameter(resources2, "res");
        Intrinsics.checkNotNullParameter(attributeSet2, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        Intrinsics.checkNotNullParameter(builder, "builder");
        AndroidVectorResources androidVectorResources = AndroidVectorResources.INSTANCE;
        TypedArray obtainAttributes = androidVectorParser2.obtainAttributes(resources2, theme, attributeSet2, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH());
        if (TypedArrayUtils.hasAttribute(androidVectorParser.getXmlParser(), "pathData")) {
            String string = androidVectorParser2.getString(obtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_NAME());
            if (string == null) {
                string = "";
            }
            String str = string;
            List<PathNode> addPathNodes = VectorKt.addPathNodes(androidVectorParser2.getString(obtainAttributes, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_PATH_DATA()));
            ComplexColorCompat namedComplexColor = androidVectorParser.getNamedComplexColor(obtainAttributes, theme, Param.FILL_COLOR, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_COLOR(), 0);
            float namedFloat = androidVectorParser2.getNamedFloat(obtainAttributes, "fillAlpha", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_FILL_ALPHA(), 1.0f);
            int r16 = m3556getStrokeLineCapCSYIeUk(androidVectorParser2.getNamedInt(obtainAttributes, "strokeLineCap", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_CAP(), -1), StrokeCap.Companion.m3253getButtKaPHkGw());
            int r17 = m3557getStrokeLineJoinkLtJ_vA(androidVectorParser2.getNamedInt(obtainAttributes, "strokeLineJoin", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_LINE_JOIN(), -1), StrokeJoin.Companion.m3263getBevelLxFBmk8());
            float namedFloat2 = androidVectorParser2.getNamedFloat(obtainAttributes, "strokeMiterLimit", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_MITER_LIMIT(), 1.0f);
            ComplexColorCompat namedComplexColor2 = androidVectorParser.getNamedComplexColor(obtainAttributes, theme, Param.STROKE_COLOR, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_COLOR(), 0);
            float namedFloat3 = androidVectorParser2.getNamedFloat(obtainAttributes, "strokeAlpha", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_ALPHA(), 1.0f);
            float namedFloat4 = androidVectorParser2.getNamedFloat(obtainAttributes, Param.STROKE_WIDTH, androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_STROKE_WIDTH(), 1.0f);
            float namedFloat5 = androidVectorParser2.getNamedFloat(obtainAttributes, "trimPathEnd", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_END(), 1.0f);
            float namedFloat6 = androidVectorParser2.getNamedFloat(obtainAttributes, "trimPathOffset", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_OFFSET(), 0.0f);
            float namedFloat7 = androidVectorParser2.getNamedFloat(obtainAttributes, "trimPathStart", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_START(), 0.0f);
            int namedInt = androidVectorParser2.getNamedInt(obtainAttributes, "fillType", androidVectorResources.getSTYLEABLE_VECTOR_DRAWABLE_PATH_TRIM_PATH_FILLTYPE(), FILL_TYPE_WINDING);
            obtainAttributes.recycle();
            Brush obtainBrushFromComplexColor = obtainBrushFromComplexColor(namedComplexColor);
            Brush obtainBrushFromComplexColor2 = obtainBrushFromComplexColor(namedComplexColor2);
            PathFillType.Companion companion = PathFillType.Companion;
            if (namedInt == 0) {
                i11 = companion.m3166getNonZeroRgk1Os();
            } else {
                i11 = companion.m3165getEvenOddRgk1Os();
            }
            builder.m3523addPathoIyEayM(addPathNodes, i11, str, obtainBrushFromComplexColor, namedFloat, obtainBrushFromComplexColor2, namedFloat3, namedFloat4, r16, r17, namedFloat2, namedFloat7, namedFloat5, namedFloat6);
            return;
        }
        throw new IllegalArgumentException("No path data available");
    }

    @NotNull
    public static final XmlPullParser seekToStartTag(@NotNull XmlPullParser xmlPullParser) throws XmlPullParserException {
        Intrinsics.checkNotNullParameter(xmlPullParser, "<this>");
        int next = xmlPullParser.next();
        while (next != 2 && next != 1) {
            next = xmlPullParser.next();
        }
        if (next == 2) {
            return xmlPullParser;
        }
        throw new XmlPullParserException("No start tag found");
    }
}
