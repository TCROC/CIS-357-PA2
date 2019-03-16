package sample;

public class Computer extends NonConsumable {

    protected String processor;
    protected double memory;
    protected String graphicsCard;

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public String getGraphicsCard() {
        return graphicsCard;
    }

    public void setGraphicsCard(String graphicsCard) {
        this.graphicsCard = graphicsCard;
    }

    @Override
    public String getItemTypeDetails() {
        return null;
    }

    @Override
    public String getItemSummary() {
        return null;
    }

    @Override
    public int compareTo(StockItem o) {
        return 0;
    }
}
