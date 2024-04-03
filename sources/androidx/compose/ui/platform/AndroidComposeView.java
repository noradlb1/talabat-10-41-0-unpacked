package androidx.compose.ui.platform;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.os.Build;
import android.os.Trace;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStructure;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.view.autofill.AutofillValue;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.VisibleForTesting;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotMutationPolicy;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.autofill.AndroidAutofill;
import androidx.compose.ui.autofill.AndroidAutofill_androidKt;
import androidx.compose.ui.autofill.Autofill;
import androidx.compose.ui.autofill.AutofillCallback;
import androidx.compose.ui.autofill.AutofillTree;
import androidx.compose.ui.focus.FocusDirection;
import androidx.compose.ui.focus.FocusManager;
import androidx.compose.ui.focus.FocusManagerImpl;
import androidx.compose.ui.focus.FocusModifier;
import androidx.compose.ui.focus.FocusTraversalKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.CanvasHolder;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.drawscope.CanvasDrawScope;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.hapticfeedback.PlatformHapticFeedback;
import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.input.InputModeManagerImpl;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.KeyInputModifier;
import androidx.compose.ui.input.pointer.MotionEventAdapter;
import androidx.compose.ui.input.pointer.PointerIcon;
import androidx.compose.ui.input.pointer.PointerIconService;
import androidx.compose.ui.input.pointer.PointerInputEvent;
import androidx.compose.ui.input.pointer.PointerInputEventData;
import androidx.compose.ui.input.pointer.PointerInputEventProcessor;
import androidx.compose.ui.input.pointer.PointerInputEventProcessorKt;
import androidx.compose.ui.input.pointer.PointerKeyboardModifiers;
import androidx.compose.ui.input.pointer.PositionCalculator;
import androidx.compose.ui.input.pointer.ProcessResult;
import androidx.compose.ui.input.rotary.RotaryInputModifierKt;
import androidx.compose.ui.input.rotary.RotaryScrollEvent;
import androidx.compose.ui.layout.RootMeasurePolicy;
import androidx.compose.ui.modifier.ModifierLocalManager;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeDrawScope;
import androidx.compose.ui.node.MeasureAndLayoutDelegate;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.node.Owner;
import androidx.compose.ui.node.OwnerSnapshotObserver;
import androidx.compose.ui.node.RootForTest;
import androidx.compose.ui.platform.ViewLayer;
import androidx.compose.ui.semantics.SemanticsModifierCore;
import androidx.compose.ui.semantics.SemanticsOwner;
import androidx.compose.ui.text.font.Font;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyResolver_androidKt;
import androidx.compose.ui.text.input.TextInputService;
import androidx.compose.ui.text.input.TextInputServiceAndroid;
import androidx.compose.ui.unit.AndroidDensity_androidKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.ViewConfigurationCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import androidx.savedstate.SavedStateRegistryOwner;
import androidx.savedstate.ViewTreeSavedStateRegistryOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import d2.a;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import m0.d;
import m0.e;
import m0.f;
import m0.g;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000Ê\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0018*\u0002\u0001\b\u0001\u0018\u0000 \u00032\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0004\u0003\u0003B\r\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u001b\u0010ë\u0001\u001a\u00020-2\b\u0010Î\u0001\u001a\u00030ì\u00012\b\u0010í\u0001\u001a\u00030\u0001J\u0019\u0010\u001c\u001a\u00020-2\u000f\u0010î\u0001\u001a\n\u0012\u0005\u0012\u00030ð\u00010ï\u0001H\u0016J\t\u0010ñ\u0001\u001a\u00020TH\u0002J\u0013\u0010ò\u0001\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010ó\u0001J!\u0010ô\u0001\u001a\u00020m2\u0007\u0010õ\u0001\u001a\u00020mH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bö\u0001\u0010÷\u0001J!\u0010ø\u0001\u001a\u00020m2\u0007\u0010ù\u0001\u001a\u00020mH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bú\u0001\u0010÷\u0001J\u0012\u0010û\u0001\u001a\u00020T2\u0007\u0010ü\u0001\u001a\u000203H\u0016J\u0012\u0010ý\u0001\u001a\u00020T2\u0007\u0010ü\u0001\u001a\u000203H\u0016J\u0012\u0010þ\u0001\u001a\u00020-2\u0007\u0010ÿ\u0001\u001a\u00020\u0001H\u0002J\u001f\u0010\u0002\u001a\u000f\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u0002030\u00022\u0007\u0010\u0002\u001a\u000203H\u0002J.\u0010\u0002\u001a\u00020=2\u0014\u0010\u0002\u001a\u000f\u0012\u0005\u0012\u00030\u0002\u0012\u0004\u0012\u00020-0+2\r\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020-0@H\u0016J\u0013\u0010\u0002\u001a\u00020-2\b\u0010\u0002\u001a\u00030\u0002H\u0014J\u0013\u0010\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0001H\u0016J\u0013\u0010\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0001H\u0016J\u0013\u0010\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0002H\u0016J\u0013\u0010\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0001H\u0016J\u001b\u0010\u0002\u001a\u00020-2\b\u0010Î\u0001\u001a\u00030ì\u00012\b\u0010\u0002\u001a\u00030\u0002J\u001f\u0010\u0002\u001a\u0005\u0018\u00010Ï\u00012\u0007\u0010\u0002\u001a\u0002032\b\u0010\u0002\u001a\u00030Ï\u0001H\u0002J\u0013\u0010\u0002\u001a\u0005\u0018\u00010Ï\u00012\u0007\u0010\u0002\u001a\u000203J\u0013\u0010\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u0001H\u0016J%\u0010\u0002\u001a\u0005\u0018\u00010\u00022\b\u0010\u0002\u001a\u00030\u0002H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b\u0002\u0010\u0002J\u0013\u0010\u0002\u001a\u00020-2\b\u0010\u0002\u001a\u00030\u0002H\u0016J&\u0010 \u0002\u001a\u00030¡\u00022\b\u0010\u0002\u001a\u00030\u0001H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b¢\u0002\u0010£\u0002J\u0013\u0010¤\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u001d\u0010¥\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u00012\b\u0010¦\u0002\u001a\u00030\u0001H\u0002J\t\u0010§\u0002\u001a\u00020-H\u0016J\u0013\u0010¨\u0002\u001a\u00020-2\b\u0010©\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010ª\u0002\u001a\u00020-2\b\u0010©\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010«\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010¬\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010­\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010®\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\u0013\u0010¯\u0002\u001a\u00020-H@ø\u0001\u0000¢\u0006\u0003\u0010ó\u0001J!\u0010°\u0002\u001a\u00020m2\u0007\u0010ù\u0001\u001a\u00020mH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b±\u0002\u0010÷\u0001J,\u0010²\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u00012\b\u0010³\u0002\u001a\u00030\u0001H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\b´\u0002\u0010µ\u0002J\u0012\u0010²\u0002\u001a\u00020-2\u0007\u0010¶\u0002\u001a\u00020TH\u0016J!\u0010·\u0002\u001a\u00020-2\u0007\u0010¸\u0002\u001a\u00020=2\u0007\u0010¹\u0002\u001a\u00020TH\u0000¢\u0006\u0003\bº\u0002J\u0013\u0010»\u0002\u001a\u00020-2\b\u0010©\u0002\u001a\u00030\u0001H\u0016J\t\u0010¼\u0002\u001a\u00020-H\u0014J\t\u0010½\u0002\u001a\u00020TH\u0016J\u0012\u0010¾\u0002\u001a\u00020-2\u0007\u0010¿\u0002\u001a\u00020,H\u0014J\u0016\u0010À\u0002\u001a\u0005\u0018\u00010Á\u00022\b\u0010Â\u0002\u001a\u00030Ã\u0002H\u0016J\u0013\u0010Ä\u0002\u001a\u00020-2\b\u0010©\u0002\u001a\u00030\u0001H\u0016J\t\u0010Å\u0002\u001a\u00020-H\u0014J\u0013\u0010Æ\u0002\u001a\u00020-2\b\u0010\u0002\u001a\u00030\u0002H\u0014J\t\u0010Ç\u0002\u001a\u00020-H\u0016J'\u0010È\u0002\u001a\u00020-2\u0007\u0010É\u0002\u001a\u00020T2\u0007\u0010ü\u0001\u001a\u0002032\n\u0010Ê\u0002\u001a\u0005\u0018\u00010\u0002H\u0014J6\u0010Ë\u0002\u001a\u00020-2\u0007\u0010Ì\u0002\u001a\u00020T2\u0007\u0010Í\u0002\u001a\u0002032\u0007\u0010Î\u0002\u001a\u0002032\u0007\u0010Ï\u0002\u001a\u0002032\u0007\u0010Ð\u0002\u001a\u000203H\u0014J\u0013\u0010Ñ\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u0001H\u0016J\u001b\u0010Ò\u0002\u001a\u00020-2\u0007\u0010Ó\u0002\u001a\u0002032\u0007\u0010Ô\u0002\u001a\u000203H\u0014J\u001e\u0010Õ\u0002\u001a\u00020-2\n\u0010Ö\u0002\u001a\u0005\u0018\u00010×\u00022\u0007\u0010Ø\u0002\u001a\u000203H\u0016J%\u0010Ù\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u00012\u0007\u0010Ú\u0002\u001a\u00020T2\u0007\u0010Û\u0002\u001a\u00020TH\u0016J%\u0010Ü\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u00012\u0007\u0010Ú\u0002\u001a\u00020T2\u0007\u0010Û\u0002\u001a\u00020TH\u0016J\u0013\u0010Ý\u0002\u001a\u00020-2\b\u0010Þ\u0002\u001a\u00030ß\u0002H\u0016J\u0011\u0010à\u0002\u001a\u00020-2\u0006\u0010x\u001a\u000203H\u0016J\t\u0010á\u0002\u001a\u00020-H\u0016J\u0012\u0010â\u0002\u001a\u00020-2\u0007\u0010ã\u0002\u001a\u00020TH\u0016J\t\u0010ä\u0002\u001a\u00020-H\u0002J\u0013\u0010ä\u0002\u001a\u00020-2\b\u0010\u0002\u001a\u00030\u0001H\u0002J\t\u0010å\u0002\u001a\u00020-H\u0002J\u0018\u0010æ\u0002\u001a\u00020T2\u0007\u0010¸\u0002\u001a\u00020=H\u0000¢\u0006\u0003\bç\u0002J\u0018\u0010è\u0002\u001a\u00020-2\r\u0010é\u0002\u001a\b\u0012\u0004\u0012\u00020-0@H\u0016J\u0013\u0010ê\u0002\u001a\u00020-2\b\u0010é\u0002\u001a\u00030ë\u0002H\u0016J\u0011\u0010ì\u0002\u001a\u00020-2\b\u0010Î\u0001\u001a\u00030ì\u0001J\u0007\u0010í\u0002\u001a\u00020-J\u0013\u0010î\u0002\u001a\u00020-2\b\u0010í\u0001\u001a\u00030\u0001H\u0016J\u0017\u0010ï\u0002\u001a\u00020-2\f\b\u0002\u0010ð\u0002\u001a\u0005\u0018\u00010\u0001H\u0002J!\u0010ñ\u0002\u001a\u00020m2\u0007\u0010ò\u0002\u001a\u00020mH\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bó\u0002\u0010÷\u0001J\"\u0010ô\u0002\u001a\u00020T2\b\u0010\u0002\u001a\u00030\u0002H\u0016ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bõ\u0002\u0010ö\u0002J&\u0010÷\u0002\u001a\u00030¡\u00022\b\u0010\u0002\u001a\u00030\u0001H\u0002ø\u0001\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0006\bø\u0002\u0010£\u0002J0\u0010ù\u0002\u001a\u00020-2\b\u0010\u0002\u001a\u00030\u00012\u0007\u0010ú\u0002\u001a\u0002032\u0007\u0010û\u0002\u001a\u00020o2\t\b\u0002\u0010ü\u0002\u001a\u00020TH\u0002J\u001d\u0010ý\u0002\u001a\u00020-2\u0014\u0010þ\u0002\u001a\u000f\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020-0+J\t\u0010ÿ\u0002\u001a\u00020TH\u0016J\t\u0010\u0003\u001a\u00020-H\u0002R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u0016X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\u00020\n8@X\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u0004\u0018\u00010\u001d8VX\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020!X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010&\u001a\u00020'X\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R&\u0010*\u001a\u000e\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-0+X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u000e\u00102\u001a\u000203X\u000e¢\u0006\u0002\n\u0000R\u001e\u00106\u001a\u0002052\u0006\u00104\u001a\u000205@RX\u000e¢\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0010\u00109\u001a\u0004\u0018\u00010:X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010;\u001a\b\u0012\u0004\u0012\u00020=0<X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010>\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020-\u0018\u00010@0?X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020B8VX\u0004¢\u0006\u0006\u001a\u0004\bC\u0010DR+\u0010F\u001a\u00020E2\u0006\u00104\u001a\u00020E8V@RX\u0002¢\u0006\u0012\n\u0004\bK\u0010L\u001a\u0004\bG\u0010H\"\u0004\bI\u0010JR\u001c\u0010M\u001a\u00020N8\u0016X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bO\u0010P\u001a\u0004\bQ\u0010RR\u000e\u0010S\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020VX\u0004¢\u0006\u0002\n\u0000R\u0019\u0010W\u001a\u00020XX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010YR\u0014\u0010Z\u001a\u00020[X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\\\u0010]R\u0014\u0010^\u001a\u00020T8VX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u000e\u0010a\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010b\u001a\u00020c8VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010eR\u000e\u0010f\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010g\u001a\u00020T8VX\u0004¢\u0006\u0006\u001a\u0004\bg\u0010`R\u000e\u0010h\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010i\u001a\u00020jX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000R\u0019\u0010l\u001a\u00020mX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010YR$\u0010n\u001a\u00020o8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bp\u0010P\u001a\u0004\bq\u0010r\"\u0004\bs\u0010tR\u0014\u0010u\u001a\b\u0012\u0004\u0012\u00020=0vX\u0004¢\u0006\u0002\n\u0000R+\u0010x\u001a\u00020w2\u0006\u00104\u001a\u00020w8V@RX\u0002¢\u0006\u0012\n\u0004\b}\u0010L\u001a\u0004\by\u0010z\"\u0004\b{\u0010|R\u000e\u0010~\u001a\u00020X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0001\u001a\u00020o8VX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010rR\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0002\n\u0000R\u001e\u0010\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u0001\u0012\u0004\u0012\u00020-\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010\u0001R\u0010\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0001\u001a\n\u0012\u0004\u0012\u00020=\u0018\u00010<X\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0001\u001a\u0005\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0001\u001a\u00020oX\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020-0@X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\u0005\n\u0003\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b\u0001\u0010 \u0001R\u0018\u0010¡\u0001\u001a\u00030¢\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b£\u0001\u0010¤\u0001R\u0010\u0010¥\u0001\u001a\u00030¦\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010§\u0001\u001a\u00030¨\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010©\u0001\u001a\u00030ª\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010«\u0001\u001a\u00030¬\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b­\u0001\u0010®\u0001R\u0010\u0010¯\u0001\u001a\u00030°\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010±\u0001\u001a\u00030²\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b³\u0001\u0010´\u0001R%\u0010µ\u0001\u001a\u00020TX\u000e¢\u0006\u0018\n\u0000\u0012\u0005\b¶\u0001\u0010P\u001a\u0005\b·\u0001\u0010`\"\u0006\b¸\u0001\u0010¹\u0001R\u0018\u0010º\u0001\u001a\u00030»\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\b¼\u0001\u0010½\u0001R\u000f\u0010¾\u0001\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000R\u001f\u0010¿\u0001\u001a\u00030À\u0001X\u0004¢\u0006\u0011\n\u0000\u0012\u0005\bÁ\u0001\u0010P\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u0010\u0010Ä\u0001\u001a\u00030Å\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Æ\u0001\u001a\u00030Ç\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÈ\u0001\u0010É\u0001R\u0010\u0010Ê\u0001\u001a\u00030Ë\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Ì\u0001\u001a\u00030Í\u0001X\u0004¢\u0006\u0002\n\u0000R\u0018\u0010Î\u0001\u001a\u00030Ï\u00018VX\u0004¢\u0006\b\u001a\u0006\bÐ\u0001\u0010Ñ\u0001R\u0018\u0010Ò\u0001\u001a\u00030Ó\u0001X\u0004¢\u0006\n\n\u0000\u001a\u0006\bÔ\u0001\u0010Õ\u0001R\u0012\u0010Ö\u0001\u001a\u0005\u0018\u00010×\u0001X\u000e¢\u0006\u0002\n\u0000R\u001c\u0010Ø\u0001\u001a\u00030Ù\u0001X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010Ú\u0001R7\u0010Û\u0001\u001a\u0005\u0018\u00010\u00012\t\u00104\u001a\u0005\u0018\u00010\u00018F@BX\u0002¢\u0006\u0017\n\u0005\bà\u0001\u0010L\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010ß\u0001R\u000f\u0010á\u0001\u001a\u00020TX\u000e¢\u0006\u0002\n\u0000R\u0018\u0010â\u0001\u001a\u00030ã\u00018VX\u0004¢\u0006\b\u001a\u0006\bä\u0001\u0010å\u0001R\u001a\u0010æ\u0001\u001a\u00020mX\u000eø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0004\n\u0002\u0010YR\u001c\u0010ç\u0001\u001a\u00030Ù\u0001X\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0005\n\u0003\u0010Ú\u0001R\u001b\u0010è\u0001\u001a\u000203*\u00020,8BX\u0004¢\u0006\b\u001a\u0006\bé\u0001\u0010ê\u0001\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0003"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView;", "Landroid/view/ViewGroup;", "Landroidx/compose/ui/node/Owner;", "Landroidx/compose/ui/platform/ViewRootForTest;", "Landroidx/compose/ui/input/pointer/PositionCalculator;", "Landroidx/lifecycle/DefaultLifecycleObserver;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_androidViewsHandler", "Landroidx/compose/ui/platform/AndroidViewsHandler;", "_autofill", "Landroidx/compose/ui/autofill/AndroidAutofill;", "_focusManager", "Landroidx/compose/ui/focus/FocusManagerImpl;", "_inputModeManager", "Landroidx/compose/ui/input/InputModeManagerImpl;", "_windowInfo", "Landroidx/compose/ui/platform/WindowInfoImpl;", "accessibilityDelegate", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "accessibilityManager", "Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "getAccessibilityManager", "()Landroidx/compose/ui/platform/AndroidAccessibilityManager;", "androidViewsHandler", "getAndroidViewsHandler$ui_release", "()Landroidx/compose/ui/platform/AndroidViewsHandler;", "autofill", "Landroidx/compose/ui/autofill/Autofill;", "getAutofill", "()Landroidx/compose/ui/autofill/Autofill;", "autofillTree", "Landroidx/compose/ui/autofill/AutofillTree;", "getAutofillTree", "()Landroidx/compose/ui/autofill/AutofillTree;", "canvasHolder", "Landroidx/compose/ui/graphics/CanvasHolder;", "clipboardManager", "Landroidx/compose/ui/platform/AndroidClipboardManager;", "getClipboardManager", "()Landroidx/compose/ui/platform/AndroidClipboardManager;", "configurationChangeObserver", "Lkotlin/Function1;", "Landroid/content/res/Configuration;", "", "getConfigurationChangeObserver", "()Lkotlin/jvm/functions/Function1;", "setConfigurationChangeObserver", "(Lkotlin/jvm/functions/Function1;)V", "currentFontWeightAdjustment", "", "<set-?>", "Landroidx/compose/ui/unit/Density;", "density", "getDensity", "()Landroidx/compose/ui/unit/Density;", "desiredPointerIcon", "Landroidx/compose/ui/input/pointer/PointerIcon;", "dirtyLayers", "", "Landroidx/compose/ui/node/OwnedLayer;", "endApplyChangesListeners", "Landroidx/compose/runtime/collection/MutableVector;", "Lkotlin/Function0;", "focusManager", "Landroidx/compose/ui/focus/FocusManager;", "getFocusManager", "()Landroidx/compose/ui/focus/FocusManager;", "Landroidx/compose/ui/text/font/FontFamily$Resolver;", "fontFamilyResolver", "getFontFamilyResolver", "()Landroidx/compose/ui/text/font/FontFamily$Resolver;", "setFontFamilyResolver", "(Landroidx/compose/ui/text/font/FontFamily$Resolver;)V", "fontFamilyResolver$delegate", "Landroidx/compose/runtime/MutableState;", "fontLoader", "Landroidx/compose/ui/text/font/Font$ResourceLoader;", "getFontLoader$annotations", "()V", "getFontLoader", "()Landroidx/compose/ui/text/font/Font$ResourceLoader;", "forceUseMatrixCache", "", "globalLayoutListener", "Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;", "globalPosition", "Landroidx/compose/ui/unit/IntOffset;", "J", "hapticFeedBack", "Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "getHapticFeedBack", "()Landroidx/compose/ui/hapticfeedback/HapticFeedback;", "hasPendingMeasureOrLayout", "getHasPendingMeasureOrLayout", "()Z", "hoverExitReceived", "inputModeManager", "Landroidx/compose/ui/input/InputModeManager;", "getInputModeManager", "()Landroidx/compose/ui/input/InputModeManager;", "isDrawingContent", "isLifecycleInResumedState", "isRenderNodeCompatible", "keyInputModifier", "Landroidx/compose/ui/input/key/KeyInputModifier;", "keyboardModifiersRequireUpdate", "lastDownPointerPosition", "Landroidx/compose/ui/geometry/Offset;", "lastMatrixRecalculationAnimationTime", "", "getLastMatrixRecalculationAnimationTime$ui_release$annotations", "getLastMatrixRecalculationAnimationTime$ui_release", "()J", "setLastMatrixRecalculationAnimationTime$ui_release", "(J)V", "layerCache", "Landroidx/compose/ui/platform/WeakCache;", "Landroidx/compose/ui/unit/LayoutDirection;", "layoutDirection", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "layoutDirection$delegate", "matrixToWindow", "Landroidx/compose/ui/platform/CalculateMatrixToWindow;", "measureAndLayoutDelegate", "Landroidx/compose/ui/node/MeasureAndLayoutDelegate;", "measureIteration", "getMeasureIteration", "modifierLocalManager", "Landroidx/compose/ui/modifier/ModifierLocalManager;", "getModifierLocalManager", "()Landroidx/compose/ui/modifier/ModifierLocalManager;", "motionEventAdapter", "Landroidx/compose/ui/input/pointer/MotionEventAdapter;", "observationClearRequested", "onMeasureConstraints", "Landroidx/compose/ui/unit/Constraints;", "onViewTreeOwnersAvailable", "Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "pointerIconService", "Landroidx/compose/ui/input/pointer/PointerIconService;", "getPointerIconService", "()Landroidx/compose/ui/input/pointer/PointerIconService;", "pointerInputEventProcessor", "Landroidx/compose/ui/input/pointer/PointerInputEventProcessor;", "postponedDirtyLayers", "previousMotionEvent", "Landroid/view/MotionEvent;", "relayoutTime", "resendMotionEventOnLayout", "resendMotionEventRunnable", "androidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1", "Landroidx/compose/ui/platform/AndroidComposeView$resendMotionEventRunnable$1;", "root", "Landroidx/compose/ui/node/LayoutNode;", "getRoot", "()Landroidx/compose/ui/node/LayoutNode;", "rootForTest", "Landroidx/compose/ui/node/RootForTest;", "getRootForTest", "()Landroidx/compose/ui/node/RootForTest;", "rotaryInputModifier", "Landroidx/compose/ui/Modifier;", "scrollChangedListener", "Landroid/view/ViewTreeObserver$OnScrollChangedListener;", "semanticsModifier", "Landroidx/compose/ui/semantics/SemanticsModifierCore;", "semanticsOwner", "Landroidx/compose/ui/semantics/SemanticsOwner;", "getSemanticsOwner", "()Landroidx/compose/ui/semantics/SemanticsOwner;", "sendHoverExitEvent", "Ljava/lang/Runnable;", "sharedDrawScope", "Landroidx/compose/ui/node/LayoutNodeDrawScope;", "getSharedDrawScope", "()Landroidx/compose/ui/node/LayoutNodeDrawScope;", "showLayoutBounds", "getShowLayoutBounds$annotations", "getShowLayoutBounds", "setShowLayoutBounds", "(Z)V", "snapshotObserver", "Landroidx/compose/ui/node/OwnerSnapshotObserver;", "getSnapshotObserver", "()Landroidx/compose/ui/node/OwnerSnapshotObserver;", "superclassInitComplete", "textInputService", "Landroidx/compose/ui/text/input/TextInputService;", "getTextInputService$annotations", "getTextInputService", "()Landroidx/compose/ui/text/input/TextInputService;", "textInputServiceAndroid", "Landroidx/compose/ui/text/input/TextInputServiceAndroid;", "textToolbar", "Landroidx/compose/ui/platform/TextToolbar;", "getTextToolbar", "()Landroidx/compose/ui/platform/TextToolbar;", "tmpPositionArray", "", "touchModeChangeListener", "Landroid/view/ViewTreeObserver$OnTouchModeChangeListener;", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "viewConfiguration", "Landroidx/compose/ui/platform/ViewConfiguration;", "getViewConfiguration", "()Landroidx/compose/ui/platform/ViewConfiguration;", "viewLayersContainer", "Landroidx/compose/ui/platform/DrawChildContainer;", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "[F", "viewTreeOwners", "getViewTreeOwners", "()Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "setViewTreeOwners", "(Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;)V", "viewTreeOwners$delegate", "wasMeasuredWithMultipleConstraints", "windowInfo", "Landroidx/compose/ui/platform/WindowInfo;", "getWindowInfo", "()Landroidx/compose/ui/platform/WindowInfo;", "windowPosition", "windowToViewMatrix", "fontWeightAdjustmentCompat", "getFontWeightAdjustmentCompat", "(Landroid/content/res/Configuration;)I", "addAndroidView", "Landroidx/compose/ui/viewinterop/AndroidViewHolder;", "layoutNode", "values", "Landroid/util/SparseArray;", "Landroid/view/autofill/AutofillValue;", "autofillSupported", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateLocalPosition", "positionInWindow", "calculateLocalPosition-MK-Hz9U", "(J)J", "calculatePositionInWindow", "localPosition", "calculatePositionInWindow-MK-Hz9U", "canScrollHorizontally", "direction", "canScrollVertically", "clearChildInvalidObservations", "viewGroup", "convertMeasureSpec", "Lkotlin/Pair;", "measureSpec", "createLayer", "drawBlock", "Landroidx/compose/ui/graphics/Canvas;", "invalidateParentLayer", "dispatchDraw", "canvas", "Landroid/graphics/Canvas;", "dispatchGenericMotionEvent", "event", "dispatchHoverEvent", "dispatchKeyEvent", "Landroid/view/KeyEvent;", "dispatchTouchEvent", "motionEvent", "drawAndroidView", "findViewByAccessibilityIdRootedAtCurrentView", "accessibilityId", "currentView", "findViewByAccessibilityIdTraversal", "forceMeasureTheSubtree", "getFocusDirection", "Landroidx/compose/ui/focus/FocusDirection;", "keyEvent", "Landroidx/compose/ui/input/key/KeyEvent;", "getFocusDirection-P8AzH3I", "(Landroid/view/KeyEvent;)Landroidx/compose/ui/focus/FocusDirection;", "getFocusedRect", "rect", "Landroid/graphics/Rect;", "handleMotionEvent", "Landroidx/compose/ui/input/pointer/ProcessResult;", "handleMotionEvent-8iAsVTc", "(Landroid/view/MotionEvent;)I", "handleRotaryEvent", "hasChangedDevices", "lastEvent", "invalidateDescendants", "invalidateLayers", "node", "invalidateLayoutNodeMeasurement", "isBadMotionEvent", "isDevicePressEvent", "isInBounds", "isPositionChanged", "keyboardVisibilityEventLoop", "localToScreen", "localToScreen-MK-Hz9U", "measureAndLayout", "constraints", "measureAndLayout-0kLqBqw", "(Landroidx/compose/ui/node/LayoutNode;J)V", "sendPointerUpdate", "notifyLayerIsDirty", "layer", "isDirty", "notifyLayerIsDirty$ui_release", "onAttach", "onAttachedToWindow", "onCheckIsTextEditor", "onConfigurationChanged", "newConfig", "onCreateInputConnection", "Landroid/view/inputmethod/InputConnection;", "outAttrs", "Landroid/view/inputmethod/EditorInfo;", "onDetach", "onDetachedFromWindow", "onDraw", "onEndApplyChanges", "onFocusChanged", "gainFocus", "previouslyFocusedRect", "onLayout", "changed", "l", "t", "r", "b", "onLayoutChange", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "onProvideAutofillVirtualStructure", "structure", "Landroid/view/ViewStructure;", "flags", "onRequestMeasure", "affectsLookahead", "forceRequest", "onRequestRelayout", "onResume", "owner", "Landroidx/lifecycle/LifecycleOwner;", "onRtlPropertiesChanged", "onSemanticsChange", "onWindowFocusChanged", "hasWindowFocus", "recalculateWindowPosition", "recalculateWindowViewTransforms", "recycle", "recycle$ui_release", "registerOnEndApplyChangesListener", "listener", "registerOnLayoutCompletedListener", "Landroidx/compose/ui/node/Owner$OnLayoutCompletedListener;", "removeAndroidView", "requestClearInvalidObservations", "requestOnPositionedCallback", "scheduleMeasureAndLayout", "nodeToRemeasure", "screenToLocal", "positionOnScreen", "screenToLocal-MK-Hz9U", "sendKeyEvent", "sendKeyEvent-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "sendMotionEvent", "sendMotionEvent-8iAsVTc", "sendSimulatedEvent", "action", "eventTime", "forceHover", "setOnViewTreeOwnersAvailable", "callback", "shouldDelayChildPressedState", "updatePositionCacheAndDispatch", "Companion", "ViewTreeOwners", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@SuppressLint({"ViewConstructor", "VisibleForTests"})
public final class AndroidComposeView extends ViewGroup implements Owner, ViewRootForTest, PositionCalculator, DefaultLifecycleObserver {
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    private static final String FocusTag = "Compose Focus";
    private static final int MaximumLayerCacheSize = 10;
    /* access modifiers changed from: private */
    @Nullable
    public static Method getBooleanMethod;
    /* access modifiers changed from: private */
    @Nullable
    public static Class<?> systemPropertiesClass;
    @Nullable
    private AndroidViewsHandler _androidViewsHandler;
    @Nullable
    private final AndroidAutofill _autofill;
    @NotNull
    private final FocusManagerImpl _focusManager;
    @NotNull
    private final InputModeManagerImpl _inputModeManager;
    @NotNull
    private final WindowInfoImpl _windowInfo;
    @NotNull
    private final AndroidComposeViewAccessibilityDelegateCompat accessibilityDelegate;
    @NotNull
    private final AndroidAccessibilityManager accessibilityManager;
    @NotNull
    private final AutofillTree autofillTree;
    @NotNull
    private final CanvasHolder canvasHolder;
    @NotNull
    private final AndroidClipboardManager clipboardManager;
    @NotNull
    private Function1<? super Configuration, Unit> configurationChangeObserver;
    private int currentFontWeightAdjustment;
    @NotNull
    private Density density;
    /* access modifiers changed from: private */
    @Nullable
    public PointerIcon desiredPointerIcon;
    @NotNull
    private final List<OwnedLayer> dirtyLayers;
    @NotNull
    private final MutableVector<Function0<Unit>> endApplyChangesListeners;
    @NotNull
    private final MutableState fontFamilyResolver$delegate;
    @NotNull
    private final Font.ResourceLoader fontLoader;
    private boolean forceUseMatrixCache;
    @NotNull
    private final ViewTreeObserver.OnGlobalLayoutListener globalLayoutListener;
    private long globalPosition;
    @NotNull
    private final HapticFeedback hapticFeedBack;
    private boolean hoverExitReceived;
    private boolean isDrawingContent;
    private boolean isRenderNodeCompatible;
    @NotNull
    private final KeyInputModifier keyInputModifier;
    private boolean keyboardModifiersRequireUpdate;
    private long lastDownPointerPosition;
    private long lastMatrixRecalculationAnimationTime;
    @NotNull
    private final WeakCache<OwnedLayer> layerCache;
    @NotNull
    private final MutableState layoutDirection$delegate;
    @NotNull
    private final CalculateMatrixToWindow matrixToWindow;
    @NotNull
    private final MeasureAndLayoutDelegate measureAndLayoutDelegate;
    @NotNull
    private final ModifierLocalManager modifierLocalManager;
    @NotNull
    private final MotionEventAdapter motionEventAdapter;
    private boolean observationClearRequested;
    @Nullable
    private Constraints onMeasureConstraints;
    @Nullable
    private Function1<? super ViewTreeOwners, Unit> onViewTreeOwnersAvailable;
    @NotNull
    private final PointerIconService pointerIconService;
    @NotNull
    private final PointerInputEventProcessor pointerInputEventProcessor;
    @Nullable
    private List<OwnedLayer> postponedDirtyLayers;
    /* access modifiers changed from: private */
    @Nullable
    public MotionEvent previousMotionEvent;
    /* access modifiers changed from: private */
    public long relayoutTime;
    @NotNull
    private final Function0<Unit> resendMotionEventOnLayout;
    /* access modifiers changed from: private */
    @NotNull
    public final AndroidComposeView$resendMotionEventRunnable$1 resendMotionEventRunnable;
    @NotNull
    private final LayoutNode root;
    @NotNull
    private final RootForTest rootForTest;
    @NotNull
    private final Modifier rotaryInputModifier;
    @NotNull
    private final ViewTreeObserver.OnScrollChangedListener scrollChangedListener;
    @NotNull
    private final SemanticsModifierCore semanticsModifier;
    @NotNull
    private final SemanticsOwner semanticsOwner;
    @NotNull
    private final Runnable sendHoverExitEvent;
    @NotNull
    private final LayoutNodeDrawScope sharedDrawScope = new LayoutNodeDrawScope((CanvasDrawScope) null, 1, (DefaultConstructorMarker) null);
    private boolean showLayoutBounds;
    @NotNull
    private final OwnerSnapshotObserver snapshotObserver;
    private boolean superclassInitComplete = true;
    @NotNull
    private final TextInputService textInputService;
    @NotNull
    private final TextInputServiceAndroid textInputServiceAndroid;
    @NotNull
    private final TextToolbar textToolbar;
    @NotNull
    private final int[] tmpPositionArray;
    @NotNull
    private final ViewTreeObserver.OnTouchModeChangeListener touchModeChangeListener;
    @NotNull
    private final ViewConfiguration viewConfiguration;
    @Nullable
    private DrawChildContainer viewLayersContainer;
    @NotNull
    private final float[] viewToWindowMatrix;
    @NotNull
    private final MutableState viewTreeOwners$delegate;
    private boolean wasMeasuredWithMultipleConstraints;
    private long windowPosition;
    @NotNull
    private final float[] windowToViewMatrix;

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0003R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0002\b\u0003\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$Companion;", "", "()V", "FocusTag", "", "MaximumLayerCacheSize", "", "getBooleanMethod", "Ljava/lang/reflect/Method;", "systemPropertiesClass", "Ljava/lang/Class;", "getIsShowingLayoutBounds", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* access modifiers changed from: private */
        @SuppressLint({"PrivateApi", "BanUncheckedReflection"})
        public final boolean getIsShowingLayoutBounds() {
            Object obj;
            Method method;
            try {
                Boolean bool = null;
                if (AndroidComposeView.systemPropertiesClass == null) {
                    AndroidComposeView.systemPropertiesClass = Class.forName("android.os.SystemProperties");
                    Class access$getSystemPropertiesClass$cp = AndroidComposeView.systemPropertiesClass;
                    if (access$getSystemPropertiesClass$cp != null) {
                        method = access$getSystemPropertiesClass$cp.getDeclaredMethod("getBoolean", new Class[]{String.class, Boolean.TYPE});
                    } else {
                        method = null;
                    }
                    AndroidComposeView.getBooleanMethod = method;
                }
                Method access$getGetBooleanMethod$cp = AndroidComposeView.getBooleanMethod;
                if (access$getGetBooleanMethod$cp != null) {
                    obj = access$getGetBooleanMethod$cp.invoke((Object) null, new Object[]{"debug.layout", Boolean.FALSE});
                } else {
                    obj = null;
                }
                if (obj instanceof Boolean) {
                    bool = (Boolean) obj;
                }
                if (bool != null) {
                    return bool.booleanValue();
                }
                return false;
            } catch (Exception unused) {
                return false;
            }
        }
    }

    @StabilityInferred(parameters = 0)
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeView$ViewTreeOwners;", "", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "savedStateRegistryOwner", "Landroidx/savedstate/SavedStateRegistryOwner;", "(Landroidx/lifecycle/LifecycleOwner;Landroidx/savedstate/SavedStateRegistryOwner;)V", "getLifecycleOwner", "()Landroidx/lifecycle/LifecycleOwner;", "getSavedStateRegistryOwner", "()Landroidx/savedstate/SavedStateRegistryOwner;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class ViewTreeOwners {
        public static final int $stable = 8;
        @NotNull
        private final LifecycleOwner lifecycleOwner;
        @NotNull
        private final SavedStateRegistryOwner savedStateRegistryOwner;

        public ViewTreeOwners(@NotNull LifecycleOwner lifecycleOwner2, @NotNull SavedStateRegistryOwner savedStateRegistryOwner2) {
            Intrinsics.checkNotNullParameter(lifecycleOwner2, "lifecycleOwner");
            Intrinsics.checkNotNullParameter(savedStateRegistryOwner2, "savedStateRegistryOwner");
            this.lifecycleOwner = lifecycleOwner2;
            this.savedStateRegistryOwner = savedStateRegistryOwner2;
        }

        @NotNull
        public final LifecycleOwner getLifecycleOwner() {
            return this.lifecycleOwner;
        }

        @NotNull
        public final SavedStateRegistryOwner getSavedStateRegistryOwner() {
            return this.savedStateRegistryOwner;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AndroidComposeView(@NotNull Context context) {
        super(context);
        AndroidAutofill androidAutofill;
        int i11;
        CalculateMatrixToWindow calculateMatrixToWindow;
        Intrinsics.checkNotNullParameter(context, "context");
        Offset.Companion companion = Offset.Companion;
        this.lastDownPointerPosition = companion.m2691getUnspecifiedF1C5BW0();
        this.density = AndroidDensity_androidKt.Density(context);
        SemanticsModifierCore semanticsModifierCore = new SemanticsModifierCore(false, false, AndroidComposeView$semanticsModifier$1.INSTANCE, (Function1) null, 8, (DefaultConstructorMarker) null);
        this.semanticsModifier = semanticsModifierCore;
        FocusManagerImpl focusManagerImpl = new FocusManagerImpl((FocusModifier) null, 1, (DefaultConstructorMarker) null);
        this._focusManager = focusManagerImpl;
        this._windowInfo = new WindowInfoImpl();
        KeyInputModifier keyInputModifier2 = new KeyInputModifier(new AndroidComposeView$keyInputModifier$1(this), (Function1<? super KeyEvent, Boolean>) null);
        this.keyInputModifier = keyInputModifier2;
        Modifier.Companion companion2 = Modifier.Companion;
        Modifier onRotaryScrollEvent = RotaryInputModifierKt.onRotaryScrollEvent(companion2, AndroidComposeView$rotaryInputModifier$1.INSTANCE);
        this.rotaryInputModifier = onRotaryScrollEvent;
        this.canvasHolder = new CanvasHolder();
        LayoutNode layoutNode = new LayoutNode(false, 0, 3, (DefaultConstructorMarker) null);
        layoutNode.setMeasurePolicy(RootMeasurePolicy.INSTANCE);
        layoutNode.setDensity(getDensity());
        layoutNode.setModifier(companion2.then(semanticsModifierCore).then(onRotaryScrollEvent).then(focusManagerImpl.getModifier()).then(keyInputModifier2));
        this.root = layoutNode;
        this.rootForTest = this;
        this.semanticsOwner = new SemanticsOwner(getRoot());
        AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat = new AndroidComposeViewAccessibilityDelegateCompat(this);
        this.accessibilityDelegate = androidComposeViewAccessibilityDelegateCompat;
        this.autofillTree = new AutofillTree();
        this.dirtyLayers = new ArrayList();
        this.motionEventAdapter = new MotionEventAdapter();
        this.pointerInputEventProcessor = new PointerInputEventProcessor(getRoot());
        this.configurationChangeObserver = AndroidComposeView$configurationChangeObserver$1.INSTANCE;
        if (autofillSupported()) {
            androidAutofill = new AndroidAutofill(this, getAutofillTree());
        } else {
            androidAutofill = null;
        }
        this._autofill = androidAutofill;
        this.clipboardManager = new AndroidClipboardManager(context);
        this.accessibilityManager = new AndroidAccessibilityManager(context);
        this.snapshotObserver = new OwnerSnapshotObserver(new AndroidComposeView$snapshotObserver$1(this));
        this.measureAndLayoutDelegate = new MeasureAndLayoutDelegate(getRoot());
        ViewConfiguration viewConfiguration2 = ViewConfiguration.get(context);
        Intrinsics.checkNotNullExpressionValue(viewConfiguration2, "get(context)");
        this.viewConfiguration = new AndroidViewConfiguration(viewConfiguration2);
        this.globalPosition = IntOffsetKt.IntOffset(Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.tmpPositionArray = new int[]{0, 0};
        this.viewToWindowMatrix = Matrix.m3100constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.windowToViewMatrix = Matrix.m3100constructorimpl$default((float[]) null, 1, (DefaultConstructorMarker) null);
        this.lastMatrixRecalculationAnimationTime = -1;
        this.windowPosition = companion.m2690getInfiniteF1C5BW0();
        this.isRenderNodeCompatible = true;
        this.viewTreeOwners$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default((Object) null, (SnapshotMutationPolicy) null, 2, (Object) null);
        this.globalLayoutListener = new d(this);
        this.scrollChangedListener = new e(this);
        this.touchModeChangeListener = new f(this);
        TextInputServiceAndroid textInputServiceAndroid2 = new TextInputServiceAndroid(this);
        this.textInputServiceAndroid = textInputServiceAndroid2;
        this.textInputService = AndroidComposeView_androidKt.getTextInputServiceFactory().invoke(textInputServiceAndroid2);
        this.fontLoader = new AndroidFontResourceLoader(context);
        this.fontFamilyResolver$delegate = SnapshotStateKt.mutableStateOf(FontFamilyResolver_androidKt.createFontFamilyResolver(context), SnapshotStateKt.referentialEqualityPolicy());
        Configuration configuration = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration, "context.resources.configuration");
        this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(configuration);
        Configuration configuration2 = context.getResources().getConfiguration();
        Intrinsics.checkNotNullExpressionValue(configuration2, "context.resources.configuration");
        this.layoutDirection$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(AndroidComposeView_androidKt.getLocaleLayoutDirection(configuration2), (SnapshotMutationPolicy) null, 2, (Object) null);
        this.hapticFeedBack = new PlatformHapticFeedback(this);
        if (isInTouchMode()) {
            i11 = InputMode.Companion.m3579getTouchaOaMEAU();
        } else {
            i11 = InputMode.Companion.m3578getKeyboardaOaMEAU();
        }
        this._inputModeManager = new InputModeManagerImpl(i11, new AndroidComposeView$_inputModeManager$1(this), (DefaultConstructorMarker) null);
        this.modifierLocalManager = new ModifierLocalManager(this);
        this.textToolbar = new AndroidTextToolbar(this);
        this.layerCache = new WeakCache<>();
        this.endApplyChangesListeners = new MutableVector<>(new Function0[16], 0);
        this.resendMotionEventRunnable = new AndroidComposeView$resendMotionEventRunnable$1(this);
        this.sendHoverExitEvent = new g(this);
        this.resendMotionEventOnLayout = new AndroidComposeView$resendMotionEventOnLayout$1(this);
        int i12 = Build.VERSION.SDK_INT;
        if (i12 >= 29) {
            calculateMatrixToWindow = new CalculateMatrixToWindowApi29();
        } else {
            calculateMatrixToWindow = new CalculateMatrixToWindowApi21();
        }
        this.matrixToWindow = calculateMatrixToWindow;
        setWillNotDraw(false);
        setFocusable(true);
        if (i12 >= 26) {
            AndroidComposeViewVerificationHelperMethodsO.INSTANCE.focusable(this, 1, false);
        }
        setFocusableInTouchMode(true);
        setClipChildren(false);
        setTransitionGroup(true);
        ViewCompat.setAccessibilityDelegate(this, androidComposeViewAccessibilityDelegateCompat);
        Function1<ViewRootForTest, Unit> onViewCreatedCallback = ViewRootForTest.Companion.getOnViewCreatedCallback();
        if (onViewCreatedCallback != null) {
            onViewCreatedCallback.invoke(this);
        }
        getRoot().attach$ui_release(this);
        if (i12 >= 29) {
            AndroidComposeViewForceDarkModeQ.INSTANCE.disallowForceDark(this);
        }
        this.pointerIconService = new AndroidComposeView$pointerIconService$1(this);
    }

    private final boolean autofillSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    private final void clearChildInvalidObservations(ViewGroup viewGroup) {
        int childCount = viewGroup.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof AndroidComposeView) {
                ((AndroidComposeView) childAt).onEndApplyChanges();
            } else if (childAt instanceof ViewGroup) {
                clearChildInvalidObservations((ViewGroup) childAt);
            }
        }
    }

    private final Pair<Integer, Integer> convertMeasureSpec(int i11) {
        int mode = View.MeasureSpec.getMode(i11);
        int size = View.MeasureSpec.getSize(i11);
        if (mode == Integer.MIN_VALUE) {
            return TuplesKt.to(0, Integer.valueOf(size));
        }
        if (mode == 0) {
            return TuplesKt.to(0, Integer.MAX_VALUE);
        }
        if (mode == 1073741824) {
            return TuplesKt.to(Integer.valueOf(size), Integer.valueOf(size));
        }
        throw new IllegalStateException();
    }

    public static /* synthetic */ void e(AndroidComposeView androidComposeView, LayoutNode layoutNode, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            layoutNode = null;
        }
        androidComposeView.scheduleMeasureAndLayout(layoutNode);
    }

    public static /* synthetic */ void f(AndroidComposeView androidComposeView, MotionEvent motionEvent, int i11, long j11, boolean z11, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            z11 = true;
        }
        androidComposeView.sendSimulatedEvent(motionEvent, i11, j11, z11);
    }

    private final View findViewByAccessibilityIdRootedAtCurrentView(int i11, View view) {
        if (Build.VERSION.SDK_INT >= 29) {
            return null;
        }
        Method declaredMethod = View.class.getDeclaredMethod("getAccessibilityViewId", new Class[0]);
        declaredMethod.setAccessible(true);
        if (Intrinsics.areEqual(declaredMethod.invoke(view, new Object[0]), (Object) Integer.valueOf(i11))) {
            return view;
        }
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i12 = 0; i12 < childCount; i12++) {
            View childAt = viewGroup.getChildAt(i12);
            Intrinsics.checkNotNullExpressionValue(childAt, "currentView.getChildAt(i)");
            View findViewByAccessibilityIdRootedAtCurrentView = findViewByAccessibilityIdRootedAtCurrentView(i11, childAt);
            if (findViewByAccessibilityIdRootedAtCurrentView != null) {
                return findViewByAccessibilityIdRootedAtCurrentView;
            }
        }
        return null;
    }

    @Deprecated(message = "fontLoader is deprecated, use fontFamilyResolver", replaceWith = @ReplaceWith(expression = "fontFamilyResolver", imports = {}))
    public static /* synthetic */ void getFontLoader$annotations() {
    }

    private final int getFontWeightAdjustmentCompat(Configuration configuration) {
        if (Build.VERSION.SDK_INT >= 31) {
            return configuration.fontWeightAdjustment;
        }
        return 0;
    }

    @VisibleForTesting
    public static /* synthetic */ void getLastMatrixRecalculationAnimationTime$ui_release$annotations() {
    }

    public static /* synthetic */ void getShowLayoutBounds$annotations() {
    }

    public static /* synthetic */ void getTextInputService$annotations() {
    }

    /* access modifiers changed from: private */
    /* renamed from: globalLayoutListener$lambda-1  reason: not valid java name */
    public static final void m4796globalLayoutListener$lambda1(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        androidComposeView.updatePositionCacheAndDispatch();
    }

    /* renamed from: handleMotionEvent-8iAsVTc  reason: not valid java name */
    private final int m4797handleMotionEvent8iAsVTc(MotionEvent motionEvent) {
        boolean z11;
        removeCallbacks(this.resendMotionEventRunnable);
        try {
            recalculateWindowPosition(motionEvent);
            boolean z12 = true;
            this.forceUseMatrixCache = true;
            measureAndLayout(false);
            this.desiredPointerIcon = null;
            Trace.beginSection("AndroidOwner:onTouch");
            int actionMasked = motionEvent.getActionMasked();
            MotionEvent motionEvent2 = this.previousMotionEvent;
            if (motionEvent2 == null || motionEvent2.getToolType(0) != 3) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (motionEvent2 != null && hasChangedDevices(motionEvent, motionEvent2)) {
                if (isDevicePressEvent(motionEvent2)) {
                    this.pointerInputEventProcessor.processCancel();
                } else if (motionEvent2.getActionMasked() != 10 && z11) {
                    f(this, motionEvent2, 10, motionEvent2.getEventTime(), false, 8, (Object) null);
                }
            }
            if (motionEvent.getToolType(0) != 3) {
                z12 = false;
            }
            if (!z11 && z12 && actionMasked != 3 && actionMasked != 9 && isInBounds(motionEvent)) {
                f(this, motionEvent, 9, motionEvent.getEventTime(), false, 8, (Object) null);
            }
            if (motionEvent2 != null) {
                motionEvent2.recycle();
            }
            this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
            int r15 = m4800sendMotionEvent8iAsVTc(motionEvent);
            Trace.endSection();
            if (Build.VERSION.SDK_INT >= 24) {
                AndroidComposeViewVerificationHelperMethodsN.INSTANCE.setPointerIcon(this, this.desiredPointerIcon);
            }
            this.forceUseMatrixCache = false;
            return r15;
        } catch (Throwable th2) {
            this.forceUseMatrixCache = false;
            throw th2;
        }
    }

    private final boolean handleRotaryEvent(MotionEvent motionEvent) {
        ViewConfiguration viewConfiguration2 = ViewConfiguration.get(getContext());
        float f11 = -motionEvent.getAxisValue(26);
        RotaryScrollEvent rotaryScrollEvent = new RotaryScrollEvent(ViewConfigurationCompat.getScaledVerticalScrollFactor(viewConfiguration2, getContext()) * f11, f11 * ViewConfigurationCompat.getScaledHorizontalScrollFactor(viewConfiguration2, getContext()), motionEvent.getEventTime());
        FocusModifier activeFocusModifier$ui_release = this._focusManager.getActiveFocusModifier$ui_release();
        if (activeFocusModifier$ui_release != null) {
            return activeFocusModifier$ui_release.propagateRotaryEvent(rotaryScrollEvent);
        }
        return false;
    }

    private final boolean hasChangedDevices(MotionEvent motionEvent, MotionEvent motionEvent2) {
        if (motionEvent2.getSource() == motionEvent.getSource() && motionEvent2.getToolType(0) == motionEvent.getToolType(0)) {
            return false;
        }
        return true;
    }

    private final void invalidateLayers(LayoutNode layoutNode) {
        layoutNode.invalidateLayers$ui_release();
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            int i11 = 0;
            do {
                invalidateLayers((LayoutNode) content[i11]);
                i11++;
            } while (i11 < size);
        }
    }

    private final void invalidateLayoutNodeMeasurement(LayoutNode layoutNode) {
        int i11 = 0;
        MeasureAndLayoutDelegate.requestRemeasure$default(this.measureAndLayoutDelegate, layoutNode, false, 2, (Object) null);
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        int size = mutableVector.getSize();
        if (size > 0) {
            Object[] content = mutableVector.getContent();
            Intrinsics.checkNotNull(content, "null cannot be cast to non-null type kotlin.Array<T of androidx.compose.runtime.collection.MutableVector>");
            do {
                invalidateLayoutNodeMeasurement((LayoutNode) content[i11]);
                i11++;
            } while (i11 < size);
        }
    }

    private final boolean isBadMotionEvent(MotionEvent motionEvent) {
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        float x11 = motionEvent.getX();
        if (Float.isInfinite(x11) || Float.isNaN(x11)) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (!z11) {
            return true;
        }
        float y11 = motionEvent.getY();
        if (Float.isInfinite(y11) || Float.isNaN(y11)) {
            z12 = false;
        } else {
            z12 = true;
        }
        if (!z12) {
            return true;
        }
        float rawX = motionEvent.getRawX();
        if (Float.isInfinite(rawX) || Float.isNaN(rawX)) {
            z13 = false;
        } else {
            z13 = true;
        }
        if (!z13) {
            return true;
        }
        float rawY = motionEvent.getRawY();
        if (Float.isInfinite(rawY) || Float.isNaN(rawY)) {
            z14 = false;
        } else {
            z14 = true;
        }
        if (!z14) {
            return true;
        }
        return false;
    }

    private final boolean isDevicePressEvent(MotionEvent motionEvent) {
        int actionMasked;
        if (motionEvent.getButtonState() != 0 || (actionMasked = motionEvent.getActionMasked()) == 0 || actionMasked == 2 || actionMasked == 6) {
            return true;
        }
        return false;
    }

    private final boolean isInBounds(MotionEvent motionEvent) {
        boolean z11;
        boolean z12;
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        if (0.0f > x11 || x11 > ((float) getWidth())) {
            z11 = false;
        } else {
            z11 = true;
        }
        if (z11) {
            if (0.0f > y11 || y11 > ((float) getHeight())) {
                z12 = false;
            } else {
                z12 = true;
            }
            if (z12) {
                return true;
            }
        }
        return false;
    }

    private final boolean isPositionChanged(MotionEvent motionEvent) {
        MotionEvent motionEvent2;
        boolean z11;
        boolean z12;
        if (motionEvent.getPointerCount() != 1 || (motionEvent2 = this.previousMotionEvent) == null) {
            return true;
        }
        if (motionEvent.getRawX() == motionEvent2.getRawX()) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11) {
            return true;
        }
        if (motionEvent.getRawY() == motionEvent2.getRawY()) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return true;
        }
        return false;
    }

    private final void recalculateWindowPosition() {
        if (!this.forceUseMatrixCache) {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            if (currentAnimationTimeMillis != this.lastMatrixRecalculationAnimationTime) {
                this.lastMatrixRecalculationAnimationTime = currentAnimationTimeMillis;
                recalculateWindowViewTransforms();
                ViewParent parent = getParent();
                View view = this;
                while (parent instanceof ViewGroup) {
                    view = (View) parent;
                    parent = ((ViewGroup) view).getParent();
                }
                view.getLocationOnScreen(this.tmpPositionArray);
                int[] iArr = this.tmpPositionArray;
                view.getLocationInWindow(iArr);
                int[] iArr2 = this.tmpPositionArray;
                this.windowPosition = OffsetKt.Offset(((float) iArr[0]) - ((float) iArr2[0]), ((float) iArr[1]) - ((float) iArr2[1]));
            }
        }
    }

    private final void recalculateWindowViewTransforms() {
        this.matrixToWindow.m4822calculateMatrixToWindowEL8BTi8(this, this.viewToWindowMatrix);
        InvertMatrixKt.m4841invertToJiSxe2E(this.viewToWindowMatrix, this.windowToViewMatrix);
    }

    private final void scheduleMeasureAndLayout(LayoutNode layoutNode) {
        if (!isLayoutRequested() && isAttachedToWindow()) {
            if (this.wasMeasuredWithMultipleConstraints && layoutNode != null) {
                while (layoutNode != null && layoutNode.getMeasuredByParent$ui_release() == LayoutNode.UsageByParent.InMeasureBlock) {
                    layoutNode = layoutNode.getParent$ui_release();
                }
                if (layoutNode == getRoot()) {
                    requestLayout();
                    return;
                }
            }
            if (getWidth() == 0 || getHeight() == 0) {
                requestLayout();
            } else {
                invalidate();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: scrollChangedListener$lambda-2  reason: not valid java name */
    public static final void m4798scrollChangedListener$lambda2(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        androidComposeView.updatePositionCacheAndDispatch();
    }

    /* access modifiers changed from: private */
    /* renamed from: sendHoverExitEvent$lambda-5  reason: not valid java name */
    public static final void m4799sendHoverExitEvent$lambda5(AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        boolean z11 = false;
        androidComposeView.hoverExitReceived = false;
        MotionEvent motionEvent = androidComposeView.previousMotionEvent;
        Intrinsics.checkNotNull(motionEvent);
        if (motionEvent.getActionMasked() == 10) {
            z11 = true;
        }
        if (z11) {
            androidComposeView.m4800sendMotionEvent8iAsVTc(motionEvent);
            return;
        }
        throw new IllegalStateException("The ACTION_HOVER_EXIT event was not cleared.".toString());
    }

    /* renamed from: sendMotionEvent-8iAsVTc  reason: not valid java name */
    private final int m4800sendMotionEvent8iAsVTc(MotionEvent motionEvent) {
        PointerInputEventData pointerInputEventData;
        if (this.keyboardModifiersRequireUpdate) {
            this.keyboardModifiersRequireUpdate = false;
            this._windowInfo.m4893setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m4356constructorimpl(motionEvent.getMetaState()));
        }
        PointerInputEvent convertToPointerInputEvent$ui_release = this.motionEventAdapter.convertToPointerInputEvent$ui_release(motionEvent, this);
        if (convertToPointerInputEvent$ui_release != null) {
            List<PointerInputEventData> pointers = convertToPointerInputEvent$ui_release.getPointers();
            ListIterator<PointerInputEventData> listIterator = pointers.listIterator(pointers.size());
            while (true) {
                if (!listIterator.hasPrevious()) {
                    pointerInputEventData = null;
                    break;
                }
                pointerInputEventData = listIterator.previous();
                if (pointerInputEventData.getDown()) {
                    break;
                }
            }
            PointerInputEventData pointerInputEventData2 = pointerInputEventData;
            if (pointerInputEventData2 != null) {
                this.lastDownPointerPosition = pointerInputEventData2.m4320getPositionF1C5BW0();
            }
            int r02 = this.pointerInputEventProcessor.m4325processBIzXfog(convertToPointerInputEvent$ui_release, this, isInBounds(motionEvent));
            int actionMasked = motionEvent.getActionMasked();
            if ((actionMasked != 0 && actionMasked != 5) || ProcessResult.m4381getDispatchedToAPointerInputModifierimpl(r02)) {
                return r02;
            }
            this.motionEventAdapter.endStream(motionEvent.getPointerId(motionEvent.getActionIndex()));
            return r02;
        }
        this.pointerInputEventProcessor.processCancel();
        return PointerInputEventProcessorKt.ProcessResult(false, false);
    }

    /* access modifiers changed from: private */
    public final void sendSimulatedEvent(MotionEvent motionEvent, int i11, long j11, boolean z11) {
        int i12;
        int i13;
        long j12;
        int i14;
        MotionEvent motionEvent2 = motionEvent;
        int i15 = i11;
        int actionMasked = motionEvent.getActionMasked();
        int i16 = -1;
        if (actionMasked != 1) {
            if (actionMasked == 6) {
                i16 = motionEvent.getActionIndex();
            }
        } else if (!(i15 == 9 || i15 == 10)) {
            i16 = 0;
        }
        int pointerCount = motionEvent.getPointerCount();
        if (i16 >= 0) {
            i12 = 1;
        } else {
            i12 = 0;
        }
        int i17 = pointerCount - i12;
        if (i17 != 0) {
            MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[i17];
            for (int i18 = 0; i18 < i17; i18++) {
                pointerPropertiesArr[i18] = new MotionEvent.PointerProperties();
            }
            MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[i17];
            for (int i19 = 0; i19 < i17; i19++) {
                pointerCoordsArr[i19] = new MotionEvent.PointerCoords();
            }
            for (int i21 = 0; i21 < i17; i21++) {
                if (i16 < 0 || i21 < i16) {
                    i14 = 0;
                } else {
                    i14 = 1;
                }
                int i22 = i14 + i21;
                motionEvent2.getPointerProperties(i22, pointerPropertiesArr[i21]);
                MotionEvent.PointerCoords pointerCoords = pointerCoordsArr[i21];
                motionEvent2.getPointerCoords(i22, pointerCoords);
                long r11 = m4805localToScreenMKHz9U(OffsetKt.Offset(pointerCoords.x, pointerCoords.y));
                pointerCoords.x = Offset.m2676getXimpl(r11);
                pointerCoords.y = Offset.m2677getYimpl(r11);
            }
            if (z11) {
                i13 = 0;
            } else {
                i13 = motionEvent.getButtonState();
            }
            if (motionEvent.getDownTime() == motionEvent.getEventTime()) {
                j12 = j11;
            } else {
                j12 = motionEvent.getDownTime();
            }
            MotionEvent obtain = MotionEvent.obtain(j12, j11, i11, i17, pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), i13, motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags());
            MotionEventAdapter motionEventAdapter2 = this.motionEventAdapter;
            Intrinsics.checkNotNullExpressionValue(obtain, "event");
            PointerInputEvent convertToPointerInputEvent$ui_release = motionEventAdapter2.convertToPointerInputEvent$ui_release(obtain, this);
            Intrinsics.checkNotNull(convertToPointerInputEvent$ui_release);
            this.pointerInputEventProcessor.m4325processBIzXfog(convertToPointerInputEvent$ui_release, this, true);
            obtain.recycle();
        }
    }

    private void setFontFamilyResolver(FontFamily.Resolver resolver) {
        this.fontFamilyResolver$delegate.setValue(resolver);
    }

    private void setLayoutDirection(LayoutDirection layoutDirection) {
        this.layoutDirection$delegate.setValue(layoutDirection);
    }

    private final void setViewTreeOwners(ViewTreeOwners viewTreeOwners) {
        this.viewTreeOwners$delegate.setValue(viewTreeOwners);
    }

    /* access modifiers changed from: private */
    /* renamed from: touchModeChangeListener$lambda-3  reason: not valid java name */
    public static final void m4801touchModeChangeListener$lambda3(AndroidComposeView androidComposeView, boolean z11) {
        int i11;
        Intrinsics.checkNotNullParameter(androidComposeView, "this$0");
        InputModeManagerImpl inputModeManagerImpl = androidComposeView._inputModeManager;
        if (z11) {
            i11 = InputMode.Companion.m3579getTouchaOaMEAU();
        } else {
            i11 = InputMode.Companion.m3578getKeyboardaOaMEAU();
        }
        inputModeManagerImpl.m3584setInputModeiuPiT84(i11);
        androidComposeView._focusManager.fetchUpdatedFocusProperties();
    }

    private final void updatePositionCacheAndDispatch() {
        getLocationOnScreen(this.tmpPositionArray);
        long j11 = this.globalPosition;
        int r22 = IntOffset.m5588component1impl(j11);
        int r02 = IntOffset.m5589component2impl(j11);
        int[] iArr = this.tmpPositionArray;
        boolean z11 = false;
        int i11 = iArr[0];
        if (!(r22 == i11 && r02 == iArr[1])) {
            this.globalPosition = IntOffsetKt.IntOffset(i11, iArr[1]);
            if (!(r22 == Integer.MAX_VALUE || r02 == Integer.MAX_VALUE)) {
                getRoot().getLayoutDelegate$ui_release().getMeasurePassDelegate$ui_release().notifyChildrenUsingCoordinatesWhilePlacing();
                z11 = true;
            }
        }
        this.measureAndLayoutDelegate.dispatchOnPositionedCallbacks(z11);
    }

    public final void addAndroidView(@NotNull AndroidViewHolder androidViewHolder, @NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "view");
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        getAndroidViewsHandler$ui_release().getHolderToLayoutNode().put(androidViewHolder, layoutNode);
        getAndroidViewsHandler$ui_release().addView(androidViewHolder);
        getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().put(layoutNode, androidViewHolder);
        ViewCompat.setImportantForAccessibility(androidViewHolder, 1);
        ViewCompat.setAccessibilityDelegate(androidViewHolder, new AndroidComposeView$addAndroidView$1(layoutNode, this, this));
    }

    public void autofill(@NotNull SparseArray<AutofillValue> sparseArray) {
        AndroidAutofill androidAutofill;
        Intrinsics.checkNotNullParameter(sparseArray, "values");
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AndroidAutofill_androidKt.performAutofill(androidAutofill, sparseArray);
        }
    }

    @Nullable
    public final Object boundsUpdatesEventLoop(@NotNull Continuation<? super Unit> continuation) {
        Object boundsUpdatesEventLoop = this.accessibilityDelegate.boundsUpdatesEventLoop(continuation);
        return boundsUpdatesEventLoop == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? boundsUpdatesEventLoop : Unit.INSTANCE;
    }

    /* renamed from: calculateLocalPosition-MK-Hz9U  reason: not valid java name */
    public long m4802calculateLocalPositionMKHz9U(long j11) {
        recalculateWindowPosition();
        return Matrix.m3106mapMKHz9U(this.windowToViewMatrix, j11);
    }

    /* renamed from: calculatePositionInWindow-MK-Hz9U  reason: not valid java name */
    public long m4803calculatePositionInWindowMKHz9U(long j11) {
        recalculateWindowPosition();
        return Matrix.m3106mapMKHz9U(this.viewToWindowMatrix, j11);
    }

    public boolean canScrollHorizontally(int i11) {
        return this.accessibilityDelegate.m4813canScroll0AR0LA0$ui_release(false, i11, this.lastDownPointerPosition);
    }

    public boolean canScrollVertically(int i11) {
        return this.accessibilityDelegate.m4813canScroll0AR0LA0$ui_release(true, i11, this.lastDownPointerPosition);
    }

    @NotNull
    public OwnedLayer createLayer(@NotNull Function1<? super Canvas, Unit> function1, @NotNull Function0<Unit> function0) {
        DrawChildContainer drawChildContainer;
        Intrinsics.checkNotNullParameter(function1, "drawBlock");
        Intrinsics.checkNotNullParameter(function0, "invalidateParentLayer");
        OwnedLayer pop = this.layerCache.pop();
        if (pop != null) {
            pop.reuseLayer(function1, function0);
            return pop;
        }
        if (isHardwareAccelerated() && this.isRenderNodeCompatible) {
            try {
                return new RenderNodeLayer(this, function1, function0);
            } catch (Throwable unused) {
                this.isRenderNodeCompatible = false;
            }
        }
        if (this.viewLayersContainer == null) {
            ViewLayer.Companion companion = ViewLayer.Companion;
            if (!companion.getHasRetrievedMethod()) {
                companion.updateDisplayList(new View(getContext()));
            }
            if (companion.getShouldUseDispatchDraw()) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                drawChildContainer = new DrawChildContainer(context);
            } else {
                Context context2 = getContext();
                Intrinsics.checkNotNullExpressionValue(context2, "context");
                drawChildContainer = new ViewLayerContainer(context2);
            }
            this.viewLayersContainer = drawChildContainer;
            addView(drawChildContainer);
        }
        DrawChildContainer drawChildContainer2 = this.viewLayersContainer;
        Intrinsics.checkNotNull(drawChildContainer2);
        return new ViewLayer(this, drawChildContainer2, function1, function0);
    }

    public void dispatchDraw(@NotNull android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        if (!isAttachedToWindow()) {
            invalidateLayers(getRoot());
        }
        l0.d.d(this, false, 1, (Object) null);
        this.isDrawingContent = true;
        CanvasHolder canvasHolder2 = this.canvasHolder;
        android.graphics.Canvas internalCanvas = canvasHolder2.getAndroidCanvas().getInternalCanvas();
        canvasHolder2.getAndroidCanvas().setInternalCanvas(canvas);
        getRoot().draw$ui_release(canvasHolder2.getAndroidCanvas());
        canvasHolder2.getAndroidCanvas().setInternalCanvas(internalCanvas);
        if (!this.dirtyLayers.isEmpty()) {
            int size = this.dirtyLayers.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.dirtyLayers.get(i11).updateDisplayList();
            }
        }
        if (ViewLayer.Companion.getShouldUseDispatchDraw()) {
            int save = canvas.save();
            canvas.clipRect(0.0f, 0.0f, 0.0f, 0.0f);
            super.dispatchDraw(canvas);
            canvas.restoreToCount(save);
        }
        this.dirtyLayers.clear();
        this.isDrawingContent = false;
        List<OwnedLayer> list = this.postponedDirtyLayers;
        if (list != null) {
            Intrinsics.checkNotNull(list);
            this.dirtyLayers.addAll(list);
            list.clear();
        }
    }

    public boolean dispatchGenericMotionEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (motionEvent.getActionMasked() != 8) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        if (motionEvent.isFromSource(4194304)) {
            return handleRotaryEvent(motionEvent);
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return super.dispatchGenericMotionEvent(motionEvent);
        }
        return ProcessResult.m4381getDispatchedToAPointerInputModifierimpl(m4797handleMotionEvent8iAsVTc(motionEvent));
    }

    public boolean dispatchHoverEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            this.sendHoverExitEvent.run();
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.isFromSource(InputDeviceCompat.SOURCE_TOUCHSCREEN) && motionEvent.getToolType(0) == 1) {
            return this.accessibilityDelegate.dispatchHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 7) {
            if (actionMasked == 10 && isInBounds(motionEvent)) {
                if (motionEvent.getToolType(0) != 3) {
                    MotionEvent motionEvent2 = this.previousMotionEvent;
                    if (motionEvent2 != null) {
                        motionEvent2.recycle();
                    }
                    this.previousMotionEvent = MotionEvent.obtainNoHistory(motionEvent);
                    this.hoverExitReceived = true;
                    post(this.sendHoverExitEvent);
                    return false;
                } else if (motionEvent.getButtonState() != 0) {
                    return false;
                }
            }
        } else if (!isPositionChanged(motionEvent)) {
            return false;
        }
        return ProcessResult.m4381getDispatchedToAPointerInputModifierimpl(m4797handleMotionEvent8iAsVTc(motionEvent));
    }

    public boolean dispatchKeyEvent(@NotNull android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "event");
        if (!isFocused()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        this._windowInfo.m4893setKeyboardModifiers5xRPYO0(PointerKeyboardModifiers.m4356constructorimpl(keyEvent.getMetaState()));
        return m4808sendKeyEventZmokQxo(KeyEvent.m4167constructorimpl(keyEvent));
    }

    public boolean dispatchTouchEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "motionEvent");
        if (this.hoverExitReceived) {
            removeCallbacks(this.sendHoverExitEvent);
            MotionEvent motionEvent2 = this.previousMotionEvent;
            Intrinsics.checkNotNull(motionEvent2);
            if (motionEvent.getActionMasked() != 0 || hasChangedDevices(motionEvent, motionEvent2)) {
                this.sendHoverExitEvent.run();
            } else {
                this.hoverExitReceived = false;
            }
        }
        if (isBadMotionEvent(motionEvent) || !isAttachedToWindow()) {
            return false;
        }
        if (motionEvent.getActionMasked() == 2 && !isPositionChanged(motionEvent)) {
            return false;
        }
        int r42 = m4797handleMotionEvent8iAsVTc(motionEvent);
        if (ProcessResult.m4380getAnyMovementConsumedimpl(r42)) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        return ProcessResult.m4381getDispatchedToAPointerInputModifierimpl(r42);
    }

    public final void drawAndroidView(@NotNull AndroidViewHolder androidViewHolder, @NotNull android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "view");
        Intrinsics.checkNotNullParameter(canvas, "canvas");
        getAndroidViewsHandler$ui_release().drawView(androidViewHolder, canvas);
    }

    @Nullable
    public final View findViewByAccessibilityIdTraversal(int i11) {
        try {
            if (Build.VERSION.SDK_INT < 29) {
                return findViewByAccessibilityIdRootedAtCurrentView(i11, this);
            }
            Method declaredMethod = View.class.getDeclaredMethod("findViewByAccessibilityIdTraversal", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(this, new Object[]{Integer.valueOf(i11)});
            if (invoke instanceof View) {
                return (View) invoke;
            }
            return null;
        } catch (NoSuchMethodException unused) {
            return null;
        }
    }

    public void forceMeasureTheSubtree(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.forceMeasureTheSubtree(layoutNode);
    }

    @NotNull
    public final AndroidViewsHandler getAndroidViewsHandler$ui_release() {
        if (this._androidViewsHandler == null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            AndroidViewsHandler androidViewsHandler = new AndroidViewsHandler(context);
            this._androidViewsHandler = androidViewsHandler;
            addView(androidViewsHandler);
        }
        AndroidViewsHandler androidViewsHandler2 = this._androidViewsHandler;
        Intrinsics.checkNotNull(androidViewsHandler2);
        return androidViewsHandler2;
    }

    @Nullable
    public Autofill getAutofill() {
        return this._autofill;
    }

    @NotNull
    public AutofillTree getAutofillTree() {
        return this.autofillTree;
    }

    @NotNull
    public final Function1<Configuration, Unit> getConfigurationChangeObserver() {
        return this.configurationChangeObserver;
    }

    @NotNull
    public Density getDensity() {
        return this.density;
    }

    @Nullable
    /* renamed from: getFocusDirection-P8AzH3I  reason: not valid java name */
    public FocusDirection m4804getFocusDirectionP8AzH3I(@NotNull android.view.KeyEvent keyEvent) {
        boolean z11;
        boolean z12;
        int i11;
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        long r02 = KeyEvent_androidKt.m4183getKeyZmokQxo(keyEvent);
        Key.Companion companion = Key.Companion;
        if (Key.m3588equalsimpl0(r02, companion.m4111getTabEK5gGoQ())) {
            if (KeyEvent_androidKt.m4189isShiftPressedZmokQxo(keyEvent)) {
                i11 = FocusDirection.Companion.m2615getPreviousdhqQ8s();
            } else {
                i11 = FocusDirection.Companion.m2613getNextdhqQ8s();
            }
            return FocusDirection.m2597boximpl(i11);
        } else if (Key.m3588equalsimpl0(r02, companion.m3952getDirectionRightEK5gGoQ())) {
            return FocusDirection.m2597boximpl(FocusDirection.Companion.m2616getRightdhqQ8s());
        } else {
            if (Key.m3588equalsimpl0(r02, companion.m3951getDirectionLeftEK5gGoQ())) {
                return FocusDirection.m2597boximpl(FocusDirection.Companion.m2612getLeftdhqQ8s());
            }
            if (Key.m3588equalsimpl0(r02, companion.m3953getDirectionUpEK5gGoQ())) {
                return FocusDirection.m2597boximpl(FocusDirection.Companion.m2617getUpdhqQ8s());
            }
            if (Key.m3588equalsimpl0(r02, companion.m3948getDirectionDownEK5gGoQ())) {
                return FocusDirection.m2597boximpl(FocusDirection.Companion.m2608getDowndhqQ8s());
            }
            boolean z13 = true;
            if (Key.m3588equalsimpl0(r02, companion.m3947getDirectionCenterEK5gGoQ())) {
                z11 = true;
            } else {
                z11 = Key.m3588equalsimpl0(r02, companion.m3961getEnterEK5gGoQ());
            }
            if (z11) {
                z12 = true;
            } else {
                z12 = Key.m3588equalsimpl0(r02, companion.m4053getNumPadEnterEK5gGoQ());
            }
            if (z12) {
                return FocusDirection.m2597boximpl(FocusDirection.Companion.m2609getEnterdhqQ8s());
            }
            if (!Key.m3588equalsimpl0(r02, companion.m3890getBackEK5gGoQ())) {
                z13 = Key.m3588equalsimpl0(r02, companion.m3964getEscapeEK5gGoQ());
            }
            if (z13) {
                return FocusDirection.m2597boximpl(FocusDirection.Companion.m2610getExitdhqQ8s());
            }
            return null;
        }
    }

    @NotNull
    public FocusManager getFocusManager() {
        return this._focusManager;
    }

    public void getFocusedRect(@NotNull Rect rect) {
        Unit unit;
        androidx.compose.ui.geometry.Rect focusRect;
        Intrinsics.checkNotNullParameter(rect, "rect");
        FocusModifier activeFocusModifier$ui_release = this._focusManager.getActiveFocusModifier$ui_release();
        if (activeFocusModifier$ui_release == null || (focusRect = FocusTraversalKt.focusRect(activeFocusModifier$ui_release)) == null) {
            unit = null;
        } else {
            rect.left = MathKt__MathJVMKt.roundToInt(focusRect.getLeft());
            rect.top = MathKt__MathJVMKt.roundToInt(focusRect.getTop());
            rect.right = MathKt__MathJVMKt.roundToInt(focusRect.getRight());
            rect.bottom = MathKt__MathJVMKt.roundToInt(focusRect.getBottom());
            unit = Unit.INSTANCE;
        }
        if (unit == null) {
            super.getFocusedRect(rect);
        }
    }

    @NotNull
    public FontFamily.Resolver getFontFamilyResolver() {
        return (FontFamily.Resolver) this.fontFamilyResolver$delegate.getValue();
    }

    @NotNull
    public Font.ResourceLoader getFontLoader() {
        return this.fontLoader;
    }

    @NotNull
    public HapticFeedback getHapticFeedBack() {
        return this.hapticFeedBack;
    }

    public boolean getHasPendingMeasureOrLayout() {
        return this.measureAndLayoutDelegate.getHasPendingMeasureOrLayout();
    }

    @NotNull
    public InputModeManager getInputModeManager() {
        return this._inputModeManager;
    }

    public final long getLastMatrixRecalculationAnimationTime$ui_release() {
        return this.lastMatrixRecalculationAnimationTime;
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return (LayoutDirection) this.layoutDirection$delegate.getValue();
    }

    public long getMeasureIteration() {
        return this.measureAndLayoutDelegate.getMeasureIteration();
    }

    @NotNull
    public ModifierLocalManager getModifierLocalManager() {
        return this.modifierLocalManager;
    }

    @NotNull
    public PointerIconService getPointerIconService() {
        return this.pointerIconService;
    }

    @NotNull
    public LayoutNode getRoot() {
        return this.root;
    }

    @NotNull
    public RootForTest getRootForTest() {
        return this.rootForTest;
    }

    @NotNull
    public SemanticsOwner getSemanticsOwner() {
        return this.semanticsOwner;
    }

    @NotNull
    public LayoutNodeDrawScope getSharedDrawScope() {
        return this.sharedDrawScope;
    }

    public boolean getShowLayoutBounds() {
        return this.showLayoutBounds;
    }

    @NotNull
    public OwnerSnapshotObserver getSnapshotObserver() {
        return this.snapshotObserver;
    }

    @NotNull
    public TextInputService getTextInputService() {
        return this.textInputService;
    }

    @NotNull
    public TextToolbar getTextToolbar() {
        return this.textToolbar;
    }

    @NotNull
    public View getView() {
        return this;
    }

    @NotNull
    public ViewConfiguration getViewConfiguration() {
        return this.viewConfiguration;
    }

    @Nullable
    public final ViewTreeOwners getViewTreeOwners() {
        return (ViewTreeOwners) this.viewTreeOwners$delegate.getValue();
    }

    @NotNull
    public WindowInfo getWindowInfo() {
        return this._windowInfo;
    }

    public void invalidateDescendants() {
        invalidateLayers(getRoot());
    }

    public boolean isLifecycleInResumedState() {
        Lifecycle.State state;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null) {
            state = null;
        } else {
            state = lifecycle.getCurrentState();
        }
        if (state == Lifecycle.State.RESUMED) {
            return true;
        }
        return false;
    }

    @Nullable
    public final Object keyboardVisibilityEventLoop(@NotNull Continuation<? super Unit> continuation) {
        Object textInputCommandEventLoop = this.textInputServiceAndroid.textInputCommandEventLoop(continuation);
        return textInputCommandEventLoop == IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED() ? textInputCommandEventLoop : Unit.INSTANCE;
    }

    /* renamed from: localToScreen-MK-Hz9U  reason: not valid java name */
    public long m4805localToScreenMKHz9U(long j11) {
        recalculateWindowPosition();
        long r42 = Matrix.m3106mapMKHz9U(this.viewToWindowMatrix, j11);
        return OffsetKt.Offset(Offset.m2676getXimpl(r42) + Offset.m2676getXimpl(this.windowPosition), Offset.m2677getYimpl(r42) + Offset.m2677getYimpl(this.windowPosition));
    }

    public void measureAndLayout(boolean z11) {
        Function0<Unit> function0;
        Trace.beginSection("AndroidOwner:measureAndLayout");
        if (z11) {
            try {
                function0 = this.resendMotionEventOnLayout;
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        } else {
            function0 = null;
        }
        if (this.measureAndLayoutDelegate.measureAndLayout(function0)) {
            requestLayout();
        }
        MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, (Object) null);
        Unit unit = Unit.INSTANCE;
        Trace.endSection();
    }

    /* renamed from: measureAndLayout-0kLqBqw  reason: not valid java name */
    public void m4806measureAndLayout0kLqBqw(@NotNull LayoutNode layoutNode, long j11) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        Trace.beginSection("AndroidOwner:measureAndLayout");
        try {
            this.measureAndLayoutDelegate.m4695measureAndLayout0kLqBqw(layoutNode, j11);
            MeasureAndLayoutDelegate.dispatchOnPositionedCallbacks$default(this.measureAndLayoutDelegate, false, 1, (Object) null);
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final void notifyLayerIsDirty$ui_release(@NotNull OwnedLayer ownedLayer, boolean z11) {
        Intrinsics.checkNotNullParameter(ownedLayer, "layer");
        if (!z11) {
            if (!this.isDrawingContent && !this.dirtyLayers.remove(ownedLayer)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
        } else if (!this.isDrawingContent) {
            this.dirtyLayers.add(ownedLayer);
        } else {
            List list = this.postponedDirtyLayers;
            if (list == null) {
                list = new ArrayList();
                this.postponedDirtyLayers = list;
            }
            list.add(ownedLayer);
        }
    }

    public void onAttach(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
    }

    public void onAttachedToWindow() {
        boolean z11;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        AndroidAutofill androidAutofill;
        super.onAttachedToWindow();
        invalidateLayoutNodeMeasurement(getRoot());
        invalidateLayers(getRoot());
        getSnapshotObserver().startObserving$ui_release();
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.register(androidAutofill);
        }
        LifecycleOwner lifecycleOwner2 = ViewTreeLifecycleOwner.get(this);
        SavedStateRegistryOwner savedStateRegistryOwner = ViewTreeSavedStateRegistryOwner.get(this);
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners == null || !(lifecycleOwner2 == null || savedStateRegistryOwner == null || (lifecycleOwner2 == viewTreeOwners.getLifecycleOwner() && savedStateRegistryOwner == viewTreeOwners.getLifecycleOwner()))) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (lifecycleOwner2 == null) {
                throw new IllegalStateException("Composed into the View which doesn't propagate ViewTreeLifecycleOwner!");
            } else if (savedStateRegistryOwner != null) {
                if (!(viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
                    lifecycle.removeObserver(this);
                }
                lifecycleOwner2.getLifecycle().addObserver(this);
                ViewTreeOwners viewTreeOwners2 = new ViewTreeOwners(lifecycleOwner2, savedStateRegistryOwner);
                setViewTreeOwners(viewTreeOwners2);
                Function1<? super ViewTreeOwners, Unit> function1 = this.onViewTreeOwnersAvailable;
                if (function1 != null) {
                    function1.invoke(viewTreeOwners2);
                }
                this.onViewTreeOwnersAvailable = null;
            } else {
                throw new IllegalStateException("Composed into the View which doesn't propagateViewTreeSavedStateRegistryOwner!");
            }
        }
        ViewTreeOwners viewTreeOwners3 = getViewTreeOwners();
        Intrinsics.checkNotNull(viewTreeOwners3);
        viewTreeOwners3.getLifecycleOwner().getLifecycle().addObserver(this);
        getViewTreeObserver().addOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().addOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().addOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    public boolean onCheckIsTextEditor() {
        return this.textInputServiceAndroid.isEditorFocused();
    }

    public void onConfigurationChanged(@NotNull Configuration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "newConfig");
        super.onConfigurationChanged(configuration);
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        this.density = AndroidDensity_androidKt.Density(context);
        if (getFontWeightAdjustmentCompat(configuration) != this.currentFontWeightAdjustment) {
            this.currentFontWeightAdjustment = getFontWeightAdjustmentCompat(configuration);
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            setFontFamilyResolver(FontFamilyResolver_androidKt.createFontFamilyResolver(context2));
        }
        this.configurationChangeObserver.invoke(configuration);
    }

    public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
        a.a(this, lifecycleOwner);
    }

    @Nullable
    public InputConnection onCreateInputConnection(@NotNull EditorInfo editorInfo) {
        Intrinsics.checkNotNullParameter(editorInfo, "outAttrs");
        return this.textInputServiceAndroid.createInputConnection(editorInfo);
    }

    public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
        a.b(this, lifecycleOwner);
    }

    public void onDetach(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "node");
        this.measureAndLayoutDelegate.onNodeDetached(layoutNode);
        requestClearInvalidObservations();
    }

    public void onDetachedFromWindow() {
        AndroidAutofill androidAutofill;
        LifecycleOwner lifecycleOwner;
        Lifecycle lifecycle;
        super.onDetachedFromWindow();
        getSnapshotObserver().stopObserving$ui_release();
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (!(viewTreeOwners == null || (lifecycleOwner = viewTreeOwners.getLifecycleOwner()) == null || (lifecycle = lifecycleOwner.getLifecycle()) == null)) {
            lifecycle.removeObserver(this);
        }
        if (autofillSupported() && (androidAutofill = this._autofill) != null) {
            AutofillCallback.INSTANCE.unregister(androidAutofill);
        }
        getViewTreeObserver().removeOnGlobalLayoutListener(this.globalLayoutListener);
        getViewTreeObserver().removeOnScrollChangedListener(this.scrollChangedListener);
        getViewTreeObserver().removeOnTouchModeChangeListener(this.touchModeChangeListener);
    }

    public void onDraw(@NotNull android.graphics.Canvas canvas) {
        Intrinsics.checkNotNullParameter(canvas, "canvas");
    }

    public void onEndApplyChanges() {
        if (this.observationClearRequested) {
            getSnapshotObserver().clearInvalidObservations$ui_release();
            this.observationClearRequested = false;
        }
        AndroidViewsHandler androidViewsHandler = this._androidViewsHandler;
        if (androidViewsHandler != null) {
            clearChildInvalidObservations(androidViewsHandler);
        }
        while (this.endApplyChangesListeners.isNotEmpty()) {
            int size = this.endApplyChangesListeners.getSize();
            for (int i11 = 0; i11 < size; i11++) {
                Function0 function0 = (Function0) this.endApplyChangesListeners.getContent()[i11];
                this.endApplyChangesListeners.set(i11, null);
                if (function0 != null) {
                    function0.invoke();
                }
            }
            this.endApplyChangesListeners.removeRange(0, size);
        }
    }

    public void onFocusChanged(boolean z11, int i11, @Nullable Rect rect) {
        super.onFocusChanged(z11, i11, rect);
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Owner FocusChanged(");
        sb2.append(z11);
        sb2.append(')');
        FocusManagerImpl focusManagerImpl = this._focusManager;
        if (z11) {
            focusManagerImpl.takeFocus();
        } else {
            focusManagerImpl.releaseFocus();
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        this.measureAndLayoutDelegate.measureAndLayout(this.resendMotionEventOnLayout);
        this.onMeasureConstraints = null;
        updatePositionCacheAndDispatch();
        if (this._androidViewsHandler != null) {
            getAndroidViewsHandler$ui_release().layout(0, 0, i13 - i11, i14 - i12);
        }
    }

    public void onLayoutChange(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.accessibilityDelegate.onLayoutChange$ui_release(layoutNode);
    }

    public void onMeasure(int i11, int i12) {
        Trace.beginSection("AndroidOwner:onMeasure");
        try {
            if (!isAttachedToWindow()) {
                invalidateLayoutNodeMeasurement(getRoot());
            }
            Pair<Integer, Integer> convertMeasureSpec = convertMeasureSpec(i11);
            int intValue = convertMeasureSpec.component1().intValue();
            int intValue2 = convertMeasureSpec.component2().intValue();
            Pair<Integer, Integer> convertMeasureSpec2 = convertMeasureSpec(i12);
            long Constraints = ConstraintsKt.Constraints(intValue, intValue2, convertMeasureSpec2.component1().intValue(), convertMeasureSpec2.component2().intValue());
            Constraints constraints = this.onMeasureConstraints;
            boolean z11 = false;
            if (constraints == null) {
                this.onMeasureConstraints = Constraints.m5410boximpl(Constraints);
                this.wasMeasuredWithMultipleConstraints = false;
            } else {
                if (constraints != null) {
                    z11 = Constraints.m5415equalsimpl0(constraints.m5428unboximpl(), Constraints);
                }
                if (!z11) {
                    this.wasMeasuredWithMultipleConstraints = true;
                }
            }
            this.measureAndLayoutDelegate.m4696updateRootConstraintsBRTryo0(Constraints);
            this.measureAndLayoutDelegate.measureOnly();
            setMeasuredDimension(getRoot().getWidth(), getRoot().getHeight());
            if (this._androidViewsHandler != null) {
                getAndroidViewsHandler$ui_release().measure(View.MeasureSpec.makeMeasureSpec(getRoot().getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(getRoot().getHeight(), 1073741824));
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
        a.c(this, lifecycleOwner);
    }

    public void onProvideAutofillVirtualStructure(@Nullable ViewStructure viewStructure, int i11) {
        AndroidAutofill androidAutofill;
        if (autofillSupported() && viewStructure != null && (androidAutofill = this._autofill) != null) {
            AndroidAutofill_androidKt.populateViewStructure(androidAutofill, viewStructure);
        }
    }

    public void onRequestMeasure(@NotNull LayoutNode layoutNode, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (z11) {
            if (this.measureAndLayoutDelegate.requestLookaheadRemeasure(layoutNode, z12)) {
                scheduleMeasureAndLayout(layoutNode);
            }
        } else if (this.measureAndLayoutDelegate.requestRemeasure(layoutNode, z12)) {
            scheduleMeasureAndLayout(layoutNode);
        }
    }

    public void onRequestRelayout(@NotNull LayoutNode layoutNode, boolean z11, boolean z12) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        if (z11) {
            if (this.measureAndLayoutDelegate.requestLookaheadRelayout(layoutNode, z12)) {
                e(this, (LayoutNode) null, 1, (Object) null);
            }
        } else if (this.measureAndLayoutDelegate.requestRelayout(layoutNode, z12)) {
            e(this, (LayoutNode) null, 1, (Object) null);
        }
    }

    public void onResume(@NotNull LifecycleOwner lifecycleOwner) {
        Intrinsics.checkNotNullParameter(lifecycleOwner, "owner");
        setShowLayoutBounds(Companion.getIsShowingLayoutBounds());
    }

    public void onRtlPropertiesChanged(int i11) {
        if (this.superclassInitComplete) {
            LayoutDirection access$layoutDirectionFromInt = AndroidComposeView_androidKt.layoutDirectionFromInt(i11);
            setLayoutDirection(access$layoutDirectionFromInt);
            this._focusManager.setLayoutDirection(access$layoutDirectionFromInt);
        }
    }

    public void onSemanticsChange() {
        this.accessibilityDelegate.onSemanticsChange$ui_release();
    }

    public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
        a.e(this, lifecycleOwner);
    }

    public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
        a.f(this, lifecycleOwner);
    }

    public void onWindowFocusChanged(boolean z11) {
        boolean access$getIsShowingLayoutBounds;
        this._windowInfo.setWindowFocused(z11);
        this.keyboardModifiersRequireUpdate = true;
        super.onWindowFocusChanged(z11);
        if (z11 && getShowLayoutBounds() != (access$getIsShowingLayoutBounds = Companion.getIsShowingLayoutBounds())) {
            setShowLayoutBounds(access$getIsShowingLayoutBounds);
            invalidateDescendants();
        }
    }

    public final boolean recycle$ui_release(@NotNull OwnedLayer ownedLayer) {
        Intrinsics.checkNotNullParameter(ownedLayer, "layer");
        if (this.viewLayersContainer != null) {
            boolean shouldUseDispatchDraw = ViewLayer.Companion.getShouldUseDispatchDraw();
        }
        this.layerCache.push(ownedLayer);
        return true;
    }

    public void registerOnEndApplyChangesListener(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        if (!this.endApplyChangesListeners.contains(function0)) {
            this.endApplyChangesListeners.add(function0);
        }
    }

    public void registerOnLayoutCompletedListener(@NotNull Owner.OnLayoutCompletedListener onLayoutCompletedListener) {
        Intrinsics.checkNotNullParameter(onLayoutCompletedListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.measureAndLayoutDelegate.registerOnLayoutCompletedListener(onLayoutCompletedListener);
        e(this, (LayoutNode) null, 1, (Object) null);
    }

    public final void removeAndroidView(@NotNull AndroidViewHolder androidViewHolder) {
        Intrinsics.checkNotNullParameter(androidViewHolder, "view");
        registerOnEndApplyChangesListener(new AndroidComposeView$removeAndroidView$1(this, androidViewHolder));
    }

    public final void requestClearInvalidObservations() {
        this.observationClearRequested = true;
    }

    public void requestOnPositionedCallback(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.measureAndLayoutDelegate.requestOnPositionedCallback(layoutNode);
        e(this, (LayoutNode) null, 1, (Object) null);
    }

    /* renamed from: screenToLocal-MK-Hz9U  reason: not valid java name */
    public long m4807screenToLocalMKHz9U(long j11) {
        recalculateWindowPosition();
        return Matrix.m3106mapMKHz9U(this.windowToViewMatrix, OffsetKt.Offset(Offset.m2676getXimpl(j11) - Offset.m2676getXimpl(this.windowPosition), Offset.m2677getYimpl(j11) - Offset.m2677getYimpl(this.windowPosition)));
    }

    /* renamed from: sendKeyEvent-ZmokQxo  reason: not valid java name */
    public boolean m4808sendKeyEventZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        return this.keyInputModifier.m4190processKeyInputZmokQxo(keyEvent);
    }

    public final void setConfigurationChangeObserver(@NotNull Function1<? super Configuration, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        this.configurationChangeObserver = function1;
    }

    public final void setLastMatrixRecalculationAnimationTime$ui_release(long j11) {
        this.lastMatrixRecalculationAnimationTime = j11;
    }

    public final void setOnViewTreeOwnersAvailable(@NotNull Function1<? super ViewTreeOwners, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "callback");
        ViewTreeOwners viewTreeOwners = getViewTreeOwners();
        if (viewTreeOwners != null) {
            function1.invoke(viewTreeOwners);
        }
        if (!isAttachedToWindow()) {
            this.onViewTreeOwnersAvailable = function1;
        }
    }

    public void setShowLayoutBounds(boolean z11) {
        this.showLayoutBounds = z11;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    @NotNull
    public AndroidAccessibilityManager getAccessibilityManager() {
        return this.accessibilityManager;
    }

    @NotNull
    public AndroidClipboardManager getClipboardManager() {
        return this.clipboardManager;
    }

    private final void recalculateWindowPosition(MotionEvent motionEvent) {
        this.lastMatrixRecalculationAnimationTime = AnimationUtils.currentAnimationTimeMillis();
        recalculateWindowViewTransforms();
        long r02 = Matrix.m3106mapMKHz9U(this.viewToWindowMatrix, OffsetKt.Offset(motionEvent.getX(), motionEvent.getY()));
        this.windowPosition = OffsetKt.Offset(motionEvent.getRawX() - Offset.m2676getXimpl(r02), motionEvent.getRawY() - Offset.m2677getYimpl(r02));
    }
}
