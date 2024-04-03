package com.huawei.hms.common.internal;

import java.util.ArrayList;
import java.util.ListIterator;

public class BindResolveClients {

    /* renamed from: b  reason: collision with root package name */
    private static final Object f48157b = new Object();

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<ResolveClientBean> f48158a;

    public static class b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final BindResolveClients f48159a = new BindResolveClients();
    }

    public static BindResolveClients getInstance() {
        return b.f48159a;
    }

    public boolean isClientRegistered(ResolveClientBean resolveClientBean) {
        boolean contains;
        synchronized (f48157b) {
            contains = this.f48158a.contains(resolveClientBean);
        }
        return contains;
    }

    public void notifyClientReconnect() {
        synchronized (f48157b) {
            ListIterator<ResolveClientBean> listIterator = this.f48158a.listIterator();
            while (listIterator.hasNext()) {
                listIterator.next().clientReconnect();
            }
            this.f48158a.clear();
        }
    }

    public void register(ResolveClientBean resolveClientBean) {
        if (resolveClientBean != null) {
            synchronized (f48157b) {
                if (!this.f48158a.contains(resolveClientBean)) {
                    this.f48158a.add(resolveClientBean);
                }
            }
        }
    }

    public void unRegister(ResolveClientBean resolveClientBean) {
        if (resolveClientBean != null) {
            synchronized (f48157b) {
                if (this.f48158a.contains(resolveClientBean)) {
                    ListIterator<ResolveClientBean> listIterator = this.f48158a.listIterator();
                    while (true) {
                        if (listIterator.hasNext()) {
                            if (resolveClientBean.equals(listIterator.next())) {
                                listIterator.remove();
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                }
            }
        }
    }

    public void unRegisterAll() {
        synchronized (f48157b) {
            this.f48158a.clear();
        }
    }

    private BindResolveClients() {
        this.f48158a = new ArrayList<>();
    }
}
