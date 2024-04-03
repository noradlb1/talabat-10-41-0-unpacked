package com.uxcam.video.screen.codec.codecs.h264.io.model;

public class RefPicMarking {
    private final Instruction[] instructions;

    public enum InstrType {
        REMOVE_SHORT,
        REMOVE_LONG,
        CONVERT_INTO_LONG,
        TRUNK_LONG,
        CLEAR,
        MARK_LONG
    }

    public static class Instruction {
        private final int arg1;
        private final int arg2;
        private final InstrType type;

        public Instruction(InstrType instrType, int i11, int i12) {
            this.type = instrType;
            this.arg1 = i11;
            this.arg2 = i12;
        }

        public int getArg1() {
            return this.arg1;
        }

        public int getArg2() {
            return this.arg2;
        }

        public InstrType getType() {
            return this.type;
        }
    }

    public RefPicMarking(Instruction[] instructionArr) {
        this.instructions = instructionArr;
    }

    public Instruction[] getInstructions() {
        return this.instructions;
    }
}
