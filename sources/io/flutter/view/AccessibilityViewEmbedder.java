package io.flutter.view;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Keep
class AccessibilityViewEmbedder {
    private static final String TAG = "AccessibilityBridge";
    private final Map<View, Rect> embeddedViewToDisplayBounds;
    private final SparseArray<ViewAndId> flutterIdToOrigin = new SparseArray<>();
    private int nextFlutterId;
    private final Map<ViewAndId, Integer> originToFlutterId;
    private final ReflectionAccessors reflectionAccessors = new ReflectionAccessors();
    private final View rootAccessibilityView;

    public static class ReflectionAccessors {
        @Nullable
        private final Field childNodeIdsField;
        @Nullable
        private final Method getChildId;
        @Nullable
        private final Method getParentNodeId;
        @Nullable
        private final Method getRecordSourceNodeId;
        @Nullable
        private final Method getSourceNodeId;
        @Nullable
        private final Method longArrayGetIndex;

        /* access modifiers changed from: private */
        @Nullable
        public Long getChildId(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, int i11) {
            Method method = this.getChildId;
            if (method == null && (this.childNodeIdsField == null || this.longArrayGetIndex == null)) {
                return null;
            }
            if (method != null) {
                try {
                    return (Long) method.invoke(accessibilityNodeInfo, new Object[]{Integer.valueOf(i11)});
                } catch (IllegalAccessException e11) {
                    Log.w(AccessibilityViewEmbedder.TAG, "Failed to access getChildId method.", e11);
                    return null;
                } catch (InvocationTargetException e12) {
                    Log.w(AccessibilityViewEmbedder.TAG, "The getChildId method threw an exception when invoked.", e12);
                    return null;
                }
            } else {
                try {
                    return Long.valueOf(((Long) this.longArrayGetIndex.invoke(this.childNodeIdsField.get(accessibilityNodeInfo), new Object[]{Integer.valueOf(i11)})).longValue());
                } catch (IllegalAccessException e13) {
                    Log.w(AccessibilityViewEmbedder.TAG, "Failed to access longArrayGetIndex method or the childNodeId field.", e13);
                    return null;
                } catch (ArrayIndexOutOfBoundsException | InvocationTargetException e14) {
                    Log.w(AccessibilityViewEmbedder.TAG, "The longArrayGetIndex method threw an exception when invoked.", e14);
                    return null;
                }
            }
        }

        /* access modifiers changed from: private */
        @Nullable
        public Long getParentNodeId(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            Method method = this.getParentNodeId;
            if (method != null) {
                try {
                    return Long.valueOf(((Long) method.invoke(accessibilityNodeInfo, new Object[0])).longValue());
                } catch (IllegalAccessException e11) {
                    Log.w(AccessibilityViewEmbedder.TAG, "Failed to access getParentNodeId method.", e11);
                } catch (InvocationTargetException e12) {
                    Log.w(AccessibilityViewEmbedder.TAG, "The getParentNodeId method threw an exception when invoked.", e12);
                }
            }
            return yoinkParentIdFromParcel(accessibilityNodeInfo);
        }

        /* access modifiers changed from: private */
        @Nullable
        public Long getRecordSourceNodeId(@NonNull AccessibilityRecord accessibilityRecord) {
            Method method = this.getRecordSourceNodeId;
            if (method == null) {
                return null;
            }
            try {
                return (Long) method.invoke(accessibilityRecord, new Object[0]);
            } catch (IllegalAccessException e11) {
                Log.w(AccessibilityViewEmbedder.TAG, "Failed to access the getRecordSourceNodeId method.", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.w(AccessibilityViewEmbedder.TAG, "The getRecordSourceNodeId method threw an exception when invoked.", e12);
                return null;
            }
        }

        /* access modifiers changed from: private */
        @Nullable
        public Long getSourceNodeId(@NonNull AccessibilityNodeInfo accessibilityNodeInfo) {
            Method method = this.getSourceNodeId;
            if (method == null) {
                return null;
            }
            try {
                return (Long) method.invoke(accessibilityNodeInfo, new Object[0]);
            } catch (IllegalAccessException e11) {
                Log.w(AccessibilityViewEmbedder.TAG, "Failed to access getSourceNodeId method.", e11);
                return null;
            } catch (InvocationTargetException e12) {
                Log.w(AccessibilityViewEmbedder.TAG, "The getSourceNodeId method threw an exception when invoked.", e12);
                return null;
            }
        }

        /* access modifiers changed from: private */
        public static int getVirtualNodeId(long j11) {
            return (int) (j11 >> 32);
        }

        private static boolean isBitSet(long j11, int i11) {
            return (j11 & (1 << i11)) != 0;
        }

        @Nullable
        private static Long yoinkParentIdFromParcel(AccessibilityNodeInfo accessibilityNodeInfo) {
            Long l11 = null;
            if (Build.VERSION.SDK_INT < 26) {
                Log.w(AccessibilityViewEmbedder.TAG, "Unexpected Android version. Unable to find the parent ID.");
                return null;
            }
            AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            Parcel obtain2 = Parcel.obtain();
            obtain2.setDataPosition(0);
            obtain.writeToParcel(obtain2, 0);
            obtain2.setDataPosition(0);
            long readLong = obtain2.readLong();
            if (isBitSet(readLong, 0)) {
                obtain2.readInt();
            }
            if (isBitSet(readLong, 1)) {
                obtain2.readLong();
            }
            if (isBitSet(readLong, 2)) {
                obtain2.readInt();
            }
            if (isBitSet(readLong, 3)) {
                l11 = Long.valueOf(obtain2.readLong());
            }
            obtain2.recycle();
            return l11;
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.reflect.Field} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.reflect.Field} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.lang.reflect.Field} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.reflect.Method} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: java.lang.reflect.Method} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.reflect.Method} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v8, resolved type: java.lang.reflect.Field} */
        /* JADX WARNING: Multi-variable type inference failed */
        @android.annotation.SuppressLint({"DiscouragedPrivateApi,PrivateApi"})
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private ReflectionAccessors() {
            /*
                r10 = this;
                java.lang.String r0 = "getSourceNodeId"
                java.lang.Class<android.view.accessibility.AccessibilityNodeInfo> r1 = android.view.accessibility.AccessibilityNodeInfo.class
                java.lang.String r2 = "AccessibilityBridge"
                r10.<init>()
                r3 = 0
                r4 = 0
                java.lang.Class[] r5 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0012 }
                java.lang.reflect.Method r5 = r1.getMethod(r0, r5)     // Catch:{ NoSuchMethodException -> 0x0012 }
                goto L_0x0018
            L_0x0012:
                java.lang.String r5 = "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection"
                io.flutter.Log.w(r2, r5)
                r5 = r4
            L_0x0018:
                java.lang.Class<android.view.accessibility.AccessibilityRecord> r6 = android.view.accessibility.AccessibilityRecord.class
                java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0021 }
                java.lang.reflect.Method r0 = r6.getMethod(r0, r7)     // Catch:{ NoSuchMethodException -> 0x0021 }
                goto L_0x0027
            L_0x0021:
                java.lang.String r0 = "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection"
                io.flutter.Log.w(r2, r0)
                r0 = r4
            L_0x0027:
                int r6 = android.os.Build.VERSION.SDK_INT
                r7 = 26
                r8 = 1
                if (r6 > r7) goto L_0x0055
                java.lang.String r6 = "getParentNodeId"
                java.lang.Class[] r7 = new java.lang.Class[r3]     // Catch:{ NoSuchMethodException -> 0x0037 }
                java.lang.reflect.Method r6 = r1.getMethod(r6, r7)     // Catch:{ NoSuchMethodException -> 0x0037 }
                goto L_0x003d
            L_0x0037:
                java.lang.String r6 = "can't invoke getParentNodeId with reflection"
                io.flutter.Log.w(r2, r6)
                r6 = r4
            L_0x003d:
                java.lang.String r7 = "getChildId"
                java.lang.Class[] r8 = new java.lang.Class[r8]     // Catch:{ NoSuchMethodException -> 0x004b }
                java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ NoSuchMethodException -> 0x004b }
                r8[r3] = r9     // Catch:{ NoSuchMethodException -> 0x004b }
                java.lang.reflect.Method r1 = r1.getMethod(r7, r8)     // Catch:{ NoSuchMethodException -> 0x004b }
                r2 = r4
                goto L_0x0052
            L_0x004b:
                java.lang.String r1 = "can't invoke getChildId with reflection"
                io.flutter.Log.w(r2, r1)
                r1 = r4
                r2 = r1
            L_0x0052:
                r3 = r2
                r4 = r6
                goto L_0x007c
            L_0x0055:
                java.lang.String r6 = "mChildNodeIds"
                java.lang.reflect.Field r1 = r1.getDeclaredField(r6)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException -> 0x0074 }
                r1.setAccessible(r8)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException -> 0x0074 }
                java.lang.String r6 = "android.util.LongArray"
                java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException -> 0x0074 }
                java.lang.String r7 = "get"
                java.lang.Class[] r8 = new java.lang.Class[r8]     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException -> 0x0074 }
                java.lang.Class r9 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException -> 0x0074 }
                r8[r3] = r9     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException -> 0x0074 }
                java.lang.reflect.Method r2 = r6.getMethod(r7, r8)     // Catch:{ ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException -> 0x0074 }
                r3 = r2
                r2 = r1
                r1 = r4
                goto L_0x007c
            L_0x0074:
                java.lang.String r1 = "can't access childNodeIdsField with reflection"
                io.flutter.Log.w(r2, r1)
                r1 = r4
                r2 = r1
                r3 = r2
            L_0x007c:
                r10.getSourceNodeId = r5
                r10.getParentNodeId = r4
                r10.getRecordSourceNodeId = r0
                r10.getChildId = r1
                r10.childNodeIdsField = r2
                r10.longArrayGetIndex = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityViewEmbedder.ReflectionAccessors.<init>():void");
        }
    }

    public static class ViewAndId {

        /* renamed from: a  reason: collision with root package name */
        public final View f14444a;

        /* renamed from: b  reason: collision with root package name */
        public final int f14445b;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewAndId)) {
                return false;
            }
            ViewAndId viewAndId = (ViewAndId) obj;
            if (this.f14445b != viewAndId.f14445b || !this.f14444a.equals(viewAndId.f14444a)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return ((this.f14444a.hashCode() + 31) * 31) + this.f14445b;
        }

        private ViewAndId(View view, int i11) {
            this.f14444a = view;
            this.f14445b = i11;
        }
    }

    public AccessibilityViewEmbedder(@NonNull View view, int i11) {
        this.rootAccessibilityView = view;
        this.nextFlutterId = i11;
        this.originToFlutterId = new HashMap();
        this.embeddedViewToDisplayBounds = new HashMap();
    }

    private void addChildrenToFlutterNode(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        int i11;
        for (int i12 = 0; i12 < accessibilityNodeInfo.getChildCount(); i12++) {
            Long d11 = this.reflectionAccessors.getChildId(accessibilityNodeInfo, i12);
            if (d11 != null) {
                int b11 = ReflectionAccessors.getVirtualNodeId(d11.longValue());
                ViewAndId viewAndId = new ViewAndId(view, b11);
                if (this.originToFlutterId.containsKey(viewAndId)) {
                    i11 = this.originToFlutterId.get(viewAndId).intValue();
                } else {
                    int i13 = this.nextFlutterId;
                    this.nextFlutterId = i13 + 1;
                    cacheVirtualIdMappings(view, b11, i13);
                    i11 = i13;
                }
                accessibilityNodeInfo2.addChild(this.rootAccessibilityView, i11);
            }
        }
    }

    private void cacheVirtualIdMappings(@NonNull View view, int i11, int i12) {
        ViewAndId viewAndId = new ViewAndId(view, i11);
        this.originToFlutterId.put(viewAndId, Integer.valueOf(i12));
        this.flutterIdToOrigin.put(i12, viewAndId);
    }

    @NonNull
    private AccessibilityNodeInfo convertToFlutterNode(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, int i11, @NonNull View view) {
        AccessibilityNodeInfo obtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i11);
        obtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        obtain.setSource(this.rootAccessibilityView, i11);
        obtain.setClassName(accessibilityNodeInfo.getClassName());
        copyAccessibilityFields(accessibilityNodeInfo, obtain);
        setFlutterNodesTranslateBounds(accessibilityNodeInfo, this.embeddedViewToDisplayBounds.get(view), obtain);
        addChildrenToFlutterNode(accessibilityNodeInfo, view, obtain);
        setFlutterNodeParent(accessibilityNodeInfo, view, obtain);
        return obtain;
    }

    private void copyAccessibilityFields(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        accessibilityNodeInfo2.setAccessibilityFocused(accessibilityNodeInfo.isAccessibilityFocused());
        accessibilityNodeInfo2.setCheckable(accessibilityNodeInfo.isCheckable());
        accessibilityNodeInfo2.setChecked(accessibilityNodeInfo.isChecked());
        accessibilityNodeInfo2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityNodeInfo2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityNodeInfo2.setClickable(accessibilityNodeInfo.isClickable());
        accessibilityNodeInfo2.setFocusable(accessibilityNodeInfo.isFocusable());
        accessibilityNodeInfo2.setFocused(accessibilityNodeInfo.isFocused());
        accessibilityNodeInfo2.setLongClickable(accessibilityNodeInfo.isLongClickable());
        accessibilityNodeInfo2.setMovementGranularities(accessibilityNodeInfo.getMovementGranularities());
        accessibilityNodeInfo2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityNodeInfo2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityNodeInfo2.setSelected(accessibilityNodeInfo.isSelected());
        accessibilityNodeInfo2.setText(accessibilityNodeInfo.getText());
        accessibilityNodeInfo2.setVisibleToUser(accessibilityNodeInfo.isVisibleToUser());
        int i11 = Build.VERSION.SDK_INT;
        accessibilityNodeInfo2.setEditable(accessibilityNodeInfo.isEditable());
        accessibilityNodeInfo2.setCanOpenPopup(accessibilityNodeInfo.canOpenPopup());
        accessibilityNodeInfo2.setCollectionInfo(accessibilityNodeInfo.getCollectionInfo());
        accessibilityNodeInfo2.setCollectionItemInfo(accessibilityNodeInfo.getCollectionItemInfo());
        accessibilityNodeInfo2.setContentInvalid(accessibilityNodeInfo.isContentInvalid());
        accessibilityNodeInfo2.setDismissable(accessibilityNodeInfo.isDismissable());
        accessibilityNodeInfo2.setInputType(accessibilityNodeInfo.getInputType());
        accessibilityNodeInfo2.setLiveRegion(accessibilityNodeInfo.getLiveRegion());
        accessibilityNodeInfo2.setMultiLine(accessibilityNodeInfo.isMultiLine());
        accessibilityNodeInfo2.setRangeInfo(accessibilityNodeInfo.getRangeInfo());
        accessibilityNodeInfo2.setError(accessibilityNodeInfo.getError());
        accessibilityNodeInfo2.setMaxTextLength(accessibilityNodeInfo.getMaxTextLength());
        accessibilityNodeInfo2.setContextClickable(accessibilityNodeInfo.isContextClickable());
        if (i11 >= 24) {
            accessibilityNodeInfo2.setDrawingOrder(accessibilityNodeInfo.getDrawingOrder());
            accessibilityNodeInfo2.setImportantForAccessibility(accessibilityNodeInfo.isImportantForAccessibility());
        }
        if (i11 >= 26) {
            accessibilityNodeInfo2.setAvailableExtraData(accessibilityNodeInfo.getAvailableExtraData());
            accessibilityNodeInfo2.setHintText(accessibilityNodeInfo.getHintText());
            accessibilityNodeInfo2.setShowingHintText(accessibilityNodeInfo.isShowingHintText());
        }
    }

    private void setFlutterNodeParent(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull View view, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        Long c11 = this.reflectionAccessors.getParentNodeId(accessibilityNodeInfo);
        if (c11 != null) {
            Integer num = this.originToFlutterId.get(new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(c11.longValue())));
            if (num != null) {
                accessibilityNodeInfo2.setParent(this.rootAccessibilityView, num.intValue());
            }
        }
    }

    private void setFlutterNodesTranslateBounds(@NonNull AccessibilityNodeInfo accessibilityNodeInfo, @NonNull Rect rect, @NonNull AccessibilityNodeInfo accessibilityNodeInfo2) {
        Rect rect2 = new Rect();
        accessibilityNodeInfo.getBoundsInParent(rect2);
        accessibilityNodeInfo2.setBoundsInParent(rect2);
        Rect rect3 = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect3);
        rect3.offset(rect.left, rect.top);
        accessibilityNodeInfo2.setBoundsInScreen(rect3);
    }

    @Nullable
    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i11) {
        AccessibilityNodeInfo createAccessibilityNodeInfo;
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i11);
        if (viewAndId == null || !this.embeddedViewToDisplayBounds.containsKey(viewAndId.f14444a) || viewAndId.f14444a.getAccessibilityNodeProvider() == null || (createAccessibilityNodeInfo = viewAndId.f14444a.getAccessibilityNodeProvider().createAccessibilityNodeInfo(viewAndId.f14445b)) == null) {
            return null;
        }
        return convertToFlutterNode(createAccessibilityNodeInfo, i11, viewAndId.f14444a);
    }

    @Nullable
    public Integer getRecordFlutterId(@NonNull View view, @NonNull AccessibilityRecord accessibilityRecord) {
        Long e11 = this.reflectionAccessors.getRecordSourceNodeId(accessibilityRecord);
        if (e11 == null) {
            return null;
        }
        return this.originToFlutterId.get(new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(e11.longValue())));
    }

    public AccessibilityNodeInfo getRootNode(@NonNull View view, int i11, @NonNull Rect rect) {
        AccessibilityNodeInfo createAccessibilityNodeInfo = view.createAccessibilityNodeInfo();
        Long a11 = this.reflectionAccessors.getSourceNodeId(createAccessibilityNodeInfo);
        if (a11 == null) {
            return null;
        }
        this.embeddedViewToDisplayBounds.put(view, rect);
        cacheVirtualIdMappings(view, ReflectionAccessors.getVirtualNodeId(a11.longValue()), i11);
        return convertToFlutterNode(createAccessibilityNodeInfo, i11, view);
    }

    public boolean onAccessibilityHoverEvent(int i11, @NonNull MotionEvent motionEvent) {
        MotionEvent motionEvent2 = motionEvent;
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i11);
        if (viewAndId == null) {
            return false;
        }
        Rect rect = this.embeddedViewToDisplayBounds.get(viewAndId.f14444a);
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i12 = 0; i12 < motionEvent.getPointerCount(); i12++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerPropertiesArr[i12] = pointerProperties;
            motionEvent2.getPointerProperties(i12, pointerProperties);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            motionEvent2.getPointerCoords(i12, pointerCoords);
            MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords(pointerCoords);
            pointerCoordsArr[i12] = pointerCoords2;
            pointerCoords2.x -= (float) rect.left;
            pointerCoords2.y -= (float) rect.top;
        }
        return viewAndId.f14444a.dispatchGenericMotionEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getPointerCount(), pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()));
    }

    public boolean performAction(int i11, int i12, @Nullable Bundle bundle) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i11);
        if (viewAndId == null || (accessibilityNodeProvider = viewAndId.f14444a.getAccessibilityNodeProvider()) == null) {
            return false;
        }
        return accessibilityNodeProvider.performAction(viewAndId.f14445b, i12, bundle);
    }

    public View platformViewOfNode(int i11) {
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i11);
        if (viewAndId == null) {
            return null;
        }
        return viewAndId.f14444a;
    }

    public boolean requestSendAccessibilityEvent(@NonNull View view, @NonNull View view2, @NonNull AccessibilityEvent accessibilityEvent) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(accessibilityEvent);
        Long e11 = this.reflectionAccessors.getRecordSourceNodeId(accessibilityEvent);
        if (e11 == null) {
            return false;
        }
        int b11 = ReflectionAccessors.getVirtualNodeId(e11.longValue());
        Integer num = this.originToFlutterId.get(new ViewAndId(view, b11));
        if (num == null) {
            int i11 = this.nextFlutterId;
            this.nextFlutterId = i11 + 1;
            num = Integer.valueOf(i11);
            cacheVirtualIdMappings(view, b11, num.intValue());
        }
        obtain.setSource(this.rootAccessibilityView, num.intValue());
        obtain.setClassName(accessibilityEvent.getClassName());
        obtain.setPackageName(accessibilityEvent.getPackageName());
        for (int i12 = 0; i12 < obtain.getRecordCount(); i12++) {
            AccessibilityRecord record = obtain.getRecord(i12);
            Long e12 = this.reflectionAccessors.getRecordSourceNodeId(record);
            if (e12 == null) {
                return false;
            }
            ViewAndId viewAndId = new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(e12.longValue()));
            if (!this.originToFlutterId.containsKey(viewAndId)) {
                return false;
            }
            record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(viewAndId).intValue());
        }
        return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(view2, obtain);
    }
}
