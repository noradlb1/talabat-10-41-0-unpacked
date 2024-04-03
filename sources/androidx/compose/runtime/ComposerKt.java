package androidx.compose.runtime;

import androidx.compose.runtime.collection.IdentityArraySet;
import androidx.compose.runtime.external.kotlinx.collections.immutable.ExtensionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentMap;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000ä\u0001\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010%\n\u0002\b\u0010\u001a\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020CH\u0000\u001ai\u0010D\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`H2\u0012\u0010I\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030K0J2&\u0010L\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`HH\u0003¢\u0006\u0002\u0010M\u001a(\u0010N\u001a\u0004\u0018\u00010\u00012\b\u0010O\u001a\u0004\u0018\u00010\u00012\b\u0010P\u001a\u0004\u0018\u00010\u00012\b\u0010Q\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\b\u0010R\u001a\u00020SH\u0007\u001aP\u0010T\u001a>\u0012\u0004\u0012\u0002HV\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HX0Wj\b\u0012\u0004\u0012\u0002HX`Y0Uj\u001e\u0012\u0004\u0012\u0002HV\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HX0Wj\b\u0012\u0004\u0012\u0002HX`Y`Z\"\u0004\b\u0000\u0010V\"\u0004\b\u0001\u0010XH\u0002\u001a\u0010\u0010[\u001a\u00020\u00172\u0006\u0010O\u001a\u00020SH\u0000\u001a\"\u0010[\u001a\u00020\u00172\u0006\u0010O\u001a\u00020S2\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00010]H\bø\u0001\u0000\u001a\u0018\u0010^\u001a\u00020\u00172\u0006\u0010_\u001a\u00020`2\u0006\u0010^\u001a\u00020CH\u0007\u001a\u0010\u0010a\u001a\u00020\u00172\u0006\u0010_\u001a\u00020`H\u0007\u001a \u0010b\u001a\u00020\u00172\u0006\u0010_\u001a\u00020`2\u0006\u0010c\u001a\u00020\u00072\u0006\u0010^\u001a\u00020CH\u0007\u001a\b\u0010d\u001a\u00020\u0017H\u0007\u001a(\u0010e\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00072\u0006\u0010f\u001a\u00020\u00072\u0006\u0010g\u001a\u00020\u00072\u0006\u0010h\u001a\u00020CH\u0007\u001a\u0018\u0010e\u001a\u00020\u00172\u0006\u0010c\u001a\u00020\u00072\u0006\u0010h\u001a\u00020CH\u0007\u001a\f\u0010i\u001a\u00020S*\u00020\u0007H\u0002\u001a\f\u0010j\u001a\u00020\u0007*\u00020SH\u0002\u001a6\u0010k\u001a\u0002Hl\"\u0004\b\u0000\u0010l*\u00020`2\u0006\u0010m\u001a\u00020S2\u0011\u0010n\u001a\r\u0012\u0004\u0012\u0002Hl0]¢\u0006\u0002\boH\bø\u0001\u0000¢\u0006\u0002\u0010p\u001a\u001c\u0010q\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010r*\u00020s2\u0006\u0010t\u001a\u00020uH\u0002\u001a@\u0010v\u001a\u00020S\"\u0004\b\u0000\u0010l*\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`H2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002Hl0FH\u0000\u001a\u001c\u0010w\u001a\u00020\u0007*\u00020x2\u0006\u0010y\u001a\u00020\u00072\u0006\u0010z\u001a\u00020\u0007H\u0002\u001a(\u0010{\u001a\b\u0012\u0004\u0012\u00020}0|*\b\u0012\u0004\u0012\u00020}0|2\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u001a\u00020\u0007H\u0002\u001a\u001c\u0010\u0001\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020}0|2\u0007\u0010\u0001\u001a\u00020\u0007H\u0002\u001a\u001c\u0010\u0001\u001a\u00020\u0007*\b\u0012\u0004\u0012\u00020}0|2\u0007\u0010\u0001\u001a\u00020\u0007H\u0002\u001a%\u0010\u0001\u001a\u0004\u0018\u00010}*\b\u0012\u0004\u0012\u00020}0|2\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u001a\u00020\u0007H\u0002\u001aG\u0010\u0001\u001a\u0002Hl\"\u0004\b\u0000\u0010l*\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`H2\f\u0010c\u001a\b\u0012\u0004\u0012\u0002Hl0FH\u0000¢\u0006\u0003\u0010\u0001\u001a1\u0010\u0001\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020}0|2\u0007\u0010\u0001\u001a\u00020\u00072\b\u0010\u0001\u001a\u00030\u00012\t\u0010\u0001\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0001\u0010\u0001\u001a\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`H*\"\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0Ej\u0002`H21\u0010\u0001\u001a,\u0012!\u0012\u001f\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0\u0001\u0012\u0004\u0012\u00020\u00170\u0001H\bø\u0001\u0000\u001a(\u0010\u0001\u001a\u00020\u0007*\u00020x2\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u00072\u0007\u0010\u0001\u001a\u00020\u0007H\u0002\u001a[\u0010\u0001\u001a\u0004\u0018\u0001HX\"\u0004\b\u0000\u0010V\"\u0004\b\u0001\u0010X*4\u0012\u0004\u0012\u0002HV\u0012\n\u0012\b\u0012\u0004\u0012\u0002HX0W0Uj\u001e\u0012\u0004\u0012\u0002HV\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HX0Wj\b\u0012\u0004\u0012\u0002HX`Y`Z2\u0006\u0010c\u001a\u0002HVH\u0002¢\u0006\u0003\u0010\u0001\u001aa\u0010\u0001\u001a\u00020S\"\u0004\b\u0000\u0010V\"\u0004\b\u0001\u0010X*4\u0012\u0004\u0012\u0002HV\u0012\n\u0012\b\u0012\u0004\u0012\u0002HX0W0Uj\u001e\u0012\u0004\u0012\u0002HV\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HX0Wj\b\u0012\u0004\u0012\u0002HX`Y`Z2\u0006\u0010c\u001a\u0002HV2\u0006\u0010O\u001a\u0002HXH\u0002¢\u0006\u0003\u0010\u0001\u001ac\u0010\u0001\u001a\u0004\u0018\u00010\u0017\"\u0004\b\u0000\u0010V\"\u0004\b\u0001\u0010X*4\u0012\u0004\u0012\u0002HV\u0012\n\u0012\b\u0012\u0004\u0012\u0002HX0W0Uj\u001e\u0012\u0004\u0012\u0002HV\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002HX0Wj\b\u0012\u0004\u0012\u0002HX`Y`Z2\u0006\u0010c\u001a\u0002HV2\u0006\u0010O\u001a\u0002HXH\u0002¢\u0006\u0003\u0010\u0001\u001a\u0015\u0010\u0001\u001a\u00020\u0017*\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0000\u001a\u001e\u0010\u0001\u001a\u0004\u0018\u00010}*\b\u0012\u0004\u0012\u00020}0|2\u0007\u0010\u0001\u001a\u00020\u0007H\u0002\u001a#\u0010\u0001\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020}0|2\u0006\u0010~\u001a\u00020\u00072\u0006\u0010\u001a\u00020\u0007H\u0002\"\u001c\u0010\u0000\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005\"\u0016\u0010\u0006\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\b\u0010\u0003\"\u0016\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0003\"\u000e\u0010\f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"[\u0010\r\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0019\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u001c\u0010\u001a\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u001b\u0010\u0003\u001a\u0004\b\u001c\u0010\u0005\"\u0016\u0010\u001d\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u0003\"\u000e\u0010\u001f\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u000e\u0010 \u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"\u001c\u0010!\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\"\u0010\u0003\u001a\u0004\b#\u0010\u0005\"\u0016\u0010$\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u0003\"\u001c\u0010&\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010\u0003\u001a\u0004\b(\u0010\u0005\"\u0016\u0010)\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b*\u0010\u0003\"\u001c\u0010+\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b,\u0010\u0003\u001a\u0004\b-\u0010\u0005\"\u0016\u0010.\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b/\u0010\u0003\"\u001c\u00100\u001a\u00020\u00018\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b1\u0010\u0003\u001a\u0004\b2\u0010\u0005\"\u0016\u00103\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b4\u0010\u0003\"[\u00105\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000\"[\u00106\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000\"\u0016\u00107\u001a\u00020\u00078\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b8\u0010\u0003\"\u000e\u00109\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000\"[\u0010:\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000\"[\u0010;\u001aO\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000ej\u0002`\u0018X\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010<\u001a\u00020\u0001*\u00020=8BX\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?*\u0001\b\u0000\u0010\u0001\"K\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000e2K\u0012\u0017\u0012\u0015\u0012\u0002\b\u00030\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0013\u0012\u00110\u0013¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\u0015¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0016\u0012\u0004\u0012\u00020\u00170\u000e*E\b\u0000\u0010\u0001\"\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0E2\u001e\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010F\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010G0E\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0001"}, d2 = {"compositionLocalMap", "", "getCompositionLocalMap$annotations", "()V", "getCompositionLocalMap", "()Ljava/lang/Object;", "compositionLocalMapKey", "", "getCompositionLocalMapKey$annotations", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "defaultsKey", "endGroupInstance", "Lkotlin/Function3;", "Landroidx/compose/runtime/Applier;", "Lkotlin/ParameterName;", "name", "applier", "Landroidx/compose/runtime/SlotWriter;", "slots", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "", "Landroidx/compose/runtime/Change;", "invalidGroupLocation", "invocation", "getInvocation$annotations", "getInvocation", "invocationKey", "getInvocationKey$annotations", "nodeKey", "nodeKeyReplace", "provider", "getProvider$annotations", "getProvider", "providerKey", "getProviderKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "providerMapsKey", "getProviderMapsKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerValuesKey", "getProviderValuesKey$annotations", "reference", "getReference$annotations", "getReference", "referenceKey", "getReferenceKey$annotations", "removeCurrentGroupInstance", "resetSlotsInstance", "reuseKey", "getReuseKey$annotations", "rootKey", "skipToGroupEndInstance", "startRootGroup", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "composeRuntimeError", "", "message", "", "compositionLocalMapOf", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "Landroidx/compose/runtime/CompositionLocal;", "Landroidx/compose/runtime/State;", "Landroidx/compose/runtime/CompositionLocalMap;", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "parentScope", "([Landroidx/compose/runtime/ProvidedValue;Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Landroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;", "getKey", "value", "left", "right", "isTraceInProgress", "", "multiMap", "Ljava/util/HashMap;", "K", "Ljava/util/LinkedHashSet;", "V", "Lkotlin/collections/LinkedHashSet;", "Lkotlin/collections/HashMap;", "runtimeCheck", "lazyMessage", "Lkotlin/Function0;", "sourceInformation", "composer", "Landroidx/compose/runtime/Composer;", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "key", "traceEventEnd", "traceEventStart", "dirty1", "dirty2", "info", "asBool", "asInt", "cache", "T", "invalid", "block", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "collectNodesFrom", "", "Landroidx/compose/runtime/SlotTable;", "anchor", "Landroidx/compose/runtime/Anchor;", "contains", "distanceFrom", "Landroidx/compose/runtime/SlotReader;", "index", "root", "filterToRange", "", "Landroidx/compose/runtime/Invalidation;", "start", "end", "findInsertLocation", "location", "findLocation", "firstInRange", "getValueOf", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/PersistentMap;Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "insertIfMissing", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "mutate", "mutator", "Lkotlin/Function1;", "", "nearestCommonRootOf", "a", "b", "common", "pop", "(Ljava/util/HashMap;Ljava/lang/Object;)Ljava/lang/Object;", "put", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Z", "remove", "(Ljava/util/HashMap;Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Unit;", "removeCurrentGroup", "removeLocation", "removeRange", "Change", "CompositionLocalMap", "runtime_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
public final class ComposerKt {
    @NotNull
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");
    public static final int compositionLocalMapKey = 202;
    /* access modifiers changed from: private */
    @Nullable
    public static CompositionTracer compositionTracer = null;
    private static final int defaultsKey = -127;
    /* access modifiers changed from: private */
    @NotNull
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> endGroupInstance = ComposerKt$endGroupInstance$1.INSTANCE;
    private static final int invalidGroupLocation = -2;
    @NotNull
    private static final Object invocation = new OpaqueKey("provider");
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    private static final int nodeKeyReplace = 126;
    @NotNull
    private static final Object provider = new OpaqueKey("provider");
    public static final int providerKey = 201;
    @NotNull
    private static final Object providerMaps = new OpaqueKey("providers");
    public static final int providerMapsKey = 204;
    @NotNull
    private static final Object providerValues = new OpaqueKey("providerValues");
    public static final int providerValuesKey = 203;
    @NotNull
    private static final Object reference = new OpaqueKey("reference");
    public static final int referenceKey = 206;
    /* access modifiers changed from: private */
    @NotNull
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> removeCurrentGroupInstance = ComposerKt$removeCurrentGroupInstance$1.INSTANCE;
    /* access modifiers changed from: private */
    @NotNull
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> resetSlotsInstance = ComposerKt$resetSlotsInstance$1.INSTANCE;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;
    /* access modifiers changed from: private */
    @NotNull
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> skipToGroupEndInstance = ComposerKt$skipToGroupEndInstance$1.INSTANCE;
    /* access modifiers changed from: private */
    @NotNull
    public static final Function3<Applier<?>, SlotWriter, RememberManager, Unit> startRootGroup = ComposerKt$startRootGroup$1.INSTANCE;

    /* access modifiers changed from: private */
    public static final boolean asBool(int i11) {
        return i11 != 0;
    }

    /* access modifiers changed from: private */
    public static final int asInt(boolean z11) {
        return z11 ? 1 : 0;
    }

    @ComposeCompilerApi
    public static final <T> T cache(@NotNull Composer composer, boolean z11, @NotNull Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(composer, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        T rememberedValue = composer.rememberedValue();
        if (!z11 && rememberedValue != Composer.Companion.getEmpty()) {
            return rememberedValue;
        }
        T invoke = function0.invoke();
        composer.updateRememberedValue(invoke);
        return invoke;
    }

    /* access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable slotTable, Anchor anchor) {
        ArrayList arrayList = new ArrayList();
        SlotReader openReader = slotTable.openReader();
        try {
            m2525collectNodesFrom$lambda10$collectFromGroup(openReader, arrayList, slotTable.anchorIndex(anchor));
            Unit unit = Unit.INSTANCE;
            return arrayList;
        } finally {
            openReader.close();
        }
    }

    /* renamed from: collectNodesFrom$lambda-10$collectFromGroup  reason: not valid java name */
    private static final void m2525collectNodesFrom$lambda10$collectFromGroup(SlotReader slotReader, List<Object> list, int i11) {
        if (slotReader.isNode(i11)) {
            list.add(slotReader.node(i11));
            return;
        }
        int i12 = i11 + 1;
        int groupSize = i11 + slotReader.groupSize(i11);
        while (i12 < groupSize) {
            m2525collectNodesFrom$lambda10$collectFromGroup(slotReader, list, i12);
            i12 += slotReader.groupSize(i12);
        }
    }

    @NotNull
    public static final Void composeRuntimeError(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "message");
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + str + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    /* access modifiers changed from: private */
    @Composable
    public static final PersistentMap<CompositionLocal<Object>, State<Object>> compositionLocalMapOf(ProvidedValue<?>[] providedValueArr, PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, Composer composer, int i11) {
        composer.startReplaceableGroup(721128344);
        if (isTraceInProgress()) {
            traceEventStart(721128344, i11, -1, "androidx.compose.runtime.compositionLocalMapOf (Composer.kt:307)");
        }
        PersistentMap.Builder builder = ExtensionsKt.persistentHashMapOf().builder();
        for (ProvidedValue<?> providedValue : providedValueArr) {
            composer.startReplaceableGroup(680852989);
            if (providedValue.getCanOverride() || !contains(persistentMap, providedValue.getCompositionLocal())) {
                CompositionLocal<?> compositionLocal = providedValue.getCompositionLocal();
                Intrinsics.checkNotNull(compositionLocal, "null cannot be cast to non-null type androidx.compose.runtime.CompositionLocal<kotlin.Any?>");
                builder.put(compositionLocal, providedValue.getCompositionLocal().provided$runtime_release(providedValue.getValue(), composer, 72));
            }
            composer.endReplaceableGroup();
        }
        PersistentMap<CompositionLocal<Object>, State<Object>> build = builder.build();
        if (isTraceInProgress()) {
            traceEventEnd();
        }
        composer.endReplaceableGroup();
        return build;
    }

    public static final <T> boolean contains(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, @NotNull CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(compositionLocal, "key");
        return persistentMap.containsKey(compositionLocal);
    }

    private static final int distanceFrom(SlotReader slotReader, int i11, int i12) {
        int i13 = 0;
        while (i11 > 0 && i11 != i12) {
            i11 = slotReader.parent(i11);
            i13++;
        }
        return i13;
    }

    /* access modifiers changed from: private */
    public static final List<Invalidation> filterToRange(List<Invalidation> list, int i11, int i12) {
        ArrayList arrayList = new ArrayList();
        for (int findInsertLocation = findInsertLocation(list, i11); findInsertLocation < list.size(); findInsertLocation++) {
            Invalidation invalidation = list.get(findInsertLocation);
            if (invalidation.getLocation() >= i12) {
                break;
            }
            arrayList.add(invalidation);
        }
        return arrayList;
    }

    private static final int findInsertLocation(List<Invalidation> list, int i11) {
        int findLocation = findLocation(list, i11);
        return findLocation < 0 ? -(findLocation + 1) : findLocation;
    }

    private static final int findLocation(List<Invalidation> list, int i11) {
        int size = list.size() - 1;
        int i12 = 0;
        while (i12 <= size) {
            int i13 = (i12 + size) >>> 1;
            int compare = Intrinsics.compare(list.get(i13).getLocation(), i11);
            if (compare < 0) {
                i12 = i13 + 1;
            } else if (compare <= 0) {
                return i13;
            } else {
                size = i13 - 1;
            }
        }
        return -(i12 + 1);
    }

    /* access modifiers changed from: private */
    public static final Invalidation firstInRange(List<Invalidation> list, int i11, int i12) {
        int findInsertLocation = findInsertLocation(list, i11);
        if (findInsertLocation >= list.size()) {
            return null;
        }
        Invalidation invalidation = list.get(findInsertLocation);
        if (invalidation.getLocation() < i12) {
            return invalidation;
        }
        return null;
    }

    @NotNull
    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    @PublishedApi
    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    private static /* synthetic */ void getCompositionTracer$annotations() {
    }

    @NotNull
    public static final Object getInvocation() {
        return invocation;
    }

    @PublishedApi
    public static /* synthetic */ void getInvocation$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    /* access modifiers changed from: private */
    public static final Object getJoinedKey(KeyInfo keyInfo) {
        return keyInfo.getObjectKey() != null ? new JoinedKey(Integer.valueOf(keyInfo.getKey()), keyInfo.getObjectKey()) : Integer.valueOf(keyInfo.getKey());
    }

    /* access modifiers changed from: private */
    public static final Object getKey(Object obj, Object obj2, Object obj3) {
        JoinedKey joinedKey;
        if (obj instanceof JoinedKey) {
            joinedKey = (JoinedKey) obj;
        } else {
            joinedKey = null;
        }
        if (joinedKey == null) {
            return null;
        }
        if ((!Intrinsics.areEqual(joinedKey.getLeft(), obj2) || !Intrinsics.areEqual(joinedKey.getRight(), obj3)) && (obj = getKey(joinedKey.getLeft(), obj2, obj3)) == null) {
            obj = getKey(joinedKey.getRight(), obj2, obj3);
        }
        return obj;
    }

    @NotNull
    public static final Object getProvider() {
        return provider;
    }

    @PublishedApi
    public static /* synthetic */ void getProvider$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderKey$annotations() {
    }

    @NotNull
    public static final Object getProviderMaps() {
        return providerMaps;
    }

    @PublishedApi
    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    @NotNull
    public static final Object getProviderValues() {
        return providerValues;
    }

    @PublishedApi
    public static /* synthetic */ void getProviderValues$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    @NotNull
    public static final Object getReference() {
        return reference;
    }

    @PublishedApi
    public static /* synthetic */ void getReference$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    @PublishedApi
    public static /* synthetic */ void getReuseKey$annotations() {
    }

    public static final <T> T getValueOf(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, @NotNull CompositionLocal<T> compositionLocal) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(compositionLocal, "key");
        State state = (State) persistentMap.get(compositionLocal);
        if (state != null) {
            return state.getValue();
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void insertIfMissing(List<Invalidation> list, int i11, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int findLocation = findLocation(list, i11);
        IdentityArraySet identityArraySet = null;
        if (findLocation < 0) {
            int i12 = -(findLocation + 1);
            if (obj != null) {
                identityArraySet = new IdentityArraySet();
                identityArraySet.add(obj);
            }
            list.add(i12, new Invalidation(recomposeScopeImpl, i11, identityArraySet));
        } else if (obj == null) {
            list.get(findLocation).setInstances((IdentityArraySet<Object>) null);
        } else {
            IdentityArraySet<Object> instances = list.get(findLocation).getInstances();
            if (instances != null) {
                instances.add(obj);
            }
        }
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        CompositionTracer compositionTracer2 = compositionTracer;
        return compositionTracer2 != null && compositionTracer2.isTraceInProgress();
    }

    /* access modifiers changed from: private */
    public static final <K, V> HashMap<K, LinkedHashSet<V>> multiMap() {
        return new HashMap<>();
    }

    @NotNull
    public static final PersistentMap<CompositionLocal<Object>, State<Object>> mutate(@NotNull PersistentMap<CompositionLocal<Object>, ? extends State<? extends Object>> persistentMap, @NotNull Function1<? super Map<CompositionLocal<Object>, State<Object>>, Unit> function1) {
        Intrinsics.checkNotNullParameter(persistentMap, "<this>");
        Intrinsics.checkNotNullParameter(function1, "mutator");
        PersistentMap.Builder<CompositionLocal<Object>, ? extends State<? extends Object>> builder = persistentMap.builder();
        function1.invoke(builder);
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static final int nearestCommonRootOf(SlotReader slotReader, int i11, int i12, int i13) {
        if (i11 == i12) {
            return i11;
        }
        if (i11 == i13 || i12 == i13) {
            return i13;
        }
        if (slotReader.parent(i11) == i12) {
            return i12;
        }
        if (slotReader.parent(i12) == i11) {
            return i11;
        }
        if (slotReader.parent(i11) == slotReader.parent(i12)) {
            return slotReader.parent(i11);
        }
        int distanceFrom = distanceFrom(slotReader, i11, i13);
        int distanceFrom2 = distanceFrom(slotReader, i12, i13);
        int i14 = distanceFrom - distanceFrom2;
        for (int i15 = 0; i15 < i14; i15++) {
            i11 = slotReader.parent(i11);
        }
        int i16 = distanceFrom2 - distanceFrom;
        for (int i17 = 0; i17 < i16; i17++) {
            i12 = slotReader.parent(i12);
        }
        while (i11 != i12) {
            i11 = slotReader.parent(i11);
            i12 = slotReader.parent(i12);
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public static final <K, V> V pop(HashMap<K, LinkedHashSet<V>> hashMap, K k11) {
        V firstOrNull;
        LinkedHashSet linkedHashSet = hashMap.get(k11);
        if (linkedHashSet == null || (firstOrNull = CollectionsKt___CollectionsKt.firstOrNull(linkedHashSet)) == null) {
            return null;
        }
        remove(hashMap, k11, firstOrNull);
        return firstOrNull;
    }

    /* access modifiers changed from: private */
    public static final <K, V> boolean put(HashMap<K, LinkedHashSet<V>> hashMap, K k11, V v11) {
        LinkedHashSet<V> linkedHashSet = hashMap.get(k11);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
            hashMap.put(k11, linkedHashSet);
        }
        return linkedHashSet.add(v11);
    }

    private static final <K, V> Unit remove(HashMap<K, LinkedHashSet<V>> hashMap, K k11, V v11) {
        LinkedHashSet linkedHashSet = hashMap.get(k11);
        if (linkedHashSet == null) {
            return null;
        }
        linkedHashSet.remove(v11);
        if (linkedHashSet.isEmpty()) {
            hashMap.remove(k11);
        }
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0026, code lost:
        r1 = (androidx.compose.runtime.RecomposeScopeImpl) r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void removeCurrentGroup(@org.jetbrains.annotations.NotNull androidx.compose.runtime.SlotWriter r4, @org.jetbrains.annotations.NotNull androidx.compose.runtime.RememberManager r5) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "rememberManager"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.util.Iterator r0 = r4.groupSlots()
        L_0x000e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0036
            java.lang.Object r1 = r0.next()
            boolean r2 = r1 instanceof androidx.compose.runtime.RememberObserver
            if (r2 == 0) goto L_0x0022
            androidx.compose.runtime.RememberObserver r1 = (androidx.compose.runtime.RememberObserver) r1
            r5.forgetting(r1)
            goto L_0x000e
        L_0x0022:
            boolean r2 = r1 instanceof androidx.compose.runtime.RecomposeScopeImpl
            if (r2 == 0) goto L_0x000e
            androidx.compose.runtime.RecomposeScopeImpl r1 = (androidx.compose.runtime.RecomposeScopeImpl) r1
            androidx.compose.runtime.CompositionImpl r2 = r1.getComposition()
            if (r2 == 0) goto L_0x000e
            r3 = 1
            r2.setPendingInvalidScopes$runtime_release(r3)
            r1.release()
            goto L_0x000e
        L_0x0036:
            r4.removeGroup()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.ComposerKt.removeCurrentGroup(androidx.compose.runtime.SlotWriter, androidx.compose.runtime.RememberManager):void");
    }

    /* access modifiers changed from: private */
    public static final Invalidation removeLocation(List<Invalidation> list, int i11) {
        int findLocation = findLocation(list, i11);
        if (findLocation >= 0) {
            return list.remove(findLocation);
        }
        return null;
    }

    /* access modifiers changed from: private */
    public static final void removeRange(List<Invalidation> list, int i11, int i12) {
        int findInsertLocation = findInsertLocation(list, i11);
        while (findInsertLocation < list.size() && list.get(findInsertLocation).getLocation() < i12) {
            list.remove(findInsertLocation);
        }
    }

    public static final void runtimeCheck(boolean z11, @NotNull Function0<? extends Object> function0) {
        Intrinsics.checkNotNullParameter(function0, "lazyMessage");
        if (!z11) {
            composeRuntimeError(function0.invoke().toString());
            throw new KotlinNothingValueException();
        }
    }

    @ComposeCompilerApi
    public static final void sourceInformation(@NotNull Composer composer, @NotNull String str) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(str, "sourceInformation");
        composer.sourceInformation(str);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(@NotNull Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        composer.sourceInformationMarkerEnd();
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(@NotNull Composer composer, int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        Intrinsics.checkNotNullParameter(str, "sourceInformation");
        composer.sourceInformationMarkerStart(i11, str);
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventEnd();
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload with $dirty metadata instead", replaceWith = @ReplaceWith(expression = "traceEventStart(key, dirty1, dirty2, info)", imports = {}))
    @ComposeCompilerApi
    public static final /* synthetic */ void traceEventStart(int i11, String str) {
        Intrinsics.checkNotNullParameter(str, CustomerInfoLocalDataSourceImpl.KEY);
        traceEventStart(i11, -1, -1, str);
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int i11, int i12, int i13, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, CustomerInfoLocalDataSourceImpl.KEY);
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventStart(i11, i12, i13, str);
        }
    }

    public static final void runtimeCheck(boolean z11) {
        if (!z11) {
            composeRuntimeError("Check failed".toString());
            throw new KotlinNothingValueException();
        }
    }
}
