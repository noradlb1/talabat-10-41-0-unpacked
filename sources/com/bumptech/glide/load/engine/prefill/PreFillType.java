package com.bumptech.glide.load.engine.prefill;

import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.util.Preconditions;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public final class PreFillType {
    @VisibleForTesting
    static final Bitmap.Config DEFAULT_CONFIG = Bitmap.Config.RGB_565;
    private final Bitmap.Config config;
    private final int height;
    private final int weight;
    private final int width;

    public static class Builder {
        private Bitmap.Config config;
        private final int height;
        private int weight;
        private final int width;

        public Builder(int i11) {
            this(i11, i11);
        }

        public PreFillType build() {
            return new PreFillType(this.width, this.height, this.config, this.weight);
        }

        public Bitmap.Config getConfig() {
            return this.config;
        }

        public Builder setConfig(@Nullable Bitmap.Config config2) {
            this.config = config2;
            return this;
        }

        public Builder setWeight(int i11) {
            if (i11 > 0) {
                this.weight = i11;
                return this;
            }
            throw new IllegalArgumentException("Weight must be > 0");
        }

        public Builder(int i11, int i12) {
            this.weight = 1;
            if (i11 <= 0) {
                throw new IllegalArgumentException("Width must be > 0");
            } else if (i12 > 0) {
                this.width = i11;
                this.height = i12;
            } else {
                throw new IllegalArgumentException("Height must be > 0");
            }
        }
    }

    public PreFillType(int i11, int i12, Bitmap.Config config2, int i13) {
        this.config = (Bitmap.Config) Preconditions.checkNotNull(config2, "Config must not be null");
        this.width = i11;
        this.height = i12;
        this.weight = i13;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PreFillType)) {
            return false;
        }
        PreFillType preFillType = (PreFillType) obj;
        if (this.height == preFillType.height && this.width == preFillType.width && this.weight == preFillType.weight && this.config == preFillType.config) {
            return true;
        }
        return false;
    }

    public Bitmap.Config getConfig() {
        return this.config;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (((((this.width * 31) + this.height) * 31) + this.config.hashCode()) * 31) + this.weight;
    }

    public String toString() {
        return "PreFillSize{width=" + this.width + ", height=" + this.height + ", config=" + this.config + ", weight=" + this.weight + AbstractJsonLexerKt.END_OBJ;
    }
}
