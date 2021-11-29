package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.NonNull;

import java.util.UUID;

/**
 * @author toir427
 * @link http://tuychiev.com
 * @since 11/26/21
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private UUID id;
    @NonNull
    private String name;

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
