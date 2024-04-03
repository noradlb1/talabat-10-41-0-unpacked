package org.apache.commons.compress.harmony.unpack200.bytecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import org.apache.commons.compress.harmony.unpack200.Segment;
import w20.a;
import w20.b;
import w20.c;

public class ClassConstantPool {
    private final List entries = new ArrayList(500);
    protected HashSet entriesContainsSet = new HashSet();
    protected Map indexCache;
    private final HashSet mustStartClassPool = new HashSet();
    private final List others = new ArrayList(500);
    protected HashSet othersContainsSet = new HashSet();
    private boolean resolved;

    private void initialSort() {
        TreeSet treeSet = new TreeSet(new a());
        TreeSet treeSet2 = new TreeSet(new b());
        TreeSet treeSet3 = new TreeSet(new c());
        for (int i11 = 0; i11 < this.entries.size(); i11++) {
            ConstantPoolEntry constantPoolEntry = (ConstantPoolEntry) this.entries.get(i11);
            if (constantPoolEntry.getGlobalIndex() != -1) {
                treeSet.add(constantPoolEntry);
            } else if (constantPoolEntry instanceof CPUTF8) {
                treeSet2.add(constantPoolEntry);
            } else if (constantPoolEntry instanceof CPClass) {
                treeSet3.add(constantPoolEntry);
            } else {
                throw new Error("error");
            }
        }
        this.entries.clear();
        this.entries.addAll(treeSet);
        this.entries.addAll(treeSet2);
        this.entries.addAll(treeSet3);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int lambda$initialSort$0(Object obj, Object obj2) {
        return ((ConstantPoolEntry) obj).getGlobalIndex() - ((ConstantPoolEntry) obj2).getGlobalIndex();
    }

    public ClassFileEntry add(ClassFileEntry classFileEntry) {
        if (classFileEntry instanceof ByteCode) {
            return null;
        }
        if (classFileEntry instanceof ConstantPoolEntry) {
            if (this.entriesContainsSet.add(classFileEntry)) {
                this.entries.add(classFileEntry);
            }
        } else if (this.othersContainsSet.add(classFileEntry)) {
            this.others.add(classFileEntry);
        }
        return classFileEntry;
    }

    public void addNestedEntries() {
        boolean z11;
        ArrayList arrayList = new ArrayList(512);
        ArrayList arrayList2 = new ArrayList(512);
        arrayList.addAll(this.entries);
        arrayList.addAll(this.others);
        boolean z12 = true;
        while (true) {
            if (z12 || arrayList.size() > 0) {
                arrayList2.clear();
                int size = this.entries.size();
                int size2 = this.others.size();
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    ClassFileEntry classFileEntry = (ClassFileEntry) arrayList.get(i11);
                    ClassFileEntry[] nestedClassFileEntries = classFileEntry.getNestedClassFileEntries();
                    arrayList2.addAll(Arrays.asList(nestedClassFileEntries));
                    if (!(classFileEntry instanceof ByteCode) || !((ByteCode) classFileEntry).nestedMustStartClassPool()) {
                        z11 = false;
                    } else {
                        z11 = true;
                    }
                    if (z11) {
                        this.mustStartClassPool.addAll(Arrays.asList(nestedClassFileEntries));
                    }
                    add(classFileEntry);
                }
                if (this.entries.size() == size && this.others.size() == size2) {
                    z12 = false;
                } else {
                    z12 = true;
                }
                arrayList.clear();
                arrayList.addAll(arrayList2);
            } else {
                return;
            }
        }
    }

    public ClassFileEntry addWithNestedEntries(ClassFileEntry classFileEntry) {
        add(classFileEntry);
        ClassFileEntry[] nestedClassFileEntries = classFileEntry.getNestedClassFileEntries();
        for (ClassFileEntry addWithNestedEntries : nestedClassFileEntries) {
            addWithNestedEntries(addWithNestedEntries);
        }
        return classFileEntry;
    }

    public List entries() {
        return Collections.unmodifiableList(this.entries);
    }

    public ClassFileEntry get(int i11) {
        if (this.resolved) {
            return (ClassFileEntry) this.entries.get(i11 - 1);
        }
        throw new IllegalStateException("Constant pool is not yet resolved; this does not make any sense");
    }

    public int indexOf(ClassFileEntry classFileEntry) {
        if (this.resolved) {
            Map map = this.indexCache;
            if (map != null) {
                Integer num = (Integer) map.get(classFileEntry);
                if (num != null) {
                    return num.intValue() + 1;
                }
                return -1;
            }
            throw new IllegalStateException("Index cache is not initialized!");
        }
        throw new IllegalStateException("Constant pool is not yet resolved; this does not make any sense");
    }

    public void resolve(Segment segment) {
        initialSort();
        sortClassPool();
        this.resolved = true;
        for (int i11 = 0; i11 < this.entries.size(); i11++) {
            ((ClassFileEntry) this.entries.get(i11)).resolve(this);
        }
        for (int i12 = 0; i12 < this.others.size(); i12++) {
            ((ClassFileEntry) this.others.get(i12)).resolve(this);
        }
    }

    public int size() {
        return this.entries.size();
    }

    public void sortClassPool() {
        int i11;
        ArrayList arrayList = new ArrayList(this.entries.size());
        ArrayList arrayList2 = new ArrayList(this.entries.size());
        for (int i12 = 0; i12 < this.entries.size(); i12++) {
            ClassFileEntry classFileEntry = (ClassFileEntry) this.entries.get(i12);
            if (this.mustStartClassPool.contains(classFileEntry)) {
                arrayList.add(classFileEntry);
            } else {
                arrayList2.add(classFileEntry);
            }
        }
        this.indexCache = new HashMap(this.entries.size());
        this.entries.clear();
        int i13 = 0;
        for (int i14 = 0; i14 < arrayList.size(); i14++) {
            ClassFileEntry classFileEntry2 = (ClassFileEntry) arrayList.get(i14);
            this.indexCache.put(classFileEntry2, Integer.valueOf(i13));
            if ((classFileEntry2 instanceof CPLong) || (classFileEntry2 instanceof CPDouble)) {
                this.entries.add(classFileEntry2);
                this.entries.add(classFileEntry2);
                i13 += 2;
            } else {
                this.entries.add(classFileEntry2);
                i13++;
            }
        }
        for (int i15 = 0; i15 < arrayList2.size(); i15++) {
            ClassFileEntry classFileEntry3 = (ClassFileEntry) arrayList2.get(i15);
            this.indexCache.put(classFileEntry3, Integer.valueOf(i13));
            if ((classFileEntry3 instanceof CPLong) || (classFileEntry3 instanceof CPDouble)) {
                this.entries.add(classFileEntry3);
                this.entries.add(classFileEntry3);
                i11 = i13 + 2;
            } else {
                this.entries.add(classFileEntry3);
                i11 = i13 + 1;
            }
        }
    }
}
