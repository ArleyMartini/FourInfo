package PW12022.fourinfo.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import PW12022.fourinfo.dto.ProductDTO;
import PW12022.fourinfo.entities.Product;
import PW12022.fourinfo.repositories.ProductRepository;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Transactional(readOnly = true)
    public List<ProductDTO> findAll() {
        List<Product> list = repository.findAllByOrderByNameAsc();
        return list.stream().map(X -> new ProductDTO(X)).collect(Collectors.toList());
    }
}
