package homework.supermarket;

public class Supermarket {
    // поля класса
    private Product[] products; // массив типа Product
    private int quantity; // текущее кол-во продуктов в массиве ("на складе")

    // конструктор
    public Supermarket(int capacity) {
        products = new Product[capacity]; // создаем новый объект
    }

    public boolean addProduct(Product product) {
        if (product == null || quantity == products.length || findProduct(product.getBarcode()) != null) {
            return false;
        }
        products[quantity] = product; // добавляем в конец массива
        quantity++; // увеличиваем на 1
        return true;
    }

    public Product findProduct(long barcode) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getBarcode() == barcode) {
                return products[i];
            }
        }
        return null;
    }

    public Product updateProduct(long barcode, double price) {
        // TODO update product price
        // найти продукт в массиве по его баркоду и обновить ему цену
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getBarcode() == barcode) {
                products[i].setPrice(price);
                return products[i];
            }
        }
        return null;
    }

    public boolean removeProduct(long barCode) {
        // TODO remove product
        // найти продукт в массиве по его баркоду и удалить элемент массива:
        // пусть удаляемый продукт стоит на i-м индексе, тогда можно поставить на его место последний элемент массива,
        // затем последний элемент присвоить null, длину массива уменьшить на 1.
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null && products[i].getBarcode() == barCode) {
                products[i] = products[products.length - 1];
                products[products.length - 1] = null;
                quantity--;
                return true;
            }
        }
        return false;
    }

    public void printAllProducts() {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println(products[i]);
            }
        }
    }

    public int getQuantity() {
        return quantity;
    }

}
