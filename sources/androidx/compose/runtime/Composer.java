package androidx.compose.runtime;

import androidx.compose.runtime.tooling.CompositionData;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Â\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\f\n\u0002\u0010\u0006\n\u0002\u0010\u0007\n\u0002\u0010\t\n\u0002\u0010\n\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\bv\u0018\u0000 x2\u00020\u0001:\u0001xJ@\u0010.\u001a\u00020/\"\u0004\b\u0000\u00100\"\u0004\b\u0001\u001012\u0006\u00102\u001a\u0002H02\u001d\u00103\u001a\u0019\u0012\u0004\u0012\u0002H1\u0012\u0004\u0012\u0002H0\u0012\u0004\u0012\u00020/04¢\u0006\u0002\b5H'¢\u0006\u0002\u00106J\b\u00107\u001a\u000208H'J\u0012\u00109\u001a\u00020\u001b2\b\u00102\u001a\u0004\u0018\u00010\u0001H'J\u0010\u00109\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u001bH\u0017J\u0010\u00109\u001a\u00020\u001b2\u0006\u00102\u001a\u00020:H\u0017J\u0010\u00109\u001a\u00020\u001b2\u0006\u00102\u001a\u00020;H\u0017J\u0010\u00109\u001a\u00020\u001b2\u0006\u00102\u001a\u00020<H\u0017J\u0010\u00109\u001a\u00020\u001b2\u0006\u00102\u001a\u00020=H\u0017J\u0010\u00109\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u0016H\u0017J\u0010\u00109\u001a\u00020\u001b2\u0006\u00102\u001a\u00020>H\u0017J\u0010\u00109\u001a\u00020\u001b2\u0006\u00102\u001a\u00020?H\u0017J\b\u0010@\u001a\u00020/H&J!\u0010A\u001a\u0002H1\"\u0004\b\u0000\u001012\f\u0010B\u001a\b\u0012\u0004\u0012\u0002H10CH'¢\u0006\u0002\u0010DJ\u001c\u0010E\u001a\u00020/\"\u0004\b\u0000\u001012\f\u0010F\u001a\b\u0012\u0004\u0012\u0002H10GH'J\u0010\u0010H\u001a\u00020/2\u0006\u00109\u001a\u00020\u001bH'J\b\u0010I\u001a\u00020/H'J\b\u0010J\u001a\u00020/H'J\b\u0010K\u001a\u00020/H'J\b\u0010L\u001a\u00020/H'J\b\u0010M\u001a\u00020/H'J\b\u0010N\u001a\u00020/H'J\b\u0010O\u001a\u00020/H'J\n\u0010P\u001a\u0004\u0018\u00010QH'J\b\u0010R\u001a\u00020/H'J\u001e\u0010S\u001a\u00020/2\n\u00102\u001a\u0006\u0012\u0002\b\u00030T2\b\u0010U\u001a\u0004\u0018\u00010\u0001H'J$\u0010V\u001a\u00020/2\u001a\u0010W\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020Z\u0012\u0006\u0012\u0004\u0018\u00010Z0Y0XH'J\u001c\u0010[\u001a\u00020\u00012\b\u0010\\\u001a\u0004\u0018\u00010\u00012\b\u0010]\u001a\u0004\u0018\u00010\u0001H'J\u0016\u0010^\u001a\u00020/2\f\u0010_\u001a\b\u0012\u0004\u0012\u00020/0GH'J\u0010\u0010`\u001a\u00020/2\u0006\u0010a\u001a\u00020#H'J\n\u0010b\u001a\u0004\u0018\u00010\u0001H'J\b\u0010c\u001a\u00020/H'J\b\u0010d\u001a\u00020/H'J\u0010\u0010e\u001a\u00020/2\u0006\u0010e\u001a\u00020fH&J\b\u0010g\u001a\u00020/H&J\u0018\u0010h\u001a\u00020/2\u0006\u0010B\u001a\u00020\u00162\u0006\u0010e\u001a\u00020fH&J\b\u0010i\u001a\u00020/H'J\u001a\u0010j\u001a\u00020/2\u0006\u0010B\u001a\u00020\u00162\b\u0010k\u001a\u0004\u0018\u00010\u0001H'J\b\u0010l\u001a\u00020/H'J!\u0010m\u001a\u00020/2\u0012\u0010n\u001a\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030p0oH'¢\u0006\u0002\u0010qJ\u0010\u0010r\u001a\u00020/2\u0006\u0010B\u001a\u00020\u0016H'J\u0010\u0010s\u001a\u00020\u00002\u0006\u0010B\u001a\u00020\u0016H'J\u001a\u0010t\u001a\u00020/2\u0006\u0010B\u001a\u00020\u00162\b\u0010k\u001a\u0004\u0018\u00010\u0001H'J\b\u0010u\u001a\u00020/H'J\u0012\u0010v\u001a\u00020/2\b\u00102\u001a\u0004\u0018\u00010\u0001H'J\b\u0010w\u001a\u00020/H'R\u001e\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\t8fX§\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0005\u001a\u0004\b\u000b\u0010\fR\u0014\u0010\r\u001a\u00020\u000e8fX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u0012\u0010\u0011\u001a\u00020\u0012X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u00168&X§\u0004¢\u0006\f\u0012\u0004\b\u0017\u0010\u0005\u001a\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b\u001c\u0010\u0005\u001a\u0004\b\u001d\u0010\u001eR\u001a\u0010\u001f\u001a\u00020\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b \u0010\u0005\u001a\u0004\b!\u0010\u001eR\u001c\u0010\"\u001a\u0004\u0018\u00010#8&X§\u0004¢\u0006\f\u0012\u0004\b$\u0010\u0005\u001a\u0004\b%\u0010&R\u001c\u0010'\u001a\u0004\u0018\u00010\u00018&X§\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0005\u001a\u0004\b)\u0010*R\u001a\u0010+\u001a\u00020\u001b8&X§\u0004¢\u0006\f\u0012\u0004\b,\u0010\u0005\u001a\u0004\b-\u0010\u001e\u0001\u0001yø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006zÀ\u0006\u0001"}, d2 = {"Landroidx/compose/runtime/Composer;", "", "applier", "Landroidx/compose/runtime/Applier;", "getApplier$annotations", "()V", "getApplier", "()Landroidx/compose/runtime/Applier;", "applyCoroutineContext", "Lkotlin/coroutines/CoroutineContext;", "getApplyCoroutineContext$annotations", "getApplyCoroutineContext", "()Lkotlin/coroutines/CoroutineContext;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "getComposition", "()Landroidx/compose/runtime/ControlledComposition;", "compositionData", "Landroidx/compose/runtime/tooling/CompositionData;", "getCompositionData", "()Landroidx/compose/runtime/tooling/CompositionData;", "compoundKeyHash", "", "getCompoundKeyHash$annotations", "getCompoundKeyHash", "()I", "defaultsInvalid", "", "getDefaultsInvalid$annotations", "getDefaultsInvalid", "()Z", "inserting", "getInserting$annotations", "getInserting", "recomposeScope", "Landroidx/compose/runtime/RecomposeScope;", "getRecomposeScope$annotations", "getRecomposeScope", "()Landroidx/compose/runtime/RecomposeScope;", "recomposeScopeIdentity", "getRecomposeScopeIdentity$annotations", "getRecomposeScopeIdentity", "()Ljava/lang/Object;", "skipping", "getSkipping$annotations", "getSkipping", "apply", "", "V", "T", "value", "block", "Lkotlin/Function2;", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "buildContext", "Landroidx/compose/runtime/CompositionContext;", "changed", "", "", "", "", "", "", "collectParameterInformation", "consume", "key", "Landroidx/compose/runtime/CompositionLocal;", "(Landroidx/compose/runtime/CompositionLocal;)Ljava/lang/Object;", "createNode", "factory", "Lkotlin/Function0;", "deactivateToEndGroup", "disableReusing", "enableReusing", "endDefaults", "endMovableGroup", "endNode", "endProviders", "endReplaceableGroup", "endRestartGroup", "Landroidx/compose/runtime/ScopeUpdateScope;", "endReusableGroup", "insertMovableContent", "Landroidx/compose/runtime/MovableContent;", "parameter", "insertMovableContentReferences", "references", "", "Lkotlin/Pair;", "Landroidx/compose/runtime/MovableContentStateReference;", "joinKey", "left", "right", "recordSideEffect", "effect", "recordUsed", "scope", "rememberedValue", "skipCurrentGroup", "skipToGroupEnd", "sourceInformation", "", "sourceInformationMarkerEnd", "sourceInformationMarkerStart", "startDefaults", "startMovableGroup", "dataKey", "startNode", "startProviders", "values", "", "Landroidx/compose/runtime/ProvidedValue;", "([Landroidx/compose/runtime/ProvidedValue;)V", "startReplaceableGroup", "startRestartGroup", "startReusableGroup", "startReusableNode", "updateRememberedValue", "useNode", "Companion", "Landroidx/compose/runtime/ComposerImpl;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface Composer {
    @NotNull
    public static final Companion Companion = Companion.f9036a;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0007R\u0011\u0010\u0003\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n"}, d2 = {"Landroidx/compose/runtime/Composer$Companion;", "", "()V", "Empty", "getEmpty", "()Ljava/lang/Object;", "setTracer", "", "tracer", "Landroidx/compose/runtime/CompositionTracer;", "runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        @NotNull
        private static final Object Empty = new Composer$Companion$Empty$1();

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ Companion f9036a = new Companion();

        private Companion() {
        }

        @NotNull
        public final Object getEmpty() {
            return Empty;
        }

        @InternalComposeTracingApi
        public final void setTracer(@NotNull CompositionTracer compositionTracer) {
            Intrinsics.checkNotNullParameter(compositionTracer, "tracer");
            ComposerKt.compositionTracer = compositionTracer;
        }
    }

    @ComposeCompilerApi
    <V, T> void apply(V v11, @NotNull Function2<? super T, ? super V, Unit> function2);

    @InternalComposeApi
    @NotNull
    CompositionContext buildContext();

    @ComposeCompilerApi
    boolean changed(byte b11);

    @ComposeCompilerApi
    boolean changed(char c11);

    @ComposeCompilerApi
    boolean changed(double d11);

    @ComposeCompilerApi
    boolean changed(float f11);

    @ComposeCompilerApi
    boolean changed(int i11);

    @ComposeCompilerApi
    boolean changed(long j11);

    @ComposeCompilerApi
    boolean changed(@Nullable Object obj);

    @ComposeCompilerApi
    boolean changed(short s11);

    @ComposeCompilerApi
    boolean changed(boolean z11);

    void collectParameterInformation();

    @InternalComposeApi
    <T> T consume(@NotNull CompositionLocal<T> compositionLocal);

    @ComposeCompilerApi
    <T> void createNode(@NotNull Function0<? extends T> function0);

    @ComposeCompilerApi
    void deactivateToEndGroup(boolean z11);

    @ComposeCompilerApi
    void disableReusing();

    @ComposeCompilerApi
    void enableReusing();

    @ComposeCompilerApi
    void endDefaults();

    @ComposeCompilerApi
    void endMovableGroup();

    @ComposeCompilerApi
    void endNode();

    @InternalComposeApi
    void endProviders();

    @ComposeCompilerApi
    void endReplaceableGroup();

    @Nullable
    @ComposeCompilerApi
    ScopeUpdateScope endRestartGroup();

    @ComposeCompilerApi
    void endReusableGroup();

    @NotNull
    Applier<?> getApplier();

    @NotNull
    CoroutineContext getApplyCoroutineContext();

    @NotNull
    ControlledComposition getComposition();

    @NotNull
    CompositionData getCompositionData();

    int getCompoundKeyHash();

    boolean getDefaultsInvalid();

    boolean getInserting();

    @Nullable
    RecomposeScope getRecomposeScope();

    @Nullable
    Object getRecomposeScopeIdentity();

    boolean getSkipping();

    @InternalComposeApi
    void insertMovableContent(@NotNull MovableContent<?> movableContent, @Nullable Object obj);

    @InternalComposeApi
    void insertMovableContentReferences(@NotNull List<Pair<MovableContentStateReference, MovableContentStateReference>> list);

    @NotNull
    @ComposeCompilerApi
    Object joinKey(@Nullable Object obj, @Nullable Object obj2);

    @InternalComposeApi
    void recordSideEffect(@NotNull Function0<Unit> function0);

    @InternalComposeApi
    void recordUsed(@NotNull RecomposeScope recomposeScope);

    @Nullable
    @ComposeCompilerApi
    Object rememberedValue();

    @ComposeCompilerApi
    void skipCurrentGroup();

    @ComposeCompilerApi
    void skipToGroupEnd();

    void sourceInformation(@NotNull String str);

    void sourceInformationMarkerEnd();

    void sourceInformationMarkerStart(int i11, @NotNull String str);

    @ComposeCompilerApi
    void startDefaults();

    @ComposeCompilerApi
    void startMovableGroup(int i11, @Nullable Object obj);

    @ComposeCompilerApi
    void startNode();

    @InternalComposeApi
    void startProviders(@NotNull ProvidedValue<?>[] providedValueArr);

    @ComposeCompilerApi
    void startReplaceableGroup(int i11);

    @NotNull
    @ComposeCompilerApi
    Composer startRestartGroup(int i11);

    @ComposeCompilerApi
    void startReusableGroup(int i11, @Nullable Object obj);

    @ComposeCompilerApi
    void startReusableNode();

    @ComposeCompilerApi
    void updateRememberedValue(@Nullable Object obj);

    @ComposeCompilerApi
    void useNode();
}
