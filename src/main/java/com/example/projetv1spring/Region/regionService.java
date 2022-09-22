package com.example.projetv1spring.Region;

import java.util.List;

public interface regionService {
    //boolean regionByname(String s);
    int countfindname(String s);
    int findIDByname(String s);
    region saveregion(region r);
    void deleteregion(region r);
    void deleteregionById(Integer id);
    region getregion(Integer id);
    List<region> getAllregions();
}
