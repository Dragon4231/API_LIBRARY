package com.example.library.controllers;

import com.example.library.data.PrintedProduct;
import com.example.library.services.PrintedProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.net.http.HttpRequest;
import java.sql.Date;
import java.util.Calendar;

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

    @GetMapping("/getPrintedProduct")
    private PrintedProduct getPrintedProduct(){
        return null;
    }

    @DeleteMapping("/deletePrintedProduct/{productId}")
    @ResponseStatus
    private ResponseEntity deletePrintedProduct(@PathVariable long productId){
        printedProductService.deletePrintedProduct(productId);
        return new ResponseEntity(new String("id "+productId+" deleted"), HttpStatus.OK);
    }

    @PutMapping("/putPrintedProduct")
    @ResponseStatus
    private ResponseEntity putPrintedProduct(@RequestBody PrintedProduct printedProduct){
        return null;
    }


}
