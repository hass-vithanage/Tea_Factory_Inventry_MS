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

// Child Class 1: Raw Tea Leaf
class RawTeaLeaf extends InventoryItem {
    private double moisturePercentage;

    public RawTeaLeaf(String itemId, String itemName, double quantityKg, double moisturePercentage) {
        super(itemId, itemName, quantityKg);
        this.moisturePercentage = moisturePercentage;
    }

    @Override
    public void displayStorageInstructions() {
        System.out.println("Storage: Send to withering troughs within 4 hours.");
    }

    @Override
    public double calculateItemValue() {
        double basePrice = getQuantityKg() * 300.0; // Fixed flat rate
        if (moisturePercentage > 15.0) {
            return basePrice * 0.90; // Simple 10% penalty
        }
        return basePrice;
    }
}

// Child Class 2: Bulk Tea Grade
class BulkTeaGrade extends InventoryItem {
    private String teaGrade;
    private boolean isExportQuality;

    public BulkTeaGrade(String itemId, String itemName, double quantityKg, String teaGrade, boolean isExportQuality) {
        super(itemId, itemName, quantityKg);
        this.teaGrade = teaGrade;
        this.isExportQuality = isExportQuality;
    }

    @Override
    public void displayStorageInstructions() {
        System.out.println("Storage: Store in airtight, aluminum-lined paper sacks.");
    }

    @Override
    public double calculateItemValue() {
        double pricePerKg = 1200.0; // Flat rate for all grades
        double basePrice = getQuantityKg() * pricePerKg;
        if (isExportQuality) {
            return basePrice * 1.25; // 25% export premium
        }
        return basePrice;
    }
}

// Child Class 3: Packaging Material
class PackagingMaterial extends InventoryItem {
    private double unitCost;

    public PackagingMaterial(String itemId, String itemName, double quantityUnits, double unitCost) {
        super(itemId, itemName, quantityUnits);
        this.unitCost = unitCost;
    }

    @Override
    public void displayStorageInstructions() {
        System.out.println("Storage: Keep in a dry, fire-restricted warehouse zone.");
    }

    @Override
    public double calculateItemValue() {
        return getQuantityKg() * unitCost; // Quantity tracks units here
    }
}

// Driver Class
public class Main {
    public static void main(String[] args) {
        InventoryItem[] inventory = new InventoryItem[3];
        inventory[0] = new RawTeaLeaf("RAW-001", "Green Leaves", 1000, 18.5);
        inventory[1] = new BulkTeaGrade("BLK-202", "BOPF Premium", 500, "BOPF", true);
        inventory[2] = new PackagingMaterial("PKG-303", "Wooden Boxes", 200, 150.0);

        double totalValue = 0;

        System.out.println("=== TEA FACTORY INVENTORY REPORT (MANUAL) ===")
    }
}

