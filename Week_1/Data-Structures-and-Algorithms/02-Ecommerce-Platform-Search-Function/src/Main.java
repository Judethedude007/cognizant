public class Main {
    public static void main(String[] args) {
        Product[] products = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Headphones", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(104, "Backpack", "Accessories"),
            new Product(105, "Smartphone", "Electronics")
        };

        int searchId = 104;

        Product linearResult = SearchService.linearSearch(products, searchId);
        Product binaryResult = SearchService.binarySearch(products, searchId);

        System.out.println("Linear Search Result:");
        if (linearResult != null) {
            System.out.println(linearResult);
        } else {
            System.out.println("Product not found");
        }

        System.out.println();

        System.out.println("Binary Search Result:");
        if (binaryResult != null) {
            System.out.println(binaryResult);
        } else {
            System.out.println("Product not found");
        }

        System.out.println();
        System.out.println("Linear Search Time Complexity: O(n)");
        System.out.println("Binary Search Time Complexity: O(log n), but it requires sorted data");
    }
}
