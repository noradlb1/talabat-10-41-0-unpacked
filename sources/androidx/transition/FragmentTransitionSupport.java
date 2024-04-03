package androidx.transition;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.CancellationSignal;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransitionImpl;
import androidx.transition.Transition;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"RestrictedApi"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class FragmentTransitionSupport extends FragmentTransitionImpl {
    private static boolean hasSimpleTarget(Transition transition) {
        if (!FragmentTransitionImpl.isNullOrEmpty(transition.getTargetIds()) || !FragmentTransitionImpl.isNullOrEmpty(transition.getTargetNames()) || !FragmentTransitionImpl.isNullOrEmpty(transition.getTargetTypes())) {
            return true;
        }
        return false;
    }

    public void addTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).addTarget(view);
        }
    }

    public void addTargets(Object obj, ArrayList<View> arrayList) {
        Transition transition = (Transition) obj;
        if (transition != null) {
            int i11 = 0;
            if (transition instanceof TransitionSet) {
                TransitionSet transitionSet = (TransitionSet) transition;
                int transitionCount = transitionSet.getTransitionCount();
                while (i11 < transitionCount) {
                    addTargets(transitionSet.getTransitionAt(i11), arrayList);
                    i11++;
                }
            } else if (!hasSimpleTarget(transition) && FragmentTransitionImpl.isNullOrEmpty(transition.getTargets())) {
                int size = arrayList.size();
                while (i11 < size) {
                    transition.addTarget(arrayList.get(i11));
                    i11++;
                }
            }
        }
    }

    public void beginDelayedTransition(ViewGroup viewGroup, Object obj) {
        TransitionManager.beginDelayedTransition(viewGroup, (Transition) obj);
    }

    public boolean canHandle(Object obj) {
        return obj instanceof Transition;
    }

    public Object cloneTransition(Object obj) {
        if (obj != null) {
            return ((Transition) obj).clone();
        }
        return null;
    }

    public Object mergeTransitionsInSequence(Object obj, Object obj2, Object obj3) {
        Transition transition = (Transition) obj;
        Transition transition2 = (Transition) obj2;
        Transition transition3 = (Transition) obj3;
        if (transition != null && transition2 != null) {
            transition = new TransitionSet().addTransition(transition).addTransition(transition2).setOrdering(1);
        } else if (transition == null) {
            if (transition2 != null) {
                transition = transition2;
            } else {
                transition = null;
            }
        }
        if (transition3 == null) {
            return transition;
        }
        TransitionSet transitionSet = new TransitionSet();
        if (transition != null) {
            transitionSet.addTransition(transition);
        }
        transitionSet.addTransition(transition3);
        return transitionSet;
    }

    public Object mergeTransitionsTogether(Object obj, Object obj2, Object obj3) {
        TransitionSet transitionSet = new TransitionSet();
        if (obj != null) {
            transitionSet.addTransition((Transition) obj);
        }
        if (obj2 != null) {
            transitionSet.addTransition((Transition) obj2);
        }
        if (obj3 != null) {
            transitionSet.addTransition((Transition) obj3);
        }
        return transitionSet;
    }

    public void removeTarget(Object obj, View view) {
        if (obj != null) {
            ((Transition) obj).removeTarget(view);
        }
    }

    public void replaceTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        int i11;
        Transition transition = (Transition) obj;
        int i12 = 0;
        if (transition instanceof TransitionSet) {
            TransitionSet transitionSet = (TransitionSet) transition;
            int transitionCount = transitionSet.getTransitionCount();
            while (i12 < transitionCount) {
                replaceTargets(transitionSet.getTransitionAt(i12), arrayList, arrayList2);
                i12++;
            }
        } else if (!hasSimpleTarget(transition)) {
            List<View> targets = transition.getTargets();
            if (targets.size() == arrayList.size() && targets.containsAll(arrayList)) {
                if (arrayList2 == null) {
                    i11 = 0;
                } else {
                    i11 = arrayList2.size();
                }
                while (i12 < i11) {
                    transition.addTarget(arrayList2.get(i12));
                    i12++;
                }
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    transition.removeTarget(arrayList.get(size));
                }
            }
        }
    }

    public void scheduleHideFragmentView(Object obj, final View view, final ArrayList<View> arrayList) {
        ((Transition) obj).addListener(new Transition.TransitionListener() {
            public void onTransitionCancel(@NonNull Transition transition) {
            }

            public void onTransitionEnd(@NonNull Transition transition) {
                transition.removeListener(this);
                view.setVisibility(8);
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((View) arrayList.get(i11)).setVisibility(0);
                }
            }

            public void onTransitionPause(@NonNull Transition transition) {
            }

            public void onTransitionResume(@NonNull Transition transition) {
            }

            public void onTransitionStart(@NonNull Transition transition) {
                transition.removeListener(this);
                transition.addListener(this);
            }
        });
    }

    public void scheduleRemoveTargets(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3) {
        final Object obj5 = obj2;
        final ArrayList<View> arrayList4 = arrayList;
        final Object obj6 = obj3;
        final ArrayList<View> arrayList5 = arrayList2;
        final Object obj7 = obj4;
        final ArrayList<View> arrayList6 = arrayList3;
        ((Transition) obj).addListener(new TransitionListenerAdapter() {
            public void onTransitionEnd(@NonNull Transition transition) {
                transition.removeListener(this);
            }

            public void onTransitionStart(@NonNull Transition transition) {
                Object obj = obj5;
                if (obj != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj, arrayList4, (ArrayList<View>) null);
                }
                Object obj2 = obj6;
                if (obj2 != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj2, arrayList5, (ArrayList<View>) null);
                }
                Object obj3 = obj7;
                if (obj3 != null) {
                    FragmentTransitionSupport.this.replaceTargets(obj3, arrayList6, (ArrayList<View>) null);
                }
            }
        });
    }

    public void setEpicenter(Object obj, View view) {
        if (view != null) {
            final Rect rect = new Rect();
            getBoundsOnScreen(view, rect);
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() {
                public Rect onGetEpicenter(@NonNull Transition transition) {
                    return rect;
                }
            });
        }
    }

    public void setListenerForTransitionEnd(@NonNull Fragment fragment, @NonNull Object obj, @NonNull CancellationSignal cancellationSignal, @NonNull final Runnable runnable) {
        final Transition transition = (Transition) obj;
        cancellationSignal.setOnCancelListener(new CancellationSignal.OnCancelListener() {
            public void onCancel() {
                transition.cancel();
            }
        });
        transition.addListener(new Transition.TransitionListener() {
            public void onTransitionCancel(@NonNull Transition transition) {
            }

            public void onTransitionEnd(@NonNull Transition transition) {
                runnable.run();
            }

            public void onTransitionPause(@NonNull Transition transition) {
            }

            public void onTransitionResume(@NonNull Transition transition) {
            }

            public void onTransitionStart(@NonNull Transition transition) {
            }
        });
    }

    public void setSharedElementTargets(Object obj, View view, ArrayList<View> arrayList) {
        TransitionSet transitionSet = (TransitionSet) obj;
        List<View> targets = transitionSet.getTargets();
        targets.clear();
        int size = arrayList.size();
        for (int i11 = 0; i11 < size; i11++) {
            FragmentTransitionImpl.bfsAddViewChildren(targets, arrayList.get(i11));
        }
        targets.add(view);
        arrayList.add(view);
        addTargets(transitionSet, arrayList);
    }

    public void swapSharedElementTargets(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2) {
        TransitionSet transitionSet = (TransitionSet) obj;
        if (transitionSet != null) {
            transitionSet.getTargets().clear();
            transitionSet.getTargets().addAll(arrayList2);
            replaceTargets(transitionSet, arrayList, arrayList2);
        }
    }

    public Object wrapTransitionInSet(Object obj) {
        if (obj == null) {
            return null;
        }
        TransitionSet transitionSet = new TransitionSet();
        transitionSet.addTransition((Transition) obj);
        return transitionSet;
    }

    public void setEpicenter(Object obj, final Rect rect) {
        if (obj != null) {
            ((Transition) obj).setEpicenterCallback(new Transition.EpicenterCallback() {
                public Rect onGetEpicenter(@NonNull Transition transition) {
                    Rect rect = rect;
                    if (rect == null || rect.isEmpty()) {
                        return null;
                    }
                    return rect;
                }
            });
        }
    }
}
