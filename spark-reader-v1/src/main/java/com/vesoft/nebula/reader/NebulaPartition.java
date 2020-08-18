package com.vesoft.nebula.reader;

import java.util.ArrayList;
import java.util.List;
import org.apache.spark.Partition;

public class NebulaPartition implements Partition {

    private int index;
    private int totalPartition;

    public NebulaPartition(int index, int totalPartition) {
        this.index = index;
        this.totalPartition = totalPartition;
    }

    @Override
    public int index() {
        return index;
    }

    /**
     * allocate scanPart to partition
     * @param totalPart  nebula data part num
     * @return           scan data part list
     */
    public List<Integer> getScanParts(int totalPart) {
        List<Integer> scanParts = new ArrayList<>();

        int currentPart = index + 1;
        while (currentPart <= totalPart) {
            scanParts.add(currentPart);
            currentPart += totalPartition;
        }

        return scanParts;

    }
}
