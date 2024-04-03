package androidx.compose.ui.node;

import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutInfo;
import androidx.compose.ui.layout.LayoutNodeSubcompositionsState;
import androidx.compose.ui.layout.LookaheadScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.ModifierInfo;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.node.LayoutNodeLayoutDelegate;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.SemanticsModifierCore;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DensityKt;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import l0.c;
import l0.d;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b>\b\u0000\u0018\u0000 Á\u00022\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\bÁ\u0002Â\u0002Ã\u0002Ä\u0002B\u0019\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u001a\u0010Í\u0001\u001a\u00030\u00012\b\u0010§\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÎ\u0001J\u0010\u0010Ï\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÐ\u0001J\u0010\u0010Ñ\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÒ\u0001J\u0010\u0010Ó\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÔ\u0001J\n\u0010Õ\u0001\u001a\u00030\u0001H\u0002J\u0014\u0010Ö\u0001\u001a\u00030×\u00012\b\b\u0002\u00103\u001a\u00020\tH\u0002J\u0010\u0010Ø\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÙ\u0001J\u0010\u0010Ú\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÛ\u0001J\u001a\u0010Ü\u0001\u001a\u00030\u00012\b\u0010Ý\u0001\u001a\u00030Þ\u0001H\u0000¢\u0006\u0003\bß\u0001J%\u0010à\u0001\u001a\u00030\u00012\u0015\u0010á\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030\u00010\u0001H\bø\u0001\u0000J+\u0010â\u0001\u001a\u00030\u00012\u001b\u0010á\u0001\u001a\u0016\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u0000\u0012\u0005\u0012\u00030\u00010ã\u0001H\bø\u0001\u0000J#\u0010ä\u0001\u001a\u00030\u00012\u0016\u0010á\u0001\u001a\u0011\u0012\u0005\u0012\u00030å\u0001\u0012\u0005\u0012\u00030\u00010\u0001H\bJ\"\u0010æ\u0001\u001a\u00030\u00012\u0015\u0010á\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0013\u0012\u0005\u0012\u00030\u00010\u0001H\bJ\n\u0010ç\u0001\u001a\u00030\u0001H\u0016J\u0010\u0010è\u0001\u001a\t\u0012\u0005\u0012\u00030é\u00010 H\u0016JJ\u0010ê\u0001\u001a\u00030\u00012\b\u0010ë\u0001\u001a\u00030ì\u00012\u000f\u0010í\u0001\u001a\n\u0012\u0005\u0012\u00030ï\u00010î\u00012\t\b\u0002\u0010ð\u0001\u001a\u00020\u00072\t\b\u0002\u0010ñ\u0001\u001a\u00020\u0007H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\bò\u0001\u0010ó\u0001JJ\u0010ô\u0001\u001a\u00030\u00012\b\u0010ë\u0001\u001a\u00030ì\u00012\u000f\u0010õ\u0001\u001a\n\u0012\u0005\u0012\u00030ö\u00010î\u00012\t\b\u0002\u0010ð\u0001\u001a\u00020\u00072\t\b\u0002\u0010ñ\u0001\u001a\u00020\u0007H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\b÷\u0001\u0010ó\u0001J$\u0010<\u001a\u00030\u00012\u000f\u0010á\u0001\u001a\n\u0012\u0005\u0012\u00030\u00010ø\u0001H\bø\u0001\u0000¢\u0006\u0003\bù\u0001J\"\u0010ú\u0001\u001a\u00030\u00012\u0007\u0010û\u0001\u001a\u00020\t2\u0007\u0010ü\u0001\u001a\u00020\u0000H\u0000¢\u0006\u0003\bý\u0001J\u0010\u0010þ\u0001\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÿ\u0001J\u0010\u0010\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J#\u0010\u0002\u001a\u00020\u00072\f\b\u0002\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J+\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\t2\u0007\u0010\u0002\u001a\u00020\t2\u0007\u0010\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\b\u0002J\u0013\u0010\u0002\u001a\u00030\u00012\u0007\u0010\u0002\u001a\u00020\u0000H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0002J\n\u0010\u0002\u001a\u00030\u0001H\u0016J\u0010\u0010\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b\u0002J\u0010\u0010 \u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b¡\u0002J\"\u0010¢\u0002\u001a\u00030\u00012\u0007\u0010£\u0002\u001a\u00020\t2\u0007\u0010¤\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\b¥\u0002J\n\u0010¦\u0002\u001a\u00030\u0001H\u0002J#\u0010§\u0002\u001a\u00020\u00072\f\b\u0002\u0010\u0002\u001a\u0005\u0018\u00010\u0002H\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0003\b¨\u0002J\u0010\u0010©\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\bª\u0002J\"\u0010«\u0002\u001a\u00030\u00012\u0007\u0010û\u0001\u001a\u00020\t2\u0007\u0010\u0002\u001a\u00020\tH\u0000¢\u0006\u0003\b¬\u0002J\u0010\u0010­\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b®\u0002J\u001b\u0010¯\u0002\u001a\u00030\u00012\t\b\u0002\u0010°\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0003\b±\u0002J\u001b\u0010²\u0002\u001a\u00030\u00012\t\b\u0002\u0010°\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0003\b³\u0002J\u001b\u0010´\u0002\u001a\u00030\u00012\t\b\u0002\u0010°\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0003\bµ\u0002J\u001b\u0010¶\u0002\u001a\u00030\u00012\t\b\u0002\u0010°\u0002\u001a\u00020\u0007H\u0000¢\u0006\u0003\b·\u0002J\u0019\u0010¸\u0002\u001a\u00030\u00012\u0007\u0010¹\u0002\u001a\u00020\u0000H\u0000¢\u0006\u0003\bº\u0002J\u0010\u0010»\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\b¼\u0002J\t\u0010½\u0002\u001a\u00020\u0007H\u0002J\n\u0010¾\u0002\u001a\u00030×\u0001H\u0016J\u0010\u0010¿\u0002\u001a\u00030\u0001H\u0000¢\u0006\u0003\bÀ\u0002R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00000\f8@X\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00000\u0010X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0000X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0000\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00000\fX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R$\u0010\u0019\u001a\u00020\u00078\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u0018\"\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8@X\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\b\u0012\u0004\u0012\u00020!0 8@X\u0004¢\u0006\u0006\u001a\u0004\b%\u0010#R\u001a\u0010&\u001a\b\u0012\u0004\u0012\u00020\u00000 8@X\u0004¢\u0006\u0006\u001a\u0004\b'\u0010#R\u0014\u0010(\u001a\u00020)8VX\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R$\u0010.\u001a\u00020-2\u0006\u0010,\u001a\u00020-@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\u001a\u00103\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u00105\"\u0004\b6\u00107R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\u00000 8@X\u0004¢\u0006\u0006\u001a\u0004\b9\u0010#R\u0014\u0010:\u001a\u00020\t8VX\u0004¢\u0006\u0006\u001a\u0004\b;\u00105R\u000e\u0010<\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\u00020\u00138@X\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0016\u0010@\u001a\u0004\u0018\u00010\u00138BX\u0004¢\u0006\u0006\u001a\u0004\bA\u0010?R\u001a\u0010B\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010\u0018\"\u0004\bD\u0010\u001eR\u0014\u0010E\u001a\u00020FX\u0004¢\u0006\b\n\u0000\u001a\u0004\bG\u0010HR\u001a\u0010I\u001a\u00020JX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bK\u0010L\"\u0004\bM\u0010NR\u0014\u0010O\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\bO\u0010\u0018R$\u0010P\u001a\u00020\u00072\u0006\u0010,\u001a\u00020\u0007@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010\u0018\"\u0004\bQ\u0010\u001eR\u001e\u0010S\u001a\u00020\u00072\u0006\u0010R\u001a\u00020\u0007@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\bS\u0010\u0018R\u0013\u0010T\u001a\u0004\u0018\u00010\u00078F¢\u0006\u0006\u001a\u0004\bT\u0010UR\u0014\u0010V\u001a\u00020\u00078VX\u0004¢\u0006\u0006\u001a\u0004\bV\u0010\u0018R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010W\u001a\u00020XX\u0004¢\u0006\b\n\u0000\u001a\u0004\bY\u0010ZR$\u0010\\\u001a\u00020[2\u0006\u0010,\u001a\u00020[@VX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010^\"\u0004\b_\u0010`R\u0014\u0010a\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\bb\u0010\u0018R\u0014\u0010c\u001a\u00020d8@X\u0004¢\u0006\u0006\u001a\u0004\be\u0010fR\u0014\u0010g\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\bh\u0010\u0018R\u0014\u0010i\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\bj\u0010\u0018R\u001a\u0010k\u001a\b\u0018\u00010lR\u00020X8BX\u0004¢\u0006\u0006\u001a\u0004\bm\u0010nR\u0014\u0010o\u001a\u00020p8@X\u0004¢\u0006\u0006\u001a\u0004\bq\u0010rR(\u0010u\u001a\u0004\u0018\u00010t2\b\u0010s\u001a\u0004\u0018\u00010t@BX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bv\u0010w\"\u0004\bx\u0010yR\u0018\u0010z\u001a\u00060{R\u00020X8BX\u0004¢\u0006\u0006\u001a\u0004\b|\u0010}R\u0014\u0010~\u001a\u00020\u00078@X\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0018R+\u0010\u0001\u001a\u00030\u00012\u0007\u0010,\u001a\u00030\u0001@VX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020JX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010L\"\u0005\b\u0001\u0010NR\u001d\u0010\u0001\u001a\u00020JX\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010L\"\u0005\b\u0001\u0010NR+\u0010\u0001\u001a\u00030\u00012\u0007\u0010,\u001a\u00030\u0001@VX\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001d\u0010\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0010\n\u0000\u001a\u0005\b\u0001\u0010\u0018\"\u0005\b\u0001\u0010\u001eR\u000f\u0010\u0001\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R0\u0010\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0001\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b \u0001\u0010¡\u0001R0\u0010¢\u0001\u001a\u0013\u0012\u0005\u0012\u00030\u0001\u0012\u0005\u0012\u00030\u0001\u0018\u00010\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b£\u0001\u0010\u0001\"\u0006\b¤\u0001\u0010¡\u0001R\u0016\u0010¥\u0001\u001a\u00020\u00138@X\u0004¢\u0006\u0007\u001a\u0005\b¦\u0001\u0010?R'\u0010§\u0001\u001a\u0005\u0018\u00010\u00012\t\u0010R\u001a\u0005\u0018\u00010\u0001@BX\u000e¢\u0006\n\n\u0000\u001a\u0006\b¨\u0001\u0010©\u0001R\u0019\u0010ª\u0001\u001a\u0004\u0018\u00010\u00008@X\u0004¢\u0006\b\u001a\u0006\b«\u0001\u0010¬\u0001R\u0019\u0010­\u0001\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R \u0010°\u0001\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t@BX\u000e¢\u0006\t\n\u0000\u001a\u0005\b±\u0001\u00105R\u000f\u0010²\u0001\u001a\u00020JX\u000e¢\u0006\u0002\n\u0000R \u0010³\u0001\u001a\u00020\t2\u0006\u0010R\u001a\u00020\t@BX\u000e¢\u0006\t\n\u0000\u001a\u0005\b´\u0001\u00105R\u000f\u0010µ\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\u00020\tX\u0004¢\u0006\t\n\u0000\u001a\u0005\b¶\u0001\u00105R\"\u0010·\u0001\u001a\u0005\u0018\u00010¸\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\b¹\u0001\u0010º\u0001\"\u0006\b»\u0001\u0010¼\u0001R\u000f\u0010½\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R \u0010¾\u0001\u001a\u00030¿\u0001X\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÀ\u0001\u0010Á\u0001\"\u0006\bÂ\u0001\u0010Ã\u0001R\u000f\u0010Ä\u0001\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Å\u0001\u001a\u00020\t8VX\u0004¢\u0006\u0007\u001a\u0005\bÆ\u0001\u00105R\u0010\u0010Ç\u0001\u001a\u00030È\u0001X\u000e¢\u0006\u0002\n\u0000R#\u0010É\u0001\u001a\b\u0012\u0004\u0012\u00020\u00000\f8@X\u0004¢\u0006\u000e\u0012\u0005\bÊ\u0001\u0010\u001b\u001a\u0005\bË\u0001\u0010\u000eR\u000f\u0010Ì\u0001\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000\u0002\u0012\n\u0005\b20\u0001\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006Å\u0002"}, d2 = {"Landroidx/compose/ui/node/LayoutNode;", "Landroidx/compose/ui/layout/Remeasurement;", "Landroidx/compose/ui/node/OwnerScope;", "Landroidx/compose/ui/layout/LayoutInfo;", "Landroidx/compose/ui/node/ComposeUiNode;", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "isVirtual", "", "semanticsId", "", "(ZI)V", "_children", "Landroidx/compose/runtime/collection/MutableVector;", "get_children$ui_release", "()Landroidx/compose/runtime/collection/MutableVector;", "_foldedChildren", "Landroidx/compose/ui/node/MutableVectorWithMutationTracking;", "_foldedParent", "_innerLayerCoordinator", "Landroidx/compose/ui/node/NodeCoordinator;", "_unfoldedChildren", "_zSortedChildren", "alignmentLinesRequired", "getAlignmentLinesRequired$ui_release", "()Z", "canMultiMeasure", "getCanMultiMeasure$ui_release$annotations", "()V", "getCanMultiMeasure$ui_release", "setCanMultiMeasure$ui_release", "(Z)V", "childLookaheadMeasurables", "", "Landroidx/compose/ui/layout/Measurable;", "getChildLookaheadMeasurables$ui_release", "()Ljava/util/List;", "childMeasurables", "getChildMeasurables$ui_release", "children", "getChildren$ui_release", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "getCoordinates", "()Landroidx/compose/ui/layout/LayoutCoordinates;", "value", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "setDensity", "(Landroidx/compose/ui/unit/Density;)V", "depth", "getDepth$ui_release", "()I", "setDepth$ui_release", "(I)V", "foldedChildren", "getFoldedChildren$ui_release", "height", "getHeight", "ignoreRemeasureRequests", "innerCoordinator", "getInnerCoordinator$ui_release", "()Landroidx/compose/ui/node/NodeCoordinator;", "innerLayerCoordinator", "getInnerLayerCoordinator", "innerLayerCoordinatorIsDirty", "getInnerLayerCoordinatorIsDirty$ui_release", "setInnerLayerCoordinatorIsDirty$ui_release", "intrinsicsPolicy", "Landroidx/compose/ui/node/IntrinsicsPolicy;", "getIntrinsicsPolicy$ui_release", "()Landroidx/compose/ui/node/IntrinsicsPolicy;", "intrinsicsUsageByParent", "Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "getIntrinsicsUsageByParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "setIntrinsicsUsageByParent$ui_release", "(Landroidx/compose/ui/node/LayoutNode$UsageByParent;)V", "isAttached", "isLookaheadRoot", "setLookaheadRoot", "<set-?>", "isPlaced", "isPlacedInLookahead", "()Ljava/lang/Boolean;", "isValid", "layoutDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "getLayoutDelegate$ui_release", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutPending", "getLayoutPending$ui_release", "layoutState", "Landroidx/compose/ui/node/LayoutNode$LayoutState;", "getLayoutState$ui_release", "()Landroidx/compose/ui/node/LayoutNode$LayoutState;", "lookaheadLayoutPending", "getLookaheadLayoutPending$ui_release", "lookaheadMeasurePending", "getLookaheadMeasurePending$ui_release", "lookaheadPassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "getLookaheadPassDelegate", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$LookaheadPassDelegate;", "mDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getMDrawScope$ui_release", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "newScope", "Landroidx/compose/ui/layout/LookaheadScope;", "mLookaheadScope", "getMLookaheadScope$ui_release", "()Landroidx/compose/ui/layout/LookaheadScope;", "setMLookaheadScope", "(Landroidx/compose/ui/layout/LookaheadScope;)V", "measurePassDelegate", "Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "getMeasurePassDelegate", "()Landroidx/compose/ui/node/LayoutNodeLayoutDelegate$MeasurePassDelegate;", "measurePending", "getMeasurePending$ui_release", "Landroidx/compose/ui/layout/MeasurePolicy;", "measurePolicy", "getMeasurePolicy", "()Landroidx/compose/ui/layout/MeasurePolicy;", "setMeasurePolicy", "(Landroidx/compose/ui/layout/MeasurePolicy;)V", "measuredByParent", "getMeasuredByParent$ui_release", "setMeasuredByParent$ui_release", "measuredByParentInLookahead", "getMeasuredByParentInLookahead$ui_release", "setMeasuredByParentInLookahead$ui_release", "Landroidx/compose/ui/Modifier;", "modifier", "getModifier", "()Landroidx/compose/ui/Modifier;", "setModifier", "(Landroidx/compose/ui/Modifier;)V", "needsOnPositionedDispatch", "getNeedsOnPositionedDispatch$ui_release", "setNeedsOnPositionedDispatch$ui_release", "nextChildPlaceOrder", "nodes", "Landroidx/compose/ui/node/NodeChain;", "getNodes$ui_release", "()Landroidx/compose/ui/node/NodeChain;", "onAttach", "Lkotlin/Function1;", "Landroidx/compose/ui/node/Owner;", "", "getOnAttach$ui_release", "()Lkotlin/jvm/functions/Function1;", "setOnAttach$ui_release", "(Lkotlin/jvm/functions/Function1;)V", "onDetach", "getOnDetach$ui_release", "setOnDetach$ui_release", "outerCoordinator", "getOuterCoordinator$ui_release", "owner", "getOwner$ui_release", "()Landroidx/compose/ui/node/Owner;", "parent", "getParent$ui_release", "()Landroidx/compose/ui/node/LayoutNode;", "parentInfo", "getParentInfo", "()Landroidx/compose/ui/layout/LayoutInfo;", "placeOrder", "getPlaceOrder$ui_release", "previousIntrinsicsUsageByParent", "previousPlaceOrder", "getPreviousPlaceOrder$ui_release", "relayoutWithoutParentInProgress", "getSemanticsId", "subcompositionsState", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "getSubcompositionsState$ui_release", "()Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "setSubcompositionsState$ui_release", "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "unfoldedVirtualChildrenListDirty", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "setViewConfiguration", "(Landroidx/compose/ui/platform/ViewConfiguration;)V", "virtualChildrenCount", "width", "getWidth", "zIndex", "", "zSortedChildren", "getZSortedChildren$annotations", "getZSortedChildren", "zSortedChildrenInvalidated", "attach", "attach$ui_release", "checkChildrenPlaceOrderForUpdates", "checkChildrenPlaceOrderForUpdates$ui_release", "clearPlaceOrder", "clearPlaceOrder$ui_release", "clearSubtreeIntrinsicsUsage", "clearSubtreeIntrinsicsUsage$ui_release", "clearSubtreePlacementIntrinsicsUsage", "debugTreeToString", "", "detach", "detach$ui_release", "dispatchOnPositionedCallbacks", "dispatchOnPositionedCallbacks$ui_release", "draw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "draw$ui_release", "forEachChild", "block", "forEachChildIndexed", "Lkotlin/Function2;", "forEachCoordinator", "Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "forEachCoordinatorIncludingInner", "forceRemeasure", "getModifierInfo", "Landroidx/compose/ui/layout/ModifierInfo;", "hitTest", "pointerPosition", "Landroidx/compose/ui/geometry/Offset;", "hitTestResult", "Landroidx/compose/ui/node/HitTestResult;", "Landroidx/compose/ui/node/PointerInputModifierNode;", "isTouchEvent", "isInLayer", "hitTest-M_7yMNQ$ui_release", "(JLandroidx/compose/ui/node/HitTestResult;ZZ)V", "hitTestSemantics", "hitSemanticsEntities", "Landroidx/compose/ui/node/SemanticsModifierNode;", "hitTestSemantics-M_7yMNQ$ui_release", "Lkotlin/Function0;", "ignoreRemeasureRequests$ui_release", "insertAt", "index", "instance", "insertAt$ui_release", "invalidateLayer", "invalidateLayer$ui_release", "invalidateLayers", "invalidateLayers$ui_release", "invalidateMeasurements", "invalidateMeasurements$ui_release", "invalidateUnfoldedVirtualChildren", "lookaheadRemeasure", "constraints", "Landroidx/compose/ui/unit/Constraints;", "lookaheadRemeasure-_Sx5XlM$ui_release", "lookaheadReplace", "lookaheadReplace$ui_release", "markLayoutPending", "markLayoutPending$ui_release", "markLookaheadLayoutPending", "markLookaheadLayoutPending$ui_release", "markLookaheadMeasurePending", "markLookaheadMeasurePending$ui_release", "markMeasurePending", "markMeasurePending$ui_release", "markNodeAndSubtreeAsPlaced", "markSubtreeAsNotPlaced", "move", "from", "to", "count", "move$ui_release", "onChildRemoved", "child", "onDensityOrLayoutDirectionChanged", "onLayoutComplete", "onNodePlaced", "onNodePlaced$ui_release", "onZSortedChildrenInvalidated", "onZSortedChildrenInvalidated$ui_release", "place", "x", "y", "place$ui_release", "recreateUnfoldedChildrenIfDirty", "remeasure", "remeasure-_Sx5XlM$ui_release", "removeAll", "removeAll$ui_release", "removeAt", "removeAt$ui_release", "replace", "replace$ui_release", "requestLookaheadRelayout", "forceRequest", "requestLookaheadRelayout$ui_release", "requestLookaheadRemeasure", "requestLookaheadRemeasure$ui_release", "requestRelayout", "requestRelayout$ui_release", "requestRemeasure", "requestRemeasure$ui_release", "rescheduleRemeasureOrRelayout", "it", "rescheduleRemeasureOrRelayout$ui_release", "resetSubtreeIntrinsicsUsage", "resetSubtreeIntrinsicsUsage$ui_release", "shouldInvalidateParentLayer", "toString", "updateChildrenIfDirty", "updateChildrenIfDirty$ui_release", "Companion", "LayoutState", "NoIntrinsicsMeasurePolicy", "UsageByParent", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class LayoutNode implements Remeasurement, OwnerScope, LayoutInfo, ComposeUiNode, Owner.OnLayoutCompletedListener {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final Function0<LayoutNode> Constructor = LayoutNode$Companion$Constructor$1.INSTANCE;
    /* access modifiers changed from: private */
    @NotNull
    public static final ViewConfiguration DummyViewConfiguration = new LayoutNode$Companion$DummyViewConfiguration$1();
    @NotNull
    private static final NoIntrinsicsMeasurePolicy ErrorMeasurePolicy = new LayoutNode$Companion$ErrorMeasurePolicy$1();
    public static final int NotPlacedPlaceOrder = Integer.MAX_VALUE;
    /* access modifiers changed from: private */
    @NotNull
    public static final Comparator<LayoutNode> ZComparator = new c();
    @NotNull
    private final MutableVectorWithMutationTracking<LayoutNode> _foldedChildren;
    @Nullable
    private LayoutNode _foldedParent;
    @Nullable
    private NodeCoordinator _innerLayerCoordinator;
    @Nullable
    private MutableVector<LayoutNode> _unfoldedChildren;
    @NotNull
    private final MutableVector<LayoutNode> _zSortedChildren;
    private boolean canMultiMeasure;
    @NotNull
    private Density density;
    private int depth;
    /* access modifiers changed from: private */
    public boolean ignoreRemeasureRequests;
    private boolean innerLayerCoordinatorIsDirty;
    @NotNull
    private final IntrinsicsPolicy intrinsicsPolicy;
    @NotNull
    private UsageByParent intrinsicsUsageByParent;
    private boolean isLookaheadRoot;
    private boolean isPlaced;
    private final boolean isVirtual;
    @NotNull
    private final LayoutNodeLayoutDelegate layoutDelegate;
    @NotNull
    private LayoutDirection layoutDirection;
    @Nullable
    private LookaheadScope mLookaheadScope;
    @NotNull
    private MeasurePolicy measurePolicy;
    @NotNull
    private UsageByParent measuredByParent;
    @NotNull
    private UsageByParent measuredByParentInLookahead;
    @NotNull
    private Modifier modifier;
    private boolean needsOnPositionedDispatch;
    private int nextChildPlaceOrder;
    @NotNull
    private final NodeChain nodes;
    @Nullable
    private Function1<? super Owner, Unit> onAttach;
    @Nullable
    private Function1<? super Owner, Unit> onDetach;
    @Nullable
    private Owner owner;
    private int placeOrder;
    @NotNull
    private UsageByParent previousIntrinsicsUsageByParent;
    private int previousPlaceOrder;
    private boolean relayoutWithoutParentInProgress;
    private final int semanticsId;
    @Nullable
    private LayoutNodeSubcompositionsState subcompositionsState;
    private boolean unfoldedVirtualChildrenListDirty;
    @NotNull
    private ViewConfiguration viewConfiguration;
    private int virtualChildrenCount;
    private float zIndex;
    private boolean zSortedChildrenInvalidated;

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\tX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00050\u0011X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$Companion;", "", "()V", "Constructor", "Lkotlin/Function0;", "Landroidx/compose/ui/node/LayoutNode;", "getConstructor$ui_release", "()Lkotlin/jvm/functions/Function0;", "DummyViewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getDummyViewConfiguration$ui_release", "()Landroidx/compose/ui/platform/ViewConfiguration;", "ErrorMeasurePolicy", "Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "NotPlacedPlaceOrder", "", "ZComparator", "Ljava/util/Comparator;", "getZComparator$ui_release", "()Ljava/util/Comparator;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final Function0<LayoutNode> getConstructor$ui_release() {
            return LayoutNode.Constructor;
        }

        @NotNull
        public final ViewConfiguration getDummyViewConfiguration$ui_release() {
            return LayoutNode.DummyViewConfiguration;
        }

        @NotNull
        public final Comparator<LayoutNode> getZComparator$ui_release() {
            return LayoutNode.ZComparator;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$LayoutState;", "", "(Ljava/lang/String;I)V", "Measuring", "LookaheadMeasuring", "LayingOut", "LookaheadLayingOut", "Idle", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum LayoutState {
        Measuring,
        LookaheadMeasuring,
        LayingOut,
        LookaheadLayingOut,
        Idle
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b \u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0005\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\r\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016J\"\u0010\u000f\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0010\u001a\u00020\u0006*\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000e\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$NoIntrinsicsMeasurePolicy;", "Landroidx/compose/ui/layout/MeasurePolicy;", "error", "", "(Ljava/lang/String;)V", "maxIntrinsicHeight", "", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurables", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "", "maxIntrinsicWidth", "height", "minIntrinsicHeight", "minIntrinsicWidth", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static abstract class NoIntrinsicsMeasurePolicy implements MeasurePolicy {
        @NotNull
        private final String error;

        public NoIntrinsicsMeasurePolicy(@NotNull String str) {
            Intrinsics.checkNotNullParameter(str, "error");
            this.error = str;
        }

        @NotNull
        public Void maxIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        public Void maxIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        public Void minIntrinsicHeight(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }

        @NotNull
        public Void minIntrinsicWidth(@NotNull IntrinsicMeasureScope intrinsicMeasureScope, @NotNull List<? extends IntrinsicMeasurable> list, int i11) {
            Intrinsics.checkNotNullParameter(intrinsicMeasureScope, "<this>");
            Intrinsics.checkNotNullParameter(list, "measurables");
            throw new IllegalStateException(this.error.toString());
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Landroidx/compose/ui/node/LayoutNode$UsageByParent;", "", "(Ljava/lang/String;I)V", "InMeasureBlock", "InLayoutBlock", "NotUsed", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum UsageByParent {
        InMeasureBlock,
        InLayoutBlock,
        NotUsed
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[LayoutState.values().length];
            iArr[LayoutState.Idle.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public LayoutNode() {
        this(false, 0, 3, (DefaultConstructorMarker) null);
    }

    public LayoutNode(boolean z11, int i11) {
        this.isVirtual = z11;
        this.semanticsId = i11;
        this._foldedChildren = new MutableVectorWithMutationTracking<>(new MutableVector(new LayoutNode[16], 0), new LayoutNode$_foldedChildren$1(this));
        this._zSortedChildren = new MutableVector<>(new LayoutNode[16], 0);
        this.zSortedChildrenInvalidated = true;
        this.measurePolicy = ErrorMeasurePolicy;
        this.intrinsicsPolicy = new IntrinsicsPolicy(this);
        this.density = DensityKt.Density$default(1.0f, 0.0f, 2, (Object) null);
        this.layoutDirection = LayoutDirection.Ltr;
        this.viewConfiguration = DummyViewConfiguration;
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        UsageByParent usageByParent = UsageByParent.NotUsed;
        this.measuredByParent = usageByParent;
        this.measuredByParentInLookahead = usageByParent;
        this.intrinsicsUsageByParent = usageByParent;
        this.previousIntrinsicsUsageByParent = usageByParent;
        this.nodes = new NodeChain(this);
        this.layoutDelegate = new LayoutNodeLayoutDelegate(this);
        this.innerLayerCoordinatorIsDirty = true;
        this.modifier = Modifier.Companion;
    }

    /* access modifiers changed from: private */
    /* renamed from: ZComparator$lambda-37  reason: not valid java name */
    public static final int m4616ZComparator$lambda37(LayoutNode layoutNode, LayoutNode layoutNode2) {
        boolean z11;
        float f11 = layoutNode.zIndex;
        float f12 = layoutNode2.zIndex;
        if (f11 == f12) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return Intrinsics.compare(layoutNode.placeOrder, layoutNode2.placeOrder);
        }
        return Float.compare(f11, f12);
    }

    public static /* synthetic */ String b(LayoutNode layoutNode, int i11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            i11 = 0;
        }
        return layoutNode.debugTreeToString(i11);
    }

    private final void clearSubtreePlacementIntrinsicsUsage() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i11];
                if (layoutNode.intrinsicsUsageByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.clearSubtreePlacementIntrinsicsUsage();
                }
                i11++;
            } while (i11 < size);
        }
    }

    private final String debugTreeToString(int i11) {
        StringBuilder sb2 = new StringBuilder();
        for (int i12 = 0; i12 < i11; i12++) {
            sb2.append("  ");
        }
        sb2.append("|-");
        sb2.append(toString());
        sb2.append(10);
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i13 = 0;
            do {
                sb2.append(((LayoutNode) content[i13]).debugTreeToString(i11 + 1));
                i13++;
            } while (i13 < size);
        }
        String sb3 = sb2.toString();
        Intrinsics.checkNotNullExpressionValue(sb3, "tree.toString()");
        if (i11 != 0) {
            return sb3;
        }
        String substring = sb3.substring(0, sb3.length() - 1);
        Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return substring;
    }

    private final void forEachCoordinator(Function1<? super LayoutModifierNodeCoordinator, Unit> function1) {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            function1.invoke(layoutModifierNodeCoordinator);
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
        }
    }

    private final void forEachCoordinatorIncludingInner(Function1<? super NodeCoordinator, Unit> function1) {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) outerCoordinator$ui_release, (Object) wrapped$ui_release) && outerCoordinator$ui_release != null) {
            function1.invoke(outerCoordinator$ui_release);
            outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release();
        }
    }

    @Deprecated(message = "Temporary API to support ConstraintLayout prototyping.")
    public static /* synthetic */ void getCanMultiMeasure$ui_release$annotations() {
    }

    private final NodeCoordinator getInnerLayerCoordinator() {
        OwnedLayer ownedLayer;
        if (this.innerLayerCoordinatorIsDirty) {
            NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
            NodeCoordinator wrappedBy$ui_release = getOuterCoordinator$ui_release().getWrappedBy$ui_release();
            this._innerLayerCoordinator = null;
            while (true) {
                if (Intrinsics.areEqual((Object) innerCoordinator$ui_release, (Object) wrappedBy$ui_release)) {
                    break;
                }
                if (innerCoordinator$ui_release != null) {
                    ownedLayer = innerCoordinator$ui_release.getLayer();
                } else {
                    ownedLayer = null;
                }
                if (ownedLayer != null) {
                    this._innerLayerCoordinator = innerCoordinator$ui_release;
                    break;
                } else if (innerCoordinator$ui_release != null) {
                    innerCoordinator$ui_release = innerCoordinator$ui_release.getWrappedBy$ui_release();
                } else {
                    innerCoordinator$ui_release = null;
                }
            }
        }
        NodeCoordinator nodeCoordinator = this._innerLayerCoordinator;
        if (nodeCoordinator == null || nodeCoordinator.getLayer() != null) {
            return nodeCoordinator;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    private final LayoutNodeLayoutDelegate.LookaheadPassDelegate getLookaheadPassDelegate() {
        return this.layoutDelegate.getLookaheadPassDelegate$ui_release();
    }

    private final LayoutNodeLayoutDelegate.MeasurePassDelegate getMeasurePassDelegate() {
        return this.layoutDelegate.getMeasurePassDelegate$ui_release();
    }

    @PublishedApi
    public static /* synthetic */ void getZSortedChildren$annotations() {
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release$default  reason: not valid java name */
    public static /* synthetic */ void m4617hitTestM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j11, HitTestResult hitTestResult, boolean z11, boolean z12, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        boolean z13 = z11;
        if ((i11 & 8) != 0) {
            z12 = true;
        }
        layoutNode.m4621hitTestM_7yMNQ$ui_release(j11, hitTestResult, z13, z12);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release$default  reason: not valid java name */
    public static /* synthetic */ void m4618hitTestSemanticsM_7yMNQ$ui_release$default(LayoutNode layoutNode, long j11, HitTestResult hitTestResult, boolean z11, boolean z12, int i11, Object obj) {
        layoutNode.m4622hitTestSemanticsM_7yMNQ$ui_release(j11, hitTestResult, (i11 & 4) != 0 ? true : z11, (i11 & 8) != 0 ? true : z12);
    }

    private final void invalidateUnfoldedVirtualChildren() {
        LayoutNode parent$ui_release;
        if (this.virtualChildrenCount > 0) {
            this.unfoldedVirtualChildrenListDirty = true;
        }
        if (this.isVirtual && (parent$ui_release = getParent$ui_release()) != null) {
            parent$ui_release.unfoldedVirtualChildrenListDirty = true;
        }
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release$default  reason: not valid java name */
    public static /* synthetic */ boolean m4619lookaheadRemeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m4667getLastLookaheadConstraintsDWUhwKw();
        }
        return layoutNode.m4623lookaheadRemeasure_Sx5XlM$ui_release(constraints);
    }

    private final void markNodeAndSubtreeAsPlaced() {
        boolean isPlaced2 = isPlaced();
        this.isPlaced = true;
        if (!isPlaced2) {
            if (getMeasurePending$ui_release()) {
                requestRemeasure$ui_release(true);
            } else if (getLookaheadMeasurePending$ui_release()) {
                requestLookaheadRemeasure$ui_release(true);
            }
        }
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) outerCoordinator$ui_release, (Object) wrapped$ui_release) && outerCoordinator$ui_release != null) {
            if (outerCoordinator$ui_release.getLastLayerDrawingWasSkipped$ui_release()) {
                outerCoordinator$ui_release.invalidateLayer();
            }
            outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release();
        }
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i11];
                if (layoutNode.placeOrder != Integer.MAX_VALUE) {
                    layoutNode.markNodeAndSubtreeAsPlaced();
                    rescheduleRemeasureOrRelayout$ui_release(layoutNode);
                }
                i11++;
            } while (i11 < size);
        }
    }

    private final void markSubtreeAsNotPlaced() {
        if (isPlaced()) {
            int i11 = 0;
            this.isPlaced = false;
            MutableVector<LayoutNode> mutableVector = get_children$ui_release();
            int size = mutableVector.getSize();
            if (size > 0) {
                Object[] content = mutableVector.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                do {
                    ((LayoutNode) content[i11]).markSubtreeAsNotPlaced();
                    i11++;
                } while (i11 < size);
            }
        }
    }

    private final void onChildRemoved(LayoutNode layoutNode) {
        if (layoutNode.layoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() > 0) {
            LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
            layoutNodeLayoutDelegate.setChildrenAccessingCoordinatesDuringPlacement(layoutNodeLayoutDelegate.getChildrenAccessingCoordinatesDuringPlacement() - 1);
        }
        if (this.owner != null) {
            layoutNode.detach$ui_release();
        }
        layoutNode._foldedParent = null;
        layoutNode.getOuterCoordinator$ui_release().setWrappedBy$ui_release((NodeCoordinator) null);
        if (layoutNode.isVirtual) {
            this.virtualChildrenCount--;
            MutableVector<LayoutNode> vector = layoutNode._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                Object[] content = vector.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                int i11 = 0;
                do {
                    ((LayoutNode) content[i11]).getOuterCoordinator$ui_release().setWrappedBy$ui_release((NodeCoordinator) null);
                    i11++;
                } while (i11 < size);
            }
        }
        invalidateUnfoldedVirtualChildren();
        onZSortedChildrenInvalidated$ui_release();
    }

    private final void onDensityOrLayoutDirectionChanged() {
        invalidateMeasurements$ui_release();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
        invalidateLayers$ui_release();
    }

    private final void recreateUnfoldedChildrenIfDirty() {
        if (this.unfoldedVirtualChildrenListDirty) {
            int i11 = 0;
            this.unfoldedVirtualChildrenListDirty = false;
            MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
            if (mutableVector == null) {
                mutableVector = new MutableVector<>(new LayoutNode[16], 0);
                this._unfoldedChildren = mutableVector;
            }
            mutableVector.clear();
            MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
            int size = vector.getSize();
            if (size > 0) {
                Object[] content = vector.getContent();
                Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
                do {
                    LayoutNode layoutNode = (LayoutNode) content[i11];
                    if (layoutNode.isVirtual) {
                        mutableVector.addAll(mutableVector.getSize(), layoutNode.get_children$ui_release());
                    } else {
                        mutableVector.add(layoutNode);
                    }
                    i11++;
                } while (i11 < size);
            }
            this.layoutDelegate.markChildrenDirty();
        }
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release$default  reason: not valid java name */
    public static /* synthetic */ boolean m4620remeasure_Sx5XlM$ui_release$default(LayoutNode layoutNode, Constraints constraints, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            constraints = layoutNode.layoutDelegate.m4666getLastConstraintsDWUhwKw();
        }
        return layoutNode.m4624remeasure_Sx5XlM$ui_release(constraints);
    }

    public static /* synthetic */ void requestLookaheadRelayout$ui_release$default(LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        layoutNode.requestLookaheadRelayout$ui_release(z11);
    }

    public static /* synthetic */ void requestLookaheadRemeasure$ui_release$default(LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        layoutNode.requestLookaheadRemeasure$ui_release(z11);
    }

    public static /* synthetic */ void requestRelayout$ui_release$default(LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        layoutNode.requestRelayout$ui_release(z11);
    }

    public static /* synthetic */ void requestRemeasure$ui_release$default(LayoutNode layoutNode, boolean z11, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = false;
        }
        layoutNode.requestRemeasure$ui_release(z11);
    }

    private final void setMLookaheadScope(LookaheadScope lookaheadScope) {
        if (!Intrinsics.areEqual((Object) lookaheadScope, (Object) this.mLookaheadScope)) {
            this.mLookaheadScope = lookaheadScope;
            this.layoutDelegate.onLookaheadScopeChanged$ui_release(lookaheadScope);
            NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
            NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
            while (!Intrinsics.areEqual((Object) outerCoordinator$ui_release, (Object) wrapped$ui_release) && outerCoordinator$ui_release != null) {
                outerCoordinator$ui_release.updateLookaheadScope$ui_release(lookaheadScope);
                outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release();
            }
        }
    }

    private final boolean shouldInvalidateParentLayer() {
        boolean z11;
        NodeChain nodeChain = this.nodes;
        Nodes nodes2 = Nodes.INSTANCE;
        if (nodeChain.m4702hasH91voCI$ui_release(nodes2.m4758getDrawOLwlOKw()) && !this.nodes.m4702hasH91voCI$ui_release(nodes2.m4761getLayoutOLwlOKw())) {
            return true;
        }
        for (Modifier.Node head$ui_release = this.nodes.getHead$ui_release(); head$ui_release != null; head$ui_release = head$ui_release.getChild$ui_release()) {
            Nodes nodes3 = Nodes.INSTANCE;
            boolean z12 = false;
            if ((nodes3.m4761getLayoutOLwlOKw() & head$ui_release.getKindSet$ui_release()) != 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11 && (head$ui_release instanceof LayoutModifierNode) && DelegatableNodeKt.m4588requireCoordinator64DMado(head$ui_release, nodes3.m4761getLayoutOLwlOKw()).getLayer() != null) {
                return false;
            }
            if ((nodes3.m4758getDrawOLwlOKw() & head$ui_release.getKindSet$ui_release()) != 0) {
                z12 = true;
            }
            if (z12) {
                return true;
            }
        }
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: androidx.compose.ui.layout.LookaheadScope} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v7 */
    /* JADX WARNING: type inference failed for: r3v10 */
    /* JADX WARNING: type inference failed for: r3v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0027  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void attach$ui_release(@org.jetbrains.annotations.NotNull androidx.compose.ui.node.Owner r7) {
        /*
            r6 = this;
            java.lang.String r0 = "owner"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            androidx.compose.ui.node.Owner r0 = r6.owner
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000d
            r0 = r2
            goto L_0x000e
        L_0x000d:
            r0 = r1
        L_0x000e:
            r3 = 0
            if (r0 == 0) goto L_0x00f4
            androidx.compose.ui.node.LayoutNode r0 = r6._foldedParent
            if (r0 == 0) goto L_0x0024
            if (r0 == 0) goto L_0x001a
            androidx.compose.ui.node.Owner r0 = r0.owner
            goto L_0x001b
        L_0x001a:
            r0 = r3
        L_0x001b:
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r7)
            if (r0 == 0) goto L_0x0022
            goto L_0x0024
        L_0x0022:
            r0 = r1
            goto L_0x0025
        L_0x0024:
            r0 = r2
        L_0x0025:
            if (r0 != 0) goto L_0x0070
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Attaching to a different owner("
            r0.append(r4)
            r0.append(r7)
            java.lang.String r7 = ") than the parent's owner("
            r0.append(r7)
            androidx.compose.ui.node.LayoutNode r7 = r6.getParent$ui_release()
            if (r7 == 0) goto L_0x0042
            androidx.compose.ui.node.Owner r7 = r7.owner
            goto L_0x0043
        L_0x0042:
            r7 = r3
        L_0x0043:
            r0.append(r7)
            java.lang.String r7 = "). This tree: "
            r0.append(r7)
            java.lang.String r7 = b(r6, r1, r2, r3)
            r0.append(r7)
            java.lang.String r7 = " Parent tree: "
            r0.append(r7)
            androidx.compose.ui.node.LayoutNode r7 = r6._foldedParent
            if (r7 == 0) goto L_0x005f
            java.lang.String r3 = b(r7, r1, r2, r3)
        L_0x005f:
            r0.append(r3)
            java.lang.String r7 = r0.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        L_0x0070:
            androidx.compose.ui.node.LayoutNode r0 = r6.getParent$ui_release()
            if (r0 != 0) goto L_0x0078
            r6.isPlaced = r2
        L_0x0078:
            r6.owner = r7
            if (r0 == 0) goto L_0x007f
            int r4 = r0.depth
            goto L_0x0080
        L_0x007f:
            r4 = -1
        L_0x0080:
            int r4 = r4 + r2
            r6.depth = r4
            androidx.compose.ui.node.SemanticsModifierNode r4 = androidx.compose.ui.semantics.SemanticsNodeKt.getOuterSemantics(r6)
            if (r4 == 0) goto L_0x008c
            r7.onSemanticsChange()
        L_0x008c:
            r7.onAttach(r6)
            if (r0 == 0) goto L_0x0098
            androidx.compose.ui.layout.LookaheadScope r4 = r0.mLookaheadScope
            if (r4 != 0) goto L_0x0096
            goto L_0x0098
        L_0x0096:
            r3 = r4
            goto L_0x00a1
        L_0x0098:
            boolean r4 = r6.isLookaheadRoot
            if (r4 == 0) goto L_0x00a1
            androidx.compose.ui.layout.LookaheadScope r3 = new androidx.compose.ui.layout.LookaheadScope
            r3.<init>(r6)
        L_0x00a1:
            r6.setMLookaheadScope(r3)
            androidx.compose.ui.node.NodeChain r3 = r6.nodes
            r3.attach()
            androidx.compose.ui.node.MutableVectorWithMutationTracking<androidx.compose.ui.node.LayoutNode> r3 = r6._foldedChildren
            androidx.compose.runtime.collection.MutableVector r3 = r3.getVector()
            int r4 = r3.getSize()
            if (r4 <= 0) goto L_0x00c8
            java.lang.Object[] r3 = r3.getContent()
            java.lang.String r5 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3, r5)
        L_0x00be:
            r5 = r3[r1]
            androidx.compose.ui.node.LayoutNode r5 = (androidx.compose.ui.node.LayoutNode) r5
            r5.attach$ui_release(r7)
            int r1 = r1 + r2
            if (r1 < r4) goto L_0x00be
        L_0x00c8:
            r6.invalidateMeasurements$ui_release()
            if (r0 == 0) goto L_0x00d0
            r0.invalidateMeasurements$ui_release()
        L_0x00d0:
            androidx.compose.ui.node.NodeCoordinator r0 = r6.getOuterCoordinator$ui_release()
            androidx.compose.ui.node.NodeCoordinator r1 = r6.getInnerCoordinator$ui_release()
            androidx.compose.ui.node.NodeCoordinator r1 = r1.getWrapped$ui_release()
        L_0x00dc:
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r2 != 0) goto L_0x00ec
            if (r0 == 0) goto L_0x00ec
            r0.attach()
            androidx.compose.ui.node.NodeCoordinator r0 = r0.getWrapped$ui_release()
            goto L_0x00dc
        L_0x00ec:
            kotlin.jvm.functions.Function1<? super androidx.compose.ui.node.Owner, kotlin.Unit> r0 = r6.onAttach
            if (r0 == 0) goto L_0x00f3
            r0.invoke(r7)
        L_0x00f3:
            return
        L_0x00f4:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Cannot attach "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r0 = " as it already is attached.  Tree: "
            r7.append(r0)
            java.lang.String r0 = b(r6, r1, r2, r3)
            r7.append(r0)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r0.<init>(r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.attach$ui_release(androidx.compose.ui.node.Owner):void");
    }

    public final void checkChildrenPlaceOrderForUpdates$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i11];
                if (layoutNode.previousPlaceOrder != layoutNode.placeOrder) {
                    onZSortedChildrenInvalidated$ui_release();
                    invalidateLayer$ui_release();
                    if (layoutNode.placeOrder == Integer.MAX_VALUE) {
                        layoutNode.markSubtreeAsNotPlaced();
                    }
                }
                i11++;
            } while (i11 < size);
        }
    }

    public final void clearPlaceOrder$ui_release() {
        int i11 = 0;
        this.nextChildPlaceOrder = 0;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                LayoutNode layoutNode = (LayoutNode) content[i11];
                layoutNode.previousPlaceOrder = layoutNode.placeOrder;
                layoutNode.placeOrder = Integer.MAX_VALUE;
                if (layoutNode.measuredByParent == UsageByParent.InLayoutBlock) {
                    layoutNode.measuredByParent = UsageByParent.NotUsed;
                }
                i11++;
            } while (i11 < size);
        }
    }

    public final void clearSubtreeIntrinsicsUsage$ui_release() {
        this.previousIntrinsicsUsageByParent = this.intrinsicsUsageByParent;
        this.intrinsicsUsageByParent = UsageByParent.NotUsed;
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i11];
                if (layoutNode.intrinsicsUsageByParent != UsageByParent.NotUsed) {
                    layoutNode.clearSubtreeIntrinsicsUsage$ui_release();
                }
                i11++;
            } while (i11 < size);
        }
    }

    public final void detach$ui_release() {
        Owner owner2 = this.owner;
        String str = null;
        if (owner2 == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Cannot detach node that is already detached!  Tree: ");
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                str = b(parent$ui_release, 0, 1, (Object) null);
            }
            sb2.append(str);
            throw new IllegalStateException(sb2.toString().toString());
        }
        LayoutNode parent$ui_release2 = getParent$ui_release();
        if (parent$ui_release2 != null) {
            parent$ui_release2.invalidateLayer$ui_release();
            parent$ui_release2.invalidateMeasurements$ui_release();
            this.measuredByParent = UsageByParent.NotUsed;
        }
        this.layoutDelegate.resetAlignmentLines();
        Function1<? super Owner, Unit> function1 = this.onDetach;
        if (function1 != null) {
            function1.invoke(owner2);
        }
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
        while (!Intrinsics.areEqual((Object) outerCoordinator$ui_release, (Object) wrapped$ui_release) && outerCoordinator$ui_release != null) {
            outerCoordinator$ui_release.detach();
            outerCoordinator$ui_release = outerCoordinator$ui_release.getWrapped$ui_release();
        }
        if (SemanticsNodeKt.getOuterSemantics(this) != null) {
            owner2.onSemanticsChange();
        }
        this.nodes.detach$ui_release();
        owner2.onDetach(this);
        this.owner = null;
        this.depth = 0;
        MutableVector<LayoutNode> vector = this._foldedChildren.getVector();
        int size = vector.getSize();
        if (size > 0) {
            Object[] content = vector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                ((LayoutNode) content[i11]).detach$ui_release();
                i11++;
            } while (i11 < size);
        }
        this.placeOrder = Integer.MAX_VALUE;
        this.previousPlaceOrder = Integer.MAX_VALUE;
        this.isPlaced = false;
    }

    public final void dispatchOnPositionedCallbacks$ui_release() {
        if (getLayoutState$ui_release() == LayoutState.Idle && !getLayoutPending$ui_release() && !getMeasurePending$ui_release() && isPlaced()) {
            NodeChain nodeChain = this.nodes;
            int r12 = Nodes.INSTANCE.m4759getGlobalPositionAwareOLwlOKw();
            if ((nodeChain.getAggregateChildKindSet() & r12) != 0) {
                Modifier.Node head$ui_release = nodeChain.getHead$ui_release();
                while (head$ui_release != null) {
                    if ((head$ui_release.getKindSet$ui_release() & r12) != 0 && (head$ui_release instanceof GlobalPositionAwareModifierNode)) {
                        GlobalPositionAwareModifierNode globalPositionAwareModifierNode = (GlobalPositionAwareModifierNode) head$ui_release;
                        globalPositionAwareModifierNode.onGloballyPositioned(DelegatableNodeKt.m4588requireCoordinator64DMado(globalPositionAwareModifierNode, Nodes.INSTANCE.m4759getGlobalPositionAwareOLwlOKw()));
                    }
                    if ((head$ui_release.getAggregateChildKindSet$ui_release() & r12) != 0) {
                        head$ui_release = head$ui_release.getChild$ui_release();
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public final void draw$ui_release(@NotNull Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getOuterCoordinator$ui_release().draw(canvas);
    }

    public final void forEachChild(@NotNull Function1<? super LayoutNode, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                function1.invoke(content[i11]);
                i11++;
            } while (i11 < size);
        }
    }

    public final void forEachChildIndexed(@NotNull Function2<? super Integer, ? super LayoutNode, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                function2.invoke(Integer.valueOf(i11), content[i11]);
                i11++;
            } while (i11 < size);
        }
    }

    public void forceRemeasure() {
        requestRemeasure$ui_release$default(this, false, 1, (Object) null);
        Constraints r32 = this.layoutDelegate.m4666getLastConstraintsDWUhwKw();
        if (r32 != null) {
            Owner owner2 = this.owner;
            if (owner2 != null) {
                owner2.m4777measureAndLayout0kLqBqw(this, r32.m5428unboximpl());
                return;
            }
            return;
        }
        Owner owner3 = this.owner;
        if (owner3 != null) {
            d.d(owner3, false, 1, (Object) null);
        }
    }

    public final boolean getAlignmentLinesRequired$ui_release() {
        boolean z11;
        AlignmentLines alignmentLines;
        LayoutNodeLayoutDelegate layoutNodeLayoutDelegate = this.layoutDelegate;
        if (layoutNodeLayoutDelegate.getAlignmentLinesOwner$ui_release().getAlignmentLines().getRequired$ui_release()) {
            return true;
        }
        AlignmentLinesOwner lookaheadAlignmentLinesOwner$ui_release = layoutNodeLayoutDelegate.getLookaheadAlignmentLinesOwner$ui_release();
        if (lookaheadAlignmentLinesOwner$ui_release == null || (alignmentLines = lookaheadAlignmentLinesOwner$ui_release.getAlignmentLines()) == null || !alignmentLines.getRequired$ui_release()) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    public final boolean getCanMultiMeasure$ui_release() {
        return this.canMultiMeasure;
    }

    @NotNull
    public final List<Measurable> getChildLookaheadMeasurables$ui_release() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        return lookaheadPassDelegate.getChildMeasurables$ui_release();
    }

    @NotNull
    public final List<Measurable> getChildMeasurables$ui_release() {
        return getMeasurePassDelegate().getChildMeasurables$ui_release();
    }

    @NotNull
    public final List<LayoutNode> getChildren$ui_release() {
        return get_children$ui_release().asMutableList();
    }

    @NotNull
    public LayoutCoordinates getCoordinates() {
        return getInnerCoordinator$ui_release();
    }

    @NotNull
    public Density getDensity() {
        return this.density;
    }

    public final int getDepth$ui_release() {
        return this.depth;
    }

    @NotNull
    public final List<LayoutNode> getFoldedChildren$ui_release() {
        return this._foldedChildren.asList();
    }

    public int getHeight() {
        return this.layoutDelegate.getHeight$ui_release();
    }

    @NotNull
    public final NodeCoordinator getInnerCoordinator$ui_release() {
        return this.nodes.getInnerCoordinator$ui_release();
    }

    public final boolean getInnerLayerCoordinatorIsDirty$ui_release() {
        return this.innerLayerCoordinatorIsDirty;
    }

    @NotNull
    public final IntrinsicsPolicy getIntrinsicsPolicy$ui_release() {
        return this.intrinsicsPolicy;
    }

    @NotNull
    public final UsageByParent getIntrinsicsUsageByParent$ui_release() {
        return this.intrinsicsUsageByParent;
    }

    @NotNull
    public final LayoutNodeLayoutDelegate getLayoutDelegate$ui_release() {
        return this.layoutDelegate;
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    public final boolean getLayoutPending$ui_release() {
        return this.layoutDelegate.getLayoutPending$ui_release();
    }

    @NotNull
    public final LayoutState getLayoutState$ui_release() {
        return this.layoutDelegate.getLayoutState$ui_release();
    }

    public final boolean getLookaheadLayoutPending$ui_release() {
        return this.layoutDelegate.getLookaheadLayoutPending$ui_release();
    }

    public final boolean getLookaheadMeasurePending$ui_release() {
        return this.layoutDelegate.getLookaheadMeasurePending$ui_release();
    }

    @NotNull
    public final LayoutNodeDrawScope getMDrawScope$ui_release() {
        return LayoutNodeKt.requireOwner(this).getSharedDrawScope();
    }

    @Nullable
    public final LookaheadScope getMLookaheadScope$ui_release() {
        return this.mLookaheadScope;
    }

    public final boolean getMeasurePending$ui_release() {
        return this.layoutDelegate.getMeasurePending$ui_release();
    }

    @NotNull
    public MeasurePolicy getMeasurePolicy() {
        return this.measurePolicy;
    }

    @NotNull
    public final UsageByParent getMeasuredByParent$ui_release() {
        return this.measuredByParent;
    }

    @NotNull
    public final UsageByParent getMeasuredByParentInLookahead$ui_release() {
        return this.measuredByParentInLookahead;
    }

    @NotNull
    public Modifier getModifier() {
        return this.modifier;
    }

    @NotNull
    public List<ModifierInfo> getModifierInfo() {
        return this.nodes.getModifierInfo();
    }

    public final boolean getNeedsOnPositionedDispatch$ui_release() {
        return this.needsOnPositionedDispatch;
    }

    @NotNull
    public final NodeChain getNodes$ui_release() {
        return this.nodes;
    }

    @Nullable
    public final Function1<Owner, Unit> getOnAttach$ui_release() {
        return this.onAttach;
    }

    @Nullable
    public final Function1<Owner, Unit> getOnDetach$ui_release() {
        return this.onDetach;
    }

    @NotNull
    public final NodeCoordinator getOuterCoordinator$ui_release() {
        return this.nodes.getOuterCoordinator$ui_release();
    }

    @Nullable
    public final Owner getOwner$ui_release() {
        return this.owner;
    }

    @Nullable
    public final LayoutNode getParent$ui_release() {
        LayoutNode layoutNode = this._foldedParent;
        boolean z11 = false;
        if (layoutNode != null && layoutNode.isVirtual) {
            z11 = true;
        }
        if (!z11) {
            return layoutNode;
        }
        if (layoutNode != null) {
            return layoutNode.getParent$ui_release();
        }
        return null;
    }

    @Nullable
    public LayoutInfo getParentInfo() {
        return getParent$ui_release();
    }

    public final int getPlaceOrder$ui_release() {
        return this.placeOrder;
    }

    public final int getPreviousPlaceOrder$ui_release() {
        return this.previousPlaceOrder;
    }

    public int getSemanticsId() {
        return this.semanticsId;
    }

    @Nullable
    public final LayoutNodeSubcompositionsState getSubcompositionsState$ui_release() {
        return this.subcompositionsState;
    }

    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    public int getWidth() {
        return this.layoutDelegate.getWidth$ui_release();
    }

    @NotNull
    public final MutableVector<LayoutNode> getZSortedChildren() {
        if (this.zSortedChildrenInvalidated) {
            this._zSortedChildren.clear();
            MutableVector<LayoutNode> mutableVector = this._zSortedChildren;
            mutableVector.addAll(mutableVector.getSize(), get_children$ui_release());
            this._zSortedChildren.sortWith(ZComparator);
            this.zSortedChildrenInvalidated = false;
        }
        return this._zSortedChildren;
    }

    @NotNull
    public final MutableVector<LayoutNode> get_children$ui_release() {
        updateChildrenIfDirty$ui_release();
        if (this.virtualChildrenCount == 0) {
            return this._foldedChildren.getVector();
        }
        MutableVector<LayoutNode> mutableVector = this._unfoldedChildren;
        Intrinsics.checkNotNull(mutableVector);
        return mutableVector;
    }

    /* renamed from: hitTest-M_7yMNQ$ui_release  reason: not valid java name */
    public final void m4621hitTestM_7yMNQ$ui_release(long j11, @NotNull HitTestResult<PointerInputModifierNode> hitTestResult, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitTestResult");
        getOuterCoordinator$ui_release().m4726hitTestYqVAtuI(NodeCoordinator.Companion.getPointerInputSource(), getOuterCoordinator$ui_release().m4719fromParentPositionMKHz9U(j11), hitTestResult, z11, z12);
    }

    /* renamed from: hitTestSemantics-M_7yMNQ$ui_release  reason: not valid java name */
    public final void m4622hitTestSemanticsM_7yMNQ$ui_release(long j11, @NotNull HitTestResult<SemanticsModifierNode> hitTestResult, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(hitTestResult, "hitSemanticsEntities");
        getOuterCoordinator$ui_release().m4726hitTestYqVAtuI(NodeCoordinator.Companion.getSemanticsSource(), getOuterCoordinator$ui_release().m4719fromParentPositionMKHz9U(j11), hitTestResult, true, z12);
    }

    public final void ignoreRemeasureRequests$ui_release(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        this.ignoreRemeasureRequests = true;
        function0.invoke();
        this.ignoreRemeasureRequests = false;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.String} */
    /* JADX WARNING: type inference failed for: r5v0 */
    /* JADX WARNING: type inference failed for: r5v1, types: [androidx.compose.ui.node.NodeCoordinator] */
    /* JADX WARNING: type inference failed for: r5v6 */
    /* JADX WARNING: type inference failed for: r5v7 */
    /* JADX WARNING: type inference failed for: r5v8 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:46:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void insertAt$ui_release(int r7, @org.jetbrains.annotations.NotNull androidx.compose.ui.node.LayoutNode r8) {
        /*
            r6 = this;
            java.lang.String r0 = "instance"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            androidx.compose.ui.node.LayoutNode r0 = r8._foldedParent
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x000d
            r0 = r2
            goto L_0x000e
        L_0x000d:
            r0 = r1
        L_0x000e:
            java.lang.String r3 = " Other tree: "
            java.lang.String r4 = "Cannot insert "
            r5 = 0
            if (r0 != 0) goto L_0x0048
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            r7.append(r8)
            java.lang.String r0 = " because it already has a parent. This tree: "
            r7.append(r0)
            java.lang.String r0 = b(r6, r1, r2, r5)
            r7.append(r0)
            r7.append(r3)
            androidx.compose.ui.node.LayoutNode r8 = r8._foldedParent
            if (r8 == 0) goto L_0x0037
            java.lang.String r5 = b(r8, r1, r2, r5)
        L_0x0037:
            r7.append(r5)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        L_0x0048:
            androidx.compose.ui.node.Owner r0 = r8.owner
            if (r0 != 0) goto L_0x004e
            r0 = r2
            goto L_0x004f
        L_0x004e:
            r0 = r1
        L_0x004f:
            if (r0 == 0) goto L_0x00d6
            r8._foldedParent = r6
            androidx.compose.ui.node.MutableVectorWithMutationTracking<androidx.compose.ui.node.LayoutNode> r0 = r6._foldedChildren
            r0.add(r7, r8)
            r6.onZSortedChildrenInvalidated$ui_release()
            boolean r7 = r8.isVirtual
            if (r7 == 0) goto L_0x0076
            boolean r7 = r6.isVirtual
            r7 = r7 ^ r2
            if (r7 == 0) goto L_0x006a
            int r7 = r6.virtualChildrenCount
            int r7 = r7 + r2
            r6.virtualChildrenCount = r7
            goto L_0x0076
        L_0x006a:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Virtual LayoutNode can't be added into a virtual parent"
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        L_0x0076:
            r6.invalidateUnfoldedVirtualChildren()
            androidx.compose.ui.node.NodeCoordinator r7 = r8.getOuterCoordinator$ui_release()
            boolean r0 = r6.isVirtual
            if (r0 == 0) goto L_0x008a
            androidx.compose.ui.node.LayoutNode r0 = r6._foldedParent
            if (r0 == 0) goto L_0x008e
            androidx.compose.ui.node.NodeCoordinator r5 = r0.getInnerCoordinator$ui_release()
            goto L_0x008e
        L_0x008a:
            androidx.compose.ui.node.NodeCoordinator r5 = r6.getInnerCoordinator$ui_release()
        L_0x008e:
            r7.setWrappedBy$ui_release(r5)
            boolean r7 = r8.isVirtual
            if (r7 == 0) goto L_0x00bc
            androidx.compose.ui.node.MutableVectorWithMutationTracking<androidx.compose.ui.node.LayoutNode> r7 = r8._foldedChildren
            androidx.compose.runtime.collection.MutableVector r7 = r7.getVector()
            int r0 = r7.getSize()
            if (r0 <= 0) goto L_0x00bc
            java.lang.Object[] r7 = r7.getContent()
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7, r3)
        L_0x00aa:
            r3 = r7[r1]
            androidx.compose.ui.node.LayoutNode r3 = (androidx.compose.ui.node.LayoutNode) r3
            androidx.compose.ui.node.NodeCoordinator r3 = r3.getOuterCoordinator$ui_release()
            androidx.compose.ui.node.NodeCoordinator r4 = r6.getInnerCoordinator$ui_release()
            r3.setWrappedBy$ui_release(r4)
            int r1 = r1 + r2
            if (r1 < r0) goto L_0x00aa
        L_0x00bc:
            androidx.compose.ui.node.Owner r7 = r6.owner
            if (r7 == 0) goto L_0x00c3
            r8.attach$ui_release(r7)
        L_0x00c3:
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r7 = r8.layoutDelegate
            int r7 = r7.getChildrenAccessingCoordinatesDuringPlacement()
            if (r7 <= 0) goto L_0x00d5
            androidx.compose.ui.node.LayoutNodeLayoutDelegate r7 = r6.layoutDelegate
            int r8 = r7.getChildrenAccessingCoordinatesDuringPlacement()
            int r8 = r8 + r2
            r7.setChildrenAccessingCoordinatesDuringPlacement(r8)
        L_0x00d5:
            return
        L_0x00d6:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            r7.append(r4)
            r7.append(r8)
            java.lang.String r0 = " because it already has an owner. This tree: "
            r7.append(r0)
            java.lang.String r0 = b(r6, r1, r2, r5)
            r7.append(r0)
            r7.append(r3)
            java.lang.String r8 = b(r8, r1, r2, r5)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r7 = r7.toString()
            r8.<init>(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutNode.insertAt$ui_release(int, androidx.compose.ui.node.LayoutNode):void");
    }

    public final void invalidateLayer$ui_release() {
        NodeCoordinator innerLayerCoordinator = getInnerLayerCoordinator();
        if (innerLayerCoordinator != null) {
            innerLayerCoordinator.invalidateLayer();
            return;
        }
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            parent$ui_release.invalidateLayer$ui_release();
        }
    }

    public final void invalidateLayers$ui_release() {
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            OwnedLayer layer = layoutModifierNodeCoordinator.getLayer();
            if (layer != null) {
                layer.invalidate();
            }
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
        }
        OwnedLayer layer2 = getInnerCoordinator$ui_release().getLayer();
        if (layer2 != null) {
            layer2.invalidate();
        }
    }

    public final void invalidateMeasurements$ui_release() {
        if (this.mLookaheadScope != null) {
            requestLookaheadRemeasure$ui_release$default(this, false, 1, (Object) null);
        } else {
            requestRemeasure$ui_release$default(this, false, 1, (Object) null);
        }
    }

    public boolean isAttached() {
        return this.owner != null;
    }

    public final boolean isLookaheadRoot() {
        return this.isLookaheadRoot;
    }

    public boolean isPlaced() {
        return this.isPlaced;
    }

    @Nullable
    public final Boolean isPlacedInLookahead() {
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        if (lookaheadPassDelegate != null) {
            return Boolean.valueOf(lookaheadPassDelegate.isPlaced());
        }
        return null;
    }

    public boolean isValid() {
        return isAttached();
    }

    /* renamed from: lookaheadRemeasure-_Sx5XlM$ui_release  reason: not valid java name */
    public final boolean m4623lookaheadRemeasure_Sx5XlM$ui_release(@Nullable Constraints constraints) {
        if (constraints == null || this.mLookaheadScope == null) {
            return false;
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        return lookaheadPassDelegate.m4670remeasureBRTryo0(constraints.m5428unboximpl());
    }

    public final void lookaheadReplace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
        Intrinsics.checkNotNull(lookaheadPassDelegate);
        lookaheadPassDelegate.replace();
    }

    public final void markLayoutPending$ui_release() {
        this.layoutDelegate.markLayoutPending$ui_release();
    }

    public final void markLookaheadLayoutPending$ui_release() {
        this.layoutDelegate.markLookaheadLayoutPending$ui_release();
    }

    public final void markLookaheadMeasurePending$ui_release() {
        this.layoutDelegate.markLookaheadMeasurePending$ui_release();
    }

    public final void markMeasurePending$ui_release() {
        this.layoutDelegate.markMeasurePending$ui_release();
    }

    public final void move$ui_release(int i11, int i12, int i13) {
        int i14;
        int i15;
        if (i11 != i12) {
            for (int i16 = 0; i16 < i13; i16++) {
                if (i11 > i12) {
                    i14 = i11 + i16;
                } else {
                    i14 = i11;
                }
                if (i11 > i12) {
                    i15 = i12 + i16;
                } else {
                    i15 = (i12 + i13) - 2;
                }
                this._foldedChildren.add(i15, this._foldedChildren.removeAt(i14));
            }
            onZSortedChildrenInvalidated$ui_release();
            invalidateUnfoldedVirtualChildren();
            invalidateMeasurements$ui_release();
        }
    }

    public void onLayoutComplete() {
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        int r12 = Nodes.INSTANCE.m4762getLayoutAwareOLwlOKw();
        boolean r22 = NodeKindKt.m4753getIncludeSelfInTraversalH91voCI(r12);
        Modifier.Node tail = innerCoordinator$ui_release.getTail();
        if (r22 || (tail = tail.getParent$ui_release()) != null) {
            Modifier.Node access$headNode = innerCoordinator$ui_release.headNode(r22);
            while (access$headNode != null && (access$headNode.getAggregateChildKindSet$ui_release() & r12) != 0) {
                if ((access$headNode.getKindSet$ui_release() & r12) != 0 && (access$headNode instanceof LayoutAwareModifierNode)) {
                    ((LayoutAwareModifierNode) access$headNode).onPlaced(getInnerCoordinator$ui_release());
                }
                if (access$headNode != tail) {
                    access$headNode = access$headNode.getChild$ui_release();
                } else {
                    return;
                }
            }
        }
    }

    public final void onNodePlaced$ui_release() {
        boolean z11;
        LayoutNode parent$ui_release = getParent$ui_release();
        float zIndex2 = getInnerCoordinator$ui_release().getZIndex();
        NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
        NodeCoordinator innerCoordinator$ui_release = getInnerCoordinator$ui_release();
        while (outerCoordinator$ui_release != innerCoordinator$ui_release) {
            Intrinsics.checkNotNull(outerCoordinator$ui_release, "null cannot be cast to non-null type androidx.compose.ui.node.LayoutModifierNodeCoordinator");
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = (LayoutModifierNodeCoordinator) outerCoordinator$ui_release;
            zIndex2 += layoutModifierNodeCoordinator.getZIndex();
            outerCoordinator$ui_release = layoutModifierNodeCoordinator.getWrapped$ui_release();
        }
        boolean z12 = false;
        if (zIndex2 == this.zIndex) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            this.zIndex = zIndex2;
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
            }
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
        }
        if (!isPlaced()) {
            if (parent$ui_release != null) {
                parent$ui_release.invalidateLayer$ui_release();
            }
            markNodeAndSubtreeAsPlaced();
        }
        if (parent$ui_release == null) {
            this.placeOrder = 0;
        } else if (!this.relayoutWithoutParentInProgress && parent$ui_release.getLayoutState$ui_release() == LayoutState.LayingOut) {
            if (this.placeOrder == Integer.MAX_VALUE) {
                z12 = true;
            }
            if (z12) {
                int i11 = parent$ui_release.nextChildPlaceOrder;
                this.placeOrder = i11;
                parent$ui_release.nextChildPlaceOrder = i11 + 1;
            } else {
                throw new IllegalStateException("Place was called on a node which was placed already".toString());
            }
        }
        this.layoutDelegate.getAlignmentLinesOwner$ui_release().layoutChildren();
    }

    public final void onZSortedChildrenInvalidated$ui_release() {
        if (this.isVirtual) {
            LayoutNode parent$ui_release = getParent$ui_release();
            if (parent$ui_release != null) {
                parent$ui_release.onZSortedChildrenInvalidated$ui_release();
                return;
            }
            return;
        }
        this.zSortedChildrenInvalidated = true;
    }

    public final void place$ui_release(int i11, int i12) {
        NodeCoordinator nodeCoordinator;
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        LayoutNodeLayoutDelegate.MeasurePassDelegate measurePassDelegate = getMeasurePassDelegate();
        Placeable.PlacementScope.Companion companion = Placeable.PlacementScope.Companion;
        int measuredWidth = measurePassDelegate.getMeasuredWidth();
        LayoutDirection layoutDirection2 = getLayoutDirection();
        LayoutNode parent$ui_release = getParent$ui_release();
        if (parent$ui_release != null) {
            nodeCoordinator = parent$ui_release.getInnerCoordinator$ui_release();
        } else {
            nodeCoordinator = null;
        }
        NodeCoordinator nodeCoordinator2 = nodeCoordinator;
        LayoutCoordinates access$get_coordinates$cp = Placeable.PlacementScope._coordinates;
        int access$getParentWidth = companion.b();
        LayoutDirection access$getParentLayoutDirection = companion.a();
        LayoutNodeLayoutDelegate access$getLayoutDelegate$cp = Placeable.PlacementScope.layoutDelegate;
        Placeable.PlacementScope.parentWidth = measuredWidth;
        Placeable.PlacementScope.parentLayoutDirection = layoutDirection2;
        boolean access$configureForPlacingForAlignment = companion.configureForPlacingForAlignment(nodeCoordinator2);
        Placeable.PlacementScope.placeRelative$default(companion, measurePassDelegate, i11, i12, 0.0f, 4, (Object) null);
        if (nodeCoordinator2 != null) {
            nodeCoordinator2.setPlacingForAlignment$ui_release(access$configureForPlacingForAlignment);
        }
        Placeable.PlacementScope.parentWidth = access$getParentWidth;
        Placeable.PlacementScope.parentLayoutDirection = access$getParentLayoutDirection;
        Placeable.PlacementScope._coordinates = access$get_coordinates$cp;
        Placeable.PlacementScope.layoutDelegate = access$getLayoutDelegate$cp;
    }

    /* renamed from: remeasure-_Sx5XlM$ui_release  reason: not valid java name */
    public final boolean m4624remeasure_Sx5XlM$ui_release(@Nullable Constraints constraints) {
        if (constraints == null) {
            return false;
        }
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreeIntrinsicsUsage$ui_release();
        }
        return getMeasurePassDelegate().m4674remeasureBRTryo0(constraints.m5428unboximpl());
    }

    public final void removeAll$ui_release() {
        int size = this._foldedChildren.getSize();
        while (true) {
            size--;
            if (-1 < size) {
                onChildRemoved(this._foldedChildren.get(size));
            } else {
                this._foldedChildren.clear();
                return;
            }
        }
    }

    public final void removeAt$ui_release(int i11, int i12) {
        boolean z11;
        if (i12 >= 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            int i13 = (i12 + i11) - 1;
            if (i11 <= i13) {
                while (true) {
                    onChildRemoved(this._foldedChildren.removeAt(i13));
                    if (i13 != i11) {
                        i13--;
                    } else {
                        return;
                    }
                }
            }
        } else {
            throw new IllegalArgumentException(("count (" + i12 + ") must be greater than 0").toString());
        }
    }

    /* JADX INFO: finally extract failed */
    public final void replace$ui_release() {
        if (this.intrinsicsUsageByParent == UsageByParent.NotUsed) {
            clearSubtreePlacementIntrinsicsUsage();
        }
        try {
            this.relayoutWithoutParentInProgress = true;
            getMeasurePassDelegate().replace();
            this.relayoutWithoutParentInProgress = false;
        } catch (Throwable th2) {
            this.relayoutWithoutParentInProgress = false;
            throw th2;
        }
    }

    public final void requestLookaheadRelayout$ui_release(boolean z11) {
        Owner owner2;
        if (!this.isVirtual && (owner2 = this.owner) != null) {
            owner2.onRequestRelayout(this, true, z11);
        }
    }

    public final void requestLookaheadRemeasure$ui_release(boolean z11) {
        boolean z12;
        if (this.mLookaheadScope != null) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            Owner owner2 = this.owner;
            if (owner2 != null && !this.ignoreRemeasureRequests && !this.isVirtual) {
                owner2.onRequestMeasure(this, true, z11);
                LayoutNodeLayoutDelegate.LookaheadPassDelegate lookaheadPassDelegate = getLookaheadPassDelegate();
                Intrinsics.checkNotNull(lookaheadPassDelegate);
                lookaheadPassDelegate.invalidateIntrinsicsParent(z11);
                return;
            }
            return;
        }
        throw new IllegalStateException("Lookahead measure cannot be requested on a node that is not a part of theLookaheadLayout".toString());
    }

    public final void requestRelayout$ui_release(boolean z11) {
        Owner owner2;
        if (!this.isVirtual && (owner2 = this.owner) != null) {
            d.f(owner2, this, false, z11, 2, (Object) null);
        }
    }

    public final void requestRemeasure$ui_release(boolean z11) {
        Owner owner2;
        if (!this.ignoreRemeasureRequests && !this.isVirtual && (owner2 = this.owner) != null) {
            d.e(owner2, this, false, z11, 2, (Object) null);
            getMeasurePassDelegate().invalidateIntrinsicsParent(z11);
        }
    }

    public final void rescheduleRemeasureOrRelayout$ui_release(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "it");
        if (WhenMappings.$EnumSwitchMapping$0[layoutNode.getLayoutState$ui_release().ordinal()] != 1) {
            throw new IllegalStateException("Unexpected state " + layoutNode.getLayoutState$ui_release());
        } else if (layoutNode.getMeasurePending$ui_release()) {
            layoutNode.requestRemeasure$ui_release(true);
        } else if (layoutNode.getLayoutPending$ui_release()) {
            layoutNode.requestRelayout$ui_release(true);
        } else if (layoutNode.getLookaheadMeasurePending$ui_release()) {
            layoutNode.requestLookaheadRemeasure$ui_release(true);
        } else if (layoutNode.getLookaheadLayoutPending$ui_release()) {
            layoutNode.requestLookaheadRelayout$ui_release(true);
        }
    }

    public final void resetSubtreeIntrinsicsUsage$ui_release() {
        MutableVector<LayoutNode> mutableVector = get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                LayoutNode layoutNode = (LayoutNode) content[i11];
                UsageByParent usageByParent = layoutNode.previousIntrinsicsUsageByParent;
                layoutNode.intrinsicsUsageByParent = usageByParent;
                if (usageByParent != UsageByParent.NotUsed) {
                    layoutNode.resetSubtreeIntrinsicsUsage$ui_release();
                }
                i11++;
            } while (i11 < size);
        }
    }

    public final void setCanMultiMeasure$ui_release(boolean z11) {
        this.canMultiMeasure = z11;
    }

    public void setDensity(@NotNull Density density2) {
        Intrinsics.checkNotNullParameter(density2, "value");
        if (!Intrinsics.areEqual((Object) this.density, (Object) density2)) {
            this.density = density2;
            onDensityOrLayoutDirectionChanged();
        }
    }

    public final void setDepth$ui_release(int i11) {
        this.depth = i11;
    }

    public final void setInnerLayerCoordinatorIsDirty$ui_release(boolean z11) {
        this.innerLayerCoordinatorIsDirty = z11;
    }

    public final void setIntrinsicsUsageByParent$ui_release(@NotNull UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.intrinsicsUsageByParent = usageByParent;
    }

    public void setLayoutDirection(@NotNull LayoutDirection layoutDirection2) {
        Intrinsics.checkNotNullParameter(layoutDirection2, "value");
        if (this.layoutDirection != layoutDirection2) {
            this.layoutDirection = layoutDirection2;
            onDensityOrLayoutDirectionChanged();
        }
    }

    public final void setLookaheadRoot(boolean z11) {
        if (z11 != this.isLookaheadRoot) {
            if (!z11) {
                setMLookaheadScope((LookaheadScope) null);
            } else {
                setMLookaheadScope(new LookaheadScope(this));
            }
            this.isLookaheadRoot = z11;
        }
    }

    public void setMeasurePolicy(@NotNull MeasurePolicy measurePolicy2) {
        Intrinsics.checkNotNullParameter(measurePolicy2, "value");
        if (!Intrinsics.areEqual((Object) this.measurePolicy, (Object) measurePolicy2)) {
            this.measurePolicy = measurePolicy2;
            this.intrinsicsPolicy.updateFrom(getMeasurePolicy());
            invalidateMeasurements$ui_release();
        }
    }

    public final void setMeasuredByParent$ui_release(@NotNull UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.measuredByParent = usageByParent;
    }

    public final void setMeasuredByParentInLookahead$ui_release(@NotNull UsageByParent usageByParent) {
        Intrinsics.checkNotNullParameter(usageByParent, "<set-?>");
        this.measuredByParentInLookahead = usageByParent;
    }

    public void setModifier(@NotNull Modifier modifier2) {
        boolean z11;
        LayoutNode parent$ui_release;
        Intrinsics.checkNotNullParameter(modifier2, "value");
        if (!Intrinsics.areEqual((Object) modifier2, (Object) this.modifier)) {
            if (!this.isVirtual || getModifier() == Modifier.Companion) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                this.modifier = modifier2;
                boolean shouldInvalidateParentLayer = shouldInvalidateParentLayer();
                NodeCoordinator outerCoordinator$ui_release = getOuterCoordinator$ui_release();
                this.nodes.updateFrom$ui_release(modifier2);
                NodeCoordinator outerCoordinator$ui_release2 = getOuterCoordinator$ui_release();
                NodeCoordinator wrapped$ui_release = getInnerCoordinator$ui_release().getWrapped$ui_release();
                while (!Intrinsics.areEqual((Object) outerCoordinator$ui_release2, (Object) wrapped$ui_release) && outerCoordinator$ui_release2 != null) {
                    outerCoordinator$ui_release2.onInitialize();
                    outerCoordinator$ui_release2.updateLookaheadScope$ui_release(this.mLookaheadScope);
                    outerCoordinator$ui_release2 = outerCoordinator$ui_release2.getWrapped$ui_release();
                }
                this.layoutDelegate.updateParentData();
                if ((shouldInvalidateParentLayer || shouldInvalidateParentLayer()) && (parent$ui_release = getParent$ui_release()) != null) {
                    parent$ui_release.invalidateLayer$ui_release();
                }
                if (!Intrinsics.areEqual((Object) outerCoordinator$ui_release, (Object) getInnerCoordinator$ui_release()) || !Intrinsics.areEqual((Object) getOuterCoordinator$ui_release(), (Object) getInnerCoordinator$ui_release())) {
                    invalidateMeasurements$ui_release();
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Modifiers are not supported on virtual LayoutNodes".toString());
        }
    }

    public final void setNeedsOnPositionedDispatch$ui_release(boolean z11) {
        this.needsOnPositionedDispatch = z11;
    }

    public final void setOnAttach$ui_release(@Nullable Function1<? super Owner, Unit> function1) {
        this.onAttach = function1;
    }

    public final void setOnDetach$ui_release(@Nullable Function1<? super Owner, Unit> function1) {
        this.onDetach = function1;
    }

    public final void setSubcompositionsState$ui_release(@Nullable LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.subcompositionsState = layoutNodeSubcompositionsState;
    }

    public void setViewConfiguration(@NotNull ViewConfiguration viewConfiguration2) {
        Intrinsics.checkNotNullParameter(viewConfiguration2, "<set-?>");
        this.viewConfiguration = viewConfiguration2;
    }

    @NotNull
    public String toString() {
        return JvmActuals_jvmKt.simpleIdentityToString(this, (String) null) + " children: " + getChildren$ui_release().size() + " measurePolicy: " + getMeasurePolicy();
    }

    public final void updateChildrenIfDirty$ui_release() {
        if (this.virtualChildrenCount > 0) {
            recreateUnfoldedChildrenIfDirty();
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LayoutNode(boolean z11, int i11, int i12, DefaultConstructorMarker defaultConstructorMarker) {
        this((i12 & 1) != 0 ? false : z11, (i12 & 2) != 0 ? SemanticsModifierCore.Companion.generateSemanticsId() : i11);
    }
}
