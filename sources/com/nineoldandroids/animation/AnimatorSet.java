package com.nineoldandroids.animation;

import android.view.animation.Interpolator;
import com.nineoldandroids.animation.Animator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public final class AnimatorSet extends Animator {

    /* renamed from: c  reason: collision with root package name */
    public boolean f52793c = false;
    private ValueAnimator mDelayAnim = null;
    private long mDuration = -1;
    private boolean mNeedsSort = true;
    /* access modifiers changed from: private */
    public HashMap<Animator, Node> mNodeMap = new HashMap<>();
    /* access modifiers changed from: private */
    public ArrayList<Node> mNodes = new ArrayList<>();
    /* access modifiers changed from: private */
    public ArrayList<Animator> mPlayingSet = new ArrayList<>();
    private AnimatorSetListener mSetListener = null;
    /* access modifiers changed from: private */
    public ArrayList<Node> mSortedNodes = new ArrayList<>();
    private long mStartDelay = 0;
    /* access modifiers changed from: private */
    public boolean mStarted = false;

    public class AnimatorSetListener implements Animator.AnimatorListener {
        private AnimatorSet mAnimatorSet;

        public AnimatorSetListener(AnimatorSet animatorSet) {
            this.mAnimatorSet = animatorSet;
        }

        public void onAnimationCancel(Animator animator) {
            ArrayList<Animator.AnimatorListener> arrayList;
            AnimatorSet animatorSet = AnimatorSet.this;
            if (!animatorSet.f52793c && animatorSet.mPlayingSet.size() == 0 && (arrayList = AnimatorSet.this.f52792b) != null) {
                int size = arrayList.size();
                for (int i11 = 0; i11 < size; i11++) {
                    AnimatorSet.this.f52792b.get(i11).onAnimationCancel(this.mAnimatorSet);
                }
            }
        }

        public void onAnimationEnd(Animator animator) {
            animator.removeListener(this);
            AnimatorSet.this.mPlayingSet.remove(animator);
            boolean z11 = true;
            ((Node) this.mAnimatorSet.mNodeMap.get(animator)).done = true;
            if (!AnimatorSet.this.f52793c) {
                ArrayList c11 = this.mAnimatorSet.mSortedNodes;
                int size = c11.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        break;
                    } else if (!((Node) c11.get(i11)).done) {
                        z11 = false;
                        break;
                    } else {
                        i11++;
                    }
                }
                if (z11) {
                    ArrayList<Animator.AnimatorListener> arrayList = AnimatorSet.this.f52792b;
                    if (arrayList != null) {
                        ArrayList arrayList2 = (ArrayList) arrayList.clone();
                        int size2 = arrayList2.size();
                        for (int i12 = 0; i12 < size2; i12++) {
                            ((Animator.AnimatorListener) arrayList2.get(i12)).onAnimationEnd(this.mAnimatorSet);
                        }
                    }
                    boolean unused = this.mAnimatorSet.mStarted = false;
                }
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public static class Dependency {
        public Node node;
        public int rule;

        public Dependency(Node node2, int i11) {
            this.node = node2;
            this.rule = i11;
        }
    }

    public static class DependencyListener implements Animator.AnimatorListener {
        private AnimatorSet mAnimatorSet;
        private Node mNode;
        private int mRule;

        public DependencyListener(AnimatorSet animatorSet, Node node, int i11) {
            this.mAnimatorSet = animatorSet;
            this.mNode = node;
            this.mRule = i11;
        }

        private void startIfReady(Animator animator) {
            Dependency dependency;
            if (!this.mAnimatorSet.f52793c) {
                int size = this.mNode.tmpDependencies.size();
                int i11 = 0;
                while (true) {
                    if (i11 >= size) {
                        dependency = null;
                        break;
                    }
                    dependency = this.mNode.tmpDependencies.get(i11);
                    if (dependency.rule == this.mRule && dependency.node.animation == animator) {
                        animator.removeListener(this);
                        break;
                    }
                    i11++;
                }
                this.mNode.tmpDependencies.remove(dependency);
                if (this.mNode.tmpDependencies.size() == 0) {
                    this.mNode.animation.start();
                    this.mAnimatorSet.mPlayingSet.add(this.mNode.animation);
                }
            }
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if (this.mRule == 1) {
                startIfReady(animator);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            if (this.mRule == 0) {
                startIfReady(animator);
            }
        }
    }

    public static class Node implements Cloneable {
        public Animator animation;
        public ArrayList<Dependency> dependencies = null;
        public boolean done = false;
        public ArrayList<Node> nodeDependencies = null;
        public ArrayList<Node> nodeDependents = null;
        public ArrayList<Dependency> tmpDependencies = null;

        public Node(Animator animator) {
            this.animation = animator;
        }

        public void addDependency(Dependency dependency) {
            if (this.dependencies == null) {
                this.dependencies = new ArrayList<>();
                this.nodeDependencies = new ArrayList<>();
            }
            this.dependencies.add(dependency);
            if (!this.nodeDependencies.contains(dependency.node)) {
                this.nodeDependencies.add(dependency.node);
            }
            Node node = dependency.node;
            if (node.nodeDependents == null) {
                node.nodeDependents = new ArrayList<>();
            }
            node.nodeDependents.add(this);
        }

        public Node clone() {
            try {
                Node node = (Node) super.clone();
                node.animation = this.animation.clone();
                return node;
            } catch (CloneNotSupportedException unused) {
                throw new AssertionError();
            }
        }
    }

    private void sortNodes() {
        if (this.mNeedsSort) {
            this.mSortedNodes.clear();
            ArrayList arrayList = new ArrayList();
            int size = this.mNodes.size();
            for (int i11 = 0; i11 < size; i11++) {
                Node node = this.mNodes.get(i11);
                ArrayList<Dependency> arrayList2 = node.dependencies;
                if (arrayList2 == null || arrayList2.size() == 0) {
                    arrayList.add(node);
                }
            }
            ArrayList arrayList3 = new ArrayList();
            while (arrayList.size() > 0) {
                int size2 = arrayList.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    Node node2 = (Node) arrayList.get(i12);
                    this.mSortedNodes.add(node2);
                    ArrayList<Node> arrayList4 = node2.nodeDependents;
                    if (arrayList4 != null) {
                        int size3 = arrayList4.size();
                        for (int i13 = 0; i13 < size3; i13++) {
                            Node node3 = node2.nodeDependents.get(i13);
                            node3.nodeDependencies.remove(node2);
                            if (node3.nodeDependencies.size() == 0) {
                                arrayList3.add(node3);
                            }
                        }
                    }
                }
                arrayList.clear();
                arrayList.addAll(arrayList3);
                arrayList3.clear();
            }
            this.mNeedsSort = false;
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
            }
            return;
        }
        int size4 = this.mNodes.size();
        for (int i14 = 0; i14 < size4; i14++) {
            Node node4 = this.mNodes.get(i14);
            ArrayList<Dependency> arrayList5 = node4.dependencies;
            if (arrayList5 != null && arrayList5.size() > 0) {
                int size5 = node4.dependencies.size();
                for (int i15 = 0; i15 < size5; i15++) {
                    Dependency dependency = node4.dependencies.get(i15);
                    if (node4.nodeDependencies == null) {
                        node4.nodeDependencies = new ArrayList<>();
                    }
                    if (!node4.nodeDependencies.contains(dependency.node)) {
                        node4.nodeDependencies.add(dependency.node);
                    }
                }
            }
            node4.done = false;
        }
    }

    public void cancel() {
        ArrayList arrayList;
        this.f52793c = true;
        if (isStarted()) {
            ArrayList<Animator.AnimatorListener> arrayList2 = this.f52792b;
            if (arrayList2 != null) {
                arrayList = (ArrayList) arrayList2.clone();
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((Animator.AnimatorListener) it.next()).onAnimationCancel(this);
                }
            } else {
                arrayList = null;
            }
            ValueAnimator valueAnimator = this.mDelayAnim;
            if (valueAnimator != null && valueAnimator.isRunning()) {
                this.mDelayAnim.cancel();
            } else if (this.mSortedNodes.size() > 0) {
                Iterator<Node> it2 = this.mSortedNodes.iterator();
                while (it2.hasNext()) {
                    it2.next().animation.cancel();
                }
            }
            if (arrayList != null) {
                Iterator it3 = arrayList.iterator();
                while (it3.hasNext()) {
                    ((Animator.AnimatorListener) it3.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    public void end() {
        this.f52793c = true;
        if (isStarted()) {
            if (this.mSortedNodes.size() != this.mNodes.size()) {
                sortNodes();
                Iterator<Node> it = this.mSortedNodes.iterator();
                while (it.hasNext()) {
                    Node next = it.next();
                    if (this.mSetListener == null) {
                        this.mSetListener = new AnimatorSetListener(this);
                    }
                    next.animation.addListener(this.mSetListener);
                }
            }
            ValueAnimator valueAnimator = this.mDelayAnim;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            if (this.mSortedNodes.size() > 0) {
                Iterator<Node> it2 = this.mSortedNodes.iterator();
                while (it2.hasNext()) {
                    it2.next().animation.end();
                }
            }
            ArrayList<Animator.AnimatorListener> arrayList = this.f52792b;
            if (arrayList != null) {
                Iterator it3 = ((ArrayList) arrayList.clone()).iterator();
                while (it3.hasNext()) {
                    ((Animator.AnimatorListener) it3.next()).onAnimationEnd(this);
                }
            }
            this.mStarted = false;
        }
    }

    public ArrayList<Animator> getChildAnimations() {
        ArrayList<Animator> arrayList = new ArrayList<>();
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().animation);
        }
        return arrayList;
    }

    public long getDuration() {
        return this.mDuration;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public boolean isRunning() {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            if (it.next().animation.isRunning()) {
                return true;
            }
        }
        return false;
    }

    public boolean isStarted() {
        return this.mStarted;
    }

    public Builder play(Animator animator) {
        if (animator == null) {
            return null;
        }
        this.mNeedsSort = true;
        return new Builder(animator);
    }

    public void playSequentially(Animator... animatorArr) {
        if (animatorArr != null) {
            this.mNeedsSort = true;
            int i11 = 0;
            if (animatorArr.length == 1) {
                play(animatorArr[0]);
                return;
            }
            while (i11 < animatorArr.length - 1) {
                i11++;
                play(animatorArr[i11]).before(animatorArr[i11]);
            }
        }
    }

    public void playTogether(Animator... animatorArr) {
        if (animatorArr != null) {
            this.mNeedsSort = true;
            Builder play = play(animatorArr[0]);
            for (int i11 = 1; i11 < animatorArr.length; i11++) {
                play.with(animatorArr[i11]);
            }
        }
    }

    public void setInterpolator(Interpolator interpolator) {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setInterpolator(interpolator);
        }
    }

    public void setStartDelay(long j11) {
        this.mStartDelay = j11;
    }

    public void setTarget(Object obj) {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            Animator animator = it.next().animation;
            if (animator instanceof AnimatorSet) {
                ((AnimatorSet) animator).setTarget(obj);
            } else if (animator instanceof ObjectAnimator) {
                ((ObjectAnimator) animator).setTarget(obj);
            }
        }
    }

    public void setupEndValues() {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setupEndValues();
        }
    }

    public void setupStartValues() {
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            it.next().animation.setupStartValues();
        }
    }

    public void start() {
        this.f52793c = false;
        this.mStarted = true;
        sortNodes();
        int size = this.mSortedNodes.size();
        for (int i11 = 0; i11 < size; i11++) {
            Node node = this.mSortedNodes.get(i11);
            ArrayList<Animator.AnimatorListener> listeners = node.animation.getListeners();
            if (listeners != null && listeners.size() > 0) {
                Iterator it = new ArrayList(listeners).iterator();
                while (it.hasNext()) {
                    Animator.AnimatorListener animatorListener = (Animator.AnimatorListener) it.next();
                    if ((animatorListener instanceof DependencyListener) || (animatorListener instanceof AnimatorSetListener)) {
                        node.animation.removeListener(animatorListener);
                    }
                }
            }
        }
        final ArrayList arrayList = new ArrayList();
        for (int i12 = 0; i12 < size; i12++) {
            Node node2 = this.mSortedNodes.get(i12);
            if (this.mSetListener == null) {
                this.mSetListener = new AnimatorSetListener(this);
            }
            ArrayList<Dependency> arrayList2 = node2.dependencies;
            if (arrayList2 == null || arrayList2.size() == 0) {
                arrayList.add(node2);
            } else {
                int size2 = node2.dependencies.size();
                for (int i13 = 0; i13 < size2; i13++) {
                    Dependency dependency = node2.dependencies.get(i13);
                    dependency.node.animation.addListener(new DependencyListener(this, node2, dependency.rule));
                }
                node2.tmpDependencies = (ArrayList) node2.dependencies.clone();
            }
            node2.animation.addListener(this.mSetListener);
        }
        if (this.mStartDelay <= 0) {
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                Node node3 = (Node) it2.next();
                node3.animation.start();
                this.mPlayingSet.add(node3.animation);
            }
        } else {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            this.mDelayAnim = ofFloat;
            ofFloat.setDuration(this.mStartDelay);
            this.mDelayAnim.addListener(new AnimatorListenerAdapter() {

                /* renamed from: a  reason: collision with root package name */
                public boolean f52794a = false;

                public void onAnimationCancel(Animator animator) {
                    this.f52794a = true;
                }

                public void onAnimationEnd(Animator animator) {
                    if (!this.f52794a) {
                        int size = arrayList.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            Node node = (Node) arrayList.get(i11);
                            node.animation.start();
                            AnimatorSet.this.mPlayingSet.add(node.animation);
                        }
                    }
                }
            });
            this.mDelayAnim.start();
        }
        ArrayList<Animator.AnimatorListener> arrayList3 = this.f52792b;
        if (arrayList3 != null) {
            ArrayList arrayList4 = (ArrayList) arrayList3.clone();
            int size3 = arrayList4.size();
            for (int i14 = 0; i14 < size3; i14++) {
                ((Animator.AnimatorListener) arrayList4.get(i14)).onAnimationStart(this);
            }
        }
        if (this.mNodes.size() == 0 && this.mStartDelay == 0) {
            this.mStarted = false;
            ArrayList<Animator.AnimatorListener> arrayList5 = this.f52792b;
            if (arrayList5 != null) {
                ArrayList arrayList6 = (ArrayList) arrayList5.clone();
                int size4 = arrayList6.size();
                for (int i15 = 0; i15 < size4; i15++) {
                    ((Animator.AnimatorListener) arrayList6.get(i15)).onAnimationEnd(this);
                }
            }
        }
    }

    public AnimatorSet setDuration(long j11) {
        if (j11 >= 0) {
            Iterator<Node> it = this.mNodes.iterator();
            while (it.hasNext()) {
                it.next().animation.setDuration(j11);
            }
            this.mDuration = j11;
            return this;
        }
        throw new IllegalArgumentException("duration must be a value of zero or greater");
    }

    public AnimatorSet clone() {
        AnimatorSet animatorSet = (AnimatorSet) super.clone();
        animatorSet.mNeedsSort = true;
        animatorSet.f52793c = false;
        animatorSet.mStarted = false;
        animatorSet.mPlayingSet = new ArrayList<>();
        animatorSet.mNodeMap = new HashMap<>();
        animatorSet.mNodes = new ArrayList<>();
        animatorSet.mSortedNodes = new ArrayList<>();
        HashMap hashMap = new HashMap();
        Iterator<Node> it = this.mNodes.iterator();
        while (it.hasNext()) {
            Node next = it.next();
            Node clone = next.clone();
            hashMap.put(next, clone);
            animatorSet.mNodes.add(clone);
            animatorSet.mNodeMap.put(clone.animation, clone);
            ArrayList arrayList = null;
            clone.dependencies = null;
            clone.tmpDependencies = null;
            clone.nodeDependents = null;
            clone.nodeDependencies = null;
            ArrayList<Animator.AnimatorListener> listeners = clone.animation.getListeners();
            if (listeners != null) {
                Iterator<Animator.AnimatorListener> it2 = listeners.iterator();
                while (it2.hasNext()) {
                    Animator.AnimatorListener next2 = it2.next();
                    if (next2 instanceof AnimatorSetListener) {
                        if (arrayList == null) {
                            arrayList = new ArrayList();
                        }
                        arrayList.add(next2);
                    }
                }
                if (arrayList != null) {
                    Iterator it3 = arrayList.iterator();
                    while (it3.hasNext()) {
                        listeners.remove((Animator.AnimatorListener) it3.next());
                    }
                }
            }
        }
        Iterator<Node> it4 = this.mNodes.iterator();
        while (it4.hasNext()) {
            Node next3 = it4.next();
            Node node = (Node) hashMap.get(next3);
            ArrayList<Dependency> arrayList2 = next3.dependencies;
            if (arrayList2 != null) {
                Iterator<Dependency> it5 = arrayList2.iterator();
                while (it5.hasNext()) {
                    Dependency next4 = it5.next();
                    node.addDependency(new Dependency((Node) hashMap.get(next4.node), next4.rule));
                }
            }
        }
        return animatorSet;
    }

    public void playTogether(Collection<Animator> collection) {
        if (collection != null && collection.size() > 0) {
            this.mNeedsSort = true;
            Builder builder = null;
            for (Animator next : collection) {
                if (builder == null) {
                    builder = play(next);
                } else {
                    builder.with(next);
                }
            }
        }
    }

    public class Builder {
        private Node mCurrentNode;

        public Builder(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            this.mCurrentNode = node;
            if (node == null) {
                this.mCurrentNode = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, this.mCurrentNode);
                AnimatorSet.this.mNodes.add(this.mCurrentNode);
            }
        }

        public Builder after(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            this.mCurrentNode.addDependency(new Dependency(node, 1));
            return this;
        }

        public Builder before(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 1));
            return this;
        }

        public Builder with(Animator animator) {
            Node node = (Node) AnimatorSet.this.mNodeMap.get(animator);
            if (node == null) {
                node = new Node(animator);
                AnimatorSet.this.mNodeMap.put(animator, node);
                AnimatorSet.this.mNodes.add(node);
            }
            node.addDependency(new Dependency(this.mCurrentNode, 0));
            return this;
        }

        public Builder after(long j11) {
            ValueAnimator ofFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
            ofFloat.setDuration(j11);
            after((Animator) ofFloat);
            return this;
        }
    }

    public void playSequentially(List<Animator> list) {
        if (list != null && list.size() > 0) {
            this.mNeedsSort = true;
            int i11 = 0;
            if (list.size() == 1) {
                play(list.get(0));
                return;
            }
            while (i11 < list.size() - 1) {
                i11++;
                play(list.get(i11)).before(list.get(i11));
            }
        }
    }
}
