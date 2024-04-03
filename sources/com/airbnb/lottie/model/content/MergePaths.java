package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.content.Content;
import com.airbnb.lottie.animation.content.MergePathsContent;
import com.airbnb.lottie.model.layer.BaseLayer;
import com.airbnb.lottie.utils.Logger;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

public class MergePaths implements ContentModel {
    private final boolean hidden;
    private final MergePathsMode mode;

    /* renamed from: name  reason: collision with root package name */
    private final String f40653name;

    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i11) {
            if (i11 == 1) {
                return MERGE;
            }
            if (i11 == 2) {
                return ADD;
            }
            if (i11 == 3) {
                return SUBTRACT;
            }
            if (i11 == 4) {
                return INTERSECT;
            }
            if (i11 != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z11) {
        this.f40653name = str;
        this.mode = mergePathsMode;
        this.hidden = z11;
    }

    public MergePathsMode getMode() {
        return this.mode;
    }

    public String getName() {
        return this.f40653name;
    }

    public boolean isHidden() {
        return this.hidden;
    }

    @Nullable
    public Content toContent(LottieDrawable lottieDrawable, BaseLayer baseLayer) {
        if (lottieDrawable.enableMergePathsForKitKatAndAbove()) {
            return new MergePathsContent(this);
        }
        Logger.warning("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.mode + AbstractJsonLexerKt.END_OBJ;
    }
}
