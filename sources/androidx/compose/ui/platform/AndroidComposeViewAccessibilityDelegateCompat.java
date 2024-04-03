package androidx.compose.ui.platform;

import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.SpannableString;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.collection.ArraySet;
import androidx.collection.SparseArrayCompat;
import androidx.compose.ui.R;
import androidx.compose.ui.TempListUtilsKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.HitTestResult;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.SemanticsModifierNode;
import androidx.compose.ui.node.SemanticsModifierNodeKt;
import androidx.compose.ui.platform.AccessibilityIterators;
import androidx.compose.ui.platform.accessibility.CollectionInfoKt;
import androidx.compose.ui.semantics.AccessibilityAction;
import androidx.compose.ui.semantics.CustomAccessibilityAction;
import androidx.compose.ui.semantics.LiveRegionMode;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.ScrollAxisRange;
import androidx.compose.ui.semantics.SemanticsActions;
import androidx.compose.ui.semantics.SemanticsConfiguration;
import androidx.compose.ui.semantics.SemanticsConfigurationKt;
import androidx.compose.ui.semantics.SemanticsNode;
import androidx.compose.ui.semantics.SemanticsNodeKt;
import androidx.compose.ui.semantics.SemanticsProperties;
import androidx.compose.ui.semantics.SemanticsPropertiesAndroid;
import androidx.compose.ui.state.ToggleableState;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.platform.AndroidAccessibilitySpannableString_androidKt;
import androidx.compose.ui.viewinterop.AndroidViewHolder;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import com.pichillilorenzo.flutter_inappwebview.credential_database.URLProtectionSpaceContract;
import com.talabat.userandlocation.customerinfo.data.local.impl.CustomerInfoLocalDataSourceImpl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.ClosedFloatingPointRange;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import kotlinx.coroutines.channels.ChannelKt;
import l0.d;
import m0.h;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u001c\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 µ\u00012\u00020\u0001:\f³\u0001´\u0001µ\u0001¶\u0001·\u0001¸\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u00062\u0006\u0010D\u001a\u00020E2\u0006\u0010F\u001a\u00020G2\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J\u0011\u0010J\u001a\u00020\u0014H@ø\u0001\u0000¢\u0006\u0002\u0010KJ-\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020PH\u0000ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bQ\u0010RJ;\u0010L\u001a\u00020\b2\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180S2\u0006\u0010M\u001a\u00020\b2\u0006\u0010N\u001a\u00020\u00062\u0006\u0010O\u001a\u00020PH\u0001ø\u0001\u0001ø\u0001\u0000¢\u0006\u0004\bT\u0010UJ\b\u0010V\u001a\u00020\u0014H\u0002J\u0010\u0010W\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0006H\u0002J\u001d\u0010X\u001a\u00020Y2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u0006H\u0001¢\u0006\u0002\b[J\u0012\u0010\\\u001a\u0004\u0018\u00010E2\u0006\u0010C\u001a\u00020\u0006H\u0002J=\u0010]\u001a\u00020Y2\u0006\u0010C\u001a\u00020\u00062\b\u0010^\u001a\u0004\u0018\u00010\u00062\b\u0010_\u001a\u0004\u0018\u00010\u00062\b\u0010`\u001a\u0004\u0018\u00010\u00062\b\u0010a\u001a\u0004\u0018\u00010GH\u0002¢\u0006\u0002\u0010bJ\u000e\u0010c\u001a\u00020\b2\u0006\u0010d\u001a\u00020eJ\u0010\u0010f\u001a\u00020'2\u0006\u0010g\u001a\u00020hH\u0016J\u0010\u0010i\u001a\u00020\u00062\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010l\u001a\u00020\u00062\u0006\u0010j\u001a\u00020kH\u0002J\u0014\u0010m\u001a\u0004\u0018\u00010G2\b\u0010j\u001a\u0004\u0018\u00010kH\u0002J\u001c\u0010n\u001a\u0004\u0018\u00010o2\b\u0010j\u001a\u0004\u0018\u00010k2\u0006\u0010p\u001a\u00020\u0006H\u0002J\u001d\u0010q\u001a\u00020\u00062\u0006\u0010r\u001a\u00020s2\u0006\u0010t\u001a\u00020sH\u0001¢\u0006\u0002\buJ\u0010\u0010v\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0006H\u0002J\u0010\u0010w\u001a\u00020\b2\u0006\u0010j\u001a\u00020kH\u0002J\u0010\u0010x\u001a\u00020\u00142\u0006\u0010y\u001a\u00020?H\u0002J\u0015\u0010z\u001a\u00020\u00142\u0006\u0010y\u001a\u00020?H\u0000¢\u0006\u0002\b{J\r\u0010|\u001a\u00020\u0014H\u0000¢\u0006\u0002\b}J\"\u0010~\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010\u001a\u00020\u00062\b\u0010H\u001a\u0004\u0018\u00010IH\u0002J#\u0010\u0001\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u00062\u0007\u0010D\u001a\u00030\u00012\u0007\u0010\u0001\u001a\u00020kH\u0007J\"\u0010\u0001\u001a\u00020\b2\u0007\u0010\u0001\u001a\u00020\u00062\u000e\u0010\u0001\u001a\t\u0012\u0004\u0012\u0002090\u0001H\u0002J\u0011\u0010\u0001\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u0006H\u0002J\u0012\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\u0011\u0010\u0001\u001a\u00020\b2\u0006\u0010d\u001a\u00020YH\u0002J@\u0010\u0001\u001a\u00020\b2\u0006\u0010C\u001a\u00020\u00062\u0006\u0010Z\u001a\u00020\u00062\u000b\b\u0002\u0010\u0001\u001a\u0004\u0018\u00010\u00062\u0012\b\u0002\u0010\u0001\u001a\u000b\u0012\u0004\u0012\u00020G\u0018\u00010\u0001H\u0002¢\u0006\u0003\u0010\u0001J&\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00062\t\u0010\u0001\u001a\u0004\u0018\u00010GH\u0002J\u0012\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020\u0006H\u0002J\u0012\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u000209H\u0002J$\u0010\u0001\u001a\u00020\u00142\u0013\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u0017H\u0001¢\u0006\u0003\b\u0001J\u001b\u0010\u0001\u001a\u00020\u00142\u0007\u0010\u0001\u001a\u00020k2\u0007\u0010\u0001\u001a\u00020.H\u0002J \u0010\u0001\u001a\u00020\u00142\u0006\u0010y\u001a\u00020?2\r\u0010\u0001\u001a\b\u0012\u0004\u0012\u00020\u00060)H\u0002J,\u0010\u0001\u001a\u00020\b2\u0006\u0010j\u001a\u00020k2\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\bH\u0002J\u001a\u0010 \u0001\u001a\u00020\u00142\u0006\u0010j\u001a\u00020k2\u0007\u0010D\u001a\u00030\u0001H\u0002J\u001a\u0010¡\u0001\u001a\u00020\u00142\u0006\u0010j\u001a\u00020k2\u0007\u0010D\u001a\u00030\u0001H\u0002J!\u0010¢\u0001\u001a\u0005\u0018\u00010£\u00012\t\u0010¤\u0001\u001a\u0004\u0018\u00010k2\b\u0010¥\u0001\u001a\u00030¦\u0001H\u0002J+\u0010§\u0001\u001a\u00020\b2\u0006\u0010j\u001a\u00020k2\u0006\u0010p\u001a\u00020\u00062\u0007\u0010¨\u0001\u001a\u00020\b2\u0007\u0010©\u0001\u001a\u00020\bH\u0002J3\u0010ª\u0001\u001a\u0005\u0018\u0001H«\u0001\"\t\b\u0000\u0010«\u0001*\u00020\u00112\t\u0010a\u001a\u0005\u0018\u0001H«\u00012\t\b\u0001\u0010¬\u0001\u001a\u00020\u0006H\u0002¢\u0006\u0003\u0010­\u0001J\u0011\u0010®\u0001\u001a\u00020\u00142\u0006\u0010C\u001a\u00020\u0006H\u0002J\t\u0010¯\u0001\u001a\u00020\u0014H\u0002J\u0011\u0010°\u0001\u001a\u0005\u0018\u00010±\u0001*\u00030²\u0001H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\u0010X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00180\u00178BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u001eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u0014\u0010$\u001a\u00020\b8BX\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\nR \u0010%\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00060\u00170\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00060)X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u000e¢\u0006\u0002\n\u0000R0\u0010,\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020.0-8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b/\u00100\u001a\u0004\b1\u0010\u001a\"\u0004\b2\u00103R\u000e\u00104\u001a\u00020.X\u000e¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0004\n\u0002\u00106R\u0014\u00107\u001a\b\u0012\u0004\u0012\u00020908X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u000e\u0012\u0004\u0012\u000209\u0012\u0004\u0012\u00020\u00140=X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010>\u001a\b\u0012\u0004\u0012\u00020?0)X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b@\u0010A\u0002\u000b\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001¨\u0006¹\u0001"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;", "Landroidx/core/view/AccessibilityDelegateCompat;", "view", "Landroidx/compose/ui/platform/AndroidComposeView;", "(Landroidx/compose/ui/platform/AndroidComposeView;)V", "accessibilityCursorPosition", "", "accessibilityForceEnabledForTesting", "", "getAccessibilityForceEnabledForTesting$ui_release", "()Z", "setAccessibilityForceEnabledForTesting$ui_release", "(Z)V", "accessibilityManager", "Landroid/view/accessibility/AccessibilityManager;", "actionIdToLabel", "Landroidx/collection/SparseArrayCompat;", "", "boundsUpdateChannel", "Lkotlinx/coroutines/channels/Channel;", "", "checkingForSemanticsChanges", "currentSemanticsNodes", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "getCurrentSemanticsNodes", "()Ljava/util/Map;", "currentSemanticsNodesInvalidated", "focusedVirtualViewId", "handler", "Landroid/os/Handler;", "hoveredVirtualViewId", "getHoveredVirtualViewId$ui_release", "()I", "setHoveredVirtualViewId$ui_release", "(I)V", "isAccessibilityEnabled", "labelToActionId", "nodeProvider", "Landroidx/core/view/accessibility/AccessibilityNodeProviderCompat;", "paneDisplayed", "Landroidx/collection/ArraySet;", "pendingTextTraversedEvent", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "previousSemanticsNodes", "", "Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "getPreviousSemanticsNodes$ui_release$annotations", "()V", "getPreviousSemanticsNodes$ui_release", "setPreviousSemanticsNodes$ui_release", "(Ljava/util/Map;)V", "previousSemanticsRoot", "previousTraversedNode", "Ljava/lang/Integer;", "scrollObservationScopes", "", "Landroidx/compose/ui/platform/ScrollObservationScope;", "semanticsChangeChecker", "Ljava/lang/Runnable;", "sendScrollEventIfNeededLambda", "Lkotlin/Function1;", "subtreeChangedLayoutNodes", "Landroidx/compose/ui/node/LayoutNode;", "getView", "()Landroidx/compose/ui/platform/AndroidComposeView;", "addExtraDataToAccessibilityNodeInfoHelper", "virtualViewId", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "boundsUpdatesEventLoop", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "canScroll", "vertical", "direction", "position", "Landroidx/compose/ui/geometry/Offset;", "canScroll-0AR0LA0$ui_release", "(ZIJ)Z", "", "canScroll-moWRBKg$ui_release", "(Ljava/util/Collection;ZIJ)Z", "checkForSemanticsChanges", "clearAccessibilityFocus", "createEvent", "Landroid/view/accessibility/AccessibilityEvent;", "eventType", "createEvent$ui_release", "createNodeInfo", "createTextSelectionChangedEvent", "fromIndex", "toIndex", "itemCount", "text", "(ILjava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Landroid/view/accessibility/AccessibilityEvent;", "dispatchHoverEvent", "event", "Landroid/view/MotionEvent;", "getAccessibilityNodeProvider", "host", "Landroid/view/View;", "getAccessibilitySelectionEnd", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "getAccessibilitySelectionStart", "getIterableTextForAccessibility", "getIteratorForGranularity", "Landroidx/compose/ui/platform/AccessibilityIterators$TextSegmentIterator;", "granularity", "hitTestSemanticsAt", "x", "", "y", "hitTestSemanticsAt$ui_release", "isAccessibilityFocused", "isAccessibilitySelectionExtendable", "notifySubtreeAccessibilityStateChangedIfNeeded", "layoutNode", "onLayoutChange", "onLayoutChange$ui_release", "onSemanticsChange", "onSemanticsChange$ui_release", "performActionHelper", "action", "populateAccessibilityNodeInfoProperties", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "registerScrollingId", "id", "oldScrollObservationScopes", "", "requestAccessibilityFocus", "semanticsNodeIdToAccessibilityVirtualNodeId", "sendEvent", "sendEventForVirtualView", "contentChangeType", "contentDescription", "(IILjava/lang/Integer;Ljava/util/List;)Z", "sendPaneChangeEvents", "semanticsNodeId", "title", "sendPendingTextTraversedAtGranularityEvent", "sendScrollEventIfNeeded", "scrollObservationScope", "sendSemanticsPropertyChangeEvents", "newSemanticsNodes", "sendSemanticsPropertyChangeEvents$ui_release", "sendSemanticsStructureChangeEvents", "newNode", "oldNode", "sendSubtreeChangeAccessibilityEvents", "subtreeChangedSemanticsNodesIds", "setAccessibilitySelection", "start", "end", "traversalMode", "setContentInvalid", "setText", "toScreenCoords", "Landroid/graphics/RectF;", "textNode", "bounds", "Landroidx/compose/ui/geometry/Rect;", "traverseAtGranularity", "forward", "extendSelection", "trimToSize", "T", "size", "(Ljava/lang/CharSequence;I)Ljava/lang/CharSequence;", "updateHoveredVirtualView", "updateSemanticsNodesCopyAndPanes", "getTextForTextField", "Landroidx/compose/ui/text/AnnotatedString;", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "Api24Impl", "Api28Impl", "Companion", "MyNodeProvider", "PendingTextTraversedEvent", "SemanticsNodeCopy", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class AndroidComposeViewAccessibilityDelegateCompat extends AccessibilityDelegateCompat {
    @NotNull
    private static final int[] AccessibilityActionsResourceIds = {R.id.accessibility_custom_action_0, R.id.accessibility_custom_action_1, R.id.accessibility_custom_action_2, R.id.accessibility_custom_action_3, R.id.accessibility_custom_action_4, R.id.accessibility_custom_action_5, R.id.accessibility_custom_action_6, R.id.accessibility_custom_action_7, R.id.accessibility_custom_action_8, R.id.accessibility_custom_action_9, R.id.accessibility_custom_action_10, R.id.accessibility_custom_action_11, R.id.accessibility_custom_action_12, R.id.accessibility_custom_action_13, R.id.accessibility_custom_action_14, R.id.accessibility_custom_action_15, R.id.accessibility_custom_action_16, R.id.accessibility_custom_action_17, R.id.accessibility_custom_action_18, R.id.accessibility_custom_action_19, R.id.accessibility_custom_action_20, R.id.accessibility_custom_action_21, R.id.accessibility_custom_action_22, R.id.accessibility_custom_action_23, R.id.accessibility_custom_action_24, R.id.accessibility_custom_action_25, R.id.accessibility_custom_action_26, R.id.accessibility_custom_action_27, R.id.accessibility_custom_action_28, R.id.accessibility_custom_action_29, R.id.accessibility_custom_action_30, R.id.accessibility_custom_action_31};
    public static final int AccessibilityCursorPositionUndefined = -1;
    public static final int AccessibilitySliderStepsCount = 20;
    @NotNull
    public static final String ClassName = "android.view.View";
    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @NotNull
    public static final String ExtraDataTestTagKey = "androidx.compose.ui.semantics.testTag";
    public static final int InvalidId = Integer.MIN_VALUE;
    @NotNull
    public static final String LogTag = "AccessibilityDelegate";
    public static final int ParcelSafeTextLength = 100000;
    public static final long SendRecurringAccessibilityEventsIntervalMillis = 100;
    public static final long TextTraversedEventTimeoutMillis = 1000;
    private int accessibilityCursorPosition;
    private boolean accessibilityForceEnabledForTesting;
    @NotNull
    private final AccessibilityManager accessibilityManager;
    @NotNull
    private SparseArrayCompat<SparseArrayCompat<CharSequence>> actionIdToLabel;
    @NotNull
    private final Channel<Unit> boundsUpdateChannel;
    private boolean checkingForSemanticsChanges;
    @NotNull
    private Map<Integer, SemanticsNodeWithAdjustedBounds> currentSemanticsNodes;
    private boolean currentSemanticsNodesInvalidated;
    private int focusedVirtualViewId;
    /* access modifiers changed from: private */
    @NotNull
    public final Handler handler;
    private int hoveredVirtualViewId = Integer.MIN_VALUE;
    @NotNull
    private SparseArrayCompat<Map<CharSequence, Integer>> labelToActionId;
    @NotNull
    private AccessibilityNodeProviderCompat nodeProvider;
    @NotNull
    private ArraySet<Integer> paneDisplayed;
    @Nullable
    private PendingTextTraversedEvent pendingTextTraversedEvent;
    @NotNull
    private Map<Integer, SemanticsNodeCopy> previousSemanticsNodes;
    @NotNull
    private SemanticsNodeCopy previousSemanticsRoot;
    @Nullable
    private Integer previousTraversedNode;
    @NotNull
    private final List<ScrollObservationScope> scrollObservationScopes;
    /* access modifiers changed from: private */
    @NotNull
    public final Runnable semanticsChangeChecker;
    @NotNull
    private final Function1<ScrollObservationScope, Unit> sendScrollEventIfNeededLambda;
    @NotNull
    private final ArraySet<LayoutNode> subtreeChangedLayoutNodes;
    @NotNull
    private final AndroidComposeView view;

    @RequiresApi(24)
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api24Impl;", "", "()V", "addSetProgressAction", "", "info", "Landroidx/core/view/accessibility/AccessibilityNodeInfoCompat;", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Api24Impl {
        @NotNull
        public static final Api24Impl INSTANCE = new Api24Impl();

        private Api24Impl() {
        }

        @JvmStatic
        @DoNotInline
        public static final void addSetProgressAction(@NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @NotNull SemanticsNode semanticsNode) {
            AccessibilityAction accessibilityAction;
            Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat, CustomerInfoLocalDataSourceImpl.KEY);
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && (accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsActions.INSTANCE.getSetProgress())) != null) {
                accessibilityNodeInfoCompat.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16908349, accessibilityAction.getLabel()));
            }
        }
    }

    @RequiresApi(28)
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bH\u0007¨\u0006\n"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Api28Impl;", "", "()V", "setScrollEventDelta", "", "event", "Landroid/view/accessibility/AccessibilityEvent;", "deltaX", "", "deltaY", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Api28Impl {
        @NotNull
        public static final Api28Impl INSTANCE = new Api28Impl();

        private Api28Impl() {
        }

        @JvmStatic
        @DoNotInline
        public static final void setScrollEventDelta(@NotNull AccessibilityEvent accessibilityEvent, int i11, int i12) {
            Intrinsics.checkNotNullParameter(accessibilityEvent, "event");
            accessibilityEvent.setScrollDeltaX(i11);
            accessibilityEvent.setScrollDeltaY(i12);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fXT¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$Companion;", "", "()V", "AccessibilityActionsResourceIds", "", "AccessibilityCursorPositionUndefined", "", "AccessibilitySliderStepsCount", "ClassName", "", "ExtraDataTestTagKey", "InvalidId", "LogTag", "ParcelSafeTextLength", "SendRecurringAccessibilityEventsIntervalMillis", "", "TextTraversedEventTimeoutMillis", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J*\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u0012\u0010\r\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\"\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u00062\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$MyNodeProvider;", "Landroid/view/accessibility/AccessibilityNodeProvider;", "(Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat;)V", "addExtraDataToAccessibilityNodeInfo", "", "virtualViewId", "", "info", "Landroid/view/accessibility/AccessibilityNodeInfo;", "extraDataKey", "", "arguments", "Landroid/os/Bundle;", "createAccessibilityNodeInfo", "performAction", "", "action", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public final class MyNodeProvider extends AccessibilityNodeProvider {
        public MyNodeProvider() {
        }

        public void addExtraDataToAccessibilityNodeInfo(int i11, @NotNull AccessibilityNodeInfo accessibilityNodeInfo, @NotNull String str, @Nullable Bundle bundle) {
            Intrinsics.checkNotNullParameter(accessibilityNodeInfo, CustomerInfoLocalDataSourceImpl.KEY);
            Intrinsics.checkNotNullParameter(str, "extraDataKey");
            AndroidComposeViewAccessibilityDelegateCompat.this.addExtraDataToAccessibilityNodeInfoHelper(i11, accessibilityNodeInfo, str, bundle);
        }

        @Nullable
        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i11) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.createNodeInfo(i11);
        }

        public boolean performAction(int i11, int i12, @Nullable Bundle bundle) {
            return AndroidComposeViewAccessibilityDelegateCompat.this.performActionHelper(i11, i12, bundle);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u000b\b\u0002\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0015"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$PendingTextTraversedEvent;", "", "node", "Landroidx/compose/ui/semantics/SemanticsNode;", "action", "", "granularity", "fromIndex", "toIndex", "traverseTime", "", "(Landroidx/compose/ui/semantics/SemanticsNode;IIIIJ)V", "getAction", "()I", "getFromIndex", "getGranularity", "getNode", "()Landroidx/compose/ui/semantics/SemanticsNode;", "getToIndex", "getTraverseTime", "()J", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class PendingTextTraversedEvent {
        private final int action;
        private final int fromIndex;
        private final int granularity;
        @NotNull
        private final SemanticsNode node;
        private final int toIndex;
        private final long traverseTime;

        public PendingTextTraversedEvent(@NotNull SemanticsNode semanticsNode, int i11, int i12, int i13, int i14, long j11) {
            Intrinsics.checkNotNullParameter(semanticsNode, "node");
            this.node = semanticsNode;
            this.action = i11;
            this.granularity = i12;
            this.fromIndex = i13;
            this.toIndex = i14;
            this.traverseTime = j11;
        }

        public final int getAction() {
            return this.action;
        }

        public final int getFromIndex() {
            return this.fromIndex;
        }

        public final int getGranularity() {
            return this.granularity;
        }

        @NotNull
        public final SemanticsNode getNode() {
            return this.node;
        }

        public final int getToIndex() {
            return this.toIndex;
        }

        public final long getTraverseTime() {
            return this.traverseTime;
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010#\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\b\u0001\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005¢\u0006\u0002\u0010\bJ\u0006\u0010\u0011\u001a\u00020\u0012R\u0017\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00060\n¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0013"}, d2 = {"Landroidx/compose/ui/platform/AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy;", "", "semanticsNode", "Landroidx/compose/ui/semantics/SemanticsNode;", "currentSemanticsNodes", "", "", "Landroidx/compose/ui/platform/SemanticsNodeWithAdjustedBounds;", "(Landroidx/compose/ui/semantics/SemanticsNode;Ljava/util/Map;)V", "children", "", "getChildren", "()Ljava/util/Set;", "unmergedConfig", "Landroidx/compose/ui/semantics/SemanticsConfiguration;", "getUnmergedConfig", "()Landroidx/compose/ui/semantics/SemanticsConfiguration;", "hasPaneTitle", "", "ui_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    @VisibleForTesting
    public static final class SemanticsNodeCopy {
        @NotNull
        private final Set<Integer> children = new LinkedHashSet();
        @NotNull
        private final SemanticsConfiguration unmergedConfig;

        public SemanticsNodeCopy(@NotNull SemanticsNode semanticsNode, @NotNull Map<Integer, SemanticsNodeWithAdjustedBounds> map) {
            Intrinsics.checkNotNullParameter(semanticsNode, "semanticsNode");
            Intrinsics.checkNotNullParameter(map, "currentSemanticsNodes");
            this.unmergedConfig = semanticsNode.getUnmergedConfig$ui_release();
            List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
            int size = replacedChildren$ui_release.size();
            for (int i11 = 0; i11 < size; i11++) {
                SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i11);
                if (map.containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                    this.children.add(Integer.valueOf(semanticsNode2.getId()));
                }
            }
        }

        @NotNull
        public final Set<Integer> getChildren() {
            return this.children;
        }

        @NotNull
        public final SemanticsConfiguration getUnmergedConfig() {
            return this.unmergedConfig;
        }

        public final boolean hasPaneTitle() {
            return this.unmergedConfig.contains(SemanticsProperties.INSTANCE.getPaneTitle());
        }
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ToggleableState.values().length];
            iArr[ToggleableState.On.ordinal()] = 1;
            iArr[ToggleableState.Off.ordinal()] = 2;
            iArr[ToggleableState.Indeterminate.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public AndroidComposeViewAccessibilityDelegateCompat(@NotNull AndroidComposeView androidComposeView) {
        Intrinsics.checkNotNullParameter(androidComposeView, "view");
        this.view = androidComposeView;
        Object systemService = androidComposeView.getContext().getSystemService("accessibility");
        Intrinsics.checkNotNull(systemService, "null cannot be cast to non-null type android.view.accessibility.AccessibilityManager");
        this.accessibilityManager = (AccessibilityManager) systemService;
        this.handler = new Handler(Looper.getMainLooper());
        this.nodeProvider = new AccessibilityNodeProviderCompat(new MyNodeProvider());
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.actionIdToLabel = new SparseArrayCompat<>();
        this.labelToActionId = new SparseArrayCompat<>();
        this.accessibilityCursorPosition = -1;
        this.subtreeChangedLayoutNodes = new ArraySet<>();
        this.boundsUpdateChannel = ChannelKt.Channel$default(-1, (BufferOverflow) null, (Function1) null, 6, (Object) null);
        this.currentSemanticsNodesInvalidated = true;
        this.currentSemanticsNodes = MapsKt__MapsKt.emptyMap();
        this.paneDisplayed = new ArraySet<>();
        this.previousSemanticsNodes = new LinkedHashMap();
        this.previousSemanticsRoot = new SemanticsNodeCopy(androidComposeView.getSemanticsOwner().getUnmergedRootSemanticsNode(), MapsKt__MapsKt.emptyMap());
        androidComposeView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener(this) {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ AndroidComposeViewAccessibilityDelegateCompat f9987b;

            {
                this.f9987b = r1;
            }

            public void onViewAttachedToWindow(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
            }

            public void onViewDetachedFromWindow(@NotNull View view) {
                Intrinsics.checkNotNullParameter(view, "view");
                this.f9987b.handler.removeCallbacks(this.f9987b.semanticsChangeChecker);
            }
        });
        this.semanticsChangeChecker = new h(this);
        this.scrollObservationScopes = new ArrayList();
        this.sendScrollEventIfNeededLambda = new AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeededLambda$1(this);
    }

    /* access modifiers changed from: private */
    public final void addExtraDataToAccessibilityNodeInfoHelper(int i11, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
        SemanticsNode semanticsNode;
        String str2;
        int i12;
        Boolean bool;
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i11));
        if (semanticsNodeWithAdjustedBounds != null && (semanticsNode = semanticsNodeWithAdjustedBounds.getSemanticsNode()) != null) {
            String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
            SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
            SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
            if (!unmergedConfig$ui_release.contains(semanticsActions.getGetTextLayoutResult()) || bundle == null || !Intrinsics.areEqual((Object) str, (Object) "android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY")) {
                SemanticsConfiguration unmergedConfig$ui_release2 = semanticsNode.getUnmergedConfig$ui_release();
                SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
                if (unmergedConfig$ui_release2.contains(semanticsProperties.getTestTag()) && bundle != null && Intrinsics.areEqual((Object) str, (Object) ExtraDataTestTagKey) && (str2 = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getTestTag())) != null) {
                    accessibilityNodeInfo.getExtras().putCharSequence(str, str2);
                    return;
                }
                return;
            }
            int i13 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX", -1);
            int i14 = bundle.getInt("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH", -1);
            if (i14 > 0 && i13 >= 0) {
                if (iterableTextForAccessibility != null) {
                    i12 = iterableTextForAccessibility.length();
                } else {
                    i12 = Integer.MAX_VALUE;
                }
                if (i13 < i12) {
                    ArrayList arrayList = new ArrayList();
                    Function1 function1 = (Function1) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getGetTextLayoutResult())).getAction();
                    if (function1 != null) {
                        bool = (Boolean) function1.invoke(arrayList);
                    } else {
                        bool = null;
                    }
                    if (Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
                        TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
                        ArrayList arrayList2 = new ArrayList();
                        for (int i15 = 0; i15 < i14; i15++) {
                            int i16 = i13 + i15;
                            if (i16 >= textLayoutResult.getLayoutInput().getText().length()) {
                                arrayList2.add((Object) null);
                            } else {
                                arrayList2.add(toScreenCoords(semanticsNode, textLayoutResult.getBoundingBox(i16)));
                            }
                        }
                        Bundle extras = accessibilityNodeInfo.getExtras();
                        Object[] array = arrayList2.toArray(new RectF[0]);
                        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
                        extras.putParcelableArray(str, (Parcelable[]) array);
                        return;
                    }
                    return;
                }
            }
            Log.e(LogTag, "Invalid arguments for accessibility character locations");
        }
    }

    public static /* synthetic */ boolean b(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat, int i11, int i12, Integer num, List list, int i13, Object obj) {
        if ((i13 & 4) != 0) {
            num = null;
        }
        if ((i13 & 8) != 0) {
            list = null;
        }
        return androidComposeViewAccessibilityDelegateCompat.sendEventForVirtualView(i11, i12, num, list);
    }

    private final void checkForSemanticsChanges() {
        sendSemanticsStructureChangeEvents(this.view.getSemanticsOwner().getUnmergedRootSemanticsNode(), this.previousSemanticsRoot);
        sendSemanticsPropertyChangeEvents$ui_release(getCurrentSemanticsNodes());
        updateSemanticsNodesCopyAndPanes();
    }

    private final boolean clearAccessibilityFocus(int i11) {
        if (!isAccessibilityFocused(i11)) {
            return false;
        }
        this.focusedVirtualViewId = Integer.MIN_VALUE;
        this.view.invalidate();
        b(this, i11, 65536, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    /* JADX WARNING: type inference failed for: r4v13, types: [android.view.ViewParent] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.accessibility.AccessibilityNodeInfo createNodeInfo(int r11) {
        /*
            r10 = this;
            androidx.compose.ui.platform.AndroidComposeView r0 = r10.view
            androidx.compose.ui.platform.AndroidComposeView$ViewTreeOwners r0 = r0.getViewTreeOwners()
            r1 = 0
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.LifecycleOwner r0 = r0.getLifecycleOwner()
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.Lifecycle r0 = r0.getLifecycle()
            if (r0 == 0) goto L_0x001a
            androidx.lifecycle.Lifecycle$State r0 = r0.getCurrentState()
            goto L_0x001b
        L_0x001a:
            r0 = r1
        L_0x001b:
            androidx.lifecycle.Lifecycle$State r2 = androidx.lifecycle.Lifecycle.State.DESTROYED
            if (r0 != r2) goto L_0x0020
            return r1
        L_0x0020:
            androidx.core.view.accessibility.AccessibilityNodeInfoCompat r0 = androidx.core.view.accessibility.AccessibilityNodeInfoCompat.obtain()
            java.lang.String r2 = "obtain()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            java.util.Map r2 = r10.getCurrentSemanticsNodes()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r11)
            java.lang.Object r2 = r2.get(r3)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            if (r2 != 0) goto L_0x003d
            r0.recycle()
            return r1
        L_0x003d:
            androidx.compose.ui.semantics.SemanticsNode r3 = r2.getSemanticsNode()
            r4 = -1
            if (r11 != r4) goto L_0x0055
            androidx.compose.ui.platform.AndroidComposeView r4 = r10.view
            android.view.ViewParent r4 = androidx.core.view.ViewCompat.getParentForAccessibility(r4)
            boolean r5 = r4 instanceof android.view.View
            if (r5 == 0) goto L_0x0051
            r1 = r4
            android.view.View r1 = (android.view.View) r1
        L_0x0051:
            r0.setParent(r1)
            goto L_0x007d
        L_0x0055:
            androidx.compose.ui.semantics.SemanticsNode r1 = r3.getParent()
            if (r1 == 0) goto L_0x00e2
            androidx.compose.ui.semantics.SemanticsNode r1 = r3.getParent()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)
            int r1 = r1.getId()
            androidx.compose.ui.platform.AndroidComposeView r5 = r10.view
            androidx.compose.ui.semantics.SemanticsOwner r5 = r5.getSemanticsOwner()
            androidx.compose.ui.semantics.SemanticsNode r5 = r5.getUnmergedRootSemanticsNode()
            int r5 = r5.getId()
            if (r1 != r5) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            r4 = r1
        L_0x0078:
            androidx.compose.ui.platform.AndroidComposeView r1 = r10.view
            r0.setParent(r1, r4)
        L_0x007d:
            androidx.compose.ui.platform.AndroidComposeView r1 = r10.view
            r0.setSource(r1, r11)
            android.graphics.Rect r1 = r2.getAdjustedBounds()
            androidx.compose.ui.platform.AndroidComposeView r2 = r10.view
            int r4 = r1.left
            float r4 = (float) r4
            int r5 = r1.top
            float r5 = (float) r5
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r4, r5)
            long r4 = r2.m4805localToScreenMKHz9U(r4)
            androidx.compose.ui.platform.AndroidComposeView r2 = r10.view
            int r6 = r1.right
            float r6 = (float) r6
            int r1 = r1.bottom
            float r1 = (float) r1
            long r6 = androidx.compose.ui.geometry.OffsetKt.Offset(r6, r1)
            long r1 = r2.m4805localToScreenMKHz9U(r6)
            android.graphics.Rect r6 = new android.graphics.Rect
            float r7 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r4)
            double r7 = (double) r7
            double r7 = java.lang.Math.floor(r7)
            float r7 = (float) r7
            int r7 = (int) r7
            float r4 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r4)
            double r4 = (double) r4
            double r4 = java.lang.Math.floor(r4)
            float r4 = (float) r4
            int r4 = (int) r4
            float r5 = androidx.compose.ui.geometry.Offset.m2676getXimpl(r1)
            double r8 = (double) r5
            double r8 = java.lang.Math.ceil(r8)
            float r5 = (float) r8
            int r5 = (int) r5
            float r1 = androidx.compose.ui.geometry.Offset.m2677getYimpl(r1)
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            float r1 = (float) r1
            int r1 = (int) r1
            r6.<init>(r7, r4, r5, r1)
            r0.setBoundsInScreen(r6)
            r10.populateAccessibilityNodeInfoProperties(r11, r0, r3)
            android.view.accessibility.AccessibilityNodeInfo r11 = r0.unwrap()
            return r11
        L_0x00e2:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "semanticsNode "
            r1.append(r2)
            r1.append(r11)
            java.lang.String r11 = " has null parent"
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            r0.<init>(r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.createNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    private final AccessibilityEvent createTextSelectionChangedEvent(int i11, Integer num, Integer num2, Integer num3, String str) {
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(i11, 8192);
        if (num != null) {
            createEvent$ui_release.setFromIndex(num.intValue());
        }
        if (num2 != null) {
            createEvent$ui_release.setToIndex(num2.intValue());
        }
        if (num3 != null) {
            createEvent$ui_release.setItemCount(num3.intValue());
        }
        if (str != null) {
            createEvent$ui_release.getText().add(str);
        }
        return createEvent$ui_release;
    }

    private final int getAccessibilitySelectionEnd(SemanticsNode semanticsNode) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m5033getEndimpl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties.getTextSelectionRange())).m5042unboximpl());
    }

    private final int getAccessibilitySelectionStart(SemanticsNode semanticsNode) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties.getTextSelectionRange())) {
            return this.accessibilityCursorPosition;
        }
        return TextRange.m5038getStartimpl(((TextRange) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties.getTextSelectionRange())).m5042unboximpl());
    }

    private final Map<Integer, SemanticsNodeWithAdjustedBounds> getCurrentSemanticsNodes() {
        if (this.currentSemanticsNodesInvalidated) {
            this.currentSemanticsNodes = AndroidComposeViewAccessibilityDelegateCompat_androidKt.getAllUncoveredSemanticsNodesToMap(this.view.getSemanticsOwner());
            this.currentSemanticsNodesInvalidated = false;
        }
        return this.currentSemanticsNodes;
    }

    private final String getIterableTextForAccessibility(SemanticsNode semanticsNode) {
        AnnotatedString annotatedString;
        if (semanticsNode == null) {
            return null;
        }
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription())) {
            return TempListUtilsKt.fastJoinToString$default((List) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties.getContentDescription()), ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode)) {
            AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
            if (textForTextField != null) {
                return textForTextField.getText();
            }
            return null;
        }
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getText());
        if (list == null || (annotatedString = (AnnotatedString) CollectionsKt___CollectionsKt.firstOrNull(list)) == null) {
            return null;
        }
        return annotatedString.getText();
    }

    private final AccessibilityIterators.TextSegmentIterator getIteratorForGranularity(SemanticsNode semanticsNode, int i11) {
        boolean z11;
        Boolean bool;
        if (semanticsNode == null) {
            return null;
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return null;
        }
        if (i11 == 1) {
            AccessibilityIterators.CharacterTextSegmentIterator.Companion companion = AccessibilityIterators.CharacterTextSegmentIterator.Companion;
            Locale locale = this.view.getContext().getResources().getConfiguration().locale;
            Intrinsics.checkNotNullExpressionValue(locale, "view.context.resources.configuration.locale");
            AccessibilityIterators.CharacterTextSegmentIterator instance = companion.getInstance(locale);
            instance.initialize(iterableTextForAccessibility);
            return instance;
        } else if (i11 != 2) {
            if (i11 != 4) {
                if (i11 == 8) {
                    AccessibilityIterators.ParagraphTextSegmentIterator instance2 = AccessibilityIterators.ParagraphTextSegmentIterator.Companion.getInstance();
                    instance2.initialize(iterableTextForAccessibility);
                    return instance2;
                } else if (i11 != 16) {
                    return null;
                }
            }
            SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
            SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
            if (!unmergedConfig$ui_release.contains(semanticsActions.getGetTextLayoutResult())) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            Function1 function1 = (Function1) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getGetTextLayoutResult())).getAction();
            if (function1 != null) {
                bool = (Boolean) function1.invoke(arrayList);
            } else {
                bool = null;
            }
            if (!Intrinsics.areEqual((Object) bool, (Object) Boolean.TRUE)) {
                return null;
            }
            TextLayoutResult textLayoutResult = (TextLayoutResult) arrayList.get(0);
            if (i11 == 4) {
                AccessibilityIterators.LineTextSegmentIterator instance3 = AccessibilityIterators.LineTextSegmentIterator.Companion.getInstance();
                instance3.initialize(iterableTextForAccessibility, textLayoutResult);
                return instance3;
            }
            AccessibilityIterators.PageTextSegmentIterator instance4 = AccessibilityIterators.PageTextSegmentIterator.Companion.getInstance();
            instance4.initialize(iterableTextForAccessibility, textLayoutResult, semanticsNode);
            return instance4;
        } else {
            AccessibilityIterators.WordTextSegmentIterator.Companion companion2 = AccessibilityIterators.WordTextSegmentIterator.Companion;
            Locale locale2 = this.view.getContext().getResources().getConfiguration().locale;
            Intrinsics.checkNotNullExpressionValue(locale2, "view.context.resources.configuration.locale");
            AccessibilityIterators.WordTextSegmentIterator instance5 = companion2.getInstance(locale2);
            instance5.initialize(iterableTextForAccessibility);
            return instance5;
        }
    }

    @VisibleForTesting
    public static /* synthetic */ void getPreviousSemanticsNodes$ui_release$annotations() {
    }

    private final AnnotatedString getTextForTextField(SemanticsConfiguration semanticsConfiguration) {
        return (AnnotatedString) SemanticsConfigurationKt.getOrNull(semanticsConfiguration, SemanticsProperties.INSTANCE.getEditableText());
    }

    private final boolean isAccessibilityEnabled() {
        if (this.accessibilityForceEnabledForTesting || (this.accessibilityManager.isEnabled() && this.accessibilityManager.isTouchExplorationEnabled())) {
            return true;
        }
        return false;
    }

    private final boolean isAccessibilityFocused(int i11) {
        return this.focusedVirtualViewId == i11;
    }

    private final boolean isAccessibilitySelectionExtendable(SemanticsNode semanticsNode) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getContentDescription()) || !semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties.getEditableText())) {
            return false;
        }
        return true;
    }

    private final void notifySubtreeAccessibilityStateChangedIfNeeded(LayoutNode layoutNode) {
        if (this.subtreeChangedLayoutNodes.add(layoutNode)) {
            this.boundsUpdateChannel.m7820trySendJP2dKIU(Unit.INSTANCE);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r14v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v13, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v29, resolved type: java.lang.Object} */
    /* JADX WARNING: type inference failed for: r4v14, types: [java.lang.String] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x0107 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0108  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performActionHelper(int r13, int r14, android.os.Bundle r15) {
        /*
            r12 = this;
            java.util.Map r0 = r12.getCurrentSemanticsNodes()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r13)
            java.lang.Object r0 = r0.get(r1)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r0 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r0
            r1 = 0
            if (r0 == 0) goto L_0x0565
            androidx.compose.ui.semantics.SemanticsNode r0 = r0.getSemanticsNode()
            if (r0 != 0) goto L_0x0019
            goto L_0x0565
        L_0x0019:
            r2 = 64
            if (r14 == r2) goto L_0x0560
            r2 = 128(0x80, float:1.794E-43)
            if (r14 == r2) goto L_0x055b
            r2 = 256(0x100, float:3.59E-43)
            r3 = 1
            if (r14 == r2) goto L_0x0544
            r4 = 512(0x200, float:7.175E-43)
            if (r14 == r4) goto L_0x0544
            r2 = 16384(0x4000, float:2.2959E-41)
            if (r14 == r2) goto L_0x051f
            r2 = 131072(0x20000, float:1.83671E-40)
            if (r14 == r2) goto L_0x04f3
            boolean r2 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(r0)
            if (r2 != 0) goto L_0x0039
            return r1
        L_0x0039:
            if (r14 == r3) goto L_0x04ce
            r2 = 2
            r4 = 0
            if (r14 == r2) goto L_0x04ad
            switch(r14) {
                case 16: goto L_0x047a;
                case 32: goto L_0x0455;
                case 4096: goto L_0x02bf;
                case 8192: goto L_0x02bf;
                case 32768: goto L_0x029a;
                case 65536: goto L_0x0275;
                case 262144: goto L_0x0250;
                case 524288: goto L_0x022b;
                case 1048576: goto L_0x0206;
                case 2097152: goto L_0x01ca;
                case 16908342: goto L_0x00cd;
                case 16908349: goto L_0x0095;
                default: goto L_0x0042;
            }
        L_0x0042:
            switch(r14) {
                case 16908344: goto L_0x02bf;
                case 16908345: goto L_0x02bf;
                case 16908346: goto L_0x02bf;
                case 16908347: goto L_0x02bf;
                default: goto L_0x0045;
            }
        L_0x0045:
            androidx.collection.SparseArrayCompat<androidx.collection.SparseArrayCompat<java.lang.CharSequence>> r15 = r12.actionIdToLabel
            java.lang.Object r13 = r15.get(r13)
            androidx.collection.SparseArrayCompat r13 = (androidx.collection.SparseArrayCompat) r13
            if (r13 == 0) goto L_0x0094
            java.lang.Object r13 = r13.get(r14)
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            if (r13 != 0) goto L_0x0058
            goto L_0x0094
        L_0x0058:
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r15 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r15 = r15.getCustomActions()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r15)
            java.util.List r14 = (java.util.List) r14
            if (r14 != 0) goto L_0x006b
            return r1
        L_0x006b:
            int r15 = r14.size()
            r0 = r1
        L_0x0070:
            if (r0 >= r15) goto L_0x0094
            java.lang.Object r2 = r14.get(r0)
            androidx.compose.ui.semantics.CustomAccessibilityAction r2 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r2
            java.lang.String r3 = r2.getLabel()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r13)
            if (r3 == 0) goto L_0x0091
            kotlin.jvm.functions.Function0 r13 = r2.getAction()
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r13 = r13.booleanValue()
            return r13
        L_0x0091:
            int r0 = r0 + 1
            goto L_0x0070
        L_0x0094:
            return r1
        L_0x0095:
            if (r15 == 0) goto L_0x00cc
            java.lang.String r13 = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE"
            boolean r14 = r15.containsKey(r13)
            if (r14 != 0) goto L_0x00a0
            goto L_0x00cc
        L_0x00a0:
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r0 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r0 = r0.getSetProgress()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r0)
            androidx.compose.ui.semantics.AccessibilityAction r14 = (androidx.compose.ui.semantics.AccessibilityAction) r14
            if (r14 == 0) goto L_0x00cc
            kotlin.Function r14 = r14.getAction()
            kotlin.jvm.functions.Function1 r14 = (kotlin.jvm.functions.Function1) r14
            if (r14 == 0) goto L_0x00cc
            float r13 = r15.getFloat(r13)
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.Object r13 = r14.invoke(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x00cc:
            return r1
        L_0x00cd:
            androidx.compose.ui.semantics.SemanticsNode r13 = r0.getParent()
            if (r13 == 0) goto L_0x00e6
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r13.getConfig()
            if (r14 == 0) goto L_0x00e6
            androidx.compose.ui.semantics.SemanticsActions r15 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r15 = r15.getScrollBy()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r15)
            androidx.compose.ui.semantics.AccessibilityAction r14 = (androidx.compose.ui.semantics.AccessibilityAction) r14
            goto L_0x00e7
        L_0x00e6:
            r14 = r4
        L_0x00e7:
            if (r13 == 0) goto L_0x0105
            if (r14 == 0) goto L_0x00ec
            goto L_0x0105
        L_0x00ec:
            androidx.compose.ui.semantics.SemanticsNode r13 = r13.getParent()
            if (r13 == 0) goto L_0x00e6
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r13.getConfig()
            if (r14 == 0) goto L_0x00e6
            androidx.compose.ui.semantics.SemanticsActions r15 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r15 = r15.getScrollBy()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r15)
            androidx.compose.ui.semantics.AccessibilityAction r14 = (androidx.compose.ui.semantics.AccessibilityAction) r14
            goto L_0x00e7
        L_0x0105:
            if (r13 != 0) goto L_0x0108
            return r1
        L_0x0108:
            androidx.compose.ui.layout.LayoutInfo r15 = r13.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r15 = r15.getCoordinates()
            androidx.compose.ui.geometry.Rect r15 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r15)
            androidx.compose.ui.layout.LayoutInfo r2 = r13.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r2 = r2.getCoordinates()
            androidx.compose.ui.layout.LayoutCoordinates r2 = r2.getParentLayoutCoordinates()
            if (r2 == 0) goto L_0x0127
            long r4 = androidx.compose.ui.layout.LayoutCoordinatesKt.positionInRoot(r2)
            goto L_0x012d
        L_0x0127:
            androidx.compose.ui.geometry.Offset$Companion r2 = androidx.compose.ui.geometry.Offset.Companion
            long r4 = r2.m2692getZeroF1C5BW0()
        L_0x012d:
            androidx.compose.ui.geometry.Rect r15 = r15.m2713translatek4lQ0M(r4)
            long r4 = r0.m4918getPositionInRootF1C5BW0()
            long r6 = r0.m4920getSizeYbymL2g()
            long r6 = androidx.compose.ui.unit.IntSizeKt.m5648toSizeozmzZPI(r6)
            androidx.compose.ui.geometry.Rect r2 = androidx.compose.ui.geometry.RectKt.m2716Recttz77jQw(r4, r6)
            androidx.compose.ui.semantics.SemanticsConfiguration r4 = r13.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r5 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r6 = r5.getHorizontalScrollAxisRange()
            java.lang.Object r4 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r4, r6)
            androidx.compose.ui.semantics.ScrollAxisRange r4 = (androidx.compose.ui.semantics.ScrollAxisRange) r4
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r13.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsPropertyKey r5 = r5.getVerticalScrollAxisRange()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r5)
            androidx.compose.ui.semantics.ScrollAxisRange r13 = (androidx.compose.ui.semantics.ScrollAxisRange) r13
            float r5 = r2.getLeft()
            float r6 = r15.getLeft()
            float r5 = r5 - r6
            float r6 = r2.getRight()
            float r7 = r15.getRight()
            float r6 = r6 - r7
            float r5 = performActionHelper$scrollDelta(r5, r6)
            if (r4 == 0) goto L_0x017f
            boolean r4 = r4.getReverseScrolling()
            if (r4 != r3) goto L_0x017f
            r4 = r3
            goto L_0x0180
        L_0x017f:
            r4 = r1
        L_0x0180:
            if (r4 == 0) goto L_0x0183
            float r5 = -r5
        L_0x0183:
            boolean r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(r0)
            if (r0 == 0) goto L_0x018a
            float r5 = -r5
        L_0x018a:
            float r0 = r2.getTop()
            float r4 = r15.getTop()
            float r0 = r0 - r4
            float r2 = r2.getBottom()
            float r15 = r15.getBottom()
            float r2 = r2 - r15
            float r15 = performActionHelper$scrollDelta(r0, r2)
            if (r13 == 0) goto L_0x01a9
            boolean r13 = r13.getReverseScrolling()
            if (r13 != r3) goto L_0x01a9
            goto L_0x01aa
        L_0x01a9:
            r3 = r1
        L_0x01aa:
            if (r3 == 0) goto L_0x01ad
            float r15 = -r15
        L_0x01ad:
            if (r14 == 0) goto L_0x01c9
            kotlin.Function r13 = r14.getAction()
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            if (r13 == 0) goto L_0x01c9
            java.lang.Float r14 = java.lang.Float.valueOf(r5)
            java.lang.Float r15 = java.lang.Float.valueOf(r15)
            java.lang.Object r13 = r13.invoke(r14, r15)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x01c9:
            return r1
        L_0x01ca:
            if (r15 == 0) goto L_0x01d2
            java.lang.String r13 = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE"
            java.lang.String r4 = r15.getString(r13)
        L_0x01d2:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getSetText()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x0205
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function1 r13 = (kotlin.jvm.functions.Function1) r13
            if (r13 == 0) goto L_0x0205
            androidx.compose.ui.text.AnnotatedString r14 = new androidx.compose.ui.text.AnnotatedString
            if (r4 != 0) goto L_0x01f2
            java.lang.String r4 = ""
        L_0x01f2:
            r6 = r4
            r7 = 0
            r8 = 0
            r9 = 6
            r10 = 0
            r5 = r14
            r5.<init>(r6, r7, r8, r9, r10)
            java.lang.Object r13 = r13.invoke(r14)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0205:
            return r1
        L_0x0206:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getDismiss()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x022a
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x022a
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x022a:
            return r1
        L_0x022b:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getCollapse()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x024f
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x024f
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x024f:
            return r1
        L_0x0250:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getExpand()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x0274
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x0274
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0274:
            return r1
        L_0x0275:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getCutText()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x0299
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x0299
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0299:
            return r1
        L_0x029a:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getPasteText()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x02be
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x02be
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x02be:
            return r1
        L_0x02bf:
            r13 = 4096(0x1000, float:5.74E-42)
            if (r14 != r13) goto L_0x02c5
            r13 = r3
            goto L_0x02c6
        L_0x02c5:
            r13 = r1
        L_0x02c6:
            r15 = 8192(0x2000, float:1.14794E-41)
            if (r14 != r15) goto L_0x02cc
            r15 = r3
            goto L_0x02cd
        L_0x02cc:
            r15 = r1
        L_0x02cd:
            r2 = 16908345(0x1020039, float:2.387739E-38)
            if (r14 != r2) goto L_0x02d4
            r2 = r3
            goto L_0x02d5
        L_0x02d4:
            r2 = r1
        L_0x02d5:
            r4 = 16908347(0x102003b, float:2.3877394E-38)
            if (r14 != r4) goto L_0x02dc
            r4 = r3
            goto L_0x02dd
        L_0x02dc:
            r4 = r1
        L_0x02dd:
            r5 = 16908344(0x1020038, float:2.3877386E-38)
            if (r14 != r5) goto L_0x02e4
            r5 = r3
            goto L_0x02e5
        L_0x02e4:
            r5 = r1
        L_0x02e5:
            r6 = 16908346(0x102003a, float:2.3877392E-38)
            if (r14 != r6) goto L_0x02ec
            r14 = r3
            goto L_0x02ed
        L_0x02ec:
            r14 = r1
        L_0x02ed:
            if (r2 != 0) goto L_0x02f8
            if (r4 != 0) goto L_0x02f8
            if (r13 != 0) goto L_0x02f8
            if (r15 == 0) goto L_0x02f6
            goto L_0x02f8
        L_0x02f6:
            r6 = r1
            goto L_0x02f9
        L_0x02f8:
            r6 = r3
        L_0x02f9:
            if (r5 != 0) goto L_0x0304
            if (r14 != 0) goto L_0x0304
            if (r13 != 0) goto L_0x0304
            if (r15 == 0) goto L_0x0302
            goto L_0x0304
        L_0x0302:
            r14 = r1
            goto L_0x0305
        L_0x0304:
            r14 = r3
        L_0x0305:
            if (r13 != 0) goto L_0x0309
            if (r15 == 0) goto L_0x039e
        L_0x0309:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getProgressBarRangeInfo()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r7)
            androidx.compose.ui.semantics.ProgressBarRangeInfo r13 = (androidx.compose.ui.semantics.ProgressBarRangeInfo) r13
            androidx.compose.ui.semantics.SemanticsConfiguration r7 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r8 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r8 = r8.getSetProgress()
            java.lang.Object r7 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r7, r8)
            androidx.compose.ui.semantics.AccessibilityAction r7 = (androidx.compose.ui.semantics.AccessibilityAction) r7
            if (r13 == 0) goto L_0x039e
            if (r7 == 0) goto L_0x039e
            kotlin.ranges.ClosedFloatingPointRange r14 = r13.getRange()
            java.lang.Comparable r14 = r14.getEndInclusive()
            java.lang.Number r14 = (java.lang.Number) r14
            float r14 = r14.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r0 = r13.getRange()
            java.lang.Comparable r0 = r0.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            float r14 = kotlin.ranges.RangesKt___RangesKt.coerceAtLeast((float) r14, (float) r0)
            kotlin.ranges.ClosedFloatingPointRange r0 = r13.getRange()
            java.lang.Comparable r0 = r0.getStart()
            java.lang.Number r0 = (java.lang.Number) r0
            float r0 = r0.floatValue()
            kotlin.ranges.ClosedFloatingPointRange r2 = r13.getRange()
            java.lang.Comparable r2 = r2.getEndInclusive()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            float r0 = kotlin.ranges.RangesKt___RangesKt.coerceAtMost((float) r0, (float) r2)
            int r2 = r13.getSteps()
            if (r2 <= 0) goto L_0x037a
            float r14 = r14 - r0
            int r0 = r13.getSteps()
            int r0 = r0 + r3
            goto L_0x037d
        L_0x037a:
            float r14 = r14 - r0
            r0 = 20
        L_0x037d:
            float r0 = (float) r0
            float r14 = r14 / r0
            if (r15 == 0) goto L_0x0382
            float r14 = -r14
        L_0x0382:
            kotlin.Function r15 = r7.getAction()
            kotlin.jvm.functions.Function1 r15 = (kotlin.jvm.functions.Function1) r15
            if (r15 == 0) goto L_0x039d
            float r13 = r13.getCurrent()
            float r13 = r13 + r14
            java.lang.Float r13 = java.lang.Float.valueOf(r13)
            java.lang.Object r13 = r15.invoke(r13)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x039d:
            return r1
        L_0x039e:
            androidx.compose.ui.layout.LayoutInfo r13 = r0.getLayoutInfo()
            androidx.compose.ui.layout.LayoutCoordinates r13 = r13.getCoordinates()
            androidx.compose.ui.geometry.Rect r13 = androidx.compose.ui.layout.LayoutCoordinatesKt.boundsInParent(r13)
            long r7 = r13.m2709getSizeNHjbRc()
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r3 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getScrollBy()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r3)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 != 0) goto L_0x03c1
            return r1
        L_0x03c1:
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r9 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r10 = r9.getHorizontalScrollAxisRange()
            java.lang.Object r3 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r3, r10)
            androidx.compose.ui.semantics.ScrollAxisRange r3 = (androidx.compose.ui.semantics.ScrollAxisRange) r3
            r10 = 0
            if (r3 == 0) goto L_0x0412
            if (r6 == 0) goto L_0x0412
            float r6 = androidx.compose.ui.geometry.Size.m2745getWidthimpl(r7)
            if (r2 != 0) goto L_0x03de
            if (r15 == 0) goto L_0x03df
        L_0x03de:
            float r6 = -r6
        L_0x03df:
            boolean r11 = r3.getReverseScrolling()
            if (r11 == 0) goto L_0x03e6
            float r6 = -r6
        L_0x03e6:
            boolean r11 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(r0)
            if (r11 == 0) goto L_0x03f1
            if (r2 != 0) goto L_0x03f0
            if (r4 == 0) goto L_0x03f1
        L_0x03f0:
            float r6 = -r6
        L_0x03f1:
            boolean r2 = performActionHelper$canScroll(r3, r6)
            if (r2 == 0) goto L_0x0412
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            if (r13 == 0) goto L_0x0411
            java.lang.Float r14 = java.lang.Float.valueOf(r6)
            java.lang.Float r15 = java.lang.Float.valueOf(r10)
            java.lang.Object r13 = r13.invoke(r14, r15)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0411:
            return r1
        L_0x0412:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r9.getVerticalScrollAxisRange()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r2)
            androidx.compose.ui.semantics.ScrollAxisRange r0 = (androidx.compose.ui.semantics.ScrollAxisRange) r0
            if (r0 == 0) goto L_0x0454
            if (r14 == 0) goto L_0x0454
            float r14 = androidx.compose.ui.geometry.Size.m2742getHeightimpl(r7)
            if (r5 != 0) goto L_0x042c
            if (r15 == 0) goto L_0x042d
        L_0x042c:
            float r14 = -r14
        L_0x042d:
            boolean r15 = r0.getReverseScrolling()
            if (r15 == 0) goto L_0x0434
            float r14 = -r14
        L_0x0434:
            boolean r15 = performActionHelper$canScroll(r0, r14)
            if (r15 == 0) goto L_0x0454
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function2 r13 = (kotlin.jvm.functions.Function2) r13
            if (r13 == 0) goto L_0x0454
            java.lang.Float r15 = java.lang.Float.valueOf(r10)
            java.lang.Float r14 = java.lang.Float.valueOf(r14)
            java.lang.Object r13 = r13.invoke(r15, r14)
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0454:
            return r1
        L_0x0455:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getOnLongClick()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x0479
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x0479
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0479:
            return r1
        L_0x047a:
            androidx.compose.ui.semantics.SemanticsConfiguration r14 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r15 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r15 = r15.getOnClick()
            java.lang.Object r14 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r14, r15)
            androidx.compose.ui.semantics.AccessibilityAction r14 = (androidx.compose.ui.semantics.AccessibilityAction) r14
            if (r14 == 0) goto L_0x049b
            kotlin.Function r14 = r14.getAction()
            kotlin.jvm.functions.Function0 r14 = (kotlin.jvm.functions.Function0) r14
            if (r14 == 0) goto L_0x049b
            java.lang.Object r14 = r14.invoke()
            r4 = r14
            java.lang.Boolean r4 = (java.lang.Boolean) r4
        L_0x049b:
            r7 = 1
            r8 = 0
            r9 = 0
            r10 = 12
            r11 = 0
            r5 = r12
            r6 = r13
            b(r5, r6, r7, r8, r9, r10, r11)
            if (r4 == 0) goto L_0x04ac
            boolean r1 = r4.booleanValue()
        L_0x04ac:
            return r1
        L_0x04ad:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r14 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getFocused()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            java.lang.Boolean r14 = java.lang.Boolean.TRUE
            boolean r13 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r13, (java.lang.Object) r14)
            if (r13 == 0) goto L_0x04cd
            androidx.compose.ui.platform.AndroidComposeView r13 = r12.view
            androidx.compose.ui.focus.FocusManager r13 = r13.getFocusManager()
            d0.b.a(r13, r1, r3, r4)
            r1 = r3
        L_0x04cd:
            return r1
        L_0x04ce:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getRequestFocus()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x04f2
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x04f2
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x04f2:
            return r1
        L_0x04f3:
            r13 = -1
            if (r15 == 0) goto L_0x04fd
            java.lang.String r14 = "ACTION_ARGUMENT_SELECTION_START_INT"
            int r14 = r15.getInt(r14, r13)
            goto L_0x04fe
        L_0x04fd:
            r14 = r13
        L_0x04fe:
            if (r15 == 0) goto L_0x0506
            java.lang.String r2 = "ACTION_ARGUMENT_SELECTION_END_INT"
            int r13 = r15.getInt(r2, r13)
        L_0x0506:
            boolean r13 = r12.setAccessibilitySelection(r0, r14, r13, r1)
            if (r13 == 0) goto L_0x051e
            int r14 = r0.getId()
            int r1 = r12.semanticsNodeIdToAccessibilityVirtualNodeId(r14)
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 12
            r6 = 0
            r0 = r12
            b(r0, r1, r2, r3, r4, r5, r6)
        L_0x051e:
            return r13
        L_0x051f:
            androidx.compose.ui.semantics.SemanticsConfiguration r13 = r0.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsActions r14 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r14 = r14.getCopyText()
            java.lang.Object r13 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r13, r14)
            androidx.compose.ui.semantics.AccessibilityAction r13 = (androidx.compose.ui.semantics.AccessibilityAction) r13
            if (r13 == 0) goto L_0x0543
            kotlin.Function r13 = r13.getAction()
            kotlin.jvm.functions.Function0 r13 = (kotlin.jvm.functions.Function0) r13
            if (r13 == 0) goto L_0x0543
            java.lang.Object r13 = r13.invoke()
            java.lang.Boolean r13 = (java.lang.Boolean) r13
            boolean r1 = r13.booleanValue()
        L_0x0543:
            return r1
        L_0x0544:
            if (r15 == 0) goto L_0x055a
            java.lang.String r13 = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT"
            int r13 = r15.getInt(r13)
            java.lang.String r4 = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN"
            boolean r15 = r15.getBoolean(r4)
            if (r14 != r2) goto L_0x0555
            r1 = r3
        L_0x0555:
            boolean r13 = r12.traverseAtGranularity(r0, r13, r1, r15)
            return r13
        L_0x055a:
            return r1
        L_0x055b:
            boolean r13 = r12.clearAccessibilityFocus(r13)
            return r13
        L_0x0560:
            boolean r13 = r12.requestAccessibilityFocus(r13)
            return r13
        L_0x0565:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.performActionHelper(int, int, android.os.Bundle):boolean");
    }

    private static final boolean performActionHelper$canScroll(ScrollAxisRange scrollAxisRange, float f11) {
        return (f11 < 0.0f && scrollAxisRange.getValue().invoke().floatValue() > 0.0f) || (f11 > 0.0f && scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue());
    }

    private static final float performActionHelper$scrollDelta(float f11, float f12) {
        if (Math.signum(f11) == Math.signum(f12)) {
            return Math.abs(f11) < Math.abs(f12) ? f11 : f12;
        }
        return 0.0f;
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollBackward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && scrollAxisRange.getReverseScrolling());
    }

    private static final boolean populateAccessibilityNodeInfoProperties$canScrollForward(ScrollAxisRange scrollAxisRange) {
        return (scrollAxisRange.getValue().invoke().floatValue() < scrollAxisRange.getMaxValue().invoke().floatValue() && !scrollAxisRange.getReverseScrolling()) || (scrollAxisRange.getValue().invoke().floatValue() > 0.0f && scrollAxisRange.getReverseScrolling());
    }

    private final boolean registerScrollingId(int i11, List<ScrollObservationScope> list) {
        boolean z11;
        ScrollObservationScope findById = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(list, i11);
        if (findById != null) {
            z11 = false;
        } else {
            findById = new ScrollObservationScope(i11, this.scrollObservationScopes, (Float) null, (Float) null, (ScrollAxisRange) null, (ScrollAxisRange) null);
            z11 = true;
        }
        this.scrollObservationScopes.add(findById);
        return z11;
    }

    private final boolean requestAccessibilityFocus(int i11) {
        if (!isAccessibilityEnabled() || isAccessibilityFocused(i11)) {
            return false;
        }
        int i12 = this.focusedVirtualViewId;
        if (i12 != Integer.MIN_VALUE) {
            b(this, i12, 65536, (Integer) null, (List) null, 12, (Object) null);
        }
        this.focusedVirtualViewId = i11;
        this.view.invalidate();
        b(this, i11, 32768, (Integer) null, (List) null, 12, (Object) null);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: semanticsChangeChecker$lambda-26  reason: not valid java name */
    public static final void m4812semanticsChangeChecker$lambda26(AndroidComposeViewAccessibilityDelegateCompat androidComposeViewAccessibilityDelegateCompat) {
        Intrinsics.checkNotNullParameter(androidComposeViewAccessibilityDelegateCompat, "this$0");
        d.d(androidComposeViewAccessibilityDelegateCompat.view, false, 1, (Object) null);
        androidComposeViewAccessibilityDelegateCompat.checkForSemanticsChanges();
        androidComposeViewAccessibilityDelegateCompat.checkingForSemanticsChanges = false;
    }

    /* access modifiers changed from: private */
    public final int semanticsNodeIdToAccessibilityVirtualNodeId(int i11) {
        if (i11 == this.view.getSemanticsOwner().getUnmergedRootSemanticsNode().getId()) {
            return -1;
        }
        return i11;
    }

    /* access modifiers changed from: private */
    public final boolean sendEvent(AccessibilityEvent accessibilityEvent) {
        if (!isAccessibilityEnabled()) {
            return false;
        }
        return this.view.getParent().requestSendAccessibilityEvent(this.view, accessibilityEvent);
    }

    private final boolean sendEventForVirtualView(int i11, int i12, Integer num, List<String> list) {
        if (i11 == Integer.MIN_VALUE || !isAccessibilityEnabled()) {
            return false;
        }
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(i11, i12);
        if (num != null) {
            createEvent$ui_release.setContentChangeTypes(num.intValue());
        }
        if (list != null) {
            createEvent$ui_release.setContentDescription(TempListUtilsKt.fastJoinToString$default(list, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null));
        }
        return sendEvent(createEvent$ui_release);
    }

    private final void sendPaneChangeEvents(int i11, int i12, String str) {
        AccessibilityEvent createEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(i11), 32);
        createEvent$ui_release.setContentChangeTypes(i12);
        if (str != null) {
            createEvent$ui_release.getText().add(str);
        }
        sendEvent(createEvent$ui_release);
    }

    private final void sendPendingTextTraversedAtGranularityEvent(int i11) {
        PendingTextTraversedEvent pendingTextTraversedEvent2 = this.pendingTextTraversedEvent;
        if (pendingTextTraversedEvent2 != null) {
            if (i11 == pendingTextTraversedEvent2.getNode().getId()) {
                if (SystemClock.uptimeMillis() - pendingTextTraversedEvent2.getTraverseTime() <= 1000) {
                    AccessibilityEvent createEvent$ui_release = createEvent$ui_release(semanticsNodeIdToAccessibilityVirtualNodeId(pendingTextTraversedEvent2.getNode().getId()), 131072);
                    createEvent$ui_release.setFromIndex(pendingTextTraversedEvent2.getFromIndex());
                    createEvent$ui_release.setToIndex(pendingTextTraversedEvent2.getToIndex());
                    createEvent$ui_release.setAction(pendingTextTraversedEvent2.getAction());
                    createEvent$ui_release.setMovementGranularity(pendingTextTraversedEvent2.getGranularity());
                    createEvent$ui_release.getText().add(getIterableTextForAccessibility(pendingTextTraversedEvent2.getNode()));
                    sendEvent(createEvent$ui_release);
                }
            } else {
                return;
            }
        }
        this.pendingTextTraversedEvent = null;
    }

    /* access modifiers changed from: private */
    public final void sendScrollEventIfNeeded(ScrollObservationScope scrollObservationScope) {
        if (scrollObservationScope.isValid()) {
            this.view.getSnapshotObserver().observeReads$ui_release(scrollObservationScope, this.sendScrollEventIfNeededLambda, new AndroidComposeViewAccessibilityDelegateCompat$sendScrollEventIfNeeded$1(scrollObservationScope, this));
        }
    }

    private final void sendSemanticsStructureChangeEvents(SemanticsNode semanticsNode, SemanticsNodeCopy semanticsNodeCopy) {
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        List<SemanticsNode> replacedChildren$ui_release = semanticsNode.getReplacedChildren$ui_release();
        int size = replacedChildren$ui_release.size();
        for (int i11 = 0; i11 < size; i11++) {
            SemanticsNode semanticsNode2 = replacedChildren$ui_release.get(i11);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode2.getId()))) {
                if (!semanticsNodeCopy.getChildren().contains(Integer.valueOf(semanticsNode2.getId()))) {
                    notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                    return;
                }
                linkedHashSet.add(Integer.valueOf(semanticsNode2.getId()));
            }
        }
        for (Integer intValue : semanticsNodeCopy.getChildren()) {
            if (!linkedHashSet.contains(Integer.valueOf(intValue.intValue()))) {
                notifySubtreeAccessibilityStateChangedIfNeeded(semanticsNode.getLayoutNode$ui_release());
                return;
            }
        }
        List<SemanticsNode> replacedChildren$ui_release2 = semanticsNode.getReplacedChildren$ui_release();
        int size2 = replacedChildren$ui_release2.size();
        for (int i12 = 0; i12 < size2; i12++) {
            SemanticsNode semanticsNode3 = replacedChildren$ui_release2.get(i12);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode3.getId()))) {
                SemanticsNodeCopy semanticsNodeCopy2 = this.previousSemanticsNodes.get(Integer.valueOf(semanticsNode3.getId()));
                Intrinsics.checkNotNull(semanticsNodeCopy2);
                sendSemanticsStructureChangeEvents(semanticsNode3, semanticsNodeCopy2);
            }
        }
    }

    private final void sendSubtreeChangeAccessibilityEvents(LayoutNode layoutNode, ArraySet<Integer> arraySet) {
        LayoutNode access$findClosestParentNode;
        SemanticsModifierNode outerSemantics;
        if (layoutNode.isAttached() && !this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().containsKey(layoutNode)) {
            SemanticsModifierNode outerSemantics2 = SemanticsNodeKt.getOuterSemantics(layoutNode);
            if (outerSemantics2 == null) {
                LayoutNode access$findClosestParentNode2 = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$semanticsWrapper$1.INSTANCE);
                if (access$findClosestParentNode2 != null) {
                    outerSemantics2 = SemanticsNodeKt.getOuterSemantics(access$findClosestParentNode2);
                } else {
                    outerSemantics2 = null;
                }
                if (outerSemantics2 == null) {
                    return;
                }
            }
            if (!(SemanticsModifierNodeKt.collapsedSemanticsConfiguration(outerSemantics2).isMergingSemanticsOfDescendants() || (access$findClosestParentNode = AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(layoutNode, AndroidComposeViewAccessibilityDelegateCompat$sendSubtreeChangeAccessibilityEvents$1.INSTANCE)) == null || (outerSemantics = SemanticsNodeKt.getOuterSemantics(access$findClosestParentNode)) == null)) {
                outerSemantics2 = outerSemantics;
            }
            int semanticsId = DelegatableNodeKt.requireLayoutNode(outerSemantics2).getSemanticsId();
            if (arraySet.add(Integer.valueOf(semanticsId))) {
                b(this, semanticsNodeIdToAccessibilityVirtualNodeId(semanticsId), 2048, 1, (List) null, 8, (Object) null);
            }
        }
    }

    private final boolean setAccessibilitySelection(SemanticsNode semanticsNode, int i11, int i12, boolean z11) {
        String iterableTextForAccessibility;
        Integer num;
        Integer num2;
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        boolean z12 = false;
        if (unmergedConfig$ui_release.contains(semanticsActions.getSetSelection()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            Function3 function3 = (Function3) ((AccessibilityAction) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getSetSelection())).getAction();
            if (function3 != null) {
                return ((Boolean) function3.invoke(Integer.valueOf(i11), Integer.valueOf(i12), Boolean.valueOf(z11))).booleanValue();
            }
            return false;
        } else if ((i11 == i12 && i12 == this.accessibilityCursorPosition) || (iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode)) == null) {
            return false;
        } else {
            if (i11 < 0 || i11 != i12 || i12 > iterableTextForAccessibility.length()) {
                i11 = -1;
            }
            this.accessibilityCursorPosition = i11;
            if (iterableTextForAccessibility.length() > 0) {
                z12 = true;
            }
            int semanticsNodeIdToAccessibilityVirtualNodeId = semanticsNodeIdToAccessibilityVirtualNodeId(semanticsNode.getId());
            Integer num3 = null;
            if (z12) {
                num = Integer.valueOf(this.accessibilityCursorPosition);
            } else {
                num = null;
            }
            if (z12) {
                num2 = Integer.valueOf(this.accessibilityCursorPosition);
            } else {
                num2 = null;
            }
            if (z12) {
                num3 = Integer.valueOf(iterableTextForAccessibility.length());
            }
            sendEvent(createTextSelectionChangedEvent(semanticsNodeIdToAccessibilityVirtualNodeId, num, num2, num3, iterableTextForAccessibility));
            sendPendingTextTraversedAtGranularityEvent(semanticsNode.getId());
            return true;
        }
    }

    private final void setContentInvalid(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        if (unmergedConfig$ui_release.contains(semanticsProperties.getError())) {
            accessibilityNodeInfoCompat.setContentInvalid(true);
            accessibilityNodeInfoCompat.setError((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties.getError()));
        }
    }

    private final void setText(SemanticsNode semanticsNode, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        SpannableString spannableString;
        AnnotatedString annotatedString;
        FontFamily.Resolver fontFamilyResolver = this.view.getFontFamilyResolver();
        AnnotatedString textForTextField = getTextForTextField(semanticsNode.getUnmergedConfig$ui_release());
        SpannableString spannableString2 = null;
        if (textForTextField != null) {
            spannableString = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(textForTextField, this.view.getDensity(), fontFamilyResolver);
        } else {
            spannableString = null;
        }
        SpannableString spannableString3 = (SpannableString) trimToSize(spannableString, 100000);
        List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), SemanticsProperties.INSTANCE.getText());
        if (!(list == null || (annotatedString = (AnnotatedString) CollectionsKt___CollectionsKt.firstOrNull(list)) == null)) {
            spannableString2 = AndroidAccessibilitySpannableString_androidKt.toAccessibilitySpannableString(annotatedString, this.view.getDensity(), fontFamilyResolver);
        }
        SpannableString spannableString4 = (SpannableString) trimToSize(spannableString2, 100000);
        if (spannableString3 == null) {
            spannableString3 = spannableString4;
        }
        accessibilityNodeInfoCompat.setText(spannableString3);
    }

    private final RectF toScreenCoords(SemanticsNode semanticsNode, Rect rect) {
        Rect rect2;
        if (semanticsNode == null) {
            return null;
        }
        Rect r62 = rect.m2713translatek4lQ0M(semanticsNode.m4918getPositionInRootF1C5BW0());
        Rect boundsInRoot = semanticsNode.getBoundsInRoot();
        if (r62.overlaps(boundsInRoot)) {
            rect2 = r62.intersect(boundsInRoot);
        } else {
            rect2 = null;
        }
        if (rect2 == null) {
            return null;
        }
        long r02 = this.view.m4805localToScreenMKHz9U(OffsetKt.Offset(rect2.getLeft(), rect2.getTop()));
        long r52 = this.view.m4805localToScreenMKHz9U(OffsetKt.Offset(rect2.getRight(), rect2.getBottom()));
        return new RectF(Offset.m2676getXimpl(r02), Offset.m2677getYimpl(r02), Offset.m2676getXimpl(r52), Offset.m2677getYimpl(r52));
    }

    private final boolean traverseAtGranularity(SemanticsNode semanticsNode, int i11, boolean z11, boolean z12) {
        boolean z13;
        AccessibilityIterators.TextSegmentIterator iteratorForGranularity;
        int[] iArr;
        int i12;
        int i13;
        int i14;
        int i15;
        int id2 = semanticsNode.getId();
        Integer num = this.previousTraversedNode;
        if (num == null || id2 != num.intValue()) {
            this.accessibilityCursorPosition = -1;
            this.previousTraversedNode = Integer.valueOf(semanticsNode.getId());
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode);
        if (iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0) {
            z13 = true;
        } else {
            z13 = false;
        }
        if (z13 || (iteratorForGranularity = getIteratorForGranularity(semanticsNode, i11)) == null) {
            return false;
        }
        int accessibilitySelectionEnd = getAccessibilitySelectionEnd(semanticsNode);
        if (accessibilitySelectionEnd == -1) {
            if (z11) {
                accessibilitySelectionEnd = 0;
            } else {
                accessibilitySelectionEnd = iterableTextForAccessibility.length();
            }
        }
        if (z11) {
            iArr = iteratorForGranularity.following(accessibilitySelectionEnd);
        } else {
            iArr = iteratorForGranularity.preceding(accessibilitySelectionEnd);
        }
        if (iArr == null) {
            return false;
        }
        int i16 = iArr[0];
        int i17 = iArr[1];
        if (!z12 || !isAccessibilitySelectionExtendable(semanticsNode)) {
            if (z11) {
                i15 = i17;
            } else {
                i15 = i16;
            }
            i12 = i13;
        } else {
            i13 = getAccessibilitySelectionStart(semanticsNode);
            if (i13 == -1) {
                if (z11) {
                    i13 = i16;
                } else {
                    i13 = i17;
                }
            }
            if (z11) {
                i12 = i17;
            } else {
                i12 = i16;
            }
        }
        if (z11) {
            i14 = 256;
        } else {
            i14 = 512;
        }
        this.pendingTextTraversedEvent = new PendingTextTraversedEvent(semanticsNode, i14, i11, i16, i17, SystemClock.uptimeMillis());
        SemanticsNode semanticsNode2 = semanticsNode;
        setAccessibilitySelection(semanticsNode, i13, i12, true);
        return true;
    }

    private final <T extends CharSequence> T trimToSize(T t11, @IntRange(from = 1) int i11) {
        boolean z11;
        boolean z12 = true;
        if (i11 > 0) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            if (!(t11 == null || t11.length() == 0)) {
                z12 = false;
            }
            if (z12 || t11.length() <= i11) {
                return t11;
            }
            int i12 = i11 - 1;
            if (Character.isHighSurrogate(t11.charAt(i12)) && Character.isLowSurrogate(t11.charAt(i11))) {
                i11 = i12;
            }
            T subSequence = t11.subSequence(0, i11);
            Intrinsics.checkNotNull(subSequence, "null cannot be cast to non-null type T of androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.trimToSize");
            return subSequence;
        }
        throw new IllegalArgumentException("Failed requirement.".toString());
    }

    private final void updateHoveredVirtualView(int i11) {
        int i12 = this.hoveredVirtualViewId;
        if (i12 != i11) {
            this.hoveredVirtualViewId = i11;
            b(this, i11, 128, (Integer) null, (List) null, 12, (Object) null);
            b(this, i12, 256, (Integer) null, (List) null, 12, (Object) null);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v16, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v12, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateSemanticsNodesCopyAndPanes() {
        /*
            r6 = this;
            androidx.collection.ArraySet<java.lang.Integer> r0 = r6.paneDisplayed
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005e
            java.lang.Object r1 = r0.next()
            java.lang.Integer r1 = (java.lang.Integer) r1
            java.util.Map r2 = r6.getCurrentSemanticsNodes()
            java.lang.Object r2 = r2.get(r1)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            r3 = 0
            if (r2 == 0) goto L_0x0024
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.getSemanticsNode()
            goto L_0x0025
        L_0x0024:
            r2 = r3
        L_0x0025:
            if (r2 == 0) goto L_0x002d
            boolean r2 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(r2)
            if (r2 != 0) goto L_0x0006
        L_0x002d:
            androidx.collection.ArraySet<java.lang.Integer> r2 = r6.paneDisplayed
            r2.remove(r1)
            java.lang.String r2 = "id"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            int r2 = r1.intValue()
            java.util.Map<java.lang.Integer, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy> r4 = r6.previousSemanticsNodes
            java.lang.Object r1 = r4.get(r1)
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy r1 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy) r1
            if (r1 == 0) goto L_0x0058
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r1.getUnmergedConfig()
            if (r1 == 0) goto L_0x0058
            androidx.compose.ui.semantics.SemanticsProperties r3 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r3.getPaneTitle()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r3)
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
        L_0x0058:
            r1 = 32
            r6.sendPaneChangeEvents(r2, r1, r3)
            goto L_0x0006
        L_0x005e:
            java.util.Map<java.lang.Integer, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy> r0 = r6.previousSemanticsNodes
            r0.clear()
            java.util.Map r0 = r6.getCurrentSemanticsNodes()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x006f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00dd
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            java.lang.Object r2 = r1.getValue()
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.getSemanticsNode()
            boolean r2 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.hasPaneTitle(r2)
            if (r2 == 0) goto L_0x00c0
            androidx.collection.ArraySet<java.lang.Integer> r2 = r6.paneDisplayed
            java.lang.Object r3 = r1.getKey()
            boolean r2 = r2.add(r3)
            if (r2 == 0) goto L_0x00c0
            java.lang.Object r2 = r1.getKey()
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r3 = r1.getValue()
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r3 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r3
            androidx.compose.ui.semantics.SemanticsNode r3 = r3.getSemanticsNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r3.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsProperties r4 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r4.getPaneTitle()
            java.lang.Object r3 = r3.get(r4)
            java.lang.String r3 = (java.lang.String) r3
            r4 = 16
            r6.sendPaneChangeEvents(r2, r4, r3)
        L_0x00c0:
            java.util.Map<java.lang.Integer, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy> r2 = r6.previousSemanticsNodes
            java.lang.Object r3 = r1.getKey()
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy r4 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy
            java.lang.Object r1 = r1.getValue()
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r1 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r1
            androidx.compose.ui.semantics.SemanticsNode r1 = r1.getSemanticsNode()
            java.util.Map r5 = r6.getCurrentSemanticsNodes()
            r4.<init>(r1, r5)
            r2.put(r3, r4)
            goto L_0x006f
        L_0x00dd:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy
            androidx.compose.ui.platform.AndroidComposeView r1 = r6.view
            androidx.compose.ui.semantics.SemanticsOwner r1 = r1.getSemanticsOwner()
            androidx.compose.ui.semantics.SemanticsNode r1 = r1.getUnmergedRootSemanticsNode()
            java.util.Map r2 = r6.getCurrentSemanticsNodes()
            r0.<init>(r1, r2)
            r6.previousSemanticsRoot = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.updateSemanticsNodesCopyAndPanes():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0054  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0071 A[Catch:{ all -> 0x0051 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0072 A[Catch:{ all -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x007d A[Catch:{ all -> 0x0051 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    @org.jetbrains.annotations.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object boundsUpdatesEventLoop(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r11) {
        /*
            r10 = this;
            boolean r0 = r11 instanceof androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            if (r0 == 0) goto L_0x0013
            r0 = r11
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1) r0
            int r1 = r0.f9994m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9994m = r1
            goto L_0x0018
        L_0x0013:
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1 r0 = new androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$boundsUpdatesEventLoop$1
            r0.<init>(r10, r11)
        L_0x0018:
            java.lang.Object r11 = r0.f9992k
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.f9994m
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0054
            if (r2 == r4) goto L_0x0041
            if (r2 != r3) goto L_0x0039
            java.lang.Object r2 = r0.f9991j
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.f9990i
            androidx.collection.ArraySet r5 = (androidx.collection.ArraySet) r5
            java.lang.Object r6 = r0.f9989h
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r6 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r6
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0051 }
        L_0x0037:
            r11 = r5
            goto L_0x0063
        L_0x0039:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L_0x0041:
            java.lang.Object r2 = r0.f9991j
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r5 = r0.f9990i
            androidx.collection.ArraySet r5 = (androidx.collection.ArraySet) r5
            java.lang.Object r6 = r0.f9989h
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat r6 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat) r6
            kotlin.ResultKt.throwOnFailure(r11)     // Catch:{ all -> 0x0051 }
            goto L_0x0075
        L_0x0051:
            r11 = move-exception
            goto L_0x00d0
        L_0x0054:
            kotlin.ResultKt.throwOnFailure(r11)
            androidx.collection.ArraySet r11 = new androidx.collection.ArraySet     // Catch:{ all -> 0x00ce }
            r11.<init>()     // Catch:{ all -> 0x00ce }
            kotlinx.coroutines.channels.Channel<kotlin.Unit> r2 = r10.boundsUpdateChannel     // Catch:{ all -> 0x00ce }
            kotlinx.coroutines.channels.ChannelIterator r2 = r2.iterator()     // Catch:{ all -> 0x00ce }
            r6 = r10
        L_0x0063:
            r0.f9989h = r6     // Catch:{ all -> 0x0051 }
            r0.f9990i = r11     // Catch:{ all -> 0x0051 }
            r0.f9991j = r2     // Catch:{ all -> 0x0051 }
            r0.f9994m = r4     // Catch:{ all -> 0x0051 }
            java.lang.Object r5 = r2.hasNext(r0)     // Catch:{ all -> 0x0051 }
            if (r5 != r1) goto L_0x0072
            return r1
        L_0x0072:
            r9 = r5
            r5 = r11
            r11 = r9
        L_0x0075:
            java.lang.Boolean r11 = (java.lang.Boolean) r11     // Catch:{ all -> 0x0051 }
            boolean r11 = r11.booleanValue()     // Catch:{ all -> 0x0051 }
            if (r11 == 0) goto L_0x00c6
            r2.next()     // Catch:{ all -> 0x0051 }
            boolean r11 = r6.isAccessibilityEnabled()     // Catch:{ all -> 0x0051 }
            if (r11 == 0) goto L_0x00b0
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r11 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0051 }
            int r11 = r11.size()     // Catch:{ all -> 0x0051 }
            r7 = 0
        L_0x008d:
            if (r7 >= r11) goto L_0x00a0
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r8 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0051 }
            java.lang.Object r8 = r8.valueAt(r7)     // Catch:{ all -> 0x0051 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r8)     // Catch:{ all -> 0x0051 }
            androidx.compose.ui.node.LayoutNode r8 = (androidx.compose.ui.node.LayoutNode) r8     // Catch:{ all -> 0x0051 }
            r6.sendSubtreeChangeAccessibilityEvents(r8, r5)     // Catch:{ all -> 0x0051 }
            int r7 = r7 + 1
            goto L_0x008d
        L_0x00a0:
            r5.clear()     // Catch:{ all -> 0x0051 }
            boolean r11 = r6.checkingForSemanticsChanges     // Catch:{ all -> 0x0051 }
            if (r11 != 0) goto L_0x00b0
            r6.checkingForSemanticsChanges = r4     // Catch:{ all -> 0x0051 }
            android.os.Handler r11 = r6.handler     // Catch:{ all -> 0x0051 }
            java.lang.Runnable r7 = r6.semanticsChangeChecker     // Catch:{ all -> 0x0051 }
            r11.post(r7)     // Catch:{ all -> 0x0051 }
        L_0x00b0:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r11 = r6.subtreeChangedLayoutNodes     // Catch:{ all -> 0x0051 }
            r11.clear()     // Catch:{ all -> 0x0051 }
            r0.f9989h = r6     // Catch:{ all -> 0x0051 }
            r0.f9990i = r5     // Catch:{ all -> 0x0051 }
            r0.f9991j = r2     // Catch:{ all -> 0x0051 }
            r0.f9994m = r3     // Catch:{ all -> 0x0051 }
            r7 = 100
            java.lang.Object r11 = kotlinx.coroutines.DelayKt.delay(r7, r0)     // Catch:{ all -> 0x0051 }
            if (r11 != r1) goto L_0x0037
            return r1
        L_0x00c6:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r11 = r6.subtreeChangedLayoutNodes
            r11.clear()
            kotlin.Unit r11 = kotlin.Unit.INSTANCE
            return r11
        L_0x00ce:
            r11 = move-exception
            r6 = r10
        L_0x00d0:
            androidx.collection.ArraySet<androidx.compose.ui.node.LayoutNode> r0 = r6.subtreeChangedLayoutNodes
            r0.clear()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.boundsUpdatesEventLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* renamed from: canScroll-0AR0LA0$ui_release  reason: not valid java name */
    public final boolean m4813canScroll0AR0LA0$ui_release(boolean z11, int i11, long j11) {
        return m4814canScrollmoWRBKg$ui_release(getCurrentSemanticsNodes().values(), z11, i11, j11);
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00b5 A[SYNTHETIC] */
    @androidx.annotation.VisibleForTesting(otherwise = 2)
    /* renamed from: canScroll-moWRBKg$ui_release  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean m4814canScrollmoWRBKg$ui_release(@org.jetbrains.annotations.NotNull java.util.Collection<androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r6, boolean r7, int r8, long r9) {
        /*
            r5 = this;
            java.lang.String r0 = "currentSemanticsNodes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            androidx.compose.ui.geometry.Offset$Companion r0 = androidx.compose.ui.geometry.Offset.Companion
            long r0 = r0.m2691getUnspecifiedF1C5BW0()
            boolean r0 = androidx.compose.ui.geometry.Offset.m2673equalsimpl0(r9, r0)
            r1 = 0
            if (r0 != 0) goto L_0x00bd
            boolean r0 = androidx.compose.ui.geometry.Offset.m2679isValidimpl(r9)
            if (r0 != 0) goto L_0x001a
            goto L_0x00bd
        L_0x001a:
            r0 = 1
            if (r7 != r0) goto L_0x0024
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getVerticalScrollAxisRange()
            goto L_0x002c
        L_0x0024:
            if (r7 != 0) goto L_0x00b7
            androidx.compose.ui.semantics.SemanticsProperties r7 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r7 = r7.getHorizontalScrollAxisRange()
        L_0x002c:
            java.lang.Iterable r6 = (java.lang.Iterable) r6
            r2 = r6
            java.util.Collection r2 = (java.util.Collection) r2
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L_0x0039
            goto L_0x00b6
        L_0x0039:
            java.util.Iterator r6 = r6.iterator()
        L_0x003d:
            boolean r2 = r6.hasNext()
            if (r2 == 0) goto L_0x00b6
            java.lang.Object r2 = r6.next()
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r2 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r2
            android.graphics.Rect r3 = r2.getAdjustedBounds()
            androidx.compose.ui.geometry.Rect r3 = androidx.compose.ui.graphics.RectHelper_androidKt.toComposeRect(r3)
            boolean r3 = r3.m2702containsk4lQ0M(r9)
            if (r3 != 0) goto L_0x0059
        L_0x0057:
            r2 = r1
            goto L_0x00b3
        L_0x0059:
            androidx.compose.ui.semantics.SemanticsNode r2 = r2.getSemanticsNode()
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r2.getConfig()
            java.lang.Object r2 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r7)
            androidx.compose.ui.semantics.ScrollAxisRange r2 = (androidx.compose.ui.semantics.ScrollAxisRange) r2
            if (r2 != 0) goto L_0x006a
            goto L_0x0057
        L_0x006a:
            boolean r3 = r2.getReverseScrolling()
            if (r3 == 0) goto L_0x0072
            int r3 = -r8
            goto L_0x0073
        L_0x0072:
            r3 = r8
        L_0x0073:
            if (r8 != 0) goto L_0x007c
            boolean r4 = r2.getReverseScrolling()
            if (r4 == 0) goto L_0x007c
            r3 = -1
        L_0x007c:
            if (r3 >= 0) goto L_0x0092
            kotlin.jvm.functions.Function0 r2 = r2.getValue()
            java.lang.Object r2 = r2.invoke()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            r3 = 0
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x0057
            goto L_0x00b2
        L_0x0092:
            kotlin.jvm.functions.Function0 r3 = r2.getValue()
            java.lang.Object r3 = r3.invoke()
            java.lang.Number r3 = (java.lang.Number) r3
            float r3 = r3.floatValue()
            kotlin.jvm.functions.Function0 r2 = r2.getMaxValue()
            java.lang.Object r2 = r2.invoke()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            int r2 = (r3 > r2 ? 1 : (r3 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0057
        L_0x00b2:
            r2 = r0
        L_0x00b3:
            if (r2 == 0) goto L_0x003d
            r1 = r0
        L_0x00b6:
            return r1
        L_0x00b7:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        L_0x00bd:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.m4814canScrollmoWRBKg$ui_release(java.util.Collection, boolean, int, long):boolean");
    }

    @NotNull
    @VisibleForTesting
    public final AccessibilityEvent createEvent$ui_release(int i11, int i12) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i12);
        Intrinsics.checkNotNullExpressionValue(obtain, "obtain(eventType)");
        obtain.setEnabled(true);
        obtain.setClassName(ClassName);
        obtain.setPackageName(this.view.getContext().getPackageName());
        obtain.setSource(this.view, i11);
        SemanticsNodeWithAdjustedBounds semanticsNodeWithAdjustedBounds = getCurrentSemanticsNodes().get(Integer.valueOf(i11));
        if (semanticsNodeWithAdjustedBounds != null) {
            obtain.setPassword(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNodeWithAdjustedBounds.getSemanticsNode()));
        }
        return obtain;
    }

    public final boolean dispatchHoverEvent(@NotNull MotionEvent motionEvent) {
        Intrinsics.checkNotNullParameter(motionEvent, "event");
        if (!isAccessibilityEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int hitTestSemanticsAt$ui_release = hitTestSemanticsAt$ui_release(motionEvent.getX(), motionEvent.getY());
            boolean dispatchGenericMotionEvent = this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            updateHoveredVirtualView(hitTestSemanticsAt$ui_release);
            if (hitTestSemanticsAt$ui_release == Integer.MIN_VALUE) {
                return dispatchGenericMotionEvent;
            }
            return true;
        } else if (action != 10) {
            return false;
        } else {
            if (this.hoveredVirtualViewId == Integer.MIN_VALUE) {
                return this.view.getAndroidViewsHandler$ui_release().dispatchGenericMotionEvent(motionEvent);
            }
            updateHoveredVirtualView(Integer.MIN_VALUE);
            return true;
        }
    }

    public final boolean getAccessibilityForceEnabledForTesting$ui_release() {
        return this.accessibilityForceEnabledForTesting;
    }

    @NotNull
    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(@NotNull View view2) {
        Intrinsics.checkNotNullParameter(view2, URLProtectionSpaceContract.FeedEntry.COLUMN_NAME_HOST);
        return this.nodeProvider;
    }

    public final int getHoveredVirtualViewId$ui_release() {
        return this.hoveredVirtualViewId;
    }

    @NotNull
    public final Map<Integer, SemanticsNodeCopy> getPreviousSemanticsNodes$ui_release() {
        return this.previousSemanticsNodes;
    }

    @NotNull
    public final AndroidComposeView getView() {
        return this.view;
    }

    @VisibleForTesting
    public final int hitTestSemanticsAt$ui_release(float f11, float f12) {
        LayoutNode requireLayoutNode;
        SemanticsModifierNode semanticsModifierNode = null;
        d.d(this.view, false, 1, (Object) null);
        HitTestResult hitTestResult = new HitTestResult();
        LayoutNode.m4618hitTestSemanticsM_7yMNQ$ui_release$default(this.view.getRoot(), OffsetKt.Offset(f11, f12), hitTestResult, false, false, 12, (Object) null);
        SemanticsModifierNode semanticsModifierNode2 = (SemanticsModifierNode) CollectionsKt___CollectionsKt.lastOrNull(hitTestResult);
        if (!(semanticsModifierNode2 == null || (requireLayoutNode = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode2)) == null)) {
            semanticsModifierNode = SemanticsNodeKt.getOuterSemantics(requireLayoutNode);
        }
        if (semanticsModifierNode != null) {
            SemanticsNode semanticsNode = new SemanticsNode(semanticsModifierNode, false, (LayoutNode) null, 4, (DefaultConstructorMarker) null);
            NodeCoordinator findCoordinatorToGetBounds$ui_release = semanticsNode.findCoordinatorToGetBounds$ui_release();
            if (!semanticsNode.getUnmergedConfig$ui_release().contains(SemanticsProperties.INSTANCE.getInvisibleToUser()) && !findCoordinatorToGetBounds$ui_release.isTransparent()) {
                LayoutNode requireLayoutNode2 = DelegatableNodeKt.requireLayoutNode(semanticsModifierNode);
                if (this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(requireLayoutNode2) == null) {
                    return semanticsNodeIdToAccessibilityVirtualNodeId(requireLayoutNode2.getSemanticsId());
                }
            }
        }
        return Integer.MIN_VALUE;
    }

    public final void onLayoutChange$ui_release(@NotNull LayoutNode layoutNode) {
        Intrinsics.checkNotNullParameter(layoutNode, "layoutNode");
        this.currentSemanticsNodesInvalidated = true;
        if (isAccessibilityEnabled()) {
            notifySubtreeAccessibilityStateChangedIfNeeded(layoutNode);
        }
    }

    public final void onSemanticsChange$ui_release() {
        this.currentSemanticsNodesInvalidated = true;
        if (isAccessibilityEnabled() && !this.checkingForSemanticsChanges) {
            this.checkingForSemanticsChanges = true;
            this.handler.post(this.semanticsChangeChecker);
        }
    }

    @VisibleForTesting
    public final void populateAccessibilityNodeInfoProperties(int i11, @NotNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, @NotNull SemanticsNode semanticsNode) {
        NodeCoordinator nodeCoordinator;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat;
        AccessibilityNodeInfoCompat.AccessibilityActionCompat accessibilityActionCompat2;
        float f11;
        int i12;
        boolean z11;
        String str;
        String str2;
        int i13 = i11;
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat2 = accessibilityNodeInfoCompat;
        SemanticsNode semanticsNode2 = semanticsNode;
        Intrinsics.checkNotNullParameter(accessibilityNodeInfoCompat2, CustomerInfoLocalDataSourceImpl.KEY);
        Intrinsics.checkNotNullParameter(semanticsNode2, "semanticsNode");
        boolean z12 = !semanticsNode.isFake$ui_release() && semanticsNode.getReplacedChildren$ui_release().isEmpty() && AndroidComposeViewAccessibilityDelegateCompat_androidKt.findClosestParentNode(semanticsNode.getLayoutNode$ui_release(), AndroidComposeViewAccessibilityDelegateCompat$populateAccessibilityNodeInfoProperties$isUnmergedLeafNode$1.INSTANCE) == null;
        accessibilityNodeInfoCompat2.setClassName(ClassName);
        SemanticsConfiguration unmergedConfig$ui_release = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties = SemanticsProperties.INSTANCE;
        Role role = (Role) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release, semanticsProperties.getRole());
        String str3 = null;
        if (role != null) {
            int r102 = role.m4910unboximpl();
            if (semanticsNode.isFake$ui_release() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
                Role.Companion companion = Role.Companion;
                if (Role.m4907equalsimpl0(role.m4910unboximpl(), companion.m4916getTabo7Vup1c())) {
                    accessibilityNodeInfoCompat2.setRoleDescription(this.view.getContext().getResources().getString(R.string.tab));
                } else {
                    if (Role.m4907equalsimpl0(r102, companion.m4911getButtono7Vup1c())) {
                        str2 = "android.widget.Button";
                    } else if (Role.m4907equalsimpl0(r102, companion.m4912getCheckboxo7Vup1c())) {
                        str2 = "android.widget.CheckBox";
                    } else if (Role.m4907equalsimpl0(r102, companion.m4915getSwitcho7Vup1c())) {
                        str2 = "android.widget.Switch";
                    } else if (Role.m4907equalsimpl0(r102, companion.m4914getRadioButtono7Vup1c())) {
                        str2 = "android.widget.RadioButton";
                    } else {
                        str2 = Role.m4907equalsimpl0(r102, companion.m4913getImageo7Vup1c()) ? "android.widget.ImageView" : null;
                    }
                    if (!Role.m4907equalsimpl0(role.m4910unboximpl(), companion.m4913getImageo7Vup1c()) || z12 || semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants()) {
                        accessibilityNodeInfoCompat2.setClassName(str2);
                    }
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode)) {
            accessibilityNodeInfoCompat2.setClassName("android.widget.EditText");
        }
        if (semanticsNode.getConfig().contains(semanticsProperties.getText())) {
            accessibilityNodeInfoCompat2.setClassName("android.widget.TextView");
        }
        accessibilityNodeInfoCompat2.setPackageName(this.view.getContext().getPackageName());
        accessibilityNodeInfoCompat2.setImportantForAccessibility(true);
        List<SemanticsNode> replacedChildrenSortedByBounds$ui_release = semanticsNode.getReplacedChildrenSortedByBounds$ui_release();
        int size = replacedChildrenSortedByBounds$ui_release.size();
        for (int i14 = 0; i14 < size; i14++) {
            SemanticsNode semanticsNode3 = replacedChildrenSortedByBounds$ui_release.get(i14);
            if (getCurrentSemanticsNodes().containsKey(Integer.valueOf(semanticsNode3.getId()))) {
                AndroidViewHolder androidViewHolder = this.view.getAndroidViewsHandler$ui_release().getLayoutNodeToHolder().get(semanticsNode3.getLayoutNode$ui_release());
                if (androidViewHolder != null) {
                    accessibilityNodeInfoCompat2.addChild(androidViewHolder);
                } else {
                    accessibilityNodeInfoCompat2.addChild(this.view, semanticsNode3.getId());
                }
            }
        }
        if (this.focusedVirtualViewId == i13) {
            accessibilityNodeInfoCompat2.setAccessibilityFocused(true);
            accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_CLEAR_ACCESSIBILITY_FOCUS);
        } else {
            accessibilityNodeInfoCompat2.setAccessibilityFocused(false);
            accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_ACCESSIBILITY_FOCUS);
        }
        setText(semanticsNode2, accessibilityNodeInfoCompat2);
        setContentInvalid(semanticsNode2, accessibilityNodeInfoCompat2);
        SemanticsConfiguration unmergedConfig$ui_release2 = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties2 = SemanticsProperties.INSTANCE;
        accessibilityNodeInfoCompat2.setStateDescription((CharSequence) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release2, semanticsProperties2.getStateDescription()));
        ToggleableState toggleableState = (ToggleableState) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties2.getToggleableState());
        int i15 = 2;
        if (toggleableState != null) {
            accessibilityNodeInfoCompat2.setCheckable(true);
            int i16 = WhenMappings.$EnumSwitchMapping$0[toggleableState.ordinal()];
            if (i16 == 1) {
                accessibilityNodeInfoCompat2.setChecked(true);
                if ((role == null ? false : Role.m4907equalsimpl0(role.m4910unboximpl(), Role.Companion.m4915getSwitcho7Vup1c())) && accessibilityNodeInfoCompat.getStateDescription() == null) {
                    accessibilityNodeInfoCompat2.setStateDescription(this.view.getContext().getResources().getString(R.string.f9555on));
                }
            } else if (i16 == 2) {
                accessibilityNodeInfoCompat2.setChecked(false);
                if ((role == null ? false : Role.m4907equalsimpl0(role.m4910unboximpl(), Role.Companion.m4915getSwitcho7Vup1c())) && accessibilityNodeInfoCompat.getStateDescription() == null) {
                    accessibilityNodeInfoCompat2.setStateDescription(this.view.getContext().getResources().getString(R.string.off));
                }
            } else if (i16 == 3 && accessibilityNodeInfoCompat.getStateDescription() == null) {
                accessibilityNodeInfoCompat2.setStateDescription(this.view.getContext().getResources().getString(R.string.indeterminate));
            }
            Unit unit2 = Unit.INSTANCE;
        }
        Boolean bool = (Boolean) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties2.getSelected());
        if (bool != null) {
            boolean booleanValue = bool.booleanValue();
            if (role == null ? false : Role.m4907equalsimpl0(role.m4910unboximpl(), Role.Companion.m4916getTabo7Vup1c())) {
                accessibilityNodeInfoCompat2.setSelected(booleanValue);
            } else {
                accessibilityNodeInfoCompat2.setCheckable(true);
                accessibilityNodeInfoCompat2.setChecked(booleanValue);
                if (accessibilityNodeInfoCompat.getStateDescription() == null) {
                    if (booleanValue) {
                        str = this.view.getContext().getResources().getString(R.string.selected);
                    } else {
                        str = this.view.getContext().getResources().getString(R.string.not_selected);
                    }
                    accessibilityNodeInfoCompat2.setStateDescription(str);
                }
            }
            Unit unit3 = Unit.INSTANCE;
        }
        if (!semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || semanticsNode.getReplacedChildren$ui_release().isEmpty()) {
            List list = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties2.getContentDescription());
            accessibilityNodeInfoCompat2.setContentDescription(list != null ? (String) CollectionsKt___CollectionsKt.firstOrNull(list) : null);
        }
        String str4 = (String) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties2.getTestTag());
        if (str4 != null) {
            SemanticsNode semanticsNode4 = semanticsNode2;
            while (true) {
                if (semanticsNode4 == null) {
                    z11 = false;
                    break;
                }
                SemanticsConfiguration unmergedConfig$ui_release3 = semanticsNode4.getUnmergedConfig$ui_release();
                SemanticsPropertiesAndroid semanticsPropertiesAndroid = SemanticsPropertiesAndroid.INSTANCE;
                if (unmergedConfig$ui_release3.contains(semanticsPropertiesAndroid.getTestTagsAsResourceId())) {
                    z11 = ((Boolean) semanticsNode4.getUnmergedConfig$ui_release().get(semanticsPropertiesAndroid.getTestTagsAsResourceId())).booleanValue();
                    break;
                }
                semanticsNode4 = semanticsNode4.getParent();
            }
            if (z11) {
                accessibilityNodeInfoCompat2.setViewIdResourceName(str4);
            }
        }
        SemanticsConfiguration unmergedConfig$ui_release4 = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsProperties semanticsProperties3 = SemanticsProperties.INSTANCE;
        if (((Unit) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release4, semanticsProperties3.getHeading())) != null) {
            accessibilityNodeInfoCompat2.setHeading(true);
            Unit unit4 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat2.setPassword(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isPassword(semanticsNode));
        accessibilityNodeInfoCompat2.setEditable(AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(semanticsNode));
        accessibilityNodeInfoCompat2.setEnabled(AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode));
        accessibilityNodeInfoCompat2.setFocusable(semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties3.getFocused()));
        if (accessibilityNodeInfoCompat.isFocusable()) {
            accessibilityNodeInfoCompat2.setFocused(((Boolean) semanticsNode.getUnmergedConfig$ui_release().get(semanticsProperties3.getFocused())).booleanValue());
            if (accessibilityNodeInfoCompat.isFocused()) {
                accessibilityNodeInfoCompat2.addAction(2);
            } else {
                accessibilityNodeInfoCompat2.addAction(1);
            }
        }
        if (semanticsNode.isFake$ui_release()) {
            SemanticsNode parent = semanticsNode.getParent();
            nodeCoordinator = parent != null ? parent.findCoordinatorToGetBounds$ui_release() : null;
        } else {
            nodeCoordinator = semanticsNode.findCoordinatorToGetBounds$ui_release();
        }
        accessibilityNodeInfoCompat2.setVisibleToUser(!(nodeCoordinator != null ? nodeCoordinator.isTransparent() : false) && SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getInvisibleToUser()) == null);
        LiveRegionMode liveRegionMode = (LiveRegionMode) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getLiveRegion());
        if (liveRegionMode != null) {
            int r72 = liveRegionMode.m4901unboximpl();
            LiveRegionMode.Companion companion2 = LiveRegionMode.Companion;
            if (LiveRegionMode.m4898equalsimpl0(r72, companion2.m4903getPolite0phEisY()) || !LiveRegionMode.m4898equalsimpl0(r72, companion2.m4902getAssertive0phEisY())) {
                i15 = 1;
            }
            accessibilityNodeInfoCompat2.setLiveRegion(i15);
            Unit unit5 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat2.setClickable(false);
        SemanticsConfiguration unmergedConfig$ui_release5 = semanticsNode.getUnmergedConfig$ui_release();
        SemanticsActions semanticsActions = SemanticsActions.INSTANCE;
        AccessibilityAction accessibilityAction = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(unmergedConfig$ui_release5, semanticsActions.getOnClick());
        if (accessibilityAction != null) {
            boolean areEqual = Intrinsics.areEqual(SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getSelected()), (Object) Boolean.TRUE);
            accessibilityNodeInfoCompat2.setClickable(!areEqual);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode) && !areEqual) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16, accessibilityAction.getLabel()));
            }
            Unit unit6 = Unit.INSTANCE;
        }
        accessibilityNodeInfoCompat2.setLongClickable(false);
        AccessibilityAction accessibilityAction2 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getOnLongClick());
        if (accessibilityAction2 != null) {
            accessibilityNodeInfoCompat2.setLongClickable(true);
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32, accessibilityAction2.getLabel()));
            }
            Unit unit7 = Unit.INSTANCE;
        }
        AccessibilityAction accessibilityAction3 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getCopyText());
        if (accessibilityAction3 != null) {
            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(16384, accessibilityAction3.getLabel()));
            Unit unit8 = Unit.INSTANCE;
        }
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction accessibilityAction4 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getSetText());
            if (accessibilityAction4 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(2097152, accessibilityAction4.getLabel()));
                Unit unit9 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction5 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getCutText());
            if (accessibilityAction5 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(65536, accessibilityAction5.getLabel()));
                Unit unit10 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction6 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getPasteText());
            if (accessibilityAction6 != null) {
                if (accessibilityNodeInfoCompat.isFocused() && this.view.getClipboardManager().hasText()) {
                    accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(32768, accessibilityAction6.getLabel()));
                }
                Unit unit11 = Unit.INSTANCE;
            }
        }
        String iterableTextForAccessibility = getIterableTextForAccessibility(semanticsNode2);
        if (!(iterableTextForAccessibility == null || iterableTextForAccessibility.length() == 0)) {
            accessibilityNodeInfoCompat2.setTextSelection(getAccessibilitySelectionStart(semanticsNode2), getAccessibilitySelectionEnd(semanticsNode2));
            AccessibilityAction accessibilityAction7 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getSetSelection());
            if (accessibilityAction7 != null) {
                str3 = accessibilityAction7.getLabel();
            }
            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(131072, str3));
            accessibilityNodeInfoCompat2.addAction(256);
            accessibilityNodeInfoCompat2.addAction(512);
            accessibilityNodeInfoCompat2.setMovementGranularities(11);
            Collection collection = (List) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getContentDescription());
            if ((collection == null || collection.isEmpty()) && semanticsNode.getUnmergedConfig$ui_release().contains(semanticsActions.getGetTextLayoutResult()) && !AndroidComposeViewAccessibilityDelegateCompat_androidKt.excludeLineAndPageGranularities(semanticsNode)) {
                accessibilityNodeInfoCompat2.setMovementGranularities(accessibilityNodeInfoCompat.getMovementGranularities() | 4 | 16);
            }
        }
        int i17 = Build.VERSION.SDK_INT;
        if (i17 >= 26) {
            ArrayList arrayList = new ArrayList();
            CharSequence text = accessibilityNodeInfoCompat.getText();
            if (!(text == null || text.length() == 0) && semanticsNode.getUnmergedConfig$ui_release().contains(semanticsActions.getGetTextLayoutResult())) {
                arrayList.add("android.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY");
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(semanticsProperties3.getTestTag())) {
                arrayList.add(ExtraDataTestTagKey);
            }
            if (!arrayList.isEmpty()) {
                AccessibilityNodeInfoVerificationHelperMethods accessibilityNodeInfoVerificationHelperMethods = AccessibilityNodeInfoVerificationHelperMethods.INSTANCE;
                AccessibilityNodeInfo unwrap = accessibilityNodeInfoCompat.unwrap();
                Intrinsics.checkNotNullExpressionValue(unwrap, "info.unwrap()");
                accessibilityNodeInfoVerificationHelperMethods.setAvailableExtraData(unwrap, arrayList);
            }
        }
        ProgressBarRangeInfo progressBarRangeInfo = (ProgressBarRangeInfo) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getProgressBarRangeInfo());
        if (progressBarRangeInfo != null) {
            if (semanticsNode.getUnmergedConfig$ui_release().contains(semanticsActions.getSetProgress())) {
                accessibilityNodeInfoCompat2.setClassName("android.widget.SeekBar");
            } else {
                accessibilityNodeInfoCompat2.setClassName("android.widget.ProgressBar");
            }
            if (progressBarRangeInfo != ProgressBarRangeInfo.Companion.getIndeterminate()) {
                accessibilityNodeInfoCompat2.setRangeInfo(AccessibilityNodeInfoCompat.RangeInfoCompat.obtain(1, progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getCurrent()));
                if (accessibilityNodeInfoCompat.getStateDescription() == null) {
                    ClosedFloatingPointRange<Float> range = progressBarRangeInfo.getRange();
                    if (range.getEndInclusive().floatValue() - range.getStart().floatValue() == 0.0f) {
                        f11 = 0.0f;
                    } else {
                        f11 = (progressBarRangeInfo.getCurrent() - range.getStart().floatValue()) / (range.getEndInclusive().floatValue() - range.getStart().floatValue());
                    }
                    float coerceIn = RangesKt___RangesKt.coerceIn(f11, 0.0f, 1.0f);
                    if (coerceIn == 0.0f) {
                        i12 = 0;
                    } else {
                        i12 = 100;
                        if (!(coerceIn == 1.0f)) {
                            i12 = RangesKt___RangesKt.coerceIn(MathKt__MathJVMKt.roundToInt(coerceIn * ((float) 100)), 1, 99);
                        }
                    }
                    accessibilityNodeInfoCompat2.setStateDescription(this.view.getContext().getResources().getString(R.string.template_percent, new Object[]{Integer.valueOf(i12)}));
                }
            } else if (accessibilityNodeInfoCompat.getStateDescription() == null) {
                accessibilityNodeInfoCompat2.setStateDescription(this.view.getContext().getResources().getString(R.string.in_progress));
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(semanticsActions.getSetProgress()) && AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (progressBarRangeInfo.getCurrent() < RangesKt___RangesKt.coerceAtLeast(progressBarRangeInfo.getRange().getEndInclusive().floatValue(), progressBarRangeInfo.getRange().getStart().floatValue())) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                }
                if (progressBarRangeInfo.getCurrent() > RangesKt___RangesKt.coerceAtMost(progressBarRangeInfo.getRange().getStart().floatValue(), progressBarRangeInfo.getRange().getEndInclusive().floatValue())) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                }
            }
        }
        if (i17 >= 24) {
            Api24Impl.addSetProgressAction(accessibilityNodeInfoCompat, semanticsNode);
        }
        CollectionInfoKt.setCollectionInfo(semanticsNode2, accessibilityNodeInfoCompat2);
        CollectionInfoKt.setCollectionItemInfo(semanticsNode2, accessibilityNodeInfoCompat2);
        ScrollAxisRange scrollAxisRange = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getHorizontalScrollAxisRange());
        AccessibilityAction accessibilityAction8 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getScrollBy());
        if (!(scrollAxisRange == null || accessibilityAction8 == null)) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat2.setClassName("android.widget.HorizontalScrollView");
            }
            if (scrollAxisRange.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat2.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    } else {
                        accessibilityActionCompat2 = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    }
                    accessibilityNodeInfoCompat2.addAction(accessibilityActionCompat2);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    if (!AndroidComposeViewAccessibilityDelegateCompat_androidKt.isRtl(semanticsNode)) {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_LEFT;
                    } else {
                        accessibilityActionCompat = AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_RIGHT;
                    }
                    accessibilityNodeInfoCompat2.addAction(accessibilityActionCompat);
                }
            }
        }
        ScrollAxisRange scrollAxisRange2 = (ScrollAxisRange) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getVerticalScrollAxisRange());
        if (!(scrollAxisRange2 == null || accessibilityAction8 == null)) {
            if (!CollectionInfoKt.hasCollectionInfo(semanticsNode)) {
                accessibilityNodeInfoCompat2.setClassName("android.widget.ScrollView");
            }
            if (scrollAxisRange2.getMaxValue().invoke().floatValue() > 0.0f) {
                accessibilityNodeInfoCompat2.setScrollable(true);
            }
            if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
                if (populateAccessibilityNodeInfoProperties$canScrollForward(scrollAxisRange2)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_FORWARD);
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_DOWN);
                }
                if (populateAccessibilityNodeInfoProperties$canScrollBackward(scrollAxisRange2)) {
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_BACKWARD);
                    accessibilityNodeInfoCompat2.addAction(AccessibilityNodeInfoCompat.AccessibilityActionCompat.ACTION_SCROLL_UP);
                }
            }
        }
        accessibilityNodeInfoCompat2.setPaneTitle((CharSequence) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsProperties3.getPaneTitle()));
        if (AndroidComposeViewAccessibilityDelegateCompat_androidKt.enabled(semanticsNode)) {
            AccessibilityAction accessibilityAction9 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getExpand());
            if (accessibilityAction9 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(262144, accessibilityAction9.getLabel()));
                Unit unit12 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction10 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getCollapse());
            if (accessibilityAction10 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(524288, accessibilityAction10.getLabel()));
                Unit unit13 = Unit.INSTANCE;
            }
            AccessibilityAction accessibilityAction11 = (AccessibilityAction) SemanticsConfigurationKt.getOrNull(semanticsNode.getUnmergedConfig$ui_release(), semanticsActions.getDismiss());
            if (accessibilityAction11 != null) {
                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(1048576, accessibilityAction11.getLabel()));
                Unit unit14 = Unit.INSTANCE;
            }
            if (semanticsNode.getUnmergedConfig$ui_release().contains(semanticsActions.getCustomActions())) {
                List list2 = (List) semanticsNode.getUnmergedConfig$ui_release().get(semanticsActions.getCustomActions());
                int size2 = list2.size();
                int[] iArr = AccessibilityActionsResourceIds;
                if (size2 < iArr.length) {
                    SparseArrayCompat sparseArrayCompat = new SparseArrayCompat();
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    if (this.labelToActionId.containsKey(i13)) {
                        Map map = this.labelToActionId.get(i13);
                        List mutableList = ArraysKt___ArraysKt.toMutableList(iArr);
                        ArrayList arrayList2 = new ArrayList();
                        int size3 = list2.size();
                        int i18 = 0;
                        while (i18 < size3) {
                            CustomAccessibilityAction customAccessibilityAction = (CustomAccessibilityAction) list2.get(i18);
                            Intrinsics.checkNotNull(map);
                            if (map.containsKey(customAccessibilityAction.getLabel())) {
                                Integer num = (Integer) map.get(customAccessibilityAction.getLabel());
                                Intrinsics.checkNotNull(num);
                                sparseArrayCompat.put(num.intValue(), customAccessibilityAction.getLabel());
                                linkedHashMap.put(customAccessibilityAction.getLabel(), num);
                                mutableList.remove(num);
                                accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(num.intValue(), customAccessibilityAction.getLabel()));
                            } else {
                                arrayList2.add(customAccessibilityAction);
                            }
                            i18++;
                            SemanticsNode semanticsNode5 = semanticsNode;
                        }
                        int size4 = arrayList2.size();
                        for (int i19 = 0; i19 < size4; i19++) {
                            CustomAccessibilityAction customAccessibilityAction2 = (CustomAccessibilityAction) arrayList2.get(i19);
                            int intValue = ((Number) mutableList.get(i19)).intValue();
                            sparseArrayCompat.put(intValue, customAccessibilityAction2.getLabel());
                            linkedHashMap.put(customAccessibilityAction2.getLabel(), Integer.valueOf(intValue));
                            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(intValue, customAccessibilityAction2.getLabel()));
                        }
                    } else {
                        int size5 = list2.size();
                        for (int i21 = 0; i21 < size5; i21++) {
                            CustomAccessibilityAction customAccessibilityAction3 = (CustomAccessibilityAction) list2.get(i21);
                            int i22 = AccessibilityActionsResourceIds[i21];
                            sparseArrayCompat.put(i22, customAccessibilityAction3.getLabel());
                            linkedHashMap.put(customAccessibilityAction3.getLabel(), Integer.valueOf(i22));
                            accessibilityNodeInfoCompat2.addAction(new AccessibilityNodeInfoCompat.AccessibilityActionCompat(i22, customAccessibilityAction3.getLabel()));
                        }
                    }
                    this.actionIdToLabel.put(i13, sparseArrayCompat);
                    this.labelToActionId.put(i13, linkedHashMap);
                } else {
                    throw new IllegalStateException("Can't have more than " + iArr.length + " custom actions for one widget");
                }
            }
        }
        accessibilityNodeInfoCompat2.setScreenReaderFocusable(semanticsNode.getUnmergedConfig$ui_release().isMergingSemanticsOfDescendants() || (z12 && (accessibilityNodeInfoCompat.getContentDescription() != null || accessibilityNodeInfoCompat.getText() != null || accessibilityNodeInfoCompat.getHintText() != null || accessibilityNodeInfoCompat.getStateDescription() != null || accessibilityNodeInfoCompat.isCheckable())));
    }

    /* JADX WARNING: type inference failed for: r1v29, types: [androidx.compose.ui.text.AnnotatedString] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @androidx.annotation.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void sendSemanticsPropertyChangeEvents$ui_release(@org.jetbrains.annotations.NotNull java.util.Map<java.lang.Integer, androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds> r28) {
        /*
            r27 = this;
            r7 = r27
            r8 = r28
            java.lang.String r0 = "newSemanticsNodes"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.ArrayList r9 = new java.util.ArrayList
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r0 = r7.scrollObservationScopes
            java.util.Collection r0 = (java.util.Collection) r0
            r9.<init>(r0)
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r0 = r7.scrollObservationScopes
            r0.clear()
            java.util.Set r0 = r28.keySet()
            java.util.Iterator r10 = r0.iterator()
        L_0x001f:
            boolean r0 = r10.hasNext()
            if (r0 == 0) goto L_0x04bc
            java.lang.Object r0 = r10.next()
            java.lang.Number r0 = (java.lang.Number) r0
            int r11 = r0.intValue()
            java.util.Map<java.lang.Integer, androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy> r0 = r7.previousSemanticsNodes
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            java.lang.Object r0 = r0.get(r1)
            r12 = r0
            androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat$SemanticsNodeCopy r12 = (androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.SemanticsNodeCopy) r12
            if (r12 != 0) goto L_0x003f
            goto L_0x001f
        L_0x003f:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r11)
            java.lang.Object r0 = r8.get(r0)
            androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds r0 = (androidx.compose.ui.platform.SemanticsNodeWithAdjustedBounds) r0
            if (r0 == 0) goto L_0x0051
            androidx.compose.ui.semantics.SemanticsNode r0 = r0.getSemanticsNode()
            r14 = r0
            goto L_0x0052
        L_0x0051:
            r14 = 0
        L_0x0052:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r14)
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            java.util.Iterator r15 = r0.iterator()
            r16 = 0
        L_0x005f:
            r17 = r16
        L_0x0061:
            boolean r0 = r15.hasNext()
            if (r0 == 0) goto L_0x049f
            java.lang.Object r0 = r15.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r1 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsProperties r2 = androidx.compose.ui.semantics.SemanticsProperties.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getHorizontalScrollAxisRange()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 != 0) goto L_0x008f
            java.lang.Object r1 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getVerticalScrollAxisRange()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x008c
            goto L_0x008f
        L_0x008c:
            r1 = r16
            goto L_0x0093
        L_0x008f:
            boolean r1 = r7.registerScrollingId(r11, r9)
        L_0x0093:
            if (r1 != 0) goto L_0x00ae
            java.lang.Object r1 = r0.getValue()
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r12.getUnmergedConfig()
            java.lang.Object r4 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r4
            java.lang.Object r3 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r3, r4)
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x00ae
            goto L_0x0061
        L_0x00ae:
            java.lang.Object r1 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r1
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getPaneTitle()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            r4 = 8
            if (r3 == 0) goto L_0x00d5
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.String"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.lang.String r0 = (java.lang.String) r0
            boolean r1 = r12.hasPaneTitle()
            if (r1 == 0) goto L_0x0061
            r7.sendPaneChangeEvents(r11, r4, r0)
            goto L_0x0061
        L_0x00d5:
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getStateDescription()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            r5 = 1
            if (r3 == 0) goto L_0x00e2
            r3 = r5
            goto L_0x00ea
        L_0x00e2:
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getToggleableState()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
        L_0x00ea:
            r6 = 64
            if (r3 == 0) goto L_0x010e
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            b(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            b(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0061
        L_0x010e:
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getProgressBarRangeInfo()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0138
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            b(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            b(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0061
        L_0x0138:
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getSelected()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            r13 = 4
            if (r3 == 0) goto L_0x022f
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getConfig()
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r2.getRole()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            androidx.compose.ui.semantics.Role r0 = (androidx.compose.ui.semantics.Role) r0
            androidx.compose.ui.semantics.Role$Companion r1 = androidx.compose.ui.semantics.Role.Companion
            int r1 = r1.m4916getTabo7Vup1c()
            if (r0 != 0) goto L_0x015c
            r0 = r16
            goto L_0x0164
        L_0x015c:
            int r0 = r0.m4910unboximpl()
            boolean r0 = androidx.compose.ui.semantics.Role.m4907equalsimpl0(r0, r1)
        L_0x0164:
            if (r0 == 0) goto L_0x020f
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getConfig()
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r2.getSelected()
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r0, r1)
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r1)
            if (r0 == 0) goto L_0x01fa
            int r0 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            android.view.accessibility.AccessibilityEvent r0 = r7.createEvent$ui_release(r0, r13)
            androidx.compose.ui.semantics.SemanticsNode r1 = new androidx.compose.ui.semantics.SemanticsNode
            androidx.compose.ui.node.SemanticsModifierNode r19 = r14.getOuterSemanticsNode$ui_release()
            r20 = 1
            r21 = 0
            r22 = 4
            r23 = 0
            r18 = r1
            r18.<init>(r19, r20, r21, r22, r23)
            androidx.compose.ui.semantics.SemanticsConfiguration r3 = r1.getConfig()
            androidx.compose.ui.semantics.SemanticsPropertyKey r4 = r2.getContentDescription()
            java.lang.Object r3 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r3, r4)
            r18 = r3
            java.util.List r18 = (java.util.List) r18
            if (r18 == 0) goto L_0x01bc
            java.lang.String r19 = ","
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 62
            r26 = 0
            java.lang.String r3 = androidx.compose.ui.TempListUtilsKt.fastJoinToString$default(r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x01bd
        L_0x01bc:
            r3 = 0
        L_0x01bd:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r1.getConfig()
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getText()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            r18 = r1
            java.util.List r18 = (java.util.List) r18
            if (r18 == 0) goto L_0x01e4
            java.lang.String r19 = ","
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 62
            r26 = 0
            java.lang.String r1 = androidx.compose.ui.TempListUtilsKt.fastJoinToString$default(r18, r19, r20, r21, r22, r23, r24, r25, r26)
            goto L_0x01e5
        L_0x01e4:
            r1 = 0
        L_0x01e5:
            if (r3 == 0) goto L_0x01ec
            r0.setContentDescription(r3)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x01ec:
            if (r1 == 0) goto L_0x01f5
            java.util.List r2 = r0.getText()
            r2.add(r1)
        L_0x01f5:
            r7.sendEvent(r0)
            goto L_0x0061
        L_0x01fa:
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            b(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0061
        L_0x020f:
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r6)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            b(r0, r1, r2, r3, r4, r5, r6)
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            b(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0061
        L_0x022f:
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getContentDescription()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0253
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            java.lang.Object r0 = r0.getValue()
            java.lang.String r3 = "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r3)
            java.util.List r0 = (java.util.List) r0
            r3 = 2048(0x800, float:2.87E-42)
            r7.sendEventForVirtualView(r1, r3, r2, r0)
            goto L_0x0061
        L_0x0253:
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getEditableText()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            java.lang.String r13 = ""
            if (r3 == 0) goto L_0x02fc
            boolean r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.isTextField(r14)
            if (r0 == 0) goto L_0x02e6
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r12.getUnmergedConfig()
            androidx.compose.ui.text.AnnotatedString r0 = r7.getTextForTextField(r0)
            if (r0 == 0) goto L_0x0270
            goto L_0x0271
        L_0x0270:
            r0 = r13
        L_0x0271:
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.text.AnnotatedString r1 = r7.getTextForTextField(r1)
            if (r1 == 0) goto L_0x027c
            r13 = r1
        L_0x027c:
            int r1 = r0.length()
            int r2 = r13.length()
            int r3 = kotlin.ranges.RangesKt___RangesKt.coerceAtMost((int) r1, (int) r2)
            r4 = r16
        L_0x028a:
            if (r4 >= r3) goto L_0x029a
            char r5 = r0.charAt(r4)
            char r6 = r13.charAt(r4)
            if (r5 == r6) goto L_0x0297
            goto L_0x029a
        L_0x0297:
            int r4 = r4 + 1
            goto L_0x028a
        L_0x029a:
            r5 = r16
        L_0x029c:
            int r6 = r3 - r4
            if (r5 >= r6) goto L_0x02b9
            int r6 = r1 + -1
            int r6 = r6 - r5
            char r6 = r0.charAt(r6)
            int r19 = r2 + -1
            r20 = r3
            int r3 = r19 - r5
            char r3 = r13.charAt(r3)
            if (r6 == r3) goto L_0x02b4
            goto L_0x02b9
        L_0x02b4:
            int r5 = r5 + 1
            r3 = r20
            goto L_0x029c
        L_0x02b9:
            int r1 = r1 - r5
            int r1 = r1 - r4
            int r2 = r2 - r5
            int r2 = r2 - r4
            int r3 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r5 = 16
            android.view.accessibility.AccessibilityEvent r3 = r7.createEvent$ui_release(r3, r5)
            r3.setFromIndex(r4)
            r3.setRemovedCount(r1)
            r3.setAddedCount(r2)
            r3.setBeforeText(r0)
            java.util.List r0 = r3.getText()
            r1 = 100000(0x186a0, float:1.4013E-40)
            java.lang.CharSequence r1 = r7.trimToSize(r13, r1)
            r0.add(r1)
            r7.sendEvent(r3)
            goto L_0x0061
        L_0x02e6:
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            r0 = 2
            java.lang.Integer r3 = java.lang.Integer.valueOf(r0)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            b(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0061
        L_0x02fc:
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getTextSelectionRange()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0367
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.text.AnnotatedString r0 = r7.getTextForTextField(r0)
            if (r0 == 0) goto L_0x0318
            java.lang.String r0 = r0.getText()
            if (r0 != 0) goto L_0x0317
            goto L_0x0318
        L_0x0317:
            r13 = r0
        L_0x0318:
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r2.getTextSelectionRange()
            java.lang.Object r0 = r0.get(r1)
            androidx.compose.ui.text.TextRange r0 = (androidx.compose.ui.text.TextRange) r0
            long r0 = r0.m5042unboximpl()
            int r2 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            int r3 = androidx.compose.ui.text.TextRange.m5038getStartimpl(r0)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            int r0 = androidx.compose.ui.text.TextRange.m5033getEndimpl(r0)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r0)
            int r0 = r13.length()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r0)
            r0 = 100000(0x186a0, float:1.4013E-40)
            java.lang.CharSequence r0 = r7.trimToSize(r13, r0)
            r6 = r0
            java.lang.String r6 = (java.lang.String) r6
            r0 = r27
            r1 = r2
            r2 = r3
            r3 = r4
            r4 = r5
            r5 = r6
            android.view.accessibility.AccessibilityEvent r0 = r0.createTextSelectionChangedEvent(r1, r2, r3, r4, r5)
            r7.sendEvent(r0)
            int r0 = r14.getId()
            r7.sendPendingTextTraversedAtGranularityEvent(r0)
            goto L_0x0061
        L_0x0367:
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getHorizontalScrollAxisRange()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r3 == 0) goto L_0x0373
            r3 = r5
            goto L_0x037b
        L_0x0373:
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getVerticalScrollAxisRange()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
        L_0x037b:
            if (r3 == 0) goto L_0x03b4
            androidx.compose.ui.node.LayoutNode r0 = r14.getLayoutNode$ui_release()
            r7.notifySubtreeAccessibilityStateChangedIfNeeded(r0)
            java.util.List<androidx.compose.ui.platform.ScrollObservationScope> r0 = r7.scrollObservationScopes
            androidx.compose.ui.platform.ScrollObservationScope r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.findById(r0, r11)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getHorizontalScrollAxisRange()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r3)
            androidx.compose.ui.semantics.ScrollAxisRange r1 = (androidx.compose.ui.semantics.ScrollAxisRange) r1
            r0.setHorizontalScrollAxisRange(r1)
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getVerticalScrollAxisRange()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            androidx.compose.ui.semantics.ScrollAxisRange r1 = (androidx.compose.ui.semantics.ScrollAxisRange) r1
            r0.setVerticalScrollAxisRange(r1)
            r7.sendScrollEventIfNeeded(r0)
            goto L_0x0061
        L_0x03b4:
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getFocused()
            boolean r2 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r2)
            if (r2 == 0) goto L_0x03f7
            java.lang.Object r0 = r0.getValue()
            java.lang.String r1 = "null cannot be cast to non-null type kotlin.Boolean"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0, r1)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x03de
            int r0 = r14.getId()
            int r0 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r0)
            android.view.accessibility.AccessibilityEvent r0 = r7.createEvent$ui_release(r0, r4)
            r7.sendEvent(r0)
        L_0x03de:
            int r0 = r14.getId()
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r0)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            b(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x0061
        L_0x03f7:
            androidx.compose.ui.semantics.SemanticsActions r2 = androidx.compose.ui.semantics.SemanticsActions.INSTANCE
            androidx.compose.ui.semantics.SemanticsPropertyKey r3 = r2.getCustomActions()
            boolean r1 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r1, (java.lang.Object) r3)
            if (r1 == 0) goto L_0x0472
            androidx.compose.ui.semantics.SemanticsConfiguration r0 = r14.getUnmergedConfig$ui_release()
            androidx.compose.ui.semantics.SemanticsPropertyKey r1 = r2.getCustomActions()
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            androidx.compose.ui.semantics.SemanticsConfiguration r1 = r12.getUnmergedConfig()
            androidx.compose.ui.semantics.SemanticsPropertyKey r2 = r2.getCustomActions()
            java.lang.Object r1 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r1, r2)
            java.util.List r1 = (java.util.List) r1
            if (r1 == 0) goto L_0x0468
            java.util.LinkedHashSet r2 = new java.util.LinkedHashSet
            r2.<init>()
            int r3 = r0.size()
            r4 = r16
        L_0x042c:
            if (r4 >= r3) goto L_0x043e
            java.lang.Object r6 = r0.get(r4)
            androidx.compose.ui.semantics.CustomAccessibilityAction r6 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r6
            java.lang.String r6 = r6.getLabel()
            r2.add(r6)
            int r4 = r4 + 1
            goto L_0x042c
        L_0x043e:
            java.util.LinkedHashSet r0 = new java.util.LinkedHashSet
            r0.<init>()
            int r3 = r1.size()
            r4 = r16
        L_0x0449:
            if (r4 >= r3) goto L_0x045b
            java.lang.Object r6 = r1.get(r4)
            androidx.compose.ui.semantics.CustomAccessibilityAction r6 = (androidx.compose.ui.semantics.CustomAccessibilityAction) r6
            java.lang.String r6 = r6.getLabel()
            r0.add(r6)
            int r4 = r4 + 1
            goto L_0x0449
        L_0x045b:
            boolean r1 = r2.containsAll(r0)
            if (r1 == 0) goto L_0x049b
            boolean r0 = r0.containsAll(r2)
            if (r0 != 0) goto L_0x005f
            goto L_0x049b
        L_0x0468:
            java.util.Collection r0 = (java.util.Collection) r0
            boolean r0 = r0.isEmpty()
            r0 = r0 ^ r5
            if (r0 == 0) goto L_0x0061
            goto L_0x049b
        L_0x0472:
            java.lang.Object r1 = r0.getValue()
            boolean r1 = r1 instanceof androidx.compose.ui.semantics.AccessibilityAction
            if (r1 == 0) goto L_0x049b
            java.lang.Object r1 = r0.getValue()
            java.lang.String r2 = "null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>"
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1, r2)
            androidx.compose.ui.semantics.AccessibilityAction r1 = (androidx.compose.ui.semantics.AccessibilityAction) r1
            androidx.compose.ui.semantics.SemanticsConfiguration r2 = r12.getUnmergedConfig()
            java.lang.Object r0 = r0.getKey()
            androidx.compose.ui.semantics.SemanticsPropertyKey r0 = (androidx.compose.ui.semantics.SemanticsPropertyKey) r0
            java.lang.Object r0 = androidx.compose.ui.semantics.SemanticsConfigurationKt.getOrNull(r2, r0)
            boolean r0 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.accessibilityEquals(r1, r0)
            r17 = r0 ^ 1
            goto L_0x0061
        L_0x049b:
            r17 = r5
            goto L_0x0061
        L_0x049f:
            if (r17 != 0) goto L_0x04a5
            boolean r17 = androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat_androidKt.propertiesDeleted(r14, r12)
        L_0x04a5:
            if (r17 == 0) goto L_0x001f
            int r1 = r7.semanticsNodeIdToAccessibilityVirtualNodeId(r11)
            r2 = 2048(0x800, float:2.87E-42)
            java.lang.Integer r3 = java.lang.Integer.valueOf(r16)
            r4 = 0
            r5 = 8
            r6 = 0
            r0 = r27
            b(r0, r1, r2, r3, r4, r5, r6)
            goto L_0x001f
        L_0x04bc:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat.sendSemanticsPropertyChangeEvents$ui_release(java.util.Map):void");
    }

    public final void setAccessibilityForceEnabledForTesting$ui_release(boolean z11) {
        this.accessibilityForceEnabledForTesting = z11;
    }

    public final void setHoveredVirtualViewId$ui_release(int i11) {
        this.hoveredVirtualViewId = i11;
    }

    public final void setPreviousSemanticsNodes$ui_release(@NotNull Map<Integer, SemanticsNodeCopy> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.previousSemanticsNodes = map;
    }
}
