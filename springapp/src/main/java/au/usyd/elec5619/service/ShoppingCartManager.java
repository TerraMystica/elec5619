package au.usyd.elec5619.service;
import java.util.List;

import au.usyd.elec5619.domain.Product;
import au.usyd.elec5619.domain.ShoppingCart;

public interface ShoppingCartManager {

    public void addProduct(ShoppingCart hoppingCart);

    public boolean deleteProduct(long id);

    public boolean updateProduct(ShoppingCart hoppingCart);

    public List<Product> getAllProduct();
    
}
