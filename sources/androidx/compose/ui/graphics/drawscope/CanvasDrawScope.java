package androidx.compose.ui.graphics.drawscope;

import android.graphics.Shader;
import androidx.compose.ui.geometry.CornerRadius;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.BlendMode;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.FilterQuality;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import com.huawei.hms.flutter.map.constants.Param;
import com.instabug.library.model.State;
import f0.b;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import u0.a;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u00002\u00020\u0001:\u0002\u0001B\u0005¢\u0006\u0002\u0010\u0002JK\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b%\u0010&JI\u0010\u0019\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b)\u0010*Jm\u0010+\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105Jk\u0010+\u001a\u00020\u00112\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u0002012\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b6\u00107JR\u00108\u001a\u0002092\u0006\u0010\u0003\u001a\u00020:2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u00020>2\u0017\u0010?\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002090@¢\u0006\u0002\bAH\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bB\u0010CJg\u0010D\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bK\u0010LJg\u0010D\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010E\u001a\u00020\u00042\u0006\u0010F\u001a\u00020\u00042\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bM\u0010NJO\u0010O\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bR\u0010SJO\u0010O\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010P\u001a\u00020\u00042\u0006\u0010Q\u001a\u00020J2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bT\u0010UJG\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010I\u001a\u00020J2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bY\u0010ZJ_\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0017ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\ba\u0010bJg\u0010V\u001a\u0002092\u0006\u0010W\u001a\u00020X2\u0006\u0010[\u001a\u00020\\2\u0006\u0010]\u001a\u00020^2\u0006\u0010_\u001a\u00020\\2\u0006\u0010`\u001a\u00020^2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bc\u0010dJa\u0010e\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bh\u0010iJa\u0010e\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010f\u001a\u00020J2\u0006\u0010g\u001a\u00020J2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bj\u0010kJO\u0010l\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bm\u0010nJO\u0010l\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bo\u0010pJG\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bt\u0010uJG\u0010q\u001a\u0002092\u0006\u0010r\u001a\u00020s2\u0006\u0010'\u001a\u00020(2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bv\u0010wJg\u0010x\u001a\u0002092\f\u0010y\u001a\b\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b}\u0010~Jh\u0010x\u001a\u0002092\f\u0010y\u001a\b\u0012\u0004\u0012\u00020J0z2\u0006\u0010{\u001a\u00020|2\u0006\u0010'\u001a\u00020(2\u0006\u0010,\u001a\u00020\u00042\u0006\u0010.\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u0001032\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0010\u0001JQ\u0010\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0001\u0010nJQ\u0010\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0001\u0010pJ\\\u0010\u0001\u001a\u0002092\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\\\u0010\u0001\u001a\u0002092\u0006\u0010'\u001a\u00020(2\u0006\u0010I\u001a\u00020J2\u0006\u0010=\u001a\u00020>2\b\u0010\u0001\u001a\u00030\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010!\u001a\u00020\"H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0011H\u0002J\t\u0010\u0001\u001a\u00020\u0011H\u0002J\u0012\u0010\u0001\u001a\u00020\u00112\u0007\u0010\u0001\u001a\u00020\u001dH\u0002J$\u0010\u0001\u001a\u00020(*\u00020(2\u0006\u0010\u001e\u001a\u00020\u0004H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001R\u0014\u0010\u0003\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001c\u0010\u000b\u001a\u00020\f8\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\u00020\u00048VX\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0006R\u0014\u0010\u0014\u001a\u00020\u00158VX\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000\u0002\u0012\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "()V", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawParams", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "getDrawParams$annotations", "getDrawParams", "()Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "fillPaint", "Landroidx/compose/ui/graphics/Paint;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "strokePaint", "configurePaint", "brush", "Landroidx/compose/ui/graphics/Brush;", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "alpha", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "configurePaint-swdJneE", "(Landroidx/compose/ui/graphics/Brush;Landroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "color", "Landroidx/compose/ui/graphics/Color;", "configurePaint-2qPWKa0", "(JLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint", "strokeWidth", "miter", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "join", "Landroidx/compose/ui/graphics/StrokeJoin;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "configureStrokePaint-ho4zsrM", "(Landroidx/compose/ui/graphics/Brush;FFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "configureStrokePaint-Q_0CZUI", "(JFFIILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;II)Landroidx/compose/ui/graphics/Paint;", "draw", "", "Landroidx/compose/ui/unit/Density;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "draw-yzxVdVo", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/functions/Function1;)V", "drawArc", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "Landroidx/compose/ui/geometry/Offset;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "center", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "obtainFillPaint", "obtainStrokePaint", "selectPaint", "drawStyle", "modulate", "modulate-5vOe2sY", "(JF)J", "DrawParams", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class CanvasDrawScope implements DrawScope {
    @NotNull
    private final DrawContext drawContext = new CanvasDrawScope$drawContext$1(this);
    @NotNull
    private final DrawParams drawParams = new DrawParams((Density) null, (LayoutDirection) null, (Canvas) null, 0, 15, (DefaultConstructorMarker) null);
    @Nullable
    private Paint fillPaint;
    @Nullable
    private Paint strokePaint;

    public static /* synthetic */ Paint a(CanvasDrawScope canvasDrawScope, long j11, DrawStyle drawStyle, float f11, ColorFilter colorFilter, int i11, int i12, int i13, Object obj) {
        int i14;
        if ((i13 & 32) != 0) {
            i14 = DrawScope.Companion.m3427getDefaultFilterQualityfv9h1I();
        } else {
            i14 = i12;
        }
        return canvasDrawScope.m3335configurePaint2qPWKa0(j11, drawStyle, f11, colorFilter, i11, i14);
    }

    public static /* synthetic */ Paint b(CanvasDrawScope canvasDrawScope, Brush brush, DrawStyle drawStyle, float f11, ColorFilter colorFilter, int i11, int i12, int i13, Object obj) {
        if ((i13 & 32) != 0) {
            i12 = DrawScope.Companion.m3427getDefaultFilterQualityfv9h1I();
        }
        return canvasDrawScope.m3336configurePaintswdJneE(brush, drawStyle, f11, colorFilter, i11, i12);
    }

    public static /* synthetic */ Paint c(CanvasDrawScope canvasDrawScope, long j11, float f11, float f12, int i11, int i12, PathEffect pathEffect, float f13, ColorFilter colorFilter, int i13, int i14, int i15, Object obj) {
        int i16;
        if ((i15 & 512) != 0) {
            i16 = DrawScope.Companion.m3427getDefaultFilterQualityfv9h1I();
        } else {
            i16 = i14;
        }
        return canvasDrawScope.m3337configureStrokePaintQ_0CZUI(j11, f11, f12, i11, i12, pathEffect, f13, colorFilter, i13, i16);
    }

    /* renamed from: configurePaint-2qPWKa0  reason: not valid java name */
    private final Paint m3335configurePaint2qPWKa0(long j11, DrawStyle drawStyle, float f11, ColorFilter colorFilter, int i11, int i12) {
        Paint selectPaint = selectPaint(drawStyle);
        long r32 = m3339modulate5vOe2sY(j11, f11);
        if (!Color.m2920equalsimpl0(selectPaint.m3130getColor0d7_KjU(), r32)) {
            selectPaint.m3136setColor8_81llA(r32);
        }
        if (selectPaint.getShader() != null) {
            selectPaint.setShader((Shader) null);
        }
        if (!Intrinsics.areEqual((Object) selectPaint.getColorFilter(), (Object) colorFilter)) {
            selectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2826equalsimpl0(selectPaint.m3129getBlendMode0nO6VwU(), i11)) {
            selectPaint.m3135setBlendModes9anfk8(i11);
        }
        if (!FilterQuality.m3000equalsimpl0(selectPaint.m3131getFilterQualityfv9h1I(), i12)) {
            selectPaint.m3137setFilterQualityvDHp3xo(i12);
        }
        return selectPaint;
    }

    /* renamed from: configurePaint-swdJneE  reason: not valid java name */
    private final Paint m3336configurePaintswdJneE(Brush brush, DrawStyle drawStyle, float f11, ColorFilter colorFilter, int i11, int i12) {
        boolean z11;
        Paint selectPaint = selectPaint(drawStyle);
        if (brush != null) {
            brush.m2861applyToPq9zytI(m3361getSizeNHjbRc(), selectPaint, f11);
        } else {
            if (selectPaint.getAlpha() == f11) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                selectPaint.setAlpha(f11);
            }
        }
        if (!Intrinsics.areEqual((Object) selectPaint.getColorFilter(), (Object) colorFilter)) {
            selectPaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2826equalsimpl0(selectPaint.m3129getBlendMode0nO6VwU(), i11)) {
            selectPaint.m3135setBlendModes9anfk8(i11);
        }
        if (!FilterQuality.m3000equalsimpl0(selectPaint.m3131getFilterQualityfv9h1I(), i12)) {
            selectPaint.m3137setFilterQualityvDHp3xo(i12);
        }
        return selectPaint;
    }

    /* renamed from: configureStrokePaint-Q_0CZUI  reason: not valid java name */
    private final Paint m3337configureStrokePaintQ_0CZUI(long j11, float f11, float f12, int i11, int i12, PathEffect pathEffect, float f13, ColorFilter colorFilter, int i13, int i14) {
        boolean z11;
        Paint obtainStrokePaint = obtainStrokePaint();
        long r42 = m3339modulate5vOe2sY(j11, f13);
        if (!Color.m2920equalsimpl0(obtainStrokePaint.m3130getColor0d7_KjU(), r42)) {
            obtainStrokePaint.m3136setColor8_81llA(r42);
        }
        if (obtainStrokePaint.getShader() != null) {
            obtainStrokePaint.setShader((Shader) null);
        }
        if (!Intrinsics.areEqual((Object) obtainStrokePaint.getColorFilter(), (Object) colorFilter)) {
            obtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2826equalsimpl0(obtainStrokePaint.m3129getBlendMode0nO6VwU(), i13)) {
            obtainStrokePaint.m3135setBlendModes9anfk8(i13);
        }
        boolean z12 = true;
        if (obtainStrokePaint.getStrokeWidth() == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            obtainStrokePaint.setStrokeWidth(f11);
        }
        if (obtainStrokePaint.getStrokeMiterLimit() != f12) {
            z12 = false;
        }
        if (!z12) {
            obtainStrokePaint.setStrokeMiterLimit(f12);
        }
        if (!StrokeCap.m3249equalsimpl0(obtainStrokePaint.m3132getStrokeCapKaPHkGw(), i11)) {
            obtainStrokePaint.m3138setStrokeCapBeK7IIE(i11);
        }
        if (!StrokeJoin.m3259equalsimpl0(obtainStrokePaint.m3133getStrokeJoinLxFBmk8(), i12)) {
            obtainStrokePaint.m3139setStrokeJoinWw9F2mQ(i12);
        }
        if (!Intrinsics.areEqual((Object) obtainStrokePaint.getPathEffect(), (Object) pathEffect)) {
            obtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m3000equalsimpl0(obtainStrokePaint.m3131getFilterQualityfv9h1I(), i14)) {
            obtainStrokePaint.m3137setFilterQualityvDHp3xo(i14);
        }
        return obtainStrokePaint;
    }

    /* renamed from: configureStrokePaint-ho4zsrM  reason: not valid java name */
    private final Paint m3338configureStrokePaintho4zsrM(Brush brush, float f11, float f12, int i11, int i12, PathEffect pathEffect, float f13, ColorFilter colorFilter, int i13, int i14) {
        boolean z11;
        boolean z12;
        Paint obtainStrokePaint = obtainStrokePaint();
        boolean z13 = true;
        if (brush != null) {
            brush.m2861applyToPq9zytI(m3361getSizeNHjbRc(), obtainStrokePaint, f13);
        } else {
            if (obtainStrokePaint.getAlpha() == f13) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (!z12) {
                obtainStrokePaint.setAlpha(f13);
            }
        }
        if (!Intrinsics.areEqual((Object) obtainStrokePaint.getColorFilter(), (Object) colorFilter)) {
            obtainStrokePaint.setColorFilter(colorFilter);
        }
        if (!BlendMode.m2826equalsimpl0(obtainStrokePaint.m3129getBlendMode0nO6VwU(), i13)) {
            obtainStrokePaint.m3135setBlendModes9anfk8(i13);
        }
        if (obtainStrokePaint.getStrokeWidth() == f11) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            obtainStrokePaint.setStrokeWidth(f11);
        }
        if (obtainStrokePaint.getStrokeMiterLimit() != f12) {
            z13 = false;
        }
        if (!z13) {
            obtainStrokePaint.setStrokeMiterLimit(f12);
        }
        if (!StrokeCap.m3249equalsimpl0(obtainStrokePaint.m3132getStrokeCapKaPHkGw(), i11)) {
            obtainStrokePaint.m3138setStrokeCapBeK7IIE(i11);
        }
        if (!StrokeJoin.m3259equalsimpl0(obtainStrokePaint.m3133getStrokeJoinLxFBmk8(), i12)) {
            obtainStrokePaint.m3139setStrokeJoinWw9F2mQ(i12);
        }
        if (!Intrinsics.areEqual((Object) obtainStrokePaint.getPathEffect(), (Object) pathEffect)) {
            obtainStrokePaint.setPathEffect(pathEffect);
        }
        if (!FilterQuality.m3000equalsimpl0(obtainStrokePaint.m3131getFilterQualityfv9h1I(), i14)) {
            obtainStrokePaint.m3137setFilterQualityvDHp3xo(i14);
        }
        return obtainStrokePaint;
    }

    public static /* synthetic */ Paint d(CanvasDrawScope canvasDrawScope, Brush brush, float f11, float f12, int i11, int i12, PathEffect pathEffect, float f13, ColorFilter colorFilter, int i13, int i14, int i15, Object obj) {
        int i16;
        if ((i15 & 512) != 0) {
            i16 = DrawScope.Companion.m3427getDefaultFilterQualityfv9h1I();
        } else {
            i16 = i14;
        }
        return canvasDrawScope.m3338configureStrokePaintho4zsrM(brush, f11, f12, i11, i12, pathEffect, f13, colorFilter, i13, i16);
    }

    @PublishedApi
    public static /* synthetic */ void getDrawParams$annotations() {
    }

    /* renamed from: modulate-5vOe2sY  reason: not valid java name */
    private final long m3339modulate5vOe2sY(long j11, float f11) {
        if (f11 == 1.0f) {
            return j11;
        }
        return Color.m2918copywmQWz5c$default(j11, Color.m2921getAlphaimpl(j11) * f11, 0.0f, 0.0f, 0.0f, 14, (Object) null);
    }

    private final Paint obtainFillPaint() {
        Paint paint = this.fillPaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m3140setStylek9PVt8s(PaintingStyle.Companion.m3148getFillTiuSbCo());
        this.fillPaint = Paint;
        return Paint;
    }

    private final Paint obtainStrokePaint() {
        Paint paint = this.strokePaint;
        if (paint != null) {
            return paint;
        }
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.m3140setStylek9PVt8s(PaintingStyle.Companion.m3149getStrokeTiuSbCo());
        this.strokePaint = Paint;
        return Paint;
    }

    private final Paint selectPaint(DrawStyle drawStyle) {
        boolean z11;
        if (Intrinsics.areEqual((Object) drawStyle, (Object) Fill.INSTANCE)) {
            return obtainFillPaint();
        }
        if (drawStyle instanceof Stroke) {
            Paint obtainStrokePaint = obtainStrokePaint();
            Stroke stroke = (Stroke) drawStyle;
            boolean z12 = true;
            if (obtainStrokePaint.getStrokeWidth() == stroke.getWidth()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                obtainStrokePaint.setStrokeWidth(stroke.getWidth());
            }
            if (!StrokeCap.m3249equalsimpl0(obtainStrokePaint.m3132getStrokeCapKaPHkGw(), stroke.m3501getCapKaPHkGw())) {
                obtainStrokePaint.m3138setStrokeCapBeK7IIE(stroke.m3501getCapKaPHkGw());
            }
            if (obtainStrokePaint.getStrokeMiterLimit() != stroke.getMiter()) {
                z12 = false;
            }
            if (!z12) {
                obtainStrokePaint.setStrokeMiterLimit(stroke.getMiter());
            }
            if (!StrokeJoin.m3259equalsimpl0(obtainStrokePaint.m3133getStrokeJoinLxFBmk8(), stroke.m3502getJoinLxFBmk8())) {
                obtainStrokePaint.m3139setStrokeJoinWw9F2mQ(stroke.m3502getJoinLxFBmk8());
            }
            if (!Intrinsics.areEqual((Object) obtainStrokePaint.getPathEffect(), (Object) stroke.getPathEffect())) {
                obtainStrokePaint.setPathEffect(stroke.getPathEffect());
            }
            return obtainStrokePaint;
        }
        throw new NoWhenBranchMatchedException();
    }

    /* renamed from: draw-yzxVdVo  reason: not valid java name */
    public final void m3340drawyzxVdVo(@NotNull Density density, @NotNull LayoutDirection layoutDirection, @NotNull Canvas canvas, long j11, @NotNull Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(density, State.KEY_DENSITY);
        Intrinsics.checkNotNullParameter(layoutDirection, "layoutDirection");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawParams drawParams2 = getDrawParams();
        Density component1 = drawParams2.component1();
        LayoutDirection component2 = drawParams2.component2();
        Canvas component3 = drawParams2.component3();
        long r42 = drawParams2.m3375component4NHjbRc();
        DrawParams drawParams3 = getDrawParams();
        drawParams3.setDensity(density);
        drawParams3.setLayoutDirection(layoutDirection);
        drawParams3.setCanvas(canvas);
        drawParams3.m3378setSizeuvyYCjk(j11);
        canvas.save();
        function1.invoke(this);
        canvas.restore();
        DrawParams drawParams4 = getDrawParams();
        drawParams4.setDensity(component1);
        drawParams4.setLayoutDirection(component2);
        drawParams4.setCanvas(component3);
        drawParams4.m3378setSizeuvyYCjk(r42);
    }

    /* renamed from: drawArc-illE91I  reason: not valid java name */
    public void m3341drawArcillE91I(@NotNull Brush brush, float f11, float f12, boolean z11, long j11, long j12, float f13, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush2, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.drawParams.getCanvas().drawArc(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), Offset.m2676getXimpl(j11) + Size.m2745getWidthimpl(j12), Offset.m2677getYimpl(j11) + Size.m2742getHeightimpl(j12), f11, f12, z11, b(this, brush2, drawStyle2, f13, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawArc-yD3GUKo  reason: not valid java name */
    public void m3342drawArcyD3GUKo(long j11, float f11, float f12, boolean z11, long j12, long j13, float f13, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.drawParams.getCanvas().drawArc(Offset.m2676getXimpl(j12), Offset.m2677getYimpl(j12), Offset.m2676getXimpl(j12) + Size.m2745getWidthimpl(j13), Offset.m2677getYimpl(j12) + Size.m2742getHeightimpl(j13), f11, f12, z11, a(this, j11, drawStyle2, f13, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawCircle-V9BoPsw  reason: not valid java name */
    public void m3343drawCircleV9BoPsw(@NotNull Brush brush, float f11, long j11, float f12, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        Canvas canvas = this.drawParams.getCanvas();
        Paint b11 = b(this, brush, drawStyle2, f12, colorFilter, i11, 0, 32, (Object) null);
        float f13 = f11;
        long j12 = j11;
        canvas.m2888drawCircle9KIMszo(j11, f11, b11);
    }

    /* renamed from: drawCircle-VaOC9Bg  reason: not valid java name */
    public void m3344drawCircleVaOC9Bg(long j11, float f11, long j12, float f12, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        float f13 = f11;
        this.drawParams.getCanvas().m2888drawCircle9KIMszo(j12, f11, a(this, j11, drawStyle2, f12, colorFilter, i11, 0, 32, (Object) null));
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE  reason: not valid java name */
    public /* synthetic */ void m3345drawImage9jGpkUE(ImageBitmap imageBitmap, long j11, long j12, long j13, long j14, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        Canvas canvas = this.drawParams.getCanvas();
        Canvas canvas2 = canvas;
        canvas2.m2890drawImageRectHPBpro0(imageBitmap, j11, j12, j13, j14, b(this, (Brush) null, drawStyle, f11, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
    public void m3346drawImageAZ2fEMs(@NotNull ImageBitmap imageBitmap, long j11, long j12, long j13, long j14, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11, int i12) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        Canvas canvas = this.drawParams.getCanvas();
        Canvas canvas2 = canvas;
        canvas2.m2890drawImageRectHPBpro0(imageBitmap, j11, j12, j13, j14, m3336configurePaintswdJneE((Brush) null, drawStyle, f11, colorFilter, i11, i12));
    }

    /* renamed from: drawImage-gbVJVH8  reason: not valid java name */
    public void m3347drawImagegbVJVH8(@NotNull ImageBitmap imageBitmap, long j11, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        ImageBitmap imageBitmap2 = imageBitmap;
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        long j12 = j11;
        this.drawParams.getCanvas().m2889drawImaged4ec7I(imageBitmap, j11, b(this, (Brush) null, drawStyle2, f11, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawLine-1RTmtNc  reason: not valid java name */
    public void m3348drawLine1RTmtNc(@NotNull Brush brush, long j11, long j12, float f11, int i11, @Nullable PathEffect pathEffect, float f12, @Nullable ColorFilter colorFilter, int i12) {
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush2, "brush");
        this.drawParams.getCanvas().m2891drawLineWko1d7g(j11, j12, d(this, brush2, f11, 4.0f, i11, StrokeJoin.Companion.m3264getMiterLxFBmk8(), pathEffect, f12, colorFilter, i12, 0, 512, (Object) null));
    }

    /* renamed from: drawLine-NGM6Ib0  reason: not valid java name */
    public void m3349drawLineNGM6Ib0(long j11, long j12, long j13, float f11, int i11, @Nullable PathEffect pathEffect, float f12, @Nullable ColorFilter colorFilter, int i12) {
        this.drawParams.getCanvas().m2891drawLineWko1d7g(j12, j13, c(this, j11, f11, 4.0f, i11, StrokeJoin.Companion.m3264getMiterLxFBmk8(), pathEffect, f12, colorFilter, i12, 0, 512, (Object) null));
    }

    /* renamed from: drawOval-AsUm42w  reason: not valid java name */
    public void m3350drawOvalAsUm42w(@NotNull Brush brush, long j11, long j12, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush2, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.drawParams.getCanvas().drawOval(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), Offset.m2676getXimpl(j11) + Size.m2745getWidthimpl(j12), Offset.m2677getYimpl(j11) + Size.m2742getHeightimpl(j12), b(this, brush2, drawStyle2, f11, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawOval-n-J9OG0  reason: not valid java name */
    public void m3351drawOvalnJ9OG0(long j11, long j12, long j13, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.drawParams.getCanvas().drawOval(Offset.m2676getXimpl(j12), Offset.m2677getYimpl(j12), Offset.m2676getXimpl(j12) + Size.m2745getWidthimpl(j13), Offset.m2677getYimpl(j12) + Size.m2742getHeightimpl(j13), a(this, j11, drawStyle2, f11, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawPath-GBMwjPU  reason: not valid java name */
    public void m3352drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Path path2 = path;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.drawParams.getCanvas().drawPath(path, b(this, brush, drawStyle2, f11, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawPath-LG529CI  reason: not valid java name */
    public void m3353drawPathLG529CI(@NotNull Path path, long j11, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Path path2 = path;
        Intrinsics.checkNotNullParameter(path, "path");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.drawParams.getCanvas().drawPath(path, a(this, j11, drawStyle2, f11, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawPoints-F8ZwMP8  reason: not valid java name */
    public void m3354drawPointsF8ZwMP8(@NotNull List<Offset> list, int i11, long j11, float f11, int i12, @Nullable PathEffect pathEffect, float f12, @Nullable ColorFilter colorFilter, int i13) {
        List<Offset> list2 = list;
        Intrinsics.checkNotNullParameter(list2, Param.POINTS);
        this.drawParams.getCanvas().m2892drawPointsO7TthRY(i11, list2, c(this, j11, f11, 4.0f, i12, StrokeJoin.Companion.m3264getMiterLxFBmk8(), pathEffect, f12, colorFilter, i13, 0, 512, (Object) null));
    }

    /* renamed from: drawPoints-Gsft0Ws  reason: not valid java name */
    public void m3355drawPointsGsft0Ws(@NotNull List<Offset> list, int i11, @NotNull Brush brush, float f11, int i12, @Nullable PathEffect pathEffect, float f12, @Nullable ColorFilter colorFilter, int i13) {
        List<Offset> list2 = list;
        Intrinsics.checkNotNullParameter(list2, Param.POINTS);
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush2, "brush");
        this.drawParams.getCanvas().m2892drawPointsO7TthRY(i11, list2, d(this, brush2, f11, 4.0f, i12, StrokeJoin.Companion.m3264getMiterLxFBmk8(), pathEffect, f12, colorFilter, i13, 0, 512, (Object) null));
    }

    /* renamed from: drawRect-AsUm42w  reason: not valid java name */
    public void m3356drawRectAsUm42w(@NotNull Brush brush, long j11, long j12, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush2, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.drawParams.getCanvas().drawRect(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), Offset.m2676getXimpl(j11) + Size.m2745getWidthimpl(j12), Offset.m2677getYimpl(j11) + Size.m2742getHeightimpl(j12), b(this, brush2, drawStyle2, f11, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawRect-n-J9OG0  reason: not valid java name */
    public void m3357drawRectnJ9OG0(long j11, long j12, long j13, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.drawParams.getCanvas().drawRect(Offset.m2676getXimpl(j12), Offset.m2677getYimpl(j12), Offset.m2676getXimpl(j12) + Size.m2745getWidthimpl(j13), Offset.m2677getYimpl(j12) + Size.m2742getHeightimpl(j13), a(this, j11, drawStyle2, f11, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawRoundRect-ZuiqVtQ  reason: not valid java name */
    public void m3358drawRoundRectZuiqVtQ(@NotNull Brush brush, long j11, long j12, long j13, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Brush brush2 = brush;
        Intrinsics.checkNotNullParameter(brush2, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.drawParams.getCanvas().drawRoundRect(Offset.m2676getXimpl(j11), Offset.m2677getYimpl(j11), Offset.m2676getXimpl(j11) + Size.m2745getWidthimpl(j12), Offset.m2677getYimpl(j11) + Size.m2742getHeightimpl(j12), CornerRadius.m2651getXimpl(j13), CornerRadius.m2652getYimpl(j13), b(this, brush2, drawStyle2, f11, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: drawRoundRect-u-Aw5IA  reason: not valid java name */
    public void m3359drawRoundRectuAw5IA(long j11, long j12, long j13, long j14, @NotNull DrawStyle drawStyle, float f11, @Nullable ColorFilter colorFilter, int i11) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.drawParams.getCanvas().drawRoundRect(Offset.m2676getXimpl(j12), Offset.m2677getYimpl(j12), Offset.m2676getXimpl(j12) + Size.m2745getWidthimpl(j13), Offset.m2677getYimpl(j12) + Size.m2742getHeightimpl(j13), CornerRadius.m2651getXimpl(j14), CornerRadius.m2652getYimpl(j14), a(this, j11, drawStyle2, f11, colorFilter, i11, 0, 32, (Object) null));
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    public /* synthetic */ long m3360getCenterF1C5BW0() {
        return b.b(this);
    }

    public float getDensity() {
        return this.drawParams.getDensity().getDensity();
    }

    @NotNull
    public DrawContext getDrawContext() {
        return this.drawContext;
    }

    @NotNull
    public final DrawParams getDrawParams() {
        return this.drawParams;
    }

    public float getFontScale() {
        return this.drawParams.getDensity().getFontScale();
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.drawParams.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public /* synthetic */ long m3361getSizeNHjbRc() {
        return b.c(this);
    }

    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ int m3362roundToPxR2X_6o(long j11) {
        return a.a(this, j11);
    }

    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public /* synthetic */ int m3363roundToPx0680j_4(float f11) {
        return a.b(this, f11);
    }

    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public /* synthetic */ float m3364toDpGaN1DYA(long j11) {
        return a.c(this, j11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m3365toDpu2uoSUM(float f11) {
        return a.d(this, f11);
    }

    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public /* synthetic */ float m3366toDpu2uoSUM(int i11) {
        return a.e(this, i11);
    }

    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public /* synthetic */ long m3367toDpSizekrfVVM(long j11) {
        return a.f(this, j11);
    }

    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public /* synthetic */ float m3368toPxR2X_6o(long j11) {
        return a.g(this, j11);
    }

    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public /* synthetic */ float m3369toPx0680j_4(float f11) {
        return a.h(this, f11);
    }

    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return a.i(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public /* synthetic */ long m3370toSizeXkaWNTQ(long j11) {
        return a.j(this, j11);
    }

    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public /* synthetic */ long m3371toSp0xMU5do(float f11) {
        return a.k(this, f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m3372toSpkPz2Gy4(float f11) {
        return a.l(this, f11);
    }

    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public /* synthetic */ long m3373toSpkPz2Gy4(int i11) {
        return a.m(this, i11);
    }

    @PublishedApi
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B0\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\tø\u0001\u0000¢\u0006\u0002\u0010\nJ\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\u0019\u0010\u001f\u001a\u00020\tHÆ\u0003ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b \u0010\u0018J>\u0010!\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\tHÆ\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\"\u0010#J\u0013\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010'\u001a\u00020(HÖ\u0001J\t\u0010)\u001a\u00020*HÖ\u0001R\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R%\u0010\b\u001a\u00020\tX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006+"}, d2 = {"Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "", "density", "Landroidx/compose/ui/unit/Density;", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "size", "Landroidx/compose/ui/geometry/Size;", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getCanvas", "()Landroidx/compose/ui/graphics/Canvas;", "setCanvas", "(Landroidx/compose/ui/graphics/Canvas;)V", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "getSize-NH-jbRc", "()J", "setSize-uvyYCjk", "(J)V", "J", "component1", "component2", "component3", "component4", "component4-NH-jbRc", "copy", "copy-Ug5Nnss", "(Landroidx/compose/ui/unit/Density;Landroidx/compose/ui/unit/LayoutDirection;Landroidx/compose/ui/graphics/Canvas;J)Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope$DrawParams;", "equals", "", "other", "hashCode", "", "toString", "", "ui-graphics_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class DrawParams {
        @NotNull
        private Canvas canvas;
        @NotNull
        private Density density;
        @NotNull
        private LayoutDirection layoutDirection;
        private long size;

        private DrawParams(Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j11) {
            this.density = density2;
            this.layoutDirection = layoutDirection2;
            this.canvas = canvas2;
            this.size = j11;
        }

        public /* synthetic */ DrawParams(Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j11, DefaultConstructorMarker defaultConstructorMarker) {
            this(density2, layoutDirection2, canvas2, j11);
        }

        /* renamed from: copy-Ug5Nnss$default  reason: not valid java name */
        public static /* synthetic */ DrawParams m3374copyUg5Nnss$default(DrawParams drawParams, Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j11, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                density2 = drawParams.density;
            }
            if ((i11 & 2) != 0) {
                layoutDirection2 = drawParams.layoutDirection;
            }
            LayoutDirection layoutDirection3 = layoutDirection2;
            if ((i11 & 4) != 0) {
                canvas2 = drawParams.canvas;
            }
            Canvas canvas3 = canvas2;
            if ((i11 & 8) != 0) {
                j11 = drawParams.size;
            }
            return drawParams.m3376copyUg5Nnss(density2, layoutDirection3, canvas3, j11);
        }

        @NotNull
        public final Density component1() {
            return this.density;
        }

        @NotNull
        public final LayoutDirection component2() {
            return this.layoutDirection;
        }

        @NotNull
        public final Canvas component3() {
            return this.canvas;
        }

        /* renamed from: component4-NH-jbRc  reason: not valid java name */
        public final long m3375component4NHjbRc() {
            return this.size;
        }

        @NotNull
        /* renamed from: copy-Ug5Nnss  reason: not valid java name */
        public final DrawParams m3376copyUg5Nnss(@NotNull Density density2, @NotNull LayoutDirection layoutDirection2, @NotNull Canvas canvas2, long j11) {
            Intrinsics.checkNotNullParameter(density2, State.KEY_DENSITY);
            Intrinsics.checkNotNullParameter(layoutDirection2, "layoutDirection");
            Intrinsics.checkNotNullParameter(canvas2, "canvas");
            return new DrawParams(density2, layoutDirection2, canvas2, j11, (DefaultConstructorMarker) null);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DrawParams)) {
                return false;
            }
            DrawParams drawParams = (DrawParams) obj;
            return Intrinsics.areEqual((Object) this.density, (Object) drawParams.density) && this.layoutDirection == drawParams.layoutDirection && Intrinsics.areEqual((Object) this.canvas, (Object) drawParams.canvas) && Size.m2741equalsimpl0(this.size, drawParams.size);
        }

        @NotNull
        public final Canvas getCanvas() {
            return this.canvas;
        }

        @NotNull
        public final Density getDensity() {
            return this.density;
        }

        @NotNull
        public final LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        /* renamed from: getSize-NH-jbRc  reason: not valid java name */
        public final long m3377getSizeNHjbRc() {
            return this.size;
        }

        public int hashCode() {
            return (((((this.density.hashCode() * 31) + this.layoutDirection.hashCode()) * 31) + this.canvas.hashCode()) * 31) + Size.m2746hashCodeimpl(this.size);
        }

        public final void setCanvas(@NotNull Canvas canvas2) {
            Intrinsics.checkNotNullParameter(canvas2, "<set-?>");
            this.canvas = canvas2;
        }

        public final void setDensity(@NotNull Density density2) {
            Intrinsics.checkNotNullParameter(density2, "<set-?>");
            this.density = density2;
        }

        public final void setLayoutDirection(@NotNull LayoutDirection layoutDirection2) {
            Intrinsics.checkNotNullParameter(layoutDirection2, "<set-?>");
            this.layoutDirection = layoutDirection2;
        }

        /* renamed from: setSize-uvyYCjk  reason: not valid java name */
        public final void m3378setSizeuvyYCjk(long j11) {
            this.size = j11;
        }

        @NotNull
        public String toString() {
            return "DrawParams(density=" + this.density + ", layoutDirection=" + this.layoutDirection + ", canvas=" + this.canvas + ", size=" + Size.m2749toStringimpl(this.size) + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DrawParams(Density density2, LayoutDirection layoutDirection2, Canvas canvas2, long j11, int i11, DefaultConstructorMarker defaultConstructorMarker) {
            this((i11 & 1) != 0 ? CanvasDrawScopeKt.DefaultDensity : density2, (i11 & 2) != 0 ? LayoutDirection.Ltr : layoutDirection2, (i11 & 4) != 0 ? new EmptyCanvas() : canvas2, (i11 & 8) != 0 ? Size.Companion.m2754getZeroNHjbRc() : j11, (DefaultConstructorMarker) null);
        }
    }
}
