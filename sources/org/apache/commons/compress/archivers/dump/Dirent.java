package org.apache.commons.compress.archivers.dump;

class Dirent {
    private final int ino;

    /* renamed from: name  reason: collision with root package name */
    private final String f27578name;
    private final int parentIno;
    private final int type;

    public Dirent(int i11, int i12, int i13, String str) {
        this.ino = i11;
        this.parentIno = i12;
        this.type = i13;
        this.f27578name = str;
    }

    public int a() {
        return this.ino;
    }

    public String b() {
        return this.f27578name;
    }

    public int c() {
        return this.parentIno;
    }

    public String toString() {
        return String.format("[%d]: %s", new Object[]{Integer.valueOf(this.ino), this.f27578name});
    }
}
