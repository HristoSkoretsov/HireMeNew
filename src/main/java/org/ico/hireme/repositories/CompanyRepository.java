package org.ico.hireme.repositories;

import org.ico.hireme.domain.entities.Company;
import org.ico.hireme.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    <S extends Company> S saveAndFlush(S s);

    Optional<Company> findById(String id);


}
