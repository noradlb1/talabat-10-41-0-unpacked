package com.instabug.library.annotation.recognition;

import android.graphics.Path;
import androidx.annotation.Nullable;

public class c {

    public static class a {
        @Nullable

        /* renamed from: a  reason: collision with root package name */
        public e f34131a;

        /* renamed from: b  reason: collision with root package name */
        public int f34132b;

        /* renamed from: c  reason: collision with root package name */
        public float f34133c;
    }

    public a a(Path path) {
        a aVar = new a();
        a aVar2 = new a(path);
        e eVar = e.OVAL;
        h a11 = aVar2.a(eVar);
        h a12 = aVar2.a();
        e eVar2 = e.RECT;
        h a13 = aVar2.a(eVar2);
        float f11 = a12.f34139d;
        float f12 = a13.f34139d;
        if (f11 <= f12 || f11 <= a11.f34139d) {
            if (f12 > a11.f34139d) {
                if (a13.f34142g > 0.5f || a13.f34143h > 0.5f) {
                    aVar.f34131a = e.NONE;
                } else {
                    aVar.f34131a = eVar2;
                    aVar.f34132b = a13.f34138c;
                    aVar.f34133c = a13.f34141f;
                }
            } else if (a11.f34142g > 0.5f || a11.f34143h > 0.5f) {
                aVar.f34131a = e.NONE;
            } else {
                aVar.f34131a = eVar;
                aVar.f34132b = a11.f34138c;
                aVar.f34133c = a11.f34141f;
            }
        } else if (a12.f34142g > 0.5f || a12.f34143h > 0.5f) {
            aVar.f34131a = e.NONE;
        } else if (a12.f34148m < 100.0f) {
            if (Math.abs(a12.f34145j - a12.f34147l) >= 10 || Math.abs(a12.f34146k - a12.f34144i) >= 10) {
                aVar.f34131a = e.ARROW;
            } else {
                aVar.f34131a = e.LINE;
            }
            aVar.f34132b = a12.f34138c;
        } else {
            aVar.f34131a = e.NONE;
        }
        return aVar;
    }
}
