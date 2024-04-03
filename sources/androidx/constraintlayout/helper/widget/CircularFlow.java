package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;

public class CircularFlow extends VirtualLayout {
    private static float DEFAULT_ANGLE = 0.0f;
    private static int DEFAULT_RADIUS = 0;
    private static final String TAG = "CircularFlow";

    /* renamed from: j  reason: collision with root package name */
    public ConstraintLayout f10843j;

    /* renamed from: k  reason: collision with root package name */
    public int f10844k;
    private float[] mAngles;
    private int mCountAngle;
    private int mCountRadius;
    private int[] mRadius;
    private String mReferenceAngles;
    private Float mReferenceDefaultAngle;
    private Integer mReferenceDefaultRadius;
    private String mReferenceRadius;

    public CircularFlow(Context context) {
        super(context);
    }

    private void addAngle(String str) {
        float[] fArr;
        if (str != null && str.length() != 0 && this.f11096d != null && (fArr = this.mAngles) != null) {
            if (this.mCountAngle + 1 > fArr.length) {
                this.mAngles = Arrays.copyOf(fArr, fArr.length + 1);
            }
            this.mAngles[this.mCountAngle] = (float) Integer.parseInt(str);
            this.mCountAngle++;
        }
    }

    private void addRadius(String str) {
        int[] iArr;
        if (str != null && str.length() != 0 && this.f11096d != null && (iArr = this.mRadius) != null) {
            if (this.mCountRadius + 1 > iArr.length) {
                this.mRadius = Arrays.copyOf(iArr, iArr.length + 1);
            }
            this.mRadius[this.mCountRadius] = (int) (((float) Integer.parseInt(str)) * this.f11096d.getResources().getDisplayMetrics().density);
            this.mCountRadius++;
        }
    }

    private void anchorReferences() {
        this.f10843j = (ConstraintLayout) getParent();
        for (int i11 = 0; i11 < this.f11095c; i11++) {
            View viewById = this.f10843j.getViewById(this.f11094b[i11]);
            if (viewById != null) {
                int i12 = DEFAULT_RADIUS;
                float f11 = DEFAULT_ANGLE;
                int[] iArr = this.mRadius;
                if (iArr == null || i11 >= iArr.length) {
                    Integer num = this.mReferenceDefaultRadius;
                    if (num == null || num.intValue() == -1) {
                        Log.e(TAG, "Added radius to view with id: " + this.f11101i.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.mCountRadius++;
                        if (this.mRadius == null) {
                            this.mRadius = new int[1];
                        }
                        int[] radius = getRadius();
                        this.mRadius = radius;
                        radius[this.mCountRadius - 1] = i12;
                    }
                } else {
                    i12 = iArr[i11];
                }
                float[] fArr = this.mAngles;
                if (fArr == null || i11 >= fArr.length) {
                    Float f12 = this.mReferenceDefaultAngle;
                    if (f12 == null || f12.floatValue() == -1.0f) {
                        Log.e(TAG, "Added angle to view with id: " + this.f11101i.get(Integer.valueOf(viewById.getId())));
                    } else {
                        this.mCountAngle++;
                        if (this.mAngles == null) {
                            this.mAngles = new float[1];
                        }
                        float[] angles = getAngles();
                        this.mAngles = angles;
                        angles[this.mCountAngle - 1] = f11;
                    }
                } else {
                    f11 = fArr[i11];
                }
                ConstraintLayout.LayoutParams layoutParams = (ConstraintLayout.LayoutParams) viewById.getLayoutParams();
                layoutParams.circleAngle = f11;
                layoutParams.circleConstraint = this.f10844k;
                layoutParams.circleRadius = i12;
                viewById.setLayoutParams(layoutParams);
            }
        }
        a();
    }

    private float[] removeAngle(float[] fArr, int i11) {
        if (fArr == null || i11 < 0 || i11 >= this.mCountAngle) {
            return fArr;
        }
        return removeElementFromArray(fArr, i11);
    }

    public static int[] removeElementFromArray(int[] iArr, int i11) {
        int[] iArr2 = new int[(iArr.length - 1)];
        int i12 = 0;
        for (int i13 = 0; i13 < iArr.length; i13++) {
            if (i13 != i11) {
                iArr2[i12] = iArr[i13];
                i12++;
            }
        }
        return iArr2;
    }

    private int[] removeRadius(int[] iArr, int i11) {
        if (iArr == null || i11 < 0 || i11 >= this.mCountRadius) {
            return iArr;
        }
        return removeElementFromArray(iArr, i11);
    }

    private void setAngles(String str) {
        if (str != null) {
            int i11 = 0;
            this.mCountAngle = 0;
            while (true) {
                int indexOf = str.indexOf(44, i11);
                if (indexOf == -1) {
                    addAngle(str.substring(i11).trim());
                    return;
                } else {
                    addAngle(str.substring(i11, indexOf).trim());
                    i11 = indexOf + 1;
                }
            }
        }
    }

    private void setRadius(String str) {
        if (str != null) {
            int i11 = 0;
            this.mCountRadius = 0;
            while (true) {
                int indexOf = str.indexOf(44, i11);
                if (indexOf == -1) {
                    addRadius(str.substring(i11).trim());
                    return;
                } else {
                    addRadius(str.substring(i11, indexOf).trim());
                    i11 = indexOf + 1;
                }
            }
        }
    }

    public void addViewToCircularFlow(View view, int i11, float f11) {
        if (!containsId(view.getId())) {
            addView(view);
            this.mCountAngle++;
            float[] angles = getAngles();
            this.mAngles = angles;
            angles[this.mCountAngle - 1] = f11;
            this.mCountRadius++;
            int[] radius = getRadius();
            this.mRadius = radius;
            radius[this.mCountRadius - 1] = (int) (((float) i11) * this.f11096d.getResources().getDisplayMetrics().density);
            anchorReferences();
        }
    }

    public void e(AttributeSet attributeSet) {
        super.e(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f10844k = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.mReferenceAngles = string;
                    setAngles(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.mReferenceRadius = string2;
                    setRadius(string2);
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, DEFAULT_ANGLE));
                    this.mReferenceDefaultAngle = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R.styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, DEFAULT_RADIUS));
                    this.mReferenceDefaultRadius = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.mAngles, this.mCountAngle);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.mRadius, this.mCountRadius);
    }

    public boolean isUpdatable(View view) {
        if (containsId(view.getId()) && indexFromId(view.getId()) != -1) {
            return true;
        }
        return false;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.mReferenceAngles;
        if (str != null) {
            this.mAngles = new float[1];
            setAngles(str);
        }
        String str2 = this.mReferenceRadius;
        if (str2 != null) {
            this.mRadius = new int[1];
            setRadius(str2);
        }
        Float f11 = this.mReferenceDefaultAngle;
        if (f11 != null) {
            setDefaultAngle(f11.floatValue());
        }
        Integer num = this.mReferenceDefaultRadius;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        anchorReferences();
    }

    public int removeView(View view) {
        int removeView = super.removeView(view);
        if (removeView == -1) {
            return removeView;
        }
        ConstraintSet constraintSet = new ConstraintSet();
        constraintSet.clone(this.f10843j);
        constraintSet.clear(view.getId(), 8);
        constraintSet.applyTo(this.f10843j);
        float[] fArr = this.mAngles;
        if (removeView < fArr.length) {
            this.mAngles = removeAngle(fArr, removeView);
            this.mCountAngle--;
        }
        int[] iArr = this.mRadius;
        if (removeView < iArr.length) {
            this.mRadius = removeRadius(iArr, removeView);
            this.mCountRadius--;
        }
        anchorReferences();
        return removeView;
    }

    public void setDefaultAngle(float f11) {
        DEFAULT_ANGLE = f11;
    }

    public void setDefaultRadius(int i11) {
        DEFAULT_RADIUS = i11;
    }

    public void updateAngle(View view, float f11) {
        if (!isUpdatable(view)) {
            Log.e(TAG, "It was not possible to update angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId <= this.mAngles.length) {
            float[] angles = getAngles();
            this.mAngles = angles;
            angles[indexFromId] = f11;
            anchorReferences();
        }
    }

    public void updateRadius(View view, int i11) {
        if (!isUpdatable(view)) {
            Log.e(TAG, "It was not possible to update radius to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (indexFromId <= this.mRadius.length) {
            int[] radius = getRadius();
            this.mRadius = radius;
            radius[indexFromId] = (int) (((float) i11) * this.f11096d.getResources().getDisplayMetrics().density);
            anchorReferences();
        }
    }

    public void updateReference(View view, int i11, float f11) {
        if (!isUpdatable(view)) {
            Log.e(TAG, "It was not possible to update radius and angle to view with id: " + view.getId());
            return;
        }
        int indexFromId = indexFromId(view.getId());
        if (getAngles().length > indexFromId) {
            float[] angles = getAngles();
            this.mAngles = angles;
            angles[indexFromId] = f11;
        }
        if (getRadius().length > indexFromId) {
            int[] radius = getRadius();
            this.mRadius = radius;
            radius[indexFromId] = (int) (((float) i11) * this.f11096d.getResources().getDisplayMetrics().density);
        }
        anchorReferences();
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
    }

    public static float[] removeElementFromArray(float[] fArr, int i11) {
        float[] fArr2 = new float[(fArr.length - 1)];
        int i12 = 0;
        for (int i13 = 0; i13 < fArr.length; i13++) {
            if (i13 != i11) {
                fArr2[i12] = fArr[i13];
                i12++;
            }
        }
        return fArr2;
    }
}
