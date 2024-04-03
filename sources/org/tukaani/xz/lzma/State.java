package org.tukaani.xz.lzma;

final class State {
    private static final int LIT_LIT = 0;
    private static final int LIT_LONGREP = 8;
    private static final int LIT_MATCH = 7;
    private static final int LIT_SHORTREP = 9;
    private static final int LIT_STATES = 7;
    private static final int MATCH_LIT = 4;
    private static final int MATCH_LIT_LIT = 1;
    private static final int NONLIT_MATCH = 10;
    private static final int NONLIT_REP = 11;
    private static final int REP_LIT = 5;
    private static final int REP_LIT_LIT = 2;
    private static final int SHORTREP_LIT = 6;
    private static final int SHORTREP_LIT_LIT = 3;
    private int state;

    public int a() {
        return this.state;
    }

    public boolean b() {
        return this.state < 7;
    }

    public void c() {
        this.state = 0;
    }

    public void d(State state2) {
        this.state = state2.state;
    }

    public void e() {
        int i11 = this.state;
        this.state = i11 <= 3 ? 0 : i11 <= 9 ? i11 - 3 : i11 - 6;
    }

    public void f() {
        this.state = this.state < 7 ? 8 : 11;
    }

    public void g() {
        int i11 = 7;
        if (this.state >= 7) {
            i11 = 10;
        }
        this.state = i11;
    }

    public void h() {
        this.state = this.state < 7 ? 9 : 11;
    }
}
