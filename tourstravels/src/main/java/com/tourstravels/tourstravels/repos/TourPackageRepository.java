package com.tourstravels.tourstravels.repos;

import com.tourstravels.tourstravels.models.TourPackage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TourPackageRepository extends JpaRepository<TourPackage,Long> {
    TourPackage findByPkgName(String pkgName);
}
