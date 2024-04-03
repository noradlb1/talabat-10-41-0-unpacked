package com.google.firebase.components;

import java.util.List;
import n9.h;

public interface ComponentRegistrarProcessor {
    public static final ComponentRegistrarProcessor NOOP = new h();

    List<Component<?>> processRegistrar(ComponentRegistrar componentRegistrar);
}
