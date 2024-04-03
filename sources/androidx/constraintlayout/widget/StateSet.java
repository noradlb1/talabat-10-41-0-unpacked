package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.SparseArray;
import android.util.Xml;
import java.util.ArrayList;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParser;

public class StateSet {
    private static final boolean DEBUG = false;
    public static final String TAG = "ConstraintLayoutStates";

    /* renamed from: a  reason: collision with root package name */
    public int f11194a = -1;

    /* renamed from: b  reason: collision with root package name */
    public int f11195b = -1;

    /* renamed from: c  reason: collision with root package name */
    public int f11196c = -1;
    private SparseArray<ConstraintSet> mConstraintSetMap = new SparseArray<>();
    private ConstraintsChangedListener mConstraintsChangedListener = null;
    private SparseArray<State> mStateList = new SparseArray<>();

    public static class State {

        /* renamed from: a  reason: collision with root package name */
        public int f11197a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<Variant> f11198b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        public int f11199c = -1;

        /* renamed from: d  reason: collision with root package name */
        public boolean f11200d;

        public State(Context context, XmlPullParser xmlPullParser) {
            this.f11200d = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.State);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.State_android_id) {
                    this.f11197a = obtainStyledAttributes.getResourceId(index, this.f11197a);
                } else if (index == R.styleable.State_constraints) {
                    this.f11199c = obtainStyledAttributes.getResourceId(index, this.f11199c);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f11199c);
                    context.getResources().getResourceName(this.f11199c);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.f11200d = true;
                    }
                }
            }
            obtainStyledAttributes.recycle();
        }

        public void a(Variant variant) {
            this.f11198b.add(variant);
        }

        public int findMatch(float f11, float f12) {
            for (int i11 = 0; i11 < this.f11198b.size(); i11++) {
                if (this.f11198b.get(i11).a(f11, f12)) {
                    return i11;
                }
            }
            return -1;
        }
    }

    public static class Variant {

        /* renamed from: a  reason: collision with root package name */
        public float f11201a = Float.NaN;

        /* renamed from: b  reason: collision with root package name */
        public float f11202b = Float.NaN;

        /* renamed from: c  reason: collision with root package name */
        public float f11203c = Float.NaN;

        /* renamed from: d  reason: collision with root package name */
        public float f11204d = Float.NaN;

        /* renamed from: e  reason: collision with root package name */
        public int f11205e = -1;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11206f;

        public Variant(Context context, XmlPullParser xmlPullParser) {
            this.f11206f = false;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlPullParser), R.styleable.Variant);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                if (index == R.styleable.Variant_constraints) {
                    this.f11205e = obtainStyledAttributes.getResourceId(index, this.f11205e);
                    String resourceTypeName = context.getResources().getResourceTypeName(this.f11205e);
                    context.getResources().getResourceName(this.f11205e);
                    if (TtmlNode.TAG_LAYOUT.equals(resourceTypeName)) {
                        this.f11206f = true;
                    }
                } else if (index == R.styleable.Variant_region_heightLessThan) {
                    this.f11204d = obtainStyledAttributes.getDimension(index, this.f11204d);
                } else if (index == R.styleable.Variant_region_heightMoreThan) {
                    this.f11202b = obtainStyledAttributes.getDimension(index, this.f11202b);
                } else if (index == R.styleable.Variant_region_widthLessThan) {
                    this.f11203c = obtainStyledAttributes.getDimension(index, this.f11203c);
                } else if (index == R.styleable.Variant_region_widthMoreThan) {
                    this.f11201a = obtainStyledAttributes.getDimension(index, this.f11201a);
                }
            }
            obtainStyledAttributes.recycle();
        }

        public boolean a(float f11, float f12) {
            if (!Float.isNaN(this.f11201a) && f11 < this.f11201a) {
                return false;
            }
            if (!Float.isNaN(this.f11202b) && f12 < this.f11202b) {
                return false;
            }
            if (!Float.isNaN(this.f11203c) && f11 > this.f11203c) {
                return false;
            }
            if (Float.isNaN(this.f11204d) || f12 <= this.f11204d) {
                return true;
            }
            return false;
        }
    }

    public StateSet(Context context, XmlPullParser xmlPullParser) {
        load(context, xmlPullParser);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void load(android.content.Context r9, org.xmlpull.v1.XmlPullParser r10) {
        /*
            r8 = this;
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r10)
            int[] r1 = androidx.constraintlayout.widget.R.styleable.StateSet
            android.content.res.TypedArray r0 = r9.obtainStyledAttributes(r0, r1)
            int r1 = r0.getIndexCount()
            r2 = 0
            r3 = r2
        L_0x0010:
            if (r3 >= r1) goto L_0x0025
            int r4 = r0.getIndex(r3)
            int r5 = androidx.constraintlayout.widget.R.styleable.StateSet_defaultState
            if (r4 != r5) goto L_0x0022
            int r5 = r8.f11194a
            int r4 = r0.getResourceId(r4, r5)
            r8.f11194a = r4
        L_0x0022:
            int r3 = r3 + 1
            goto L_0x0010
        L_0x0025:
            r0.recycle()
            int r0 = r10.getEventType()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            r1 = 0
        L_0x002d:
            r3 = 1
            if (r0 == r3) goto L_0x00a6
            if (r0 == 0) goto L_0x0095
            java.lang.String r4 = "StateSet"
            r5 = 3
            r6 = 2
            if (r0 == r6) goto L_0x0046
            if (r0 == r5) goto L_0x003b
            goto L_0x0098
        L_0x003b:
            java.lang.String r0 = r10.getName()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            boolean r0 = r4.equals(r0)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r0 == 0) goto L_0x0098
            return
        L_0x0046:
            java.lang.String r0 = r10.getName()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            int r7 = r0.hashCode()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            switch(r7) {
                case 80204913: goto L_0x006d;
                case 1301459538: goto L_0x0063;
                case 1382829617: goto L_0x005c;
                case 1901439077: goto L_0x0052;
                default: goto L_0x0051;
            }     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
        L_0x0051:
            goto L_0x0077
        L_0x0052:
            java.lang.String r3 = "Variant"
            boolean r0 = r0.equals(r3)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r0 == 0) goto L_0x0077
            r3 = r5
            goto L_0x0078
        L_0x005c:
            boolean r0 = r0.equals(r4)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r0 == 0) goto L_0x0077
            goto L_0x0078
        L_0x0063:
            java.lang.String r3 = "LayoutDescription"
            boolean r0 = r0.equals(r3)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r0 == 0) goto L_0x0077
            r3 = r2
            goto L_0x0078
        L_0x006d:
            java.lang.String r3 = "State"
            boolean r0 = r0.equals(r3)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r0 == 0) goto L_0x0077
            r3 = r6
            goto L_0x0078
        L_0x0077:
            r3 = -1
        L_0x0078:
            if (r3 == r6) goto L_0x0088
            if (r3 == r5) goto L_0x007d
            goto L_0x0098
        L_0x007d:
            androidx.constraintlayout.widget.StateSet$Variant r0 = new androidx.constraintlayout.widget.StateSet$Variant     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            r0.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            if (r1 == 0) goto L_0x0098
            r1.a(r0)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            goto L_0x0098
        L_0x0088:
            androidx.constraintlayout.widget.StateSet$State r1 = new androidx.constraintlayout.widget.StateSet$State     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            r1.<init>(r9, r10)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            android.util.SparseArray<androidx.constraintlayout.widget.StateSet$State> r0 = r8.mStateList     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            int r3 = r1.f11197a     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            r0.put(r3, r1)     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            goto L_0x0098
        L_0x0095:
            r10.getName()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
        L_0x0098:
            int r0 = r10.next()     // Catch:{ XmlPullParserException -> 0x00a2, IOException -> 0x009d }
            goto L_0x002d
        L_0x009d:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x00a6
        L_0x00a2:
            r9 = move-exception
            r9.printStackTrace()
        L_0x00a6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.StateSet.load(android.content.Context, org.xmlpull.v1.XmlPullParser):void");
    }

    public int convertToConstraintSet(int i11, int i12, float f11, float f12) {
        State state = this.mStateList.get(i12);
        if (state == null) {
            return i12;
        }
        if (f11 != -1.0f && f12 != -1.0f) {
            Iterator<Variant> it = state.f11198b.iterator();
            Variant variant = null;
            while (it.hasNext()) {
                Variant next = it.next();
                if (next.a(f11, f12)) {
                    if (i11 == next.f11205e) {
                        return i11;
                    }
                    variant = next;
                }
            }
            if (variant != null) {
                return variant.f11205e;
            }
            return state.f11199c;
        } else if (state.f11199c == i11) {
            return i11;
        } else {
            Iterator<Variant> it2 = state.f11198b.iterator();
            while (it2.hasNext()) {
                if (i11 == it2.next().f11205e) {
                    return i11;
                }
            }
            return state.f11199c;
        }
    }

    public boolean needsToChange(int i11, float f11, float f12) {
        Object obj;
        int i12 = this.f11195b;
        if (i12 != i11) {
            return true;
        }
        if (i11 == -1) {
            obj = this.mStateList.valueAt(0);
        } else {
            obj = this.mStateList.get(i12);
        }
        State state = (State) obj;
        int i13 = this.f11196c;
        if ((i13 == -1 || !state.f11198b.get(i13).a(f11, f12)) && this.f11196c != state.findMatch(f11, f12)) {
            return true;
        }
        return false;
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
    }

    public int stateGetConstraintID(int i11, int i12, int i13) {
        return updateConstraints(-1, i11, (float) i12, (float) i13);
    }

    public int updateConstraints(int i11, int i12, float f11, float f12) {
        State state;
        int findMatch;
        if (i11 == i12) {
            if (i12 == -1) {
                state = this.mStateList.valueAt(0);
            } else {
                state = this.mStateList.get(this.f11195b);
            }
            if (state == null) {
                return -1;
            }
            if ((this.f11196c != -1 && state.f11198b.get(i11).a(f11, f12)) || i11 == (findMatch = state.findMatch(f11, f12))) {
                return i11;
            }
            if (findMatch == -1) {
                return state.f11199c;
            }
            return state.f11198b.get(findMatch).f11205e;
        }
        State state2 = this.mStateList.get(i12);
        if (state2 == null) {
            return -1;
        }
        int findMatch2 = state2.findMatch(f11, f12);
        if (findMatch2 == -1) {
            return state2.f11199c;
        }
        return state2.f11198b.get(findMatch2).f11205e;
    }
}
