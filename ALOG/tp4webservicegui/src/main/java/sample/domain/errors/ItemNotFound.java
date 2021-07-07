package sample.domain.errors;

public class ItemNotFound extends Exception{
    public ItemNotFound(String itemName) {
        super("Item "+itemName+" not found in the data store ");
    }
}
