package androidx.compose.ui.tooling;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.activity.compose.LocalActivityResultRegistryOwner;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.annotation.VisibleForTesting;
import androidx.compose.animation.core.Transition;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.CompositionData;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.tooling.animation.PreviewAnimationClock;
import androidx.compose.ui.tooling.data.Group;
import androidx.compose.ui.tooling.data.SlotTreeKt;
import androidx.compose.ui.tooling.data.SourceLocation;
import androidx.compose.ui.tooling.preview.PreviewParameterProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.lifecycle.ViewTreeViewModelStoreOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.huawei.wisesecurity.kfs.constant.KfsConstant;
import com.instabug.library.internal.storage.cache.UserAttributesCacheManager;
import com.newrelic.agent.android.agentdata.HexAttribute;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000É\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0007*\u0003\u000b\u000e\u0011\b\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ \u0010M\u001a\u00020'2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020'0&¢\u0006\u0002\b(H\u0003¢\u0006\u0002\u0010NJ\u0012\u0010O\u001a\u00020'2\b\u0010P\u001a\u0004\u0018\u00010QH\u0014J\r\u0010R\u001a\u00020'H\u0000¢\u0006\u0002\bSJ\b\u0010T\u001a\u00020'H\u0002J\b\u0010U\u001a\u00020'H\u0002J4\u0010V\u001a\b\u0012\u0004\u0012\u00020G042\u0006\u0010W\u001a\u00020G2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020-0Y2\b\b\u0002\u0010Z\u001a\u00020-H\u0002J\u0006\u0010;\u001a\u00020-J\u0010\u0010[\u001a\u00020'2\u0006\u0010\u0004\u001a\u00020\u0005H\u0002J\u0001\u0010[\u001a\u00020'2\u0006\u0010\\\u001a\u00020\u00162\u0006\u0010]\u001a\u00020\u00162\u0016\b\u0002\u0010^\u001a\u0010\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030`\u0018\u00010_2\b\b\u0002\u0010a\u001a\u00020\b2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020-2\b\b\u0002\u0010b\u001a\u00020c2\b\b\u0002\u0010:\u001a\u00020-2\b\b\u0002\u0010<\u001a\u00020-2\n\b\u0002\u00109\u001a\u0004\u0018\u00010\u00162\u000e\b\u0002\u0010d\u001a\b\u0012\u0004\u0012\u00020'0&2\u000e\b\u0002\u0010=\u001a\b\u0012\u0004\u0012\u00020'0&H\u0001¢\u0006\u0002\beJ\b\u0010f\u001a\u00020'H\u0002J\b\u0010g\u001a\u00020'H\u0014J0\u0010h\u001a\u00020'2\u0006\u0010i\u001a\u00020-2\u0006\u0010j\u001a\u00020\b2\u0006\u0010k\u001a\u00020\b2\u0006\u0010l\u001a\u00020\b2\u0006\u0010m\u001a\u00020\bH\u0014J\b\u0010n\u001a\u00020'H\u0002J\u001a\u0010o\u001a\u00020'2\u0006\u0010p\u001a\u00020C2\b\b\u0002\u0010q\u001a\u00020\bH\u0002J&\u0010r\u001a\b\u0012\u0004\u0012\u00020G04*\u00020G2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020-0YH\u0002J\"\u0010s\u001a\u0004\u0018\u00010G*\u00020G2\u0012\u0010X\u001a\u000e\u0012\u0004\u0012\u00020G\u0012\u0004\u0012\u00020-0YH\u0002J\u000e\u0010t\u001a\u0004\u0018\u00010u*\u000200H\u0002J\f\u0010v\u001a\u00020-*\u00020GH\u0002J\u001e\u0010w\u001a\u0004\u0018\u00010\u0016*\u0002002\u0006\u0010x\u001a\u00020\b2\u0006\u0010y\u001a\u00020\bH\u0002J\f\u0010z\u001a\u00020-*\u00020GH\u0002J\f\u0010{\u001a\u00020C*\u00020GH\u0002R\u0010\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0012\u0010\u0010\u001a\u00020\u00118\u0002X\u0004¢\u0006\u0004\n\u0002\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016XD¢\u0006\u0002\n\u0000R$\u0010\u0017\u001a\u00020\u00188\u0000@\u0000X.¢\u0006\u0014\n\u0000\u0012\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u0002\n\u0000R%\u0010$\u001a\u0013\u0012\u000f\u0012\r\u0012\u0004\u0012\u00020'0&¢\u0006\u0002\b(0%X\u0004¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u001aR\u000e\u0010*\u001a\u00020+X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u000200X\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u0004\u0018\u000102X\u000e¢\u0006\u0002\n\u0000R \u00103\u001a\b\u0012\u0004\u0012\u00020\u001604X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u000e\u00109\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020-X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010=\u001a\b\u0012\u0004\u0012\u00020'0&X\u000e¢\u0006\u0002\n\u0000R\u001b\u0010>\u001a\r\u0012\u0004\u0012\u00020'0&¢\u0006\u0002\b(X\u000e¢\u0006\u0004\n\u0002\u0010?R\u000e\u0010@\u001a\u00020AX\u0004¢\u0006\u0002\n\u0000R \u0010B\u001a\b\u0012\u0004\u0012\u00020C04X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bD\u00106\"\u0004\bE\u00108R\u0018\u0010F\u001a\u00020\u0016*\u00020G8BX\u0004¢\u0006\u0006\u001a\u0004\bH\u0010IR\u0018\u0010J\u001a\u00020\b*\u00020G8BX\u0004¢\u0006\u0006\u001a\u0004\bK\u0010L¨\u0006|"}, d2 = {"Landroidx/compose/ui/tooling/ComposeViewAdapter;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "FakeActivityResultRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeActivityResultRegistryOwner$1;", "FakeOnBackPressedDispatcherOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1;", "FakeSavedStateRegistryOwner", "androidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1", "Landroidx/compose/ui/tooling/ComposeViewAdapter$FakeSavedStateRegistryOwner$1;", "FakeViewModelStoreOwner", "Landroidx/lifecycle/ViewModelStoreOwner;", "TAG", "", "clock", "Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "getClock$ui_tooling_release$annotations", "()V", "getClock$ui_tooling_release", "()Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;", "setClock$ui_tooling_release", "(Landroidx/compose/ui/tooling/animation/PreviewAnimationClock;)V", "composableName", "composeView", "Landroidx/compose/ui/platform/ComposeView;", "composition", "Landroidx/compose/runtime/Composition;", "content", "Landroidx/compose/runtime/MutableState;", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "getContent$annotations", "debugBoundsPaint", "Landroid/graphics/Paint;", "debugPaintBounds", "", "debugViewInfos", "delayExceptionLock", "", "delayedException", "", "designInfoList", "", "getDesignInfoList$ui_tooling_release", "()Ljava/util/List;", "setDesignInfoList$ui_tooling_release", "(Ljava/util/List;)V", "designInfoProvidersArgument", "forceCompositionInvalidation", "hasAnimations", "lookForDesignInfoProviders", "onDraw", "previewComposition", "Lkotlin/jvm/functions/Function2;", "slotTableRecord", "Landroidx/compose/ui/tooling/CompositionDataRecord;", "viewInfos", "Landroidx/compose/ui/tooling/ViewInfo;", "getViewInfos$ui_tooling_release", "setViewInfos$ui_tooling_release", "fileName", "Landroidx/compose/ui/tooling/data/Group;", "getFileName", "(Landroidx/compose/ui/tooling/data/Group;)Ljava/lang/String;", "lineNumber", "getLineNumber", "(Landroidx/compose/ui/tooling/data/Group;)I", "WrapPreview", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispose", "dispose$ui_tooling_release", "findAndTrackTransitions", "findDesignInfoProviders", "findGroupsThatMatchPredicate", "root", "predicate", "Lkotlin/Function1;", "findOnlyFirst", "init", "className", "methodName", "parameterProvider", "Ljava/lang/Class;", "Landroidx/compose/ui/tooling/preview/PreviewParameterProvider;", "parameterProviderIndex", "animationClockStartTime", "", "onCommit", "init$ui_tooling_release", "invalidateComposition", "onAttachedToWindow", "onLayout", "changed", "left", "top", "right", "bottom", "processViewInfos", "walkTable", "viewInfo", "indent", "findAll", "firstOrNull", "getDesignInfoMethodOrNull", "Ljava/lang/reflect/Method;", "hasNullSourcePosition", "invokeGetDesignInfo", "x", "y", "isNullGroup", "toViewInfo", "ui-tooling_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class ComposeViewAdapter extends FrameLayout {
    @NotNull
    private final ComposeViewAdapter$FakeActivityResultRegistryOwner$1 FakeActivityResultRegistryOwner;
    @NotNull
    private final ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1 FakeOnBackPressedDispatcherOwner;
    /* access modifiers changed from: private */
    @NotNull
    @SuppressLint({"VisibleForTests"})
    public final ComposeViewAdapter$FakeSavedStateRegistryOwner$1 FakeSavedStateRegistryOwner;
    @NotNull
    private final ViewModelStoreOwner FakeViewModelStoreOwner;
    @NotNull
    private final String TAG = "ComposeViewAdapter";
    public PreviewAnimationClock clock;
    @NotNull
    private String composableName;
    @NotNull
    private final ComposeView composeView;
    @Nullable
    private Composition composition;
    @NotNull
    private final MutableState<Function2<Composer, Integer, Unit>> content;
    @NotNull
    private final Paint debugBoundsPaint;
    private boolean debugPaintBounds;
    private boolean debugViewInfos;
    /* access modifiers changed from: private */
    @NotNull
    public final Object delayExceptionLock;
    /* access modifiers changed from: private */
    @Nullable
    public Throwable delayedException;
    @NotNull
    private List<String> designInfoList;
    @NotNull
    private String designInfoProvidersArgument;
    private boolean forceCompositionInvalidation;
    private boolean hasAnimations;
    private boolean lookForDesignInfoProviders;
    @NotNull
    private Function0<Unit> onDraw;
    @NotNull
    private Function2<? super Composer, ? super Integer, Unit> previewComposition;
    /* access modifiers changed from: private */
    @NotNull
    public final CompositionDataRecord slotTableRecord;
    @NotNull
    private List<ViewInfo> viewInfos;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter(@NotNull Context context, @NotNull AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.viewInfos = CollectionsKt__CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt__CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.Companion.create();
        this.composableName = "";
        this.delayExceptionLock = new Object();
        this.previewComposition = ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m5406getLambda2$ui_tooling_release();
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposeViewAdapterKt.emptyContent, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.designInfoProvidersArgument = "";
        this.onDraw = ComposeViewAdapter$onDraw$1.INSTANCE;
        Paint paint = new Paint();
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ColorKt.m2974toArgb8_81llA(Color.Companion.m2953getRed0d7_KjU()));
        Unit unit = Unit.INSTANCE;
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = ComposeViewAdapter$FakeViewModelStoreOwner$1.INSTANCE;
        this.FakeOnBackPressedDispatcherOwner = new ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1(this);
        this.FakeActivityResultRegistryOwner = new ComposeViewAdapter$FakeActivityResultRegistryOwner$1();
        init(attributeSet);
    }

    /* access modifiers changed from: private */
    @Composable
    public final void WrapPreview(Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i11) {
        Composer startRestartGroup = composer.startRestartGroup(-2044544005);
        ProvidableCompositionLocal<Font.ResourceLoader> localFontLoader = CompositionLocalsKt.getLocalFontLoader();
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{localFontLoader.provides(new LayoutlibFontResourceLoader(context)), LocalOnBackPressedDispatcherOwner.INSTANCE.provides(this.FakeOnBackPressedDispatcherOwner), LocalActivityResultRegistryOwner.INSTANCE.provides(this.FakeActivityResultRegistryOwner)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(startRestartGroup, -819909905, true, new ComposeViewAdapter$WrapPreview$1(this, function2, i11)), startRestartGroup, 56);
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup != null) {
            endRestartGroup.updateScope(new ComposeViewAdapter$WrapPreview$2(this, function2, i11));
        }
    }

    public static /* synthetic */ List a(ComposeViewAdapter composeViewAdapter, Group group, Function1 function1, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            z11 = false;
        }
        return composeViewAdapter.findGroupsThatMatchPredicate(group, function1, z11);
    }

    public static /* synthetic */ void b(ComposeViewAdapter composeViewAdapter, ViewInfo viewInfo, int i11, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            i11 = 0;
        }
        composeViewAdapter.walkTable(viewInfo, i11);
    }

    private final List<Group> findAll(Group group, Function1<? super Group, Boolean> function1) {
        return a(this, group, function1, false, 4, (Object) null);
    }

    private final void findAndTrackTransitions() {
        Object obj;
        Set<CompositionData> store = this.slotTableRecord.getStore();
        ArrayList<Group> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(store, 10));
        for (CompositionData asTree : store) {
            arrayList.add(SlotTreeKt.asTree(asTree));
        }
        LinkedHashSet<Transition> linkedHashSet = new LinkedHashSet<>();
        for (Group group : arrayList) {
            linkedHashSet.addAll(findAndTrackTransitions$findTransitionObjects(findAll(group, ComposeViewAdapter$findAndTrackTransitions$1$1.INSTANCE), this));
            ArrayList arrayList2 = new ArrayList();
            for (Group children : findAll(group, ComposeViewAdapter$findAndTrackTransitions$1$animatedVisibilityParentTransitions$1.INSTANCE)) {
                Iterator it = children.getChildren().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it.next();
                    if (Intrinsics.areEqual((Object) ((Group) obj).getName(), (Object) "updateTransition")) {
                        break;
                    }
                }
                Group group2 = (Group) obj;
                if (group2 != null) {
                    arrayList2.add(group2);
                }
            }
            linkedHashSet.removeAll(findAndTrackTransitions$findTransitionObjects(arrayList2, this));
        }
        this.hasAnimations = !linkedHashSet.isEmpty();
        if (this.clock != null) {
            for (Transition trackTransition : linkedHashSet) {
                getClock$ui_tooling_release().trackTransition(trackTransition);
            }
        }
    }

    private static final List<Transition<Object>> findAndTrackTransitions$findTransitionObjects(List<? extends Group> list, ComposeViewAdapter composeViewAdapter) {
        Transition transition;
        Object obj;
        ArrayList<Group> arrayList = new ArrayList<>();
        for (Group firstOrNull : list) {
            Group firstOrNull2 = composeViewAdapter.firstOrNull(firstOrNull, ComposeViewAdapter$findAndTrackTransitions$findTransitionObjects$rememberCalls$1$1.INSTANCE);
            if (firstOrNull2 != null) {
                arrayList.add(firstOrNull2);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Group data : arrayList) {
            Iterator it = data.getData().iterator();
            while (true) {
                transition = null;
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (obj instanceof Transition) {
                    break;
                }
            }
            if (obj instanceof Transition) {
                transition = (Transition) obj;
            }
            if (transition != null) {
                arrayList2.add(transition);
            }
        }
        return arrayList2;
    }

    private final void findDesignInfoProviders() {
        String str;
        Method method;
        Set<CompositionData> store = this.slotTableRecord.getStore();
        ArrayList<Group> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(store, 10));
        for (CompositionData asTree : store) {
            arrayList.add(SlotTreeKt.asTree(asTree));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Group findAll : arrayList) {
            ArrayList arrayList3 = new ArrayList();
            for (Group group : findAll(findAll, new ComposeViewAdapter$findDesignInfoProviders$1$1(this))) {
                Iterator it = group.getChildren().iterator();
                while (true) {
                    str = null;
                    if (!it.hasNext()) {
                        break;
                    }
                    Iterator it2 = ((Group) it.next()).getData().iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            Object next = it2.next();
                            if (next == null) {
                                method = null;
                                continue;
                            } else {
                                method = getDesignInfoMethodOrNull(next);
                                continue;
                            }
                            if (method != null) {
                                str = invokeGetDesignInfo(next, group.getBox().getLeft(), group.getBox().getTop());
                                break;
                            }
                        }
                    }
                }
                if (str != null) {
                    arrayList3.add(str);
                }
            }
            boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList2, arrayList3);
        }
        this.designInfoList = arrayList2;
    }

    private final List<Group> findGroupsThatMatchPredicate(Group group, Function1<? super Group, Boolean> function1, boolean z11) {
        ArrayList arrayList = new ArrayList();
        List mutableListOf = CollectionsKt__CollectionsKt.mutableListOf(group);
        while (!mutableListOf.isEmpty()) {
            Group group2 = (Group) CollectionsKt__MutableCollectionsKt.removeLast(mutableListOf);
            if (function1.invoke(group2).booleanValue()) {
                if (z11) {
                    return CollectionsKt__CollectionsJVMKt.listOf(group2);
                }
                arrayList.add(group2);
            }
            mutableListOf.addAll(group2.getChildren());
        }
        return arrayList;
    }

    private final Group firstOrNull(Group group, Function1<? super Group, Boolean> function1) {
        return (Group) CollectionsKt___CollectionsKt.firstOrNull(findGroupsThatMatchPredicate(group, function1, true));
    }

    @VisibleForTesting
    public static /* synthetic */ void getClock$ui_tooling_release$annotations() {
    }

    private static /* synthetic */ void getContent$annotations() {
    }

    /* access modifiers changed from: private */
    public final Method getDesignInfoMethodOrNull(Object obj) {
        try {
            Class<?> cls = obj.getClass();
            Class cls2 = Integer.TYPE;
            return cls.getDeclaredMethod("getDesignInfo", new Class[]{cls2, cls2, String.class});
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r2 = r2.getSourceFile();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getFileName(androidx.compose.ui.tooling.data.Group r2) {
        /*
            r1 = this;
            androidx.compose.ui.tooling.data.SourceLocation r2 = r2.getLocation()
            java.lang.String r0 = ""
            if (r2 != 0) goto L_0x0009
            goto L_0x0011
        L_0x0009:
            java.lang.String r2 = r2.getSourceFile()
            if (r2 != 0) goto L_0x0010
            goto L_0x0011
        L_0x0010:
            r0 = r2
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.tooling.ComposeViewAdapter.getFileName(androidx.compose.ui.tooling.data.Group):java.lang.String");
    }

    private final int getLineNumber(Group group) {
        SourceLocation location = group.getLocation();
        if (location == null) {
            return -1;
        }
        return location.getLineNumber();
    }

    private final boolean hasNullSourcePosition(Group group) {
        return (getFileName(group).length() == 0) && getLineNumber(group) == -1;
    }

    private final void init(AttributeSet attributeSet) {
        long j11;
        AttributeSet attributeSet2 = attributeSet;
        ViewTreeLifecycleOwner.set(this, this.FakeSavedStateRegistryOwner);
        ViewTreeSavedStateRegistryOwner.set(this, this.FakeSavedStateRegistryOwner);
        ViewTreeViewModelStoreOwner.set(this, this.FakeViewModelStoreOwner);
        addView(this.composeView);
        String attributeValue = attributeSet2.getAttributeValue("http://schemas.android.com/tools", "composableName");
        if (attributeValue != null) {
            Class<? extends PreviewParameterProvider<?>> cls = null;
            String substringBeforeLast$default = StringsKt__StringsKt.substringBeforeLast$default(attributeValue, '.', (String) null, 2, (Object) null);
            String substringAfterLast$default = StringsKt__StringsKt.substringAfterLast$default(attributeValue, '.', (String) null, 2, (Object) null);
            int attributeIntValue = attributeSet2.getAttributeIntValue("http://schemas.android.com/tools", "parameterProviderIndex", 0);
            String attributeValue2 = attributeSet2.getAttributeValue("http://schemas.android.com/tools", "parameterProviderClass");
            if (attributeValue2 != null) {
                cls = PreviewUtilsKt.asPreviewProviderClass(attributeValue2);
            }
            try {
                String attributeValue3 = attributeSet2.getAttributeValue("http://schemas.android.com/tools", "animationClockStartTime");
                Intrinsics.checkNotNullExpressionValue(attributeValue3, "attrs.getAttributeValue(…animationClockStartTime\")");
                j11 = Long.parseLong(attributeValue3);
            } catch (Exception unused) {
                j11 = -1;
            }
            boolean attributeBooleanValue = attributeSet2.getAttributeBooleanValue("http://schemas.android.com/tools", "forceCompositionInvalidation", false);
            init$ui_tooling_release$default(this, substringBeforeLast$default, substringAfterLast$default, cls, attributeIntValue, attributeSet2.getAttributeBooleanValue("http://schemas.android.com/tools", "paintBounds", this.debugPaintBounds), attributeSet2.getAttributeBooleanValue("http://schemas.android.com/tools", "printViewInfos", this.debugViewInfos), j11, attributeBooleanValue, attributeSet2.getAttributeBooleanValue("http://schemas.android.com/tools", "findDesignInfoProviders", this.lookForDesignInfoProviders), attributeSet2.getAttributeValue("http://schemas.android.com/tools", "designInfoProvidersArgument"), (Function0) null, (Function0) null, KfsConstant.KFS_RSA_KEY_LEN_3072, (Object) null);
        }
    }

    public static /* synthetic */ void init$ui_tooling_release$default(ComposeViewAdapter composeViewAdapter, String str, String str2, Class cls, int i11, boolean z11, boolean z12, long j11, boolean z13, boolean z14, String str3, Function0 function0, Function0 function02, int i12, Object obj) {
        Class cls2;
        int i13;
        boolean z15;
        boolean z16;
        long j12;
        boolean z17;
        boolean z18;
        String str4;
        ComposeViewAdapter$init$1 composeViewAdapter$init$1;
        ComposeViewAdapter$init$2 composeViewAdapter$init$2;
        int i14 = i12;
        if ((i14 & 4) != 0) {
            cls2 = null;
        } else {
            cls2 = cls;
        }
        if ((i14 & 8) != 0) {
            i13 = 0;
        } else {
            i13 = i11;
        }
        if ((i14 & 16) != 0) {
            z15 = false;
        } else {
            z15 = z11;
        }
        if ((i14 & 32) != 0) {
            z16 = false;
        } else {
            z16 = z12;
        }
        if ((i14 & 64) != 0) {
            j12 = -1;
        } else {
            j12 = j11;
        }
        if ((i14 & 128) != 0) {
            z17 = false;
        } else {
            z17 = z13;
        }
        if ((i14 & 256) != 0) {
            z18 = false;
        } else {
            z18 = z14;
        }
        if ((i14 & 512) != 0) {
            str4 = null;
        } else {
            str4 = str3;
        }
        if ((i14 & 1024) != 0) {
            composeViewAdapter$init$1 = ComposeViewAdapter$init$1.INSTANCE;
        } else {
            composeViewAdapter$init$1 = function0;
        }
        if ((i14 & 2048) != 0) {
            composeViewAdapter$init$2 = ComposeViewAdapter$init$2.INSTANCE;
        } else {
            composeViewAdapter$init$2 = function02;
        }
        composeViewAdapter.init$ui_tooling_release(str, str2, cls2, i13, z15, z16, j12, z17, z18, str4, composeViewAdapter$init$1, composeViewAdapter$init$2);
    }

    private final void invalidateComposition() {
        this.content.setValue(ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m5407getLambda3$ui_tooling_release());
        this.content.setValue(this.previewComposition);
        invalidate();
    }

    private final String invokeGetDesignInfo(Object obj, int i11, int i12) {
        Method designInfoMethodOrNull = getDesignInfoMethodOrNull(obj);
        if (designInfoMethodOrNull == null) {
            return null;
        }
        try {
            boolean z11 = false;
            Object invoke = designInfoMethodOrNull.invoke(obj, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), this.designInfoProvidersArgument});
            if (invoke != null) {
                String str = (String) invoke;
                if (str.length() == 0) {
                    z11 = true;
                }
                if (z11) {
                    return null;
                }
                return str;
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
        } catch (Exception unused) {
            return null;
        }
    }

    private final boolean isNullGroup(Group group) {
        return hasNullSourcePosition(group) && group.getChildren().isEmpty();
    }

    private final void processViewInfos() {
        Set<CompositionData> store = this.slotTableRecord.getStore();
        ArrayList<Group> arrayList = new ArrayList<>(CollectionsKt__IterablesKt.collectionSizeOrDefault(store, 10));
        for (CompositionData asTree : store) {
            arrayList.add(SlotTreeKt.asTree(asTree));
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (Group viewInfo : arrayList) {
            arrayList2.add(toViewInfo(viewInfo));
        }
        List<ViewInfo> list = CollectionsKt___CollectionsKt.toList(arrayList2);
        this.viewInfos = list;
        if (this.debugViewInfos) {
            for (ViewInfo b11 : list) {
                b(this, b11, 0, 2, (Object) null);
            }
        }
    }

    private final ViewInfo toViewInfo(Group group) {
        String str;
        int i11;
        String sourceFile;
        if (group.getChildren().size() == 1 && hasNullSourcePosition(group)) {
            return toViewInfo((Group) CollectionsKt___CollectionsKt.single(group.getChildren()));
        }
        ArrayList<Group> arrayList = new ArrayList<>();
        for (Object next : group.getChildren()) {
            if (!isNullGroup((Group) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(CollectionsKt__IterablesKt.collectionSizeOrDefault(arrayList, 10));
        for (Group viewInfo : arrayList) {
            arrayList2.add(toViewInfo(viewInfo));
        }
        SourceLocation location = group.getLocation();
        if (location == null || (sourceFile = location.getSourceFile()) == null) {
            str = "";
        } else {
            str = sourceFile;
        }
        SourceLocation location2 = group.getLocation();
        if (location2 == null) {
            i11 = -1;
        } else {
            i11 = location2.getLineNumber();
        }
        return new ViewInfo(str, i11, group.getBox(), group.getLocation(), arrayList2);
    }

    private final void walkTable(ViewInfo viewInfo, int i11) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(StringsKt__StringsJVMKt.repeat("|  ", i11));
        sb2.append("|-");
        sb2.append(viewInfo);
        for (ViewInfo walkTable : viewInfo.getChildren()) {
            walkTable(walkTable, i11 + 1);
        }
    }

    public void dispatchDraw(@Nullable Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.forceCompositionInvalidation) {
            invalidateComposition();
        }
        this.onDraw.invoke();
        if (this.debugPaintBounds) {
            ArrayList<ViewInfo> arrayList = new ArrayList<>();
            for (ViewInfo viewInfo : this.viewInfos) {
                boolean unused = CollectionsKt__MutableCollectionsKt.addAll(arrayList, CollectionsKt___CollectionsKt.plus(CollectionsKt__CollectionsJVMKt.listOf(viewInfo), viewInfo.allChildren()));
            }
            for (ViewInfo viewInfo2 : arrayList) {
                if (viewInfo2.hasBounds() && canvas != null) {
                    canvas.drawRect(new Rect(viewInfo2.getBounds().getLeft(), viewInfo2.getBounds().getTop(), viewInfo2.getBounds().getRight(), viewInfo2.getBounds().getBottom()), this.debugBoundsPaint);
                }
            }
        }
    }

    public final void dispose$ui_tooling_release() {
        this.composeView.disposeComposition();
        if (this.clock != null) {
            getClock$ui_tooling_release().dispose();
        }
    }

    @NotNull
    public final PreviewAnimationClock getClock$ui_tooling_release() {
        PreviewAnimationClock previewAnimationClock = this.clock;
        if (previewAnimationClock != null) {
            return previewAnimationClock;
        }
        Intrinsics.throwUninitializedPropertyAccessException("clock");
        return null;
    }

    @NotNull
    public final List<String> getDesignInfoList$ui_tooling_release() {
        return this.designInfoList;
    }

    @NotNull
    public final List<ViewInfo> getViewInfos$ui_tooling_release() {
        return this.viewInfos;
    }

    public final boolean hasAnimations() {
        return this.hasAnimations;
    }

    @VisibleForTesting
    public final void init$ui_tooling_release(@NotNull String str, @NotNull String str2, @Nullable Class<? extends PreviewParameterProvider<?>> cls, int i11, boolean z11, boolean z12, long j11, boolean z13, boolean z14, @Nullable String str3, @NotNull Function0<Unit> function0, @NotNull Function0<Unit> function02) {
        String str4;
        Function0<Unit> function03 = function02;
        String str5 = str;
        Intrinsics.checkNotNullParameter(str, HexAttribute.HEX_ATTR_CLASS_NAME);
        Intrinsics.checkNotNullParameter(str2, HexAttribute.HEX_ATTR_METHOD_NAME);
        Intrinsics.checkNotNullParameter(function0, "onCommit");
        Intrinsics.checkNotNullParameter(function03, "onDraw");
        this.debugPaintBounds = z11;
        this.debugViewInfos = z12;
        this.composableName = str2;
        this.forceCompositionInvalidation = z13;
        this.lookForDesignInfoProviders = z14;
        if (str3 == null) {
            str4 = "";
        } else {
            str4 = str3;
        }
        this.designInfoProvidersArgument = str4;
        this.onDraw = function03;
        ComposableLambda composableLambdaInstance = ComposableLambdaKt.composableLambdaInstance(-985553124, true, new ComposeViewAdapter$init$3(function0, this, j11, str, str2, cls, i11));
        this.previewComposition = composableLambdaInstance;
        this.composeView.setContent(composableLambdaInstance);
        invalidate();
    }

    public void onAttachedToWindow() {
        ViewTreeLifecycleOwner.set(this.composeView.getRootView(), this.FakeSavedStateRegistryOwner);
        super.onAttachedToWindow();
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        boolean z12;
        super.onLayout(z11, i11, i12, i13, i14);
        synchronized (this.delayExceptionLock) {
            Throwable th2 = this.delayedException;
            if (th2 != null) {
                throw th2;
            }
        }
        processViewInfos();
        if (this.composableName.length() > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (z12) {
            findAndTrackTransitions();
            if (this.lookForDesignInfoProviders) {
                findDesignInfoProviders();
            }
        }
    }

    public final void setClock$ui_tooling_release(@NotNull PreviewAnimationClock previewAnimationClock) {
        Intrinsics.checkNotNullParameter(previewAnimationClock, "<set-?>");
        this.clock = previewAnimationClock;
    }

    public final void setDesignInfoList$ui_tooling_release(@NotNull List<String> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.designInfoList = list;
    }

    public final void setViewInfos$ui_tooling_release(@NotNull List<ViewInfo> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.viewInfos = list;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ComposeViewAdapter(@NotNull Context context, @NotNull AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, UserAttributesCacheManager.USER_ATTRIBUTES_CACHE_KEY);
        Context context2 = getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "context");
        this.composeView = new ComposeView(context2, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        this.viewInfos = CollectionsKt__CollectionsKt.emptyList();
        this.designInfoList = CollectionsKt__CollectionsKt.emptyList();
        this.slotTableRecord = CompositionDataRecord.Companion.create();
        this.composableName = "";
        this.delayExceptionLock = new Object();
        this.previewComposition = ComposableSingletons$ComposeViewAdapterKt.INSTANCE.m5406getLambda2$ui_tooling_release();
        this.content = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ComposeViewAdapterKt.emptyContent, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.designInfoProvidersArgument = "";
        this.onDraw = ComposeViewAdapter$onDraw$1.INSTANCE;
        Paint paint = new Paint();
        paint.setPathEffect(new DashPathEffect(new float[]{5.0f, 10.0f, 15.0f, 20.0f}, 0.0f));
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(ColorKt.m2974toArgb8_81llA(Color.Companion.m2953getRed0d7_KjU()));
        Unit unit = Unit.INSTANCE;
        this.debugBoundsPaint = paint;
        this.FakeSavedStateRegistryOwner = new ComposeViewAdapter$FakeSavedStateRegistryOwner$1();
        this.FakeViewModelStoreOwner = ComposeViewAdapter$FakeViewModelStoreOwner$1.INSTANCE;
        this.FakeOnBackPressedDispatcherOwner = new ComposeViewAdapter$FakeOnBackPressedDispatcherOwner$1(this);
        this.FakeActivityResultRegistryOwner = new ComposeViewAdapter$FakeActivityResultRegistryOwner$1();
        init(attributeSet);
    }
}
