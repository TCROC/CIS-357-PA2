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
        String details = "";
        details += "Processor: " + getProcessor() + "\n";
        details += "Memory: " + getMemory() + "\n";
        details += "Graphics Card: " + getGraphicsCard() + "\n";
        return details;
    }

    @Override
    public String getItemSummary() {
        String summary = "";
        summary += "Name: " + getItemName() + "\n";
        summary += "Category: " + getItemCategory() + "\n";
        summary += "Description: " + getItemDescription() + "\n";
        summary += "Price: " + getPrice() + "\n";

        summary += "\nDetails:\n";
        summary += getItemTypeDetails();

        return summary;
    }

    @Override
    public int compareTo(StockItem o) {
        return (int) (o.getPrice() - getPrice());
    }
}
