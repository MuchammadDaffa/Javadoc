import java.util.ArrayList;
import java.util.List;

/**
 * Kelas ProductManager mengelola daftar produk dalam sistem.
 * Memungkinkan penambahan, penghapusan, dan tampilan produk.
 */
public class ProductManager {
    
    private List<Product> productList;

    /**
     * Konstruktor untuk menginisialisasi ProductManager dengan daftar produk kosong.
     */
    public ProductManager() {
        this.productList = new ArrayList<>();
    }

    /**
     * Menambahkan produk baru ke dalam daftar.
     *
     * @param productName Nama produk yang akan ditambahkan, tidak boleh kosong.
     * @param price Harga produk dalam rupiah, harus lebih besar dari nol.
     * @return true jika produk berhasil ditambahkan, false jika gagal.
     * @throws IllegalArgumentException jika nama produk kosong atau harga negatif.
     */
    public boolean addProduct(String productName, double price) throws IllegalArgumentException {
        if (productName == null || productName.isEmpty()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong");
        }
        if (price < 0) {
            throw new IllegalArgumentException("Harga produk tidak boleh negatif");
        }
        Product newProduct = new Product(productName, price);
        productList.add(newProduct);
        return true;
    }

    /**
     * Menampilkan daftar produk yang ada.
     */
    public void displayProducts() {
        if (productList.isEmpty()) {
            System.out.println("Tidak ada produk dalam daftar.");
        } else {
            for (Product product : productList) {
                System.out.println("Produk: " + product.getName() + ", Harga: " + product.getPrice());
            }
        }
    }

    public static void main(String[] args) {
        ProductManager manager = new ProductManager();

        // Menambahkan produk ke dalam daftar
        manager.addProduct("Apel", 10000);
        manager.addProduct("Pisang", 8000);

        // Menampilkan semua produk
        manager.displayProducts();
    }
}

/**
 * Kelas Product merepresentasikan sebuah produk dengan nama dan harga.
 */
class Product {
    private String name;
    private double price;

    /**
     * Konstruktor untuk inisialisasi produk dengan nama dan harga.
     *
     * @param name Nama produk, tidak boleh kosong.
     * @param price Harga produk dalam rupiah, harus lebih besar dari nol.
     */
    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * Mengambil nama produk.
     *
     * @return Nama produk.
     */
    public String getName() {
        return name;
    }

    /**
     * Mengambil harga produk.
     *
     * @return Harga produk dalam rupiah.
     */
    public double getPrice() {
        return price;
    }
}
