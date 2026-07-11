abstract class InventoryItem {
    private String itemId;
    private String itemName;
    private double quantityKg;

    public InventoryItem(String itemId, String itemName, double quantityKg) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.quantityKg = quantityKg;
    }

    public String getItemId() { return itemId; }
    public String getItemName() { return itemName; }
    public double getQuantityKg() { return quantityKg; }
}





