package androidx.compose.ui.node;

import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.MutableRectKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.ReusableGraphicsLayerScope;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.LookaheadLayoutCoordinatesImpl;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import androidx.compose.ui.unit.LayoutDirection;
import com.huawei.hms.flutter.map.constants.Param;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0011\b \u0018\u0000 \u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005:\u0004\u0002\u0002B\u0013\u0012\b\u0010\u0001\u001a\u00030\u0001¢\u0006\u0006\b\u0002\u0010\u0002J\u0012\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\t\u001a\u00020\bH\u0002J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0002J\b\u0010\u000e\u001a\u00020\u0007H\u0002JY\u0010\u001b\u001a\u00020\u0007\"\b\b\u0000\u0010\u0010*\u00020\u000f*\u0004\u0018\u00018\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001aJa\u0010 \u001a\u00020\u0007\"\b\b\u0000\u0010\u0010*\u00020\u000f*\u0004\u0018\u00018\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001fJa\u0010\"\u001a\u00020\u0007\"\b\b\u0000\u0010\u0010*\u00020\u000f*\u0004\u0018\u00018\u00002\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b!\u0010\u001fJ\f\u0010#\u001a\u00020\u0000*\u00020\u0003H\u0002J%\u0010)\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00002\u0006\u0010&\u001a\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b'\u0010(J%\u0010+\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00002\u0006\u0010&\u001a\u00020%H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010(J%\u0010/\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b-\u0010.J \u0010/\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00002\u0006\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\bH\u0002J\u0018\u00104\u001a\u00020\u00072\u0006\u00103\u001a\u0002002\u0006\u00102\u001a\u00020\bH\u0002J\u001d\u00107\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b5\u00106J0\u0010;\u001a\u00020\u00072\u0006\u00109\u001a\u0002082\u0006\u0010\t\u001a\u00020\b2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0002JC\u0010;\u001a\u00020\u0007\"\u0006\b\u0000\u0010\u0010\u0018\u00012\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<2\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00020\u00070\u0005H\bø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b>\u0010?J\u001f\u0010B\u001a\u00020\b2\n\u0010=\u001a\u0006\u0012\u0002\b\u00030<ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b@\u0010AJ.\u0010E\u001a\u0004\u0018\u00018\u0000\"\u0006\b\u0000\u0010\u0010\u0018\u00012\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<H\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bC\u0010DJ)\u0010G\u001a\u0004\u0018\u00018\u0000\"\u0004\b\u0000\u0010\u00102\f\u0010=\u001a\b\u0012\u0004\u0012\u00028\u00000<ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bF\u0010DJ\u0006\u0010H\u001a\u00020\bJ\u000f\u0010K\u001a\u00020\u0007H\u0010¢\u0006\u0004\bI\u0010JJ\u0019\u0010P\u001a\u00020\u00072\b\u0010M\u001a\u0004\u0018\u00010LH\u0000¢\u0006\u0004\bN\u0010OJ\u0010\u0010S\u001a\u00020\u00072\u0006\u0010R\u001a\u00020QH\u0004J\u0010\u0010T\u001a\u00020Q2\u0006\u0010M\u001a\u00020LH&J\u0018\u0010W\u001a\u00020\u00072\u0006\u0010U\u001a\u0002082\u0006\u0010V\u001a\u000208H\u0014J\u0006\u0010X\u001a\u00020\u0007J\u0006\u0010Y\u001a\u00020\u0007J@\u0010`\u001a\u00020\u00072\u0006\u0010[\u001a\u00020Z2\u0006\u0010\\\u001a\u00020\u001c2\u0019\u0010_\u001a\u0015\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b^H\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b`\u0010aJ\u000e\u0010b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006J\u0010\u0010c\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0016J\u0006\u0010d\u001a\u00020\u0007J\u0011\u0010e\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u0006H\u0002J!\u0010f\u001a\u00020\u00072\u0019\u0010_\u001a\u0015\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b^JQ\u0010i\u001a\u00020\u0007\"\b\b\u0000\u0010\u0010*\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bg\u0010hJS\u0010k\u001a\u00020\u0007\"\b\b\u0000\u0010\u0010*\u00020\u000f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00028\u00000\u00112\u0006\u0010\u0014\u001a\u00020\u00132\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00152\u0006\u0010\u0017\u001a\u00020\b2\u0006\u0010\u0018\u001a\u00020\bH\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bj\u0010hJ\u0006\u0010m\u001a\u00020lJ\u001d\u0010p\u001a\u00020\u00132\u0006\u0010n\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bo\u00106J\u001d\u0010s\u001a\u00020\u00132\u0006\u0010q\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\br\u00106J%\u0010x\u001a\u00020\u00132\u0006\u0010t\u001a\u00020\u00032\u0006\u0010u\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\bv\u0010wJ%\u0010{\u001a\u00020\u00072\u0006\u0010t\u001a\u00020\u00032\u0006\u0010&\u001a\u00020%H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\by\u0010zJ\u0018\u0010|\u001a\u00020l2\u0006\u0010t\u001a\u00020\u00032\u0006\u00102\u001a\u00020\bH\u0016J\u001d\u0010~\u001a\u00020\u00132\u0006\u0010q\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b}\u00106J\u001e\u0010\u0001\u001a\u00020\u00132\u0006\u0010[\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u00106J\u001f\u0010\u0001\u001a\u00020\u00132\u0006\u0010[\u001a\u00020\u0013H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0001\u00106J\u001b\u0010\u0001\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\u00062\b\u0010\u0001\u001a\u00030\u0001H\u0004J\t\u0010\u0001\u001a\u00020\u0007H\u0016J\t\u0010\u0001\u001a\u00020\u0007H\u0016J-\u0010\u0001\u001a\u00020\u00072\u0006\u00103\u001a\u0002002\u0006\u00102\u001a\u00020\b2\t\b\u0002\u0010\u0001\u001a\u00020\bH\u0000¢\u0006\u0006\b\u0001\u0010\u0001J \u0010\u0001\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J \u0010\u0001\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u0013H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0007H\u0016J\u001e\u0010\u0001\u001a\u00020\u00072\u0006\u00101\u001a\u00020lH@ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001J\t\u0010\u0001\u001a\u00020\u0007H\u0016J\u001b\u0010\u0001\u001a\u00020\u00002\u0007\u0010\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0006\b\u0001\u0010\u0001J\u0007\u0010\u0001\u001a\u00020\bJ\"\u0010\u0001\u001a\u00030\u00012\b\u0010\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0005\b\u0001\u00106J*\u0010\u0001\u001a\u00020\u001c2\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0001\u001a\u00030\u0001H\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0006\b\u0001\u0010\u0001R \u0010\u0001\u001a\u00030\u00018\u0016X\u0004¢\u0006\u0010\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b \u0001\u0010¡\u0001R+\u0010¢\u0001\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u000e¢\u0006\u0018\n\u0006\b¢\u0001\u0010£\u0001\u001a\u0006\b¤\u0001\u0010¥\u0001\"\u0006\b¦\u0001\u0010§\u0001R+\u0010¨\u0001\u001a\u0004\u0018\u00010\u00008\u0000@\u0000X\u000e¢\u0006\u0018\n\u0006\b¨\u0001\u0010£\u0001\u001a\u0006\b©\u0001\u0010¥\u0001\"\u0006\bª\u0001\u0010§\u0001R\u0019\u0010«\u0001\u001a\u00020\b8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001RN\u0010_\u001a\u0015\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b^2\u001a\u0010­\u0001\u001a\u0015\u0012\u0004\u0012\u00020]\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0005¢\u0006\u0002\b^8\u0004@BX\u000e¢\u0006\u000f\n\u0005\b_\u0010®\u0001\u001a\u0006\b¯\u0001\u0010°\u0001R\u001a\u0010²\u0001\u001a\u00030±\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b²\u0001\u0010³\u0001R\u001a\u0010µ\u0001\u001a\u00030´\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u0019\u0010·\u0001\u001a\u00020\u001c8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R\u001c\u0010º\u0001\u001a\u0005\u0018\u00010¹\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R,\u0010R\u001a\u0004\u0018\u00010Q2\t\u0010­\u0001\u001a\u0004\u0018\u00010Q8\u0000@BX\u000e¢\u0006\u000f\n\u0005\bR\u0010¼\u0001\u001a\u0006\b½\u0001\u0010¾\u0001R)\u0010Á\u0001\u001a\u0012\u0012\u0005\u0012\u00030À\u0001\u0012\u0004\u0012\u000208\u0018\u00010¿\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R9\u0010[\u001a\u00020Z2\u0007\u0010­\u0001\u001a\u00020Z8\u0016@TX\u000eø\u0001\u0001ø\u0001\u0000ø\u0001\u0003¢\u0006\u0017\n\u0005\b[\u0010Ã\u0001\u001a\u0006\bÄ\u0001\u0010Å\u0001\"\u0006\bÆ\u0001\u0010Ç\u0001R0\u0010\\\u001a\u00020\u001c2\u0007\u0010­\u0001\u001a\u00020\u001c8\u0006@DX\u000e¢\u0006\u0017\n\u0005\b\\\u0010¸\u0001\u001a\u0006\bÈ\u0001\u0010É\u0001\"\u0006\bÊ\u0001\u0010Ë\u0001R\u001b\u0010Ì\u0001\u001a\u0004\u0018\u0001008\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001c\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u001e\u0010Ò\u0001\u001a\t\u0012\u0004\u0012\u00020\u00070Ñ\u00018\u0002X\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010Ó\u0001R*\u0010Ô\u0001\u001a\u00020\b2\u0007\u0010­\u0001\u001a\u00020\b8\u0000@BX\u000e¢\u0006\u0010\n\u0006\bÔ\u0001\u0010¬\u0001\u001a\u0006\bÕ\u0001\u0010Ö\u0001R0\u0010Ø\u0001\u001a\u0005\u0018\u00010×\u00012\n\u0010­\u0001\u001a\u0005\u0018\u00010×\u00018\u0006@BX\u000e¢\u0006\u0010\n\u0006\bØ\u0001\u0010Ù\u0001\u001a\u0006\bÚ\u0001\u0010Û\u0001R\u0018\u0010ß\u0001\u001a\u00030Ü\u00018BX\u0004¢\u0006\b\u001a\u0006\bÝ\u0001\u0010Þ\u0001R\u0017\u0010â\u0001\u001a\u00020\n8&X¦\u0004¢\u0006\b\u001a\u0006\bà\u0001\u0010á\u0001R\u0018\u0010å\u0001\u001a\u00030´\u00018VX\u0004¢\u0006\b\u001a\u0006\bã\u0001\u0010ä\u0001R\u0017\u0010ç\u0001\u001a\u00020\u001c8VX\u0004¢\u0006\b\u001a\u0006\bæ\u0001\u0010É\u0001R\u0017\u0010é\u0001\u001a\u00020\u001c8VX\u0004¢\u0006\b\u001a\u0006\bè\u0001\u0010É\u0001R\u0019\u0010ì\u0001\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\b\u001a\u0006\bê\u0001\u0010ë\u0001R\u0017\u0010ï\u0001\u001a\u00020\u00038VX\u0004¢\u0006\b\u001a\u0006\bí\u0001\u0010î\u0001R\u001e\u0010ò\u0001\u001a\u00030ð\u00018Fø\u0001\u0001ø\u0001\u0000ø\u0001\u0003¢\u0006\b\u001a\u0006\bñ\u0001\u0010Å\u0001R\u0018\u0010ö\u0001\u001a\u00030ó\u00018VX\u0004¢\u0006\b\u001a\u0006\bô\u0001\u0010õ\u0001R\u0019\u0010ø\u0001\u001a\u0004\u0018\u00010\u00018VX\u0004¢\u0006\b\u001a\u0006\b÷\u0001\u0010ë\u0001R\u0017\u0010ú\u0001\u001a\u00020\b8VX\u0004¢\u0006\b\u001a\u0006\bù\u0001\u0010Ö\u0001R\u0017\u0010û\u0001\u001a\u00020\b8VX\u0004¢\u0006\b\u001a\u0006\bû\u0001\u0010Ö\u0001R,\u0010\u0002\u001a\u00030¹\u00012\b\u0010ü\u0001\u001a\u00030¹\u00018P@PX\u000e¢\u0006\u0010\u001a\u0006\bý\u0001\u0010þ\u0001\"\u0006\bÿ\u0001\u0010\u0002R\u001f\u0010\u0002\u001a\n\u0012\u0005\u0012\u00030À\u00010\u00028VX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002R\u001a\u0010\u0002\u001a\u0005\u0018\u00010\u00028VX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\b\u001a\u0006\b\u0002\u0010î\u0001R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038F¢\u0006\b\u001a\u0006\b\u0002\u0010î\u0001R\u0017\u0010\u0002\u001a\u0002008DX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010\u0002R\u0017\u0010\u0002\u001a\u00020\b8VX\u0004¢\u0006\b\u001a\u0006\b\u0002\u0010Ö\u0001R\u001e\u0010\u0001\u001a\u00030\u00018Fø\u0001\u0001ø\u0001\u0000ø\u0001\u0003¢\u0006\b\u001a\u0006\b\u0002\u0010Å\u0001\u0002\u0016\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0005\b20\u0001\n\u0002\b!¨\u0006\u0002"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator;", "Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "Landroidx/compose/ui/layout/Measurable;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "Landroidx/compose/ui/node/OwnerScope;", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/Canvas;", "", "", "includeTail", "Landroidx/compose/ui/Modifier$Node;", "headNode", "canvas", "drawContainedDrawModifiers", "updateLayerParameters", "Landroidx/compose/ui/node/DelegatableNode;", "T", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "hitTestSource", "Landroidx/compose/ui/geometry/Offset;", "pointerPosition", "Landroidx/compose/ui/node/HitTestResult;", "hitTestResult", "isTouchEvent", "isInLayer", "hit-1hIXUjU", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hit", "", "distanceFromEdge", "hitNear-JHbHoSQ", "(Landroidx/compose/ui/node/DelegatableNode;Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZF)V", "hitNear", "speculativeHit-JHbHoSQ", "speculativeHit", "toCoordinator", "ancestor", "Landroidx/compose/ui/graphics/Matrix;", "matrix", "transformToAncestor-EL8BTi8", "(Landroidx/compose/ui/node/NodeCoordinator;[F)V", "transformToAncestor", "transformFromAncestor-EL8BTi8", "transformFromAncestor", "offset", "ancestorToLocal-R5De75A", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "ancestorToLocal", "Landroidx/compose/ui/geometry/MutableRect;", "rect", "clipBounds", "bounds", "fromParentRect", "offsetFromEdge-MK-Hz9U", "(J)J", "offsetFromEdge", "", "mask", "block", "visitNodes", "Landroidx/compose/ui/node/NodeKind;", "type", "visitNodes-aLcG6gQ", "(ILkotlin/jvm/functions/Function1;)V", "hasNode-H91voCI", "(I)Z", "hasNode", "head-H91voCI", "(I)Ljava/lang/Object;", "head", "headUnchecked-H91voCI", "headUnchecked", "isTransparent", "replace$ui_release", "()V", "replace", "Landroidx/compose/ui/layout/LookaheadScope;", "scope", "updateLookaheadScope$ui_release", "(Landroidx/compose/ui/layout/LookaheadScope;)V", "updateLookaheadScope", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "o", "createLookaheadDelegate", "width", "height", "m", "onMeasured", "onInitialize", "Landroidx/compose/ui/unit/IntOffset;", "position", "zIndex", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "layerBlock", "d", "(JFLkotlin/jvm/functions/Function1;)V", "draw", "performDraw", "onPlaced", "invoke", "onLayerBlockUpdated", "hitTest-YqVAtuI", "(Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTest", "hitTestChild-YqVAtuI", "hitTestChild", "Landroidx/compose/ui/geometry/Rect;", "touchBoundsInRoot", "relativeToWindow", "windowToLocal-MK-Hz9U", "windowToLocal", "relativeToLocal", "localToWindow-MK-Hz9U", "localToWindow", "sourceCoordinates", "relativeToSource", "localPositionOf-R5De75A", "(Landroidx/compose/ui/layout/LayoutCoordinates;J)J", "localPositionOf", "transformFrom-EL8BTi8", "(Landroidx/compose/ui/layout/LayoutCoordinates;[F)V", "transformFrom", "localBoundingBoxOf", "localToRoot-MK-Hz9U", "localToRoot", "toParentPosition-MK-Hz9U", "toParentPosition", "fromParentPosition-MK-Hz9U", "fromParentPosition", "Landroidx/compose/ui/graphics/Paint;", "paint", "j", "attach", "detach", "clipToMinimumTouchTargetSize", "rectInParent$ui_release", "(Landroidx/compose/ui/geometry/MutableRect;ZZ)V", "rectInParent", "p", "(J)Z", "l", "invalidateLayer", "propagateRelocationRequest", "(Landroidx/compose/ui/geometry/Rect;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onLayoutModifierNodeChanged", "other", "findCommonAncestor$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)Landroidx/compose/ui/node/NodeCoordinator;", "findCommonAncestor", "shouldSharePointerInputWithSiblings", "Landroidx/compose/ui/geometry/Size;", "minimumTouchTargetSize", "h", "i", "(JJ)F", "Landroidx/compose/ui/node/LayoutNode;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "getLayoutNode", "()Landroidx/compose/ui/node/LayoutNode;", "wrapped", "Landroidx/compose/ui/node/NodeCoordinator;", "getWrapped$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "setWrapped$ui_release", "(Landroidx/compose/ui/node/NodeCoordinator;)V", "wrappedBy", "getWrappedBy$ui_release", "setWrappedBy$ui_release", "isClipping", "Z", "<set-?>", "Lkotlin/jvm/functions/Function1;", "getLayerBlock", "()Lkotlin/jvm/functions/Function1;", "Landroidx/compose/ui/unit/Density;", "layerDensity", "Landroidx/compose/ui/unit/Density;", "Landroidx/compose/ui/unit/LayoutDirection;", "layerLayoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "lastLayerAlpha", "F", "Landroidx/compose/ui/layout/MeasureResult;", "_measureResult", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/node/LookaheadDelegate;", "getLookaheadDelegate$ui_release", "()Landroidx/compose/ui/node/LookaheadDelegate;", "", "Landroidx/compose/ui/layout/AlignmentLine;", "oldAlignmentLines", "Ljava/util/Map;", "J", "getPosition-nOcc-ac", "()J", "setPosition--gyyYBs", "(J)V", "getZIndex", "()F", "setZIndex", "(F)V", "_rectCache", "Landroidx/compose/ui/geometry/MutableRect;", "Landroidx/compose/ui/node/LayerPositionalProperties;", "layerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "Lkotlin/Function0;", "invalidateParentLayer", "Lkotlin/jvm/functions/Function0;", "lastLayerDrawingWasSkipped", "getLastLayerDrawingWasSkipped$ui_release", "()Z", "Landroidx/compose/ui/node/OwnedLayer;", "layer", "Landroidx/compose/ui/node/OwnedLayer;", "getLayer", "()Landroidx/compose/ui/node/OwnedLayer;", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "snapshotObserver", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "tail", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getDensity", "density", "getFontScale", "fontScale", "getParent", "()Landroidx/compose/ui/node/LookaheadCapablePlaceable;", "parent", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "coordinates", "Landroidx/compose/ui/unit/IntSize;", "getSize-YbymL2g", "size", "Landroidx/compose/ui/node/AlignmentLinesOwner;", "getAlignmentLinesOwner", "()Landroidx/compose/ui/node/AlignmentLinesOwner;", "alignmentLinesOwner", "getChild", "child", "getHasMeasureResult", "hasMeasureResult", "isAttached", "value", "getMeasureResult$ui_release", "()Landroidx/compose/ui/layout/MeasureResult;", "setMeasureResult$ui_release", "(Landroidx/compose/ui/layout/MeasureResult;)V", "measureResult", "", "getProvidedAlignmentLines", "()Ljava/util/Set;", "providedAlignmentLines", "", "getParentData", "()Ljava/lang/Object;", "parentData", "getParentLayoutCoordinates", "parentLayoutCoordinates", "getParentCoordinates", "parentCoordinates", "k", "()Landroidx/compose/ui/geometry/MutableRect;", "rectCache", "isValid", "getMinimumTouchTargetSize-NH-jbRc", "<init>", "(Landroidx/compose/ui/node/LayoutNode;)V", "Companion", "HitTestSource", "ui_release"}, k = 1, mv = {1, 7, 1})
public abstract class NodeCoordinator extends LookaheadCapablePlaceable implements Measurable, LayoutCoordinates, OwnerScope, Function1<Canvas, Unit> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String ExpectAttachedLayoutCoordinates = "LayoutCoordinate operations are only valid when isAttached is true";
    /* access modifiers changed from: private */
    @NotNull
    public static final HitTestSource<PointerInputModifierNode> PointerInputSource = new NodeCoordinator$Companion$PointerInputSource$1();
    /* access modifiers changed from: private */
    @NotNull
    public static final HitTestSource<SemanticsModifierNode> SemanticsSource = new NodeCoordinator$Companion$SemanticsSource$1();
    @NotNull
    public static final String UnmeasuredError = "Asking for measurement result of unmeasured layout modifier";
    /* access modifiers changed from: private */
    @NotNull
    public static final ReusableGraphicsLayerScope graphicsLayerScope = new ReusableGraphicsLayerScope();
    @NotNull
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayer = NodeCoordinator$Companion$onCommitAffectingLayer$1.INSTANCE;
    @NotNull
    private static final Function1<NodeCoordinator, Unit> onCommitAffectingLayerParams = NodeCoordinator$Companion$onCommitAffectingLayerParams$1.INSTANCE;
    /* access modifiers changed from: private */
    @NotNull
    public static final LayerPositionalProperties tmpLayerPositionalProperties = new LayerPositionalProperties();
    @NotNull
    private static final float[] tmpMatrix = Matrix.m3100constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
    @Nullable
    private MeasureResult _measureResult;
    @Nullable
    private MutableRect _rectCache;
    @NotNull
    private final Function0<Unit> invalidateParentLayer = new NodeCoordinator$invalidateParentLayer$1(this);
    private boolean isClipping;
    private float lastLayerAlpha = 0.8f;
    private boolean lastLayerDrawingWasSkipped;
    @Nullable
    private OwnedLayer layer;
    @Nullable
    private Function1<? super GraphicsLayerScope, Unit> layerBlock;
    @NotNull
    private Density layerDensity = getLayoutNode().getDensity();
    @NotNull
    private LayoutDirection layerLayoutDirection = getLayoutNode().getLayoutDirection();
    /* access modifiers changed from: private */
    @Nullable
    public LayerPositionalProperties layerPositionalProperties;
    @NotNull
    private final LayoutNode layoutNode;
    @Nullable
    private LookaheadDelegate lookaheadDelegate;
    @Nullable
    private Map<AlignmentLine, Integer> oldAlignmentLines;
    private long position = IntOffset.Companion.m5606getZeronOccac();
    @Nullable
    private NodeCoordinator wrapped;
    @Nullable
    private NodeCoordinator wrappedBy;
    private float zIndex;

    @Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\b\u0010\u0002\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\nR\u000e\u0010\u000e\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00140\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u0019\u0010\u0018\u001a\u00020\u0019X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010\u001a\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$Companion;", "", "()V", "ExpectAttachedLayoutCoordinates", "", "PointerInputSource", "Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "getPointerInputSource$annotations", "getPointerInputSource", "()Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "SemanticsSource", "Landroidx/compose/ui/node/SemanticsModifierNode;", "getSemanticsSource", "UnmeasuredError", "graphicsLayerScope", "Landroidx/compose/ui/graphics/ReusableGraphicsLayerScope;", "onCommitAffectingLayer", "Lkotlin/Function1;", "Landroidx/compose/ui/node/NodeCoordinator;", "", "onCommitAffectingLayerParams", "tmpLayerPositionalProperties", "Landroidx/compose/ui/node/LayerPositionalProperties;", "tmpMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getPointerInputSource$annotations() {
        }

        @NotNull
        public final HitTestSource<PointerInputModifierNode> getPointerInputSource() {
            return NodeCoordinator.PointerInputSource;
        }

        @NotNull
        public final HitTestSource<SemanticsModifierNode> getSemanticsSource() {
            return NodeCoordinator.SemanticsSource;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003JC\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH&ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0012H&ø\u0001\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0013\u0010\u0014J\u0015\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\u0007H&ø\u0001\u0003\u0002\u0015\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019\n\u0002\b!\n\u0004\b!0\u0001¨\u0006\u001aÀ\u0006\u0001"}, d2 = {"Landroidx/compose/ui/node/NodeCoordinator$HitTestSource;", "N", "Landroidx/compose/ui/node/DelegatableNode;", "", "childHitTest", "", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "isTouchEvent", "", "isInLayer", "childHitTest-YqVAtuI", "(Landroidx/compose/ui/node/LayoutNode;JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "entityType", "Landroidx/compose/ui/node/NodeKind;", "entityType-OLwlOKw", "()I", "interceptOutOfBoundsChildEvents", "node", "(Landroidx/compose/ui/node/DelegatableNode;)Z", "shouldHitTestChildren", "parentLayoutNode", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface HitTestSource<N extends DelegatableNode> {
        /* renamed from: childHitTest-YqVAtuI  reason: not valid java name */
        void m4740childHitTestYqVAtuI(@NotNull LayoutNode layoutNode, long j11, @NotNull HitTestResult<N> hitTestResult, boolean z11, boolean z12);

        /* renamed from: entityType-OLwlOKw  reason: not valid java name */
        int m4741entityTypeOLwlOKw();

        boolean interceptOutOfBoundsChildEvents(@NotNull N n11);

        boolean shouldHitTestChildren(@NotNull LayoutNode layoutNode);
    }

    public NodeCoordinator(@NotNull LayoutNode layoutNode2) {
        Intrinsics.checkNotNullParameter(layoutNode2, "layoutNode");
        this.layoutNode = layoutNode2;
    }

    private final void ancestorToLocal(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z11) {
        if (nodeCoordinator != this) {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                nodeCoordinator2.ancestorToLocal(nodeCoordinator, mutableRect, z11);
            }
            fromParentRect(mutableRect, z11);
        }
    }

    /* renamed from: ancestorToLocal-R5De75A  reason: not valid java name */
    private final long m4712ancestorToLocalR5De75A(NodeCoordinator nodeCoordinator, long j11) {
        if (nodeCoordinator == this) {
            return j11;
        }
        NodeCoordinator nodeCoordinator2 = this.wrappedBy;
        if (nodeCoordinator2 == null || Intrinsics.areEqual((Object) nodeCoordinator, (Object) nodeCoordinator2)) {
            return m4719fromParentPositionMKHz9U(j11);
        }
        return m4719fromParentPositionMKHz9U(nodeCoordinator2.m4712ancestorToLocalR5De75A(nodeCoordinator, j11));
    }

    /* access modifiers changed from: private */
    public final void drawContainedDrawModifiers(Canvas canvas) {
        int r02 = Nodes.INSTANCE.m4758getDrawOLwlOKw();
        boolean r12 = NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(r02);
        DrawModifierNode drawModifierNode = null;
        Modifier.Node tail = getTail();
        if (r12 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r12);
            while (true) {
                if (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r02) != 0) {
                    if ((access$headNode.getKindSet$ui_release() & r02) == 0) {
                        if (access$headNode == tail) {
                            break;
                        }
                        access$headNode = access$headNode.getChild$ui_release();
                    } else {
                        if (access$headNode instanceof DrawModifierNode) {
                            drawModifierNode = access$headNode;
                        }
                        drawModifierNode = drawModifierNode;
                    }
                } else {
                    break;
                }
            }
        }
        DrawModifierNode drawModifierNode2 = drawModifierNode;
        if (drawModifierNode2 == null) {
            performDraw(canvas);
            return;
        }
        getLayoutNode().getMDrawScope$ui_release().m4628drawx_KDEd0$ui_release(canvas, IntSizeKt.m5648toSizeozmzZPI(m4722getSizeYbymL2g()), this, drawModifierNode2);
    }

    private final void fromParentRect(MutableRect mutableRect, boolean z11) {
        float r02 = (float) IntOffset.m5596getXimpl(m4721getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() - r02);
        mutableRect.setRight(mutableRect.getRight() - r02);
        float r03 = (float) IntOffset.m5597getYimpl(m4721getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() - r03);
        mutableRect.setBottom(mutableRect.getBottom() - r03);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.mapBounds(mutableRect, true);
            if (this.isClipping && z11) {
                mutableRect.intersect(0.0f, 0.0f, (float) IntSize.m5638getWidthimpl(m4722getSizeYbymL2g()), (float) IntSize.m5637getHeightimpl(m4722getSizeYbymL2g()));
                mutableRect.isEmpty();
            }
        }
    }

    private final OwnerSnapshotObserver getSnapshotObserver() {
        return LayoutNodeKt.requireOwner(getLayoutNode()).getSnapshotObserver();
    }

    /* access modifiers changed from: private */
    public final Modifier.Node headNode(boolean z11) {
        Modifier.Node tail;
        if (getLayoutNode().getOuterCoordinator$ui_release() == this) {
            return getLayoutNode().getNodes$ui_release().getHead$ui_release();
        }
        if (z11) {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (!(nodeCoordinator == null || (tail = nodeCoordinator.getTail()) == null)) {
                return tail.getChild$ui_release();
            }
        } else {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            if (nodeCoordinator2 != null) {
                return nodeCoordinator2.getTail();
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: hit-1hIXUjU  reason: not valid java name */
    public final <T extends DelegatableNode> void m4713hit1hIXUjU(T t11, HitTestSource<T> hitTestSource, long j11, HitTestResult<T> hitTestResult, boolean z11, boolean z12) {
        if (t11 == null) {
            m4727hitTestChildYqVAtuI(hitTestSource, j11, hitTestResult, z11, z12);
            return;
        }
        hitTestResult.hit(t11, z12, new NodeCoordinator$hit$1(this, t11, hitTestSource, j11, hitTestResult, z11, z12));
    }

    /* access modifiers changed from: private */
    /* renamed from: hitNear-JHbHoSQ  reason: not valid java name */
    public final <T extends DelegatableNode> void m4714hitNearJHbHoSQ(T t11, HitTestSource<T> hitTestSource, long j11, HitTestResult<T> hitTestResult, boolean z11, boolean z12, float f11) {
        if (t11 == null) {
            m4727hitTestChildYqVAtuI(hitTestSource, j11, hitTestResult, z11, z12);
            return;
        }
        float f12 = f11;
        hitTestResult.hitInMinimumTouchTarget(t11, f12, z12, new NodeCoordinator$hitNear$1(this, t11, hitTestSource, j11, hitTestResult, z11, z12, f11));
    }

    public static /* synthetic */ Object n(NodeCoordinator nodeCoordinator, Rect rect, Continuation continuation) {
        NodeCoordinator nodeCoordinator2 = nodeCoordinator.wrappedBy;
        if (nodeCoordinator2 == null) {
            return Unit.INSTANCE;
        }
        Object propagateRelocationRequest = nodeCoordinator2.propagateRelocationRequest(rect.m2713translatek4lQ0M(nodeCoordinator2.localBoundingBoxOf(nodeCoordinator, false).m2711getTopLeftF1C5BW0()), continuation);
        if (propagateRelocationRequest == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
            return propagateRelocationRequest;
        }
        return Unit.INSTANCE;
    }

    /* renamed from: offsetFromEdge-MK-Hz9U  reason: not valid java name */
    private final long m4715offsetFromEdgeMKHz9U(long j11) {
        float f11;
        float f12;
        float r02 = Offset.m2676getXimpl(j11);
        if (r02 < 0.0f) {
            f11 = -r02;
        } else {
            f11 = r02 - ((float) getMeasuredWidth());
        }
        float max = Math.max(0.0f, f11);
        float r42 = Offset.m2677getYimpl(j11);
        if (r42 < 0.0f) {
            f12 = -r42;
        } else {
            f12 = r42 - ((float) getMeasuredHeight());
        }
        return OffsetKt.Offset(max, Math.max(0.0f, f12));
    }

    public static /* synthetic */ void rectInParent$ui_release$default(NodeCoordinator nodeCoordinator, MutableRect mutableRect, boolean z11, boolean z12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 4) != 0) {
                z12 = false;
            }
            nodeCoordinator.rectInParent$ui_release(mutableRect, z11, z12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: rectInParent");
    }

    /* access modifiers changed from: private */
    /* renamed from: speculativeHit-JHbHoSQ  reason: not valid java name */
    public final <T extends DelegatableNode> void m4716speculativeHitJHbHoSQ(T t11, HitTestSource<T> hitTestSource, long j11, HitTestResult<T> hitTestResult, boolean z11, boolean z12, float f11) {
        if (t11 == null) {
            m4727hitTestChildYqVAtuI(hitTestSource, j11, hitTestResult, z11, z12);
            return;
        }
        HitTestSource<T> hitTestSource2 = hitTestSource;
        if (hitTestSource.interceptOutOfBoundsChildEvents(t11)) {
            boolean z13 = z12;
            float f12 = f11;
            hitTestResult.speculativeHit(t11, f12, z13, new NodeCoordinator$speculativeHit$1(this, t11, hitTestSource, j11, hitTestResult, z11, z13, f12));
            return;
        }
        HitTestResult<T> hitTestResult2 = hitTestResult;
        m4716speculativeHitJHbHoSQ((DelegatableNode) NodeCoordinatorKt.m4743nextUncheckedUntilhw7D004(t11, hitTestSource.m4741entityTypeOLwlOKw(), Nodes.INSTANCE.m4761getLayoutOLwlOKw()), hitTestSource, j11, hitTestResult, z11, z12, f11);
    }

    private final NodeCoordinator toCoordinator(LayoutCoordinates layoutCoordinates) {
        NodeCoordinator coordinator;
        LookaheadLayoutCoordinatesImpl lookaheadLayoutCoordinatesImpl = layoutCoordinates instanceof LookaheadLayoutCoordinatesImpl ? (LookaheadLayoutCoordinatesImpl) layoutCoordinates : null;
        if (lookaheadLayoutCoordinatesImpl != null && (coordinator = lookaheadLayoutCoordinatesImpl.getCoordinator()) != null) {
            return coordinator;
        }
        Intrinsics.checkNotNull(layoutCoordinates, "null cannot be cast to non-null type androidx.compose.ui.node.NodeCoordinator");
        return (NodeCoordinator) layoutCoordinates;
    }

    /* renamed from: transformFromAncestor-EL8BTi8  reason: not valid java name */
    private final void m4717transformFromAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        if (!Intrinsics.areEqual((Object) nodeCoordinator, (Object) this)) {
            NodeCoordinator nodeCoordinator2 = this.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
            nodeCoordinator2.m4717transformFromAncestorEL8BTi8(nodeCoordinator, fArr);
            if (!IntOffset.m5595equalsimpl0(m4721getPositionnOccac(), IntOffset.Companion.m5606getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m3109resetimpl(fArr2);
                Matrix.m3120translateimpl$default(fArr2, -((float) IntOffset.m5596getXimpl(m4721getPositionnOccac())), -((float) IntOffset.m5597getYimpl(m4721getPositionnOccac())), 0.0f, 4, (Object) null);
                Matrix.m3117timesAssign58bKbWc(fArr, fArr2);
            }
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m4767inverseTransform58bKbWc(fArr);
            }
        }
    }

    /* renamed from: transformToAncestor-EL8BTi8  reason: not valid java name */
    private final void m4718transformToAncestorEL8BTi8(NodeCoordinator nodeCoordinator, float[] fArr) {
        NodeCoordinator nodeCoordinator2 = this;
        while (!Intrinsics.areEqual((Object) nodeCoordinator2, (Object) nodeCoordinator)) {
            OwnedLayer ownedLayer = nodeCoordinator2.layer;
            if (ownedLayer != null) {
                ownedLayer.m4772transform58bKbWc(fArr);
            }
            long r12 = nodeCoordinator2.m4721getPositionnOccac();
            if (!IntOffset.m5595equalsimpl0(r12, IntOffset.Companion.m5606getZeronOccac())) {
                float[] fArr2 = tmpMatrix;
                Matrix.m3109resetimpl(fArr2);
                Matrix.m3120translateimpl$default(fArr2, (float) IntOffset.m5596getXimpl(r12), (float) IntOffset.m5597getYimpl(r12), 0.0f, 4, (Object) null);
                Matrix.m3117timesAssign58bKbWc(fArr, fArr2);
            }
            nodeCoordinator2 = nodeCoordinator2.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator2);
        }
    }

    /* access modifiers changed from: private */
    public final void updateLayerParameters() {
        boolean z11;
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            Function1<? super GraphicsLayerScope, Unit> function1 = this.layerBlock;
            if (function1 != null) {
                ReusableGraphicsLayerScope reusableGraphicsLayerScope = graphicsLayerScope;
                reusableGraphicsLayerScope.reset();
                reusableGraphicsLayerScope.setGraphicsDensity$ui_release(getLayoutNode().getDensity());
                getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayerParams, new NodeCoordinator$updateLayerParameters$1(function1));
                LayerPositionalProperties layerPositionalProperties2 = this.layerPositionalProperties;
                if (layerPositionalProperties2 == null) {
                    layerPositionalProperties2 = new LayerPositionalProperties();
                    this.layerPositionalProperties = layerPositionalProperties2;
                }
                layerPositionalProperties2.copyFrom((GraphicsLayerScope) reusableGraphicsLayerScope);
                ReusableGraphicsLayerScope reusableGraphicsLayerScope2 = reusableGraphicsLayerScope;
                ownedLayer.m4773updateLayerPropertiesNHXXZp8(reusableGraphicsLayerScope.getScaleX(), reusableGraphicsLayerScope.getScaleY(), reusableGraphicsLayerScope.getAlpha(), reusableGraphicsLayerScope.getTranslationX(), reusableGraphicsLayerScope.getTranslationY(), reusableGraphicsLayerScope.getShadowElevation(), reusableGraphicsLayerScope.getRotationX(), reusableGraphicsLayerScope.getRotationY(), reusableGraphicsLayerScope.getRotationZ(), reusableGraphicsLayerScope.getCameraDistance(), reusableGraphicsLayerScope.m3200getTransformOriginSzJe1aQ(), reusableGraphicsLayerScope.getShape(), reusableGraphicsLayerScope.getClip(), reusableGraphicsLayerScope2.getRenderEffect(), reusableGraphicsLayerScope.m3198getAmbientShadowColor0d7_KjU(), reusableGraphicsLayerScope.m3199getSpotShadowColor0d7_KjU(), getLayoutNode().getLayoutDirection(), getLayoutNode().getDensity());
                this.isClipping = reusableGraphicsLayerScope2.getClip();
            } else {
                throw new IllegalArgumentException("Required value was null.".toString());
            }
        } else {
            if (this.layerBlock == null) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        }
        this.lastLayerAlpha = graphicsLayerScope.getAlpha();
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
    }

    public void attach() {
        onLayerBlockUpdated(this.layerBlock);
    }

    @NotNull
    public abstract LookaheadDelegate createLookaheadDelegate(@NotNull LookaheadScope lookaheadScope);

    public void d(long j11, float f11, @Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        onLayerBlockUpdated(function1);
        if (!IntOffset.m5595equalsimpl0(m4721getPositionnOccac(), j11)) {
            m4731setPositiongyyYBs(j11);
            getLayoutNode().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.m4770movegyyYBs(j11);
            } else {
                NodeCoordinator nodeCoordinator = this.wrappedBy;
                if (nodeCoordinator != null) {
                    nodeCoordinator.invalidateLayer();
                }
            }
            g(this);
            Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
            if (owner$ui_release != null) {
                owner$ui_release.onLayoutChange(getLayoutNode());
            }
        }
        this.zIndex = f11;
    }

    public void detach() {
        onLayerBlockUpdated(this.layerBlock);
        LayoutNode parent$ui_release = getLayoutNode().getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public final void draw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.drawLayer(canvas);
            return;
        }
        float r02 = (float) IntOffset.m5596getXimpl(m4721getPositionnOccac());
        float r12 = (float) IntOffset.m5597getYimpl(m4721getPositionnOccac());
        canvas.translate(r02, r12);
        drawContainedDrawModifiers(canvas);
        canvas.translate(-r02, -r12);
    }

    @NotNull
    public final NodeCoordinator findCommonAncestor$ui_release(@NotNull NodeCoordinator nodeCoordinator) {
        Intrinsics.checkNotNullParameter(nodeCoordinator, "other");
        LayoutNode layoutNode2 = nodeCoordinator.getLayoutNode();
        LayoutNode layoutNode3 = getLayoutNode();
        if (layoutNode2 == layoutNode3) {
            Modifier.Node tail = nodeCoordinator.getTail();
            Modifier.Node tail2 = getTail();
            int r22 = Nodes.INSTANCE.m4761getLayoutOLwlOKw();
            if (tail2.getNode().isAttached()) {
                for (Modifier.Node parent$ui_release = tail2.getNode().getParent$ui_release(); parent$ui_release != null; parent$ui_release = parent$ui_release.getParent$ui_release()) {
                    if ((parent$ui_release.getKindSet$ui_release() & r22) != 0 && parent$ui_release == tail) {
                        return nodeCoordinator;
                    }
                }
                return this;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
        while (layoutNode2.getDepth$ui_release() > layoutNode3.getDepth$ui_release()) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode2);
        }
        while (layoutNode3.getDepth$ui_release() > layoutNode2.getDepth$ui_release()) {
            layoutNode3 = layoutNode3.getParent$ui_release();
            Intrinsics.checkNotNull(layoutNode3);
        }
        while (layoutNode2 != layoutNode3) {
            layoutNode2 = layoutNode2.getParent$ui_release();
            layoutNode3 = layoutNode3.getParent$ui_release();
            if (layoutNode2 != null) {
                if (layoutNode3 == null) {
                }
            }
            throw new IllegalArgumentException("layouts are not part of the same hierarchy");
        }
        if (layoutNode3 == getLayoutNode()) {
            return this;
        }
        if (layoutNode2 == nodeCoordinator.getLayoutNode()) {
            return nodeCoordinator;
        }
        return layoutNode2.getInnerCoordinator$ui_release();
    }

    /* renamed from: fromParentPosition-MK-Hz9U  reason: not valid java name */
    public long m4719fromParentPositionMKHz9U(long j11) {
        long r32 = IntOffsetKt.m5608minusNvtHpc(j11, m4721getPositionnOccac());
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            return ownedLayer.m4769mapOffset8S9VItk(r32, true);
        }
        return r32;
    }

    @NotNull
    public AlignmentLinesOwner getAlignmentLinesOwner() {
        return getLayoutNode().getLayoutDelegate$ui_release().getAlignmentLinesOwner$ui_release();
    }

    @Nullable
    public LookaheadCapablePlaceable getChild() {
        return this.wrapped;
    }

    @NotNull
    public LayoutCoordinates getCoordinates() {
        return this;
    }

    public float getDensity() {
        return getLayoutNode().getDensity().getDensity();
    }

    public float getFontScale() {
        return getLayoutNode().getDensity().getFontScale();
    }

    public boolean getHasMeasureResult() {
        return this._measureResult != null;
    }

    public final boolean getLastLayerDrawingWasSkipped$ui_release() {
        return this.lastLayerDrawingWasSkipped;
    }

    @Nullable
    public final OwnedLayer getLayer() {
        return this.layer;
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return getLayoutNode().getLayoutDirection();
    }

    @NotNull
    public LayoutNode getLayoutNode() {
        return this.layoutNode;
    }

    @Nullable
    public final LookaheadDelegate getLookaheadDelegate$ui_release() {
        return this.lookaheadDelegate;
    }

    @NotNull
    public MeasureResult getMeasureResult$ui_release() {
        MeasureResult measureResult = this._measureResult;
        if (measureResult != null) {
            return measureResult;
        }
        throw new IllegalStateException(UnmeasuredError.toString());
    }

    /* renamed from: getMinimumTouchTargetSize-NH-jbRc  reason: not valid java name */
    public final long m4720getMinimumTouchTargetSizeNHjbRc() {
        return this.layerDensity.m5448toSizeXkaWNTQ(getLayoutNode().getViewConfiguration().m4881getMinimumTouchTargetSizeMYxV2XQ());
    }

    @Nullable
    public LookaheadCapablePlaceable getParent() {
        return this.wrappedBy;
    }

    @Nullable
    public final LayoutCoordinates getParentCoordinates() {
        if (isAttached()) {
            return this.wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    @Nullable
    public Object getParentData() {
        boolean z11;
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        Modifier.Node tail = getTail();
        Density density = getLayoutNode().getDensity();
        for (Modifier.Node tail$ui_release = getLayoutNode().getNodes$ui_release().getTail$ui_release(); tail$ui_release != null; tail$ui_release = tail$ui_release.getParent$ui_release()) {
            if (tail$ui_release != tail) {
                if ((Nodes.INSTANCE.m4764getParentDataOLwlOKw() & tail$ui_release.getKindSet$ui_release()) != 0) {
                    z11 = true;
                } else {
                    z11 = false;
                }
                if (z11 && (tail$ui_release instanceof ParentDataModifierNode)) {
                    objectRef.element = ((ParentDataModifierNode) tail$ui_release).modifyParentData(density, objectRef.element);
                }
            }
        }
        return objectRef.element;
    }

    @Nullable
    public final LayoutCoordinates getParentLayoutCoordinates() {
        if (isAttached()) {
            return getLayoutNode().getOuterCoordinator$ui_release().wrappedBy;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* renamed from: getPosition-nOcc-ac  reason: not valid java name */
    public long m4721getPositionnOccac() {
        return this.position;
    }

    @NotNull
    public Set<AlignmentLine> getProvidedAlignmentLines() {
        Map<AlignmentLine, Integer> map;
        LinkedHashSet linkedHashSet = null;
        for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrapped) {
            MeasureResult measureResult = nodeCoordinator._measureResult;
            if (measureResult != null) {
                map = measureResult.getAlignmentLines();
            } else {
                map = null;
            }
            boolean z11 = false;
            if (map != null && (!map.isEmpty())) {
                z11 = true;
            }
            if (z11) {
                if (linkedHashSet == null) {
                    linkedHashSet = new LinkedHashSet();
                }
                linkedHashSet.addAll(map.keySet());
            }
        }
        if (linkedHashSet == null) {
            return SetsKt__SetsKt.emptySet();
        }
        return linkedHashSet;
    }

    /* renamed from: getSize-YbymL2g  reason: not valid java name */
    public final long m4722getSizeYbymL2g() {
        return b();
    }

    @NotNull
    public abstract Modifier.Node getTail();

    @Nullable
    public final NodeCoordinator getWrapped$ui_release() {
        return this.wrapped;
    }

    @Nullable
    public final NodeCoordinator getWrappedBy$ui_release() {
        return this.wrappedBy;
    }

    public final float getZIndex() {
        return this.zIndex;
    }

    public final long h(long j11) {
        return SizeKt.Size(Math.max(0.0f, (Size.m2745getWidthimpl(j11) - ((float) getMeasuredWidth())) / 2.0f), Math.max(0.0f, (Size.m2742getHeightimpl(j11) - ((float) getMeasuredHeight())) / 2.0f));
    }

    /* renamed from: hasNode-H91voCI  reason: not valid java name */
    public final boolean m4723hasNodeH91voCI(int i11) {
        Modifier.Node headNode = headNode(NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(i11));
        return headNode != null && DelegatableNodeKt.m4584has64DMado(headNode, i11);
    }

    /* renamed from: head-H91voCI  reason: not valid java name */
    public final /* synthetic */ <T> T m4724headH91voCI(int i11) {
        boolean r02 = NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(i11);
        T tail = getTail();
        if (!r02 && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        T access$headNode = headNode(r02);
        while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i11) != 0) {
            if ((access$headNode.getKindSet$ui_release() & i11) != 0) {
                Intrinsics.reifiedOperationMarker(2, "T");
                return access$headNode;
            } else if (access$headNode == tail) {
                return null;
            } else {
                access$headNode = access$headNode.getChild$ui_release();
            }
        }
        return null;
    }

    @Nullable
    /* renamed from: headUnchecked-H91voCI  reason: not valid java name */
    public final <T> T m4725headUncheckedH91voCI(int i11) {
        boolean r02 = NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(i11);
        T tail = getTail();
        if (!r02 && (tail = tail.getParent$ui_release()) == null) {
            return null;
        }
        T access$headNode = headNode(r02);
        while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i11) != 0) {
            if ((access$headNode.getKindSet$ui_release() & i11) != 0) {
                return access$headNode;
            }
            if (access$headNode == tail) {
                return null;
            }
            access$headNode = access$headNode.getChild$ui_release();
        }
        return null;
    }

    /* renamed from: hitTest-YqVAtuI  reason: not valid java name */
    public final <T extends DelegatableNode> void m4726hitTestYqVAtuI(@NotNull HitTestSource<T> hitTestSource, long j11, @NotNull HitTestResult<T> hitTestResult, boolean z11, boolean z12) {
        float f11;
        long j12 = j11;
        HitTestResult<T> hitTestResult2 = hitTestResult;
        HitTestSource<T> hitTestSource2 = hitTestSource;
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult2, "hitTestResult");
        DelegatableNode delegatableNode = (DelegatableNode) m4725headUncheckedH91voCI(hitTestSource.m4741entityTypeOLwlOKw());
        boolean z13 = true;
        if (!p(j11)) {
            if (z11) {
                float i11 = i(j11, m4720getMinimumTouchTargetSizeNHjbRc());
                if (Float.isInfinite(i11) || Float.isNaN(i11)) {
                    z13 = false;
                }
                if (z13 && hitTestResult2.isHitInMinimumTouchTargetBetter(i11, false)) {
                    m4714hitNearJHbHoSQ(delegatableNode, hitTestSource, j11, hitTestResult, z11, false, i11);
                }
            }
        } else if (delegatableNode == null) {
            m4727hitTestChildYqVAtuI(hitTestSource, j11, hitTestResult, z11, z12);
        } else if (l(j11)) {
            m4713hit1hIXUjU(delegatableNode, hitTestSource, j11, hitTestResult, z11, z12);
        } else {
            if (!z11) {
                f11 = Float.POSITIVE_INFINITY;
            } else {
                f11 = i(j11, m4720getMinimumTouchTargetSizeNHjbRc());
            }
            float f12 = f11;
            if (Float.isInfinite(f12) || Float.isNaN(f12)) {
                z13 = false;
            }
            boolean z14 = z12;
            if (!z13 || !hitTestResult2.isHitInMinimumTouchTargetBetter(f12, z14)) {
                m4716speculativeHitJHbHoSQ(delegatableNode, hitTestSource, j11, hitTestResult, z11, z12, f12);
            } else {
                m4714hitNearJHbHoSQ(delegatableNode, hitTestSource, j11, hitTestResult, z11, z12, f12);
            }
        }
    }

    /* renamed from: hitTestChild-YqVAtuI  reason: not valid java name */
    public <T extends DelegatableNode> void m4727hitTestChildYqVAtuI(@NotNull HitTestSource<T> hitTestSource, long j11, @NotNull HitTestResult<T> hitTestResult, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(hitTestSource, "hitTestSource");
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.m4726hitTestYqVAtuI(hitTestSource, nodeCoordinator.m4719fromParentPositionMKHz9U(j11), hitTestResult, z11, z12);
        }
    }

    public final float i(long j11, long j12) {
        if (((float) getMeasuredWidth()) >= Size.m2745getWidthimpl(j12) && ((float) getMeasuredHeight()) >= Size.m2742getHeightimpl(j12)) {
            return Float.POSITIVE_INFINITY;
        }
        long h11 = h(j12);
        float r02 = Size.m2745getWidthimpl(h11);
        float r62 = Size.m2742getHeightimpl(h11);
        long r42 = m4715offsetFromEdgeMKHz9U(j11);
        if ((r02 > 0.0f || r62 > 0.0f) && Offset.m2676getXimpl(r42) <= r02 && Offset.m2677getYimpl(r42) <= r62) {
            return Offset.m2675getDistanceSquaredimpl(r42);
        }
        return Float.POSITIVE_INFINITY;
    }

    public void invalidateLayer() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
            return;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            nodeCoordinator.invalidateLayer();
        }
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Canvas) obj);
        return Unit.INSTANCE;
    }

    public boolean isAttached() {
        return getTail().isAttached();
    }

    public final boolean isTransparent() {
        if (this.layer != null && this.lastLayerAlpha <= 0.0f) {
            return true;
        }
        NodeCoordinator nodeCoordinator = this.wrappedBy;
        if (nodeCoordinator != null) {
            return nodeCoordinator.isTransparent();
        }
        return false;
    }

    public boolean isValid() {
        return this.layer != null && isAttached();
    }

    public final void j(@NotNull Canvas canvas, @NotNull Paint paint) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        Intrinsics.checkNotNullParameter(paint, "paint");
        canvas.drawRect(new Rect(0.5f, 0.5f, ((float) IntSize.m5638getWidthimpl(b())) - 0.5f, ((float) IntSize.m5637getHeightimpl(b())) - 0.5f), paint);
    }

    @NotNull
    public final MutableRect k() {
        MutableRect mutableRect = this._rectCache;
        if (mutableRect != null) {
            return mutableRect;
        }
        MutableRect mutableRect2 = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
        this._rectCache = mutableRect2;
        return mutableRect2;
    }

    public final boolean l(long j11) {
        float r02 = Offset.m2676getXimpl(j11);
        float r32 = Offset.m2677getYimpl(j11);
        if (r02 < 0.0f || r32 < 0.0f || r02 >= ((float) getMeasuredWidth()) || r32 >= ((float) getMeasuredHeight())) {
            return false;
        }
        return true;
    }

    @NotNull
    public Rect localBoundingBoxOf(@NotNull LayoutCoordinates layoutCoordinates, boolean z11) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        if (!isAttached()) {
            throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
        } else if (layoutCoordinates.isAttached()) {
            NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
            NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
            MutableRect k11 = k();
            k11.setLeft(0.0f);
            k11.setTop(0.0f);
            k11.setRight((float) IntSize.m5638getWidthimpl(layoutCoordinates.m4473getSizeYbymL2g()));
            k11.setBottom((float) IntSize.m5637getHeightimpl(layoutCoordinates.m4473getSizeYbymL2g()));
            while (coordinator != findCommonAncestor$ui_release) {
                rectInParent$ui_release$default(coordinator, k11, z11, false, 4, (Object) null);
                if (k11.isEmpty()) {
                    return Rect.Companion.getZero();
                }
                coordinator = coordinator.wrappedBy;
                Intrinsics.checkNotNull(coordinator);
            }
            ancestorToLocal(findCommonAncestor$ui_release, k11, z11);
            return MutableRectKt.toRect(k11);
        } else {
            throw new IllegalStateException(("LayoutCoordinates " + layoutCoordinates + " is not attached!").toString());
        }
    }

    /* renamed from: localPositionOf-R5De75A  reason: not valid java name */
    public long m4728localPositionOfR5De75A(@NotNull LayoutCoordinates layoutCoordinates, long j11) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        while (coordinator != findCommonAncestor$ui_release) {
            j11 = coordinator.m4732toParentPositionMKHz9U(j11);
            coordinator = coordinator.wrappedBy;
            Intrinsics.checkNotNull(coordinator);
        }
        return m4712ancestorToLocalR5De75A(findCommonAncestor$ui_release, j11);
    }

    /* renamed from: localToRoot-MK-Hz9U  reason: not valid java name */
    public long m4729localToRootMKHz9U(long j11) {
        if (isAttached()) {
            for (NodeCoordinator nodeCoordinator = this; nodeCoordinator != null; nodeCoordinator = nodeCoordinator.wrappedBy) {
                j11 = nodeCoordinator.m4732toParentPositionMKHz9U(j11);
            }
            return j11;
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    /* renamed from: localToWindow-MK-Hz9U  reason: not valid java name */
    public long m4730localToWindowMKHz9U(long j11) {
        return LayoutNodeKt.requireOwner(getLayoutNode()).m4775calculatePositionInWindowMKHz9U(m4729localToRootMKHz9U(j11));
    }

    public void m(int i11, int i12) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.m4771resizeozmzZPI(IntSizeKt.IntSize(i11, i12));
        } else {
            NodeCoordinator nodeCoordinator = this.wrappedBy;
            if (nodeCoordinator != null) {
                nodeCoordinator.invalidateLayer();
            }
        }
        Owner owner$ui_release = getLayoutNode().getOwner$ui_release();
        if (owner$ui_release != null) {
            owner$ui_release.onLayoutChange(getLayoutNode());
        }
        e(IntSizeKt.IntSize(i11, i12));
        int r42 = Nodes.INSTANCE.m4758getDrawOLwlOKw();
        boolean r52 = NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(r42);
        Modifier.Node tail = getTail();
        if (r52 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r52);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r42) != 0) {
                if ((access$headNode.getKindSet$ui_release() & r42) != 0 && (access$headNode instanceof DrawModifierNode)) {
                    ((DrawModifierNode) access$headNode).onMeasureResultChanged();
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final void o(@NotNull LookaheadDelegate lookaheadDelegate2) {
        Intrinsics.checkNotNullParameter(lookaheadDelegate2, "lookaheadDelegate");
        this.lookaheadDelegate = lookaheadDelegate2;
    }

    public final void onInitialize() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onLayerBlockUpdated(@Nullable Function1<? super GraphicsLayerScope, Unit> function1) {
        boolean z11;
        Owner owner$ui_release;
        if (this.layerBlock == function1 && Intrinsics.areEqual((Object) this.layerDensity, (Object) getLayoutNode().getDensity()) && this.layerLayoutDirection == getLayoutNode().getLayoutDirection()) {
            z11 = false;
        } else {
            z11 = true;
        }
        this.layerBlock = function1;
        this.layerDensity = getLayoutNode().getDensity();
        this.layerLayoutDirection = getLayoutNode().getLayoutDirection();
        if (!isAttached() || function1 == null) {
            OwnedLayer ownedLayer = this.layer;
            if (ownedLayer != null) {
                ownedLayer.destroy();
                getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
                this.invalidateParentLayer.invoke();
                if (isAttached() && (owner$ui_release = getLayoutNode().getOwner$ui_release()) != null) {
                    owner$ui_release.onLayoutChange(getLayoutNode());
                }
            }
            this.layer = null;
            this.lastLayerDrawingWasSkipped = false;
        } else if (this.layer == null) {
            OwnedLayer createLayer = LayoutNodeKt.requireOwner(getLayoutNode()).createLayer(this, this.invalidateParentLayer);
            createLayer.m4771resizeozmzZPI(b());
            createLayer.m4770movegyyYBs(m4721getPositionnOccac());
            this.layer = createLayer;
            updateLayerParameters();
            getLayoutNode().setInnerLayerCoordinatorIsDirty$ui_release(true);
            this.invalidateParentLayer.invoke();
        } else if (z11) {
            updateLayerParameters();
        }
    }

    public void onLayoutModifierNodeChanged() {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            ownedLayer.invalidate();
        }
    }

    public final void onMeasured() {
        Snapshot makeCurrent;
        Modifier.Node node;
        Nodes nodes = Nodes.INSTANCE;
        if (m4723hasNodeH91voCI(nodes.m4762getLayoutAwareOLwlOKw())) {
            Snapshot createNonObservableSnapshot = Snapshot.Companion.createNonObservableSnapshot();
            try {
                makeCurrent = createNonObservableSnapshot.makeCurrent();
                int r02 = nodes.m4762getLayoutAwareOLwlOKw();
                boolean r32 = NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(r02);
                if (r32) {
                    node = getTail();
                } else {
                    node = getTail().getParent$ui_release();
                    if (node == null) {
                        Unit unit = Unit.INSTANCE;
                        createNonObservableSnapshot.restoreCurrent(makeCurrent);
                        createNonObservableSnapshot.dispose();
                    }
                }
                Modifier.Node access$headNode = headNode(r32);
                while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r02) != 0) {
                    if ((access$headNode.getKindSet$ui_release() & r02) != 0 && (access$headNode instanceof LayoutAwareModifierNode)) {
                        ((LayoutAwareModifierNode) access$headNode).m4611onRemeasuredozmzZPI(b());
                    }
                    if (access$headNode == node) {
                        break;
                    }
                    access$headNode = access$headNode.getChild$ui_release();
                }
                Unit unit2 = Unit.INSTANCE;
                createNonObservableSnapshot.restoreCurrent(makeCurrent);
                createNonObservableSnapshot.dispose();
            } catch (Throwable th2) {
                createNonObservableSnapshot.dispose();
                throw th2;
            }
        }
    }

    public final void onPlaced() {
        LookaheadDelegate lookaheadDelegate2 = this.lookaheadDelegate;
        if (lookaheadDelegate2 != null) {
            int r12 = Nodes.INSTANCE.m4762getLayoutAwareOLwlOKw();
            boolean r22 = NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(r12);
            Modifier.Node tail = getTail();
            if (r22 || (tail = tail.getParent$ui_release()) != null) {
                Modifier.Node access$headNode = headNode(r22);
                while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r12) != 0) {
                    if ((access$headNode.getKindSet$ui_release() & r12) != 0 && (access$headNode instanceof LayoutAwareModifierNode)) {
                        ((LayoutAwareModifierNode) access$headNode).onLookaheadPlaced(lookaheadDelegate2.getLookaheadLayoutCoordinates());
                    }
                    if (access$headNode == tail) {
                        break;
                    }
                    access$headNode = access$headNode.getChild$ui_release();
                }
            }
        }
        int r02 = Nodes.INSTANCE.m4762getLayoutAwareOLwlOKw();
        boolean r13 = NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(r02);
        Modifier.Node tail2 = getTail();
        if (r13 || (tail2 = tail2.getParent$ui_release()) != null) {
            Modifier.Node access$headNode2 = headNode(r13);
            while (access$headNode2 != null && (access$headNode2.getAggregateChildKindSet$ui_release() & r02) != 0) {
                if ((access$headNode2.getKindSet$ui_release() & r02) != 0 && (access$headNode2 instanceof LayoutAwareModifierNode)) {
                    ((LayoutAwareModifierNode) access$headNode2).onPlaced(this);
                }
                if (access$headNode2 != tail2) {
                    access$headNode2 = access$headNode2.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final boolean p(long j11) {
        if (!OffsetKt.m2693isFinitek4lQ0M(j11)) {
            return false;
        }
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer == null || !this.isClipping || ownedLayer.m4768isInLayerk4lQ0M(j11)) {
            return true;
        }
        return false;
    }

    public void performDraw(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        NodeCoordinator nodeCoordinator = this.wrapped;
        if (nodeCoordinator != null) {
            nodeCoordinator.draw(canvas);
        }
    }

    @Nullable
    public Object propagateRelocationRequest(@NotNull Rect rect, @NotNull Continuation<? super Unit> continuation) {
        return n(this, rect, continuation);
    }

    public final void rectInParent$ui_release(@NotNull MutableRect mutableRect, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(mutableRect, Param.BOUNDS);
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            if (this.isClipping) {
                if (z12) {
                    long r82 = m4720getMinimumTouchTargetSizeNHjbRc();
                    float r12 = Size.m2745getWidthimpl(r82) / 2.0f;
                    float r83 = Size.m2742getHeightimpl(r82) / 2.0f;
                    mutableRect.intersect(-r12, -r83, ((float) IntSize.m5638getWidthimpl(m4722getSizeYbymL2g())) + r12, ((float) IntSize.m5637getHeightimpl(m4722getSizeYbymL2g())) + r83);
                } else if (z11) {
                    mutableRect.intersect(0.0f, 0.0f, (float) IntSize.m5638getWidthimpl(m4722getSizeYbymL2g()), (float) IntSize.m5637getHeightimpl(m4722getSizeYbymL2g()));
                }
                if (mutableRect.isEmpty()) {
                    return;
                }
            }
            ownedLayer.mapBounds(mutableRect, false);
        }
        float r84 = (float) IntOffset.m5596getXimpl(m4721getPositionnOccac());
        mutableRect.setLeft(mutableRect.getLeft() + r84);
        mutableRect.setRight(mutableRect.getRight() + r84);
        float r85 = (float) IntOffset.m5597getYimpl(m4721getPositionnOccac());
        mutableRect.setTop(mutableRect.getTop() + r85);
        mutableRect.setBottom(mutableRect.getBottom() + r85);
    }

    public void replace$ui_release() {
        d(m4721getPositionnOccac(), this.zIndex, this.layerBlock);
    }

    public void setMeasureResult$ui_release(@NotNull MeasureResult measureResult) {
        boolean z11;
        Intrinsics.checkNotNullParameter(measureResult, "value");
        MeasureResult measureResult2 = this._measureResult;
        if (measureResult != measureResult2) {
            this._measureResult = measureResult;
            if (!(measureResult2 != null && measureResult.getWidth() == measureResult2.getWidth() && measureResult.getHeight() == measureResult2.getHeight())) {
                m(measureResult.getWidth(), measureResult.getHeight());
            }
            Map<AlignmentLine, Integer> map = this.oldAlignmentLines;
            if (map == null || map.isEmpty()) {
                z11 = true;
            } else {
                z11 = false;
            }
            if ((!z11 || (!measureResult.getAlignmentLines().isEmpty())) && !Intrinsics.areEqual((Object) measureResult.getAlignmentLines(), (Object) this.oldAlignmentLines)) {
                getAlignmentLinesOwner().getAlignmentLines().onAlignmentsChanged();
                Map map2 = this.oldAlignmentLines;
                if (map2 == null) {
                    map2 = new LinkedHashMap();
                    this.oldAlignmentLines = map2;
                }
                map2.clear();
                map2.putAll(measureResult.getAlignmentLines());
            }
        }
    }

    /* renamed from: setPosition--gyyYBs  reason: not valid java name */
    public void m4731setPositiongyyYBs(long j11) {
        this.position = j11;
    }

    public final void setWrapped$ui_release(@Nullable NodeCoordinator nodeCoordinator) {
        this.wrapped = nodeCoordinator;
    }

    public final void setWrappedBy$ui_release(@Nullable NodeCoordinator nodeCoordinator) {
        this.wrappedBy = nodeCoordinator;
    }

    public final boolean shouldSharePointerInputWithSiblings() {
        Nodes nodes = Nodes.INSTANCE;
        Modifier.Node headNode = headNode(NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(nodes.m4765getPointerInputOLwlOKw()));
        if (headNode == null) {
            return false;
        }
        int r02 = nodes.m4765getPointerInputOLwlOKw();
        if (headNode.getNode().isAttached()) {
            Modifier.Node node = headNode.getNode();
            if ((node.getAggregateChildKindSet$ui_release() & r02) != 0) {
                for (Modifier.Node child$ui_release = node.getChild$ui_release(); child$ui_release != null; child$ui_release = child$ui_release.getChild$ui_release()) {
                    if ((child$ui_release.getKindSet$ui_release() & r02) != 0 && (child$ui_release instanceof PointerInputModifierNode) && ((PointerInputModifierNode) child$ui_release).sharePointerInputWithSiblings()) {
                        return true;
                    }
                }
            }
            return false;
        }
        throw new IllegalStateException("Check failed.".toString());
    }

    /* renamed from: toParentPosition-MK-Hz9U  reason: not valid java name */
    public long m4732toParentPositionMKHz9U(long j11) {
        OwnedLayer ownedLayer = this.layer;
        if (ownedLayer != null) {
            j11 = ownedLayer.m4769mapOffset8S9VItk(j11, false);
        }
        return IntOffsetKt.m5610plusNvtHpc(j11, m4721getPositionnOccac());
    }

    @NotNull
    public final Rect touchBoundsInRoot() {
        if (!isAttached()) {
            return Rect.Companion.getZero();
        }
        LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
        MutableRect k11 = k();
        long h11 = h(m4720getMinimumTouchTargetSizeNHjbRc());
        k11.setLeft(-Size.m2745getWidthimpl(h11));
        k11.setTop(-Size.m2742getHeightimpl(h11));
        k11.setRight(((float) getMeasuredWidth()) + Size.m2745getWidthimpl(h11));
        k11.setBottom(((float) getMeasuredHeight()) + Size.m2742getHeightimpl(h11));
        NodeCoordinator nodeCoordinator = this;
        while (nodeCoordinator != findRootCoordinates) {
            nodeCoordinator.rectInParent$ui_release(k11, false, true);
            if (k11.isEmpty()) {
                return Rect.Companion.getZero();
            }
            nodeCoordinator = nodeCoordinator.wrappedBy;
            Intrinsics.checkNotNull(nodeCoordinator);
        }
        return MutableRectKt.toRect(k11);
    }

    /* renamed from: transformFrom-EL8BTi8  reason: not valid java name */
    public void m4733transformFromEL8BTi8(@NotNull LayoutCoordinates layoutCoordinates, @NotNull float[] fArr) {
        Intrinsics.checkNotNullParameter(layoutCoordinates, "sourceCoordinates");
        Intrinsics.checkNotNullParameter(fArr, "matrix");
        NodeCoordinator coordinator = toCoordinator(layoutCoordinates);
        NodeCoordinator findCommonAncestor$ui_release = findCommonAncestor$ui_release(coordinator);
        Matrix.m3109resetimpl(fArr);
        coordinator.m4718transformToAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
        m4717transformFromAncestorEL8BTi8(findCommonAncestor$ui_release, fArr);
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [androidx.compose.ui.layout.LookaheadScope] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateLookaheadScope$ui_release(@org.jetbrains.annotations.Nullable androidx.compose.ui.layout.LookaheadScope r3) {
        /*
            r2 = this;
            r0 = 0
            if (r3 == 0) goto L_0x0019
            androidx.compose.ui.node.LookaheadDelegate r1 = r2.lookaheadDelegate
            if (r1 == 0) goto L_0x000b
            androidx.compose.ui.layout.LookaheadScope r0 = r1.getLookaheadScope()
        L_0x000b:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r0)
            if (r0 != 0) goto L_0x0016
            androidx.compose.ui.node.LookaheadDelegate r3 = r2.createLookaheadDelegate(r3)
            goto L_0x0018
        L_0x0016:
            androidx.compose.ui.node.LookaheadDelegate r3 = r2.lookaheadDelegate
        L_0x0018:
            r0 = r3
        L_0x0019:
            r2.lookaheadDelegate = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.NodeCoordinator.updateLookaheadScope$ui_release(androidx.compose.ui.layout.LookaheadScope):void");
    }

    public final void visitNodes(int i11, boolean z11, @NotNull Function1<? super Modifier.Node, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        Modifier.Node tail = getTail();
        if (z11 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(z11);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i11) != 0) {
                if ((access$headNode.getKindSet$ui_release() & i11) != 0) {
                    function1.invoke(access$headNode);
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: visitNodes-aLcG6gQ  reason: not valid java name */
    public final /* synthetic */ <T> void m4734visitNodesaLcG6gQ(int i11, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        boolean r02 = NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(i11);
        Modifier.Node tail = getTail();
        if (r02 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = headNode(r02);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & i11) != 0) {
                if ((access$headNode.getKindSet$ui_release() & i11) != 0) {
                    Intrinsics.reifiedOperationMarker(3, "T");
                    function1.invoke(access$headNode);
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    /* renamed from: windowToLocal-MK-Hz9U  reason: not valid java name */
    public long m4735windowToLocalMKHz9U(long j11) {
        if (isAttached()) {
            LayoutCoordinates findRootCoordinates = LayoutCoordinatesKt.findRootCoordinates(this);
            return m4728localPositionOfR5De75A(findRootCoordinates, Offset.m2680minusMKHz9U(LayoutNodeKt.requireOwner(getLayoutNode()).m4774calculateLocalPositionMKHz9U(j11), LayoutCoordinatesKt.positionInRoot(findRootCoordinates)));
        }
        throw new IllegalStateException(ExpectAttachedLayoutCoordinates.toString());
    }

    public void invoke(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (getLayoutNode().isPlaced()) {
            getSnapshotObserver().observeReads$ui_release(this, onCommitAffectingLayer, new NodeCoordinator$invoke$1(this, canvas));
            this.lastLayerDrawingWasSkipped = false;
            return;
        }
        this.lastLayerDrawingWasSkipped = true;
    }
}
