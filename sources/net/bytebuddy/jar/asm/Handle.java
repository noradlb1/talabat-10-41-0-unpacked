package net.bytebuddy.jar.asm;

public final class Handle {
    private final String descriptor;
    private final boolean isInterface;

    /* renamed from: name  reason: collision with root package name */
    private final String f27381name;
    private final String owner;
    private final int tag;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @Deprecated
    public Handle(int i11, String str, String str2, String str3) {
        this(i11, str, str2, str3, i11 == 9);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Handle)) {
            return false;
        }
        Handle handle = (Handle) obj;
        if (this.tag != handle.tag || this.isInterface != handle.isInterface || !this.owner.equals(handle.owner) || !this.f27381name.equals(handle.f27381name) || !this.descriptor.equals(handle.descriptor)) {
            return false;
        }
        return true;
    }

    public String getDesc() {
        return this.descriptor;
    }

    public String getName() {
        return this.f27381name;
    }

    public String getOwner() {
        return this.owner;
    }

    public int getTag() {
        return this.tag;
    }

    public int hashCode() {
        int i11;
        int i12 = this.tag;
        if (this.isInterface) {
            i11 = 64;
        } else {
            i11 = 0;
        }
        return i12 + i11 + (this.owner.hashCode() * this.f27381name.hashCode() * this.descriptor.hashCode());
    }

    public boolean isInterface() {
        return this.isInterface;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.owner);
        sb2.append('.');
        sb2.append(this.f27381name);
        sb2.append(this.descriptor);
        sb2.append(" (");
        sb2.append(this.tag);
        sb2.append(this.isInterface ? " itf" : "");
        sb2.append(')');
        return sb2.toString();
    }

    public Handle(int i11, String str, String str2, String str3, boolean z11) {
        this.tag = i11;
        this.owner = str;
        this.f27381name = str2;
        this.descriptor = str3;
        this.isInterface = z11;
    }
}
