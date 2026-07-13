package AI_assised_code;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

abstract class InventoryItem {

    private final String itemId;
    private final String itemName;
    private final double quantity;

    public InventoryItem(String itemId, String itemName, double quantity) {

        this.itemId = Objects.requireNonNull(itemId);
        this.itemName = Objects.requireNonNull(itemName);

        if (quantity < 0)
            throw new IllegalArgumentException("Quantity cannot be negative.");

        this.quantity = quantity;
    }

    public String getItemId() {
        return itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public double getQuantity() {
        return quantity;
    }

    public abstract String getStorageInstructions();

    public abstract double calculateItemValue();
}



class RawTeaLeaf extends InventoryItem {

    private static final double PRICE_PER_KG = 300;
    private final double moisturePercentage;

    public RawTeaLeaf(String id, String name,
                      double quantity, double moisturePercentage) {

        super(id, name, quantity);
        this.moisturePercentage = moisturePercentage;
    }

    @Override
    public String getStorageInstructions() {
        return "Send to withering troughs within 4 hours.";
    }

    @Override
    public double calculateItemValue() {

        double value = getQuantity() * PRICE_PER_KG;

        return moisturePercentage > 15 ? value * 0.90 : value;
    }
}



class BulkTeaGrade extends InventoryItem {

    private static final double PRICE_PER_KG = 1200;

    private final boolean exportQuality;

    public BulkTeaGrade(String id, String name,
                        double quantity,
                        String grade,
                        boolean exportQuality) {

        super(id, name, quantity);
        this.exportQuality = exportQuality;
    }

    @Override
    public String getStorageInstructions() {
        return "Store in airtight, aluminum-lined paper sacks.";
    }

    @Override
    public double calculateItemValue() {

        double value = getQuantity() * PRICE_PER_KG;

        return exportQuality ? value * 1.25 : value;
    }
}



class PackagingMaterial extends InventoryItem {

    private final double unitCost;

    public PackagingMaterial(String id,
                             String name,
                             double units,
                             double unitCost) {

        super(id, name, units);
        this.unitCost = unitCost;
    }

    @Override
    public String getStorageInstructions() {
        return "Keep in a dry, fire-restricted warehouse zone.";
    }

    @Override
    public double calculateItemValue() {
        return getQuantity() * unitCost;
    }
}



public class MainAI_Assised {

    public static void main(String[] args) {

        List<InventoryItem> inventory = new ArrayList<>();

        inventory.add(new RawTeaLeaf(
                "RAW-001",
                "Green Leaves",
                1000,
                18.5));

        inventory.add(new BulkTeaGrade(
                "BLK-202",
                "BOPF Premium",
                500,
                "BOPF",
                true));

        inventory.add(new PackagingMaterial(
                "PKG-303",
                "Wooden Boxes",
                200,
                150));



        System.out.println("=== TEA FACTORY INVENTORY REPORT (AI ASSISTED) ===");

        for (InventoryItem item : inventory) {

            System.out.println();

            System.out.printf("ID: %s | Name: %s%n",
                    item.getItemId(),
                    item.getItemName());

            System.out.println("Storage: "
                    + item.getStorageInstructions());

            System.out.printf("Valuation: %.1f LKR%n",
                    item.calculateItemValue());
        }



        double totalValue = inventory.stream()
                .mapToDouble(InventoryItem::calculateItemValue)
                .sum();

        System.out.printf("%nTotal Warehouse Valuation: %.1f LKR%n",
                totalValue);
    }
}

