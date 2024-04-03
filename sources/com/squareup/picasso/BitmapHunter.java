package com.squareup.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.NetworkInfo;
import com.newrelic.agent.android.instrumentation.BitmapFactoryInstrumentation;
import com.newrelic.agent.android.instrumentation.Instrumented;
import com.squareup.picasso.NetworkRequestHandler;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.RequestHandler;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

@Instrumented
class BitmapHunter implements Runnable {
    private static final Object DECODE_LOCK = new Object();
    private static final RequestHandler ERRORING_HANDLER = new RequestHandler() {
        public boolean canHandleRequest(Request request) {
            return true;
        }

        public RequestHandler.Result load(Request request, int i11) throws IOException {
            throw new IllegalStateException("Unrecognized type of request: " + request);
        }
    };
    private static final ThreadLocal<StringBuilder> NAME_BUILDER = new ThreadLocal<StringBuilder>() {
        /* renamed from: a */
        public StringBuilder initialValue() {
            return new StringBuilder("Picasso-");
        }
    };
    private static final AtomicInteger SEQUENCE_GENERATOR = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public final int f53371b = SEQUENCE_GENERATOR.incrementAndGet();

    /* renamed from: c  reason: collision with root package name */
    public final Picasso f53372c;

    /* renamed from: d  reason: collision with root package name */
    public final Dispatcher f53373d;

    /* renamed from: e  reason: collision with root package name */
    public final Cache f53374e;

    /* renamed from: f  reason: collision with root package name */
    public final Stats f53375f;

    /* renamed from: g  reason: collision with root package name */
    public final String f53376g;

    /* renamed from: h  reason: collision with root package name */
    public final Request f53377h;

    /* renamed from: i  reason: collision with root package name */
    public final int f53378i;

    /* renamed from: j  reason: collision with root package name */
    public int f53379j;

    /* renamed from: k  reason: collision with root package name */
    public final RequestHandler f53380k;

    /* renamed from: l  reason: collision with root package name */
    public Action f53381l;

    /* renamed from: m  reason: collision with root package name */
    public List<Action> f53382m;

    /* renamed from: n  reason: collision with root package name */
    public Bitmap f53383n;

    /* renamed from: o  reason: collision with root package name */
    public Future<?> f53384o;

    /* renamed from: p  reason: collision with root package name */
    public Picasso.LoadedFrom f53385p;

    /* renamed from: q  reason: collision with root package name */
    public Exception f53386q;

    /* renamed from: r  reason: collision with root package name */
    public int f53387r;

    /* renamed from: s  reason: collision with root package name */
    public int f53388s;

    /* renamed from: t  reason: collision with root package name */
    public Picasso.Priority f53389t;

    public BitmapHunter(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action, RequestHandler requestHandler) {
        this.f53372c = picasso;
        this.f53373d = dispatcher;
        this.f53374e = cache;
        this.f53375f = stats;
        this.f53381l = action;
        this.f53376g = action.b();
        this.f53377h = action.g();
        this.f53389t = action.f();
        this.f53378i = action.c();
        this.f53379j = action.d();
        this.f53380k = requestHandler;
        this.f53388s = requestHandler.d();
    }

    public static Bitmap a(List<Transformation> list, Bitmap bitmap) {
        int size = list.size();
        int i11 = 0;
        while (i11 < size) {
            final Transformation transformation = list.get(i11);
            try {
                Bitmap transform = transformation.transform(bitmap);
                if (transform == null) {
                    final StringBuilder sb2 = new StringBuilder();
                    sb2.append("Transformation ");
                    sb2.append(transformation.key());
                    sb2.append(" returned null after ");
                    sb2.append(i11);
                    sb2.append(" previous transformation(s).\n\nTransformation list:\n");
                    for (Transformation key : list) {
                        sb2.append(key.key());
                        sb2.append(10);
                    }
                    Picasso.f53431l.post(new Runnable() {
                        public void run() {
                            throw new NullPointerException(sb2.toString());
                        }
                    });
                    return null;
                } else if (transform == bitmap && bitmap.isRecycled()) {
                    Picasso.f53431l.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + transformation.key() + " returned input Bitmap but recycled it.");
                        }
                    });
                    return null;
                } else if (transform == bitmap || bitmap.isRecycled()) {
                    i11++;
                    bitmap = transform;
                } else {
                    Picasso.f53431l.post(new Runnable() {
                        public void run() {
                            throw new IllegalStateException("Transformation " + transformation.key() + " mutated input Bitmap but failed to recycle the original.");
                        }
                    });
                    return null;
                }
            } catch (RuntimeException e11) {
                Picasso.f53431l.post(new Runnable() {
                    public void run() {
                        throw new RuntimeException("Transformation " + transformation.key() + " crashed with exception.", e11);
                    }
                });
                return null;
            }
        }
        return bitmap;
    }

    private Picasso.Priority computeNewPriority() {
        boolean z11;
        Picasso.Priority priority = Picasso.Priority.LOW;
        List<Action> list = this.f53382m;
        boolean z12 = true;
        if (list == null || list.isEmpty()) {
            z11 = false;
        } else {
            z11 = true;
        }
        Action action = this.f53381l;
        if (action == null && !z11) {
            z12 = false;
        }
        if (!z12) {
            return priority;
        }
        if (action != null) {
            priority = action.f();
        }
        if (z11) {
            int size = this.f53382m.size();
            for (int i11 = 0; i11 < size; i11++) {
                Picasso.Priority f11 = this.f53382m.get(i11).f();
                if (f11.ordinal() > priority.ordinal()) {
                    priority = f11;
                }
            }
        }
        return priority;
    }

    public static Bitmap d(Source source, Request request) throws IOException {
        BufferedSource buffer = Okio.buffer(source);
        boolean s11 = Utils.s(buffer);
        boolean z11 = request.purgeable;
        BitmapFactory.Options c11 = RequestHandler.c(request);
        boolean e11 = RequestHandler.e(c11);
        if (!s11) {
            InputStream inputStream = buffer.inputStream();
            if (e11) {
                MarkableInputStream markableInputStream = new MarkableInputStream(inputStream);
                markableInputStream.allowMarksToExpire(false);
                long savePosition = markableInputStream.savePosition(1024);
                BitmapFactoryInstrumentation.decodeStream(markableInputStream, (Rect) null, c11);
                RequestHandler.b(request.targetWidth, request.targetHeight, c11, request);
                markableInputStream.reset(savePosition);
                markableInputStream.allowMarksToExpire(true);
                inputStream = markableInputStream;
            }
            Bitmap decodeStream = BitmapFactoryInstrumentation.decodeStream(inputStream, (Rect) null, c11);
            if (decodeStream != null) {
                return decodeStream;
            }
            throw new IOException("Failed to decode stream.");
        }
        byte[] readByteArray = buffer.readByteArray();
        if (e11) {
            BitmapFactoryInstrumentation.decodeByteArray(readByteArray, 0, readByteArray.length, c11);
            RequestHandler.b(request.targetWidth, request.targetHeight, c11, request);
        }
        return BitmapFactoryInstrumentation.decodeByteArray(readByteArray, 0, readByteArray.length, c11);
    }

    public static BitmapHunter f(Picasso picasso, Dispatcher dispatcher, Cache cache, Stats stats, Action action) {
        Request g11 = action.g();
        List<RequestHandler> e11 = picasso.e();
        int size = e11.size();
        for (int i11 = 0; i11 < size; i11++) {
            RequestHandler requestHandler = e11.get(i11);
            if (requestHandler.canHandleRequest(g11)) {
                return new BitmapHunter(picasso, dispatcher, cache, stats, action, requestHandler);
            }
        }
        return new BitmapHunter(picasso, dispatcher, cache, stats, action, ERRORING_HANDLER);
    }

    public static int k(int i11) {
        switch (i11) {
            case 3:
            case 4:
                return 180;
            case 5:
            case 6:
                return 90;
            case 7:
            case 8:
                return 270;
            default:
                return 0;
        }
    }

    public static int l(int i11) {
        return (i11 == 2 || i11 == 7 || i11 == 4 || i11 == 5) ? -1 : 1;
    }

    private static boolean shouldResize(boolean z11, int i11, int i12, int i13, int i14) {
        return !z11 || (i13 != 0 && i11 > i13) || (i14 != 0 && i12 > i14);
    }

    /* JADX WARNING: Removed duplicated region for block: B:87:0x024b  */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x024f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.graphics.Bitmap w(com.squareup.picasso.Request r26, android.graphics.Bitmap r27, int r28) {
        /*
            r0 = r26
            int r1 = r27.getWidth()
            int r2 = r27.getHeight()
            boolean r3 = r0.onlyScaleDown
            android.graphics.Matrix r9 = new android.graphics.Matrix
            r9.<init>()
            boolean r4 = r26.d()
            if (r4 != 0) goto L_0x001f
            if (r28 == 0) goto L_0x001a
            goto L_0x001f
        L_0x001a:
            r3 = r1
            r5 = r2
            r0 = r9
            goto L_0x023b
        L_0x001f:
            int r4 = r0.targetWidth
            int r6 = r0.targetHeight
            float r7 = r0.rotationDegrees
            r8 = 0
            int r8 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
            if (r8 == 0) goto L_0x0130
            double r10 = (double) r7
            double r12 = java.lang.Math.toRadians(r10)
            double r12 = java.lang.Math.cos(r12)
            double r10 = java.lang.Math.toRadians(r10)
            double r10 = java.lang.Math.sin(r10)
            boolean r4 = r0.hasRotationPivot
            if (r4 == 0) goto L_0x00c9
            float r4 = r0.rotationPivotX
            float r6 = r0.rotationPivotY
            r9.setRotate(r7, r4, r6)
            float r4 = r0.rotationPivotX
            double r6 = (double) r4
            r14 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            double r14 = r14 - r12
            double r6 = r6 * r14
            float r8 = r0.rotationPivotY
            r16 = r2
            r17 = r3
            double r2 = (double) r8
            double r2 = r2 * r10
            double r6 = r6 + r2
            double r2 = (double) r8
            double r2 = r2 * r14
            double r14 = (double) r4
            double r14 = r14 * r10
            double r2 = r2 - r14
            int r4 = r0.targetWidth
            double r14 = (double) r4
            double r14 = r14 * r12
            double r14 = r14 + r6
            r18 = r6
            double r5 = (double) r4
            double r5 = r5 * r10
            double r5 = r5 + r2
            r20 = r9
            double r8 = (double) r4
            double r8 = r8 * r12
            double r7 = r18 + r8
            int r9 = r0.targetHeight
            r22 = r1
            double r0 = (double) r9
            double r0 = r0 * r10
            double r7 = r7 - r0
            double r0 = (double) r4
            double r0 = r0 * r10
            double r0 = r0 + r2
            r23 = r5
            double r4 = (double) r9
            double r4 = r4 * r12
            double r0 = r0 + r4
            double r4 = (double) r9
            double r4 = r4 * r10
            double r4 = r18 - r4
            double r9 = (double) r9
            double r9 = r9 * r12
            double r9 = r9 + r2
            r11 = r18
            r18 = r9
            double r9 = java.lang.Math.max(r11, r14)
            double r9 = java.lang.Math.max(r7, r9)
            double r9 = java.lang.Math.max(r4, r9)
            double r11 = java.lang.Math.min(r11, r14)
            double r6 = java.lang.Math.min(r7, r11)
            double r4 = java.lang.Math.min(r4, r6)
            r6 = r23
            double r11 = java.lang.Math.max(r2, r6)
            double r11 = java.lang.Math.max(r0, r11)
            r13 = r18
            double r11 = java.lang.Math.max(r13, r11)
            double r2 = java.lang.Math.min(r2, r6)
            double r0 = java.lang.Math.min(r0, r2)
            double r0 = java.lang.Math.min(r13, r0)
            double r9 = r9 - r4
            double r2 = java.lang.Math.floor(r9)
            int r4 = (int) r2
            double r11 = r11 - r0
            double r0 = java.lang.Math.floor(r11)
            int r6 = (int) r0
            r0 = r20
            goto L_0x0137
        L_0x00c9:
            r22 = r1
            r16 = r2
            r17 = r3
            r0 = r9
            r0.setRotate(r7)
            r1 = r26
            int r2 = r1.targetWidth
            double r3 = (double) r2
            double r3 = r3 * r12
            double r5 = (double) r2
            double r5 = r5 * r10
            double r7 = (double) r2
            double r7 = r7 * r12
            int r9 = r1.targetHeight
            double r14 = (double) r9
            double r14 = r14 * r10
            double r7 = r7 - r14
            double r14 = (double) r2
            double r14 = r14 * r10
            double r1 = (double) r9
            double r1 = r1 * r12
            double r14 = r14 + r1
            double r1 = (double) r9
            double r1 = r1 * r10
            double r1 = -r1
            double r9 = (double) r9
            double r9 = r9 * r12
            r11 = 0
            r18 = r9
            double r9 = java.lang.Math.max(r11, r3)
            double r9 = java.lang.Math.max(r7, r9)
            double r9 = java.lang.Math.max(r1, r9)
            double r3 = java.lang.Math.min(r11, r3)
            double r3 = java.lang.Math.min(r7, r3)
            double r1 = java.lang.Math.min(r1, r3)
            double r3 = java.lang.Math.max(r11, r5)
            double r3 = java.lang.Math.max(r14, r3)
            r7 = r18
            double r3 = java.lang.Math.max(r7, r3)
            double r5 = java.lang.Math.min(r11, r5)
            double r5 = java.lang.Math.min(r14, r5)
            double r5 = java.lang.Math.min(r7, r5)
            double r9 = r9 - r1
            double r1 = java.lang.Math.floor(r9)
            int r1 = (int) r1
            double r3 = r3 - r5
            double r2 = java.lang.Math.floor(r3)
            int r6 = (int) r2
            r4 = r1
            goto L_0x0137
        L_0x0130:
            r22 = r1
            r16 = r2
            r17 = r3
            r0 = r9
        L_0x0137:
            if (r28 == 0) goto L_0x015d
            int r1 = k(r28)
            int r2 = l(r28)
            if (r1 == 0) goto L_0x0154
            float r3 = (float) r1
            r0.preRotate(r3)
            r3 = 90
            if (r1 == r3) goto L_0x014f
            r3 = 270(0x10e, float:3.78E-43)
            if (r1 != r3) goto L_0x0154
        L_0x014f:
            r25 = r6
            r6 = r4
            r4 = r25
        L_0x0154:
            r1 = 1
            if (r2 == r1) goto L_0x015d
            float r1 = (float) r2
            r2 = 1065353216(0x3f800000, float:1.0)
            r0.postScale(r1, r2)
        L_0x015d:
            r1 = r26
            boolean r2 = r1.centerCrop
            if (r2 == 0) goto L_0x01f0
            if (r4 == 0) goto L_0x016d
            float r2 = (float) r4
            r3 = r22
            float r5 = (float) r3
            float r2 = r2 / r5
            r5 = r16
            goto L_0x0174
        L_0x016d:
            r3 = r22
            float r2 = (float) r6
            r5 = r16
            float r7 = (float) r5
            float r2 = r2 / r7
        L_0x0174:
            if (r6 == 0) goto L_0x0179
            float r7 = (float) r6
            float r8 = (float) r5
            goto L_0x017b
        L_0x0179:
            float r7 = (float) r4
            float r8 = (float) r3
        L_0x017b:
            float r7 = r7 / r8
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 <= 0) goto L_0x01aa
            float r8 = (float) r5
            float r7 = r7 / r2
            float r8 = r8 * r7
            double r7 = (double) r8
            double r7 = java.lang.Math.ceil(r7)
            int r7 = (int) r7
            int r1 = r1.centerCropGravity
            r8 = r1 & 48
            r9 = 48
            if (r8 != r9) goto L_0x0193
            r1 = 0
            goto L_0x019f
        L_0x0193:
            r8 = 80
            r1 = r1 & r8
            if (r1 != r8) goto L_0x019b
            int r1 = r5 - r7
            goto L_0x019f
        L_0x019b:
            int r1 = r5 - r7
            int r1 = r1 / 2
        L_0x019f:
            float r8 = (float) r6
            float r9 = (float) r7
            float r8 = r8 / r9
            r9 = r7
            r10 = r17
            r21 = 0
            r7 = r1
            r1 = r3
            goto L_0x01e1
        L_0x01aa:
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 >= 0) goto L_0x01d8
            float r8 = (float) r3
            float r2 = r2 / r7
            float r8 = r8 * r2
            double r8 = (double) r8
            double r8 = java.lang.Math.ceil(r8)
            int r2 = (int) r8
            int r1 = r1.centerCropGravity
            r8 = r1 & 3
            r9 = 3
            if (r8 != r9) goto L_0x01c0
            r1 = 0
            goto L_0x01cb
        L_0x01c0:
            r8 = 5
            r1 = r1 & r8
            if (r1 != r8) goto L_0x01c7
            int r1 = r3 - r2
            goto L_0x01cb
        L_0x01c7:
            int r1 = r3 - r2
            int r1 = r1 / 2
        L_0x01cb:
            float r8 = (float) r4
            float r9 = (float) r2
            float r8 = r8 / r9
            r21 = r1
            r1 = r2
            r9 = r5
            r2 = r8
            r10 = r17
            r8 = r7
            r7 = 0
            goto L_0x01e1
        L_0x01d8:
            r1 = r3
            r9 = r5
            r2 = r7
            r8 = r2
            r10 = r17
            r7 = 0
            r21 = 0
        L_0x01e1:
            boolean r3 = shouldResize(r10, r3, r5, r4, r6)
            if (r3 == 0) goto L_0x01ea
            r0.preScale(r2, r8)
        L_0x01ea:
            r6 = r7
            r8 = r9
            r5 = r21
            r7 = r1
            goto L_0x023f
        L_0x01f0:
            r5 = r16
            r10 = r17
            r3 = r22
            boolean r1 = r1.centerInside
            if (r1 == 0) goto L_0x021a
            if (r4 == 0) goto L_0x01ff
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x0201
        L_0x01ff:
            float r1 = (float) r6
            float r2 = (float) r5
        L_0x0201:
            float r1 = r1 / r2
            if (r6 == 0) goto L_0x0207
            float r2 = (float) r6
            float r7 = (float) r5
            goto L_0x0209
        L_0x0207:
            float r2 = (float) r4
            float r7 = (float) r3
        L_0x0209:
            float r2 = r2 / r7
            int r7 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r7 >= 0) goto L_0x020f
            goto L_0x0210
        L_0x020f:
            r1 = r2
        L_0x0210:
            boolean r2 = shouldResize(r10, r3, r5, r4, r6)
            if (r2 == 0) goto L_0x023b
            r0.preScale(r1, r1)
            goto L_0x023b
        L_0x021a:
            if (r4 != 0) goto L_0x021e
            if (r6 == 0) goto L_0x023b
        L_0x021e:
            if (r4 != r3) goto L_0x0222
            if (r6 == r5) goto L_0x023b
        L_0x0222:
            if (r4 == 0) goto L_0x0227
            float r1 = (float) r4
            float r2 = (float) r3
            goto L_0x0229
        L_0x0227:
            float r1 = (float) r6
            float r2 = (float) r5
        L_0x0229:
            float r1 = r1 / r2
            if (r6 == 0) goto L_0x022f
            float r2 = (float) r6
            float r7 = (float) r5
            goto L_0x0231
        L_0x022f:
            float r2 = (float) r4
            float r7 = (float) r3
        L_0x0231:
            float r2 = r2 / r7
            boolean r4 = shouldResize(r10, r3, r5, r4, r6)
            if (r4 == 0) goto L_0x023b
            r0.preScale(r1, r2)
        L_0x023b:
            r7 = r3
            r8 = r5
            r5 = 0
            r6 = 0
        L_0x023f:
            r10 = 1
            r4 = r27
            r9 = r0
            android.graphics.Bitmap r0 = android.graphics.Bitmap.createBitmap(r4, r5, r6, r7, r8, r9, r10)
            r1 = r27
            if (r0 == r1) goto L_0x024f
            r27.recycle()
            goto L_0x0250
        L_0x024f:
            r0 = r1
        L_0x0250:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.squareup.picasso.BitmapHunter.w(com.squareup.picasso.Request, android.graphics.Bitmap, int):android.graphics.Bitmap");
    }

    public static void x(Request request) {
        String a11 = request.a();
        StringBuilder sb2 = NAME_BUILDER.get();
        sb2.ensureCapacity(a11.length() + 8);
        sb2.replace(8, sb2.length(), a11);
        Thread.currentThread().setName(sb2.toString());
    }

    public void b(Action action) {
        boolean z11 = this.f53372c.f53442j;
        Request request = action.f53359b;
        if (this.f53381l == null) {
            this.f53381l = action;
            if (z11) {
                List<Action> list = this.f53382m;
                if (list == null || list.isEmpty()) {
                    Utils.u("Hunter", "joined", request.c(), "to empty hunter");
                } else {
                    Utils.u("Hunter", "joined", request.c(), Utils.l(this, "to "));
                }
            }
        } else {
            if (this.f53382m == null) {
                this.f53382m = new ArrayList(3);
            }
            this.f53382m.add(action);
            if (z11) {
                Utils.u("Hunter", "joined", request.c(), Utils.l(this, "to "));
            }
            Picasso.Priority f11 = action.f();
            if (f11.ordinal() > this.f53389t.ordinal()) {
                this.f53389t = f11;
            }
        }
    }

    public boolean c() {
        Future<?> future;
        if (this.f53381l != null) {
            return false;
        }
        List<Action> list = this.f53382m;
        if ((list == null || list.isEmpty()) && (future = this.f53384o) != null && future.cancel(false)) {
            return true;
        }
        return false;
    }

    public void e(Action action) {
        boolean z11;
        if (this.f53381l == action) {
            this.f53381l = null;
            z11 = true;
        } else {
            List<Action> list = this.f53382m;
            if (list != null) {
                z11 = list.remove(action);
            } else {
                z11 = false;
            }
        }
        if (z11 && action.f() == this.f53389t) {
            this.f53389t = computeNewPriority();
        }
        if (this.f53372c.f53442j) {
            Utils.u("Hunter", "removed", action.f53359b.c(), Utils.l(this, "from "));
        }
    }

    public Action g() {
        return this.f53381l;
    }

    public List<Action> h() {
        return this.f53382m;
    }

    public Request i() {
        return this.f53377h;
    }

    public Exception j() {
        return this.f53386q;
    }

    public String m() {
        return this.f53376g;
    }

    public Picasso.LoadedFrom n() {
        return this.f53385p;
    }

    public int o() {
        return this.f53378i;
    }

    public Picasso p() {
        return this.f53372c;
    }

    public Picasso.Priority q() {
        return this.f53389t;
    }

    public Bitmap r() {
        return this.f53383n;
    }

    public void run() {
        try {
            x(this.f53377h);
            if (this.f53372c.f53442j) {
                Utils.t("Hunter", "executing", Utils.k(this));
            }
            Bitmap s11 = s();
            this.f53383n = s11;
            if (s11 == null) {
                this.f53373d.d(this);
            } else {
                this.f53373d.c(this);
            }
        } catch (NetworkRequestHandler.ResponseException e11) {
            if (!NetworkPolicy.isOfflineOnly(e11.f53429c) || e11.f53428b != 504) {
                this.f53386q = e11;
            }
            this.f53373d.d(this);
        } catch (IOException e12) {
            this.f53386q = e12;
            this.f53373d.h(this);
        } catch (OutOfMemoryError e13) {
            StringWriter stringWriter = new StringWriter();
            this.f53375f.a().dump(new PrintWriter(stringWriter));
            this.f53386q = new RuntimeException(stringWriter.toString(), e13);
            this.f53373d.d(this);
        } catch (Exception e14) {
            this.f53386q = e14;
            this.f53373d.d(this);
        } catch (Throwable th2) {
            Thread.currentThread().setName("Picasso-Idle");
            throw th2;
        }
        Thread.currentThread().setName("Picasso-Idle");
    }

    public Bitmap s() throws IOException {
        Bitmap bitmap;
        int i11;
        if (MemoryPolicy.a(this.f53378i)) {
            bitmap = this.f53374e.get(this.f53376g);
            if (bitmap != null) {
                this.f53375f.d();
                this.f53385p = Picasso.LoadedFrom.MEMORY;
                if (this.f53372c.f53442j) {
                    Utils.u("Hunter", "decoded", this.f53377h.c(), "from cache");
                }
                return bitmap;
            }
        } else {
            bitmap = null;
        }
        if (this.f53388s == 0) {
            i11 = NetworkPolicy.OFFLINE.f53427b;
        } else {
            i11 = this.f53379j;
        }
        this.f53379j = i11;
        RequestHandler.Result load = this.f53380k.load(this.f53377h, i11);
        if (load != null) {
            this.f53385p = load.getLoadedFrom();
            this.f53387r = load.a();
            bitmap = load.getBitmap();
            if (bitmap == null) {
                Source source = load.getSource();
                try {
                    bitmap = d(source, this.f53377h);
                } finally {
                    try {
                        source.close();
                    } catch (IOException unused) {
                    }
                }
            }
        }
        if (bitmap != null) {
            if (this.f53372c.f53442j) {
                Utils.t("Hunter", "decoded", this.f53377h.c());
            }
            this.f53375f.b(bitmap);
            if (this.f53377h.e() || this.f53387r != 0) {
                synchronized (DECODE_LOCK) {
                    if (this.f53377h.d() || this.f53387r != 0) {
                        bitmap = w(this.f53377h, bitmap, this.f53387r);
                        if (this.f53372c.f53442j) {
                            Utils.t("Hunter", "transformed", this.f53377h.c());
                        }
                    }
                    if (this.f53377h.b()) {
                        bitmap = a(this.f53377h.transformations, bitmap);
                        if (this.f53372c.f53442j) {
                            Utils.u("Hunter", "transformed", this.f53377h.c(), "from custom transformations");
                        }
                    }
                }
                if (bitmap != null) {
                    this.f53375f.c(bitmap);
                }
            }
        }
        return bitmap;
    }

    public boolean t() {
        Future<?> future = this.f53384o;
        return future != null && future.isCancelled();
    }

    public boolean u(boolean z11, NetworkInfo networkInfo) {
        boolean z12;
        int i11 = this.f53388s;
        if (i11 > 0) {
            z12 = true;
        } else {
            z12 = false;
        }
        if (!z12) {
            return false;
        }
        this.f53388s = i11 - 1;
        return this.f53380k.f(z11, networkInfo);
    }

    public boolean v() {
        return this.f53380k.g();
    }
}
