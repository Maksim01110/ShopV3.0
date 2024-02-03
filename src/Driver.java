import java.util.*;

public class Driver {

    private Store store;

    public static void main(String[] args) {
        new Driver();
    }

    public Driver() {
        store = new Store();
        runMenu();
    }

    private int mainMenu(){
        int option = ScannerInput.readNextInt("""
               Shop Menu
               ---------
                  1) Add a product
                  2) List the Products
                  ----------------------------
                  3) List the current products
                  4) Display average product unit cost
                  5) Display cheapest product
                  6) List products that are more expensive than a given price
                  ----------------------------
                  0) Exit
               ==>>  """);
        return option;
    }

    private void runMenu(){
        int option = mainMenu();

        while (option != 0){

            switch (option){
                case 1 -> addProduct();
                case 2 -> printProducts();
                case 3 -> printCurrentProducts();
                case 4 -> printAverageProductPrice();
                case 5 -> printCheapestProduct();
                case 6 -> printProductsAboveAPrice();
                default -> System.out.println("Invalid option entered: " + option);
            }

            ScannerInput.readNextLine("\nPress enter key to continue...");

            option = mainMenu();
        }

        System.out.println("Exiting...bye");
        System.exit(0);
    }



    private void addProduct(){

        String productName = ScannerInput.readNextLine("Enter the Product Name:  ");
        int productCode = ScannerInput.readNextInt("Enter the Product Code:  ");
        double unitCost = ScannerInput.readNextDouble("Enter the Unit Cost:  ");

        char currentProduct = ScannerInput.readNextChar("Is this product in your current line (y/n): ");
        boolean inCurrentProductLine = false;
        if ((currentProduct == 'y') || (currentProduct == 'Y'))
            inCurrentProductLine = true;

        boolean isAdded = store.add(new Product(productName, productCode, unitCost, inCurrentProductLine));
        if (isAdded){
            System.out.println("Product Added Successfully");
        }
        else{
            System.out.println("No Product Added");
        }
    }



    private void printProducts() {
        System.out.println("List of Products are:");
        System.out.println(store.listProducts());
    }

    private void printCurrentProducts() {
        System.out.println("List of CURRENT Products are:");
        System.out.println(store.listCurrentProducts());
    }

    private void printAverageProductPrice() {
        double averagePrice = store.averageProductPrice();
        if (averagePrice != -1) {
            System.out.println("The average product price is: " + averagePrice);
        } else {
            System.out.println("There are no products in the store.");
        }
    }

    private void printCheapestProduct() {
        Product cheapestProduct = store.cheapestProduct();
        if (cheapestProduct != null) {
            System.out.println("The cheapest product is:  " + cheapestProduct.getProductName());
        } else {
            System.out.println("There are no products in the store.");
        }
    }

    private void printProductsAboveAPrice() {
        double price = ScannerInput.readNextDouble("View the products costing more than this price: ");
        System.out.println(store.listProductsAboveAPrice(price));
    }
}


