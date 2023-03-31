package com.bek.warehouse.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.PackagePrivate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@PackagePrivate
public class Result {
    String message;
    Boolean status;
}
