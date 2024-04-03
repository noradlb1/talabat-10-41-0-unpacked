package androidx.compose.ui.text;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextForegroundStyle;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Immutable
@Metadata(d1 = {"\u0000´\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\bA\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\b\u0007\u0018\u0000 \u00012\u00020\u0001:\u0002\u0001B\u0017\b\u0010\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BØ\u0001\b\u0016\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'ø\u0001\u0000¢\u0006\u0002\u0010(Bð\u0001\b\u0016\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,ø\u0001\u0000¢\u0006\u0002\u0010-B\u0002\b\u0017\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101ø\u0001\u0000¢\u0006\u0002\u00102B\u0002\b\u0017\u0012\b\u00103\u001a\u0004\u0018\u000104\u0012\b\b\u0002\u00105\u001a\u000206\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\n\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u0017\u0012\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b\u0012\b\b\u0002\u0010\u001c\u001a\u00020\b\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e\u0012\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 \u0012\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"\u0012\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$\u0012\b\b\u0002\u0010%\u001a\u00020\n\u0012\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*\u0012\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,\u0012\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/\u0012\n\b\u0002\u00100\u001a\u0004\u0018\u000101ø\u0001\u0000¢\u0006\u0002\u00107B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*¢\u0006\u0002\u00108J\u0002\u0010n\u001a\u00020\u00002\b\u00103\u001a\u0004\u0018\u0001042\b\b\u0002\u00105\u001a\u0002062\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bo\u0010pJá\u0001\u0010n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bq\u0010rJù\u0001\u0010n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bs\u0010tJ\u0002\u0010n\u001a\u00020\u00002\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\b\u0002\u0010\u0015\u001a\u00020\n2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\b2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010 2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\"2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010$2\b\b\u0002\u0010%\u001a\u00020\n2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'2\n\b\u0002\u0010)\u001a\u0004\u0018\u00010*2\n\b\u0002\u0010+\u001a\u0004\u0018\u00010,2\n\b\u0002\u0010.\u001a\u0004\u0018\u00010/2\n\b\u0002\u00100\u001a\u0004\u0018\u000101H\u0007ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bu\u0010vJ\u0013\u0010w\u001a\u00020x2\b\u0010y\u001a\u0004\u0018\u00010\u0001H\u0002J\u000e\u0010z\u001a\u00020x2\u0006\u0010y\u001a\u00020\u0000J\b\u0010{\u001a\u00020|H\u0016J\r\u0010}\u001a\u00020|H\u0000¢\u0006\u0002\b~J\u0010\u0010\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u0005H\u0007J\u0010\u0010\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u0003H\u0007J\u0014\u0010\u001a\u00020\u00002\n\b\u0002\u0010y\u001a\u0004\u0018\u00010\u0000H\u0007J\u0012\u0010\u0001\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u0005H\u0002J\u0012\u0010\u0001\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u0003H\u0002J\u0012\u0010\u0001\u001a\u00020\u00002\u0006\u0010y\u001a\u00020\u0000H\u0002J\t\u0010\u0001\u001a\u00020\u0005H\u0007J\t\u0010\u0001\u001a\u00020\u0003H\u0007J\t\u0010\u0001\u001a\u00020\u0014H\u0016R\u001a\u00105\u001a\u0002068GX\u0004¢\u0006\f\u0012\u0004\b9\u0010:\u001a\u0004\b;\u0010<R\u001a\u0010\u001c\u001a\u00020\b8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b=\u0010>R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u00178Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b?\u0010@R\u001c\u00103\u001a\u0004\u0018\u0001048GX\u0004¢\u0006\f\u0012\u0004\bA\u0010:\u001a\u0004\bB\u0010CR\u001a\u0010\u0007\u001a\u00020\b8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bD\u0010>R\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u00128F¢\u0006\u0006\u001a\u0004\bE\u0010FR\u0013\u0010\u0013\u001a\u0004\u0018\u00010\u00148F¢\u0006\u0006\u001a\u0004\bG\u0010HR\u001a\u0010\t\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bI\u0010>R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000e8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bJ\u0010KR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u00108Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bL\u0010MR\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f8F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u001c\u00100\u001a\u0004\u0018\u0001018GX\u0004¢\u0006\f\u0012\u0004\bP\u0010:\u001a\u0004\bQ\u0010RR\u001a\u0010\u0015\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bS\u0010>R\u001c\u0010.\u001a\u0004\u0018\u00010/8GX\u0004¢\u0006\f\u0012\u0004\bT\u0010:\u001a\u0004\bU\u0010VR\u001a\u0010%\u001a\u00020\n8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bW\u0010>R\u0013\u0010+\u001a\u0004\u0018\u00010,8F¢\u0006\u0006\u001a\u0004\bX\u0010YR\u0013\u0010\u001a\u001a\u0004\u0018\u00010\u001b8F¢\u0006\u0006\u001a\u0004\bZ\u0010[R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0013\u0010)\u001a\u0004\u0018\u00010*¢\u0006\b\n\u0000\u001a\u0004\b^\u0010_R\u0013\u0010\u001f\u001a\u0004\u0018\u00010 8F¢\u0006\u0006\u001a\u0004\b`\u0010aR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\bb\u0010cR\u001c\u0010!\u001a\u0004\u0018\u00010\"8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bd\u0010eR\u0013\u0010\u001d\u001a\u0004\u0018\u00010\u001e8F¢\u0006\u0006\u001a\u0004\bf\u0010gR\u001c\u0010#\u001a\u0004\u0018\u00010$8Fø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\bh\u0010iR\u0013\u0010\u0018\u001a\u0004\u0018\u00010\u00198F¢\u0006\u0006\u001a\u0004\bj\u0010kR\u0013\u0010&\u001a\u0004\u0018\u00010'8F¢\u0006\u0006\u001a\u0004\bl\u0010m\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0001"}, d2 = {"Landroidx/compose/ui/text/TextStyle;", "", "spanStyle", "Landroidx/compose/ui/text/SpanStyle;", "paragraphStyle", "Landroidx/compose/ui/text/ParagraphStyle;", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;)V", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontSynthesis", "Landroidx/compose/ui/text/font/FontSynthesis;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "fontFeatureSettings", "", "letterSpacing", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "background", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "textDirection", "Landroidx/compose/ui/text/style/TextDirection;", "lineHeight", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "platformStyle", "Landroidx/compose/ui/text/PlatformTextStyle;", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "lineBreak", "Landroidx/compose/ui/text/style/LineBreak;", "hyphens", "Landroidx/compose/ui/text/style/Hyphens;", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;Lkotlin/jvm/internal/DefaultConstructorMarker;)V", "(Landroidx/compose/ui/text/SpanStyle;Landroidx/compose/ui/text/ParagraphStyle;Landroidx/compose/ui/text/PlatformTextStyle;)V", "getAlpha$annotations", "()V", "getAlpha", "()F", "getBackground-0d7_KjU", "()J", "getBaselineShift-5SSeXJ0", "()Landroidx/compose/ui/text/style/BaselineShift;", "getBrush$annotations", "getBrush", "()Landroidx/compose/ui/graphics/Brush;", "getColor-0d7_KjU", "getFontFamily", "()Landroidx/compose/ui/text/font/FontFamily;", "getFontFeatureSettings", "()Ljava/lang/String;", "getFontSize-XSAIIZE", "getFontStyle-4Lr2A7w", "()Landroidx/compose/ui/text/font/FontStyle;", "getFontSynthesis-ZQGJjVo", "()Landroidx/compose/ui/text/font/FontSynthesis;", "getFontWeight", "()Landroidx/compose/ui/text/font/FontWeight;", "getHyphens$annotations", "getHyphens", "()Landroidx/compose/ui/text/style/Hyphens;", "getLetterSpacing-XSAIIZE", "getLineBreak$annotations", "getLineBreak", "()Landroidx/compose/ui/text/style/LineBreak;", "getLineHeight-XSAIIZE", "getLineHeightStyle", "()Landroidx/compose/ui/text/style/LineHeightStyle;", "getLocaleList", "()Landroidx/compose/ui/text/intl/LocaleList;", "getParagraphStyle$ui_text_release", "()Landroidx/compose/ui/text/ParagraphStyle;", "getPlatformStyle", "()Landroidx/compose/ui/text/PlatformTextStyle;", "getShadow", "()Landroidx/compose/ui/graphics/Shadow;", "getSpanStyle$ui_text_release", "()Landroidx/compose/ui/text/SpanStyle;", "getTextAlign-buA522U", "()Landroidx/compose/ui/text/style/TextAlign;", "getTextDecoration", "()Landroidx/compose/ui/text/style/TextDecoration;", "getTextDirection-mmuk1to", "()Landroidx/compose/ui/text/style/TextDirection;", "getTextGeometricTransform", "()Landroidx/compose/ui/text/style/TextGeometricTransform;", "getTextIndent", "()Landroidx/compose/ui/text/style/TextIndent;", "copy", "copy-c8hh_gE", "(Landroidx/compose/ui/graphics/Brush;FJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/TextStyle;", "copy-HL5avdY", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;)Landroidx/compose/ui/text/TextStyle;", "copy-NOaFTUo", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;)Landroidx/compose/ui/text/TextStyle;", "copy-Pus4vRE", "(JJLandroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontSynthesis;Landroidx/compose/ui/text/font/FontFamily;Ljava/lang/String;JLandroidx/compose/ui/text/style/BaselineShift;Landroidx/compose/ui/text/style/TextGeometricTransform;Landroidx/compose/ui/text/intl/LocaleList;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/graphics/Shadow;Landroidx/compose/ui/text/style/TextAlign;Landroidx/compose/ui/text/style/TextDirection;JLandroidx/compose/ui/text/style/TextIndent;Landroidx/compose/ui/text/PlatformTextStyle;Landroidx/compose/ui/text/style/LineHeightStyle;Landroidx/compose/ui/text/style/LineBreak;Landroidx/compose/ui/text/style/Hyphens;)Landroidx/compose/ui/text/TextStyle;", "equals", "", "other", "hasSameLayoutAffectingAttributes", "hashCode", "", "hashCodeLayoutAffectingAttributes", "hashCodeLayoutAffectingAttributes$ui_text_release", "merge", "plus", "toParagraphStyle", "toSpanStyle", "toString", "Companion", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TextStyle {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final TextStyle Default = new TextStyle(0, 0, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0, (TextDecoration) null, (Shadow) null, (TextAlign) null, (TextDirection) null, 0, (TextIndent) null, 262143, (DefaultConstructorMarker) null);
    @NotNull
    private final ParagraphStyle paragraphStyle;
    @Nullable
    private final PlatformTextStyle platformStyle;
    @NotNull
    private final SpanStyle spanStyle;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/TextStyle$Companion;", "", "()V", "Default", "Landroidx/compose/ui/text/TextStyle;", "getDefault$annotations", "getDefault", "()Landroidx/compose/ui/text/TextStyle;", "ui-text_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        public static /* synthetic */ void getDefault$annotations() {
        }

        @NotNull
        public final TextStyle getDefault() {
            return TextStyle.Default;
        }
    }

    @ExperimentalTextApi
    public /* synthetic */ TextStyle(long j11, long j12, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j13, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j14, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j15, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j13, baselineShift, textGeometricTransform, localeList, j14, textDecoration, shadow, textAlign, textDirection, j15, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens);
    }

    public /* synthetic */ TextStyle(long j11, long j12, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j13, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j14, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j15, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j13, baselineShift, textGeometricTransform, localeList, j14, textDecoration, shadow, textAlign, textDirection, j15, textIndent, platformTextStyle, lineHeightStyle);
    }

    public /* synthetic */ TextStyle(long j11, long j12, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j13, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j14, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j15, TextIndent textIndent, DefaultConstructorMarker defaultConstructorMarker) {
        this(j11, j12, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j13, baselineShift, textGeometricTransform, localeList, j14, textDecoration, shadow, textAlign, textDirection, j15, textIndent);
    }

    @ExperimentalTextApi
    public /* synthetic */ TextStyle(Brush brush, float f11, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j14, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, DefaultConstructorMarker defaultConstructorMarker) {
        this(brush, f11, j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, textAlign, textDirection, j14, textIndent, platformTextStyle, lineHeightStyle, lineBreak, hyphens);
    }

    public TextStyle(@NotNull SpanStyle spanStyle2, @NotNull ParagraphStyle paragraphStyle2, @Nullable PlatformTextStyle platformTextStyle) {
        Intrinsics.checkNotNullParameter(spanStyle2, "spanStyle");
        Intrinsics.checkNotNullParameter(paragraphStyle2, "paragraphStyle");
        this.spanStyle = spanStyle2;
        this.paragraphStyle = paragraphStyle2;
        this.platformStyle = platformTextStyle;
    }

    /* renamed from: copy-HL5avdY$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m5046copyHL5avdY$default(TextStyle textStyle, long j11, long j12, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j13, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j14, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j15, TextIndent textIndent, int i11, Object obj) {
        TextStyle textStyle2 = textStyle;
        int i12 = i11;
        return textStyle.m5050copyHL5avdY((i12 & 1) != 0 ? textStyle2.spanStyle.m5001getColor0d7_KjU() : j11, (i12 & 2) != 0 ? textStyle2.spanStyle.m5002getFontSizeXSAIIZE() : j12, (i12 & 4) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight, (i12 & 8) != 0 ? textStyle2.spanStyle.m5003getFontStyle4Lr2A7w() : fontStyle, (i12 & 16) != 0 ? textStyle2.spanStyle.m5004getFontSynthesisZQGJjVo() : fontSynthesis, (i12 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily, (i12 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str, (i12 & 128) != 0 ? textStyle2.spanStyle.m5005getLetterSpacingXSAIIZE() : j13, (i12 & 256) != 0 ? textStyle2.spanStyle.m5000getBaselineShift5SSeXJ0() : baselineShift, (i12 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform, (i12 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList, (i12 & 2048) != 0 ? textStyle2.spanStyle.m4999getBackground0d7_KjU() : j14, (i12 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration, (i12 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow, (i12 & 16384) != 0 ? textStyle2.paragraphStyle.m4962getTextAlignbuA522U() : textAlign, (i12 & 32768) != 0 ? textStyle2.paragraphStyle.m4963getTextDirectionmmuk1to() : textDirection, (i12 & 65536) != 0 ? textStyle2.paragraphStyle.m4961getLineHeightXSAIIZE() : j15, (i12 & 131072) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent);
    }

    /* renamed from: copy-NOaFTUo$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m5047copyNOaFTUo$default(TextStyle textStyle, long j11, long j12, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j13, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j14, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j15, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, int i11, Object obj) {
        TextStyle textStyle2 = textStyle;
        int i12 = i11;
        return textStyle.m5051copyNOaFTUo((i12 & 1) != 0 ? textStyle2.spanStyle.m5001getColor0d7_KjU() : j11, (i12 & 2) != 0 ? textStyle2.spanStyle.m5002getFontSizeXSAIIZE() : j12, (i12 & 4) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight, (i12 & 8) != 0 ? textStyle2.spanStyle.m5003getFontStyle4Lr2A7w() : fontStyle, (i12 & 16) != 0 ? textStyle2.spanStyle.m5004getFontSynthesisZQGJjVo() : fontSynthesis, (i12 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily, (i12 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str, (i12 & 128) != 0 ? textStyle2.spanStyle.m5005getLetterSpacingXSAIIZE() : j13, (i12 & 256) != 0 ? textStyle2.spanStyle.m5000getBaselineShift5SSeXJ0() : baselineShift, (i12 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform, (i12 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList, (i12 & 2048) != 0 ? textStyle2.spanStyle.m4999getBackground0d7_KjU() : j14, (i12 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration, (i12 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow, (i12 & 16384) != 0 ? textStyle2.paragraphStyle.m4962getTextAlignbuA522U() : textAlign, (i12 & 32768) != 0 ? textStyle2.paragraphStyle.m4963getTextDirectionmmuk1to() : textDirection, (i12 & 65536) != 0 ? textStyle2.paragraphStyle.m4961getLineHeightXSAIIZE() : j15, (i12 & 131072) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent, (i12 & 262144) != 0 ? textStyle2.platformStyle : platformTextStyle, (i12 & 524288) != 0 ? textStyle2.paragraphStyle.getLineHeightStyle() : lineHeightStyle);
    }

    /* renamed from: copy-Pus4vRE$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m5048copyPus4vRE$default(TextStyle textStyle, long j11, long j12, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j13, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j14, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j15, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i11, Object obj) {
        TextStyle textStyle2 = textStyle;
        int i12 = i11;
        return textStyle.m5052copyPus4vRE((i12 & 1) != 0 ? textStyle2.spanStyle.m5001getColor0d7_KjU() : j11, (i12 & 2) != 0 ? textStyle2.spanStyle.m5002getFontSizeXSAIIZE() : j12, (i12 & 4) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight, (i12 & 8) != 0 ? textStyle2.spanStyle.m5003getFontStyle4Lr2A7w() : fontStyle, (i12 & 16) != 0 ? textStyle2.spanStyle.m5004getFontSynthesisZQGJjVo() : fontSynthesis, (i12 & 32) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily, (i12 & 64) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str, (i12 & 128) != 0 ? textStyle2.spanStyle.m5005getLetterSpacingXSAIIZE() : j13, (i12 & 256) != 0 ? textStyle2.spanStyle.m5000getBaselineShift5SSeXJ0() : baselineShift, (i12 & 512) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform, (i12 & 1024) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList, (i12 & 2048) != 0 ? textStyle2.spanStyle.m4999getBackground0d7_KjU() : j14, (i12 & 4096) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration, (i12 & 8192) != 0 ? textStyle2.spanStyle.getShadow() : shadow, (i12 & 16384) != 0 ? textStyle2.paragraphStyle.m4962getTextAlignbuA522U() : textAlign, (i12 & 32768) != 0 ? textStyle2.paragraphStyle.m4963getTextDirectionmmuk1to() : textDirection, (i12 & 65536) != 0 ? textStyle2.paragraphStyle.m4961getLineHeightXSAIIZE() : j15, (i12 & 131072) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent, (i12 & 262144) != 0 ? textStyle2.platformStyle : platformTextStyle, (i12 & 524288) != 0 ? textStyle2.paragraphStyle.getLineHeightStyle() : lineHeightStyle, (i12 & 1048576) != 0 ? textStyle2.paragraphStyle.getLineBreak() : lineBreak, (i12 & 2097152) != 0 ? textStyle2.paragraphStyle.getHyphens() : hyphens);
    }

    /* renamed from: copy-c8hh_gE$default  reason: not valid java name */
    public static /* synthetic */ TextStyle m5049copyc8hh_gE$default(TextStyle textStyle, Brush brush, float f11, long j11, FontWeight fontWeight, FontStyle fontStyle, FontSynthesis fontSynthesis, FontFamily fontFamily, String str, long j12, BaselineShift baselineShift, TextGeometricTransform textGeometricTransform, LocaleList localeList, long j13, TextDecoration textDecoration, Shadow shadow, TextAlign textAlign, TextDirection textDirection, long j14, TextIndent textIndent, PlatformTextStyle platformTextStyle, LineHeightStyle lineHeightStyle, LineBreak lineBreak, Hyphens hyphens, int i11, Object obj) {
        Shadow shadow2;
        TextAlign textAlign2;
        TextAlign textAlign3;
        TextDirection textDirection2;
        long j15;
        TextDirection textDirection3;
        TextIndent textIndent2;
        PlatformTextStyle platformTextStyle2;
        PlatformTextStyle platformTextStyle3;
        LineHeightStyle lineHeightStyle2;
        LineHeightStyle lineHeightStyle3;
        LineBreak lineBreak2;
        TextStyle textStyle2 = textStyle;
        int i12 = i11;
        float alpha = (i12 & 2) != 0 ? textStyle2.spanStyle.getAlpha() : f11;
        long r32 = (i12 & 4) != 0 ? textStyle2.spanStyle.m5002getFontSizeXSAIIZE() : j11;
        FontWeight fontWeight2 = (i12 & 8) != 0 ? textStyle2.spanStyle.getFontWeight() : fontWeight;
        FontStyle r62 = (i12 & 16) != 0 ? textStyle2.spanStyle.m5003getFontStyle4Lr2A7w() : fontStyle;
        FontSynthesis r72 = (i12 & 32) != 0 ? textStyle2.spanStyle.m5004getFontSynthesisZQGJjVo() : fontSynthesis;
        FontFamily fontFamily2 = (i12 & 64) != 0 ? textStyle2.spanStyle.getFontFamily() : fontFamily;
        String fontFeatureSettings = (i12 & 128) != 0 ? textStyle2.spanStyle.getFontFeatureSettings() : str;
        long r102 = (i12 & 256) != 0 ? textStyle2.spanStyle.m5005getLetterSpacingXSAIIZE() : j12;
        BaselineShift r12 = (i12 & 512) != 0 ? textStyle2.spanStyle.m5000getBaselineShift5SSeXJ0() : baselineShift;
        TextGeometricTransform textGeometricTransform2 = (i12 & 1024) != 0 ? textStyle2.spanStyle.getTextGeometricTransform() : textGeometricTransform;
        LocaleList localeList2 = (i12 & 2048) != 0 ? textStyle2.spanStyle.getLocaleList() : localeList;
        long r17 = (i12 & 4096) != 0 ? textStyle2.spanStyle.m4999getBackground0d7_KjU() : j13;
        TextDecoration textDecoration2 = (i12 & 8192) != 0 ? textStyle2.spanStyle.getTextDecoration() : textDecoration;
        Shadow shadow3 = (i12 & 16384) != 0 ? textStyle2.spanStyle.getShadow() : shadow;
        if ((i12 & 32768) != 0) {
            shadow2 = shadow3;
            textAlign2 = textStyle2.paragraphStyle.m4962getTextAlignbuA522U();
        } else {
            shadow2 = shadow3;
            textAlign2 = textAlign;
        }
        if ((i12 & 65536) != 0) {
            textAlign3 = textAlign2;
            textDirection2 = textStyle2.paragraphStyle.m4963getTextDirectionmmuk1to();
        } else {
            textAlign3 = textAlign2;
            textDirection2 = textDirection;
        }
        if ((i12 & 131072) != 0) {
            textDirection3 = textDirection2;
            j15 = textStyle2.paragraphStyle.m4961getLineHeightXSAIIZE();
        } else {
            textDirection3 = textDirection2;
            j15 = j14;
        }
        TextIndent textIndent3 = (262144 & i12) != 0 ? textStyle2.paragraphStyle.getTextIndent() : textIndent;
        if ((i12 & 524288) != 0) {
            textIndent2 = textIndent3;
            platformTextStyle2 = textStyle2.platformStyle;
        } else {
            textIndent2 = textIndent3;
            platformTextStyle2 = platformTextStyle;
        }
        if ((i12 & 1048576) != 0) {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = textStyle2.paragraphStyle.getLineHeightStyle();
        } else {
            platformTextStyle3 = platformTextStyle2;
            lineHeightStyle2 = lineHeightStyle;
        }
        if ((i12 & 2097152) != 0) {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = textStyle2.paragraphStyle.getLineBreak();
        } else {
            lineHeightStyle3 = lineHeightStyle2;
            lineBreak2 = lineBreak;
        }
        return textStyle.m5053copyc8hh_gE(brush, alpha, r32, fontWeight2, r62, r72, fontFamily2, fontFeatureSettings, r102, r12, textGeometricTransform2, localeList2, r17, textDecoration2, shadow2, textAlign3, textDirection3, j15, textIndent2, platformTextStyle3, lineHeightStyle3, lineBreak2, (i12 & 4194304) != 0 ? textStyle2.paragraphStyle.getHyphens() : hyphens);
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getAlpha$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getBrush$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getHyphens$annotations() {
    }

    @ExperimentalTextApi
    public static /* synthetic */ void getLineBreak$annotations() {
    }

    public static /* synthetic */ TextStyle merge$default(TextStyle textStyle, TextStyle textStyle2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            textStyle2 = null;
        }
        return textStyle.merge(textStyle2);
    }

    @NotNull
    /* renamed from: copy-HL5avdY  reason: not valid java name */
    public final TextStyle m5050copyHL5avdY(long j11, long j12, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j13, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j14, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j15, @Nullable TextIndent textIndent) {
        TextForegroundStyle textForegroundStyle;
        long j16 = j11;
        if (Color.m2920equalsimpl0(j16, this.spanStyle.m5001getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m5386from8_81llA(j16);
        }
        SpanStyle spanStyle2 = r4;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle, j12, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j13, baselineShift, textGeometricTransform, localeList, j14, textDecoration, shadow, this.spanStyle.getPlatformStyle(), (DefaultConstructorMarker) null);
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign, textDirection, j15, textIndent, this.paragraphStyle.getPlatformStyle(), getLineHeightStyle(), getLineBreak(), getHyphens(), (DefaultConstructorMarker) null), this.platformStyle);
    }

    @NotNull
    /* renamed from: copy-NOaFTUo  reason: not valid java name */
    public final TextStyle m5051copyNOaFTUo(long j11, long j12, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j13, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j14, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j15, @Nullable TextIndent textIndent, @Nullable PlatformTextStyle platformTextStyle, @Nullable LineHeightStyle lineHeightStyle) {
        TextForegroundStyle textForegroundStyle;
        long j16 = j11;
        PlatformTextStyle platformTextStyle2 = platformTextStyle;
        if (Color.m2920equalsimpl0(j16, this.spanStyle.m5001getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m5386from8_81llA(j16);
        }
        TextForegroundStyle textForegroundStyle2 = textForegroundStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        SpanStyle spanStyle2 = r5;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle2, j12, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j13, baselineShift, textGeometricTransform, localeList, j14, textDecoration, shadow, platformTextStyle2 != null ? platformTextStyle.getSpanStyle() : null, (DefaultConstructorMarker) null);
        if (platformTextStyle2 != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign, textDirection, j15, textIndent, platformParagraphStyle, lineHeightStyle, getLineBreak(), getHyphens(), (DefaultConstructorMarker) null), platformTextStyle2);
    }

    @ExperimentalTextApi
    @NotNull
    /* renamed from: copy-Pus4vRE  reason: not valid java name */
    public final TextStyle m5052copyPus4vRE(long j11, long j12, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j13, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j14, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j15, @Nullable TextIndent textIndent, @Nullable PlatformTextStyle platformTextStyle, @Nullable LineHeightStyle lineHeightStyle, @Nullable LineBreak lineBreak, @Nullable Hyphens hyphens) {
        TextForegroundStyle textForegroundStyle;
        long j16 = j11;
        PlatformTextStyle platformTextStyle2 = platformTextStyle;
        if (Color.m2920equalsimpl0(j16, this.spanStyle.m5001getColor0d7_KjU())) {
            textForegroundStyle = this.spanStyle.getTextForegroundStyle$ui_text_release();
        } else {
            textForegroundStyle = TextForegroundStyle.Companion.m5386from8_81llA(j16);
        }
        TextForegroundStyle textForegroundStyle2 = textForegroundStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        SpanStyle spanStyle2 = r5;
        SpanStyle spanStyle3 = new SpanStyle(textForegroundStyle2, j12, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j13, baselineShift, textGeometricTransform, localeList, j14, textDecoration, shadow, platformTextStyle2 != null ? platformTextStyle.getSpanStyle() : null, (DefaultConstructorMarker) null);
        if (platformTextStyle2 != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign, textDirection, j15, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, (DefaultConstructorMarker) null), platformTextStyle2);
    }

    @ExperimentalTextApi
    @NotNull
    /* renamed from: copy-c8hh_gE  reason: not valid java name */
    public final TextStyle m5053copyc8hh_gE(@Nullable Brush brush, float f11, long j11, @Nullable FontWeight fontWeight, @Nullable FontStyle fontStyle, @Nullable FontSynthesis fontSynthesis, @Nullable FontFamily fontFamily, @Nullable String str, long j12, @Nullable BaselineShift baselineShift, @Nullable TextGeometricTransform textGeometricTransform, @Nullable LocaleList localeList, long j13, @Nullable TextDecoration textDecoration, @Nullable Shadow shadow, @Nullable TextAlign textAlign, @Nullable TextDirection textDirection, long j14, @Nullable TextIndent textIndent, @Nullable PlatformTextStyle platformTextStyle, @Nullable LineHeightStyle lineHeightStyle, @Nullable LineBreak lineBreak, @Nullable Hyphens hyphens) {
        PlatformTextStyle platformTextStyle2 = platformTextStyle;
        PlatformParagraphStyle platformParagraphStyle = null;
        SpanStyle spanStyle2 = r2;
        SpanStyle spanStyle3 = new SpanStyle(brush, f11, j11, fontWeight, fontStyle, fontSynthesis, fontFamily, str, j12, baselineShift, textGeometricTransform, localeList, j13, textDecoration, shadow, platformTextStyle2 != null ? platformTextStyle.getSpanStyle() : null, (DefaultConstructorMarker) null);
        if (platformTextStyle2 != null) {
            platformParagraphStyle = platformTextStyle.getParagraphStyle();
        }
        return new TextStyle(spanStyle2, new ParagraphStyle(textAlign, textDirection, j14, textIndent, platformParagraphStyle, lineHeightStyle, lineBreak, hyphens, (DefaultConstructorMarker) null), platformTextStyle2);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextStyle)) {
            return false;
        }
        TextStyle textStyle = (TextStyle) obj;
        if (Intrinsics.areEqual((Object) this.spanStyle, (Object) textStyle.spanStyle) && Intrinsics.areEqual((Object) this.paragraphStyle, (Object) textStyle.paragraphStyle) && Intrinsics.areEqual((Object) this.platformStyle, (Object) textStyle.platformStyle)) {
            return true;
        }
        return false;
    }

    @ExperimentalTextApi
    public final float getAlpha() {
        return this.spanStyle.getAlpha();
    }

    /* renamed from: getBackground-0d7_KjU  reason: not valid java name */
    public final long m5054getBackground0d7_KjU() {
        return this.spanStyle.m4999getBackground0d7_KjU();
    }

    @Nullable
    /* renamed from: getBaselineShift-5SSeXJ0  reason: not valid java name */
    public final BaselineShift m5055getBaselineShift5SSeXJ0() {
        return this.spanStyle.m5000getBaselineShift5SSeXJ0();
    }

    @ExperimentalTextApi
    @Nullable
    public final Brush getBrush() {
        return this.spanStyle.getBrush();
    }

    /* renamed from: getColor-0d7_KjU  reason: not valid java name */
    public final long m5056getColor0d7_KjU() {
        return this.spanStyle.m5001getColor0d7_KjU();
    }

    @Nullable
    public final FontFamily getFontFamily() {
        return this.spanStyle.getFontFamily();
    }

    @Nullable
    public final String getFontFeatureSettings() {
        return this.spanStyle.getFontFeatureSettings();
    }

    /* renamed from: getFontSize-XSAIIZE  reason: not valid java name */
    public final long m5057getFontSizeXSAIIZE() {
        return this.spanStyle.m5002getFontSizeXSAIIZE();
    }

    @Nullable
    /* renamed from: getFontStyle-4Lr2A7w  reason: not valid java name */
    public final FontStyle m5058getFontStyle4Lr2A7w() {
        return this.spanStyle.m5003getFontStyle4Lr2A7w();
    }

    @Nullable
    /* renamed from: getFontSynthesis-ZQGJjVo  reason: not valid java name */
    public final FontSynthesis m5059getFontSynthesisZQGJjVo() {
        return this.spanStyle.m5004getFontSynthesisZQGJjVo();
    }

    @Nullable
    public final FontWeight getFontWeight() {
        return this.spanStyle.getFontWeight();
    }

    @ExperimentalTextApi
    @Nullable
    public final Hyphens getHyphens() {
        return this.paragraphStyle.getHyphens();
    }

    /* renamed from: getLetterSpacing-XSAIIZE  reason: not valid java name */
    public final long m5060getLetterSpacingXSAIIZE() {
        return this.spanStyle.m5005getLetterSpacingXSAIIZE();
    }

    @ExperimentalTextApi
    @Nullable
    public final LineBreak getLineBreak() {
        return this.paragraphStyle.getLineBreak();
    }

    /* renamed from: getLineHeight-XSAIIZE  reason: not valid java name */
    public final long m5061getLineHeightXSAIIZE() {
        return this.paragraphStyle.m4961getLineHeightXSAIIZE();
    }

    @Nullable
    public final LineHeightStyle getLineHeightStyle() {
        return this.paragraphStyle.getLineHeightStyle();
    }

    @Nullable
    public final LocaleList getLocaleList() {
        return this.spanStyle.getLocaleList();
    }

    @NotNull
    public final ParagraphStyle getParagraphStyle$ui_text_release() {
        return this.paragraphStyle;
    }

    @Nullable
    public final PlatformTextStyle getPlatformStyle() {
        return this.platformStyle;
    }

    @Nullable
    public final Shadow getShadow() {
        return this.spanStyle.getShadow();
    }

    @NotNull
    public final SpanStyle getSpanStyle$ui_text_release() {
        return this.spanStyle;
    }

    @Nullable
    /* renamed from: getTextAlign-buA522U  reason: not valid java name */
    public final TextAlign m5062getTextAlignbuA522U() {
        return this.paragraphStyle.m4962getTextAlignbuA522U();
    }

    @Nullable
    public final TextDecoration getTextDecoration() {
        return this.spanStyle.getTextDecoration();
    }

    @Nullable
    /* renamed from: getTextDirection-mmuk1to  reason: not valid java name */
    public final TextDirection m5063getTextDirectionmmuk1to() {
        return this.paragraphStyle.m4963getTextDirectionmmuk1to();
    }

    @Nullable
    public final TextGeometricTransform getTextGeometricTransform() {
        return this.spanStyle.getTextGeometricTransform();
    }

    @Nullable
    public final TextIndent getTextIndent() {
        return this.paragraphStyle.getTextIndent();
    }

    public final boolean hasSameLayoutAffectingAttributes(@NotNull TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "other");
        if (this == textStyle || (Intrinsics.areEqual((Object) this.paragraphStyle, (Object) textStyle.paragraphStyle) && this.spanStyle.hasSameLayoutAffectingAttributes$ui_text_release(textStyle.spanStyle))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i11;
        int hashCode = ((this.spanStyle.hashCode() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        if (platformTextStyle != null) {
            i11 = platformTextStyle.hashCode();
        } else {
            i11 = 0;
        }
        return hashCode + i11;
    }

    public final int hashCodeLayoutAffectingAttributes$ui_text_release() {
        int i11;
        int hashCodeLayoutAffectingAttributes$ui_text_release = ((this.spanStyle.hashCodeLayoutAffectingAttributes$ui_text_release() * 31) + this.paragraphStyle.hashCode()) * 31;
        PlatformTextStyle platformTextStyle = this.platformStyle;
        if (platformTextStyle != null) {
            i11 = platformTextStyle.hashCode();
        } else {
            i11 = 0;
        }
        return hashCodeLayoutAffectingAttributes$ui_text_release + i11;
    }

    @NotNull
    @Stable
    public final TextStyle merge(@Nullable TextStyle textStyle) {
        return (textStyle == null || Intrinsics.areEqual((Object) textStyle, (Object) Default)) ? this : new TextStyle(toSpanStyle().merge(textStyle.toSpanStyle()), toParagraphStyle().merge(textStyle.toParagraphStyle()));
    }

    @NotNull
    @Stable
    public final TextStyle plus(@NotNull TextStyle textStyle) {
        Intrinsics.checkNotNullParameter(textStyle, "other");
        return merge(textStyle);
    }

    @NotNull
    @Stable
    public final ParagraphStyle toParagraphStyle() {
        return this.paragraphStyle;
    }

    @NotNull
    @Stable
    public final SpanStyle toSpanStyle() {
        return this.spanStyle;
    }

    @NotNull
    public String toString() {
        return "TextStyle(color=" + Color.m2927toStringimpl(m5056getColor0d7_KjU()) + ", brush=" + getBrush() + ", alpha=" + getAlpha() + ", fontSize=" + TextUnit.m5666toStringimpl(m5057getFontSizeXSAIIZE()) + ", fontWeight=" + getFontWeight() + ", fontStyle=" + m5058getFontStyle4Lr2A7w() + ", fontSynthesis=" + m5059getFontSynthesisZQGJjVo() + ", fontFamily=" + getFontFamily() + ", fontFeatureSettings=" + getFontFeatureSettings() + ", letterSpacing=" + TextUnit.m5666toStringimpl(m5060getLetterSpacingXSAIIZE()) + ", baselineShift=" + m5055getBaselineShift5SSeXJ0() + ", textGeometricTransform=" + getTextGeometricTransform() + ", localeList=" + getLocaleList() + ", background=" + Color.m2927toStringimpl(m5054getBackground0d7_KjU()) + ", textDecoration=" + getTextDecoration() + ", shadow=" + getShadow() + ", textAlign=" + m5062getTextAlignbuA522U() + ", textDirection=" + m5063getTextDirectionmmuk1to() + ", lineHeight=" + TextUnit.m5666toStringimpl(m5061getLineHeightXSAIIZE()) + ", textIndent=" + getTextIndent() + ", platformStyle=" + this.platformStyle + ", lineHeightStyle=" + getLineHeightStyle() + ", lineBreak=" + getLineBreak() + ", hyphens=" + getHyphens() + ')';
    }

    @NotNull
    @Stable
    public final TextStyle plus(@NotNull ParagraphStyle paragraphStyle2) {
        Intrinsics.checkNotNullParameter(paragraphStyle2, "other");
        return merge(paragraphStyle2);
    }

    @NotNull
    @Stable
    public final TextStyle plus(@NotNull SpanStyle spanStyle2) {
        Intrinsics.checkNotNullParameter(spanStyle2, "other");
        return merge(spanStyle2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextStyle(SpanStyle spanStyle2, ParagraphStyle paragraphStyle2, PlatformTextStyle platformTextStyle, int i11, DefaultConstructorMarker defaultConstructorMarker) {
        this(spanStyle2, paragraphStyle2, (i11 & 4) != 0 ? null : platformTextStyle);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TextStyle(@NotNull SpanStyle spanStyle2, @NotNull ParagraphStyle paragraphStyle2) {
        this(spanStyle2, paragraphStyle2, TextStyleKt.createPlatformTextStyleInternal(spanStyle2.getPlatformStyle(), paragraphStyle2.getPlatformStyle()));
        Intrinsics.checkNotNullParameter(spanStyle2, "spanStyle");
        Intrinsics.checkNotNullParameter(paragraphStyle2, "paragraphStyle");
    }

    @NotNull
    @Stable
    public final TextStyle merge(@NotNull SpanStyle spanStyle2) {
        Intrinsics.checkNotNullParameter(spanStyle2, "other");
        return new TextStyle(toSpanStyle().merge(spanStyle2), toParagraphStyle());
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r25, long r27, androidx.compose.ui.text.font.FontWeight r29, androidx.compose.ui.text.font.FontStyle r30, androidx.compose.ui.text.font.FontSynthesis r31, androidx.compose.ui.text.font.FontFamily r32, java.lang.String r33, long r34, androidx.compose.ui.text.style.BaselineShift r36, androidx.compose.ui.text.style.TextGeometricTransform r37, androidx.compose.ui.text.intl.LocaleList r38, long r39, androidx.compose.ui.text.style.TextDecoration r41, androidx.compose.ui.graphics.Shadow r42, androidx.compose.ui.text.style.TextAlign r43, androidx.compose.ui.text.style.TextDirection r44, long r45, androidx.compose.ui.text.style.TextIndent r47, int r48, kotlin.jvm.internal.DefaultConstructorMarker r49) {
        /*
            r24 = this;
            r0 = r48
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m2955getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r25
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m5670getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r27
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r29
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r30
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r31
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r32
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r33
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m5670getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r34
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r36
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r37
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r38
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m2955getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r39
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r41
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r42
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r43
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r44
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ab
            androidx.compose.ui.unit.TextUnit$Companion r21 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r21.m5670getUnspecifiedXSAIIZE()
            goto L_0x00ad
        L_0x00ab:
            r21 = r45
        L_0x00ad:
            r23 = 131072(0x20000, float:1.83671E-40)
            r0 = r0 & r23
            if (r0 == 0) goto L_0x00b5
            r0 = 0
            goto L_0x00b7
        L_0x00b5:
            r0 = r47
        L_0x00b7:
            r23 = 0
            r49 = r23
            r25 = r24
            r26 = r1
            r28 = r3
            r30 = r5
            r31 = r7
            r32 = r8
            r33 = r9
            r34 = r10
            r35 = r11
            r37 = r13
            r38 = r14
            r39 = r15
            r40 = r16
            r42 = r18
            r43 = r19
            r44 = r6
            r45 = r20
            r46 = r21
            r48 = r0
            r25.<init>(r26, r28, r30, r31, r32, r33, r34, r35, r37, r38, r39, r40, r42, r43, r44, r45, r46, r48, r49)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    @NotNull
    @Stable
    public final TextStyle merge(@NotNull ParagraphStyle paragraphStyle2) {
        Intrinsics.checkNotNullParameter(paragraphStyle2, "other");
        return new TextStyle(toSpanStyle(), toParagraphStyle().merge(paragraphStyle2));
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r22, long r24, androidx.compose.ui.text.font.FontWeight r26, androidx.compose.ui.text.font.FontStyle r27, androidx.compose.ui.text.font.FontSynthesis r28, androidx.compose.ui.text.font.FontFamily r29, java.lang.String r30, long r31, androidx.compose.ui.text.style.BaselineShift r33, androidx.compose.ui.text.style.TextGeometricTransform r34, androidx.compose.ui.text.intl.LocaleList r35, long r36, androidx.compose.ui.text.style.TextDecoration r38, androidx.compose.ui.graphics.Shadow r39, androidx.compose.ui.text.style.TextAlign r40, androidx.compose.ui.text.style.TextDirection r41, long r42, androidx.compose.ui.text.style.TextIndent r44) {
        /*
            r21 = this;
            r1 = r22
            r3 = r24
            r5 = r26
            r6 = r27
            r7 = r28
            r8 = r29
            r9 = r30
            r10 = r31
            r12 = r33
            r13 = r34
            r14 = r35
            r15 = r36
            r17 = r38
            r18 = r39
            androidx.compose.ui.text.SpanStyle r0 = new androidx.compose.ui.text.SpanStyle
            r22 = r0
            r19 = 0
            r20 = 0
            r0.<init>((long) r1, (long) r3, (androidx.compose.ui.text.font.FontWeight) r5, (androidx.compose.ui.text.font.FontStyle) r6, (androidx.compose.ui.text.font.FontSynthesis) r7, (androidx.compose.ui.text.font.FontFamily) r8, (java.lang.String) r9, (long) r10, (androidx.compose.ui.text.style.BaselineShift) r12, (androidx.compose.ui.text.style.TextGeometricTransform) r13, (androidx.compose.ui.text.intl.LocaleList) r14, (long) r15, (androidx.compose.ui.text.style.TextDecoration) r17, (androidx.compose.ui.graphics.Shadow) r18, (androidx.compose.ui.text.PlatformSpanStyle) r19, (kotlin.jvm.internal.DefaultConstructorMarker) r20)
            androidx.compose.ui.text.ParagraphStyle r0 = new androidx.compose.ui.text.ParagraphStyle
            r1 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r23 = r0
            r24 = r40
            r25 = r41
            r26 = r42
            r28 = r44
            r29 = r1
            r30 = r2
            r31 = r3
            r32 = r4
            r33 = r5
            r23.<init>(r24, r25, r26, r28, r29, r30, r31, r32, r33)
            r2 = r21
            r3 = r22
            r2.<init>(r3, r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r27, long r29, androidx.compose.ui.text.font.FontWeight r31, androidx.compose.ui.text.font.FontStyle r32, androidx.compose.ui.text.font.FontSynthesis r33, androidx.compose.ui.text.font.FontFamily r34, java.lang.String r35, long r36, androidx.compose.ui.text.style.BaselineShift r38, androidx.compose.ui.text.style.TextGeometricTransform r39, androidx.compose.ui.text.intl.LocaleList r40, long r41, androidx.compose.ui.text.style.TextDecoration r43, androidx.compose.ui.graphics.Shadow r44, androidx.compose.ui.text.style.TextAlign r45, androidx.compose.ui.text.style.TextDirection r46, long r47, androidx.compose.ui.text.style.TextIndent r49, androidx.compose.ui.text.PlatformTextStyle r50, androidx.compose.ui.text.style.LineHeightStyle r51, int r52, kotlin.jvm.internal.DefaultConstructorMarker r53) {
        /*
            r26 = this;
            r0 = r52
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m2955getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r27
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m5670getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r29
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r31
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r32
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r33
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r34
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r35
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m5670getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r36
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r38
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r39
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r40
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m2955getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r41
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r43
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r44
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r45
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r46
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ab
            androidx.compose.ui.unit.TextUnit$Companion r21 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r21.m5670getUnspecifiedXSAIIZE()
            goto L_0x00ad
        L_0x00ab:
            r21 = r47
        L_0x00ad:
            r23 = 131072(0x20000, float:1.83671E-40)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00b6
            r23 = 0
            goto L_0x00b8
        L_0x00b6:
            r23 = r49
        L_0x00b8:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c1
            r24 = 0
            goto L_0x00c3
        L_0x00c1:
            r24 = r50
        L_0x00c3:
            r25 = 524288(0x80000, float:7.34684E-40)
            r0 = r0 & r25
            if (r0 == 0) goto L_0x00cb
            r0 = 0
            goto L_0x00cd
        L_0x00cb:
            r0 = r51
        L_0x00cd:
            r25 = 0
            r53 = r25
            r27 = r26
            r28 = r1
            r30 = r3
            r32 = r5
            r33 = r7
            r34 = r8
            r35 = r9
            r36 = r10
            r37 = r11
            r39 = r13
            r40 = r14
            r41 = r15
            r42 = r16
            r44 = r18
            r45 = r19
            r46 = r6
            r47 = r20
            r48 = r21
            r50 = r23
            r51 = r24
            r52 = r0
            r27.<init>(r28, r30, r32, r33, r34, r35, r36, r37, r39, r40, r41, r42, r44, r45, r46, r47, r48, r50, r51, r52, r53)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r25, long r27, androidx.compose.ui.text.font.FontWeight r29, androidx.compose.ui.text.font.FontStyle r30, androidx.compose.ui.text.font.FontSynthesis r31, androidx.compose.ui.text.font.FontFamily r32, java.lang.String r33, long r34, androidx.compose.ui.text.style.BaselineShift r36, androidx.compose.ui.text.style.TextGeometricTransform r37, androidx.compose.ui.text.intl.LocaleList r38, long r39, androidx.compose.ui.text.style.TextDecoration r41, androidx.compose.ui.graphics.Shadow r42, androidx.compose.ui.text.style.TextAlign r43, androidx.compose.ui.text.style.TextDirection r44, long r45, androidx.compose.ui.text.style.TextIndent r47, androidx.compose.ui.text.PlatformTextStyle r48, androidx.compose.ui.text.style.LineHeightStyle r49) {
        /*
            r24 = this;
            r0 = r48
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r22 = 0
            if (r0 == 0) goto L_0x000f
            androidx.compose.ui.text.PlatformSpanStyle r1 = r48.getSpanStyle()
            r20 = r1
            goto L_0x0011
        L_0x000f:
            r20 = r22
        L_0x0011:
            r21 = 0
            r1 = r15
            r2 = r25
            r4 = r27
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r36
            r14 = r37
            r23 = r15
            r15 = r38
            r16 = r39
            r18 = r41
            r19 = r42
            r1.<init>((long) r2, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (kotlin.jvm.internal.DefaultConstructorMarker) r21)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r0 == 0) goto L_0x003d
            androidx.compose.ui.text.PlatformParagraphStyle r22 = r48.getParagraphStyle()
        L_0x003d:
            r2 = 0
            r3 = 0
            r4 = 0
            r25 = r1
            r26 = r43
            r27 = r44
            r28 = r45
            r30 = r47
            r31 = r22
            r32 = r49
            r33 = r2
            r34 = r3
            r35 = r4
            r25.<init>(r26, r27, r28, r30, r31, r32, r33, r34, r35)
            r2 = r24
            r3 = r23
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(long r29, long r31, androidx.compose.ui.text.font.FontWeight r33, androidx.compose.ui.text.font.FontStyle r34, androidx.compose.ui.text.font.FontSynthesis r35, androidx.compose.ui.text.font.FontFamily r36, java.lang.String r37, long r38, androidx.compose.ui.text.style.BaselineShift r40, androidx.compose.ui.text.style.TextGeometricTransform r41, androidx.compose.ui.text.intl.LocaleList r42, long r43, androidx.compose.ui.text.style.TextDecoration r45, androidx.compose.ui.graphics.Shadow r46, androidx.compose.ui.text.style.TextAlign r47, androidx.compose.ui.text.style.TextDirection r48, long r49, androidx.compose.ui.text.style.TextIndent r51, androidx.compose.ui.text.PlatformTextStyle r52, androidx.compose.ui.text.style.LineHeightStyle r53, androidx.compose.ui.text.style.LineBreak r54, androidx.compose.ui.text.style.Hyphens r55, int r56, kotlin.jvm.internal.DefaultConstructorMarker r57) {
        /*
            r28 = this;
            r0 = r56
            r1 = r0 & 1
            if (r1 == 0) goto L_0x000d
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r1 = r1.m2955getUnspecified0d7_KjU()
            goto L_0x000f
        L_0x000d:
            r1 = r29
        L_0x000f:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x001a
            androidx.compose.ui.unit.TextUnit$Companion r3 = androidx.compose.ui.unit.TextUnit.Companion
            long r3 = r3.m5670getUnspecifiedXSAIIZE()
            goto L_0x001c
        L_0x001a:
            r3 = r31
        L_0x001c:
            r5 = r0 & 4
            if (r5 == 0) goto L_0x0022
            r5 = 0
            goto L_0x0024
        L_0x0022:
            r5 = r33
        L_0x0024:
            r7 = r0 & 8
            if (r7 == 0) goto L_0x002a
            r7 = 0
            goto L_0x002c
        L_0x002a:
            r7 = r34
        L_0x002c:
            r8 = r0 & 16
            if (r8 == 0) goto L_0x0032
            r8 = 0
            goto L_0x0034
        L_0x0032:
            r8 = r35
        L_0x0034:
            r9 = r0 & 32
            if (r9 == 0) goto L_0x003a
            r9 = 0
            goto L_0x003c
        L_0x003a:
            r9 = r36
        L_0x003c:
            r10 = r0 & 64
            if (r10 == 0) goto L_0x0042
            r10 = 0
            goto L_0x0044
        L_0x0042:
            r10 = r37
        L_0x0044:
            r11 = r0 & 128(0x80, float:1.794E-43)
            if (r11 == 0) goto L_0x004f
            androidx.compose.ui.unit.TextUnit$Companion r11 = androidx.compose.ui.unit.TextUnit.Companion
            long r11 = r11.m5670getUnspecifiedXSAIIZE()
            goto L_0x0051
        L_0x004f:
            r11 = r38
        L_0x0051:
            r13 = r0 & 256(0x100, float:3.59E-43)
            if (r13 == 0) goto L_0x0057
            r13 = 0
            goto L_0x0059
        L_0x0057:
            r13 = r40
        L_0x0059:
            r14 = r0 & 512(0x200, float:7.175E-43)
            if (r14 == 0) goto L_0x005f
            r14 = 0
            goto L_0x0061
        L_0x005f:
            r14 = r41
        L_0x0061:
            r15 = r0 & 1024(0x400, float:1.435E-42)
            if (r15 == 0) goto L_0x0067
            r15 = 0
            goto L_0x0069
        L_0x0067:
            r15 = r42
        L_0x0069:
            r6 = r0 & 2048(0x800, float:2.87E-42)
            if (r6 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r6 = androidx.compose.ui.graphics.Color.Companion
            long r16 = r6.m2955getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r16 = r43
        L_0x0076:
            r6 = r0 & 4096(0x1000, float:5.74E-42)
            if (r6 == 0) goto L_0x007c
            r6 = 0
            goto L_0x007e
        L_0x007c:
            r6 = r45
        L_0x007e:
            r18 = r6
            r6 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r6 == 0) goto L_0x0086
            r6 = 0
            goto L_0x0088
        L_0x0086:
            r6 = r46
        L_0x0088:
            r19 = r6
            r6 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r6 == 0) goto L_0x0090
            r6 = 0
            goto L_0x0092
        L_0x0090:
            r6 = r47
        L_0x0092:
            r20 = 32768(0x8000, float:4.5918E-41)
            r20 = r0 & r20
            if (r20 == 0) goto L_0x009c
            r20 = 0
            goto L_0x009e
        L_0x009c:
            r20 = r48
        L_0x009e:
            r21 = 65536(0x10000, float:9.18355E-41)
            r21 = r0 & r21
            if (r21 == 0) goto L_0x00ab
            androidx.compose.ui.unit.TextUnit$Companion r21 = androidx.compose.ui.unit.TextUnit.Companion
            long r21 = r21.m5670getUnspecifiedXSAIIZE()
            goto L_0x00ad
        L_0x00ab:
            r21 = r49
        L_0x00ad:
            r23 = 131072(0x20000, float:1.83671E-40)
            r23 = r0 & r23
            if (r23 == 0) goto L_0x00b6
            r23 = 0
            goto L_0x00b8
        L_0x00b6:
            r23 = r51
        L_0x00b8:
            r24 = 262144(0x40000, float:3.67342E-40)
            r24 = r0 & r24
            if (r24 == 0) goto L_0x00c1
            r24 = 0
            goto L_0x00c3
        L_0x00c1:
            r24 = r52
        L_0x00c3:
            r25 = 524288(0x80000, float:7.34684E-40)
            r25 = r0 & r25
            if (r25 == 0) goto L_0x00cc
            r25 = 0
            goto L_0x00ce
        L_0x00cc:
            r25 = r53
        L_0x00ce:
            r26 = 1048576(0x100000, float:1.469368E-39)
            r26 = r0 & r26
            if (r26 == 0) goto L_0x00d7
            r26 = 0
            goto L_0x00d9
        L_0x00d7:
            r26 = r54
        L_0x00d9:
            r27 = 2097152(0x200000, float:2.938736E-39)
            r0 = r0 & r27
            if (r0 == 0) goto L_0x00e1
            r0 = 0
            goto L_0x00e3
        L_0x00e1:
            r0 = r55
        L_0x00e3:
            r27 = 0
            r57 = r27
            r29 = r28
            r30 = r1
            r32 = r3
            r34 = r5
            r35 = r7
            r36 = r8
            r37 = r9
            r38 = r10
            r39 = r11
            r41 = r13
            r42 = r14
            r43 = r15
            r44 = r16
            r46 = r18
            r47 = r19
            r48 = r6
            r49 = r20
            r50 = r21
            r52 = r23
            r53 = r24
            r54 = r25
            r55 = r26
            r56 = r0
            r29.<init>((long) r30, (long) r32, (androidx.compose.ui.text.font.FontWeight) r34, (androidx.compose.ui.text.font.FontStyle) r35, (androidx.compose.ui.text.font.FontSynthesis) r36, (androidx.compose.ui.text.font.FontFamily) r37, (java.lang.String) r38, (long) r39, (androidx.compose.ui.text.style.BaselineShift) r41, (androidx.compose.ui.text.style.TextGeometricTransform) r42, (androidx.compose.ui.text.intl.LocaleList) r43, (long) r44, (androidx.compose.ui.text.style.TextDecoration) r46, (androidx.compose.ui.graphics.Shadow) r47, (androidx.compose.ui.text.style.TextAlign) r48, (androidx.compose.ui.text.style.TextDirection) r49, (long) r50, (androidx.compose.ui.text.style.TextIndent) r52, (androidx.compose.ui.text.PlatformTextStyle) r53, (androidx.compose.ui.text.style.LineHeightStyle) r54, (androidx.compose.ui.text.style.LineBreak) r55, (androidx.compose.ui.text.style.Hyphens) r56, (kotlin.jvm.internal.DefaultConstructorMarker) r57)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(long r25, long r27, androidx.compose.ui.text.font.FontWeight r29, androidx.compose.ui.text.font.FontStyle r30, androidx.compose.ui.text.font.FontSynthesis r31, androidx.compose.ui.text.font.FontFamily r32, java.lang.String r33, long r34, androidx.compose.ui.text.style.BaselineShift r36, androidx.compose.ui.text.style.TextGeometricTransform r37, androidx.compose.ui.text.intl.LocaleList r38, long r39, androidx.compose.ui.text.style.TextDecoration r41, androidx.compose.ui.graphics.Shadow r42, androidx.compose.ui.text.style.TextAlign r43, androidx.compose.ui.text.style.TextDirection r44, long r45, androidx.compose.ui.text.style.TextIndent r47, androidx.compose.ui.text.PlatformTextStyle r48, androidx.compose.ui.text.style.LineHeightStyle r49, androidx.compose.ui.text.style.LineBreak r50, androidx.compose.ui.text.style.Hyphens r51) {
        /*
            r24 = this;
            r0 = r48
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r22 = 0
            if (r0 == 0) goto L_0x000f
            androidx.compose.ui.text.PlatformSpanStyle r1 = r48.getSpanStyle()
            r20 = r1
            goto L_0x0011
        L_0x000f:
            r20 = r22
        L_0x0011:
            r21 = 0
            r1 = r15
            r2 = r25
            r4 = r27
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r36
            r14 = r37
            r23 = r15
            r15 = r38
            r16 = r39
            r18 = r41
            r19 = r42
            r1.<init>((long) r2, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (kotlin.jvm.internal.DefaultConstructorMarker) r21)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r0 == 0) goto L_0x003d
            androidx.compose.ui.text.PlatformParagraphStyle r22 = r48.getParagraphStyle()
        L_0x003d:
            r2 = 0
            r25 = r1
            r26 = r43
            r27 = r44
            r28 = r45
            r30 = r47
            r31 = r22
            r32 = r49
            r33 = r50
            r34 = r51
            r35 = r2
            r25.<init>(r26, r27, r28, r30, r31, r32, r33, r34, r35)
            r2 = r24
            r3 = r23
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(long, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TextStyle(androidx.compose.ui.graphics.Brush r32, float r33, long r34, androidx.compose.ui.text.font.FontWeight r36, androidx.compose.ui.text.font.FontStyle r37, androidx.compose.ui.text.font.FontSynthesis r38, androidx.compose.ui.text.font.FontFamily r39, java.lang.String r40, long r41, androidx.compose.ui.text.style.BaselineShift r43, androidx.compose.ui.text.style.TextGeometricTransform r44, androidx.compose.ui.text.intl.LocaleList r45, long r46, androidx.compose.ui.text.style.TextDecoration r48, androidx.compose.ui.graphics.Shadow r49, androidx.compose.ui.text.style.TextAlign r50, androidx.compose.ui.text.style.TextDirection r51, long r52, androidx.compose.ui.text.style.TextIndent r54, androidx.compose.ui.text.PlatformTextStyle r55, androidx.compose.ui.text.style.LineHeightStyle r56, androidx.compose.ui.text.style.LineBreak r57, androidx.compose.ui.text.style.Hyphens r58, int r59, kotlin.jvm.internal.DefaultConstructorMarker r60) {
        /*
            r31 = this;
            r0 = r59
            r1 = r0 & 2
            if (r1 == 0) goto L_0x000a
            r1 = 2143289344(0x7fc00000, float:NaN)
            r4 = r1
            goto L_0x000c
        L_0x000a:
            r4 = r33
        L_0x000c:
            r1 = r0 & 4
            if (r1 == 0) goto L_0x0018
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r1 = r1.m5670getUnspecifiedXSAIIZE()
            r5 = r1
            goto L_0x001a
        L_0x0018:
            r5 = r34
        L_0x001a:
            r1 = r0 & 8
            r2 = 0
            if (r1 == 0) goto L_0x0021
            r7 = r2
            goto L_0x0023
        L_0x0021:
            r7 = r36
        L_0x0023:
            r1 = r0 & 16
            if (r1 == 0) goto L_0x0029
            r8 = r2
            goto L_0x002b
        L_0x0029:
            r8 = r37
        L_0x002b:
            r1 = r0 & 32
            if (r1 == 0) goto L_0x0031
            r9 = r2
            goto L_0x0033
        L_0x0031:
            r9 = r38
        L_0x0033:
            r1 = r0 & 64
            if (r1 == 0) goto L_0x0039
            r10 = r2
            goto L_0x003b
        L_0x0039:
            r10 = r39
        L_0x003b:
            r1 = r0 & 128(0x80, float:1.794E-43)
            if (r1 == 0) goto L_0x0041
            r11 = r2
            goto L_0x0043
        L_0x0041:
            r11 = r40
        L_0x0043:
            r1 = r0 & 256(0x100, float:3.59E-43)
            if (r1 == 0) goto L_0x004e
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r12 = r1.m5670getUnspecifiedXSAIIZE()
            goto L_0x0050
        L_0x004e:
            r12 = r41
        L_0x0050:
            r1 = r0 & 512(0x200, float:7.175E-43)
            if (r1 == 0) goto L_0x0056
            r14 = r2
            goto L_0x0058
        L_0x0056:
            r14 = r43
        L_0x0058:
            r1 = r0 & 1024(0x400, float:1.435E-42)
            if (r1 == 0) goto L_0x005e
            r15 = r2
            goto L_0x0060
        L_0x005e:
            r15 = r44
        L_0x0060:
            r1 = r0 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0067
            r16 = r2
            goto L_0x0069
        L_0x0067:
            r16 = r45
        L_0x0069:
            r1 = r0 & 4096(0x1000, float:5.74E-42)
            if (r1 == 0) goto L_0x0074
            androidx.compose.ui.graphics.Color$Companion r1 = androidx.compose.ui.graphics.Color.Companion
            long r17 = r1.m2955getUnspecified0d7_KjU()
            goto L_0x0076
        L_0x0074:
            r17 = r46
        L_0x0076:
            r1 = r0 & 8192(0x2000, float:1.14794E-41)
            if (r1 == 0) goto L_0x007d
            r19 = r2
            goto L_0x007f
        L_0x007d:
            r19 = r48
        L_0x007f:
            r1 = r0 & 16384(0x4000, float:2.2959E-41)
            if (r1 == 0) goto L_0x0086
            r20 = r2
            goto L_0x0088
        L_0x0086:
            r20 = r49
        L_0x0088:
            r1 = 32768(0x8000, float:4.5918E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x0091
            r21 = r2
            goto L_0x0093
        L_0x0091:
            r21 = r50
        L_0x0093:
            r1 = 65536(0x10000, float:9.18355E-41)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x009b
            r22 = r2
            goto L_0x009d
        L_0x009b:
            r22 = r51
        L_0x009d:
            r1 = 131072(0x20000, float:1.83671E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00a9
            androidx.compose.ui.unit.TextUnit$Companion r1 = androidx.compose.ui.unit.TextUnit.Companion
            long r23 = r1.m5670getUnspecifiedXSAIIZE()
            goto L_0x00ab
        L_0x00a9:
            r23 = r52
        L_0x00ab:
            r1 = 262144(0x40000, float:3.67342E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00b3
            r25 = r2
            goto L_0x00b5
        L_0x00b3:
            r25 = r54
        L_0x00b5:
            r1 = 524288(0x80000, float:7.34684E-40)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00bd
            r26 = r2
            goto L_0x00bf
        L_0x00bd:
            r26 = r55
        L_0x00bf:
            r1 = 1048576(0x100000, float:1.469368E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00c7
            r27 = r2
            goto L_0x00c9
        L_0x00c7:
            r27 = r56
        L_0x00c9:
            r1 = 2097152(0x200000, float:2.938736E-39)
            r1 = r1 & r0
            if (r1 == 0) goto L_0x00d1
            r28 = r2
            goto L_0x00d3
        L_0x00d1:
            r28 = r57
        L_0x00d3:
            r1 = 4194304(0x400000, float:5.877472E-39)
            r0 = r0 & r1
            if (r0 == 0) goto L_0x00db
            r29 = r2
            goto L_0x00dd
        L_0x00db:
            r29 = r58
        L_0x00dd:
            r30 = 0
            r2 = r31
            r3 = r32
            r2.<init>((androidx.compose.ui.graphics.Brush) r3, (float) r4, (long) r5, (androidx.compose.ui.text.font.FontWeight) r7, (androidx.compose.ui.text.font.FontStyle) r8, (androidx.compose.ui.text.font.FontSynthesis) r9, (androidx.compose.ui.text.font.FontFamily) r10, (java.lang.String) r11, (long) r12, (androidx.compose.ui.text.style.BaselineShift) r14, (androidx.compose.ui.text.style.TextGeometricTransform) r15, (androidx.compose.ui.text.intl.LocaleList) r16, (long) r17, (androidx.compose.ui.text.style.TextDecoration) r19, (androidx.compose.ui.graphics.Shadow) r20, (androidx.compose.ui.text.style.TextAlign) r21, (androidx.compose.ui.text.style.TextDirection) r22, (long) r23, (androidx.compose.ui.text.style.TextIndent) r25, (androidx.compose.ui.text.PlatformTextStyle) r26, (androidx.compose.ui.text.style.LineHeightStyle) r27, (androidx.compose.ui.text.style.LineBreak) r28, (androidx.compose.ui.text.style.Hyphens) r29, (kotlin.jvm.internal.DefaultConstructorMarker) r30)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private TextStyle(androidx.compose.ui.graphics.Brush r25, float r26, long r27, androidx.compose.ui.text.font.FontWeight r29, androidx.compose.ui.text.font.FontStyle r30, androidx.compose.ui.text.font.FontSynthesis r31, androidx.compose.ui.text.font.FontFamily r32, java.lang.String r33, long r34, androidx.compose.ui.text.style.BaselineShift r36, androidx.compose.ui.text.style.TextGeometricTransform r37, androidx.compose.ui.text.intl.LocaleList r38, long r39, androidx.compose.ui.text.style.TextDecoration r41, androidx.compose.ui.graphics.Shadow r42, androidx.compose.ui.text.style.TextAlign r43, androidx.compose.ui.text.style.TextDirection r44, long r45, androidx.compose.ui.text.style.TextIndent r47, androidx.compose.ui.text.PlatformTextStyle r48, androidx.compose.ui.text.style.LineHeightStyle r49, androidx.compose.ui.text.style.LineBreak r50, androidx.compose.ui.text.style.Hyphens r51) {
        /*
            r24 = this;
            r0 = r48
            androidx.compose.ui.text.SpanStyle r15 = new androidx.compose.ui.text.SpanStyle
            r22 = 0
            if (r0 == 0) goto L_0x000f
            androidx.compose.ui.text.PlatformSpanStyle r1 = r48.getSpanStyle()
            r20 = r1
            goto L_0x0011
        L_0x000f:
            r20 = r22
        L_0x0011:
            r21 = 0
            r1 = r15
            r2 = r25
            r3 = r26
            r4 = r27
            r6 = r29
            r7 = r30
            r8 = r31
            r9 = r32
            r10 = r33
            r11 = r34
            r13 = r36
            r14 = r37
            r23 = r15
            r15 = r38
            r16 = r39
            r18 = r41
            r19 = r42
            r1.<init>((androidx.compose.ui.graphics.Brush) r2, (float) r3, (long) r4, (androidx.compose.ui.text.font.FontWeight) r6, (androidx.compose.ui.text.font.FontStyle) r7, (androidx.compose.ui.text.font.FontSynthesis) r8, (androidx.compose.ui.text.font.FontFamily) r9, (java.lang.String) r10, (long) r11, (androidx.compose.ui.text.style.BaselineShift) r13, (androidx.compose.ui.text.style.TextGeometricTransform) r14, (androidx.compose.ui.text.intl.LocaleList) r15, (long) r16, (androidx.compose.ui.text.style.TextDecoration) r18, (androidx.compose.ui.graphics.Shadow) r19, (androidx.compose.ui.text.PlatformSpanStyle) r20, (kotlin.jvm.internal.DefaultConstructorMarker) r21)
            androidx.compose.ui.text.ParagraphStyle r1 = new androidx.compose.ui.text.ParagraphStyle
            if (r0 == 0) goto L_0x003f
            androidx.compose.ui.text.PlatformParagraphStyle r22 = r48.getParagraphStyle()
        L_0x003f:
            r2 = 0
            r25 = r1
            r26 = r43
            r27 = r44
            r28 = r45
            r30 = r47
            r31 = r22
            r32 = r49
            r33 = r50
            r34 = r51
            r35 = r2
            r25.<init>(r26, r27, r28, r30, r31, r32, r33, r34, r35)
            r2 = r24
            r3 = r23
            r2.<init>(r3, r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.TextStyle.<init>(androidx.compose.ui.graphics.Brush, float, long, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontSynthesis, androidx.compose.ui.text.font.FontFamily, java.lang.String, long, androidx.compose.ui.text.style.BaselineShift, androidx.compose.ui.text.style.TextGeometricTransform, androidx.compose.ui.text.intl.LocaleList, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.graphics.Shadow, androidx.compose.ui.text.style.TextAlign, androidx.compose.ui.text.style.TextDirection, long, androidx.compose.ui.text.style.TextIndent, androidx.compose.ui.text.PlatformTextStyle, androidx.compose.ui.text.style.LineHeightStyle, androidx.compose.ui.text.style.LineBreak, androidx.compose.ui.text.style.Hyphens):void");
    }
}
