package androidx.vectordrawable.graphics.drawable;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.collection.ArrayMap;
import androidx.core.content.res.ComplexColorCompat;
import androidx.core.content.res.TypedArrayUtils;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.drawable.DrawableCompat;
import com.facebook.internal.security.CertificateUtil;
import com.huawei.hms.flutter.map.constants.Param;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class VectorDrawableCompat extends VectorDrawableCommon {
    private static final boolean DBG_VECTOR_DRAWABLE = false;
    private static final int LINECAP_BUTT = 0;
    private static final int LINECAP_ROUND = 1;
    private static final int LINECAP_SQUARE = 2;
    private static final int LINEJOIN_BEVEL = 2;
    private static final int LINEJOIN_MITER = 0;
    private static final int LINEJOIN_ROUND = 1;
    private static final int MAX_CACHED_BITMAP_SIZE = 2048;
    private static final String SHAPE_CLIP_PATH = "clip-path";
    private static final String SHAPE_GROUP = "group";
    private static final String SHAPE_PATH = "path";
    private static final String SHAPE_VECTOR = "vector";

    /* renamed from: c  reason: collision with root package name */
    public static final PorterDuff.Mode f37853c = PorterDuff.Mode.SRC_IN;
    private boolean mAllowCaching;
    private Drawable.ConstantState mCachedConstantStateDelegate;
    private ColorFilter mColorFilter;
    private boolean mMutated;
    private PorterDuffColorFilter mTintFilter;
    private final Rect mTmpBounds;
    private final float[] mTmpFloats;
    private final Matrix mTmpMatrix;
    private VectorDrawableCompatState mVectorState;

    public static class VClipPath extends VPath {
        public VClipPath() {
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f37871b = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f37870a = PathParser.createNodesFromPathData(string2);
            }
            this.f37872c = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.f37838d);
                updateStateFromTypedArray(obtainAttributes, xmlPullParser);
                obtainAttributes.recycle();
            }
        }

        public boolean isClipPath() {
            return true;
        }

        public VClipPath(VClipPath vClipPath) {
            super(vClipPath);
        }
    }

    public static abstract class VObject {
        private VObject() {
        }

        public boolean isStateful() {
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            return false;
        }
    }

    public static class VectorDrawableCompatState extends Drawable.ConstantState {

        /* renamed from: a  reason: collision with root package name */
        public int f37885a;

        /* renamed from: b  reason: collision with root package name */
        public VPathRenderer f37886b;

        /* renamed from: c  reason: collision with root package name */
        public ColorStateList f37887c;

        /* renamed from: d  reason: collision with root package name */
        public PorterDuff.Mode f37888d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f37889e;

        /* renamed from: f  reason: collision with root package name */
        public Bitmap f37890f;

        /* renamed from: g  reason: collision with root package name */
        public ColorStateList f37891g;

        /* renamed from: h  reason: collision with root package name */
        public PorterDuff.Mode f37892h;

        /* renamed from: i  reason: collision with root package name */
        public int f37893i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f37894j;

        /* renamed from: k  reason: collision with root package name */
        public boolean f37895k;

        /* renamed from: l  reason: collision with root package name */
        public Paint f37896l;

        public VectorDrawableCompatState(VectorDrawableCompatState vectorDrawableCompatState) {
            this.f37887c = null;
            this.f37888d = VectorDrawableCompat.f37853c;
            if (vectorDrawableCompatState != null) {
                this.f37885a = vectorDrawableCompatState.f37885a;
                VPathRenderer vPathRenderer = new VPathRenderer(vectorDrawableCompatState.f37886b);
                this.f37886b = vPathRenderer;
                if (vectorDrawableCompatState.f37886b.f37875b != null) {
                    vPathRenderer.f37875b = new Paint(vectorDrawableCompatState.f37886b.f37875b);
                }
                if (vectorDrawableCompatState.f37886b.f37874a != null) {
                    this.f37886b.f37874a = new Paint(vectorDrawableCompatState.f37886b.f37874a);
                }
                this.f37887c = vectorDrawableCompatState.f37887c;
                this.f37888d = vectorDrawableCompatState.f37888d;
                this.f37889e = vectorDrawableCompatState.f37889e;
            }
        }

        public boolean canReuseBitmap(int i11, int i12) {
            if (i11 == this.f37890f.getWidth() && i12 == this.f37890f.getHeight()) {
                return true;
            }
            return false;
        }

        public boolean canReuseCache() {
            if (!this.f37895k && this.f37891g == this.f37887c && this.f37892h == this.f37888d && this.f37894j == this.f37889e && this.f37893i == this.f37886b.getRootAlpha()) {
                return true;
            }
            return false;
        }

        public void createCachedBitmapIfNeeded(int i11, int i12) {
            if (this.f37890f == null || !canReuseBitmap(i11, i12)) {
                this.f37890f = Bitmap.createBitmap(i11, i12, Bitmap.Config.ARGB_8888);
                this.f37895k = true;
            }
        }

        public void drawCachedBitmapWithRootAlpha(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f37890f, (Rect) null, rect, getPaint(colorFilter));
        }

        public int getChangingConfigurations() {
            return this.f37885a;
        }

        public Paint getPaint(ColorFilter colorFilter) {
            if (!hasTranslucentRoot() && colorFilter == null) {
                return null;
            }
            if (this.f37896l == null) {
                Paint paint = new Paint();
                this.f37896l = paint;
                paint.setFilterBitmap(true);
            }
            this.f37896l.setAlpha(this.f37886b.getRootAlpha());
            this.f37896l.setColorFilter(colorFilter);
            return this.f37896l;
        }

        public boolean hasTranslucentRoot() {
            return this.f37886b.getRootAlpha() < 255;
        }

        public boolean isStateful() {
            return this.f37886b.isStateful();
        }

        @NonNull
        public Drawable newDrawable() {
            return new VectorDrawableCompat(this);
        }

        public boolean onStateChanged(int[] iArr) {
            boolean onStateChanged = this.f37886b.onStateChanged(iArr);
            this.f37895k |= onStateChanged;
            return onStateChanged;
        }

        public void updateCacheStates() {
            this.f37891g = this.f37887c;
            this.f37892h = this.f37888d;
            this.f37893i = this.f37886b.getRootAlpha();
            this.f37894j = this.f37889e;
            this.f37895k = false;
        }

        public void updateCachedBitmap(int i11, int i12) {
            this.f37890f.eraseColor(0);
            this.f37886b.draw(new Canvas(this.f37890f), i11, i12, (ColorFilter) null);
        }

        @NonNull
        public Drawable newDrawable(Resources resources) {
            return new VectorDrawableCompat(this);
        }

        public VectorDrawableCompatState() {
            this.f37887c = null;
            this.f37888d = VectorDrawableCompat.f37853c;
            this.f37886b = new VPathRenderer();
        }
    }

    public VectorDrawableCompat() {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = new VectorDrawableCompatState();
    }

    public static int a(int i11, float f11) {
        return (i11 & 16777215) | (((int) (((float) Color.alpha(i11)) * f11)) << 24);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0038 A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d A[Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }] */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.vectordrawable.graphics.drawable.VectorDrawableCompat create(@androidx.annotation.NonNull android.content.res.Resources r6, @androidx.annotation.DrawableRes int r7, @androidx.annotation.Nullable android.content.res.Resources.Theme r8) {
        /*
            java.lang.String r0 = "parser error"
            java.lang.String r1 = "VectorDrawableCompat"
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 24
            if (r2 < r3) goto L_0x0023
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r0 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat
            r0.<init>()
            android.graphics.drawable.Drawable r6 = androidx.core.content.res.ResourcesCompat.getDrawable(r6, r7, r8)
            r0.f37852b = r6
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState r6 = new androidx.vectordrawable.graphics.drawable.VectorDrawableCompat$VectorDrawableDelegateState
            android.graphics.drawable.Drawable r7 = r0.f37852b
            android.graphics.drawable.Drawable$ConstantState r7 = r7.getConstantState()
            r6.<init>(r7)
            r0.mCachedConstantStateDelegate = r6
            return r0
        L_0x0023:
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            android.util.AttributeSet r2 = android.util.Xml.asAttributeSet(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x002b:
            int r3 = r7.next()     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            r4 = 2
            if (r3 == r4) goto L_0x0036
            r5 = 1
            if (r3 == r5) goto L_0x0036
            goto L_0x002b
        L_0x0036:
            if (r3 != r4) goto L_0x003d
            androidx.vectordrawable.graphics.drawable.VectorDrawableCompat r6 = createFromXmlInner(r6, r7, r2, r8)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            return r6
        L_0x003d:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
            throw r6     // Catch:{ XmlPullParserException -> 0x004a, IOException -> 0x0045 }
        L_0x0045:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
            goto L_0x004e
        L_0x004a:
            r6 = move-exception
            android.util.Log.e(r1, r0, r6)
        L_0x004e:
            r6 = 0
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.vectordrawable.graphics.drawable.VectorDrawableCompat.create(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.vectordrawable.graphics.drawable.VectorDrawableCompat");
    }

    public static VectorDrawableCompat createFromXmlInner(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
        vectorDrawableCompat.inflate(resources, xmlPullParser, attributeSet, theme);
        return vectorDrawableCompat;
    }

    private void inflateInternal(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f37886b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(vPathRenderer.f37876c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z11 = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name2 = xmlPullParser.getName();
                VGroup vGroup = (VGroup) arrayDeque.peek();
                if (SHAPE_PATH.equals(name2)) {
                    VFullPath vFullPath = new VFullPath();
                    vFullPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f37866b.add(vFullPath);
                    if (vFullPath.getPathName() != null) {
                        vPathRenderer.f37884k.put(vFullPath.getPathName(), vFullPath);
                    }
                    vectorDrawableCompatState.f37885a = vFullPath.f37873d | vectorDrawableCompatState.f37885a;
                    z11 = false;
                } else if (SHAPE_CLIP_PATH.equals(name2)) {
                    VClipPath vClipPath = new VClipPath();
                    vClipPath.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f37866b.add(vClipPath);
                    if (vClipPath.getPathName() != null) {
                        vPathRenderer.f37884k.put(vClipPath.getPathName(), vClipPath);
                    }
                    vectorDrawableCompatState.f37885a = vClipPath.f37873d | vectorDrawableCompatState.f37885a;
                } else if ("group".equals(name2)) {
                    VGroup vGroup2 = new VGroup();
                    vGroup2.inflate(resources, attributeSet, theme, xmlPullParser);
                    vGroup.f37866b.add(vGroup2);
                    arrayDeque.push(vGroup2);
                    if (vGroup2.getGroupName() != null) {
                        vPathRenderer.f37884k.put(vGroup2.getGroupName(), vGroup2);
                    }
                    vectorDrawableCompatState.f37885a = vGroup2.f37869e | vectorDrawableCompatState.f37885a;
                }
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z11) {
            throw new XmlPullParserException("no path defined");
        }
    }

    private boolean needMirroring() {
        if (!isAutoMirrored() || DrawableCompat.getLayoutDirection(this) != 1) {
            return false;
        }
        return true;
    }

    private static PorterDuff.Mode parseTintModeCompat(int i11, PorterDuff.Mode mode) {
        if (i11 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i11 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i11 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i11) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    private void printGroupTree(VGroup vGroup, int i11) {
        String str = "";
        for (int i12 = 0; i12 < i11; i12++) {
            str = str + "    ";
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        sb2.append("current group is :");
        sb2.append(vGroup.getGroupName());
        sb2.append(" rotation is ");
        sb2.append(vGroup.f37867c);
        StringBuilder sb3 = new StringBuilder();
        sb3.append(str);
        sb3.append("matrix is :");
        sb3.append(vGroup.getLocalMatrix().toString());
        for (int i13 = 0; i13 < vGroup.f37866b.size(); i13++) {
            VObject vObject = vGroup.f37866b.get(i13);
            if (vObject instanceof VGroup) {
                printGroupTree((VGroup) vObject, i11 + 1);
            } else {
                ((VPath) vObject).printVPath(i11 + 1);
            }
        }
    }

    private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) throws XmlPullParserException {
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        VPathRenderer vPathRenderer = vectorDrawableCompatState.f37886b;
        vectorDrawableCompatState.f37888d = parseTintModeCompat(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList namedColorStateList = TypedArrayUtils.getNamedColorStateList(typedArray, xmlPullParser, theme, "tint", 1);
        if (namedColorStateList != null) {
            vectorDrawableCompatState.f37887c = namedColorStateList;
        }
        vectorDrawableCompatState.f37889e = TypedArrayUtils.getNamedBoolean(typedArray, xmlPullParser, "autoMirrored", 5, vectorDrawableCompatState.f37889e);
        vPathRenderer.f37879f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportWidth", 7, vPathRenderer.f37879f);
        float namedFloat = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "viewportHeight", 8, vPathRenderer.f37880g);
        vPathRenderer.f37880g = namedFloat;
        if (vPathRenderer.f37879f <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (namedFloat > 0.0f) {
            vPathRenderer.f37877d = typedArray.getDimension(3, vPathRenderer.f37877d);
            float dimension = typedArray.getDimension(2, vPathRenderer.f37878e);
            vPathRenderer.f37878e = dimension;
            if (vPathRenderer.f37877d <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (dimension > 0.0f) {
                vPathRenderer.setAlpha(TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "alpha", 4, vPathRenderer.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    vPathRenderer.f37882i = string;
                    vPathRenderer.f37884k.put(string, vPathRenderer);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public Object b(String str) {
        return this.mVectorState.f37886b.f37884k.get(str);
    }

    public void c(boolean z11) {
        this.mAllowCaching = z11;
    }

    public boolean canApplyTheme() {
        Drawable drawable = this.f37852b;
        if (drawable == null) {
            return false;
        }
        DrawableCompat.canApplyTheme(drawable);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public PorterDuffColorFilter d(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    public void draw(Canvas canvas) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.draw(canvas);
            return;
        }
        copyBounds(this.mTmpBounds);
        if (this.mTmpBounds.width() > 0 && this.mTmpBounds.height() > 0) {
            ColorFilter colorFilter = this.mColorFilter;
            if (colorFilter == null) {
                colorFilter = this.mTintFilter;
            }
            canvas.getMatrix(this.mTmpMatrix);
            this.mTmpMatrix.getValues(this.mTmpFloats);
            float abs = Math.abs(this.mTmpFloats[0]);
            float abs2 = Math.abs(this.mTmpFloats[4]);
            float abs3 = Math.abs(this.mTmpFloats[1]);
            float abs4 = Math.abs(this.mTmpFloats[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.mTmpBounds.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.mTmpBounds.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                Rect rect = this.mTmpBounds;
                canvas.translate((float) rect.left, (float) rect.top);
                if (needMirroring()) {
                    canvas.translate((float) this.mTmpBounds.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.mTmpBounds.offsetTo(0, 0);
                this.mVectorState.createCachedBitmapIfNeeded(min, min2);
                if (!this.mAllowCaching) {
                    this.mVectorState.updateCachedBitmap(min, min2);
                } else if (!this.mVectorState.canReuseCache()) {
                    this.mVectorState.updateCachedBitmap(min, min2);
                    this.mVectorState.updateCacheStates();
                }
                this.mVectorState.drawCachedBitmapWithRootAlpha(canvas, colorFilter, this.mTmpBounds);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return DrawableCompat.getAlpha(drawable);
        }
        return this.mVectorState.f37886b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getChangingConfigurations();
        }
        return super.getChangingConfigurations() | this.mVectorState.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return DrawableCompat.getColorFilter(drawable);
        }
        return this.mColorFilter;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f37852b != null && Build.VERSION.SDK_INT >= 24) {
            return new VectorDrawableDelegateState(this.f37852b.getConstantState());
        }
        this.mVectorState.f37885a = getChangingConfigurations();
        return this.mVectorState;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getIntrinsicHeight();
        }
        return (int) this.mVectorState.f37886b.f37878e;
    }

    public int getIntrinsicWidth() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getIntrinsicWidth();
        }
        return (int) this.mVectorState.f37886b.f37877d;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public float getPixelSize() {
        VPathRenderer vPathRenderer;
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState == null || (vPathRenderer = vectorDrawableCompatState.f37886b) == null) {
            return 1.0f;
        }
        float f11 = vPathRenderer.f37877d;
        if (f11 == 0.0f) {
            return 1.0f;
        }
        float f12 = vPathRenderer.f37878e;
        if (f12 == 0.0f) {
            return 1.0f;
        }
        float f13 = vPathRenderer.f37880g;
        if (f13 == 0.0f) {
            return 1.0f;
        }
        float f14 = vPathRenderer.f37879f;
        if (f14 == 0.0f) {
            return 1.0f;
        }
        return Math.min(f14 / f11, f13 / f12);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) throws XmlPullParserException, IOException {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void invalidateSelf() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return DrawableCompat.isAutoMirrored(drawable);
        }
        return this.mVectorState.f37889e;
    }

    public boolean isStateful() {
        VectorDrawableCompatState vectorDrawableCompatState;
        ColorStateList colorStateList;
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.isStateful();
        }
        if (super.isStateful() || ((vectorDrawableCompatState = this.mVectorState) != null && (vectorDrawableCompatState.isStateful() || ((colorStateList = this.mVectorState.f37887c) != null && colorStateList.isStateful())))) {
            return true;
        }
        return false;
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.mutate();
            return this;
        }
        if (!this.mMutated && super.mutate() == this) {
            this.mVectorState = new VectorDrawableCompatState(this.mVectorState);
            this.mMutated = true;
        }
        return this;
    }

    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
    }

    public boolean onStateChange(int[] iArr) {
        boolean z11;
        PorterDuff.Mode mode;
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.setState(iArr);
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        ColorStateList colorStateList = vectorDrawableCompatState.f37887c;
        if (colorStateList == null || (mode = vectorDrawableCompatState.f37888d) == null) {
            z11 = false;
        } else {
            this.mTintFilter = d(this.mTintFilter, colorStateList, mode);
            invalidateSelf();
            z11 = true;
        }
        if (!vectorDrawableCompatState.isStateful() || !vectorDrawableCompatState.onStateChanged(iArr)) {
            return z11;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.scheduleSelf(runnable, j11);
        } else {
            super.scheduleSelf(runnable, j11);
        }
    }

    public void setAlpha(int i11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.setAlpha(i11);
        } else if (this.mVectorState.f37886b.getRootAlpha() != i11) {
            this.mVectorState.f37886b.setRootAlpha(i11);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.setAutoMirrored(drawable, z11);
        } else {
            this.mVectorState.f37889e = z11;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i11) {
        super.setChangingConfigurations(i11);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i11, PorterDuff.Mode mode) {
        super.setColorFilter(i11, mode);
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z11) {
        super.setFilterBitmap(z11);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f11, float f12) {
        super.setHotspot(f11, f12);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i11, int i12, int i13, int i14) {
        super.setHotspotBounds(i11, i12, i13, i14);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i11) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.setTint(drawable, i11);
        } else {
            setTintList(ColorStateList.valueOf(i11));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.setTintList(drawable, colorStateList);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.f37887c != colorStateList) {
            vectorDrawableCompatState.f37887c = colorStateList;
            this.mTintFilter = d(this.mTintFilter, colorStateList, vectorDrawableCompatState.f37888d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.setTintMode(drawable, mode);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        if (vectorDrawableCompatState.f37888d != mode) {
            vectorDrawableCompatState.f37888d = mode;
            this.mTintFilter = d(this.mTintFilter, vectorDrawableCompatState.f37887c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z11, boolean z12) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            return drawable.setVisible(z11, z12);
        }
        return super.setVisible(z11, z12);
    }

    public void unscheduleSelf(Runnable runnable) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }

    @RequiresApi(24)
    public static class VectorDrawableDelegateState extends Drawable.ConstantState {
        private final Drawable.ConstantState mDelegateState;

        public VectorDrawableDelegateState(Drawable.ConstantState constantState) {
            this.mDelegateState = constantState;
        }

        public boolean canApplyTheme() {
            return this.mDelegateState.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.mDelegateState.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f37852b = (VectorDrawable) this.mDelegateState.newDrawable();
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f37852b = (VectorDrawable) this.mDelegateState.newDrawable(resources);
            return vectorDrawableCompat;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            VectorDrawableCompat vectorDrawableCompat = new VectorDrawableCompat();
            vectorDrawableCompat.f37852b = (VectorDrawable) this.mDelegateState.newDrawable(resources, theme);
            return vectorDrawableCompat;
        }
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
            return;
        }
        this.mColorFilter = colorFilter;
        invalidateSelf();
    }

    public static abstract class VPath extends VObject {

        /* renamed from: a  reason: collision with root package name */
        public PathParser.PathDataNode[] f37870a = null;

        /* renamed from: b  reason: collision with root package name */
        public String f37871b;

        /* renamed from: c  reason: collision with root package name */
        public int f37872c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f37873d;

        public VPath() {
            super();
        }

        public void applyTheme(Resources.Theme theme) {
        }

        public boolean canApplyTheme() {
            return false;
        }

        public PathParser.PathDataNode[] getPathData() {
            return this.f37870a;
        }

        public String getPathName() {
            return this.f37871b;
        }

        public boolean isClipPath() {
            return false;
        }

        public String nodesToString(PathParser.PathDataNode[] pathDataNodeArr) {
            String str = " ";
            for (int i11 = 0; i11 < pathDataNodeArr.length; i11++) {
                str = str + pathDataNodeArr[i11].mType + CertificateUtil.DELIMITER;
                float[] fArr = pathDataNodeArr[i11].mParams;
                for (int i12 = 0; i12 < fArr.length; i12++) {
                    str = str + fArr[i12] + ",";
                }
            }
            return str;
        }

        public void printVPath(int i11) {
            String str = "";
            for (int i12 = 0; i12 < i11; i12++) {
                str = str + "    ";
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append(str);
            sb2.append("current path is :");
            sb2.append(this.f37871b);
            sb2.append(" pathData is ");
            sb2.append(nodesToString(this.f37870a));
        }

        public void setPathData(PathParser.PathDataNode[] pathDataNodeArr) {
            if (!PathParser.canMorph(this.f37870a, pathDataNodeArr)) {
                this.f37870a = PathParser.deepCopyNodes(pathDataNodeArr);
            } else {
                PathParser.updateNodes(this.f37870a, pathDataNodeArr);
            }
        }

        public void toPath(Path path) {
            path.reset();
            PathParser.PathDataNode[] pathDataNodeArr = this.f37870a;
            if (pathDataNodeArr != null) {
                PathParser.PathDataNode.nodesToPath(pathDataNodeArr, path);
            }
        }

        public VPath(VPath vPath) {
            super();
            this.f37871b = vPath.f37871b;
            this.f37873d = vPath.f37873d;
            this.f37870a = PathParser.deepCopyNodes(vPath.f37870a);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        Drawable drawable = this.f37852b;
        if (drawable != null) {
            DrawableCompat.inflate(drawable, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        VectorDrawableCompatState vectorDrawableCompatState = this.mVectorState;
        vectorDrawableCompatState.f37886b = new VPathRenderer();
        TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.f37835a);
        updateStateFromTypedArray(obtainAttributes, xmlPullParser, theme);
        obtainAttributes.recycle();
        vectorDrawableCompatState.f37885a = getChangingConfigurations();
        vectorDrawableCompatState.f37895k = true;
        inflateInternal(resources, xmlPullParser, attributeSet, theme);
        this.mTintFilter = d(this.mTintFilter, vectorDrawableCompatState.f37887c, vectorDrawableCompatState.f37888d);
    }

    public VectorDrawableCompat(@NonNull VectorDrawableCompatState vectorDrawableCompatState) {
        this.mAllowCaching = true;
        this.mTmpFloats = new float[9];
        this.mTmpMatrix = new Matrix();
        this.mTmpBounds = new Rect();
        this.mVectorState = vectorDrawableCompatState;
        this.mTintFilter = d(this.mTintFilter, vectorDrawableCompatState.f37887c, vectorDrawableCompatState.f37888d);
    }

    public static class VFullPath extends VPath {

        /* renamed from: e  reason: collision with root package name */
        public ComplexColorCompat f37854e;

        /* renamed from: f  reason: collision with root package name */
        public float f37855f = 0.0f;

        /* renamed from: g  reason: collision with root package name */
        public ComplexColorCompat f37856g;

        /* renamed from: h  reason: collision with root package name */
        public float f37857h = 1.0f;

        /* renamed from: i  reason: collision with root package name */
        public float f37858i = 1.0f;

        /* renamed from: j  reason: collision with root package name */
        public float f37859j = 0.0f;

        /* renamed from: k  reason: collision with root package name */
        public float f37860k = 1.0f;

        /* renamed from: l  reason: collision with root package name */
        public float f37861l = 0.0f;

        /* renamed from: m  reason: collision with root package name */
        public Paint.Cap f37862m = Paint.Cap.BUTT;
        private int[] mThemeAttrs;

        /* renamed from: n  reason: collision with root package name */
        public Paint.Join f37863n = Paint.Join.MITER;

        /* renamed from: o  reason: collision with root package name */
        public float f37864o = 4.0f;

        public VFullPath() {
        }

        private Paint.Cap getStrokeLineCap(int i11, Paint.Cap cap) {
            if (i11 == 0) {
                return Paint.Cap.BUTT;
            }
            if (i11 == 1) {
                return Paint.Cap.ROUND;
            }
            if (i11 != 2) {
                return cap;
            }
            return Paint.Cap.SQUARE;
        }

        private Paint.Join getStrokeLineJoin(int i11, Paint.Join join) {
            if (i11 == 0) {
                return Paint.Join.MITER;
            }
            if (i11 == 1) {
                return Paint.Join.ROUND;
            }
            if (i11 != 2) {
                return join;
            }
            return Paint.Join.BEVEL;
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.mThemeAttrs = null;
            if (TypedArrayUtils.hasAttribute(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f37871b = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f37870a = PathParser.createNodesFromPathData(string2);
                }
                Resources.Theme theme2 = theme;
                this.f37856g = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme2, Param.FILL_COLOR, 1, 0);
                this.f37858i = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "fillAlpha", 12, this.f37858i);
                this.f37862m = getStrokeLineCap(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f37862m);
                this.f37863n = getStrokeLineJoin(TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f37863n);
                this.f37864o = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f37864o);
                this.f37854e = TypedArrayUtils.getNamedComplexColor(typedArray, xmlPullParser, theme2, Param.STROKE_COLOR, 3, 0);
                this.f37857h = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "strokeAlpha", 11, this.f37857h);
                this.f37855f = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, Param.STROKE_WIDTH, 4, this.f37855f);
                this.f37860k = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathEnd", 6, this.f37860k);
                this.f37861l = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathOffset", 7, this.f37861l);
                this.f37859j = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "trimPathStart", 5, this.f37859j);
                this.f37872c = TypedArrayUtils.getNamedInt(typedArray, xmlPullParser, "fillType", 13, this.f37872c);
            }
        }

        public void applyTheme(Resources.Theme theme) {
        }

        public boolean canApplyTheme() {
            return this.mThemeAttrs != null;
        }

        public float getFillAlpha() {
            return this.f37858i;
        }

        @ColorInt
        public int getFillColor() {
            return this.f37856g.getColor();
        }

        public float getStrokeAlpha() {
            return this.f37857h;
        }

        @ColorInt
        public int getStrokeColor() {
            return this.f37854e.getColor();
        }

        public float getStrokeWidth() {
            return this.f37855f;
        }

        public float getTrimPathEnd() {
            return this.f37860k;
        }

        public float getTrimPathOffset() {
            return this.f37861l;
        }

        public float getTrimPathStart() {
            return this.f37859j;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.f37837c);
            updateStateFromTypedArray(obtainAttributes, xmlPullParser, theme);
            obtainAttributes.recycle();
        }

        public boolean isStateful() {
            return this.f37856g.isStateful() || this.f37854e.isStateful();
        }

        public boolean onStateChanged(int[] iArr) {
            return this.f37854e.onStateChanged(iArr) | this.f37856g.onStateChanged(iArr);
        }

        public void setFillAlpha(float f11) {
            this.f37858i = f11;
        }

        public void setFillColor(int i11) {
            this.f37856g.setColor(i11);
        }

        public void setStrokeAlpha(float f11) {
            this.f37857h = f11;
        }

        public void setStrokeColor(int i11) {
            this.f37854e.setColor(i11);
        }

        public void setStrokeWidth(float f11) {
            this.f37855f = f11;
        }

        public void setTrimPathEnd(float f11) {
            this.f37860k = f11;
        }

        public void setTrimPathOffset(float f11) {
            this.f37861l = f11;
        }

        public void setTrimPathStart(float f11) {
            this.f37859j = f11;
        }

        public VFullPath(VFullPath vFullPath) {
            super(vFullPath);
            this.mThemeAttrs = vFullPath.mThemeAttrs;
            this.f37854e = vFullPath.f37854e;
            this.f37855f = vFullPath.f37855f;
            this.f37857h = vFullPath.f37857h;
            this.f37856g = vFullPath.f37856g;
            this.f37872c = vFullPath.f37872c;
            this.f37858i = vFullPath.f37858i;
            this.f37859j = vFullPath.f37859j;
            this.f37860k = vFullPath.f37860k;
            this.f37861l = vFullPath.f37861l;
            this.f37862m = vFullPath.f37862m;
            this.f37863n = vFullPath.f37863n;
            this.f37864o = vFullPath.f37864o;
        }
    }

    public static class VPathRenderer {
        private static final Matrix IDENTITY_MATRIX = new Matrix();

        /* renamed from: a  reason: collision with root package name */
        public Paint f37874a;

        /* renamed from: b  reason: collision with root package name */
        public Paint f37875b;

        /* renamed from: c  reason: collision with root package name */
        public final VGroup f37876c;

        /* renamed from: d  reason: collision with root package name */
        public float f37877d;

        /* renamed from: e  reason: collision with root package name */
        public float f37878e;

        /* renamed from: f  reason: collision with root package name */
        public float f37879f;

        /* renamed from: g  reason: collision with root package name */
        public float f37880g;

        /* renamed from: h  reason: collision with root package name */
        public int f37881h;

        /* renamed from: i  reason: collision with root package name */
        public String f37882i;

        /* renamed from: j  reason: collision with root package name */
        public Boolean f37883j;

        /* renamed from: k  reason: collision with root package name */
        public final ArrayMap<String, Object> f37884k;
        private int mChangingConfigurations;
        private final Matrix mFinalPathMatrix;
        private final Path mPath;
        private PathMeasure mPathMeasure;
        private final Path mRenderPath;

        public VPathRenderer() {
            this.mFinalPathMatrix = new Matrix();
            this.f37877d = 0.0f;
            this.f37878e = 0.0f;
            this.f37879f = 0.0f;
            this.f37880g = 0.0f;
            this.f37881h = 255;
            this.f37882i = null;
            this.f37883j = null;
            this.f37884k = new ArrayMap<>();
            this.f37876c = new VGroup();
            this.mPath = new Path();
            this.mRenderPath = new Path();
        }

        private static float cross(float f11, float f12, float f13, float f14) {
            return (f11 * f14) - (f12 * f13);
        }

        private void drawGroupTree(VGroup vGroup, Matrix matrix, Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            vGroup.f37865a.set(matrix);
            vGroup.f37865a.preConcat(vGroup.f37868d);
            canvas.save();
            for (int i13 = 0; i13 < vGroup.f37866b.size(); i13++) {
                VObject vObject = vGroup.f37866b.get(i13);
                if (vObject instanceof VGroup) {
                    drawGroupTree((VGroup) vObject, vGroup.f37865a, canvas, i11, i12, colorFilter);
                } else if (vObject instanceof VPath) {
                    drawPath(vGroup, (VPath) vObject, canvas, i11, i12, colorFilter);
                }
            }
            canvas.restore();
        }

        private void drawPath(VGroup vGroup, VPath vPath, Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            Path.FillType fillType;
            Path.FillType fillType2;
            float f11 = ((float) i11) / this.f37879f;
            float f12 = ((float) i12) / this.f37880g;
            float min = Math.min(f11, f12);
            Matrix matrix = vGroup.f37865a;
            this.mFinalPathMatrix.set(matrix);
            this.mFinalPathMatrix.postScale(f11, f12);
            float matrixScale = getMatrixScale(matrix);
            if (matrixScale != 0.0f) {
                vPath.toPath(this.mPath);
                Path path = this.mPath;
                this.mRenderPath.reset();
                if (vPath.isClipPath()) {
                    Path path2 = this.mRenderPath;
                    if (vPath.f37872c == 0) {
                        fillType2 = Path.FillType.WINDING;
                    } else {
                        fillType2 = Path.FillType.EVEN_ODD;
                    }
                    path2.setFillType(fillType2);
                    this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                    canvas.clipPath(this.mRenderPath);
                    return;
                }
                VFullPath vFullPath = (VFullPath) vPath;
                float f13 = vFullPath.f37859j;
                if (!(f13 == 0.0f && vFullPath.f37860k == 1.0f)) {
                    float f14 = vFullPath.f37861l;
                    float f15 = (f13 + f14) % 1.0f;
                    float f16 = (vFullPath.f37860k + f14) % 1.0f;
                    if (this.mPathMeasure == null) {
                        this.mPathMeasure = new PathMeasure();
                    }
                    this.mPathMeasure.setPath(this.mPath, false);
                    float length = this.mPathMeasure.getLength();
                    float f17 = f15 * length;
                    float f18 = f16 * length;
                    path.reset();
                    if (f17 > f18) {
                        this.mPathMeasure.getSegment(f17, length, path, true);
                        this.mPathMeasure.getSegment(0.0f, f18, path, true);
                    } else {
                        this.mPathMeasure.getSegment(f17, f18, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.mRenderPath.addPath(path, this.mFinalPathMatrix);
                if (vFullPath.f37856g.willDraw()) {
                    ComplexColorCompat complexColorCompat = vFullPath.f37856g;
                    if (this.f37875b == null) {
                        Paint paint = new Paint(1);
                        this.f37875b = paint;
                        paint.setStyle(Paint.Style.FILL);
                    }
                    Paint paint2 = this.f37875b;
                    if (complexColorCompat.isGradient()) {
                        Shader shader = complexColorCompat.getShader();
                        shader.setLocalMatrix(this.mFinalPathMatrix);
                        paint2.setShader(shader);
                        paint2.setAlpha(Math.round(vFullPath.f37858i * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(VectorDrawableCompat.a(complexColorCompat.getColor(), vFullPath.f37858i));
                    }
                    paint2.setColorFilter(colorFilter);
                    Path path3 = this.mRenderPath;
                    if (vFullPath.f37872c == 0) {
                        fillType = Path.FillType.WINDING;
                    } else {
                        fillType = Path.FillType.EVEN_ODD;
                    }
                    path3.setFillType(fillType);
                    canvas.drawPath(this.mRenderPath, paint2);
                }
                if (vFullPath.f37854e.willDraw()) {
                    ComplexColorCompat complexColorCompat2 = vFullPath.f37854e;
                    if (this.f37874a == null) {
                        Paint paint3 = new Paint(1);
                        this.f37874a = paint3;
                        paint3.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint4 = this.f37874a;
                    Paint.Join join = vFullPath.f37863n;
                    if (join != null) {
                        paint4.setStrokeJoin(join);
                    }
                    Paint.Cap cap = vFullPath.f37862m;
                    if (cap != null) {
                        paint4.setStrokeCap(cap);
                    }
                    paint4.setStrokeMiter(vFullPath.f37864o);
                    if (complexColorCompat2.isGradient()) {
                        Shader shader2 = complexColorCompat2.getShader();
                        shader2.setLocalMatrix(this.mFinalPathMatrix);
                        paint4.setShader(shader2);
                        paint4.setAlpha(Math.round(vFullPath.f37857h * 255.0f));
                    } else {
                        paint4.setShader((Shader) null);
                        paint4.setAlpha(255);
                        paint4.setColor(VectorDrawableCompat.a(complexColorCompat2.getColor(), vFullPath.f37857h));
                    }
                    paint4.setColorFilter(colorFilter);
                    paint4.setStrokeWidth(vFullPath.f37855f * min * matrixScale);
                    canvas.drawPath(this.mRenderPath, paint4);
                }
            }
        }

        private float getMatrixScale(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float cross = cross(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(cross) / max;
            }
            return 0.0f;
        }

        public void draw(Canvas canvas, int i11, int i12, ColorFilter colorFilter) {
            drawGroupTree(this.f37876c, IDENTITY_MATRIX, canvas, i11, i12, colorFilter);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f37881h;
        }

        public boolean isStateful() {
            if (this.f37883j == null) {
                this.f37883j = Boolean.valueOf(this.f37876c.isStateful());
            }
            return this.f37883j.booleanValue();
        }

        public boolean onStateChanged(int[] iArr) {
            return this.f37876c.onStateChanged(iArr);
        }

        public void setAlpha(float f11) {
            setRootAlpha((int) (f11 * 255.0f));
        }

        public void setRootAlpha(int i11) {
            this.f37881h = i11;
        }

        public VPathRenderer(VPathRenderer vPathRenderer) {
            this.mFinalPathMatrix = new Matrix();
            this.f37877d = 0.0f;
            this.f37878e = 0.0f;
            this.f37879f = 0.0f;
            this.f37880g = 0.0f;
            this.f37881h = 255;
            this.f37882i = null;
            this.f37883j = null;
            ArrayMap<String, Object> arrayMap = new ArrayMap<>();
            this.f37884k = arrayMap;
            this.f37876c = new VGroup(vPathRenderer.f37876c, arrayMap);
            this.mPath = new Path(vPathRenderer.mPath);
            this.mRenderPath = new Path(vPathRenderer.mRenderPath);
            this.f37877d = vPathRenderer.f37877d;
            this.f37878e = vPathRenderer.f37878e;
            this.f37879f = vPathRenderer.f37879f;
            this.f37880g = vPathRenderer.f37880g;
            this.mChangingConfigurations = vPathRenderer.mChangingConfigurations;
            this.f37881h = vPathRenderer.f37881h;
            this.f37882i = vPathRenderer.f37882i;
            String str = vPathRenderer.f37882i;
            if (str != null) {
                arrayMap.put(str, this);
            }
            this.f37883j = vPathRenderer.f37883j;
        }
    }

    public static class VGroup extends VObject {

        /* renamed from: a  reason: collision with root package name */
        public final Matrix f37865a;

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<VObject> f37866b;

        /* renamed from: c  reason: collision with root package name */
        public float f37867c;

        /* renamed from: d  reason: collision with root package name */
        public final Matrix f37868d;

        /* renamed from: e  reason: collision with root package name */
        public int f37869e;
        private String mGroupName;
        private float mPivotX;
        private float mPivotY;
        private float mScaleX;
        private float mScaleY;
        private int[] mThemeAttrs;
        private float mTranslateX;
        private float mTranslateY;

        public VGroup(VGroup vGroup, ArrayMap<String, Object> arrayMap) {
            super();
            VPath vPath;
            this.f37865a = new Matrix();
            this.f37866b = new ArrayList<>();
            this.f37867c = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            Matrix matrix = new Matrix();
            this.f37868d = matrix;
            this.mGroupName = null;
            this.f37867c = vGroup.f37867c;
            this.mPivotX = vGroup.mPivotX;
            this.mPivotY = vGroup.mPivotY;
            this.mScaleX = vGroup.mScaleX;
            this.mScaleY = vGroup.mScaleY;
            this.mTranslateX = vGroup.mTranslateX;
            this.mTranslateY = vGroup.mTranslateY;
            this.mThemeAttrs = vGroup.mThemeAttrs;
            String str = vGroup.mGroupName;
            this.mGroupName = str;
            this.f37869e = vGroup.f37869e;
            if (str != null) {
                arrayMap.put(str, this);
            }
            matrix.set(vGroup.f37868d);
            ArrayList<VObject> arrayList = vGroup.f37866b;
            for (int i11 = 0; i11 < arrayList.size(); i11++) {
                VObject vObject = arrayList.get(i11);
                if (vObject instanceof VGroup) {
                    this.f37866b.add(new VGroup((VGroup) vObject, arrayMap));
                } else {
                    if (vObject instanceof VFullPath) {
                        vPath = new VFullPath((VFullPath) vObject);
                    } else if (vObject instanceof VClipPath) {
                        vPath = new VClipPath((VClipPath) vObject);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f37866b.add(vPath);
                    String str2 = vPath.f37871b;
                    if (str2 != null) {
                        arrayMap.put(str2, vPath);
                    }
                }
            }
        }

        private void updateLocalMatrix() {
            this.f37868d.reset();
            this.f37868d.postTranslate(-this.mPivotX, -this.mPivotY);
            this.f37868d.postScale(this.mScaleX, this.mScaleY);
            this.f37868d.postRotate(this.f37867c, 0.0f, 0.0f);
            this.f37868d.postTranslate(this.mTranslateX + this.mPivotX, this.mTranslateY + this.mPivotY);
        }

        private void updateStateFromTypedArray(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.mThemeAttrs = null;
            this.f37867c = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "rotation", 5, this.f37867c);
            this.mPivotX = typedArray.getFloat(1, this.mPivotX);
            this.mPivotY = typedArray.getFloat(2, this.mPivotY);
            this.mScaleX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleX", 3, this.mScaleX);
            this.mScaleY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "scaleY", 4, this.mScaleY);
            this.mTranslateX = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateX", 6, this.mTranslateX);
            this.mTranslateY = TypedArrayUtils.getNamedFloat(typedArray, xmlPullParser, "translateY", 7, this.mTranslateY);
            String string = typedArray.getString(0);
            if (string != null) {
                this.mGroupName = string;
            }
            updateLocalMatrix();
        }

        public String getGroupName() {
            return this.mGroupName;
        }

        public Matrix getLocalMatrix() {
            return this.f37868d;
        }

        public float getPivotX() {
            return this.mPivotX;
        }

        public float getPivotY() {
            return this.mPivotY;
        }

        public float getRotation() {
            return this.f37867c;
        }

        public float getScaleX() {
            return this.mScaleX;
        }

        public float getScaleY() {
            return this.mScaleY;
        }

        public float getTranslateX() {
            return this.mTranslateX;
        }

        public float getTranslateY() {
            return this.mTranslateY;
        }

        public void inflate(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray obtainAttributes = TypedArrayUtils.obtainAttributes(resources, theme, attributeSet, AndroidResources.f37836b);
            updateStateFromTypedArray(obtainAttributes, xmlPullParser);
            obtainAttributes.recycle();
        }

        public boolean isStateful() {
            for (int i11 = 0; i11 < this.f37866b.size(); i11++) {
                if (this.f37866b.get(i11).isStateful()) {
                    return true;
                }
            }
            return false;
        }

        public boolean onStateChanged(int[] iArr) {
            boolean z11 = false;
            for (int i11 = 0; i11 < this.f37866b.size(); i11++) {
                z11 |= this.f37866b.get(i11).onStateChanged(iArr);
            }
            return z11;
        }

        public void setPivotX(float f11) {
            if (f11 != this.mPivotX) {
                this.mPivotX = f11;
                updateLocalMatrix();
            }
        }

        public void setPivotY(float f11) {
            if (f11 != this.mPivotY) {
                this.mPivotY = f11;
                updateLocalMatrix();
            }
        }

        public void setRotation(float f11) {
            if (f11 != this.f37867c) {
                this.f37867c = f11;
                updateLocalMatrix();
            }
        }

        public void setScaleX(float f11) {
            if (f11 != this.mScaleX) {
                this.mScaleX = f11;
                updateLocalMatrix();
            }
        }

        public void setScaleY(float f11) {
            if (f11 != this.mScaleY) {
                this.mScaleY = f11;
                updateLocalMatrix();
            }
        }

        public void setTranslateX(float f11) {
            if (f11 != this.mTranslateX) {
                this.mTranslateX = f11;
                updateLocalMatrix();
            }
        }

        public void setTranslateY(float f11) {
            if (f11 != this.mTranslateY) {
                this.mTranslateY = f11;
                updateLocalMatrix();
            }
        }

        public VGroup() {
            super();
            this.f37865a = new Matrix();
            this.f37866b = new ArrayList<>();
            this.f37867c = 0.0f;
            this.mPivotX = 0.0f;
            this.mPivotY = 0.0f;
            this.mScaleX = 1.0f;
            this.mScaleY = 1.0f;
            this.mTranslateX = 0.0f;
            this.mTranslateY = 0.0f;
            this.f37868d = new Matrix();
            this.mGroupName = null;
        }
    }
}
