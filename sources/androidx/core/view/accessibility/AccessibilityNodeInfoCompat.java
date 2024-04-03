package androidx.core.view.accessibility;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.graphics.Region;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.annotation.DoNotInline;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.OptIn;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.core.R;
import androidx.core.os.BuildCompat;
import androidx.core.view.accessibility.AccessibilityViewCommand;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.IndicativeSentencesGeneration;

public class AccessibilityNodeInfoCompat {
    public static final int ACTION_ACCESSIBILITY_FOCUS = 64;
    public static final String ACTION_ARGUMENT_COLUMN_INT = "android.view.accessibility.action.ARGUMENT_COLUMN_INT";
    public static final String ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN = "ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN";
    public static final String ACTION_ARGUMENT_HTML_ELEMENT_STRING = "ACTION_ARGUMENT_HTML_ELEMENT_STRING";
    public static final String ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT = "ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_X = "ACTION_ARGUMENT_MOVE_WINDOW_X";
    public static final String ACTION_ARGUMENT_MOVE_WINDOW_Y = "ACTION_ARGUMENT_MOVE_WINDOW_Y";
    @SuppressLint({"ActionValue"})
    public static final String ACTION_ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT = "android.view.accessibility.action.ARGUMENT_PRESS_AND_HOLD_DURATION_MILLIS_INT";
    public static final String ACTION_ARGUMENT_PROGRESS_VALUE = "android.view.accessibility.action.ARGUMENT_PROGRESS_VALUE";
    public static final String ACTION_ARGUMENT_ROW_INT = "android.view.accessibility.action.ARGUMENT_ROW_INT";
    public static final String ACTION_ARGUMENT_SELECTION_END_INT = "ACTION_ARGUMENT_SELECTION_END_INT";
    public static final String ACTION_ARGUMENT_SELECTION_START_INT = "ACTION_ARGUMENT_SELECTION_START_INT";
    public static final String ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE = "ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE";
    public static final int ACTION_CLEAR_ACCESSIBILITY_FOCUS = 128;
    public static final int ACTION_CLEAR_FOCUS = 2;
    public static final int ACTION_CLEAR_SELECTION = 8;
    public static final int ACTION_CLICK = 16;
    public static final int ACTION_COLLAPSE = 524288;
    public static final int ACTION_COPY = 16384;
    public static final int ACTION_CUT = 65536;
    public static final int ACTION_DISMISS = 1048576;
    public static final int ACTION_EXPAND = 262144;
    public static final int ACTION_FOCUS = 1;
    public static final int ACTION_LONG_CLICK = 32;
    public static final int ACTION_NEXT_AT_MOVEMENT_GRANULARITY = 256;
    public static final int ACTION_NEXT_HTML_ELEMENT = 1024;
    public static final int ACTION_PASTE = 32768;
    public static final int ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = 512;
    public static final int ACTION_PREVIOUS_HTML_ELEMENT = 2048;
    public static final int ACTION_SCROLL_BACKWARD = 8192;
    public static final int ACTION_SCROLL_FORWARD = 4096;
    public static final int ACTION_SELECT = 4;
    public static final int ACTION_SET_SELECTION = 131072;
    public static final int ACTION_SET_TEXT = 2097152;
    private static final int BOOLEAN_PROPERTY_IS_HEADING = 2;
    private static final int BOOLEAN_PROPERTY_IS_SHOWING_HINT = 4;
    private static final int BOOLEAN_PROPERTY_IS_TEXT_ENTRY_KEY = 8;
    private static final String BOOLEAN_PROPERTY_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.BOOLEAN_PROPERTY_KEY";
    private static final int BOOLEAN_PROPERTY_SCREEN_READER_FOCUSABLE = 1;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_LENGTH";
    public static final int EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_MAX_LENGTH = 20000;
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_ARG_START_INDEX";
    public static final String EXTRA_DATA_TEXT_CHARACTER_LOCATION_KEY = "android.core.view.accessibility.extra.DATA_TEXT_CHARACTER_LOCATION_KEY";
    public static final int FOCUS_ACCESSIBILITY = 2;
    public static final int FOCUS_INPUT = 1;
    private static final String HINT_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.HINT_TEXT_KEY";
    public static final int MOVEMENT_GRANULARITY_CHARACTER = 1;
    public static final int MOVEMENT_GRANULARITY_LINE = 4;
    public static final int MOVEMENT_GRANULARITY_PAGE = 16;
    public static final int MOVEMENT_GRANULARITY_PARAGRAPH = 8;
    public static final int MOVEMENT_GRANULARITY_WORD = 2;
    private static final String PANE_TITLE_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.PANE_TITLE_KEY";
    private static final String ROLE_DESCRIPTION_KEY = "AccessibilityNodeInfo.roleDescription";
    private static final String SPANS_ACTION_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ACTION_ID_KEY";
    private static final String SPANS_END_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_END_KEY";
    private static final String SPANS_FLAGS_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_FLAGS_KEY";
    private static final String SPANS_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_ID_KEY";
    private static final String SPANS_START_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.SPANS_START_KEY";
    private static final String STATE_DESCRIPTION_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.STATE_DESCRIPTION_KEY";
    private static final String TOOLTIP_TEXT_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.TOOLTIP_TEXT_KEY";
    private static final String UNIQUE_ID_KEY = "androidx.view.accessibility.AccessibilityNodeInfoCompat.UNIQUE_ID_KEY";
    private static int sClickableSpanId;
    private final AccessibilityNodeInfo mInfo;
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public int mParentVirtualDescendantId = -1;
    private int mVirtualDescendantId = -1;

    public static class AccessibilityActionCompat {
        public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CLICK = new AccessibilityActionCompat(16, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_COLLAPSE = new AccessibilityActionCompat(524288, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK, 16908348, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        public static final AccessibilityActionCompat ACTION_COPY = new AccessibilityActionCompat(16384, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_CUT = new AccessibilityActionCompat(65536, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_DISMISS = new AccessibilityActionCompat(1048576, (CharSequence) null);
        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_CANCEL;
        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_DROP;
        @NonNull
        public static final AccessibilityActionCompat ACTION_DRAG_START;
        public static final AccessibilityActionCompat ACTION_EXPAND = new AccessibilityActionCompat(262144, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_FOCUS = new AccessibilityActionCompat(1, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_HIDE_TOOLTIP;
        @NonNull
        public static final AccessibilityActionCompat ACTION_IME_ENTER;
        public static final AccessibilityActionCompat ACTION_LONG_CLICK = new AccessibilityActionCompat(32, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_MOVE_WINDOW;
        public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
        public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_DOWN;
        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_LEFT;
        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_RIGHT;
        @NonNull
        public static final AccessibilityActionCompat ACTION_PAGE_UP;
        public static final AccessibilityActionCompat ACTION_PASTE = new AccessibilityActionCompat(32768, (CharSequence) null);
        @NonNull
        public static final AccessibilityActionCompat ACTION_PRESS_AND_HOLD;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
        public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
        public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SCROLL_DOWN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN, 16908346, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SCROLL_LEFT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT, 16908345, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT, 16908347, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION, 16908343, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.ScrollToPositionArguments.class);
        public static final AccessibilityActionCompat ACTION_SCROLL_UP = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP, 16908344, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        public static final AccessibilityActionCompat ACTION_SELECT = new AccessibilityActionCompat(4, (CharSequence) null);
        public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
        public static final AccessibilityActionCompat ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetSelectionArguments.class);
        public static final AccessibilityActionCompat ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) AccessibilityViewCommand.SetTextArguments.class);
        public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN, 16908342, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        @NonNull
        public static final AccessibilityActionCompat ACTION_SHOW_TEXT_SUGGESTIONS;
        public static final AccessibilityActionCompat ACTION_SHOW_TOOLTIP;
        private static final String TAG = "A11yActionCompat";

        /* renamed from: a  reason: collision with root package name */
        public final Object f11536a;
        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})

        /* renamed from: b  reason: collision with root package name */
        public final AccessibilityViewCommand f11537b;
        private final int mId;
        private final Class<? extends AccessibilityViewCommand.CommandArguments> mViewCommandArgumentClass;

        static {
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction2;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction3;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction4;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction5;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction6;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction7;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction8;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction9;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction10;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction11;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction12;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction13;
            AccessibilityNodeInfo.AccessibilityAction accessibilityAction14 = null;
            Class<AccessibilityViewCommand.MoveAtGranularityArguments> cls = AccessibilityViewCommand.MoveAtGranularityArguments.class;
            ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls);
            ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls);
            Class<AccessibilityViewCommand.MoveHtmlArguments> cls2 = AccessibilityViewCommand.MoveHtmlArguments.class;
            ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls2);
            ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, (CharSequence) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) cls2);
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 29) {
                accessibilityAction = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_UP;
            } else {
                accessibilityAction = null;
            }
            ACTION_PAGE_UP = new AccessibilityActionCompat(accessibilityAction, 16908358, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 29) {
                accessibilityAction2 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_DOWN;
            } else {
                accessibilityAction2 = null;
            }
            ACTION_PAGE_DOWN = new AccessibilityActionCompat(accessibilityAction2, 16908359, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 29) {
                accessibilityAction3 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_LEFT;
            } else {
                accessibilityAction3 = null;
            }
            ACTION_PAGE_LEFT = new AccessibilityActionCompat(accessibilityAction3, 16908360, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 29) {
                accessibilityAction4 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PAGE_RIGHT;
            } else {
                accessibilityAction4 = null;
            }
            ACTION_PAGE_RIGHT = new AccessibilityActionCompat(accessibilityAction4, 16908361, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 24) {
                accessibilityAction5 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
            } else {
                accessibilityAction5 = null;
            }
            ACTION_SET_PROGRESS = new AccessibilityActionCompat(accessibilityAction5, 16908349, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.SetProgressArguments.class);
            if (i11 >= 26) {
                accessibilityAction6 = AccessibilityNodeInfo.AccessibilityAction.ACTION_MOVE_WINDOW;
            } else {
                accessibilityAction6 = null;
            }
            ACTION_MOVE_WINDOW = new AccessibilityActionCompat(accessibilityAction6, 16908354, (CharSequence) null, (AccessibilityViewCommand) null, AccessibilityViewCommand.MoveWindowArguments.class);
            if (i11 >= 28) {
                accessibilityAction7 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TOOLTIP;
            } else {
                accessibilityAction7 = null;
            }
            ACTION_SHOW_TOOLTIP = new AccessibilityActionCompat(accessibilityAction7, 16908356, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 28) {
                accessibilityAction8 = AccessibilityNodeInfo.AccessibilityAction.ACTION_HIDE_TOOLTIP;
            } else {
                accessibilityAction8 = null;
            }
            ACTION_HIDE_TOOLTIP = new AccessibilityActionCompat(accessibilityAction8, 16908357, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 30) {
                accessibilityAction9 = AccessibilityNodeInfo.AccessibilityAction.ACTION_PRESS_AND_HOLD;
            } else {
                accessibilityAction9 = null;
            }
            ACTION_PRESS_AND_HOLD = new AccessibilityActionCompat(accessibilityAction9, 16908362, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 30) {
                accessibilityAction10 = AccessibilityNodeInfo.AccessibilityAction.ACTION_IME_ENTER;
            } else {
                accessibilityAction10 = null;
            }
            ACTION_IME_ENTER = new AccessibilityActionCompat(accessibilityAction10, 16908372, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 32) {
                accessibilityAction11 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_START;
            } else {
                accessibilityAction11 = null;
            }
            ACTION_DRAG_START = new AccessibilityActionCompat(accessibilityAction11, 16908373, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 32) {
                accessibilityAction12 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_DROP;
            } else {
                accessibilityAction12 = null;
            }
            ACTION_DRAG_DROP = new AccessibilityActionCompat(accessibilityAction12, 16908374, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 32) {
                accessibilityAction13 = AccessibilityNodeInfo.AccessibilityAction.ACTION_DRAG_CANCEL;
            } else {
                accessibilityAction13 = null;
            }
            ACTION_DRAG_CANCEL = new AccessibilityActionCompat(accessibilityAction13, 16908375, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
            if (i11 >= 33) {
                accessibilityAction14 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_TEXT_SUGGESTIONS;
            }
            ACTION_SHOW_TEXT_SUGGESTIONS = new AccessibilityActionCompat(accessibilityAction14, 16908376, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        public AccessibilityActionCompat(int i11, CharSequence charSequence) {
            this((Object) null, i11, charSequence, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat createReplacementAction(CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            return new AccessibilityActionCompat((Object) null, this.mId, charSequence, accessibilityViewCommand, this.mViewCommandArgumentClass);
        }

        public boolean equals(@Nullable Object obj) {
            if (obj == null || !(obj instanceof AccessibilityActionCompat)) {
                return false;
            }
            AccessibilityActionCompat accessibilityActionCompat = (AccessibilityActionCompat) obj;
            Object obj2 = this.f11536a;
            if (obj2 == null) {
                if (accessibilityActionCompat.f11536a != null) {
                    return false;
                }
                return true;
            } else if (!obj2.equals(accessibilityActionCompat.f11536a)) {
                return false;
            } else {
                return true;
            }
        }

        public int getId() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f11536a).getId();
        }

        public CharSequence getLabel() {
            return ((AccessibilityNodeInfo.AccessibilityAction) this.f11536a).getLabel();
        }

        public int hashCode() {
            Object obj = this.f11536a;
            if (obj != null) {
                return obj.hashCode();
            }
            return 0;
        }

        /* JADX WARNING: Removed duplicated region for block: B:14:0x0025  */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0028  */
        @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean perform(android.view.View r5, android.os.Bundle r6) {
            /*
                r4 = this;
                androidx.core.view.accessibility.AccessibilityViewCommand r0 = r4.f11537b
                r1 = 0
                if (r0 == 0) goto L_0x0049
                java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments> r0 = r4.mViewCommandArgumentClass
                r2 = 0
                if (r0 == 0) goto L_0x0042
                java.lang.Class[] r3 = new java.lang.Class[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.reflect.Constructor r0 = r0.getDeclaredConstructor(r3)     // Catch:{ Exception -> 0x0020 }
                java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x0020 }
                java.lang.Object r0 = r0.newInstance(r1)     // Catch:{ Exception -> 0x0020 }
                androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments r0 = (androidx.core.view.accessibility.AccessibilityViewCommand.CommandArguments) r0     // Catch:{ Exception -> 0x0020 }
                r0.setBundle(r6)     // Catch:{ Exception -> 0x001d }
                r2 = r0
                goto L_0x0042
            L_0x001d:
                r6 = move-exception
                r2 = r0
                goto L_0x0021
            L_0x0020:
                r6 = move-exception
            L_0x0021:
                java.lang.Class<? extends androidx.core.view.accessibility.AccessibilityViewCommand$CommandArguments> r0 = r4.mViewCommandArgumentClass
                if (r0 != 0) goto L_0x0028
                java.lang.String r0 = "null"
                goto L_0x002c
            L_0x0028:
                java.lang.String r0 = r0.getName()
            L_0x002c:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r3 = "Failed to execute command with argument class ViewCommandArgument: "
                r1.append(r3)
                r1.append(r0)
                java.lang.String r0 = r1.toString()
                java.lang.String r1 = "A11yActionCompat"
                android.util.Log.e(r1, r0, r6)
            L_0x0042:
                androidx.core.view.accessibility.AccessibilityViewCommand r6 = r4.f11537b
                boolean r5 = r6.perform(r5, r2)
                return r5
            L_0x0049:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat.perform(android.view.View, android.os.Bundle):boolean");
        }

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
        public AccessibilityActionCompat(int i11, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand) {
            this((Object) null, i11, charSequence, accessibilityViewCommand, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        public AccessibilityActionCompat(Object obj) {
            this(obj, 0, (CharSequence) null, (AccessibilityViewCommand) null, (Class<? extends AccessibilityViewCommand.CommandArguments>) null);
        }

        private AccessibilityActionCompat(int i11, CharSequence charSequence, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this((Object) null, i11, charSequence, (AccessibilityViewCommand) null, cls);
        }

        public AccessibilityActionCompat(Object obj, int i11, CharSequence charSequence, AccessibilityViewCommand accessibilityViewCommand, Class<? extends AccessibilityViewCommand.CommandArguments> cls) {
            this.mId = i11;
            this.f11537b = accessibilityViewCommand;
            if (obj == null) {
                this.f11536a = new AccessibilityNodeInfo.AccessibilityAction(i11, charSequence);
            } else {
                this.f11536a = obj;
            }
            this.mViewCommandArgumentClass = cls;
        }
    }

    @RequiresApi(33)
    public static class Api33Impl {
        private Api33Impl() {
        }

        @DoNotInline
        public static AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.getExtraRenderingInfo();
        }

        @DoNotInline
        public static boolean isTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo) {
            return accessibilityNodeInfo.isTextSelectable();
        }

        @DoNotInline
        public static void setTextSelectable(AccessibilityNodeInfo accessibilityNodeInfo, boolean z11) {
            accessibilityNodeInfo.setTextSelectable(z11);
        }
    }

    public static class CollectionInfoCompat {
        public static final int SELECTION_MODE_MULTIPLE = 2;
        public static final int SELECTION_MODE_NONE = 0;
        public static final int SELECTION_MODE_SINGLE = 1;

        /* renamed from: a  reason: collision with root package name */
        public final Object f11538a;

        public CollectionInfoCompat(Object obj) {
            this.f11538a = obj;
        }

        public static CollectionInfoCompat obtain(int i11, int i12, boolean z11, int i13) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i11, i12, z11, i13));
        }

        public int getColumnCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f11538a).getColumnCount();
        }

        public int getRowCount() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f11538a).getRowCount();
        }

        public int getSelectionMode() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f11538a).getSelectionMode();
        }

        public boolean isHierarchical() {
            return ((AccessibilityNodeInfo.CollectionInfo) this.f11538a).isHierarchical();
        }

        public static CollectionInfoCompat obtain(int i11, int i12, boolean z11) {
            return new CollectionInfoCompat(AccessibilityNodeInfo.CollectionInfo.obtain(i11, i12, z11));
        }
    }

    public static class CollectionItemInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        public final Object f11539a;

        public CollectionItemInfoCompat(Object obj) {
            this.f11539a = obj;
        }

        public static CollectionItemInfoCompat obtain(int i11, int i12, int i13, int i14, boolean z11, boolean z12) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i11, i12, i13, i14, z11, z12));
        }

        public int getColumnIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f11539a).getColumnIndex();
        }

        public int getColumnSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f11539a).getColumnSpan();
        }

        public int getRowIndex() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f11539a).getRowIndex();
        }

        public int getRowSpan() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f11539a).getRowSpan();
        }

        @Deprecated
        public boolean isHeading() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f11539a).isHeading();
        }

        public boolean isSelected() {
            return ((AccessibilityNodeInfo.CollectionItemInfo) this.f11539a).isSelected();
        }

        public static CollectionItemInfoCompat obtain(int i11, int i12, int i13, int i14, boolean z11) {
            return new CollectionItemInfoCompat(AccessibilityNodeInfo.CollectionItemInfo.obtain(i11, i12, i13, i14, z11));
        }
    }

    public static class RangeInfoCompat {
        public static final int RANGE_TYPE_FLOAT = 1;
        public static final int RANGE_TYPE_INT = 0;
        public static final int RANGE_TYPE_PERCENT = 2;

        /* renamed from: a  reason: collision with root package name */
        public final Object f11540a;

        public RangeInfoCompat(Object obj) {
            this.f11540a = obj;
        }

        public static RangeInfoCompat obtain(int i11, float f11, float f12, float f13) {
            return new RangeInfoCompat(AccessibilityNodeInfo.RangeInfo.obtain(i11, f11, f12, f13));
        }

        public float getCurrent() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f11540a).getCurrent();
        }

        public float getMax() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f11540a).getMax();
        }

        public float getMin() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f11540a).getMin();
        }

        public int getType() {
            return ((AccessibilityNodeInfo.RangeInfo) this.f11540a).getType();
        }
    }

    @Deprecated
    public AccessibilityNodeInfoCompat(Object obj) {
        this.mInfo = (AccessibilityNodeInfo) obj;
    }

    public static AccessibilityNodeInfoCompat a(Object obj) {
        if (obj != null) {
            return new AccessibilityNodeInfoCompat(obj);
        }
        return null;
    }

    private void addSpanLocationToExtras(ClickableSpan clickableSpan, Spanned spanned, int i11) {
        extrasIntList(SPANS_START_KEY).add(Integer.valueOf(spanned.getSpanStart(clickableSpan)));
        extrasIntList(SPANS_END_KEY).add(Integer.valueOf(spanned.getSpanEnd(clickableSpan)));
        extrasIntList(SPANS_FLAGS_KEY).add(Integer.valueOf(spanned.getSpanFlags(clickableSpan)));
        extrasIntList(SPANS_ID_KEY).add(Integer.valueOf(i11));
    }

    private void clearExtrasSpans() {
        this.mInfo.getExtras().remove(SPANS_START_KEY);
        this.mInfo.getExtras().remove(SPANS_END_KEY);
        this.mInfo.getExtras().remove(SPANS_FLAGS_KEY);
        this.mInfo.getExtras().remove(SPANS_ID_KEY);
    }

    private List<Integer> extrasIntList(String str) {
        ArrayList<Integer> integerArrayList = this.mInfo.getExtras().getIntegerArrayList(str);
        if (integerArrayList != null) {
            return integerArrayList;
        }
        ArrayList arrayList = new ArrayList();
        this.mInfo.getExtras().putIntegerArrayList(str, arrayList);
        return arrayList;
    }

    private static String getActionSymbolicName(int i11) {
        if (i11 == 1) {
            return "ACTION_FOCUS";
        }
        if (i11 == 2) {
            return "ACTION_CLEAR_FOCUS";
        }
        switch (i11) {
            case 4:
                return "ACTION_SELECT";
            case 8:
                return "ACTION_CLEAR_SELECTION";
            case 16:
                return "ACTION_CLICK";
            case 32:
                return "ACTION_LONG_CLICK";
            case 64:
                return "ACTION_ACCESSIBILITY_FOCUS";
            case 128:
                return "ACTION_CLEAR_ACCESSIBILITY_FOCUS";
            case 256:
                return "ACTION_NEXT_AT_MOVEMENT_GRANULARITY";
            case 512:
                return "ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY";
            case 1024:
                return "ACTION_NEXT_HTML_ELEMENT";
            case 2048:
                return "ACTION_PREVIOUS_HTML_ELEMENT";
            case 4096:
                return "ACTION_SCROLL_FORWARD";
            case 8192:
                return "ACTION_SCROLL_BACKWARD";
            case 16384:
                return "ACTION_COPY";
            case 32768:
                return "ACTION_PASTE";
            case 65536:
                return "ACTION_CUT";
            case 131072:
                return "ACTION_SET_SELECTION";
            case 262144:
                return "ACTION_EXPAND";
            case 524288:
                return "ACTION_COLLAPSE";
            case 2097152:
                return "ACTION_SET_TEXT";
            case 16908354:
                return "ACTION_MOVE_WINDOW";
            default:
                switch (i11) {
                    case 16908342:
                        return "ACTION_SHOW_ON_SCREEN";
                    case 16908343:
                        return "ACTION_SCROLL_TO_POSITION";
                    case 16908344:
                        return "ACTION_SCROLL_UP";
                    case 16908345:
                        return "ACTION_SCROLL_LEFT";
                    case 16908346:
                        return "ACTION_SCROLL_DOWN";
                    case 16908347:
                        return "ACTION_SCROLL_RIGHT";
                    case 16908348:
                        return "ACTION_CONTEXT_CLICK";
                    case 16908349:
                        return "ACTION_SET_PROGRESS";
                    default:
                        switch (i11) {
                            case 16908356:
                                return "ACTION_SHOW_TOOLTIP";
                            case 16908357:
                                return "ACTION_HIDE_TOOLTIP";
                            case 16908358:
                                return "ACTION_PAGE_UP";
                            case 16908359:
                                return "ACTION_PAGE_DOWN";
                            case 16908360:
                                return "ACTION_PAGE_LEFT";
                            case 16908361:
                                return "ACTION_PAGE_RIGHT";
                            case 16908362:
                                return "ACTION_PRESS_AND_HOLD";
                            default:
                                switch (i11) {
                                    case 16908372:
                                        return "ACTION_IME_ENTER";
                                    case 16908373:
                                        return "ACTION_DRAG_START";
                                    case 16908374:
                                        return "ACTION_DRAG_DROP";
                                    case 16908375:
                                        return "ACTION_DRAG_CANCEL";
                                    default:
                                        return "ACTION_UNKNOWN";
                                }
                        }
                }
        }
    }

    private boolean getBooleanProperty(int i11) {
        Bundle extras = getExtras();
        if (extras != null && (extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & i11) == i11) {
            return true;
        }
        return false;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static ClickableSpan[] getClickableSpans(CharSequence charSequence) {
        if (charSequence instanceof Spanned) {
            return (ClickableSpan[]) ((Spanned) charSequence).getSpans(0, charSequence.length(), ClickableSpan.class);
        }
        return null;
    }

    private SparseArray<WeakReference<ClickableSpan>> getOrCreateSpansFromViewTags(View view) {
        SparseArray<WeakReference<ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags != null) {
            return spansFromViewTags;
        }
        SparseArray<WeakReference<ClickableSpan>> sparseArray = new SparseArray<>();
        view.setTag(R.id.tag_accessibility_clickable_spans, sparseArray);
        return sparseArray;
    }

    private SparseArray<WeakReference<ClickableSpan>> getSpansFromViewTags(View view) {
        return (SparseArray) view.getTag(R.id.tag_accessibility_clickable_spans);
    }

    private boolean hasSpans() {
        return !extrasIntList(SPANS_START_KEY).isEmpty();
    }

    private int idForClickableSpan(ClickableSpan clickableSpan, SparseArray<WeakReference<ClickableSpan>> sparseArray) {
        if (sparseArray != null) {
            for (int i11 = 0; i11 < sparseArray.size(); i11++) {
                if (clickableSpan.equals((ClickableSpan) sparseArray.valueAt(i11).get())) {
                    return sparseArray.keyAt(i11);
                }
            }
        }
        int i12 = sClickableSpanId;
        sClickableSpanId = i12 + 1;
        return i12;
    }

    public static AccessibilityNodeInfoCompat obtain(View view) {
        return wrap(AccessibilityNodeInfo.obtain(view));
    }

    private void removeCollectedSpans(View view) {
        SparseArray<WeakReference<ClickableSpan>> spansFromViewTags = getSpansFromViewTags(view);
        if (spansFromViewTags != null) {
            ArrayList arrayList = new ArrayList();
            for (int i11 = 0; i11 < spansFromViewTags.size(); i11++) {
                if (spansFromViewTags.valueAt(i11).get() == null) {
                    arrayList.add(Integer.valueOf(i11));
                }
            }
            for (int i12 = 0; i12 < arrayList.size(); i12++) {
                spansFromViewTags.remove(((Integer) arrayList.get(i12)).intValue());
            }
        }
    }

    private void setBooleanProperty(int i11, boolean z11) {
        Bundle extras = getExtras();
        if (extras != null) {
            int i12 = extras.getInt(BOOLEAN_PROPERTY_KEY, 0) & (~i11);
            if (!z11) {
                i11 = 0;
            }
            extras.putInt(BOOLEAN_PROPERTY_KEY, i11 | i12);
        }
    }

    public static AccessibilityNodeInfoCompat wrap(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
        return new AccessibilityNodeInfoCompat(accessibilityNodeInfo);
    }

    public void addAction(int i11) {
        this.mInfo.addAction(i11);
    }

    public void addChild(View view) {
        this.mInfo.addChild(view);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public void addSpansToExtras(CharSequence charSequence, View view) {
        if (Build.VERSION.SDK_INT < 26) {
            clearExtrasSpans();
            removeCollectedSpans(view);
            ClickableSpan[] clickableSpans = getClickableSpans(charSequence);
            if (clickableSpans != null && clickableSpans.length > 0) {
                getExtras().putInt(SPANS_ACTION_ID_KEY, R.id.accessibility_action_clickable_span);
                SparseArray<WeakReference<ClickableSpan>> orCreateSpansFromViewTags = getOrCreateSpansFromViewTags(view);
                for (int i11 = 0; i11 < clickableSpans.length; i11++) {
                    int idForClickableSpan = idForClickableSpan(clickableSpans[i11], orCreateSpansFromViewTags);
                    orCreateSpansFromViewTags.put(idForClickableSpan, new WeakReference(clickableSpans[i11]));
                    addSpanLocationToExtras(clickableSpans[i11], (Spanned) charSequence, idForClickableSpan);
                }
            }
        }
    }

    public boolean canOpenPopup() {
        return this.mInfo.canOpenPopup();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityNodeInfoCompat)) {
            return false;
        }
        AccessibilityNodeInfoCompat accessibilityNodeInfoCompat = (AccessibilityNodeInfoCompat) obj;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            if (accessibilityNodeInfoCompat.mInfo != null) {
                return false;
            }
        } else if (!accessibilityNodeInfo.equals(accessibilityNodeInfoCompat.mInfo)) {
            return false;
        }
        if (this.mVirtualDescendantId == accessibilityNodeInfoCompat.mVirtualDescendantId && this.mParentVirtualDescendantId == accessibilityNodeInfoCompat.mParentVirtualDescendantId) {
            return true;
        }
        return false;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByText(String str) {
        ArrayList arrayList = new ArrayList();
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText = this.mInfo.findAccessibilityNodeInfosByText(str);
        int size = findAccessibilityNodeInfosByText.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(wrap(findAccessibilityNodeInfosByText.get(i11)));
        }
        return arrayList;
    }

    public List<AccessibilityNodeInfoCompat> findAccessibilityNodeInfosByViewId(String str) {
        List<AccessibilityNodeInfo> findAccessibilityNodeInfosByViewId = this.mInfo.findAccessibilityNodeInfosByViewId(str);
        ArrayList arrayList = new ArrayList();
        for (AccessibilityNodeInfo wrap : findAccessibilityNodeInfosByViewId) {
            arrayList.add(wrap(wrap));
        }
        return arrayList;
    }

    public AccessibilityNodeInfoCompat findFocus(int i11) {
        return a(this.mInfo.findFocus(i11));
    }

    public AccessibilityNodeInfoCompat focusSearch(int i11) {
        return a(this.mInfo.focusSearch(i11));
    }

    public List<AccessibilityActionCompat> getActionList() {
        List<AccessibilityNodeInfo.AccessibilityAction> actionList = this.mInfo.getActionList();
        if (actionList == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        int size = actionList.size();
        for (int i11 = 0; i11 < size; i11++) {
            arrayList.add(new AccessibilityActionCompat(actionList.get(i11)));
        }
        return arrayList;
    }

    @Deprecated
    public int getActions() {
        return this.mInfo.getActions();
    }

    @NonNull
    public List<String> getAvailableExtraData() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mInfo.getAvailableExtraData();
        }
        return Collections.emptyList();
    }

    @Deprecated
    public void getBoundsInParent(Rect rect) {
        this.mInfo.getBoundsInParent(rect);
    }

    public void getBoundsInScreen(Rect rect) {
        this.mInfo.getBoundsInScreen(rect);
    }

    public AccessibilityNodeInfoCompat getChild(int i11) {
        return a(this.mInfo.getChild(i11));
    }

    public int getChildCount() {
        return this.mInfo.getChildCount();
    }

    public CharSequence getClassName() {
        return this.mInfo.getClassName();
    }

    public CollectionInfoCompat getCollectionInfo() {
        AccessibilityNodeInfo.CollectionInfo collectionInfo = this.mInfo.getCollectionInfo();
        if (collectionInfo != null) {
            return new CollectionInfoCompat(collectionInfo);
        }
        return null;
    }

    public CollectionItemInfoCompat getCollectionItemInfo() {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo = this.mInfo.getCollectionItemInfo();
        if (collectionItemInfo != null) {
            return new CollectionItemInfoCompat(collectionItemInfo);
        }
        return null;
    }

    public CharSequence getContentDescription() {
        return this.mInfo.getContentDescription();
    }

    public int getDrawingOrder() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.mInfo.getDrawingOrder();
        }
        return 0;
    }

    public CharSequence getError() {
        return this.mInfo.getError();
    }

    @Nullable
    public AccessibilityNodeInfo.ExtraRenderingInfo getExtraRenderingInfo() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getExtraRenderingInfo(this.mInfo);
        }
        return null;
    }

    public Bundle getExtras() {
        return this.mInfo.getExtras();
    }

    @Nullable
    public CharSequence getHintText() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mInfo.getHintText();
        }
        return this.mInfo.getExtras().getCharSequence(HINT_TEXT_KEY);
    }

    @Deprecated
    public Object getInfo() {
        return this.mInfo;
    }

    public int getInputType() {
        return this.mInfo.getInputType();
    }

    public AccessibilityNodeInfoCompat getLabelFor() {
        return a(this.mInfo.getLabelFor());
    }

    public AccessibilityNodeInfoCompat getLabeledBy() {
        return a(this.mInfo.getLabeledBy());
    }

    public int getLiveRegion() {
        return this.mInfo.getLiveRegion();
    }

    public int getMaxTextLength() {
        return this.mInfo.getMaxTextLength();
    }

    public int getMovementGranularities() {
        return this.mInfo.getMovementGranularities();
    }

    public CharSequence getPackageName() {
        return this.mInfo.getPackageName();
    }

    @Nullable
    public CharSequence getPaneTitle() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.getPaneTitle();
        }
        return this.mInfo.getExtras().getCharSequence(PANE_TITLE_KEY);
    }

    public AccessibilityNodeInfoCompat getParent() {
        return a(this.mInfo.getParent());
    }

    public RangeInfoCompat getRangeInfo() {
        AccessibilityNodeInfo.RangeInfo rangeInfo = this.mInfo.getRangeInfo();
        if (rangeInfo != null) {
            return new RangeInfoCompat(rangeInfo);
        }
        return null;
    }

    @Nullable
    public CharSequence getRoleDescription() {
        return this.mInfo.getExtras().getCharSequence(ROLE_DESCRIPTION_KEY);
    }

    @Nullable
    public CharSequence getStateDescription() {
        if (BuildCompat.isAtLeastR()) {
            return this.mInfo.getStateDescription();
        }
        return this.mInfo.getExtras().getCharSequence(STATE_DESCRIPTION_KEY);
    }

    public CharSequence getText() {
        if (!hasSpans()) {
            return this.mInfo.getText();
        }
        List<Integer> extrasIntList = extrasIntList(SPANS_START_KEY);
        List<Integer> extrasIntList2 = extrasIntList(SPANS_END_KEY);
        List<Integer> extrasIntList3 = extrasIntList(SPANS_FLAGS_KEY);
        List<Integer> extrasIntList4 = extrasIntList(SPANS_ID_KEY);
        SpannableString spannableString = new SpannableString(TextUtils.substring(this.mInfo.getText(), 0, this.mInfo.getText().length()));
        for (int i11 = 0; i11 < extrasIntList.size(); i11++) {
            spannableString.setSpan(new AccessibilityClickableSpanCompat(extrasIntList4.get(i11).intValue(), this, getExtras().getInt(SPANS_ACTION_ID_KEY)), extrasIntList.get(i11).intValue(), extrasIntList2.get(i11).intValue(), extrasIntList3.get(i11).intValue());
        }
        return spannableString;
    }

    public int getTextSelectionEnd() {
        return this.mInfo.getTextSelectionEnd();
    }

    public int getTextSelectionStart() {
        return this.mInfo.getTextSelectionStart();
    }

    @Nullable
    public CharSequence getTooltipText() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.getTooltipText();
        }
        return this.mInfo.getExtras().getCharSequence(TOOLTIP_TEXT_KEY);
    }

    @Nullable
    public TouchDelegateInfoCompat getTouchDelegateInfo() {
        AccessibilityNodeInfo.TouchDelegateInfo a11;
        if (Build.VERSION.SDK_INT < 29 || (a11 = this.mInfo.getTouchDelegateInfo()) == null) {
            return null;
        }
        return new TouchDelegateInfoCompat(a11);
    }

    public AccessibilityNodeInfoCompat getTraversalAfter() {
        return a(this.mInfo.getTraversalAfter());
    }

    public AccessibilityNodeInfoCompat getTraversalBefore() {
        return a(this.mInfo.getTraversalBefore());
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    @Nullable
    public String getUniqueId() {
        if (BuildCompat.isAtLeastT()) {
            return this.mInfo.getUniqueId();
        }
        return this.mInfo.getExtras().getString(UNIQUE_ID_KEY);
    }

    public String getViewIdResourceName() {
        return this.mInfo.getViewIdResourceName();
    }

    public AccessibilityWindowInfoCompat getWindow() {
        return AccessibilityWindowInfoCompat.a(this.mInfo.getWindow());
    }

    public int getWindowId() {
        return this.mInfo.getWindowId();
    }

    public int hashCode() {
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (accessibilityNodeInfo == null) {
            return 0;
        }
        return accessibilityNodeInfo.hashCode();
    }

    public boolean isAccessibilityFocused() {
        return this.mInfo.isAccessibilityFocused();
    }

    public boolean isCheckable() {
        return this.mInfo.isCheckable();
    }

    public boolean isChecked() {
        return this.mInfo.isChecked();
    }

    public boolean isClickable() {
        return this.mInfo.isClickable();
    }

    public boolean isContentInvalid() {
        return this.mInfo.isContentInvalid();
    }

    public boolean isContextClickable() {
        return this.mInfo.isContextClickable();
    }

    public boolean isDismissable() {
        return this.mInfo.isDismissable();
    }

    public boolean isEditable() {
        return this.mInfo.isEditable();
    }

    public boolean isEnabled() {
        return this.mInfo.isEnabled();
    }

    public boolean isFocusable() {
        return this.mInfo.isFocusable();
    }

    public boolean isFocused() {
        return this.mInfo.isFocused();
    }

    public boolean isHeading() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.isHeading();
        }
        if (getBooleanProperty(2)) {
            return true;
        }
        CollectionItemInfoCompat collectionItemInfo = getCollectionItemInfo();
        if (collectionItemInfo == null || !collectionItemInfo.isHeading()) {
            return false;
        }
        return true;
    }

    public boolean isImportantForAccessibility() {
        if (Build.VERSION.SDK_INT >= 24) {
            return this.mInfo.isImportantForAccessibility();
        }
        return true;
    }

    public boolean isLongClickable() {
        return this.mInfo.isLongClickable();
    }

    public boolean isMultiLine() {
        return this.mInfo.isMultiLine();
    }

    public boolean isPassword() {
        return this.mInfo.isPassword();
    }

    public boolean isScreenReaderFocusable() {
        if (Build.VERSION.SDK_INT >= 28) {
            return this.mInfo.isScreenReaderFocusable();
        }
        return getBooleanProperty(1);
    }

    public boolean isScrollable() {
        return this.mInfo.isScrollable();
    }

    public boolean isSelected() {
        return this.mInfo.isSelected();
    }

    public boolean isShowingHintText() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.mInfo.isShowingHintText();
        }
        return getBooleanProperty(4);
    }

    public boolean isTextEntryKey() {
        if (Build.VERSION.SDK_INT >= 29) {
            return this.mInfo.isTextEntryKey();
        }
        return getBooleanProperty(8);
    }

    public boolean isTextSelectable() {
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.isTextSelectable(this.mInfo);
        }
        return false;
    }

    public boolean isVisibleToUser() {
        return this.mInfo.isVisibleToUser();
    }

    public boolean performAction(int i11) {
        return this.mInfo.performAction(i11);
    }

    public void recycle() {
        this.mInfo.recycle();
    }

    public boolean refresh() {
        return this.mInfo.refresh();
    }

    public boolean removeAction(AccessibilityActionCompat accessibilityActionCompat) {
        return this.mInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f11536a);
    }

    public boolean removeChild(View view) {
        return this.mInfo.removeChild(view);
    }

    public void setAccessibilityFocused(boolean z11) {
        this.mInfo.setAccessibilityFocused(z11);
    }

    public void setAvailableExtraData(@NonNull List<String> list) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setAvailableExtraData(list);
        }
    }

    @Deprecated
    public void setBoundsInParent(Rect rect) {
        this.mInfo.setBoundsInParent(rect);
    }

    public void setBoundsInScreen(Rect rect) {
        this.mInfo.setBoundsInScreen(rect);
    }

    public void setCanOpenPopup(boolean z11) {
        this.mInfo.setCanOpenPopup(z11);
    }

    public void setCheckable(boolean z11) {
        this.mInfo.setCheckable(z11);
    }

    public void setChecked(boolean z11) {
        this.mInfo.setChecked(z11);
    }

    public void setClassName(CharSequence charSequence) {
        this.mInfo.setClassName(charSequence);
    }

    public void setClickable(boolean z11) {
        this.mInfo.setClickable(z11);
    }

    public void setCollectionInfo(Object obj) {
        AccessibilityNodeInfo.CollectionInfo collectionInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (obj == null) {
            collectionInfo = null;
        } else {
            collectionInfo = (AccessibilityNodeInfo.CollectionInfo) ((CollectionInfoCompat) obj).f11538a;
        }
        accessibilityNodeInfo.setCollectionInfo(collectionInfo);
    }

    public void setCollectionItemInfo(Object obj) {
        AccessibilityNodeInfo.CollectionItemInfo collectionItemInfo;
        AccessibilityNodeInfo accessibilityNodeInfo = this.mInfo;
        if (obj == null) {
            collectionItemInfo = null;
        } else {
            collectionItemInfo = (AccessibilityNodeInfo.CollectionItemInfo) ((CollectionItemInfoCompat) obj).f11539a;
        }
        accessibilityNodeInfo.setCollectionItemInfo(collectionItemInfo);
    }

    public void setContentDescription(CharSequence charSequence) {
        this.mInfo.setContentDescription(charSequence);
    }

    public void setContentInvalid(boolean z11) {
        this.mInfo.setContentInvalid(z11);
    }

    public void setContextClickable(boolean z11) {
        this.mInfo.setContextClickable(z11);
    }

    public void setDismissable(boolean z11) {
        this.mInfo.setDismissable(z11);
    }

    public void setDrawingOrder(int i11) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mInfo.setDrawingOrder(i11);
        }
    }

    public void setEditable(boolean z11) {
        this.mInfo.setEditable(z11);
    }

    public void setEnabled(boolean z11) {
        this.mInfo.setEnabled(z11);
    }

    public void setError(CharSequence charSequence) {
        this.mInfo.setError(charSequence);
    }

    public void setFocusable(boolean z11) {
        this.mInfo.setFocusable(z11);
    }

    public void setFocused(boolean z11) {
        this.mInfo.setFocused(z11);
    }

    public void setHeading(boolean z11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setHeading(z11);
        } else {
            setBooleanProperty(2, z11);
        }
    }

    public void setHintText(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setHintText(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(HINT_TEXT_KEY, charSequence);
        }
    }

    public void setImportantForAccessibility(boolean z11) {
        if (Build.VERSION.SDK_INT >= 24) {
            this.mInfo.setImportantForAccessibility(z11);
        }
    }

    public void setInputType(int i11) {
        this.mInfo.setInputType(i11);
    }

    public void setLabelFor(View view) {
        this.mInfo.setLabelFor(view);
    }

    public void setLabeledBy(View view) {
        this.mInfo.setLabeledBy(view);
    }

    public void setLiveRegion(int i11) {
        this.mInfo.setLiveRegion(i11);
    }

    public void setLongClickable(boolean z11) {
        this.mInfo.setLongClickable(z11);
    }

    public void setMaxTextLength(int i11) {
        this.mInfo.setMaxTextLength(i11);
    }

    public void setMovementGranularities(int i11) {
        this.mInfo.setMovementGranularities(i11);
    }

    public void setMultiLine(boolean z11) {
        this.mInfo.setMultiLine(z11);
    }

    public void setPackageName(CharSequence charSequence) {
        this.mInfo.setPackageName(charSequence);
    }

    public void setPaneTitle(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setPaneTitle(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(PANE_TITLE_KEY, charSequence);
        }
    }

    public void setParent(View view) {
        this.mParentVirtualDescendantId = -1;
        this.mInfo.setParent(view);
    }

    public void setPassword(boolean z11) {
        this.mInfo.setPassword(z11);
    }

    public void setRangeInfo(RangeInfoCompat rangeInfoCompat) {
        this.mInfo.setRangeInfo((AccessibilityNodeInfo.RangeInfo) rangeInfoCompat.f11540a);
    }

    public void setRoleDescription(@Nullable CharSequence charSequence) {
        this.mInfo.getExtras().putCharSequence(ROLE_DESCRIPTION_KEY, charSequence);
    }

    public void setScreenReaderFocusable(boolean z11) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setScreenReaderFocusable(z11);
        } else {
            setBooleanProperty(1, z11);
        }
    }

    public void setScrollable(boolean z11) {
        this.mInfo.setScrollable(z11);
    }

    public void setSelected(boolean z11) {
        this.mInfo.setSelected(z11);
    }

    public void setShowingHintText(boolean z11) {
        if (Build.VERSION.SDK_INT >= 26) {
            this.mInfo.setShowingHintText(z11);
        } else {
            setBooleanProperty(4, z11);
        }
    }

    public void setSource(View view) {
        this.mVirtualDescendantId = -1;
        this.mInfo.setSource(view);
    }

    public void setStateDescription(@Nullable CharSequence charSequence) {
        if (BuildCompat.isAtLeastR()) {
            this.mInfo.setStateDescription(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(STATE_DESCRIPTION_KEY, charSequence);
        }
    }

    public void setText(CharSequence charSequence) {
        this.mInfo.setText(charSequence);
    }

    public void setTextEntryKey(boolean z11) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTextEntryKey(z11);
        } else {
            setBooleanProperty(8, z11);
        }
    }

    public void setTextSelectable(boolean z11) {
        if (Build.VERSION.SDK_INT >= 33) {
            Api33Impl.setTextSelectable(this.mInfo, z11);
        }
    }

    public void setTextSelection(int i11, int i12) {
        this.mInfo.setTextSelection(i11, i12);
    }

    public void setTooltipText(@Nullable CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 28) {
            this.mInfo.setTooltipText(charSequence);
        } else {
            this.mInfo.getExtras().putCharSequence(TOOLTIP_TEXT_KEY, charSequence);
        }
    }

    public void setTouchDelegateInfo(@NonNull TouchDelegateInfoCompat touchDelegateInfoCompat) {
        if (Build.VERSION.SDK_INT >= 29) {
            this.mInfo.setTouchDelegateInfo(touchDelegateInfoCompat.f11541a);
        }
    }

    public void setTraversalAfter(View view) {
        this.mInfo.setTraversalAfter(view);
    }

    public void setTraversalBefore(View view) {
        this.mInfo.setTraversalBefore(view);
    }

    @OptIn(markerClass = {BuildCompat.PrereleaseSdkCheck.class})
    public void setUniqueId(@Nullable String str) {
        if (BuildCompat.isAtLeastT()) {
            this.mInfo.setUniqueId(str);
        } else {
            this.mInfo.getExtras().putString(UNIQUE_ID_KEY, str);
        }
    }

    public void setViewIdResourceName(String str) {
        this.mInfo.setViewIdResourceName(str);
    }

    public void setVisibleToUser(boolean z11) {
        this.mInfo.setVisibleToUser(z11);
    }

    @NonNull
    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(super.toString());
        Rect rect = new Rect();
        getBoundsInParent(rect);
        sb2.append("; boundsInParent: " + rect);
        getBoundsInScreen(rect);
        sb2.append("; boundsInScreen: " + rect);
        sb2.append("; packageName: ");
        sb2.append(getPackageName());
        sb2.append("; className: ");
        sb2.append(getClassName());
        sb2.append("; text: ");
        sb2.append(getText());
        sb2.append("; contentDescription: ");
        sb2.append(getContentDescription());
        sb2.append("; viewId: ");
        sb2.append(getViewIdResourceName());
        sb2.append("; uniqueId: ");
        sb2.append(getUniqueId());
        sb2.append("; checkable: ");
        sb2.append(isCheckable());
        sb2.append("; checked: ");
        sb2.append(isChecked());
        sb2.append("; focusable: ");
        sb2.append(isFocusable());
        sb2.append("; focused: ");
        sb2.append(isFocused());
        sb2.append("; selected: ");
        sb2.append(isSelected());
        sb2.append("; clickable: ");
        sb2.append(isClickable());
        sb2.append("; longClickable: ");
        sb2.append(isLongClickable());
        sb2.append("; enabled: ");
        sb2.append(isEnabled());
        sb2.append("; password: ");
        sb2.append(isPassword());
        sb2.append("; scrollable: " + isScrollable());
        sb2.append("; [");
        List<AccessibilityActionCompat> actionList = getActionList();
        for (int i11 = 0; i11 < actionList.size(); i11++) {
            AccessibilityActionCompat accessibilityActionCompat = actionList.get(i11);
            String actionSymbolicName = getActionSymbolicName(accessibilityActionCompat.getId());
            if (actionSymbolicName.equals("ACTION_UNKNOWN") && accessibilityActionCompat.getLabel() != null) {
                actionSymbolicName = accessibilityActionCompat.getLabel().toString();
            }
            sb2.append(actionSymbolicName);
            if (i11 != actionList.size() - 1) {
                sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            }
        }
        sb2.append("]");
        return sb2.toString();
    }

    public AccessibilityNodeInfo unwrap() {
        return this.mInfo;
    }

    public static AccessibilityNodeInfoCompat obtain(View view, int i11) {
        return a(AccessibilityNodeInfo.obtain(view, i11));
    }

    public void addAction(AccessibilityActionCompat accessibilityActionCompat) {
        this.mInfo.addAction((AccessibilityNodeInfo.AccessibilityAction) accessibilityActionCompat.f11536a);
    }

    public void addChild(View view, int i11) {
        this.mInfo.addChild(view, i11);
    }

    public boolean performAction(int i11, Bundle bundle) {
        return this.mInfo.performAction(i11, bundle);
    }

    public boolean removeChild(View view, int i11) {
        return this.mInfo.removeChild(view, i11);
    }

    public void setLabelFor(View view, int i11) {
        this.mInfo.setLabelFor(view, i11);
    }

    public void setLabeledBy(View view, int i11) {
        this.mInfo.setLabeledBy(view, i11);
    }

    public void setTraversalAfter(View view, int i11) {
        this.mInfo.setTraversalAfter(view, i11);
    }

    public void setTraversalBefore(View view, int i11) {
        this.mInfo.setTraversalBefore(view, i11);
    }

    public void setParent(View view, int i11) {
        this.mParentVirtualDescendantId = i11;
        this.mInfo.setParent(view, i11);
    }

    public void setSource(View view, int i11) {
        this.mVirtualDescendantId = i11;
        this.mInfo.setSource(view, i11);
    }

    public static final class TouchDelegateInfoCompat {

        /* renamed from: a  reason: collision with root package name */
        public final AccessibilityNodeInfo.TouchDelegateInfo f11541a;

        public TouchDelegateInfoCompat(@NonNull Map<Region, View> map) {
            if (Build.VERSION.SDK_INT >= 29) {
                this.f11541a = new AccessibilityNodeInfo.TouchDelegateInfo(map);
            } else {
                this.f11541a = null;
            }
        }

        @Nullable
        public Region getRegionAt(@IntRange(from = 0) int i11) {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f11541a.getRegionAt(i11);
            }
            return null;
        }

        @IntRange(from = 0)
        public int getRegionCount() {
            if (Build.VERSION.SDK_INT >= 29) {
                return this.f11541a.getRegionCount();
            }
            return 0;
        }

        @Nullable
        public AccessibilityNodeInfoCompat getTargetForRegion(@NonNull Region region) {
            AccessibilityNodeInfo a11;
            if (Build.VERSION.SDK_INT < 29 || (a11 = this.f11541a.getTargetForRegion(region)) == null) {
                return null;
            }
            return AccessibilityNodeInfoCompat.wrap(a11);
        }

        public TouchDelegateInfoCompat(@NonNull AccessibilityNodeInfo.TouchDelegateInfo touchDelegateInfo) {
            this.f11541a = touchDelegateInfo;
        }
    }

    public static AccessibilityNodeInfoCompat obtain() {
        return wrap(AccessibilityNodeInfo.obtain());
    }

    private AccessibilityNodeInfoCompat(AccessibilityNodeInfo accessibilityNodeInfo) {
        this.mInfo = accessibilityNodeInfo;
    }

    public static AccessibilityNodeInfoCompat obtain(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        return wrap(AccessibilityNodeInfo.obtain(accessibilityNodeInfoCompat.mInfo));
    }
}
