package com.ozmenyavuz.utils;


import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class RestPageableEntity<T> {

    private List<T> content; // donen - response asil veri listesi
    private int pageNumber; // ilgili sayfa numarasi temsil eder
    private int pageSize; // Bir sayfada kaç adet kayıt olduğunu belirtir.
    private Long totalElements; // Toplam kaç kayıt olduğunu gösterir (tüm sayfalardaki toplam eleman sayısı).
}
