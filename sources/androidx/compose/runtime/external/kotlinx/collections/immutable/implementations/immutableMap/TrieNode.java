package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b*\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b(\b\u0000\u0018\u0000 }*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002}~B'\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b¢\u0006\u0002\u0010\tB/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\u0001\u0010\u0011\u001a\u00020\u00122\u0001\u0010\u0013\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u0014H\u0000¢\u0006\u0002\b\u001aJ\u0001\u0010\u0011\u001a\u00020\u00122\u0001\u0010\u0013\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0005H\u0002J\u0014\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002J\u0014\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u001cH\u0002JO\u0010\u001e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010%J\b\u0010&\u001a\u00020\u0005H\u0002J\u0015\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010*J\u0017\u0010+\u001a\u0004\u0018\u00018\u00012\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010,J+\u0010-\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010/J#\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u0000H\u0002¢\u0006\u0002\u00101J+\u00100\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u00102J\u001e\u00103\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00104\u001a\u00020\u0005H\u0002J#\u00105\u001a\u00020(2\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u00107J\u001c\u00108\u001a\u00020(2\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J\r\u0010:\u001a\u00020\u0005H\u0000¢\u0006\u0002\b;J\u0015\u0010<\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\b=J%\u0010>\u001a\u0004\u0018\u00018\u00012\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010?J\u0015\u0010@\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\bAJ\u0010\u0010B\u001a\u00020(2\u0006\u0010 \u001a\u00020\u0005H\u0002J1\u0010C\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010DJ\u0015\u0010E\u001a\u00028\u00002\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010FJ[\u0010G\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010H\u001a\u00020\u00052\u0006\u0010I\u001a\u00028\u00002\u0006\u0010J\u001a\u00028\u00012\u0006\u0010K\u001a\u00020\u00052\u0006\u0010L\u001a\u00028\u00002\u0006\u0010M\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\b\u0010$\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0002\u0010NJI\u0010O\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010PJ=\u0010Q\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010TJ8\u0010U\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010V\u001a\u00020W2\u0006\u0010$\u001a\u00020\u000bH\u0002J?\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010TJ7\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010)\u001a\u00028\u00002\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010YJ2\u0010Z\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00104\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002J9\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010\\JQ\u0010]\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\"\u001a\u00028\u00002\u0006\u0010#\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002¢\u0006\u0002\u0010^JK\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010`JJ\u0010a\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SJT\u0010b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u00109\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010 \u001a\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010V\u001a\u00020W2\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002JM\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010`JE\u0010c\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010S¢\u0006\u0002\u0010dJ:\u0010e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002J.\u0010f\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002JX\u0010h\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u000bH\u0002J8\u0010k\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010$\u001a\u00020\u000bH\u0002J=\u0010l\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u00012\u0012\u0010R\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010SH\u0002¢\u0006\u0002\u0010mJ!\u0010n\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u0005H\u0000¢\u0006\u0002\boJ\u0015\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0000¢\u0006\u0002\bpJ9\u0010q\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u001c2\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010rJ9\u0010s\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010.\u001a\u00028\u00012\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010tJ1\u0010s\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u00106\u001a\u00020\u00052\u0006\u0010)\u001a\u00028\u00002\u0006\u0010\u0018\u001a\u00020\u0005¢\u0006\u0002\u0010uJ&\u0010v\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J&\u0010w\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002JP\u0010x\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010i\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010j\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J8\u0010y\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010g\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u00052\u0012\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J)\u0010z\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010.\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010{J\u0015\u0010|\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010FR0\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u000e\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b@BX\u000e¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "K", "V", "", "dataMap", "", "nodeMap", "buffer", "", "(II[Ljava/lang/Object;)V", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "(II[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "<set-?>", "getBuffer$runtime_release", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "accept", "", "visitor", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "node", "shift", "hash", "accept$runtime_release", "asInsertResult", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "asUpdateResult", "bufferMoveEntryToNode", "keyIndex", "positionMask", "newKeyHash", "newKey", "newValue", "owner", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)[Ljava/lang/Object;", "calculateSize", "collisionContainsKey", "", "key", "(Ljava/lang/Object;)Z", "collisionGet", "(Ljava/lang/Object;)Ljava/lang/Object;", "collisionPut", "value", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "collisionRemove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "collisionRemoveEntryAtIndex", "i", "containsKey", "keyHash", "(ILjava/lang/Object;I)Z", "elementsIdentityEquals", "otherNode", "entryCount", "entryCount$runtime_release", "entryKeyIndex", "entryKeyIndex$runtime_release", "get", "(ILjava/lang/Object;I)Ljava/lang/Object;", "hasEntryAt", "hasEntryAt$runtime_release", "hasNodeAt", "insertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "keyAtIndex", "(I)Ljava/lang/Object;", "makeNode", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "moveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPut", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPutAll", "intersectionCounter", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutableCollisionRemove", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionRemoveEntryAtIndex", "mutableInsertEntryAt", "(ILjava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableMoveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePut", "(ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutablePutAll", "mutablePutAllFromOtherNodeCell", "mutableRemove", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableRemoveEntryAtIndex", "mutableRemoveNodeAtIndex", "nodeIndex", "mutableReplaceNode", "targetNode", "newNode", "mutableUpdateNodeAtIndex", "mutableUpdateValueAtIndex", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "nodeAtIndex", "nodeAtIndex$runtime_release", "nodeIndex$runtime_release", "put", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "remove", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "removeEntryAtIndex", "removeNodeAtIndex", "replaceNode", "updateNodeAtIndex", "updateValueAtIndex", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "valueAtKeyIndex", "Companion", "ModificationResult", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class TrieNode<K, V> {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    @NotNull
    public static final TrieNode EMPTY = new TrieNode(0, 0, new Object[0]);
    @NotNull
    private Object[] buffer;
    private int dataMap;
    private int nodeMap;
    @Nullable
    private final MutabilityOwnership ownedBy;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$Companion;", "", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "", "getEMPTY$runtime_release", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TrieNode getEMPTY$runtime_release() {
            return TrieNode.EMPTY;
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B!\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJD\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002*\u0010\u0010\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0011H\bø\u0001\u0000R&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u0002\u0007\n\u0005\b20\u0001¨\u0006\u0012"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "K", "V", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "sizeDelta", "", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "getNode", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "getSizeDelta", "()I", "replaceNode", "operation", "Lkotlin/Function1;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ModificationResult<K, V> {
        @NotNull
        private TrieNode<K, V> node;
        private final int sizeDelta;

        public ModificationResult(@NotNull TrieNode<K, V> trieNode, int i11) {
            Intrinsics.checkNotNullParameter(trieNode, "node");
            this.node = trieNode;
            this.sizeDelta = i11;
        }

        @NotNull
        public final TrieNode<K, V> getNode() {
            return this.node;
        }

        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        @NotNull
        public final ModificationResult<K, V> replaceNode(@NotNull Function1<? super TrieNode<K, V>, TrieNode<K, V>> function1) {
            Intrinsics.checkNotNullParameter(function1, "operation");
            setNode(function1.invoke(getNode()));
            return this;
        }

        public final void setNode(@NotNull TrieNode<K, V> trieNode) {
            Intrinsics.checkNotNullParameter(trieNode, "<set-?>");
            this.node = trieNode;
        }
    }

    public TrieNode(int i11, int i12, @NotNull Object[] objArr, @Nullable MutabilityOwnership mutabilityOwnership) {
        Intrinsics.checkNotNullParameter(objArr, "buffer");
        this.dataMap = i11;
        this.nodeMap = i12;
        this.ownedBy = mutabilityOwnership;
        this.buffer = objArr;
    }

    private final void accept(Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function5, int i11, int i12) {
        function5.invoke(this, Integer.valueOf(i12), Integer.valueOf(i11), Integer.valueOf(this.dataMap), Integer.valueOf(this.nodeMap));
        int i13 = this.nodeMap;
        while (i13 != 0) {
            int lowestOneBit = Integer.lowestOneBit(i13);
            nodeAtIndex$runtime_release(nodeIndex$runtime_release(lowestOneBit)).accept(function5, (Integer.numberOfTrailingZeros(lowestOneBit) << i12) + i11, i12 + 5);
            i13 -= lowestOneBit;
        }
    }

    private final ModificationResult<K, V> asInsertResult() {
        return new ModificationResult<>(this, 1);
    }

    private final ModificationResult<K, V> asUpdateResult() {
        return new ModificationResult<>(this, 0);
    }

    private final Object[] bufferMoveEntryToNode(int i11, int i12, int i13, K k11, V v11, int i14, MutabilityOwnership mutabilityOwnership) {
        int i15;
        Object keyAtIndex = keyAtIndex(i11);
        if (keyAtIndex != null) {
            i15 = keyAtIndex.hashCode();
        } else {
            i15 = 0;
        }
        TrieNode makeNode = makeNode(i15, keyAtIndex, valueAtKeyIndex(i11), i13, k11, v11, i14 + 5, mutabilityOwnership);
        int i16 = i12;
        int i17 = i11;
        return TrieNodeKt.replaceEntryWithNode(this.buffer, i11, nodeIndex$runtime_release(i12) + 1, makeNode);
    }

    private final int calculateSize() {
        if (this.nodeMap == 0) {
            return this.buffer.length / 2;
        }
        int bitCount = Integer.bitCount(this.dataMap);
        int length = this.buffer.length;
        for (int i11 = bitCount * 2; i11 < length; i11++) {
            bitCount += nodeAtIndex$runtime_release(i11).calculateSize();
        }
        return bitCount;
    }

    private final boolean collisionContainsKey(K k11) {
        IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, this.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (!Intrinsics.areEqual((Object) k11, this.buffer[first])) {
                if (first != last) {
                    first += step2;
                }
            }
            return true;
        }
        return false;
    }

    private final V collisionGet(K k11) {
        IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, this.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 <= 0 || first > last) && (step2 >= 0 || last > first)) {
            return null;
        }
        while (!Intrinsics.areEqual((Object) k11, keyAtIndex(first))) {
            if (first == last) {
                return null;
            }
            first += step2;
        }
        return valueAtKeyIndex(first);
    }

    private final ModificationResult<K, V> collisionPut(K k11, V v11) {
        IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, this.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (!Intrinsics.areEqual((Object) k11, keyAtIndex(first))) {
                if (first != last) {
                    first += step2;
                }
            }
            if (v11 == valueAtKeyIndex(first)) {
                return null;
            }
            Object[] objArr = this.buffer;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            copyOf[first + 1] = v11;
            return new TrieNode(0, 0, copyOf).asUpdateResult();
        }
        return new TrieNode(0, 0, TrieNodeKt.insertEntryAtIndex(this.buffer, 0, k11, v11)).asInsertResult();
    }

    private final TrieNode<K, V> collisionRemove(K k11) {
        IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, this.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (!Intrinsics.areEqual((Object) k11, keyAtIndex(first))) {
                if (first != last) {
                    first += step2;
                }
            }
            return collisionRemoveEntryAtIndex(first);
        }
        return this;
    }

    private final TrieNode<K, V> collisionRemoveEntryAtIndex(int i11) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(0, 0, TrieNodeKt.removeEntryAtIndex(objArr, i11));
    }

    private final boolean elementsIdentityEquals(TrieNode<K, V> trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.nodeMap != trieNode.nodeMap || this.dataMap != trieNode.dataMap) {
            return false;
        }
        int length = this.buffer.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (this.buffer[i11] != trieNode.buffer[i11]) {
                return false;
            }
        }
        return true;
    }

    private final boolean hasNodeAt(int i11) {
        return (i11 & this.nodeMap) != 0;
    }

    private final TrieNode<K, V> insertEntryAt(int i11, K k11, V v11) {
        return new TrieNode<>(i11 | this.dataMap, this.nodeMap, TrieNodeKt.insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release(i11), k11, v11));
    }

    private final K keyAtIndex(int i11) {
        return this.buffer[i11];
    }

    private final TrieNode<K, V> makeNode(int i11, K k11, V v11, int i12, K k12, V v12, int i13, MutabilityOwnership mutabilityOwnership) {
        int i14 = i13;
        MutabilityOwnership mutabilityOwnership2 = mutabilityOwnership;
        if (i14 > 30) {
            return new TrieNode<>(0, 0, new Object[]{k11, v11, k12, v12}, mutabilityOwnership2);
        }
        int i15 = i11;
        int indexSegment = TrieNodeKt.indexSegment(i11, i14);
        int indexSegment2 = TrieNodeKt.indexSegment(i12, i14);
        if (indexSegment != indexSegment2) {
            return new TrieNode<>((1 << indexSegment) | (1 << indexSegment2), 0, indexSegment < indexSegment2 ? new Object[]{k11, v11, k12, v12} : new Object[]{k12, v12, k11, v11}, mutabilityOwnership2);
        }
        return new TrieNode<>(0, 1 << indexSegment, new Object[]{makeNode(i11, k11, v11, i12, k12, v12, i14 + 5, mutabilityOwnership)}, mutabilityOwnership2);
    }

    private final TrieNode<K, V> moveEntryToNode(int i11, int i12, int i13, K k11, V v11, int i14) {
        return new TrieNode<>(this.dataMap ^ i12, i12 | this.nodeMap, bufferMoveEntryToNode(i11, i12, i13, k11, v11, i14, (MutabilityOwnership) null));
    }

    private final TrieNode<K, V> mutableCollisionPut(K k11, V v11, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, this.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (!Intrinsics.areEqual((Object) k11, keyAtIndex(first))) {
                if (first != last) {
                    first += step2;
                }
            }
            persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(first));
            if (this.ownedBy == persistentHashMapBuilder.getOwnership$runtime_release()) {
                this.buffer[first + 1] = v11;
                return this;
            }
            persistentHashMapBuilder.setModCount$runtime_release(persistentHashMapBuilder.getModCount$runtime_release() + 1);
            Object[] objArr = this.buffer;
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            copyOf[first + 1] = v11;
            return new TrieNode<>(0, 0, copyOf, persistentHashMapBuilder.getOwnership$runtime_release());
        }
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() + 1);
        return new TrieNode<>(0, 0, TrieNodeKt.insertEntryAtIndex(this.buffer, 0, k11, v11), persistentHashMapBuilder.getOwnership$runtime_release());
    }

    private final TrieNode<K, V> mutableCollisionPutAll(TrieNode<K, V> trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        if (this.nodeMap == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        CommonFunctionsKt.m2551assert(z11);
        if (this.dataMap == 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        CommonFunctionsKt.m2551assert(z12);
        if (trieNode.nodeMap == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        CommonFunctionsKt.m2551assert(z13);
        if (trieNode.dataMap == 0) {
            z14 = true;
        } else {
            z14 = false;
        }
        CommonFunctionsKt.m2551assert(z14);
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length + trieNode.buffer.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
        int length = this.buffer.length;
        IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, trieNode.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                if (!collisionContainsKey(trieNode.buffer[first])) {
                    Object[] objArr2 = trieNode.buffer;
                    copyOf[length] = objArr2[first];
                    copyOf[length + 1] = objArr2[first + 1];
                    length += 2;
                } else {
                    deltaCounter.setCount(deltaCounter.getCount() + 1);
                }
                if (first == last) {
                    break;
                }
                first += step2;
            }
        }
        if (length == this.buffer.length) {
            return this;
        }
        if (length == trieNode.buffer.length) {
            return trieNode;
        }
        if (length == copyOf.length) {
            return new TrieNode<>(0, 0, copyOf, mutabilityOwnership);
        }
        Object[] copyOf2 = Arrays.copyOf(copyOf, length);
        Intrinsics.checkNotNullExpressionValue(copyOf2, "copyOf(this, newSize)");
        return new TrieNode<>(0, 0, copyOf2, mutabilityOwnership);
    }

    private final TrieNode<K, V> mutableCollisionRemove(K k11, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, this.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (!Intrinsics.areEqual((Object) k11, keyAtIndex(first))) {
                if (first != last) {
                    first += step2;
                }
            }
            return mutableCollisionRemoveEntryAtIndex(first, persistentHashMapBuilder);
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionRemoveEntryAtIndex(int i11, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(i11));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy != persistentHashMapBuilder.getOwnership$runtime_release()) {
            return new TrieNode<>(0, 0, TrieNodeKt.removeEntryAtIndex(this.buffer, i11), persistentHashMapBuilder.getOwnership$runtime_release());
        }
        this.buffer = TrieNodeKt.removeEntryAtIndex(this.buffer, i11);
        return this;
    }

    private final TrieNode<K, V> mutableInsertEntryAt(int i11, K k11, V v11, MutabilityOwnership mutabilityOwnership) {
        int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(i11);
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = TrieNodeKt.insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release, k11, v11);
            this.dataMap = i11 | this.dataMap;
            return this;
        }
        return new TrieNode<>(i11 | this.dataMap, this.nodeMap, TrieNodeKt.insertEntryAtIndex(this.buffer, entryKeyIndex$runtime_release, k11, v11), mutabilityOwnership);
    }

    private final TrieNode<K, V> mutableMoveEntryToNode(int i11, int i12, int i13, K k11, V v11, int i14, MutabilityOwnership mutabilityOwnership) {
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = bufferMoveEntryToNode(i11, i12, i13, k11, v11, i14, mutabilityOwnership);
            this.dataMap ^= i12;
            this.nodeMap |= i12;
            return this;
        }
        return new TrieNode<>(this.dataMap ^ i12, i12 | this.nodeMap, bufferMoveEntryToNode(i11, i12, i13, k11, v11, i14, mutabilityOwnership), mutabilityOwnership);
    }

    private final TrieNode<K, V> mutablePutAllFromOtherNodeCell(TrieNode<K, V> trieNode, int i11, int i12, DeltaCounter deltaCounter, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        int i13;
        int i14;
        TrieNode<K, V> trieNode2 = trieNode;
        int i15 = i11;
        DeltaCounter deltaCounter2 = deltaCounter;
        int i16 = 0;
        if (hasNodeAt(i15)) {
            TrieNode<K, V> nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(i15));
            if (trieNode.hasNodeAt(i11)) {
                return nodeAtIndex$runtime_release.mutablePutAll(trieNode2.nodeAtIndex$runtime_release(trieNode.nodeIndex$runtime_release(i11)), i12 + 5, deltaCounter2, persistentHashMapBuilder);
            }
            PersistentHashMapBuilder<K, V> persistentHashMapBuilder2 = persistentHashMapBuilder;
            if (!trieNode.hasEntryAt$runtime_release(i11)) {
                return nodeAtIndex$runtime_release;
            }
            int entryKeyIndex$runtime_release = trieNode.entryKeyIndex$runtime_release(i11);
            K keyAtIndex = trieNode2.keyAtIndex(entryKeyIndex$runtime_release);
            V valueAtKeyIndex = trieNode2.valueAtKeyIndex(entryKeyIndex$runtime_release);
            int size = persistentHashMapBuilder.size();
            if (keyAtIndex != null) {
                i16 = keyAtIndex.hashCode();
            }
            TrieNode<K, V> mutablePut = nodeAtIndex$runtime_release.mutablePut(i16, keyAtIndex, valueAtKeyIndex, i12 + 5, persistentHashMapBuilder);
            if (persistentHashMapBuilder.size() != size) {
                return mutablePut;
            }
            deltaCounter2.setCount(deltaCounter.getCount() + 1);
            return mutablePut;
        }
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder3 = persistentHashMapBuilder;
        if (trieNode.hasNodeAt(i11)) {
            TrieNode<K, V> nodeAtIndex$runtime_release2 = trieNode2.nodeAtIndex$runtime_release(trieNode.nodeIndex$runtime_release(i11));
            if (hasEntryAt$runtime_release(i15)) {
                int entryKeyIndex$runtime_release2 = entryKeyIndex$runtime_release(i15);
                Object keyAtIndex2 = keyAtIndex(entryKeyIndex$runtime_release2);
                if (keyAtIndex2 != null) {
                    i14 = keyAtIndex2.hashCode();
                } else {
                    i14 = 0;
                }
                int i17 = i12 + 5;
                if (nodeAtIndex$runtime_release2.containsKey(i14, keyAtIndex2, i17)) {
                    deltaCounter2.setCount(deltaCounter.getCount() + 1);
                } else {
                    Object valueAtKeyIndex2 = valueAtKeyIndex(entryKeyIndex$runtime_release2);
                    if (keyAtIndex2 != null) {
                        i16 = keyAtIndex2.hashCode();
                    }
                    return nodeAtIndex$runtime_release2.mutablePut(i16, keyAtIndex2, valueAtKeyIndex2, i17, persistentHashMapBuilder);
                }
            }
            return nodeAtIndex$runtime_release2;
        }
        int entryKeyIndex$runtime_release3 = entryKeyIndex$runtime_release(i15);
        Object keyAtIndex3 = keyAtIndex(entryKeyIndex$runtime_release3);
        Object valueAtKeyIndex3 = valueAtKeyIndex(entryKeyIndex$runtime_release3);
        int entryKeyIndex$runtime_release4 = trieNode.entryKeyIndex$runtime_release(i11);
        K keyAtIndex4 = trieNode2.keyAtIndex(entryKeyIndex$runtime_release4);
        V valueAtKeyIndex4 = trieNode2.valueAtKeyIndex(entryKeyIndex$runtime_release4);
        if (keyAtIndex3 != null) {
            i13 = keyAtIndex3.hashCode();
        } else {
            i13 = 0;
        }
        if (keyAtIndex4 != null) {
            i16 = keyAtIndex4.hashCode();
        }
        return makeNode(i13, keyAtIndex3, valueAtKeyIndex3, i16, keyAtIndex4, valueAtKeyIndex4, i12 + 5, persistentHashMapBuilder.getOwnership$runtime_release());
    }

    private final TrieNode<K, V> mutableRemoveEntryAtIndex(int i11, int i12, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(i11));
        if (this.buffer.length == 2) {
            return null;
        }
        if (this.ownedBy == persistentHashMapBuilder.getOwnership$runtime_release()) {
            this.buffer = TrieNodeKt.removeEntryAtIndex(this.buffer, i11);
            this.dataMap ^= i12;
            return this;
        }
        return new TrieNode<>(i12 ^ this.dataMap, this.nodeMap, TrieNodeKt.removeEntryAtIndex(this.buffer, i11), persistentHashMapBuilder.getOwnership$runtime_release());
    }

    private final TrieNode<K, V> mutableRemoveNodeAtIndex(int i11, int i12, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        if (this.ownedBy == mutabilityOwnership) {
            this.buffer = TrieNodeKt.removeNodeAtIndex(objArr, i11);
            this.nodeMap ^= i12;
            return this;
        }
        return new TrieNode<>(this.dataMap, i12 ^ this.nodeMap, TrieNodeKt.removeNodeAtIndex(objArr, i11), mutabilityOwnership);
    }

    private final TrieNode<K, V> mutableReplaceNode(TrieNode<K, V> trieNode, TrieNode<K, V> trieNode2, int i11, int i12, MutabilityOwnership mutabilityOwnership) {
        if (trieNode2 == null) {
            return mutableRemoveNodeAtIndex(i11, i12, mutabilityOwnership);
        }
        if (this.ownedBy == mutabilityOwnership || trieNode != trieNode2) {
            return mutableUpdateNodeAtIndex(i11, trieNode2, mutabilityOwnership);
        }
        return this;
    }

    private final TrieNode<K, V> mutableUpdateNodeAtIndex(int i11, TrieNode<K, V> trieNode, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1 && trieNode.buffer.length == 2 && trieNode.nodeMap == 0) {
            trieNode.dataMap = this.nodeMap;
            return trieNode;
        } else if (this.ownedBy == mutabilityOwnership) {
            objArr[i11] = trieNode;
            return this;
        } else {
            Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
            copyOf[i11] = trieNode;
            return new TrieNode<>(this.dataMap, this.nodeMap, copyOf, mutabilityOwnership);
        }
    }

    private final TrieNode<K, V> mutableUpdateValueAtIndex(int i11, V v11, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        if (this.ownedBy == persistentHashMapBuilder.getOwnership$runtime_release()) {
            this.buffer[i11 + 1] = v11;
            return this;
        }
        persistentHashMapBuilder.setModCount$runtime_release(persistentHashMapBuilder.getModCount$runtime_release() + 1);
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i11 + 1] = v11;
        return new TrieNode<>(this.dataMap, this.nodeMap, copyOf, persistentHashMapBuilder.getOwnership$runtime_release());
    }

    private final TrieNode<K, V> removeEntryAtIndex(int i11, int i12) {
        Object[] objArr = this.buffer;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode<>(i12 ^ this.dataMap, this.nodeMap, TrieNodeKt.removeEntryAtIndex(objArr, i11));
    }

    private final TrieNode<K, V> removeNodeAtIndex(int i11, int i12) {
        Object[] objArr = this.buffer;
        if (objArr.length == 1) {
            return null;
        }
        return new TrieNode<>(this.dataMap, i12 ^ this.nodeMap, TrieNodeKt.removeNodeAtIndex(objArr, i11));
    }

    private final TrieNode<K, V> replaceNode(TrieNode<K, V> trieNode, TrieNode<K, V> trieNode2, int i11, int i12) {
        if (trieNode2 == null) {
            return removeNodeAtIndex(i11, i12);
        }
        if (trieNode != trieNode2) {
            return updateNodeAtIndex(i11, i12, trieNode2);
        }
        return this;
    }

    private final TrieNode<K, V> updateNodeAtIndex(int i11, int i12, TrieNode<K, V> trieNode) {
        Object[] objArr = trieNode.buffer;
        if (objArr.length != 2 || trieNode.nodeMap != 0) {
            Object[] objArr2 = this.buffer;
            Object[] copyOf = Arrays.copyOf(objArr2, objArr2.length);
            Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, newSize)");
            copyOf[i11] = trieNode;
            return new TrieNode<>(this.dataMap, this.nodeMap, copyOf);
        } else if (this.buffer.length == 1) {
            trieNode.dataMap = this.nodeMap;
            return trieNode;
        } else {
            return new TrieNode<>(this.dataMap ^ i12, i12 ^ this.nodeMap, TrieNodeKt.replaceNodeWithEntry(this.buffer, i11, entryKeyIndex$runtime_release(i12), objArr[0], objArr[1]));
        }
    }

    private final TrieNode<K, V> updateValueAtIndex(int i11, V v11) {
        Object[] objArr = this.buffer;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(copyOf, "copyOf(this, size)");
        copyOf[i11 + 1] = v11;
        return new TrieNode<>(this.dataMap, this.nodeMap, copyOf);
    }

    private final V valueAtKeyIndex(int i11) {
        return this.buffer[i11 + 1];
    }

    public final void accept$runtime_release(@NotNull Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> function5) {
        Intrinsics.checkNotNullParameter(function5, "visitor");
        accept(function5, 0, 0);
    }

    public final boolean containsKey(int i11, K k11, int i12) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasEntryAt$runtime_release(indexSegment)) {
            return Intrinsics.areEqual((Object) k11, keyAtIndex(entryKeyIndex$runtime_release(indexSegment)));
        }
        if (!hasNodeAt(indexSegment)) {
            return false;
        }
        TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(indexSegment));
        if (i12 == 30) {
            return nodeAtIndex$runtime_release.collisionContainsKey(k11);
        }
        return nodeAtIndex$runtime_release.containsKey(i11, k11, i12 + 5);
    }

    public final int entryCount$runtime_release() {
        return Integer.bitCount(this.dataMap);
    }

    public final int entryKeyIndex$runtime_release(int i11) {
        return Integer.bitCount((i11 - 1) & this.dataMap) * 2;
    }

    @Nullable
    public final V get(int i11, K k11, int i12) {
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasEntryAt$runtime_release(indexSegment)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(indexSegment);
            if (Intrinsics.areEqual((Object) k11, keyAtIndex(entryKeyIndex$runtime_release))) {
                return valueAtKeyIndex(entryKeyIndex$runtime_release);
            }
            return null;
        } else if (!hasNodeAt(indexSegment)) {
            return null;
        } else {
            TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release(indexSegment));
            if (i12 == 30) {
                return nodeAtIndex$runtime_release.collisionGet(k11);
            }
            return nodeAtIndex$runtime_release.get(i11, k11, i12 + 5);
        }
    }

    @NotNull
    public final Object[] getBuffer$runtime_release() {
        return this.buffer;
    }

    public final boolean hasEntryAt$runtime_release(int i11) {
        return (i11 & this.dataMap) != 0;
    }

    @NotNull
    public final TrieNode<K, V> mutablePut(int i11, K k11, V v11, int i12, @NotNull PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        TrieNode<K, V> trieNode;
        Intrinsics.checkNotNullParameter(persistentHashMapBuilder, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasEntryAt$runtime_release(indexSegment)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(indexSegment);
            if (Intrinsics.areEqual((Object) k11, keyAtIndex(entryKeyIndex$runtime_release))) {
                persistentHashMapBuilder.setOperationResult$runtime_release(valueAtKeyIndex(entryKeyIndex$runtime_release));
                if (valueAtKeyIndex(entryKeyIndex$runtime_release) == v11) {
                    return this;
                }
                return mutableUpdateValueAtIndex(entryKeyIndex$runtime_release, v11, persistentHashMapBuilder);
            }
            persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() + 1);
            return mutableMoveEntryToNode(entryKeyIndex$runtime_release, indexSegment, i11, k11, v11, i12, persistentHashMapBuilder.getOwnership$runtime_release());
        } else if (hasNodeAt(indexSegment)) {
            int nodeIndex$runtime_release = nodeIndex$runtime_release(indexSegment);
            TrieNode<K, V> nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (i12 == 30) {
                trieNode = nodeAtIndex$runtime_release.mutableCollisionPut(k11, v11, persistentHashMapBuilder);
            } else {
                trieNode = nodeAtIndex$runtime_release.mutablePut(i11, k11, v11, i12 + 5, persistentHashMapBuilder);
            }
            if (nodeAtIndex$runtime_release == trieNode) {
                return this;
            }
            return mutableUpdateNodeAtIndex(nodeIndex$runtime_release, trieNode, persistentHashMapBuilder.getOwnership$runtime_release());
        } else {
            persistentHashMapBuilder.setSize(persistentHashMapBuilder.size() + 1);
            return mutableInsertEntryAt(indexSegment, k11, v11, persistentHashMapBuilder.getOwnership$runtime_release());
        }
    }

    @NotNull
    public final TrieNode<K, V> mutablePutAll(@NotNull TrieNode<K, V> trieNode, int i11, @NotNull DeltaCounter deltaCounter, @NotNull PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        boolean z11;
        TrieNode trieNode2;
        TrieNode<K, V> trieNode3 = trieNode;
        DeltaCounter deltaCounter2 = deltaCounter;
        Intrinsics.checkNotNullParameter(trieNode3, "otherNode");
        Intrinsics.checkNotNullParameter(deltaCounter2, "intersectionCounter");
        Intrinsics.checkNotNullParameter(persistentHashMapBuilder, "mutator");
        if (this == trieNode3) {
            deltaCounter2.plusAssign(calculateSize());
            return this;
        } else if (i11 > 30) {
            return mutableCollisionPutAll(trieNode3, deltaCounter2, persistentHashMapBuilder.getOwnership$runtime_release());
        } else {
            int i12 = this.nodeMap | trieNode3.nodeMap;
            int i13 = this.dataMap;
            int i14 = trieNode3.dataMap;
            int i15 = i13 & i14;
            int i16 = (i13 ^ i14) & (~i12);
            while (i15 != 0) {
                int lowestOneBit = Integer.lowestOneBit(i15);
                if (Intrinsics.areEqual(keyAtIndex(entryKeyIndex$runtime_release(lowestOneBit)), (Object) trieNode3.keyAtIndex(trieNode3.entryKeyIndex$runtime_release(lowestOneBit)))) {
                    i16 |= lowestOneBit;
                } else {
                    i12 |= lowestOneBit;
                }
                i15 ^= lowestOneBit;
            }
            int i17 = 0;
            if ((i12 & i16) == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                if (Intrinsics.areEqual((Object) this.ownedBy, (Object) persistentHashMapBuilder.getOwnership$runtime_release()) && this.dataMap == i16 && this.nodeMap == i12) {
                    trieNode2 = this;
                } else {
                    trieNode2 = new TrieNode(i16, i12, new Object[((Integer.bitCount(i16) * 2) + Integer.bitCount(i12))]);
                }
                int i18 = i12;
                int i19 = 0;
                while (i18 != 0) {
                    int lowestOneBit2 = Integer.lowestOneBit(i18);
                    Object[] objArr = trieNode2.buffer;
                    objArr[(objArr.length - 1) - i19] = mutablePutAllFromOtherNodeCell(trieNode, lowestOneBit2, i11, deltaCounter, persistentHashMapBuilder);
                    i19++;
                    i18 ^= lowestOneBit2;
                }
                while (i16 != 0) {
                    int lowestOneBit3 = Integer.lowestOneBit(i16);
                    int i21 = i17 * 2;
                    if (!trieNode3.hasEntryAt$runtime_release(lowestOneBit3)) {
                        int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(lowestOneBit3);
                        trieNode2.buffer[i21] = keyAtIndex(entryKeyIndex$runtime_release);
                        trieNode2.buffer[i21 + 1] = valueAtKeyIndex(entryKeyIndex$runtime_release);
                    } else {
                        int entryKeyIndex$runtime_release2 = trieNode3.entryKeyIndex$runtime_release(lowestOneBit3);
                        trieNode2.buffer[i21] = trieNode3.keyAtIndex(entryKeyIndex$runtime_release2);
                        trieNode2.buffer[i21 + 1] = trieNode3.valueAtKeyIndex(entryKeyIndex$runtime_release2);
                        if (hasEntryAt$runtime_release(lowestOneBit3)) {
                            deltaCounter2.setCount(deltaCounter.getCount() + 1);
                        }
                    }
                    i17++;
                    i16 ^= lowestOneBit3;
                }
                if (elementsIdentityEquals(trieNode2)) {
                    return this;
                }
                if (trieNode3.elementsIdentityEquals(trieNode2)) {
                    return trieNode3;
                }
                return trieNode2;
            }
            throw new IllegalStateException("Check failed.".toString());
        }
    }

    @Nullable
    public final TrieNode<K, V> mutableRemove(int i11, K k11, int i12, @NotNull PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        TrieNode<K, V> trieNode;
        Intrinsics.checkNotNullParameter(persistentHashMapBuilder, "mutator");
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasEntryAt$runtime_release(indexSegment)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(indexSegment);
            return Intrinsics.areEqual((Object) k11, keyAtIndex(entryKeyIndex$runtime_release)) ? mutableRemoveEntryAtIndex(entryKeyIndex$runtime_release, indexSegment, persistentHashMapBuilder) : this;
        } else if (!hasNodeAt(indexSegment)) {
            return this;
        } else {
            int nodeIndex$runtime_release = nodeIndex$runtime_release(indexSegment);
            TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (i12 == 30) {
                trieNode = nodeAtIndex$runtime_release.mutableCollisionRemove(k11, persistentHashMapBuilder);
            } else {
                trieNode = nodeAtIndex$runtime_release.mutableRemove(i11, k11, i12 + 5, persistentHashMapBuilder);
            }
            return mutableReplaceNode(nodeAtIndex$runtime_release, trieNode, nodeIndex$runtime_release, indexSegment, persistentHashMapBuilder.getOwnership$runtime_release());
        }
    }

    @NotNull
    public final TrieNode<K, V> nodeAtIndex$runtime_release(int i11) {
        Object obj = this.buffer[i11];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (TrieNode) obj;
    }

    public final int nodeIndex$runtime_release(int i11) {
        return (this.buffer.length - 1) - Integer.bitCount((i11 - 1) & this.nodeMap);
    }

    @Nullable
    public final ModificationResult<K, V> put(int i11, K k11, V v11, int i12) {
        ModificationResult<K, V> modificationResult;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasEntryAt$runtime_release(indexSegment)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(indexSegment);
            if (!Intrinsics.areEqual((Object) k11, keyAtIndex(entryKeyIndex$runtime_release))) {
                return moveEntryToNode(entryKeyIndex$runtime_release, indexSegment, i11, k11, v11, i12).asInsertResult();
            }
            if (valueAtKeyIndex(entryKeyIndex$runtime_release) == v11) {
                return null;
            }
            return updateValueAtIndex(entryKeyIndex$runtime_release, v11).asUpdateResult();
        } else if (!hasNodeAt(indexSegment)) {
            return insertEntryAt(indexSegment, k11, v11).asInsertResult();
        } else {
            int nodeIndex$runtime_release = nodeIndex$runtime_release(indexSegment);
            TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (i12 == 30) {
                modificationResult = nodeAtIndex$runtime_release.collisionPut(k11, v11);
                if (modificationResult == null) {
                    return null;
                }
            } else {
                modificationResult = nodeAtIndex$runtime_release.put(i11, k11, v11, i12 + 5);
                if (modificationResult == null) {
                    return null;
                }
            }
            modificationResult.setNode(updateNodeAtIndex(nodeIndex$runtime_release, indexSegment, modificationResult.getNode()));
            return modificationResult;
        }
    }

    @Nullable
    public final TrieNode<K, V> remove(int i11, K k11, int i12) {
        TrieNode trieNode;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasEntryAt$runtime_release(indexSegment)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(indexSegment);
            return Intrinsics.areEqual((Object) k11, keyAtIndex(entryKeyIndex$runtime_release)) ? removeEntryAtIndex(entryKeyIndex$runtime_release, indexSegment) : this;
        } else if (!hasNodeAt(indexSegment)) {
            return this;
        } else {
            int nodeIndex$runtime_release = nodeIndex$runtime_release(indexSegment);
            TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (i12 == 30) {
                trieNode = nodeAtIndex$runtime_release.collisionRemove(k11);
            } else {
                trieNode = nodeAtIndex$runtime_release.remove(i11, k11, i12 + 5);
            }
            return replaceNode(nodeAtIndex$runtime_release, trieNode, nodeIndex$runtime_release, indexSegment);
        }
    }

    private final TrieNode<K, V> collisionRemove(K k11, V v11) {
        IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, this.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                if (!Intrinsics.areEqual((Object) k11, keyAtIndex(first)) || !Intrinsics.areEqual((Object) v11, valueAtKeyIndex(first))) {
                    if (first == last) {
                        break;
                    }
                    first += step2;
                } else {
                    return collisionRemoveEntryAtIndex(first);
                }
            }
        }
        return this;
    }

    private final TrieNode<K, V> mutableCollisionRemove(K k11, V v11, PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        IntProgression step = RangesKt___RangesKt.step((IntProgression) RangesKt___RangesKt.until(0, this.buffer.length), 2);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if ((step2 > 0 && first <= last) || (step2 < 0 && last <= first)) {
            while (true) {
                if (!Intrinsics.areEqual((Object) k11, keyAtIndex(first)) || !Intrinsics.areEqual((Object) v11, valueAtKeyIndex(first))) {
                    if (first == last) {
                        break;
                    }
                    first += step2;
                } else {
                    return mutableCollisionRemoveEntryAtIndex(first, persistentHashMapBuilder);
                }
            }
        }
        return this;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TrieNode(int i11, int i12, @NotNull Object[] objArr) {
        this(i11, i12, objArr, (MutabilityOwnership) null);
        Intrinsics.checkNotNullParameter(objArr, "buffer");
    }

    @Nullable
    public final TrieNode<K, V> mutableRemove(int i11, K k11, V v11, int i12, @NotNull PersistentHashMapBuilder<K, V> persistentHashMapBuilder) {
        TrieNode<K, V> trieNode;
        K k12 = k11;
        V v12 = v11;
        int i13 = i12;
        PersistentHashMapBuilder<K, V> persistentHashMapBuilder2 = persistentHashMapBuilder;
        Intrinsics.checkNotNullParameter(persistentHashMapBuilder2, "mutator");
        int i14 = i11;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasEntryAt$runtime_release(indexSegment)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(indexSegment);
            return (!Intrinsics.areEqual((Object) k11, keyAtIndex(entryKeyIndex$runtime_release)) || !Intrinsics.areEqual((Object) v11, valueAtKeyIndex(entryKeyIndex$runtime_release))) ? this : mutableRemoveEntryAtIndex(entryKeyIndex$runtime_release, indexSegment, persistentHashMapBuilder2);
        } else if (!hasNodeAt(indexSegment)) {
            return this;
        } else {
            int nodeIndex$runtime_release = nodeIndex$runtime_release(indexSegment);
            TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (i13 == 30) {
                trieNode = nodeAtIndex$runtime_release.mutableCollisionRemove(k11, v11, persistentHashMapBuilder2);
            } else {
                trieNode = nodeAtIndex$runtime_release.mutableRemove(i11, k11, v11, i13 + 5, persistentHashMapBuilder);
            }
            return mutableReplaceNode(nodeAtIndex$runtime_release, trieNode, nodeIndex$runtime_release, indexSegment, persistentHashMapBuilder.getOwnership$runtime_release());
        }
    }

    @Nullable
    public final TrieNode<K, V> remove(int i11, K k11, V v11, int i12) {
        TrieNode trieNode;
        int indexSegment = 1 << TrieNodeKt.indexSegment(i11, i12);
        if (hasEntryAt$runtime_release(indexSegment)) {
            int entryKeyIndex$runtime_release = entryKeyIndex$runtime_release(indexSegment);
            return (!Intrinsics.areEqual((Object) k11, keyAtIndex(entryKeyIndex$runtime_release)) || !Intrinsics.areEqual((Object) v11, valueAtKeyIndex(entryKeyIndex$runtime_release))) ? this : removeEntryAtIndex(entryKeyIndex$runtime_release, indexSegment);
        } else if (!hasNodeAt(indexSegment)) {
            return this;
        } else {
            int nodeIndex$runtime_release = nodeIndex$runtime_release(indexSegment);
            TrieNode nodeAtIndex$runtime_release = nodeAtIndex$runtime_release(nodeIndex$runtime_release);
            if (i12 == 30) {
                trieNode = nodeAtIndex$runtime_release.collisionRemove(k11, v11);
            } else {
                trieNode = nodeAtIndex$runtime_release.remove(i11, k11, v11, i12 + 5);
            }
            return replaceNode(nodeAtIndex$runtime_release, trieNode, nodeIndex$runtime_release, indexSegment);
        }
    }
}
