package androidx.compose.ui.node;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathEffect;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ø\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J5\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u0012\u001a\u00020\u0013H\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b#\u0010$Jt\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b4\u00105Jt\u0010%\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\u0006\u0010(\u001a\u00020\u000b2\u0006\u0010)\u001a\u00020\u000b2\u0006\u0010*\u001a\u00020+2\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b8\u00109J\\\u0010:\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010;\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b<\u0010=J\\\u0010:\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\b\b\u0002\u0010;\u001a\u00020\u000b2\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b>\u0010?J\b\u0010@\u001a\u00020\u001eH\u0016JR\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020C2\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bD\u0010EJp\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u00020G2\b\b\u0002\u0010K\u001a\u00020I2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bL\u0010MJz\u0010A\u001a\u00020\u001e2\u0006\u0010B\u001a\u00020C2\b\b\u0002\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020I2\b\b\u0002\u0010J\u001a\u00020G2\b\b\u0002\u0010K\u001a\u00020I2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u0002032\b\b\u0002\u0010N\u001a\u00020OH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bP\u0010QJn\u0010R\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\b\b\u0002\u0010U\u001a\u00020\u000b2\b\b\u0002\u0010V\u001a\u00020W2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010Y2\b\b\u0002\u0010-\u001a\u00020\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bZ\u0010[Jn\u0010R\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\u0006\u0010S\u001a\u00020\u00072\u0006\u0010T\u001a\u00020\u00072\b\b\u0002\u0010U\u001a\u00020\u000b2\b\b\u0002\u0010V\u001a\u00020W2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010Y2\b\b\u0002\u0010-\u001a\u00020\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b\\\u0010]J\\\u0010^\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b_\u0010`J\\\u0010^\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\ba\u0010bJP\u0010c\u001a\u00020\u001e2\u0006\u0010d\u001a\u00020e2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bf\u0010gJP\u0010c\u001a\u00020\u001e2\u0006\u0010d\u001a\u00020e2\u0006\u00106\u001a\u0002072\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bh\u0010iJt\u0010j\u001a\u00020\u001e2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00070l2\u0006\u0010m\u001a\u00020n2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010U\u001a\u00020\u000b2\b\b\u0002\u0010V\u001a\u00020W2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010Y2\b\b\u0002\u0010-\u001a\u00020\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010pJt\u0010j\u001a\u00020\u001e2\f\u0010k\u001a\b\u0012\u0004\u0012\u00020\u00070l2\u0006\u0010m\u001a\u00020n2\u0006\u00106\u001a\u0002072\b\b\u0002\u0010U\u001a\u00020\u000b2\b\b\u0002\u0010V\u001a\u00020W2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010Y2\b\b\u0002\u0010-\u001a\u00020\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010rJ\\\u0010s\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bt\u0010`J\\\u0010s\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010bJf\u0010v\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020'2\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010w\u001a\u00020x2\b\b\u0002\u0010-\u001a\u00020\u000b2\b\b\u0002\u0010.\u001a\u00020/2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\by\u0010zJf\u0010v\u001a\u00020\u001e2\u0006\u00106\u001a\u0002072\b\b\u0002\u0010,\u001a\u00020\u00072\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010w\u001a\u00020x2\b\b\u0002\u0010.\u001a\u00020/2\b\b\u0002\u0010-\u001a\u00020\u000b2\n\b\u0002\u00100\u001a\u0004\u0018\u0001012\b\b\u0002\u00102\u001a\u000203H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\b{\u0010|J\u0012\u0010}\u001a\u00020\u001e*\u00020\u00132\u0006\u0010\u001f\u001a\u00020 J\u001d\u0010~\u001a\u00020*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001d\u0010~\u001a\u00020*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u00030\u0001*\u00020\u000bH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u00030\u0001*\u00020H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00030\u0001*\u00020\u001bH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u000b*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001e\u0010\u0001\u001a\u00020\u000b*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001J\u001e\u0010\u0001\u001a\u00020\u001b*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u001f\u0010\u0001\u001a\u00030\u0001*\u00030\u0001H\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u00030\u0001*\u00020\u000bH\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001J!\u0010\u0001\u001a\u00030\u0001*\u00020H\u0001ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0001\u0010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0006\u001a\u00020\u00078VX\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0012\u0010\u000e\u001a\u00020\u000fX\u0005¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u000b8\u0016X\u0005¢\u0006\u0006\u001a\u0004\b\u0015\u0010\rR\u0012\u0010\u0016\u001a\u00020\u0017X\u0005¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\u001a\u001a\u00020\u001b8VX\u0005ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001c\u0010\t\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/LayoutNodeDrawScope;", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "canvasDrawScope", "Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;", "(Landroidx/compose/ui/graphics/drawscope/CanvasDrawScope;)V", "center", "Landroidx/compose/ui/geometry/Offset;", "getCenter-F1C5BW0", "()J", "density", "", "getDensity", "()F", "drawContext", "Landroidx/compose/ui/graphics/drawscope/DrawContext;", "getDrawContext", "()Landroidx/compose/ui/graphics/drawscope/DrawContext;", "drawNode", "Landroidx/compose/ui/node/DrawModifierNode;", "fontScale", "getFontScale", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "size", "Landroidx/compose/ui/geometry/Size;", "getSize-NH-jbRc", "draw", "", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "coordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "draw-x_KDEd0$ui_release", "(Landroidx/compose/ui/graphics/Canvas;JLandroidx/compose/ui/node/NodeCoordinator;Landroidx/compose/ui/node/DrawModifierNode;)V", "drawArc", "brush", "Landroidx/compose/ui/graphics/Brush;", "startAngle", "sweepAngle", "useCenter", "", "topLeft", "alpha", "style", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "drawArc-illE91I", "(Landroidx/compose/ui/graphics/Brush;FFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "color", "Landroidx/compose/ui/graphics/Color;", "drawArc-yD3GUKo", "(JFFZJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle", "radius", "drawCircle-V9BoPsw", "(Landroidx/compose/ui/graphics/Brush;FJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawCircle-VaOC9Bg", "(JFJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawContent", "drawImage", "image", "Landroidx/compose/ui/graphics/ImageBitmap;", "drawImage-gbVJVH8", "(Landroidx/compose/ui/graphics/ImageBitmap;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "srcOffset", "Landroidx/compose/ui/unit/IntOffset;", "srcSize", "Landroidx/compose/ui/unit/IntSize;", "dstOffset", "dstSize", "drawImage-9jGpkUE", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "filterQuality", "Landroidx/compose/ui/graphics/FilterQuality;", "drawImage-AZ2fEMs", "(Landroidx/compose/ui/graphics/ImageBitmap;JJJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;II)V", "drawLine", "start", "end", "strokeWidth", "cap", "Landroidx/compose/ui/graphics/StrokeCap;", "pathEffect", "Landroidx/compose/ui/graphics/PathEffect;", "drawLine-1RTmtNc", "(Landroidx/compose/ui/graphics/Brush;JJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawLine-NGM6Ib0", "(JJJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval", "drawOval-AsUm42w", "(Landroidx/compose/ui/graphics/Brush;JJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawOval-n-J9OG0", "(JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath", "path", "Landroidx/compose/ui/graphics/Path;", "drawPath-GBMwjPU", "(Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/graphics/Brush;FLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPath-LG529CI", "(Landroidx/compose/ui/graphics/Path;JFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints", "points", "", "pointMode", "Landroidx/compose/ui/graphics/PointMode;", "drawPoints-Gsft0Ws", "(Ljava/util/List;ILandroidx/compose/ui/graphics/Brush;FILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawPoints-F8ZwMP8", "(Ljava/util/List;IJFILandroidx/compose/ui/graphics/PathEffect;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "drawRect", "drawRect-AsUm42w", "drawRect-n-J9OG0", "drawRoundRect", "cornerRadius", "Landroidx/compose/ui/geometry/CornerRadius;", "drawRoundRect-ZuiqVtQ", "(Landroidx/compose/ui/graphics/Brush;JJJFLandroidx/compose/ui/graphics/drawscope/DrawStyle;Landroidx/compose/ui/graphics/ColorFilter;I)V", "drawRoundRect-u-Aw5IA", "(JJJJLandroidx/compose/ui/graphics/drawscope/DrawStyle;FLandroidx/compose/ui/graphics/ColorFilter;I)V", "performDraw", "roundToPx", "", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-GaN1DYA", "(J)F", "toDp-u2uoSUM", "(F)F", "(I)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-0xMU5do", "(F)J", "toSp-kPz2Gy4", "(I)J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LayoutNodeDrawScope implements DrawScope, ContentDrawScope {
    @NotNull
    private final CanvasDrawScope canvasDrawScope;
    @Nullable
    private DrawModifierNode drawNode;

    public LayoutNodeDrawScope() {
        this((CanvasDrawScope) null, 1, (DefaultConstructorMarker) null);
    }

    public LayoutNodeDrawScope(@NotNull CanvasDrawScope canvasDrawScope2) {
        Intrinsics.checkNotNullParameter(canvasDrawScope2, "canvasDrawScope");
        this.canvasDrawScope = canvasDrawScope2;
    }

    /* renamed from: draw-x_KDEd0$ui_release  reason: not valid java name */
    public final void m4628drawx_KDEd0$ui_release(@NotNull Canvas canvas, long j11, @NotNull NodeCoordinator nodeCoordinator, @NotNull DrawModifierNode drawModifierNode) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(nodeCoordinator, "coordinator");
        Intrinsics.checkNotNullParameter(drawModifierNode, "drawNode");
        DrawModifierNode drawModifierNode2 = this.drawNode;
        this.drawNode = drawModifierNode;
        CanvasDrawScope canvasDrawScope2 = this.canvasDrawScope;
        LayoutDirection layoutDirection = nodeCoordinator.getLayoutDirection();
        CanvasDrawScope.DrawParams drawParams = canvasDrawScope2.getDrawParams();
        Density component1 = drawParams.component1();
        LayoutDirection component2 = drawParams.component2();
        Canvas component3 = drawParams.component3();
        long r72 = drawParams.m3375component4NHjbRc();
        CanvasDrawScope.DrawParams drawParams2 = canvasDrawScope2.getDrawParams();
        drawParams2.setDensity(nodeCoordinator);
        drawParams2.setLayoutDirection(layoutDirection);
        drawParams2.setCanvas(canvas);
        drawParams2.m3378setSizeuvyYCjk(j11);
        canvas.save();
        drawModifierNode.draw(this);
        canvas.restore();
        CanvasDrawScope.DrawParams drawParams3 = canvasDrawScope2.getDrawParams();
        drawParams3.setDensity(component1);
        drawParams3.setLayoutDirection(component2);
        drawParams3.setCanvas(component3);
        drawParams3.m3378setSizeuvyYCjk(r72);
        this.drawNode = drawModifierNode2;
    }

    /* renamed from: drawArc-illE91I  reason: not valid java name */
    public void m4629drawArcillE91I(@NotNull Brush brush, float f11, float f12, boolean z11, long j11, long j12, float f13, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3341drawArcillE91I(brush, f11, f12, z11, j11, j12, f13, drawStyle2, colorFilter, i11);
    }

    /* renamed from: drawArc-yD3GUKo  reason: not valid java name */
    public void m4630drawArcyD3GUKo(long j11, float f11, float f12, boolean z11, long j12, long j13, float f13, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3342drawArcyD3GUKo(j11, f11, f12, z11, j12, j13, f13, drawStyle2, colorFilter, i11);
    }

    /* renamed from: drawCircle-V9BoPsw  reason: not valid java name */
    public void m4631drawCircleV9BoPsw(@NotNull Brush brush, float f11, long j11, float f12, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3343drawCircleV9BoPsw(brush, f11, j11, f12, drawStyle2, colorFilter, i11);
    }

    /* renamed from: drawCircle-VaOC9Bg  reason: not valid java name */
    public void m4632drawCircleVaOC9Bg(long j11, float f11, long j12, float f12, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3344drawCircleVaOC9Bg(j11, f11, j12, f12, drawStyle2, colorFilter, i11);
    }

    public void drawContent() {
        Canvas canvas = getDrawContext().getCanvas();
        DrawModifierNode drawModifierNode = this.drawNode;
        Intrinsics.checkNotNull(drawModifierNode);
        DrawModifierNode access$nextDrawNode = LayoutNodeDrawScopeKt.nextDrawNode(drawModifierNode);
        if (access$nextDrawNode != null) {
            performDraw(access$nextDrawNode, canvas);
            return;
        }
        NodeCoordinator r22 = DelegatableNodeKt.m4588requireCoordinator64DMado(drawModifierNode, Nodes.INSTANCE.m4758getDrawOLwlOKw());
        if (r22.getTail() == drawModifierNode) {
            r22 = r22.getWrapped$ui_release();
            Intrinsics.checkNotNull(r22);
        }
        r22.performDraw(canvas);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Prefer usage of drawImage that consumes an optional FilterQuality parameter", replaceWith = @ReplaceWith(expression = "drawImage(image, srcOffset, srcSize, dstOffset, dstSize, alpha, style, colorFilter, blendMode, FilterQuality.Low)", imports = {"androidx.compose.ui.graphics.drawscope", "androidx.compose.ui.graphics.FilterQuality"}))
    /* renamed from: drawImage-9jGpkUE  reason: not valid java name */
    public /* synthetic */ void m4633drawImage9jGpkUE(ImageBitmap imageBitmap, long j11, long j12, long j13, long j14, float f11, DrawStyle drawStyle, ColorFilter colorFilter, int i11) {
        ImageBitmap imageBitmap2 = imageBitmap;
        Intrinsics.checkNotNullParameter(imageBitmap2, "image");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3345drawImage9jGpkUE(imageBitmap2, j11, j12, j13, j14, f11, drawStyle2, colorFilter, i11);
    }

    /* renamed from: drawImage-AZ2fEMs  reason: not valid java name */
    public void m4634drawImageAZ2fEMs(@NotNull ImageBitmap imageBitmap, long j11, long j12, long j13, long j14, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11, int i12) {
        ImageBitmap imageBitmap2 = imageBitmap;
        Intrinsics.checkNotNullParameter(imageBitmap2, "image");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3346drawImageAZ2fEMs(imageBitmap2, j11, j12, j13, j14, f11, drawStyle2, colorFilter, i11, i12);
    }

    /* renamed from: drawImage-gbVJVH8  reason: not valid java name */
    public void m4635drawImagegbVJVH8(@NotNull ImageBitmap imageBitmap, long j11, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Intrinsics.checkNotNullParameter(imageBitmap, "image");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3347drawImagegbVJVH8(imageBitmap, j11, f11, drawStyle, colorFilter, i11);
    }

    /* renamed from: drawLine-1RTmtNc  reason: not valid java name */
    public void m4636drawLine1RTmtNc(@NotNull Brush brush, long j11, long j12, float f11, int i11, @Nullable PathEffect pathEffect, float f12, @Nullable ColorFilter colorFilter, int i12) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.canvasDrawScope.m3348drawLine1RTmtNc(brush, j11, j12, f11, i11, pathEffect, f12, colorFilter, i12);
    }

    /* renamed from: drawLine-NGM6Ib0  reason: not valid java name */
    public void m4637drawLineNGM6Ib0(long j11, long j12, long j13, float f11, int i11, @Nullable PathEffect pathEffect, float f12, @Nullable ColorFilter colorFilter, int i12) {
        this.canvasDrawScope.m3349drawLineNGM6Ib0(j11, j12, j13, f11, i11, pathEffect, f12, colorFilter, i12);
    }

    /* renamed from: drawOval-AsUm42w  reason: not valid java name */
    public void m4638drawOvalAsUm42w(@NotNull Brush brush, long j11, long j12, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3350drawOvalAsUm42w(brush, j11, j12, f11, drawStyle2, colorFilter, i11);
    }

    /* renamed from: drawOval-n-J9OG0  reason: not valid java name */
    public void m4639drawOvalnJ9OG0(long j11, long j12, long j13, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3351drawOvalnJ9OG0(j11, j12, j13, f11, drawStyle2, colorFilter, i11);
    }

    /* renamed from: drawPath-GBMwjPU  reason: not valid java name */
    public void m4640drawPathGBMwjPU(@NotNull Path path, @NotNull Brush brush, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(brush, "brush");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3352drawPathGBMwjPU(path, brush, f11, drawStyle, colorFilter, i11);
    }

    /* renamed from: drawPath-LG529CI  reason: not valid java name */
    public void m4641drawPathLG529CI(@NotNull Path path, long j11, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(drawStyle, "style");
        this.canvasDrawScope.m3353drawPathLG529CI(path, j11, f11, drawStyle, colorFilter, i11);
    }

    /* renamed from: drawPoints-F8ZwMP8  reason: not valid java name */
    public void m4642drawPointsF8ZwMP8(@NotNull List<Offset> list, int i11, long j11, float f11, int i12, @Nullable PathEffect pathEffect, float f12, @Nullable ColorFilter colorFilter, int i13) {
        Intrinsics.checkNotNullParameter(list, Param.POINTS);
        this.canvasDrawScope.m3354drawPointsF8ZwMP8(list, i11, j11, f11, i12, pathEffect, f12, colorFilter, i13);
    }

    /* renamed from: drawPoints-Gsft0Ws  reason: not valid java name */
    public void m4643drawPointsGsft0Ws(@NotNull List<Offset> list, int i11, @NotNull Brush brush, float f11, int i12, @Nullable PathEffect pathEffect, float f12, @Nullable ColorFilter colorFilter, int i13) {
        Intrinsics.checkNotNullParameter(list, Param.POINTS);
        Intrinsics.checkNotNullParameter(brush, "brush");
        this.canvasDrawScope.m3355drawPointsGsft0Ws(list, i11, brush, f11, i12, pathEffect, f12, colorFilter, i13);
    }

    /* renamed from: drawRect-AsUm42w  reason: not valid java name */
    public void m4644drawRectAsUm42w(@NotNull Brush brush, long j11, long j12, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3356drawRectAsUm42w(brush, j11, j12, f11, drawStyle2, colorFilter, i11);
    }

    /* renamed from: drawRect-n-J9OG0  reason: not valid java name */
    public void m4645drawRectnJ9OG0(long j11, long j12, long j13, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3357drawRectnJ9OG0(j11, j12, j13, f11, drawStyle2, colorFilter, i11);
    }

    /* renamed from: drawRoundRect-ZuiqVtQ  reason: not valid java name */
    public void m4646drawRoundRectZuiqVtQ(@NotNull Brush brush, long j11, long j12, long j13, float f11, @NotNull DrawStyle drawStyle, @Nullable ColorFilter colorFilter, int i11) {
        Intrinsics.checkNotNullParameter(brush, "brush");
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3358drawRoundRectZuiqVtQ(brush, j11, j12, j13, f11, drawStyle2, colorFilter, i11);
    }

    /* renamed from: drawRoundRect-u-Aw5IA  reason: not valid java name */
    public void m4647drawRoundRectuAw5IA(long j11, long j12, long j13, long j14, @NotNull DrawStyle drawStyle, float f11, @Nullable ColorFilter colorFilter, int i11) {
        DrawStyle drawStyle2 = drawStyle;
        Intrinsics.checkNotNullParameter(drawStyle2, "style");
        this.canvasDrawScope.m3359drawRoundRectuAw5IA(j11, j12, j13, j14, drawStyle2, f11, colorFilter, i11);
    }

    /* renamed from: getCenter-F1C5BW0  reason: not valid java name */
    public long m4648getCenterF1C5BW0() {
        return this.canvasDrawScope.m3360getCenterF1C5BW0();
    }

    public float getDensity() {
        return this.canvasDrawScope.getDensity();
    }

    @NotNull
    public DrawContext getDrawContext() {
        return this.canvasDrawScope.getDrawContext();
    }

    public float getFontScale() {
        return this.canvasDrawScope.getFontScale();
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.canvasDrawScope.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc  reason: not valid java name */
    public long m4649getSizeNHjbRc() {
        return this.canvasDrawScope.m3361getSizeNHjbRc();
    }

    public final void performDraw(@NotNull DrawModifierNode drawModifierNode, @NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(drawModifierNode, "<this>");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator r52 = DelegatableNodeKt.m4588requireCoordinator64DMado(drawModifierNode, Nodes.INSTANCE.m4758getDrawOLwlOKw());
        r52.getLayoutNode().getMDrawScope$ui_release().m4628drawx_KDEd0$ui_release(canvas, IntSizeKt.m5648toSizeozmzZPI(r52.m4722getSizeYbymL2g()), r52, drawModifierNode);
    }

    @Stable
    /* renamed from: roundToPx--R2X_6o  reason: not valid java name */
    public int m4650roundToPxR2X_6o(long j11) {
        return this.canvasDrawScope.m3362roundToPxR2X_6o(j11);
    }

    @Stable
    /* renamed from: roundToPx-0680j_4  reason: not valid java name */
    public int m4651roundToPx0680j_4(float f11) {
        return this.canvasDrawScope.m3363roundToPx0680j_4(f11);
    }

    @Stable
    /* renamed from: toDp-GaN1DYA  reason: not valid java name */
    public float m4652toDpGaN1DYA(long j11) {
        return this.canvasDrawScope.m3364toDpGaN1DYA(j11);
    }

    @Stable
    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m4653toDpu2uoSUM(float f11) {
        return this.canvasDrawScope.m3365toDpu2uoSUM(f11);
    }

    @Stable
    /* renamed from: toDp-u2uoSUM  reason: not valid java name */
    public float m4654toDpu2uoSUM(int i11) {
        return this.canvasDrawScope.m3366toDpu2uoSUM(i11);
    }

    @Stable
    /* renamed from: toDpSize-k-rfVVM  reason: not valid java name */
    public long m4655toDpSizekrfVVM(long j11) {
        return this.canvasDrawScope.m3367toDpSizekrfVVM(j11);
    }

    @Stable
    /* renamed from: toPx--R2X_6o  reason: not valid java name */
    public float m4656toPxR2X_6o(long j11) {
        return this.canvasDrawScope.m3368toPxR2X_6o(j11);
    }

    @Stable
    /* renamed from: toPx-0680j_4  reason: not valid java name */
    public float m4657toPx0680j_4(float f11) {
        return this.canvasDrawScope.m3369toPx0680j_4(f11);
    }

    @NotNull
    @Stable
    public Rect toRect(@NotNull DpRect dpRect) {
        Intrinsics.checkNotNullParameter(dpRect, "<this>");
        return this.canvasDrawScope.toRect(dpRect);
    }

    @Stable
    /* renamed from: toSize-XkaWNTQ  reason: not valid java name */
    public long m4658toSizeXkaWNTQ(long j11) {
        return this.canvasDrawScope.m3370toSizeXkaWNTQ(j11);
    }

    @Stable
    /* renamed from: toSp-0xMU5do  reason: not valid java name */
    public long m4659toSp0xMU5do(float f11) {
        return this.canvasDrawScope.m3371toSp0xMU5do(f11);
    }

    @Stable
    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m4660toSpkPz2Gy4(float f11) {
        return this.canvasDrawScope.m3372toSpkPz2Gy4(f11);
    }

    @Stable
    /* renamed from: toSp-kPz2Gy4  reason: not valid java name */
    public long m4661toSpkPz2Gy4(int i11) {
        return this.canvasDrawScope.m3373toSpkPz2Gy4(i11);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNodeDrawScope(CanvasDrawScope canvasDrawScope2, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this((i11 & 1) != 0 ? new CanvasDrawScope() : canvasDrawScope2);
    }
}
