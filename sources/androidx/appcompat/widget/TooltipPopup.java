package androidx.appcompat.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.Resources;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.appcompat.R;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
class TooltipPopup {
    private static final String TAG = "TooltipPopup";
    private final View mContentView;
    private final Context mContext;
    private final WindowManager.LayoutParams mLayoutParams;
    private final TextView mMessageView;
    private final int[] mTmpAnchorPos = new int[2];
    private final int[] mTmpAppPos = new int[2];
    private final Rect mTmpDisplayFrame = new Rect();

    public TooltipPopup(@NonNull Context context) {
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.mLayoutParams = layoutParams;
        this.mContext = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.mContentView = inflate;
        this.mMessageView = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(getClass().getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = R.style.Animation_AppCompat_Tooltip;
        layoutParams.flags = 24;
    }

    private void computePosition(View view, int i11, int i12, boolean z11, WindowManager.LayoutParams layoutParams) {
        int i13;
        int i14;
        int i15;
        int i16;
        layoutParams.token = view.getApplicationWindowToken();
        int dimensionPixelOffset = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_threshold);
        if (view.getWidth() < dimensionPixelOffset) {
            i11 = view.getWidth() / 2;
        }
        if (view.getHeight() >= dimensionPixelOffset) {
            int dimensionPixelOffset2 = this.mContext.getResources().getDimensionPixelOffset(R.dimen.tooltip_precise_anchor_extra_offset);
            i14 = i12 + dimensionPixelOffset2;
            i13 = i12 - dimensionPixelOffset2;
        } else {
            i14 = view.getHeight();
            i13 = 0;
        }
        layoutParams.gravity = 49;
        Resources resources = this.mContext.getResources();
        if (z11) {
            i15 = R.dimen.tooltip_y_offset_touch;
        } else {
            i15 = R.dimen.tooltip_y_offset_non_touch;
        }
        int dimensionPixelOffset3 = resources.getDimensionPixelOffset(i15);
        View appRootView = getAppRootView(view);
        if (appRootView == null) {
            Log.e(TAG, "Cannot find app view");
            return;
        }
        appRootView.getWindowVisibleDisplayFrame(this.mTmpDisplayFrame);
        Rect rect = this.mTmpDisplayFrame;
        if (rect.left < 0 && rect.top < 0) {
            Resources resources2 = this.mContext.getResources();
            int identifier = resources2.getIdentifier("status_bar_height", "dimen", "android");
            if (identifier != 0) {
                i16 = resources2.getDimensionPixelSize(identifier);
            } else {
                i16 = 0;
            }
            DisplayMetrics displayMetrics = resources2.getDisplayMetrics();
            this.mTmpDisplayFrame.set(0, i16, displayMetrics.widthPixels, displayMetrics.heightPixels);
        }
        appRootView.getLocationOnScreen(this.mTmpAppPos);
        view.getLocationOnScreen(this.mTmpAnchorPos);
        int[] iArr = this.mTmpAnchorPos;
        int i17 = iArr[0];
        int[] iArr2 = this.mTmpAppPos;
        int i18 = i17 - iArr2[0];
        iArr[0] = i18;
        iArr[1] = iArr[1] - iArr2[1];
        layoutParams.x = (i18 + i11) - (appRootView.getWidth() / 2);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
        this.mContentView.measure(makeMeasureSpec, makeMeasureSpec);
        int measuredHeight = this.mContentView.getMeasuredHeight();
        int i19 = this.mTmpAnchorPos[1];
        int i21 = ((i13 + i19) - dimensionPixelOffset3) - measuredHeight;
        int i22 = i19 + i14 + dimensionPixelOffset3;
        if (z11) {
            if (i21 >= 0) {
                layoutParams.y = i21;
            } else {
                layoutParams.y = i22;
            }
        } else if (measuredHeight + i22 <= this.mTmpDisplayFrame.height()) {
            layoutParams.y = i22;
        } else {
            layoutParams.y = i21;
        }
    }

    private static View getAppRootView(View view) {
        View rootView = view.getRootView();
        ViewGroup.LayoutParams layoutParams = rootView.getLayoutParams();
        if ((layoutParams instanceof WindowManager.LayoutParams) && ((WindowManager.LayoutParams) layoutParams).type == 2) {
            return rootView;
        }
        for (Context context = view.getContext(); context instanceof ContextWrapper; context = ((ContextWrapper) context).getBaseContext()) {
            if (context instanceof Activity) {
                return ((Activity) context).getWindow().getDecorView();
            }
        }
        return rootView;
    }

    public void a() {
        if (b()) {
            ((WindowManager) this.mContext.getSystemService("window")).removeView(this.mContentView);
        }
    }

    public boolean b() {
        return this.mContentView.getParent() != null;
    }

    public void c(View view, int i11, int i12, boolean z11, CharSequence charSequence) {
        if (b()) {
            a();
        }
        this.mMessageView.setText(charSequence);
        computePosition(view, i11, i12, z11, this.mLayoutParams);
        ((WindowManager) this.mContext.getSystemService("window")).addView(this.mContentView, this.mLayoutParams);
    }
}
