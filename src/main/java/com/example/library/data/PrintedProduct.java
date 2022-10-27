package com.example.library.data;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class PrintedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @NotNull
    private String theme;
    @NotNull
    private String author;
    @NotNull
    private String publication;
    @NotNull
    private Type typeOfProduct;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    Date date;

    public enum Type {
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
