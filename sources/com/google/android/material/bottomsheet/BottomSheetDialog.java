package com.google.android.material.bottomsheet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.app.AppCompatDialog;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import com.google.android.material.R;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.color.MaterialColors;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.firebase.database.core.ValidationPath;

public class BottomSheetDialog extends AppCompatDialog {
    /* access modifiers changed from: private */
    public BottomSheetBehavior<FrameLayout> behavior;
    /* access modifiers changed from: private */
    public FrameLayout bottomSheet;
    @NonNull
    private BottomSheetBehavior.BottomSheetCallback bottomSheetCallback;
    boolean cancelable;
    private boolean canceledOnTouchOutside;
    private boolean canceledOnTouchOutsideSet;
    private FrameLayout container;
    private CoordinatorLayout coordinator;
    boolean dismissWithAnimation;
    /* access modifiers changed from: private */
    public BottomSheetBehavior.BottomSheetCallback edgeToEdgeCallback;
    private boolean edgeToEdgeEnabled;

    public static class EdgeToEdgeCallback extends BottomSheetBehavior.BottomSheetCallback {
        private final WindowInsetsCompat insetsCompat;
        private final boolean lightBottomSheet;
        private final boolean lightStatusBar;

        private void setPaddingForPosition(View view) {
            if (view.getTop() < this.insetsCompat.getSystemWindowInsetTop()) {
                BottomSheetDialog.setLightStatusBar(view, this.lightBottomSheet);
                view.setPadding(view.getPaddingLeft(), this.insetsCompat.getSystemWindowInsetTop() - view.getTop(), view.getPaddingRight(), view.getPaddingBottom());
            } else if (view.getTop() != 0) {
                BottomSheetDialog.setLightStatusBar(view, this.lightStatusBar);
                view.setPadding(view.getPaddingLeft(), 0, view.getPaddingRight(), view.getPaddingBottom());
            }
        }

        public void onSlide(@NonNull View view, float f11) {
            setPaddingForPosition(view);
        }

        public void onStateChanged(@NonNull View view, int i11) {
            setPaddingForPosition(view);
        }

        private EdgeToEdgeCallback(@NonNull View view, @NonNull WindowInsetsCompat windowInsetsCompat) {
            ColorStateList colorStateList;
            this.insetsCompat = windowInsetsCompat;
            boolean z11 = (view.getSystemUiVisibility() & 8192) != 0;
            this.lightStatusBar = z11;
            MaterialShapeDrawable materialShapeDrawable = BottomSheetBehavior.from(view).getMaterialShapeDrawable();
            if (materialShapeDrawable != null) {
                colorStateList = materialShapeDrawable.getFillColor();
            } else {
                colorStateList = ViewCompat.getBackgroundTintList(view);
            }
            if (colorStateList != null) {
                this.lightBottomSheet = MaterialColors.isColorLight(colorStateList.getDefaultColor());
            } else if (view.getBackground() instanceof ColorDrawable) {
                this.lightBottomSheet = MaterialColors.isColorLight(((ColorDrawable) view.getBackground()).getColor());
            } else {
                this.lightBottomSheet = z11;
            }
        }
    }

    public BottomSheetDialog(@NonNull Context context) {
        this(context, 0);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    private FrameLayout ensureContainerAndBehavior() {
        if (this.container == null) {
            FrameLayout frameLayout = (FrameLayout) View.inflate(getContext(), R.layout.design_bottom_sheet_dialog, (ViewGroup) null);
            this.container = frameLayout;
            this.coordinator = (CoordinatorLayout) frameLayout.findViewById(R.id.coordinator);
            FrameLayout frameLayout2 = (FrameLayout) this.container.findViewById(R.id.design_bottom_sheet);
            this.bottomSheet = frameLayout2;
            BottomSheetBehavior<FrameLayout> from = BottomSheetBehavior.from(frameLayout2);
            this.behavior = from;
            from.addBottomSheetCallback(this.bottomSheetCallback);
            this.behavior.setHideable(this.cancelable);
        }
        return this.container;
    }

    private static int getThemeResId(@NonNull Context context, int i11) {
        if (i11 != 0) {
            return i11;
        }
        TypedValue typedValue = new TypedValue();
        if (context.getTheme().resolveAttribute(R.attr.bottomSheetDialogTheme, typedValue, true)) {
            return typedValue.resourceId;
        }
        return R.style.Theme_Design_Light_BottomSheetDialog;
    }

    public static void setLightStatusBar(@NonNull View view, boolean z11) {
        int i11;
        int systemUiVisibility = view.getSystemUiVisibility();
        if (z11) {
            i11 = systemUiVisibility | 8192;
        } else {
            i11 = systemUiVisibility & -8193;
        }
        view.setSystemUiVisibility(i11);
    }

    private View wrapInBottomSheet(int i11, @Nullable View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        ensureContainerAndBehavior();
        CoordinatorLayout coordinatorLayout = (CoordinatorLayout) this.container.findViewById(R.id.coordinator);
        if (i11 != 0 && view == null) {
            view = getLayoutInflater().inflate(i11, coordinatorLayout, false);
        }
        if (this.edgeToEdgeEnabled) {
            ViewCompat.setOnApplyWindowInsetsListener(this.bottomSheet, new OnApplyWindowInsetsListener() {
                public WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                    if (BottomSheetDialog.this.edgeToEdgeCallback != null) {
                        BottomSheetDialog.this.behavior.removeBottomSheetCallback(BottomSheetDialog.this.edgeToEdgeCallback);
                    }
                    if (windowInsetsCompat != null) {
                        BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                        BottomSheetBehavior.BottomSheetCallback unused = bottomSheetDialog.edgeToEdgeCallback = new EdgeToEdgeCallback(bottomSheetDialog.bottomSheet, windowInsetsCompat);
                        BottomSheetDialog.this.behavior.addBottomSheetCallback(BottomSheetDialog.this.edgeToEdgeCallback);
                    }
                    return windowInsetsCompat;
                }
            });
        }
        this.bottomSheet.removeAllViews();
        if (layoutParams == null) {
            this.bottomSheet.addView(view);
        } else {
            this.bottomSheet.addView(view, layoutParams);
        }
        coordinatorLayout.findViewById(R.id.touch_outside).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                if (bottomSheetDialog.cancelable && bottomSheetDialog.isShowing() && BottomSheetDialog.this.shouldWindowCloseOnTouchOutside()) {
                    BottomSheetDialog.this.cancel();
                }
            }
        });
        ViewCompat.setAccessibilityDelegate(this.bottomSheet, new AccessibilityDelegateCompat() {
            public void onInitializeAccessibilityNodeInfo(View view, @NonNull AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
                super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
                if (BottomSheetDialog.this.cancelable) {
                    accessibilityNodeInfoCompat.addAction(1048576);
                    accessibilityNodeInfoCompat.setDismissable(true);
                    return;
                }
                accessibilityNodeInfoCompat.setDismissable(false);
            }

            public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
                if (i11 == 1048576) {
                    BottomSheetDialog bottomSheetDialog = BottomSheetDialog.this;
                    if (bottomSheetDialog.cancelable) {
                        bottomSheetDialog.cancel();
                        return true;
                    }
                }
                return super.performAccessibilityAction(view, i11, bundle);
            }
        });
        this.bottomSheet.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        return this.container;
    }

    public void cancel() {
        BottomSheetBehavior<FrameLayout> behavior2 = getBehavior();
        if (!this.dismissWithAnimation || behavior2.getState() == 5) {
            super.cancel();
        } else {
            behavior2.setState(5);
        }
    }

    @NonNull
    public BottomSheetBehavior<FrameLayout> getBehavior() {
        if (this.behavior == null) {
            ensureContainerAndBehavior();
        }
        return this.behavior;
    }

    public boolean getDismissWithAnimation() {
        return this.dismissWithAnimation;
    }

    public boolean getEdgeToEdgeEnabled() {
        return this.edgeToEdgeEnabled;
    }

    public void onAttachedToWindow() {
        boolean z11;
        super.onAttachedToWindow();
        Window window = getWindow();
        if (window != null) {
            if (!this.edgeToEdgeEnabled || Color.alpha(window.getNavigationBarColor()) >= 255) {
                z11 = false;
            } else {
                z11 = true;
            }
            FrameLayout frameLayout = this.container;
            if (frameLayout != null) {
                frameLayout.setFitsSystemWindows(!z11);
            }
            CoordinatorLayout coordinatorLayout = this.coordinator;
            if (coordinatorLayout != null) {
                coordinatorLayout.setFitsSystemWindows(!z11);
            }
            if (z11) {
                window.getDecorView().setSystemUiVisibility(ValidationPath.MAX_PATH_LENGTH_BYTES);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Window window = getWindow();
        if (window != null) {
            window.setStatusBarColor(0);
            window.addFlags(Integer.MIN_VALUE);
            window.setLayout(-1, -1);
        }
    }

    public void onStart() {
        super.onStart();
        BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
        if (bottomSheetBehavior != null && bottomSheetBehavior.getState() == 5) {
            this.behavior.setState(4);
        }
    }

    public void removeDefaultCallback() {
        this.behavior.removeBottomSheetCallback(this.bottomSheetCallback);
    }

    public void setCancelable(boolean z11) {
        super.setCancelable(z11);
        if (this.cancelable != z11) {
            this.cancelable = z11;
            BottomSheetBehavior<FrameLayout> bottomSheetBehavior = this.behavior;
            if (bottomSheetBehavior != null) {
                bottomSheetBehavior.setHideable(z11);
            }
        }
    }

    public void setCanceledOnTouchOutside(boolean z11) {
        super.setCanceledOnTouchOutside(z11);
        if (z11 && !this.cancelable) {
            this.cancelable = true;
        }
        this.canceledOnTouchOutside = z11;
        this.canceledOnTouchOutsideSet = true;
    }

    public void setContentView(@LayoutRes int i11) {
        super.setContentView(wrapInBottomSheet(i11, (View) null, (ViewGroup.LayoutParams) null));
    }

    public void setDismissWithAnimation(boolean z11) {
        this.dismissWithAnimation = z11;
    }

    public boolean shouldWindowCloseOnTouchOutside() {
        if (!this.canceledOnTouchOutsideSet) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(new int[]{16843611});
            this.canceledOnTouchOutside = obtainStyledAttributes.getBoolean(0, true);
            obtainStyledAttributes.recycle();
            this.canceledOnTouchOutsideSet = true;
        }
        return this.canceledOnTouchOutside;
    }

    public void setContentView(View view) {
        super.setContentView(wrapInBottomSheet(0, view, (ViewGroup.LayoutParams) null));
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        super.setContentView(wrapInBottomSheet(0, view, layoutParams));
    }

    public BottomSheetDialog(@NonNull Context context, @StyleRes int i11) {
        super(context, getThemeResId(context, i11));
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(@NonNull View view, float f11) {
            }

            public void onStateChanged(@NonNull View view, int i11) {
                if (i11 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }

    public BottomSheetDialog(@NonNull Context context, boolean z11, DialogInterface.OnCancelListener onCancelListener) {
        super(context, z11, onCancelListener);
        this.cancelable = true;
        this.canceledOnTouchOutside = true;
        this.bottomSheetCallback = new BottomSheetBehavior.BottomSheetCallback() {
            public void onSlide(@NonNull View view, float f11) {
            }

            public void onStateChanged(@NonNull View view, int i11) {
                if (i11 == 5) {
                    BottomSheetDialog.this.cancel();
                }
            }
        };
        supportRequestWindowFeature(1);
        this.cancelable = z11;
        this.edgeToEdgeEnabled = getContext().getTheme().obtainStyledAttributes(new int[]{R.attr.enableEdgeToEdge}).getBoolean(0, false);
    }
}
