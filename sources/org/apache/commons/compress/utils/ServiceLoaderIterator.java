package org.apache.commons.compress.utils;

import j$.util.Iterator;
import j$.util.function.Consumer;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

public class ServiceLoaderIterator<E> implements Iterator<E>, j$.util.Iterator {
    private E nextServiceLoader;

    /* renamed from: service  reason: collision with root package name */
    private final Class<E> f27776service;
    private final Iterator<E> serviceLoaderIterator;

    public ServiceLoaderIterator(Class<E> cls) {
        this(cls, ClassLoader.getSystemClassLoader());
    }

    public /* synthetic */ void forEachRemaining(Consumer consumer) {
        Iterator.CC.$default$forEachRemaining(this, consumer);
    }

    public /* synthetic */ void forEachRemaining(java.util.function.Consumer consumer) {
        forEachRemaining(Consumer.VivifiedWrapper.convert(consumer));
    }

    public boolean hasNext() {
        while (this.nextServiceLoader == null) {
            try {
                if (!this.serviceLoaderIterator.hasNext()) {
                    return false;
                }
                this.nextServiceLoader = this.serviceLoaderIterator.next();
            } catch (ServiceConfigurationError e11) {
                if (!(e11.getCause() instanceof SecurityException)) {
                    throw e11;
                }
            }
        }
        return true;
    }

    public E next() {
        if (hasNext()) {
            E e11 = this.nextServiceLoader;
            this.nextServiceLoader = null;
            return e11;
        }
        throw new NoSuchElementException("No more elements for service " + this.f27776service.getName());
    }

    public void remove() {
        throw new UnsupportedOperationException("service=" + this.f27776service.getName());
    }

    public ServiceLoaderIterator(Class<E> cls, ClassLoader classLoader) {
        this.f27776service = cls;
        this.serviceLoaderIterator = ServiceLoader.load(cls, classLoader).iterator();
    }
}
