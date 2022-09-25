package pet.project.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.calendar.entity.Credentials;
import pet.project.calendar.exception.CredentialsNotFoundException;
import pet.project.calendar.repository.CredentialsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CredentialsServiceImpl implements CredentialsService{

    @Autowired
    private CredentialsRepository credentialsRepository;

    @Override
    public Credentials findCredentialsById(Integer id) {
        Optional<Credentials> op = credentialsRepository.findCredentialsById(id);
        if (op.isPresent()){
            return op.get();
        }else {
            throw new CredentialsNotFoundException("Credential with id = " + id + " not found.");
        }
    }

    @Override
    public Credentials findCredentialsByEmail(String email) {
        Optional<Credentials> op = credentialsRepository.findCredentialsByEmail(email);
        if (op.isPresent()){
            return op.get();
        }else{
            throw new CredentialsNotFoundException("Credential with email = " + email + " not found.");
        }
    }

    @Override
    public Credentials findCredentialsByUserId(Integer id) {
        Optional<Credentials> op = credentialsRepository.findCredentialsByUserId(id);
        if (op.isPresent()){
            return op.get();
        }else{
            throw new CredentialsNotFoundException("Credential with userId = " + id + " not found.");
        }
    }

    @Override
    public List<Credentials> findAll() {
        return (List<Credentials>) credentialsRepository.findAll();
    }

    @Override
    public void deleteCredentialsById(Integer id) {
        credentialsRepository.deleteCredentialsById(id);
    }
}
