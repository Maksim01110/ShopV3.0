import java.util.*;

public class Store {

    private ArrayList<Product> products;

    public Store() {
        products = new ArrayList<Product>();
    }

    public boolean add(Product product) {
        return products.add(product);
    }

    public String listProducts() {
        if (products.isEmpty()) {
            return "No products in the store :(";
        } else {
            String listOfProducts = "";
            for (int i = 0; i < products.size(); i++) {
                listOfProducts += i + ": " + products.get(i) + "\n";
            }
            return listOfProducts;
        }
    }

    public Product cheapestProduct() {
        if (!products.isEmpty()) {
            Product cheapestProduct = products.get(0);
            for (Product product : products) {
                if (product.getUnitCost() < cheapestProduct.getUnitCost())
                    cheapestProduct = product;
            }
            return cheapestProduct;
        } else {
            return null;
        }
    }

    public String listCurrentProducts() {
        if (products.isEmpty()) {
            return "No Products in the store";
        } else {
            String listOfProducts = "";
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).isInCurrentProductLine())
                    listOfProducts += i + ": " + products.get(i) + "\n";
            }
            if (listOfProducts.equals("")) {
                return "No Products are in our current product line";
            } else {
                return listOfProducts;
            }
        }
    }

    public double averageProductPrice() {
        if (!products.isEmpty()) {
            double totalPrice = 0;
            for (Product product : products) {
                totalPrice += product.getUnitCost();
            }
            return totalPrice / products.size();
        } else {
            return -1;
        }
    }

    public String listProductsAboveAPrice(double price) {
        if (products.isEmpty()) {
            return "No Products are in the store";
        } else {
            String str = "";
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getUnitCost() > price)
                    str += i + ": " + products.get(i) + "\n";
            }
            if (str.equals("")) {
                return "No Products are more expensive than: " + price;
            } else {
                return str;
            }
        }
    }
}
