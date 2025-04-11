package com.ozmenyavuz.utils;

import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

@UtilityClass // Sınıfı otomatik olarak final yapar.
//  Constructor’ı private yapar – yani bu sınıftan nesne oluşturulamaz.
// İçindeki tüm metotları otomatik olarak static yapar – yani PagerUtil.isNullOrEmpty(...)

public class PagerUtil {

    public boolean isNullOrEmpty(String value) {
        return value == null || value.trim().isEmpty();
        // trim() ile baştaki ve sondaki boşluklar silinir, sonra uzunluk kontrol edilir.

    }
    // Pageable nedir?
    //	Spring Data JPA’nın findAll(Pageable pageable) gibi metotlarında kullanılan,
    //	sayfa bilgilerini (numara, boyut, sıralama) taşıyan nesnedir.

    //	•	RestPageableRequest → Bu sınıf, dışarıdan gelen istekle birlikte sayfa numarası,
    //	sayfa boyutu ve sıralama bilgilerini taşıyan özel bir DTO’dur.

    public Pageable toPageable(RestPageableRequest request) {
        if (!isNullOrEmpty(request.getColumnName())) {
            Sort sortBy = request.isAsc()
                    // Sort.by(...) → Spring Data JPA’nın sıralama sınıfı.
                    ? Sort.by(Sort.Direction.ASC, request.getColumnName()) // true ise arttan sira
                    : Sort.by(Sort.Direction.DESC, request.getColumnName()); // false azalan sira
            return PageRequest.of(
                    request.getPageNumber(), // •	getPageNumber() → Hangi sayfa isteniyor? (0, 1, 2…)
                    request.getPageSize(), // •	getPageSize() → Kaç kayıt getirilecek?
                    sortBy); // •	sortBy → Hangi kolona göre sıralanacak?
        }
        return PageRequest.of( // 	•	Eğer sıralama kolonu belirtilmemişse,
                request.getPageNumber(), // sadece sayfa numarası
                request.getPageSize()); //   boyutuna göre Pageable doner
    }

    // response

    public <T> RestPageableEntity<T> toPageableResponse(Page<?> page, List<T> content) {

        RestPageableEntity<T> pageableEntity = new RestPageableEntity<T>();
        pageableEntity.setContent(content);
        pageableEntity.setPageSize(page.getPageable().getPageSize());
        pageableEntity.setPageNumber(page.getPageable().getPageNumber());
        pageableEntity.setTotalElements(page.getTotalElements());

        return pageableEntity;
    }
}

// ✅ SONUÇ – Ne Yaptık?
//
//Bu sınıf:
//	•	Her yerden erişilebilir statik metotlar içerir.
//	•	Kullanıcının gönderdiği sayfa, boyut ve sıralama bilgilerini işleyip Pageable nesnesine çevirir.
//	•	Bu Pageable, Spring Data JPA’nın findAll(Pageable) gibi metotlarında kullanılabilir.