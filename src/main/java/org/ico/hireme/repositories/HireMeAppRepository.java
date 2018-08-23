package org.ico.hireme.repositories;

import org.ico.hireme.domain.entities.HireMeApp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HireMeAppRepository extends JpaRepository<HireMeApp, String> {
}
