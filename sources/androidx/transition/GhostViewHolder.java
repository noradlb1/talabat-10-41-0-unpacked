package androidx.transition;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import java.util.ArrayList;

@SuppressLint({"ViewConstructor"})
class GhostViewHolder extends FrameLayout {
    private boolean mAttached = true;
    @NonNull
    private ViewGroup mParent;

    public GhostViewHolder(ViewGroup viewGroup) {
        super(viewGroup.getContext());
        setClipChildren(false);
        this.mParent = viewGroup;
        viewGroup.setTag(R.id.ghost_view_holder, this);
        ViewGroupUtils.b(this.mParent).add(this);
    }

    public static GhostViewHolder b(@NonNull ViewGroup viewGroup) {
        return (GhostViewHolder) viewGroup.getTag(R.id.ghost_view_holder);
    }

    private int getInsertIndex(ArrayList<View> arrayList) {
        ArrayList arrayList2 = new ArrayList();
        int childCount = getChildCount() - 1;
        int i11 = 0;
        while (i11 <= childCount) {
            int i12 = (i11 + childCount) / 2;
            getParents(((GhostViewPort) getChildAt(i12)).f37775d, arrayList2);
            if (isOnTop(arrayList, (ArrayList<View>) arrayList2)) {
                i11 = i12 + 1;
            } else {
                childCount = i12 - 1;
            }
            arrayList2.clear();
        }
        return i11;
    }

    private static void getParents(View view, ArrayList<View> arrayList) {
        ViewParent parent = view.getParent();
        if (parent instanceof ViewGroup) {
            getParents((View) parent, arrayList);
        }
        arrayList.add(view);
    }

    private static boolean isOnTop(ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        if (arrayList.isEmpty() || arrayList2.isEmpty() || arrayList.get(0) != arrayList2.get(0)) {
            return true;
        }
        int min = Math.min(arrayList.size(), arrayList2.size());
        for (int i11 = 1; i11 < min; i11++) {
            View view = arrayList.get(i11);
            View view2 = arrayList2.get(i11);
            if (view != view2) {
                return isOnTop(view, view2);
            }
        }
        if (arrayList2.size() == min) {
            return true;
        }
        return false;
    }

    public void a(GhostViewPort ghostViewPort) {
        ArrayList arrayList = new ArrayList();
        getParents(ghostViewPort.f37775d, arrayList);
        int insertIndex = getInsertIndex(arrayList);
        if (insertIndex < 0 || insertIndex >= getChildCount()) {
            addView(ghostViewPort);
        } else {
            addView(ghostViewPort, insertIndex);
        }
    }

    public void c() {
        if (this.mAttached) {
            ViewGroupUtils.b(this.mParent).remove(this);
            ViewGroupUtils.b(this.mParent).add(this);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewAdded(View view) {
        if (this.mAttached) {
            super.onViewAdded(view);
            return;
        }
        throw new IllegalStateException("This GhostViewHolder is detached!");
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if ((getChildCount() == 1 && getChildAt(0) == view) || getChildCount() == 0) {
            this.mParent.setTag(R.id.ghost_view_holder, (Object) null);
            ViewGroupUtils.b(this.mParent).remove(this);
            this.mAttached = false;
        }
    }

    private static boolean isOnTop(View view, View view2) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        int childCount = viewGroup.getChildCount();
        if (view.getZ() == view2.getZ()) {
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(ViewGroupUtils.a(viewGroup, i11));
                if (childAt == view) {
                    return false;
                }
                if (childAt == view2) {
                    break;
                }
            }
            return true;
        } else if (view.getZ() > view2.getZ()) {
            return true;
        } else {
            return false;
        }
    }
}
