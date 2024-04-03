package com.instabug.library.visualusersteps.inspector;

import androidx.annotation.NonNull;
import io.reactivex.Maybe;
import io.reactivex.Observable;
import java.util.Collection;

class m implements l {

    /* renamed from: a  reason: collision with root package name */
    private final Collection f52167a;

    public m(@NonNull Collection collection) {
        this.f52167a = collection;
        collection.isEmpty();
    }

    @NonNull
    public Maybe a(float f11, float f12) {
        return b(f11, f12).map(j.d()).map(j.f()).map(j.e()).flatMap(j.g());
    }

    @NonNull
    public Maybe b(float f11, float f12) {
        return Observable.fromIterable(this.f52167a).filter(j.h()).filter(j.c(f11, f12)).toList().toMaybe().map(j.b());
    }
}
