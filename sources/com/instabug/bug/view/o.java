package com.instabug.bug.view;

class o implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ q f45864b;

    public o(q qVar) {
        this.f45864b = qVar;
    }

    public void run() {
        if (this.f45864b.getActivity() != null) {
            this.f45864b.getActivity().finish();
        }
    }
}
