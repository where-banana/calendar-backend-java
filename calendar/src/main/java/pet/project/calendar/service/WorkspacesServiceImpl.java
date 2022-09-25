package pet.project.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.calendar.entity.Workspaces;
import pet.project.calendar.exception.WorkspacesNotFoundException;
import pet.project.calendar.repository.WorkspacesRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WorkspacesServiceImpl implements WorkspacesService{

    @Autowired
    private WorkspacesRepository workspacesRepository;

    @Override
    public Workspaces findWorkspacesById(Integer id) {
        Optional<Workspaces> ws = workspacesRepository.findWorkspacesById(id);
        if (ws.isPresent()){
            return ws.get();
        }else {
            throw new WorkspacesNotFoundException("Workspace with id = " + id + " not found.");
        }
    }

    @Override
    public List<Workspaces> findWorkspacesByName(String name) {
        return (List<Workspaces>) workspacesRepository.findWorkspacesByName(name);
    }

    @Override
    public List<Workspaces> findWorkspacesByUserId(Integer id) {
        return (List<Workspaces>) workspacesRepository.findWorkspacesByUserId(id);
    }

    @Override
    public void deleteWorkspacesById(Integer id) {
        workspacesRepository.deleteWorkspacesById(id);
    }

    @Override
    public void deleteWorkspacesByName(String name) {
        workspacesRepository.deleteWorkspacesByName(name);
    }
}
