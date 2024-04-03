package androidx.transition;

import android.annotation.SuppressLint;
import androidx.annotation.StyleableRes;

@SuppressLint({"InlinedApi"})
class Styleable {
    @StyleableRes

    /* renamed from: a  reason: collision with root package name */
    public static final int[] f37780a = {16842799, 16843740, 16843841, 16843842, 16843853, 16843854};
    @StyleableRes

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f37781b = {16843741, 16843742, 16843743};
    @StyleableRes

    /* renamed from: c  reason: collision with root package name */
    public static final int[] f37782c = {16843073, 16843160, 16843746, 16843855};
    @StyleableRes

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f37783d = {16843983};
    @StyleableRes

    /* renamed from: e  reason: collision with root package name */
    public static final int[] f37784e = {16843900};
    @StyleableRes

    /* renamed from: f  reason: collision with root package name */
    public static final int[] f37785f = {16843745};
    @StyleableRes

    /* renamed from: g  reason: collision with root package name */
    public static final int[] f37786g = {16843964, 16843965};
    @StyleableRes

    /* renamed from: h  reason: collision with root package name */
    public static final int[] f37787h = {16843824};
    @StyleableRes

    /* renamed from: i  reason: collision with root package name */
    public static final int[] f37788i = {16843744};
    @StyleableRes

    /* renamed from: j  reason: collision with root package name */
    public static final int[] f37789j = {16843901, 16843902, 16843903};
    @StyleableRes

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f37790k = {16843978};

    public interface ArcMotion {
        @StyleableRes
        public static final int MAXIMUM_ANGLE = 2;
        @StyleableRes
        public static final int MINIMUM_HORIZONTAL_ANGLE = 0;
        @StyleableRes
        public static final int MINIMUM_VERTICAL_ANGLE = 1;
    }

    public interface ChangeBounds {
        @StyleableRes
        public static final int RESIZE_CLIP = 0;
    }

    public interface ChangeTransform {
        @StyleableRes
        public static final int REPARENT = 0;
        @StyleableRes
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    public interface Fade {
        @StyleableRes
        public static final int FADING_MODE = 0;
    }

    public interface PatternPathMotion {
        @StyleableRes
        public static final int PATTERN_PATH_DATA = 0;
    }

    public interface Slide {
        @StyleableRes
        public static final int SLIDE_EDGE = 0;
    }

    public interface Transition {
        @StyleableRes
        public static final int DURATION = 1;
        @StyleableRes
        public static final int INTERPOLATOR = 0;
        @StyleableRes
        public static final int MATCH_ORDER = 3;
        @StyleableRes
        public static final int START_DELAY = 2;
    }

    public interface TransitionManager {
        @StyleableRes
        public static final int FROM_SCENE = 0;
        @StyleableRes
        public static final int TO_SCENE = 1;
        @StyleableRes
        public static final int TRANSITION = 2;
    }

    public interface TransitionSet {
        @StyleableRes
        public static final int TRANSITION_ORDERING = 0;
    }

    public interface TransitionTarget {
        @StyleableRes
        public static final int EXCLUDE_CLASS = 3;
        @StyleableRes
        public static final int EXCLUDE_ID = 2;
        @StyleableRes
        public static final int EXCLUDE_NAME = 5;
        @StyleableRes
        public static final int TARGET_CLASS = 0;
        @StyleableRes
        public static final int TARGET_ID = 1;
        @StyleableRes
        public static final int TARGET_NAME = 4;
    }

    public interface VisibilityTransition {
        @StyleableRes
        public static final int TRANSITION_VISIBILITY_MODE = 0;
    }

    private Styleable() {
    }
}
