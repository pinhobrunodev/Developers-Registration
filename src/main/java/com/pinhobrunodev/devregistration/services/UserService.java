package com.pinhobrunodev.devregistration.services;

import com.pinhobrunodev.devregistration.dto.user.UserDTO;
import com.pinhobrunodev.devregistration.entities.Address;
import com.pinhobrunodev.devregistration.entities.User;
import com.pinhobrunodev.devregistration.github.GitHubUserInfoDTO;
import com.pinhobrunodev.devregistration.github.GitHubWebService;
import com.pinhobrunodev.devregistration.repositories.AddressRepository;
import com.pinhobrunodev.devregistration.repositories.UserRepository;
import com.pinhobrunodev.devregistration.viaCEP.AddressViaCEPDTO;
import com.pinhobrunodev.devregistration.viaCEP.viaCEPWebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private viaCEPWebService viaCEPWebService;
    @Autowired
    private GitHubWebService gitHubWebService;


    @Transactional
    public UserDTO save(UserDTO dto) throws Exception {
        User aux = new User();
        return new UserDTO(repository.save(copyDtoToEntity(aux, dto)),aux.getAddresses());
    }


    // Auxiliary methods


    private User copyDtoToEntity(User entity, UserDTO dto) throws Exception {

        entity.setGithub_username(dto.getGithub_username());
        entity.setCep(dto.getCep());
        entity.setEmail(dto.getEmail());

        AddressViaCEPDTO addressViaCEPDTO = viaCEPWebService.viaCEPWebService(entity.getCep());
        dto.getAddresses().add(addressViaCEPDTO);

        GitHubUserInfoDTO gitHubUserInfoDTO = gitHubWebService.gitHubWebService(entity.getGithub_username());
        entity.setName(gitHubUserInfoDTO.getName());
        entity.setBlog(gitHubUserInfoDTO.getBlog());
        entity.setBio(gitHubUserInfoDTO.getBio());
        entity.setCompany(gitHubUserInfoDTO.getCompany());

        for (AddressViaCEPDTO addressDTO : dto.getAddresses()) {
            Address addressEntity = new Address();
            addressEntity.setLogradouro(addressDTO.getLogradouro());
            addressEntity.setBairro(addressDTO.getBairro());
            addressEntity.setComplemento(addressDTO.getComplemento());
            addressEntity.setLocalidade(addressDTO.getLocalidade());
            addressEntity.setUf(addressDTO.getUf());
            entity.getAddresses().add(addressEntity);
            addressRepository.save(addressEntity);
        }
        return entity;
    }
}
