package com.lordofthepushes.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lordofthepushes.data.CharacterData;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class Util {

    private static final Logger LOG = LoggerFactory.getLogger(Util.class);

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

    public static String getJson(Object object) {
        ObjectMapper jsonObject = new ObjectMapper();
        try {
            return jsonObject.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOG.error("Error while parsing the object to json. Message: " + e.getMessage());
            return object.toString();
        }
    }
}
