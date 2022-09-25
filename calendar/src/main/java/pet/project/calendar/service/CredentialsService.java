package pet.project.calendar.service;

import pet.project.calendar.entity.Credentials;

import java.util.List;

public interface CredentialsService {

    Credentials findCredentialsById(Integer id);

    Credentials findCredentialsByEmail(String email);

    Credentials findCredentialsByUserId(Integer id);

    List<Credentials> findAll();

    void deleteCredentialsById(Integer id);
}
