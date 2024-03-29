package pet.project.calendar.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pet.project.calendar.dto.WorkspaceDto;
import pet.project.calendar.entity.Workspace;
import pet.project.calendar.exception.WorkspaceNotFoundException;
import pet.project.calendar.repository.WorkspaceRepository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class WorkspaceServiceImpl implements WorkspaceService {

    @Autowired
    private WorkspaceRepository workspacesRepository;

    @Override
    public Workspace findWorkspaceById(Integer id) {
        Optional<Workspace> ws = workspacesRepository.findWorkspaceById(id);
        if (ws.isPresent()){
            return ws.get();
        }else {
            throw new WorkspaceNotFoundException("Workspace with id = " + id + " not found.");
        }
    }

    @Override
    public List<Workspace> findWorkspacesByName(String name) {
        return (List<Workspace>) workspacesRepository.findWorkspacesByName(name);
    }


    @Override
    public Workspace add(WorkspaceDto workspaceDto) {
        String name = workspaceDto.getName();
        Workspace workspace = new Workspace(name);
        workspacesRepository.save(workspace);
        return workspace;
    }

    @Override
    public void updateWorkspace(Integer id, String name) {
        workspacesRepository.updateWorkspace(id, name);
    }

    @Override
    public void deleteWorkspacesById(Integer id) {
        workspacesRepository.deleteWorkspacesById(id);
    }

    @Override
    public void deleteWorkspacesByName(String name) {
        workspacesRepository.deleteWorkspacesByName(name);
    }

    @Override
    public List<Workspace> findAll() {
        return (List<Workspace>) workspacesRepository.findAll();
    }
}
