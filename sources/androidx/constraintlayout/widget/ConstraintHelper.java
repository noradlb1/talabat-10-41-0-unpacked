package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Helper;
import androidx.constraintlayout.core.widgets.HelperWidget;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.constraintlayout.widget.R;
import java.util.Arrays;
import java.util.HashMap;

public abstract class ConstraintHelper extends View {

    /* renamed from: b  reason: collision with root package name */
    public int[] f11094b = new int[32];

    /* renamed from: c  reason: collision with root package name */
    public int f11095c;

    /* renamed from: d  reason: collision with root package name */
    public Context f11096d;

    /* renamed from: e  reason: collision with root package name */
    public Helper f11097e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f11098f = false;

    /* renamed from: g  reason: collision with root package name */
    public String f11099g;

    /* renamed from: h  reason: collision with root package name */
    public String f11100h;

    /* renamed from: i  reason: collision with root package name */
    public HashMap<Integer, String> f11101i = new HashMap<>();
    private View[] mViews = null;

    public ConstraintHelper(Context context) {
        super(context);
        this.f11096d = context;
        e((AttributeSet) null);
    }

    private void addID(String str) {
        if (str != null && str.length() != 0 && this.f11096d != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                ConstraintLayout constraintLayout = (ConstraintLayout) getParent();
            }
            int findId = findId(trim);
            if (findId != 0) {
                this.f11101i.put(Integer.valueOf(findId), trim);
                addRscID(findId);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private void addRscID(int i11) {
        if (i11 != getId()) {
            int i12 = this.f11095c + 1;
            int[] iArr = this.f11094b;
            if (i12 > iArr.length) {
                this.f11094b = Arrays.copyOf(iArr, iArr.length * 2);
            }
            int[] iArr2 = this.f11094b;
            int i13 = this.f11095c;
            iArr2[i13] = i11;
            this.f11095c = i13 + 1;
        }
    }

    private void addTag(String str) {
        ConstraintLayout constraintLayout;
        if (str != null && str.length() != 0 && this.f11096d != null) {
            String trim = str.trim();
            if (getParent() instanceof ConstraintLayout) {
                constraintLayout = (ConstraintLayout) getParent();
            } else {
                constraintLayout = null;
            }
            if (constraintLayout == null) {
                Log.w("ConstraintHelper", "Parent not a ConstraintLayout");
                return;
            }
            int childCount = constraintLayout.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = constraintLayout.getChildAt(i11);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if ((layoutParams instanceof ConstraintLayout.LayoutParams) && trim.equals(((ConstraintLayout.LayoutParams) layoutParams).constraintTag)) {
                    if (childAt.getId() == -1) {
                        Log.w("ConstraintHelper", "to use ConstraintTag view " + childAt.getClass().getSimpleName() + " must have an ID");
                    } else {
                        addRscID(childAt.getId());
                    }
                }
            }
        }
    }

    private int[] convertReferenceString(View view, String str) {
        String[] split = str.split(",");
        view.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        for (String trim : split) {
            int findId = findId(trim.trim());
            if (findId != 0) {
                iArr[i11] = findId;
                i11++;
            }
        }
        if (i11 != split.length) {
            return Arrays.copyOf(iArr, i11);
        }
        return iArr;
    }

    private int findId(String str) {
        ConstraintLayout constraintLayout = getParent() instanceof ConstraintLayout ? (ConstraintLayout) getParent() : null;
        int i11 = 0;
        if (isInEditMode() && constraintLayout != null) {
            Object designInformation = constraintLayout.getDesignInformation(0, str);
            if (designInformation instanceof Integer) {
                i11 = ((Integer) designInformation).intValue();
            }
        }
        if (i11 == 0 && constraintLayout != null) {
            i11 = findId(constraintLayout, str);
        }
        if (i11 == 0) {
            try {
                i11 = R.id.class.getField(str).getInt((Object) null);
            } catch (Exception unused) {
            }
        }
        return i11 == 0 ? this.f11096d.getResources().getIdentifier(str, "id", this.f11096d.getPackageName()) : i11;
    }

    public void a() {
        ViewParent parent = getParent();
        if (parent != null && (parent instanceof ConstraintLayout)) {
            b((ConstraintLayout) parent);
        }
    }

    public void addView(View view) {
        if (view != this) {
            if (view.getId() == -1) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have an id");
            } else if (view.getParent() == null) {
                Log.e("ConstraintHelper", "Views added to a ConstraintHelper need to have a parent");
            } else {
                this.f11099g = null;
                addRscID(view.getId());
                requestLayout();
            }
        }
    }

    public void b(ConstraintLayout constraintLayout) {
        int visibility = getVisibility();
        float elevation = getElevation();
        for (int i11 = 0; i11 < this.f11095c; i11++) {
            View viewById = constraintLayout.getViewById(this.f11094b[i11]);
            if (viewById != null) {
                viewById.setVisibility(visibility);
                if (elevation > 0.0f) {
                    viewById.setTranslationZ(viewById.getTranslationZ() + elevation);
                }
            }
        }
    }

    public void c(ConstraintLayout constraintLayout) {
    }

    public boolean containsId(int i11) {
        for (int i12 : this.f11094b) {
            if (i12 == i11) {
                return true;
            }
        }
        return false;
    }

    public View[] d(ConstraintLayout constraintLayout) {
        View[] viewArr = this.mViews;
        if (viewArr == null || viewArr.length != this.f11095c) {
            this.mViews = new View[this.f11095c];
        }
        for (int i11 = 0; i11 < this.f11095c; i11++) {
            this.mViews[i11] = constraintLayout.getViewById(this.f11094b[i11]);
        }
        return this.mViews;
    }

    public void e(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f11099g = string;
                    setIds(string);
                } else if (index == R.styleable.ConstraintLayout_Layout_constraint_referenced_tags) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.f11100h = string2;
                    setReferenceTags(string2);
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f11094b, this.f11095c);
    }

    public int indexFromId(int i11) {
        int i12 = -1;
        for (int i13 : this.f11094b) {
            i12++;
            if (i13 == i11) {
                return i12;
            }
        }
        return i12;
    }

    public void loadParameters(ConstraintSet.Constraint constraint, HelperWidget helperWidget, ConstraintLayout.LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        ConstraintSet.Layout layout = constraint.layout;
        int[] iArr = layout.mReferenceIds;
        if (iArr != null) {
            setReferencedIds(iArr);
        } else {
            String str = layout.mReferenceIdString;
            if (str != null) {
                if (str.length() > 0) {
                    ConstraintSet.Layout layout2 = constraint.layout;
                    layout2.mReferenceIds = convertReferenceString(this, layout2.mReferenceIdString);
                } else {
                    constraint.layout.mReferenceIds = null;
                }
            }
        }
        if (helperWidget != null) {
            helperWidget.removeAllIds();
            if (constraint.layout.mReferenceIds != null) {
                int i11 = 0;
                while (true) {
                    int[] iArr2 = constraint.layout.mReferenceIds;
                    if (i11 < iArr2.length) {
                        ConstraintWidget constraintWidget = sparseArray.get(iArr2[i11]);
                        if (constraintWidget != null) {
                            helperWidget.add(constraintWidget);
                        }
                        i11++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f11099g;
        if (str != null) {
            setIds(str);
        }
        String str2 = this.f11100h;
        if (str2 != null) {
            setReferenceTags(str2);
        }
    }

    public void onDraw(Canvas canvas) {
    }

    public void onMeasure(int i11, int i12) {
        if (this.f11098f) {
            super.onMeasure(i11, i12);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public int removeView(View view) {
        int i11;
        int id2 = view.getId();
        int i12 = -1;
        if (id2 == -1) {
            return -1;
        }
        this.f11099g = null;
        int i13 = 0;
        while (true) {
            if (i13 >= this.f11095c) {
                break;
            } else if (this.f11094b[i13] == id2) {
                int i14 = i13;
                while (true) {
                    i11 = this.f11095c;
                    if (i14 >= i11 - 1) {
                        break;
                    }
                    int[] iArr = this.f11094b;
                    int i15 = i14 + 1;
                    iArr[i14] = iArr[i15];
                    i14 = i15;
                }
                this.f11094b[i11 - 1] = 0;
                this.f11095c = i11 - 1;
                i12 = i13;
            } else {
                i13++;
            }
        }
        requestLayout();
        return i12;
    }

    public void resolveRtl(ConstraintWidget constraintWidget, boolean z11) {
    }

    public void setIds(String str) {
        this.f11099g = str;
        if (str != null) {
            int i11 = 0;
            this.f11095c = 0;
            while (true) {
                int indexOf = str.indexOf(44, i11);
                if (indexOf == -1) {
                    addID(str.substring(i11));
                    return;
                } else {
                    addID(str.substring(i11, indexOf));
                    i11 = indexOf + 1;
                }
            }
        }
    }

    public void setReferenceTags(String str) {
        this.f11100h = str;
        if (str != null) {
            int i11 = 0;
            this.f11095c = 0;
            while (true) {
                int indexOf = str.indexOf(44, i11);
                if (indexOf == -1) {
                    addTag(str.substring(i11));
                    return;
                } else {
                    addTag(str.substring(i11, indexOf));
                    i11 = indexOf + 1;
                }
            }
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f11099g = null;
        this.f11095c = 0;
        for (int addRscID : iArr) {
            addRscID(addRscID);
        }
    }

    public void setTag(int i11, Object obj) {
        super.setTag(i11, obj);
        if (obj == null && this.f11099g == null) {
            addRscID(i11);
        }
    }

    public void updatePostConstraints(ConstraintLayout constraintLayout) {
    }

    public void updatePostLayout(ConstraintLayout constraintLayout) {
    }

    public void updatePostMeasure(ConstraintLayout constraintLayout) {
    }

    public void updatePreDraw(ConstraintLayout constraintLayout) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r1 = r5.f11101i.get(java.lang.Integer.valueOf(r1));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updatePreLayout(androidx.constraintlayout.widget.ConstraintLayout r6) {
        /*
            r5 = this;
            boolean r0 = r5.isInEditMode()
            if (r0 == 0) goto L_0x000b
            java.lang.String r0 = r5.f11099g
            r5.setIds(r0)
        L_0x000b:
            androidx.constraintlayout.core.widgets.Helper r0 = r5.f11097e
            if (r0 != 0) goto L_0x0010
            return
        L_0x0010:
            r0.removeAllIds()
            r0 = 0
        L_0x0014:
            int r1 = r5.f11095c
            if (r0 >= r1) goto L_0x0053
            int[] r1 = r5.f11094b
            r1 = r1[r0]
            android.view.View r2 = r6.getViewById(r1)
            if (r2 != 0) goto L_0x0045
            java.util.HashMap<java.lang.Integer, java.lang.String> r3 = r5.f11101i
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.Object r1 = r3.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            int r3 = r5.findId(r6, r1)
            if (r3 == 0) goto L_0x0045
            int[] r2 = r5.f11094b
            r2[r0] = r3
            java.util.HashMap<java.lang.Integer, java.lang.String> r2 = r5.f11101i
            java.lang.Integer r4 = java.lang.Integer.valueOf(r3)
            r2.put(r4, r1)
            android.view.View r2 = r6.getViewById(r3)
        L_0x0045:
            if (r2 == 0) goto L_0x0050
            androidx.constraintlayout.core.widgets.Helper r1 = r5.f11097e
            androidx.constraintlayout.core.widgets.ConstraintWidget r2 = r6.getViewWidget(r2)
            r1.add(r2)
        L_0x0050:
            int r0 = r0 + 1
            goto L_0x0014
        L_0x0053:
            androidx.constraintlayout.core.widgets.Helper r0 = r5.f11097e
            androidx.constraintlayout.core.widgets.ConstraintWidgetContainer r6 = r6.mLayoutWidget
            r0.updateConstraints(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintHelper.updatePreLayout(androidx.constraintlayout.widget.ConstraintLayout):void");
    }

    public void validateParams() {
        if (this.f11097e != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.LayoutParams) {
                ((ConstraintLayout.LayoutParams) layoutParams).f11124v = (ConstraintWidget) this.f11097e;
            }
        }
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11096d = context;
        e(attributeSet);
    }

    private int findId(ConstraintLayout constraintLayout, String str) {
        Resources resources;
        String str2;
        if (str == null || constraintLayout == null || (resources = this.f11096d.getResources()) == null) {
            return 0;
        }
        int childCount = constraintLayout.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = constraintLayout.getChildAt(i11);
            if (childAt.getId() != -1) {
                try {
                    str2 = resources.getResourceEntryName(childAt.getId());
                } catch (Resources.NotFoundException unused) {
                    str2 = null;
                }
                if (str.equals(str2)) {
                    return childAt.getId();
                }
            }
        }
        return 0;
    }

    public ConstraintHelper(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f11096d = context;
        e(attributeSet);
    }

    public void updatePreLayout(ConstraintWidgetContainer constraintWidgetContainer, Helper helper, SparseArray<ConstraintWidget> sparseArray) {
        helper.removeAllIds();
        for (int i11 = 0; i11 < this.f11095c; i11++) {
            helper.add(sparseArray.get(this.f11094b[i11]));
        }
    }
}
