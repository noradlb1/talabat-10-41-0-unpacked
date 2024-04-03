package com.google.firebase.database.core;

import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.core.utilities.Utilities;
import com.google.firebase.database.snapshot.ChildKey;
import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Path implements Iterable<ChildKey>, Comparable<Path> {
    private static final Path EMPTY_PATH = new Path("");
    /* access modifiers changed from: private */
    public final int end;
    /* access modifiers changed from: private */
    public final ChildKey[] pieces;
    /* access modifiers changed from: private */
    public final int start;

    public Path(ChildKey... childKeyArr) {
        this.pieces = (ChildKey[]) Arrays.copyOf(childKeyArr, childKeyArr.length);
        this.start = 0;
        this.end = childKeyArr.length;
        int length = childKeyArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            Utilities.hardAssert(childKeyArr[i11] != null, "Can't construct a path with a null value!");
        }
    }

    public static Path getEmptyPath() {
        return EMPTY_PATH;
    }

    public static Path getRelative(Path path, Path path2) {
        ChildKey front = path.getFront();
        ChildKey front2 = path2.getFront();
        if (front == null) {
            return path2;
        }
        if (front.equals(front2)) {
            return getRelative(path.popFront(), path2.popFront());
        }
        throw new DatabaseException("INTERNAL ERROR: " + path2 + " is not contained in " + path);
    }

    public List<String> asList() {
        ArrayList arrayList = new ArrayList(size());
        Iterator<ChildKey> it = iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().asString());
        }
        return arrayList;
    }

    public Path child(Path path) {
        int size = size() + path.size();
        ChildKey[] childKeyArr = new ChildKey[size];
        System.arraycopy(this.pieces, this.start, childKeyArr, 0, size());
        System.arraycopy(path.pieces, path.start, childKeyArr, size(), path.size());
        return new Path(childKeyArr, 0, size);
    }

    public boolean contains(Path path) {
        if (size() > path.size()) {
            return false;
        }
        int i11 = this.start;
        int i12 = path.start;
        while (i11 < this.end) {
            if (!this.pieces[i11].equals(path.pieces[i12])) {
                return false;
            }
            i11++;
            i12++;
        }
        return true;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Path)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Path path = (Path) obj;
        if (size() != path.size()) {
            return false;
        }
        int i11 = this.start;
        int i12 = path.start;
        while (i11 < this.end && i12 < path.end) {
            if (!this.pieces[i11].equals(path.pieces[i12])) {
                return false;
            }
            i11++;
            i12++;
        }
        return true;
    }

    public ChildKey getBack() {
        if (!isEmpty()) {
            return this.pieces[this.end - 1];
        }
        return null;
    }

    public ChildKey getFront() {
        if (isEmpty()) {
            return null;
        }
        return this.pieces[this.start];
    }

    public Path getParent() {
        if (isEmpty()) {
            return null;
        }
        return new Path(this.pieces, this.start, this.end - 1);
    }

    public int hashCode() {
        int i11 = 0;
        for (int i12 = this.start; i12 < this.end; i12++) {
            i11 = (i11 * 37) + this.pieces[i12].hashCode();
        }
        return i11;
    }

    public boolean isEmpty() {
        return this.start >= this.end;
    }

    public Iterator<ChildKey> iterator() {
        return new Object() {
            int offset;

            {
                this.offset = Path.this.start;
            }

            public /* synthetic */ void forEachRemaining(Consumer consumer) {
                Iterator.CC.$default$forEachRemaining(this, consumer);
            }

            public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
                forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
            }

            public boolean hasNext() {
                return this.offset < Path.this.end;
            }

            public void remove() {
                throw new UnsupportedOperationException("Can't remove component from immutable Path!");
            }

            public ChildKey next() {
                if (hasNext()) {
                    ChildKey[] access$200 = Path.this.pieces;
                    int i11 = this.offset;
                    ChildKey childKey = access$200[i11];
                    this.offset = i11 + 1;
                    return childKey;
                }
                throw new NoSuchElementException("No more elements.");
            }
        };
    }

    public Path popFront() {
        int i11 = this.start;
        if (!isEmpty()) {
            i11++;
        }
        return new Path(this.pieces, i11, this.end);
    }

    public int size() {
        return this.end - this.start;
    }

    public String toString() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = this.start; i11 < this.end; i11++) {
            sb2.append("/");
            sb2.append(this.pieces[i11].asString());
        }
        return sb2.toString();
    }

    public String wireFormat() {
        if (isEmpty()) {
            return "/";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = this.start; i11 < this.end; i11++) {
            if (i11 > this.start) {
                sb2.append("/");
            }
            sb2.append(this.pieces[i11].asString());
        }
        return sb2.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0026 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0028  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int compareTo(com.google.firebase.database.core.Path r5) {
        /*
            r4 = this;
            int r0 = r4.start
            int r1 = r5.start
        L_0x0004:
            int r2 = r4.end
            if (r0 >= r2) goto L_0x0020
            int r3 = r5.end
            if (r1 >= r3) goto L_0x0020
            com.google.firebase.database.snapshot.ChildKey[] r2 = r4.pieces
            r2 = r2[r0]
            com.google.firebase.database.snapshot.ChildKey[] r3 = r5.pieces
            r3 = r3[r1]
            int r2 = r2.compareTo((com.google.firebase.database.snapshot.ChildKey) r3)
            if (r2 == 0) goto L_0x001b
            return r2
        L_0x001b:
            int r0 = r0 + 1
            int r1 = r1 + 1
            goto L_0x0004
        L_0x0020:
            if (r0 != r2) goto L_0x0028
            int r5 = r5.end
            if (r1 != r5) goto L_0x0028
            r5 = 0
            return r5
        L_0x0028:
            if (r0 != r2) goto L_0x002c
            r5 = -1
            return r5
        L_0x002c:
            r5 = 1
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.database.core.Path.compareTo(com.google.firebase.database.core.Path):int");
    }

    public Path child(ChildKey childKey) {
        int size = size();
        int i11 = size + 1;
        ChildKey[] childKeyArr = new ChildKey[i11];
        System.arraycopy(this.pieces, this.start, childKeyArr, 0, size);
        childKeyArr[size] = childKey;
        return new Path(childKeyArr, 0, i11);
    }

    public Path(List<String> list) {
        this.pieces = new ChildKey[list.size()];
        int i11 = 0;
        for (String fromString : list) {
            this.pieces[i11] = ChildKey.fromString(fromString);
            i11++;
        }
        this.start = 0;
        this.end = list.size();
    }

    public Path(String str) {
        String[] split = str.split("/", -1);
        int i11 = 0;
        for (String length : split) {
            if (length.length() > 0) {
                i11++;
            }
        }
        this.pieces = new ChildKey[i11];
        int i12 = 0;
        for (String str2 : split) {
            if (str2.length() > 0) {
                this.pieces[i12] = ChildKey.fromString(str2);
                i12++;
            }
        }
        this.start = 0;
        this.end = this.pieces.length;
    }

    private Path(ChildKey[] childKeyArr, int i11, int i12) {
        this.pieces = childKeyArr;
        this.start = i11;
        this.end = i12;
    }
}
