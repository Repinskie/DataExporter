package com.repinsky.dataexporter.util;

import org.springframework.data.domain.Sort;

public class CriteriaSort {
    public static Sort criteriaSort(String[] sort){
        if(sort == null || sort.length == 0){
            return Sort.unsorted();
        }

        Sort sortCriteria = Sort.unsorted();
        for(String sortParam : sort){
            String[] sortPair = sortParam.split(",");
            String field = sortPair[0];
            Sort.Direction direction = sortPair.length > 1 && sortPair[1].equals("desc")
                    ? Sort.Direction.DESC
                    : Sort.Direction.ASC;

            sortCriteria = sortCriteria.and(Sort.by(direction, field));
        }
        return sortCriteria;
    }
}
