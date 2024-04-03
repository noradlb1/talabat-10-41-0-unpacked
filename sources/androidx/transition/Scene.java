package androidx.transition;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class Scene {
    private Context mContext;
    private Runnable mEnterAction;
    private Runnable mExitAction;
    private View mLayout;
    private int mLayoutId;
    private ViewGroup mSceneRoot;

    public Scene(@NonNull ViewGroup viewGroup) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
    }

    public static void b(@NonNull ViewGroup viewGroup, @Nullable Scene scene) {
        viewGroup.setTag(R.id.transition_current_scene, scene);
    }

    @Nullable
    public static Scene getCurrentScene(@NonNull ViewGroup viewGroup) {
        return (Scene) viewGroup.getTag(R.id.transition_current_scene);
    }

    @NonNull
    public static Scene getSceneForLayout(@NonNull ViewGroup viewGroup, @LayoutRes int i11, @NonNull Context context) {
        int i12 = R.id.transition_scene_layoutid_cache;
        SparseArray sparseArray = (SparseArray) viewGroup.getTag(i12);
        if (sparseArray == null) {
            sparseArray = new SparseArray();
            viewGroup.setTag(i12, sparseArray);
        }
        Scene scene = (Scene) sparseArray.get(i11);
        if (scene != null) {
            return scene;
        }
        Scene scene2 = new Scene(viewGroup, i11, context);
        sparseArray.put(i11, scene2);
        return scene2;
    }

    public boolean a() {
        return this.mLayoutId > 0;
    }

    public void enter() {
        if (this.mLayoutId > 0 || this.mLayout != null) {
            getSceneRoot().removeAllViews();
            if (this.mLayoutId > 0) {
                LayoutInflater.from(this.mContext).inflate(this.mLayoutId, this.mSceneRoot);
            } else {
                this.mSceneRoot.addView(this.mLayout);
            }
        }
        Runnable runnable = this.mEnterAction;
        if (runnable != null) {
            runnable.run();
        }
        b(this.mSceneRoot, this);
    }

    public void exit() {
        Runnable runnable;
        if (getCurrentScene(this.mSceneRoot) == this && (runnable = this.mExitAction) != null) {
            runnable.run();
        }
    }

    @NonNull
    public ViewGroup getSceneRoot() {
        return this.mSceneRoot;
    }

    public void setEnterAction(@Nullable Runnable runnable) {
        this.mEnterAction = runnable;
    }

    public void setExitAction(@Nullable Runnable runnable) {
        this.mExitAction = runnable;
    }

    private Scene(ViewGroup viewGroup, int i11, Context context) {
        this.mContext = context;
        this.mSceneRoot = viewGroup;
        this.mLayoutId = i11;
    }

    public Scene(@NonNull ViewGroup viewGroup, @NonNull View view) {
        this.mLayoutId = -1;
        this.mSceneRoot = viewGroup;
        this.mLayout = view;
    }
}
