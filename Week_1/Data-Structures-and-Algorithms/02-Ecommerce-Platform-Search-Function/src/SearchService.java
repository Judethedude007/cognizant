public class SearchService {

    public static Product linearSearch(Product[] products, int productId) {
        for (Product product : products) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, int productId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (products[middle].getProductId() == productId) {
                return products[middle];
            }

            if (products[middle].getProductId() < productId) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return null;
    }
}
