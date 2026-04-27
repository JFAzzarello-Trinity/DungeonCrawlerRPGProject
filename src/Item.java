public class Item implements Comparable<Item>{
    private String name;
    private String itemType;
    private int value;
    private String description;
    public Item(String name, String itemType, int value, String description) {
        this.name = name;
        this.itemType = itemType;
        this.value = value;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getItemType() {
        return itemType;
    }

    public void setItemType(String itemType) {
        if(itemType.toUpperCase().equals("WEAPON") || itemType.toUpperCase().equals("ARMOR") || itemType.toUpperCase().equals("POTION")){this.itemType = itemType.toUpperCase();}
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        if(value > 0){this.value = value;}
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    @Override
    public String toString() {
        return "[" + itemType + "] " + name + " (Value: " + value + ")\n" + ">> " + description;
    }

    @Override
    public int compareTo(Item other) {
        return Integer.compare(this.value, other.value);
    }

    public void interact(Hero hero){
        
    }
}
