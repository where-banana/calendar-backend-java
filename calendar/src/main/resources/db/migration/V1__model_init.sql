CREATE TABLE workspaces
(
    id      SERIAL PRIMARY KEY NOT NULL,
    name    VARCHAR(255) NOT NULL
);

CREATE TABLE events
(
    id           SERIAL PRIMARY KEY NOT NULL,
    title        VARCHAR(255) NOT NULL,
    workspace_id INTEGER NOT NULL,
    CONSTRAINT fk_events_workspaces FOREIGN KEY (workspace_id) REFERENCES workspaces(id)
);

CREATE TABLE notes
(
    id          SERIAL PRIMARY KEY NOT NULL,
    description VARCHAR(255) NOT NULL,
    checked     BOOLEAN DEFAULT(FALSE),
    event_id    INTEGER NOT NULL,
    CONSTRAINT fk_notes_events FOREIGN KEY (event_id) REFERENCES events(id)
);