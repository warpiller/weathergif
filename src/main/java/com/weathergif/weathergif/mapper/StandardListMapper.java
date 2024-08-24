package com.weathergif.weathergif.mapper;

import java.util.List;

public interface StandardListMapper<From,To> {
    List<To> map(List<From> from);
}
