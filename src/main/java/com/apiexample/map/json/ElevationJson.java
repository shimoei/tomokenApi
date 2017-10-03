package com.apiexample.map.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by Platykun on 2017/09/24.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ElevationJson {
    Double elevation;
    LocationJson location;
    Double resolution;
}
