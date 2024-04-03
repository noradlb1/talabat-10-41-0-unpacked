package com.huawei.location.nlp.network.request.cell;

import java.util.List;

public class CellSourceInfo {
    private CurrentCell currentCell;
    private List<NeighborCell> neighborCells;

    public CellSourceInfo(CurrentCell currentCell2, List<NeighborCell> list) {
        this.currentCell = currentCell2;
        this.neighborCells = list;
    }

    public CurrentCell getCurrentCell() {
        return this.currentCell;
    }

    public List<NeighborCell> getNeighborCells() {
        return this.neighborCells;
    }

    public void setCurrentCell(CurrentCell currentCell2) {
        this.currentCell = currentCell2;
    }

    public void setNeighborCells(List<NeighborCell> list) {
        this.neighborCells = list;
    }
}
