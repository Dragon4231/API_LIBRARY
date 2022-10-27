package com.example.library.services;

import com.example.library.data.PrintedProduct;
import com.example.library.repository.PrintedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class PrintedProductService {
    @Autowired
    PrintedProductRepository printedProductRepository;

    public PrintedProductService(PrintedProductRepository printedProductRepository) {
        this.printedProductRepository = printedProductRepository;
    }

    public void savePrintedProduct(PrintedProduct printedProduct){
        printedProductRepository.save(printedProduct);
    }

    public void deletePrintedProduct(long id){
        if(printedProductRepository.findById(id).isPresent()){
            printedProductRepository.deleteById(id);
        }else{
            throw new NoSuchElementException();
        }
    }

}
