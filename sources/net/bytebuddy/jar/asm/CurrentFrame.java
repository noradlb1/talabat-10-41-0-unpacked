package net.bytebuddy.jar.asm;

final class CurrentFrame extends Frame {
    public CurrentFrame(Label label) {
        super(label);
    }

    public void c(int i11, int i12, Symbol symbol, SymbolTable symbolTable) {
        super.c(i11, i12, symbol, symbolTable);
        Frame frame = new Frame((Label) null);
        g(symbolTable, frame, 0);
        b(frame);
    }
}
