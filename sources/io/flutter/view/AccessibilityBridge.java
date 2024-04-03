package io.flutter.view;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.util.Predicate;
import io.flutter.util.ViewUtils;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class AccessibilityBridge extends AccessibilityNodeProvider {
    private static final int ACTION_SHOW_ON_SCREEN = 16908342;
    private static final int BOLD_TEXT_WEIGHT_ADJUSTMENT = 300;
    private static int FIRST_RESOURCE_ID = 267386881;
    /* access modifiers changed from: private */
    public static final int FOCUSABLE_FLAGS = (((((((((((Flag.HAS_CHECKED_STATE.f14437b | Flag.IS_CHECKED.f14437b) | Flag.IS_SELECTED.f14437b) | Flag.IS_TEXT_FIELD.f14437b) | Flag.IS_FOCUSED.f14437b) | Flag.HAS_ENABLED_STATE.f14437b) | Flag.IS_ENABLED.f14437b) | Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.f14437b) | Flag.HAS_TOGGLED_STATE.f14437b) | Flag.IS_TOGGLED.f14437b) | Flag.IS_FOCUSABLE.f14437b) | Flag.IS_SLIDER.f14437b);
    private static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
    private static final int ROOT_NODE_ID = 0;
    /* access modifiers changed from: private */
    public static final int SCROLLABLE_ACTIONS = (((Action.SCROLL_RIGHT.value | Action.SCROLL_LEFT.value) | Action.SCROLL_UP.value) | Action.SCROLL_DOWN.value);
    private static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0f;
    private static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0f;
    private static final String TAG = "AccessibilityBridge";
    /* access modifiers changed from: private */
    @NonNull
    public final AccessibilityChannel accessibilityChannel;
    private int accessibilityFeatureFlags;
    @Nullable
    private SemanticsNode accessibilityFocusedSemanticsNode;
    /* access modifiers changed from: private */
    @NonNull
    public final AccessibilityManager accessibilityManager;
    /* access modifiers changed from: private */
    public final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler;
    private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
    @NonNull
    private final AccessibilityViewEmbedder accessibilityViewEmbedder;
    private boolean accessibleNavigation;
    private final ContentObserver animationScaleObserver;
    /* access modifiers changed from: private */
    @NonNull
    public final ContentResolver contentResolver;
    @NonNull
    private final Map<Integer, CustomAccessibilityAction> customAccessibilityActions;
    private Integer embeddedAccessibilityFocusedNodeId;
    private Integer embeddedInputFocusedNodeId;
    @NonNull
    private final List<Integer> flutterNavigationStack;
    @NonNull
    private final Map<Integer, SemanticsNode> flutterSemanticsTree;
    @Nullable
    private SemanticsNode hoveredObject;
    @Nullable
    private SemanticsNode inputFocusedSemanticsNode;
    /* access modifiers changed from: private */
    public boolean isReleased;
    @Nullable
    private SemanticsNode lastInputFocusedSemanticsNode;
    @NonNull
    private Integer lastLeftFrameInset;
    /* access modifiers changed from: private */
    @Nullable
    public OnAccessibilityChangeListener onAccessibilityChangeListener;
    @NonNull
    private final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
    private int previousRouteId;
    /* access modifiers changed from: private */
    @NonNull
    public final View rootAccessibilityView;
    @RequiresApi(19)
    @TargetApi(19)
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;

    /* renamed from: io.flutter.view.AccessibilityBridge$5  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f14434a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                io.flutter.view.AccessibilityBridge$StringAttributeType[] r0 = io.flutter.view.AccessibilityBridge.StringAttributeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f14434a = r0
                io.flutter.view.AccessibilityBridge$StringAttributeType r1 = io.flutter.view.AccessibilityBridge.StringAttributeType.SPELLOUT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f14434a     // Catch:{ NoSuchFieldError -> 0x001d }
                io.flutter.view.AccessibilityBridge$StringAttributeType r1 = io.flutter.view.AccessibilityBridge.StringAttributeType.LOCALE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.AnonymousClass5.<clinit>():void");
        }
    }

    public enum AccessibilityFeature {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f14435b;

        private AccessibilityFeature(int i11) {
            this.f14435b = i11;
        }
    }

    public enum Action {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(65536),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152);
        
        public final int value;

        private Action(int i11) {
            this.value = i11;
        }
    }

    public static class CustomAccessibilityAction {
        /* access modifiers changed from: private */
        public String hint;
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public int f14436id = -1;
        /* access modifiers changed from: private */
        public String label;
        /* access modifiers changed from: private */
        public int overrideId = -1;
        /* access modifiers changed from: private */
        public int resourceId = -1;
    }

    public enum Flag {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(65536),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432);
        

        /* renamed from: b  reason: collision with root package name */
        public final int f14437b;

        private Flag(int i11) {
            this.f14437b = i11;
        }
    }

    public static class LocaleStringAttribute extends StringAttribute {

        /* renamed from: d  reason: collision with root package name */
        public String f14438d;

        private LocaleStringAttribute() {
            super();
        }
    }

    public interface OnAccessibilityChangeListener {
        void onAccessibilityChanged(boolean z11, boolean z12);
    }

    public static class SemanticsNode {

        /* renamed from: a  reason: collision with root package name */
        public final AccessibilityBridge f14439a;
        private int actions;
        private float bottom;
        /* access modifiers changed from: private */
        public List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
        /* access modifiers changed from: private */
        public List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
        /* access modifiers changed from: private */
        public int currentValueLength;
        /* access modifiers changed from: private */
        public List<CustomAccessibilityAction> customAccessibilityActions;
        /* access modifiers changed from: private */
        public String decreasedValue;
        /* access modifiers changed from: private */
        public List<StringAttribute> decreasedValueAttributes;
        private int flags;
        /* access modifiers changed from: private */
        public boolean globalGeometryDirty = true;
        private Rect globalRect;
        private float[] globalTransform;
        /* access modifiers changed from: private */
        public boolean hadPreviousConfig = false;
        private String hint;
        private List<StringAttribute> hintAttributes;
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public int f14440id = -1;
        /* access modifiers changed from: private */
        public String increasedValue;
        /* access modifiers changed from: private */
        public List<StringAttribute> increasedValueAttributes;
        private float[] inverseTransform;
        /* access modifiers changed from: private */
        public boolean inverseTransformDirty = true;
        /* access modifiers changed from: private */
        public String label;
        private List<StringAttribute> labelAttributes;
        private float left;
        /* access modifiers changed from: private */
        public int maxValueLength;
        /* access modifiers changed from: private */
        public CustomAccessibilityAction onLongPressOverride;
        /* access modifiers changed from: private */
        public CustomAccessibilityAction onTapOverride;
        /* access modifiers changed from: private */
        public SemanticsNode parent;
        /* access modifiers changed from: private */
        public int platformViewId;
        private int previousActions;
        private int previousFlags;
        private String previousLabel;
        /* access modifiers changed from: private */
        public int previousNodeId = -1;
        private float previousScrollExtentMax;
        private float previousScrollExtentMin;
        private float previousScrollPosition;
        /* access modifiers changed from: private */
        public int previousTextSelectionBase;
        /* access modifiers changed from: private */
        public int previousTextSelectionExtent;
        /* access modifiers changed from: private */
        public String previousValue;
        private float right;
        /* access modifiers changed from: private */
        public int scrollChildren;
        /* access modifiers changed from: private */
        public float scrollExtentMax;
        /* access modifiers changed from: private */
        public float scrollExtentMin;
        /* access modifiers changed from: private */
        public int scrollIndex;
        /* access modifiers changed from: private */
        public float scrollPosition;
        private TextDirection textDirection;
        /* access modifiers changed from: private */
        public int textSelectionBase;
        /* access modifiers changed from: private */
        public int textSelectionExtent;
        /* access modifiers changed from: private */
        @Nullable
        public String tooltip;
        private float top;
        private float[] transform;
        /* access modifiers changed from: private */
        public String value;
        /* access modifiers changed from: private */
        public List<StringAttribute> valueAttributes;

        public SemanticsNode(@NonNull AccessibilityBridge accessibilityBridge) {
            this.f14439a = accessibilityBridge;
        }

        /* access modifiers changed from: private */
        public void collectRoutes(List<SemanticsNode> list) {
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                list.add(this);
            }
            for (SemanticsNode collectRoutes : this.childrenInTraversalOrder) {
                collectRoutes.collectRoutes(list);
            }
        }

        @RequiresApi(21)
        @TargetApi(21)
        private SpannableString createSpannableString(String str, List<StringAttribute> list) {
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (StringAttribute next : list) {
                    int i11 = AnonymousClass5.f14434a[next.f14443c.ordinal()];
                    if (i11 == 1) {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), next.f14441a, next.f14442b, 0);
                    } else if (i11 == 2) {
                        spannableString.setSpan(new LocaleSpan(Locale.forLanguageTag(((LocaleStringAttribute) next).f14438d)), next.f14441a, next.f14442b, 0);
                    }
                }
            }
            return spannableString;
        }

        /* access modifiers changed from: private */
        public boolean didChangeLabel() {
            String str;
            String str2 = this.label;
            if (str2 == null && this.previousLabel == null) {
                return false;
            }
            if (str2 == null || (str = this.previousLabel) == null || !str2.equals(str)) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: private */
        public boolean didScroll() {
            if (Float.isNaN(this.scrollPosition) || Float.isNaN(this.previousScrollPosition) || this.previousScrollPosition == this.scrollPosition) {
                return false;
            }
            return true;
        }

        private void ensureInverseTransform() {
            if (this.inverseTransformDirty) {
                this.inverseTransformDirty = false;
                if (this.inverseTransform == null) {
                    this.inverseTransform = new float[16];
                }
                if (!Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
                    Arrays.fill(this.inverseTransform, 0.0f);
                }
            }
        }

        private SemanticsNode getAncestor(Predicate<SemanticsNode> predicate) {
            for (SemanticsNode semanticsNode = this.parent; semanticsNode != null; semanticsNode = semanticsNode.parent) {
                if (predicate.test(semanticsNode)) {
                    return semanticsNode;
                }
            }
            return null;
        }

        /* access modifiers changed from: private */
        public Rect getGlobalRect() {
            return this.globalRect;
        }

        private CharSequence getHint() {
            return createSpannableString(this.hint, this.hintAttributes);
        }

        private CharSequence getLabel() {
            return createSpannableString(this.label, this.labelAttributes);
        }

        /* access modifiers changed from: private */
        public String getRouteName() {
            String str;
            if (hasFlag(Flag.NAMES_ROUTE) && (str = this.label) != null && !str.isEmpty()) {
                return this.label;
            }
            for (SemanticsNode routeName : this.childrenInTraversalOrder) {
                String routeName2 = routeName.getRouteName();
                if (routeName2 != null && !routeName2.isEmpty()) {
                    return routeName2;
                }
            }
            return null;
        }

        private List<StringAttribute> getStringAttributesFromBuffer(@NonNull ByteBuffer byteBuffer, @NonNull ByteBuffer[] byteBufferArr) {
            int i11 = byteBuffer.getInt();
            if (i11 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i11);
            for (int i12 = 0; i12 < i11; i12++) {
                int i13 = byteBuffer.getInt();
                int i14 = byteBuffer.getInt();
                StringAttributeType stringAttributeType = StringAttributeType.values()[byteBuffer.getInt()];
                int i15 = AnonymousClass5.f14434a[stringAttributeType.ordinal()];
                if (i15 == 1) {
                    byteBuffer.getInt();
                    SpellOutStringAttribute spellOutStringAttribute = new SpellOutStringAttribute();
                    spellOutStringAttribute.f14441a = i13;
                    spellOutStringAttribute.f14442b = i14;
                    spellOutStringAttribute.f14443c = stringAttributeType;
                    arrayList.add(spellOutStringAttribute);
                } else if (i15 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    LocaleStringAttribute localeStringAttribute = new LocaleStringAttribute();
                    localeStringAttribute.f14441a = i13;
                    localeStringAttribute.f14442b = i14;
                    localeStringAttribute.f14443c = stringAttributeType;
                    localeStringAttribute.f14438d = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(localeStringAttribute);
                }
            }
            return arrayList;
        }

        /* access modifiers changed from: private */
        public CharSequence getTextFieldHint() {
            CharSequence[] charSequenceArr = {getLabel(), getHint()};
            CharSequence charSequence = null;
            for (int i11 = 0; i11 < 2; i11++) {
                CharSequence charSequence2 = charSequenceArr[i11];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    if (charSequence == null || charSequence.length() == 0) {
                        charSequence = charSequence2;
                    } else {
                        charSequence = TextUtils.concat(new CharSequence[]{charSequence, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, charSequence2});
                    }
                }
            }
            return charSequence;
        }

        /* access modifiers changed from: private */
        public CharSequence getValue() {
            return createSpannableString(this.value, this.valueAttributes);
        }

        /* access modifiers changed from: private */
        public CharSequence getValueLabelHint() {
            CharSequence[] charSequenceArr = {getValue(), getLabel(), getHint()};
            CharSequence charSequence = null;
            for (int i11 = 0; i11 < 3; i11++) {
                CharSequence charSequence2 = charSequenceArr[i11];
                if (charSequence2 != null && charSequence2.length() > 0) {
                    if (charSequence == null || charSequence.length() == 0) {
                        charSequence = charSequence2;
                    } else {
                        charSequence = TextUtils.concat(new CharSequence[]{charSequence, IndicativeSentencesGeneration.DEFAULT_SEPARATOR, charSequence2});
                    }
                }
            }
            return charSequence;
        }

        /* access modifiers changed from: private */
        public boolean hadAction(@NonNull Action action) {
            return (action.value & this.previousActions) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hadFlag(@NonNull Flag flag) {
            return (flag.f14437b & this.previousFlags) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hasAction(@NonNull Action action) {
            return (action.value & this.actions) != 0;
        }

        /* access modifiers changed from: private */
        public boolean hasFlag(@NonNull Flag flag) {
            return (flag.f14437b & this.flags) != 0;
        }

        /* access modifiers changed from: private */
        public SemanticsNode hitTest(float[] fArr, boolean z11) {
            float f11 = fArr[3];
            boolean z12 = false;
            float f12 = fArr[0] / f11;
            float f13 = fArr[1] / f11;
            if (f12 < this.left || f12 >= this.right || f13 < this.top || f13 >= this.bottom) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (SemanticsNode next : this.childrenInHitTestOrder) {
                if (!next.hasFlag(Flag.IS_HIDDEN)) {
                    next.ensureInverseTransform();
                    Matrix.multiplyMV(fArr2, 0, next.inverseTransform, 0, fArr, 0);
                    SemanticsNode hitTest = next.hitTest(fArr2, z11);
                    if (hitTest != null) {
                        return hitTest;
                    }
                }
            }
            if (z11 && this.platformViewId != -1) {
                z12 = true;
            }
            if (isFocusable() || z12) {
                return this;
            }
            return null;
        }

        /* access modifiers changed from: private */
        public boolean isFocusable() {
            String str;
            String str2;
            String str3;
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                return false;
            }
            if (hasFlag(Flag.IS_FOCUSABLE)) {
                return true;
            }
            if ((this.actions & (~AccessibilityBridge.SCROLLABLE_ACTIONS)) == 0 && (this.flags & AccessibilityBridge.FOCUSABLE_FLAGS) == 0 && (((str = this.label) == null || str.isEmpty()) && (((str2 = this.value) == null || str2.isEmpty()) && ((str3 = this.hint) == null || str3.isEmpty())))) {
                return false;
            }
            return true;
        }

        private void log(@NonNull String str, boolean z11) {
        }

        public static /* synthetic */ int m(SemanticsNode semanticsNode, int i11) {
            int i12 = semanticsNode.textSelectionExtent + i11;
            semanticsNode.textSelectionExtent = i12;
            return i12;
        }

        private float max(float f11, float f12, float f13, float f14) {
            return Math.max(f11, Math.max(f12, Math.max(f13, f14)));
        }

        private float min(float f11, float f12, float f13, float f14) {
            return Math.min(f11, Math.min(f12, Math.min(f13, f14)));
        }

        public static /* synthetic */ int n(SemanticsNode semanticsNode, int i11) {
            int i12 = semanticsNode.textSelectionExtent - i11;
            semanticsNode.textSelectionExtent = i12;
            return i12;
        }

        /* access modifiers changed from: private */
        public static boolean nullableHasAncestor(SemanticsNode semanticsNode, Predicate<SemanticsNode> predicate) {
            return (semanticsNode == null || semanticsNode.getAncestor(predicate) == null) ? false : true;
        }

        private void transformPoint(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f11 = fArr[3];
            fArr[0] = fArr[0] / f11;
            fArr[1] = fArr[1] / f11;
            fArr[2] = fArr[2] / f11;
            fArr[3] = 0.0f;
        }

        /* access modifiers changed from: private */
        public void updateRecursively(float[] fArr, Set<SemanticsNode> set, boolean z11) {
            set.add(this);
            if (this.globalGeometryDirty) {
                z11 = true;
            }
            if (z11) {
                if (this.globalTransform == null) {
                    this.globalTransform = new float[16];
                }
                if (this.transform == null) {
                    this.transform = new float[16];
                }
                Matrix.multiplyMM(this.globalTransform, 0, fArr, 0, this.transform, 0);
                float[] fArr2 = new float[4];
                fArr2[2] = 0.0f;
                fArr2[3] = 1.0f;
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                fArr2[0] = this.left;
                fArr2[1] = this.top;
                transformPoint(fArr3, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.top;
                transformPoint(fArr4, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.bottom;
                transformPoint(fArr5, this.globalTransform, fArr2);
                fArr2[0] = this.left;
                fArr2[1] = this.bottom;
                transformPoint(fArr6, this.globalTransform, fArr2);
                if (this.globalRect == null) {
                    this.globalRect = new Rect();
                }
                this.globalRect.set(Math.round(min(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(min(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(max(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(max(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.globalGeometryDirty = false;
            }
            int i11 = -1;
            for (SemanticsNode next : this.childrenInTraversalOrder) {
                next.previousNodeId = i11;
                i11 = next.f14440id;
                next.updateRecursively(this.globalTransform, set, z11);
            }
        }

        /* access modifiers changed from: private */
        public void updateWith(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr, @NonNull ByteBuffer[] byteBufferArr) {
            String str;
            String str2;
            String str3;
            String str4;
            String str5;
            String str6;
            this.hadPreviousConfig = true;
            this.previousValue = this.value;
            this.previousLabel = this.label;
            this.previousFlags = this.flags;
            this.previousActions = this.actions;
            this.previousTextSelectionBase = this.textSelectionBase;
            this.previousTextSelectionExtent = this.textSelectionExtent;
            this.previousScrollPosition = this.scrollPosition;
            this.previousScrollExtentMax = this.scrollExtentMax;
            this.previousScrollExtentMin = this.scrollExtentMin;
            this.flags = byteBuffer.getInt();
            this.actions = byteBuffer.getInt();
            this.maxValueLength = byteBuffer.getInt();
            this.currentValueLength = byteBuffer.getInt();
            this.textSelectionBase = byteBuffer.getInt();
            this.textSelectionExtent = byteBuffer.getInt();
            this.platformViewId = byteBuffer.getInt();
            this.scrollChildren = byteBuffer.getInt();
            this.scrollIndex = byteBuffer.getInt();
            this.scrollPosition = byteBuffer.getFloat();
            this.scrollExtentMax = byteBuffer.getFloat();
            this.scrollExtentMin = byteBuffer.getFloat();
            int i11 = byteBuffer.getInt();
            if (i11 == -1) {
                str = null;
            } else {
                str = strArr[i11];
            }
            this.label = str;
            this.labelAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i12 = byteBuffer.getInt();
            if (i12 == -1) {
                str2 = null;
            } else {
                str2 = strArr[i12];
            }
            this.value = str2;
            this.valueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i13 = byteBuffer.getInt();
            if (i13 == -1) {
                str3 = null;
            } else {
                str3 = strArr[i13];
            }
            this.increasedValue = str3;
            this.increasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i14 = byteBuffer.getInt();
            if (i14 == -1) {
                str4 = null;
            } else {
                str4 = strArr[i14];
            }
            this.decreasedValue = str4;
            this.decreasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i15 = byteBuffer.getInt();
            if (i15 == -1) {
                str5 = null;
            } else {
                str5 = strArr[i15];
            }
            this.hint = str5;
            this.hintAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i16 = byteBuffer.getInt();
            if (i16 == -1) {
                str6 = null;
            } else {
                str6 = strArr[i16];
            }
            this.tooltip = str6;
            this.textDirection = TextDirection.fromInt(byteBuffer.getInt());
            this.left = byteBuffer.getFloat();
            this.top = byteBuffer.getFloat();
            this.right = byteBuffer.getFloat();
            this.bottom = byteBuffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i17 = 0; i17 < 16; i17++) {
                this.transform[i17] = byteBuffer.getFloat();
            }
            this.inverseTransformDirty = true;
            this.globalGeometryDirty = true;
            int i18 = byteBuffer.getInt();
            this.childrenInTraversalOrder.clear();
            this.childrenInHitTestOrder.clear();
            for (int i19 = 0; i19 < i18; i19++) {
                SemanticsNode o11 = this.f14439a.getOrCreateSemanticsNode(byteBuffer.getInt());
                o11.parent = this;
                this.childrenInTraversalOrder.add(o11);
            }
            for (int i21 = 0; i21 < i18; i21++) {
                SemanticsNode o12 = this.f14439a.getOrCreateSemanticsNode(byteBuffer.getInt());
                o12.parent = this;
                this.childrenInHitTestOrder.add(o12);
            }
            int i22 = byteBuffer.getInt();
            if (i22 == 0) {
                this.customAccessibilityActions = null;
                return;
            }
            List<CustomAccessibilityAction> list = this.customAccessibilityActions;
            if (list == null) {
                this.customAccessibilityActions = new ArrayList(i22);
            } else {
                list.clear();
            }
            for (int i23 = 0; i23 < i22; i23++) {
                CustomAccessibilityAction q11 = this.f14439a.getOrCreateAccessibilityAction(byteBuffer.getInt());
                if (q11.overrideId == Action.TAP.value) {
                    this.onTapOverride = q11;
                } else if (q11.overrideId == Action.LONG_PRESS.value) {
                    this.onLongPressOverride = q11;
                } else {
                    this.customAccessibilityActions.add(q11);
                }
                this.customAccessibilityActions.add(q11);
            }
        }
    }

    public static class SpellOutStringAttribute extends StringAttribute {
        private SpellOutStringAttribute() {
            super();
        }
    }

    public static class StringAttribute {

        /* renamed from: a  reason: collision with root package name */
        public int f14441a;

        /* renamed from: b  reason: collision with root package name */
        public int f14442b;

        /* renamed from: c  reason: collision with root package name */
        public StringAttributeType f14443c;

        private StringAttribute() {
        }
    }

    public enum StringAttributeType {
        SPELLOUT,
        LOCALE
    }

    public enum TextDirection {
        UNKNOWN,
        LTR,
        RTL;

        public static TextDirection fromInt(int i11) {
            if (i11 == 1) {
                return RTL;
            }
            if (i11 != 2) {
                return UNKNOWN;
            }
            return LTR;
        }
    }

    public AccessibilityBridge(@NonNull View view, @NonNull AccessibilityChannel accessibilityChannel2, @NonNull AccessibilityManager accessibilityManager2, @NonNull ContentResolver contentResolver2, @NonNull PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate2) {
        this(view, accessibilityChannel2, accessibilityManager2, contentResolver2, new AccessibilityViewEmbedder(view, 65536), platformViewsAccessibilityDelegate2);
    }

    private AccessibilityEvent createTextChangedEvent(int i11, String str, String str2) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i11, 16);
        obtainAccessibilityEvent.setBeforeText(str);
        obtainAccessibilityEvent.getText().add(str2);
        int i12 = 0;
        while (i12 < str.length() && i12 < str2.length() && str.charAt(i12) == str2.charAt(i12)) {
            i12++;
        }
        if (i12 >= str.length() && i12 >= str2.length()) {
            return null;
        }
        obtainAccessibilityEvent.setFromIndex(i12);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i12 && length2 >= i12 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        obtainAccessibilityEvent.setRemovedCount((length - i12) + 1);
        obtainAccessibilityEvent.setAddedCount((length2 - i12) + 1);
        return obtainAccessibilityEvent;
    }

    @RequiresApi(28)
    @TargetApi(28)
    private boolean doesLayoutInDisplayCutoutModeRequireLeftInset() {
        Activity activity = ViewUtils.getActivity(this.rootAccessibilityView.getContext());
        if (activity == null || activity.getWindow() == null) {
            return false;
        }
        int a11 = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
        if (a11 == 2 || a11 == 0) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ int f(AccessibilityBridge accessibilityBridge, int i11) {
        int i12 = i11 & accessibilityBridge.accessibilityFeatureFlags;
        accessibilityBridge.accessibilityFeatureFlags = i12;
        return i12;
    }

    public static /* synthetic */ int g(AccessibilityBridge accessibilityBridge, int i11) {
        int i12 = i11 | accessibilityBridge.accessibilityFeatureFlags;
        accessibilityBridge.accessibilityFeatureFlags = i12;
        return i12;
    }

    private Rect getBoundsInScreen(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.rootAccessibilityView.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* access modifiers changed from: private */
    public CustomAccessibilityAction getOrCreateAccessibilityAction(int i11) {
        CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i11));
        if (customAccessibilityAction != null) {
            return customAccessibilityAction;
        }
        CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction();
        int unused = customAccessibilityAction2.f14436id = i11;
        int unused2 = customAccessibilityAction2.resourceId = FIRST_RESOURCE_ID + i11;
        this.customAccessibilityActions.put(Integer.valueOf(i11), customAccessibilityAction2);
        return customAccessibilityAction2;
    }

    /* access modifiers changed from: private */
    public SemanticsNode getOrCreateSemanticsNode(int i11) {
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i11));
        if (semanticsNode != null) {
            return semanticsNode;
        }
        SemanticsNode semanticsNode2 = new SemanticsNode(this);
        int unused = semanticsNode2.f14440id = i11;
        this.flutterSemanticsTree.put(Integer.valueOf(i11), semanticsNode2);
        return semanticsNode2;
    }

    private SemanticsNode getRootSemanticsNode() {
        return this.flutterSemanticsTree.get(0);
    }

    private void handleTouchExploration(float f11, float f12, boolean z11) {
        SemanticsNode J;
        if (!this.flutterSemanticsTree.isEmpty() && (J = getRootSemanticsNode().hitTest(new float[]{f11, f12, 0.0f, 1.0f}, z11)) != this.hoveredObject) {
            if (J != null) {
                sendAccessibilityEvent(J.f14440id, 128);
            }
            SemanticsNode semanticsNode = this.hoveredObject;
            if (semanticsNode != null) {
                sendAccessibilityEvent(semanticsNode.f14440id, 256);
            }
            this.hoveredObject = J;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$shouldSetCollectionInfo$0(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        return semanticsNode2 == semanticsNode;
    }

    /* access modifiers changed from: private */
    public AccessibilityEvent obtainAccessibilityEvent(int i11, int i12) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i12);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i11);
        return obtain;
    }

    /* access modifiers changed from: private */
    public void onTouchExplorationExit() {
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.f14440id, 256);
            this.hoveredObject = null;
        }
    }

    private void onWindowNameChange(@NonNull SemanticsNode semanticsNode) {
        String d02 = semanticsNode.getRouteName();
        if (d02 == null) {
            d02 = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            setAccessibilityPaneTitle(d02);
            return;
        }
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.f14440id, 32);
        obtainAccessibilityEvent.getText().add(d02);
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    @RequiresApi(18)
    @TargetApi(18)
    private boolean performCursorMoveAction(@NonNull SemanticsNode semanticsNode, int i11, @NonNull Bundle bundle, boolean z11) {
        String str;
        int i12 = bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT);
        boolean z12 = bundle.getBoolean(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN);
        int i13 = semanticsNode.textSelectionBase;
        int k11 = semanticsNode.textSelectionExtent;
        predictCursorMovement(semanticsNode, i12, z11, z12);
        if (!(i13 == semanticsNode.textSelectionBase && k11 == semanticsNode.textSelectionExtent)) {
            if (semanticsNode.value != null) {
                str = semanticsNode.value;
            } else {
                str = "";
            }
            AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.f14440id, 8192);
            obtainAccessibilityEvent.getText().add(str);
            obtainAccessibilityEvent.setFromIndex(semanticsNode.textSelectionBase);
            obtainAccessibilityEvent.setToIndex(semanticsNode.textSelectionExtent);
            obtainAccessibilityEvent.setItemCount(str.length());
            sendAccessibilityEvent(obtainAccessibilityEvent);
        }
        if (i12 == 1) {
            if (z11) {
                Action action = Action.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (semanticsNode.hasAction(action)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i11, action, Boolean.valueOf(z12));
                    return true;
                }
            }
            if (z11) {
                return false;
            }
            Action action2 = Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (!semanticsNode.hasAction(action2)) {
                return false;
            }
            this.accessibilityChannel.dispatchSemanticsAction(i11, action2, Boolean.valueOf(z12));
            return true;
        } else if (i12 == 2) {
            if (z11) {
                Action action3 = Action.MOVE_CURSOR_FORWARD_BY_WORD;
                if (semanticsNode.hasAction(action3)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i11, action3, Boolean.valueOf(z12));
                    return true;
                }
            }
            if (z11) {
                return false;
            }
            Action action4 = Action.MOVE_CURSOR_BACKWARD_BY_WORD;
            if (!semanticsNode.hasAction(action4)) {
                return false;
            }
            this.accessibilityChannel.dispatchSemanticsAction(i11, action4, Boolean.valueOf(z12));
            return true;
        } else if (i12 == 4 || i12 == 8 || i12 == 16) {
            return true;
        } else {
            return false;
        }
    }

    @RequiresApi(21)
    @TargetApi(21)
    private boolean performSetText(SemanticsNode semanticsNode, int i11, @NonNull Bundle bundle) {
        String str;
        if (bundle == null || !bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE)) {
            str = "";
        } else {
            str = bundle.getString(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE);
        }
        this.accessibilityChannel.dispatchSemanticsAction(i11, Action.SET_TEXT, str);
        String unused = semanticsNode.value = str;
        List unused2 = semanticsNode.valueAttributes = null;
        return true;
    }

    private void predictCursorMovement(@NonNull SemanticsNode semanticsNode, int i11, boolean z11, boolean z12) {
        if (semanticsNode.textSelectionExtent >= 0 && semanticsNode.textSelectionBase >= 0) {
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 4) {
                        if (i11 == 8 || i11 == 16) {
                            if (z11) {
                                int unused = semanticsNode.textSelectionExtent = semanticsNode.value.length();
                            } else {
                                int unused2 = semanticsNode.textSelectionExtent = 0;
                            }
                        }
                    } else if (z11 && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                        Matcher matcher = Pattern.compile("(?!^)(\\n)").matcher(semanticsNode.value.substring(semanticsNode.textSelectionExtent));
                        if (matcher.find()) {
                            SemanticsNode.m(semanticsNode, matcher.start(1));
                        } else {
                            int unused3 = semanticsNode.textSelectionExtent = semanticsNode.value.length();
                        }
                    } else if (!z11 && semanticsNode.textSelectionExtent > 0) {
                        Matcher matcher2 = Pattern.compile("(?s:.*)(\\n)").matcher(semanticsNode.value.substring(0, semanticsNode.textSelectionExtent));
                        if (matcher2.find()) {
                            int unused4 = semanticsNode.textSelectionExtent = matcher2.start(1);
                        } else {
                            int unused5 = semanticsNode.textSelectionExtent = 0;
                        }
                    }
                } else if (z11 && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                    Matcher matcher3 = Pattern.compile("\\p{L}(\\b)").matcher(semanticsNode.value.substring(semanticsNode.textSelectionExtent));
                    matcher3.find();
                    if (matcher3.find()) {
                        SemanticsNode.m(semanticsNode, matcher3.start(1));
                    } else {
                        int unused6 = semanticsNode.textSelectionExtent = semanticsNode.value.length();
                    }
                } else if (!z11 && semanticsNode.textSelectionExtent > 0) {
                    Matcher matcher4 = Pattern.compile("(?s:.*)(\\b)\\p{L}").matcher(semanticsNode.value.substring(0, semanticsNode.textSelectionExtent));
                    if (matcher4.find()) {
                        int unused7 = semanticsNode.textSelectionExtent = matcher4.start(1);
                    }
                }
            } else if (z11 && semanticsNode.textSelectionExtent < semanticsNode.value.length()) {
                SemanticsNode.m(semanticsNode, 1);
            } else if (!z11 && semanticsNode.textSelectionExtent > 0) {
                SemanticsNode.n(semanticsNode, 1);
            }
            if (!z12) {
                int unused8 = semanticsNode.textSelectionBase = semanticsNode.textSelectionExtent;
            }
        }
    }

    /* access modifiers changed from: private */
    public void sendAccessibilityEvent(int i11, int i12) {
        if (this.accessibilityManager.isEnabled()) {
            sendAccessibilityEvent(obtainAccessibilityEvent(i11, i12));
        }
    }

    /* access modifiers changed from: private */
    public void sendLatestAccessibilityFlagsToFlutter() {
        this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
    }

    private void sendWindowContentChangeEvent(int i11) {
        AccessibilityEvent obtainAccessibilityEvent = obtainAccessibilityEvent(i11, 2048);
        obtainAccessibilityEvent.setContentChangeTypes(1);
        sendAccessibilityEvent(obtainAccessibilityEvent);
    }

    @RequiresApi(28)
    @TargetApi(28)
    private void setAccessibilityPaneTitle(String str) {
        this.rootAccessibilityView.setAccessibilityPaneTitle(str);
    }

    /* access modifiers changed from: private */
    public void setAccessibleNavigation(boolean z11) {
        if (this.accessibleNavigation != z11) {
            this.accessibleNavigation = z11;
            if (z11) {
                this.accessibilityFeatureFlags |= AccessibilityFeature.ACCESSIBLE_NAVIGATION.f14435b;
            } else {
                this.accessibilityFeatureFlags &= ~AccessibilityFeature.ACCESSIBLE_NAVIGATION.f14435b;
            }
            sendLatestAccessibilityFlagsToFlutter();
        }
    }

    @RequiresApi(31)
    @TargetApi(31)
    private void setBoldTextFlag() {
        boolean z11;
        View view = this.rootAccessibilityView;
        if (view != null && view.getResources() != null) {
            int a11 = this.rootAccessibilityView.getResources().getConfiguration().fontWeightAdjustment;
            if (a11 == Integer.MAX_VALUE || a11 < 300) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (z11) {
                this.accessibilityFeatureFlags |= AccessibilityFeature.BOLD_TEXT.f14435b;
            } else {
                this.accessibilityFeatureFlags &= AccessibilityFeature.BOLD_TEXT.f14435b;
            }
            sendLatestAccessibilityFlagsToFlutter();
        }
    }

    private boolean shouldSetCollectionInfo(SemanticsNode semanticsNode) {
        if (semanticsNode.scrollChildren <= 0 || (!SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new a(semanticsNode)) && SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new b()))) {
            return false;
        }
        return true;
    }

    @RequiresApi(19)
    @TargetApi(19)
    private void willRemoveSemanticsNode(SemanticsNode semanticsNode) {
        View platformViewById;
        Integer num;
        SemanticsNode unused = semanticsNode.parent = null;
        if (!(semanticsNode.platformViewId == -1 || (num = this.embeddedAccessibilityFocusedNodeId) == null || this.accessibilityViewEmbedder.platformViewOfNode(num.intValue()) != this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId))) {
            sendAccessibilityEvent(this.embeddedAccessibilityFocusedNodeId.intValue(), 65536);
            this.embeddedAccessibilityFocusedNodeId = null;
        }
        if (!(semanticsNode.platformViewId == -1 || (platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId)) == null)) {
            platformViewById.setImportantForAccessibility(4);
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 == semanticsNode) {
            sendAccessibilityEvent(semanticsNode2.f14440id, 65536);
            this.accessibilityFocusedSemanticsNode = null;
        }
        if (this.inputFocusedSemanticsNode == semanticsNode) {
            this.inputFocusedSemanticsNode = null;
        }
        if (this.hoveredObject == semanticsNode) {
            this.hoveredObject = null;
        }
    }

    @SuppressLint({"NewApi"})
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i11) {
        boolean z11;
        int i12;
        int i13;
        boolean z12;
        boolean z13;
        boolean z14 = true;
        setAccessibleNavigation(true);
        if (i11 >= 65536) {
            return this.accessibilityViewEmbedder.createAccessibilityNodeInfo(i11);
        }
        if (i11 == -1) {
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView);
            this.rootAccessibilityView.onInitializeAccessibilityNodeInfo(obtain);
            if (this.flutterSemanticsTree.containsKey(0)) {
                obtain.addChild(this.rootAccessibilityView, 0);
            }
            return obtain;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i11));
        if (semanticsNode == null) {
            return null;
        }
        if (semanticsNode.platformViewId == -1 || !this.platformViewsAccessibilityDelegate.usesVirtualDisplay(semanticsNode.platformViewId)) {
            AccessibilityNodeInfo obtainAccessibilityNodeInfo = obtainAccessibilityNodeInfo(this.rootAccessibilityView, i11);
            int i14 = Build.VERSION.SDK_INT;
            String str = "";
            obtainAccessibilityNodeInfo.setViewIdResourceName(str);
            obtainAccessibilityNodeInfo.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
            obtainAccessibilityNodeInfo.setClassName(AndroidComposeViewAccessibilityDelegateCompat.ClassName);
            obtainAccessibilityNodeInfo.setSource(this.rootAccessibilityView, i11);
            obtainAccessibilityNodeInfo.setFocusable(semanticsNode.isFocusable());
            SemanticsNode semanticsNode2 = this.inputFocusedSemanticsNode;
            if (semanticsNode2 != null) {
                if (semanticsNode2.f14440id == i11) {
                    z13 = true;
                } else {
                    z13 = false;
                }
                obtainAccessibilityNodeInfo.setFocused(z13);
            }
            SemanticsNode semanticsNode3 = this.accessibilityFocusedSemanticsNode;
            if (semanticsNode3 != null) {
                if (semanticsNode3.f14440id == i11) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                obtainAccessibilityNodeInfo.setAccessibilityFocused(z12);
            }
            Flag flag = Flag.IS_TEXT_FIELD;
            if (semanticsNode.hasFlag(flag)) {
                obtainAccessibilityNodeInfo.setPassword(semanticsNode.hasFlag(Flag.IS_OBSCURED));
                Flag flag2 = Flag.IS_READ_ONLY;
                if (!semanticsNode.hasFlag(flag2)) {
                    obtainAccessibilityNodeInfo.setClassName("android.widget.EditText");
                }
                obtainAccessibilityNodeInfo.setEditable(!semanticsNode.hasFlag(flag2));
                if (!(semanticsNode.textSelectionBase == -1 || semanticsNode.textSelectionExtent == -1)) {
                    obtainAccessibilityNodeInfo.setTextSelection(semanticsNode.textSelectionBase, semanticsNode.textSelectionExtent);
                }
                SemanticsNode semanticsNode4 = this.accessibilityFocusedSemanticsNode;
                if (semanticsNode4 != null && semanticsNode4.f14440id == i11) {
                    obtainAccessibilityNodeInfo.setLiveRegion(1);
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_CHARACTER)) {
                    obtainAccessibilityNodeInfo.addAction(256);
                    i12 = 1;
                } else {
                    i12 = 0;
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER)) {
                    obtainAccessibilityNodeInfo.addAction(512);
                    i12 |= 1;
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_FORWARD_BY_WORD)) {
                    obtainAccessibilityNodeInfo.addAction(256);
                    i12 |= 2;
                }
                if (semanticsNode.hasAction(Action.MOVE_CURSOR_BACKWARD_BY_WORD)) {
                    obtainAccessibilityNodeInfo.addAction(512);
                    i12 |= 2;
                }
                obtainAccessibilityNodeInfo.setMovementGranularities(i12);
                if (semanticsNode.maxValueLength >= 0) {
                    if (semanticsNode.value == null) {
                        i13 = 0;
                    } else {
                        i13 = semanticsNode.value.length();
                    }
                    int unused = semanticsNode.currentValueLength;
                    int unused2 = semanticsNode.maxValueLength;
                    obtainAccessibilityNodeInfo.setMaxTextLength((i13 - semanticsNode.currentValueLength) + semanticsNode.maxValueLength);
                }
            }
            if (semanticsNode.hasAction(Action.SET_SELECTION)) {
                obtainAccessibilityNodeInfo.addAction(131072);
            }
            if (semanticsNode.hasAction(Action.COPY)) {
                obtainAccessibilityNodeInfo.addAction(16384);
            }
            if (semanticsNode.hasAction(Action.CUT)) {
                obtainAccessibilityNodeInfo.addAction(65536);
            }
            if (semanticsNode.hasAction(Action.PASTE)) {
                obtainAccessibilityNodeInfo.addAction(32768);
            }
            if (semanticsNode.hasAction(Action.SET_TEXT)) {
                obtainAccessibilityNodeInfo.addAction(2097152);
            }
            if (semanticsNode.hasFlag(Flag.IS_BUTTON) || semanticsNode.hasFlag(Flag.IS_LINK)) {
                obtainAccessibilityNodeInfo.setClassName("android.widget.Button");
            }
            if (semanticsNode.hasFlag(Flag.IS_IMAGE)) {
                obtainAccessibilityNodeInfo.setClassName("android.widget.ImageView");
            }
            if (semanticsNode.hasAction(Action.DISMISS)) {
                obtainAccessibilityNodeInfo.setDismissable(true);
                obtainAccessibilityNodeInfo.addAction(1048576);
            }
            if (semanticsNode.parent != null) {
                obtainAccessibilityNodeInfo.setParent(this.rootAccessibilityView, semanticsNode.parent.f14440id);
            } else {
                obtainAccessibilityNodeInfo.setParent(this.rootAccessibilityView);
            }
            if (semanticsNode.previousNodeId != -1) {
                obtainAccessibilityNodeInfo.setTraversalAfter(this.rootAccessibilityView, semanticsNode.previousNodeId);
            }
            Rect f11 = semanticsNode.getGlobalRect();
            if (semanticsNode.parent != null) {
                Rect f12 = semanticsNode.parent.getGlobalRect();
                Rect rect = new Rect(f11);
                rect.offset(-f12.left, -f12.top);
                obtainAccessibilityNodeInfo.setBoundsInParent(rect);
            } else {
                obtainAccessibilityNodeInfo.setBoundsInParent(f11);
            }
            obtainAccessibilityNodeInfo.setBoundsInScreen(getBoundsInScreen(f11));
            obtainAccessibilityNodeInfo.setVisibleToUser(true);
            if (!semanticsNode.hasFlag(Flag.HAS_ENABLED_STATE) || semanticsNode.hasFlag(Flag.IS_ENABLED)) {
                z11 = true;
            } else {
                z11 = false;
            }
            obtainAccessibilityNodeInfo.setEnabled(z11);
            if (semanticsNode.hasAction(Action.TAP)) {
                if (semanticsNode.onTapOverride != null) {
                    obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(16, semanticsNode.onTapOverride.hint));
                    obtainAccessibilityNodeInfo.setClickable(true);
                } else {
                    obtainAccessibilityNodeInfo.addAction(16);
                    obtainAccessibilityNodeInfo.setClickable(true);
                }
            }
            if (semanticsNode.hasAction(Action.LONG_PRESS)) {
                if (semanticsNode.onLongPressOverride != null) {
                    obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(32, semanticsNode.onLongPressOverride.hint));
                    obtainAccessibilityNodeInfo.setLongClickable(true);
                } else {
                    obtainAccessibilityNodeInfo.addAction(32);
                    obtainAccessibilityNodeInfo.setLongClickable(true);
                }
            }
            Action action = Action.SCROLL_LEFT;
            if (semanticsNode.hasAction(action) || semanticsNode.hasAction(Action.SCROLL_UP) || semanticsNode.hasAction(Action.SCROLL_RIGHT) || semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                obtainAccessibilityNodeInfo.setScrollable(true);
                if (semanticsNode.hasFlag(Flag.HAS_IMPLICIT_SCROLLING)) {
                    if (semanticsNode.hasAction(action) || semanticsNode.hasAction(Action.SCROLL_RIGHT)) {
                        if (shouldSetCollectionInfo(semanticsNode)) {
                            obtainAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(0, semanticsNode.scrollChildren, false));
                        } else {
                            obtainAccessibilityNodeInfo.setClassName("android.widget.HorizontalScrollView");
                        }
                    } else if (shouldSetCollectionInfo(semanticsNode)) {
                        obtainAccessibilityNodeInfo.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(semanticsNode.scrollChildren, 0, false));
                    } else {
                        obtainAccessibilityNodeInfo.setClassName("android.widget.ScrollView");
                    }
                }
                if (semanticsNode.hasAction(action) || semanticsNode.hasAction(Action.SCROLL_UP)) {
                    obtainAccessibilityNodeInfo.addAction(4096);
                }
                if (semanticsNode.hasAction(Action.SCROLL_RIGHT) || semanticsNode.hasAction(Action.SCROLL_DOWN)) {
                    obtainAccessibilityNodeInfo.addAction(8192);
                }
            }
            Action action2 = Action.INCREASE;
            if (semanticsNode.hasAction(action2) || semanticsNode.hasAction(Action.DECREASE)) {
                obtainAccessibilityNodeInfo.setClassName("android.widget.SeekBar");
                if (semanticsNode.hasAction(action2)) {
                    obtainAccessibilityNodeInfo.addAction(4096);
                }
                if (semanticsNode.hasAction(Action.DECREASE)) {
                    obtainAccessibilityNodeInfo.addAction(8192);
                }
            }
            if (semanticsNode.hasFlag(Flag.IS_LIVE_REGION)) {
                obtainAccessibilityNodeInfo.setLiveRegion(1);
            }
            if (semanticsNode.hasFlag(flag)) {
                obtainAccessibilityNodeInfo.setText(semanticsNode.getValue());
                if (i14 >= 28) {
                    obtainAccessibilityNodeInfo.setHintText(semanticsNode.getTextFieldHint());
                }
            } else if (!semanticsNode.hasFlag(Flag.SCOPES_ROUTE)) {
                CharSequence A = semanticsNode.getValueLabelHint();
                String str2 = A;
                if (i14 < 28) {
                    str2 = A;
                    if (semanticsNode.tooltip != null) {
                        if (A != null) {
                            str = A;
                        }
                        str2 = str + StringUtils.LF + semanticsNode.tooltip;
                    }
                }
                if (str2 != null) {
                    obtainAccessibilityNodeInfo.setContentDescription(str2);
                }
            }
            if (i14 >= 28 && semanticsNode.tooltip != null) {
                obtainAccessibilityNodeInfo.setTooltipText(semanticsNode.tooltip);
            }
            boolean h11 = semanticsNode.hasFlag(Flag.HAS_CHECKED_STATE);
            boolean h12 = semanticsNode.hasFlag(Flag.HAS_TOGGLED_STATE);
            if (!h11 && !h12) {
                z14 = false;
            }
            obtainAccessibilityNodeInfo.setCheckable(z14);
            if (h11) {
                obtainAccessibilityNodeInfo.setChecked(semanticsNode.hasFlag(Flag.IS_CHECKED));
                if (semanticsNode.hasFlag(Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP)) {
                    obtainAccessibilityNodeInfo.setClassName("android.widget.RadioButton");
                } else {
                    obtainAccessibilityNodeInfo.setClassName("android.widget.CheckBox");
                }
            } else if (h12) {
                obtainAccessibilityNodeInfo.setChecked(semanticsNode.hasFlag(Flag.IS_TOGGLED));
                obtainAccessibilityNodeInfo.setClassName("android.widget.Switch");
            }
            obtainAccessibilityNodeInfo.setSelected(semanticsNode.hasFlag(Flag.IS_SELECTED));
            if (i14 >= 28) {
                obtainAccessibilityNodeInfo.setHeading(semanticsNode.hasFlag(Flag.IS_HEADER));
            }
            SemanticsNode semanticsNode5 = this.accessibilityFocusedSemanticsNode;
            if (semanticsNode5 == null || semanticsNode5.f14440id != i11) {
                obtainAccessibilityNodeInfo.addAction(64);
            } else {
                obtainAccessibilityNodeInfo.addAction(128);
            }
            if (semanticsNode.customAccessibilityActions != null) {
                for (CustomAccessibilityAction customAccessibilityAction : semanticsNode.customAccessibilityActions) {
                    obtainAccessibilityNodeInfo.addAction(new AccessibilityNodeInfo.AccessibilityAction(customAccessibilityAction.resourceId, customAccessibilityAction.label));
                }
            }
            for (SemanticsNode semanticsNode6 : semanticsNode.childrenInTraversalOrder) {
                if (!semanticsNode6.hasFlag(Flag.IS_HIDDEN)) {
                    if (semanticsNode6.platformViewId != -1) {
                        View platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode6.platformViewId);
                        if (!this.platformViewsAccessibilityDelegate.usesVirtualDisplay(semanticsNode6.platformViewId)) {
                            obtainAccessibilityNodeInfo.addChild(platformViewById);
                        }
                    }
                    obtainAccessibilityNodeInfo.addChild(this.rootAccessibilityView, semanticsNode6.f14440id);
                }
            }
            return obtainAccessibilityNodeInfo;
        }
        View platformViewById2 = this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId);
        if (platformViewById2 == null) {
            return null;
        }
        return this.accessibilityViewEmbedder.getRootNode(platformViewById2, semanticsNode.f14440id, semanticsNode.getGlobalRect());
    }

    @SuppressLint({"SwitchIntDef"})
    public boolean externalViewRequestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.embeddedInputFocusedNodeId = recordFlutterId;
            this.inputFocusedSemanticsNode = null;
            return true;
        } else if (eventType == 128) {
            this.hoveredObject = null;
            return true;
        } else if (eventType == 32768) {
            this.embeddedAccessibilityFocusedNodeId = recordFlutterId;
            this.accessibilityFocusedSemanticsNode = null;
            return true;
        } else if (eventType != 65536) {
            return true;
        } else {
            this.embeddedInputFocusedNodeId = null;
            this.embeddedAccessibilityFocusedNodeId = null;
            return true;
        }
    }

    public AccessibilityNodeInfo findFocus(int i11) {
        if (i11 == 1) {
            SemanticsNode semanticsNode = this.inputFocusedSemanticsNode;
            if (semanticsNode != null) {
                return createAccessibilityNodeInfo(semanticsNode.f14440id);
            }
            Integer num = this.embeddedInputFocusedNodeId;
            if (num != null) {
                return createAccessibilityNodeInfo(num.intValue());
            }
        } else if (i11 != 2) {
            return null;
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 != null) {
            return createAccessibilityNodeInfo(semanticsNode2.f14440id);
        }
        Integer num2 = this.embeddedAccessibilityFocusedNodeId;
        if (num2 != null) {
            return createAccessibilityNodeInfo(num2.intValue());
        }
        return null;
    }

    @VisibleForTesting
    public boolean getAccessibleNavigation() {
        return this.accessibleNavigation;
    }

    @VisibleForTesting
    public int getHoveredObjectId() {
        return this.hoveredObject.f14440id;
    }

    public boolean isAccessibilityEnabled() {
        return this.accessibilityManager.isEnabled();
    }

    public boolean isTouchExplorationEnabled() {
        return this.accessibilityManager.isTouchExplorationEnabled();
    }

    @VisibleForTesting
    public AccessibilityNodeInfo obtainAccessibilityNodeInfo(View view, int i11) {
        return AccessibilityNodeInfo.obtain(view, i11);
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent) {
        return onAccessibilityHoverEvent(motionEvent, false);
    }

    public boolean performAction(int i11, int i12, @Nullable Bundle bundle) {
        if (i11 >= 65536) {
            boolean performAction = this.accessibilityViewEmbedder.performAction(i11, i12, bundle);
            if (performAction && i12 == 128) {
                this.embeddedAccessibilityFocusedNodeId = null;
            }
            return performAction;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i11));
        boolean z11 = false;
        if (semanticsNode == null) {
            return false;
        }
        switch (i12) {
            case 16:
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.TAP);
                return true;
            case 32:
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.LONG_PRESS);
                return true;
            case 64:
                if (this.accessibilityFocusedSemanticsNode == null) {
                    this.rootAccessibilityView.invalidate();
                }
                this.accessibilityFocusedSemanticsNode = semanticsNode;
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i11, 32768);
                if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                    sendAccessibilityEvent(i11, 4);
                }
                return true;
            case 128:
                SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
                if (semanticsNode2 != null && semanticsNode2.f14440id == i11) {
                    this.accessibilityFocusedSemanticsNode = null;
                }
                Integer num = this.embeddedAccessibilityFocusedNodeId;
                if (num != null && num.intValue() == i11) {
                    this.embeddedAccessibilityFocusedNodeId = null;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i11, 65536);
                return true;
            case 256:
                return performCursorMoveAction(semanticsNode, i11, bundle, true);
            case 512:
                return performCursorMoveAction(semanticsNode, i11, bundle, false);
            case 4096:
                Action action = Action.SCROLL_UP;
                if (semanticsNode.hasAction(action)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i11, action);
                } else {
                    Action action2 = Action.SCROLL_LEFT;
                    if (semanticsNode.hasAction(action2)) {
                        this.accessibilityChannel.dispatchSemanticsAction(i11, action2);
                    } else {
                        Action action3 = Action.INCREASE;
                        if (!semanticsNode.hasAction(action3)) {
                            return false;
                        }
                        String unused = semanticsNode.value = semanticsNode.increasedValue;
                        List unused2 = semanticsNode.valueAttributes = semanticsNode.increasedValueAttributes;
                        sendAccessibilityEvent(i11, 4);
                        this.accessibilityChannel.dispatchSemanticsAction(i11, action3);
                    }
                }
                return true;
            case 8192:
                Action action4 = Action.SCROLL_DOWN;
                if (semanticsNode.hasAction(action4)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i11, action4);
                } else {
                    Action action5 = Action.SCROLL_RIGHT;
                    if (semanticsNode.hasAction(action5)) {
                        this.accessibilityChannel.dispatchSemanticsAction(i11, action5);
                    } else {
                        Action action6 = Action.DECREASE;
                        if (!semanticsNode.hasAction(action6)) {
                            return false;
                        }
                        String unused3 = semanticsNode.value = semanticsNode.decreasedValue;
                        List unused4 = semanticsNode.valueAttributes = semanticsNode.decreasedValueAttributes;
                        sendAccessibilityEvent(i11, 4);
                        this.accessibilityChannel.dispatchSemanticsAction(i11, action6);
                    }
                }
                return true;
            case 16384:
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.COPY);
                return true;
            case 32768:
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.PASTE);
                return true;
            case 65536:
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.CUT);
                return true;
            case 131072:
                HashMap hashMap = new HashMap();
                if (bundle != null && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT) && bundle.containsKey(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)) {
                    z11 = true;
                }
                if (z11) {
                    hashMap.put(TtmlNode.RUBY_BASE, Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_START_INT)));
                    hashMap.put(TtmlNode.ATTR_TTS_EXTENT, Integer.valueOf(bundle.getInt(AccessibilityNodeInfoCompat.ACTION_ARGUMENT_SELECTION_END_INT)));
                } else {
                    hashMap.put(TtmlNode.RUBY_BASE, Integer.valueOf(semanticsNode.textSelectionExtent));
                    hashMap.put(TtmlNode.ATTR_TTS_EXTENT, Integer.valueOf(semanticsNode.textSelectionExtent));
                }
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.SET_SELECTION, hashMap);
                SemanticsNode semanticsNode3 = this.flutterSemanticsTree.get(Integer.valueOf(i11));
                int unused5 = semanticsNode3.textSelectionBase = ((Integer) hashMap.get(TtmlNode.RUBY_BASE)).intValue();
                int unused6 = semanticsNode3.textSelectionExtent = ((Integer) hashMap.get(TtmlNode.ATTR_TTS_EXTENT)).intValue();
                return true;
            case 1048576:
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.DISMISS);
                return true;
            case 2097152:
                return performSetText(semanticsNode, i11, bundle);
            case ACTION_SHOW_ON_SCREEN /*16908342*/:
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.SHOW_ON_SCREEN);
                return true;
            default:
                CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i12 - FIRST_RESOURCE_ID));
                if (customAccessibilityAction == null) {
                    return false;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i11, Action.CUSTOM_ACTION, Integer.valueOf(customAccessibilityAction.f14436id));
                return true;
        }
    }

    public void release() {
        this.isReleased = true;
        this.platformViewsAccessibilityDelegate.detachAccessibilityBridge();
        setOnAccessibilityChangeListener((OnAccessibilityChangeListener) null);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
        this.accessibilityChannel.setAccessibilityMessageHandler((AccessibilityChannel.AccessibilityMessageHandler) null);
    }

    public void reset() {
        this.flutterSemanticsTree.clear();
        SemanticsNode semanticsNode = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.f14440id, 65536);
        }
        this.accessibilityFocusedSemanticsNode = null;
        this.hoveredObject = null;
        sendWindowContentChangeEvent(0);
    }

    public void setOnAccessibilityChangeListener(@Nullable OnAccessibilityChangeListener onAccessibilityChangeListener2) {
        this.onAccessibilityChangeListener = onAccessibilityChangeListener2;
    }

    public void v(@NonNull ByteBuffer byteBuffer, @NonNull String[] strArr) {
        String str;
        while (byteBuffer.hasRemaining()) {
            CustomAccessibilityAction orCreateAccessibilityAction = getOrCreateAccessibilityAction(byteBuffer.getInt());
            int unused = orCreateAccessibilityAction.overrideId = byteBuffer.getInt();
            int i11 = byteBuffer.getInt();
            String str2 = null;
            if (i11 == -1) {
                str = null;
            } else {
                str = strArr[i11];
            }
            String unused2 = orCreateAccessibilityAction.label = str;
            int i12 = byteBuffer.getInt();
            if (i12 != -1) {
                str2 = strArr[i12];
            }
            String unused3 = orCreateAccessibilityAction.hint = str2;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r10v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v24, resolved type: io.flutter.view.AccessibilityBridge$SemanticsNode} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void w(@androidx.annotation.NonNull java.nio.ByteBuffer r9, @androidx.annotation.NonNull java.lang.String[] r10, @androidx.annotation.NonNull java.nio.ByteBuffer[] r11) {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
        L_0x0005:
            boolean r1 = r9.hasRemaining()
            r2 = 0
            if (r1 == 0) goto L_0x0056
            int r1 = r9.getInt()
            io.flutter.view.AccessibilityBridge$SemanticsNode r1 = r8.getOrCreateSemanticsNode(r1)
            r1.updateWith(r9, r10, r11)
            io.flutter.view.AccessibilityBridge$Flag r3 = io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r3 = r1.hasFlag(r3)
            if (r3 == 0) goto L_0x0020
            goto L_0x0005
        L_0x0020:
            io.flutter.view.AccessibilityBridge$Flag r3 = io.flutter.view.AccessibilityBridge.Flag.IS_FOCUSED
            boolean r3 = r1.hasFlag(r3)
            if (r3 == 0) goto L_0x002a
            r8.inputFocusedSemanticsNode = r1
        L_0x002a:
            boolean r3 = r1.hadPreviousConfig
            if (r3 == 0) goto L_0x0033
            r0.add(r1)
        L_0x0033:
            int r3 = r1.platformViewId
            r4 = -1
            if (r3 == r4) goto L_0x0005
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r3 = r8.platformViewsAccessibilityDelegate
            int r4 = r1.platformViewId
            boolean r3 = r3.usesVirtualDisplay(r4)
            if (r3 != 0) goto L_0x0005
            io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate r3 = r8.platformViewsAccessibilityDelegate
            int r1 = r1.platformViewId
            android.view.View r1 = r3.getPlatformViewById(r1)
            if (r1 == 0) goto L_0x0005
            r1.setImportantForAccessibility(r2)
            goto L_0x0005
        L_0x0056:
            java.util.HashSet r9 = new java.util.HashSet
            r9.<init>()
            io.flutter.view.AccessibilityBridge$SemanticsNode r10 = r8.getRootSemanticsNode()
            java.util.ArrayList r11 = new java.util.ArrayList
            r11.<init>()
            r1 = 1
            if (r10 == 0) goto L_0x00b3
            r3 = 16
            float[] r3 = new float[r3]
            android.opengl.Matrix.setIdentityM(r3, r2)
            int r4 = android.os.Build.VERSION.SDK_INT
            r5 = 28
            if (r4 < r5) goto L_0x0079
            boolean r4 = r8.doesLayoutInDisplayCutoutModeRequireLeftInset()
            goto L_0x007a
        L_0x0079:
            r4 = r1
        L_0x007a:
            if (r4 == 0) goto L_0x00ad
            android.view.View r4 = r8.rootAccessibilityView
            android.view.WindowInsets r4 = r4.getRootWindowInsets()
            if (r4 == 0) goto L_0x00ad
            java.lang.Integer r5 = r8.lastLeftFrameInset
            int r6 = r4.getSystemWindowInsetLeft()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            boolean r5 = r5.equals(r6)
            if (r5 != 0) goto L_0x009a
            boolean unused = r10.globalGeometryDirty = r1
            boolean unused = r10.inverseTransformDirty = r1
        L_0x009a:
            int r4 = r4.getSystemWindowInsetLeft()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r8.lastLeftFrameInset = r4
            int r4 = r4.intValue()
            float r4 = (float) r4
            r5 = 0
            android.opengl.Matrix.translateM(r3, r2, r4, r5, r5)
        L_0x00ad:
            r10.updateRecursively(r3, r9, r2)
            r10.collectRoutes(r11)
        L_0x00b3:
            java.util.Iterator r10 = r11.iterator()
            r3 = 0
            r4 = r3
        L_0x00b9:
            boolean r5 = r10.hasNext()
            if (r5 == 0) goto L_0x00d7
            java.lang.Object r5 = r10.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r5 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r5
            java.util.List<java.lang.Integer> r6 = r8.flutterNavigationStack
            int r7 = r5.f14440id
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            boolean r6 = r6.contains(r7)
            if (r6 != 0) goto L_0x00b9
            r4 = r5
            goto L_0x00b9
        L_0x00d7:
            if (r4 != 0) goto L_0x00eb
            int r10 = r11.size()
            if (r10 <= 0) goto L_0x00eb
            int r10 = r11.size()
            int r10 = r10 - r1
            java.lang.Object r10 = r11.get(r10)
            r4 = r10
            io.flutter.view.AccessibilityBridge$SemanticsNode r4 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r4
        L_0x00eb:
            if (r4 == 0) goto L_0x010a
            int r10 = r4.f14440id
            int r5 = r8.previousRouteId
            if (r10 != r5) goto L_0x0101
            int r10 = r11.size()
            java.util.List<java.lang.Integer> r5 = r8.flutterNavigationStack
            int r5 = r5.size()
            if (r10 == r5) goto L_0x010a
        L_0x0101:
            int r10 = r4.f14440id
            r8.previousRouteId = r10
            r8.onWindowNameChange(r4)
        L_0x010a:
            java.util.List<java.lang.Integer> r10 = r8.flutterNavigationStack
            r10.clear()
            java.util.Iterator r10 = r11.iterator()
        L_0x0113:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x012d
            java.lang.Object r11 = r10.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            java.util.List<java.lang.Integer> r4 = r8.flutterNavigationStack
            int r11 = r11.f14440id
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            r4.add(r11)
            goto L_0x0113
        L_0x012d:
            java.util.Map<java.lang.Integer, io.flutter.view.AccessibilityBridge$SemanticsNode> r10 = r8.flutterSemanticsTree
            java.util.Set r10 = r10.entrySet()
            java.util.Iterator r10 = r10.iterator()
        L_0x0137:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x0156
            java.lang.Object r11 = r10.next()
            java.util.Map$Entry r11 = (java.util.Map.Entry) r11
            java.lang.Object r11 = r11.getValue()
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r11
            boolean r4 = r9.contains(r11)
            if (r4 != 0) goto L_0x0137
            r8.willRemoveSemanticsNode(r11)
            r10.remove()
            goto L_0x0137
        L_0x0156:
            r8.sendWindowContentChangeEvent(r2)
            java.util.Iterator r9 = r0.iterator()
        L_0x015d:
            boolean r10 = r9.hasNext()
            if (r10 == 0) goto L_0x0336
            java.lang.Object r10 = r9.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r10 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r10
            boolean r11 = r10.didScroll()
            if (r11 == 0) goto L_0x0228
            int r11 = r10.f14440id
            r0 = 4096(0x1000, float:5.74E-42)
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r0)
            float r0 = r10.scrollPosition
            float r4 = r10.scrollExtentMax
            float r5 = r10.scrollExtentMax
            boolean r5 = java.lang.Float.isInfinite(r5)
            r6 = 1203982336(0x47c35000, float:100000.0)
            if (r5 == 0) goto L_0x0197
            r4 = 1200142336(0x4788b800, float:70000.0)
            int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r5 <= 0) goto L_0x0196
            r0 = r4
        L_0x0196:
            r4 = r6
        L_0x0197:
            float r5 = r10.scrollExtentMin
            boolean r5 = java.lang.Float.isInfinite(r5)
            if (r5 == 0) goto L_0x01ac
            float r4 = r4 + r6
            r5 = -947341312(0xffffffffc788b800, float:-70000.0)
            int r7 = (r0 > r5 ? 1 : (r0 == r5 ? 0 : -1))
            if (r7 >= 0) goto L_0x01aa
            r0 = r5
        L_0x01aa:
            float r0 = r0 + r6
            goto L_0x01b6
        L_0x01ac:
            float r5 = r10.scrollExtentMin
            float r4 = r4 - r5
            float r5 = r10.scrollExtentMin
            float r0 = r0 - r5
        L_0x01b6:
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_UP
            boolean r5 = r10.hadAction(r5)
            if (r5 != 0) goto L_0x01e0
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_DOWN
            boolean r5 = r10.hadAction(r5)
            if (r5 == 0) goto L_0x01c7
            goto L_0x01e0
        L_0x01c7:
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_LEFT
            boolean r5 = r10.hadAction(r5)
            if (r5 != 0) goto L_0x01d7
            io.flutter.view.AccessibilityBridge$Action r5 = io.flutter.view.AccessibilityBridge.Action.SCROLL_RIGHT
            boolean r5 = r10.hadAction(r5)
            if (r5 == 0) goto L_0x01e8
        L_0x01d7:
            int r0 = (int) r0
            r11.setScrollX(r0)
            int r0 = (int) r4
            r11.setMaxScrollX(r0)
            goto L_0x01e8
        L_0x01e0:
            int r0 = (int) r0
            r11.setScrollY(r0)
            int r0 = (int) r4
            r11.setMaxScrollY(r0)
        L_0x01e8:
            int r0 = r10.scrollChildren
            if (r0 <= 0) goto L_0x0225
            int r0 = r10.scrollChildren
            r11.setItemCount(r0)
            int r0 = r10.scrollIndex
            r11.setFromIndex(r0)
            java.util.List r0 = r10.childrenInHitTestOrder
            java.util.Iterator r0 = r0.iterator()
            r4 = r2
        L_0x0205:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x021c
            java.lang.Object r5 = r0.next()
            io.flutter.view.AccessibilityBridge$SemanticsNode r5 = (io.flutter.view.AccessibilityBridge.SemanticsNode) r5
            io.flutter.view.AccessibilityBridge$Flag r6 = io.flutter.view.AccessibilityBridge.Flag.IS_HIDDEN
            boolean r5 = r5.hasFlag(r6)
            if (r5 != 0) goto L_0x0205
            int r4 = r4 + 1
            goto L_0x0205
        L_0x021c:
            int r0 = r10.scrollIndex
            int r0 = r0 + r4
            int r0 = r0 - r1
            r11.setToIndex(r0)
        L_0x0225:
            r8.sendAccessibilityEvent(r11)
        L_0x0228:
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_LIVE_REGION
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x023d
            boolean r11 = r10.didChangeLabel()
            if (r11 == 0) goto L_0x023d
            int r11 = r10.f14440id
            r8.sendWindowContentChangeEvent(r11)
        L_0x023d:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.accessibilityFocusedSemanticsNode
            if (r11 == 0) goto L_0x0270
            int r11 = r11.f14440id
            int r0 = r10.f14440id
            if (r11 != r0) goto L_0x0270
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_SELECTED
            boolean r0 = r10.hadFlag(r11)
            if (r0 != 0) goto L_0x0270
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x0270
            int r11 = r10.f14440id
            r0 = 4
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r0)
            java.util.List r0 = r11.getText()
            java.lang.String r4 = r10.label
            r0.add(r4)
            r8.sendAccessibilityEvent(r11)
        L_0x0270:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            if (r11 == 0) goto L_0x02a0
            int r11 = r11.f14440id
            int r0 = r10.f14440id
            if (r11 != r0) goto L_0x02a0
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.lastInputFocusedSemanticsNode
            if (r11 == 0) goto L_0x028e
            int r11 = r11.f14440id
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r8.inputFocusedSemanticsNode
            int r0 = r0.f14440id
            if (r11 == r0) goto L_0x02a0
        L_0x028e:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            r8.lastInputFocusedSemanticsNode = r11
            int r11 = r10.f14440id
            r0 = 8
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r0)
            r8.sendAccessibilityEvent(r11)
            goto L_0x02a6
        L_0x02a0:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            if (r11 != 0) goto L_0x02a6
            r8.lastInputFocusedSemanticsNode = r3
        L_0x02a6:
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.inputFocusedSemanticsNode
            if (r11 == 0) goto L_0x015d
            int r11 = r11.f14440id
            int r0 = r10.f14440id
            if (r11 != r0) goto L_0x015d
            io.flutter.view.AccessibilityBridge$Flag r11 = io.flutter.view.AccessibilityBridge.Flag.IS_TEXT_FIELD
            boolean r0 = r10.hadFlag(r11)
            if (r0 == 0) goto L_0x015d
            boolean r11 = r10.hasFlag(r11)
            if (r11 == 0) goto L_0x015d
            io.flutter.view.AccessibilityBridge$SemanticsNode r11 = r8.accessibilityFocusedSemanticsNode
            if (r11 == 0) goto L_0x02d2
            int r11 = r11.f14440id
            io.flutter.view.AccessibilityBridge$SemanticsNode r0 = r8.inputFocusedSemanticsNode
            int r0 = r0.f14440id
            if (r11 != r0) goto L_0x015d
        L_0x02d2:
            java.lang.String r11 = r10.previousValue
            java.lang.String r0 = ""
            if (r11 == 0) goto L_0x02df
            java.lang.String r11 = r10.previousValue
            goto L_0x02e0
        L_0x02df:
            r11 = r0
        L_0x02e0:
            java.lang.String r4 = r10.value
            if (r4 == 0) goto L_0x02ea
            java.lang.String r0 = r10.value
        L_0x02ea:
            int r4 = r10.f14440id
            android.view.accessibility.AccessibilityEvent r11 = r8.createTextChangedEvent(r4, r11, r0)
            if (r11 == 0) goto L_0x02f7
            r8.sendAccessibilityEvent(r11)
        L_0x02f7:
            int r11 = r10.previousTextSelectionBase
            int r4 = r10.textSelectionBase
            if (r11 != r4) goto L_0x030b
            int r11 = r10.previousTextSelectionExtent
            int r4 = r10.textSelectionExtent
            if (r11 == r4) goto L_0x015d
        L_0x030b:
            int r11 = r10.f14440id
            r4 = 8192(0x2000, float:1.14794E-41)
            android.view.accessibility.AccessibilityEvent r11 = r8.obtainAccessibilityEvent(r11, r4)
            java.util.List r4 = r11.getText()
            r4.add(r0)
            int r4 = r10.textSelectionBase
            r11.setFromIndex(r4)
            int r10 = r10.textSelectionExtent
            r11.setToIndex(r10)
            int r10 = r0.length()
            r11.setItemCount(r10)
            r8.sendAccessibilityEvent(r11)
            goto L_0x015d
        L_0x0336:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.w(java.nio.ByteBuffer, java.lang.String[], java.nio.ByteBuffer[]):void");
    }

    @VisibleForTesting
    public AccessibilityBridge(@NonNull View view, @NonNull AccessibilityChannel accessibilityChannel2, @NonNull final AccessibilityManager accessibilityManager2, @NonNull ContentResolver contentResolver2, @NonNull AccessibilityViewEmbedder accessibilityViewEmbedder2, @NonNull PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate2) {
        this.flutterSemanticsTree = new HashMap();
        this.customAccessibilityActions = new HashMap();
        this.accessibilityFeatureFlags = 0;
        this.flutterNavigationStack = new ArrayList();
        this.previousRouteId = 0;
        this.lastLeftFrameInset = 0;
        this.accessibleNavigation = false;
        this.isReleased = false;
        this.accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler() {
            public void announce(@NonNull String str) {
                AccessibilityBridge.this.rootAccessibilityView.announceForAccessibility(str);
            }

            public void onLongPress(int i11) {
                AccessibilityBridge.this.sendAccessibilityEvent(i11, 2);
            }

            public void onTap(int i11) {
                AccessibilityBridge.this.sendAccessibilityEvent(i11, 1);
            }

            public void onTooltip(@NonNull String str) {
                if (Build.VERSION.SDK_INT < 28) {
                    AccessibilityEvent k11 = AccessibilityBridge.this.obtainAccessibilityEvent(0, 32);
                    k11.getText().add(str);
                    AccessibilityBridge.this.sendAccessibilityEvent(k11);
                }
            }

            public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                AccessibilityBridge.this.v(byteBuffer, strArr);
            }

            public void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                for (ByteBuffer order : byteBufferArr) {
                    order.order(ByteOrder.LITTLE_ENDIAN);
                }
                AccessibilityBridge.this.w(byteBuffer, strArr, byteBufferArr);
            }
        };
        AnonymousClass2 r12 = new AccessibilityManager.AccessibilityStateChangeListener() {
            public void onAccessibilityStateChanged(boolean z11) {
                if (!AccessibilityBridge.this.isReleased) {
                    if (z11) {
                        AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(AccessibilityBridge.this.accessibilityMessageHandler);
                        AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityEnabled();
                    } else {
                        AccessibilityBridge.this.setAccessibleNavigation(false);
                        AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler((AccessibilityChannel.AccessibilityMessageHandler) null);
                        AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityDisabled();
                    }
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(z11, AccessibilityBridge.this.accessibilityManager.isTouchExplorationEnabled());
                    }
                }
            }
        };
        this.accessibilityStateChangeListener = r12;
        AnonymousClass3 r22 = new ContentObserver(new Handler()) {
            public void onChange(boolean z11) {
                onChange(z11, (Uri) null);
            }

            public void onChange(boolean z11, Uri uri) {
                if (!AccessibilityBridge.this.isReleased) {
                    String string = Settings.Global.getString(AccessibilityBridge.this.contentResolver, "transition_animation_scale");
                    if (string != null && string.equals("0")) {
                        AccessibilityBridge.g(AccessibilityBridge.this, AccessibilityFeature.DISABLE_ANIMATIONS.f14435b);
                    } else {
                        AccessibilityBridge.f(AccessibilityBridge.this, ~AccessibilityFeature.DISABLE_ANIMATIONS.f14435b);
                    }
                    AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
                }
            }
        };
        this.animationScaleObserver = r22;
        this.rootAccessibilityView = view;
        this.accessibilityChannel = accessibilityChannel2;
        this.accessibilityManager = accessibilityManager2;
        this.contentResolver = contentResolver2;
        this.accessibilityViewEmbedder = accessibilityViewEmbedder2;
        this.platformViewsAccessibilityDelegate = platformViewsAccessibilityDelegate2;
        r12.onAccessibilityStateChanged(accessibilityManager2.isEnabled());
        accessibilityManager2.addAccessibilityStateChangeListener(r12);
        int i11 = Build.VERSION.SDK_INT;
        AnonymousClass4 r62 = new AccessibilityManager.TouchExplorationStateChangeListener() {
            public void onTouchExplorationStateChanged(boolean z11) {
                if (!AccessibilityBridge.this.isReleased) {
                    if (!z11) {
                        AccessibilityBridge.this.setAccessibleNavigation(false);
                        AccessibilityBridge.this.onTouchExplorationExit();
                    }
                    if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                        AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(accessibilityManager2.isEnabled(), z11);
                    }
                }
            }
        };
        this.touchExplorationStateChangeListener = r62;
        r62.onTouchExplorationStateChanged(accessibilityManager2.isTouchExplorationEnabled());
        accessibilityManager2.addTouchExplorationStateChangeListener(r62);
        r22.onChange(false);
        contentResolver2.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, r22);
        if (i11 >= 31) {
            setBoldTextFlag();
        }
        platformViewsAccessibilityDelegate2.attachAccessibilityBridge(this);
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent, boolean z11) {
        if (!this.accessibilityManager.isTouchExplorationEnabled() || this.flutterSemanticsTree.isEmpty()) {
            return false;
        }
        SemanticsNode J = getRootSemanticsNode().hitTest(new float[]{motionEvent.getX(), motionEvent.getY(), 0.0f, 1.0f}, z11);
        if (J == null || J.platformViewId == -1) {
            if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
                handleTouchExploration(motionEvent.getX(), motionEvent.getY(), z11);
            } else if (motionEvent.getAction() == 10) {
                onTouchExplorationExit();
            } else {
                Log.d("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            }
            return true;
        } else if (z11) {
            return false;
        } else {
            return this.accessibilityViewEmbedder.onAccessibilityHoverEvent(J.f14440id, motionEvent);
        }
    }

    /* access modifiers changed from: private */
    public void sendAccessibilityEvent(@NonNull AccessibilityEvent accessibilityEvent) {
        if (this.accessibilityManager.isEnabled()) {
            this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, accessibilityEvent);
        }
    }
}
