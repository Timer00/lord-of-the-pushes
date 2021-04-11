package com.lordofthepushes.util;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Util {
    public static Pageable verifyPageable(Integer pageNumber, Integer qtdPage) {
        if (qtdPage > 5 ) {
            qtdPage = 5;
        }
        if (qtdPage < 1) {
            qtdPage = 1;
        }
        pageNumber = pageNumber >= 1 ? pageNumber - 1 : pageNumber ;
        return PageRequest.of(pageNumber, qtdPage);
    }
}
