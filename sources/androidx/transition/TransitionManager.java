package androidx.transition;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.collection.ArrayMap;
import androidx.core.view.ViewCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;

public class TransitionManager {
    private static final String LOG_TAG = "TransitionManager";

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<ViewGroup> f37799a = new ArrayList<>();
    private static Transition sDefaultTransition = new AutoTransition();
    private static ThreadLocal<WeakReference<ArrayMap<ViewGroup, ArrayList<Transition>>>> sRunningTransitions = new ThreadLocal<>();
    private ArrayMap<Scene, ArrayMap<Scene, Transition>> mScenePairTransitions = new ArrayMap<>();
    private ArrayMap<Scene, Transition> mSceneTransitions = new ArrayMap<>();

    public static class MultiListener implements ViewTreeObserver.OnPreDrawListener, View.OnAttachStateChangeListener {

        /* renamed from: b  reason: collision with root package name */
        public Transition f37800b;

        /* renamed from: c  reason: collision with root package name */
        public ViewGroup f37801c;

        public MultiListener(Transition transition, ViewGroup viewGroup) {
            this.f37800b = transition;
            this.f37801c = viewGroup;
        }

        private void removeListeners() {
            this.f37801c.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f37801c.removeOnAttachStateChangeListener(this);
        }

        public boolean onPreDraw() {
            removeListeners();
            if (!TransitionManager.f37799a.remove(this.f37801c)) {
                return true;
            }
            final ArrayMap<ViewGroup, ArrayList<Transition>> a11 = TransitionManager.a();
            ArrayList arrayList = a11.get(this.f37801c);
            ArrayList arrayList2 = null;
            if (arrayList == null) {
                arrayList = new ArrayList();
                a11.put(this.f37801c, arrayList);
            } else if (arrayList.size() > 0) {
                arrayList2 = new ArrayList(arrayList);
            }
            arrayList.add(this.f37800b);
            this.f37800b.addListener(new TransitionListenerAdapter() {
                public void onTransitionEnd(@NonNull Transition transition) {
                    ((ArrayList) a11.get(MultiListener.this.f37801c)).remove(transition);
                    transition.removeListener(this);
                }
            });
            this.f37800b.captureValues(this.f37801c, false);
            if (arrayList2 != null) {
                Iterator it = arrayList2.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.f37801c);
                }
            }
            this.f37800b.playTransition(this.f37801c);
            return true;
        }

        public void onViewAttachedToWindow(View view) {
        }

        public void onViewDetachedFromWindow(View view) {
            removeListeners();
            TransitionManager.f37799a.remove(this.f37801c);
            ArrayList arrayList = TransitionManager.a().get(this.f37801c);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Transition) it.next()).resume(this.f37801c);
                }
            }
            this.f37800b.clearValues(true);
        }
    }

    public static ArrayMap<ViewGroup, ArrayList<Transition>> a() {
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap;
        WeakReference weakReference = sRunningTransitions.get();
        if (weakReference != null && (arrayMap = (ArrayMap) weakReference.get()) != null) {
            return arrayMap;
        }
        ArrayMap<ViewGroup, ArrayList<Transition>> arrayMap2 = new ArrayMap<>();
        sRunningTransitions.set(new WeakReference(arrayMap2));
        return arrayMap2;
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup) {
        beginDelayedTransition(viewGroup, (Transition) null);
    }

    private static void changeScene(Scene scene, Transition transition) {
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (!f37799a.contains(sceneRoot)) {
            Scene currentScene = Scene.getCurrentScene(sceneRoot);
            if (transition == null) {
                if (currentScene != null) {
                    currentScene.exit();
                }
                scene.enter();
                return;
            }
            f37799a.add(sceneRoot);
            Transition clone = transition.clone();
            if (currentScene != null && currentScene.a()) {
                clone.setCanRemoveViews(true);
            }
            sceneChangeSetup(sceneRoot, clone);
            scene.enter();
            sceneChangeRunTransition(sceneRoot, clone);
        }
    }

    public static void endTransitions(ViewGroup viewGroup) {
        f37799a.remove(viewGroup);
        ArrayList arrayList = a().get(viewGroup);
        if (arrayList != null && !arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(arrayList);
            for (int size = arrayList2.size() - 1; size >= 0; size--) {
                ((Transition) arrayList2.get(size)).forceToEnd(viewGroup);
            }
        }
    }

    private Transition getTransition(Scene scene) {
        Scene currentScene;
        ArrayMap arrayMap;
        Transition transition;
        ViewGroup sceneRoot = scene.getSceneRoot();
        if (sceneRoot != null && (currentScene = Scene.getCurrentScene(sceneRoot)) != null && (arrayMap = this.mScenePairTransitions.get(scene)) != null && (transition = (Transition) arrayMap.get(currentScene)) != null) {
            return transition;
        }
        Transition transition2 = this.mSceneTransitions.get(scene);
        if (transition2 != null) {
            return transition2;
        }
        return sDefaultTransition;
    }

    public static void go(@NonNull Scene scene) {
        changeScene(scene, sDefaultTransition);
    }

    private static void sceneChangeRunTransition(ViewGroup viewGroup, Transition transition) {
        if (transition != null && viewGroup != null) {
            MultiListener multiListener = new MultiListener(transition, viewGroup);
            viewGroup.addOnAttachStateChangeListener(multiListener);
            viewGroup.getViewTreeObserver().addOnPreDrawListener(multiListener);
        }
    }

    private static void sceneChangeSetup(ViewGroup viewGroup, Transition transition) {
        ArrayList arrayList = a().get(viewGroup);
        if (arrayList != null && arrayList.size() > 0) {
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                ((Transition) it.next()).pause(viewGroup);
            }
        }
        if (transition != null) {
            transition.captureValues(viewGroup, true);
        }
        Scene currentScene = Scene.getCurrentScene(viewGroup);
        if (currentScene != null) {
            currentScene.exit();
        }
    }

    public void setTransition(@NonNull Scene scene, @Nullable Transition transition) {
        this.mSceneTransitions.put(scene, transition);
    }

    public void transitionTo(@NonNull Scene scene) {
        changeScene(scene, getTransition(scene));
    }

    public static void beginDelayedTransition(@NonNull ViewGroup viewGroup, @Nullable Transition transition) {
        if (!f37799a.contains(viewGroup) && ViewCompat.isLaidOut(viewGroup)) {
            f37799a.add(viewGroup);
            if (transition == null) {
                transition = sDefaultTransition;
            }
            Transition clone = transition.clone();
            sceneChangeSetup(viewGroup, clone);
            Scene.b(viewGroup, (Scene) null);
            sceneChangeRunTransition(viewGroup, clone);
        }
    }

    public static void go(@NonNull Scene scene, @Nullable Transition transition) {
        changeScene(scene, transition);
    }

    public void setTransition(@NonNull Scene scene, @NonNull Scene scene2, @Nullable Transition transition) {
        ArrayMap arrayMap = this.mScenePairTransitions.get(scene2);
        if (arrayMap == null) {
            arrayMap = new ArrayMap();
            this.mScenePairTransitions.put(scene2, arrayMap);
        }
        arrayMap.put(scene, transition);
    }
}
