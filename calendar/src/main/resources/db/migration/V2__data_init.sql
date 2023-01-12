INSERT INTO workspaces(name) VALUES ('Матмодели');

INSERT INTO events(title, workspace_id) VALUES ('Лабораторная номер 1', 1);
INSERT INTO events(title, workspace_id) VALUES ('Лабораторная номер 2', 1);

INSERT INTO notes(description, event_id) VALUES ('Получение решения', 1);
INSERT INTO notes(description, event_id) VALUES ('Вывод разностной схемы', 2);
INSERT INTO notes(description, event_id) VALUES ('Получение решения', 2);

-----------------------------------------------------------------------------------
INSERT INTO workspaces(name) VALUES ('Базы данных');

INSERT INTO events(title, workspace_id) VALUES ('Этап 1', 2);
INSERT INTO events(title, workspace_id) VALUES ('Этап 2', 2);
INSERT INTO events(title, workspace_id) VALUES ('Этап 3', 2);
INSERT INTO events(title, workspace_id) VALUES ('Этап 4', 2);
INSERT INTO events(title, workspace_id) VALUES ('Этап 5', 2);

INSERT INTO notes(description, event_id) VALUES ('Придумать архитектуру', 3);
INSERT INTO notes(description, event_id) VALUES ('Придумать функционал', 3);
INSERT INTO notes(description, event_id) VALUES ('Написать отчёт', 3);

INSERT INTO notes(description, event_id) VALUES ('Придумать запросы', 4);
INSERT INTO notes(description, event_id) VALUES ('Написать отчёт', 4);

INSERT INTO notes(description, event_id) VALUES ('Реализовать простые запросы', 5);
INSERT INTO notes(description, event_id) VALUES ('Реализовать сложные запросы', 5);
INSERT INTO notes(description, event_id) VALUES ('Реализовать представления', 5);
INSERT INTO notes(description, event_id) VALUES ('Реализовать хранимые процедуры', 5);
INSERT INTO notes(description, event_id) VALUES ('Реализовать триггеры', 5);

INSERT INTO notes(description, event_id) VALUES ('Написать приложение', 6);


INSERT INTO notes(description, event_id) VALUES ('Написать полный отчёт', 7);


