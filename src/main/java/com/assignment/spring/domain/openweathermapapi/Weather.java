
package com.assignment.spring.domain.openweathermapapi;

import lombok.Data;

@Data
public class Weather {

    private Integer id;
    private String main;
    private String description;
    private String icon;

}
