package androidx.palette.graphics;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.AsyncTask;
import android.util.Log;
import android.util.SparseBooleanArray;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.collection.ArrayMap;
import androidx.core.graphics.ColorUtils;
import androidx.core.view.ViewCompat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class Palette {

    /* renamed from: a  reason: collision with root package name */
    public static final Filter f37275a = new Filter() {
        private static final float BLACK_MAX_LIGHTNESS = 0.05f;
        private static final float WHITE_MIN_LIGHTNESS = 0.95f;

        private boolean isBlack(float[] fArr) {
            return fArr[2] <= BLACK_MAX_LIGHTNESS;
        }

        private boolean isNearRedILine(float[] fArr) {
            float f11 = fArr[0];
            return f11 >= 10.0f && f11 <= 37.0f && fArr[1] <= 0.82f;
        }

        private boolean isWhite(float[] fArr) {
            return fArr[2] >= WHITE_MIN_LIGHTNESS;
        }

        public boolean isAllowed(int i11, float[] fArr) {
            return !isWhite(fArr) && !isBlack(fArr) && !isNearRedILine(fArr);
        }
    };
    @Nullable
    private final Swatch mDominantSwatch = findDominantSwatch();
    private final Map<Target, Swatch> mSelectedSwatches = new ArrayMap();
    private final List<Swatch> mSwatches;
    private final List<Target> mTargets;
    private final SparseBooleanArray mUsedColors = new SparseBooleanArray();

    public interface Filter {
        boolean isAllowed(@ColorInt int i11, @NonNull float[] fArr);
    }

    public interface PaletteAsyncListener {
        void onGenerated(@Nullable Palette palette);
    }

    public static final class Swatch {
        private final int mBlue;
        private int mBodyTextColor;
        private boolean mGeneratedTextColors;
        private final int mGreen;
        @Nullable
        private float[] mHsl;
        private final int mPopulation;
        private final int mRed;
        private final int mRgb;
        private int mTitleTextColor;

        public Swatch(@ColorInt int i11, int i12) {
            this.mRed = Color.red(i11);
            this.mGreen = Color.green(i11);
            this.mBlue = Color.blue(i11);
            this.mRgb = i11;
            this.mPopulation = i12;
        }

        private void ensureTextColorsGenerated() {
            int i11;
            int i12;
            if (!this.mGeneratedTextColors) {
                int calculateMinimumAlpha = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 4.5f);
                int calculateMinimumAlpha2 = ColorUtils.calculateMinimumAlpha(-1, this.mRgb, 3.0f);
                if (calculateMinimumAlpha == -1 || calculateMinimumAlpha2 == -1) {
                    int calculateMinimumAlpha3 = ColorUtils.calculateMinimumAlpha(ViewCompat.MEASURED_STATE_MASK, this.mRgb, 4.5f);
                    int calculateMinimumAlpha4 = ColorUtils.calculateMinimumAlpha(ViewCompat.MEASURED_STATE_MASK, this.mRgb, 3.0f);
                    if (calculateMinimumAlpha3 == -1 || calculateMinimumAlpha4 == -1) {
                        if (calculateMinimumAlpha != -1) {
                            i11 = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                        } else {
                            i11 = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha3);
                        }
                        this.mBodyTextColor = i11;
                        if (calculateMinimumAlpha2 != -1) {
                            i12 = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                        } else {
                            i12 = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha4);
                        }
                        this.mTitleTextColor = i12;
                        this.mGeneratedTextColors = true;
                        return;
                    }
                    this.mBodyTextColor = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha3);
                    this.mTitleTextColor = ColorUtils.setAlphaComponent(ViewCompat.MEASURED_STATE_MASK, calculateMinimumAlpha4);
                    this.mGeneratedTextColors = true;
                    return;
                }
                this.mBodyTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha);
                this.mTitleTextColor = ColorUtils.setAlphaComponent(-1, calculateMinimumAlpha2);
                this.mGeneratedTextColors = true;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || Swatch.class != obj.getClass()) {
                return false;
            }
            Swatch swatch = (Swatch) obj;
            if (this.mPopulation == swatch.mPopulation && this.mRgb == swatch.mRgb) {
                return true;
            }
            return false;
        }

        @ColorInt
        public int getBodyTextColor() {
            ensureTextColorsGenerated();
            return this.mBodyTextColor;
        }

        @NonNull
        public float[] getHsl() {
            if (this.mHsl == null) {
                this.mHsl = new float[3];
            }
            ColorUtils.RGBToHSL(this.mRed, this.mGreen, this.mBlue, this.mHsl);
            return this.mHsl;
        }

        public int getPopulation() {
            return this.mPopulation;
        }

        @ColorInt
        public int getRgb() {
            return this.mRgb;
        }

        @ColorInt
        public int getTitleTextColor() {
            ensureTextColorsGenerated();
            return this.mTitleTextColor;
        }

        public int hashCode() {
            return (this.mRgb * 31) + this.mPopulation;
        }

        public String toString() {
            return Swatch.class.getSimpleName() + " [RGB: #" + Integer.toHexString(getRgb()) + AbstractJsonLexerKt.END_LIST + " [HSL: " + Arrays.toString(getHsl()) + AbstractJsonLexerKt.END_LIST + " [Population: " + this.mPopulation + AbstractJsonLexerKt.END_LIST + " [Title Text: #" + Integer.toHexString(getTitleTextColor()) + AbstractJsonLexerKt.END_LIST + " [Body Text: #" + Integer.toHexString(getBodyTextColor()) + AbstractJsonLexerKt.END_LIST;
        }
    }

    public Palette(List<Swatch> list, List<Target> list2) {
        this.mSwatches = list;
        this.mTargets = list2;
    }

    @Nullable
    private Swatch findDominantSwatch() {
        int size = this.mSwatches.size();
        int i11 = Integer.MIN_VALUE;
        Swatch swatch = null;
        for (int i12 = 0; i12 < size; i12++) {
            Swatch swatch2 = this.mSwatches.get(i12);
            if (swatch2.getPopulation() > i11) {
                i11 = swatch2.getPopulation();
                swatch = swatch2;
            }
        }
        return swatch;
    }

    @NonNull
    public static Builder from(@NonNull Bitmap bitmap) {
        return new Builder(bitmap);
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap) {
        return from(bitmap).generate();
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).generate(paletteAsyncListener);
    }

    private float generateScore(Swatch swatch, Target target) {
        int i11;
        float f11;
        float f12;
        float[] hsl = swatch.getHsl();
        Swatch swatch2 = this.mDominantSwatch;
        if (swatch2 != null) {
            i11 = swatch2.getPopulation();
        } else {
            i11 = 1;
        }
        float f13 = 0.0f;
        if (target.getSaturationWeight() > 0.0f) {
            f11 = target.getSaturationWeight() * (1.0f - Math.abs(hsl[1] - target.getTargetSaturation()));
        } else {
            f11 = 0.0f;
        }
        if (target.getLightnessWeight() > 0.0f) {
            f12 = target.getLightnessWeight() * (1.0f - Math.abs(hsl[2] - target.getTargetLightness()));
        } else {
            f12 = 0.0f;
        }
        if (target.getPopulationWeight() > 0.0f) {
            f13 = target.getPopulationWeight() * (((float) swatch.getPopulation()) / ((float) i11));
        }
        return f11 + f12 + f13;
    }

    @Nullable
    private Swatch generateScoredTarget(Target target) {
        Swatch maxScoredSwatchForTarget = getMaxScoredSwatchForTarget(target);
        if (maxScoredSwatchForTarget != null && target.isExclusive()) {
            this.mUsedColors.append(maxScoredSwatchForTarget.getRgb(), true);
        }
        return maxScoredSwatchForTarget;
    }

    @Nullable
    private Swatch getMaxScoredSwatchForTarget(Target target) {
        int size = this.mSwatches.size();
        float f11 = 0.0f;
        Swatch swatch = null;
        for (int i11 = 0; i11 < size; i11++) {
            Swatch swatch2 = this.mSwatches.get(i11);
            if (shouldBeScoredForTarget(swatch2, target)) {
                float generateScore = generateScore(swatch2, target);
                if (swatch == null || generateScore > f11) {
                    swatch = swatch2;
                    f11 = generateScore;
                }
            }
        }
        return swatch;
    }

    private boolean shouldBeScoredForTarget(Swatch swatch, Target target) {
        float[] hsl = swatch.getHsl();
        if (hsl[1] < target.getMinimumSaturation() || hsl[1] > target.getMaximumSaturation() || hsl[2] < target.getMinimumLightness() || hsl[2] > target.getMaximumLightness() || this.mUsedColors.get(swatch.getRgb())) {
            return false;
        }
        return true;
    }

    public void a() {
        int size = this.mTargets.size();
        for (int i11 = 0; i11 < size; i11++) {
            Target target = this.mTargets.get(i11);
            target.a();
            this.mSelectedSwatches.put(target, generateScoredTarget(target));
        }
        this.mUsedColors.clear();
    }

    @ColorInt
    public int getColorForTarget(@NonNull Target target, @ColorInt int i11) {
        Swatch swatchForTarget = getSwatchForTarget(target);
        if (swatchForTarget != null) {
            return swatchForTarget.getRgb();
        }
        return i11;
    }

    @ColorInt
    public int getDarkMutedColor(@ColorInt int i11) {
        return getColorForTarget(Target.DARK_MUTED, i11);
    }

    @Nullable
    public Swatch getDarkMutedSwatch() {
        return getSwatchForTarget(Target.DARK_MUTED);
    }

    @ColorInt
    public int getDarkVibrantColor(@ColorInt int i11) {
        return getColorForTarget(Target.DARK_VIBRANT, i11);
    }

    @Nullable
    public Swatch getDarkVibrantSwatch() {
        return getSwatchForTarget(Target.DARK_VIBRANT);
    }

    @ColorInt
    public int getDominantColor(@ColorInt int i11) {
        Swatch swatch = this.mDominantSwatch;
        return swatch != null ? swatch.getRgb() : i11;
    }

    @Nullable
    public Swatch getDominantSwatch() {
        return this.mDominantSwatch;
    }

    @ColorInt
    public int getLightMutedColor(@ColorInt int i11) {
        return getColorForTarget(Target.LIGHT_MUTED, i11);
    }

    @Nullable
    public Swatch getLightMutedSwatch() {
        return getSwatchForTarget(Target.LIGHT_MUTED);
    }

    @ColorInt
    public int getLightVibrantColor(@ColorInt int i11) {
        return getColorForTarget(Target.LIGHT_VIBRANT, i11);
    }

    @Nullable
    public Swatch getLightVibrantSwatch() {
        return getSwatchForTarget(Target.LIGHT_VIBRANT);
    }

    @ColorInt
    public int getMutedColor(@ColorInt int i11) {
        return getColorForTarget(Target.MUTED, i11);
    }

    @Nullable
    public Swatch getMutedSwatch() {
        return getSwatchForTarget(Target.MUTED);
    }

    @Nullable
    public Swatch getSwatchForTarget(@NonNull Target target) {
        return this.mSelectedSwatches.get(target);
    }

    @NonNull
    public List<Swatch> getSwatches() {
        return Collections.unmodifiableList(this.mSwatches);
    }

    @NonNull
    public List<Target> getTargets() {
        return Collections.unmodifiableList(this.mTargets);
    }

    @ColorInt
    public int getVibrantColor(@ColorInt int i11) {
        return getColorForTarget(Target.VIBRANT, i11);
    }

    @Nullable
    public Swatch getVibrantSwatch() {
        return getSwatchForTarget(Target.VIBRANT);
    }

    @NonNull
    public static Palette from(@NonNull List<Swatch> list) {
        return new Builder(list).generate();
    }

    @Deprecated
    public static Palette generate(Bitmap bitmap, int i11) {
        return from(bitmap).maximumColorCount(i11).generate();
    }

    @Deprecated
    public static AsyncTask<Bitmap, Void, Palette> generateAsync(Bitmap bitmap, int i11, PaletteAsyncListener paletteAsyncListener) {
        return from(bitmap).maximumColorCount(i11).generate(paletteAsyncListener);
    }

    public static final class Builder {
        @Nullable
        private final Bitmap mBitmap;
        private final List<Filter> mFilters;
        private int mMaxColors;
        @Nullable
        private Rect mRegion;
        private int mResizeArea;
        private int mResizeMaxDimension;
        @Nullable
        private final List<Swatch> mSwatches;
        private final List<Target> mTargets;

        public Builder(@NonNull Bitmap bitmap) {
            ArrayList arrayList = new ArrayList();
            this.mTargets = arrayList;
            this.mMaxColors = 16;
            this.mResizeArea = 12544;
            this.mResizeMaxDimension = -1;
            ArrayList arrayList2 = new ArrayList();
            this.mFilters = arrayList2;
            if (bitmap == null || bitmap.isRecycled()) {
                throw new IllegalArgumentException("Bitmap is not valid");
            }
            arrayList2.add(Palette.f37275a);
            this.mBitmap = bitmap;
            this.mSwatches = null;
            arrayList.add(Target.LIGHT_VIBRANT);
            arrayList.add(Target.VIBRANT);
            arrayList.add(Target.DARK_VIBRANT);
            arrayList.add(Target.LIGHT_MUTED);
            arrayList.add(Target.MUTED);
            arrayList.add(Target.DARK_MUTED);
        }

        private int[] getPixelsFromBitmap(Bitmap bitmap) {
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int[] iArr = new int[(width * height)];
            bitmap.getPixels(iArr, 0, width, 0, 0, width, height);
            Rect rect = this.mRegion;
            if (rect == null) {
                return iArr;
            }
            int width2 = rect.width();
            int height2 = this.mRegion.height();
            int[] iArr2 = new int[(width2 * height2)];
            for (int i11 = 0; i11 < height2; i11++) {
                Rect rect2 = this.mRegion;
                System.arraycopy(iArr, ((rect2.top + i11) * width) + rect2.left, iArr2, i11 * width2, width2);
            }
            return iArr2;
        }

        private Bitmap scaleBitmapDown(Bitmap bitmap) {
            int max;
            int i11;
            double d11 = -1.0d;
            if (this.mResizeArea > 0) {
                int width = bitmap.getWidth() * bitmap.getHeight();
                int i12 = this.mResizeArea;
                if (width > i12) {
                    d11 = Math.sqrt(((double) i12) / ((double) width));
                }
            } else if (this.mResizeMaxDimension > 0 && (max = Math.max(bitmap.getWidth(), bitmap.getHeight())) > (i11 = this.mResizeMaxDimension)) {
                d11 = ((double) i11) / ((double) max);
            }
            if (d11 <= 0.0d) {
                return bitmap;
            }
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * d11), (int) Math.ceil(((double) bitmap.getHeight()) * d11), false);
        }

        @NonNull
        public Builder addFilter(Filter filter) {
            if (filter != null) {
                this.mFilters.add(filter);
            }
            return this;
        }

        @NonNull
        public Builder addTarget(@NonNull Target target) {
            if (!this.mTargets.contains(target)) {
                this.mTargets.add(target);
            }
            return this;
        }

        @NonNull
        public Builder clearFilters() {
            this.mFilters.clear();
            return this;
        }

        @NonNull
        public Builder clearRegion() {
            this.mRegion = null;
            return this;
        }

        @NonNull
        public Builder clearTargets() {
            List<Target> list = this.mTargets;
            if (list != null) {
                list.clear();
            }
            return this;
        }

        @NonNull
        public Palette generate() {
            List<Swatch> list;
            Filter[] filterArr;
            Bitmap bitmap = this.mBitmap;
            if (bitmap != null) {
                Bitmap scaleBitmapDown = scaleBitmapDown(bitmap);
                Rect rect = this.mRegion;
                if (!(scaleBitmapDown == this.mBitmap || rect == null)) {
                    double width = ((double) scaleBitmapDown.getWidth()) / ((double) this.mBitmap.getWidth());
                    rect.left = (int) Math.floor(((double) rect.left) * width);
                    rect.top = (int) Math.floor(((double) rect.top) * width);
                    rect.right = Math.min((int) Math.ceil(((double) rect.right) * width), scaleBitmapDown.getWidth());
                    rect.bottom = Math.min((int) Math.ceil(((double) rect.bottom) * width), scaleBitmapDown.getHeight());
                }
                int[] pixelsFromBitmap = getPixelsFromBitmap(scaleBitmapDown);
                int i11 = this.mMaxColors;
                if (this.mFilters.isEmpty()) {
                    filterArr = null;
                } else {
                    List<Filter> list2 = this.mFilters;
                    filterArr = (Filter[]) list2.toArray(new Filter[list2.size()]);
                }
                ColorCutQuantizer colorCutQuantizer = new ColorCutQuantizer(pixelsFromBitmap, i11, filterArr);
                if (scaleBitmapDown != this.mBitmap) {
                    scaleBitmapDown.recycle();
                }
                list = colorCutQuantizer.b();
            } else {
                list = this.mSwatches;
                if (list == null) {
                    throw new AssertionError();
                }
            }
            Palette palette = new Palette(list, this.mTargets);
            palette.a();
            return palette;
        }

        @NonNull
        public Builder maximumColorCount(int i11) {
            this.mMaxColors = i11;
            return this;
        }

        @NonNull
        public Builder resizeBitmapArea(int i11) {
            this.mResizeArea = i11;
            this.mResizeMaxDimension = -1;
            return this;
        }

        @NonNull
        @Deprecated
        public Builder resizeBitmapSize(int i11) {
            this.mResizeMaxDimension = i11;
            this.mResizeArea = -1;
            return this;
        }

        @NonNull
        public Builder setRegion(@Px int i11, @Px int i12, @Px int i13, @Px int i14) {
            if (this.mBitmap != null) {
                if (this.mRegion == null) {
                    this.mRegion = new Rect();
                }
                this.mRegion.set(0, 0, this.mBitmap.getWidth(), this.mBitmap.getHeight());
                if (!this.mRegion.intersect(i11, i12, i13, i14)) {
                    throw new IllegalArgumentException("The given region must intersect with the Bitmap's dimensions.");
                }
            }
            return this;
        }

        public Builder(@NonNull List<Swatch> list) {
            this.mTargets = new ArrayList();
            this.mMaxColors = 16;
            this.mResizeArea = 12544;
            this.mResizeMaxDimension = -1;
            ArrayList arrayList = new ArrayList();
            this.mFilters = arrayList;
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException("List of Swatches is not valid");
            }
            arrayList.add(Palette.f37275a);
            this.mSwatches = list;
            this.mBitmap = null;
        }

        @NonNull
        public AsyncTask<Bitmap, Void, Palette> generate(@NonNull final PaletteAsyncListener paletteAsyncListener) {
            if (paletteAsyncListener != null) {
                return new AsyncTask<Bitmap, Void, Palette>() {
                    @Nullable
                    /* renamed from: a */
                    public Palette doInBackground(Bitmap... bitmapArr) {
                        try {
                            return Builder.this.generate();
                        } catch (Exception e11) {
                            Log.e("Palette", "Exception thrown during async generate", e11);
                            return null;
                        }
                    }

                    /* renamed from: b */
                    public void onPostExecute(@Nullable Palette palette) {
                        paletteAsyncListener.onGenerated(palette);
                    }
                }.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Bitmap[]{this.mBitmap});
            }
            throw new IllegalArgumentException("listener can not be null");
        }
    }
}
