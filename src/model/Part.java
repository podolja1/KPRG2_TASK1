package model;

public class Part {

    private final TopologyType topologyType;
    private final int index;
    private final int count;

    public Part(TopologyType topologyType, int index, int count) {
        this.topologyType = topologyType;
        this.index = index;
        this.count = count;
    }

    public TopologyType getTopologyType() {
        return topologyType;
    }

    public int getIndex() {
        return index;
    }

    public int getCount() {
        return count;
    }
}
