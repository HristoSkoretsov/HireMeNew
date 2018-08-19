package org.ico.hireme.repositories;

import org.ico.hireme.domain.entities.Company;
import org.ico.hireme.domain.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository<Company, String> {

    <S extends Company> S saveAndFlush(S s);

}
