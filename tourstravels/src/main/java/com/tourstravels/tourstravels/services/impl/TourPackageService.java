package com.tourstravels.tourstravels.services.impl;

import com.tourstravels.tourstravels.models.TourPackage;
import com.tourstravels.tourstravels.repos.TourPackageRepository;
import com.tourstravels.tourstravels.services.ITourPackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TourPackageService implements ITourPackageService {
    @Autowired
    private TourPackageRepository tourPackageRepository;

    @Override
    public List<TourPackage> getAll() {
        return tourPackageRepository.findAll() ;
    }

    @Override
    public TourPackage getById(Long id) {
        return tourPackageRepository.findById(id).get();
    }

    @Override
    public TourPackage savePackage(TourPackage tourPackage) {
        return tourPackageRepository.save(tourPackage);
    }

    @Override
    public void deleteById(Long id) {
        tourPackageRepository.deleteById(id);
    }
    @Override
    public TourPackage getByPackageName(String pkgName){
        return tourPackageRepository.findByPkgName(pkgName);
    }
}
