package kodlamaio.northwind.business.concretes;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.*;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service 		//bu classın servıce gorevı gorecegını soyler
public class ProductManager implements ProductService{

	//productDao ve injextion
	private ProductDao productDao;
	
	@Autowired		//productdaonun instance olabilecek bir tane sınıfı turetıp onu verır
	public ProductManager(ProductDao productDao){
        super();
        this.productDao = productDao;
    }

    @Override
    public DataResult<List<Product>> getAll(){
        return new SuccessDataResult<List<Product>>(
                this.productDao.findAll(),
                "Data listelendi"
        );
    }

    @Override
    public Result add(Product product) {
        try{
            productDao.save(product);
            return new SuccessResult("Ürün eklendi");
        } catch (Exception e){
            return new ErrorResult("Ürün eklenemedi");
        }
    }

	
}
