package com.bek.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class InputDto {
    private Integer warehouseId;
    private Integer supplierId;
    private Integer currencyId;
    private Integer factureNumber;
    private String code;
    private LocalTime date;
}
