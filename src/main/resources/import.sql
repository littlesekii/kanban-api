INSERT INTO boards (title) VALUES ('Board');
INSERT INTO fields (title, sort_order, board_id) VALUES ('To do', 1, 1);
INSERT INTO fields (title, sort_order, board_id) VALUES ('In progress', 2, 1);
INSERT INTO fields (title, sort_order, board_id) VALUES ('Done', 3, 1);
INSERT INTO cards (title, sort_order, field_id) VALUES ('Finish Kanban API', 1, 1);