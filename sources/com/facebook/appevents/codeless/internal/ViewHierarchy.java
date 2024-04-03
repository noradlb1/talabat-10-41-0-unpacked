package com.facebook.appevents.codeless.internal;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.annotation.RestrictTo;
import androidx.compose.ui.platform.AndroidComposeViewAccessibilityDelegateCompat;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.AutoHandleExceptions;
import java.io.ByteArrayOutputStream;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0018\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u00142\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\fH\u0007J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\fH\u0007J\u0010\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0016\u0010\u0019\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u001a2\u0006\u0010\u001b\u001a\u00020\u0004H\u0002J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010 \u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0014\u0010!\u001a\u0004\u0018\u00010\"2\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u0012\u0010#\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\fH\u0007J\u001e\u0010$\u001a\u0004\u0018\u00010\f2\b\u0010%\u001a\u0004\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\fH\u0002J\u0010\u0010(\u001a\u00020&2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\b\u0010)\u001a\u00020*H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\fH\u0003J\u0018\u0010-\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\f2\b\u0010'\u001a\u0004\u0018\u00010\fJ\u0010\u0010.\u001a\u00020,2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u001a\u0010/\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\f2\b\u00100\u001a\u0004\u0018\u00010\u001dH\u0007J \u00101\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u000204H\u0007J\u0018\u00105\u001a\u00020*2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u00102\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u000bX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\r\u001a\n \u000e*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/facebook/appevents/codeless/internal/ViewHierarchy;", "", "()V", "CLASS_RCTROOTVIEW", "", "CLASS_RCTVIEWGROUP", "CLASS_TOUCHTARGETHELPER", "ICON_MAX_EDGE_LENGTH", "", "METHOD_FIND_TOUCHTARGET_VIEW", "RCTRootViewReference", "Ljava/lang/ref/WeakReference;", "Landroid/view/View;", "TAG", "kotlin.jvm.PlatformType", "methodFindTouchTargetView", "Ljava/lang/reflect/Method;", "findRCTRootView", "view", "getChildrenOfView", "", "getClassTypeBitmask", "getDictionaryOfView", "Lorg/json/JSONObject;", "getDimensionOfView", "getExistingClass", "Ljava/lang/Class;", "className", "getExistingOnClickListener", "Landroid/view/View$OnClickListener;", "getExistingOnTouchListener", "Landroid/view/View$OnTouchListener;", "getHintOfView", "getParentOfView", "Landroid/view/ViewGroup;", "getTextOfView", "getTouchReactView", "location", "", "RCTRootView", "getViewLocationOnScreen", "initTouchTargetHelperMethods", "", "isAdapterViewItem", "", "isRCTButton", "isRCTRootView", "setOnClickListener", "newListener", "updateAppearanceOfView", "json", "displayDensity", "", "updateBasicInfoOfView", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
@AutoHandleExceptions
public final class ViewHierarchy {
    @NotNull
    private static final String CLASS_RCTROOTVIEW = "com.facebook.react.ReactRootView";
    @NotNull
    private static final String CLASS_RCTVIEWGROUP = "com.facebook.react.views.view.ReactViewGroup";
    @NotNull
    private static final String CLASS_TOUCHTARGETHELPER = "com.facebook.react.uimanager.TouchTargetHelper";
    private static final int ICON_MAX_EDGE_LENGTH = 44;
    @NotNull
    public static final ViewHierarchy INSTANCE = new ViewHierarchy();
    @NotNull
    private static final String METHOD_FIND_TOUCHTARGET_VIEW = "findTouchTargetView";
    @NotNull
    private static WeakReference<View> RCTRootViewReference = new WeakReference<>((Object) null);
    private static final String TAG = ViewHierarchy.class.getCanonicalName();
    @Nullable
    private static Method methodFindTouchTargetView;

    private ViewHierarchy() {
    }

    @JvmStatic
    @Nullable
    public static final View findRCTRootView(@Nullable View view) {
        while (view != null) {
            if (INSTANCE.isRCTRootView(view)) {
                return view;
            }
            ViewParent parent = view.getParent();
            if (!(parent instanceof View)) {
                return null;
            }
            view = (View) parent;
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r4 = (android.view.ViewGroup) r4;
     */
    @kotlin.jvm.JvmStatic
    @org.jetbrains.annotations.NotNull
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.util.List<android.view.View> getChildrenOfView(@org.jetbrains.annotations.Nullable android.view.View r4) {
        /*
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            boolean r1 = r4 instanceof android.view.ViewGroup
            if (r1 == 0) goto L_0x0020
            android.view.ViewGroup r4 = (android.view.ViewGroup) r4
            int r1 = r4.getChildCount()
            if (r1 <= 0) goto L_0x0020
            r2 = 0
        L_0x0012:
            int r3 = r2 + 1
            android.view.View r2 = r4.getChildAt(r2)
            r0.add(r2)
            if (r3 < r1) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r2 = r3
            goto L_0x0012
        L_0x0020:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.getChildrenOfView(android.view.View):java.util.List");
    }

    @JvmStatic
    public static final int getClassTypeBitmask(@NotNull View view) {
        int i11;
        Intrinsics.checkNotNullParameter(view, "view");
        if (view instanceof ImageView) {
            i11 = 2;
        } else {
            i11 = 0;
        }
        if (view.isClickable()) {
            i11 |= 32;
        }
        if (isAdapterViewItem(view)) {
            i11 |= 512;
        }
        if (view instanceof TextView) {
            int i12 = i11 | 1024 | 1;
            if (view instanceof Button) {
                i12 |= 4;
                if (view instanceof Switch) {
                    i12 |= 8192;
                } else if (view instanceof CheckBox) {
                    i12 |= 32768;
                }
            }
            if (view instanceof EditText) {
                return i12 | 2048;
            }
            return i12;
        } else if ((view instanceof Spinner) || (view instanceof DatePicker)) {
            return i11 | 4096;
        } else {
            if (view instanceof RatingBar) {
                return i11 | 65536;
            }
            if (view instanceof RadioGroup) {
                return i11 | 16384;
            }
            if (!(view instanceof ViewGroup) || !INSTANCE.isRCTButton(view, RCTRootViewReference.get())) {
                return i11;
            }
            return i11 | 64;
        }
    }

    @JvmStatic
    @NotNull
    public static final JSONObject getDictionaryOfView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        if (Intrinsics.areEqual((Object) view.getClass().getName(), (Object) CLASS_RCTROOTVIEW)) {
            RCTRootViewReference = new WeakReference<>(view);
        }
        JSONObject jSONObject = new JSONObject();
        try {
            updateBasicInfoOfView(view, jSONObject);
            JSONArray jSONArray = new JSONArray();
            List<View> childrenOfView = getChildrenOfView(view);
            int size = childrenOfView.size() - 1;
            if (size >= 0) {
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    jSONArray.put((Object) getDictionaryOfView(childrenOfView.get(i11)));
                    if (i12 > size) {
                        break;
                    }
                    i11 = i12;
                }
            }
            jSONObject.put(ViewHierarchyConstants.CHILDREN_VIEW_KEY, (Object) jSONArray);
        } catch (JSONException e11) {
            Log.e(TAG, "Failed to create JSONObject for view.", e11);
        }
        return jSONObject;
    }

    private final JSONObject getDimensionOfView(View view) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(ViewHierarchyConstants.DIMENSION_TOP_KEY, view.getTop());
            jSONObject.put("left", view.getLeft());
            jSONObject.put("width", view.getWidth());
            jSONObject.put("height", view.getHeight());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_X_KEY, view.getScrollX());
            jSONObject.put(ViewHierarchyConstants.DIMENSION_SCROLL_Y_KEY, view.getScrollY());
            jSONObject.put("visibility", view.getVisibility());
        } catch (JSONException e11) {
            Log.e(TAG, "Failed to create JSONObject for dimension.", e11);
        }
        return jSONObject;
    }

    private final Class<?> getExistingClass(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final View.OnClickListener getExistingOnClickListener(@Nullable View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnClickListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnClickListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnClickListener");
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return null;
        }
    }

    @JvmStatic
    @Nullable
    public static final View.OnTouchListener getExistingOnTouchListener(@Nullable View view) {
        Field declaredField;
        try {
            Field declaredField2 = Class.forName(AndroidComposeViewAccessibilityDelegateCompat.ClassName).getDeclaredField("mListenerInfo");
            if (declaredField2 != null) {
                declaredField2.setAccessible(true);
            }
            Object obj = declaredField2.get(view);
            if (obj == null || (declaredField = Class.forName("android.view.View$ListenerInfo").getDeclaredField("mOnTouchListener")) == null) {
                return null;
            }
            declaredField.setAccessible(true);
            Object obj2 = declaredField.get(obj);
            if (obj2 != null) {
                return (View.OnTouchListener) obj2;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.view.View.OnTouchListener");
        } catch (NoSuchFieldException e11) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e11);
            return null;
        } catch (ClassNotFoundException e12) {
            Utility utility2 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e12);
            return null;
        } catch (IllegalAccessException e13) {
            Utility utility3 = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e13);
            return null;
        }
    }

    @JvmStatic
    @NotNull
    public static final String getHintOfView(@Nullable View view) {
        CharSequence charSequence;
        String obj;
        if (view instanceof EditText) {
            charSequence = ((EditText) view).getHint();
        } else if (view instanceof TextView) {
            charSequence = ((TextView) view).getHint();
        } else {
            charSequence = null;
        }
        if (charSequence == null || (obj = charSequence.toString()) == null) {
            return "";
        }
        return obj;
    }

    @JvmStatic
    @Nullable
    public static final ViewGroup getParentOfView(@Nullable View view) {
        if (view == null) {
            return null;
        }
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            return (ViewGroup) parent;
        }
        return null;
    }

    @JvmStatic
    @NotNull
    public static final String getTextOfView(@Nullable View view) {
        Object obj;
        String obj2;
        Object selectedItem;
        String str;
        if (view instanceof TextView) {
            obj = ((TextView) view).getText();
            if (view instanceof Switch) {
                if (((Switch) view).isChecked()) {
                    str = "1";
                } else {
                    str = "0";
                }
                obj = str;
            }
        } else {
            if (view instanceof Spinner) {
                Spinner spinner = (Spinner) view;
                if (spinner.getCount() > 0 && (selectedItem = spinner.getSelectedItem()) != null) {
                    obj = selectedItem.toString();
                }
            } else {
                int i11 = 0;
                if (view instanceof DatePicker) {
                    DatePicker datePicker = (DatePicker) view;
                    int year = datePicker.getYear();
                    int month = datePicker.getMonth();
                    int dayOfMonth = datePicker.getDayOfMonth();
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    obj = String.format("%04d-%02d-%02d", Arrays.copyOf(new Object[]{Integer.valueOf(year), Integer.valueOf(month), Integer.valueOf(dayOfMonth)}, 3));
                    Intrinsics.checkNotNullExpressionValue(obj, "java.lang.String.format(format, *args)");
                } else if (view instanceof TimePicker) {
                    TimePicker timePicker = (TimePicker) view;
                    Integer currentHour = timePicker.getCurrentHour();
                    Intrinsics.checkNotNullExpressionValue(currentHour, "view.currentHour");
                    int intValue = currentHour.intValue();
                    Integer currentMinute = timePicker.getCurrentMinute();
                    Intrinsics.checkNotNullExpressionValue(currentMinute, "view.currentMinute");
                    int intValue2 = currentMinute.intValue();
                    StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                    obj = String.format("%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(intValue), Integer.valueOf(intValue2)}, 2));
                    Intrinsics.checkNotNullExpressionValue(obj, "java.lang.String.format(format, *args)");
                } else if (view instanceof RadioGroup) {
                    RadioGroup radioGroup = (RadioGroup) view;
                    int checkedRadioButtonId = radioGroup.getCheckedRadioButtonId();
                    int childCount = radioGroup.getChildCount();
                    if (childCount > 0) {
                        while (true) {
                            int i12 = i11 + 1;
                            View childAt = radioGroup.getChildAt(i11);
                            if (childAt.getId() == checkedRadioButtonId && (childAt instanceof RadioButton)) {
                                obj = ((RadioButton) childAt).getText();
                                break;
                            } else if (i12 >= childCount) {
                                break;
                            } else {
                                i11 = i12;
                            }
                        }
                    }
                } else if (view instanceof RatingBar) {
                    obj = String.valueOf(((RatingBar) view).getRating());
                }
            }
            obj = null;
        }
        if (obj == null || (obj2 = obj.toString()) == null) {
            return "";
        }
        return obj2;
    }

    private final View getTouchReactView(float[] fArr, View view) {
        initTouchTargetHelperMethods();
        Method method = methodFindTouchTargetView;
        if (!(method == null || view == null)) {
            if (method != null) {
                try {
                    Object invoke = method.invoke((Object) null, new Object[]{fArr, view});
                    if (invoke != null) {
                        View view2 = (View) invoke;
                        if (view2.getId() > 0) {
                            ViewParent parent = view2.getParent();
                            if (parent != null) {
                                return (View) parent;
                            }
                            throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                        }
                    } else {
                        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
                    }
                } catch (IllegalAccessException e11) {
                    Utility utility = Utility.INSTANCE;
                    Utility.logd(TAG, (Exception) e11);
                } catch (InvocationTargetException e12) {
                    Utility utility2 = Utility.INSTANCE;
                    Utility.logd(TAG, (Exception) e12);
                }
            } else {
                throw new IllegalStateException("Required value was null.".toString());
            }
        }
        return null;
    }

    private final float[] getViewLocationOnScreen(View view) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        return new float[]{(float) iArr[0], (float) iArr[1]};
    }

    private final void initTouchTargetHelperMethods() {
        if (methodFindTouchTargetView == null) {
            try {
                Method declaredMethod = Class.forName(CLASS_TOUCHTARGETHELPER).getDeclaredMethod(METHOD_FIND_TOUCHTARGET_VIEW, new Class[]{float[].class, ViewGroup.class});
                methodFindTouchTargetView = declaredMethod;
                if (declaredMethod != null) {
                    declaredMethod.setAccessible(true);
                    return;
                }
                throw new IllegalStateException("Required value was null.".toString());
            } catch (ClassNotFoundException e11) {
                Utility utility = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e11);
            } catch (NoSuchMethodException e12) {
                Utility utility2 = Utility.INSTANCE;
                Utility.logd(TAG, (Exception) e12);
            }
        }
    }

    @JvmStatic
    private static final boolean isAdapterViewItem(View view) {
        ViewParent parent = view.getParent();
        if (parent instanceof AdapterView) {
            return true;
        }
        ViewHierarchy viewHierarchy = INSTANCE;
        Class<?> existingClass = viewHierarchy.getExistingClass("android.support.v4.view.NestedScrollingChild");
        if (existingClass != null && existingClass.isInstance(parent)) {
            return true;
        }
        Class<?> existingClass2 = viewHierarchy.getExistingClass("androidx.core.view.NestedScrollingChild");
        if (existingClass2 == null || !existingClass2.isInstance(parent)) {
            return false;
        }
        return true;
    }

    private final boolean isRCTRootView(View view) {
        return Intrinsics.areEqual((Object) view.getClass().getName(), (Object) CLASS_RCTROOTVIEW);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0023 A[ADDED_TO_REGION] */
    @kotlin.jvm.JvmStatic
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void setOnClickListener(@org.jetbrains.annotations.NotNull android.view.View r4, @org.jetbrains.annotations.Nullable android.view.View.OnClickListener r5) {
        /*
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            r0 = 0
            java.lang.String r1 = "android.view.View"
            java.lang.Class r1 = java.lang.Class.forName(r1)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x001f }
            java.lang.String r2 = "mListenerInfo"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r2)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x001f }
            java.lang.String r2 = "android.view.View$ListenerInfo"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0020 }
            java.lang.String r3 = "mOnClickListener"
            java.lang.reflect.Field r2 = r2.getDeclaredField(r3)     // Catch:{ ClassNotFoundException | NoSuchFieldException -> 0x0020 }
            goto L_0x0021
        L_0x001f:
            r1 = r0
        L_0x0020:
            r2 = r0
        L_0x0021:
            if (r1 == 0) goto L_0x003e
            if (r2 != 0) goto L_0x0026
            goto L_0x003e
        L_0x0026:
            r3 = 1
            r1.setAccessible(r3)     // Catch:{ Exception -> 0x0041 }
            r2.setAccessible(r3)     // Catch:{ Exception -> 0x0041 }
            r1.setAccessible(r3)     // Catch:{ IllegalAccessException -> 0x0034 }
            java.lang.Object r0 = r1.get(r4)     // Catch:{ IllegalAccessException -> 0x0034 }
        L_0x0034:
            if (r0 != 0) goto L_0x003a
            r4.setOnClickListener(r5)     // Catch:{ Exception -> 0x0041 }
            return
        L_0x003a:
            r2.set(r0, r5)     // Catch:{ Exception -> 0x0041 }
            goto L_0x0041
        L_0x003e:
            r4.setOnClickListener(r5)     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.codeless.internal.ViewHierarchy.setOnClickListener(android.view.View, android.view.View$OnClickListener):void");
    }

    @JvmStatic
    public static final void updateAppearanceOfView(@NotNull View view, @NotNull JSONObject jSONObject, float f11) {
        Bitmap bitmap;
        Typeface typeface;
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        try {
            JSONObject jSONObject2 = new JSONObject();
            if ((view instanceof TextView) && (typeface = ((TextView) view).getTypeface()) != null) {
                jSONObject2.put(ViewHierarchyConstants.TEXT_SIZE, (double) ((TextView) view).getTextSize());
                jSONObject2.put(ViewHierarchyConstants.TEXT_IS_BOLD, typeface.isBold());
                jSONObject2.put(ViewHierarchyConstants.TEXT_IS_ITALIC, typeface.isItalic());
                jSONObject.put(ViewHierarchyConstants.TEXT_STYLE, (Object) jSONObject2);
            }
            if (view instanceof ImageView) {
                Drawable drawable = ((ImageView) view).getDrawable();
                if (drawable instanceof BitmapDrawable) {
                    float f12 = (float) 44;
                    if (((float) view.getHeight()) / f11 <= f12 && ((float) view.getWidth()) / f11 <= f12 && (bitmap = ((BitmapDrawable) drawable).getBitmap()) != null) {
                        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                        jSONObject.put(ViewHierarchyConstants.ICON_BITMAP, (Object) Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0));
                    }
                }
            }
        } catch (JSONException e11) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e11);
        }
    }

    @JvmStatic
    public static final void updateBasicInfoOfView(@NotNull View view, @NotNull JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(jSONObject, "json");
        try {
            String textOfView = getTextOfView(view);
            String hintOfView = getHintOfView(view);
            Object tag = view.getTag();
            CharSequence contentDescription = view.getContentDescription();
            jSONObject.put(ViewHierarchyConstants.CLASS_NAME_KEY, (Object) view.getClass().getCanonicalName());
            jSONObject.put(ViewHierarchyConstants.CLASS_TYPE_BITMASK_KEY, getClassTypeBitmask(view));
            jSONObject.put("id", view.getId());
            if (!SensitiveUserDataUtils.isSensitiveUserData(view)) {
                jSONObject.put("text", (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(textOfView), ""));
            } else {
                jSONObject.put("text", (Object) "");
                jSONObject.put(ViewHierarchyConstants.IS_USER_INPUT_KEY, true);
            }
            jSONObject.put(ViewHierarchyConstants.HINT_KEY, (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(hintOfView), ""));
            if (tag != null) {
                jSONObject.put("tag", (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(tag.toString()), ""));
            }
            if (contentDescription != null) {
                jSONObject.put("description", (Object) Utility.coerceValueIfNullOrEmpty(Utility.sha256hash(contentDescription.toString()), ""));
            }
            jSONObject.put("dimension", (Object) INSTANCE.getDimensionOfView(view));
        } catch (JSONException e11) {
            Utility utility = Utility.INSTANCE;
            Utility.logd(TAG, (Exception) e11);
        }
    }

    public final boolean isRCTButton(@NotNull View view, @Nullable View view2) {
        View touchReactView;
        Intrinsics.checkNotNullParameter(view, "view");
        if (!Intrinsics.areEqual((Object) view.getClass().getName(), (Object) CLASS_RCTVIEWGROUP) || (touchReactView = getTouchReactView(getViewLocationOnScreen(view), view2)) == null || touchReactView.getId() != view.getId()) {
            return false;
        }
        return true;
    }
}
