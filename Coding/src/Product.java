public class Product {
    
    private String name;
    
    public Product(String name) {
        this.setName(name);
    }
    
    private void setName(String name) {
    	this.name = name;
    }
    
    public String getName() {
    	return this.name;
    }
    
    public void setQuantity(int quantity) {
    	if(quantity<1)
    		this.setQuantity(1);
    	else this.setQuantity(quantity);
    }
    
    public String getQuantity() {
    	return this.name;
    }
}