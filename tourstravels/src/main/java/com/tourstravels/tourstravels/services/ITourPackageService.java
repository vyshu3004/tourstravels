package com.tourstravels.tourstravels.services;

import com.tourstravels.tourstravels.models.TourPackage;

import java.util.List;

public interface ITourPackageService {
    List<TourPackage> getAll();
    TourPackage getById(Long id);
    TourPackage savePackage(TourPackage tourPackage);
    void deleteById(Long id);

    TourPackage getByPackageName(String pkgName);
}
