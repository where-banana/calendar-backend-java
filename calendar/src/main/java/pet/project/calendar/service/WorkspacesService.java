package pet.project.calendar.service;

import pet.project.calendar.entity.Workspaces;

import java.util.List;

public interface WorkspacesService {
    Workspaces findWorkspacesById(Integer id);

    List<Workspaces> findWorkspacesByName(String name);

    List<Workspaces> findWorkspacesByUserId(Integer id);

    void deleteWorkspacesById(Integer id);

    void deleteWorkspacesByName(String name);

}
