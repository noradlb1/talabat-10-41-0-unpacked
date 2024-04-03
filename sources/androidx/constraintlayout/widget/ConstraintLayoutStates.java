package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.Log;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import org.junit.jupiter.api.IndicativeSentencesGeneration;
import org.xmlpull.v1.XmlPullParser;

public class ConstraintLayoutStates {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";

    /* renamed from: a  reason: collision with root package name */
    public ConstraintSet f11133a;

    /* renamed from: b  reason: collision with root package name */
    public int f11134b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f11135c = -1;
    private final ConstraintLayout mConstraintLayout;
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    private SparseArray<State> mStateList = new SparseArray<>();

    public static class State {

        /* renamed from: a  reason: collision with root package name */
        public int f11136a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Variant> f11137b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public int f11138c = -1;

        /* renamed from: d  reason: collision with root package name */
        public ConstraintSet f11139d;

        public State(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.State_android_id) {
                    this.f11136a = obtainStyledAttributes.getResourceId(index, this.f11136a);
                } else if (index == R.styleable.State_constraints) {
                    this.f11138c = obtainStyledAttributes.getResourceId(index, this.f11138c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f11138c);
                    context.getResources().getResourceName(this.f11138c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f11139d = constraintSet;
                        constraintSet.clone(context, this.f11138c);
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(Variant variant) {
            this.f11137b.add(variant);
        }

        public int findMatch(float f11, float f12) {
            for (int i11 = 0; i11 < this.f11137b.size(); i11++) {
                if (this.f11137b.get(i11).a(f11, f12)) {
                    return i11;
                }
            }
            return -1;
        }
    }

    public static class Variant {

        /* renamed from: a  reason: collision with root package name */
        public float f11140a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        public float f11141b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        public float f11142c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        public float f11143d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        public int f11144e = -1;

        /* renamed from: f  reason: collision with root package name */
        public ConstraintSet f11145f;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.Variant_constraints) {
                    this.f11144e = obtainStyledAttributes.getResourceId(index, this.f11144e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f11144e);
                    context.getResources().getResourceName(this.f11144e);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.f11145f = constraintSet;
                        constraintSet.clone(context, this.f11144e);
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f11143d = obtainStyledAttributes.getDimension(index, this.f11143d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f11141b = obtainStyledAttributes.getDimension(index, this.f11141b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f11142c = obtainStyledAttributes.getDimension(index, this.f11142c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f11140a = obtainStyledAttributes.getDimension(index, this.f11140a);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean a(float f11, float f12) {
            if (!Float.isNaN(this.f11140a) && f11 < this.f11140a) {
                return false;
            }
            if (!Float.isNaN(this.f11141b) && f12 < this.f11141b) {
                return false;
            }
            if (!Float.isNaN(this.f11142c) && f11 > this.f11142c) {
                return false;
            }
            if (Float.isNaN(this.f11143d) || f12 <= this.f11143d) {
                return true;
            }
            return false;
        }
    }

    public ConstraintLayoutStates(Context context, ConstraintLayout constraintLayout, int i11) {
        this.mConstraintLayout = constraintLayout;
        load(context, i11);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r8, int r9) {
        /*
            r7 = this;
            android.content.res.Resources r0 = r8.getResources()
            android.content.res.XmlResourceParser r9 = r0.getXml(r9)
            int r0 = r9.getEventType()     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            r1 = 0
        L_0x000d:
            r2 = 1
            if (r0 == r2) goto L_0x008b
            if (r0 == 0) goto L_0x007a
            r3 = 2
            if (r0 == r3) goto L_0x0017
            goto L_0x007d
        L_0x0017:
            java.lang.String r0 = r9.getName()     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            int r4 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            r5 = 4
            r6 = 3
            switch(r4) {
                case -1349929691: goto L_0x004c;
                case 80204913: goto L_0x0042;
                case 1382829617: goto L_0x0039;
                case 1657696882: goto L_0x002f;
                case 1901439077: goto L_0x0025;
                default: goto L_0x0024;
            }     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
        L_0x0024:
            goto L_0x0056
        L_0x0025:
            java.lang.String r2 = "Variant"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            if (r0 == 0) goto L_0x0056
            r2 = r6
            goto L_0x0057
        L_0x002f:
            java.lang.String r2 = "layoutDescription"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            if (r0 == 0) goto L_0x0056
            r2 = 0
            goto L_0x0057
        L_0x0039:
            java.lang.String r4 = "StateSet"
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            if (r0 == 0) goto L_0x0056
            goto L_0x0057
        L_0x0042:
            java.lang.String r2 = "State"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            if (r0 == 0) goto L_0x0056
            r2 = r3
            goto L_0x0057
        L_0x004c:
            java.lang.String r2 = "ConstraintSet"
            boolean r0 = r0.equals(r2)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            if (r0 == 0) goto L_0x0056
            r2 = r5
            goto L_0x0057
        L_0x0056:
            r2 = -1
        L_0x0057:
            if (r2 == r3) goto L_0x006d
            if (r2 == r6) goto L_0x0062
            if (r2 == r5) goto L_0x005e
            goto L_0x007d
        L_0x005e:
            r7.parseConstraintSet(r8, r9)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            goto L_0x007d
        L_0x0062:
            androidx.constraintlayout.widget.ConstraintLayoutStates$Variant r0 = new androidx.constraintlayout.widget.ConstraintLayoutStates$Variant     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            r0.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            if (r1 == 0) goto L_0x007d
            r1.a(r0)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            goto L_0x007d
        L_0x006d:
            androidx.constraintlayout.widget.ConstraintLayoutStates$State r1 = new androidx.constraintlayout.widget.ConstraintLayoutStates$State     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            r1.<init>(r8, r9)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            android.util.SparseArray<androidx.constraintlayout.widget.ConstraintLayoutStates$State> r0 = r7.mStateList     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            int r2 = r1.f11136a     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            r0.put(r2, r1)     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            goto L_0x007d
        L_0x007a:
            r9.getName()     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
        L_0x007d:
            int r0 = r9.next()     // Catch:{ XmlPullParserException -> 0x0087, IOException -> 0x0082 }
            goto L_0x000d
        L_0x0082:
            r8 = move-exception
            r8.printStackTrace()
            goto L_0x008b
        L_0x0087:
            r8 = move-exception
            r8.printStackTrace()
        L_0x008b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayoutStates.load(android.content.Context, int):void");
    }

    private void parseConstraintSet(Context context, XmlPullParser xmlPullParser) {
        int i11;
        ConstraintSet constraintSet = new ConstraintSet();
        int attributeCount = xmlPullParser.getAttributeCount();
        int i12 = 0;
        while (i12 < attributeCount) {
            String attributeName = xmlPullParser.getAttributeName(i12);
            String attributeValue = xmlPullParser.getAttributeValue(i12);
            if (attributeName == null || attributeValue == null || !"id".equals(attributeName)) {
                i12++;
            } else {
                if (attributeValue.contains("/")) {
                    i11 = context.getResources().getIdentifier(attributeValue.substring(attributeValue.indexOf(47) + 1), "id", context.getPackageName());
                } else {
                    i11 = -1;
                }
                if (i11 == -1) {
                    if (attributeValue.length() > 1) {
                        i11 = Integer.parseInt(attributeValue.substring(1));
                    } else {
                        Log.e("ConstraintLayoutStates", "error in parsing id");
                    }
                }
                constraintSet.load(context, xmlPullParser);
                this.mConstraintSetMap.put(i11, constraintSet);
                return;
            }
        }
    }

    public boolean needsToChange(int i11, float f11, float f12) {
        Object obj;
        int i12 = this.f11134b;
        if (i12 != i11) {
            return true;
        }
        if (i11 == -1) {
            obj = this.mStateList.valueAt(0);
        } else {
            obj = this.mStateList.get(i12);
        }
        State state = (State) obj;
        int i13 = this.f11135c;
        if ((i13 == -1 || !state.f11137b.get(i13).a(f11, f12)) && this.f11135c != state.findMatch(f11, f12)) {
            return true;
        }
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public void updateConstraints(int i11, float f11, float f12) {
        ConstraintSet constraintSet;
        int i12;
        State state;
        int findMatch;
        ConstraintSet constraintSet2;
        int i13;
        int i14 = this.f11134b;
        if (i14 == i11) {
            if (i11 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(i14);
            }
            int i15 = this.f11135c;
            if ((i15 == -1 || !state.f11137b.get(i15).a(f11, f12)) && this.f11135c != (findMatch = state.findMatch(f11, f12))) {
                if (findMatch == -1) {
                    constraintSet2 = this.f11133a;
                } else {
                    constraintSet2 = state.f11137b.get(findMatch).f11145f;
                }
                if (findMatch == -1) {
                    i13 = state.f11138c;
                } else {
                    i13 = state.f11137b.get(findMatch).f11144e;
                }
                if (constraintSet2 != null) {
                    this.f11135c = findMatch;
                    ConstraintsChangedListener constraintsChangedListener = this.mConstraintsChangedListener;
                    if (constraintsChangedListener != null) {
                        constraintsChangedListener.preLayoutChange(-1, i13);
                    }
                    constraintSet2.applyTo(this.mConstraintLayout);
                    ConstraintsChangedListener constraintsChangedListener2 = this.mConstraintsChangedListener;
                    if (constraintsChangedListener2 != null) {
                        constraintsChangedListener2.postLayoutChange(-1, i13);
                        return;
                    }
                    return;
                }
                return;
            }
            return;
        }
        this.f11134b = i11;
        State state2 = this.mStateList.get(i11);
        int findMatch2 = state2.findMatch(f11, f12);
        if (findMatch2 == -1) {
            constraintSet = state2.f11139d;
        } else {
            constraintSet = state2.f11137b.get(findMatch2).f11145f;
        }
        if (findMatch2 == -1) {
            i12 = state2.f11138c;
        } else {
            i12 = state2.f11137b.get(findMatch2).f11144e;
        }
        if (constraintSet == null) {
            StringBuilder sb2 = new StringBuilder();
            sb2.append("NO Constraint set found ! id=");
            sb2.append(i11);
            sb2.append(", dim =");
            sb2.append(f11);
            sb2.append(IndicativeSentencesGeneration.DEFAULT_SEPARATOR);
            sb2.append(f12);
            return;
        }
        this.f11135c = findMatch2;
        ConstraintsChangedListener constraintsChangedListener3 = this.mConstraintsChangedListener;
        if (constraintsChangedListener3 != null) {
            constraintsChangedListener3.preLayoutChange(i11, i12);
        }
        constraintSet.applyTo(this.mConstraintLayout);
        ConstraintsChangedListener constraintsChangedListener4 = this.mConstraintsChangedListener;
        if (constraintsChangedListener4 != null) {
            constraintsChangedListener4.postLayoutChange(i11, i12);
        }
    }
}
