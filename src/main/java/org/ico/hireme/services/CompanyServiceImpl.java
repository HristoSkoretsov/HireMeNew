package org.ico.hireme.services;

import org.ico.hireme.domain.entities.Company;
import org.ico.hireme.models.binding.CompanyBindingModel;
import org.ico.hireme.models.service.CompanyServiceModel;
import org.ico.hireme.repositories.CompanyRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CompanyServiceImpl implements CompanyService{

    private final ModelMapper modelMapper;
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl(ModelMapper modelMapper, CompanyRepository companyRepository) {
        this.modelMapper = modelMapper;
        this.companyRepository = companyRepository;
    }

    @Override
    public boolean createUser(CompanyBindingModel companyBindingModel) {
        Company companyEntity = this.modelMapper.map(companyBindingModel, Company.class);
        return this.companyRepository.saveAndFlush(companyEntity)!=null;
    }

    @Override
    public Set<CompanyServiceModel> getAll() {
        return this.companyRepository
                .findAll()
                .stream()
                .map(x -> this.modelMapper.map(x, CompanyServiceModel.class))
                .collect(Collectors.toUnmodifiableSet());
    }

    @Override
    public Optional<Company> findById(String id) {
        return this.companyRepository.findById(id);
    }

    @Override
    public void deleteCompany(Company company) {
        this.companyRepository.delete(company);
    }
}
