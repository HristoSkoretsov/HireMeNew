package org.ico.hireme.services;


import org.ico.hireme.domain.entities.Company;
import org.ico.hireme.models.binding.CompanyBindingModel;
import org.ico.hireme.models.service.CompanyServiceModel;

import java.util.Optional;
import java.util.Set;

public interface CompanyService {

    boolean createUser(CompanyBindingModel user);

    Set<CompanyServiceModel> getAll();

    Optional<Company> findById(String id);

    void deleteCompany(Company company);

}
