package com.example.library.controllers;

import com.example.library.data.PrintedProduct;
import com.example.library.services.PrintedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/")
public class MainController {

    @Autowired
    PrintedProductService printedProductService;

    public MainController(PrintedProductService printedProductService) {
        this.printedProductService = printedProductService;
    }

    @PostMapping("/postPrintedProduct")
    @ResponseStatus
    private ResponseEntity postPrintedProduct(@RequestBody PrintedProduct printedProduct) {
        printedProductService.savePrintedProduct(printedProduct);
        return new ResponseEntity("new PrintedProduct added", HttpStatus.OK);
    }

    @GetMapping("/getPrintedProduct/{getBy}")
    private List<PrintedProduct> getPrintedProduct(@PathVariable String getBy, @RequestParam(value = "value") Object object) throws ParseException {
        List list = printedProductService.getByValuePrintedProducts(getBy, object);
        if (list.isEmpty()) {
            throw new NoSuchElementException();
        } else {
            return list;
        }
    }

    @DeleteMapping("/deletePrintedProduct/{productId}")
    @ResponseStatus
    private ResponseEntity deletePrintedProduct(@PathVariable long productId) {
        printedProductService.deletePrintedProduct(productId);
        return new ResponseEntity(new String("id " + productId + " deleted"), HttpStatus.OK);
    }

    @PutMapping("/putPrintedProduct/{productId}")
    @ResponseStatus
    private ResponseEntity putPrintedProduct(
            @PathVariable long productId,
            @RequestParam(value = "theme", required = false) String theme,
            @RequestParam(value = "author", required = false) String author,
            @RequestParam(value = "publication", required = false) String publication,
            @RequestParam(value = "typeOfProduct", required = false) PrintedProduct.Type typeOfProduct,
            @RequestParam(value = "date", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        if (theme != null) printedProductService.updatePrintedProductTheme(productId, theme);
        if (author != null) printedProductService.updatePrintedProductAuthor(productId, author);
        if (publication != null) printedProductService.updatePrintedProductPublication(productId, publication);
        if (typeOfProduct != null) printedProductService.updatePrintedProductTypeOfProduct(productId, typeOfProduct);
        if (date != null) printedProductService.updatePrintedProductDate(productId, date);
        return new ResponseEntity(new String("updating for " + productId + " done"), HttpStatus.OK);
    }


}
