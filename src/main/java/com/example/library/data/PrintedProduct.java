package com.example.library.data;

import lombok.Data;
import lombok.NonNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Calendar;
import java.util.Date;

@Data
public class PrintedProduct {

    @NonNull
    private long ID;

    @NonNull
    private String theme;
    @NonNull
    private String author;
    @NonNull
    private String publication;
    @NonNull
    private Type typeOfProduct;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NonNull
    Date date;

    enum Type {
        BOOK {
            @Override
            public String getName() {
                return "Книга";
            }
        },
        JOURNAL {
            @Override
            public String getName() {
                return "Журнал";
            }
        },
        NEWSPAPER {
            @Override
            public String getName() {
                return "Газета";
            }
        };

        public abstract String getName();
    }
}
