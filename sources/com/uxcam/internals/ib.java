package com.uxcam.internals;

import android.app.Activity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.uxcam.datamodel.UXCamOcclusion;
import com.uxcam.internals.eu;
import com.uxcam.internals.fi;
import com.uxcam.internals.gu;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlinx.coroutines.DebugKt;

public class ib extends ScaleGestureDetector.SimpleOnScaleGestureListener implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    /* renamed from: d  reason: collision with root package name */
    public static final String f13620d = "ib";

    /* renamed from: a  reason: collision with root package name */
    public eu f13621a;

    /* renamed from: b  reason: collision with root package name */
    public String f13622b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f13623c = new ArrayList();

    public class aa implements eu.aa {
        public aa(ib ibVar) {
        }

        public void a(List list) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((cq) it.next()).f13162k = true;
                String str = hb.f13524g;
            }
            HashMap hashMap = new HashMap();
            Float valueOf = Float.valueOf(String.format(Locale.ENGLISH, "%.3f", new Object[]{Float.valueOf(((cq) list.get(0)).f13154c - hb.f13525h)}));
            hashMap.put("activity", ((cq) list.get(0)).f13152a);
            hb.c().a("rageTap", valueOf.floatValue(), (Map) hashMap);
        }
    }

    public ib() {
        int[] iArr = gm.f13474w;
        this.f13621a = new eu(iArr[0], ((float) iArr[1]) / 1000.0f, (int) ia.a((float) iArr[2], ia.b()), new aa(this));
    }

    public final void a(cq cqVar, gz gzVar) {
        fi fiVar;
        int i11;
        ArrayList arrayList;
        fi.aa aaVar;
        String str;
        eu.aa aaVar2;
        if (!gzVar.f13520e) {
            gzVar.f13518c.add(cqVar);
        }
        int i12 = cqVar.f13153b;
        if (i12 == 0 || i12 == 1) {
            eu euVar = this.f13621a;
            if (euVar.f13299e.isEmpty()) {
                euVar.a(cqVar);
            } else {
                ArrayList arrayList2 = euVar.f13299e;
                cq cqVar2 = (cq) arrayList2.get(arrayList2.size() - 1);
                int i13 = cqVar.f13155d - cqVar2.f13155d;
                int i14 = cqVar.f13156e - cqVar2.f13156e;
                float sqrt = (float) Math.sqrt((double) ((i14 * i14) + (i13 * i13)));
                float f11 = cqVar.f13154c - cqVar2.f13154c;
                int i15 = cqVar2.f13153b;
                if ((i15 == 0 && sqrt <= ((float) euVar.f13297c) && f11 <= euVar.f13296b) || (i15 == 1 && sqrt <= ((float) (euVar.f13297c * 2)) && f11 <= euVar.f13296b * 2.0f)) {
                    euVar.a(cqVar);
                } else {
                    if (euVar.f13300f >= euVar.f13295a && (aaVar2 = euVar.f13298d) != null) {
                        ((aa) aaVar2).a(euVar.f13299e);
                    }
                    euVar.f13299e = new ArrayList();
                    euVar.f13300f = 0;
                    euVar.a(cqVar);
                }
            }
        }
        ArrayList arrayList3 = fj.f13339g;
        if (!arrayList3.isEmpty()) {
            hr hrVar = (hr) arrayList3.get(arrayList3.size() - 1);
            if (hrVar.f13590b.get() != null) {
                View view = (View) hrVar.f13590b.get();
                try {
                    fi.aa aaVar3 = new fi.aa();
                    aaVar3.f13327b = view.getId();
                    String str2 = ia.f13615a;
                    try {
                        str = view.getResources().getResourceName(view.getId());
                    } catch (Exception unused) {
                        str = "";
                    }
                    aaVar3.f13328c = str;
                    aaVar3.f13329d = hrVar.f13589a;
                    aaVar3.f13332g = ia.d();
                    aaVar3.f13333h = hrVar.f13592d;
                    aaVar = aaVar3.a((Class) view.getClass());
                    aaVar.f13335j = hrVar;
                } catch (Exception e11) {
                    e11.printStackTrace();
                    aaVar = null;
                }
                a(view, aaVar);
                aaVar.f13337l = "onTouchEvent";
                fiVar = new fi(aaVar);
                boolean z11 = gm.B;
                i11 = cqVar.f13153b;
                if (i11 != 10 || !z11) {
                    cqVar.f13160i = Boolean.TRUE;
                } else if (fiVar != null && z11) {
                    cqVar.f13163l = fiVar;
                    if (i11 == 0 || i11 == 1 || i11 == 6) {
                        hr hrVar2 = fiVar.f13321g;
                        if (hrVar2.f13593e || hrVar2.f13601m) {
                            cqVar.f13160i = Boolean.valueOf(hrVar2.f13594f);
                        }
                    } else if (cqVar.b() || cqVar.f13153b == 11) {
                        cqVar.f13163l = fiVar;
                        hr hrVar3 = fiVar.f13321g;
                        boolean z12 = hrVar3.f13595g;
                        boolean z13 = hrVar3.f13596h;
                        boolean z14 = hrVar3.f13597i;
                        boolean z15 = hrVar3.f13598j;
                        int i16 = cqVar.f13153b;
                        if (i16 == 2 && z12) {
                            cqVar.f13160i = Boolean.TRUE;
                        } else if (i16 == 3 && z13) {
                            cqVar.f13160i = Boolean.TRUE;
                        } else if (i16 == 4 && z15) {
                            cqVar.f13160i = Boolean.TRUE;
                        } else if (i16 == 5 && z14) {
                            cqVar.f13160i = Boolean.TRUE;
                        } else if (i16 == 11) {
                            cqVar.f13160i = Boolean.TRUE;
                        }
                    }
                    if (cqVar.b() && (arrayList = gzVar.f13518c) != null && arrayList.size() > 1) {
                        ArrayList arrayList4 = gzVar.f13518c;
                        cq cqVar3 = (cq) arrayList4.get(arrayList4.size() - 2);
                        if (cqVar3.f13153b == 11) {
                            cqVar3.f13163l = null;
                            cqVar3.f13160i = cqVar.f13160i;
                        }
                    }
                    cqVar.toString();
                    gu.ab a11 = gu.a("screenaction77");
                    int i17 = cqVar.f13153b;
                    switch (i17) {
                        case 0:
                        case 1:
                        case 2:
                        case 3:
                        case 4:
                        case 5:
                        case 6:
                        case 10:
                        case 11:
                        case 12:
                            break;
                        default:
                            Integer.toString(i17);
                            break;
                    }
                    a11.getClass();
                    return;
                } else {
                    return;
                }
            }
        }
        fiVar = null;
        boolean z112 = gm.B;
        i11 = cqVar.f13153b;
        if (i11 != 10) {
        }
        cqVar.f13160i = Boolean.TRUE;
    }

    public void b() {
        eu.aa aaVar;
        eu euVar = this.f13621a;
        if (euVar.f13300f >= euVar.f13295a && (aaVar = euVar.f13298d) != null) {
            ((aa) aaVar).a(euVar.f13299e);
        }
    }

    public boolean onDoubleTap(MotionEvent motionEvent) {
        a(1, motionEvent.getRawX(), motionEvent.getRawY());
        return false;
    }

    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    public boolean onDown(MotionEvent motionEvent) {
        if (motionEvent != null) {
            motionEvent.getRawX();
            motionEvent.getRawY();
            if (!this.f13623c.isEmpty()) {
                cq a11 = ((cq) this.f13623c.get(0)).a();
                a11.f13153b = 11;
                a11.f13164m = this.f13623c;
                a11.c();
                a(a11);
                this.f13623c = new ArrayList();
            }
        }
        fj.a();
        return false;
    }

    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        int a11 = a(motionEvent.getRawX(), motionEvent.getRawY(), motionEvent2.getRawX(), motionEvent2.getRawY());
        if (a11 == 2 && Math.abs(f12) > 1.0f) {
            a(3, motionEvent2.getRawX(), motionEvent2.getRawY());
            return false;
        } else if (a11 == 1 && Math.abs(f12) > 1.0f) {
            a(2, motionEvent2.getRawX(), motionEvent2.getRawY());
            return false;
        } else if (a11 == 4 && Math.abs(f11) > 1.0f) {
            a(5, motionEvent2.getRawX(), motionEvent2.getRawY());
            return false;
        } else if (a11 != 3 || Math.abs(f11) <= 1.0f) {
            return false;
        } else {
            a(4, motionEvent2.getRawX(), motionEvent2.getRawY());
            return false;
        }
    }

    public void onLongPress(MotionEvent motionEvent) {
        if (motionEvent != null) {
            a(6, motionEvent.getRawX(), motionEvent.getRawY());
        }
    }

    public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        return false;
    }

    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f11, float f12) {
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        if (this.f13623c.isEmpty()) {
            a(12, motionEvent.getRawX(), motionEvent.getRawY());
        }
        a(12, motionEvent2.getRawX(), motionEvent2.getRawY());
        return false;
    }

    public void onShowPress(MotionEvent motionEvent) {
    }

    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        if (motionEvent != null) {
            a(0, motionEvent.getRawX(), motionEvent.getRawY());
        }
        return false;
    }

    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0049, code lost:
        if (r0 != 3) goto L_0x005d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (r0 != 3) goto L_0x005d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int a() {
        /*
            android.content.Context r0 = com.uxcam.internals.ia.f13617c
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            int r0 = r0.getRotation()
            android.content.Context r2 = com.uxcam.internals.ia.f13617c
            java.lang.Object r1 = r2.getSystemService(r1)
            android.view.WindowManager r1 = (android.view.WindowManager) r1
            android.content.res.Resources r2 = r2.getResources()
            android.content.res.Configuration r2 = r2.getConfiguration()
            android.view.Display r1 = r1.getDefaultDisplay()
            int r1 = r1.getRotation()
            r3 = 3
            r4 = 1
            r5 = 2
            if (r1 == 0) goto L_0x0031
            if (r1 != r5) goto L_0x0035
        L_0x0031:
            int r6 = r2.orientation
            if (r6 == r5) goto L_0x0040
        L_0x0035:
            if (r1 == r4) goto L_0x0039
            if (r1 != r3) goto L_0x003e
        L_0x0039:
            int r1 = r2.orientation
            if (r1 != r4) goto L_0x003e
            goto L_0x0040
        L_0x003e:
            r1 = r4
            goto L_0x0041
        L_0x0040:
            r1 = r5
        L_0x0041:
            if (r1 != r4) goto L_0x004c
            if (r0 == 0) goto L_0x0057
            if (r0 == r4) goto L_0x005b
            if (r0 == r5) goto L_0x005e
            if (r0 == r3) goto L_0x0059
            goto L_0x005d
        L_0x004c:
            if (r1 != r5) goto L_0x005d
            if (r0 == 0) goto L_0x005b
            if (r0 == r4) goto L_0x005e
            if (r0 == r5) goto L_0x0059
            if (r0 == r3) goto L_0x0057
            goto L_0x005d
        L_0x0057:
            r3 = r4
            goto L_0x005e
        L_0x0059:
            r3 = r5
            goto L_0x005e
        L_0x005b:
            r3 = 0
            goto L_0x005e
        L_0x005d:
            r3 = -1
        L_0x005e:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uxcam.internals.ib.a():int");
    }

    public static void a(View view, fi.aa aaVar) {
        boolean z11 = view instanceof Button;
        if ((z11 || (view instanceof ImageButton) || view.getClass().getName().contains("ActionMenuItemView")) && !(view instanceof CompoundButton)) {
            String charSequence = z11 ? ((Button) view).getText().toString() : "";
            aaVar.f13326a = 1;
            aaVar.a(charSequence).f13335j = new hr(view);
        } else if (view instanceof EditText) {
            aaVar.f13326a = 2;
            aaVar.f13335j = new hr(view);
        } else if (view instanceof CompoundButton) {
            aaVar.f13326a = 3;
            aaVar.f13331f = ((CompoundButton) view).isChecked() ? DebugKt.DEBUG_PROPERTY_VALUE_ON : DebugKt.DEBUG_PROPERTY_VALUE_OFF;
            aaVar.f13335j = new hr(view);
        } else if (view instanceof SeekBar) {
            aaVar.f13326a = 4;
            aaVar.f13331f = String.valueOf(((SeekBar) view).getProgress());
            aaVar.f13335j = new hr(view);
        } else if (view instanceof ViewGroup) {
            ArrayList arrayList = new ArrayList();
            a((ViewGroup) view, arrayList);
            if (new hr(view).a()) {
                aaVar.f13326a = 6;
                aaVar.f13336k = arrayList;
                return;
            }
            aaVar.f13326a = 5;
            aaVar.f13336k = arrayList;
        } else if (view instanceof TextView) {
            String charSequence2 = ((TextView) view).getText().toString();
            aaVar.f13326a = 7;
            aaVar.a(charSequence2).f13335j = new hr(view);
        } else {
            aaVar.f13326a = -1;
            aaVar.a("UnknownView");
        }
    }

    public static void a(ViewGroup viewGroup, ArrayList arrayList) {
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, arrayList);
            } else {
                arrayList.add(new hr(childAt));
            }
        }
    }

    public void a(int i11, float f11, float f12) {
        int i12;
        UXCamOcclusion b11;
        try {
            if (!ee.c(hb.f13528k) || (b11 = ee.b(hb.f13528k)) == null || !b11.isWithoutGesture()) {
                int i13 = (int) f11;
                int i14 = (int) f12;
                cq cqVar = new cq(i11, ia.d(), i13, i14, i13, i14);
                int i15 = hb.f13526i;
                boolean z11 = false;
                cqVar.f13155d -= 0;
                cqVar.f13156e -= i15;
                Iterator it = cqVar.f13164m.iterator();
                while (it.hasNext()) {
                    cq cqVar2 = (cq) it.next();
                    cqVar2.f13155d -= 0;
                    cqVar2.f13156e -= i15;
                }
                Activity activity = (Activity) ia.c();
                if (activity.getWindow() != null) {
                    activity.getWindow().getDecorView().getLocationOnScreen(new int[2]);
                    cqVar.f13156e = cqVar.f13156e;
                    cqVar.f13155d = cqVar.f13155d;
                }
                cqVar.f13159h = a();
                if (cqVar.f13153b == 12) {
                    this.f13623c.add(cqVar);
                    return;
                }
                if (!this.f13623c.isEmpty() && ((i12 = cqVar.f13153b) == 2 || i12 == 3 || i12 == 4 || i12 == 5)) {
                    cq a11 = ((cq) this.f13623c.get(0)).a();
                    a11.f13164m = this.f13623c;
                    a11.c();
                    a11.f13153b = 11;
                    a(a11);
                    ArrayList arrayList = this.f13623c;
                    cq a12 = ((cq) arrayList.get(arrayList.size() - 1)).a();
                    a12.f13153b = cqVar.f13153b;
                    a12.f13157f = a11.f13155d;
                    a12.f13158g = a11.f13156e;
                    a(a12);
                    this.f13623c = new ArrayList();
                    z11 = true;
                } else if (!this.f13623c.isEmpty()) {
                    cq a13 = ((cq) this.f13623c.get(0)).a();
                    ArrayList arrayList2 = this.f13623c;
                    cq a14 = ((cq) arrayList2.get(arrayList2.size() - 1)).a();
                    try {
                        int a15 = a((float) a13.f13155d, (float) a13.f13156e, (float) a14.f13155d, (float) a14.f13156e);
                        if (a15 == 2) {
                            a13.f13153b = 3;
                        } else if (a15 == 1) {
                            a13.f13153b = 2;
                        } else if (a15 == 4) {
                            a13.f13153b = 5;
                        } else if (a15 == 3) {
                            a13.f13153b = 4;
                        }
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    cq a16 = ((cq) this.f13623c.get(0)).a();
                    a16.f13153b = 11;
                    a16.f13164m = this.f13623c;
                    a16.c();
                    a(a16);
                    this.f13623c = new ArrayList();
                }
                gu.f13504c.getClass();
                if (!z11) {
                    a(cqVar);
                }
            }
        } catch (Exception unused) {
            gu.a(f13620d).getClass();
        }
    }

    public final void a(cq cqVar) {
        boolean z11;
        if (hb.f13525h > 0.0f || !gm.f13457f || cqVar.f13153b == 10) {
            cqVar.f13152a = this.f13622b;
            if (cqVar.f13153b != 10) {
                int i11 = cqVar.f13157f;
                int i12 = cqVar.f13158g;
                Iterator it = fn.f13382m.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z11 = false;
                        break;
                    }
                    hn hnVar = (hn) it.next();
                    if (hnVar.f13590b.get() != null && hnVar.f13591c) {
                        View view = (View) hnVar.f13590b.get();
                        int[] iArr = new int[2];
                        view.getLocationOnScreen(iArr);
                        int i13 = iArr[0];
                        int i14 = iArr[1];
                        boolean z12 = i11 >= i13 && i11 <= view.getWidth() + i13 && i12 >= i14 && i12 <= view.getHeight() + i14;
                        if (cqVar.f13152a.equals(hnVar.f13584o) && z12) {
                            z11 = true;
                            break;
                        }
                    }
                }
                if (z11) {
                    return;
                }
            }
            ArrayList arrayList = hb.c().f13530a;
            gz gzVar = (gz) arrayList.get(arrayList.size() - 1);
            float f11 = cqVar.f13154c - gzVar.f13517b;
            if (f11 >= 1.0f || cqVar.f13153b == 10) {
                a(cqVar, gzVar);
                return;
            }
            int indexOf = arrayList.indexOf(gzVar) - 1;
            if (indexOf >= 0) {
                cqVar.a(cqVar.f13154c - f11);
                cqVar.f13155d += 0;
                cqVar.f13156e += hb.f13526i;
                a(cqVar, (gz) hb.c().f13530a.get(indexOf));
            }
        }
    }

    public final int a(float f11, float f12, float f13, float f14) {
        double atan2 = ((((Math.atan2((double) (f12 - f14), (double) (f13 - f11)) + 3.141592653589793d) * 180.0d) / 3.141592653589793d) + 180.0d) % 360.0d;
        if (ic.a(atan2, 45.0f, 135.0f)) {
            return 1;
        }
        if (ic.a(atan2, 0.0f, 45.0f) || ic.a(atan2, 315.0f, 360.0f)) {
            return 4;
        }
        return ic.a(atan2, 225.0f, 315.0f) ? 2 : 3;
    }
}
