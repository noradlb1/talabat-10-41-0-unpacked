package kotlinx.coroutines.debug.internal;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLongFieldUpdater;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.concurrent.ThreadsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.CoroutineStackFrame;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineId;
import kotlinx.coroutines.CoroutineName;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.JobSupport;
import kotlinx.coroutines.internal.ScopeCoroutine;
import kotlinx.coroutines.internal.StackTraceRecoveryKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ö\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0003\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001b\bÀ\u0002\u0018\u00002\u00020\u0014:\u0002\u0001B\t\b\u0002¢\u0006\u0004\b\u0001\u0010\u0002J3\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\u0004\b\u0011\u0010\u0012J\u0013\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013¢\u0006\u0004\b\u0015\u0010\u0016J@\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u000f\"\b\b\u0000\u0010\u0017*\u00020\u00142\u001e\b\u0004\u0010\u001b\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00028\u00000\u0018H\b¢\u0006\u0004\b\u001c\u0010\u001dJ\u0017\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u001e\u0010\u000eJ\u0013\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001f0\u000f¢\u0006\u0004\b \u0010\u0012J)\u0010$\u001a\b\u0012\u0004\u0012\u00020\"0\u000f2\u0006\u0010!\u001a\u00020\u00102\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000f¢\u0006\u0004\b$\u0010%J\u0015\u0010'\u001a\u00020&2\u0006\u0010!\u001a\u00020\u0010¢\u0006\u0004\b'\u0010(J5\u0010,\u001a\b\u0012\u0004\u0012\u00020\"0\u000f2\u0006\u0010)\u001a\u00020&2\b\u0010+\u001a\u0004\u0018\u00010*2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\b,\u0010-J?\u00102\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020.012\u0006\u0010/\u001a\u00020.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\"0\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\b2\u00103J3\u00105\u001a\u00020.2\u0006\u00104\u001a\u00020.2\f\u00100\u001a\b\u0012\u0004\u0012\u00020\"0\u00132\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\b5\u00106J\u001d\u00109\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\f\u0018\u000107H\u0002¢\u0006\u0004\b9\u0010:J\u0015\u0010=\u001a\u00020&2\u0006\u0010<\u001a\u00020;¢\u0006\u0004\b=\u0010>J\r\u0010?\u001a\u00020\f¢\u0006\u0004\b?\u0010\u0002J%\u0010A\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\n2\f\u0010@\u001a\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\bA\u0010BJ\u001b\u0010D\u001a\u00020\f2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030\u0019H\u0002¢\u0006\u0004\bD\u0010EJ)\u0010H\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\"\u0004\b\u0000\u0010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004H\u0000¢\u0006\u0004\bF\u0010GJ\u001b\u0010K\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\bI\u0010JJ\u001b\u0010M\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u0004H\u0000¢\u0006\u0004\bL\u0010JJ'\u0010P\u001a\b\u0012\u0004\u0012\u00020\"0\u000f\"\b\b\u0000\u0010\u0003*\u00020N2\u0006\u0010O\u001a\u00028\u0000H\u0002¢\u0006\u0004\bP\u0010QJ\u000f\u0010R\u001a\u00020\fH\u0002¢\u0006\u0004\bR\u0010\u0002J\u000f\u0010S\u001a\u00020\fH\u0002¢\u0006\u0004\bS\u0010\u0002J\r\u0010T\u001a\u00020\f¢\u0006\u0004\bT\u0010\u0002J\u001f\u0010V\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020U2\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\bV\u0010WJ#\u0010X\u001a\u00020\f2\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\bX\u0010YJ/\u0010X\u001a\u00020\f2\n\u0010C\u001a\u0006\u0012\u0002\b\u00030\u00192\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010)\u001a\u00020&H\u0002¢\u0006\u0004\bX\u0010ZJ;\u0010b\u001a\u00020\f*\u00020;2\u0012\u0010]\u001a\u000e\u0012\u0004\u0012\u00020;\u0012\u0004\u0012\u00020\\0[2\n\u0010`\u001a\u00060^j\u0002`_2\u0006\u0010a\u001a\u00020&H\u0002¢\u0006\u0004\bb\u0010cJ\u0017\u0010d\u001a\u000208*\u0006\u0012\u0002\b\u00030\u0019H\u0002¢\u0006\u0004\bd\u0010eJ\u001d\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u0006\u0012\u0002\b\u00030\u0004H\u0002¢\u0006\u0004\bC\u0010fJ\u001a\u0010C\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0019*\u00020UH\u0010¢\u0006\u0004\bC\u0010gJ\u0016\u0010h\u001a\u0004\u0018\u00010U*\u00020UH\u0010¢\u0006\u0004\bh\u0010iJ\u001b\u0010j\u001a\u0004\u0018\u00010\u0006*\b\u0012\u0004\u0012\u00020\"0\u000fH\u0002¢\u0006\u0004\bj\u0010kJ\u0013\u0010l\u001a\u00020&*\u00020\u0014H\u0002¢\u0006\u0004\bl\u0010mR\u0014\u0010n\u001a\u00020&8\u0002XT¢\u0006\u0006\n\u0004\bn\u0010oR \u0010q\u001a\u000e\u0012\u0004\u0012\u00020U\u0012\u0004\u0012\u00020\\0p8\u0002X\u0004¢\u0006\u0006\n\u0004\bq\u0010rR\u001e\u0010v\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00190s8BX\u0004¢\u0006\u0006\u001a\u0004\bt\u0010uR$\u0010w\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0019\u0012\u0004\u0012\u0002080p8\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010rR\u0014\u0010y\u001a\u00020x8\u0002X\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u0014\u0010|\u001a\u00020{8\u0002X\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\"\u0010~\u001a\u0010\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\f\u0018\u0001078\u0002X\u0004¢\u0006\u0006\n\u0004\b~\u0010R)\u0010\u0001\u001a\u0002088\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u0019\u0010\u0001\u001a\u00020.8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\u0017\u0010\u0001\u001a\u0002088@X\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R)\u0010\u0001\u001a\u0002088\u0006@\u0006X\u000e¢\u0006\u0018\n\u0006\b\u0001\u0010\u0001\u001a\u0006\b\u0001\u0010\u0001\"\u0006\b\u0001\u0010\u0001R\u001b\u0010\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u000e¢\u0006\b\n\u0006\b\u0001\u0010\u0001R\"\u0010\u0001\u001a\u00020&*\u00020;8BX\u0004¢\u0006\u000f\u0012\u0006\b\u0001\u0010\u0001\u001a\u0005\b\u0001\u0010>R\u001b\u0010\u0001\u001a\u000208*\u00020\"8BX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006\u0001"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl;", "<init>", "()V", "T", "Lkotlin/coroutines/Continuation;", "completion", "Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "frame", "createOwner", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/StackTraceFrame;)Lkotlin/coroutines/Continuation;", "Ljava/io/PrintStream;", "out", "", "dumpCoroutines", "(Ljava/io/PrintStream;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;", "dumpCoroutinesInfo", "()Ljava/util/List;", "", "", "dumpCoroutinesInfoAsJsonAndReferences", "()[Ljava/lang/Object;", "R", "Lkotlin/Function2;", "Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "Lkotlin/coroutines/CoroutineContext;", "create", "dumpCoroutinesInfoImpl", "(Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "dumpCoroutinesSynchronized", "Lkotlinx/coroutines/debug/internal/DebuggerInfo;", "dumpDebuggerInfo", "info", "Ljava/lang/StackTraceElement;", "coroutineTrace", "enhanceStackTraceWithThreadDump", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;Ljava/util/List;)Ljava/util/List;", "", "enhanceStackTraceWithThreadDumpAsJson", "(Lkotlinx/coroutines/debug/internal/DebugCoroutineInfo;)Ljava/lang/String;", "state", "Ljava/lang/Thread;", "thread", "enhanceStackTraceWithThreadDumpImpl", "(Ljava/lang/String;Ljava/lang/Thread;Ljava/util/List;)Ljava/util/List;", "", "indexOfResumeWith", "actualTrace", "Lkotlin/Pair;", "findContinuationStartIndex", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)Lkotlin/Pair;", "frameIndex", "findIndexOfFrame", "(I[Ljava/lang/StackTraceElement;Ljava/util/List;)I", "Lkotlin/Function1;", "", "getDynamicAttach", "()Lkotlin/jvm/functions/Function1;", "Lkotlinx/coroutines/Job;", "job", "hierarchyToString", "(Lkotlinx/coroutines/Job;)Ljava/lang/String;", "install", "frames", "printStackTrace", "(Ljava/io/PrintStream;Ljava/util/List;)V", "owner", "probeCoroutineCompleted", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)V", "probeCoroutineCreated$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "probeCoroutineCreated", "probeCoroutineResumed$kotlinx_coroutines_core", "(Lkotlin/coroutines/Continuation;)V", "probeCoroutineResumed", "probeCoroutineSuspended$kotlinx_coroutines_core", "probeCoroutineSuspended", "", "throwable", "sanitizeStackTrace", "(Ljava/lang/Throwable;)Ljava/util/List;", "startWeakRefCleanerThread", "stopWeakRefCleanerThread", "uninstall", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "updateRunningState", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;Ljava/lang/String;)V", "updateState", "(Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;Lkotlin/coroutines/Continuation;Ljava/lang/String;)V", "", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "map", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "builder", "indent", "build", "(Lkotlinx/coroutines/Job;Ljava/util/Map;Ljava/lang/StringBuilder;Ljava/lang/String;)V", "isFinished", "(Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;)Z", "(Lkotlin/coroutines/Continuation;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "realCaller", "(Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "toStackTraceFrame", "(Ljava/util/List;)Lkotlinx/coroutines/debug/internal/StackTraceFrame;", "toStringWithQuotes", "(Ljava/lang/Object;)Ljava/lang/String;", "ARTIFICIAL_FRAME_MESSAGE", "Ljava/lang/String;", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "callerInfoCache", "Lkotlinx/coroutines/debug/internal/ConcurrentWeakMap;", "", "getCapturedCoroutines", "()Ljava/util/Set;", "capturedCoroutines", "capturedCoroutinesMap", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "coroutineStateLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "Ljava/text/SimpleDateFormat;", "dateFormat", "Ljava/text/SimpleDateFormat;", "dynamicAttach", "Lkotlin/jvm/functions/Function1;", "enableCreationStackTraces", "Z", "getEnableCreationStackTraces", "()Z", "setEnableCreationStackTraces", "(Z)V", "installations", "I", "isInstalled$kotlinx_coroutines_core", "isInstalled", "sanitizeStackTraces", "getSanitizeStackTraces", "setSanitizeStackTraces", "weakRefCleanerThread", "Ljava/lang/Thread;", "getDebugString", "getDebugString$annotations", "(Lkotlinx/coroutines/Job;)V", "debugString", "isInternalMethod", "(Ljava/lang/StackTraceElement;)Z", "CoroutineOwner", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class DebugProbesImpl {
    @NotNull
    private static final String ARTIFICIAL_FRAME_MESSAGE = "Coroutine creation stacktrace";
    @NotNull
    public static final DebugProbesImpl INSTANCE;
    /* access modifiers changed from: private */
    @NotNull
    public static final ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> callerInfoCache = new ConcurrentWeakMap<>(true);
    @NotNull
    private static final ConcurrentWeakMap<CoroutineOwner<?>, Boolean> capturedCoroutinesMap = new ConcurrentWeakMap<>(false, 1, (DefaultConstructorMarker) null);
    @NotNull
    private static final ReentrantReadWriteLock coroutineStateLock = new ReentrantReadWriteLock();
    @NotNull
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    @NotNull
    private static final /* synthetic */ SequenceNumberRefVolatile debugProbesImpl$SequenceNumberRefVolatile = new SequenceNumberRefVolatile(0);
    @Nullable
    private static final Function1<Boolean, Unit> dynamicAttach;
    private static boolean enableCreationStackTraces = true;
    private static volatile int installations;
    private static boolean sanitizeStackTraces = true;
    private static final /* synthetic */ AtomicLongFieldUpdater sequenceNumber$FU = AtomicLongFieldUpdater.newUpdater(SequenceNumberRefVolatile.class, "sequenceNumber");
    @Nullable
    private static Thread weakRefCleanerThread;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\n\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u001e\u0010\u0012\u001a\u00020\u00132\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00028\u00000\u0015H\u0016ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\b\u0010\u0017\u001a\u00020\u0018H\u0016R\u0016\u0010\t\u001a\u0004\u0018\u00010\u00038VX\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX\u0005¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00028\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Lkotlinx/coroutines/debug/internal/DebugProbesImpl$CoroutineOwner;", "T", "Lkotlin/coroutines/Continuation;", "Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "delegate", "info", "Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;", "frame", "(Lkotlin/coroutines/Continuation;Lkotlinx/coroutines/debug/internal/DebugCoroutineInfoImpl;Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;)V", "callerFrame", "getCallerFrame", "()Lkotlin/coroutines/jvm/internal/CoroutineStackFrame;", "context", "Lkotlin/coroutines/CoroutineContext;", "getContext", "()Lkotlin/coroutines/CoroutineContext;", "getStackTraceElement", "Ljava/lang/StackTraceElement;", "resumeWith", "", "result", "Lkotlin/Result;", "(Ljava/lang/Object;)V", "toString", "", "kotlinx-coroutines-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class CoroutineOwner<T> implements Continuation<T>, CoroutineStackFrame {
        @NotNull
        @JvmField
        public final Continuation<T> delegate;
        @Nullable
        private final CoroutineStackFrame frame;
        @NotNull
        @JvmField
        public final DebugCoroutineInfoImpl info;

        public CoroutineOwner(@NotNull Continuation<? super T> continuation, @NotNull DebugCoroutineInfoImpl debugCoroutineInfoImpl, @Nullable CoroutineStackFrame coroutineStackFrame) {
            this.delegate = continuation;
            this.info = debugCoroutineInfoImpl;
            this.frame = coroutineStackFrame;
        }

        @Nullable
        public CoroutineStackFrame getCallerFrame() {
            CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getCallerFrame();
            }
            return null;
        }

        @NotNull
        public CoroutineContext getContext() {
            return this.delegate.getContext();
        }

        @Nullable
        public StackTraceElement getStackTraceElement() {
            CoroutineStackFrame coroutineStackFrame = this.frame;
            if (coroutineStackFrame != null) {
                return coroutineStackFrame.getStackTraceElement();
            }
            return null;
        }

        public void resumeWith(@NotNull Object obj) {
            DebugProbesImpl.INSTANCE.probeCoroutineCompleted(this);
            this.delegate.resumeWith(obj);
        }

        @NotNull
        public String toString() {
            return this.delegate.toString();
        }
    }

    /* synthetic */ class SequenceNumberRefVolatile {
        volatile long sequenceNumber;

        public SequenceNumberRefVolatile(long j11) {
            this.sequenceNumber = j11;
        }
    }

    static {
        DebugProbesImpl debugProbesImpl = new DebugProbesImpl();
        INSTANCE = debugProbesImpl;
        dynamicAttach = debugProbesImpl.getDynamicAttach();
    }

    private DebugProbesImpl() {
    }

    private final void build(Job job, Map<Job, DebugCoroutineInfoImpl> map, StringBuilder sb2, String str) {
        DebugCoroutineInfoImpl debugCoroutineInfoImpl = map.get(job);
        if (debugCoroutineInfoImpl != null) {
            String state = debugCoroutineInfoImpl.getState();
            sb2.append(str + getDebugString(job) + ", continuation is " + state + " at line " + ((StackTraceElement) CollectionsKt___CollectionsKt.firstOrNull(debugCoroutineInfoImpl.lastObservedStackTrace())) + 10);
            StringBuilder sb3 = new StringBuilder();
            sb3.append(str);
            sb3.append(9);
            str = sb3.toString();
        } else if (!(job instanceof ScopeCoroutine)) {
            sb2.append(str + getDebugString(job) + 10);
            StringBuilder sb4 = new StringBuilder();
            sb4.append(str);
            sb4.append(9);
            str = sb4.toString();
        }
        for (Job build : job.getChildren()) {
            build(build, map, sb2, str);
        }
    }

    private final <T> Continuation<T> createOwner(Continuation<? super T> continuation, StackTraceFrame stackTraceFrame) {
        if (!isInstalled$kotlinx_coroutines_core()) {
            return continuation;
        }
        CoroutineOwner coroutineOwner = new CoroutineOwner(continuation, new DebugCoroutineInfoImpl(continuation.getContext(), stackTraceFrame, sequenceNumber$FU.incrementAndGet(debugProbesImpl$SequenceNumberRefVolatile)), stackTraceFrame);
        ConcurrentWeakMap<CoroutineOwner<?>, Boolean> concurrentWeakMap = capturedCoroutinesMap;
        concurrentWeakMap.put(coroutineOwner, Boolean.TRUE);
        if (!isInstalled$kotlinx_coroutines_core()) {
            concurrentWeakMap.clear();
        }
        return coroutineOwner;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final <R> java.util.List<R> dumpCoroutinesInfoImpl(kotlin.jvm.functions.Function2<? super kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner<?>, ? super kotlin.coroutines.CoroutineContext, ? extends R> r8) {
        /*
            r7 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = r3
        L_0x0013:
            r4 = r3
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            r4 = 1
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = INSTANCE     // Catch:{ all -> 0x0068 }
            boolean r6 = r5.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0068 }
            if (r6 == 0) goto L_0x005c
            java.util.Set r5 = r5.getCapturedCoroutines()     // Catch:{ all -> 0x0068 }
            kotlin.sequences.Sequence r5 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r5)     // Catch:{ all -> 0x0068 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1 r6 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1     // Catch:{ all -> 0x0068 }
            r6.<init>()     // Catch:{ all -> 0x0068 }
            kotlin.sequences.Sequence r5 = kotlin.sequences.SequencesKt___SequencesKt.sortedWith(r5, r6)     // Catch:{ all -> 0x0068 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$1$3 r6 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$1$3     // Catch:{ all -> 0x0068 }
            r6.<init>(r8)     // Catch:{ all -> 0x0068 }
            kotlin.sequences.Sequence r8 = kotlin.sequences.SequencesKt___SequencesKt.mapNotNull(r5, r6)     // Catch:{ all -> 0x0068 }
            java.util.List r8 = kotlin.sequences.SequencesKt___SequencesKt.toList(r8)     // Catch:{ all -> 0x0068 }
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
        L_0x004d:
            if (r3 >= r2) goto L_0x0055
            r1.lock()
            int r3 = r3 + 1
            goto L_0x004d
        L_0x0055:
            r0.unlock()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            return r8
        L_0x005c:
            java.lang.String r8 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0068 }
            java.lang.String r8 = r8.toString()     // Catch:{ all -> 0x0068 }
            r5.<init>(r8)     // Catch:{ all -> 0x0068 }
            throw r5     // Catch:{ all -> 0x0068 }
        L_0x0068:
            r8 = move-exception
            kotlin.jvm.internal.InlineMarker.finallyStart(r4)
        L_0x006c:
            if (r3 >= r2) goto L_0x0074
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006c
        L_0x0074:
            r0.unlock()
            kotlin.jvm.internal.InlineMarker.finallyEnd(r4)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfoImpl(kotlin.jvm.functions.Function2):java.util.List");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    private final void dumpCoroutinesSynchronized(java.io.PrintStream r14) {
        /*
            r13 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = r3
        L_0x0013:
            r4 = r3
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0114 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0114 }
            if (r5 == 0) goto L_0x0108
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            r5.<init>()     // Catch:{ all -> 0x0114 }
            java.lang.String r6 = "Coroutines dump "
            r5.append(r6)     // Catch:{ all -> 0x0114 }
            java.text.SimpleDateFormat r6 = dateFormat     // Catch:{ all -> 0x0114 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0114 }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ all -> 0x0114 }
            java.lang.String r6 = r6.format(r7)     // Catch:{ all -> 0x0114 }
            r5.append(r6)     // Catch:{ all -> 0x0114 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0114 }
            r14.print(r5)     // Catch:{ all -> 0x0114 }
            java.util.Set r4 = r4.getCapturedCoroutines()     // Catch:{ all -> 0x0114 }
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r4)     // Catch:{ all -> 0x0114 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$1$2 r5 = kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$1$2.INSTANCE     // Catch:{ all -> 0x0114 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt___SequencesKt.filter(r4, r5)     // Catch:{ all -> 0x0114 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$lambda-19$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesSynchronized$lambda-19$$inlined$sortedBy$1     // Catch:{ all -> 0x0114 }
            r5.<init>()     // Catch:{ all -> 0x0114 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt___SequencesKt.sortedWith(r4, r5)     // Catch:{ all -> 0x0114 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x0114 }
        L_0x0068:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x0114 }
            if (r5 == 0) goto L_0x00fa
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x0114 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r5 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r5     // Catch:{ all -> 0x0114 }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r6 = r5.info     // Catch:{ all -> 0x0114 }
            java.util.List r7 = r6.lastObservedStackTrace()     // Catch:{ all -> 0x0114 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r8 = INSTANCE     // Catch:{ all -> 0x0114 }
            java.lang.String r9 = r6.getState()     // Catch:{ all -> 0x0114 }
            java.lang.Thread r10 = r6.lastObservedThread     // Catch:{ all -> 0x0114 }
            java.util.List r9 = r8.enhanceStackTraceWithThreadDumpImpl(r9, r10, r7)     // Catch:{ all -> 0x0114 }
            java.lang.String r10 = r6.getState()     // Catch:{ all -> 0x0114 }
            java.lang.String r11 = "RUNNING"
            boolean r10 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r10, (java.lang.Object) r11)     // Catch:{ all -> 0x0114 }
            if (r10 == 0) goto L_0x00aa
            if (r9 != r7) goto L_0x00aa
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            r10.<init>()     // Catch:{ all -> 0x0114 }
            java.lang.String r11 = r6.getState()     // Catch:{ all -> 0x0114 }
            r10.append(r11)     // Catch:{ all -> 0x0114 }
            java.lang.String r11 = " (Last suspension stacktrace, not an actual stacktrace)"
            r10.append(r11)     // Catch:{ all -> 0x0114 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x0114 }
            goto L_0x00ae
        L_0x00aa:
            java.lang.String r10 = r6.getState()     // Catch:{ all -> 0x0114 }
        L_0x00ae:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            r11.<init>()     // Catch:{ all -> 0x0114 }
            java.lang.String r12 = "\n\nCoroutine "
            r11.append(r12)     // Catch:{ all -> 0x0114 }
            kotlin.coroutines.Continuation<T> r5 = r5.delegate     // Catch:{ all -> 0x0114 }
            r11.append(r5)     // Catch:{ all -> 0x0114 }
            java.lang.String r5 = ", state: "
            r11.append(r5)     // Catch:{ all -> 0x0114 }
            r11.append(r10)     // Catch:{ all -> 0x0114 }
            java.lang.String r5 = r11.toString()     // Catch:{ all -> 0x0114 }
            r14.print(r5)     // Catch:{ all -> 0x0114 }
            boolean r5 = r7.isEmpty()     // Catch:{ all -> 0x0114 }
            if (r5 == 0) goto L_0x00f5
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0114 }
            r5.<init>()     // Catch:{ all -> 0x0114 }
            java.lang.String r7 = "\n\tat "
            r5.append(r7)     // Catch:{ all -> 0x0114 }
            java.lang.String r7 = "Coroutine creation stacktrace"
            java.lang.StackTraceElement r7 = kotlinx.coroutines.internal.StackTraceRecoveryKt.artificialFrame(r7)     // Catch:{ all -> 0x0114 }
            r5.append(r7)     // Catch:{ all -> 0x0114 }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x0114 }
            r14.print(r5)     // Catch:{ all -> 0x0114 }
            java.util.List r5 = r6.getCreationStackTrace()     // Catch:{ all -> 0x0114 }
            r8.printStackTrace(r14, r5)     // Catch:{ all -> 0x0114 }
            goto L_0x0068
        L_0x00f5:
            r8.printStackTrace(r14, r9)     // Catch:{ all -> 0x0114 }
            goto L_0x0068
        L_0x00fa:
            kotlin.Unit r14 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0114 }
        L_0x00fc:
            if (r3 >= r2) goto L_0x0104
            r1.lock()
            int r3 = r3 + 1
            goto L_0x00fc
        L_0x0104:
            r0.unlock()
            return
        L_0x0108:
            java.lang.String r14 = "Debug probes are not installed"
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0114 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0114 }
            r4.<init>(r14)     // Catch:{ all -> 0x0114 }
            throw r4     // Catch:{ all -> 0x0114 }
        L_0x0114:
            r14 = move-exception
        L_0x0115:
            if (r3 >= r2) goto L_0x011d
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0115
        L_0x011d:
            r0.unlock()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesSynchronized(java.io.PrintStream):void");
    }

    private final List<StackTraceElement> enhanceStackTraceWithThreadDumpImpl(String str, Thread thread, List<StackTraceElement> list) {
        Object obj;
        boolean z11;
        if (!Intrinsics.areEqual((Object) str, (Object) DebugCoroutineInfoImplKt.RUNNING) || thread == null) {
            return list;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj = Result.m6329constructorimpl(thread.getStackTrace());
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
        if (Result.m6335isFailureimpl(obj)) {
            obj = null;
        }
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) obj;
        if (stackTraceElementArr == null) {
            return list;
        }
        int length = stackTraceElementArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            }
            StackTraceElement stackTraceElement = stackTraceElementArr[i11];
            if (!Intrinsics.areEqual((Object) stackTraceElement.getClassName(), (Object) "kotlin.coroutines.jvm.internal.BaseContinuationImpl") || !Intrinsics.areEqual((Object) stackTraceElement.getMethodName(), (Object) "resumeWith") || !Intrinsics.areEqual((Object) stackTraceElement.getFileName(), (Object) "ContinuationImpl.kt")) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                break;
            }
            i11++;
        }
        Pair<Integer, Integer> findContinuationStartIndex = findContinuationStartIndex(i11, stackTraceElementArr, list);
        int intValue = findContinuationStartIndex.component1().intValue();
        int intValue2 = findContinuationStartIndex.component2().intValue();
        if (intValue == -1) {
            return list;
        }
        ArrayList arrayList = new ArrayList((((list.size() + i11) - intValue) - 1) - intValue2);
        int i12 = i11 - intValue2;
        for (int i13 = 0; i13 < i12; i13++) {
            arrayList.add(stackTraceElementArr[i13]);
        }
        int size = list.size();
        for (int i14 = intValue + 1; i14 < size; i14++) {
            arrayList.add(list.get(i14));
        }
        return arrayList;
    }

    private final Pair<Integer, Integer> findContinuationStartIndex(int i11, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        for (int i12 = 0; i12 < 3; i12++) {
            int findIndexOfFrame = INSTANCE.findIndexOfFrame((i11 - 1) - i12, stackTraceElementArr, list);
            if (findIndexOfFrame != -1) {
                return TuplesKt.to(Integer.valueOf(findIndexOfFrame), Integer.valueOf(i12));
            }
        }
        return TuplesKt.to(-1, 0);
    }

    private final int findIndexOfFrame(int i11, StackTraceElement[] stackTraceElementArr, List<StackTraceElement> list) {
        boolean z11;
        StackTraceElement stackTraceElement = (StackTraceElement) ArraysKt___ArraysKt.getOrNull((T[]) stackTraceElementArr, i11);
        if (stackTraceElement == null) {
            return -1;
        }
        int i12 = 0;
        for (StackTraceElement next : list) {
            if (!Intrinsics.areEqual((Object) next.getFileName(), (Object) stackTraceElement.getFileName()) || !Intrinsics.areEqual((Object) next.getClassName(), (Object) stackTraceElement.getClassName()) || !Intrinsics.areEqual((Object) next.getMethodName(), (Object) stackTraceElement.getMethodName())) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                return i12;
            }
            i12++;
        }
        return -1;
    }

    private final Set<CoroutineOwner<?>> getCapturedCoroutines() {
        return capturedCoroutinesMap.keySet();
    }

    private final String getDebugString(Job job) {
        return job instanceof JobSupport ? ((JobSupport) job).toDebugString() : job.toString();
    }

    private static /* synthetic */ void getDebugString$annotations(Job job) {
    }

    private final Function1<Boolean, Unit> getDynamicAttach() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            Object newInstance = Class.forName("kotlinx.coroutines.debug.internal.ByteBuddyDynamicAttach").getConstructors()[0].newInstance(new Object[0]);
            if (newInstance != null) {
                obj = Result.m6329constructorimpl((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(newInstance, 1));
                if (Result.m6335isFailureimpl(obj)) {
                    obj = null;
                }
                return (Function1) obj;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Function1<kotlin.Boolean, kotlin.Unit>");
        } catch (Throwable th2) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.m6329constructorimpl(ResultKt.createFailure(th2));
        }
    }

    /* access modifiers changed from: private */
    public final boolean isFinished(CoroutineOwner<?> coroutineOwner) {
        Job job;
        CoroutineContext context = coroutineOwner.info.getContext();
        if (context == null || (job = (Job) context.get(Job.Key)) == null || !job.isCompleted()) {
            return false;
        }
        capturedCoroutinesMap.remove(coroutineOwner);
        return true;
    }

    private final boolean isInternalMethod(StackTraceElement stackTraceElement) {
        return StringsKt__StringsJVMKt.startsWith$default(stackTraceElement.getClassName(), "kotlinx.coroutines", false, 2, (Object) null);
    }

    private final CoroutineOwner<?> owner(Continuation<?> continuation) {
        CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
        if (coroutineStackFrame != null) {
            return owner(coroutineStackFrame);
        }
        return null;
    }

    private final void printStackTrace(PrintStream printStream, List<StackTraceElement> list) {
        for (StackTraceElement stackTraceElement : list) {
            printStream.print("\n\tat " + stackTraceElement);
        }
    }

    /* access modifiers changed from: private */
    public final void probeCoroutineCompleted(CoroutineOwner<?> coroutineOwner) {
        CoroutineStackFrame realCaller;
        capturedCoroutinesMap.remove(coroutineOwner);
        CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = coroutineOwner.info.getLastObservedFrame$kotlinx_coroutines_core();
        if (lastObservedFrame$kotlinx_coroutines_core != null && (realCaller = realCaller(lastObservedFrame$kotlinx_coroutines_core)) != null) {
            callerInfoCache.remove(realCaller);
        }
    }

    private final CoroutineStackFrame realCaller(CoroutineStackFrame coroutineStackFrame) {
        do {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        } while (coroutineStackFrame.getStackTraceElement() == null);
        return coroutineStackFrame;
    }

    private final <T extends Throwable> List<StackTraceElement> sanitizeStackTrace(T t11) {
        int i11;
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = t11.getStackTrace();
        int length = stackTrace.length;
        int i12 = -1;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i13 = length2 - 1;
                if (Intrinsics.areEqual((Object) stackTrace[length2].getClassName(), (Object) "kotlin.coroutines.jvm.internal.DebugProbesKt")) {
                    i12 = length2;
                    break;
                } else if (i13 < 0) {
                    break;
                } else {
                    length2 = i13;
                }
            }
        }
        if (!sanitizeStackTraces) {
            int i14 = length - i11;
            ArrayList arrayList = new ArrayList(i14);
            for (int i15 = 0; i15 < i14; i15++) {
                if (i15 == 0) {
                    stackTraceElement = StackTraceRecoveryKt.artificialFrame(ARTIFICIAL_FRAME_MESSAGE);
                } else {
                    stackTraceElement = stackTrace[i15 + i11];
                }
                arrayList.add(stackTraceElement);
            }
            return arrayList;
        }
        ArrayList arrayList2 = new ArrayList((length - i11) + 1);
        arrayList2.add(StackTraceRecoveryKt.artificialFrame(ARTIFICIAL_FRAME_MESSAGE));
        while (true) {
            i11++;
            while (i11 < length) {
                if (isInternalMethod(stackTrace[i11])) {
                    arrayList2.add(stackTrace[i11]);
                    int i16 = i11 + 1;
                    while (i16 < length && isInternalMethod(stackTrace[i16])) {
                        i16++;
                    }
                    int i17 = i16 - 1;
                    int i18 = i17;
                    while (i18 > i11 && stackTrace[i18].getFileName() == null) {
                        i18--;
                    }
                    if (i18 > i11 && i18 < i17) {
                        arrayList2.add(stackTrace[i18]);
                    }
                    arrayList2.add(stackTrace[i17]);
                    i11 = i16;
                } else {
                    arrayList2.add(stackTrace[i11]);
                }
            }
            return arrayList2;
        }
    }

    private final void startWeakRefCleanerThread() {
        weakRefCleanerThread = ThreadsKt.thread$default(false, true, (ClassLoader) null, "Coroutines Debugger Cleaner", 0, DebugProbesImpl$startWeakRefCleanerThread$1.INSTANCE, 21, (Object) null);
    }

    private final void stopWeakRefCleanerThread() {
        Thread thread = weakRefCleanerThread;
        if (thread != null) {
            weakRefCleanerThread = null;
            thread.interrupt();
            thread.join();
        }
    }

    private final StackTraceFrame toStackTraceFrame(List<StackTraceElement> list) {
        StackTraceFrame stackTraceFrame = null;
        if (!list.isEmpty()) {
            ListIterator<StackTraceElement> listIterator = list.listIterator(list.size());
            while (listIterator.hasPrevious()) {
                stackTraceFrame = new StackTraceFrame(stackTraceFrame, listIterator.previous());
            }
        }
        return stackTraceFrame;
    }

    private final String toStringWithQuotes(Object obj) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append('\"');
        sb2.append(obj);
        sb2.append('\"');
        return sb2.toString();
    }

    private final void updateRunningState(CoroutineStackFrame coroutineStackFrame, String str) {
        CoroutineStackFrame coroutineStackFrame2;
        ReentrantReadWriteLock.ReadLock readLock = coroutineStateLock.readLock();
        readLock.lock();
        try {
            DebugProbesImpl debugProbesImpl = INSTANCE;
            if (debugProbesImpl.isInstalled$kotlinx_coroutines_core()) {
                ConcurrentWeakMap<CoroutineStackFrame, DebugCoroutineInfoImpl> concurrentWeakMap = callerInfoCache;
                DebugCoroutineInfoImpl remove = concurrentWeakMap.remove(coroutineStackFrame);
                if (remove == null) {
                    CoroutineOwner<?> owner = debugProbesImpl.owner(coroutineStackFrame);
                    if (owner != null) {
                        remove = owner.info;
                        if (remove != null) {
                            CoroutineStackFrame lastObservedFrame$kotlinx_coroutines_core = remove.getLastObservedFrame$kotlinx_coroutines_core();
                            if (lastObservedFrame$kotlinx_coroutines_core != null) {
                                coroutineStackFrame2 = debugProbesImpl.realCaller(lastObservedFrame$kotlinx_coroutines_core);
                            } else {
                                coroutineStackFrame2 = null;
                            }
                            if (coroutineStackFrame2 != null) {
                                concurrentWeakMap.remove(coroutineStackFrame2);
                            }
                        }
                    }
                    readLock.unlock();
                    return;
                }
                remove.updateState$kotlinx_coroutines_core(str, (Continuation) coroutineStackFrame);
                CoroutineStackFrame realCaller = debugProbesImpl.realCaller(coroutineStackFrame);
                if (realCaller == null) {
                    readLock.unlock();
                    return;
                }
                concurrentWeakMap.put(realCaller, remove);
                Unit unit = Unit.INSTANCE;
                readLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }

    private final void updateState(Continuation<?> continuation, String str) {
        if (isInstalled$kotlinx_coroutines_core()) {
            if (!Intrinsics.areEqual((Object) str, (Object) DebugCoroutineInfoImplKt.RUNNING) || !KotlinVersion.CURRENT.isAtLeast(1, 3, 30)) {
                CoroutineOwner<?> owner = owner(continuation);
                if (owner != null) {
                    updateState(owner, continuation, str);
                    return;
                }
                return;
            }
            CoroutineStackFrame coroutineStackFrame = continuation instanceof CoroutineStackFrame ? (CoroutineStackFrame) continuation : null;
            if (coroutineStackFrame != null) {
                updateRunningState(coroutineStackFrame, str);
            }
        }
    }

    public final void dumpCoroutines(@NotNull PrintStream printStream) {
        synchronized (printStream) {
            INSTANCE.dumpCoroutinesSynchronized(printStream);
            Unit unit = Unit.INSTANCE;
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlinx.coroutines.debug.internal.DebugCoroutineInfo> dumpCoroutinesInfo() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = r3
        L_0x0013:
            r4 = r3
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0061 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x0055
            java.util.Set r4 = r4.getCapturedCoroutines()     // Catch:{ all -> 0x0061 }
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r4)     // Catch:{ all -> 0x0061 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1     // Catch:{ all -> 0x0061 }
            r5.<init>()     // Catch:{ all -> 0x0061 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt___SequencesKt.sortedWith(r4, r5)     // Catch:{ all -> 0x0061 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfo$$inlined$dumpCoroutinesInfoImpl$1     // Catch:{ all -> 0x0061 }
            r5.<init>()     // Catch:{ all -> 0x0061 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt___SequencesKt.mapNotNull(r4, r5)     // Catch:{ all -> 0x0061 }
            java.util.List r4 = kotlin.sequences.SequencesKt___SequencesKt.toList(r4)     // Catch:{ all -> 0x0061 }
        L_0x0049:
            if (r3 >= r2) goto L_0x0051
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0049
        L_0x0051:
            r0.unlock()
            return r4
        L_0x0055:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0061 }
            r5.<init>(r4)     // Catch:{ all -> 0x0061 }
            throw r5     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r4 = move-exception
        L_0x0062:
            if (r3 >= r2) goto L_0x006a
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0062
        L_0x006a:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpCoroutinesInfo():java.util.List");
    }

    @NotNull
    public final Object[] dumpCoroutinesInfoAsJsonAndReferences() {
        String str;
        String str2;
        String name2;
        List<DebugCoroutineInfo> dumpCoroutinesInfo = dumpCoroutinesInfo();
        int size = dumpCoroutinesInfo.size();
        ArrayList arrayList = new ArrayList(size);
        ArrayList arrayList2 = new ArrayList(size);
        ArrayList arrayList3 = new ArrayList(size);
        for (DebugCoroutineInfo next : dumpCoroutinesInfo) {
            CoroutineContext context = next.getContext();
            CoroutineName coroutineName = (CoroutineName) context.get(CoroutineName.Key);
            Long l11 = null;
            if (coroutineName == null || (name2 = coroutineName.getName()) == null) {
                str = null;
            } else {
                str = toStringWithQuotes(name2);
            }
            CoroutineDispatcher coroutineDispatcher = (CoroutineDispatcher) context.get(CoroutineDispatcher.Key);
            if (coroutineDispatcher != null) {
                str2 = toStringWithQuotes(coroutineDispatcher);
            } else {
                str2 = null;
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n                {\n                    \"name\": ");
            sb2.append(str);
            sb2.append(",\n                    \"id\": ");
            CoroutineId coroutineId = (CoroutineId) context.get(CoroutineId.Key);
            if (coroutineId != null) {
                l11 = Long.valueOf(coroutineId.getId());
            }
            sb2.append(l11);
            sb2.append(",\n                    \"dispatcher\": ");
            sb2.append(str2);
            sb2.append(",\n                    \"sequenceNumber\": ");
            sb2.append(next.getSequenceNumber());
            sb2.append(",\n                    \"state\": \"");
            sb2.append(next.getState());
            sb2.append("\"\n                } \n                ");
            arrayList3.add(StringsKt__IndentKt.trimIndent(sb2.toString()));
            arrayList2.add(next.getLastObservedFrame());
            arrayList.add(next.getLastObservedThread());
        }
        Object[] objArr = new Object[4];
        objArr[0] = '[' + CollectionsKt___CollectionsKt.joinToString$default(arrayList3, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + AbstractJsonLexerKt.END_LIST;
        Object[] array = arrayList.toArray(new Thread[0]);
        if (array != null) {
            objArr[1] = array;
            Object[] array2 = arrayList2.toArray(new CoroutineStackFrame[0]);
            if (array2 != null) {
                objArr[2] = array2;
                Object[] array3 = dumpCoroutinesInfo.toArray(new DebugCoroutineInfo[0]);
                if (array3 != null) {
                    objArr[3] = array3;
                    return objArr;
                }
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @org.jetbrains.annotations.NotNull
    public final java.util.List<kotlinx.coroutines.debug.internal.DebuggerInfo> dumpDebuggerInfo() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = r3
        L_0x0013:
            r4 = r3
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0061 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0061 }
            if (r5 == 0) goto L_0x0055
            java.util.Set r4 = r4.getCapturedCoroutines()     // Catch:{ all -> 0x0061 }
            kotlin.sequences.Sequence r4 = kotlin.collections.CollectionsKt___CollectionsKt.asSequence(r4)     // Catch:{ all -> 0x0061 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpCoroutinesInfoImpl$lambda-12$$inlined$sortedBy$1     // Catch:{ all -> 0x0061 }
            r5.<init>()     // Catch:{ all -> 0x0061 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt___SequencesKt.sortedWith(r4, r5)     // Catch:{ all -> 0x0061 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1 r5 = new kotlinx.coroutines.debug.internal.DebugProbesImpl$dumpDebuggerInfo$$inlined$dumpCoroutinesInfoImpl$1     // Catch:{ all -> 0x0061 }
            r5.<init>()     // Catch:{ all -> 0x0061 }
            kotlin.sequences.Sequence r4 = kotlin.sequences.SequencesKt___SequencesKt.mapNotNull(r4, r5)     // Catch:{ all -> 0x0061 }
            java.util.List r4 = kotlin.sequences.SequencesKt___SequencesKt.toList(r4)     // Catch:{ all -> 0x0061 }
        L_0x0049:
            if (r3 >= r2) goto L_0x0051
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0049
        L_0x0051:
            r0.unlock()
            return r4
        L_0x0055:
            java.lang.String r4 = "Debug probes are not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0061 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0061 }
            r5.<init>(r4)     // Catch:{ all -> 0x0061 }
            throw r5     // Catch:{ all -> 0x0061 }
        L_0x0061:
            r4 = move-exception
        L_0x0062:
            if (r3 >= r2) goto L_0x006a
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0062
        L_0x006a:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.dumpDebuggerInfo():java.util.List");
    }

    @NotNull
    public final List<StackTraceElement> enhanceStackTraceWithThreadDump(@NotNull DebugCoroutineInfo debugCoroutineInfo, @NotNull List<StackTraceElement> list) {
        return enhanceStackTraceWithThreadDumpImpl(debugCoroutineInfo.getState(), debugCoroutineInfo.getLastObservedThread(), list);
    }

    @NotNull
    public final String enhanceStackTraceWithThreadDumpAsJson(@NotNull DebugCoroutineInfo debugCoroutineInfo) {
        String str;
        List<StackTraceElement> enhanceStackTraceWithThreadDump = enhanceStackTraceWithThreadDump(debugCoroutineInfo, debugCoroutineInfo.lastObservedStackTrace());
        ArrayList arrayList = new ArrayList();
        for (StackTraceElement next : enhanceStackTraceWithThreadDump) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("\n                {\n                    \"declaringClass\": \"");
            sb2.append(next.getClassName());
            sb2.append("\",\n                    \"methodName\": \"");
            sb2.append(next.getMethodName());
            sb2.append("\",\n                    \"fileName\": ");
            String fileName = next.getFileName();
            if (fileName != null) {
                str = toStringWithQuotes(fileName);
            } else {
                str = null;
            }
            sb2.append(str);
            sb2.append(",\n                    \"lineNumber\": ");
            sb2.append(next.getLineNumber());
            sb2.append("\n                }\n                ");
            arrayList.add(StringsKt__IndentKt.trimIndent(sb2.toString()));
        }
        return '[' + CollectionsKt___CollectionsKt.joinToString$default(arrayList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 63, (Object) null) + AbstractJsonLexerKt.END_LIST;
    }

    public final boolean getEnableCreationStackTraces() {
        return enableCreationStackTraces;
    }

    public final boolean getSanitizeStackTraces() {
        return sanitizeStackTraces;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    @org.jetbrains.annotations.NotNull
    public final java.lang.String hierarchyToString(@org.jetbrains.annotations.NotNull kotlinx.coroutines.Job r10) {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = r3
        L_0x0013:
            r4 = r3
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x00c1 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x00c1 }
            if (r5 == 0) goto L_0x00b5
            java.util.Set r4 = r4.getCapturedCoroutines()     // Catch:{ all -> 0x00c1 }
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ all -> 0x00c1 }
            r5.<init>()     // Catch:{ all -> 0x00c1 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ all -> 0x00c1 }
        L_0x0038:
            boolean r6 = r4.hasNext()     // Catch:{ all -> 0x00c1 }
            if (r6 == 0) goto L_0x005c
            java.lang.Object r6 = r4.next()     // Catch:{ all -> 0x00c1 }
            r7 = r6
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r7     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.Continuation<T> r7 = r7.delegate     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.Job$Key r8 = kotlinx.coroutines.Job.Key     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.CoroutineContext$Element r7 = r7.get(r8)     // Catch:{ all -> 0x00c1 }
            if (r7 == 0) goto L_0x0055
            r7 = 1
            goto L_0x0056
        L_0x0055:
            r7 = r3
        L_0x0056:
            if (r7 == 0) goto L_0x0038
            r5.add(r6)     // Catch:{ all -> 0x00c1 }
            goto L_0x0038
        L_0x005c:
            r4 = 10
            int r4 = kotlin.collections.CollectionsKt__IterablesKt.collectionSizeOrDefault(r5, r4)     // Catch:{ all -> 0x00c1 }
            int r4 = kotlin.collections.MapsKt__MapsJVMKt.mapCapacity(r4)     // Catch:{ all -> 0x00c1 }
            r6 = 16
            int r4 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((int) r4, (int) r6)     // Catch:{ all -> 0x00c1 }
            java.util.LinkedHashMap r6 = new java.util.LinkedHashMap     // Catch:{ all -> 0x00c1 }
            r6.<init>(r4)     // Catch:{ all -> 0x00c1 }
            java.util.Iterator r4 = r5.iterator()     // Catch:{ all -> 0x00c1 }
        L_0x0075:
            boolean r5 = r4.hasNext()     // Catch:{ all -> 0x00c1 }
            if (r5 == 0) goto L_0x0094
            java.lang.Object r5 = r4.next()     // Catch:{ all -> 0x00c1 }
            r7 = r5
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r7 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r7     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.Continuation<T> r7 = r7.delegate     // Catch:{ all -> 0x00c1 }
            kotlin.coroutines.CoroutineContext r7 = r7.getContext()     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.Job r7 = kotlinx.coroutines.JobKt.getJob(r7)     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner r5 = (kotlinx.coroutines.debug.internal.DebugProbesImpl.CoroutineOwner) r5     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl r5 = r5.info     // Catch:{ all -> 0x00c1 }
            r6.put(r7, r5)     // Catch:{ all -> 0x00c1 }
            goto L_0x0075
        L_0x0094:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x00c1 }
            r4.<init>()     // Catch:{ all -> 0x00c1 }
            kotlinx.coroutines.debug.internal.DebugProbesImpl r5 = INSTANCE     // Catch:{ all -> 0x00c1 }
            java.lang.String r7 = ""
            r5.build(r10, r6, r4, r7)     // Catch:{ all -> 0x00c1 }
            java.lang.String r10 = r4.toString()     // Catch:{ all -> 0x00c1 }
            java.lang.String r4 = "StringBuilder().apply(builderAction).toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r4)     // Catch:{ all -> 0x00c1 }
        L_0x00a9:
            if (r3 >= r2) goto L_0x00b1
            r1.lock()
            int r3 = r3 + 1
            goto L_0x00a9
        L_0x00b1:
            r0.unlock()
            return r10
        L_0x00b5:
            java.lang.String r10 = "Debug probes are not installed"
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00c1 }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x00c1 }
            r4.<init>(r10)     // Catch:{ all -> 0x00c1 }
            throw r4     // Catch:{ all -> 0x00c1 }
        L_0x00c1:
            r10 = move-exception
        L_0x00c2:
            if (r3 >= r2) goto L_0x00ca
            r1.lock()
            int r3 = r3 + 1
            goto L_0x00c2
        L_0x00ca:
            r0.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.hierarchyToString(kotlinx.coroutines.Job):java.lang.String");
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void install() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = r3
        L_0x0013:
            r4 = r3
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            int r4 = installations     // Catch:{ all -> 0x0069 }
            r5 = 1
            int r4 = r4 + r5
            installations = r4     // Catch:{ all -> 0x0069 }
            int r4 = installations     // Catch:{ all -> 0x0069 }
            if (r4 <= r5) goto L_0x0039
        L_0x002d:
            if (r3 >= r2) goto L_0x0035
            r1.lock()
            int r3 = r3 + 1
            goto L_0x002d
        L_0x0035:
            r0.unlock()
            return
        L_0x0039:
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0069 }
            r4.startWeakRefCleanerThread()     // Catch:{ all -> 0x0069 }
            kotlinx.coroutines.debug.internal.AgentInstallationType r4 = kotlinx.coroutines.debug.internal.AgentInstallationType.INSTANCE     // Catch:{ all -> 0x0069 }
            boolean r4 = r4.isInstalledStatically$kotlinx_coroutines_core()     // Catch:{ all -> 0x0069 }
            if (r4 == 0) goto L_0x0052
        L_0x0046:
            if (r3 >= r2) goto L_0x004e
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0046
        L_0x004e:
            r0.unlock()
            return
        L_0x0052:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r4 = dynamicAttach     // Catch:{ all -> 0x0069 }
            if (r4 == 0) goto L_0x005b
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x0069 }
            r4.invoke(r5)     // Catch:{ all -> 0x0069 }
        L_0x005b:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0069 }
        L_0x005d:
            if (r3 >= r2) goto L_0x0065
            r1.lock()
            int r3 = r3 + 1
            goto L_0x005d
        L_0x0065:
            r0.unlock()
            return
        L_0x0069:
            r4 = move-exception
        L_0x006a:
            if (r3 >= r2) goto L_0x0072
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006a
        L_0x0072:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.install():void");
    }

    public final boolean isInstalled$kotlinx_coroutines_core() {
        return installations > 0;
    }

    @NotNull
    public final <T> Continuation<T> probeCoroutineCreated$kotlinx_coroutines_core(@NotNull Continuation<? super T> continuation) {
        StackTraceFrame stackTraceFrame;
        if (!isInstalled$kotlinx_coroutines_core() || owner((Continuation<?>) continuation) != null) {
            return continuation;
        }
        if (enableCreationStackTraces) {
            stackTraceFrame = toStackTraceFrame(sanitizeStackTrace(new Exception()));
        } else {
            stackTraceFrame = null;
        }
        return createOwner(continuation, stackTraceFrame);
    }

    public final void probeCoroutineResumed$kotlinx_coroutines_core(@NotNull Continuation<?> continuation) {
        updateState(continuation, DebugCoroutineInfoImplKt.RUNNING);
    }

    public final void probeCoroutineSuspended$kotlinx_coroutines_core(@NotNull Continuation<?> continuation) {
        updateState(continuation, DebugCoroutineInfoImplKt.SUSPENDED);
    }

    public final void setEnableCreationStackTraces(boolean z11) {
        enableCreationStackTraces = z11;
    }

    public final void setSanitizeStackTraces(boolean z11) {
        sanitizeStackTraces = z11;
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    public final void uninstall() {
        /*
            r6 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = coroutineStateLock
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            int r2 = r0.getWriteHoldCount()
            r3 = 0
            if (r2 != 0) goto L_0x0012
            int r2 = r0.getReadHoldCount()
            goto L_0x0013
        L_0x0012:
            r2 = r3
        L_0x0013:
            r4 = r3
        L_0x0014:
            if (r4 >= r2) goto L_0x001c
            r1.unlock()
            int r4 = r4 + 1
            goto L_0x0014
        L_0x001c:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r0 = r0.writeLock()
            r0.lock()
            kotlinx.coroutines.debug.internal.DebugProbesImpl r4 = INSTANCE     // Catch:{ all -> 0x0085 }
            boolean r5 = r4.isInstalled$kotlinx_coroutines_core()     // Catch:{ all -> 0x0085 }
            if (r5 == 0) goto L_0x0079
            int r5 = installations     // Catch:{ all -> 0x0085 }
            int r5 = r5 + -1
            installations = r5     // Catch:{ all -> 0x0085 }
            int r5 = installations     // Catch:{ all -> 0x0085 }
            if (r5 == 0) goto L_0x0041
        L_0x0035:
            if (r3 >= r2) goto L_0x003d
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0035
        L_0x003d:
            r0.unlock()
            return
        L_0x0041:
            r4.stopWeakRefCleanerThread()     // Catch:{ all -> 0x0085 }
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlinx.coroutines.debug.internal.DebugProbesImpl$CoroutineOwner<?>, java.lang.Boolean> r4 = capturedCoroutinesMap     // Catch:{ all -> 0x0085 }
            r4.clear()     // Catch:{ all -> 0x0085 }
            kotlinx.coroutines.debug.internal.ConcurrentWeakMap<kotlin.coroutines.jvm.internal.CoroutineStackFrame, kotlinx.coroutines.debug.internal.DebugCoroutineInfoImpl> r4 = callerInfoCache     // Catch:{ all -> 0x0085 }
            r4.clear()     // Catch:{ all -> 0x0085 }
            kotlinx.coroutines.debug.internal.AgentInstallationType r4 = kotlinx.coroutines.debug.internal.AgentInstallationType.INSTANCE     // Catch:{ all -> 0x0085 }
            boolean r4 = r4.isInstalledStatically$kotlinx_coroutines_core()     // Catch:{ all -> 0x0085 }
            if (r4 == 0) goto L_0x0062
        L_0x0056:
            if (r3 >= r2) goto L_0x005e
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0056
        L_0x005e:
            r0.unlock()
            return
        L_0x0062:
            kotlin.jvm.functions.Function1<java.lang.Boolean, kotlin.Unit> r4 = dynamicAttach     // Catch:{ all -> 0x0085 }
            if (r4 == 0) goto L_0x006b
            java.lang.Boolean r5 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0085 }
            r4.invoke(r5)     // Catch:{ all -> 0x0085 }
        L_0x006b:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0085 }
        L_0x006d:
            if (r3 >= r2) goto L_0x0075
            r1.lock()
            int r3 = r3 + 1
            goto L_0x006d
        L_0x0075:
            r0.unlock()
            return
        L_0x0079:
            java.lang.String r4 = "Agent was not installed"
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0085 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0085 }
            r5.<init>(r4)     // Catch:{ all -> 0x0085 }
            throw r5     // Catch:{ all -> 0x0085 }
        L_0x0085:
            r4 = move-exception
        L_0x0086:
            if (r3 >= r2) goto L_0x008e
            r1.lock()
            int r3 = r3 + 1
            goto L_0x0086
        L_0x008e:
            r0.unlock()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.debug.internal.DebugProbesImpl.uninstall():void");
    }

    private final CoroutineOwner<?> owner(CoroutineStackFrame coroutineStackFrame) {
        while (!(coroutineStackFrame instanceof CoroutineOwner)) {
            coroutineStackFrame = coroutineStackFrame.getCallerFrame();
            if (coroutineStackFrame == null) {
                return null;
            }
        }
        return (CoroutineOwner) coroutineStackFrame;
    }

    private final void updateState(CoroutineOwner<?> coroutineOwner, Continuation<?> continuation, String str) {
        ReentrantReadWriteLock.ReadLock readLock = coroutineStateLock.readLock();
        readLock.lock();
        try {
            if (INSTANCE.isInstalled$kotlinx_coroutines_core()) {
                coroutineOwner.info.updateState$kotlinx_coroutines_core(str, continuation);
                Unit unit = Unit.INSTANCE;
                readLock.unlock();
            }
        } finally {
            readLock.unlock();
        }
    }
}
