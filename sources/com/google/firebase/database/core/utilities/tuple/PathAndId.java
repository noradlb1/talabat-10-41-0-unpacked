package com.google.firebase.database.core.utilities.tuple;

import com.google.firebase.database.core.Path;

public class PathAndId {

    /* renamed from: id  reason: collision with root package name */
    private long f47414id;
    private Path path;

    public PathAndId(Path path2, long j11) {
        this.path = path2;
        this.f47414id = j11;
    }

    public long getId() {
        return this.f47414id;
    }

    public Path getPath() {
        return this.path;
    }
}
