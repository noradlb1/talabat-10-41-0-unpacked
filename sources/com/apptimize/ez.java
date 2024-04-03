package com.apptimize;

public abstract class ez {
    public abstract void a();

    public abstract void b();

    public fi c() {
        return new fi() {
            public void run() {
                ez.this.a();
            }
        };
    }

    public fi d() {
        return new fi() {
            public void run() {
                ez.this.b();
            }
        };
    }
}
