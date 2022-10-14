package pet.project.calendar.service;

import pet.project.calendar.dto.WorkspaceDto;
import pet.project.calendar.entity.Workspace;

import java.util.List;

public interface WorkspaceService {
    Workspace findWorkspaceById(Integer id);

    List<Workspace> findWorkspacesByName(String name);

    List<Workspace> findWorkspacesByUserId(Integer id);

    Workspace add(WorkspaceDto workspaceDto);

    void updateWorkspace(Integer id, String name);

    void deleteWorkspacesById(Integer id);

    void deleteWorkspacesByName(String name);

}
