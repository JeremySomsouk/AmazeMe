package com.manomano.AmazeMe.repository;

import com.manomano.AmazeMe.repository.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationsRepository extends JpaRepository<Location, String> {
}
