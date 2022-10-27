package com.example.library.services;

import com.example.library.data.PrintedProduct;
import com.example.library.repository.PrintedProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class PrintedProductService {
    @Autowired
    PrintedProductRepository printedProductRepository;

    public PrintedProductService(PrintedProductRepository printedProductRepository) {
        this.printedProductRepository = printedProductRepository;
    }

    public List<PrintedProduct> getByValuePrintedProducts(String getBy, Object o) throws ParseException {
        if (getBy.equals("author")) {
            return printedProductRepository.findAllByAuthor((String) o);
        } else if (getBy.equals("publication")) {
            return printedProductRepository.findAllByPublication((String) o);
        } else if (getBy.equals("typeOfProduct")) {
            return printedProductRepository.findAllByTypeOfProduct(PrintedProduct.Type.valueOf((String) o));
        } else if (getBy.equals("theme")) {
            return printedProductRepository.findAllByTheme((String) o);
        } else if (getBy.equals("date")) {
            SimpleDateFormat format = new SimpleDateFormat();
            format.applyPattern("yyyy-MM-dd");
            Calendar c = Calendar.getInstance();
            c.setTime(format.parse((String) o));
            return printedProductRepository.findAllByDate(c);
        }
        throw new NoSuchElementException();
    }

    public void savePrintedProduct(PrintedProduct printedProduct) {
        printedProductRepository.save(printedProduct);
    }

    public void deletePrintedProduct(long id) {
        if (printedProductRepository.findById(id).isPresent()) {
            printedProductRepository.deleteById(id);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void updatePrintedProductTheme(long id, String theme) {
        if (printedProductRepository.findById(id).isPresent()) {
            printedProductRepository.updateTheme(id, theme);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void updatePrintedProductAuthor(long id, String author) {
        if (printedProductRepository.findById(id).isPresent()) {
            printedProductRepository.updateAuthor(id, author);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void updatePrintedProductDate(long id, Date date) {
        if (printedProductRepository.findById(id).isPresent()) {
            printedProductRepository.updateDate(id, date);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void updatePrintedProductPublication(long id, String publication) {
        if (printedProductRepository.findById(id).isPresent()) {
            printedProductRepository.updatePublication(id, publication);
        } else {
            throw new NoSuchElementException();
        }
    }

    public void updatePrintedProductTypeOfProduct(long id, PrintedProduct.Type typeOfProduct) {
        if (printedProductRepository.findById(id).isPresent()) {
            printedProductRepository.updateTypeOfProduct(id, typeOfProduct);
        } else {
            throw new NoSuchElementException();
        }
    }

}
