abstract class InventoryItem {
    private String itemId;
    private String itemName;
    private double quantityKg;

    //constructor
    public InventoryItem(String itemId, String itemName, double quantityKg) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityKg = quantityKg;
    }

    // Getter methods
    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public double getQuantityKg() { return quantityKg; }

    // Abstract methods
    public abstract void displayStorageInstructions();
    public abstract double calculateItemValue();
}





