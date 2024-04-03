package androidx.coordinatorlayout.widget;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.collection.SimpleArrayMap;
import androidx.core.util.Pools;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class DirectedAcyclicGraph<T> {
    private final SimpleArrayMap<T, ArrayList<T>> mGraph = new SimpleArrayMap<>();
    private final Pools.Pool<ArrayList<T>> mListPool = new Pools.SimplePool(10);
    private final ArrayList<T> mSortResult = new ArrayList<>();
    private final HashSet<T> mSortTmpMarked = new HashSet<>();

    private void dfs(T t11, ArrayList<T> arrayList, HashSet<T> hashSet) {
        if (!arrayList.contains(t11)) {
            if (!hashSet.contains(t11)) {
                hashSet.add(t11);
                ArrayList arrayList2 = this.mGraph.get(t11);
                if (arrayList2 != null) {
                    int size = arrayList2.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        dfs(arrayList2.get(i11), arrayList, hashSet);
                    }
                }
                hashSet.remove(t11);
                arrayList.add(t11);
                return;
            }
            throw new RuntimeException("This graph contains cyclic dependencies");
        }
    }

    @NonNull
    private ArrayList<T> getEmptyList() {
        ArrayList<T> acquire = this.mListPool.acquire();
        if (acquire == null) {
            return new ArrayList<>();
        }
        return acquire;
    }

    private void poolList(@NonNull ArrayList<T> arrayList) {
        arrayList.clear();
        this.mListPool.release(arrayList);
    }

    public void addEdge(@NonNull T t11, @NonNull T t12) {
        if (!this.mGraph.containsKey(t11) || !this.mGraph.containsKey(t12)) {
            throw new IllegalArgumentException("All nodes must be present in the graph before being added as an edge");
        }
        ArrayList arrayList = this.mGraph.get(t11);
        if (arrayList == null) {
            arrayList = getEmptyList();
            this.mGraph.put(t11, arrayList);
        }
        arrayList.add(t12);
    }

    public void addNode(@NonNull T t11) {
        if (!this.mGraph.containsKey(t11)) {
            this.mGraph.put(t11, null);
        }
    }

    public void clear() {
        int size = this.mGraph.size();
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList valueAt = this.mGraph.valueAt(i11);
            if (valueAt != null) {
                poolList(valueAt);
            }
        }
        this.mGraph.clear();
    }

    public boolean contains(@NonNull T t11) {
        return this.mGraph.containsKey(t11);
    }

    @Nullable
    public List getIncomingEdges(@NonNull T t11) {
        return this.mGraph.get(t11);
    }

    @Nullable
    public List<T> getOutgoingEdges(@NonNull T t11) {
        int size = this.mGraph.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList valueAt = this.mGraph.valueAt(i11);
            if (valueAt != null && valueAt.contains(t11)) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(this.mGraph.keyAt(i11));
            }
        }
        return arrayList;
    }

    @NonNull
    public ArrayList<T> getSortedList() {
        this.mSortResult.clear();
        this.mSortTmpMarked.clear();
        int size = this.mGraph.size();
        for (int i11 = 0; i11 < size; i11++) {
            dfs(this.mGraph.keyAt(i11), this.mSortResult, this.mSortTmpMarked);
        }
        return this.mSortResult;
    }

    public boolean hasOutgoingEdges(@NonNull T t11) {
        int size = this.mGraph.size();
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList valueAt = this.mGraph.valueAt(i11);
            if (valueAt != null && valueAt.contains(t11)) {
                return true;
            }
        }
        return false;
    }
}
