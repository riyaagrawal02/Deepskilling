package Week1.DSA.EcommerceSearch;

public class SearchTest {
    public static void main(String[] args) {
        Product[] products = {
                new Product(103, "Keyboard", "Electronics"),
                new Product(101, "Laptop", "Electronics"),
                new Product(105, "Shoes", "Fashion"),
                new Product(102, "Phone", "Electronics"),
                new Product(104, "Book", "Education")
        };
        System.out.println("Linear Search:");
        Product p1 = Search.linearSearch(products, 102);
        if (p1 != null)
            p1.display();
        else
            System.out.println("Product Not Found");
        Search.sortProducts(products);
        System.out.println("\nBinary Search:");
        Product p2 = Search.binarySearch(products, 102);
        if (p2 != null)
            p2.display();
        else
            System.out.println("Product Not Found");
    }
}
