package com.instabug.library.annotation.recognition;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private int f34121a;

    /* renamed from: b  reason: collision with root package name */
    private int f34122b;

    /* renamed from: c  reason: collision with root package name */
    private int f34123c;

    /* renamed from: d  reason: collision with root package name */
    private int f34124d;

    /* renamed from: e  reason: collision with root package name */
    private int f34125e;

    /* renamed from: f  reason: collision with root package name */
    private float f34126f;

    /* renamed from: g  reason: collision with root package name */
    private final Path f34127g;

    /* renamed from: h  reason: collision with root package name */
    private Paint f34128h;

    public a(Path path) {
        Paint paint = new Paint();
        this.f34128h = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.f34128h.setStrokeWidth(2.0f);
        Path a11 = f.a(path);
        this.f34127g = a11;
        a(a11);
    }

    private void a(Path path) {
        this.f34126f = new PathMeasure(path, false).getLength();
        Bitmap createBitmap = Bitmap.createBitmap(28, 28, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f34128h.setColor(-65536);
        canvas.drawPath(path, this.f34128h);
        int[] iArr = new int[784];
        createBitmap.getPixels(iArr, 0, 28, 0, 0, 28, 28);
        for (int i11 = 0; i11 < 784; i11++) {
            if (iArr[i11] == -65536) {
                this.f34121a++;
                if (i11 < 392) {
                    this.f34123c++;
                } else {
                    this.f34125e++;
                }
                if (i11 % 28 < 14) {
                    this.f34122b++;
                } else {
                    this.f34124d++;
                }
            }
        }
    }

    private List b(Path path) {
        ArrayList arrayList = new ArrayList();
        Path a11 = b.a();
        for (int i11 = 0; i11 < 36; i11++) {
            int i12 = i11 * 10;
            h a12 = a(f.a(a11, i12), path);
            a12.f34138c = i12;
            arrayList.add(a12);
        }
        return arrayList;
    }

    private h a(Path path, Path path2) {
        Bitmap createBitmap = Bitmap.createBitmap(28, 28, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        this.f34128h.setColor(ViewCompat.MEASURED_STATE_MASK);
        canvas.drawPath(path, this.f34128h);
        int[] iArr = new int[784];
        createBitmap.getPixels(iArr, 0, 28, 0, 0, 28, 28);
        int i11 = 0;
        for (int i12 = 0; i12 < 784; i12++) {
            if (iArr[i12] == -16777216) {
                i11++;
            }
        }
        this.f34128h.setColor(-2130706433);
        canvas.drawPath(path2, this.f34128h);
        int[] iArr2 = new int[784];
        createBitmap.getPixels(iArr2, 0, createBitmap.getWidth(), 0, 0, 28, 28);
        h hVar = new h();
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i13 = 0;
        for (int i14 = 0; i14 < 784; i14++) {
            int i15 = iArr2[i14];
            if (i15 == -8355712) {
                i13++;
            } else if (i15 == -2130706433) {
                f12 += 1.0f;
            } else if (i15 == -16777216) {
                f11 += 1.0f;
            }
        }
        hVar.f34137b = i13;
        float f13 = f12 / ((float) this.f34121a);
        hVar.f34142g = f13;
        float f14 = (float) i11;
        float f15 = f11 / f14;
        hVar.f34143h = f15;
        hVar.f34139d = ((((1.0f - f15) + 1.0f) - f13) + (((float) i13) / f14)) / 3.0f;
        hVar.f34144i = this.f34122b;
        hVar.f34145j = this.f34123c;
        hVar.f34146k = this.f34124d;
        hVar.f34147l = this.f34125e;
        hVar.f34148m = this.f34126f;
        return hVar;
    }

    private List a(e eVar, int i11, int i12, int i13) {
        ArrayList arrayList = new ArrayList();
        List<d> a11 = b.a(eVar);
        if (a11 != null && !a11.isEmpty()) {
            for (d dVar : a11) {
                for (int i14 = i11; i14 < i12; i14++) {
                    int i15 = i14 * i13;
                    h a12 = a(f.a(dVar.f34134a, i15), this.f34127g);
                    a12.f34138c = i15;
                    a12.f34141f = dVar.f34135b;
                    arrayList.add(a12);
                    if (eVar == e.OVAL && dVar.f34135b == 0.0f) {
                        break;
                    }
                }
            }
        }
        return arrayList;
    }

    public h a(e eVar) {
        List a11 = a(eVar, 0, 18, 10);
        h hVar = (h) Collections.max(a11);
        hVar.f34140e = a(a11);
        return hVar;
    }

    public h a() {
        h hVar;
        List b11 = b(this.f34127g);
        h hVar2 = (h) Collections.max(b11);
        int i11 = hVar2.f34138c;
        if ((i11 >= 0 && i11 <= 20) || ((i11 <= 360 && i11 >= 340) || ((i11 >= 160 && i11 <= 200) || ((i11 > 180 && hVar2.a() == g.TOP) || (hVar2.f34138c < 180 && hVar2.a() == g.BOTTOM))))) {
            return hVar2;
        }
        int i12 = hVar2.f34138c;
        if (i12 < 180) {
            hVar = (h) b11.get((i12 + 180) / 10);
        } else {
            hVar = (h) b11.get((i12 - 180) / 10);
        }
        hVar.f34140e = a(b11);
        return hVar;
    }

    private float a(List list) {
        Iterator it = list.iterator();
        float f11 = 0.0f;
        while (it.hasNext()) {
            f11 += ((h) it.next()).f34139d;
        }
        return f11 / ((float) list.size());
    }
}
