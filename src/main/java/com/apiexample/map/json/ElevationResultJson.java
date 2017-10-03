package com.apiexample.map.json;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Created by Platykun on 2017/09/24.
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ElevationResultJson extends CommonJson{
    List<ElevationJson> results;
}
