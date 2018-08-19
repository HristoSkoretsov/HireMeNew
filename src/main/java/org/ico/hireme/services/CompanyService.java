package org.ico.hireme.services;


import org.ico.hireme.models.binding.CompanyBindingModel;
import org.ico.hireme.models.service.CompanyServiceModel;

import java.util.Set;

public interface CompanyService {
    boolean createUser(CompanyBindingModel user);
    Set<CompanyServiceModel> getAll();
}
