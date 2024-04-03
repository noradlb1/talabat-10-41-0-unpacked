package com.talabat.domain.address.parse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/talabat/domain/address/parse/AddressJsonInternal;", "", "id", "", "item", "", "(ILjava/lang/String;)V", "getId", "()I", "getItem", "()Ljava/lang/String;", "com_talabat_domain_address_address"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AddressJsonInternal {

    /* renamed from: id  reason: collision with root package name */
    private final int f58347id;
    @NotNull
    private final String item;

    public AddressJsonInternal(int i11, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "item");
        this.f58347id = i11;
        this.item = str;
    }

    public final int getId() {
        return this.f58347id;
    }

    @NotNull
    public final String getItem() {
        return this.item;
    }
}
