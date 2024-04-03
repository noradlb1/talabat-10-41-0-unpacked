package com.uxcam.internals;

import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.uxcam.datamodel.UXCamOccludeAllTextFields;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ge implements gd {
    public gf a(ViewGroup viewGroup, String str, List list, boolean z11, UXCamOccludeAllTextFields uXCamOccludeAllTextFields) {
        boolean z12;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        WeakReference weakReference = null;
        for (int i11 = 0; i11 < viewGroup.getChildCount(); i11++) {
            ViewGroup viewGroup2 = viewGroup;
            View childAt = viewGroup.getChildAt(i11);
            if (childAt instanceof ViewGroup) {
                if ((childAt instanceof WebView) && z11) {
                    weakReference = new WeakReference((WebView) childAt);
                }
                gf a11 = a((ViewGroup) childAt, str, list, z11, uXCamOccludeAllTextFields);
                arrayList.addAll(a11.f13432a);
                arrayList2.addAll(a11.f13433b);
                if (weakReference == null) {
                    weakReference = a11.f13434c;
                }
            } else if (childAt != null && (childAt instanceof TextView)) {
                int inputType = ((TextView) childAt).getInputType();
                Iterator it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        hn hnVar = (hn) it.next();
                        View view = (View) hnVar.f13590b.get();
                        if (view == null) {
                            arrayList2.add(hnVar);
                        } else if (view.equals(childAt)) {
                            break;
                        }
                    } else if (inputType == 128 || inputType == 129) {
                        hn hnVar2 = new hn(false);
                        hnVar2.f13590b = new WeakReference(childAt);
                        hnVar2.f13591c = true;
                        hnVar2.f13584o = str;
                        arrayList.add(hnVar2);
                    } else {
                        if (!(childAt instanceof EditText) || uXCamOccludeAllTextFields == null) {
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                        if (z12) {
                            hn hnVar3 = new hn(false);
                            hnVar3.f13590b = new WeakReference(childAt);
                            hnVar3.f13591c = true;
                            arrayList.add(hnVar3);
                        }
                    }
                }
            }
            String str2 = str;
        }
        return new gf(arrayList, arrayList2, weakReference);
    }
}
