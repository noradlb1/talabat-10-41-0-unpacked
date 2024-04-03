package androidx.customview.widget;

import android.graphics.Rect;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

class FocusStrategy {

    public interface BoundsAdapter<T> {
        void obtainBounds(T t11, Rect rect);
    }

    public interface CollectionAdapter<T, V> {
        V get(T t11, int i11);

        int size(T t11);
    }

    public static class SequentialComparator<T> implements Comparator<T> {
        private final BoundsAdapter<T> mAdapter;
        private final boolean mIsLayoutRtl;
        private final Rect mTemp1 = new Rect();
        private final Rect mTemp2 = new Rect();

        public SequentialComparator(boolean z11, BoundsAdapter<T> boundsAdapter) {
            this.mIsLayoutRtl = z11;
            this.mAdapter = boundsAdapter;
        }

        public int compare(T t11, T t12) {
            Rect rect = this.mTemp1;
            Rect rect2 = this.mTemp2;
            this.mAdapter.obtainBounds(t11, rect);
            this.mAdapter.obtainBounds(t12, rect2);
            int i11 = rect.top;
            int i12 = rect2.top;
            if (i11 < i12) {
                return -1;
            }
            if (i11 > i12) {
                return 1;
            }
            int i13 = rect.left;
            int i14 = rect2.left;
            if (i13 < i14) {
                if (this.mIsLayoutRtl) {
                    return 1;
                }
                return -1;
            } else if (i13 <= i14) {
                int i15 = rect.bottom;
                int i16 = rect2.bottom;
                if (i15 < i16) {
                    return -1;
                }
                if (i15 > i16) {
                    return 1;
                }
                int i17 = rect.right;
                int i18 = rect2.right;
                if (i17 < i18) {
                    if (this.mIsLayoutRtl) {
                        return 1;
                    }
                    return -1;
                } else if (i17 <= i18) {
                    return 0;
                } else {
                    if (this.mIsLayoutRtl) {
                        return -1;
                    }
                    return 1;
                }
            } else if (this.mIsLayoutRtl) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    private FocusStrategy() {
    }

    private static boolean beamBeats(int i11, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        boolean beamsOverlap = beamsOverlap(i11, rect, rect2);
        if (beamsOverlap(i11, rect, rect3) || !beamsOverlap) {
            return false;
        }
        if (!isToDirectionOf(i11, rect, rect3) || i11 == 17 || i11 == 66) {
            return true;
        }
        if (majorAxisDistance(i11, rect, rect2) < majorAxisDistanceToFarEdge(i11, rect, rect3)) {
            return true;
        }
        return false;
    }

    private static boolean beamsOverlap(int i11, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i11 != 17) {
            if (i11 != 33) {
                if (i11 != 66) {
                    if (i11 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                return false;
            }
            return true;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            return false;
        }
        return true;
    }

    public static <L, T> T findNextFocusInAbsoluteDirection(@NonNull L l11, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t11, @NonNull Rect rect, int i11) {
        Rect rect2 = new Rect(rect);
        if (i11 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i11 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i11 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else if (i11 == 130) {
            rect2.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        int size = collectionAdapter.size(l11);
        Rect rect3 = new Rect();
        T t12 = null;
        for (int i12 = 0; i12 < size; i12++) {
            T t13 = collectionAdapter.get(l11, i12);
            if (t13 != t11) {
                boundsAdapter.obtainBounds(t13, rect3);
                if (isBetterCandidate(i11, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t12 = t13;
                }
            }
        }
        return t12;
    }

    public static <L, T> T findNextFocusInRelativeDirection(@NonNull L l11, @NonNull CollectionAdapter<L, T> collectionAdapter, @NonNull BoundsAdapter<T> boundsAdapter, @Nullable T t11, int i11, boolean z11, boolean z12) {
        int size = collectionAdapter.size(l11);
        ArrayList arrayList = new ArrayList(size);
        for (int i12 = 0; i12 < size; i12++) {
            arrayList.add(collectionAdapter.get(l11, i12));
        }
        Collections.sort(arrayList, new SequentialComparator(z11, boundsAdapter));
        if (i11 == 1) {
            return getPreviousFocusable(t11, arrayList, z12);
        }
        if (i11 == 2) {
            return getNextFocusable(t11, arrayList, z12);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    private static <T> T getNextFocusable(T t11, ArrayList<T> arrayList, boolean z11) {
        int i11;
        int size = arrayList.size();
        if (t11 == null) {
            i11 = -1;
        } else {
            i11 = arrayList.lastIndexOf(t11);
        }
        int i12 = i11 + 1;
        if (i12 < size) {
            return arrayList.get(i12);
        }
        if (!z11 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    private static <T> T getPreviousFocusable(T t11, ArrayList<T> arrayList, boolean z11) {
        int i11;
        int size = arrayList.size();
        if (t11 == null) {
            i11 = size;
        } else {
            i11 = arrayList.indexOf(t11);
        }
        int i12 = i11 - 1;
        if (i12 >= 0) {
            return arrayList.get(i12);
        }
        if (!z11 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    private static int getWeightedDistanceFor(int i11, int i12) {
        return (i11 * 13 * i11) + (i12 * i12);
    }

    private static boolean isBetterCandidate(int i11, @NonNull Rect rect, @NonNull Rect rect2, @NonNull Rect rect3) {
        if (!isCandidate(rect, rect2, i11)) {
            return false;
        }
        if (!isCandidate(rect, rect3, i11) || beamBeats(i11, rect, rect2, rect3)) {
            return true;
        }
        if (!beamBeats(i11, rect, rect3, rect2) && getWeightedDistanceFor(majorAxisDistance(i11, rect, rect2), minorAxisDistance(i11, rect, rect2)) < getWeightedDistanceFor(majorAxisDistance(i11, rect, rect3), minorAxisDistance(i11, rect, rect3))) {
            return true;
        }
        return false;
    }

    private static boolean isCandidate(@NonNull Rect rect, @NonNull Rect rect2, int i11) {
        if (i11 == 17) {
            int i12 = rect.right;
            int i13 = rect2.right;
            if ((i12 > i13 || rect.left >= i13) && rect.left > rect2.left) {
                return true;
            }
            return false;
        } else if (i11 == 33) {
            int i14 = rect.bottom;
            int i15 = rect2.bottom;
            if ((i14 > i15 || rect.top >= i15) && rect.top > rect2.top) {
                return true;
            }
            return false;
        } else if (i11 == 66) {
            int i16 = rect.left;
            int i17 = rect2.left;
            if ((i16 < i17 || rect.right <= i17) && rect.right < rect2.right) {
                return true;
            }
            return false;
        } else if (i11 == 130) {
            int i18 = rect.top;
            int i19 = rect2.top;
            if ((i18 < i19 || rect.bottom <= i19) && rect.bottom < rect2.bottom) {
                return true;
            }
            return false;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    private static boolean isToDirectionOf(int i11, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i11 != 17) {
            if (i11 != 33) {
                if (i11 != 66) {
                    if (i11 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    } else if (rect.bottom <= rect2.top) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (rect.right <= rect2.left) {
                    return true;
                } else {
                    return false;
                }
            } else if (rect.top >= rect2.bottom) {
                return true;
            } else {
                return false;
            }
        } else if (rect.left >= rect2.right) {
            return true;
        } else {
            return false;
        }
    }

    private static int majorAxisDistance(int i11, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(0, majorAxisDistanceRaw(i11, rect, rect2));
    }

    private static int majorAxisDistanceRaw(int i11, @NonNull Rect rect, @NonNull Rect rect2) {
        int i12;
        int i13;
        if (i11 == 17) {
            i12 = rect.left;
            i13 = rect2.right;
        } else if (i11 == 33) {
            i12 = rect.top;
            i13 = rect2.bottom;
        } else if (i11 == 66) {
            i12 = rect2.left;
            i13 = rect.right;
        } else if (i11 == 130) {
            i12 = rect2.top;
            i13 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i12 - i13;
    }

    private static int majorAxisDistanceToFarEdge(int i11, @NonNull Rect rect, @NonNull Rect rect2) {
        return Math.max(1, majorAxisDistanceToFarEdgeRaw(i11, rect, rect2));
    }

    private static int majorAxisDistanceToFarEdgeRaw(int i11, @NonNull Rect rect, @NonNull Rect rect2) {
        int i12;
        int i13;
        if (i11 == 17) {
            i12 = rect.left;
            i13 = rect2.left;
        } else if (i11 == 33) {
            i12 = rect.top;
            i13 = rect2.top;
        } else if (i11 == 66) {
            i12 = rect2.right;
            i13 = rect.right;
        } else if (i11 == 130) {
            i12 = rect2.bottom;
            i13 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i12 - i13;
    }

    private static int minorAxisDistance(int i11, @NonNull Rect rect, @NonNull Rect rect2) {
        if (i11 != 17) {
            if (i11 != 33) {
                if (i11 != 66) {
                    if (i11 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
